package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "show", "findPromptViewContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "luggage-wechat-full-sdk_release"})
public abstract interface f
{
  public abstract void h(d paramd);
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static m j(d paramd)
    {
      AppMethodBeat.i(230123);
      p.h(paramd, "$this$findPromptViewContainer");
      paramd = paramd.getRuntime();
      if (paramd == null) {
        p.hyc();
      }
      paramd = paramd.brn();
      if (paramd == null) {
        p.hyc();
      }
      AppMethodBeat.o(230123);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.f
 * JD-Core Version:    0.7.0.1
 */