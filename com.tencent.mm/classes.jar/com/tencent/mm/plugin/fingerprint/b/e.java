package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in.a;
import com.tencent.mm.g.a.in.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.wallet_core.c.y;

public final class e
  extends c<in>
  implements f
{
  private String dlu;
  private in tgG;
  private int tgH;
  ap tgI;
  private boolean tgz;
  
  public e()
  {
    AppMethodBeat.i(64320);
    this.tgH = 0;
    this.dlu = "";
    this.tgz = false;
    this.tgI = new ap(Looper.getMainLooper());
    this.__eventId = in.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(in paramin)
  {
    AppMethodBeat.i(64321);
    if (!g.ajx())
    {
      ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.tgz = false;
    if ((paramin instanceof in))
    {
      if (!d.cPx())
      {
        ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramin = new in.b();
        paramin.dpX = false;
        this.tgG.dvb = paramin;
        this.tgz = true;
        bTZ();
        AppMethodBeat.o(64321);
        return true;
      }
      this.tgG = paramin;
      g.ajD();
      g.ajB().gAO.a(385, this);
      boolean bool = this.tgG.dva.dvc;
      this.tgH = this.tgG.dva.dvd;
      this.dlu = this.tgG.dva.dve;
      int i;
      if (!bool)
      {
        paramin = d.getUserId();
        String str = com.tencent.mm.compatible.deviceinfo.q.aay();
        paramin = FingerPrintAuth.getRsaKey(d.fc(aj.getContext()), paramin, str);
        if (!TextUtils.isEmpty(paramin))
        {
          ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramin = new com.tencent.mm.plugin.fingerprint.c.e(paramin);
          g.ajD();
          g.ajB().gAO.a(paramin, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new o(new e.a(this, (byte)0)).bhM();
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
  
  private void bTZ()
  {
    AppMethodBeat.i(64323);
    ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.tgG.callback != null) {
      this.tgG.callback.run();
    }
    if (this.tgz) {
      this.tgG = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64322);
    in.b localb;
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new in.b();
      localb.dpX = false;
      ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      ad.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramn = (com.tencent.mm.plugin.fingerprint.c.e)paramn;
      paramString = paramn.tgP;
      paramn = paramn.dvg;
      String str1 = d.getUserId();
      String str2 = com.tencent.mm.compatible.deviceinfo.q.aay();
      String str3 = y.fRw();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.fc(aj.getContext()), str1, str2, String.valueOf(this.tgH), str3, "", paramString, paramn, Build.MODEL))) {
        break label260;
      }
      ad.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.dpX = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(d.fc(aj.getContext()), str1, str2, String.valueOf(this.tgH), str3, this.dlu, Build.MODEL);
      paramn = FingerPrintAuth.genOpenFPSign(d.fc(aj.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.aay(), paramString);
      localb.dvf = paramString;
      localb.dvg = paramn;
    }
    for (;;)
    {
      g.ajD();
      g.ajB().gAO.b(385, this);
      this.tgG.dvb = localb;
      this.tgz = true;
      bTZ();
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