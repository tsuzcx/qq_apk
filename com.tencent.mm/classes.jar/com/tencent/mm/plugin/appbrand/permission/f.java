package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "show", "findPromptViewContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public abstract void h(g paramg);
  
  public abstract void i(g paramg);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static r a(f paramf, g paramg)
    {
      AppMethodBeat.i(318741);
      s.u(paramf, "this");
      s.u(paramg, "receiver");
      paramf = paramg.getRuntime();
      s.checkNotNull(paramf);
      paramf = paramf.qsn;
      s.checkNotNull(paramf);
      AppMethodBeat.o(318741);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.f
 * JD-Core Version:    0.7.0.1
 */