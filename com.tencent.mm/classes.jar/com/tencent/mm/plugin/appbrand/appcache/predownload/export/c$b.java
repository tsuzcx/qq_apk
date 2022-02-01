package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "", "appId", "", "versionType", "", "version", "(Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getVersion", "()I", "getVersionType", "compareTo", "other", "component1", "component2", "component3", "copy", "equals", "", "", "hashCode", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  implements Comparable<b>
{
  public final String appId;
  public final int euz;
  public final int version;
  
  public c$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(320527);
    this.appId = paramString;
    this.euz = 0;
    this.version = paramInt;
    AppMethodBeat.o(320527);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(320534);
    if (this == paramObject)
    {
      AppMethodBeat.o(320534);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(320534);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl.OccupiedPkgKey");
      AppMethodBeat.o(320534);
      throw paramObject;
    }
    if (!s.p(this.appId, ((b)paramObject).appId))
    {
      AppMethodBeat.o(320534);
      return false;
    }
    if (this.euz != ((b)paramObject).euz)
    {
      AppMethodBeat.o(320534);
      return false;
    }
    if (this.version != ((b)paramObject).version)
    {
      AppMethodBeat.o(320534);
      return false;
    }
    AppMethodBeat.o(320534);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(320540);
    int i = this.appId.hashCode();
    int j = this.euz;
    int k = this.version;
    AppMethodBeat.o(320540);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320547);
    String str = "OccupiedPkgKey(appId=" + this.appId + ", versionType=" + this.euz + ", version=" + this.version + ')';
    AppMethodBeat.o(320547);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.b
 * JD-Core Version:    0.7.0.1
 */