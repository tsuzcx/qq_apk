package com.tencent.mm.plugin.appbrand.page;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
final class b$b
  implements View.OnTouchListener
{
  b$b(View paramView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219685);
    if (this.nns != null)
    {
      this.nns.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(219685);
      return true;
    }
    AppMethodBeat.o(219685);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.b
 * JD-Core Version:    0.7.0.1
 */