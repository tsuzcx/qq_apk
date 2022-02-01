package com.tencent.qphone.base.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.util.ArrayList;
import java.util.Properties;

public abstract class BaseApplication
  extends Application
{
  public static int appnewavmsgicon;
  public static int appnewmsgicon = 0;
  public static BaseApplication context;
  public static int defaultNotifSoundResourceId = 0;
  public static int devlockQuickloginIcon = 0;
  public static ArrayList exclusiveStreamList = new ArrayList();
  public static MonitorSocketStat monitor;
  public static int qqWifiConnecticon3;
  public static int qqWifiLayout;
  public static int qqWifiMissions;
  public static int qqWifiNoSignal;
  public static int qqWifiOperation;
  public static int qqWifiOperationTextViewId;
  public static int qqWifiRedTouchViewId;
  public static int qqWifiSettingViewId;
  public static int qqWifiSettings;
  public static int qqWifiStateIconViewId;
  public static int qqWifiStateTextViewId;
  public static int qqWifiUserful;
  public static int qqlaunchicon;
  public static int qqwifinotifyconnectedicon;
  public static int qqwifinotifydivide;
  public static int qqwifinotifynoneicon;
  public static int qqwifinotifyusefulicon;
  
  static
  {
    appnewavmsgicon = 0;
    qqlaunchicon = 0;
    qqWifiLayout = 0;
    qqWifiStateIconViewId = 0;
    qqWifiStateTextViewId = 0;
    qqWifiOperationTextViewId = 0;
    qqWifiSettingViewId = 0;
    qqWifiRedTouchViewId = 0;
    qqWifiConnecticon3 = 0;
    qqWifiNoSignal = 0;
    qqWifiUserful = 0;
    qqWifiMissions = 0;
    qqWifiSettings = 0;
    qqWifiOperation = 0;
    qqwifinotifyusefulicon = 0;
    qqwifinotifynoneicon = 0;
    qqwifinotifyconnectedicon = 0;
    qqwifinotifydivide = 0;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public boolean doesHasPhonePermission()
  {
    return false;
  }
  
  public boolean doesHasSDCardPermission()
  {
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    context = this;
    monitor = new MonitorSocketStat();
    long l = System.currentTimeMillis();
    for (;;)
    {
      Object localObject1;
      try
      {
        File localFile = new File(context.getFilesDir().getAbsolutePath() + "/monitor_config.properties");
        if ((localFile == null) || (!localFile.exists()))
        {
          QLog.d("MSF.D.MonitorSocket", 1, "monitor_config not found, disable monitor socket");
          localObject6 = null;
          localFile = null;
          if (localFile != null) {
            break label320;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "phoneDisplays is null, close Monitor Socket");
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "BaseApplication initialization used " + (System.currentTimeMillis() - l) + "ms");
          }
          return;
        }
      }
      catch (Exception localException1)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException1);
        localObject1 = null;
        continue;
      }
      for (;;)
      {
        try
        {
          localObject3 = new FileInputStream((File)localObject1);
          localObject4 = new Properties();
          ((Properties)localObject4).load((InputStream)localObject3);
          localObject1 = ((Properties)localObject4).getProperty("model");
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Object localObject3;
            Object localObject2;
            try
            {
              localObject4 = ((Properties)localObject4).getProperty("display");
            }
            catch (Exception localException4)
            {
              Object localObject4;
              Object localObject5;
              localObject6 = null;
              localObject3 = localException2;
              localObject2 = localObject6;
              continue;
            }
            try
            {
              ((FileInputStream)localObject3).close();
              localObject3 = localObject1;
              localObject6 = localObject3;
              localObject1 = localObject4;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.D.MonitorSocket", 2, "phoneDisplays: " + (String)localObject4 + ", phoneModels: " + (String)localObject3);
              localObject6 = localObject3;
              localObject1 = localObject4;
            }
            catch (Exception localException6)
            {
              localObject3 = localObject2;
              localObject2 = localException4;
              Exception localException5 = localException6;
            }
          }
          localException3 = localException3;
          localObject1 = null;
          localObject3 = null;
        }
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException3);
        localObject5 = localObject1;
      }
      label320:
      if ((Build.VERSION.SDK_INT >= 19) && ((Build.DISPLAY.toUpperCase().contains("KOT49H")) || (Build.DISPLAY.toUpperCase().contains("KTU84P"))))
      {
        QLog.d("MSF.D.MonitorSocket", 1, "Samsung above android 4.4 rom Donot Monitor Socket Netflow");
      }
      else if ((((String)localObject1).contains(Build.DISPLAY.toUpperCase())) || (localObject6.contains(Build.MODEL.toUpperCase())))
      {
        QLog.d("MSF.D.MonitorSocket", 1, "Phone display|model in banlist, close Monitor Socket");
      }
      else
      {
        localObject1 = new MonitorSocketImplFactory();
        if (((MonitorSocketImplFactory)localObject1).getMsfSocketImpl(getContext()) == true) {
          try
          {
            Socket.setSocketImplFactory((SocketImplFactory)localObject1);
          }
          catch (Exception localException2)
          {
            QLog.d("MSF.D.MonitorSocket", 1, "set socketimpl factory failed.");
          }
        } else {
          QLog.d("MSF.D.MonitorSocket", 1, "get socketimpl failed.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */