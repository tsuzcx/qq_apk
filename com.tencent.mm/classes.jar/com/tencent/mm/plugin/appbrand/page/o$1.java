package com.tencent.mm.plugin.appbrand.page;

import android.util.Log;
import android.view.MotionEvent;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

final class o$1
  implements SwipeBackLayout.a
{
  o$1(o paramo) {}
  
  public final boolean aZ(boolean paramBoolean)
  {
    return false;
  }
  
  public final void g(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87069);
    o localo;
    if (paramInt != 0)
    {
      o.a(this.iwb, true);
      localo = o.a(this.iwb).e(this.iwb);
      if (Float.compare(1.0F, paramFloat) > 0) {
        break label157;
      }
      if (this.iwb.ivZ[0] == 0)
      {
        if (localo != null) {
          o.ct(o.b(localo));
        }
        localo = this.iwb;
        d.d("MicroMsg.AppBrandPage", "onSwipeBack %s", new Object[] { Log.getStackTraceString(new Throwable()) });
        localo.mSwiping = true;
        localo.post(new o.2(localo));
        this.iwb.ivZ[0] = true;
      }
    }
    for (;;)
    {
      d.v("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(87069);
      return;
      o.a(this.iwb, false);
      break;
      label157:
      if (localo != null) {
        o.a(localo, paramFloat);
      }
    }
  }
  
  public final void l(MotionEvent paramMotionEvent) {}
  
  public final void uA() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.1
 * JD-Core Version:    0.7.0.1
 */