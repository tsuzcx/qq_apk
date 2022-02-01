package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.soter.model.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class d
  implements com.tencent.mm.plugin.fingerprint.c.d
{
  MMHandler HfH;
  com.tencent.mm.plugin.fingerprint.c.b HfL;
  private com.tencent.mm.plugin.fingerprint.c.b HfM;
  WalletBaseUI HfN;
  private String HfO;
  private String hMA;
  int hMx;
  private String qdg;
  
  public d()
  {
    AppMethodBeat.i(64332);
    this.HfL = null;
    this.HfM = null;
    this.HfN = null;
    this.HfO = null;
    this.hMA = null;
    this.qdg = null;
    this.HfH = new MMHandler(new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(64327);
        if (1 == paramAnonymousMessage.what)
        {
          String str = paramAnonymousMessage.getData().getString("rsaKey");
          if (TextUtils.isEmpty(str))
          {
            Log.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + paramAnonymousMessage.what + " rsaKey is null");
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(64326);
                d.this.HfL.bL(-1, d.this.HfN.getString(a.i.fingerprint_open_fail));
                AppMethodBeat.o(64326);
              }
            });
          }
          paramAnonymousMessage = new e(str);
          d.this.HfN.doSceneProgress(paramAnonymousMessage, false);
          AppMethodBeat.o(64327);
          return true;
        }
        AppMethodBeat.o(64327);
        return false;
      }
    });
    AppMethodBeat.o(64332);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.c.b paramb)
  {
    AppMethodBeat.i(64336);
    ((com.tencent.mm.plugin.fingerprint.mgr.a.i)h.ax(com.tencent.mm.plugin.fingerprint.mgr.a.i.class)).a(paramContext, new com.tencent.mm.plugin.fingerprint.mgr.a.f("", (byte)0), new com.tencent.mm.plugin.fingerprint.mgr.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.mgr.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64328);
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        String str = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
        case 0: 
        case 2002: 
        case 2001: 
          for (;;)
          {
            paramb.bL(-2, str);
            AppMethodBeat.o(64328);
            return;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
            d.this.hMx = paramAnonymousc.hMx;
            paramb.bL(0, "");
            AppMethodBeat.o(64328);
            return;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
            paramb.bL(-1, "");
            AppMethodBeat.o(64328);
            return;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
          }
        case 2005: 
          str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
        }
        do
        {
          a.e(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          break;
          Log.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
        } while (paramAnonymousc.errCode != 10308);
        paramAnonymousc = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial_special);
        a.e(6, -1000223, -1, "too many trial");
        paramb.bL(-3, paramAnonymousc);
        AppMethodBeat.o(64328);
      }
    });
    AppMethodBeat.o(64336);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.c.b paramb, String paramString)
  {
    AppMethodBeat.i(64333);
    this.HfN = ((WalletBaseUI)paramContext);
    this.HfL = paramb;
    this.qdg = paramString;
    paramContext = FingerPrintAuth.getRsaKey(c.hA(MMApplicationContext.getContext()), c.getUserId(), q.aPg());
    a.htv();
    if (TextUtils.isEmpty(paramContext))
    {
      Log.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new i(new a((byte)0)).cpv();
      AppMethodBeat.o(64333);
      return;
    }
    Log.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new e(paramContext);
    this.HfN.doSceneProgress(paramContext, false);
    AppMethodBeat.o(64333);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(64335);
    this.HfM = paramb;
    if (TextUtils.isEmpty(this.qdg))
    {
      Log.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      paramb.bL(-1, this.HfN.getString(a.i.fingerprint_open_fail));
      AppMethodBeat.o(64335);
      return;
    }
    String str1 = c.getUserId();
    String str2 = q.aPg();
    String str3 = y.jON();
    paramb = "";
    if (c.ftz())
    {
      str1 = FingerPrintAuth.genOpenFPEncrypt(c.hA(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.hMx), str3, "", this.HfO, this.hMA, q.aPo());
      paramb = FingerPrintAuth.genOpenFPSign(c.hA(MMApplicationContext.getContext()), c.getUserId(), q.aPg(), str1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.HfO)) {
        Log.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        paramb = new com.tencent.mm.plugin.fingerprint.b.f(str1, paramb, this.qdg, paramInt);
        this.HfN.doSceneProgress(paramb, false);
        AppMethodBeat.o(64335);
        return;
        if (TextUtils.isEmpty(paramb)) {
          Log.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
      }
      str1 = "";
    }
  }
  
  public final void clear() {}
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(64334);
    if ((paramp instanceof e))
    {
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (e)paramp;
        this.HfO = paramString.HfO;
        this.hMA = paramString.hMA;
        localObject = this.HfL;
        paramp = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fingerprint.c.b)localObject).bL(paramInt1, paramp);
        AppMethodBeat.o(64334);
        return true;
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.plugin.fingerprint.c.b localb = this.HfL;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = localb;
        paramp = paramString;
        if (Util.isNullOrNil(paramString))
        {
          paramp = this.HfN.getString(a.i.fingerprint_open_fail);
          paramInt1 = paramInt2;
          localObject = localb;
        }
      }
    }
    if ((paramp instanceof com.tencent.mm.plugin.fingerprint.b.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.htw();
        a.e(0, 0, 0, "OK");
        this.HfM.bL(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(64334);
        return true;
        this.HfM.bL(-2, "");
      }
    }
    AppMethodBeat.o(64334);
    return false;
  }
  
  final class a
    implements i.a
  {
    private a() {}
    
    public final void aal(final String paramString)
    {
      AppMethodBeat.i(64331);
      if (TextUtils.isEmpty(paramString))
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64329);
            d.this.HfL.bL(-1, d.this.HfN.getString(a.i.fingerprint_open_fail));
            AppMethodBeat.o(64329);
          }
        });
        Log.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
        AppMethodBeat.o(64331);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64330);
          Log.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
          Message localMessage = d.this.HfH.obtainMessage();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.d
 * JD-Core Version:    0.7.0.1
 */