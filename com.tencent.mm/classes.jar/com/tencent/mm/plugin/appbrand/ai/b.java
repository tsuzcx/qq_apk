package com.tencent.mm.plugin.appbrand.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/worker/AppBrandWorkerInfo;", "", "()V", "createFailErrorMsg", "", "getCreateFailErrorMsg", "()Ljava/lang/String;", "setCreateFailErrorMsg", "(Ljava/lang/String;)V", "engineCreateTimestamp", "Lkotlin/Pair;", "", "getEngineCreateTimestamp", "()Lkotlin/Pair;", "setEngineCreateTimestamp", "(Lkotlin/Pair;)V", "id", "", "getId", "()I", "setId", "(I)V", "jsCreateWorkTime", "getJsCreateWorkTime", "()J", "setJsCreateWorkTime", "(J)V", "jsInjectCost", "getJsInjectCost", "setJsInjectCost", "params", "getParams", "setParams", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getService", "()Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "setService", "(Lcom/tencent/mm/plugin/appbrand/AppBrandService;)V", "serviceCreateWorkerTime", "getServiceCreateWorkerTime", "setServiceCreateWorkerTime", "startInject", "getStartInject", "setStartInject", "workerEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "getWorkerEngine", "()Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "setWorkerEngine", "(Lcom/tencent/mm/appbrand/v8/V8ContextEngine;)V", "toString", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public int id;
  public m qqS;
  public y qqV;
  public long qqX;
  public long qxn;
  public String rRQ;
  public r<Long, Long> uSm;
  public String uSn;
  public long uSo;
  public long uSp;
  
  public b()
  {
    AppMethodBeat.i(317827);
    this.id = 2147483647;
    this.uSm = new r(Long.valueOf(-1L), Long.valueOf(-1L));
    this.qqX = -1L;
    this.qxn = -1L;
    AppMethodBeat.o(317827);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(317833);
    String str = "AppBrandWorkerInfo(id=" + this.id + ", workerEngine=" + this.qqS + ", engineCreateTimestamp=" + this.uSm + ", createFailErrorMsg=" + this.uSn + ", jsInjectCost=" + this.qqX + ", startInject=" + this.qxn + ", service=" + this.qqV + ')';
    AppMethodBeat.o(317833);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai.b
 * JD-Core Version:    0.7.0.1
 */