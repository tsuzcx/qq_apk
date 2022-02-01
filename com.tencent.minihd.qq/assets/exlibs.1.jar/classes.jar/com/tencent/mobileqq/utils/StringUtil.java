package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
  public static final int a = 0;
  private static final String a = "…";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = -1;
  
  public static int a(String paramString)
  {
    int k = 0;
    int i;
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      i = 3;
    }
    int m;
    do
    {
      return i;
      paramString = paramString.trim();
      m = paramString.length();
      i = 0;
      int j = 1;
      while (i < m)
      {
        if (!Character.isDigit(paramString.charAt(i))) {
          j = 0;
        }
        i += 1;
      }
      if (j == 0) {
        break;
      }
      i = k;
    } while (m < 5);
    if (m > 15) {
      return 1;
    }
    return -1;
    if (paramString.contains("@"))
    {
      if (a(paramString)) {
        return -1;
      }
      return 2;
    }
    return 4;
  }
  
  public static String a(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return paramContext.getResources().getString(2131368278);
    case 1: 
      return paramContext.getResources().getString(2131368279);
    case 2: 
      return paramContext.getResources().getString(2131368280);
    case 3: 
      return paramContext.getResources().getString(2131368281);
    case 4: 
      return paramContext.getResources().getString(2131368282);
    case 5: 
      return paramContext.getResources().getString(2131368283);
    case 6: 
      return paramContext.getResources().getString(2131368284);
    case 7: 
      return paramContext.getResources().getString(2131368285);
    case 8: 
      return paramContext.getResources().getString(2131368286);
    }
    return paramContext.getResources().getString(2131368287);
  }
  
  public static String a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    String str1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      str1 = "????";
    }
    for (;;)
    {
      String str2 = str1;
      if (paramBoolean) {
        str2 = str1 + " -> pos = (" + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + "), raw = (" + paramMotionEvent.getRawX() + ", " + paramMotionEvent.getRawY() + ")";
      }
      return str2;
      str1 = "down";
      continue;
      str1 = "up";
      continue;
      str1 = "move";
      continue;
      str1 = "cancel";
      continue;
      str1 = "outside";
      continue;
      str1 = "pointer_down";
      continue;
      str1 = "pointer_up";
      continue;
      str1 = "hover_move";
      continue;
      str1 = "scroll";
      continue;
      str1 = "hover_enter";
      continue;
      str1 = "hover_exit";
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return "";
      Matcher localMatcher = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b").matcher(paramString);
      if (localMatcher.find()) {
        return localMatcher.group();
      }
      paramString = Pattern.compile("(?<=http://)[\\w\\.]+[^/]", 2).matcher(paramString);
    } while (!paramString.find());
    return paramString.group();
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    float f1 = 0.0F;
    int i = 0;
    label20:
    double d1;
    if (i < paramString.length())
    {
      double d2 = f1;
      if (d(paramString.charAt(i)))
      {
        d1 = 2.0D;
        label50:
        f1 = (float)(d1 + d2);
        if (f1 <= paramInt) {
          break label107;
        }
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      str = paramString;
      if (paramInt == 0) {
        break;
      }
      return paramString.substring(0, i) + "…";
      d1 = 1.5D;
      break label50;
      label107:
      i += 1;
      break label20;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramInt2);
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      char c1;
      if (i < paramString.length())
      {
        c1 = paramString.charAt(i);
        if ((c1 < 0) || (c1 > 'ÿ')) {
          break label67;
        }
        paramInt1 += 1;
      }
      while (paramInt1 > paramInt2)
      {
        return localStringBuffer.toString();
        label67:
        paramInt1 += 2;
      }
      localStringBuffer.append(c1);
      i += 1;
    }
  }
  
  public static String a(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append(paramList.get(i).toString());
      localStringBuffer.append(paramString);
      i += 1;
    }
    localStringBuffer.delete(localStringBuffer.lastIndexOf(paramString), localStringBuffer.length());
    return localStringBuffer.toString();
  }
  
  public static String a(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {}
      for (localObject = localObject.toString();; localObject = null)
      {
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" , ");
        i += 1;
        break;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Log.d("fuck", paramString1 + ": " + paramString2);
  }
  
  public static boolean a(char paramChar)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((!Character.isDigit(paramChar)) && ((paramChar < 'A') || (paramChar > 'Z')))
    {
      bool1 = bool2;
      if (paramChar >= 'a')
      {
        bool1 = bool2;
        if (paramChar > 'z') {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(paramString).matches();
  }
  
  public static String[] a(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    int m = paramString.length();
    if (m == 0) {
      return new String[] { paramString };
    }
    ArrayList localArrayList = new ArrayList(50);
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < m) {
      if (arrayOfChar[j] == paramChar)
      {
        localArrayList.add(paramString.substring(k, j));
        k = j + 1;
        j = k;
        i = 1;
      }
      else
      {
        j += 1;
        i = 0;
      }
    }
    if (i == 0) {
      localArrayList.add(paramString.substring(k, j));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static int b(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      int k = paramString.charAt(j);
      if ((k >= 0) && (k <= 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 2;
      }
    }
    return i;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int j = 0;
    int k = 1;
    int i = 0;
    if (i < paramString.length())
    {
      int n;
      if (k != 0)
      {
        n = j;
        m = k;
        if (b(paramString.charAt(i)))
        {
          n = i;
          m = 0;
        }
      }
      do
      {
        do
        {
          i += 1;
          j = n;
          k = m;
          break;
          n = j;
          m = k;
        } while (!b(paramString.charAt(i)));
        m = i;
        if (paramString.length() - 1 == i) {
          break label113;
        }
        n = j;
        m = k;
      } while (b(paramString.charAt(i + 1)));
    }
    for (int m = i;; m = 0)
    {
      label113:
      if (j < m + 1) {
        if (m + 1 < paramString.length()) {
          i = m + 1;
        }
      }
      for (paramString = paramString.substring(j, i);; paramString = "")
      {
        return paramString;
        i = paramString.length();
        break;
      }
    }
  }
  
  public static boolean b(char paramChar)
  {
    return (!Character.isISOControl(paramChar)) || (Character.isLetterOrDigit(paramChar)) || (Character.isSpace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue())).append(" ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean c(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String d(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return String.valueOf(paramString);
  }
  
  public static boolean d(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    return (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
  }
  
  public static boolean d(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {}
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      j = paramString.length();
    } while (j < 5);
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label58;
      }
      if (!Character.isDigit(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label58:
    return true;
  }
  
  public static String e(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return paramString;
    }
    paramString = new StringBuffer(paramString);
    while ((paramString.length() > 0) && ((Character.isWhitespace(paramString.charAt(0))) || (paramString.charAt(0) == 0))) {
      paramString.deleteCharAt(0);
    }
    for (int i = paramString.length(); (i > 0) && ((Character.isWhitespace(paramString.charAt(i - 1))) || (paramString.charAt(0) == 0)); i = paramString.length()) {
      paramString.deleteCharAt(i - 1);
    }
    return paramString.toString();
  }
  
  public static boolean e(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      bool = false;
    }
    return bool;
  }
  
  public static String f(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes();
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuffer.append(Integer.toHexString(new Integer(paramString[i] & 0xFF).intValue()));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String g(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public static String h(String paramString)
  {
    paramString = paramString.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!").replaceAll("：", ":");
    return Pattern.compile("[『』]").matcher(paramString).replaceAll("").trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StringUtil
 * JD-Core Version:    0.7.0.1
 */