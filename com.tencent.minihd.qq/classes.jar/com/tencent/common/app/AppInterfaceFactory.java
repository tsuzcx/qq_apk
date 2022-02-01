package com.tencent.common.app;

import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.buscard.BuscardHelper;
import cooperation.qlink.QlinkHelper;
import cooperation.qqdataline.DatalineHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.secmsg.SecMsgHelper;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.thirdpay.ThirdPayManager;
import cooperation.weiyun.WeiyunHelper;
import mqq.app.AppRuntime;

public class AppInterfaceFactory
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    Object localObject2 = null;
    String str = paramBaseApplicationImpl.getPackageName();
    Object localObject1;
    if (str.equals(paramString)) {
      localObject1 = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (paramString.equals(str + ":msf"));
        localObject1 = localObject2;
      } while (paramString.equals(str + ":notifypush"));
      if (paramString.equals(str + ":video")) {
        return new QavAppInterface(paramBaseApplicationImpl, "video");
      }
      localObject1 = localObject2;
    } while (paramString.equals(str + ":qzone"));
    if (paramString.equals(str + ":qzonevideo")) {
      return QZoneHelper.b(paramBaseApplicationImpl, "qzonevideo");
    }
    if (paramString.equals(str + ":web")) {
      return new BrowserAppInterface(paramBaseApplicationImpl, "web");
    }
    if (paramString.equals(str + ":openSdk")) {
      return new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
    }
    if (paramString.equals(str + ":photoedit"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":zebra")) {
      return new PluginRuntime();
    }
    if (paramString.equals(str + ":demoji"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":map")) {
      return new QQMapActivity.MapRuntime();
    }
    if (paramString.equals(str + ":weiyun"))
    {
      paramBaseApplicationImpl = WeiyunHelper.a(paramBaseApplicationImpl);
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":secmsg"))
    {
      paramBaseApplicationImpl = SecMsgHelper.a(paramBaseApplicationImpl);
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qwallet"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qqfav")) {
      return QfavHelper.a(paramBaseApplicationImpl);
    }
    if (paramString.equals(str + ":qqreader"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qlink")) {
      return QlinkHelper.a(paramBaseApplicationImpl, "qlink");
    }
    if (paramString.equals(str + ":cardpay"))
    {
      paramString = new PluginRuntime();
      ReportController.a(paramString);
      paramBaseApplicationImpl = ThirdPayManager.a(paramBaseApplicationImpl, "cardpay");
      if (paramBaseApplicationImpl != null) {
        break label943;
      }
      paramBaseApplicationImpl = paramString;
    }
    label943:
    for (;;)
    {
      return paramBaseApplicationImpl;
      if (paramString.equals(str + ":peak")) {
        return new PeakAppInterface(paramBaseApplicationImpl, "peak");
      }
      if (paramString.equals(str + ":qqwifi"))
      {
        paramBaseApplicationImpl = QQWiFiHelper.a(paramBaseApplicationImpl, "qqwifi");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":qqwifiditu"))
      {
        paramBaseApplicationImpl = QQWiFiHelper.b(paramBaseApplicationImpl, "qqwifiditu");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      if (paramString.equals(str + ":dataline")) {
        return DatalineHelper.a(paramBaseApplicationImpl, "dataline");
      }
      if (paramString.equals(str + ":smartdevice")) {
        return SmartDevicePluginLoader.a(paramBaseApplicationImpl, "smartdevice");
      }
      if (paramString.equals(str + ":buscard"))
      {
        paramBaseApplicationImpl = BuscardHelper.a(paramBaseApplicationImpl, "buscard");
        ReportController.a((PluginRuntime)paramBaseApplicationImpl);
        return paramBaseApplicationImpl;
      }
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.common.app.AppInterfaceFactory
 * JD-Core Version:    0.7.0.1
 */