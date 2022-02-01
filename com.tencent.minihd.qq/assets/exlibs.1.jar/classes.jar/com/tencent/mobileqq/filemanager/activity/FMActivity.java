package com.tencent.mobileqq.filemanager.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SegmentedControlView;
import ijk;
import ijl;
import ijm;
import ijn;
import ijo;
import java.util.ArrayList;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  public View a;
  public RadioButton a;
  RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = null;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup = null;
  public VerifyPwdView a;
  IBaseTabViewEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = null;
  public QfileTabBarView a;
  ijo jdField_a_of_type_Ijo = null;
  int jdField_b_of_type_Int;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  TextView c;
  public final String c;
  String d;
  public String e = null;
  public boolean f = false;
  
  public FMActivity()
  {
    this.jdField_c_of_type_JavaLangString = "FMActivity<FileAssistant>";
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_a_of_type_AndroidWidgetRadioButton = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private boolean a(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().endsWith("Finish All modal"));
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131299519));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setActivity(this);
    if ((c()) && (paramInt != 5))
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131299512));
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener == null) {
        n();
      }
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
      this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)findViewById(2131299514));
      this.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(true);
      o();
      return;
    }
    if ((this.d != null) && (this.d.trim().length() != 0) && (this.jdField_b_of_type_Int != -1)) {
      setLeftViewName(2131367787);
    }
    for (;;)
    {
      g();
      switch (paramInt)
      {
      case 4: 
      default: 
        return;
      case 0: 
      case 6: 
        this.jdField_b_of_type_JavaLangString = getString(2131362364);
        setTitle(this.jdField_b_of_type_JavaLangString);
        o();
        return;
        setLeftViewName(2131365114);
      }
    }
    this.jdField_b_of_type_JavaLangString = getString(2131362358);
    setTitle(this.jdField_b_of_type_JavaLangString);
    c(paramInt);
    return;
    this.jdField_b_of_type_JavaLangString = getString(2131362356);
    setTitle(this.jdField_b_of_type_JavaLangString);
    p();
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initCloudTabView");
    }
    if (3 == paramInt) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = new VerifyPwdView(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new ijm(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.b();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
  }
  
  private void l()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
    if (localTroopHandler != null) {}
    try
    {
      localTroopHandler.a(Long.parseLong(this.e), 0L, 2, null, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("FMActivity<FileAssistant>", 2, localException.toString());
    }
  }
  
  private void m()
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131558902);
    localQQCustomDialog.setContentView(2130903216);
    localQQCustomDialog.setTitle(getString(2131363508));
    localQQCustomDialog.setMessage(getString(2131363509));
    localQQCustomDialog.setNegativeButton(getString(2131363511), new ijk(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = new ijl(this);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initRecentTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if ((this.d != null) && (this.d.trim().length() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setUin(this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(3, getString(2131362529));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(4, getString(2131362530));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(5, getString(2131362531));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(6, getString(2131362532));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(7, getString(2131362536));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "initLocalTabView");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(1);
    if (h()) {
      if (c())
      {
        TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.jdField_b_of_type_AndroidWidgetTextView;
        localTextView.setVisibility(0);
        localTextView.setText(2131362529);
        localTextView.setOnClickListener(this);
        g();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(8, getString(2131362536));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(10, getString(2131362530));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(9, getString(2131362531));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(11, getString(2131362532));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(12, getString(2131362535));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setVisibility(0);
      return;
      this.rightViewText.setText(2131362529);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setBackgroundDrawable(null);
      break;
      a(this);
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
    }
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FMActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ijn(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void s()
  {
    if (isModeleWindow())
    {
      Object localObject = findViewById(2131297738);
      ((View)localObject).setBackgroundResource(2130841808);
      int i = getResources().getDimensionPixelSize(2131492916);
      ((View)localObject).setPadding(i, 0, i, 0);
      findViewById(2131299511).setBackgroundResource(2130838413);
      localObject = getResources().getColorStateList(2131427929);
      ((TextView)findViewById(2131299517)).setTextColor((ColorStateList)localObject);
      SegmentedControlView localSegmentedControlView = (SegmentedControlView)findViewById(2131299512);
      localSegmentedControlView.setBackgroundFirstButton(getResources().getDrawable(2130841629));
      localSegmentedControlView.setBackgroundMiddleButton(getResources().getDrawable(2130841626));
      localSegmentedControlView.setBackgroundLastButton(getResources().getDrawable(2130841631));
      ((RadioButton)findViewById(2131299514)).setTextColor((ColorStateList)localObject);
      ((RadioButton)findViewById(2131299515)).setTextColor((ColorStateList)localObject);
      ((RadioButton)findViewById(2131299516)).setTextColor((ColorStateList)localObject);
    }
    findViewById(2131299511).setOnClickListener(this);
    if (!c()) {
      findViewById(2131299517).setOnClickListener(this);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int i = 0;
    if (h()) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int j = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(j - i);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent = paramIBaseTabViewEvent;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramArrayList);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(paramArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView == null) {
      return;
    }
    int i = 0;
    if (paramBoolean) {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.getLayoutParams().height;
    }
    int j = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setTabFrameHeight(j - i);
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public void d(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.d(paramArrayList);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (a(paramIntent))) {
      finish();
    }
    do
    {
      return;
      if ((paramInt2 != -1) || (this.d == null) || (this.d.trim().length() == 0)) {
        break;
      }
    } while (((paramIntent == null) || (paramIntent.getExtras() == null) || ((paramIntent.getBooleanExtra("foward_editbar", false) != true) && (paramIntent.getBooleanExtra("destroy_last_activity", false) != true))) && (paramInt2 != 4));
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    finish();
    return;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    t();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("tab_tab_type", -1);
    this.d = getIntent().getStringExtra("uin");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("uintype", -1);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("from_qlink", false);
    this.f = getIntent().getBooleanExtra("from_aio", false);
    this.e = getIntent().getStringExtra("targetUin");
    if (QLog.isColorLevel()) {
      QLog.d("FMActivity<FileAssistant>", 2, "doOnCreate type[" + this.jdField_a_of_type_Int + "],select[" + c() + "]");
    }
    if ((!TextUtils.isEmpty(this.d)) && (this.jdField_b_of_type_Int == -1)) {
      e(true);
    }
    if ((c()) && (this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 6)) {
      a(2130903754);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299518));
      if ((!TextUtils.isEmpty(this.d)) && (this.jdField_b_of_type_Int == -1))
      {
        setLeftViewName(2131368038);
        if (this.rightViewText != null) {
          this.rightViewText.setVisibility(8);
        }
      }
      b(this.jdField_a_of_type_Int);
      s();
      if (this.jdField_a_of_type_Int == 6) {
        d();
      }
      this.app.a().h();
      q();
      return true;
      setContentView(2130903754);
      ((RelativeLayout)findViewById(2131297738)).setVisibility(8);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FMActivity<FileAssistant>", 2, "FMActiviy is called doOnDestroy But not finished!");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.app.a().b();
    this.app.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
    }
    FMDataCache.b();
    r();
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent("com.tencent.qlink.selectfileover");
      this.app.a().sendBroadcast(localIntent);
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_Ijo != null) {
      removeObserver(this.jdField_a_of_type_Ijo);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if ((getIntent().getBooleanExtra("key_check_troop_privilege", false)) && (this.e != null))
    {
      ((TroopHandler)this.app.a(19)).m(this.e);
      this.jdField_a_of_type_Ijo = new ijo(this);
      addObserver(this.jdField_a_of_type_Ijo);
    }
    super.doOnResume();
  }
  
  public void e(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.e(paramArrayList);
  }
  
  public void f(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.f(paramArrayList);
  }
  
  public void finish()
  {
    super.finish();
    if (c()) {
      overridePendingTransition(2130968583, 2130968584);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131299511) {
      onBackEvent2();
    }
    Intent localIntent;
    do
    {
      do
      {
        do
        {
          return;
          super.onClick(paramView);
        } while (!a());
        e();
        localIntent = new Intent(this, FMLocalFileActivity.class);
        localIntent.putExtra("STRING_Show_Music_Category", false);
        localIntent.putExtra("STRING_Show_Video_Category", false);
        localIntent.putExtra("STRING_Show_Apk_Category", false);
        localIntent.putExtra("STRING_Show_Pic_Category", false);
        localIntent.putExtra("STRING_Show_Driver_Category", false);
        localIntent.putExtra("STRING_Show_First_Space", false);
        if ((paramView.getId() != 2131297360) && (paramView.getId() != 2131299517) && (paramView.getId() != 2131299541)) {
          break;
        }
        localIntent.putExtra("localSdCardfile", 1408041717);
        localIntent.putExtra("STRING_Show_Download_Category", false);
        localIntent.putExtra("STRING_Show_MyFile_Category", true);
        a().ag();
        startActivityForResult(localIntent, paramView.getId());
      } while (isModeleWindow());
      overridePendingTransition(2130968602, 2130968606);
      return;
    } while (paramView.getId() != 2131299549);
    localIntent.putExtra("localSdCardfile", 1408041716);
    localIntent.putExtra("STRING_Show_Download_Category", false);
    a().an();
    startActivityForResult(localIntent, paramView.getId());
  }
  
  public void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.o();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("FMActivity<FileAssistant>", 2, "onRestart but mUiEvent is null");
  }
  
  protected void onResume()
  {
    if (FMDataCache.a() > 0L) {
      k();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantIBaseTabViewEvent.n();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */