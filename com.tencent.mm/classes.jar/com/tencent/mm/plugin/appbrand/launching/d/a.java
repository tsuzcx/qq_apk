package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "T", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "()V", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
  extends com.tencent.luggage.sdk.f.a<T>
{
  public void a(QualitySession paramQualitySession)
  {
    s.u(paramQualitySession, "qualitySession");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.a
 * JD-Core Version:    0.7.0.1
 */