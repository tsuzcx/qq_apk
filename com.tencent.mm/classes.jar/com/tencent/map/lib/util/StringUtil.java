package com.tencent.map.lib.util;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
  
  public static CharSequence buildMulColorText(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(paramArrayOfString[i]);
      localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(paramArrayOfInt[i]), 0, localSpannableStringBuilder2.length(), 33);
      localSpannableStringBuilder1.append(localSpannableStringBuilder2);
      i += 1;
    }
    return localSpannableStringBuilder1;
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
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
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static int compareVersion(String paramString1, String paramString2)
  {
    int k = 0;
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i = 0;
    int j;
    if (paramString1.length > paramString2.length)
    {
      j = paramString2.length;
      label29:
      if (i >= j) {
        break label82;
      }
      j = Integer.valueOf(paramString1[i]).intValue();
      int m = Integer.valueOf(paramString2[i]).intValue();
      if (j - m == 0) {
        break label75;
      }
      i = j - m;
    }
    label75:
    label82:
    do
    {
      return i;
      j = paramString1.length;
      break label29;
      i += 1;
      break;
      i = k;
    } while (paramString1.length == paramString2.length);
    return paramString1.length - paramString2.length;
  }
  
  public static String fromUTF8(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static boolean isContains(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return false;
    }
    return paramString2.contains(paramString1);
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static boolean isEqual(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    if (paramString2 != null) {
      return paramString2.equals(paramString1);
    }
    return false;
  }
  
  public static boolean isMatched(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {}
    while (paramString2.indexOf(paramString1) != 0) {
      return false;
    }
    return true;
  }
  
  public static boolean isNumber(String paramString)
  {
    try
    {
      boolean bool = Pattern.compile("[0-9]*").matcher(paramString).matches();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isWordLikeMyLocation(String paramString)
  {
    if (isEmpty(paramString)) {}
    while ((!paramString.equals("我的位置")) && (!paramString.equals("当前位置")) && (!paramString.equals("我在哪")) && (!paramString.equals("我在哪儿")) && (!paramString.equals("我在的位置")) && (!paramString.equals("我的位置在哪")) && (!paramString.equals("我的位置在哪儿"))) {
      return false;
    }
    return true;
  }
  
  public static String removeSuffix(String paramString)
  {
    if (isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  public static String toDateFormat(long paramLong)
  {
    return a.format(Long.valueOf(paramLong));
  }
  
  public static String toGBK(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "gbk");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return "";
  }
  
  public static String toUTF8(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.lib.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */