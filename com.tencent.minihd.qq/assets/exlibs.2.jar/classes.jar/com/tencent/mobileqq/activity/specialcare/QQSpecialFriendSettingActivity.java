package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import gzx;
import gzy;
import gzz;
import haa;
import hab;

public class QQSpecialFriendSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, FaceDecoder.DecodeTaskCompletionListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "QQSpecialFriendSettingActivity";
  private static final int jdField_b_of_type_Int = 0;
  private static final int c = 8193;
  private static final int d = 8194;
  private static final int e = 8195;
  public final Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new haa(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new hab(this);
  private SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString;
  private int f;
  
  public QQSpecialFriendSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new gzz(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300564));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300562));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300565));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300566);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300568);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300567));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296683));
    if (this.jdField_a_of_type_Boolean)
    {
      setLeftViewName(2131367014);
      setRightButton(2131367064, new gzx(this));
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    setLeftViewName(2131365818);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, this.jdField_b_of_type_JavaLangString, 3000);
    if (localObject == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_b_of_type_JavaLangString, 1, true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.a());
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_b_of_type_JavaLangString);
      if (localObject != null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject).getFriendNickWithAlias());
  }
  
  private void c()
  {
    boolean bool2 = true;
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "showItems mSpecInfo: " + this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo == null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.specialRingSwitch == 0)
    {
      bool1 = false;
      ((FormSwitchItem)localObject).setChecked(bool1);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo.qzoneSwitch == 0) {
        bool1 = false;
      }
      ((FormSwitchItem)localObject).setChecked(bool1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label248;
      }
    }
    for (;;)
    {
      ((FormSimpleItem)localObject).setVisibility(i);
      e();
      return;
      bool1 = true;
      break;
      label248:
      i = 8;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new gzy(this));
  }
  
  private void e()
  {
    String str2;
    FormSimpleItem localFormSimpleItem;
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.f = ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").getInt("special_care_id_cache" + this.jdField_b_of_type_JavaLangString, 1);
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(this.f);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (TextUtils.isEmpty(str2)) {}
      for (str1 = getString(2131367201);; str1 = str2)
      {
        localFormSimpleItem.setRightText(str1);
        if (QLog.isColorLevel()) {
          QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice FromForwardFriendActivity mFriUin: " + this.jdField_b_of_type_JavaLangString + ", soundId: " + this.f + ", soundName: " + str2);
        }
        return;
      }
    }
    if (QvipSpecialCareManager.a(this.jdField_b_of_type_JavaLangString, this.app))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a()) {
        d();
      }
      int i = QvipSpecialCareManager.a(this.jdField_b_of_type_JavaLangString, this.app);
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice mFriUin: " + this.jdField_b_of_type_JavaLangString + ", soundId: " + i + ", soundName: " + str2);
      }
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getString(2131367201);
      }
      localFormSimpleItem.setRightText(str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "updatePersonalVoice not contain friend: " + this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131367201));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904033);
    setTitle(2131369159);
    paramBundle = getIntent();
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_friend_uin");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("key_is_from_friendsforward_activity", false);
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(49));
    if (this.app != null)
    {
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    b();
    ReportController.b(null, "CliOper", "", "", "0X80050E5", "0X80050E5", 0, 0, "0", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "doOnCreate mFriUin: " + this.jdField_b_of_type_JavaLangString);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.app != null)
    {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_Boolean) {
      ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences").edit().remove("special_care_id_cache" + this.jdField_b_of_type_JavaLangString).commit();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    c();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 2;
    boolean bool = false;
    if (!paramCompoundButton.isPressed()) {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", NOT switched by user.");
      }
    }
    int i;
    label108:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "onCheckedChanged isCheck: " + paramBoolean + ", switched by user.");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break;
      }
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
    } while (this.jdField_a_of_type_Boolean);
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      i = j;
    }
    for (;;)
    {
      if (!NetworkUtil.f(this)) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(i, new String[] { this.jdField_b_of_type_JavaLangString }, new boolean[] { paramBoolean });
      return;
      i = 8;
      break label108;
      if (paramCompoundButton != this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break;
      }
      i = 3;
      paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    }
    label201:
    Object localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
    ((Message)localObject).arg1 = 0;
    ((Message)localObject).arg2 = 2131365730;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    paramBoolean = bool;
    if (!paramCompoundButton.a()) {
      paramBoolean = true;
    }
    paramCompoundButton.setChecked(paramBoolean);
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
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/specialRing/rel/index.html?_wv=1027&suin=" + this.jdField_b_of_type_JavaLangString + "&uin=" + this.app.a() + "&_bid=279&lazy=" + this.jdField_a_of_type_Boolean);
    paramView.putExtra("uin", this.jdField_b_of_type_JavaLangString);
    startActivity(paramView);
    return;
    if (NetworkUtil.f(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, new String[] { this.jdField_b_of_type_JavaLangString }, new boolean[] { false });
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8193);
      paramView.obj = getString(2131369171);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramView);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
      return;
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8195);
      paramView.arg1 = 0;
      paramView.arg2 = 2131365730;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity
 * JD-Core Version:    0.7.0.1
 */