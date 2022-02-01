package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e jyN;
  
  static
  {
    AppMethodBeat.i(223187);
    jyN = new e();
    AppMethodBeat.o(223187);
  }
  
  public static final void a(ad paramad)
  {
    AppMethodBeat.i(223186);
    d.g.b.p.h(paramad, "$this$tryFastLoadEntryPage");
    if (paramad.getRuntime() == null)
    {
      AppMethodBeat.o(223186);
      return;
    }
    Object localObject = paramad.getRuntime();
    d.g.b.p.g(localObject, "this.runtime");
    if (((p)localObject).isDestroyed())
    {
      AppMethodBeat.o(223186);
      return;
    }
    localObject = paramad.getRuntime();
    d.g.b.p.g(localObject, "this.runtime");
    if (((p)localObject).Ee())
    {
      AppMethodBeat.o(223186);
      return;
    }
    if (AppBrandRuntimeWCAccessible.E((AppBrandRuntime)paramad.getRuntime()))
    {
      AppMethodBeat.o(223186);
      return;
    }
    localObject = paramad.getRuntime();
    d.g.b.p.g(localObject, "this.runtime");
    localObject = ((p)localObject).aXz();
    if (localObject != null)
    {
      if (((c)localObject).aXQ() != true) {
        AppMethodBeat.o(223186);
      }
    }
    else
    {
      AppMethodBeat.o(223186);
      return;
    }
    if (!paramad.bvA())
    {
      AppMethodBeat.o(223186);
      return;
    }
    localObject = paramad.getRuntime();
    d.g.b.p.g(localObject, "this.runtime");
    if ((((p)localObject).aWN() instanceof v))
    {
      AppMethodBeat.o(223186);
      return;
    }
    localObject = paramad.getRuntime();
    d.g.b.p.g(localObject, "this.runtime");
    if (!((p)localObject).aXo())
    {
      localObject = paramad.bvi();
      d.g.b.p.g(localObject, "this.actionBar");
      if ((!((b)localObject).isFullscreenMode()) || ((paramad.bvc() instanceof com.tencent.mm.plugin.appbrand.page.j))) {}
      for (int i = 1; (i == 0) && (!paramad.aXQ()); i = 0)
      {
        AppMethodBeat.o(223186);
        return;
      }
    }
    localObject = new Boolean[1];
    localObject[0] = Boolean.FALSE;
    final View[] arrayOfView = new View[1];
    final Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(0L);
    paramad.a((f.f)new a(paramad, (Boolean[])localObject, arrayOfLong, arrayOfView));
    View localView = paramad.getContentView();
    if (localView != null)
    {
      localView.post((Runnable)new b(paramad, (Boolean[])localObject, arrayOfView, arrayOfLong));
      AppMethodBeat.o(223186);
      return;
    }
    AppMethodBeat.o(223186);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onReady"})
  static final class a
    implements f.f
  {
    a(ad paramad, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(223184);
      this.jyP[0] = Boolean.TRUE;
      Object localObject1;
      if (arrayOfLong[0].longValue() > 0L)
      {
        long l = arrayOfLong[0].longValue();
        localObject1 = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
        localObject2 = this.jyO.getRuntime();
        d.g.b.p.g(localObject2, "this.runtime");
        ae.i("MicroMsg.AppBrandEntryPageFastLoadHelper", ((p)localObject2).getAppId() + "], time diff: " + (bu.HQ() - l));
      }
      Object localObject2 = arrayOfView[0];
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.appbrand.ui.j.cN((View)localObject2);
        localObject1 = localObject2;
        if (!(localObject2 instanceof ThreeDotsLoadingView)) {
          localObject1 = null;
        }
        localObject1 = (ThreeDotsLoadingView)localObject1;
        if (localObject1 != null)
        {
          ((ThreeDotsLoadingView)localObject1).fQe();
          AppMethodBeat.o(223184);
          return;
        }
        AppMethodBeat.o(223184);
        return;
      }
      AppMethodBeat.o(223184);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    implements Runnable
  {
    b(ad paramad, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */