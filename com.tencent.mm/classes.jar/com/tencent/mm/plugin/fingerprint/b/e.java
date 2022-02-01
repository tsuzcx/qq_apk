package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hy.a;
import com.tencent.mm.g.a.hy.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.wallet_core.c.y;

public final class e
  extends c<hy>
  implements com.tencent.mm.al.g
{
  private String dcE;
  private boolean rbD;
  private hy rbK;
  private int rbL;
  ap rbM;
  
  public e()
  {
    AppMethodBeat.i(64320);
    this.rbL = 0;
    this.dcE = "";
    this.rbD = false;
    this.rbM = new ap(Looper.getMainLooper());
    this.__eventId = hy.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(hy paramhy)
  {
    AppMethodBeat.i(64321);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.rbD = false;
    if ((paramhy instanceof hy))
    {
      if (!d.ctW())
      {
        ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramhy = new hy.b();
        paramhy.dhg = false;
        this.rbK.dlG = paramhy;
        this.rbD = true;
        bIh();
        AppMethodBeat.o(64321);
        return true;
      }
      this.rbK = paramhy;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(385, this);
      boolean bool = this.rbK.dlF.dlH;
      this.rbL = this.rbK.dlF.dlI;
      this.dcE = this.rbK.dlF.dlJ;
      int i;
      if (!bool)
      {
        paramhy = d.getUserId();
        String str = com.tencent.mm.compatible.deviceinfo.q.Xa();
        paramhy = FingerPrintAuth.getRsaKey(d.eM(aj.getContext()), paramhy, str);
        if (!TextUtils.isEmpty(paramhy))
        {
          ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramhy = new com.tencent.mm.plugin.fingerprint.c.e(paramhy);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(paramhy, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new o(new e.a(this, (byte)0)).aXl();
        }
        AppMethodBeat.o(64321);
        return true;
        ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
        i = 1;
        continue;
        ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
        i = 1;
      }
    }
    AppMethodBeat.o(64321);
    return false;
  }
  
  private void bIh()
  {
    AppMethodBeat.i(64323);
    ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.rbK.callback != null) {
      this.rbK.callback.run();
    }
    if (this.rbD) {
      this.rbK = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64322);
    hy.b localb;
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new hy.b();
      localb.dhg = false;
      ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramn = (com.tencent.mm.plugin.fingerprint.c.e)paramn;
      paramString = paramn.rbT;
      paramn = paramn.dlL;
      String str1 = d.getUserId();
      String str2 = com.tencent.mm.compatible.deviceinfo.q.Xa();
      String str3 = y.fjW();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.eM(aj.getContext()), str1, str2, String.valueOf(this.rbL), str3, "", paramString, paramn, Build.MODEL))) {
        break label260;
      }
      ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.dhg = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(d.eM(aj.getContext()), str1, str2, String.valueOf(this.rbL), str3, this.dcE, Build.MODEL);
      paramn = FingerPrintAuth.genOpenFPSign(d.eM(aj.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.Xa(), paramString);
      localb.dlK = paramString;
      localb.dlL = paramn;
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      this.rbK.dlG = localb;
      this.rbD = true;
      bIh();
      AppMethodBeat.o(64322);
      return;
      label260:
      ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label271:
      ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e
 * JD-Core Version:    0.7.0.1
 */