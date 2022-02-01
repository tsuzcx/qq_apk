package com.tencent.mm.plugin.finder.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public static String awf(String paramString)
  {
    AppMethodBeat.i(241812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(241812);
      return "";
    }
    paramString = paramString.substring(0, Math.min(4, paramString.length()));
    AppMethodBeat.o(241812);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.h
 * JD-Core Version:    0.7.0.1
 */