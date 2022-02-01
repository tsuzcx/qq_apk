package com.tencent.device;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import cwu;
import cwv;

public class DeviceScanner
{
  public static final int a = 16;
  public static final String a = "https://iot.qq.com/add";
  public static final int b = 1000000000;
  static final String b = "smartdevice::DeviceScanner";
  public static final String c = "pid";
  public static final String d = "sn";
  public static final String e = "ScanSmartDevice";
  
  private static void a(Activity paramActivity, ScannerView paramScannerView, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setNegativeButton(2131365737, new cwu(paramScannerView));
    paramActivity.setTitle(paramInt1);
    paramActivity.setMessage(paramInt2);
    paramActivity.show();
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getStringExtra("from");
    } while ((paramActivity == null) || (!"ScanSmartDevice".equals(paramActivity)));
    return true;
  }
  
  public static boolean a(Activity paramActivity, ScannerView paramScannerView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::DeviceScanner", 2, "device qrcode url:" + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    cwv localcwv = new cwv();
    try
    {
      localcwv.a(paramString);
      label56:
      if ((TextUtils.isEmpty(localcwv.a)) || (TextUtils.isEmpty(localcwv.b)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("smartdevice::DeviceScanner", 2, "device qrcode error pid:" + localcwv.a + " sn:" + localcwv.b);
        }
        SmartDeviceReport.a(localQQAppInterface, "Usr_QRCode_Result", 0, 0, 0);
        if (paramActivity != null) {
          a(paramActivity, paramScannerView, 2131362329, 2131362330);
        }
      }
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("smartdevice::DeviceScanner", 2, "device qrcode pid:" + localcwv.a + " sn:" + localcwv.b);
        }
        if (SmartDevicePluginLoader.a().a(localQQAppInterface)) {
          break;
        }
      } while (paramActivity == null);
      paramScannerView = new Intent(paramActivity, DevicePluginDownloadActivity.class);
      paramScannerView.putExtra("DevicePID", localcwv.a);
      paramScannerView.putExtra("DeviceSN", localcwv.b);
      paramActivity.startActivity(paramScannerView);
      return true;
      paramScannerView = new Intent();
      paramScannerView.putExtra("DevicePID", localcwv.a);
      paramScannerView.putExtra("DeviceSN", localcwv.b);
      SmartDevicePluginLoader.a().a(paramActivity, localQQAppInterface, localQQAppInterface.getAccount(), paramScannerView, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
      return true;
    }
    catch (Exception paramString)
    {
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.DeviceScanner
 * JD-Core Version:    0.7.0.1
 */