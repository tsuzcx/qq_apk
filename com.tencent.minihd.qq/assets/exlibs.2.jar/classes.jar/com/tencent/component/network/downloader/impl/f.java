package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;
import cum;
import cun;

public class f
{
  public static void a(Downloader paramDownloader)
  {
    if (paramDownloader == null) {
      return;
    }
    paramDownloader.a(new cum(paramDownloader));
    paramDownloader.a(new cun());
  }
  
  private static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("photo.store.qq.com")) && (!paramString.endsWith("qpic.cn"))) {
      return false;
    }
    return true;
  }
  
  private static boolean d(String paramString)
  {
    boolean bool1 = false;
    try
    {
      if ((!"m.qpic.cn".equalsIgnoreCase(paramString)) && (!"a1.qpic.cn".equalsIgnoreCase(paramString)) && (!"a2.qpic.cn".equalsIgnoreCase(paramString)) && (!"a3.qpic.cn".equalsIgnoreCase(paramString)))
      {
        boolean bool2 = "a4.qpic.cn".equalsIgnoreCase(paramString);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.f
 * JD-Core Version:    0.7.0.1
 */