package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onCreateCustomScriptProvider", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw
  extends ag
{
  public bw(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(324947);
    AppMethodBeat.o(324947);
  }
  
  protected final bg cDI()
  {
    AppMethodBeat.i(324948);
    bg localbg = (bg)new a(this);
    AppMethodBeat.o(324948);
    return localbg;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer$onCreateCustomScriptProvider$1", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "provideScript", "", "resourceName", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends bk
  {
    a(bw parambw)
    {
      super();
      AppMethodBeat.i(324963);
      AppMethodBeat.o(324963);
    }
    
    public final String aeU(String paramString)
    {
      AppMethodBeat.i(324965);
      if (s.p(paramString, "WAWebview.js"))
      {
        paramString = this.tBl.aa(ICommLibReader.class);
        s.checkNotNull(paramString);
        paramString = ((ICommLibReader)paramString).UW("WAWebview.js");
        s.checkNotNull(paramString);
        s.s(paramString, "this@MonkeyTestAppPageVi…g(SCRIPT_LIB_WAWEBVIEW)!!");
        StringBuilder localStringBuilder = new StringBuilder();
        f localf = this.tBl.aqX();
        if (localf == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.MonkeyTestAppPageView");
          AppMethodBeat.o(324965);
          throw paramString;
        }
        paramString = ((bv)localf).tBk + "\n\n" + paramString;
        AppMethodBeat.o(324965);
        return paramString;
      }
      paramString = super.aeU(paramString);
      AppMethodBeat.o(324965);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bw
 * JD-Core Version:    0.7.0.1
 */