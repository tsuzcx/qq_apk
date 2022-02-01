package com.tencent.biz.pubaccount.assistant;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import cke;
import ckf;
import ckg;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PubAccountAssistantData;
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

public class PubAccountAssistantManager
{
  protected static final int a = 0;
  public static final String a = "init_pubaccount_assistants";
  protected static final boolean a = true;
  protected static final int b = 1;
  public static final String b = "show_public_account_assistant_guide";
  protected static final int c = 2;
  public static final String c = "pubaccount_assistant_deleted";
  protected static final int d = 3;
  public static final String d = "pubaccount_assistant_conversation_tip_last_show_time";
  public static final int e = 5;
  public static final String e = "pubaccount_assistant_show_in_msg";
  public static final int f = 10;
  public static final String f = "pubaccount_assistant_last_read_time";
  public static final String g = "pubaccount_assistant_new_unread_list";
  private static final String h = "should_update_pubaccount_assistant";
  private static final String i = "pubaccount_assistant_has_config";
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
  private int g = 0;
  private String j;
  
  public static PubAccountAssistantManager a()
  {
    try
    {
      if (ckg.a == null) {
        ckg.a = new PubAccountAssistantManager();
      }
      PubAccountAssistantManager localPubAccountAssistantManager = ckg.a;
      return localPubAccountAssistantManager;
    }
    finally {}
  }
  
  private PubAccountAssistantData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (PubAccountAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private PubAccountAssistantData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localPubAccountAssistantData;
      if (localPubAccountAssistantData == null)
      {
        localPubAccountAssistantData = new PubAccountAssistantData();
        localPubAccountAssistantData.mUin = paramString;
        localPubAccountAssistantData.mType = a(paramString);
        paramQQAppInterface = paramQQAppInterface.a();
        paramEntityManager = localPubAccountAssistantData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, localPubAccountAssistantData.mType);
          paramEntityManager = localPubAccountAssistantData;
          if (paramQQAppInterface != null)
          {
            localPubAccountAssistantData.mLastDraftTime = paramQQAppInterface.getTime();
            paramEntityManager = localPubAccountAssistantData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager arg2, PubAccountAssistantData paramPubAccountAssistantData)
  {
    if (paramPubAccountAssistantData == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramPubAccountAssistantData.mUin, paramPubAccountAssistantData);
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramPubAccountAssistantData);
        int m = this.jdField_a_of_type_JavaUtilList.size();
        k = 0;
        if (k >= m) {
          break label226;
        }
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)this.jdField_a_of_type_JavaUtilList.get(k);
        if (Math.max(paramPubAccountAssistantData.mLastMsgTime, paramPubAccountAssistantData.mLastDraftTime) > Math.max(localPubAccountAssistantData.mLastMsgTime, localPubAccountAssistantData.mLastDraftTime))
        {
          this.jdField_a_of_type_JavaUtilList.add(k, paramPubAccountAssistantData);
          k = 1;
          if (k == 0) {
            this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramPubAccountAssistantData);
          }
          ??? = (ProxyManager)paramQQAppInterface.getManager(17);
          if (paramPubAccountAssistantData.getStatus() == 1000)
          {
            ???.a(paramQQAppInterface.getAccount(), 0, paramPubAccountAssistantData.getTableName(), paramPubAccountAssistantData, 3, null);
            return;
            paramQQAppInterface = finally;
            throw paramQQAppInterface;
          }
        }
        else
        {
          k += 1;
        }
      }
      ???.a(paramQQAppInterface.getAccount(), 0, paramPubAccountAssistantData.getTableName(), paramPubAccountAssistantData, 4, null);
      return;
      label226:
      int k = 0;
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
      i(paramQQAppInterface);
      return;
    }
    finally {}
  }
  
  private void a(EntityManager arg1)
  {
    try
    {
      localObject1 = ???.a(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort((List)localObject1, new ckf(this));
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
          PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilMap.put(localPubAccountAssistantData.mUin, localPubAccountAssistantData);
        }
        ??? = ???;
        if (QLog.isColorLevel()) {
          QLog.e("PubAccountAssistantManager", 2, "initPubAccountAssistantRecent");
        }
        return;
      }
    }
    finally {}
    label166:
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    int k = 0;
    Object localObject = (FriendManager)paramQQAppInterface.getManager(8);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      if ((this.jdField_b_of_type_Boolean) && (!this.c))
      {
        paramInt = 1;
        k = paramInt;
      }
      break;
    case 2: 
      label71:
      if (k != 0)
      {
        localObject = localRecentUserProxy.a(AppConstants.ao, 7200);
        ((RecentUser)localObject).uin = AppConstants.ao;
        ((RecentUser)localObject).type = 7200;
        if (((RecentUser)localObject).lastmsgtime < paramLong) {
          ((RecentUser)localObject).lastmsgtime = paramLong;
        }
        paramQQAppInterface = a(paramQQAppInterface);
        if (paramQQAppInterface != null)
        {
          ((RecentUser)localObject).lastmsgtime = paramQQAppInterface.mLastMsgTime;
          ((RecentUser)localObject).lastmsgdrafttime = paramQQAppInterface.mLastDraftTime;
        }
        localRecentUserProxy.a((RecentUser)localObject);
      }
      break;
    }
    for (;;)
    {
      return true;
      k = 1;
      break label71;
      paramInt = 0;
      break;
      paramQQAppInterface = localRecentUserProxy.b(AppConstants.ao, 7200);
      if (paramQQAppInterface != null) {
        localRecentUserProxy.b(paramQQAppInterface);
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (PubAccountAssistantData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, a(paramString));
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {
      return;
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("should_update_pubaccount_assistant", paramBoolean).commit();
  }
  
  private void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, a(paramString)) > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      i(paramQQAppInterface);
      return;
    }
  }
  
  private boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("should_update_pubaccount_assistant", true);
  }
  
  private void f(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramQQAppInterface.a().a(paramString, a(paramString)) > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      i(paramQQAppInterface);
      return;
    }
  }
  
  private void i(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.b(new cke(this, paramQQAppInterface));
  }
  
  public int a()
  {
    return this.g;
  }
  
  public int a(QQMessageFacade paramQQMessageFacade)
  {
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      int k = this.jdField_a_of_type_JavaUtilSet.size();
      this.g = k;
      return k;
    }
    this.g = 0;
    return 0;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap != null)
    {
      paramString = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (paramString != null)
      {
        if (paramString.extendType == 2) {
          return 1024;
        }
        return 1008;
      }
    }
    return 1008;
  }
  
  public PubAccountAssistantData a(QQAppInterface paramQQAppInterface)
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
          paramQQAppInterface = (PubAccountAssistantData)this.jdField_a_of_type_JavaUtilList.get(0);
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
          k = this.jdField_a_of_type_JavaUtilList.size();
          ArrayList localArrayList = new ArrayList(k);
          localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
          return localArrayList;
        }
      }
      int k = 0;
    }
  }
  
  public void a()
  {
    ckg.a = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int k;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        k = 1;
        if (k != 0)
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
        k = 0;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.j)) {
      b(paramQQAppInterface);
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("pubaccount_assistant_last_read_time", paramLong).commit();
    this.jdField_a_of_type_Long = paramLong;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      i(paramQQAppInterface);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramString, 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putLong("pubaccount_assistant_conversation_tip_last_show_time_" + paramString, System.currentTimeMillis()).commit();
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    this.d = true;
    if (paramQQAppInterface != null) {
      f(paramQQAppInterface);
    }
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
    g(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("pubaccount_assistant_deleted", paramBoolean).commit();
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
    PubAccountAssistantData localPubAccountAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
    localPubAccountAssistantData.mType = a(paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong)) {}
    for (localPubAccountAssistantData.mLastMsgTime = paramMessageRecord.time;; localPubAccountAssistantData.mLastMsgTime = paramLong)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType);
      if (localMessage != null)
      {
        long l = localMessage.time;
        if (l > localPubAccountAssistantData.mLastMsgTime) {
          localPubAccountAssistantData.mLastMsgTime = l;
        }
      }
      a(paramQQAppInterface, paramEntityManager, localPubAccountAssistantData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.c) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      a(paramQQAppInterface, 0, paramLong);
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
          ((PubAccountAssistantData)localObject3).mLastDraftTime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.a().a(((PubAccountAssistantData)localObject3).mUin, ((PubAccountAssistantData)localObject3).mType);
            if (localMessage == null) {}
          }
          for (((PubAccountAssistantData)localObject3).mLastMsgTime = localMessage.time;; ((PubAccountAssistantData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramQQAppInterface, paramEntityManager, (PubAccountAssistantData)localObject3);
            localRecentUserProxy.b((RecentUser)localObject2);
            f(((PubAccountAssistantData)localObject3).mUin, paramQQAppInterface);
            break;
          }
        }
      }
      paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_pubaccount_assistants", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    PubAccountAssistantData localPubAccountAssistantData;
    if (paramLong == 0L)
    {
      localPubAccountAssistantData = a(paramQQAppInterface, paramString);
      if (localPubAccountAssistantData != null)
      {
        localPubAccountAssistantData.mLastDraftTime = paramLong;
        if ((paramLong != 0L) || (localPubAccountAssistantData.mLastMsgTime != 0L)) {
          break label103;
        }
        b(paramQQAppInterface, paramString);
      }
    }
    for (;;)
    {
      if (this.c) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      if (localPubAccountAssistantData != null) {
        a(paramQQAppInterface, 0, localPubAccountAssistantData.mLastMsgTime);
      }
      return;
      localPubAccountAssistantData = a(paramEntityManager, paramQQAppInterface, paramString);
      break;
      label103:
      a(paramQQAppInterface, paramEntityManager, localPubAccountAssistantData);
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localObject1 != null)
    {
      if (((PublicAccountInfo)localObject1).messageSettingFlag != 0) {
        ((PublicAccountInfo)localObject1).messageSettingFlag = 2;
      }
      ((PublicAccountInfo)localObject1).mShowMsgFlag = 0;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    Object localObject2 = localRecentUserProxy.b(paramString, a(paramString));
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localRecentUserProxy.b(paramString, 0);
    }
    if (localObject1 != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (((RecentUser)localObject1).lastmsgtime != 0L) {
        break label229;
      }
      localObject2 = paramQQAppInterface.a().a(paramString.mUin, paramString.mType);
      if (localObject2 == null) {}
    }
    label229:
    for (paramString.mLastMsgTime = ((QQMessageFacade.Message)localObject2).time;; paramString.mLastMsgTime = ((RecentUser)localObject1).lastmsgtime)
    {
      paramString.mLastDraftTime = ((RecentUser)localObject1).lastmsgdrafttime;
      a(paramQQAppInterface, localEntityManager, paramString);
      f(paramString.mUin, paramQQAppInterface);
      RecentDataListManager.a().a(((RecentUser)localObject1).uin + "-" + ((RecentUser)localObject1).type);
      localRecentUserProxy.b((RecentUser)localObject1);
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, 0, paramString.mLastMsgTime);
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
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_pubaccount_assistants", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    if (!this.d) {
      try
      {
        Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
        if (localObject != null)
        {
          this.d = true;
          if (paramQQAppInterface != null) {
            f(paramQQAppInterface);
          }
          paramQQAppInterface = ((PublicAccountDataManager)localObject).a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              localObject = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilMap.put(((PublicAccountInfo)localObject).getUin(), localObject);
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
    if (paramQQAppInterface.messageSettingFlag != 0)
    {
      if ((paramQQAppInterface.messageSettingFlag == 2) && ((paramQQAppInterface.accountFlag & 0x800000) == 0)) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if (paramQQAppInterface.mShowMsgFlag == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (!paramQQAppInterface.getAccount().equals(this.j)) {
      b(paramQQAppInterface);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("pubaccount_assistant_show_in_msg", paramBoolean).commit();
    int k;
    if (paramBoolean)
    {
      k = 1;
      paramBoolean = a(paramQQAppInterface, k, 0L);
      if ((!this.jdField_b_of_type_Boolean) || (!paramBoolean)) {
        break label99;
      }
    }
    label99:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      k = 2;
      break;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    Object localObject2;
    Object localObject3;
    if (paramQQAppInterface != null)
    {
      this.j = paramQQAppInterface.getAccount();
      localObject2 = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
      this.jdField_b_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("pubaccount_assistant_show_in_msg", true);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("pubaccount_assistant_last_read_time", 0L);
      this.c = ((SharedPreferences)localObject2).getBoolean("pubaccount_assistant_deleted", false);
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList = null;
        localObject3 = a(paramQQAppInterface);
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilSet = SharedPreferencesHandler.a((SharedPreferences)localObject2, "pubaccount_assistant_new_unread_list", null);
      if (this.jdField_a_of_type_JavaUtilSet == null)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        if (e(paramQQAppInterface))
        {
          c(paramQQAppInterface, false);
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
            PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject3).next();
            QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject2).a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType);
            if ((paramQQAppInterface.a().a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType) > 0) && (localMessage.time > this.jdField_a_of_type_Long)) {
              f(localMessage.frienduin, paramQQAppInterface);
            }
          }
        }
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {
      return;
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("show_public_account_assistant_guide", paramBoolean).commit();
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (((PublicAccountInfo)localObject).messageSettingFlag != 0)) {
      ((PublicAccountInfo)localObject).messageSettingFlag = 3;
    }
    localObject = paramQQAppInterface.a().createEntityManager();
    b(paramQQAppInterface, paramString);
    if (a((EntityManager)localObject, paramString)) {
      e(paramString, paramQQAppInterface);
    }
    ((EntityManager)localObject).a();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return this.c;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!this.d) {
      try
      {
        Object localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
        if (localObject != null)
        {
          this.d = true;
          if (paramQQAppInterface != null) {
            f(paramQQAppInterface);
          }
          paramQQAppInterface = ((PublicAccountDataManager)localObject).a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              localObject = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilMap.put(((PublicAccountInfo)localObject).getUin(), localObject);
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
    if (paramQQAppInterface.messageSettingFlag == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PubAccountAssistantManager", 2, "app == null; what happen.");
      }
    }
    PubAccountAssistantData localPubAccountAssistantData;
    do
    {
      return;
      if (!paramQQAppInterface.getAccount().equals(this.j)) {
        b(paramQQAppInterface);
      }
      localPubAccountAssistantData = a(paramQQAppInterface);
    } while (localPubAccountAssistantData == null);
    a(paramQQAppInterface, 0, localPubAccountAssistantData.mLastMsgTime);
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      e(paramString, paramQQAppInterface);
    }
    localEntityManager.a();
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("show_public_account_assistant_guide", true);
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((a(paramQQAppInterface, paramString)) || (b(paramQQAppInterface, paramString))) {}
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          return false;
        } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)));
        paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramString, 0);
      } while (paramQQAppInterface == null);
      l1 = paramQQAppInterface.getLong("pubaccount_assistant_conversation_tip_last_show_time_" + paramString, 0L);
      l2 = System.currentTimeMillis();
    } while ((l1 != 0L) && (Math.abs(l2 - l1) <= 604800000L));
    return true;
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    i(paramQQAppInterface);
  }
  
  public void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (localObject1 != null)
    {
      if (((PublicAccountInfo)localObject1).messageSettingFlag != 0) {
        ((PublicAccountInfo)localObject1).messageSettingFlag = 1;
      }
      ((PublicAccountInfo)localObject1).mShowMsgFlag = 1;
    }
    localObject1 = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localObject1 = localEntityManager;
      PubAccountAssistantData localPubAccountAssistantData = a(paramQQAppInterface, paramString);
      localObject1 = localEntityManager;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      if (localPubAccountAssistantData != null)
      {
        localObject1 = localEntityManager;
        Object localObject2 = localRecentUserProxy.b(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localEntityManager;
          localObject2 = localRecentUserProxy.b(localPubAccountAssistantData.mUin, 0);
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localEntityManager;
          localObject2 = localRecentUserProxy.a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType);
        }
        localObject1 = localEntityManager;
        ((RecentUser)localObject2).lastmsgtime = localPubAccountAssistantData.mLastMsgTime;
        localObject1 = localEntityManager;
        ((RecentUser)localObject2).lastmsgdrafttime = localPubAccountAssistantData.mLastDraftTime;
        localObject1 = localEntityManager;
        a(localEntityManager, paramString);
        localObject1 = localEntityManager;
        localRecentUserProxy.a((RecentUser)localObject2);
        localObject1 = localEntityManager;
        e(paramString, paramQQAppInterface);
      }
      localObject1 = localEntityManager;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject1 = localEntityManager;
        a(paramQQAppInterface, 0, paramString.mLastMsgTime);
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
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(this.j, 0).getBoolean("pubaccount_assistant_has_config", true);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    int i1 = 0;
    int n = 0;
    int k = 0;
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int m = i1;
    try
    {
      if (this.jdField_a_of_type_JavaUtilSet != null)
      {
        m = i1;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        m = k;
        n = k;
        if (localIterator.hasNext())
        {
          m = k;
          String str = (String)localIterator.next();
          m = k;
          if (paramQQAppInterface.a().a(str, a(str)) > 0) {
            break label134;
          }
          m = k;
          localIterator.remove();
          k = 1;
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
      n = m;
      if (n != 0) {
        i(paramQQAppInterface);
      }
      return;
    }
    finally {}
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a().getSharedPreferences(this.j, 0).edit().putBoolean("pubaccount_assistant_has_config", true).commit();
  }
  
  public void g(QQAppInterface paramQQAppInterface)
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
        if (((((RecentUser)localObject4).type == 1008) || (((RecentUser)localObject4).type == 1024)) && (a(paramQQAppInterface, ((RecentUser)localObject4).uin)) && (!((RecentUser)localObject4).shouldShowInRecentList()) && (!b(paramQQAppInterface, ((RecentUser)localObject4).uin))) {
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
          localObject5 = (PubAccountAssistantData)((Iterator)localObject4).next();
          if (!a(paramQQAppInterface, ((PubAccountAssistantData)localObject5).mUin)) {
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
          localObject5 = paramQQAppInterface.a().a(((PubAccountAssistantData)localObject4).mUin, ((PubAccountAssistantData)localObject4).mType);
          if (localObject5 == null) {}
        }
        for (((PubAccountAssistantData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((PubAccountAssistantData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a(paramQQAppInterface, localEntityManager, (PubAccountAssistantData)localObject4);
          localRecentUserProxy.b((RecentUser)???);
          f(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (PubAccountAssistantData)((Iterator)localObject2).next();
        localObject4 = localRecentUserProxy.a(((PubAccountAssistantData)???).mUin, ((PubAccountAssistantData)???).mType);
        ((RecentUser)localObject4).uin = ((PubAccountAssistantData)???).mUin;
        ((RecentUser)localObject4).type = ((PubAccountAssistantData)???).mType;
        ((RecentUser)localObject4).lastmsgtime = ((PubAccountAssistantData)???).mLastMsgTime;
        ((RecentUser)localObject4).lastmsgdrafttime = ((PubAccountAssistantData)???).mLastDraftTime;
        if (a(localEntityManager, ((PubAccountAssistantData)???).mUin))
        {
          if (this.jdField_b_of_type_JavaUtilMap == null) {}
          for (localObject1 = null;; localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilMap.get(((PubAccountAssistantData)???).mUin))
          {
            if (localObject1 != null) {
              localRecentUserProxy.a((RecentUser)localObject4);
            }
            e(((PubAccountAssistantData)???).mUin, paramQQAppInterface);
            break;
          }
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, 0, ((PubAccountAssistantData)localObject1).mLastMsgTime);
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  public void h(QQAppInterface paramQQAppInterface)
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
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager
 * JD-Core Version:    0.7.0.1
 */