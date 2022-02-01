package com.google.android.gms.common.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings
{
  private static final Pattern zzaak;
  
  static
  {
    AppMethodBeat.i(5295);
    zzaak = Pattern.compile("\\$\\{(.*?)\\}");
    AppMethodBeat.o(5295);
  }
  
  public static String capitalize(String paramString)
  {
    AppMethodBeat.i(5292);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(5292);
      return paramString;
    }
    char c1 = paramString.charAt(0);
    char c2 = Character.toUpperCase(c1);
    if (c1 == c2)
    {
      AppMethodBeat.o(5292);
      return paramString;
    }
    paramString = paramString.substring(1);
    paramString = String.valueOf(paramString).length() + 1 + c2 + paramString;
    AppMethodBeat.o(5292);
    return paramString;
  }
  
  public static String emptyToNull(String paramString)
  {
    AppMethodBeat.i(5291);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(5291);
      return null;
    }
    AppMethodBeat.o(5291);
    return paramString;
  }
  
  public static String format(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(5290);
    Matcher localMatcher = zzaak.matcher(paramString);
    if (localMatcher.find())
    {
      paramString = new StringBuffer();
      for (;;)
      {
        String str = localMatcher.group(1);
        Object localObject = paramBundle.get(str);
        if (localObject != null) {
          localMatcher.appendReplacement(paramString, localObject.toString());
        }
        while (!localMatcher.find())
        {
          localMatcher.appendTail(paramString);
          paramString = paramString.toString();
          AppMethodBeat.o(5290);
          return paramString;
          if (paramBundle.containsKey(str)) {
            localMatcher.appendReplacement(paramString, "null");
          } else {
            localMatcher.appendReplacement(paramString, "");
          }
        }
      }
    }
    AppMethodBeat.o(5290);
    return paramString;
  }
  
  public static boolean isEmptyOrWhitespace(String paramString)
  {
    AppMethodBeat.i(5293);
    if ((paramString == null) || (paramString.trim().isEmpty()))
    {
      AppMethodBeat.o(5293);
      return true;
    }
    AppMethodBeat.o(5293);
    return false;
  }
  
  public static String nullToEmpty(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String padEnd(String paramString, int paramInt, char paramChar)
  {
    AppMethodBeat.i(5294);
    Preconditions.checkNotNull(paramString);
    if (paramString.length() >= paramInt)
    {
      AppMethodBeat.o(5294);
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    localStringBuilder.append(paramString);
    int i = paramString.length();
    while (i < paramInt)
    {
      localStringBuilder.append(paramChar);
      i += 1;
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(5294);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.Strings
 * JD-Core Version:    0.7.0.1
 */