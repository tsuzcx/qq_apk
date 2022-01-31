package com.tencent.mm.plugin.appbrand.page;

import a.l;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1", "com/tencent/mm/plugin/appbrand/page/MPPageViewPullDownExtensionImpl$runOnUiThread$$inlined$runOnUiThread$1"})
public final class au$h
  implements Runnable
{
  public au$h(au paramau) {}
  
  public final void run()
  {
    AppMethodBeat.i(141016);
    d.i(au.a(this.izh), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + au.b(this.izh).getAppId() + " url:" + au.b(this.izh).getURL());
    try
    {
      au.c(this.izh).eE(true);
      au.c(this.izh).aJC();
      AppMethodBeat.o(141016);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.e(au.a(this.izh), "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + au.b(this.izh).getAppId() + " url:" + au.b(this.izh).getURL() + " e:" + localNullPointerException);
      Throwable localThrowable = (Throwable)localNullPointerException;
      AppMethodBeat.o(141016);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.au.h
 * JD-Core Version:    0.7.0.1
 */