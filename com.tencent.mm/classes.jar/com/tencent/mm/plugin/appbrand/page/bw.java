package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onCreateCustomScriptProvider", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "plugin-appbrand-integration_release"})
public final class bw
  extends ag
{
  public bw(ah paramah)
  {
    super(paramah);
    AppMethodBeat.i(271940);
    AppMethodBeat.o(271940);
  }
  
  protected final bg cdk()
  {
    AppMethodBeat.i(271939);
    bg localbg = (bg)new a(this, (a)this);
    AppMethodBeat.o(271939);
    return localbg;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer$onCreateCustomScriptProvider$1", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "provideScript", "", "resourceName", "plugin-appbrand-integration_release"})
  public static final class a
    extends bk
  {
    a(a parama)
    {
      super();
    }
    
    public final String alO(String paramString)
    {
      AppMethodBeat.i(271351);
      if (paramString == null) {}
      do
      {
        for (;;)
        {
          paramString = super.alO(paramString);
          AppMethodBeat.o(271351);
          return paramString;
          switch (paramString.hashCode())
          {
          }
        }
      } while (!paramString.equals("WAWebview.js"));
      paramString = this.qww.R(ICommLibReader.class);
      if (paramString == null) {
        p.iCn();
      }
      paramString = ((ICommLibReader)paramString).acw("WAWebview.js");
      if (paramString == null) {
        p.iCn();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      ah localah = (ah)this.qww.QK();
      if (localah == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.MonkeyTestAppPageView");
        AppMethodBeat.o(271351);
        throw paramString;
      }
      paramString = ((bv)localah).qwv + "\n\n" + paramString;
      AppMethodBeat.o(271351);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bw
 * JD-Core Version:    0.7.0.1
 */