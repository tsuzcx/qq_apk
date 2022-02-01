package com.tencent.mobileqq.filemanager.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.List;
import jbw;
import jbx;
import jca;
import jcb;
import jcc;

public class SendBottomBar
  extends RelativeLayout
{
  public ProgressDialog a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new jbw(this);
  public TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private IClickListener_Ver51 jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51;
  private View.OnClickListener b;
  public TextView b;
  public TextView c;
  private TextView d = null;
  private TextView e = null;
  private TextView f = null;
  
  public SendBottomBar(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new jbx(this);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903768, this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  public SendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new jbx(this);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903768, this, true);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299541));
    this.e = ((TextView)findViewById(2131299544));
    this.f = ((TextView)findViewById(2131299545));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297398));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.d = ((TextView)findViewById(2131299543));
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void e()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject = FMDataCache.b();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      localArrayList.add(((FileInfo)((ArrayList)localObject).get(i)).d());
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, localArrayList);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent();
    ((Intent)localObject).putExtra("_UIN_", str);
    ((Intent)localObject).putExtra("_SEND_QLINK_FILE_", true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  private void f()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.d();
    if ((1 == i) && (!bool))
    {
      FMDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2131364827, 2131364828, new jca(this));
      return;
    }
    e();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.setResult(-1, new Intent("Finish All modal"));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.finish();
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_b_of_type_AndroidViewView$OnClickListener;
  }
  
  public void a()
  {
    boolean bool3 = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
    Object localObject;
    String str1;
    label225:
    boolean bool1;
    if (i == 5)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363280) + this.jdField_a_of_type_AndroidContentContext.getString(2131362471) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362472);
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131362393) + FileUtil.a(FMDataCache.c());
      str1 = str2;
      if (FMDataCache.d() > 0L) {
        str1 = str2 + this.jdField_a_of_type_AndroidContentContext.getString(2131362394) + FileUtil.a(FMDataCache.d());
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.b())
      {
      default: 
        i = this.d.getVisibility();
        if ((i == 4) || (i == 8))
        {
          this.f.setVisibility(0);
          this.e.setVisibility(8);
          this.f.setText(str1);
          if (FileManagerUtil.a() == null) {
            break label538;
          }
          bool1 = true;
          label233:
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          if (FMDataCache.a() <= 0L) {
            break label543;
          }
          bool2 = true;
          label258:
          ((TextView)localObject).setEnabled(bool2);
          this.d.setEnabled(bool1);
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          if (FMDataCache.a() <= 0L) {
            break label548;
          }
        }
        break;
      }
    }
    label538:
    label543:
    label548:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      ((TextView)localObject).setSelected(bool2);
      this.d.setSelected(bool1);
      return;
      if (i == 6001)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362389) + this.jdField_a_of_type_AndroidContentContext.getString(2131362471) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362472);
        break;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131362384) + this.jdField_a_of_type_AndroidContentContext.getString(2131362471) + FMDataCache.a() + this.jdField_a_of_type_AndroidContentContext.getString(2131362472);
      break;
      i = this.d.getVisibility();
      if ((i == 4) || (i == 8))
      {
        this.f.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setText(2131364826);
        break label225;
      }
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      this.e.setText(2131364826);
      break label225;
      this.e.setVisibility(0);
      this.f.setVisibility(8);
      this.e.setText(str1);
      break label225;
      bool1 = false;
      break label233;
      bool2 = false;
      break label258;
    }
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      c();
    }
    for (;;)
    {
      this.c.setText(paramInt);
      if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
      }
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(SplashActivity.sTopActivity, 2131558902);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.getWindow().setContentView(2130903413);
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903413);
      this.c = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298140));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((FileManagerUtil.a()) && (FMDataCache.a()) && (paramBoolean))
    {
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131362469, 2131362465, new jcb(this));
      return;
    }
    b();
  }
  
  public void b()
  {
    a(2131368525);
    new Handler().post(new jcc(this));
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setActivity(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getAppRuntime());
  }
  
  public void setClickListener(IClickListener_Ver51 paramIClickListener_Ver51)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilIClickListener_Ver51 = paramIClickListener_Ver51;
  }
  
  public void setEditBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.d;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      a();
      return;
    }
  }
  
  public void setSendBtnVisible(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar
 * JD-Core Version:    0.7.0.1
 */