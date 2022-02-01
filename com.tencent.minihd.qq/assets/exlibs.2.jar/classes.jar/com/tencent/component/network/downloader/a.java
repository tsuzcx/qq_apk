package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;
import cud;
import cue;

public abstract class a
{
  public static final a a = new cud(null);
  public static final a b = new cue(null);
  
  private static boolean b(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!NetworkUtils.a(paramString)) {
      return paramString;
    }
    return b(paramString);
  }
  
  public abstract String b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.a
 * JD-Core Version:    0.7.0.1
 */