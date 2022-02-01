package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onCreateCustomScriptProvider", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "plugin-appbrand-integration_release"})
public final class bt
  extends af
{
  public bt(ag paramag)
  {
    super(paramag);
    AppMethodBeat.i(229246);
    AppMethodBeat.o(229246);
  }
  
  protected final be bQu()
  {
    AppMethodBeat.i(229245);
    be localbe = (be)new a(this, (a)this);
    AppMethodBeat.o(229245);
    return localbe;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer$onCreateCustomScriptProvider$1", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "provideScript", "", "resourceName", "plugin-appbrand-integration_release"})
  public static final class a
    extends bi
  {
    a(a parama)
    {
      super();
    }
    
    public final String adT(String paramString)
    {
      AppMethodBeat.i(229244);
      if (paramString == null) {}
      do
      {
        for (;;)
        {
          paramString = super.adT(paramString);
          AppMethodBeat.o(229244);
          return paramString;
          switch (paramString.hashCode())
          {
          }
        }
      } while (!paramString.equals("WAWebview.js"));
      paramString = this.nuC.S(ICommLibReader.class);
      if (paramString == null) {
        p.hyc();
      }
      paramString = ((ICommLibReader)paramString).UM("WAWebview.js");
      if (paramString == null) {
        p.hyc();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      ag localag = (ag)this.nuC.NN();
      if (localag == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.MonkeyTestAppPageView");
        AppMethodBeat.o(229244);
        throw paramString;
      }
      paramString = ((bs)localag).nuB + "\n\n" + paramString;
      AppMethodBeat.o(229244);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bt
 * JD-Core Version:    0.7.0.1
 */