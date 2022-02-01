package com.tencent.device.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import cooperation.plugin.PluginBaseActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import dbo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

public class LightAppUtil
{
  public static final int a = 0;
  protected static long a = 0L;
  protected static final String a = "LightAppUtil";
  public static ArrayList a;
  public static volatile ConcurrentHashMap a;
  public static final int b = 1;
  protected static final long b = 15000L;
  protected static final String b = "LightAppUtil";
  public static final int c = 2;
  protected static final String c = "https://qzs.qq.com/open/mobile/qq_download/index.html";
  public static final int d = 3;
  public static final String d = "https://qzs.qq.com/open/mobile/share_device/agreement.html";
  public Activity a;
  protected DeviceInfo a;
  public LightAppUtil.GetLightAppSettingListener a;
  public QQProgressDialog a;
  protected AppRuntime a;
  protected SSOAccountObserver a;
  protected boolean a;
  public ArrayList b;
  protected boolean b;
  protected boolean c = false;
  public String e;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Long = 0L;
  }
  
  public LightAppUtil()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new dbo(this);
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.a().a();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new dbo(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity, LightAppUtil.GetLightAppSettingListener paramGetLightAppSettingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new dbo(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener = paramGetLightAppSettingListener;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public static String a(Resources paramResources, LightAppSettingInfo paramLightAppSettingInfo, String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("null")) {}
    }
    else
    {
      str = paramResources.getString(2131362259);
    }
    if ((!TextUtils.isEmpty(paramLightAppSettingInfo.b)) && (!TextUtils.isEmpty(paramLightAppSettingInfo.a)) && (AppUtil.a(paramLightAppSettingInfo.b))) {
      return paramResources.getString(2131362258, new Object[] { str });
    }
    return paramResources.getString(2131362257, new Object[] { str });
  }
  
  public static String a(BaseActivity paramBaseActivity)
  {
    return ((TicketManager)paramBaseActivity.getAppRuntime().getManager(2)).getVkey(paramBaseActivity.getAppRuntime().getAccount());
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString3)) && (AppUtil.a(paramString3)))
    {
      AppUtil.a(paramActivity, paramString3);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("sid", paramString2);
    localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ");
    localBundle.putBoolean("autoDownload", false);
    localBundle.putString("packageName", paramString3);
    AppClient.a(paramActivity, paramString4, 2470, localBundle);
  }
  
  public static void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      LightAppSettingInfo localLightAppSettingInfo = (LightAppSettingInfo)paramArrayList.next();
      if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.f)))
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.f), localLightAppSettingInfo);
        jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
      }
    }
  }
  
  public LightAppSettingInfo a(DeviceInfo paramDeviceInfo)
  {
    LightAppSettingInfo localLightAppSettingInfo2 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
    LightAppSettingInfo localLightAppSettingInfo1 = localLightAppSettingInfo2;
    if (localLightAppSettingInfo2 == null)
    {
      localLightAppSettingInfo1 = localLightAppSettingInfo2;
      if (!this.c)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
        localLightAppSettingInfo1 = localLightAppSettingInfo2;
        if ((localAppRuntime instanceof QQAppInterface))
        {
          a(((SmartDeviceProxyMgr)((QQAppInterface)localAppRuntime).a(53)).a());
          localLightAppSettingInfo1 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
        }
      }
    }
    return localLightAppSettingInfo1;
  }
  
  public void a()
  {
    Object localObject1 = BaseApplicationImpl.a().a();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).a(53)).a();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        if (SystemClock.elapsedRealtime() - jdField_a_of_type_Long > 15000L)
        {
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localObject2.productId))) {
              localArrayList.add(Integer.valueOf(localObject2.productId));
            }
            i += 1;
          }
          if (localArrayList.size() > 0) {
            a(localArrayList, false);
          }
        }
      }
    }
  }
  
  public void a(DeviceInfo paramDeviceInfo)
  {
    if (paramDeviceInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    Object localObject2 = a(paramDeviceInfo);
    String str;
    Object localObject1;
    if (localObject2 != null) {
      if ((((LightAppSettingInfo)localObject2).h != 3) && (((LightAppSettingInfo)localObject2).h != 5) && (((LightAppSettingInfo)localObject2).h != 4) && (((LightAppSettingInfo)localObject2).h != 1))
      {
        str = null;
        localObject1 = null;
      }
    }
    for (;;)
    {
      label79:
      if ((str == null) && (localObject1 == null))
      {
        paramDeviceInfo = new Intent();
        paramDeviceInfo.setClassName("com.tencent.minihd.qq", "com.tencent.biz.pubaccount.PublicAccountBrowser");
        paramDeviceInfo.putExtra("url", "https://qzs.qq.com/open/mobile/qq_download/index.html");
        SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, ((LightAppSettingInfo)localObject2).f);
        if (str != null) {
          break label469;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
          break label548;
        }
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(true);
        return;
        if (((LightAppSettingInfo)localObject2).jdField_d_of_type_Int == 0) {
          switch (((LightAppSettingInfo)localObject2).g)
          {
          default: 
            if ((TextUtils.isEmpty(((LightAppSettingInfo)localObject2).c)) && (TextUtils.isEmpty(((LightAppSettingInfo)localObject2).jdField_d_of_type_JavaLangString))) {
              break label677;
            }
            str = "com.tencent.device.lightapp.LightAppActivity";
            localObject1 = null;
            break;
          case 2: 
            str = "com.tencent.device.av.VideoActivity";
            localObject1 = null;
            break;
          case 9: 
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName("com.tencent.minihd.qq", "com.dataline.activities.DLRouterActivity");
            ((Intent)localObject1).putExtra("isBack2Root", true);
            str = null;
            break;
          }
        }
        if (((LightAppSettingInfo)localObject2).jdField_d_of_type_Int == 1)
        {
          if ((TextUtils.isEmpty(((LightAppSettingInfo)localObject2).c)) && (TextUtils.isEmpty(((LightAppSettingInfo)localObject2).jdField_d_of_type_JavaLangString))) {
            break label677;
          }
          str = "com.tencent.device.lightapp.LightAppActivity";
          localObject1 = null;
          break label79;
        }
        ToastUtil.a().a(2131362256);
        if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
        return;
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("device_info", paramDeviceInfo);
        localBundle.putParcelable("lightapp_setting", (Parcelable)localObject2);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Intent();
        }
        ((Intent)localObject2).putExtra("uin", String.valueOf(paramDeviceInfo.din));
        if (TextUtils.isEmpty(paramDeviceInfo.remark)) {}
        for (localObject1 = paramDeviceInfo.name;; localObject1 = paramDeviceInfo.remark)
        {
          ((Intent)localObject2).putExtra("uinname", (String)localObject1);
          ((Intent)localObject2).putExtra("account", paramDeviceInfo.serialNum);
          ((Intent)localObject2).putExtra("device_info", paramDeviceInfo);
          ((Intent)localObject2).putExtras(localBundle);
          paramDeviceInfo = (DeviceInfo)localObject2;
          break;
        }
        label469:
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
        {
          paramDeviceInfo.setClassName(this.jdField_a_of_type_AndroidAppActivity, str);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
        }
        else
        {
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) {
            paramDeviceInfo.putExtra("bFromChatActivity", true);
          }
          SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), paramDeviceInfo, str, -1, null, SmartDevicePluginProxyActivity.class);
        }
      }
      label548:
      break;
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
      {
        if (!NetworkUtil.f(this.jdField_a_of_type_AndroidAppActivity))
        {
          ToastUtil.a().a(2131362255);
          if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          return;
        }
        this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = paramDeviceInfo;
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(Integer.valueOf(paramDeviceInfo.productId));
        a((ArrayList)localObject1, true);
        return;
      }
      ToastUtil.a().a(2131362254);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      return;
      label677:
      str = null;
      localObject1 = null;
    }
  }
  
  protected void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break label92;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492923));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362253);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      LogUtility.d("LightAppUtil", "app == null when dologin");
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
      label92:
      this.jdField_a_of_type_Boolean = false;
    }
    this.e = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    if (TextUtils.isEmpty(this.e)) {
      ToastUtil.a().a(2131368105);
    }
    LogUtility.d("LightAppUtil", "start getSkey");
    this.jdField_a_of_type_MqqAppAppRuntime.ssoGetTicketNoPasswd(this.e, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil
 * JD-Core Version:    0.7.0.1
 */