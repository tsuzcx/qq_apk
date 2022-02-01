package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.a;
import com.tencent.mm.g.a.jd.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.wallet_core.c.y;

public final class e
  extends IListener<jd>
  implements i
{
  private String dDL;
  private boolean wEZ;
  private jd wFg;
  private int wFh;
  MMHandler wFi;
  
  public e()
  {
    AppMethodBeat.i(64320);
    this.wFh = 0;
    this.dDL = "";
    this.wEZ = false;
    this.wFi = new MMHandler(Looper.getMainLooper());
    this.__eventId = jd.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(jd paramjd)
  {
    AppMethodBeat.i(64321);
    if (!g.aAc())
    {
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.wEZ = false;
    if ((paramjd instanceof jd))
    {
      if (!d.dJX())
      {
        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramjd = new jd.b();
        paramjd.isSuccess = false;
        this.wFg.dNN = paramjd;
        this.wEZ = true;
        ctc();
        AppMethodBeat.o(64321);
        return true;
      }
      this.wFg = paramjd;
      g.aAi();
      g.aAg().hqi.a(385, this);
      boolean bool = this.wFg.dNM.dNO;
      this.wFh = this.wFg.dNM.dNP;
      this.dDL = this.wFg.dNM.dNQ;
      int i;
      if (!bool)
      {
        paramjd = d.getUserId();
        String str = com.tencent.mm.compatible.deviceinfo.q.aoG();
        paramjd = FingerPrintAuth.getRsaKey(d.fL(MMApplicationContext.getContext()), paramjd, str);
        if (!TextUtils.isEmpty(paramjd))
        {
          Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramjd = new com.tencent.mm.plugin.fingerprint.c.e(paramjd);
          g.aAi();
          g.aAg().hqi.a(paramjd, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new o(new a((byte)0)).bDI();
        }
        AppMethodBeat.o(64321);
        return true;
        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
        i = 1;
        continue;
        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
        i = 1;
      }
    }
    AppMethodBeat.o(64321);
    return false;
  }
  
  private void ctc()
  {
    AppMethodBeat.i(64323);
    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.wFg.callback != null) {
      this.wFg.callback.run();
    }
    if (this.wEZ) {
      this.wFg = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(64322);
    jd.b localb;
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new jd.b();
      localb.isSuccess = false;
      Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramq = (com.tencent.mm.plugin.fingerprint.c.e)paramq;
      paramString = paramq.wFp;
      paramq = paramq.dNS;
      String str1 = d.getUserId();
      String str2 = com.tencent.mm.compatible.deviceinfo.q.aoG();
      String str3 = y.hhp();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.fL(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.wFh), str3, "", paramString, paramq, Build.MODEL))) {
        break label260;
      }
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.isSuccess = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(d.fL(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.wFh), str3, this.dDL, Build.MODEL);
      paramq = FingerPrintAuth.genOpenFPSign(d.fL(MMApplicationContext.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.aoG(), paramString);
      localb.dNR = paramString;
      localb.dNS = paramq;
    }
    for (;;)
    {
      g.aAi();
      g.aAg().hqi.b(385, this);
      this.wFg.dNN = localb;
      this.wEZ = true;
      ctc();
      AppMethodBeat.o(64322);
      return;
      label260:
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label271:
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void ZA(final String paramString)
    {
      AppMethodBeat.i(64319);
      e.this.wFi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64318);
          if (TextUtils.isEmpty(paramString)) {
            Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
          }
          com.tencent.mm.plugin.fingerprint.c.e locale = new com.tencent.mm.plugin.fingerprint.c.e(paramString);
          g.aAi();
          g.aAg().hqi.a(locale, 0);
          AppMethodBeat.o(64318);
        }
      });
      AppMethodBeat.o(64319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e
 * JD-Core Version:    0.7.0.1
 */