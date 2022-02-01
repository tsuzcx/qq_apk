package com.tencent.luggage.h;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"startsWithIgnoreCase", "", "", "prefix", "protocol", "luggage-commons_release"})
public final class c
{
  public static final boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(194911);
    d.g.b.k.h(paramString1, "$this$startsWithIgnoreCase");
    d.g.b.k.h(paramString2, "prefix");
    if (n.aC((CharSequence)paramString2))
    {
      AppMethodBeat.o(194911);
      return false;
    }
    String str = paramString1;
    if (!paramBoolean)
    {
      if (!URLUtil.isHttpUrl(paramString1)) {
        break label73;
      }
      str = paramString1.substring(7);
      d.g.b.k.g(str, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      paramBoolean = k.A(str, paramString2);
      AppMethodBeat.o(194911);
      return paramBoolean;
      label73:
      str = paramString1;
      if (URLUtil.isHttpsUrl(paramString1))
      {
        str = paramString1.substring(8);
        d.g.b.k.g(str, "(this as java.lang.String).substring(startIndex)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.h.c
 * JD-Core Version:    0.7.0.1
 */