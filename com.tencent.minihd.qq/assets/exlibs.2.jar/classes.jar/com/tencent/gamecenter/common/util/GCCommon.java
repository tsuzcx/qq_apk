package com.tencent.gamecenter.common.util;

import android.content.Context;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GCCommon
  extends Common
{
  private static final String F = ".GameCenterWebBuffer";
  private static final String G = ;
  public static final String a = "GameCenter";
  public static final String b = "WebPages/android";
  public static final String c = "Images/games";
  public static final String d = "Apk";
  public static final String e = "https://gamecenter.qq.com/gamecenter/index/index.html";
  public static final String f = "https://gamecenter.qq.com/md5";
  public static final String g = "https://gamecenter.qq.com/appfriends/get_recent";
  public static final String h = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
  public static final String i = "https://gamecenter.qq.com/report/action";
  public static final String j = "https://gamecenter.qq.com/report/pg_act?appid=%1$s&sid=%2$s&tt=1&osv=%3$s";
  public static final String k = "https://pay.qq.com/h5/index.shtml?m=buy&c=qqacct_save&pf=2201";
  public static final String l = "com.qq.AppService";
  public static final String m = "ANDROIDQQ.GAME.RECENT";
  
  public static int a(String paramString)
  {
    int n = -1;
    try
    {
      int i1 = Integer.parseInt(paramString);
      n = i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameCenter", 4, "try parse string param to int exception. value:" + paramString + ". msg - " + localNumberFormatException.getMessage());
    }
    return n;
    return -1;
  }
  
  public static long a(String paramString)
  {
    long l1 = -1L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameCenter", 4, "try parse string param to long exception. value:" + paramString + ". msg - " + localNumberFormatException.getMessage());
    }
    return l1;
    return -1L;
  }
  
  public static String a()
  {
    return G + File.separator + ".GameCenterWebBuffer" + File.separator + "Images/games";
  }
  
  public static String a(Context paramContext)
  {
    return QQDeviceInfo.a();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString2 = a();
    return paramString2 + File.separator + paramString1;
  }
  
  public static String b()
  {
    return G + File.separator + ".GameCenterWebBuffer" + File.separator + "WebPages/android" + File.separator + "notupdate.txt";
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return paramString1 + "_" + MD5Utils.b(paramString2) + ".apk";
  }
  
  public static String c()
  {
    return G + File.separator + "download" + File.separator + "Apk";
  }
  
  public static String d()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return localObject;
    }
    catch (SocketException localSocketException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GCCommon
 * JD-Core Version:    0.7.0.1
 */