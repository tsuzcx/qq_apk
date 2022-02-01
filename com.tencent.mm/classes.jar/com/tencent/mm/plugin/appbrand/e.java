package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.ui.t;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e jcJ;
  
  static
  {
    AppMethodBeat.i(187074);
    jcJ = new e();
    AppMethodBeat.o(187074);
  }
  
  public static final void a(ae paramae)
  {
    AppMethodBeat.i(187073);
    d.g.b.k.h(paramae, "$this$tryFastLoadEntryPage");
    if (paramae.getRuntime() == null)
    {
      AppMethodBeat.o(187073);
      return;
    }
    Object localObject = paramae.getRuntime();
    d.g.b.k.g(localObject, "this.runtime");
    if (((o)localObject).isDestroyed())
    {
      AppMethodBeat.o(187073);
      return;
    }
    localObject = paramae.getRuntime();
    d.g.b.k.g(localObject, "this.runtime");
    if (((o)localObject).CC())
    {
      AppMethodBeat.o(187073);
      return;
    }
    if (AppBrandRuntimeWCAccessible.J((AppBrandRuntime)paramae.getRuntime()))
    {
      AppMethodBeat.o(187073);
      return;
    }
    localObject = paramae.getRuntime();
    d.g.b.k.g(localObject, "this.runtime");
    localObject = ((o)localObject).aTU();
    if (localObject != null)
    {
      if (((c)localObject).aUm() != true) {
        AppMethodBeat.o(187073);
      }
    }
    else
    {
      AppMethodBeat.o(187073);
      return;
    }
    if (!paramae.bqO())
    {
      AppMethodBeat.o(187073);
      return;
    }
    localObject = paramae.getRuntime();
    d.g.b.k.g(localObject, "this.runtime");
    if ((((o)localObject).aSY() instanceof t))
    {
      AppMethodBeat.o(187073);
      return;
    }
    localObject = paramae.getRuntime();
    d.g.b.k.g(localObject, "this.runtime");
    if (!((o)localObject).aTJ())
    {
      localObject = paramae.bqy();
      d.g.b.k.g(localObject, "this.actionBar");
      if ((!((b)localObject).isFullscreenMode()) || ((paramae.bqs() instanceof com.tencent.mm.plugin.appbrand.page.k))) {}
      for (int i = 1; (i == 0) && (!paramae.aUm()); i = 0)
      {
        AppMethodBeat.o(187073);
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
      AppMethodBeat.o(187073);
      return;
    }
    AppMethodBeat.o(187073);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onReady"})
  static final class a
    implements f.f
  {
    a(ae paramae, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(187071);
      this.jcL[0] = Boolean.TRUE;
      Object localObject1;
      if (arrayOfLong[0].longValue() > 0L)
      {
        long l = arrayOfLong[0].longValue();
        localObject1 = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
        localObject2 = this.jcK.getRuntime();
        d.g.b.k.g(localObject2, "this.runtime");
        ac.i("MicroMsg.AppBrandEntryPageFastLoadHelper", ((o)localObject2).getAppId() + "], time diff: " + (bs.Gn() - l));
      }
      Object localObject2 = arrayOfView[0];
      if (localObject2 != null)
      {
        h.cK((View)localObject2);
        localObject1 = localObject2;
        if (!(localObject2 instanceof ThreeDotsLoadingView)) {
          localObject1 = null;
        }
        localObject1 = (ThreeDotsLoadingView)localObject1;
        if (localObject1 != null)
        {
          ((ThreeDotsLoadingView)localObject1).fuX();
          AppMethodBeat.o(187071);
          return;
        }
        AppMethodBeat.o(187071);
        return;
      }
      AppMethodBeat.o(187071);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    implements Runnable
  {
    b(ae paramae, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */