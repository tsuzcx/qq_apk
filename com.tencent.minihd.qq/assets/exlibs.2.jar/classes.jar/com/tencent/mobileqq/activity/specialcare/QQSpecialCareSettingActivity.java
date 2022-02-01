package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import gzt;
import gzu;
import gzv;
import gzw;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "key_friend_uin";
  private static final int jdField_b_of_type_Int = 0;
  public static final String b = "key_is_from_management_activity";
  private static final int jdField_c_of_type_Int = 8193;
  private static final String jdField_c_of_type_JavaLangString = "QQSpecialCareSettingActivity";
  private static final int jdField_d_of_type_Int = 8194;
  private static final int e = 8195;
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gzv(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new gzw(this);
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private View jdField_c_of_type_AndroidViewView;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_d_of_type_JavaLangString;
  
  public QQSpecialCareSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new gzu(this);
  }
  
  private void a()
  {
    boolean bool2 = true;
    int j = 8;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        ((View)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getParent()).setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        ((View)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getParent()).setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      ((View)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getParent()).setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getParent()).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.globalSwitch == 0)
    {
      bool1 = false;
      ((FormSwitchItem)localObject).setChecked(bool1);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch != 0) {
        break label509;
      }
      bool1 = false;
      label306:
      ((FormSwitchItem)localObject).setChecked(bool1);
      localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
        bool1 = false;
      }
      ((FormSwitchItem)localObject).setChecked(bool1);
      bool1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!bool1) {
        break label514;
      }
      i = 0;
      label359:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!bool1) {
        break label520;
      }
      i = 0;
      label377:
      ((FormSwitchItem)localObject).setVisibility(i);
      localObject = (View)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getParent();
      if (!bool1) {
        break label526;
      }
      i = 0;
      label401:
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (!bool1) {
        break label532;
      }
      i = 0;
      label419:
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if ((!bool1) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        break label538;
      }
    }
    label514:
    label520:
    label526:
    label532:
    label538:
    for (int i = 0;; i = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidViewView;
      i = j;
      if (bool1)
      {
        i = j;
        if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          i = 0;
        }
      }
      ((View)localObject).setVisibility(i);
      ((View)this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getParent()).setVisibility(0);
      c();
      return;
      bool1 = true;
      break;
      label509:
      bool1 = true;
      break label306;
      i = 8;
      break label359;
      i = 8;
      break label377;
      i = 8;
      break label401;
      i = 8;
      break label419;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new gzt(this));
  }
  
  private void c()
  {
    if (QvipSpecialCareManager.a(this.d, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        b();
      }
      int i = QvipSpecialCareManager.a(this.d, this.app);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.d + ", soundId: " + i + ", soundName: " + str2);
      }
      FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131367201);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131367201));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904032);
    setTitle(2131369159);
    setLeftViewName(2131366374);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300560));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300561);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300562));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300563);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300565));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131300566);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300564));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(49));
    this.d = getIntent().getStringExtra("key_friend_uin");
    if (this.app != null)
    {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "doOnCreate mFriUin: " + this.d);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  public void finish()
  {
    if (getIntent().getBooleanExtra("key_is_from_management_activity", false)) {
      setResult(-1);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 2;
    boolean bool2 = true;
    boolean bool1 = true;
    int j = 0;
    if (!paramCompoundButton.isPressed()) {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", NOT switched by user.");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
      }
      if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (NetworkUtil.f(this))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, new String[] { this.d }, new boolean[] { paramBoolean });
          paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
          return;
        }
        paramCompoundButton = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
        paramCompoundButton.arg1 = 0;
        paramCompoundButton.arg2 = 2131365730;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramCompoundButton);
        paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          return;
        }
      }
    } while ((paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (paramCompoundButton != this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()));
    if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      label259:
      if (!NetworkUtil.f(this)) {
        break label359;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(i, new String[] { this.d }, new boolean[] { paramBoolean });
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label418;
      }
      i = 0;
      label309:
      paramCompoundButton.setVisibility(i);
      paramCompoundButton = this.jdField_a_of_type_AndroidViewView;
      if (!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label424;
      }
    }
    label418:
    label424:
    for (i = j;; i = 8)
    {
      paramCompoundButton.setVisibility(i);
      return;
      if (paramCompoundButton != this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break;
      }
      i = 3;
      paramCompoundButton = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      break label259;
      label359:
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      localMessage.arg1 = 0;
      localMessage.arg2 = 2131365730;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (!paramCompoundButton.a()) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        break;
      }
      i = 8;
      break label309;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (int i = 0;; i = paramView.getId()) {
      switch (i)
      {
      default: 
        return;
      }
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/specialRing/rel/index.html?_wv=1027&suin=" + this.d + "&uin=" + this.app.a() + "&_bid=279");
    paramView.putExtra("uin", this.d);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */