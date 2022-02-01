package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.mobileqq.utils.QQLSSensor.ProximitySensorChangeListener;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import esb;
import esc;
import esd;
import ese;
import esf;
import esg;
import esh;
import esi;
import esj;
import esk;
import esl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;

public class QQLSActivity
  extends AppActivity
  implements View.OnClickListener, DragFrameLayout.OnDragModeChangedListener, QQLSSensor.ProximitySensorChangeListener, Observer
{
  public static int a = 0;
  public static final String a = "QQLSActivity";
  public static boolean a;
  float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new esi(this, Looper.getMainLooper());
  PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new esh(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  public DragFrameLayout a;
  protected MessageObserver a;
  NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QQLSRecentManager a;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  public QQLSSensor a;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private esk jdField_a_of_type_Esk;
  private esl jdField_a_of_type_Esl;
  public ArrayList a;
  public Comparator a;
  public final int b;
  private long jdField_b_of_type_Long = 0L;
  private PowerManager.WakeLock jdField_b_of_type_AndroidOsPowerManager$WakeLock;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  public Comparator b;
  private boolean jdField_b_of_type_Boolean = false;
  public final int c;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 300;
  private boolean jdField_d_of_type_Boolean = true;
  private final int jdField_e_of_type_Int = 1000;
  private boolean jdField_e_of_type_Boolean = false;
  private final int jdField_f_of_type_Int = 1;
  private boolean jdField_f_of_type_Boolean = true;
  private final int g = 2;
  private final int h = 3;
  private final int i = 4;
  private final int j = 5;
  private final int k = 6;
  private final int l = 7;
  private final int m = 8;
  private final int n = 9;
  private final int o = 10;
  private final int p = 1500;
  private final int q = 1000;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public QQLSActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilComparator = new esd(this);
    this.jdField_b_of_type_JavaUtilComparator = new ese(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new esf(this);
  }
  
  private int a()
  {
    int i2 = 10000;
    try
    {
      i1 = Settings.System.getInt(getContentResolver(), "screen_off_timeout");
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getScreenOffTime " + i1);
      }
      return i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQLSActivity", 2, "getScreenOffTime e=" + localException.getMessage());
          i1 = i2;
        }
      }
    }
  }
  
  private SessionInfo a(RecentBaseData paramRecentBaseData)
  {
    int i1 = paramRecentBaseData.a();
    String str = paramRecentBaseData.a();
    SessionInfo localSessionInfo = new SessionInfo();
    Object localObject;
    if (i1 == 1)
    {
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null)
      {
        if (!((FriendManager)localObject).f(str)) {
          break label103;
        }
        localObject = ((FriendManager)localObject).a(str);
        if (localObject != null) {
          localSessionInfo.jdField_b_of_type_JavaLangString = ((OpenTroopInfo)localObject).troopUin;
        }
      }
    }
    for (;;)
    {
      localSessionInfo.jdField_a_of_type_JavaLangString = str;
      localSessionInfo.jdField_a_of_type_Int = i1;
      localSessionInfo.d = paramRecentBaseData.jdField_a_of_type_JavaLangString;
      return localSessionInfo;
      label103:
      localObject = ((FriendManager)localObject).a(str + "");
      if ((localObject != null) && (((TroopInfo)localObject).troopcode != null))
      {
        localSessionInfo.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject).troopcode;
        continue;
        if (i1 == 1006)
        {
          localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
          localSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
          localSessionInfo.f = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
          if ((localSessionInfo.f == null) && (QLog.isColorLevel())) {
            QLog.d("QQLSActivity", 2, "contactUin == null");
          }
        }
        else if (((i1 == 1004) || (i1 == 1000)) && ((paramRecentBaseData instanceof RecentUserBaseData)))
        {
          localSessionInfo.jdField_b_of_type_JavaLangString = ((RecentUserBaseData)paramRecentBaseData).c();
        }
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    d();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enterAIO");
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData)) {}
    for (Object localObject = ((RecentUserBaseData)paramRecentBaseData).a();; localObject = null)
    {
      if (paramRecentBaseData != null) {
        paramRecentBaseData.b();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
      QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_f_of_type_Boolean = true;
      if (b())
      {
        d();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        if (((RecentUser)localObject).type == 1012)
        {
          paramRecentBaseData = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          localObject = new Intent(this, NearbyPeopleProfileActivity.class);
          ((Intent)localObject).putExtra("param_mode", 2);
          ((Intent)localObject).putExtra("AllInOne", paramRecentBaseData);
          ((Intent)localObject).putExtra("abp_flag", true);
          ((Intent)localObject).putExtra("frome_where", 1);
          ((Intent)localObject).addFlags(67108864);
          startActivity((Intent)localObject);
        }
        for (;;)
        {
          paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
          return;
          paramRecentBaseData = new Intent(this, SplashActivity.class);
          paramRecentBaseData.putExtra("tab_index", 1);
          paramRecentBaseData.setFlags(67108864);
          startActivity(paramRecentBaseData);
        }
      }
      RecentUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject, paramRecentBaseData.jdField_a_of_type_JavaLangString, true, 1);
      paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (GesturePWDUtils.getJumpLock(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {}
      for (long l1 = 500L;; l1 = 0L)
      {
        ((Handler)localObject).sendMessageDelayed(paramRecentBaseData, l1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        paramRecentBaseData = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRecentBaseData, 1500L);
        return;
      }
    }
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    QQLSRecentManager localQQLSRecentManager;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("judge need to wake up, now =").append(l1).append(", firstMsgTime =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_a_of_type_Long).append(", lastWakeUpTime = ");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localObject = ((StringBuilder)localObject).append(QQLSRecentManager.jdField_b_of_type_Long).append(", wakeUpTimeAfter30Minute =");
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QLog.d("QQLSActivity", 2, QQLSRecentManager.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_c_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "消息是群消息不点亮");
      }
    }
    do
    {
      return false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (l1 < QQLSRecentManager.jdField_a_of_type_Long + 1800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "30分钟以内，每一条消息亮屏一次");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_b_of_type_Long = l1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Boolean = false;
        return true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      long l2 = Math.min(6, QQLSRecentManager.jdField_a_of_type_Int + 1) * 10 * 60 * 1000;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("之前提醒过");
        localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QLog.d("QQLSActivity", 2, QQLSRecentManager.jdField_a_of_type_Int + "次");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      if (l1 > l2 + QQLSRecentManager.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "超过间隔时间，亮屏一次");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_a_of_type_Boolean = true;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQLSActivity", 2, "不亮屏");
    return false;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3000);
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent1.getEventTime() > 300L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isConsideredDoubleTap true");
      }
      return false;
    }
    return true;
  }
  
  private List b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    if ((paramString.equals(AppConstants.aA)) || (paramString.equals(AppConstants.az)))
    {
      localObject1 = new MessageRecord();
      ((MessageRecord)localObject1).frienduin = paramString;
      ((MessageRecord)localObject1).senderuin = paramString;
      ((MessageRecord)localObject1).istroop = paramInt;
      paramString = new ArrayList();
      paramString.add(localObject1);
      return paramString;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item msg list size: " + ((List)localObject1).size());
    }
    if (MsgProxyUtils.c(paramInt)) {
      localObject1 = MsgProxy.a((List)localObject1, ((Long)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString).first).longValue());
    }
    Object localObject3;
    while ((paramInt == 1001) || (paramInt == 1010))
    {
      return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 1, ((List)localObject1).size()));
      if ((paramInt == 3000) || (paramInt == 1))
      {
        localObject1 = MsgProxyUtils.a((List)localObject1, false);
      }
      else if (paramInt == 7000)
      {
        localObject2 = new MessageRecord();
        localObject3 = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        localObject1 = localArrayList;
        if (localObject3 != null)
        {
          localObject1 = localArrayList;
          if (((SubAccountManager)localObject3).a(paramString) != null)
          {
            ((MessageRecord)localObject2).msg = ((SubAccountManager)localObject3).a(paramString).toString();
            ((MessageRecord)localObject2).istroop = paramInt;
            ((MessageRecord)localObject2).frienduin = paramString;
            localArrayList.add(localObject2);
            localObject1 = localArrayList;
          }
        }
      }
      else if (paramInt == 4000)
      {
        localObject2 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
        localObject3 = new MessageRecord();
        localObject1 = localArrayList;
        if (localObject2 != null)
        {
          localObject1 = localArrayList;
          if (((NewFriendManager)localObject2).a() != null)
          {
            ((MessageRecord)localObject3).msg = ((NewFriendManager)localObject2).a().jdField_a_of_type_JavaLangString;
            ((MessageRecord)localObject3).istroop = paramInt;
            ((MessageRecord)localObject3).frienduin = paramString;
            localArrayList.add(localObject3);
            localObject1 = localArrayList;
          }
        }
      }
      else if (paramInt == 9002)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aw, 9002);
        localObject2 = new MessageRecord();
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
        localArrayList.add(localObject2);
        localObject1 = localArrayList;
      }
      else
      {
        localObject1 = localArrayList;
        if (paramInt == 8)
        {
          localObject1 = MessageRecordFactory.a(-2026);
          ((MessageRecord)localObject1).istroop = paramInt;
          ((MessageRecord)localObject1).frienduin = paramString;
          ((MessageRecord)localObject1).msg = "";
          ((MessageRecord)localObject1).isread = true;
          localArrayList.add(localObject1);
          localObject1 = localArrayList;
        }
      }
    }
    if (paramString.equals(AppConstants.ay))
    {
      paramString = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
      if (paramString != null) {
        ((List)localObject1).add(paramString.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData));
      }
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item continued msg list size: " + ((List)localObject1).size());
    }
    MsgProxyUtils.a((List)localObject1);
    MsgProxyUtils.a(paramString, paramInt, (List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localArrayList = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "single item continued msg list size= 0" + Thread.currentThread().getId());
      }
      finish();
      return new ArrayList();
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if ((((MessageRecord)localObject3).isread) || (((MessageRecord)localObject3).isSend())) {
        localArrayList.add(localObject3);
      }
    }
    ((List)localObject1).removeAll(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + "uinType" + paramInt);
    }
    paramString = a(paramString, paramInt);
    if (paramString.size() > 0) {
      a((List)localObject1, paramString, paramInt);
    }
    if (((List)localObject1).size() > 15) {
      return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 15, ((List)localObject1).size()));
    }
    return localObject1;
  }
  
  @TargetApi(16)
  private boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {}
    }
    for (;;)
    {
      try
      {
        KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localKeyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + localKeyguardManager.isKeyguardSecure());
        }
        if ((localKeyguardManager == null) || (!localKeyguardManager.isKeyguardLocked())) {
          continue;
        }
        bool1 = localKeyguardManager.isKeyguardSecure();
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (SecurityException localSecurityException)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localSecurityException);
      }
      return bool1;
      bool1 = false;
    }
    return true;
  }
  
  private void c()
  {
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_a_of_type_Long == 0L)
    {
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Long = System.currentTimeMillis();
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int = 0;
    }
    long l1;
    do
    {
      return;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      l1 = QQLSRecentManager.jdField_b_of_type_Long;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (l1 >= QQLSRecentManager.jdField_a_of_type_Long);
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = QQLSRecentManager.jdField_a_of_type_Long;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "clearRemindTime");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Long = 0L;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_a_of_type_Int = 0;
  }
  
  @TargetApi(9)
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300135));
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968710);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300137));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300146));
    ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).setMargins(0, (int)(getResources().getDisplayMetrics().density * -120.0F - 0.5D), 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299514));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300144));
    this.jdField_b_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_b_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131300148));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)findViewById(2131300149));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131300150));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298336));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300153));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300152));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new esb(this));
    this.jdField_a_of_type_Esk = new esk(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Esk);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(new esc(this));
    this.jdField_a_of_type_Esl = new esl(this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Esl);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "initUI updateUI");
    }
    f();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateUI thread" + Thread.currentThread().getId());
    }
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a());
    if (localArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentBaseData size = 0,  finish" + Thread.currentThread().getId());
      }
      finish();
    }
    if (localArrayList.size() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = ((RecentBaseData)localArrayList.get(0));
      g();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, "" + localArrayList.size(), "", "", "");
      return;
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_Esk.a(localArrayList);
    }
  }
  
  private void g()
  {
    Object localObject1;
    Object localObject2;
    DragTextView localDragTextView;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null))
    {
      localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300138);
      localObject2 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300141);
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300142);
      localDragTextView = (DragTextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300145);
      localDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localDragTextView.setDragViewType(0);
      localDragTextView.setTag(Integer.valueOf(1000));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      ((RelativeLayout)localObject1).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      ((RelativeLayout)localObject1).requestLayout();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
      ((TextView)localObject2).setText(((RecentBaseData)localObject1).jdField_a_of_type_JavaLangString);
      localTextView.setText(((RecentBaseData)localObject1).jdField_b_of_type_JavaLangString);
      if ((((RecentBaseData)localObject1).a() != 7000) && (((RecentBaseData)localObject1).a() != 4000) && (((RecentBaseData)localObject1).a() != 1001) && (((RecentBaseData)localObject1).a() != 1010) && (((RecentBaseData)localObject1).a() != 1012) && (((RecentBaseData)localObject1).a() != 9002)) {
        break label360;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300146).setVisibility(8);
      localObject2 = (RelativeLayout.LayoutParams)localDragTextView.getLayoutParams();
      if (((RecentBaseData)localObject1).a() != 1012) {
        break label377;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300138).setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
      label257:
      if (!a(((RecentBaseData)localObject1).a())) {
        break label399;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841712);
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(true);
    }
    for (;;)
    {
      localObject2 = b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break label420;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "LSActivity mSingleAdapter size =0 finish" + Thread.currentThread().getId());
      }
      finish();
      return;
      label360:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300146).setVisibility(0);
      break;
      label377:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300138).setVisibility(0);
      break label257;
      label399:
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841713);
      this.jdField_a_of_type_AndroidWidgetImageButton.setClickable(false);
    }
    label420:
    this.jdField_a_of_type_Esl.a((List)localObject2);
    this.jdField_b_of_type_ComTencentWidgetXListView.setSelection(this.jdField_a_of_type_Esl.getCount() - 1);
    if (GesturePWDUtils.getGesturePWDState(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()) == 2) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300146).setVisibility(8);
    }
    if (((RecentBaseData)localObject1).a() == 4000)
    {
      localObject1 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      CustomWidgetUtil.a(localDragTextView, 3, ((List)localObject2).size(), 0);
      return;
    }
    CustomWidgetUtil.a(localDragTextView, 3, ((List)localObject2).size(), 0);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "go to wakeUpScreen==========================");
    }
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "wakeUpScreen proximitySensor=null");
        }
        j();
      }
    }
    else {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen hasSensor=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.jdField_a_of_type_Boolean);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800477A", "0X800477A", 0, 0, "", "", "", "");
      j();
      return;
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "some phone need to bright early");
      }
      j();
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose  firstTimeToWakeScreen acquireWakeLock");
      }
      i();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      i();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose acquireWakeLock");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "wakeUpScreen acquireBrightWakeLock");
    }
    j();
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new wakeLock");
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new brightWakeLock");
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_a_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_b_of_type_Long = l1;
      localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
      QQLSRecentManager.jdField_a_of_type_Int += 1;
    }
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)getSystemService("power")).newWakeLock(268435462, "QQLSActivity");
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire(10000L);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "release wakeLock");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "release Exception e=" + localException.getMessage());
        }
      }
    }
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    if (QQLSRecentManager.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      if ((AIOUtils.a()) && (Build.VERSION.SDK_INT == 15))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_d_of_type_Boolean = true;
        return;
      }
      localObject = Build.MANUFACTURER + "-" + Build.MODEL;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setPhoneNeedBright devicesInfo=== " + (String)localObject);
      }
      if ((((String)localObject).equalsIgnoreCase("oppo-x907")) || (((String)localObject).equalsIgnoreCase("samsung-sch-i779")) || (((String)localObject).equalsIgnoreCase("xiaomi-hm 1sc")) || (((String)localObject).endsWith("lenovo-lenovo a390t")) || (((String)localObject).endsWith("xiaomi-2013022")) || (((String)localObject).endsWith("bbk-vivo x3t")) || (((String)localObject).endsWith("bbk-vivo y3t")) || (((String)localObject).endsWith("oppo-r813t")) || (((String)localObject).endsWith("huawei-huawei t8833")) || (((String)localObject).equalsIgnoreCase("unknown-K-Touch W619")) || (((String)localObject).equalsIgnoreCase("COOLPAD-Coolpad 8079")) || (((String)localObject).endsWith("K-Touch-K-Touch T780")) || (((String)localObject).endsWith("HTC-HTC T328w")) || (((String)localObject).endsWith("HUAWEI-HUAWEI U9508")))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
        QQLSRecentManager.jdField_d_of_type_Boolean = true;
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    } while (QQLSRecentManager.a());
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_d_of_type_Boolean = false;
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(paramString, paramInt);
  }
  
  public CharSequence a(RecentBaseData paramRecentBaseData)
  {
    List localList = a(paramRecentBaseData.a(), paramRecentBaseData.a());
    if ((localList == null) || (localList.size() == 0)) {
      return paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
    }
    long l1 = paramRecentBaseData.a();
    long l2 = ((MessageRecord)localList.get(localList.size() - 1)).time;
    if (Long.valueOf(l1).longValue() <= Long.valueOf(l2).longValue()) {
      return paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence;
    }
    return ((MessageRecord)localList.get(localList.size() - 1)).msg;
  }
  
  public List a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return localArrayList;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
        localArrayList.add(localMessageRecord);
      }
    }
    Collections.sort(localArrayList, this.jdField_b_of_type_JavaUtilComparator);
    return localArrayList;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 228	com/tencent/mobileqq/activity/QQLSActivity:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 1103	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 228	com/tencent/mobileqq/activity/QQLSActivity:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   24: aload_0
    //   25: invokevirtual 1107	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   28: goto -14 -> 14
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	QQLSActivity
    //   9	2	1	bool	boolean
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	31	finally
    //   17	28	31	finally
  }
  
  public void a(String paramString) {}
  
  public void a(List paramList1, List paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + paramList2.size());
    }
    paramList1.addAll(paramList2);
    Collections.sort(paramList1, this.jdField_b_of_type_JavaUtilComparator);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "sensor has callback sensorIsClose=" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    do
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "callback firstTimeToWakeScreen=" + this.jdField_d_of_type_Boolean);
      }
    } while (!this.jdField_d_of_type_Boolean);
    if (a()) {
      j();
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      break;
      i();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQLSActivity", 2, "onChange isDone " + paramBoolean);
      QLog.d("QQLSActivity", 2, "onChange mDragHost.getMode() " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a());
    }
    Object localObject;
    label438:
    int i1;
    if (paramBoolean)
    {
      paramDragFrameLayout = paramDragFrameLayout.a();
      if ((paramDragFrameLayout == null) || (paramDragFrameLayout.getTag() == null)) {
        break label1199;
      }
      paramInt = ((Integer)paramDragFrameLayout.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "delete onChange position=" + paramInt);
      }
      if (paramInt == 1000)
      {
        paramInt = ((MessageRecord)this.jdField_a_of_type_Esl.a.get(0)).istroop;
        paramDragFrameLayout = ((MessageRecord)this.jdField_a_of_type_Esl.a.get(0)).frienduin;
        if ((paramInt == 1001) || (paramInt == 1010))
        {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).b(paramDragFrameLayout, paramInt);
          RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, paramInt);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout, paramInt);
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(paramDragFrameLayout, paramInt);
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.j();
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "single data remove finish");
          }
          finish();
          if (paramInt != 3000) {
            break label438;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
        }
        do
        {
          return;
          if (paramInt == 4000)
          {
            ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).f();
            break;
          }
          if (paramInt == 7000)
          {
            ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a().a(paramDragFrameLayout, null);
            localObject = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            if (localObject == null) {
              break;
            }
            ((SubAccountManager)localObject).b(paramDragFrameLayout);
            break;
          }
          if (paramInt != 1012) {
            break;
          }
          localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (localObject == null) {
            break;
          }
          ((DatingManager)localObject).a().b();
          break;
          if (paramInt == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
            return;
          }
          if (paramInt == 0)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
            return;
          }
        } while ((paramInt != 1001) && (paramInt != 1010));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        return;
      }
      i1 = ((RecentBaseData)esk.a(this.jdField_a_of_type_Esk).get(paramInt)).a();
      paramDragFrameLayout = ((RecentBaseData)esk.a(this.jdField_a_of_type_Esk).get(paramInt)).a();
      RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, i1);
      if ((i1 == 1001) || (i1 == 1010))
      {
        ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).b(paramDragFrameLayout, i1);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)((Iterator)localObject).next();
        if (localMessage.istroop == i1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localMessage);
          continue;
          if (i1 != 4000) {
            break label918;
          }
          ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).f();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(AppConstants.aj, 0);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(AppConstants.ab, 4000);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramDragFrameLayout, i1);
      esk.a(this.jdField_a_of_type_Esk).remove(paramInt);
      this.jdField_a_of_type_Esk.notifyDataSetChanged();
      if (i1 != 3000) {
        break label1055;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
      label842:
      this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a(paramDragFrameLayout, i1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onChange updateUI" + Thread.currentThread().getId());
        }
        this.jdField_f_of_type_Boolean = true;
        runOnUiThread(new esj(this));
        return;
        label918:
        if (i1 == 7000)
        {
          ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a().a(paramDragFrameLayout, null);
          localObject = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          if (localObject == null) {
            break;
          }
          ((SubAccountManager)localObject).b(paramDragFrameLayout);
          break;
        }
        if (i1 == 1012)
        {
          localObject = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (localObject == null) {
            break;
          }
          ((DatingManager)localObject).a().b();
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout, i1);
        this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a(paramDragFrameLayout, i1);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
        break;
        label1055:
        if (i1 == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
          break label842;
        }
        if (i1 == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
          break label842;
        }
        if ((i1 != 1001) && (i1 != 1010)) {
          break label842;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        break label842;
        label1199:
        if (QLog.isColorLevel())
        {
          QLog.d("QQLSActivity", 2, "dragView = null");
          return;
        }
      }
    }
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void b()
  {
    new SessionInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.j();
      localSessionInfo = a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, " send start currenttime:" + System.currentTimeMillis());
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if ((localObject != null) && (((String)localObject).length() > 3478))
    {
      ChatActivityUtils.a(this, 2131366078, 1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 1)
    {
      localObject = new ArrayList();
      String str = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localSessionInfo, str, (ArrayList)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().clear();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      return;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localSessionInfo, (String)localObject, null);
    }
  }
  
  protected void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onBackPressed=== ");
    }
    d();
    super.doOnBackPressed();
    if (!isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "onBackPressed not finish ");
      }
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    StatisticCollector.a(this).a(this);
    jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "dooncreate taskId" + getTaskId() + Thread.currentThread().getId());
    }
    setContentView(2130903939);
    getWindow().addFlags(524288);
    l();
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().scaledDensity;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor = new QQLSSensor(getApplicationContext(), this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.a();
    paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "app null,  finish");
      }
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "rcf null,  finish");
      }
      finish();
      return true;
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.a();
    this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager = ((QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    c();
    this.jdField_d_of_type_Boolean = true;
    h();
    PublicAccountUtil.a(this.jdField_a_of_type_AndroidOsHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    jdField_a_of_type_Int -= 1;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnDestroy taskId" + getTaskId());
    }
    PublicAccountUtil.a(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor = null;
    }
    super.doOnDestroy();
    StatisticCollector.a(this).d(this);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnNewIntent taskId" + getTaskId());
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))) {
      return;
    }
    f();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    StatisticCollector.a(this).c(this);
    this.mRuntime.isBackground_Pause = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onPause,isbackground_pause : true");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnPause taskId" + getTaskId());
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1500L);
    if ((Build.MANUFACTURER + "-" + Build.MODEL).equalsIgnoreCase("Xiaomi-2013022"))
    {
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 600L);
    }
    do
    {
      do
      {
        return;
        localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
      } while ((localObject == null) || (((List)localObject).size() <= 0));
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "qqlsActivity onpause by :" + (String)localObject);
      }
    } while (!((String)localObject).equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity"));
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
    }
    localObject = new Intent(this, QQLSActivity.class);
    ((Intent)localObject).addFlags(131072);
    startActivity((Intent)localObject);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    StatisticCollector.a(this).b(this);
    QQLSRecentManager localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_b_of_type_Boolean = true;
    localQQLSRecentManager = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = true;
    this.mRuntime.isBackground_Pause = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnResume taskId" + getTaskId());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (!QQUtils.a(this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSActivity resume but isScreenLocked false");
      }
      finish();
    }
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager != null) {
      localGuardManager.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnStart taskId" + getTaskId());
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_e_of_type_Boolean = false;
    localObject = GuardManager.a;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(8)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQLSSensor = null;
    }
    if (localObject != null) {
      ((GuardManager)localObject).c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnStop taskId" + getTaskId());
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "on finish taskId" + getTaskId());
    }
    Object localObject = new Exception("this is a log");
    ((Exception)localObject).printStackTrace();
    localObject = ((Exception)localObject).getStackTrace();
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 0;
      while (i1 < localObject.length)
      {
        localStringBuilder.append(localObject[i1].getClassName() + ":");
        localStringBuilder.append(localObject[i1].getFileName() + ":");
        localStringBuilder.append(localObject[i1].getLineNumber() + ":");
        localStringBuilder.append(localObject[i1].getMethodName() + ":\n\n");
        i1 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqManagersQQLSRecentManager;
    QQLSRecentManager.jdField_f_of_type_Boolean = false;
    super.finish();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      Object localObject = getWindow().getAttributes().token;
      String str = getClass().getName();
      localObject = localObject.toString() + "----->" + str;
      StatisticCollector.a(this).a("WindowToken2Activity", (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQLSActivity", 2, "LS onAttachedToWindow e=" + localException);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300148: 
    case 2131300150: 
      do
      {
        do
        {
          do
          {
            return;
            d();
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() != 3000) && (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a()))));
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 3000)
          {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, 3000, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), true, true, null);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DB", "0X80040DB", 0, 0, "1", "", "", "");
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
            paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1500L);
            return;
          }
          Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 1006) {
            paramView = ((PhoneContactManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a());
          }
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a();; localObject = ((PhoneContactManager)localObject).c(paramView))
          {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), paramView, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.jdField_a_of_type_JavaLangString, (String)localObject, true, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a(), true, true, null, null);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DB", "0X80040DB", 0, 0, "0", "", "", "");
            break;
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a();
          }
          d();
        } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() == 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "onClick mSingleRecentBaseData=null return");
      return;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWindowToken(), 0);
      }
      Toast.makeText(getApplicationContext(), getString(2131369537), 0).show();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 3000) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "1", "", "", "");
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        moveTaskToBack(true);
        paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1000L);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.a() == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "2", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "0", "", "", "");
        }
      }
    }
    d();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040DE", "0X80040DE", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    moveTaskToBack(true);
    paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 1500L);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "logout finish");
    }
    finish();
    super.onLogout(paramLogoutReason);
  }
  
  @Deprecated
  protected void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onStart taskId" + getTaskId());
    }
    if (getTaskId() == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getTadk = -1 finish LS ,or onresume will get badToken!");
      }
      finish();
    }
    try
    {
      Field localField = Activity.class.getDeclaredField("mFinished");
      localField.setAccessible(true);
      localField.get(this);
      localField.set(this, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onUserLeaveHint()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onUserLeaveHint");
    }
    d();
    super.onUserLeaveHint();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "update" + Thread.currentThread().getId());
    }
    runOnUiThread(new esg(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity
 * JD-Core Version:    0.7.0.1
 */