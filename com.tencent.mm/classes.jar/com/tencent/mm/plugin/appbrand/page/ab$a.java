package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"})
public final class ab$a
{
  public static boolean e(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(236646);
    p.k(paramICommLibReader, "$this$supportLazyCodeLoading");
    int i = 0;
    while (i < 2)
    {
      CharSequence localCharSequence = (CharSequence)paramICommLibReader.acx(new java.lang.String[] { "lazyCodeLoading", "lazyCodeLoading2" }[i]);
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int j = 1; j == 0; j = 0)
      {
        AppMethodBeat.o(236646);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(236646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab.a
 * JD-Core Version:    0.7.0.1
 */