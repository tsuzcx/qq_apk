package com.tencent.mm.plugin.appbrand.luggage.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.bk;

final class a$2
  extends bk
{
  a$2(a parama1, com.tencent.mm.plugin.appbrand.page.a parama, a parama2)
  {
    super(parama);
  }
  
  public final String Ky(String paramString)
  {
    AppMethodBeat.i(47538);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(47538);
      return null;
    }
    if (paramString.equals(a.a(this.kPJ)))
    {
      paramString = ab.LG(be.d(this.kPJ.Dl(), paramString));
      AppMethodBeat.o(47538);
      return paramString;
    }
    paramString = super.Ky(paramString);
    AppMethodBeat.o(47538);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.a.2
 * JD-Core Version:    0.7.0.1
 */