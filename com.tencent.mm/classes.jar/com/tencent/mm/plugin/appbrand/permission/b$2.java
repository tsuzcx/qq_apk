package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.plugin.appbrand.widget.f.b;
import com.tencent.mm.plugin.appbrand.widget.f.b.a;
import com.tencent.mm.plugin.appbrand.widget.f.f;

final class b$2
  implements Runnable
{
  b$2(i parami, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(132506);
    Object localObject = this.gQE.atj();
    if (localObject != null)
    {
      localObject = ((r)localObject).getCurrentPage();
      if (localObject != null)
      {
        localObject = ((o)localObject).getCurrentPageView();
        if (localObject != null)
        {
          localObject = ((v)localObject).ixr;
          String str = this.val$message;
          if (((b)localObject).jug.isRunning())
          {
            b.a locala = ((b)localObject).aSg();
            if (((b)localObject).jui == null)
            {
              ((b)localObject).jui = new a(((b)localObject).jug.getContext());
              ((b)localObject).jui.a(locala);
            }
            ((b)localObject).jui.FX(str);
          }
        }
      }
    }
    AppMethodBeat.o(132506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b.2
 * JD-Core Version:    0.7.0.1
 */