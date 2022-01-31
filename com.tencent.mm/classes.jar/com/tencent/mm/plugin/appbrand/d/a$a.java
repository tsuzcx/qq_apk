package com.tencent.mm.plugin.appbrand.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "appId", "", "appName", "appType", "", "appVersion", "(Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getAppName", "getAppType", "()I", "getAppVersion", "compareTo", "other", "equals", "", "", "hashCode", "Companion", "plugin-appbrand-integration_release"})
final class a$a
  implements Comparable<a>
{
  public static final a.a.a hkW;
  final String appId;
  final String appName;
  final int bDc;
  private final int edl;
  
  static
  {
    AppMethodBeat.i(154889);
    hkW = new a.a.a((byte)0);
    AppMethodBeat.o(154889);
  }
  
  public a$a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154888);
    this.appId = paramString1;
    this.appName = paramString2;
    this.edl = paramInt1;
    this.bDc = paramInt2;
    AppMethodBeat.o(154888);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(154884);
    j.q(parama, "other");
    int j = this.appId.compareTo(parama.appId);
    int i = j;
    if (j == 0) {
      i = this.edl - parama.edl;
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (j.a.nk(this.edl)) {
        j = this.bDc - parama.bDc;
      }
    }
    AppMethodBeat.o(154884);
    return j;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(154887);
    if (((paramObject instanceof a)) && (a((a)paramObject) == 0))
    {
      AppMethodBeat.o(154887);
      return true;
    }
    AppMethodBeat.o(154887);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(154886);
    int i = ("[" + this.appId + "::" + this.edl + "::" + this.bDc + ']').hashCode();
    AppMethodBeat.o(154886);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a.a
 * JD-Core Version:    0.7.0.1
 */