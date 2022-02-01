package com.tencent.mobileqq.activity.activateFriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import fnz;
import foa;
import fob;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneGeoGraphicFriend;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, Observer
{
  public static final int a = 1;
  public static final String a = "af_key_from";
  public static final int b = 2;
  private static final String b = "ActivateFriends.MainActivity";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 1000;
  private static final int f = 1;
  private static final int i = 0;
  private static final int j = 1;
  private static final int k = 2;
  private static final int l = 3;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ActivatePageAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new fob(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private boolean jdField_a_of_type_Boolean = false;
  private int g;
  private int h;
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(MessageCache.a() * 1000L);
    int m = ((Calendar)localObject).get(1);
    int n = ((Calendar)localObject).get(2);
    int i1 = ((Calendar)localObject).get(6);
    ((Calendar)localObject).add(6, 1);
    int i2 = ((Calendar)localObject).get(6);
    localObject = new GregorianCalendar();
    ((GregorianCalendar)localObject).set(5, paramInt3);
    ((GregorianCalendar)localObject).set(2, paramInt2 - 1);
    ((GregorianCalendar)localObject).set(1, paramInt1);
    paramInt3 = ((GregorianCalendar)localObject).get(6);
    if (m == paramInt1) {
      if (paramInt3 >= i1) {}
    }
    while (paramInt1 <= m)
    {
      return 0;
      if (paramInt3 == i1) {
        return 1;
      }
      if (paramInt3 == i2) {
        return 2;
      }
      return 3;
    }
    if ((paramInt1 == m + 1) && (n + 1 + 0 == 12) && (paramInt2 == 1))
    {
      if (i2 == paramInt3) {
        return 2;
      }
      return 3;
    }
    return 3;
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      return getString(2131369452, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    case 0: 
      return getString(2131369449);
    case 1: 
      return getString(2131369450);
    }
    return getString(2131369451);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, long[] paramArrayOfLong)
  {
    PositionActivatePage localPositionActivatePage = new PositionActivatePage(this);
    localPositionActivatePage.a(paramQQAppInterface, paramLong, paramString, paramArrayOfLong);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localPositionActivatePage);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, long[] paramArrayOfLong1, String[] paramArrayOfString, long[] paramArrayOfLong2)
  {
    BirthdayActivatePage localBirthdayActivatePage = new BirthdayActivatePage(this);
    localBirthdayActivatePage.a(paramQQAppInterface, paramLong, paramArrayOfLong1, paramArrayOfString, paramArrayOfLong2);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localBirthdayActivatePage);
  }
  
  private boolean a()
  {
    Object localObject1 = null;
    if (getIntent().getExtras() != null) {
      localObject1 = getIntent().getExtras().getString("leftViewText");
    }
    if ((localObject1 != null) && (((String)localObject1).contains(getString(2131366025)))) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        this.app.a().addObserver(this);
      }
      this.app.a().c(AppConstants.aw, 9002);
      localObject1 = this.app.a().a(AppConstants.aw, 9002);
      m = ((List)localObject1).size();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + m);
      }
      if (m != 0) {
        break;
      }
      return false;
    }
    Collections.sort((List)localObject1, new fnz(this));
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      SubMsgType0x76.MsgBody localMsgBody = ((MessageForActivateFriends)localObject2).getMsgBody();
      long l1 = 1000L * ((MessageRecord)localObject2).time;
      long[] arrayOfLong;
      if (localMsgBody.uint32_msg_type.get() == 1)
      {
        localObject2 = localMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8();
        arrayOfLong = new long[localMsgBody.msg_geographic_notify.rpt_msg_one_friend.get().size()];
        m = 0;
        while (m < arrayOfLong.length)
        {
          arrayOfLong[m] = ((SubMsgType0x76.OneGeoGraphicFriend)localMsgBody.msg_geographic_notify.rpt_msg_one_friend.get().get(m)).uint64_uin.get();
          m += 1;
        }
        a(this.app, l1, (String)localObject2, arrayOfLong);
      }
      else
      {
        localObject2 = new long[localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().size()];
        arrayOfLong = new long[localObject2.length];
        String[] arrayOfString = new String[localObject2.length];
        m = 0;
        if (m < localObject2.length)
        {
          localObject2[m] = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint64_uin.get();
          int n = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint32_birth_month.get();
          int i1 = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint32_birth_date.get();
          int i2 = a(((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint32_birth_year.get(), n, i1);
          arrayOfString[m] = a(i2, n, i1);
          if ((i2 == 0) || (i2 == 1)) {
            arrayOfLong[m] = MessageCache.a();
          }
          for (;;)
          {
            m += 1;
            break;
            arrayOfLong[m] = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint64_msg_send_time.get();
          }
        }
        a(this.app, l1, (long[])localObject2, arrayOfString, arrayOfLong);
      }
    }
    this.h = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.getCount();
    if (this.h > 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.g = 0;
      a(this.g);
    }
    return true;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", 0, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
  }
  
  private void c()
  {
    super.setContentView(2130903825);
    super.setTitle(2131369424);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297361));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838415);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298426));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131299745));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(80));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131369090));
  }
  
  void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131369440), this.jdField_a_of_type_Boolean);
    localActionSheet.a(new foa(this, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  void a(int paramInt)
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "setIndicatorSelected-->index = " + paramInt);
    }
    if (this.h <= 1)
    {
      paramInt = m;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
    }
    m = 0;
    while (m < this.h)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m).setVisibility(0);
      m += 1;
    }
    m = 0;
    if (m < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if (m == paramInt) {
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m)).setImageResource(2130837558);
      }
      for (;;)
      {
        m += 1;
        break;
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m)).setImageResource(2130837557);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int m = -1;
    StringBuilder localStringBuilder = new StringBuilder("doOnActiResult").append(" | rs code = ").append(paramInt2);
    long[] arrayOfLong;
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      if (paramIntent != null)
      {
        arrayOfLong = paramIntent.getLongArrayExtra("key_friend_list");
        paramInt2 = paramIntent.getIntExtra("key_msg_type", -1);
        if ((arrayOfLong != null) && (arrayOfLong.length > 0) && (paramInt2 != -1)) {
          this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(arrayOfLong, paramInt2);
        }
        paramIntent = localStringBuilder.append(" | uinArray len = ");
        if (arrayOfLong != null) {
          break label140;
        }
      }
    }
    label140:
    for (paramInt1 = m;; paramInt1 = arrayOfLong.length)
    {
      paramIntent.append(paramInt1).append(" | type = ").append(paramInt2);
      super.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    b();
    c();
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    b();
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.g = paramInt;
    a(paramInt);
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      if (this.g == 0) {
        localTopGestureLayout.setInterceptTouchFlag(true);
      }
    }
    else {
      return;
    }
    localTopGestureLayout.setInterceptTouchFlag(false);
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity
 * JD-Core Version:    0.7.0.1
 */