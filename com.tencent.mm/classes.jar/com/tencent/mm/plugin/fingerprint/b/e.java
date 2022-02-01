package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.f.a.jt.a;
import com.tencent.mm.f.a.jt.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.wallet_core.c.y;

public final class e
  extends IListener<jt>
  implements i
{
  private boolean BxW;
  private jt Byd;
  private int Bye;
  MMHandler Byf;
  private String fwv;
  
  public e()
  {
    AppMethodBeat.i(64320);
    this.Bye = 0;
    this.fwv = "";
    this.BxW = false;
    this.Byf = new MMHandler(Looper.getMainLooper());
    this.__eventId = jt.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(jt paramjt)
  {
    AppMethodBeat.i(64321);
    if (!h.aHB())
    {
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.BxW = false;
    if ((paramjt instanceof jt))
    {
      if (!d.eow())
      {
        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramjt = new jt.b();
        paramjt.isSuccess = false;
        this.Byd.fGY = paramjt;
        this.BxW = true;
        cGE();
        AppMethodBeat.o(64321);
        return true;
      }
      this.Byd = paramjt;
      h.aHH();
      h.aHF().kcd.a(385, this);
      boolean bool = this.Byd.fGX.fGZ;
      this.Bye = this.Byd.fGX.fHa;
      this.fwv = this.Byd.fGX.fHb;
      int i;
      if (!bool)
      {
        paramjt = d.getUserId();
        String str = com.tencent.mm.compatible.deviceinfo.q.auM();
        paramjt = FingerPrintAuth.getRsaKey(d.gf(MMApplicationContext.getContext()), paramjt, str);
        if (!TextUtils.isEmpty(paramjt))
        {
          Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramjt = new com.tencent.mm.plugin.fingerprint.c.e(paramjt);
          h.aHH();
          h.aHF().kcd.a(paramjt, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new o(new a((byte)0)).bPi();
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
  
  private void cGE()
  {
    AppMethodBeat.i(64323);
    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.Byd.callback != null) {
      this.Byd.callback.run();
    }
    if (this.BxW) {
      this.Byd = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(64322);
    jt.b localb;
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new jt.b();
      localb.isSuccess = false;
      Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramq = (com.tencent.mm.plugin.fingerprint.c.e)paramq;
      paramString = paramq.Bym;
      paramq = paramq.fHd;
      String str1 = d.getUserId();
      String str2 = com.tencent.mm.compatible.deviceinfo.q.auM();
      String str3 = y.iiR();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.gf(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.Bye), str3, "", paramString, paramq, Build.MODEL))) {
        break label260;
      }
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.isSuccess = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(d.gf(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.Bye), str3, this.fwv, Build.MODEL);
      paramq = FingerPrintAuth.genOpenFPSign(d.gf(MMApplicationContext.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.auM(), paramString);
      localb.fHc = paramString;
      localb.fHd = paramq;
    }
    for (;;)
    {
      h.aHH();
      h.aHF().kcd.b(385, this);
      this.Byd.fGY = localb;
      this.BxW = true;
      cGE();
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
    
    public final void aho(final String paramString)
    {
      AppMethodBeat.i(64319);
      e.this.Byf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64318);
          if (TextUtils.isEmpty(paramString)) {
            Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
          }
          com.tencent.mm.plugin.fingerprint.c.e locale = new com.tencent.mm.plugin.fingerprint.c.e(paramString);
          h.aHH();
          h.aHF().kcd.a(locale, 0);
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