package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "", "userName", "", "appId", "versionType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getUserName", "getVersionType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-appbrand-integration_release"})
final class aq
{
  final String appId;
  final int cBU;
  final String userName;
  
  public aq(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(273641);
    this.userName = paramString1;
    this.appId = paramString2;
    this.cBU = paramInt;
    AppMethodBeat.o(273641);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(273647);
    if (this != paramObject)
    {
      if ((paramObject instanceof aq))
      {
        paramObject = (aq)paramObject;
        if ((!p.h(this.userName, paramObject.userName)) || (!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU)) {}
      }
    }
    else
    {
      AppMethodBeat.o(273647);
      return true;
    }
    AppMethodBeat.o(273647);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(273645);
    String str = this.userName;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.appId;
      if (str != null) {
        j = str.hashCode();
      }
      int k = this.cBU;
      AppMethodBeat.o(273645);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(273643);
    String str = "WxaInfo(userName=" + this.userName + ", appId=" + this.appId + ", versionType=" + this.cBU + ")";
    AppMethodBeat.o(273643);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aq
 * JD-Core Version:    0.7.0.1
 */