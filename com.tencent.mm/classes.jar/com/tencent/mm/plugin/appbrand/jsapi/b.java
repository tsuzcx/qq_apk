package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "addTagWhenFavAnyProcess", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final void I(Activity paramActivity)
  {
    AppMethodBeat.i(325631);
    s.u(paramActivity, "activity");
    a.a((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new AddTagWhenFavRequest(), b..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(325631);
  }
  
  private static final void a(EmptyResult paramEmptyResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */