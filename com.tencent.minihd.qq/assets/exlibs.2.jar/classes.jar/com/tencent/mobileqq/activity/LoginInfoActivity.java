package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import eiz;
import eja;
import ejb;
import ejc;
import ejg;
import ejh;
import eji;
import ejj;
import java.net.URLEncoder;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.LoginInfoActivity";
  static final int jdField_b_of_type_Int = 4;
  public static final int c = 20140331;
  public static final int d = 1;
  private static final int f = 0;
  private static final int g = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new eiz(this);
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new eji(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ejg(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private List jdField_a_of_type_JavaUtilList = null;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new ejh(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private String jdField_c_of_type_JavaLangString = "";
  private TextView d = null;
  private int e = 0;
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new eja(this, paramInt));
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label59;
        }
        i += 1;
      }
    }
    label59:
    View localView = getLayoutInflater().inflate(2130903366, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131296577);
    if (i == j - 1) {
      localView.findViewById(2131297956).setVisibility(8);
    }
    getResources().getString(2131368807);
    Object localObject2 = getResources().getString(2131368806);
    TextView localTextView1 = (TextView)localView.findViewById(2131297954);
    Button localButton = (Button)localView.findViewById(2131297955);
    localTextView1.setContentDescription(getString(2131368806));
    localButton.setContentDescription(getString(2131368807));
    TextView localTextView2 = (TextView)localView.findViewById(2131296582);
    localObject1 = (TextView)localView.findViewById(2131297409);
    ImageView localImageView = (ImageView)localView.findViewById(2131296551);
    if (i == 0)
    {
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130838542);
      label246:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label446;
      }
      localTextView2.setText(2131368810);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject2).length() > 0) {
        ((TextView)localObject1).setText(((StringBuffer)localObject2).toString());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130838541);
      localButton.setOnClickListener(new ejc(this, localButton, i));
      break label246;
      label446:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.d.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    int i;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
        this.d.setText(getString(2131368862));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840291);
        return;
        i = 0;
      }
      else
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
        this.d.setText(getString(2131368861));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840290);
        return;
        i = 0;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ejb(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131427936));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void d()
  {
    this.e = GesturePWDUtils.getGesturePWDState(this, this.app.a());
    switch (this.e)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131368426));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131368425));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131368424));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.LoginInfoActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    String str = this.app.a();
    int i = EquipmentLockImpl.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      c();
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject = SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.a(), "account_logout_success_text", "");
    String str = SharedPreUtils.a(paramQQAppInterface.a(), paramQQAppInterface.a(), "account_logout_bold_text", "");
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", 1);
    localIntent.putExtra("is_from_account_release", true);
    localIntent.putExtra("release_account_uin", paramQQAppInterface.a());
    localIntent.putExtra("release_success_text", (String)localObject);
    localIntent.putExtra("release_bold_text", str);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    BadgeUtils.a(paramQQAppInterface.a(), 0);
    localObject = paramQQAppInterface.a().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
    int i = QQSettingUtil.a(paramActivity, paramQQAppInterface.a());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.a(), i + 1);
    startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        paramIntent = paramIntent.getExtras();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
          break label149;
        }
        bool1 = true;
        bool1 = paramIntent.getBoolean("auth_dev_open", bool1);
        String str = paramIntent.getString("phone_num");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1) {}
        boolean bool2 = paramIntent.getBoolean("allow_set");
        if (!bool1) {
          break label155;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
        label110:
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
        }
        if (!bool2) {
          break label166;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;
        label140:
        a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      }
    }
    label149:
    label155:
    label166:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
        break label110;
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0;
        break label140;
        if (paramInt1 == 1)
        {
          d();
          return;
        }
      } while (paramInt1 != 4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, String.format("doOnActivityResult, resultCode: %s", new Object[] { Integer.valueOf(paramInt2) }));
      }
    } while (paramInt2 != -1);
    ReportController.b(this.app, "CliOper", "", "", "Quit", "QQCanle_Quit", 0, 0, "2", "", "", "");
    a(getActivity(), this.app);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903365);
    setTitle(2131369097);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297947));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297946));
    findViewById(2131297944).setOnClickListener(this);
    paramBundle = (FormSimpleItem)findViewById(2131297945);
    paramBundle.setClickable(false);
    paramBundle.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297939));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297948));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297940));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297949));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297943));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131366193));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297950);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297952));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367938));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297951);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    paramBundle = SharedPreUtils.a(this.app.a(), this.app.a(), "account_logout_url", "");
    if (TextUtils.isEmpty(paramBundle)) {
      this.jdField_b_of_type_JavaLangString = "https://ti.qq.com/qqcancel/index.html?_wv=2097153";
    }
    for (;;)
    {
      this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
      boolean bool = SettingCloneUtil.readValue(this, this.app.a(), "login_accounts", "qqsetting_bothonline_key", true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      bool = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (!EquipmentLockImpl.a().b()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = new SpannableString(getResources().getString(2131368804));
      this.d = ((TextView)findViewById(2131297942));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297004));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297941));
      int i = paramBundle.length();
      paramBundle.setSpan(new ejj(this, null), 0, i, 33);
      paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131427941)), 0, i, 33);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
      try
      {
        this.jdField_c_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.LoginInfoActivity", 2, "packName = " + this.jdField_c_of_type_JavaLangString);
        }
        a(null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.LoginInfoActivity", 2, "onCreate begin to getLoginDevList");
        }
        if (NetworkUtil.e(this))
        {
          bool = EquipmentLockImpl.a().a(this.app, this.jdField_c_of_type_JavaLangString, 0L);
          if (bool)
          {
            a(0);
            a();
            d();
            return true;
            this.jdField_b_of_type_JavaLangString = paramBundle;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.devlock.LoginInfoActivity", 2, "onCreate getLoginDevList failed ret=" + bool);
            continue;
            QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
          }
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(getClass());
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent;
    boolean bool1;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localIntent = new Intent();
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
        break label71;
      }
      bool1 = true;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
        break label76;
      }
    }
    label71:
    label76:
    for (boolean bool2 = true;; bool2 = false)
    {
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("allow_set", bool2);
      setResult(0, localIntent);
      finish();
      return true;
      bool1 = false;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297940: 
    case 2131297941: 
    case 2131297942: 
    case 2131297943: 
    case 2131297945: 
    case 2131297946: 
    case 2131297947: 
    default: 
    case 2131297939: 
      do
      {
        return;
        ReportController.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!NetworkUtil.e(this))
          {
            QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
            return;
          }
          a();
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          paramView = new Intent(this, AuthDevActivity.class);
          paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          paramView.putExtra("auth_dev_open", true);
          startActivityForResult(paramView, 0);
          return;
        }
        this.app.sendWirelessMeibaoReq(1);
        if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
        {
          paramView = new Intent(this, AuthDevOpenUgActivity.class);
          paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          startActivityForResult(paramView, 0);
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
        {
          paramView = new Intent(this, AuthDevOpenUgActivity.class);
          paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          startActivityForResult(paramView, 0);
          return;
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1);
      paramView = new Intent(this, AuthDevActivity.class);
      paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      paramView.putExtra("auth_dev_open", false);
      startActivityForResult(paramView, 0);
      return;
    case 2131297944: 
      startActivity(new Intent(this, SecurityPickproofActivity.class));
      ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
      return;
    case 2131297948: 
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
      startActivity(new Intent(this, RecentLoginDevActivity.class));
      return;
    case 2131297949: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      return;
    case 2131297950: 
      if (PhoneNumLoginImpl.a().a(this.app, this.app.a()))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("uin", this.app.a());
        startActivity(paramView.putExtra("url", "https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733&uin=" + this.app.a()));
        this.app.sendWirelessPswReq(1);
        return;
      }
      paramView = this.app.a();
      Object localObject = new StringBuilder("https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw");
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append("&plat=1");
      ((StringBuilder)localObject).append("&app=1");
      ((StringBuilder)localObject).append("&version=5.9.3.3468");
      ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
      ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
      ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      localObject = ((StringBuilder)localObject).toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", paramView);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.a(this, (String)localObject, 32768L, localIntent, false, -1);
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_b_of_type_JavaLangString);
    paramView.putExtra("is_release_account", true);
    startActivityForResult(paramView, 4);
    ReportController.b(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */