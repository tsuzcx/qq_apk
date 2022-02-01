package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h
  extends f
{
  public abstract g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, aj paramaj);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static r a(h paramh, com.tencent.mm.plugin.appbrand.g paramg)
    {
      AppMethodBeat.i(318759);
      s.u(paramh, "this");
      s.u(paramg, "receiver");
      paramh = f.a.a((f)paramh, paramg);
      AppMethodBeat.o(318759);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.h
 * JD-Core Version:    0.7.0.1
 */