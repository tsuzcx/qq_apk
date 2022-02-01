package com.tencent.av.utils;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterUtil
{
  private static final long MAX_VALUE = -1L;
  private static final String MIN_VALUE = "-9223372036854775808";
  private static final String TAG = "CharacterUtil";
  private static final int maxSafeDigits = 18;
  private static final long maxValueDivs = divide(-1L, 10L);
  private static final int maxValueMods = 5;
  
  public static String asUnsignedDecimalString(long paramLong)
  {
    long l = paramLong & 0xFFFFFFFF;
    if (paramLong == l) {
      return String.valueOf(l);
    }
    char[] arrayOfChar = "-9223372036854775808".toCharArray();
    arrayOfChar[0] = '0';
    int j = arrayOfChar.length - 1;
    paramLong = l;
    while ((j != 0) && (paramLong != 0L))
    {
      int i = (char)(int)(arrayOfChar[j] + paramLong % 10L);
      arrayOfChar[j] = i;
      if (i > 57)
      {
        arrayOfChar[j] = ((char)(arrayOfChar[j] - '\n'));
        int k = j - 1;
        arrayOfChar[k] = ((char)(arrayOfChar[k] + '\001'));
      }
      paramLong /= 10L;
      j -= 1;
    }
    j = '1' - arrayOfChar[0];
    return new String(arrayOfChar, j, arrayOfChar.length - j);
  }
  
  static int compare(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  static long divide(long paramLong1, long paramLong2)
  {
    int i = 1;
    if (paramLong2 < 0L)
    {
      if (compare(paramLong1, paramLong2) < 0) {
        return 0L;
      }
      return 1L;
    }
    if (paramLong1 >= 0L) {
      return paramLong1 / paramLong2;
    }
    long l = (paramLong1 >>> 1) / paramLong2 << 1;
    if (compare(paramLong1 - l * paramLong2, paramLong2) >= 0) {}
    for (;;)
    {
      return i + l;
      i = 0;
    }
  }
  
  public static int getChineseNum(String paramString)
  {
    int j = 0;
    int i = 0;
    while ((paramString != null) && (i < paramString.length()))
    {
      int k = j;
      if (isChinese(paramString.charAt(i))) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static boolean isChinese(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION);
  }
  
  public static boolean isChineseByBlock(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
  }
  
  public static boolean isChineseByRange(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.compile("[\\u4E00-\\u9FCC]+").matcher(paramString.trim()).find();
  }
  
  public static boolean isChinesePunctuation(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static int length(String paramString)
  {
    int i = 0;
    int j = 0;
    if ((paramString != null) && (j < paramString.length()))
    {
      if (isChinese(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  private static boolean overflowInParse(long paramLong, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong >= 0L)
    {
      if (paramLong >= maxValueDivs) {
        break label27;
      }
      bool1 = false;
    }
    label27:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLong > maxValueDivs);
      bool1 = bool2;
    } while (paramInt1 > 5);
    return false;
  }
  
  public static long parseBigIntegerPositive(String paramString)
  {
    long l2 = 0L;
    if (paramString == null) {}
    while (paramString.length() == 0) {
      return l2;
    }
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= paramString.length()) {
        break;
      }
      int j = Character.digit(paramString.charAt(i), 10);
      if (j == -1) {
        throw new NumberFormatException(paramString);
      }
      if ((i > 18) && (overflowInParse(l1, j, 10))) {
        throw new NumberFormatException("Too large for unsigned long: " + paramString);
      }
      l1 = 10 * l1 + j;
      i += 1;
    }
  }
  
  public static String subString(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramInt1;
      int i = paramInt2;
      paramInt2 = j;
      while (paramInt2 < i)
      {
        j = i;
        if (isChinese(paramString.charAt(paramInt2))) {
          j = i - 1;
        }
        paramInt2 += 1;
        i = j;
      }
      return paramString.substring(paramInt1, i);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.CharacterUtil
 * JD-Core Version:    0.7.0.1
 */