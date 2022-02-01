package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.ce.a;
import com.tencent.mm.g.a.ce.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends IListener<ce>
  implements i
{
  private ce wEY;
  private boolean wEZ;
  
  public b()
  {
    AppMethodBeat.i(160794);
    this.wEZ = false;
    this.__eventId = ce.class.getName().hashCode();
    AppMethodBeat.o(160794);
  }
  
  private boolean a(ce paramce)
  {
    AppMethodBeat.i(64289);
    if (!g.aAc())
    {
      Log.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(64289);
      return false;
    }
    this.wEZ = false;
    if ((paramce instanceof ce))
    {
      this.wEY = paramce;
      Log.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      g.aAi();
      g.aAg().hqi.a(385, this);
      paramce = new d(paramce.dFo.dFq);
      g.aAi();
      g.aAg().hqi.a(paramce, 0);
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
      paramq = new ce.b();
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramq.retCode = 0;; paramq.retCode = paramInt2)
    {
      g.aAi();
      g.aAg().hqi.b(385, this);
      this.wEY.dFp = paramq;
      this.wEZ = true;
      if (this.wEY.callback != null) {
        this.wEY.callback.run();
      }
      if (this.wEZ) {
        this.wEY = null;
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