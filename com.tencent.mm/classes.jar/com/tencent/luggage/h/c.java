package com.tencent.luggage.h;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"removeUiRunnable", "", "task", "Ljava/lang/Runnable;", "uiThread", "block", "Lkotlin/Function0;", "delay", "", "isNotNull", "", "", "isNull", "optStringStrictly", "", "Lorg/json/JSONObject;", "name", "startsWithIgnoreCase", "prefix", "protocol", "startsWithIgnoreCaseAndBlank", "toArrayList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "luggage-commons_release"})
public final class c
{
  public static final boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(221357);
    p.h(paramString1, "$this$startsWithIgnoreCase");
    p.h(paramString2, "prefix");
    if (n.aL((CharSequence)paramString2))
    {
      AppMethodBeat.o(221357);
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
      paramBoolean = l.C(str, paramString2);
      AppMethodBeat.o(221357);
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