package com.tencent.biz.pubaccount.troopbarassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import ckx;
import cky;
import ckz;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TroopBarAssistantManager
{
  public static final String a = "init_troopbar_assist";
  protected static final boolean a = true;
  public static final String b = "troopbar_assist_deleted";
  public static final String c = "troopbar_assist_show_in_msg";
  public static final String d = "troopbar_assist_last_read_time";
  public static final String e = "troopbar_assist_new_unread_list";
  private static final String f = "is_update_troopbar_assist";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private final Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  private boolean d = false;
  private String g;
  
  public static TroopBarAssistantManager a()
  {
    try
    {
      if (ckz.a == null) {
        ckz.a = new TroopBarAssistantManager();
      }
      TroopBarAssistantManager localTroopBarAssistantManager = ckz.a;
      return localTroopBarAssistantManager;
    }
    finally {}
  }
  
  private TroopBarData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private TroopBarData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localTroopBarData;
      if (localTroopBarData == null)
      {
        localTroopBarData = new TroopBarData();
        localTroopBarData.mUin = paramString;
        paramQQAppInterface = paramQQAppInterface.a();
        paramEntityManager = localTroopBarData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, 1008);
          paramEntityManager = localTroopBarData;
          if (paramQQAppInterface != null)
          {
            localTroopBarData.mLastDraftTime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopBarData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager arg2, TroopBarData paramTroopBarData)
  {
    if (paramTroopBarData == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramTroopBarData.mUin, paramTroopBarData);
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramTroopBarData);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i >= j) {
          break label226;
        }
        TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i);
        if (Math.max(paramTroopBarData.mLastMsgTime, paramTroopBarData.mLastDraftTime) > Math.max(localTroopBarData.mLastMsgTime, localTroopBarData.mLastDraftTime))
        {
          this.jdField_a_of_type_JavaUtilList.add(i, paramTroopBarData);
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramTroopBarData);
          }
          ??? = (ProxyManager)paramQQAppInterface.getManager(17);
          if (paramTroopBarData.getStatus() == 1000)
          {
            ???.a(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 3, null);
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
        }
        else
        {
          i += 1;
        }
      }
      ???.a(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 4, null);
      return;
      label226:
      int i = 0;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramMessageRecord != null) {}
    try
    {
      if ((!paramMessageRecord.isread) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h(paramQQAppInterface);
      return;
    }
    finally {}
  }
  
  private void a(EntityManager arg1)
  {
    try
    {
      localObject1 = ???.a(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort((List)localObject1, new cky(this));
      }
    }
    catch (Exception ???)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        Object localObject1;
        this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
        }
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          this.jdField_a_of_type_JavaUtilMap.clear();
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label166;
          }
          TroopBarData localTroopBarData = (TroopBarData)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilMap.put(localTroopBarData.mUin, localTroopBarData);
        }
        ??? = ???;
        if (QLog.isColorLevel()) {
          QLog.e("TroopBarAssistManager", 2, "initTroopBarAssistRecent");
        }
        return;
      }
    }
    finally {}
    label166:
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int j = 0;
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    int i = j;
    if (this.jdField_b_of_type_Boolean)
    {
      i = j;
      if (!this.c) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject = localRecentUserProxy.a(AppConstants.av, 7210);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      TroopBarData localTroopBarData = a(paramQQAppInterface);
      if (localTroopBarData != null)
      {
        ((RecentUser)localObject).lastmsgtime = localTroopBarData.mLastMsgTime;
        ((RecentUser)localObject).lastmsgdrafttime = localTroopBarData.mLastDraftTime;
      }
      localRecentUserProxy.a((RecentUser)localObject);
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      return true;
      localObject = localRecentUserProxy.b(AppConstants.av, 7210);
      if (localObject != null) {
        localRecentUserProxy.b((RecentUser)localObject);
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(paramString);
      }
      if (paramString != null)
      {
        return paramEntityManager.b(paramString);
        paramEntityManager = finally;
        throw paramEntityManager;
      }
    }
    return false;
  }
  
  private void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {
      return;
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_troopbar_assist", paramBoolean).commit();
  }
  
  private boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("is_update_troopbar_assist", true);
  }
  
  private void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1008) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      h(paramQQAppInterface);
      return;
    }
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, 1008) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      h(paramQQAppInterface);
      return;
    }
  }
  
  private void h(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.b(new ckx(this, paramQQAppInterface));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(QQMessageFacade paramQQMessageFacade)
  {
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      int i = this.jdField_a_of_type_JavaUtilSet.size();
      this.jdField_a_of_type_Int = i;
      return i;
    }
    this.jdField_a_of_type_Int = 0;
    return 0;
  }
  
  public TroopBarData a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = null;
    a(paramQQAppInterface);
    Object localObject2 = this.jdField_b_of_type_JavaLangObject;
    paramQQAppInterface = localObject1;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        paramQQAppInterface = localObject1;
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          paramQQAppInterface = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(0);
        }
      }
      return paramQQAppInterface;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap != null)
    {
      paramString = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public List a(QQAppInterface arg1)
  {
    a(???);
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          i = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(i);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          return localArrayList;
        }
      }
      int i = 0;
    }
  }
  
  public void a()
  {
    ckz.a = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int i;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        i = 1;
        if (i != 0)
        {
          ??? = paramQQAppInterface.a().createEntityManager();
          a((EntityManager)???);
          ((EntityManager)???).a();
          paramQQAppInterface = ((PublicAccountDataManager)paramQQAppInterface.getManager(54)).a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              ??? = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilMap.put(((PublicAccountInfo)???).getUin(), ???);
            }
          }
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.g)) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", paramLong).commit();
    this.jdField_a_of_type_Long = paramLong;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      h(paramQQAppInterface);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    this.d = true;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramList.next();
        this.jdField_b_of_type_JavaUtilMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
      }
    }
    f(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", paramBoolean).commit();
    this.c = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, localEntityManager, paramQQAppInterface);
    localEntityManager.a();
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong)) {}
    for (localTroopBarData.mLastMsgTime = paramMessageRecord.time;; localTroopBarData.mLastMsgTime = paramLong)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
      if (localMessage != null)
      {
        long l = localMessage.time;
        if (l > localTroopBarData.mLastMsgTime) {
          localTroopBarData.mLastMsgTime = l;
        }
      }
      a(paramQQAppInterface, paramEntityManager, localTroopBarData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.c) {
        a(paramQQAppInterface, false);
      }
      a(paramQQAppInterface, paramString);
      a(paramQQAppInterface, paramLong);
      return;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      Object localObject2 = localRecentUserProxy.b();
      long l = System.currentTimeMillis() / 1000L;
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if (((((RecentUser)localObject3).type == 1008) || (((RecentUser)localObject3).type == 1024)) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        l = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopBarData)localObject3).mLastDraftTime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.a().a(((TroopBarData)localObject3).mUin, 1008);
            if (localMessage == null) {}
          }
          for (((TroopBarData)localObject3).mLastMsgTime = localMessage.time;; ((TroopBarData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramQQAppInterface, paramEntityManager, (TroopBarData)localObject3);
            localRecentUserProxy.b((RecentUser)localObject2);
            e(((TroopBarData)localObject3).mUin, paramQQAppInterface);
            break;
          }
        }
      }
      ((PublicAccountHandler)paramQQAppInterface.a(10)).d();
      paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troopbar_assist", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData;
    if (paramLong == 0L)
    {
      localTroopBarData = a(paramQQAppInterface, paramString);
      if (localTroopBarData != null)
      {
        localTroopBarData.mLastDraftTime = paramLong;
        if ((paramLong != 0L) || (localTroopBarData.mLastMsgTime != 0L)) {
          break label102;
        }
        a(paramQQAppInterface, paramString);
      }
    }
    for (;;)
    {
      if (this.c) {
        a(paramQQAppInterface, false);
      }
      a(paramQQAppInterface, paramString);
      if (localTroopBarData != null) {
        a(paramQQAppInterface, localTroopBarData.mLastMsgTime);
      }
      return;
      localTroopBarData = a(paramEntityManager, paramQQAppInterface, paramString);
      break;
      label102:
      a(paramQQAppInterface, paramEntityManager, localTroopBarData);
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localObject1 != null) {
      ((PublicAccountInfo)localObject1).mShowMsgFlag = 0;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    Object localObject2 = localRecentUserProxy.b(paramString, 1008);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localRecentUserProxy.b(paramString, 0);
    }
    if (localObject1 != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (((RecentUser)localObject1).lastmsgtime != 0L) {
        break label213;
      }
      localObject2 = paramQQAppInterface.a().a(paramString.mUin, 1008);
      if (localObject2 == null) {}
    }
    label213:
    for (paramString.mLastMsgTime = ((QQMessageFacade.Message)localObject2).time;; paramString.mLastMsgTime = ((RecentUser)localObject1).lastmsgtime)
    {
      paramString.mLastDraftTime = ((RecentUser)localObject1).lastmsgdrafttime;
      a(paramQQAppInterface, localEntityManager, paramString);
      e(paramString.mUin, paramQQAppInterface);
      RecentDataListManager.a().a(((RecentUser)localObject1).uin + "-" + ((RecentUser)localObject1).type);
      localRecentUserProxy.b((RecentUser)localObject1);
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, paramString.mLastMsgTime);
      }
      localEntityManager.a();
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!this.d) {
      try
      {
        paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
        if (paramQQAppInterface != null)
        {
          this.d = true;
          paramQQAppInterface = paramQQAppInterface.a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
              continue;
              return false;
            }
          }
        }
      }
      catch (Exception paramQQAppInterface) {}
    }
    do
    {
      paramQQAppInterface = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    } while (paramQQAppInterface == null);
    if ((paramQQAppInterface.accountFlag & 0x200000) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.g = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("troopbar_assist_show_in_msg", true);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("troopbar_assist_last_read_time", 0L);
      this.c = ((SharedPreferences)localObject2).getBoolean("troopbar_assist_deleted", false);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        localObject3 = a(paramQQAppInterface);
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet = SharedPreferencesHandler.a((SharedPreferences)localObject2, "troopbar_assist_new_unread_list", null);
      if (this.jdField_a_of_type_JavaUtilSet == null)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        if (c(paramQQAppInterface))
        {
          b(paramQQAppInterface, false);
          localObject2 = paramQQAppInterface.a();
          if (localObject2 == null)
          {
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            TroopBarData localTroopBarData = (TroopBarData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localTroopBarData.mUin, 1008);
            if ((paramQQAppInterface.a().a(localTroopBarData.mUin, 1008) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
              e(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      d(paramString, paramQQAppInterface);
    }
    localEntityManager.a();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return this.c;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBarAssistManager", 2, "app == null; what happen.");
      }
    }
    TroopBarData localTroopBarData;
    do
    {
      return;
      if (!paramQQAppInterface.getAccount().equals(this.g)) {
        b(paramQQAppInterface);
      }
      localTroopBarData = a(paramQQAppInterface);
    } while (localTroopBarData == null);
    a(paramQQAppInterface, localTroopBarData.mLastMsgTime);
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localObject1 != null) {
      ((PublicAccountInfo)localObject1).mShowMsgFlag = 1;
    }
    localObject1 = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localObject1 = localEntityManager;
      TroopBarData localTroopBarData = a(paramQQAppInterface, paramString);
      localObject1 = localEntityManager;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      if (localTroopBarData != null)
      {
        localObject1 = localEntityManager;
        Object localObject2 = localRecentUserProxy.b(localTroopBarData.mUin, 1008);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localEntityManager;
          localObject2 = localRecentUserProxy.b(localTroopBarData.mUin, 0);
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localEntityManager;
          localObject2 = localRecentUserProxy.a(localTroopBarData.mUin, 1008);
        }
        localObject1 = localEntityManager;
        ((RecentUser)localObject2).lastmsgtime = localTroopBarData.mLastMsgTime;
        localObject1 = localEntityManager;
        ((RecentUser)localObject2).lastmsgdrafttime = localTroopBarData.mLastDraftTime;
        localObject1 = localEntityManager;
        if (a(localEntityManager, paramString))
        {
          localObject1 = localEntityManager;
          localRecentUserProxy.a((RecentUser)localObject2);
          localObject1 = localEntityManager;
          d(paramString, paramQQAppInterface);
        }
      }
      localObject1 = localEntityManager;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject1 = localEntityManager;
        a(paramQQAppInterface, paramString.mLastMsgTime);
      }
      if (localEntityManager != null) {
        localEntityManager.a();
      }
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((EntityManager)localObject1).a();
      }
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    h(paramQQAppInterface);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    int m = 0;
    int k = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int j = m;
    try
    {
      if (this.jdField_a_of_type_JavaUtilSet != null)
      {
        j = m;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        j = i;
        k = i;
        if (localIterator.hasNext())
        {
          j = i;
          String str = (String)localIterator.next();
          j = i;
          if (paramQQAppInterface.a().a(str, 1008) > 0) {
            break label131;
          }
          j = i;
          localIterator.remove();
          i = 1;
        }
      }
      for (;;)
      {
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      k = j;
      if (k != 0) {
        h(paramQQAppInterface);
      }
      return;
    }
    finally {}
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ??? = localRecentUserProxy.b();
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).type == 1008) && (a(paramQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList())) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    a(paramQQAppInterface);
    Object localObject5;
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (TroopBarData)((Iterator)localObject4).next();
          if (!a(paramQQAppInterface, ((TroopBarData)localObject5).mUin)) {
            ((ArrayList)localObject1).add(localObject5);
          }
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = paramQQAppInterface.a().a(((TroopBarData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((TroopBarData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((TroopBarData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a(paramQQAppInterface, localEntityManager, (TroopBarData)localObject4);
          localRecentUserProxy.b((RecentUser)???);
          e(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (TroopBarData)((Iterator)localObject2).next();
        localObject4 = localRecentUserProxy.a(((TroopBarData)???).mUin, 1008);
        ((RecentUser)localObject4).uin = ((TroopBarData)???).mUin;
        ((RecentUser)localObject4).type = 1008;
        ((RecentUser)localObject4).lastmsgtime = ((TroopBarData)???).mLastMsgTime;
        ((RecentUser)localObject4).lastmsgdrafttime = ((TroopBarData)???).mLastDraftTime;
        if (a(localEntityManager, ((TroopBarData)???).mUin))
        {
          if (this.jdField_b_of_type_JavaUtilMap == null) {}
          for (localObject1 = null;; localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(((TroopBarData)???).mUin))
          {
            if (localObject1 != null) {
              localRecentUserProxy.a((RecentUser)localObject4);
            }
            d(((TroopBarData)???).mUin, paramQQAppInterface);
            break;
          }
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, ((TroopBarData)localObject1).mLastMsgTime);
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    try
    {
      b(paramQQAppInterface);
      if (a(paramQQAppInterface) == true)
      {
        EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
        a(localEntityManager, paramQQAppInterface);
        localEntityManager.a();
      }
      c(paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager
 * JD-Core Version:    0.7.0.1
 */