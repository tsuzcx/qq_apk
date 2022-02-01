package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.mmsight.SightParams;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$Companion;", "", "()V", "getSightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "sightMode", "", "maxDuration", "isFront", "", "plugin-appbrand-integration_release"})
public final class GetSightParamsIPCTask$a
{
  public static SightParams q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(180477);
    Object localObject = XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new GetSightParamsIPCTask.TaskParams(paramInt1, paramInt2, paramBoolean), GetSightParamsIPCTask.class);
    p.j(localObject, "XIPCInvoker.invokeSync(\n…aramsIPCTask::class.java)");
    localObject = (SightParams)localObject;
    AppMethodBeat.o(180477);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask.a
 * JD-Core Version:    0.7.0.1
 */