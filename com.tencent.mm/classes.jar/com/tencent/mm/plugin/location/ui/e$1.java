package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  implements a.a
{
  e$1(e parame) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    if (e.a(this.lFj)) {
      return false;
    }
    y.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
    e.b(this.lFj);
    e.a(this.lFj, paramDouble2);
    e.b(this.lFj, paramFloat2);
    e.c(this.lFj, paramFloat1);
    if (e.c(this.lFj) != null)
    {
      if (e.d(this.lFj)) {
        break label204;
      }
      e.e(this.lFj);
      e.c(this.lFj).addPinView(this.lFj, e.f(this.lFj), e.g(this.lFj));
    }
    for (;;)
    {
      if (e.h(this.lFj) != null) {
        e.h(this.lFj).a(paramBoolean, paramFloat1, paramFloat2, paramInt, paramDouble1, paramDouble2, paramDouble3);
      }
      this.lFj.invalidate();
      this.lFj.postInvalidate();
      this.lFj.requestLayout();
      e.i(this.lFj);
      return true;
      label204:
      e.c(this.lFj).updateLocaitonPinLayout(this.lFj, e.f(this.lFj), e.g(this.lFj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e.1
 * JD-Core Version:    0.7.0.1
 */