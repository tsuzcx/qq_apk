package com.b.a.a;

import android.text.TextUtils;
import com.b.a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements c
{
  public final String aW(String paramString)
  {
    AppMethodBeat.i(183627);
    int i = paramString.lastIndexOf('.');
    int j = paramString.lastIndexOf('/');
    if ((i != -1) && (i > j) && (i + 2 + 4 > paramString.length())) {}
    for (String str = paramString.substring(i + 1, paramString.length());; str = "")
    {
      paramString = o.aV(paramString);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      AppMethodBeat.o(183627);
      return paramString;
    }
    paramString = paramString + "." + str;
    AppMethodBeat.o(183627);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */