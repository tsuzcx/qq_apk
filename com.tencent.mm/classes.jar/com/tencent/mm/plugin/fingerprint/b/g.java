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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class g
  implements com.tencent.mm.plugin.fingerprint.d.d
{
  int dwi;
  private String dwl;
  private String jpT;
  aq trB;
  com.tencent.mm.plugin.fingerprint.d.b trF;
  private com.tencent.mm.plugin.fingerprint.d.b trG;
  WalletBaseUI trH;
  private String trI;
  
  public g()
  {
    AppMethodBeat.i(64332);
    this.trF = null;
    this.trG = null;
    this.trH = null;
    this.trI = null;
    this.dwl = null;
    this.jpT = null;
    this.trB = new aq(new aq.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(64327);
        if (1 == paramAnonymousMessage.what)
        {
          String str = paramAnonymousMessage.getData().getString("rsaKey");
          if (TextUtils.isEmpty(str))
          {
            ae.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + paramAnonymousMessage.what + " rsaKey is null");
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(64326);
                g.this.trF.bb(-1, g.this.trH.getString(2131759409));
                AppMethodBeat.o(64326);
              }
            });
          }
          paramAnonymousMessage = new e(str);
          g.this.trH.doSceneProgress(paramAnonymousMessage, false);
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
        ae.i("MicroMsg.HwFingerprintOpenDelegate", "result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        String str = "";
        switch (paramAnonymousc.errCode)
        {
        }
        for (;;)
        {
          paramb.bb(-2, str);
          AppMethodBeat.o(64328);
          return;
          ae.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
          g.this.dwi = paramAnonymousc.dwi;
          paramb.bb(0, "");
          AppMethodBeat.o(64328);
          return;
          ae.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bb(-1, "");
          AppMethodBeat.o(64328);
          return;
          ae.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
          continue;
          str = ak.getContext().getString(2131764097);
          do
          {
            a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            break;
            ae.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            str = ak.getContext().getString(2131764095);
          } while (paramAnonymousc.errCode != 10308);
          str = ak.getContext().getString(2131764096);
          a.d(6, -1000223, -1, "too many trial");
        }
      }
    });
    AppMethodBeat.o(64336);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64333);
    this.trH = ((WalletBaseUI)paramContext);
    this.trF = paramb;
    this.jpT = paramString;
    paramContext = FingerPrintAuth.getRsaKey(d.fg(ak.getContext()), d.getUserId(), q.aaH());
    a.eji();
    if (TextUtils.isEmpty(paramContext))
    {
      ae.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new o(new a((byte)0)).biv();
      AppMethodBeat.o(64333);
      return;
    }
    ae.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new e(paramContext);
    this.trH.doSceneProgress(paramContext, false);
    AppMethodBeat.o(64333);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64335);
    this.trG = paramb;
    if (TextUtils.isEmpty(this.jpT))
    {
      ae.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      paramb.bb(-1, this.trH.getString(2131759409));
      AppMethodBeat.o(64335);
      return;
    }
    String str1 = d.getUserId();
    String str2 = q.aaH();
    String str3 = y.fVS();
    paramb = "";
    if (d.cSc())
    {
      str1 = FingerPrintAuth.genOpenFPEncrypt(d.fg(ak.getContext()), str1, str2, String.valueOf(this.dwi), str3, "", this.trI, this.dwl, Build.MODEL);
      paramb = FingerPrintAuth.genOpenFPSign(d.fg(ak.getContext()), d.getUserId(), q.aaH(), str1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.trI)) {
        ae.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        paramb = new com.tencent.mm.plugin.fingerprint.c.f(str1, paramb, this.jpT, paramInt);
        this.trH.doSceneProgress(paramb, false);
        AppMethodBeat.o(64335);
        return;
        if (TextUtils.isEmpty(paramb)) {
          ae.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
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
        ae.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (e)paramn;
        this.trI = paramString.trI;
        this.dwl = paramString.dwl;
        localObject = this.trF;
        paramn = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fingerprint.d.b)localObject).bb(paramInt1, paramn);
        AppMethodBeat.o(64334);
        return true;
        ae.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.plugin.fingerprint.d.b localb = this.trF;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = localb;
        paramn = paramString;
        if (bu.isNullOrNil(paramString))
        {
          paramn = this.trH.getString(2131759409);
          paramInt1 = paramInt2;
          localObject = localb;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.ejj();
        a.d(0, 0, 0, "OK");
        this.trG.bb(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(64334);
        return true;
        this.trG.bb(-2, "");
      }
    }
    AppMethodBeat.o(64334);
    return false;
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void PZ(final String paramString)
    {
      AppMethodBeat.i(64331);
      if (TextUtils.isEmpty(paramString))
      {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64329);
            g.this.trF.bb(-1, g.this.trH.getString(2131759409));
            AppMethodBeat.o(64329);
          }
        });
        ae.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
        AppMethodBeat.o(64331);
        return;
      }
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64330);
          ae.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
          Message localMessage = g.this.trB.obtainMessage();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.g
 * JD-Core Version:    0.7.0.1
 */