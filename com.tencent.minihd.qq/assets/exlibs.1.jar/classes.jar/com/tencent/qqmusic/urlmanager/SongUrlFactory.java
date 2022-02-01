package com.tencent.qqmusic.urlmanager;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;

public class SongUrlFactory
{
  private static final String a = "SongUrlFactory";
  
  static
  {
    try
    {
      System.loadLibrary("SongUrlFactory");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      MLog.a("SongUrlFactory", localUnsatisfiedLinkError);
    }
  }
  
  private static String a(long paramLong, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("https://ws.stream.qqmusic.qq.com/");
    localStringBuffer.append(b(paramLong, paramInt));
    return localStringBuffer.toString();
  }
  
  public static String a(SongInfo paramSongInfo, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    for (;;)
    {
      try
      {
        localSession = SessionManager.a().a();
        if (localSession == null) {
          return "";
        }
        if (!paramBoolean) {
          continue;
        }
        if (TextUtils.isEmpty(paramSongInfo.d().trim())) {
          continue;
        }
        localObject1 = a(paramSongInfo.d(), paramInt);
      }
      catch (Exception paramSongInfo)
      {
        Session localSession;
        MLog.a("SongUrlFactory", paramSongInfo);
        localObject1 = "";
        continue;
      }
      catch (Error paramSongInfo)
      {
        MLog.a("SongUrlFactory", paramSongInfo);
        localObject1 = localObject2;
        continue;
      }
      if (localObject1 != null) {
        return localObject1;
      }
      return "";
      localObject1 = a(paramSongInfo.b(), paramInt);
      continue;
      if (paramInt == 0)
      {
        if (!TextUtils.isEmpty(paramSongInfo.d())) {
          localObject1 = a(paramSongInfo.d(), paramInt);
        } else {
          localObject1 = a(paramSongInfo.b(), paramInt);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (localSession.b() != null) {
          localObject1 = getUrlBySongId(localSession.b(), (int)paramSongInfo.b(), paramInt, false);
        }
      }
    }
    return localObject1;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = getEncryptedIMEI(paramString);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString) {}
    return "";
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("https://ws.stream.qqmusic.qq.com/");
    localStringBuffer.append(b(paramString, paramInt));
    return localStringBuffer.toString();
  }
  
  private static String b(long paramLong, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      localStringBuffer.append(paramLong);
      localStringBuffer.append(".");
      localStringBuffer.append(str);
      return localStringBuffer.toString();
      paramLong += 0L;
      str = "m4a";
      continue;
      paramLong += 10000000L;
      str = "m4a";
      continue;
      paramLong += 20000000L;
      str = "m4a";
      continue;
      paramLong += 30000000L;
      str = "mp3";
      continue;
      paramLong += 40000000L;
      str = "ogg";
      continue;
      paramLong += 50000000L;
      str = "m4a";
      continue;
      paramLong += 0L;
      str = "mp3";
      continue;
      paramLong += 70000000L;
      str = "flac";
      continue;
      paramLong += 80000000L;
      str = "ape";
    }
  }
  
  private static String b(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str1;
    switch (paramInt)
    {
    default: 
      String str2 = "";
      str1 = paramString;
      paramString = str2;
    }
    for (;;)
    {
      localStringBuffer.append(str1);
      localStringBuffer.append(".");
      localStringBuffer.append(paramString);
      return localStringBuffer.toString();
      str1 = "C100" + paramString;
      paramString = "m4a";
      continue;
      str1 = "C200" + paramString;
      paramString = "m4a";
      continue;
      str1 = "C400" + paramString;
      paramString = "m4a";
      continue;
      str1 = "M500" + paramString;
      paramString = "mp3";
      continue;
      str1 = "O600" + paramString;
      paramString = "ogg";
      continue;
      str1 = "C600" + paramString;
      paramString = "m4a";
      continue;
      str1 = "M800" + paramString;
      paramString = "mp3";
      continue;
      str1 = "F000" + paramString;
      paramString = "flac";
      continue;
      str1 = "A000" + paramString;
      paramString = "ape";
      continue;
      str1 = "L200" + paramString;
      paramString = "m4a";
      continue;
      str1 = "L400" + paramString;
      paramString = "m4a";
      continue;
      str1 = "L500" + paramString;
      paramString = "mp3";
    }
  }
  
  private static native String getEncryptedIMEI(String paramString);
  
  private native String getUrlByMid(String paramString1, String paramString2, int paramInt);
  
  private static native String getUrlBySongId(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native boolean isARMFamily();
  
  public static native boolean isSupportFPU();
  
  public static native boolean isSupportNeon();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqmusic.urlmanager.SongUrlFactory
 * JD-Core Version:    0.7.0.1
 */