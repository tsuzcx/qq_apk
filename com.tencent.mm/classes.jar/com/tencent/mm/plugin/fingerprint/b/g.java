package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.a.c;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.soter.d.a;
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
  int dNP;
  private String dNS;
  private String kof;
  MMHandler wFi;
  com.tencent.mm.plugin.fingerprint.d.b wFm;
  private com.tencent.mm.plugin.fingerprint.d.b wFn;
  WalletBaseUI wFo;
  private String wFp;
  
  public g()
  {
    AppMethodBeat.i(64332);
    this.wFm = null;
    this.wFn = null;
    this.wFo = null;
    this.wFp = null;
    this.dNS = null;
    this.kof = null;
    this.wFi = new MMHandler(new MMHandler.Callback()
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
                g.this.wFm.bg(-1, g.this.wFo.getString(2131760697));
                AppMethodBeat.o(64326);
              }
            });
          }
          paramAnonymousMessage = new e(str);
          g.this.wFo.doSceneProgress(paramAnonymousMessage, false);
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
    ((i)com.tencent.mm.kernel.g.af(i.class)).a(paramContext, new com.tencent.mm.plugin.fingerprint.b.a.f("", (byte)0), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64328);
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        String str = "";
        switch (paramAnonymousc.errCode)
        {
        }
        for (;;)
        {
          paramb.bg(-2, str);
          AppMethodBeat.o(64328);
          return;
          Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify success");
          g.this.dNP = paramAnonymousc.dNP;
          paramb.bg(0, "");
          AppMethodBeat.o(64328);
          return;
          Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bg(-1, "");
          AppMethodBeat.o(64328);
          return;
          Log.i("MicroMsg.HwFingerprintOpenDelegate", "identify timeout");
          continue;
          str = MMApplicationContext.getContext().getString(2131766339);
          do
          {
            a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            break;
            Log.i("MicroMsg.HwFingerprintOpenDelegate", "hy: on error: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            str = MMApplicationContext.getContext().getString(2131766337);
          } while (paramAnonymousc.errCode != 10308);
          str = MMApplicationContext.getContext().getString(2131766338);
          a.d(6, -1000223, -1, "too many trial");
        }
      }
    });
    AppMethodBeat.o(64336);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64333);
    this.wFo = ((WalletBaseUI)paramContext);
    this.wFm = paramb;
    this.kof = paramString;
    paramContext = FingerPrintAuth.getRsaKey(d.fL(MMApplicationContext.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.aoG());
    a.flI();
    if (TextUtils.isEmpty(paramContext))
    {
      Log.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
      new o(new a((byte)0)).bDI();
      AppMethodBeat.o(64333);
      return;
    }
    Log.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
    paramContext = new e(paramContext);
    this.wFo.doSceneProgress(paramContext, false);
    AppMethodBeat.o(64333);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64335);
    this.wFn = paramb;
    if (TextUtils.isEmpty(this.kof))
    {
      Log.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
      paramb.bg(-1, this.wFo.getString(2131760697));
      AppMethodBeat.o(64335);
      return;
    }
    String str1 = d.getUserId();
    String str2 = com.tencent.mm.compatible.deviceinfo.q.aoG();
    String str3 = y.hhp();
    paramb = "";
    if (d.dJX())
    {
      str1 = FingerPrintAuth.genOpenFPEncrypt(d.fL(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.dNP), str3, "", this.wFp, this.dNS, Build.MODEL);
      paramb = FingerPrintAuth.genOpenFPSign(d.fL(MMApplicationContext.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.aoG(), str1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.wFp)) {
        Log.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
      }
      for (;;)
      {
        paramb = new com.tencent.mm.plugin.fingerprint.c.f(str1, paramb, this.kof, paramInt);
        this.wFo.doSceneProgress(paramb, false);
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
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
        this.wFp = paramString.wFp;
        this.dNS = paramString.dNS;
        localObject = this.wFm;
        paramq = "";
        paramInt1 = i;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.fingerprint.d.b)localObject).bg(paramInt1, paramq);
        AppMethodBeat.o(64334);
        return true;
        Log.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
        com.tencent.mm.plugin.fingerprint.d.b localb = this.wFm;
        paramInt2 = -1;
        paramInt1 = paramInt2;
        localObject = localb;
        paramq = paramString;
        if (Util.isNullOrNil(paramString))
        {
          paramq = this.wFo.getString(2131760697);
          paramInt1 = paramInt2;
          localObject = localb;
        }
      }
    }
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a.flJ();
        a.d(0, 0, 0, "OK");
        this.wFn.bg(0, "");
      }
      for (;;)
      {
        AppMethodBeat.o(64334);
        return true;
        this.wFn.bg(-2, "");
      }
    }
    AppMethodBeat.o(64334);
    return false;
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void ZA(final String paramString)
    {
      AppMethodBeat.i(64331);
      if (TextUtils.isEmpty(paramString))
      {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64329);
            g.this.wFm.bg(-1, g.this.wFo.getString(2131760697));
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
          Message localMessage = g.this.wFi.obtainMessage();
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