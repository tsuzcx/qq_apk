package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeInfo;", "", "username", "", "authScopeInfoList", "", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AuthorizeScopeInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getAuthScopeInfoList", "()Ljava/util/List;", "getUsername", "()Ljava/lang/String;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  final List<e> ujs;
  final String username;
  
  public i(String paramString, List<e> paramList)
  {
    AppMethodBeat.i(322985);
    this.username = paramString;
    this.ujs = paramList;
    AppMethodBeat.o(322985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.i
 * JD-Core Version:    0.7.0.1
 */