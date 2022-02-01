package com.tencent.mobileqq.dating.widget;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;

public class VoteEventMgr
{
  public static final int a = 4098;
  public static final String a = "nearby_like_notification_tag";
  RecentItemVoteData jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageForText jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  
  public VoteEventMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    Context localContext = BaseApplicationImpl.getContext();
    boolean bool = QQUtils.a(localContext);
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) || (bool))
    {
      Object localObject2 = BitmapManager.a(localContext.getResources(), 2130840359);
      localObject1 = new NotificationCompat.Builder(localContext).setContentTitle(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a).setWhen(System.currentTimeMillis());
      if (localObject2 != null) {
        ((NotificationCompat.Builder)localObject1).setLargeIcon((Bitmap)localObject2);
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject1).setSmallIcon(2130840359);
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject2 = new RemoteViews(localContext.getPackageName(), 2130903904);
        ((NotificationCompat.Builder)localObject1).setContent((RemoteViews)localObject2);
        ((RemoteViews)localObject2).setCharSequence(2131297001, "setText", this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a);
        ((RemoteViews)localObject2).setCharSequence(2131299202, "setText", TimeFormatterUtils.a(System.currentTimeMillis(), true, "yyyy-MM-dd"));
      }
      ((NotificationCompat.Builder)localObject1).setContentIntent(PendingIntent.getActivity(localContext, 0, a(), 134217728));
      localObject1 = ((NotificationCompat.Builder)localObject1).build();
      ((Notification)localObject1).flags |= 0x10;
      ((Notification)localObject1).defaults |= 0x1;
      ((Notification)localObject1).defaults |= 0x4;
      ((Notification)localObject1).icon = 2130840359;
      localObject2 = (NotificationManager)localContext.getSystemService("notification");
      if (localObject2 != null)
      {
        ((NotificationManager)localObject2).cancel("nearby_like_notification_tag", 4098);
        ((NotificationManager)localObject2).notify("nearby_like_notification_tag", 4098, (Notification)localObject1);
      }
    }
    if (bool)
    {
      localObject1 = (QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68);
      if (SettingCloneUtil.readValue(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localContext.getString(2131367906), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface VoteEventMgr.notifyVoteEvent");
        }
        ((QQLSRecentManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.ay, 1012, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyObservers(a());
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData == null) {
      return 0;
    }
    return 1;
  }
  
  public Intent a()
  {
    Object localObject = BaseApplicationImpl.getContext();
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    localObject = new Intent((Context)localObject, NearbyPeopleProfileActivity.class);
    ((Intent)localObject).putExtra("param_mode", 2);
    ((Intent)localObject).putExtra("AllInOne", localAllInOne);
    ((Intent)localObject).putExtra("abp_flag", true);
    ((Intent)localObject).putExtra("frome_where", 1);
    ((Intent)localObject).putExtra("PUSH_CONTENT", this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a);
    ((Intent)localObject).addFlags(335544320);
    return localObject;
  }
  
  public RecentBaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData;
  }
  
  public MessageForText a(RecentBaseData paramRecentBaseData)
  {
    paramRecentBaseData = (RecentItemVoteData)paramRecentBaseData;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)MessageRecordFactory.a(-1000));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msgtype = -1000;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop = 1012;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.isread = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = AppConstants.au;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = AppConstants.au;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = paramRecentBaseData.a;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = paramRecentBaseData.b;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(paramRecentBaseData.a))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = paramRecentBaseData.a;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != paramRecentBaseData.b) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = paramRecentBaseData.b;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData == null)
    {
      RecentUser localRecentUser = new RecentUser();
      localRecentUser.uin = AppConstants.ay;
      localRecentUser.msgType = 1012;
      localRecentUser.type = 1012;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData = new RecentItemVoteData(localRecentUser);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a("text wording", System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a("text wording", l);
    c();
  }
  
  public void a(SubMsgType0x6f.MCardNotificationLike paramMCardNotificationLike)
  {
    String str = "";
    if (paramMCardNotificationLike.str_wording.has()) {
      str = paramMCardNotificationLike.str_wording.get();
    }
    if (TextUtils.isEmpty(str)) {}
    long l;
    do
    {
      return;
      l = MessageCache.a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData == null)
      {
        paramMCardNotificationLike = new RecentUser();
        paramMCardNotificationLike.uin = AppConstants.ay;
        paramMCardNotificationLike.msgType = 1012;
        paramMCardNotificationLike.type = 1012;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData = new RecentItemVoteData(paramMCardNotificationLike);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a(str, l);
        c();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a.equals(str)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.b == l));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a(str, l);
    c();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData = null;
    NotificationManager localNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
    if (localNotificationManager != null) {
      localNotificationManager.cancel("nearby_like_notification_tag", 4098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.VoteEventMgr
 * JD-Core Version:    0.7.0.1
 */