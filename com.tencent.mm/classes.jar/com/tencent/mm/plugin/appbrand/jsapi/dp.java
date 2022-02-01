package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/WxaComponentAdapter;", "", "()V", "asPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "asService", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dp
{
  public static final dp rBN;
  
  static
  {
    AppMethodBeat.i(135576);
    rBN = new dp();
    AppMethodBeat.o(135576);
  }
  
  public static final ad j(f paramf)
  {
    AppMethodBeat.i(135574);
    if (paramf == null)
    {
      AppMethodBeat.o(135574);
      return null;
    }
    if ((paramf instanceof ad))
    {
      paramf = (ad)paramf;
      AppMethodBeat.o(135574);
      return paramf;
    }
    if ((paramf instanceof y))
    {
      paramf = ((y)paramf).getCurrentPageView();
      AppMethodBeat.o(135574);
      return paramf;
    }
    AppMethodBeat.o(135574);
    return null;
  }
  
  public static final y k(f paramf)
  {
    AppMethodBeat.i(135575);
    if (paramf == null)
    {
      AppMethodBeat.o(135575);
      return null;
    }
    if ((paramf instanceof ad))
    {
      paramf = ((ad)paramf).ari();
      AppMethodBeat.o(135575);
      return paramf;
    }
    if ((paramf instanceof y))
    {
      paramf = (y)paramf;
      AppMethodBeat.o(135575);
      return paramf;
    }
    AppMethodBeat.o(135575);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dp
 * JD-Core Version:    0.7.0.1
 */