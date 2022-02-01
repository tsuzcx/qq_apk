package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.qphone.base.util.QLog;
import ffj;
import ffk;
import ffm;

public class ThemeSwitchDlgActivity
  extends BaseActivity
{
  public Dialog a;
  public QQAppInterface a;
  public NightModeLogic a;
  public boolean a;
  
  public ThemeSwitchDlgActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = getResources().getString(paramInt1);
    Object localObject1 = getResources().getString(paramInt2);
    String str2 = getResources().getString(paramInt3);
    String str1 = getResources().getString(paramInt4);
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null) {
      localTextView.setText((CharSequence)localObject2);
    }
    localObject2 = (TextView)localDialog.findViewById(2131296606);
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = (TextView)localDialog.findViewById(2131297370);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
    }
    paramOnClickListener1 = (TextView)localDialog.findViewById(2131297371);
    if (paramOnClickListener1 != null)
    {
      paramOnClickListener1.setText(str1);
      paramOnClickListener1.setOnClickListener(paramOnClickListener2);
    }
    return localDialog;
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "ThemeSwitchDlgActivity showThemeSettingDialog");
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = a(2131366740, 2131366742, 2131365736, 2131366744, new ffj(this), new ffk(this));
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ffm(this));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(getAppRuntime(), this);
    }
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("themedownloadalert", false)) && (!this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.isCurrentNightMode())) {
      a(paramBundle.getStringExtra("themeID"));
    }
    for (;;)
    {
      if ((getAppRuntime() instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
      }
      return true;
      finish();
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.destroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.doOnDestroy();
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onPostThemeChanged();
      finish();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeSwitchDlgActivity
 * JD-Core Version:    0.7.0.1
 */