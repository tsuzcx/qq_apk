package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io.a;
import com.tencent.mm.g.a.io.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.wallet_core.c.y;

public final class e
  extends c<io>
  implements f
{
  private String dmw;
  private int trA;
  aq trB;
  private boolean trs;
  private io trz;
  
  public e()
  {
    AppMethodBeat.i(64320);
    this.trA = 0;
    this.dmw = "";
    this.trs = false;
    this.trB = new aq(Looper.getMainLooper());
    this.__eventId = io.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(io paramio)
  {
    AppMethodBeat.i(64321);
    if (!g.ajM())
    {
      ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    ae.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.trs = false;
    if ((paramio instanceof io))
    {
      if (!d.cSc())
      {
        ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramio = new io.b();
        paramio.drc = false;
        this.trz.dwg = paramio;
        this.trs = true;
        bVo();
        AppMethodBeat.o(64321);
        return true;
      }
      this.trz = paramio;
      g.ajS();
      g.ajQ().gDv.a(385, this);
      boolean bool = this.trz.dwf.dwh;
      this.trA = this.trz.dwf.dwi;
      this.dmw = this.trz.dwf.dwj;
      int i;
      if (!bool)
      {
        paramio = d.getUserId();
        String str = com.tencent.mm.compatible.deviceinfo.q.aaH();
        paramio = FingerPrintAuth.getRsaKey(d.fg(ak.getContext()), paramio, str);
        if (!TextUtils.isEmpty(paramio))
        {
          ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramio = new com.tencent.mm.plugin.fingerprint.c.e(paramio);
          g.ajS();
          g.ajQ().gDv.a(paramio, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ae.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new o(new a((byte)0)).biv();
        }
        AppMethodBeat.o(64321);
        return true;
        ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
        i = 1;
        continue;
        ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
        i = 1;
      }
    }
    AppMethodBeat.o(64321);
    return false;
  }
  
  private void bVo()
  {
    AppMethodBeat.i(64323);
    ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.trz.callback != null) {
      this.trz.callback.run();
    }
    if (this.trs) {
      this.trz = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64322);
    io.b localb;
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new io.b();
      localb.drc = false;
      ae.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      ae.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramn = (com.tencent.mm.plugin.fingerprint.c.e)paramn;
      paramString = paramn.trI;
      paramn = paramn.dwl;
      String str1 = d.getUserId();
      String str2 = com.tencent.mm.compatible.deviceinfo.q.aaH();
      String str3 = y.fVS();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.fg(ak.getContext()), str1, str2, String.valueOf(this.trA), str3, "", paramString, paramn, Build.MODEL))) {
        break label260;
      }
      ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.drc = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(d.fg(ak.getContext()), str1, str2, String.valueOf(this.trA), str3, this.dmw, Build.MODEL);
      paramn = FingerPrintAuth.genOpenFPSign(d.fg(ak.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.aaH(), paramString);
      localb.dwk = paramString;
      localb.dwl = paramn;
    }
    for (;;)
    {
      g.ajS();
      g.ajQ().gDv.b(385, this);
      this.trz.dwg = localb;
      this.trs = true;
      bVo();
      AppMethodBeat.o(64322);
      return;
      label260:
      ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label271:
      ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
  
  final class a
    implements o.a
  {
    private a() {}
    
    public final void PZ(final String paramString)
    {
      AppMethodBeat.i(64319);
      e.this.trB.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64318);
          if (TextUtils.isEmpty(paramString)) {
            ae.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
          }
          com.tencent.mm.plugin.fingerprint.c.e locale = new com.tencent.mm.plugin.fingerprint.c.e(paramString);
          g.ajS();
          g.ajQ().gDv.a(locale, 0);
          AppMethodBeat.o(64318);
        }
      });
      AppMethodBeat.o(64319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e
 * JD-Core Version:    0.7.0.1
 */