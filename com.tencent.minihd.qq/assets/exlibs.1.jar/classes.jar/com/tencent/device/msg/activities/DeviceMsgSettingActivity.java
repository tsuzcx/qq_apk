package com.tencent.device.msg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.widget.Switch;
import daw;
import dax;
import day;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceMsgSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public Handler a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DeviceInfo jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo;
  public QQProgressDialog a;
  public String a;
  public ArrayList a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public String b;
  public String c;
  public String d;
  
  public DeviceMsgSettingActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new daw(this);
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j)
    {
      day localday = (day)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(localday.jdField_a_of_type_JavaLangString);
      localFormSwitchItem.setFocusable(true);
      label72:
      Switch localSwitch;
      if (j == 1)
      {
        localFormSwitchItem.setBgType(0);
        localSwitch = localFormSwitchItem.a();
        localSwitch.setTag(Integer.valueOf(localday.jdField_a_of_type_Int));
        if (localday.b != 1) {
          break label169;
        }
      }
      label169:
      for (boolean bool = true;; bool = false)
      {
        localSwitch.setChecked(bool);
        localSwitch.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
        i += 1;
        break;
        if (i == 0)
        {
          localFormSwitchItem.setBgType(1);
          break label72;
        }
        if (i == j - 1)
        {
          localFormSwitchItem.setBgType(3);
          break label72;
        }
        localFormSwitchItem.setBgType(2);
        break label72;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903265);
    setTitle(2131362317);
    paramBundle = super.getIntent();
    this.b = String.valueOf(paramBundle.getIntExtra("pid", 0));
    this.c = paramBundle.getStringExtra("din");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297461));
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(1));
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_a_of_type_JavaLangString, 16))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_JavaLangString, 131072, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362335);
      if ((!isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(53)).a(Long.parseLong(this.c));
    SmartDeviceReport.a(this.app, "Usr_MsgMgr_Open", 0, 0, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362339);
    if ((!isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (day)((Iterator)localObject1).next();
      if (((day)localObject2).jdField_a_of_type_Int == j)
      {
        int k = ((day)localObject2).b;
        if (paramBoolean)
        {
          i = 1;
          if (k != i) {
            break label152;
          }
          paramCompoundButton = this.app;
          if (!paramBoolean) {
            break label147;
          }
        }
        label147:
        for (int i = 1;; i = 2)
        {
          SmartDeviceReport.a(paramCompoundButton, "Usr_MsgMgr_Setting", i, 1, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
          return;
          i = 0;
          break;
        }
        for (;;)
        {
          try
          {
            label152:
            localObject2 = new JSONObject().put("id", ((day)localObject2).jdField_a_of_type_Int);
            if (!paramBoolean) {
              break label206;
            }
            i = 1;
            localJSONArray.put(((JSONObject)localObject2).put("enable", i));
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          break;
          label206:
          i = 0;
        }
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("vkey", this.d);
    ((Bundle)localObject1).putString("uin", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject1).putString("din", this.c);
    ((Bundle)localObject1).putString("pid", this.b);
    ((Bundle)localObject1).putString("appid", "1300000607");
    ((Bundle)localObject1).putString("data", localJSONArray.toString());
    new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/set_lightapp_property", "GET", new dax(this, j, paramCompoundButton)).a((Bundle)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */