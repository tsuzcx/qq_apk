package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public class UnicodeUtils
{
  private static final Pattern zzaal;
  
  static
  {
    AppMethodBeat.i(90279);
    zzaal = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
    AppMethodBeat.o(90279);
  }
  
  public static String unescape(String paramString)
  {
    AppMethodBeat.i(90278);
    if (!TextUtils.isEmpty(paramString))
    {
      Matcher localMatcher = zzaal.matcher(paramString);
      Object localObject2;
      for (Object localObject1 = null; localMatcher.find(); localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new StringBuffer();
        }
        localMatcher.appendReplacement((StringBuffer)localObject2, new String(Character.toChars(Integer.parseInt(localMatcher.group().substring(2), 16))));
      }
      if (localObject1 == null)
      {
        AppMethodBeat.o(90278);
        return paramString;
      }
      localMatcher.appendTail(localObject1);
      paramString = localObject1.toString();
      AppMethodBeat.o(90278);
      return paramString;
    }
    AppMethodBeat.o(90278);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.util.UnicodeUtils
 * JD-Core Version:    0.7.0.1
 */