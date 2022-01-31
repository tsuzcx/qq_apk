package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.he.a;
import com.tencent.mm.g.a.he.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends c<he>
  implements com.tencent.mm.ai.f
{
  private String cnI;
  private boolean mFK;
  private he mFR;
  private int mFS;
  ak mFT;
  
  public f()
  {
    AppMethodBeat.i(41473);
    this.mFS = 0;
    this.cnI = "";
    this.mFK = false;
    this.mFT = new ak(Looper.getMainLooper());
    this.__eventId = he.class.getName().hashCode();
    AppMethodBeat.o(41473);
  }
  
  private boolean a(he paramhe)
  {
    AppMethodBeat.i(41474);
    if (!g.RG())
    {
      ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
      AppMethodBeat.o(41474);
      return false;
    }
    ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
    this.mFK = false;
    if ((paramhe instanceof he))
    {
      if (!e.bzf())
      {
        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
        paramhe = new he.b();
        paramhe.csk = false;
        this.mFR.cwh = paramhe;
        this.mFK = true;
        bbp();
        AppMethodBeat.o(41474);
        return true;
      }
      this.mFR = paramhe;
      g.RM();
      g.RK().eHt.a(385, this);
      boolean bool = this.mFR.cwg.cwi;
      this.mFS = this.mFR.cwg.cwj;
      this.cnI = this.mFR.cwg.cwk;
      int i;
      if (!bool)
      {
        paramhe = e.getUserId();
        String str = com.tencent.mm.compatible.e.q.LK();
        paramhe = FingerPrintAuth.getRsaKey(e.dU(ah.getContext()), paramhe, str);
        if (!TextUtils.isEmpty(paramhe))
        {
          ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
          paramhe = new com.tencent.mm.plugin.fingerprint.c.e(paramhe);
          g.RM();
          g.RK().eHt.a(paramhe, 0);
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
          new q(new f.a(this, (byte)0)).aBi();
        }
        AppMethodBeat.o(41474);
        return true;
        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
        i = 1;
        continue;
        ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
        i = 1;
      }
    }
    AppMethodBeat.o(41474);
    return false;
  }
  
  private void bbp()
  {
    AppMethodBeat.i(41476);
    ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
    if (this.mFR.callback != null) {
      this.mFR.callback.run();
    }
    if (this.mFK) {
      this.mFR = null;
    }
    AppMethodBeat.o(41476);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41475);
    he.b localb;
    if ((paramm instanceof com.tencent.mm.plugin.fingerprint.c.e))
    {
      localb = new he.b();
      localb.csk = false;
      ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label271;
      }
      ab.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
      paramm = (com.tencent.mm.plugin.fingerprint.c.e)paramm;
      paramString = paramm.mGa;
      paramm = paramm.cwm;
      String str1 = e.getUserId();
      String str2 = com.tencent.mm.compatible.e.q.LK();
      String str3 = w.dSo();
      if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.dU(ah.getContext()), str1, str2, String.valueOf(this.mFS), str3, "", paramString, paramm, Build.MODEL))) {
        break label260;
      }
      ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
      localb.csk = true;
      paramString = FingerPrintAuth.genPayFPEncrypt(e.dU(ah.getContext()), str1, str2, String.valueOf(this.mFS), str3, this.cnI, Build.MODEL);
      paramm = FingerPrintAuth.genOpenFPSign(e.dU(ah.getContext()), e.getUserId(), com.tencent.mm.compatible.e.q.LK(), paramString);
      localb.cwl = paramString;
      localb.cwm = paramm;
    }
    for (;;)
    {
      g.RM();
      g.RK().eHt.b(385, this);
      this.mFR.cwh = localb;
      this.mFK = true;
      bbp();
      AppMethodBeat.o(41475);
      return;
      label260:
      ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
      break;
      label271:
      ab.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.f
 * JD-Core Version:    0.7.0.1
 */