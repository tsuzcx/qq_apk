package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.ae;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "lastStablePos", "Landroid/graphics/Point;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "plugin-appbrand-integration_release"})
final class l
  extends i
{
  volatile Point mti;
  
  public l(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    super(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.i(223835);
    AppMethodBeat.o(223835);
  }
  
  public final void a(final h paramh)
  {
    AppMethodBeat.i(223833);
    d.g.b.p.h(paramh, "callback");
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)new IPCString(this.appId), n.class, (d)new a(this, paramh));
    AppMethodBeat.o(223833);
  }
  
  protected final void f(final Point paramPoint)
  {
    AppMethodBeat.i(223834);
    d.g.b.p.h(paramPoint, "point");
    if (d.g.b.p.i(paramPoint, this.mti))
    {
      ae.i("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "saveStablePos, same pos");
      AppMethodBeat.o(223834);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)new PipStablePos(this.appId, paramPoint), p.class, (d)new b(this, paramPoint));
    AppMethodBeat.o(223834);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "point", "Landroid/graphics/Point;", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    a(l paraml, h paramh) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements d<ResultType>
  {
    b(l paraml, Point paramPoint) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.l
 * JD-Core Version:    0.7.0.1
 */