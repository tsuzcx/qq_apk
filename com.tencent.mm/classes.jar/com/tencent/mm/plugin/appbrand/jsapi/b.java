package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "addTagWhenFavAnyProcess", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class b
{
  public static final void C(Activity paramActivity)
  {
    AppMethodBeat.i(280667);
    p.k(paramActivity, "activity");
    a.a((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new AddTagWhenFavRequest(), (AppBrandProxyUIProcessTask.b)a.orW);
    AppMethodBeat.o(280667);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/EmptyResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class a<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<EmptyResult>
  {
    public static final a orW;
    
    static
    {
      AppMethodBeat.i(277973);
      orW = new a();
      AppMethodBeat.o(277973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */