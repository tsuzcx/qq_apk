package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;

public class AvatarTroopUtil
{
  public static final int a = 100;
  public static final String a = "https://p.qlogo.cn/gh/dir/file/";
  public static final int b = 640;
  protected static String b = "https://p.qlogo.cn/gh/";
  public static final int c = 0;
  public static final int d = 0;
  public static final int e = 1;
  
  public static String a(String paramString)
  {
    if (a(paramString)) {
      return paramString + 100;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str = "https://p.qlogo.cn/gh/dir/file/";
    if (1 == paramInt) {
      paramString1 = "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
    }
    do
    {
      return paramString1;
      paramString1 = str;
    } while (paramInt != 0);
    return "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith(b);
  }
  
  public static String b(String paramString)
  {
    if (a(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.length();
      int k;
      do
      {
        k = j - 1;
        if (k < i) {
          break;
        }
        j = k;
      } while (Character.isDigit(paramString.charAt(k)));
      return false;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AvatarTroopUtil
 * JD-Core Version:    0.7.0.1
 */