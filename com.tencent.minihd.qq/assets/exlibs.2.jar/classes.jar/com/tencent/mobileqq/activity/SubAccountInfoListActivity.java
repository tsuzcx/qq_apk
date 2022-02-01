package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import fdd;
import fde;
import fdg;
import java.util.List;

public class SubAccountInfoListActivity
  extends SubAccountBaseActivity
  implements Handler.Callback, View.OnClickListener
{
  public static final int a = 1991;
  private static final String jdField_b_of_type_JavaLangString = "0X800445B";
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fdg(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new fde(this);
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  private boolean c()
  {
    this.jdField_a_of_type_JavaUtilList = ((SubAccountManager)this.app.getManager(59)).b();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "refresh() go to SubaccountUgActivity, mAccountList == null || mAccountList.size() < 1");
      }
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (!this.b)
    {
      setContentView(2130904459);
      setTitle(2131368649);
      this.b = true;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302252));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302253));
    String str = getString(2131368667, new Object[] { this.app.c() });
    ((TextView)findViewById(2131302251)).setText(str);
    e();
    return true;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      runOnUiThread(new fdd(this));
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    View localView;
    while (i < j)
    {
      localView = getLayoutInflater().inflate(2130904457, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      localView.setTag(Integer.valueOf(i));
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      i += 1;
    }
    if (j == 1)
    {
      localView = getLayoutInflater().inflate(2130903044, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      TextView localTextView = (TextView)localView.findViewById(2131296578);
      localTextView.setText(2131368666);
      localTextView.setContentDescription(getString(2131368666) + "按钮");
      localView.setTag(Integer.valueOf(2147483647));
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      f();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateAccounts() return, mAccountListContainer == null || mAccountListContainer.getChildCount() <= 0");
      }
    }
    label348:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "updateAccounts() return,mAccountList == null || mAccountList.size() == 0");
        }
      }
      else
      {
        int i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label348;
          }
          View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          Object localObject1 = localView.getTag();
          if (!(localObject1 instanceof Integer)) {
            break;
          }
          int j = ((Integer)localObject1).intValue();
          if ((this.jdField_a_of_type_JavaUtilList == null) || (j >= this.jdField_a_of_type_JavaUtilList.size())) {
            break;
          }
          localObject1 = (SubAccountInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          if (localObject1 == null) {
            break;
          }
          ImageView localImageView = (ImageView)localView.findViewById(2131296574);
          TextView localTextView2 = (TextView)localView.findViewById(2131298410);
          TextView localTextView1 = (TextView)localView.findViewById(2131302249);
          ((ImageView)localView.findViewById(2131302250)).setVisibility(0);
          String str = ((SubAccountInfo)localObject1).subuin;
          Object localObject2 = ContactUtils.g(this.app, str);
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = str;
          }
          localObject2 = localObject1;
          if (str.equals(localObject1)) {
            localObject2 = ((FriendManager)this.app.getManager(8)).a(str);
          }
          localTextView2.setText((CharSequence)localObject2);
          localObject1 = this.app.b(str);
          localTextView1.setText((CharSequence)localObject1);
          localView.setContentDescription((String)localObject2 + "," + (String)localObject1 + ",触摸两次进入");
          localObject1 = this.app.b(str);
          if (localObject1 != null) {
            localImageView.setBackgroundDrawable((Drawable)localObject1);
          }
          i += 1;
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!c()) {
      return false;
    }
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(getClass());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.app != null) && (this.app.isRunning()))
    {
      c();
      d();
    }
    do
    {
      return;
      finish();
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "SubAccountInfoListActivity.doOnResume() return.app.isRunning == false");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      i = j;
      if ((paramView.getTag() instanceof Integer)) {
        i = ((Integer)paramView.getTag()).intValue();
      }
    }
    if (i < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "onClick() return, index<0:" + i);
      }
    }
    do
    {
      return;
      if (i == 2147483647)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "onAddAccountClick.onClick() add account");
        }
        if (((SubAccountManager)this.app.getManager(59)).a() >= 2)
        {
          SubAccountControll.a(this.app, this);
          c();
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(paramView.getContext(), SubAccountBindActivity.class);
        ((Intent)localObject).putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
        startActivity((Intent)localObject);
        ReportController.a(this.app, "CliOper", "", "", "0X800445B", "0X800445B", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "onClick() return,mAccountList == null || index >= mAccountList.size()");
    return;
    Object localObject = (SubAccountInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if (((SubAccountManager)this.app.getManager(59)).a(((SubAccountInfo)localObject).subuin) == 1) {}
    for (paramView = new Intent(this, SubAccountSettingActivity.class);; paramView = new Intent(this, SubAccountUgActivity.class))
    {
      paramView.putExtra("subAccount", ((SubAccountInfo)localObject).subuin);
      paramView.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
      startActivity(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountInfoListActivity
 * JD-Core Version:    0.7.0.1
 */