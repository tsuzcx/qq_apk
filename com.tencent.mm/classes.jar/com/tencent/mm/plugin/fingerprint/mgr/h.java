package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.plugin.fingerprint.mgr.a.f;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class h
  implements d
{
  private com.tencent.mm.plugin.fingerprint.c.b HfL = null;
  private com.tencent.mm.plugin.fingerprint.c.b HfM = null;
  WeakReference<WalletBaseUI> HfY = null;
  private com.tencent.mm.plugin.soter.b Hgb;
  private String Hgd;
  String Hge;
  String Hgf;
  int hMx;
  private String qdg = "";
  
  private void bP(int paramInt, String paramString)
  {
    AppMethodBeat.i(64384);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.HfM.bL(paramInt, paramString);
    this.HfM = null;
    AppMethodBeat.o(64384);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.c.b paramb)
  {
    AppMethodBeat.i(64381);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
    if (Util.isNullOrNil(this.Hgd))
    {
      Log.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
      AppMethodBeat.o(64381);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 41);
    ((i)com.tencent.mm.kernel.h.ax(i.class)).a(paramContext, new f(this.Hgd), new com.tencent.mm.plugin.fingerprint.mgr.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.mgr.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64375);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        Object localObject = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.mgr.a.c)localObject;
        }
        for (;;)
        {
          paramb.bL(-2, paramAnonymousc);
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
          h.this.hMx = paramAnonymousc.hMx;
          h.this.Hge = paramAnonymousc.Hge;
          h.this.Hgf = paramAnonymousc.Hgf;
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 40);
          paramb.bL(0, "");
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bL(-1, "");
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
          AppMethodBeat.o(64375);
          return;
          localObject = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
          com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.mgr.a.c)localObject;
          continue;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          String str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          if (paramAnonymousc.errCode == 10308)
          {
            paramAnonymousc = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial_special);
            com.tencent.mm.plugin.soter.model.a.e(6, -1000223, -1, "too many trial");
            paramb.bL(-3, paramAnonymousc);
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
          com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.mgr.a.c)localObject;
          continue;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          localObject = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
          com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.soter.model.a.amR(2);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.mgr.a.c)localObject;
        }
      }
    });
    AppMethodBeat.o(64381);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.c.b paramb, String paramString)
  {
    AppMethodBeat.i(64379);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.Hgb = new com.tencent.mm.plugin.soter.b();
    this.HfY = new WeakReference((WalletBaseUI)paramContext);
    this.HfL = paramb;
    this.qdg = paramString;
    ((WalletBaseUI)this.HfY.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.HfY.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.model.a.htv();
    ((i)com.tencent.mm.kernel.h.ax(i.class)).s(new Object[0]);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 35);
    this.Hgb.a(new b.d()new com.tencent.mm.plugin.fingerprint.b.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64376);
        if ((h.this.HfY != null) && (h.this.HfY.get() != null))
        {
          ((WalletBaseUI)h.this.HfY.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.b.a(1), false);
          AppMethodBeat.o(64376);
          return;
        }
        h.this.bO(-1, "base ui is null");
        AppMethodBeat.o(64376);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64377);
        if (paramAnonymousc.errCode == 1006)
        {
          Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.model.a.e(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 34);
          h.this.bO(-1, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg));
          AppMethodBeat.o(64377);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.model.a.e(4, -1000223, -1, "gen auth key failed");
            if ((!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              h.this.bO(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg2));
              AppMethodBeat.o(64377);
              return;
            }
            if ((com.tencent.soter.core.a.jXR() == 1) && (!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              h.this.bO(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg3));
              AppMethodBeat.o(64377);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.model.a.e(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.model.a.e(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.model.a.e(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.model.a.e(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.b.c(this.qdg, 1));
    AppMethodBeat.o(64379);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(64385);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.HfM = paramb;
    if (!Util.isNullOrNil(this.Hge))
    {
      if ((this.HfY != null) && (this.HfY.get() != null))
      {
        ((WalletBaseUI)this.HfY.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.b.b(this.Hge, this.Hgf, this.qdg, 1));
        AppMethodBeat.o(64385);
      }
    }
    else
    {
      Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.model.a.e(9, -1000223, -1, "signature is null");
      bO(-1, MMApplicationContext.getContext().getString(a.i.fingerprint_open_fail));
    }
    AppMethodBeat.o(64385);
  }
  
  final void bO(int paramInt, String paramString)
  {
    AppMethodBeat.i(64382);
    if (this.HfL != null) {
      this.HfL.bL(paramInt, paramString);
    }
    AppMethodBeat.o(64382);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64380);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.HfY != null) && (this.HfY.get() != null))
    {
      ((WalletBaseUI)this.HfY.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.HfY.get()).removeSceneEndListener(1638);
    }
    this.HfL = null;
    j.Hgj.reset();
    if ((this.HfY != null) && (this.HfY.get() != null)) {
      this.HfY.clear();
    }
    AppMethodBeat.o(64380);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64383);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.fingerprint_open_fail);
    }
    if ((paramp instanceof com.tencent.mm.plugin.fingerprint.b.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        paramString = (com.tencent.mm.plugin.fingerprint.b.a)paramp;
        if (Util.isNullOrNil(paramString.Hgd))
        {
          bO(-1, str);
          AppMethodBeat.o(64383);
          return true;
        }
        this.Hgd = paramString.Hgd;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64378);
            h.this.bO(0, "");
            AppMethodBeat.o(64378);
          }
        });
      }
    }
    else
    {
      if (!(paramp instanceof com.tencent.mm.plugin.fingerprint.b.b)) {
        break label237;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label209;
      }
      Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.model.a.htw();
      com.tencent.mm.plugin.soter.model.a.e(0, 0, 0, "OK");
      bP(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64383);
      return true;
      Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      bO(paramInt2, str);
      com.tencent.mm.plugin.soter.model.a.e(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64383);
      return true;
      label209:
      Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.model.a.e(8, paramInt1, paramInt2, "open fp pay failed");
      bP(-1, str);
    }
    label237:
    AppMethodBeat.o(64383);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.h
 * JD-Core Version:    0.7.0.1
 */