package com.tencent.mm.plugin.appbrand.page;

import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.f.b.a;

final class h$3
  implements Runnable
{
  h$3(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(141654);
    Object localObject2 = this.ivQ.getCurrentPageView();
    if (localObject2 == null)
    {
      AppMethodBeat.o(141654);
      return;
    }
    Object localObject1 = ((v)localObject2).getActionBar();
    if (localObject1 == null)
    {
      AppMethodBeat.o(141654);
      return;
    }
    localObject2 = ((v)localObject2).ixr;
    int i = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getTop();
    i = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).getMeasuredHeight() + i;
    localObject1 = ((com.tencent.mm.plugin.appbrand.widget.f.b)localObject2).aSf();
    if ((localObject1 != null) && ((((b.a)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((b.a)localObject1).getLayoutParams();
      if (i != ((ViewGroup.MarginLayoutParams)localObject2).topMargin)
      {
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = i;
        ((b.a)localObject1).requestLayout();
      }
    }
    AppMethodBeat.o(141654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h.3
 * JD-Core Version:    0.7.0.1
 */