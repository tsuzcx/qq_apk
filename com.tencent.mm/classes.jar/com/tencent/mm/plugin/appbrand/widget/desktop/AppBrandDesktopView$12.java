package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import java.util.ArrayList;
import java.util.List;

final class AppBrandDesktopView$12
  implements Runnable
{
  AppBrandDesktopView$12(AppBrandDesktopView paramAppBrandDesktopView) {}
  
  public final void run()
  {
    AppMethodBeat.i(143654);
    if ((AppBrandDesktopView.s(this.jfg)) && (AppBrandDesktopView.t(this.jfg)))
    {
      if (AppBrandDesktopView.f(this.jfg) == null)
      {
        AppMethodBeat.o(143654);
        return;
      }
      Object localObject1 = AppBrandDesktopView.f(this.jfg).getShowList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      Object localObject2;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (AppBrandDesktopView.c)((List)localObject1).get(i);
        if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).jfk != null))
        {
          localObject2 = new a(((AppBrandDesktopView.c)localObject2).jfk);
          ((a)localObject2).position = i;
          localArrayList.add(localObject2);
        }
        i += 1;
      }
      localObject1 = new ArrayList();
      i = AppBrandDesktopView.g(this.jfg);
      while (i < AppBrandDesktopView.n(this.jfg).size())
      {
        localObject2 = (AppBrandDesktopView.c)AppBrandDesktopView.n(this.jfg).get(i);
        if ((localObject2 != null) && (((AppBrandDesktopView.c)localObject2).type == 1))
        {
          localObject2 = new a(((AppBrandDesktopView.c)localObject2).jfk);
          ((a)localObject2).position = i;
          ((List)localObject1).add(localObject2);
        }
        i += 1;
      }
      b.g(localArrayList, (List)localObject1);
    }
    AppMethodBeat.o(143654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.12
 * JD-Core Version:    0.7.0.1
 */