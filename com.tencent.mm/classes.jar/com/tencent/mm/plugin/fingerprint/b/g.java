package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class g
  implements com.tencent.mm.plugin.fingerprint.d.d
{
  int dlI;
  private String dlL;
  private String itM;
  ap rbM;
  com.tencent.mm.plugin.fingerprint.d.b rbQ;
  private com.tencent.mm.plugin.fingerprint.d.b rbR;
  WalletBaseUI rbS;
  private String rbT;
  
  public g()
  {
    AppMethodBeat.i(64332);
    this.rbQ = null;
    this.rbR = null;
    this.rbS = null;
    this.rbT = null;
    this.dlL = null;
    this.itM = null;
    this.rbM = new ap(new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(64327);
        if (1 == paramAnonymousMessage.what)
        {
          String str = paramAnonymousMessage.getData().getString("rsaKey");
          if (TextUtils.isEmpty(str))
          {
            ad.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + paramAnonymousMessage.what + " rsaKey is null");
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(64326);
                g.this.rbQ.aU(-1, g.this.rbS.getString(2131759409));
                AppMethodBeat.o(64326);
              }
            });
          }
          paramAnonymousMessage = new e(str);
          g.this.rbS.doSceneProgress(paramAnonymousMessage, false);
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
        ad.i("MicroMsg.HwFingerprintOpenDelegate", "result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        String str = "";
        switch (paramAnonymousc.errCode)
        {
        }
        for (;;)
        {
          paramb.aU(-2, str);
          AppMethodBeat.o(64328);
          return;
          ad.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
          g.this.dlI = paramAnonymousc.dlI;
          paramb.aU(0, "");
          AppMethodBeat.o(64328);
          return;
          ad.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.aU(-1, "");
          AppMethodBeat.o(64328);
          return;
          ad.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
          continue;
          str = aj.getContext().getString(2131764097);
          do
          {
            a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            break;
            ad.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            str = aj.getContext().getString(2131764095);
          } while (paramAnonymousc.errCode != 10308);
          str = aj.getContext().getString(2131764096);
          a.d(6, -1000223, -1, "too many trial");
        }
      }
    });
    AppMethodBeat.o(64336);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64333);
    this.rbS = ((WalletBaseUI)paramContext);
    this.rbQ = paramb;
    this.itM = paramString;
    paramContext = FingerPrintAuth.getRsaKey(d.eM(aj.getContext()), d.getUserId(), q.Xa());
    a.dEN();
    if (TextUtils.isEmpty(paramContext))
    {
      ad.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new o(new a((byte)0)).aXl();
      AppMethodBeat.o(64333);
      return;
    }
    ad.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new e(paramContext);
    this.rbS.doSceneProgress(paramContext, false);
    AppMethodBeat.o(64333);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64335);
    this.rbR = paramb;
    if (TextUtils.isEmpty(this.itM))
    {
      ad.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      paramb.aU(-1, this.rbS.getString(2131759409));
      AppMethodBeat.o(64335);
      return;
    }
    String str1 = d.getUserId();
    String str2 = q.Xa();
    String str3 = y.fjW();
    paramb = "";
    if (d.ctW())
    {
      str1 = FingerPrintAuth.genOpenFPEncrypt(d.eM(aj.getContext()), str1, str2, String.valueOf(this.dlI), str3, "", this.rbT, this.dlL, Build.MODEL);
      paramb = FingerPrintAuth.genOpenFPSign(d.eM(aj.getContext()), d.getUserId(), q.Xa(), str1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.rbT)) {
        ad.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        paramb = new com.tencent.mm.plugin.fingerprint.c.f(str1, paramb, this.itM, paramInt);
        this.rbS.doSceneProgress(paramb, false);
        AppMethodBeat.o(64335);
        return;
        if (TextUtils.isEmpty(paramb)) {
          ad.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
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
        ad.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (e)paramn;
        this.rbT = paramString.rbT;
        this.dlL = paramString.dlL;
        localObject = this.rbQ;
        paramn = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fingerprint.d.b)localObject).aU(paramInt1, paramn);
        AppMethodBeat.o(64334);
        return true;
        ad.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.plugin.fingerprint.d.b localb = this.rbQ;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = localb;
        paramn = paramString;
        if (bt.isNullOrNil(paramString))
        {
          paramn = this.rbS.getString(2131759409);
          paramInt1 = paramInt2;
          localObject = localb;
        }
      }
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.dEO();
        a.d(0, 0, 0, "OK");
        this.rbR.aU(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(64334);
        return true;
        this.rbR.aU(-2, "");
      }
    }
    AppMethodBeat.o(64334);
    return false;
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void HQ(final String paramString)
    {
      AppMethodBeat.i(64331);
      if (TextUtils.isEmpty(paramString))
      {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64329);
            g.this.rbQ.aU(-1, g.this.rbS.getString(2131759409));
            AppMethodBeat.o(64329);
          }
        });
        ad.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
        AppMethodBeat.o(64331);
        return;
      }
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64330);
          ad.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
          Message localMessage = g.this.rbM.obtainMessage();
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