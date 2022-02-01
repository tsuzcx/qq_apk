package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.util.ImplDataReportHandle_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import ijh;
import iji;
import ijj;
import java.util.ArrayList;

public abstract class BaseFileAssistantActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new iji(this);
  public RelativeLayout a;
  public TextView a;
  FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ijj(this);
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  private IReport_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51;
  public QfileEditBottomBar a;
  public SendBottomBar a;
  final String jdField_a_of_type_JavaLangString = "BaseFileAssistantActivity<FileAssistant>";
  public boolean a;
  private int b;
  public String b;
  protected boolean b;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  protected boolean c;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private int e;
  public boolean e;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private boolean i;
  private boolean j;
  
  public BaseFileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
  }
  
  private void l()
  {
    i();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar = ((SendBottomBar)findViewById(2131299540));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setActivity(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar = ((QfileEditBottomBar)findViewById(2131299487));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setActivity(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(8);
    if (c())
    {
      g();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.rightViewText.setEnabled(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.jdField_a_of_type_AndroidWidgetTextView.isEnabled());
      this.rightViewText.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a());
    }
    while (!e()) {
      return;
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299550));
    }
    if ((c()) || (e())) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      b(h());
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public IReport_Ver51 a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    super.setContentViewNoTitle(2130903771);
    ((RelativeLayout)findViewById(2131299548)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131299517));
    f();
    j();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setClickListener(paramIClickListener_Ver51);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setClickListener(paramIClickListener_Ver51);
  }
  
  public void a(ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      startTitleProgress();
      return;
    }
    stopTitleProgress();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setEditBtnVisible(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    f();
  }
  
  public void b(ArrayList paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return this.f;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void c()
  {
    this.rightViewText.setVisibility(0);
  }
  
  public void c(ArrayList paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void d()
  {
    this.rightViewText.setVisibility(8);
  }
  
  public void d(ArrayList paramArrayList) {}
  
  protected void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if (paramInt2 == 4) {
      if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
        a(paramIntent.getExtras());
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt2 != -1) {
          break;
        }
      } while ((paramIntent == null) || (paramIntent.getExtras() == null));
      a(paramIntent.getExtras());
      return;
      if (paramInt2 == 5)
      {
        setResult(5, null);
        finish();
        return;
      }
    } while (paramInt2 != 10);
    setResult(10, paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    paramBundle = getIntent();
    d(paramBundle.getBooleanExtra("selectMode", c()));
    boolean bool;
    if (!c())
    {
      bool = true;
      c(paramBundle.getBooleanExtra("enableDelete", bool));
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
      this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("srcDiscGroup");
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("peerType", 0);
      this.j = paramBundle.getBooleanExtra("rootEntrace", true);
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("busiType", 0);
      this.jdField_e_of_type_Int = paramBundle.getIntExtra("enterfrom", 0);
      this.jdField_d_of_type_Int = paramBundle.getIntExtra("sendprepare", -100);
      this.i = paramBundle.getBooleanExtra("apautocreate", false);
      this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
      this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("qlinkselect", false);
      if (!this.jdField_c_of_type_Boolean) {
        break label243;
      }
      FMDataCache.a(50);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnCreate ");
      }
      return true;
      bool = false;
      break;
      label243:
      FMDataCache.a(20);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseFileAssistantActivity<FileAssistant>", 2, ">>>>>" + getClass().getSimpleName() + "<<<<< doOnDestroy ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void doOnResume()
  {
    this.jdField_e_of_type_Boolean = true;
    k();
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    super.doOnResume();
  }
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void e()
  {
    this.jdField_e_of_type_Boolean = false;
    new Handler().postDelayed(new ijh(this), 1500L);
  }
  
  public void e(ArrayList paramArrayList) {}
  
  public void e(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean e()
  {
    return this.h;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299549));
      g();
    }
    l();
    if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
      d();
    }
    m();
    n();
  }
  
  public void f(ArrayList paramArrayList) {}
  
  public boolean f()
  {
    return (c()) && (isModeleWindow());
  }
  
  public void finish()
  {
    super.finish();
    if (this.j)
    {
      if (b() == 1) {
        this.app.a().f();
      }
      if (h()) {
        FMDataCache.b();
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.isShown();
    }
    return false;
  }
  
  public void h()
  {
    setTitle(this.jdField_b_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Int == 1) && (!h())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public boolean h()
  {
    return (c()) || (e());
  }
  
  public void i()
  {
    if (h()) {}
    for (;;)
    {
      this.rightViewText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131362354);
    }
  }
  
  public boolean i()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51 == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIReport_Ver51 = new ImplDataReportHandle_Ver51();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.a();
    if (c())
    {
      this.rightViewText.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.rightViewText.setEnabled(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.jdField_a_of_type_AndroidWidgetTextView.isEnabled());
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a();
    long l = FMDataCache.a();
    if ((!this.jdField_d_of_type_Boolean) && (h()))
    {
      if (FMDataCache.a() == 0L) {
        h();
      }
    }
    else {
      return;
    }
    setTitle("已选" + l + "个");
  }
  
  public void onClick(View paramView) {}
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2130903771);
    ((RelativeLayout)findViewById(2131299548)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131297360));
    f();
    j();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", c());
    paramIntent.putExtra("enableDelete", b());
    paramIntent.putExtra("targetUin", this.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("srcDiscGroup", this.jdField_d_of_type_JavaLangString);
    paramIntent.putExtra("peerType", this.jdField_b_of_type_Int);
    paramIntent.putExtra("busiType", this.jdField_c_of_type_Int);
    paramIntent.putExtra("enterfrom", this.jdField_e_of_type_Int);
    paramIntent.putExtra("sendprepare", this.jdField_d_of_type_Int);
    paramIntent.putExtra("apautocreate", this.i);
    paramIntent.putExtra("qlinkselect", this.jdField_c_of_type_Boolean);
    paramIntent.putExtra("rootEntrace", false);
    if (isModeleWindow()) {
      paramIntent.putExtra("fragment_no_anim", true);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */