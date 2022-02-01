package com.tencent.mm.plugin.fingerprint.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cr;
import com.tencent.mm.autogen.a.cr.a;
import com.tencent.mm.autogen.a.cr.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class CloseFingerPrintEventListener
  extends IListener<cr>
  implements com.tencent.mm.am.h
{
  private cr Hfy;
  private boolean Hfz;
  
  public CloseFingerPrintEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160794);
    this.Hfz = false;
    this.__eventId = cr.class.getName().hashCode();
    AppMethodBeat.o(160794);
  }
  
  private boolean a(cr paramcr)
  {
    AppMethodBeat.i(64289);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(64289);
      return false;
    }
    this.Hfz = false;
    if ((paramcr instanceof cr))
    {
      this.Hfy = paramcr;
      Log.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(385, this);
      paramcr = new d(paramcr.hCB.hCD);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramcr, 0);
      AppMethodBeat.o(64289);
      return true;
    }
    AppMethodBeat.o(64289);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64290);
    if ((paramp instanceof d))
    {
      paramp = new cr.b();
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramp.retCode = 0;; paramp.retCode = paramInt2)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      this.Hfy.hCC = paramp;
      this.Hfz = true;
      if (this.Hfy.callback != null) {
        this.Hfy.callback.run();
      }
      if (this.Hfz) {
        this.Hfy = null;
      }
      AppMethodBeat.o(64290);
      return;
      label144:
      Log.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.CloseFingerPrintEventListener
 * JD-Core Version:    0.7.0.1
 */