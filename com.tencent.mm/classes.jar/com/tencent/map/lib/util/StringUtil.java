package com.tencent.map.lib.util;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
  private static SimpleDateFormat a;
  
  static
  {
    AppMethodBeat.i(98227);
    a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
    AppMethodBeat.o(98227);
  }
  
  public static CharSequence buildMulColorText(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(98216);
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(paramArrayOfString[i]);
      localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(paramArrayOfInt[i]), 0, localSpannableStringBuilder2.length(), 33);
      localSpannableStringBuilder1.append(localSpannableStringBuilder2);
      i += 1;
    }
    AppMethodBeat.o(98216);
    return localSpannableStringBuilder1;
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98220);
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
      AppMethodBeat.o(98220);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(98220);
    return null;
  }
  
  public static int compareVersion(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98223);
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
        AppMethodBeat.o(98223);
        return j - k;
      }
      i += 1;
    }
    label87:
    if (paramString1.length != paramString2.length)
    {
      i = paramString1.length;
      j = paramString2.length;
      AppMethodBeat.o(98223);
      return i - j;
    }
    AppMethodBeat.o(98223);
    return 0;
  }
  
  public static String fromUTF8(String paramString)
  {
    AppMethodBeat.i(98218);
    if (paramString == null)
    {
      AppMethodBeat.o(98218);
      return "";
    }
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      AppMethodBeat.o(98218);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(98218);
    }
    return "";
  }
  
  public static boolean isContains(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98215);
    if ((paramString2 == null) || (paramString1 == null))
    {
      AppMethodBeat.o(98215);
      return false;
    }
    boolean bool = paramString2.contains(paramString1);
    AppMethodBeat.o(98215);
    return bool;
  }
  
  public static boolean isEmpty(String paramString)
  {
    AppMethodBeat.i(98213);
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(98213);
      return true;
    }
    AppMethodBeat.o(98213);
    return false;
  }
  
  public static boolean isEqual(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98225);
    if (paramString1 == paramString2)
    {
      AppMethodBeat.o(98225);
      return true;
    }
    boolean bool;
    if (paramString1 != null)
    {
      bool = paramString1.equals(paramString2);
      AppMethodBeat.o(98225);
      return bool;
    }
    if (paramString2 != null)
    {
      bool = paramString2.equals(paramString1);
      AppMethodBeat.o(98225);
      return bool;
    }
    AppMethodBeat.o(98225);
    return false;
  }
  
  public static boolean isMatched(String paramString1, String paramString2)
  {
    AppMethodBeat.i(98214);
    if ((paramString2 == null) || (paramString1 == null))
    {
      AppMethodBeat.o(98214);
      return false;
    }
    if (paramString2.indexOf(paramString1) == 0)
    {
      AppMethodBeat.o(98214);
      return true;
    }
    AppMethodBeat.o(98214);
    return false;
  }
  
  public static boolean isNumber(String paramString)
  {
    AppMethodBeat.i(98222);
    try
    {
      boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
      AppMethodBeat.o(98222);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(98222);
    }
    return false;
  }
  
  public static boolean isWordLikeMyLocation(String paramString)
  {
    AppMethodBeat.i(98221);
    if (isEmpty(paramString))
    {
      AppMethodBeat.o(98221);
      return false;
    }
    if ((paramString.equals("我的位置")) || (paramString.equals("当前位置")) || (paramString.equals("我在哪")) || (paramString.equals("我在哪儿")) || (paramString.equals("我在的位置")) || (paramString.equals("我的位置在哪")) || (paramString.equals("我的位置在哪儿")))
    {
      AppMethodBeat.o(98221);
      return true;
    }
    AppMethodBeat.o(98221);
    return false;
  }
  
  public static String removeSuffix(String paramString)
  {
    AppMethodBeat.i(98226);
    if (isEmpty(paramString))
    {
      AppMethodBeat.o(98226);
      return paramString;
    }
    int i = paramString.lastIndexOf(".");
    if (i > 0)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(98226);
      return paramString;
    }
    AppMethodBeat.o(98226);
    return paramString;
  }
  
  public static String toDateFormat(long paramLong)
  {
    AppMethodBeat.i(98224);
    String str = a.format(Long.valueOf(paramLong));
    AppMethodBeat.o(98224);
    return str;
  }
  
  public static String toGBK(String paramString)
  {
    AppMethodBeat.i(98219);
    if (paramString == null)
    {
      AppMethodBeat.o(98219);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "gbk");
      AppMethodBeat.o(98219);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      AppMethodBeat.o(98219);
    }
    return "";
  }
  
  public static String toUTF8(String paramString)
  {
    AppMethodBeat.i(98217);
    if (paramString == null)
    {
      AppMethodBeat.o(98217);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(98217);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(98217);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */