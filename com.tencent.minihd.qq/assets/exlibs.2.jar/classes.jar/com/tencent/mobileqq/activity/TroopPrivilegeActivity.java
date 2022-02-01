package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import fka;
import fkb;

public class TroopPrivilegeActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public TroopPrivilegeActivity.PrivilegeAdapter a;
  TroopPrivilegeActivity.PrivilegeTroopObserver jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeTroopObserver;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public Object a;
  public String a;
  
  public TroopPrivilegeActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangObject = null;
  }
  
  String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "";
    case 1: 
      return getString(2131363504);
    }
    return getString(2131363505);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903553, null);
    setContentView(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131297158));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter = new TroopPrivilegeActivity.PrivilegeAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter.a(getString(2131363507), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter.a(getString(2131363506), 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeAdapter);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopuin");
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeTroopObserver = new TroopPrivilegeActivity.PrivilegeTroopObserver(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeTroopObserver);
    ((TroopHandler)this.app.a(19)).m(this.jdField_a_of_type_JavaLangString);
    setTitle(getString(2131367870));
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivilegeActivity$PrivilegeTroopObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    Object localObject = paramView.getTag();
    String str;
    if ((localObject instanceof fkb))
    {
      paramView = (fkb)localObject;
      this.jdField_a_of_type_JavaLangObject = localObject;
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      str = getString(2131363504);
      if (paramView.a != 1) {
        break label118;
      }
      bool1 = true;
      ((ActionSheet)localObject).a(str, bool1);
      str = getString(2131363505);
      if (paramView.a != 2) {
        break label123;
      }
    }
    label118:
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ActionSheet)localObject).a(str, bool1);
      ((ActionSheet)localObject).a(new fka(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).e(2131365736);
      ((ActionSheet)localObject).show();
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopPrivilegeActivity
 * JD-Core Version:    0.7.0.1
 */