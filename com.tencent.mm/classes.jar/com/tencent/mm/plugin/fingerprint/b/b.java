package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.a;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends c<cc>
  implements f
{
  private cc tgy;
  private boolean tgz;
  
  public b()
  {
    AppMethodBeat.i(160794);
    this.tgz = false;
    this.__eventId = cc.class.getName().hashCode();
    AppMethodBeat.o(160794);
  }
  
  private boolean a(cc paramcc)
  {
    AppMethodBeat.i(64289);
    if (!g.ajx())
    {
      ad.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(64289);
      return false;
    }
    this.tgz = false;
    if ((paramcc instanceof cc))
    {
      this.tgy = paramcc;
      ad.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      g.ajD();
      g.ajB().gAO.a(385, this);
      paramcc = new d(paramcc.dmX.dmZ);
      g.ajD();
      g.ajB().gAO.a(paramcc, 0);
      AppMethodBeat.o(64289);
      return true;
    }
    AppMethodBeat.o(64289);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64290);
    if ((paramn instanceof d))
    {
      paramn = new cc.b();
      ad.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      ad.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramn.retCode = 0;; paramn.retCode = paramInt2)
    {
      g.ajD();
      g.ajB().gAO.b(385, this);
      this.tgy.dmY = paramn;
      this.tgz = true;
      if (this.tgy.callback != null) {
        this.tgy.callback.run();
      }
      if (this.tgz) {
        this.tgy = null;
      }
      AppMethodBeat.o(64290);
      return;
      label144:
      ad.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */