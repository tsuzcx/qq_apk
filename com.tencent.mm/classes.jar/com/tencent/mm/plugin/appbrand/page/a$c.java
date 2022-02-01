package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ao;

final class a$c
  implements a.a
{
  private a$c(a parama) {}
  
  public final void Lo(String paramString)
  {
    AppMethodBeat.i(147427);
    if (!this.kXh.Dl().iDL.bii())
    {
      AppMethodBeat.o(147427);
      return;
    }
    String str = this.kXh.Dl().iDL.KR(paramString);
    Object localObject = new StringBuilder().append(str);
    if (str.endsWith("/")) {}
    for (paramString = "";; paramString = "/")
    {
      paramString = paramString + "page-frame.js";
      localObject = this.kXh.biQ().Ky(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramString = new ao(paramString);
      AppMethodBeat.o(147427);
      throw paramString;
    }
    a.c(this.kXh).au(str, false);
    this.kXh.dL(paramString, (String)localObject);
    AppMethodBeat.o(147427);
  }
  
  public final void Lp(String paramString)
  {
    AppMethodBeat.i(147428);
    String str = this.kXh.biQ().Ky(paramString);
    this.kXh.dL(paramString, str);
    AppMethodBeat.o(147428);
  }
  
  public final void biR()
  {
    AppMethodBeat.i(147426);
    a.c(this.kXh).au("__APP__", false);
    if (this.kXh.Dl().iDL.bii())
    {
      localObject = this.kXh.biQ().Ky("app-wxss.js");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ao("app-wxss.js");
        AppMethodBeat.o(147426);
        throw ((Throwable)localObject);
      }
      this.kXh.dL("app-wxss.js", (String)localObject);
      AppMethodBeat.o(147426);
      return;
    }
    Object localObject = this.kXh.biQ().Ky("page-frame.html");
    this.kXh.dL("page-frame.html", (String)localObject);
    AppMethodBeat.o(147426);
  }
  
  public final String name()
  {
    return "Legacy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.c
 * JD-Core Version:    0.7.0.1
 */