package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "lastStablePos", "Landroid/graphics/Point;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "plugin-appbrand-integration_release"})
final class l
  extends i
{
  volatile Point nDQ;
  
  public l(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    super(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.i(229267);
    AppMethodBeat.o(229267);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(229265);
    kotlin.g.b.p.h(paramh, "callback");
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(this.appId), n.class, (d)new a(this, paramh));
    AppMethodBeat.o(229265);
  }
  
  protected final void g(final Point paramPoint)
  {
    AppMethodBeat.i(229266);
    kotlin.g.b.p.h(paramPoint, "point");
    if (kotlin.g.b.p.j(paramPoint, this.nDQ))
    {
      Log.i("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "saveStablePos, same pos");
      AppMethodBeat.o(229266);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)new PipStablePos(this.appId, paramPoint), p.class, (d)new b(this, paramPoint));
    AppMethodBeat.o(229266);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "point", "Landroid/graphics/Point;", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    a(l paraml, h paramh) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    b(l paraml, Point paramPoint) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.l
 * JD-Core Version:    0.7.0.1
 */