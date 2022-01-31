package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.bu.a;
import com.tencent.mm.g.a.bu.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends c<bu>
  implements f
{
  private bu mFJ;
  private boolean mFK;
  
  public b()
  {
    AppMethodBeat.i(41425);
    this.mFK = false;
    this.__eventId = bu.class.getName().hashCode();
    AppMethodBeat.o(41425);
  }
  
  private boolean a(bu parambu)
  {
    AppMethodBeat.i(41426);
    if (!g.RG())
    {
      ab.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
      AppMethodBeat.o(41426);
      return false;
    }
    this.mFK = false;
    if ((parambu instanceof bu))
    {
      this.mFJ = parambu;
      ab.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
      g.RM();
      g.RK().eHt.a(385, this);
      parambu = new d(parambu.cpi.cpk);
      g.RM();
      g.RK().eHt.a(parambu, 0);
      AppMethodBeat.o(41426);
      return true;
    }
    AppMethodBeat.o(41426);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41427);
    if ((paramm instanceof d))
    {
      paramm = new bu.b();
      ab.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label144;
      }
      ab.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
    }
    for (paramm.retCode = 0;; paramm.retCode = paramInt2)
    {
      g.RM();
      g.RK().eHt.b(385, this);
      this.mFJ.cpj = paramm;
      this.mFK = true;
      if (this.mFJ.callback != null) {
        this.mFJ.callback.run();
      }
      if (this.mFK) {
        this.mFJ = null;
      }
      AppMethodBeat.o(41427);
      return;
      label144:
      ab.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.b
 * JD-Core Version:    0.7.0.1
 */