package com.tencent.mobileqq.activity.widget.qqmusic.common;

public class QQMusicCGIConfig
{
  public static final int a = 0;
  private static final String a = "https://proxy.music.qq.com/";
  public static final int b = 1;
  private static final String b = "https://3g.music.qq.com/";
  public static final int c = 2;
  private static final String c = "https://imgcache.qq.com/";
  public static final int d = 3;
  private static final String d = "https://musict.proxy.music.qq.com/";
  public static final int e = 64;
  private static final String e = "https://musicd.proxy.music.qq.com/";
  public static final int f = 86400;
  private static String f = "";
  public static final int g = 128;
  private static String g = null;
  private static int jdField_h_of_type_Int = 0;
  private static String jdField_h_of_type_JavaLangString = null;
  private static String i = null;
  private static String j = null;
  private static String k = null;
  private static String l = null;
  private static String m = null;
  private static String n = null;
  private static String o = null;
  
  public static String a()
  {
    if (g == null) {
      g = m() + "fcgi-bin/getsession";
    }
    return g;
  }
  
  public static String b()
  {
    if (jdField_h_of_type_JavaLangString == null) {
      jdField_h_of_type_JavaLangString = k() + "fcgi-bin/fcg_music_express_mobile2.fcg";
    }
    return jdField_h_of_type_JavaLangString;
  }
  
  public static String c()
  {
    if (i == null) {
      i = l() + "fcgi-bin/fcg_get_radio_songlist";
    }
    return i;
  }
  
  public static String d()
  {
    if (j == null) {
      j = j() + "rcmusic2/fcgi-bin/fcg_guess_youlike_android.fcg";
    }
    return j;
  }
  
  public static String e()
  {
    if (k == null) {
      k = j() + "fcgi-bin/getfav";
    }
    return k;
  }
  
  public static String f()
  {
    if (l == null) {
      l = n() + "fcgi-bin/3g_get_diss";
    }
    return l;
  }
  
  public static String g()
  {
    if (m == null) {
      m = o() + "fcgi-bin/imusic";
    }
    return m;
  }
  
  public static String h()
  {
    if (n == null) {
      n = o() + "fcgi-bin/iphone_music_fav";
    }
    return n;
  }
  
  public static String i()
  {
    if (o == null) {
      o = o() + "fcgi-bin/fcg_report_radio_song_behavior";
    }
    return o;
  }
  
  private static String j()
  {
    switch (jdField_h_of_type_Int)
    {
    default: 
      return "https://proxy.music.qq.com/";
    case 0: 
      return "https://proxy.music.qq.com/";
    case 1: 
      return "https://musict.proxy.music.qq.com/";
    case 2: 
      return "https://musicd.proxy.music.qq.com/";
    }
    return f;
  }
  
  private static String k()
  {
    String str1;
    switch (jdField_h_of_type_Int)
    {
    default: 
      str1 = "https://proxy.music.qq.com/";
    }
    for (;;)
    {
      String str2 = str1;
      if (jdField_h_of_type_Int != 3) {
        str2 = str1 + "base/";
      }
      return str2;
      str1 = "https://proxy.music.qq.com/";
      continue;
      str1 = "https://musict.proxy.music.qq.com/";
      continue;
      str1 = "https://musicd.proxy.music.qq.com/";
      continue;
      str1 = f;
    }
  }
  
  private static String l()
  {
    String str2 = j();
    String str1 = str2;
    if (jdField_h_of_type_Int != 3) {
      str1 = str2 + "musichall/";
    }
    return str1;
  }
  
  private static String m()
  {
    String str2 = j();
    String str1 = str2;
    if (jdField_h_of_type_Int != 3) {
      str1 = str2 + "3glogin/";
    }
    return str1;
  }
  
  private static String n()
  {
    String str2 = j();
    String str1 = str2;
    if (jdField_h_of_type_Int != 3) {
      str1 = str2 + "folder/";
    }
    return str1;
  }
  
  private static String o()
  {
    String str1;
    switch (jdField_h_of_type_Int)
    {
    default: 
      str1 = "https://proxy.music.qq.com/";
    }
    for (;;)
    {
      String str2 = str1;
      if (jdField_h_of_type_Int != 3) {
        str2 = str1 + "3gmusic/";
      }
      return str2;
      str1 = "https://proxy.music.qq.com/";
      continue;
      str1 = "https://musict.proxy.music.qq.com/";
      continue;
      str1 = "https://musicd.proxy.music.qq.com/";
      continue;
      str1 = f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.common.QQMusicCGIConfig
 * JD-Core Version:    0.7.0.1
 */