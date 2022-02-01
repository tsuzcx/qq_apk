package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import fcs;
import fct;
import fcv;
import fcw;
import fcz;
import fda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SubAccountBindActivity
  extends SubAccountBaseActivity
{
  public static final int a = 1981;
  public static final int b = 1990;
  private static final String jdField_b_of_type_JavaLangString = "Q.subaccount.SubAccountBindActivity";
  Handler jdField_a_of_type_AndroidOsHandler = new fcs(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new fcw(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fda(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new fct(this);
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new fcz(this);
  private boolean jdField_b_of_type_Boolean;
  
  private SimpleAccount a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)localIterator.next();
      if (paramString.equals(localSimpleAccount.getUin())) {
        return localSimpleAccount;
      }
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      Object localObject = getAppRuntime().getApplication().getAllAccounts();
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      localObject = a(this.app.getAccount());
      this.jdField_a_of_type_JavaUtilList.remove(localObject);
      localObject = ((SubAccountManager)this.app.getManager(59)).a();
      if (localObject == null) {
        break;
      }
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        SimpleAccount localSimpleAccount = a((String)((List)localObject).get(i));
        this.jdField_a_of_type_JavaUtilList.remove(localSimpleAccount);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    label281:
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label281;
        }
        Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        Object localObject2 = ((View)localObject1).getTag();
        if (localObject2 == null) {
          break;
        }
        int k = ((Integer)localObject2).intValue();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
        if (localSimpleAccount == null) {
          break;
        }
        ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131296551);
        TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131296582);
        TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131296583);
        localObject1 = (ImageView)((View)localObject1).findViewById(2131296584);
        localObject2 = ContactUtils.g(this.app, localSimpleAccount.getUin());
        localObject1 = localObject2;
        if (localSimpleAccount.isLogined()) {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equals(localSimpleAccount.getUin())) {}
          }
          else
          {
            localObject1 = ((FriendManager)this.app.getManager(8)).a(localSimpleAccount.getUin());
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localSimpleAccount.getUin();
        }
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(this.app.b(localSimpleAccount.getUin()));
        localObject1 = this.app.b(localSimpleAccount.getUin());
        if (localObject1 != null) {
          localImageView.setBackgroundDrawable((Drawable)localObject1);
        }
        i += 1;
      }
    }
  }
  
  protected boolean a(boolean paramBoolean)
  {
    d();
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_a_of_type_JavaUtilList.get(0) == null)) {
      this.jdField_b_of_type_Boolean = true;
    }
    setContentView(2130904458);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296589));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null)
      {
        localView = getLayoutInflater().inflate(2130903044, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        ((TextView)localView.findViewById(2131296578)).setText(2131368665);
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        i += 1;
        break;
        localView = getLayoutInflater().inflate(2130903045, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        localView.setTag(Integer.valueOf(i));
        ((ImageView)localView.findViewById(2131296551)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    e();
    return true;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!a(true)) {
      return false;
    }
    setTitle(2131368650);
    setContentBackgroundResource(2130837687);
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a(getClass());
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_b_of_type_Boolean) {
      runOnUiThread(new fcv(this));
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity
 * JD-Core Version:    0.7.0.1
 */