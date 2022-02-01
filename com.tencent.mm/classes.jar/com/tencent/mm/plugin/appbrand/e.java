package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.i;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e jvS;
  
  static
  {
    AppMethodBeat.i(188954);
    jvS = new e();
    AppMethodBeat.o(188954);
  }
  
  public static final void a(ae paramae)
  {
    AppMethodBeat.i(188953);
    p.h(paramae, "$this$tryFastLoadEntryPage");
    if (paramae.getRuntime() == null)
    {
      AppMethodBeat.o(188953);
      return;
    }
    Object localObject = paramae.getRuntime();
    p.g(localObject, "this.runtime");
    if (((o)localObject).isDestroyed())
    {
      AppMethodBeat.o(188953);
      return;
    }
    localObject = paramae.getRuntime();
    p.g(localObject, "this.runtime");
    if (((o)localObject).Eb())
    {
      AppMethodBeat.o(188953);
      return;
    }
    if (AppBrandRuntimeWCAccessible.G((AppBrandRuntime)paramae.getRuntime()))
    {
      AppMethodBeat.o(188953);
      return;
    }
    localObject = paramae.getRuntime();
    p.g(localObject, "this.runtime");
    localObject = ((o)localObject).aXe();
    if (localObject != null)
    {
      if (((c)localObject).aXv() != true) {
        AppMethodBeat.o(188953);
      }
    }
    else
    {
      AppMethodBeat.o(188953);
      return;
    }
    if (!paramae.buO())
    {
      AppMethodBeat.o(188953);
      return;
    }
    localObject = paramae.getRuntime();
    p.g(localObject, "this.runtime");
    if ((((o)localObject).aWm() instanceof u))
    {
      AppMethodBeat.o(188953);
      return;
    }
    localObject = paramae.getRuntime();
    p.g(localObject, "this.runtime");
    if (!((o)localObject).aWT())
    {
      localObject = paramae.bux();
      p.g(localObject, "this.actionBar");
      if ((!((b)localObject).isFullscreenMode()) || ((paramae.bur() instanceof k))) {}
      for (int i = 1; (i == 0) && (!paramae.aXv()); i = 0)
      {
        AppMethodBeat.o(188953);
        return;
      }
    }
    localObject = new Boolean[1];
    localObject[0] = Boolean.FALSE;
    final View[] arrayOfView = new View[1];
    final Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(0L);
    paramae.a((f.f)new a(paramae, (Boolean[])localObject, arrayOfLong, arrayOfView));
    View localView = paramae.getContentView();
    if (localView != null)
    {
      localView.post((Runnable)new b(paramae, (Boolean[])localObject, arrayOfView, arrayOfLong));
      AppMethodBeat.o(188953);
      return;
    }
    AppMethodBeat.o(188953);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onReady"})
  static final class a
    implements f.f
  {
    a(ae paramae, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(188951);
      this.jvU[0] = Boolean.TRUE;
      Object localObject1;
      if (arrayOfLong[0].longValue() > 0L)
      {
        long l = arrayOfLong[0].longValue();
        localObject1 = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
        localObject2 = this.jvT.getRuntime();
        p.g(localObject2, "this.runtime");
        ad.i("MicroMsg.AppBrandEntryPageFastLoadHelper", ((o)localObject2).getAppId() + "], time diff: " + (bt.HI() - l));
      }
      Object localObject2 = arrayOfView[0];
      if (localObject2 != null)
      {
        i.cM((View)localObject2);
        localObject1 = localObject2;
        if (!(localObject2 instanceof ThreeDotsLoadingView)) {
          localObject1 = null;
        }
        localObject1 = (ThreeDotsLoadingView)localObject1;
        if (localObject1 != null)
        {
          ((ThreeDotsLoadingView)localObject1).fLK();
          AppMethodBeat.o(188951);
          return;
        }
        AppMethodBeat.o(188951);
        return;
      }
      AppMethodBeat.o(188951);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    implements Runnable
  {
    b(ae paramae, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */