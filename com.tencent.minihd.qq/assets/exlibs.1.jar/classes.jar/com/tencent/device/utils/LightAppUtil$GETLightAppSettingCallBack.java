package com.tencent.device.utils;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class LightAppUtil$GETLightAppSettingCallBack
  implements HttpCgiAsyncTask.Callback
{
  public LightAppUtil$GETLightAppSettingCallBack(LightAppUtil paramLightAppUtil) {}
  
  public void a(Exception paramException)
  {
    ToastUtil.a().a(2131362255);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
      this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtility.a("LightAppUtil", "GETLightAppSettingCallBack success");
    int k = paramJSONObject.optInt("ret", -1);
    if (k != 0)
    {
      LogUtility.a("LightAppUtil", "GETLightAppSettingCallBack failed");
      ToastUtil.a().a(2131362254);
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
    }
    for (;;)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null) {
        break label741;
      }
      i = this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
      label113:
      if (!this.a.c) {
        break label730;
      }
      SmartDeviceReport.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "Net_Get_LiteappSetting", 0, k, i);
      return;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("list");
        if (((paramJSONObject != null) && (paramJSONObject.length() != 0)) || (!this.a.b)) {
          break;
        }
        ToastUtil.a().a(2131362254);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
          this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(true);
        }
        SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        ToastUtil.a().a(2131362254);
      }
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
        localLightAppSettingInfo.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("pid");
        localLightAppSettingInfo.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("template_type");
        localLightAppSettingInfo.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("has_own_app");
        localLightAppSettingInfo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("h5_url");
        localLightAppSettingInfo.c = ((JSONObject)localObject).optString("public_url");
        localLightAppSettingInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("own_appid");
        localLightAppSettingInfo.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("device_type");
        localLightAppSettingInfo.b = ((JSONObject)localObject).optString("own_pkgname");
        localLightAppSettingInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("openid");
        localLightAppSettingInfo.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("openkey");
        localLightAppSettingInfo.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("appname");
        localLightAppSettingInfo.h = ((JSONObject)localObject).optInt("bindtype", 1);
        localObject = ((JSONObject)localObject).optString("pub_propertyids").split(",");
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          int m = localObject.length;
          int j = 0;
          while (j < m)
          {
            localArrayList.add(Integer.valueOf(localObject[j]));
            j += 1;
          }
          localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = localArrayList;
        }
        for (;;)
        {
          if (!LightAppUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_f_of_type_Int)))
          {
            LightAppUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_f_of_type_Int), localLightAppSettingInfo);
            LightAppUtil.jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
          }
          if ((!this.a.b) || (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId != localLightAppSettingInfo.jdField_f_of_type_Int)) {
            break;
          }
          this.a.a(this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo);
          break label746;
          LogUtility.e("LightAppUtil", "no ids!");
        }
        if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
          this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
        }
      }
      else
      {
        if ((this.a.c) || (LightAppUtil.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        paramJSONObject = BaseApplicationImpl.a().a();
        if (!(paramJSONObject instanceof QQAppInterface)) {
          break;
        }
        ((SmartDeviceProxyMgr)((QQAppInterface)paramJSONObject).a(53)).a(LightAppUtil.jdField_a_of_type_JavaUtilArrayList);
        break;
        label730:
        SmartDeviceReport.a(null, "Net_Get_LiteappSetting", 0, k, i);
        return;
        label741:
        i = 0;
        break label113;
      }
      label746:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil.GETLightAppSettingCallBack
 * JD-Core Version:    0.7.0.1
 */