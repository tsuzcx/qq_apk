package com.tencent.mm.plugin.appbrand.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/authrize/OnWxaAuthorizeScopeModifyEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "username", "", "authorizeInfoList", "", "Lcom/tencent/mm/protocal/protobuf/AuthItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getAuthorizeInfoList", "()Ljava/util/List;", "getUsername", "()Ljava/lang/String;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends IEvent
{
  public final List<hu> ugF;
  public final String username;
  
  public a(String paramString, List<? extends hu> paramList)
  {
    AppMethodBeat.i(322189);
    this.username = paramString;
    this.ugF = paramList;
    AppMethodBeat.o(322189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a.a
 * JD-Core Version:    0.7.0.1
 */