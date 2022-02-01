package com.tencent.mobileqq.activity.widget.qqmusic.business.player;

import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;

public class UtilForFromTag
{
  public static final int a = 57;
  public static final String a = "&";
  public static final int b = 58;
  public static final String b = "&amp;";
  public static final int c = 59;
  public static final String c = "fromtag=";
  public static final int d = 60;
  public static final int e = 46;
  public static final int f = 50;
  
  public static String a(String paramString)
  {
    if (ApnManager.b()) {
      return a(paramString, 59);
    }
    return a(paramString, 60);
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false);
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = "&";
    if ((paramBoolean) || (paramString.contains("&amp;"))) {
      str1 = "&amp;";
    }
    int i = paramString.indexOf("fromtag=");
    String str2;
    if (i >= 0)
    {
      str2 = paramString.substring(0, i);
      paramString = paramString.substring(i);
      i = paramString.indexOf(str1);
      if (i < 0) {
        break label168;
      }
    }
    label168:
    for (paramString = paramString.substring(i);; paramString = "")
    {
      localStringBuilder.append(str2);
      localStringBuilder.append("fromtag=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      localStringBuilder.append(paramString);
      if (!paramString.contains("?")) {
        localStringBuilder.append("?");
      }
      for (;;)
      {
        localStringBuilder.append("fromtag=");
        localStringBuilder.append(paramInt);
        break;
        localStringBuilder.append(str1);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (ApnManager.b()) {
      return a(paramString, 57);
    }
    return a(paramString, 58);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.player.UtilForFromTag
 * JD-Core Version:    0.7.0.1
 */