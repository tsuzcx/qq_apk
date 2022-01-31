package com.tencent.mm.plugin.appbrand.game.f;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.ui.o;

final class c$1
  implements Runnable
{
  c$1(c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(143178);
    Object localObject = this.htH;
    if (d.a.Es(this.htG) == d.a.iAm) {}
    for (boolean bool = true;; bool = false)
    {
      c.a((c)localObject, bool);
      if ((this.htH.getContext() instanceof Activity))
      {
        localObject = ((Activity)this.htH.getContext()).getWindow();
        if (localObject != null) {
          o.a((Window)localObject, c.a(this.htH));
        }
      }
      AppMethodBeat.o(143178);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c.1
 * JD-Core Version:    0.7.0.1
 */