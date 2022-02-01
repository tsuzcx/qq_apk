package com.tencent.luggage.h;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"startsWithIgnoreCase", "", "", "prefix", "protocol", "startsWithIgnoreCaseAndBlank", "luggage-commons_release"})
public final class c
{
  public static final boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(187560);
    p.h(paramString1, "$this$startsWithIgnoreCase");
    p.h(paramString2, "prefix");
    if (n.aE((CharSequence)paramString2))
    {
      AppMethodBeat.o(187560);
      return false;
    }
    String str = paramString1;
    if (!paramBoolean)
    {
      if (!URLUtil.isHttpUrl(paramString1)) {
        break label73;
      }
      str = paramString1.substring(7);
      p.g(str, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      paramBoolean = k.C(str, paramString2);
      AppMethodBeat.o(187560);
      return paramBoolean;
      label73:
      str = paramString1;
      if (URLUtil.isHttpsUrl(paramString1))
      {
        str = paramString1.substring(8);
        p.g(str, "(this as java.lang.String).substring(startIndex)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.c
 * JD-Core Version:    0.7.0.1
 */