package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.v;

final class k$2
  implements Runnable
{
  k$2(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(123653);
    if (!k.a(this.jlT).isRunning())
    {
      AppMethodBeat.o(123653);
      return;
    }
    Object localObject = k.b(this.jlT);
    if (localObject != null)
    {
      ((View)localObject).scrollTo(0, 0);
      if (k.c(this.jlT) != 0)
      {
        localObject = k.a(this.jlT).iuy;
        if (localObject != null)
        {
          localObject = ((ap)localObject).getContentView();
          if (localObject != null) {
            ((View)localObject).scrollBy(((View)localObject).getScrollX(), -k.c(this.jlT));
          }
        }
      }
      k.d(this.jlT);
    }
    AppMethodBeat.o(123653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.k.2
 * JD-Core Version:    0.7.0.1
 */