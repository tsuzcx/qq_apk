package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e iCJ;
  
  static
  {
    AppMethodBeat.i(196218);
    iCJ = new e();
    AppMethodBeat.o(196218);
  }
  
  public static final void a(ae paramae)
  {
    AppMethodBeat.i(196217);
    k.h(paramae, "$this$tryFastLoadEntryPage");
    if (paramae.getRuntime() == null)
    {
      AppMethodBeat.o(196217);
      return;
    }
    Object localObject = paramae.getRuntime();
    k.g(localObject, "this.runtime");
    if (((o)localObject).isDestroyed())
    {
      AppMethodBeat.o(196217);
      return;
    }
    localObject = paramae.getRuntime();
    k.g(localObject, "this.runtime");
    if (((o)localObject).CZ())
    {
      AppMethodBeat.o(196217);
      return;
    }
    if (AppBrandRuntimeWCAccessible.J((AppBrandRuntime)paramae.getRuntime()))
    {
      AppMethodBeat.o(196217);
      return;
    }
    localObject = paramae.getRuntime();
    k.g(localObject, "this.runtime");
    localObject = ((o)localObject).aNe();
    if (localObject != null)
    {
      if (((c)localObject).aNw() != true) {
        AppMethodBeat.o(196217);
      }
    }
    else
    {
      AppMethodBeat.o(196217);
      return;
    }
    if (!paramae.bjX())
    {
      AppMethodBeat.o(196217);
      return;
    }
    localObject = paramae.getRuntime();
    k.g(localObject, "this.runtime");
    if ((((o)localObject).aMi() instanceof u))
    {
      AppMethodBeat.o(196217);
      return;
    }
    localObject = paramae.getRuntime();
    k.g(localObject, "this.runtime");
    if (!((o)localObject).aMT())
    {
      localObject = paramae.bjH();
      k.g(localObject, "this.actionBar");
      if ((!((b)localObject).isFullscreenMode()) || ((paramae.bjB() instanceof j))) {}
      for (int i = 1; (i == 0) && (!paramae.aNw()); i = 0)
      {
        AppMethodBeat.o(196217);
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
      AppMethodBeat.o(196217);
      return;
    }
    AppMethodBeat.o(196217);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onReady"})
  static final class a
    implements f.f
  {
    a(ae paramae, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(196215);
      this.iCL[0] = Boolean.TRUE;
      Object localObject1;
      if (arrayOfLong[0].longValue() > 0L)
      {
        long l = arrayOfLong[0].longValue();
        localObject1 = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
        localObject2 = this.iCK.getRuntime();
        k.g(localObject2, "this.runtime");
        ad.i("MicroMsg.AppBrandEntryPageFastLoadHelper", ((o)localObject2).getAppId() + "], time diff: " + (bt.GC() - l));
      }
      Object localObject2 = arrayOfView[0];
      if (localObject2 != null)
      {
        h.cI((View)localObject2);
        localObject1 = localObject2;
        if (!(localObject2 instanceof ThreeDotsLoadingView)) {
          localObject1 = null;
        }
        localObject1 = (ThreeDotsLoadingView)localObject1;
        if (localObject1 != null)
        {
          ((ThreeDotsLoadingView)localObject1).ffc();
          AppMethodBeat.o(196215);
          return;
        }
        AppMethodBeat.o(196215);
        return;
      }
      AppMethodBeat.o(196215);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    implements Runnable
  {
    b(ae paramae, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */