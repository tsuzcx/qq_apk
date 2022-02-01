package com.dataline.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cq;
import cr;
import cs;

public class RouterAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "unbind_flag";
  public static final String b = "guid_flag";
  private static final String c = "dataline.router";
  Handler jdField_a_of_type_AndroidOsHandler = new cr(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RouterAdvanceActivity.NotifyReceiver jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver;
  private DeviceInfo jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private View b;
  private String d;
  private String e;
  
  private void a(int paramInt)
  {
    DialogUtil.a(this, 230).setTitle("解除绑定失败").setMessage("解除绑定失败，错误码：" + paramInt).setNegativeButton(2131366375, new cs(this)).show();
  }
  
  private void a(String paramString)
  {
    RecentUserProxy localRecentUserProxy = this.app.a().a();
    paramString = localRecentUserProxy.b(paramString, 6002);
    if (paramString != null) {
      localRecentUserProxy.b(paramString);
    }
  }
  
  private void b()
  {
    Intent localIntent = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
    }
    while (localIntent == null)
    {
      return;
      FMToastUtil.a(2131362437);
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", 6);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("localSdCardfile", 0);
      startActivityForResult(localIntent, 100);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    String str = getString(2131362125);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(str);
    localActionSheet.a(getResources().getString(2131362053), 3);
    localActionSheet.e(2131365736);
    localActionSheet.a(new cq(this, localActionSheet));
    localActionSheet.show();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "modifyRemark,  DIN[" + this.e + "], 设备信息不存在");
      }
      return;
    }
    String str = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark;
    Intent localIntent = new Intent(this, EditActivity.class);
    boolean bool = true;
    if (TextUtils.isEmpty(str)) {
      bool = false;
    }
    localIntent.putExtra("title", 2131366181).putExtra("limit", 96).putExtra("current", str).putExtra("canPostNull", bool).putExtra("multiLine", false);
    startActivityForResult(localIntent, 1003);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    String str;
    if (paramInt2 == -1) {
      str = null;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    if (str == null) {}
    for (paramIntent = "";; paramIntent = str)
    {
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IphoneTitleBarActivity", 2, "modifyRemark,  DIN[" + this.e + "], 设备信息不存在");
        return;
      }
      if (!paramIntent.equals(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark))
      {
        ((SmartDeviceProxyMgr)this.app.a(53)).a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.serialNum, paramIntent);
        this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark = paramIntent;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903268);
    setTitle(2131363604);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297412);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.b = findViewById(2131297415);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297500));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297413));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AppConstants.aP);
    paramBundle = new IntentFilter();
    paramBundle.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver = new RouterAdvanceActivity.NotifyReceiver(this);
    registerReceiver(this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver, paramBundle);
    this.d = getIntent().getStringExtra("guid_flag");
    this.e = getIntent().getStringExtra("uin");
    Object localObject = this.leftView.getText().toString();
    paramBundle = (Bundle)localObject;
    if (!getString(2131365114).equals(localObject)) {
      paramBundle = "返回" + (String)localObject + "界面";
    }
    this.leftView.setContentDescription(paramBundle);
    this.leftView.setText(2131362047);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297499));
    localObject = (FormSimpleItem)findViewById(2131297498);
    paramBundle = (ImageView)findViewById(2131296551);
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(53)).a(Long.parseLong(this.e));
    int i;
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)
    {
      i = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
      ((FormSimpleItem)localObject).setRightText(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.name);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.remark);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      PrinterOptionActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, 0.0F, this);
      PrinterOptionActivity.a((FormSimpleItem)localObject, 0.0F, this);
    }
    for (;;)
    {
      localObject = DeviceHeadMgr.a().a(i);
      paramBundle.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap)localObject));
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      ((FormSimpleItem)localObject).setVisibility(8);
      i = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity$NotifyReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297412: 
      b();
      return;
    case 2131297415: 
      c();
      return;
    case 2131297500: 
      ((SmartDeviceProxyMgr)this.app.a(53)).a(this.d);
      a(this.e);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.RouterAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */