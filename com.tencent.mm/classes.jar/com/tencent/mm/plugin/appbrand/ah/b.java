package com.tencent.mm.plugin.appbrand.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/worker/AppBrandWorkerInfo;", "", "()V", "createFailErrorMsg", "", "getCreateFailErrorMsg", "()Ljava/lang/String;", "setCreateFailErrorMsg", "(Ljava/lang/String;)V", "engineCreateTimestamp", "Lkotlin/Pair;", "", "getEngineCreateTimestamp", "()Lkotlin/Pair;", "setEngineCreateTimestamp", "(Lkotlin/Pair;)V", "id", "", "getId", "()I", "setId", "(I)V", "jsInjectCost", "getJsInjectCost", "()J", "setJsInjectCost", "(J)V", "startInject", "getStartInject", "setStartInject", "workerEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getWorkerEngine", "()Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "setWorkerEngine", "(Lcom/tencent/mm/appbrand/v8/V8ContextEngine;)V", "luggage-wxa-app_release"})
public final class b
{
  public int id;
  public m nsn;
  public long nss;
  public long nxY;
  public o<Long, Long> rGX;
  public String rGY;
  
  public b()
  {
    AppMethodBeat.i(243408);
    this.id = 2147483647;
    this.rGX = new o(Long.valueOf(-1L), Long.valueOf(-1L));
    this.nss = -1L;
    this.nxY = -1L;
    AppMethodBeat.o(243408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.b
 * JD-Core Version:    0.7.0.1
 */