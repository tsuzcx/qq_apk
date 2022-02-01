package com.tencent.mobileqq.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.flaotaio.FloatSetting;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import jez;
import mqq.manager.Manager;

public class QQLSRecentManager
  implements Observer, Manager
{
  public static int a = 0;
  public static long a = 0L;
  public static final String a = "QQLSActivity";
  private static CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public static boolean a;
  private static byte[] jdField_a_of_type_ArrayOfByte;
  public static long b;
  public static String b;
  public static volatile boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_b_of_type_Boolean = false;
    c = false;
    d = false;
    e = false;
    f = false;
    jdField_b_of_type_JavaLangString = "";
  }
  
  public QQLSRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_JavaLangString = Build.MANUFACTURER + "-" + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "QQLSRecentManager deviceInfo=" + jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.addObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      d = true;
      return d;
    }
    d = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lock_screen.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "isPhoneNeedBright need bright before sensor = " + d);
    }
    return d;
  }
  
  private boolean a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    FloatSetting localFloatSetting = FloatSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (((paramInt == 0) || (paramInt == 1004) || (paramInt == 1000)) && (!localFloatSetting.b(str))) {}
    while (((paramInt == 3000) && (!localFloatSetting.c(str))) || ((paramInt == 1) && (!localFloatSetting.d(str)))) {
      return true;
    }
    return false;
  }
  
  public CopyOnWriteArrayList a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      return localCopyOnWriteArrayList;
    }
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "mDataList clear");
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (jdField_b_of_type_JavaLangString.equalsIgnoreCase("HUAWEI-HUAWEI T8833")) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "needStartQQLS isFromMisscall:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        paramQQAppInterface = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningTasks(1);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
          paramQQAppInterface = (ActivityManager.RunningTaskInfo)paramQQAppInterface.get(0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.getInstance().isLsonResume:" + jdField_b_of_type_Boolean);
        }
        if (paramInt != 1) {
          break label162;
        }
      }
      label162:
      for (c = true; !a(paramInt); c = false)
      {
        new Handler(Looper.getMainLooper()).post(new jez(this));
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      RecentBaseData localRecentBaseData;
      int j;
      int i;
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localRecentBaseData = (RecentBaseData)localIterator.next();
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
        int k = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(localRecentBaseData.a(), localRecentBaseData.a());
        if (localRecentBaseData.a().equals(AppConstants.af))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.af, localRecentBaseData.a());
          if ((i != 0) || (k != 0)) {
            continue;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
        }
      }
      if (localRecentBaseData.a().equals(AppConstants.ab))
      {
        i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();
      }
      else if (localRecentBaseData.a().equals(AppConstants.au))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.au, localRecentBaseData.a());
      }
      else
      {
        i = j;
        if (localRecentBaseData.a().equals(paramString))
        {
          i = j;
          if (paramInt == localRecentBaseData.a())
          {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
            i = j;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "after removeUnreadMsg mDataList= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (a(paramInt)) {
      return false;
    }
    Object localObject1;
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if ((!AppConstants.aA.equals(paramString)) && (!AppConstants.az.equals(paramString))) {
        break label152;
      }
      localObject1 = new RecentUser();
      ((RecentUser)localObject1).uin = paramString;
      ((RecentUser)localObject1).type = paramInt;
      paramQQAppInterface = ConversationDataFactory.a((RecentUser)localObject1, paramQQAppInterface, paramQQAppInterface.a());
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RecentBaseData)((Iterator)localObject1).next();
        if (((RecentBaseData)localObject2).a().equals(paramString)) {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject2);
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramQQAppInterface);
    return true;
    label152:
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateLSRencentUser size= " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() + "threadId =" + Thread.currentThread().getId());
    }
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    Object localObject2 = localRecentUserProxy.b().iterator();
    label269:
    label277:
    int i;
    label358:
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (RecentUser)((Iterator)localObject2).next();
      if (localObject1 != null)
      {
        RecentBaseData localRecentBaseData;
        if (TextUtils.isEmpty(((RecentUser)localObject1).uin))
        {
          localObject1 = null;
          break label1280;
          break label594;
          localObject2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localRecentBaseData = (RecentBaseData)((Iterator)localObject2).next();
          } while ((localRecentBaseData.a().equals(AppConstants.aA)) || (localRecentBaseData.a().equals(AppConstants.az)));
          if (!localRecentBaseData.a().equals(AppConstants.af)) {
            break label616;
          }
          i = paramQQAppInterface.a().a(AppConstants.af, localRecentBaseData.a());
        }
        for (;;)
        {
          if ((localRecentBaseData.a() == 3000) || (localRecentBaseData.a() == 0) || (localRecentBaseData.a() == 8))
          {
            j = 0;
            if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
              j = this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade.b(localRecentBaseData.a(), localRecentBaseData.a());
            }
            if (!QLog.isColorLevel()) {
              break label1295;
            }
            QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser miscallUnread = " + j);
            break label1295;
          }
          label452:
          if (i != 0) {
            break label1301;
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localRecentBaseData);
          break label277;
          if (((localObject1 != null) && (paramString.equals(((RecentUser)localObject1).uin)) && (((RecentUser)localObject1).type == paramInt)) || ((localObject1 != null) && (((RecentUser)localObject1).type == paramInt) && (AppConstants.af.equals(((RecentUser)localObject1).uin))) || ((localObject1 != null) && (((RecentUser)localObject1).type == paramInt) && (AppConstants.au.equals(((RecentUser)localObject1).uin)))) {
            break label1280;
          }
          if ((localObject1 == null) || (!AppConstants.ab.equals(((RecentUser)localObject1).uin)) || (!paramString.equals(((RecentUser)localObject1).uin))) {
            break;
          }
          break label1280;
          label594:
          if (((QCallFacade)paramQQAppInterface.getManager(37)).b(paramString, paramInt) != 0) {
            break label269;
          }
          return false;
          label616:
          if (localRecentBaseData.a().equals(AppConstants.ab))
          {
            i = ((NewFriendManager)paramQQAppInterface.getManager(33)).a();
          }
          else if (localRecentBaseData.a().equals(AppConstants.au))
          {
            i = paramQQAppInterface.a().a(AppConstants.au, localRecentBaseData.a());
          }
          else
          {
            if (localRecentBaseData.a().equals(AppConstants.ay))
            {
              DatingManager localDatingManager = (DatingManager)paramQQAppInterface.getManager(67);
              if (localDatingManager == null) {
                break label1271;
              }
              i = localDatingManager.a().a();
              break label1303;
            }
            i = paramQQAppInterface.a().a(localRecentBaseData.a(), localRecentBaseData.a());
          }
        }
        i = 0;
        localObject2 = null;
        if (localObject1 != null) {
          if (((RecentUser)localObject1).uin.equals(AppConstants.af))
          {
            paramInt = paramQQAppInterface.a().a(AppConstants.af, ((RecentUser)localObject1).type);
            paramString = ConversationDataFactory.a((RecentUser)localObject1, paramQQAppInterface, paramQQAppInterface.a());
          }
        }
      }
    }
    for (;;)
    {
      label798:
      if ((paramInt > 0) && (paramString != null))
      {
        paramQQAppInterface = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        label813:
        if (paramQQAppInterface.hasNext())
        {
          localObject1 = (RecentBaseData)paramQQAppInterface.next();
          if ((((RecentBaseData)localObject1).a().equals(paramString.a())) && (((RecentBaseData)localObject1).a() == paramString.a())) {
            jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
          }
        }
        else
        {
          label869:
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser mDataList.size = " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
        }
        if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0) {
          break label1262;
        }
        return true;
        if (((RecentUser)localObject1).uin.equals(AppConstants.ab))
        {
          paramInt = ((NewFriendManager)paramQQAppInterface.getManager(33)).a();
          break;
        }
        if (((RecentUser)localObject1).uin.equals(AppConstants.au))
        {
          paramInt = paramQQAppInterface.a().a(AppConstants.au, ((RecentUser)localObject1).type);
          break;
        }
        paramInt = paramQQAppInterface.a().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).type);
        break;
        if (paramInt == 1012)
        {
          paramQQAppInterface = (DatingManager)paramQQAppInterface.getManager(67);
          if (paramQQAppInterface == null) {
            break label1264;
          }
          paramInt = paramQQAppInterface.a().a();
          paramQQAppInterface = paramQQAppInterface.a().a();
          break label1306;
        }
        localObject1 = localRecentUserProxy.a(paramString, paramInt);
        paramString = (String)localObject2;
        paramInt = i;
        if (localObject1 == null) {
          break label798;
        }
        ((RecentUser)localObject1).lastmsgtime = MessageCache.a();
        paramString = ConversationDataFactory.a((RecentUser)localObject1, paramQQAppInterface, paramQQAppInterface.a());
        paramInt = i;
        break label798;
        if ((paramString.a().equals(AppConstants.af)) && (((RecentBaseData)localObject1).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
          break label869;
        }
        if ((paramString.a().equals(AppConstants.au)) && (((RecentBaseData)localObject1).a().equals(paramString.a())))
        {
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
          break label869;
        }
        if ((!paramString.a().equals(AppConstants.ab)) || (!((RecentBaseData)localObject1).a().equals(paramString.a()))) {
          break label813;
        }
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject1);
        break label869;
        if ((paramBoolean) && (paramString != null) && (!jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "QQLSRecentManager.updateLSRencentUser from misscall");
          }
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramString);
        }
      }
      label1262:
      return false;
      label1264:
      paramQQAppInterface = null;
      paramInt = 0;
      break label1306;
      label1271:
      i = 0;
      break label1303;
      localObject1 = null;
      label1280:
      if (localObject1 != null) {
        break label269;
      }
      if (paramInt != 1012) {
        break;
      }
      break label269;
      label1295:
      if (j > 0) {
        break label277;
      }
      break label452;
      label1301:
      break label277;
      label1303:
      break label358;
      label1306:
      paramString = paramQQAppInterface;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = null;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof NewFriendMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "QQLSRecentManager new friend update~~~~~ " + Thread.currentThread().getId());
      }
      if (!((NewFriendMessage)paramObject).jdField_a_of_type_Boolean) {
        break label59;
      }
    }
    label59:
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            return;
            if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun ");
          return;
          i = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();
        } while (TextUtils.isEmpty(((NewFriendMessage)paramObject).jdField_a_of_type_JavaLangString));
        if ((i != 0) && (!f)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "QQLSRecentManager update retrun because unread =0 || isNewFriendEnterAio" + f);
      return;
      bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367906), "qqsetting_lock_screen_whenexit_key", true);
      bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366821), "qqsetting_notify_showcontent_key", true);
    } while ((!Boolean.valueOf(bool1).booleanValue()) || (!Boolean.valueOf(bool2).booleanValue()));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.ab, 4000, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.QQLSRecentManager
 * JD-Core Version:    0.7.0.1
 */