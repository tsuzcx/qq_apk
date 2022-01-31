package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements b.a
{
  e$1(e parame) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113456);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113456);
      return false;
    }
    ab.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    e.a(this.ocx);
    e.a(this.ocx, paramDouble2);
    e.b(this.ocx, paramFloat2);
    e.c(this.ocx, paramFloat1);
    if (e.b(this.ocx) != null)
    {
      if (e.c(this.ocx)) {
        break label207;
      }
      e.d(this.ocx);
      e.b(this.ocx).addPinView(this.ocx, e.e(this.ocx), e.f(this.ocx));
    }
    for (;;)
    {
      if (e.g(this.ocx) != null) {
        e.g(this.ocx).a(paramBoolean, paramFloat1, paramFloat2, paramInt, paramDouble1, paramDouble2, paramDouble3);
      }
      this.ocx.invalidate();
      this.ocx.postInvalidate();
      this.ocx.requestLayout();
      e.h(this.ocx);
      AppMethodBeat.o(113456);
      return true;
      label207:
      e.b(this.ocx).updateLocaitonPinLayout(this.ocx, e.e(this.ocx), e.f(this.ocx));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e.1
 * JD-Core Version:    0.7.0.1
 */