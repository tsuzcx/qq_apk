package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.gng;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeListWithAttrs;", "", "wxaAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "authScopeItemList", "", "Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "updateTime", "", "(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;Ljava/util/List;I)V", "getAuthScopeItemList", "()Ljava/util/List;", "getUpdateTime", "()I", "getWxaAttrs", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  final int hdp;
  final WxaAttributes ujt;
  final List<gng> uju;
  
  public j(WxaAttributes paramWxaAttributes, List<? extends gng> paramList, int paramInt)
  {
    AppMethodBeat.i(322990);
    this.ujt = paramWxaAttributes;
    this.uju = paramList;
    this.hdp = paramInt;
    AppMethodBeat.o(322990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.j
 * JD-Core Version:    0.7.0.1
 */