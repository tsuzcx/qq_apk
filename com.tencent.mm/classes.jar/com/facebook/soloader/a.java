package com.facebook.soloader;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  public static void e(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(208059);
    String str2 = paramString1 + paramString2 + paramString3;
    String str1 = str2;
    if (str2.length() > 127)
    {
      str1 = str2;
      if (paramString2 != null)
      {
        int i = paramString1.length();
        int j = paramString3.length();
        str1 = paramString1 + paramString2.substring(0, 127 - i - j) + paramString3;
      }
    }
    Trace.beginSection(str1);
    AppMethodBeat.o(208059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.soloader.a
 * JD-Core Version:    0.7.0.1
 */