package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
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
    Object localObject = this.iFn.aLK();
    if (localObject != null)
    {
      localObject = ((t)localObject).getCurrentPage();
      if (localObject != null)
      {
        localObject = ((q)localObject).getCurrentPageView();
        if (localObject != null)
        {
          localObject = ((aa)localObject).lbc;
          String str = this.val$message;
          if (((b)localObject).mkl.isRunning())
          {
            b.a locala = ((b)localObject).buy();
            ((b)localObject).buz();
            if (((b)localObject).mkn == null)
            {
              ((b)localObject).mkn = new a(((b)localObject).mkl.getContext());
              ((b)localObject).mkn.b(locala);
            }
            ((b)localObject).mkn.NU(str);
          }
        }
      }
    }
    AppMethodBeat.o(47992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.b.2
 * JD-Core Version:    0.7.0.1
 */