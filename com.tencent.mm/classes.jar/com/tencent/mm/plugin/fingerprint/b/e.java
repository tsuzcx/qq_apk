package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.a.if.a;
import com.tencent.mm.g.a.if.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.wallet_core.c.y;

public final class e
  extends c<if>
  implements com.tencent.mm.ak.g
{
  private String dac;
  private boolean sjX;
  private if ske;
  private int skf;
  ao skg;
  
  public e()
  {
    AppMethodBeat.i(64320);
    this.skf = 0;
    this.dac = "";
    this.sjX = false;
    this.skg = new ao(Looper.getMainLooper());
    this.__eventId = if.class.getName().hashCode();
    AppMethodBeat.o(64320);
  }
  
  private boolean a(if paramif)
  {
    AppMethodBeat.i(64321);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(64321);
      return false;
    }
    ac.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.sjX = false;
    if ((paramif instanceof if))
    {
      if (!d.cHi())
      {
        ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramif = new if.b();
        paramif.deB = false;
        this.ske.djo = paramif;
        this.sjX = true;
        bPu();
        AppMethodBeat.o(64321);
        return true;
      }
      this.ske = paramif;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
      boolean bool = this.ske.djn.djp;
      this.skf = this.ske.djn.djq;
      this.dac = this.ske.djn.djr;
      int i;
      if (!bool)
      {
        paramif = d.getUserId();
        String str = com.tencent.mm.compatible.deviceinfo.q.XX();
        paramif = FingerPrintAuth.getRsaKey(d.eZ(ai.getContext()), paramif, str);
        if (!TextUtils.isEmpty(paramif))
        {
          ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramif = new com.tencent.mm.plugin.fingerprint.c.e(paramif);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(paramif, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ac.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new o(new e.a(this, (byte)0)).bei();
        }
        AppMethodBeat.o(64321);
        return true;
        ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
        i = 1;
        continue;
        ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
        i = 1;
      }
    }
    AppMethodBeat.o(64321);
    return false;
  }
  
  private void bPu()
  {
    AppMethodBeat.i(64323);
    ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.ske.callback != null) {
      this.ske.callback.run();
    }
    if (this.sjX) {
      this.ske = null;
    }
    AppMethodBeat.o(64323);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64322);
    if.b localb;
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new if.b();
      localb.deB = false;
      ac.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      ac.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramn = (com.tencent.mm.plugin.fingerprint.c.e)paramn;
      paramString = paramn.skn;
      paramn = paramn.djt;
      String str1 = d.getUserId();
      String str2 = com.tencent.mm.compatible.deviceinfo.q.XX();
      String str3 = y.fAm();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(d.eZ(ai.getContext()), str1, str2, String.valueOf(this.skf), str3, "", paramString, paramn, Build.MODEL))) {
        break label260;
      }
      ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.deB = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(d.eZ(ai.getContext()), str1, str2, String.valueOf(this.skf), str3, this.dac, Build.MODEL);
      paramn = FingerPrintAuth.genOpenFPSign(d.eZ(ai.getContext()), d.getUserId(), com.tencent.mm.compatible.deviceinfo.q.XX(), paramString);
      localb.djs = paramString;
      localb.djt = paramn;
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      this.ske.djo = localb;
      this.sjX = true;
      bPu();
      AppMethodBeat.o(64322);
      return;
      label260:
      ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label271:
      ac.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e
 * JD-Core Version:    0.7.0.1
 */