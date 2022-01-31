package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hb;
import com.tencent.mm.h.a.hb.a;
import com.tencent.mm.h.a.hb.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.u;

public final class f
  extends c<hb>
  implements com.tencent.mm.ah.f
{
  private String bMX = "";
  private boolean kkX = false;
  private hb kld;
  private int kle = 0;
  ah klf = new ah(Looper.getMainLooper());
  
  public f()
  {
    this.udX = hb.class.getName().hashCode();
  }
  
  private boolean a(hb paramhb)
  {
    if (!g.DK()) {
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
    }
    do
    {
      return false;
      y.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
      this.kkX = false;
    } while (!(paramhb instanceof hb));
    if (!e.aSK())
    {
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
      paramhb = new hb.b();
      paramhb.bKQ = false;
      this.kld.bOQ = paramhb;
      this.kkX = true;
      azJ();
      return true;
    }
    this.kld = paramhb;
    g.DQ();
    g.DO().dJT.a(385, this);
    boolean bool = this.kld.bOP.bOR;
    this.kle = this.kld.bOP.bOS;
    this.bMX = this.kld.bOP.bOT;
    int i;
    if (!bool)
    {
      paramhb = e.getUserId();
      String str = com.tencent.mm.compatible.e.q.zg();
      paramhb = FingerPrintAuth.getRsaKey(e.dj(ae.getContext()), paramhb, str);
      if (!TextUtils.isEmpty(paramhb))
      {
        y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
        paramhb = new com.tencent.mm.plugin.fingerprint.c.e(paramhb);
        g.DQ();
        g.DO().dJT.a(paramhb, 0);
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        y.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
        new q(new f.a(this, (byte)0)).aTf();
      }
      return true;
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
      i = 1;
      continue;
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
      i = 1;
    }
  }
  
  private void azJ()
  {
    y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.kld.bFJ != null) {
      this.kld.bFJ.run();
    }
    if (this.kkX) {
      this.kld = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    hb.b localb;
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new hb.b();
      localb.bKQ = false;
      y.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label261;
      }
      y.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramm = (com.tencent.mm.plugin.fingerprint.c.e)paramm;
      paramString = paramm.klm;
      paramm = paramm.bOV;
      String str1 = e.getUserId();
      String str2 = com.tencent.mm.compatible.e.q.zg();
      String str3 = u.cMz();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.dj(ae.getContext()), str1, str2, String.valueOf(this.kle), str3, "", paramString, paramm, Build.MODEL))) {
        break label250;
      }
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.bKQ = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(e.dj(ae.getContext()), str1, str2, String.valueOf(this.kle), str3, this.bMX, Build.MODEL);
      paramm = FingerPrintAuth.genOpenFPSign(e.dj(ae.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.zg(), paramString);
      localb.bOU = paramString;
      localb.bOV = paramm;
    }
    for (;;)
    {
      g.DQ();
      g.DO().dJT.b(385, this);
      this.kld.bOQ = localb;
      this.kkX = true;
      azJ();
      return;
      label250:
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label261:
      y.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.f
 * JD-Core Version:    0.7.0.1
 */