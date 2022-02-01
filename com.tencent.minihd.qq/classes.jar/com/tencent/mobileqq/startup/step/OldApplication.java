package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.utils.SoLoadReportImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import cooperation.plugin.PluginAdapterImpl;

public class OldApplication
  extends Step
{
  protected boolean a()
  {
    mqq.app.MainService.isDebugVersion = false;
    if (BaseApplicationImpl.g == 1)
    {
      long l = SystemClock.uptimeMillis();
      BaseApplicationImpl.jdField_a_of_type_Long = l;
      BaseApplicationImpl.b = l;
      BaseApplicationImpl.c = BaseApplicationImpl.jdField_a_of_type_Long;
      BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler = new Handler();
      IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
    }
    for (;;)
    {
      BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
      SoLoadUtilNew.setReport(new SoLoadReportImpl());
      TimeFormatterUtils.a();
      BaseApplicationImpl.appnewmsgicon = 2130838570;
      BaseApplicationImpl.appnewavmsgicon = 2130838900;
      BaseApplicationImpl.qqlaunchicon = 2130838429;
      BaseApplicationImpl.qqWifiLayout = 2130904065;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131300703;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131300705;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131300706;
      BaseApplicationImpl.qqWifiSettingViewId = 2131297509;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130840667;
      BaseApplicationImpl.qqWifiNoSignal = 2130840669;
      BaseApplicationImpl.qqWifiUserful = 2130840675;
      BaseApplicationImpl.qqWifiSettings = 2130840673;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130840672;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130840671;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130840670;
      BaseApplicationImpl.qqwifinotifydivide = 2131427521;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131165186;
      BaseApplicationImpl.devlockQuickloginIcon = 2130839616;
      try
      {
        Class.forName("android.os.AsyncTask");
        if (BaseApplicationImpl.g == 1)
        {
          return true;
          if (BaseApplicationImpl.g == 4) {
            continue;
          }
          IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */