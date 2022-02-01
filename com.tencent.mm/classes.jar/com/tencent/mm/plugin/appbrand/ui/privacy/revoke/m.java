package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.gne;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoUsageInfoItem;", "", "hostAppInfo", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;", "hostPluginInfo", "usageInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeItem;", "(Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;Lcom/tencent/mm/protocal/protobuf/ScopeItem;)V", "getHostAppInfo", "()Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;", "getHostPluginInfo", "getUsageInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeItem;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "toReadableString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  final gne ukI;
  final gne ukJ;
  final eum ukK;
  
  public m(gne paramgne1, gne paramgne2, eum parameum)
  {
    AppMethodBeat.i(322881);
    this.ukI = paramgne1;
    this.ukJ = paramgne2;
    this.ukK = parameum;
    AppMethodBeat.o(322881);
  }
  
  private static String b(gne paramgne)
  {
    AppMethodBeat.i(322888);
    paramgne = "WxaUseUserInfoItem(appid=" + paramgne.appid + ", nick_name=" + paramgne.xkX + ", icon_url=" + paramgne.icon_url + ')';
    AppMethodBeat.o(322888);
    return paramgne;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(322913);
    if (this == paramObject)
    {
      AppMethodBeat.o(322913);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(322913);
      return false;
    }
    paramObject = (m)paramObject;
    if (!s.p(this.ukI, paramObject.ukI))
    {
      AppMethodBeat.o(322913);
      return false;
    }
    if (!s.p(this.ukJ, paramObject.ukJ))
    {
      AppMethodBeat.o(322913);
      return false;
    }
    if (!s.p(this.ukK, paramObject.ukK))
    {
      AppMethodBeat.o(322913);
      return false;
    }
    AppMethodBeat.o(322913);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(322904);
    int j = this.ukI.hashCode();
    if (this.ukJ == null) {}
    for (int i = 0;; i = this.ukJ.hashCode())
    {
      int k = this.ukK.hashCode();
      AppMethodBeat.o(322904);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(322897);
    StringBuilder localStringBuilder = new StringBuilder("UserInfoUsageInfoItem(hostAppInfo=").append(b(this.ukI)).append(", hostPluginInfo=");
    Object localObject = this.ukJ;
    if (localObject == null) {}
    for (localObject = "null";; localObject = b((gne)localObject))
    {
      localObject = (String)localObject + ", usageInfo=" + this.ukK.toJSON() + ')';
      AppMethodBeat.o(322897);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.m
 * JD-Core Version:    0.7.0.1
 */