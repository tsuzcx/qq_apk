package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "luggage-wechat-full-sdk_release"})
public abstract interface h
  extends f
{
  public abstract g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, ag paramag);
  
  @kotlin.l(iBK={1, 1, 16})
  public static final class a
  {
    public static com.tencent.mm.plugin.appbrand.widget.dialog.l m(com.tencent.mm.plugin.appbrand.g paramg)
    {
      AppMethodBeat.i(250361);
      p.k(paramg, "$this$findPromptViewContainer");
      paramg = f.a.k(paramg);
      AppMethodBeat.o(250361);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.h
 * JD-Core Version:    0.7.0.1
 */