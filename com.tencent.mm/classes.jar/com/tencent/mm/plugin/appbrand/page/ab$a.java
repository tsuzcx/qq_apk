package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageScriptInjectConfig$Constants;", "", "()V", "COMMON_JS_NAME", "", "TAG", "WEBVIEW_APP_JS_NAME", "supportLazyCodeLoading", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab$a
{
  public static boolean g(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(325217);
    s.u(paramICommLibReader, "<this>");
    int i = 0;
    while (i < 2)
    {
      CharSequence localCharSequence = (CharSequence)paramICommLibReader.UX(new java.lang.String[] { "lazyCodeLoading", "lazyCodeLoading2" }[i]);
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int j = 1; j == 0; j = 0)
      {
        AppMethodBeat.o(325217);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(325217);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab.a
 * JD-Core Version:    0.7.0.1
 */