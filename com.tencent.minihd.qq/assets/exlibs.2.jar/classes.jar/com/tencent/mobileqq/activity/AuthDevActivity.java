package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dgs;
import dgt;
import dgu;
import dgv;
import dgw;
import dgx;
import dgy;
import dgz;
import dha;
import dhb;
import dhc;
import dhd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.observer.WtloginObserver;

public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.AuthDevActivity";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Handler jdField_a_of_type_AndroidOsHandler = new dgs(this);
  private View jdField_a_of_type_AndroidViewView = null;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new dgw(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dhb(this);
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new dhd(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = null;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private List jdField_a_of_type_JavaUtilList = null;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new dhc(this);
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = null;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = null;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet = null;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = false;
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131368919), 5, false);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131366672), 3, false);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.e(2131365736);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new dgz(this, paramString2, paramLong, paramString1, paramInt, paramArrayList, paramBoolean1, paramBoolean2));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
      if (localSvcDevLoginInfo == null) {}
      for (;;)
      {
        i += 1;
        break;
        View localView = getLayoutInflater().inflate(2130903915, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131296577);
        if (i == j - 1) {
          localView.findViewById(2131297956).setVisibility(8);
        }
        TextView localTextView2 = (TextView)localView.findViewById(2131296582);
        TextView localTextView1 = (TextView)localView.findViewById(2131297409);
        String str = localSvcDevLoginInfo.strDeviceName;
        Object localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = getResources().getString(2131368810);
        }
        str = null;
        if (Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid)) {
          str = "（" + getResources().getString(2131368806) + "）";
        }
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject);
        if (!TextUtils.isEmpty(str))
        {
          localSpannableStringBuilder.append(str);
          dgx localdgx = new dgx(this);
          int k = ((String)localObject).length();
          localSpannableStringBuilder.setSpan(localdgx, k, str.length() + k, 33);
        }
        localTextView2.setText(localSpannableStringBuilder);
        localObject = new StringBuffer();
        if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
          ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
        }
        if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
        {
          if (((StringBuffer)localObject).length() > 0) {
            ((StringBuffer)localObject).append(" ");
          }
          ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
        }
        if (((StringBuffer)localObject).length() > 0) {
          localTextView1.setText(((StringBuffer)localObject).toString());
        }
        localRelativeLayout.setClickable(true);
        localRelativeLayout.setTag(localSvcDevLoginInfo);
        localRelativeLayout.setOnClickListener(new dgy(this, localRelativeLayout, i));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    paramList = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) {}
    for (i = 4;; i = 0)
    {
      paramList.setVisibility(i);
      return;
    }
  }
  
  private void b(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131368810);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131368871, new Object[] { str });; paramString1 = getString(2131368870, new Object[] { str }))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131368872), 3, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(2131365736);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new dha(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList.begin to getAuthLoginDevList");
    }
    boolean bool = EquipmentLockImpl.a().c(this.app, this.jdField_b_of_type_JavaLangString, 0L);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 2, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dgu(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dgv(this));
  }
  
  private void f()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CheckDevLockSms");
        }
        if (DevlockPhoneStatus.a().a() == DevlockPhoneStatus.d)
        {
          DevlockPhoneStatus.a().a(this, this.jdField_c_of_type_JavaLangString);
          return;
        }
        ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      d();
      return;
      d();
      this.jdField_c_of_type_Boolean = false;
      String str = this.app.a();
      i = EquipmentLockImpl.a().a(this.app, str, "", null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    this.jdField_c_of_type_Boolean = true;
    e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CheckDevLockSms fail ret=" + i);
    }
    QQToast.a(getApplicationContext(), getString(2131368884), 0).b(getTitleBarHeight());
  }
  
  void a()
  {
    b();
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131297367);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131368873));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131296606);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131368874));
    }
    localTextView1 = (TextView)localDialog.findViewById(2131297370);
    if (localTextView1 != null) {
      localTextView1.setText(2131367454);
    }
    TextView localTextView2 = (TextView)localDialog.findViewById(2131297371);
    if (localTextView2 != null) {
      localTextView2.setText(2131365736);
    }
    localDialog.setOnDismissListener(new dgt(this));
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(this);
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1003) && (paramIntent != null))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {}
    }
    else
    {
      return;
    }
    paramInt1 = paramIntent.getInt("resultState", 1);
    paramInt2 = paramIntent.getInt("emergency_phone_state", 1);
    if (paramInt1 == 2)
    {
      DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
      label60:
      if (paramInt1 != 1)
      {
        this.jdField_c_of_type_JavaLangString = paramIntent.getString("resultMobileMask");
        if (paramInt1 != 2) {
          break label166;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (paramInt2 != 1) {
        DevlockPhoneStatus.a().b(DevlockPhoneStatus.j);
      }
      paramIntent = paramIntent.getString("emergency_phone_mask");
      if ((paramInt2 == 1) || (TextUtils.isEmpty(paramIntent))) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
      DevlockPhoneStatus.a().a(paramIntent);
      return;
      if (paramInt1 != 3) {
        break label60;
      }
      DevlockPhoneStatus.a().a(DevlockPhoneStatus.d);
      DevlockPhoneStatus.a().a(0L);
      break label60;
      label166:
      if (paramInt1 == 3) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131368932));
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("allow_set", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("phone_num", this.jdField_c_of_type_JavaLangString);
    setResult(0, localIntent);
    finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i;
    do
    {
      do
      {
        return;
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
        paramView.putExtra("hide_more_button", true);
        startActivity(paramView);
        return;
        f();
        return;
        this.app.sendWirelessMeibaoReq(1);
        ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "Clk_protect_detail", 0, 0, "", "", "", "");
        if ((TextUtils.isEmpty(this.app.a())) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick current is empty");
        }
        EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.a, 1003, null);
        return;
        EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.b, 1003, null);
        return;
        b();
        return;
        b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
        }
        if (this.jdField_c_of_type_Boolean) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      d();
      return;
      d();
      this.jdField_c_of_type_Boolean = false;
      paramView = this.app.a();
      i = EquipmentLockImpl.a().a(this.app, paramView, this.jdField_a_of_type_MqqObserverWtloginObserver);
    } while (i == 0);
    e();
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
    }
    QQToast.a(getApplicationContext(), getString(2131368883), 0).b(getTitleBarHeight());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903914);
    super.setTitle(2131368856);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131300081));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131300091));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131300089);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131297004));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131300083));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setFocusable(false);
    super.findViewById(2131300082).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131300084));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131300079));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300090));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131300087));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300088));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131300086);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838067);
    this.rightViewImg.setContentDescription(getString(2131368866));
    this.rightViewImg.setOnClickListener(this);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("auth_dev_open");
    this.jdField_c_of_type_JavaLangString = paramBundle.getExtras().getString("phone_num");
    this.d = paramBundle.getExtras().getBoolean("allow_set");
    if (DevlockPhoneStatus.a().b() != DevlockPhoneStatus.i)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(3);
      paramBundle = DevlockPhoneStatus.a().b();
      if (!TextUtils.isEmpty(paramBundle)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramBundle);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (this.app == null) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      super.finish();
      return;
    }
    paramBundle = this.app.a(LoginInfoActivity.class);
    if (paramBundle != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label629;
      }
      paramBundle.obtainMessage(20140331, 1, 0).sendToTarget();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131368856));
      try
      {
        this.jdField_b_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.jdField_b_of_type_JavaLangString);
        }
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
        if (DevlockPhoneStatus.a().a() == DevlockPhoneStatus.d)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131368932));
          if (!this.jdField_a_of_type_Boolean) {
            break label666;
          }
          paramBundle = (SecSvcHandler)this.app.a(36);
          if (paramBundle != null) {
            paramBundle.a();
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          c();
          return;
          label629:
          paramBundle.obtainMessage(20140331, 0, 0).sendToTarget();
        }
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_c_of_type_JavaLangString);
        }
        label666:
        if (!this.d) {
          break label696;
        }
      }
    }
    if (EquipmentLockImpl.a().c()) {
      f();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      label696:
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */