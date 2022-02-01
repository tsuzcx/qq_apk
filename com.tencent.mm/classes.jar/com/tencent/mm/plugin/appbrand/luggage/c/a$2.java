package com.tencent.mm.plugin.appbrand.luggage.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ab;

final class a$2
  extends com.tencent.mm.plugin.appbrand.page.bf
{
  a$2(a parama1, com.tencent.mm.plugin.appbrand.page.a parama, a parama2)
  {
    super(parama);
  }
  
  public final String Si(String paramString)
  {
    AppMethodBeat.i(47538);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(47538);
      return null;
    }
    if (paramString.equals(a.a(this.lQs)))
    {
      paramString = ab.Tr(com.tencent.mm.plugin.appbrand.appcache.bf.d(this.lQs.En(), paramString));
      AppMethodBeat.o(47538);
      return paramString;
    }
    paramString = super.Si(paramString);
    AppMethodBeat.o(47538);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.a.2
 * JD-Core Version:    0.7.0.1
 */