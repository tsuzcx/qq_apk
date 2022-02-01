package com.tencent.mm.plugin.comm.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/kvstat/Session;", "", "()V", "asyncTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/threadpool/runnable/FutureEx;", "getAsyncTasks", "()Ljava/util/concurrent/ConcurrentHashMap;", "setAsyncTasks", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "jsonMap", "Lorg/json/JSONArray;", "getJsonMap", "setJsonMap", "kvMap", "getKvMap", "setKvMap", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "getStruct", "()Lcom/tencent/mm/plugin/report/AbsReportStruct;", "setStruct", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)V", "tryCount", "", "getTryCount", "()I", "setTryCount", "(I)V", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  String id;
  int nrQ;
  a xeZ;
  public ConcurrentHashMap<String, Object> xfa;
  ConcurrentHashMap<String, com.tencent.threadpool.i.d<?>> xfb;
  ConcurrentHashMap<String, JSONArray> xfc;
  
  public d()
  {
    AppMethodBeat.i(260546);
    this.id = "";
    this.xfa = new ConcurrentHashMap();
    this.xfb = new ConcurrentHashMap();
    this.xfc = new ConcurrentHashMap();
    AppMethodBeat.o(260546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b.d
 * JD-Core Version:    0.7.0.1
 */