package com.dataline.activities;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import br;
import bs;
import bt;
import bu;
import bv;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import mqq.app.MobileQQ;

public class LiteAdvanceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "clear_flag";
  private static final String jdField_b_of_type_JavaLangString = "LiteAdvanceActivity";
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new bu(this);
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private boolean jdField_a_of_type_Boolean;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new bv(this);
  private View jdField_b_of_type_AndroidViewView;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  
  public LiteAdvanceActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a()
  {
    setContentView(2130903229);
    setTitle(2131363604);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297412);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297414);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.c = findViewById(2131297415);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297413));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AppConstants.aP);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131297410));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new br(this));
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131297411));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bs(this));
    String str2 = this.leftView.getText().toString();
    String str1 = str2;
    if (!getString(2131365114).equals(str2)) {
      str1 = "返回" + str2 + "界面";
    }
    this.leftView.setContentDescription(str1);
  }
  
  private void a(View paramView)
  {
    DialogUtil.a(this, 230, getResources().getString(2131362053), getResources().getString(2131362125), getResources().getString(2131365736), getResources().getString(2131365737), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener).show();
  }
  
  private void a(boolean paramBoolean)
  {
    this.app.getPreferences().edit().putBoolean("auto_receive_files", paramBoolean).commit();
  }
  
  private boolean a()
  {
    return this.app.getPreferences().getBoolean("auto_receive_files", false);
  }
  
  private void b()
  {
    String str = getString(2131362125);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(str);
    localActionSheet.a(getResources().getString(2131362053), 3);
    localActionSheet.a(new bt(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void b(View paramView)
  {
    a(paramView);
  }
  
  private void b(boolean paramBoolean)
  {
    this.app.getPreferences().edit().putBoolean("dl_pc_online_notify", paramBoolean).commit();
  }
  
  private boolean b()
  {
    return this.app.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  private void c()
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
      startActivityForResult(localIntent, 103);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    QQUtils.a(this.app, 2130839616, qfileJumpActivity.class.getName(), getString(2131362046), getTitleBarHeight(), this.jdField_a_of_type_AndroidOsHandler, 500);
    DataLineReportUtil.q(this.app);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    super.doOnConfigurationChanged(paramConfiguration);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = a();
    this.jdField_b_of_type_Boolean = b();
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131297413: 
    default: 
      return;
    case 2131297412: 
      StatisticAssist.a(this.app.getApplication().getApplicationContext(), this.app.a(), "dl_ckviewrecvfile");
      c();
      return;
    case 2131297414: 
      d();
      return;
    }
    b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity
 * JD-Core Version:    0.7.0.1
 */