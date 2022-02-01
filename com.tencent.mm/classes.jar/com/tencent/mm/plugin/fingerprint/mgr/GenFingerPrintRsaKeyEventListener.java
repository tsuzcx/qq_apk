package com.tencent.mm.plugin.fingerprint.mgr;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.kv;
import com.tencent.mm.autogen.a.kv.a;
import com.tencent.mm.autogen.a.kv.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.wallet_core.model.y;

public class GenFingerPrintRsaKeyEventListener
  extends IListener<kv>
  implements com.tencent.mm.am.h
{
  private kv HfF;
  private int HfG;
  MMHandler HfH;
  private boolean Hfz;
  private String hAT;
  
  public GenFingerPrintRsaKeyEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(64320);
    this.HfG = 0;
    this.hAT = "";
    this.Hfz = false;
    this.HfH = new MMHandler(Looper.getMainLooper());
    this.__eventId = kv.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(kv paramkv)
  {
    AppMethodBeat.i(64321);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.Hfz = false;
    if ((paramkv instanceof kv))
    {
      if (!c.ftz())
      {
        Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramkv = new kv.b();
        paramkv.isSuccess = false;
        this.HfF.hMv = paramkv;
        this.Hfz = true;
        djV();
        AppMethodBeat.o(64321);
        return true;
      }
      this.HfF = paramkv;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(385, this);
      boolean bool = this.HfF.hMu.hMw;
      this.HfG = this.HfF.hMu.hMx;
      this.hAT = this.HfF.hMu.hMy;
      int i;
      if (!bool)
      {
        paramkv = c.getUserId();
        String str = q.aPg();
        paramkv = FingerPrintAuth.getRsaKey(c.hA(MMApplicationContext.getContext()), paramkv, str);
        if (!TextUtils.isEmpty(paramkv))
        {
          Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramkv = new e(paramkv);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(paramkv, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new i(new GenFingerPrintRsaKeyEventListener.a(this, (byte)0)).cpv();
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
  
  private void djV()
  {
    AppMethodBeat.i(64323);
    Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.HfF.callback != null) {
      this.HfF.callback.run();
    }
    if (this.Hfz) {
      this.HfF = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64322);
    kv.b localb;
    if ((paramp instanceof e))
    {
      localb = new kv.b();
      localb.isSuccess = false;
      Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      Log.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramp = (e)paramp;
      paramString = paramp.HfO;
      paramp = paramp.hMA;
      String str1 = c.getUserId();
      String str2 = q.aPg();
      String str3 = y.jON();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(c.hA(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.HfG), str3, "", paramString, paramp, q.aPo()))) {
        break label260;
      }
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.isSuccess = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(c.hA(MMApplicationContext.getContext()), str1, str2, String.valueOf(this.HfG), str3, this.hAT, q.aPo());
      paramp = FingerPrintAuth.genOpenFPSign(c.hA(MMApplicationContext.getContext()), c.getUserId(), q.aPg(), paramString);
      localb.hMz = paramString;
      localb.hMA = paramp;
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      this.HfF.hMv = localb;
      this.Hfz = true;
      djV();
      AppMethodBeat.o(64322);
      return;
      label260:
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label271:
      Log.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.GenFingerPrintRsaKeyEventListener
 * JD-Core Version:    0.7.0.1
 */