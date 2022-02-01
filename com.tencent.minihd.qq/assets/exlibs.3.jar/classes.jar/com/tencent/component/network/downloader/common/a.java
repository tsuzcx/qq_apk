package com.tencent.component.network.downloader.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Parcel;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.NetworkUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: new 18	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 22	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 26	java/net/URL:getAuthority	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne -18 -> 7
    //   28: aload_0
    //   29: ldc 28
    //   31: invokevirtual 33	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   34: istore_1
    //   35: iload_1
    //   36: iflt -29 -> 7
    //   39: aload_0
    //   40: invokevirtual 37	java/lang/String:length	()I
    //   43: istore_2
    //   44: iload_1
    //   45: iload_2
    //   46: if_icmpge -39 -> 7
    //   49: aload_0
    //   50: iload_1
    //   51: iconst_1
    //   52: iadd
    //   53: invokevirtual 41	java/lang/String:substring	(I)Ljava/lang/String;
    //   56: invokestatic 47	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   59: invokevirtual 50	java/lang/Integer:intValue	()I
    //   62: istore_1
    //   63: iload_1
    //   64: ireturn
    //   65: astore_0
    //   66: iconst_m1
    //   67: ireturn
    //   68: astore_0
    //   69: iconst_m1
    //   70: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramString	String
    //   34	30	1	i	int
    //   43	4	2	j	int
    // Exception table:
    //   from	to	target	type
    //   9	35	65	java/net/MalformedURLException
    //   39	44	65	java/net/MalformedURLException
    //   49	63	65	java/net/MalformedURLException
    //   49	63	68	java/lang/Exception
  }
  
  public static int a(String paramString, char paramChar)
  {
    int i = 0;
    int k = 0;
    if (paramString == null) {
      return k;
    }
    int m = paramString.length();
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramChar == paramString.charAt(j)) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  public static Parcel a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    if (paramArrayOfByte == null) {
      return localParcel;
    }
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      return localParcel;
    }
    catch (Exception paramArrayOfByte) {}
    return localParcel;
  }
  
  public static String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getRunningAppProcesses();
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == i)
          {
            paramContext = localRunningAppProcessInfo.processName;
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String a(String paramString)
  {
    String str2 = null;
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    for (;;)
    {
      return paramString;
      str1 = str2;
      try
      {
        str2 = new URL(paramString).getAuthority();
        paramString = str2;
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          int i = str2.indexOf(":");
          paramString = str2;
          if (i >= 0)
          {
            paramString = str2;
            str1 = str2;
            if (i < str2.length())
            {
              str1 = str2;
              paramString = str2.substring(0, i);
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString) {}
    }
    return str1;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 65535);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (NetworkUtils.a(paramString));
  }
  
  public static boolean a(Pattern paramPattern, String paramString)
  {
    if ((paramPattern == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      boolean bool = paramPattern.matcher(paramString).matches();
      return bool;
    }
    catch (Exception paramPattern)
    {
      b.d("Utils", "", paramPattern);
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.a
 * JD-Core Version:    0.7.0.1
 */