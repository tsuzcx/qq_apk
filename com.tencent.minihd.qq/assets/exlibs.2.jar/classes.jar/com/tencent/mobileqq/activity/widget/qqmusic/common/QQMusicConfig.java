package com.tencent.mobileqq.activity.widget.qqmusic.common;

import android.os.Build;

public class QQMusicConfig
{
  public static final int a = 3;
  public static final String a = "10014292";
  public static final boolean a = true;
  public static final int b = 4070003;
  public static final String b = "https://ws.stream.qqmusic.qq.com/";
  public static final String c = "https://share.weiyun.qq.com/share_dl.fcg";
  
  public static String a()
  {
    String str2 = Build.MODEL;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = "android";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicConfig
 * JD-Core Version:    0.7.0.1
 */