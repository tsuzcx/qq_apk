package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ci;
import com.tencent.mm.f.a.ci.a;
import com.tencent.mm.f.a.ci.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends IListener<ci>
  implements i
{
  private ci BxV;
  private boolean BxW;
  
  public b()
  {
    AppMethodBeat.i(160794);
    this.BxW = false;
    this.__eventId = ci.class.getName().hashCode();
    AppMethodBeat.o(160794);
  }
  
  private boolean a(ci paramci)
  {
    AppMethodBeat.i(64289);
    if (!h.aHB())
    {
      Log.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(64289);
      return false;
    }
    this.BxW = false;
    if ((paramci instanceof ci))
    {
      this.BxV = paramci;
      Log.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      h.aHH();
      h.aHF().kcd.a(385, this);
      paramci = new d(paramci.fxW.fxY);
      h.aHH();
      h.aHF().kcd.a(paramci, 0);
      AppMethodBeat.o(64289);
      return true;
    }
    AppMethodBeat.o(64289);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64290);
    if ((paramq instanceof d))
    {
      paramq = new ci.b();
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramq.retCode = 0;; paramq.retCode = paramInt2)
    {
      h.aHH();
      h.aHF().kcd.b(385, this);
      this.BxV.fxX = paramq;
      this.BxW = true;
      if (this.BxV.callback != null) {
        this.BxV.callback.run();
      }
      if (this.BxW) {
        this.BxV = null;
      }
      AppMethodBeat.o(64290);
      return;
      label144:
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */