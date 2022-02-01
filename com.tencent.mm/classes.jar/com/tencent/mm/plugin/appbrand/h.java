package com.tencent.mm.plugin.appbrand;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class h
{
  public static final h nsH;
  
  static
  {
    AppMethodBeat.i(275373);
    nsH = new h();
    AppMethodBeat.o(275373);
  }
  
  public static final void a(ah paramah)
  {
    AppMethodBeat.i(275372);
    p.k(paramah, "$this$tryFastLoadEntryPage");
    if (paramah.getRuntime() == null)
    {
      AppMethodBeat.o(275372);
      return;
    }
    Object localObject = paramah.getRuntime();
    p.j(localObject, "this.runtime");
    if (((t)localObject).isDestroyed())
    {
      AppMethodBeat.o(275372);
      return;
    }
    localObject = paramah.getRuntime();
    p.j(localObject, "this.runtime");
    if (((t)localObject).Qv())
    {
      AppMethodBeat.o(275372);
      return;
    }
    if (AppBrandRuntimeWCAccessible.F((AppBrandRuntime)paramah.getRuntime()))
    {
      AppMethodBeat.o(275372);
      return;
    }
    if (!paramah.cet())
    {
      AppMethodBeat.o(275372);
      return;
    }
    localObject = paramah.getRuntime();
    p.j(localObject, "this.runtime");
    if ((((t)localObject).bCz() instanceof z))
    {
      AppMethodBeat.o(275372);
      return;
    }
    localObject = paramah.getRuntime();
    p.j(localObject, "this.runtime");
    if (!((t)localObject).bDl())
    {
      localObject = paramah.cdY();
      p.j(localObject, "this.actionBar");
      int i;
      if ((!((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).cne()) || ((paramah.cdS() instanceof n)))
      {
        i = 1;
        if (i != 0) {
          break label223;
        }
        localObject = com.tencent.mm.plugin.appbrand.report.quality.b.amO(paramah.getAppId());
        if (localObject == null) {
          break label218;
        }
      }
      label218:
      for (localObject = ((QualitySessionRuntime)localObject).qNN;; localObject = null)
      {
        if (localObject == com.tencent.mm.plugin.appbrand.report.quality.j.qNe) {
          break label223;
        }
        AppMethodBeat.o(275372);
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
    paramah.a((h.f)new a(paramah, (Boolean[])localObject, arrayOfLong, arrayOfView));
    View localView = paramah.getContentView();
    if (localView != null)
    {
      localView.post((Runnable)new b(paramah, (Boolean[])localObject, arrayOfView, arrayOfLong));
      AppMethodBeat.o(275372);
      return;
    }
    AppMethodBeat.o(275372);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onReady"})
  static final class a
    implements h.f
  {
    a(ah paramah, Boolean[] paramArrayOfBoolean, Long[] paramArrayOfLong, View[] paramArrayOfView) {}
    
    public final void NR()
    {
      AppMethodBeat.i(268019);
      this.nsJ[0] = Boolean.TRUE;
      Object localObject1;
      if (arrayOfLong[0].longValue() > 0L)
      {
        long l = arrayOfLong[0].longValue();
        localObject1 = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
        localObject2 = this.nsI.getRuntime();
        p.j(localObject2, "this.runtime");
        Log.i("MicroMsg.AppBrandEntryPageFastLoadHelper", ((t)localObject2).getAppId() + "], time diff: " + (Util.currentTicks() - l));
      }
      Object localObject2 = arrayOfView[0];
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.appbrand.ui.j.da((View)localObject2);
        localObject1 = localObject2;
        if (!(localObject2 instanceof ThreeDotsLoadingView)) {
          localObject1 = null;
        }
        localObject1 = (ThreeDotsLoadingView)localObject1;
        if (localObject1 != null)
        {
          ((ThreeDotsLoadingView)localObject1).hZY();
          AppMethodBeat.o(268019);
          return;
        }
        AppMethodBeat.o(268019);
        return;
      }
      AppMethodBeat.o(268019);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    implements Runnable
  {
    b(ah paramah, Boolean[] paramArrayOfBoolean, View[] paramArrayOfView, Long[] paramArrayOfLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */