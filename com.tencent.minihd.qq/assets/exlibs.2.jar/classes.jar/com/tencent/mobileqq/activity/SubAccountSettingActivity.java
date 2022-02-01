package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import fec;
import fed;
import fef;
import feg;
import feh;
import fei;
import fej;
import fek;
import java.util.ArrayList;

public class SubAccountSettingActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener
{
  public static final int a = 1985;
  Handler jdField_a_of_type_AndroidOsHandler = new fec(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new fek(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new fed(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new feg(this);
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "Q.subaccount.SubAccountSettingActivity";
  private Button c;
  
  private void a(SubAccountControll paramSubAccountControll, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramSubAccountControll == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (SubAccountControll.a(this.app, paramString)))
      {
        a();
        paramString = paramSubAccountControll.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramSubAccountControll.a(this.app, this, localPair, new feh(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void d()
  {
    setTitle(2131368669);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302277));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302278));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302279));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302281);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302284));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131302282));
    this.c = ((Button)findViewById(2131302283));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    boolean bool = false;
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(59);
    if (localSubAccountManager != null) {
      bool = localSubAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302280));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fef(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))
      {
        localObject = new Intent(this, SubAccountUgActivity.class);
        ((Intent)localObject).putExtra("subAccount", this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        ((Intent)localObject).putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
        startActivity((Intent)localObject);
        finish();
      }
      do
      {
        return;
        localObject = ContactUtils.c(this.app, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)))) {
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname = ((String)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      } while ((this.app == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)));
      localObject = this.app.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    Object localObject = new Intent(this, SubAccountUgActivity.class);
    ((Intent)localObject).putExtra("subAccount", this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    ((Intent)localObject).putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
    startActivity((Intent)localObject);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904466);
    paramBundle = getIntent().getStringExtra("subAccount");
    this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountManager)this.app.getManager(59)).a(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "doOnCreate() mSubAccountInfo is null.");
      }
      a(this.app.a().getString(2131368693));
      return true;
    }
    d();
    e();
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(getClass());
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    switch (paramView.getId())
    {
    case 2131302282: 
    default: 
      return;
    case 2131302284: 
      localActionSheet.a(2131368674);
      localActionSheet.a(2131365737, 3);
      localActionSheet.e(2131365736);
      localActionSheet.a(new fei(this, localActionSheet));
      localActionSheet.show();
      return;
    case 2131302283: 
      localActionSheet.a(2131368675);
      localActionSheet.a(2131368673, 3);
      localActionSheet.e(2131365736);
      localActionSheet.a(new fej(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    SubAccountAssistantForward.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    finish();
    SubAccountAssistantForward.f(this.app);
    Conversation.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountSettingActivity
 * JD-Core Version:    0.7.0.1
 */