package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "", "appId", "", "versionType", "", "version", "(Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getVersion", "()I", "getVersionType", "compareTo", "other", "component1", "component2", "component3", "copy", "equals", "", "", "hashCode", "toString", "plugin-appbrand-integration_release"})
public final class c$b
  implements Comparable<b>
{
  public final String appId;
  public final int cBU;
  public final int version;
  
  public c$b(String paramString, int paramInt)
  {
    AppMethodBeat.i(280470);
    this.appId = paramString;
    this.cBU = 0;
    this.version = paramInt;
    AppMethodBeat.o(280470);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(280467);
    if ((b)this == paramObject)
    {
      AppMethodBeat.o(280467);
      return true;
    }
    Class localClass2 = getClass();
    if (paramObject != null) {}
    for (Class localClass1 = paramObject.getClass(); (p.h(localClass2, localClass1) ^ true); localClass1 = null)
    {
      AppMethodBeat.o(280467);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl.OccupiedPkgKey");
      AppMethodBeat.o(280467);
      throw paramObject;
    }
    if ((p.h(this.appId, ((b)paramObject).appId) ^ true))
    {
      AppMethodBeat.o(280467);
      return false;
    }
    if (this.cBU != ((b)paramObject).cBU)
    {
      AppMethodBeat.o(280467);
      return false;
    }
    if (this.version != ((b)paramObject).version)
    {
      AppMethodBeat.o(280467);
      return false;
    }
    AppMethodBeat.o(280467);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(280468);
    int i = this.appId.hashCode();
    int j = this.cBU;
    int k = this.version;
    AppMethodBeat.o(280468);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280471);
    String str = "OccupiedPkgKey(appId=" + this.appId + ", versionType=" + this.cBU + ", version=" + this.version + ")";
    AppMethodBeat.o(280471);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.b
 * JD-Core Version:    0.7.0.1
 */