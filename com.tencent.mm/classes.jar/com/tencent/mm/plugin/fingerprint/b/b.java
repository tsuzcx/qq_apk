package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.bz.a;
import com.tencent.mm.g.a.bz.b;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends c<bz>
  implements com.tencent.mm.ak.g
{
  private bz sjW;
  private boolean sjX;
  
  public b()
  {
    AppMethodBeat.i(160794);
    this.sjX = false;
    this.__eventId = bz.class.getName().hashCode();
    AppMethodBeat.o(160794);
  }
  
  private boolean a(bz parambz)
  {
    AppMethodBeat.i(64289);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(64289);
      return false;
    }
    this.sjX = false;
    if ((parambz instanceof bz))
    {
      this.sjW = parambz;
      ac.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
      parambz = new d(parambz.dbB.dbD);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(parambz, 0);
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
      paramn = new bz.b();
      ac.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      ac.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramn.retCode = 0;; paramn.retCode = paramInt2)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      this.sjW.dbC = paramn;
      this.sjX = true;
      if (this.sjW.callback != null) {
        this.sjW.callback.run();
      }
      if (this.sjX) {
        this.sjW = null;
      }
      AppMethodBeat.o(64290);
      return;
      label144:
      ac.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */