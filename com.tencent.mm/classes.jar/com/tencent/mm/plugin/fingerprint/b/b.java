package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cc.a;
import com.tencent.mm.g.a.cc.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends c<cc>
  implements f
{
  private cc trr;
  private boolean trs;
  
  public b()
  {
    AppMethodBeat.i(160794);
    this.trs = false;
    this.__eventId = cc.class.getName().hashCode();
    AppMethodBeat.o(160794);
  }
  
  private boolean a(cc paramcc)
  {
    AppMethodBeat.i(64289);
    if (!g.ajM())
    {
      ae.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(64289);
      return false;
    }
    this.trs = false;
    if ((paramcc instanceof cc))
    {
      this.trr = paramcc;
      ae.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      g.ajS();
      g.ajQ().gDv.a(385, this);
      paramcc = new d(paramcc.dnZ.dob);
      g.ajS();
      g.ajQ().gDv.a(paramcc, 0);
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
      ae.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      ae.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramn.retCode = 0;; paramn.retCode = paramInt2)
    {
      g.ajS();
      g.ajQ().gDv.b(385, this);
      this.trr.doa = paramn;
      this.trs = true;
      if (this.trr.callback != null) {
        this.trr.callback.run();
      }
      if (this.trs) {
        this.trr = null;
      }
      AppMethodBeat.o(64290);
      return;
      label144:
      ae.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */