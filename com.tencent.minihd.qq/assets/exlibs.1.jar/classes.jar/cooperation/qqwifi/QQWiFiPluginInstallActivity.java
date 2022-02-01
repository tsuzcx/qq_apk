package cooperation.qqwifi;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lzt;
import lzu;
import lzw;
import lzx;
import maa;
import mab;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class QQWiFiPluginInstallActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_c_of_type_JavaLangString = QQWiFiPluginInstallActivity.class.getSimpleName();
  private static final String e = "com.tencent.process.exit";
  private long jdField_a_of_type_Long = 0L;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new lzu(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  String jdField_a_of_type_JavaLangString = "";
  mab jdField_a_of_type_Mab;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new lzt(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private OnPluginInstallListener jdField_b_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new lzx(this);
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private String d;
  
  private String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a()
  {
    try
    {
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, getString(2131368894), 0).b(getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "从Intent传来的为空，开始重新获取设备锁信息. OMG~~~");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492923));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在确认帐号信息……");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      String str = this.app.a();
      int i = EquipmentLockImpl.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if ((i != 0) && (QLog.isColorLevel()))
      {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "initDevlockInfo CheckDevLockStatus failed. ret=" + i);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_c_of_type_JavaLangString, 2, localThrowable.toString());
      }
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((Context)localObject).getSharedPreferences("mobileQQ", i).edit();
      ((SharedPreferences.Editor)localObject).putInt("bar_switch_operation" + QQUtils.a(), paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
      ((Intent)localObject).putExtra("barswitch", true);
      sendBroadcast((Intent)localObject);
      return;
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "需要跳转到绑定手机号页面:" + paramString);
    }
    paramString = new Intent(this, BindNumberActivity.class);
    paramString.setFlags(536870912);
    paramString.putExtra("key_is_first_activity", false);
    paramString.putExtra("key_is_qqwifi", true);
    startActivityForResult(paramString, 1);
  }
  
  private boolean a()
  {
    return PreferenceManager.getDefaultSharedPreferences(this).getLong("KEY_JAR_INFO_LAST_UPDATE_TIME", -1L) != -1L;
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.minihd.qq:qqwifi".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300722));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131300727));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300723));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131300726));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300724));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300718));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("立即体验免费上网");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300729));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300721));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.d, new Object[] { Integer.valueOf(0) }));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131300714));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300719));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131300720));
    Context localContext = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4; localContext.getSharedPreferences("mobileQQ", i).getInt("bar_switch_operation" + QQUtils.a(), 0) == 1; i = 0)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "goPlugin:" + paramString);
    }
    if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("QQWifiPlugin.apk"))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(8);
      d();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    } while (!a(getApplicationContext()));
    paramString = new Intent("com.tencent.process.exit");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("com.tencent.minihd.qq:qqwifi");
    paramString.putStringArrayListExtra("procNameList", localArrayList);
    paramString.putExtra("verify", a(localArrayList, false));
    sendBroadcast(paramString);
  }
  
  private boolean b()
  {
    if (((PhoneContactManager)this.app.getManager(10)).b() > 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean)
      {
        RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.app.getManager(10)).a();
        if (localRespondQueryQQBindingStat != null) {
          this.jdField_b_of_type_JavaLangString = localRespondQueryQQBindingStat.mobileNo;
        }
      }
      return this.jdField_b_of_type_Boolean;
    }
  }
  
  private void c()
  {
    Boolean localBoolean = Boolean.valueOf(this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    if (localBoolean.booleanValue()) {
      a(1);
    }
    ReportController.b(this.app, "CliOper", "", "", "QQWIFI", "CheckedBar_" + localBoolean, 0, 0, "", "", "", "");
  }
  
  private void c(String paramString)
  {
    if (a())
    {
      findViewById(2131300715).setVisibility(8);
      findViewById(2131300711).setVisibility(0);
      if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("QQWifiPlugin.apk"))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "goPluginFromBackground, plugin installed");
        }
        d();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "goPluginFromBackground, plugin not installed");
      }
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("QQWifiPlugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
      return;
    }
    b(paramString);
  }
  
  private void d()
  {
    PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putLong("KEY_QQWIFI_PLUGIN_CREATE_TIME", System.currentTimeMillis()).commit();
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131492923));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new lzw(this));
    if (getIntent() != null) {}
    for (Intent localIntent = getIntent();; localIntent = new Intent())
    {
      localIntent.putExtra("enableLock", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("bindContact", this.jdField_b_of_type_Boolean);
      localIntent.putExtra("dev_phoneNumber", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("contact_phoneNumber", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("version_name", "5.9.3");
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("userQqResources", -1);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "QQWifiPlugin.apk";
      localPluginParams.d = "QQWifiPlugin";
      localPluginParams.jdField_a_of_type_AndroidAppDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      localPluginParams.jdField_a_of_type_JavaLangString = this.app.a();
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.e = "com.tencent.wifisdk.activity.NewConnectActivity";
      localPluginParams.jdField_a_of_type_JavaLangClass = QQWiFiConnectProxyActivity.class;
      localPluginParams.jdField_b_of_type_Int = 19;
      localPluginParams.c = 15000;
      localPluginParams.jdField_a_of_type_Boolean = false;
      localPluginParams.f = null;
      IPluginManager.a(this, localPluginParams);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQWiFiHelper.a(this.app, false);
      return;
    }
  }
  
  private void e()
  {
    runOnUiThread(new maa(this));
  }
  
  public void a(DevlockInfo paramDevlockInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    int i;
    boolean bool;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1)
      {
        i = 1;
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) || (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile.length() != 11)) {
          break label173;
        }
        bool = true;
        label90:
        this.jdField_a_of_type_Boolean = bool;
        if (!this.jdField_a_of_type_Boolean) {
          break label178;
        }
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        b("onGetDevLockStatus");
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
        return;
        i = 0;
        break;
        label173:
        bool = false;
        break label90;
        label178:
        if (QLog.isColorLevel()) {
          QLog.i(jdField_c_of_type_JavaLangString, 2, "onGetDevLockStatus:需要跳转到绑定手机号页面");
        }
        a("onGetDevLockStatus");
        continue;
      }
      EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
      return;
      i = 0;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.doOnCreate(paramBundle);
    setContentView(2130904067);
    setTitle(2131369104);
    setContentBackgroundResource(2130837687);
    paramBundle = new IntentFilter();
    paramBundle.addAction("qqwifi.plugin.onresume.broadcast");
    this.jdField_a_of_type_Mab = new mab(this, null);
    registerReceiver(this.jdField_a_of_type_Mab, paramBundle);
    int i;
    if ((getIntent() != null) && ("com.tencent.mobileqq.action.QQWiFi".equals(getIntent().getAction())))
    {
      i = getIntent().getIntExtra("type", 0);
      if (i != 101) {
        break label212;
      }
      ReportController.b(this.app, "CliOper", "", "", "QQWIFI", "clk_permanent", 0, 0, "", "", "", "");
    }
    while (!this.app.isLogin())
    {
      paramBundle = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
      paramBundle.putExtra("intervalTime", QQWiFiHelper.jdField_a_of_type_Long);
      sendBroadcast(paramBundle);
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
      label212:
      if (i == 102) {
        ReportController.b(this.app, "CliOper", "", "", "QQWIFI", "clk_availNotify", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    this.d = getString(2131369609);
    if ((getIntent() != null) && (getIntent().getExtras() != null))
    {
      paramBundle = getIntent().getExtras().get("devlock_info");
      if ((paramBundle != null) && ((paramBundle instanceof DevlockInfo))) {
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle);
      }
    }
    b();
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) {
      if (b()) {
        c("doOnCreate1");
      }
    }
    for (;;)
    {
      return true;
      a();
      continue;
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile.length() == 11) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        b("doOnCreate2");
      }
      else if (b())
      {
        b("doOnCreate3");
      }
      else
      {
        a("doOnCreate");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_c_of_type_JavaLangString, 2, "doOnDestroy, ready to unregister receiver,mExitReceiver:" + this.jdField_a_of_type_Mab);
      }
      if (this.jdField_a_of_type_Mab != null) {
        unregisterReceiver(this.jdField_a_of_type_Mab);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Intent localIntent;
        localThrowable.printStackTrace();
      }
    }
    localIntent = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
    localIntent.putExtra("mInInstallActivity", false);
    sendBroadcast(localIntent);
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 != 0) {
        break label101;
      }
      setResult(0);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "onActivityResult->finish.resultCode == RESULT_CANCELED ");
      }
      finish();
    }
    for (;;)
    {
      if ((paramInt1 == 19) && ((paramInt2 == 20) || (paramInt2 == 4865))) {
        finish();
      }
      return;
      label101:
      b();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "onActivityResult [mBindContact=" + this.jdField_b_of_type_Boolean + ",contactPhoneNumber=" + this.jdField_b_of_type_JavaLangString + "]");
      }
      b("onActivityResult");
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (!ProfileActivity.a(this.jdField_a_of_type_Long, l)) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131300722: 
        if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("QQWifiPlugin.apk", this.jdField_b_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
          c();
          return;
        }
        break;
      }
    } while (this.jdField_c_of_type_Boolean);
    a();
    return;
    this.jdField_a_of_type_CooperationPluginIPluginManager.cancelInstall("QQWifiPlugin.apk");
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    return;
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "https://youxi.vip.qq.com/m/qqwifi/introduce.html?_wv=3");
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiPluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */