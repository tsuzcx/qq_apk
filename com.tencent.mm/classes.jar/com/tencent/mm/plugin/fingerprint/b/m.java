package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.b.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class m
  implements d
{
  private String ByB;
  String ByC;
  String ByD;
  private com.tencent.mm.plugin.fingerprint.d.b Byj = null;
  private com.tencent.mm.plugin.fingerprint.d.b Byk = null;
  WeakReference<WalletBaseUI> Byw = null;
  private com.tencent.mm.plugin.soter.b Byz;
  int fHa;
  private String nfX = "";
  
  private void bl(int paramInt, String paramString)
  {
    AppMethodBeat.i(64384);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.Byk.bh(paramInt, paramString);
    this.Byk = null;
    AppMethodBeat.o(64384);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.d.b paramb)
  {
    AppMethodBeat.i(64381);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
    if (Util.isNullOrNil(this.ByB))
    {
      Log.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
      AppMethodBeat.o(64381);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(1104, 41);
    ((i)com.tencent.mm.kernel.h.ae(i.class)).a(paramContext, new f(this.ByB), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64375);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        Object localObject = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
        }
        for (;;)
        {
          paramb.bh(-2, paramAnonymousc);
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
          m.this.fHa = paramAnonymousc.fHa;
          m.this.ByC = paramAnonymousc.ByC;
          m.this.ByD = paramAnonymousc.ByD;
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 40);
          paramb.bh(0, "");
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bh(-1, "");
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
          AppMethodBeat.o(64375);
          return;
          localObject = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
          com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          continue;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          String str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          if (paramAnonymousc.errCode == 10308)
          {
            paramAnonymousc = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial_special);
            com.tencent.mm.plugin.soter.d.a.c(6, -1000223, -1, "too many trial");
            paramb.bh(-3, paramAnonymousc);
            AppMethodBeat.o(64375);
            return;
          }
          localObject = str;
          if (Build.VERSION.SDK_INT == 27)
          {
            localObject = str;
            if ("Xiaomi".equals(Build.MANUFACTURER)) {
              localObject = MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg);
            }
          }
          com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          continue;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.soter.d.a.ahQ(2);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
        }
      }
    });
    AppMethodBeat.o(64381);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64379);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.Byz = new com.tencent.mm.plugin.soter.b();
    this.Byw = new WeakReference((WalletBaseUI)paramContext);
    this.Byj = paramb;
    this.nfX = paramString;
    ((WalletBaseUI)this.Byw.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.Byw.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.d.a.gae();
    ((i)com.tencent.mm.kernel.h.ae(i.class)).q(new Object[0]);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    com.tencent.mm.plugin.report.service.h.IzE.el(1104, 35);
    this.Byz.a(new b.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64376);
        if ((m.this.Byw != null) && (m.this.Byw.get() != null))
        {
          ((WalletBaseUI)m.this.Byw.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(1), false);
          AppMethodBeat.o(64376);
          return;
        }
        m.this.bk(-1, "base ui is null");
        AppMethodBeat.o(64376);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64377);
        if (paramAnonymousc.errCode == 1006)
        {
          Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.c(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 34);
          m.this.bk(-1, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg));
          AppMethodBeat.o(64377);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.c(4, -1000223, -1, "gen auth key failed");
            if ((!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              m.this.bk(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg2));
              AppMethodBeat.o(64377);
              return;
            }
            if ((com.tencent.soter.core.a.ioE() == 1) && (!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              m.this.bk(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg3));
              AppMethodBeat.o(64377);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.c(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.c(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.c(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.c(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.nfX, 1));
    AppMethodBeat.o(64379);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64385);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.Byk = paramb;
    if (!Util.isNullOrNil(this.ByC))
    {
      if ((this.Byw != null) && (this.Byw.get() != null))
      {
        ((WalletBaseUI)this.Byw.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(this.ByC, this.ByD, this.nfX, 1));
        AppMethodBeat.o(64385);
      }
    }
    else
    {
      Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.c(9, -1000223, -1, "signature is null");
      bk(-1, MMApplicationContext.getContext().getString(a.i.fingerprint_open_fail));
    }
    AppMethodBeat.o(64385);
  }
  
  final void bk(int paramInt, String paramString)
  {
    AppMethodBeat.i(64382);
    if (this.Byj != null) {
      this.Byj.bh(paramInt, paramString);
    }
    AppMethodBeat.o(64382);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64380);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.Byw != null) && (this.Byw.get() != null))
    {
      ((WalletBaseUI)this.Byw.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.Byw.get()).removeSceneEndListener(1638);
    }
    this.Byj = null;
    p.ByH.reset();
    if ((this.Byw != null) && (this.Byw.get() != null)) {
      this.Byw.clear();
    }
    AppMethodBeat.o(64380);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64383);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.fingerprint_open_fail);
    }
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.a)paramq;
        if (Util.isNullOrNil(paramString.ByB))
        {
          bk(-1, str);
          AppMethodBeat.o(64383);
          return true;
        }
        this.ByB = paramString.ByB;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64378);
            m.this.bk(0, "");
            AppMethodBeat.o(64378);
          }
        });
      }
    }
    else
    {
      if (!(paramq instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
        break label237;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label209;
      }
      Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.gaf();
      com.tencent.mm.plugin.soter.d.a.c(0, 0, 0, "OK");
      bl(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64383);
      return true;
      Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      bk(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.c(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64383);
      return true;
      label209:
      Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.c(8, paramInt1, paramInt2, "open fp pay failed");
      bl(-1, str);
    }
    label237:
    AppMethodBeat.o(64383);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.m
 * JD-Core Version:    0.7.0.1
 */