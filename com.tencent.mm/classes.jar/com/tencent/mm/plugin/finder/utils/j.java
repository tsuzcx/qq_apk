package com.tencent.mm.plugin.finder.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public static String aFA(String paramString)
  {
    AppMethodBeat.i(279060);
    paramString = aFy(paramString);
    AppMethodBeat.o(279060);
    return paramString;
  }
  
  private static String aFy(String paramString)
  {
    AppMethodBeat.i(279058);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(279058);
      return "";
    }
    paramString = paramString.substring(0, Math.min(4, paramString.length()));
    AppMethodBeat.o(279058);
    return paramString;
  }
  
  public static String aFz(String paramString)
  {
    AppMethodBeat.i(279059);
    paramString = aFy(paramString);
    AppMethodBeat.o(279059);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j
 * JD-Core Version:    0.7.0.1
 */