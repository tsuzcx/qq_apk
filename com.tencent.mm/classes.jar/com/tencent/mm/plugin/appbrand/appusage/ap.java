package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaInfo;", "", "userName", "", "appId", "versionType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getUserName", "getVersionType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ap
{
  final String appId;
  final int euz;
  final String userName;
  
  public ap(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(319367);
    this.userName = paramString1;
    this.appId = paramString2;
    this.euz = paramInt;
    AppMethodBeat.o(319367);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(319378);
    if (this == paramObject)
    {
      AppMethodBeat.o(319378);
      return true;
    }
    if (!(paramObject instanceof ap))
    {
      AppMethodBeat.o(319378);
      return false;
    }
    paramObject = (ap)paramObject;
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(319378);
      return false;
    }
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(319378);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(319378);
      return false;
    }
    AppMethodBeat.o(319378);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(319372);
    int i = this.userName.hashCode();
    int j = this.appId.hashCode();
    int k = this.euz;
    AppMethodBeat.o(319372);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(319369);
    String str = "WxaInfo(userName=" + this.userName + ", appId=" + this.appId + ", versionType=" + this.euz + ')';
    AppMethodBeat.o(319369);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap
 * JD-Core Version:    0.7.0.1
 */