package com.tencent.qav.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.qav.QavSDK;
import com.tencent.qav.log.AVLog;

public class DeviceInfoUtil
{
  private static final String TAG = "DeviceInfoUtil";
  private static String sDeviceId = "";
  private static String sIMSI = "";
  
  public static String getIMEI()
  {
    if ((sDeviceId != null) && (sDeviceId.length() > 0)) {
      return sDeviceId;
    }
    try
    {
      sDeviceId = ((TelephonyManager)QavSDK.getInstance().getContext().getSystemService("phone")).getDeviceId();
      return sDeviceId;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.e("DeviceInfoUtil", "getIMEI fail.", localException);
      }
    }
  }
  
  public static String getIMSI()
  {
    if ((sIMSI != null) && (sIMSI.length() > 0)) {
      return sIMSI;
    }
    try
    {
      sIMSI = ((TelephonyManager)QavSDK.getInstance().getContext().getSystemService("phone")).getSubscriberId();
      return sIMSI;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.e("DeviceInfoUtil", "getIMSI fail.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.utils.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */