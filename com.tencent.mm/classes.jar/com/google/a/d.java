package com.google.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Locale;

public enum d
  implements e
{
  private d() {}
  
  static String bW(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    char c = paramString.charAt(0);
    int j = paramString.length();
    while ((i < j - 1) && (!Character.isLetter(c)))
    {
      localStringBuilder.append(c);
      i += 1;
      c = paramString.charAt(i);
    }
    String str = paramString;
    if (!Character.isUpperCase(c))
    {
      c = Character.toUpperCase(c);
      i += 1;
      if (i >= paramString.length()) {
        break label120;
      }
    }
    label120:
    for (paramString = c + paramString.substring(i);; paramString = String.valueOf(c))
    {
      str = paramString;
      return str;
    }
  }
  
  static String s(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramString1.length();
    while (i < j)
    {
      char c = paramString1.charAt(i);
      if ((Character.isUpperCase(c)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.d
 * JD-Core Version:    0.7.0.1
 */