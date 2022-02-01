package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.j;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e kzv;
  
  static
  {
    AppMethodBeat.i(227883);
    kzv = new e();
    AppMethodBeat.o(227883);
  }
  
  public static final void a(ag paramag)
  {
    AppMethodBeat.i(227882);
    p.h(paramag, "$this$tryFastLoadEntryPage");
    if (paramag.getRuntime() == null)
    {
      AppMethodBeat.o(227882);
      return;
    }
    Object localObject = paramag.getRuntime();
    p.g(localObject, "this.runtime");
    if (((q)localObject).isDestroyed())
    {
      AppMethodBeat.o(227882);
      return;
    }
    localObject = paramag.getRuntime();
    p.g(localObject, "this.runtime");
    if (((q)localObject).NA())
    {
      AppMethodBeat.o(227882);
      return;
    }
    if (AppBrandRuntimeWCAccessible.E((AppBrandRuntime)paramag.getRuntime()))
    {
      AppMethodBeat.o(227882);
      return;
    }
    if (!paramag.bRC())
    {
      AppMethodBeat.o(227882);
      return;
    }
    localObject = paramag.getRuntime();
    p.g(localObject, "this.runtime");
    if ((((q)localObject).brK() instanceof aa))
    {
      AppMethodBeat.o(227882);
      return;
    }
    localObject = paramag.getRuntime();
    p.g(localObject, "this.runtime");
    if (!((q)localObject).bsr())
    {
      localObject = paramag.bRi();
      p.g(localObject, "this.actionBar");
      int i;
      if ((!((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).isFullscreenMode()) || ((paramag.bRc() instanceof m)))
      {
        i = 1;
        if (i != 0) {
          break label223;
        }
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(paramag.getAppId());
        if (localObject == null) {
          break label218;
        }
      }
      label218:
      for (localObject = ((QualitySessionRuntime)localObject).nLA;; localObject = null)
      {
        if (localObject == j.nKS) {
          break label223;
        }
        AppMethodBeat.o(227882);
        return;
        i = 0;
        break;
      }
    }
    label223:
    localObject = new Boolean[1];
    localObject[0] = Boolean.FALSE;
    final View[] arrayOfView = new View[1];
    final Long[] arrayOfLong = new Long[1];
    arrayOfLong[0] = Long.valueOf(0L);
    paramag.a((i.f)new a(paramag, (Boolean[])localObject, arrayOfLong, arrayOfView));
    View localView = paramag.getContentView();
    if (localView != null)
    {
      localView.post((Runnable)new b(paramag, (Boolean[])localObject, arrayOfView, arrayOfLong));
      AppMethodBeat.o(227882);
      return;
    }
    AppMethodBeat.o(227882);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onReady"})
  static final class a
    implements i.f
  {
    a(ag paramag, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(227880);
      this.kzx[0] = Boolean.TRUE;
      Object localObject1;
      if (arrayOfLong[0].longValue() > 0L)
      {
        long l = arrayOfLong[0].longValue();
        localObject1 = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
        localObject2 = this.kzw.getRuntime();
        p.g(localObject2, "this.runtime");
        Log.i("MicroMsg.AppBrandEntryPageFastLoadHelper", ((q)localObject2).getAppId() + "], time diff: " + (Util.currentTicks() - l));
      }
      Object localObject2 = arrayOfView[0];
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.appbrand.ui.l.cG((View)localObject2);
        localObject1 = localObject2;
        if (!(localObject2 instanceof ThreeDotsLoadingView)) {
          localObject1 = null;
        }
        localObject1 = (ThreeDotsLoadingView)localObject1;
        if (localObject1 != null)
        {
          ((ThreeDotsLoadingView)localObject1).gZi();
          AppMethodBeat.o(227880);
          return;
        }
        AppMethodBeat.o(227880);
        return;
      }
      AppMethodBeat.o(227880);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    implements Runnable
  {
    b(ag paramag, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */