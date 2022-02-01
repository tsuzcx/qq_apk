package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class g
  implements com.tencent.mm.plugin.fingerprint.d.d
{
  int djq;
  private String djt;
  private String iTR;
  ao skg;
  com.tencent.mm.plugin.fingerprint.d.b skk;
  private com.tencent.mm.plugin.fingerprint.d.b skl;
  WalletBaseUI skm;
  private String skn;
  
  public g()
  {
    AppMethodBeat.i(64332);
    this.skk = null;
    this.skl = null;
    this.skm = null;
    this.skn = null;
    this.djt = null;
    this.iTR = null;
    this.skg = new ao(new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(64327);
        if (1 == paramAnonymousMessage.what)
        {
          String str = paramAnonymousMessage.getData().getString("rsaKey");
          if (TextUtils.isEmpty(str))
          {
            ac.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + paramAnonymousMessage.what + " rsaKey is null");
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(64326);
                g.this.skk.aZ(-1, g.this.skm.getString(2131759409));
                AppMethodBeat.o(64326);
              }
            });
          }
          paramAnonymousMessage = new e(str);
          g.this.skm.doSceneProgress(paramAnonymousMessage, false);
          AppMethodBeat.o(64327);
          return true;
        }
        AppMethodBeat.o(64327);
        return false;
      }
    });
    AppMethodBeat.o(64332);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.d.b paramb)
  {
    AppMethodBeat.i(64336);
    ((i)com.tencent.mm.kernel.g.ab(i.class)).a(paramContext, new com.tencent.mm.plugin.fingerprint.b.a.f("", (byte)0), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64328);
        ac.i("MicroMsg.HwFingerprintOpenDelegate", "result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        String str = "";
        switch (paramAnonymousc.errCode)
        {
        }
        for (;;)
        {
          paramb.aZ(-2, str);
          AppMethodBeat.o(64328);
          return;
          ac.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
          g.this.djq = paramAnonymousc.djq;
          paramb.aZ(0, "");
          AppMethodBeat.o(64328);
          return;
          ac.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.aZ(-1, "");
          AppMethodBeat.o(64328);
          return;
          ac.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
          continue;
          str = ai.getContext().getString(2131764097);
          do
          {
            a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            break;
            ac.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            str = ai.getContext().getString(2131764095);
          } while (paramAnonymousc.errCode != 10308);
          str = ai.getContext().getString(2131764096);
          a.d(6, -1000223, -1, "too many trial");
        }
      }
    });
    AppMethodBeat.o(64336);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64333);
    this.skm = ((WalletBaseUI)paramContext);
    this.skk = paramb;
    this.iTR = paramString;
    paramContext = FingerPrintAuth.getRsaKey(d.eZ(ai.getContext()), d.getUserId(), q.XX());
    a.dTm();
    if (TextUtils.isEmpty(paramContext))
    {
      ac.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new o(new a((byte)0)).bei();
      AppMethodBeat.o(64333);
      return;
    }
    ac.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new e(paramContext);
    this.skm.doSceneProgress(paramContext, false);
    AppMethodBeat.o(64333);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64335);
    this.skl = paramb;
    if (TextUtils.isEmpty(this.iTR))
    {
      ac.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      paramb.aZ(-1, this.skm.getString(2131759409));
      AppMethodBeat.o(64335);
      return;
    }
    String str1 = d.getUserId();
    String str2 = q.XX();
    String str3 = y.fAm();
    paramb = "";
    if (d.cHi())
    {
      str1 = FingerPrintAuth.genOpenFPEncrypt(d.eZ(ai.getContext()), str1, str2, String.valueOf(this.djq), str3, "", this.skn, this.djt, Build.MODEL);
      paramb = FingerPrintAuth.genOpenFPSign(d.eZ(ai.getContext()), d.getUserId(), q.XX(), str1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.skn)) {
        ac.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        paramb = new com.tencent.mm.plugin.fingerprint.c.f(str1, paramb, this.iTR, paramInt);
        this.skm.doSceneProgress(paramb, false);
        AppMethodBeat.o(64335);
        return;
        if (TextUtils.isEmpty(paramb)) {
          ac.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
      }
      str1 = "";
    }
  }
  
  public final void clear() {}
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(64334);
    if ((paramn instanceof e))
    {
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (e)paramn;
        this.skn = paramString.skn;
        this.djt = paramString.djt;
        localObject = this.skk;
        paramn = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fingerprint.d.b)localObject).aZ(paramInt1, paramn);
        AppMethodBeat.o(64334);
        return true;
        ac.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.plugin.fingerprint.d.b localb = this.skk;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = localb;
        paramn = paramString;
        if (bs.isNullOrNil(paramString))
        {
          paramn = this.skm.getString(2131759409);
          paramInt1 = paramInt2;
          localObject = localb;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.dTn();
        a.d(0, 0, 0, "OK");
        this.skl.aZ(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(64334);
        return true;
        this.skl.aZ(-2, "");
      }
    }
    AppMethodBeat.o(64334);
    return false;
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void LV(final String paramString)
    {
      AppMethodBeat.i(64331);
      if (TextUtils.isEmpty(paramString))
      {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64329);
            g.this.skk.aZ(-1, g.this.skm.getString(2131759409));
            AppMethodBeat.o(64329);
          }
        });
        ac.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
        AppMethodBeat.o(64331);
        return;
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64330);
          ac.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
          Message localMessage = g.this.skg.obtainMessage();
          localMessage.what = 1;
          Bundle localBundle = new Bundle();
          localBundle.putString("rsaKey", paramString);
          localMessage.setData(localBundle);
          localMessage.sendToTarget();
          AppMethodBeat.o(64330);
        }
      });
      AppMethodBeat.o(64331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.g
 * JD-Core Version:    0.7.0.1
 */