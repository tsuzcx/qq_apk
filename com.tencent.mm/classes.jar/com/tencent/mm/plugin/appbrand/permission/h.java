package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "luggage-wechat-full-sdk_release"})
public abstract interface h
  extends f
{
  public abstract g a(d paramd, String paramString, ag paramag);
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static m k(d paramd)
    {
      AppMethodBeat.i(230124);
      p.h(paramd, "$this$findPromptViewContainer");
      paramd = f.a.j(paramd);
      AppMethodBeat.o(230124);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.h
 * JD-Core Version:    0.7.0.1
 */