package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import gff;
import gfi;
import gfj;
import gfk;

public class AddContactsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "tab_index_key";
  public static final int b = 1;
  private static final String b = "https://find.qq.com/m/index.html?_wv=1026";
  public static final int c = 2;
  public static final int d = 1;
  public static final int e = 0;
  private static final int f = 250;
  public Handler a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public LinearLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactsView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView;
  public ContactBaseView.IAddContactContext a;
  private ContactBaseView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView;
  private PublicView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView;
  private TroopView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new gfi(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public boolean a;
  
  public AddContactsActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext = new gff(this);
    this.jdField_a_of_type_AndroidOsHandler = new gfk(this);
  }
  
  private void a()
  {
    ((TextView)findViewById(2131297348)).setText(2131367014);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296742));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    String str2 = getIntent().getStringExtra("leftViewText");
    String str1 = str2;
    if (str2 == null) {
      str1 = "联系人";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131299722));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131366951));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setContentDescription("已选定" + getString(2131366951));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131366952));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(getString(2131366952));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(2, getString(2131366953));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(2).setContentDescription(getString(2131366953));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131299723));
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, AddContactsActivity.class));
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, AddContactsActivity.class);
    localIntent.putExtra("tab_index_key", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(ContactBaseView paramContactBaseView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != paramContactBaseView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView = paramContactBaseView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.e();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.b();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView);
      }
    }
  }
  
  private void b()
  {
    int i = getIntent().getIntExtra("tab_index_key", 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i, true);
  }
  
  public static void b(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountBrowser.class);
    if ((paramActivity instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).a());
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", "https://find.qq.com/m/index.html?_wv=1026");
    paramActivity.startActivity(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView = new AddContactsView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView = new TroopView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView = new PublicView(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView.a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof AddContactsView)) {
      return 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView instanceof TroopView)) {
      return 1;
    }
    return 2;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903815);
    getWindow().setBackgroundDrawable(null);
    a();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactAddContactsView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactTroopView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicView.c();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.f();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      Looper.myQueue().addIdleHandler(new gfj(this));
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.e();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView.g();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */