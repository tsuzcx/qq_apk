package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gne;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem;", "", "()V", "Header", "Manage", "PluginTitle", "UserInfo", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$Header;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$UserInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$PluginTitle;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$Manage;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class d
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$Header;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem;", "appInfo", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;", "(Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;)V", "getAppInfo", "()Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    final gne ujQ;
    
    public a(gne paramgne)
    {
      super();
      AppMethodBeat.i(322797);
      this.ujQ = paramgne;
      AppMethodBeat.o(322797);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(322830);
      if (this == paramObject)
      {
        AppMethodBeat.o(322830);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(322830);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.ujQ, paramObject.ujQ))
      {
        AppMethodBeat.o(322830);
        return false;
      }
      AppMethodBeat.o(322830);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(322818);
      int i = this.ujQ.hashCode();
      AppMethodBeat.o(322818);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(322810);
      String str = "Header(appInfo=" + this.ujQ + ')';
      AppMethodBeat.o(322810);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$Manage;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem;", "()V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends d
  {
    public static final b ujR;
    
    static
    {
      AppMethodBeat.i(322792);
      ujR = new b();
      AppMethodBeat.o(322792);
    }
    
    private b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$PluginTitle;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem;", "nickName", "", "(Ljava/lang/String;)V", "getNickName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends d
  {
    final String nickName;
    
    public c(String paramString)
    {
      super();
      AppMethodBeat.i(322787);
      this.nickName = paramString;
      AppMethodBeat.o(322787);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(322804);
      if (this == paramObject)
      {
        AppMethodBeat.o(322804);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(322804);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.nickName, paramObject.nickName))
      {
        AppMethodBeat.o(322804);
        return false;
      }
      AppMethodBeat.o(322804);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(322798);
      int i = this.nickName.hashCode();
      AppMethodBeat.o(322798);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(322793);
      String str = "PluginTitle(nickName=" + this.nickName + ')';
      AppMethodBeat.o(322793);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem$UserInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedItem;", "usageInfoItem", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoUsageInfoItem;", "(Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoUsageInfoItem;)V", "getUsageInfoItem", "()Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoUsageInfoItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends d
  {
    final m ujS;
    
    public d(m paramm)
    {
      super();
      AppMethodBeat.i(322788);
      this.ujS = paramm;
      AppMethodBeat.o(322788);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(322809);
      if (this == paramObject)
      {
        AppMethodBeat.o(322809);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(322809);
        return false;
      }
      paramObject = (d)paramObject;
      if (!s.p(this.ujS, paramObject.ujS))
      {
        AppMethodBeat.o(322809);
        return false;
      }
      AppMethodBeat.o(322809);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(322802);
      int i = this.ujS.hashCode();
      AppMethodBeat.o(322802);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(322795);
      String str = "UserInfo(usageInfoItem=" + this.ujS + ')';
      AppMethodBeat.o(322795);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.d
 * JD-Core Version:    0.7.0.1
 */