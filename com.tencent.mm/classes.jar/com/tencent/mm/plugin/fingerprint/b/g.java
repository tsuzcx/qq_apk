package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class g
  implements com.tencent.mm.plugin.fingerprint.d.d
{
  MMHandler Byf;
  com.tencent.mm.plugin.fingerprint.d.b Byj;
  private com.tencent.mm.plugin.fingerprint.d.b Byk;
  WalletBaseUI Byl;
  private String Bym;
  int fHa;
  private String fHd;
  private String nfX;
  
  public g()
  {
    AppMethodBeat.i(64332);
    this.Byj = null;
    this.Byk = null;
    this.Byl = null;
    this.Bym = null;
    this.fHd = null;
    this.nfX = null;
    this.Byf = new MMHandler(new MMHandler.Callback()
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
                g.this.Byj.bh(-1, g.this.Byl.getString(a.i.fingerprint_open_fail));
                AppMethodBeat.o(64326);
              }
            });
          }
          paramAnonymousMessage = new e(str);
          g.this.Byl.doSceneProgress(paramAnonymousMessage, false);
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
    ((i)h.ae(i.class)).a(paramContext, new com.tencent.mm.plugin.fingerprint.b.a.f("", (byte)0), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(c paramAnonymousc)
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
            paramb.bh(-2, str);
            AppMethodBeat.o(64328);
            return;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
            g.this.fHa = paramAnonymousc.fHa;
            paramb.bh(0, "");
            AppMethodBeat.o(64328);
            return;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
            paramb.bh(-1, "");
            AppMethodBeat.o(64328);
            return;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
          }
        case 2005: 
          str = MMApplicationContext.getContext().getString(a.i.soter_on_sensor_error);
        }
        do
        {
          a.c(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          break;
          Log.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          str = MMApplicationContext.getContext().getString(a.i.soter_on_error_common);
        } while (paramAnonymousc.errCode != 10308);
        paramAnonymousc = MMApplicationContext.getContext().getString(a.i.soter_on_error_max_trial_special);
        a.c(6, -1000223, -1, "too many trial");
        paramb.bh(-3, paramAnonymousc);
        AppMethodBeat.o(64328);
      }
    });
    AppMethodBeat.o(64336);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64333);
    this.Byl = ((WalletBaseUI)paramContext);
    this.Byj = paramb;
    this.nfX = paramString;
    paramContext = FingerPrintAuth.getRsaKey(d.gf(MMApplicationContext.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.auM());
    a.gae();
    if (TextUtils.isEmpty(paramContext))
    {
      Log.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new o(new a((byte)0)).bPi();
      AppMethodBeat.o(64333);
      return;
    }
    Log.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new e(paramContext);
    this.Byl.doSceneProgress(paramContext, false);
    AppMethodBeat.o(64333);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64335);
    this.Byk = paramb;
    if (TextUtils.isEmpty(this.nfX))
    {
      Log.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      paramb.bh(-1, this.Byl.getString(a.i.fingerprint_open_fail));
      AppMethodBeat.o(64335);
      return;
    }
    String str1 = d.getUserId();
    String str2 = com.tencent.mm.compatible.deviceinfo.q.auM();
    String str3 = y.iiR();
    paramb = "";
    if (d.eow())
    {
      str1 = FingerPrintAuth.genOpenFPEncrypt(d.gf(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.fHa), str3, "", this.Bym, this.fHd, Build.MODEL);
      paramb = FingerPrintAuth.genOpenFPSign(d.gf(MMApplicationContext.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.auM(), str1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.Bym)) {
        Log.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        paramb = new com.tencent.mm.plugin.fingerprint.c.f(str1, paramb, this.nfX, paramInt);
        this.Byl.doSceneProgress(paramb, false);
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(64334);
    if ((paramq instanceof e))
    {
      Object localObject;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
        paramString = (e)paramq;
        this.Bym = paramString.Bym;
        this.fHd = paramString.fHd;
        localObject = this.Byj;
        paramq = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fingerprint.d.b)localObject).bh(paramInt1, paramq);
        AppMethodBeat.o(64334);
        return true;
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.plugin.fingerprint.d.b localb = this.Byj;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = localb;
        paramq = paramString;
        if (Util.isNullOrNil(paramString))
        {
          paramq = this.Byl.getString(a.i.fingerprint_open_fail);
          paramInt1 = paramInt2;
          localObject = localb;
        }
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.gaf();
        a.c(0, 0, 0, "OK");
        this.Byk.bh(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(64334);
        return true;
        this.Byk.bh(-2, "");
      }
    }
    AppMethodBeat.o(64334);
    return false;
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void aho(final String paramString)
    {
      AppMethodBeat.i(64331);
      if (TextUtils.isEmpty(paramString))
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64329);
            g.this.Byj.bh(-1, g.this.Byl.getString(a.i.fingerprint_open_fail));
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
          Message localMessage = g.this.Byf.obtainMessage();
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