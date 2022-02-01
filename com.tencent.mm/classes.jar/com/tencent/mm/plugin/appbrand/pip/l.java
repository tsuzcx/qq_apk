package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "lastStablePos", "Landroid/graphics/Point;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "plugin-appbrand-integration_release"})
final class l
  extends i
{
  volatile Point qGb;
  
  public l(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    super(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.i(266756);
    AppMethodBeat.o(266756);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(266753);
    kotlin.g.b.p.k(paramh, "callback");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(getAppId()), n.class, (f)new a(this, paramh));
    AppMethodBeat.o(266753);
  }
  
  protected final void g(final Point paramPoint)
  {
    AppMethodBeat.i(266755);
    kotlin.g.b.p.k(paramPoint, "point");
    if (kotlin.g.b.p.h(paramPoint, this.qGb))
    {
      Log.i("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "saveStablePos, same pos");
      AppMethodBeat.o(266755);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new PipStablePos(getAppId(), paramPoint), p.class, (f)new b(this, paramPoint));
    AppMethodBeat.o(266755);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "point", "Landroid/graphics/Point;", "onCallback"})
  static final class a<T>
    implements f<ResultType>
  {
    a(l paraml, h paramh) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements f<ResultType>
  {
    b(l paraml, Point paramPoint) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.l
 * JD-Core Version:    0.7.0.1
 */