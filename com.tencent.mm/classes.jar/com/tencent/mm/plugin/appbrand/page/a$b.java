package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ao;

final class a$b
  implements a.a
{
  private a$b(a parama) {}
  
  private void Lq(String paramString)
  {
    AppMethodBeat.i(147423);
    String str = this.kXh.biQ().Ky(paramString);
    if (TextUtils.isEmpty(str))
    {
      paramString = new ao(paramString);
      AppMethodBeat.o(147423);
      throw paramString;
    }
    this.kXh.dL(paramString, str);
    AppMethodBeat.o(147423);
  }
  
  public final void Lo(String paramString)
  {
    AppMethodBeat.i(147425);
    if (!this.kXh.Dl().iDL.bii())
    {
      AppMethodBeat.o(147425);
      return;
    }
    paramString = this.kXh.Dl().iDL.KR(paramString);
    if ("__APP__".equals(paramString))
    {
      AppMethodBeat.o(147425);
      return;
    }
    a.c(this.kXh).au(paramString, true);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.endsWith("/")) {}
    for (paramString = "";; paramString = "/")
    {
      paramString = paramString;
      Lq(paramString + "common.app.js");
      Lq(paramString + "webview.app.js");
      AppMethodBeat.o(147425);
      return;
    }
  }
  
  public final void Lp(String paramString) {}
  
  public final void biR()
  {
    AppMethodBeat.i(147424);
    a.c(this.kXh).au("__APP__", true);
    Lq("common.app.js");
    Lq("webview.app.js");
    AppMethodBeat.o(147424);
  }
  
  public final String name()
  {
    return "LazyCodeLoading";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.b
 * JD-Core Version:    0.7.0.1
 */