package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.mmsight.SightParams;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$Companion;", "", "()V", "getSightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "sightMode", "", "maxDuration", "isFront", "", "plugin-appbrand-integration_release"})
public final class GetSightParamsIPCTask$a
{
  public static SightParams o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(180477);
    Object localObject = XIPCInvoker.a("com.tencent.mm", new GetSightParamsIPCTask.TaskParams(paramInt1, paramInt2, paramBoolean), GetSightParamsIPCTask.class);
    p.g(localObject, "XIPCInvoker.invokeSync(\n…aramsIPCTask::class.java)");
    localObject = (SightParams)localObject;
    AppMethodBeat.o(180477);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask.a
 * JD-Core Version:    0.7.0.1
 */