package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogicWC;", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosLogic;", "appId", "", "pipContainerView", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/widget/AppBrandPipContainerView;)V", "lastStablePos", "Landroid/graphics/Point;", "getStablePosAsync", "", "callback", "Lcom/tencent/mm/plugin/appbrand/pip/AppBrandPipStablePosCallback;", "saveStablePos", "point", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class m
  extends j
{
  private volatile Point tKQ;
  
  public m(String paramString, AppBrandPipContainerView paramAppBrandPipContainerView)
  {
    super(paramString, paramAppBrandPipContainerView);
    AppMethodBeat.i(319627);
    AppMethodBeat.o(319627);
  }
  
  private static final void a(m paramm, Point paramPoint, IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(319643);
    s.u(paramm, "this$0");
    s.u(paramPoint, "$point");
    paramm.tKQ = paramPoint;
    AppMethodBeat.o(319643);
  }
  
  private static final void a(m paramm, i parami, Point paramPoint)
  {
    AppMethodBeat.i(319635);
    s.u(paramm, "this$0");
    s.u(parami, "$callback");
    paramm.tKQ = paramPoint;
    parami.g(paramPoint);
    AppMethodBeat.o(319635);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(319657);
    s.u(parami, "callback");
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(getAppId()), o.class, new m..ExternalSyntheticLambda1(this, parami));
    AppMethodBeat.o(319657);
  }
  
  protected final void h(Point paramPoint)
  {
    AppMethodBeat.i(319660);
    s.u(paramPoint, "point");
    if (s.p(paramPoint, this.tKQ))
    {
      Log.i("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "saveStablePos, same pos");
      AppMethodBeat.o(319660);
      return;
    }
    com.tencent.mm.ipcinvoker.j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new PipStablePos(getAppId(), paramPoint), q.class, new m..ExternalSyntheticLambda0(this, paramPoint));
    AppMethodBeat.o(319660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.m
 * JD-Core Version:    0.7.0.1
 */