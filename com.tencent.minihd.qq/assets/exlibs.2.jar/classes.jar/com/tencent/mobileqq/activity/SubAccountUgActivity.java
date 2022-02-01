package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import fel;
import fen;
import feo;
import fep;
import feq;
import fer;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SubAccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 1980;
  Handler jdField_a_of_type_AndroidOsHandler = new feo(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new fep(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new fel(this);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  
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
          paramSubAccountControll.a(this.app, this, localPair, new fen(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    View localView = findViewById(2131302260);
    TextView localTextView1 = (TextView)findViewById(2131302257);
    TextView localTextView2 = (TextView)findViewById(2131302258);
    ImageView localImageView = (ImageView)findViewById(2131302255);
    ((Button)findViewById(2131302259)).setText(2131368662);
    localView.setVisibility(8);
    localTextView1.setText(2131368651);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130841998);
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_JavaLangString.equals(paramIntent.getStringExtra("subAccount"))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("subAccount");
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(59);
    this.jdField_b_of_type_Boolean = localSubAccountManager.a(this.jdField_b_of_type_JavaLangString);
    boolean bool1 = false;
    paramBundle = SubAccountControll.a(this.app, this.jdField_b_of_type_JavaLangString);
    boolean bool2;
    if (paramBundle != null)
    {
      bool2 = ((Boolean)paramBundle.first).booleanValue();
      bool1 = ((Boolean)paramBundle.second).booleanValue();
    }
    for (;;)
    {
      if (bool1)
      {
        SubAccountAssistantForward.a(this.app, this, this.jdField_b_of_type_JavaLangString);
        finish();
        return false;
      }
      setContentView(2130904461);
      setTitle(2131368649);
      ImageView localImageView2 = (ImageView)findViewById(2131302256);
      ImageView localImageView1 = (ImageView)findViewById(2131302255);
      TextView localTextView1 = (TextView)findViewById(2131302257);
      TextView localTextView2 = (TextView)findViewById(2131302258);
      Button localButton = (Button)findViewById(2131302259);
      View localView = findViewById(2131302260);
      Object localObject = this.app.a(this.app.getAccount(), false);
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = ImageUtil.a();
      }
      localImageView2.setImageBitmap(paramBundle);
      localTextView1.setTextColor(getResources().getColor(2131427934));
      localTextView2.setVisibility(8);
      int i;
      if (this.jdField_b_of_type_Boolean)
      {
        if (!bool2) {
          break label620;
        }
        if (localSubAccountManager == null) {
          break label615;
        }
        paramBundle = localSubAccountManager.a(this.jdField_b_of_type_JavaLangString);
        if (paramBundle == null) {
          break label615;
        }
        i = ((Integer)paramBundle.first).intValue();
        if (i != 0) {
          switch (i)
          {
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        int j = i;
        if (i == 0) {
          j = 2131368653;
        }
        localTextView1.setTextColor(getResources().getColor(2131427934));
        paramBundle = this.app.a(this.jdField_b_of_type_JavaLangString, false);
        if (paramBundle != null) {
          localImageView1.setImageBitmap(paramBundle);
        }
        localObject = ContactUtils.c(this.app, this.jdField_b_of_type_JavaLangString, true);
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          paramBundle = this.jdField_b_of_type_JavaLangString;
        }
        localTextView1.setText(getString(j, new Object[] { paramBundle }));
        if (j == 2131368653)
        {
          localTextView2.setVisibility(0);
          label455:
          localButton.setText(2131368663);
          localView.setVisibility(0);
          ((Button)localView.findViewById(2131302261)).setOnClickListener(this);
          ((Button)localView.findViewById(2131302263)).setOnClickListener(this);
        }
        for (;;)
        {
          localButton.setOnClickListener(this);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          e();
          this.app.a().addObserver(this);
          this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
          return true;
          i = 2131368702;
          break;
          i = 2131368700;
          break;
          i = 2131368701;
          break;
          i = 2131368702;
          break;
          i = 2131368702;
          break;
          i = 2131368653;
          break;
          localTextView2.setVisibility(8);
          break label455;
          localImageView1.setImageResource(2130841998);
        }
        label615:
        i = 0;
        break;
        label620:
        i = 0;
      }
      bool2 = false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.a(getClass());
    this.app.a().deleteObserver(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131302260: 
    case 2131302262: 
    default: 
      return;
    case 2131302259: 
      Intent localIntent = new Intent();
      if (this.jdField_b_of_type_Boolean)
      {
        localIntent.putExtra("is_need_bind", false);
        localIntent.putExtra("subuin", this.jdField_b_of_type_JavaLangString);
        localIntent.setClass(this, SubLoginActivity.class);
        localIntent.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
        startActivity(localIntent);
        return;
      }
      localIntent.setClass(paramView.getContext(), SubAccountBindActivity.class);
      localIntent.putExtra("fromWhere", this.jdField_a_of_type_JavaLangString);
      startActivity(localIntent);
      return;
    case 2131302261: 
      paramView = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
      paramView.a(2131368680);
      paramView.a(getResources().getString(2131368673), 3);
      paramView.e(2131365736);
      paramView.a(new feq(this, paramView));
      paramView.show();
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    paramView.putExtra("reqType", 3);
    paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
    startActivity(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new fer(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity
 * JD-Core Version:    0.7.0.1
 */