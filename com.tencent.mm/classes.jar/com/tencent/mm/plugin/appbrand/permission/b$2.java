package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.plugin.appbrand.widget.e.b.a;
import com.tencent.mm.plugin.appbrand.widget.e.f;

final class b$2
  implements Runnable
{
  b$2(AppBrandRuntime paramAppBrandRuntime, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(47992);
    Object localObject = this.jyv.aVN();
    if (localObject != null)
    {
      localObject = ((u)localObject).getCurrentPage();
      if (localObject != null)
      {
        localObject = ((r)localObject).getCurrentPageView();
        if (localObject != null)
        {
          localObject = ((aa)localObject).mcc;
          String str = this.val$message;
          if (((b)localObject).nmH.isRunning())
          {
            b.a locala = ((b)localObject).bFx();
            ((b)localObject).bFy();
            if (((b)localObject).nmJ == null)
            {
              ((b)localObject).nmJ = new a(((b)localObject).nmH.getContext());
              ((b)localObject).nmJ.b(locala);
            }
            ((b)localObject).nmJ.VA(str);
          }
        }
      }
    }
    AppMethodBeat.o(47992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b.2
 * JD-Core Version:    0.7.0.1
 */