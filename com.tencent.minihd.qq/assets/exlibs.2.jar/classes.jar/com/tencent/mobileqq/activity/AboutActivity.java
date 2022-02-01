package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import dco;
import dcp;
import dcq;
import dcr;
import dcs;
import dct;
import dcu;
import protocol.KQQConfig.UpgradeInfo;

public class AboutActivity
  extends IphoneTitleBarActivity
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new dct(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_a_of_type_JavaLangString = "https://mobile.qq.com/android/";
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString = "https://ti.qq.com/agreement/index.html";
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_c_of_type_JavaLangString = "https://ti.qq.com/doc/redirect/qqhd-privacy";
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_d_of_type_JavaLangString = "https://ti.qq.com/agreement/privateProtocal.html";
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_e_of_type_JavaLangString = "https://ti.3g.qq.com/g/s?aid=h&hu=MobileQQ";
  
  private String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager == null) || (paramConnectivityManager == null)) {
      paramConnectivityManager = "//";
    }
    NetworkInfo localNetworkInfo;
    do
    {
      String str;
      do
      {
        return paramConnectivityManager;
        str = "";
        localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
        paramConnectivityManager = str;
      } while (localNetworkInfo == null);
      paramConnectivityManager = str;
    } while (!localNetworkInfo.isAvailable());
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      return "unknown";
    case 9: 
      return "cable";
    case 1: 
    case 6: 
      return "WIFI";
    }
    a(paramTelephonyManager.getNetworkOperatorName());
    switch (paramTelephonyManager.getNetworkType())
    {
    default: 
      return "2G";
    case 13: 
      return "4G";
    case 3: 
      return "3G";
    case 5: 
      return "3G";
    case 6: 
      return "3G";
    case 8: 
      return "3G";
    case 9: 
      return "3G";
    case 10: 
      return "3G";
    case 12: 
      return "3G";
    case 14: 
      return "3G";
    case 15: 
      return "3G";
    case 1: 
      return "2G";
    case 2: 
      return "2G";
    case 4: 
      return "2G";
    case 7: 
      return "2G";
    case 11: 
      return "2G";
    }
    return "2G";
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("/")) {
        str = paramString.replace("/", "_");
      }
      paramString = str;
    } while (str.length() <= 20);
    return str.substring(20);
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  private void a(AboutConfig paramAboutConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("已是最新版本");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText("有新版本可用");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130841955));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new dcr(this));
  }
  
  private void a(AboutConfig paramAboutConfig, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem)
  {
    if (paramResourcePluginInfo.cLocalState == 0)
    {
      paramFormSimpleItem.setVisibility(8);
      return;
    }
    paramFormSimpleItem.setVisibility(0);
    if (paramResourcePluginInfo.isNew == 0) {
      paramFormSimpleItem.setRightIcon(getResources().getDrawable(2130841955));
    }
    for (;;)
    {
      paramFormSimpleItem.setLeftText(paramResourcePluginInfo.strResName);
      paramFormSimpleItem.setOnClickListener(new dcs(this, paramResourcePluginInfo, paramFormSimpleItem));
      return;
      paramFormSimpleItem.setRightIcon(null);
    }
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("url", this.jdField_d_of_type_JavaLangString).putExtra("bFormatUrl", false);
    localIntent.putExtra("uin", this.app.a());
    startActivity(localIntent);
  }
  
  private void c()
  {
    localObject2 = "";
    localObject4 = "";
    localObject3 = "";
    str3 = "";
    try
    {
      str1 = Build.MANUFACTURER;
      localObject2 = str1;
      str2 = Build.PRODUCT;
      localObject2 = str3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str1;
        String str4;
        ConnectivityManager localConnectivityManager;
        label156:
        str3 = "";
        localObject4 = "";
        localObject1 = "";
        localObject3 = "";
        String str2 = "";
        Object localObject5 = localObject2;
        localObject2 = str3;
      }
    }
    try
    {
      localObject5 = Build.VERSION.RELEASE + "";
      str4 = "V 5.9.3.3468";
      localObject2 = str3;
      localObject3 = str4;
      localObject4 = localObject5;
      str3 = AppSetting.a + "";
      localObject2 = str3;
      localObject3 = str4;
      localObject4 = localObject5;
      localConnectivityManager = (ConnectivityManager)getSystemService("connectivity");
      localObject2 = str3;
      localObject3 = str4;
      localObject4 = localObject5;
      str4 = a((TelephonyManager)getSystemService("phone"), localConnectivityManager);
      localObject2 = "V 5.9.3.3468";
      localObject4 = str4;
      localObject3 = localObject5;
      localObject5 = str1;
      str1 = str3;
    }
    catch (Exception localException2)
    {
      str3 = "";
      Object localObject6 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = str3;
      break label156;
    }
    str1 = "https://mma.qq.com/hdqq/feedback.html" + "?manufacturer=" + (String)localObject5 + "&product=" + str2 + "&network=" + (String)localObject4 + "&os=" + (String)localObject3 + "&version=" + (String)localObject2 + "&appid=" + str1;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("portraitOnly", true);
    ((Intent)localObject2).putExtra("url", str1).putExtra("bFormatUrl", false);
    ((Intent)localObject2).putExtra("uin", this.app.a());
    startActivity((Intent)localObject2);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    setContentView(2130903040);
    setTitle(2131368059);
    paramBundle = this.app.a();
    ((TextView)findViewById(2131296531)).setText("V 5.9.3.3468");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296540));
    Object localObject = new SpannableString(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new dcu(this, this.jdField_a_of_type_JavaLangString), 0, this.jdField_a_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296541));
    localObject = new SpannableString(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new dcu(this, this.jdField_b_of_type_JavaLangString), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296542));
    localObject = new SpannableString(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new dcu(this, this.jdField_c_of_type_JavaLangString), 0, this.jdField_c_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296543));
    localObject = new SpannableString(this.jdField_d_of_type_AndroidWidgetTextView.getText());
    ((SpannableString)localObject).setSpan(new dcu(this, this.jdField_e_of_type_JavaLangString + "&sid=" + this.app.getSid()), 0, this.jdField_d_of_type_AndroidWidgetTextView.getText().length(), 17);
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296533));
    a(paramBundle);
    localObject = paramBundle.a("com.tx.aboutfunction");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296534));
    if (localObject != null) {
      a(paramBundle, (ResourcePluginInfo)localObject, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296537));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new dco(this));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296536));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new dcp(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296535));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new dcq(this));
      if (DeviceInfoUtil.e() <= 160)
      {
        paramBundle = (ImageView)findViewById(2131296530);
        localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin -= Utils.a(this, 5.0F);
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramBundle = "appid: " + String.valueOf(AppSetting.a) + "\n";
      paramBundle = paramBundle + "LC: 1411F8F6E5D453F9\n";
      paramBundle = paramBundle + "buildNum: 3468\n";
      paramBundle = paramBundle + "isDebugVersion: " + String.valueOf(false) + "\n";
      paramBundle = paramBundle + "subVersion: 5.9.3\n";
      paramBundle = paramBundle + "productID: 130\n";
      paramBundle = paramBundle + "quaAppName: AQQ_2013 4.6\n";
      paramBundle = paramBundle + "supVersion: 2013\n";
      paramBundle = paramBundle + "revision: 2cb8ec\n";
      paramBundle = paramBundle + "isSkinEngieAccelerated: " + String.valueOf(true) + "\n";
      paramBundle = paramBundle + "reportVersionName: 5.9.3.3468\n";
      paramBundle = paramBundle + "aboutSubVersionName: V 5.9.3.3468\n";
      paramBundle = paramBundle + "aboutSubVersionLog: 5.9.3.3468.2021-11-21.r2cb8ec.YingYongBao\n";
      paramBundle = paramBundle + "isPublicVersion: true\n";
      paramBundle = paramBundle + "versioncode: " + ApkUtils.a(this) + "\n";
      paramBundle = paramBundle + "amem: " + DeviceInfoUtil.d() / 1024L / 1024L + "\n";
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, paramBundle);
      }
      return true;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (isFinishing()) {}
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_b_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_c_of_type_AndroidWidgetTextView.invalidate();
    this.jdField_d_of_type_AndroidWidgetTextView.invalidate();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity
 * JD-Core Version:    0.7.0.1
 */