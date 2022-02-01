package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePresenterViewCommon;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
  extends f
{
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static r a(g paramg, com.tencent.mm.plugin.appbrand.g paramg1)
    {
      AppMethodBeat.i(318734);
      s.u(paramg, "this");
      s.u(paramg1, "receiver");
      paramg = f.a.a((f)paramg, paramg1);
      AppMethodBeat.o(318734);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.g
 * JD-Core Version:    0.7.0.1
 */