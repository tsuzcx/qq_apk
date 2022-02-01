package com.tencent.mapsdk.internal;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gz
{
  private static SimpleDateFormat a;
  
  static
  {
    AppMethodBeat.i(225850);
    a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    AppMethodBeat.o(225850);
  }
  
  private static CharSequence a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(225710);
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(paramArrayOfString[i]);
      localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(paramArrayOfInt[i]), 0, localSpannableStringBuilder2.length(), 33);
      localSpannableStringBuilder1.append(localSpannableStringBuilder2);
      i += 1;
    }
    AppMethodBeat.o(225710);
    return localSpannableStringBuilder1;
  }
  
  private static String a(long paramLong)
  {
    AppMethodBeat.i(225788);
    String str = a.format(Long.valueOf(paramLong));
    AppMethodBeat.o(225788);
    return str;
  }
  
  private static String a(Collection<String> paramCollection, String paramString)
  {
    AppMethodBeat.i(225842);
    if ((paramCollection == null) || (paramCollection.isEmpty()) || (paramString == null))
    {
      AppMethodBeat.o(225842);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramCollection.size() - 1) {
        localStringBuilder.append(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(str).append(paramString);
      }
    }
    paramCollection = localStringBuilder.toString();
    AppMethodBeat.o(225842);
    return paramCollection;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(225752);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str.length() < 2) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(str);
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      AppMethodBeat.o(225752);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(225752);
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(225742);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, paramString);
        AppMethodBeat.o(225742);
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte) {}
    }
    AppMethodBeat.o(225742);
    return null;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(225689);
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(225689);
      return true;
    }
    AppMethodBeat.o(225689);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225799);
    if (paramString1 == paramString2)
    {
      AppMethodBeat.o(225799);
      return true;
    }
    boolean bool;
    if (paramString1 != null)
    {
      bool = paramString1.equals(paramString2);
      AppMethodBeat.o(225799);
      return bool;
    }
    if (paramString2 != null)
    {
      bool = paramString2.equals(paramString1);
      AppMethodBeat.o(225799);
      return bool;
    }
    AppMethodBeat.o(225799);
    return false;
  }
  
  public static String b(String paramString)
  {
    AppMethodBeat.i(225806);
    if (a(paramString))
    {
      AppMethodBeat.o(225806);
      return paramString;
    }
    int i = paramString.lastIndexOf(".");
    if (i > 0)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(225806);
      return paramString;
    }
    AppMethodBeat.o(225806);
    return paramString;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225697);
    if ((paramString2 == null) || (paramString1 == null))
    {
      AppMethodBeat.o(225697);
      return false;
    }
    if (paramString2.indexOf(paramString1) == 0)
    {
      AppMethodBeat.o(225697);
      return true;
    }
    AppMethodBeat.o(225697);
    return false;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225704);
    if ((paramString2 == null) || (paramString1 == null))
    {
      AppMethodBeat.o(225704);
      return false;
    }
    boolean bool = paramString2.contains(paramString1);
    AppMethodBeat.o(225704);
    return bool;
  }
  
  private static int d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225781);
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i = 0;
    int j;
    for (;;)
    {
      if (paramString1.length > paramString2.length) {}
      for (j = paramString2.length;; j = paramString1.length)
      {
        if (i >= j) {
          break label87;
        }
        j = Integer.valueOf(paramString1[i]).intValue();
        int k = Integer.valueOf(paramString2[i]).intValue();
        if (j - k == 0) {
          break;
        }
        AppMethodBeat.o(225781);
        return j - k;
      }
      i += 1;
    }
    label87:
    if (paramString1.length != paramString2.length)
    {
      i = paramString1.length;
      j = paramString2.length;
      AppMethodBeat.o(225781);
      return i - j;
    }
    AppMethodBeat.o(225781);
    return 0;
  }
  
  private static String d(String paramString)
  {
    AppMethodBeat.i(225717);
    if (paramString == null)
    {
      AppMethodBeat.o(225717);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(225717);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(225717);
    }
    return "";
  }
  
  private static String e(String paramString)
  {
    AppMethodBeat.i(225727);
    if (paramString == null)
    {
      AppMethodBeat.o(225727);
      return "";
    }
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      AppMethodBeat.o(225727);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(225727);
    }
    return "";
  }
  
  private static String f(String paramString)
  {
    AppMethodBeat.i(225734);
    if (paramString == null)
    {
      AppMethodBeat.o(225734);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "gbk");
      AppMethodBeat.o(225734);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      AppMethodBeat.o(225734);
    }
    return "";
  }
  
  private static boolean g(String paramString)
  {
    AppMethodBeat.i(225761);
    if (a(paramString))
    {
      AppMethodBeat.o(225761);
      return false;
    }
    if ((paramString.equals("我的位置")) || (paramString.equals("当前位置")) || (paramString.equals("我在哪")) || (paramString.equals("我在哪儿")) || (paramString.equals("我在的位置")) || (paramString.equals("我的位置在哪")) || (paramString.equals("我的位置在哪儿")))
    {
      AppMethodBeat.o(225761);
      return true;
    }
    AppMethodBeat.o(225761);
    return false;
  }
  
  private static boolean h(String paramString)
  {
    AppMethodBeat.i(225769);
    try
    {
      boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
      AppMethodBeat.o(225769);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(225769);
    }
    return false;
  }
  
  private static String i(String paramString)
  {
    AppMethodBeat.i(225816);
    if (a(paramString))
    {
      AppMethodBeat.o(225816);
      return paramString;
    }
    try
    {
      Object localObject = new URI(paramString);
      String[] arrayOfString = ((URI)localObject).getQuery().split("&");
      Arrays.sort(arrayOfString);
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        i += 1;
      }
      localObject = new URI(((URI)localObject).getScheme(), ((URI)localObject).getAuthority(), ((URI)localObject).getPath(), localStringBuilder.toString(), ((URI)localObject).getFragment()).toString();
      AppMethodBeat.o(225816);
      return localObject;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      AppMethodBeat.o(225816);
    }
    return paramString;
  }
  
  private static int j(String paramString)
  {
    AppMethodBeat.i(225825);
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[一-龥]")) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        i = (int)(i + 0.5D);
      }
    }
    AppMethodBeat.o(225825);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gz
 * JD-Core Version:    0.7.0.1
 */