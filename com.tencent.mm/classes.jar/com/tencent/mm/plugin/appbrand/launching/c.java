package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchTask;", "", "instanceId", "", "userName", "versionType", "", "prefetchType", "ts", "", "futureResult", "Lcom/tencent/threadpool/runnable/FutureEx;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp;", "(Ljava/lang/String;Ljava/lang/String;IIJLcom/tencent/threadpool/runnable/FutureEx;)V", "getFutureResult", "()Lcom/tencent/threadpool/runnable/FutureEx;", "getInstanceId", "()Ljava/lang/String;", "getPrefetchType", "()I", "getTs", "()J", "getUserName", "getVersionType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final String eup;
  private final int euz;
  final int sVB;
  final d<AppBrandCgiPrefetchedResp> sVE;
  private final long ts;
  private final String userName;
  
  public c(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, d<AppBrandCgiPrefetchedResp> paramd)
  {
    AppMethodBeat.i(320758);
    this.eup = paramString1;
    this.userName = paramString2;
    this.euz = paramInt1;
    this.sVB = paramInt2;
    this.ts = paramLong;
    this.sVE = paramd;
    AppMethodBeat.o(320758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */