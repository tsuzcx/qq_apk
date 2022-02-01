package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "", "userName", "", "appId", "versionType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getUserName", "getVersionType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-appbrand-integration_release"})
final class aq
{
  final String appId;
  final int iOo;
  final String userName;
  
  public aq(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(228131);
    this.userName = paramString1;
    this.appId = paramString2;
    this.iOo = paramInt;
    AppMethodBeat.o(228131);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(228134);
    if (this != paramObject)
    {
      if ((paramObject instanceof aq))
      {
        paramObject = (aq)paramObject;
        if ((!p.j(this.userName, paramObject.userName)) || (!p.j(this.appId, paramObject.appId)) || (this.iOo != paramObject.iOo)) {}
      }
    }
    else
    {
      AppMethodBeat.o(228134);
      return true;
    }
    AppMethodBeat.o(228134);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(228133);
    String str = this.userName;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.appId;
      if (str != null) {
        j = str.hashCode();
      }
      int k = this.iOo;
      AppMethodBeat.o(228133);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(228132);
    String str = "WxaInfo(userName=" + this.userName + ", appId=" + this.appId + ", versionType=" + this.iOo + ")";
    AppMethodBeat.o(228132);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.aq
 * JD-Core Version:    0.7.0.1
 */