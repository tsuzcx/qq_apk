package com.tencent.mobileqq.app;

import MessageSvcPack.RequestPushFStatus;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import hjv;
import hjx;
import hjy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;

public class FriendsManager
  implements Manager
{
  public static final int a = -100;
  private static final long jdField_a_of_type_Long = 500654080L;
  public static final String a = "Q.contacttab.";
  public static final String b = "Q.contacttab.friend";
  public static final String c = "Q.contacttab.extension";
  public static final String d = "Q.contacttab.group";
  private static final String jdField_e_of_type_JavaLangString = "add_friend_request_sp";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(6);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new hjv(this);
  private boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private ConcurrentHashMap d = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap f = new ConcurrentHashMap(4);
  private ConcurrentHashMap g = new ConcurrentHashMap();
  private ConcurrentHashMap h = null;
  
  public FriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    f();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "add_friend_request_sp", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private ConcurrentHashMap a(boolean paramBoolean)
  {
    label611:
    label614:
    label617:
    label620:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      int i;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)localIterator.next();
          if (localFriends.gathtertype != 1) {
            break label617;
          }
          i += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label614;
            }
            if (localFriends.gathtertype == 2) {
              continue;
            }
          }
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            ContactSorter.a(localFriends);
          }
          String str = localFriends.groupid + "";
          localObject4 = (ArrayList)localConcurrentHashMap.get(str);
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label611;
            }
            localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (!((Iterator)localObject4).hasNext()) {
              break label611;
            }
            Groups localGroups = (Groups)((Iterator)localObject4).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
          }
          ((ArrayList)localObject1).add(localFriends);
          if ((!paramBoolean) || ((localFriends.status != 10) && (localFriends.status != 11))) {
            break label620;
          }
          localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
          if (localObject1 == null) {
            ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          } else {
            ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
          }
        }
      }
      finally {}
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            ContactSorter.b((ArrayList)localObject4);
          }
        }
      }
      if (paramBoolean) {
        this.e = ((ConcurrentHashMap)localObject5);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildNormalAndGatheredUiMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
        QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps end: , size:" + localConcurrentHashMap.size());
      }
      this.jdField_c_of_type_Int = i;
      return localConcurrentHashMap;
      continue;
      continue;
    }
  }
  
  private void a(Friends[] paramArrayOfFriends)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfFriends.length)
    {
      localArrayList.add(paramArrayOfFriends[i].uin);
      i += 1;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), localArrayList);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    c();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  private boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    for (;;)
    {
      return false;
      if (paramString.length() >= 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin uin=" + paramString);
      }
    }
    return true;
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (bool) {
          return;
        }
        long l = System.currentTimeMillis();
        this.jdField_c_of_type_Boolean = true;
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, null, null);
        if (QLog.isColorLevel())
        {
          if (localArrayList == null)
          {
            i = 0;
            QLog.d("Q.contacttab.", 2, "nearby people card count = " + i);
            break label187;
            if (i < localArrayList.size())
            {
              NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localArrayList.get(i);
              if (localNearbyPeopleCard == null) {
                break label197;
              }
              a(localNearbyPeopleCard);
              break label197;
            }
          }
          else
          {
            i = localArrayList.size();
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("Q.contacttab.", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - l));
          continue;
        }
        if (localObject == null) {
          continue;
        }
      }
      finally {}
      label187:
      int i = 0;
      continue;
      label197:
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.status;
    }
    return 10;
  }
  
  public Card a(String paramString)
  {
    return (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
  }
  
  public ContactCard a(String paramString)
  {
    return (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {}
    do
    {
      return null;
      if (!this.jdField_c_of_type_Boolean) {
        g();
      }
    } while (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString));
    return (DateNickNameInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      ??? = null;
      return ???;
    }
    if (this.d != null) {}
    for (ExtensionInfo localExtensionInfo = (ExtensionInfo)this.d.get(paramString);; localExtensionInfo = null)
    {
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      if (!paramBoolean) {
        return null;
      }
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      ??? = localExtensionInfo;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
      ??? = localExtensionInfo;
      if (localExtensionInfo == null) {
        break;
      }
      synchronized (this.d)
      {
        this.d.put(paramString, localExtensionInfo);
        return localExtensionInfo;
      }
    }
  }
  
  public Friends a(String paramString)
  {
    Object localObject = null;
    if (!f(paramString)) {}
    do
    {
      do
      {
        Friends localFriends;
        do
        {
          do
          {
            return localObject;
          } while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null);
          localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.jdField_a_of_type_Boolean);
      paramString = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
      if (paramString != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString.uin, paramString);
      }
      localObject = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "findFriendEntifyFromCache from db f=" + paramString);
    return paramString;
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    paramString1.name = paramString2;
    paramString1.datetime = System.currentTimeMillis();
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    return paramString1;
  }
  
  public Groups a(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return localObject;
        localGroups = (Groups)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localGroups);
    this.jdField_a_of_type_JavaUtilArrayList = ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, localGroups);
    return localGroups;
  }
  
  public SpecialCareInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getSpecialCareInfo: uin=" + paramString + ", cacheState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    ??? = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label76;
      }
      ??? = localObject1;
    }
    for (;;)
    {
      return ???;
      label76:
      localObject1 = localObject3;
      if (this.g != null) {}
      synchronized (this.g)
      {
        localObject1 = (SpecialCareInfo)this.g.get(paramString);
        ??? = localObject1;
        if (localObject1 == null) {
          continue;
        }
        return (SpecialCareInfo)((SpecialCareInfo)localObject1).clone();
      }
    }
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    Friends localFriends = c(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  protected ArrayList a(String paramString)
  {
    return (ArrayList)this.f.get(paramString);
  }
  
  public List a()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.g == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.g)
    {
      Iterator localIterator = this.g.values().iterator();
      while (localIterator.hasNext())
      {
        SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)localIterator.next();
        if (localSpecialCareInfo.globalSwitch != 0) {
          localArrayList.add((SpecialCareInfo)localSpecialCareInfo.clone());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getSpecailCareInfos: size=" + localList.size());
    }
    return localList;
  }
  
  public ConcurrentHashMap a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, Friends.class.getSimpleName(), false, "gathtertype=?", new String[] { String.valueOf(2) }, null, null, null, null);
    Object localObject1 = new ConcurrentHashMap();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Friends)((Iterator)localObject2).next();
        ((ConcurrentHashMap)localObject1).put(((Friends)localObject3).uin, localObject3);
      }
    }
    Object localObject3 = new ConcurrentHashMap(6);
    Iterator localIterator = ((ConcurrentHashMap)localObject1).values().iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      String str = localFriends.groupid + "";
      localObject2 = (ArrayList)((ConcurrentHashMap)localObject3).get(str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        ((ConcurrentHashMap)localObject3).put(str, localObject1);
      }
      ((ArrayList)localObject1).add(localFriends);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArrayList)((ConcurrentHashMap)localObject3).get(String.valueOf(((Groups)((Iterator)localObject1).next()).group_id));
        if (localObject2 != null) {
          ContactSorter.b((ArrayList)localObject2);
        }
      }
    }
    return localObject3;
  }
  
  public void a()
  {
    label299:
    label502:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildUIMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label299;
        }
        Friends localFriends = (Friends)localIterator.next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          ContactSorter.a(localFriends);
        }
        String str = localFriends.groupid + "";
        localObject4 = (ArrayList)localConcurrentHashMap.get(str);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          localConcurrentHashMap.put(str, localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label502;
          }
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label502;
          }
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          if (localGroups.group_id != localFriends.groupid) {
            continue;
          }
          ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
        }
        ((ArrayList)localObject1).add(localFriends);
        if ((localFriends.status != 10) && (localFriends.status != 11)) {
          continue;
        }
        localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
        if (localObject1 == null)
        {
          ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          continue;
        }
        ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(localObject2.intValue() + 1));
      }
      finally {}
      continue;
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            ContactSorter.b((ArrayList)localObject4);
          }
        }
      }
      this.e = ((ConcurrentHashMap)localObject5);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildUIMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
      }
      this.f = localConcurrentHashMap;
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 467	java/lang/StringBuffer
    //   6: dup
    //   7: invokespecial 468	java/lang/StringBuffer:<init>	()V
    //   10: astore 9
    //   12: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +19 -> 34
    //   18: aload 9
    //   20: ldc_w 470
    //   23: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aload 9
    //   29: iload_1
    //   30: invokevirtual 476	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   33: pop
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 478	com/tencent/mobileqq/app/FriendsManager:a	(I)Ljava/util/ArrayList;
    //   39: astore 8
    //   41: aconst_null
    //   42: astore 6
    //   44: aload_0
    //   45: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   48: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   51: astore 7
    //   53: aload 7
    //   55: astore 6
    //   57: aload 6
    //   59: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   62: aload 8
    //   64: invokevirtual 218	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_2
    //   71: aload 7
    //   73: invokeinterface 170 1 0
    //   78: ifeq +170 -> 248
    //   81: aload 7
    //   83: invokeinterface 174 1 0
    //   88: checkcast 176	com/tencent/mobileqq/persistence/Entity
    //   91: checkcast 178	com/tencent/mobileqq/data/Friends
    //   94: astore 10
    //   96: aload_0
    //   97: aload 10
    //   99: getfield 279	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   102: invokevirtual 483	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   105: istore 5
    //   107: iload_2
    //   108: istore_3
    //   109: aload 10
    //   111: getfield 182	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   114: iconst_1
    //   115: if_icmpeq +14 -> 129
    //   118: iload_2
    //   119: istore_3
    //   120: iload 5
    //   122: ifeq +7 -> 129
    //   125: iload_2
    //   126: iconst_1
    //   127: iadd
    //   128: istore_3
    //   129: aload 10
    //   131: iconst_0
    //   132: putfield 199	com/tencent/mobileqq/data/Friends:groupid	I
    //   135: aload_0
    //   136: aload 10
    //   138: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   141: pop
    //   142: iload_3
    //   143: istore_2
    //   144: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq -76 -> 71
    //   150: aload 9
    //   152: ldc_w 488
    //   155: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: aload 9
    //   161: aload 10
    //   163: getfield 279	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   166: iconst_0
    //   167: iconst_4
    //   168: invokevirtual 492	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   174: pop
    //   175: aload 9
    //   177: ldc_w 494
    //   180: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   183: pop
    //   184: aload 9
    //   186: iload 5
    //   188: invokevirtual 497	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   191: pop
    //   192: iload_3
    //   193: istore_2
    //   194: goto -123 -> 71
    //   197: astore 7
    //   199: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +31 -> 233
    //   205: ldc 24
    //   207: iconst_2
    //   208: new 124	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 499
    //   218: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload_1
    //   222: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: aload 7
    //   230: invokestatic 502	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload 6
    //   235: ifnull +8 -> 243
    //   238: aload 6
    //   240: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   243: aload_0
    //   244: invokevirtual 306	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   247: return
    //   248: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +14 -> 265
    //   254: ldc 24
    //   256: iconst_2
    //   257: aload 9
    //   259: invokevirtual 505	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   262: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_0
    //   266: iconst_0
    //   267: invokestatic 248	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   270: invokevirtual 507	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   273: astore 7
    //   275: aload 7
    //   277: ifnull +31 -> 308
    //   280: aload 7
    //   282: aload 7
    //   284: getfield 226	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   287: aload 8
    //   289: invokevirtual 271	java/util/ArrayList:size	()I
    //   292: iadd
    //   293: putfield 226	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   296: aload 7
    //   298: iload_2
    //   299: aload 7
    //   301: getfield 510	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   304: iadd
    //   305: putfield 510	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   308: aload_0
    //   309: aload 7
    //   311: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   314: pop
    //   315: aload_0
    //   316: new 124	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   323: iload_1
    //   324: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc 204
    //   329: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 507	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   338: astore 7
    //   340: aload_0
    //   341: getfield 410	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   344: ifnull +30 -> 374
    //   347: aload_0
    //   348: getfield 410	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   351: new 124	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   358: iload_1
    //   359: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 204
    //   364: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 516	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: aload_0
    //   375: getfield 217	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   378: invokevirtual 517	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   381: checkcast 210	java/util/ArrayList
    //   384: astore 8
    //   386: iload 4
    //   388: istore_2
    //   389: iload_2
    //   390: aload 8
    //   392: invokevirtual 271	java/util/ArrayList:size	()I
    //   395: if_icmpge +26 -> 421
    //   398: iload_1
    //   399: aload 8
    //   401: iload_2
    //   402: invokevirtual 343	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   405: checkcast 220	com/tencent/mobileqq/data/Groups
    //   408: getfield 223	com/tencent/mobileqq/data/Groups:group_id	I
    //   411: if_icmpne +44 -> 455
    //   414: aload 8
    //   416: iload_2
    //   417: invokevirtual 519	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   420: pop
    //   421: aload_0
    //   422: aload 8
    //   424: putfield 217	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   427: aload_0
    //   428: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   431: aload 7
    //   433: invokevirtual 521	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   436: pop
    //   437: aload 6
    //   439: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   442: aload 6
    //   444: ifnull -201 -> 243
    //   447: aload 6
    //   449: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   452: goto -209 -> 243
    //   455: iload_2
    //   456: iconst_1
    //   457: iadd
    //   458: istore_2
    //   459: goto -70 -> 389
    //   462: astore 7
    //   464: aconst_null
    //   465: astore 6
    //   467: aload 6
    //   469: ifnull +8 -> 477
    //   472: aload 6
    //   474: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   477: aload 7
    //   479: athrow
    //   480: astore 7
    //   482: goto -15 -> 467
    //   485: astore 7
    //   487: goto -20 -> 467
    //   490: astore 7
    //   492: goto -293 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	FriendsManager
    //   0	495	1	paramInt	int
    //   70	389	2	i	int
    //   108	85	3	j	int
    //   1	386	4	k	int
    //   105	82	5	bool	boolean
    //   42	431	6	localObject1	Object
    //   51	31	7	localObject2	Object
    //   197	32	7	localException1	Exception
    //   273	159	7	localGroups	Groups
    //   462	16	7	localObject3	Object
    //   480	1	7	localObject4	Object
    //   485	1	7	localObject5	Object
    //   490	1	7	localException2	Exception
    //   39	384	8	localArrayList	ArrayList
    //   10	248	9	localStringBuffer	java.lang.StringBuffer
    //   94	68	10	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   57	69	197	java/lang/Exception
    //   71	107	197	java/lang/Exception
    //   109	118	197	java/lang/Exception
    //   129	142	197	java/lang/Exception
    //   144	192	197	java/lang/Exception
    //   248	265	197	java/lang/Exception
    //   265	275	197	java/lang/Exception
    //   280	308	197	java/lang/Exception
    //   308	374	197	java/lang/Exception
    //   374	386	197	java/lang/Exception
    //   389	421	197	java/lang/Exception
    //   421	442	197	java/lang/Exception
    //   44	53	462	finally
    //   57	69	480	finally
    //   71	107	480	finally
    //   109	118	480	finally
    //   129	142	480	finally
    //   144	192	480	finally
    //   248	265	480	finally
    //   265	275	480	finally
    //   280	308	480	finally
    //   308	374	480	finally
    //   374	386	480	finally
    //   389	421	480	finally
    //   421	442	480	finally
    //   199	233	485	finally
    //   44	53	490	java/lang/Exception
  }
  
  void a(long paramLong, byte paramByte)
  {
    Groups localGroups = a(paramLong + "");
    if ((localGroups == null) || (localGroups.seqid == paramByte)) {
      return;
    }
    localGroups.seqid = paramByte;
    a(localGroups);
    e();
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (paramExtensionInfo.uin == null)) {}
    do
    {
      return;
      a(paramExtensionInfo);
    } while (this.d == null);
    synchronized (this.d)
    {
      this.d.put(paramExtensionInfo.uin, paramExtensionInfo);
      return;
    }
  }
  
  public void a(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      ContactSorter.a(paramFriends);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void a(Friends paramFriends, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin + ", needRefreshUI=" + paramBoolean);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    a(paramFriends);
    if (paramBoolean) {
      a();
    }
  }
  
  public void a(Groups paramGroups)
  {
    int k = 0;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    int i;
    if (paramGroups.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramGroups.group_id + "", paramGroups);
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localGroups.group_id == paramGroups.group_id)
        {
          localGroups.datetime = paramGroups.datetime;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          localGroups.group_id = paramGroups.group_id;
          localGroups.group_name = paramGroups.group_name;
          localGroups.group_online_friend_count = paramGroups.group_online_friend_count;
          localGroups.seqid = paramGroups.seqid;
          localGroups.sqqOnLine_count = paramGroups.sqqOnLine_count;
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          this.jdField_a_of_type_JavaUtilArrayList = ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, paramGroups);
        }
        a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
        break;
      }
      i += 1;
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    if (paramNearbyPeopleCard == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((TextUtils.isEmpty(paramNearbyPeopleCard.uin)) || (TextUtils.isEmpty(paramNearbyPeopleCard.nickname)) || (paramNearbyPeopleCard.lastUpdateNickTime <= 0L)) {
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramNearbyPeopleCard.uin))
        {
          localDateNickNameInfo = (DateNickNameInfo)this.jdField_a_of_type_JavaUtilMap.get(paramNearbyPeopleCard.uin);
          localDateNickNameInfo.lastUpdateTime = paramNearbyPeopleCard.lastUpdateNickTime;
          localDateNickNameInfo.nickName = paramNearbyPeopleCard.nickname;
          continue;
        }
      }
      finally {}
      DateNickNameInfo localDateNickNameInfo = new DateNickNameInfo(paramNearbyPeopleCard.nickname, paramNearbyPeopleCard.lastUpdateNickTime);
      this.jdField_a_of_type_JavaUtilMap.put(paramNearbyPeopleCard.uin, localDateNickNameInfo);
    }
  }
  
  public void a(SpecialCareInfo paramSpecialCareInfo)
  {
    if ((paramSpecialCareInfo == null) || (paramSpecialCareInfo.uin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo: " + paramSpecialCareInfo.toString());
    }
    if (this.g != null) {}
    synchronized (this.g)
    {
      this.g.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
      a(paramSpecialCareInfo);
      return;
    }
  }
  
  protected void a(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.h != null) {
      this.h.put(paramString, "");
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      Friends localFriends = b(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (localFriends.groupid >= 0)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Groups localGroups = a(String.valueOf(localFriends.groupid));
        if (localGroups != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localGroups.group_friend_count -= 1;
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (c(paramString))
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localGroups.group_online_friend_count -= 1;
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a(localGroups);
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localFriends.groupid = -1002;
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localFriends.uin);
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      a(localFriends);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.c();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        EntityTransaction localEntityTransaction;
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToBlackList ex", paramString);
        }
        if (localObject1 != null) {
          localObject1.b();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label335;
      }
      localObject2.b();
    }
    a();
  }
  
  protected void a(String paramString, byte paramByte)
  {
    Card localCard = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = paramString;
      localCard.bSingle = paramByte;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.bSingle = paramByte;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  public void a(String paramString, int paramInt)
  {
    Friends localFriends = c(paramString);
    int i;
    Groups localGroups1;
    Groups localGroups2;
    if (localFriends != null)
    {
      i = localFriends.groupid;
      localGroups1 = a(String.valueOf(i));
      if ((i >= 0) && (localGroups1 != null))
      {
        localGroups1.group_friend_count -= 1;
        if (c(localFriends.uin)) {
          localGroups1.group_online_friend_count -= 1;
        }
      }
      localGroups2 = a(String.valueOf(paramInt));
      if (localGroups2 != null)
      {
        localGroups2.group_friend_count += 1;
        if (c(localFriends.uin)) {
          localGroups2.group_online_friend_count += 1;
        }
      }
      localFriends.groupid = paramInt;
      localObject = null;
      paramString = null;
    }
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      a(localFriends);
      if ((i >= 0) && (localGroups1 != null))
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups1);
      }
      if (localGroups2 != null)
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups2);
      }
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          QLog.e("Q.contacttab.group", 2, "setFriendGroup ex=", localException);
        }
        if (paramString != null) {
          paramString.b();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label286;
      }
      ((EntityTransaction)localObject).b();
    }
    a();
  }
  
  void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramGetOnlineInfoResp != null))
    {
      paramString = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        break label28;
      }
    }
    label28:
    do
    {
      return;
      paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      paramString.eNetwork = paramGetOnlineInfoResp.eNetworkType;
      paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
    } while (((paramGetOnlineInfoResp.iTermType != 67586L) && (paramGetOnlineInfoResp.iTermType != 66566L) && (paramGetOnlineInfoResp.iTermType != 72194L) && (paramGetOnlineInfoResp.iTermType != 65804L) && (paramGetOnlineInfoResp.iTermType != 72706L)) || (paramGetOnlineInfoResp.eNetworkType == 1));
    paramString.netTypeIconIdIphoneOrWphoneNoWifi = paramGetOnlineInfoResp.eIconType;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = b(paramString1);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    a(localFriends);
  }
  
  protected void a(String paramString1, short paramShort, String paramString2, String paramString3)
  {
    paramString1 = b(paramString1);
    paramString1.name = paramString2;
    paramString1.faceid = paramShort;
    if (paramString3 != null) {
      paramString1.signature = paramString3;
    }
    paramString1.datetime = System.currentTimeMillis();
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    a(paramString1);
  }
  
  protected void a(String paramString1, short paramShort1, String paramString2, String paramString3, byte paramByte1, short paramShort2, byte paramByte2)
  {
    byte b1 = 1;
    paramString1 = b(paramString1);
    paramString1.cSpecialFlag = paramByte1;
    paramString1.name = paramString2;
    paramString1.faceid = paramShort1;
    if (paramShort2 == 0) {
      paramByte1 = b1;
    }
    for (;;)
    {
      paramString1.gender = paramByte1;
      paramString1.age = paramByte2;
      if (paramString3 != null) {
        paramString1.signature = paramString3;
      }
      paramString1.datetime = System.currentTimeMillis();
      if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin))) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ContactSorter.a(paramString1);
      a(paramString1);
      return;
      if (paramShort2 == 1) {
        paramByte1 = 2;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      a().edit().putLong(paramString, System.currentTimeMillis()).commit();
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
    a().edit().remove(paramString).commit();
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte, short paramShort)
  {
    Card localCard = a(paramString);
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = paramString;
      localCard.vContent = paramArrayOfByte;
      localCard.shType = paramShort;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.vContent = paramArrayOfByte;
    localCard.shType = paramShort;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  void a(ArrayList paramArrayList)
  {
    if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (paramArrayList != null))
    {
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject1 = (SimpleOnlineFriendInfo)paramArrayList.next();
        localObject2 = String.valueOf(((SimpleOnlineFriendInfo)localObject1).friendUin);
        Friends localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if (localFriends != null)
        {
          if (((SimpleOnlineFriendInfo)localObject1).isMqqOnLine != 0) {}
          for (boolean bool = true;; bool = false)
          {
            localFriends.isMqqOnLine = bool;
            localFriends.status = ((SimpleOnlineFriendInfo)localObject1).status;
            localFriends.detalStatusFlag = ((SimpleOnlineFriendInfo)localObject1).detalStatusFlag;
            localFriends.sqqOnLineState = ((SimpleOnlineFriendInfo)localObject1).sqqOnLineState;
            localFriends.isIphoneOnline = ((SimpleOnlineFriendInfo)localObject1).isIphoneOnline;
            localFriends.iTermType = ((SimpleOnlineFriendInfo)localObject1).iTermType;
            localFriends.cNetwork = ((SimpleOnlineFriendInfo)localObject1).cNetwork;
            localFriends.abilityBits = ((SimpleOnlineFriendInfo)localObject1).uAbiFlag;
            localFriends.eNetwork = ((SimpleOnlineFriendInfo)localObject1).eNetworkType;
            localFriends.netTypeIconId = ((SimpleOnlineFriendInfo)localObject1).eIconType;
            localFriends.strTermDesc = ((SimpleOnlineFriendInfo)localObject1).strTermDesc;
            if (((((SimpleOnlineFriendInfo)localObject1).iTermType == 67586) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 66566) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 72194) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 65804) || (((SimpleOnlineFriendInfo)localObject1).iTermType == 72706)) && (((SimpleOnlineFriendInfo)localObject1).eNetworkType != 1)) {
              localFriends.netTypeIconIdIphoneOrWphoneNoWifi = ((SimpleOnlineFriendInfo)localObject1).eIconType;
            }
            localHashMap.put(localObject2, Boolean.TRUE);
            break;
          }
        }
      }
      paramArrayList = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if (((Boolean)localHashMap.get(localObject1) == null) && (((Friends)localObject2).isFriend()))
        {
          ((Friends)localObject2).status = 20;
          ((Friends)localObject2).isMqqOnLine = false;
          ((Friends)localObject2).sqqOnLineState = 0;
          ((Friends)localObject2).detalStatusFlag = 20;
          ((Friends)localObject2).isIphoneOnline = 0;
          ((Friends)localObject2).cNetwork = 0;
          ((Friends)localObject2).abilityBits = 0L;
          ((Friends)localObject2).eNetwork = 0;
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramArrayList.iterator();
    Friends localFriends;
    while (((Iterator)localObject2).hasNext())
    {
      localFriends = (Friends)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(localFriends.uin + ",");
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveGatherList  GatherList size : " + paramArrayList.size() + " | saveGatherList : " + ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1) {
            localFriends.gathtertype = 0;
          }
          a(localFriends);
        }
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryFriends_" + paramList.size());
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int i = 1;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        i += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Friends)paramList.next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Friends)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  public void a(List paramList, long paramLong, boolean paramBoolean)
  {
    int k = 0;
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "syncSpecialCareInfos: " + i + ", " + paramLong + ", " + paramBoolean);
      }
      int j;
      if (this.g != null)
      {
        localObject = this.g;
        j = 0;
        for (;;)
        {
          if (j < i) {}
          Iterator localIterator;
          try
          {
            this.g.put(((SpecialCareInfo)paramList.get(j)).uin, paramList.get(j));
            j += 1;
          }
          finally {}
        }
        if (paramBoolean)
        {
          localIterator = this.g.entrySet().iterator();
          while (localIterator.hasNext()) {
            if (((SpecialCareInfo)((Map.Entry)localIterator.next()).getValue()).dateTime < paramLong) {
              localIterator.remove();
            }
          }
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        ((EntityTransaction)localObject).a();
        j = k;
        while (j < i)
        {
          a((Entity)paramList.get(j));
          j += 1;
        }
        if (paramBoolean)
        {
          paramList = ((SpecialCareInfo)SpecialCareInfo.class.newInstance()).getTableName();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("delete from " + paramList + " where dateTime<" + paramLong);
        }
        ((EntityTransaction)localObject).c();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)localObject).b();
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Card localCard = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localCard.vQQFaceID = paramArrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.vQQFaceID = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnull +277 -> 281
    //   7: aload_2
    //   8: ifnull +273 -> 281
    //   11: aconst_null
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 7
    //   23: aload 7
    //   25: astore 6
    //   27: aload 6
    //   29: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   32: new 467	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 468	java/lang/StringBuffer:<init>	()V
    //   39: astore 7
    //   41: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +12 -> 56
    //   47: aload 7
    //   49: ldc_w 840
    //   52: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: istore 4
    //   61: iload 5
    //   63: aload_1
    //   64: arraylength
    //   65: if_icmpge +217 -> 282
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_1
    //   73: iload 5
    //   75: baload
    //   76: invokestatic 248	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 507	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 8
    //   84: iload_3
    //   85: istore 4
    //   87: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +70 -> 160
    //   93: iload_3
    //   94: istore 4
    //   96: aload 7
    //   98: ldc_w 842
    //   101: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   104: pop
    //   105: iload_3
    //   106: istore 4
    //   108: aload 7
    //   110: aload_1
    //   111: iload 5
    //   113: baload
    //   114: invokevirtual 476	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: iload_3
    //   119: istore 4
    //   121: aload 7
    //   123: ldc_w 844
    //   126: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: iload_3
    //   131: istore 4
    //   133: aload 7
    //   135: aload_2
    //   136: iload 5
    //   138: baload
    //   139: invokevirtual 476	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 8
    //   145: ifnonnull +15 -> 160
    //   148: iload_3
    //   149: istore 4
    //   151: aload 7
    //   153: ldc_w 846
    //   156: invokevirtual 473	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: iload_3
    //   161: istore 4
    //   163: aload 8
    //   165: ifnull +220 -> 385
    //   168: iload_3
    //   169: istore 4
    //   171: aload 8
    //   173: getfield 526	com/tencent/mobileqq/data/Groups:seqid	B
    //   176: aload_2
    //   177: iload 5
    //   179: baload
    //   180: if_icmpne +9 -> 189
    //   183: iload_3
    //   184: istore 4
    //   186: goto +199 -> 385
    //   189: iload_3
    //   190: istore 4
    //   192: aload 8
    //   194: aload_2
    //   195: iload 5
    //   197: baload
    //   198: putfield 526	com/tencent/mobileqq/data/Groups:seqid	B
    //   201: iconst_1
    //   202: istore_3
    //   203: iconst_1
    //   204: istore 4
    //   206: aload_0
    //   207: aload 8
    //   209: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   212: pop
    //   213: iload_3
    //   214: istore 4
    //   216: goto +169 -> 385
    //   219: astore_2
    //   220: aload 6
    //   222: astore_1
    //   223: iload 4
    //   225: istore_3
    //   226: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +32 -> 261
    //   232: ldc 24
    //   234: iconst_2
    //   235: new 124	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 848
    //   245: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_2
    //   249: invokevirtual 851	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   252: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_1
    //   262: ifnull +117 -> 379
    //   265: aload_1
    //   266: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   269: iload_3
    //   270: istore 4
    //   272: iload 4
    //   274: ifeq +7 -> 281
    //   277: aload_0
    //   278: invokevirtual 528	com/tencent/mobileqq/app/FriendsManager:e	()V
    //   281: return
    //   282: iload_3
    //   283: istore 4
    //   285: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +17 -> 305
    //   291: iload_3
    //   292: istore 4
    //   294: ldc 24
    //   296: iconst_2
    //   297: aload 7
    //   299: invokevirtual 505	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   302: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: iload_3
    //   306: istore 4
    //   308: aload 6
    //   310: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   313: iload_3
    //   314: istore 4
    //   316: aload 6
    //   318: ifnull -46 -> 272
    //   321: aload 6
    //   323: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   326: iload_3
    //   327: istore 4
    //   329: goto -57 -> 272
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 6
    //   336: aload 6
    //   338: ifnull +8 -> 346
    //   341: aload 6
    //   343: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: goto -13 -> 336
    //   352: astore_2
    //   353: aload_1
    //   354: astore 6
    //   356: aload_2
    //   357: astore_1
    //   358: goto -22 -> 336
    //   361: astore_2
    //   362: iconst_0
    //   363: istore_3
    //   364: aload 6
    //   366: astore_1
    //   367: goto -141 -> 226
    //   370: astore_2
    //   371: aload 6
    //   373: astore_1
    //   374: iconst_0
    //   375: istore_3
    //   376: goto -150 -> 226
    //   379: iload_3
    //   380: istore 4
    //   382: goto -110 -> 272
    //   385: iload 5
    //   387: iconst_1
    //   388: iadd
    //   389: istore 5
    //   391: iload 4
    //   393: istore_3
    //   394: goto -336 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	FriendsManager
    //   0	397	1	paramArrayOfByte1	byte[]
    //   0	397	2	paramArrayOfByte2	byte[]
    //   57	337	3	i	int
    //   59	333	4	j	int
    //   1	389	5	k	int
    //   12	360	6	localObject1	Object
    //   21	277	7	localObject2	Object
    //   82	126	8	localGroups	Groups
    // Exception table:
    //   from	to	target	type
    //   61	68	219	java/lang/Exception
    //   71	84	219	java/lang/Exception
    //   87	93	219	java/lang/Exception
    //   96	105	219	java/lang/Exception
    //   108	118	219	java/lang/Exception
    //   121	130	219	java/lang/Exception
    //   133	143	219	java/lang/Exception
    //   151	160	219	java/lang/Exception
    //   171	183	219	java/lang/Exception
    //   192	201	219	java/lang/Exception
    //   206	213	219	java/lang/Exception
    //   285	291	219	java/lang/Exception
    //   294	305	219	java/lang/Exception
    //   308	313	219	java/lang/Exception
    //   14	23	332	finally
    //   27	56	348	finally
    //   61	68	348	finally
    //   71	84	348	finally
    //   87	93	348	finally
    //   96	105	348	finally
    //   108	118	348	finally
    //   121	130	348	finally
    //   133	143	348	finally
    //   151	160	348	finally
    //   171	183	348	finally
    //   192	201	348	finally
    //   206	213	348	finally
    //   285	291	348	finally
    //   294	305	348	finally
    //   308	313	348	finally
    //   226	261	352	finally
    //   14	23	361	java/lang/Exception
    //   27	56	370	java/lang/Exception
  }
  
  void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    int i;
    if (paramArrayOfFriends != null) {
      i = paramArrayOfFriends.length;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveFriendsList: " + i + ", " + paramLong + ", " + paramBoolean);
      }
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        int j = 0;
        while (j < i)
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfFriends[j].uin, paramArrayOfFriends[j]);
          a(paramArrayOfFriends[j]);
          j += 1;
        }
        if (paramBoolean)
        {
          Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
            if ((localFriends.datetime < paramLong) && (localFriends.isFriend()))
            {
              localIterator.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFriends);
            }
          }
        }
        i = -1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
        for (;;)
        {
          if (i > 0) {
            a(paramArrayOfFriends);
          }
          return;
          localEntityTransaction.c();
          localEntityTransaction.b();
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  /* Error */
  void a(Groups[] paramArrayOfGroups)
  {
    // Byte code:
    //   0: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 124	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 859
    //   16: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore_3
    //   20: aload_1
    //   21: ifnull +30 -> 51
    //   24: aload_1
    //   25: arraylength
    //   26: istore_2
    //   27: ldc 18
    //   29: iconst_2
    //   30: aload_3
    //   31: iload_2
    //   32: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_1
    //   42: ifnull +8 -> 50
    //   45: aload_1
    //   46: arraylength
    //   47: ifne +9 -> 56
    //   50: return
    //   51: iconst_m1
    //   52: istore_2
    //   53: goto -26 -> 27
    //   56: aload_0
    //   57: getfield 217	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   60: ifnonnull +29 -> 89
    //   63: aload_0
    //   64: new 210	java/util/ArrayList
    //   67: dup
    //   68: aload_1
    //   69: arraylength
    //   70: invokespecial 860	java/util/ArrayList:<init>	(I)V
    //   73: putfield 217	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: aload_0
    //   77: new 47	java/util/concurrent/ConcurrentHashMap
    //   80: dup
    //   81: aload_1
    //   82: arraylength
    //   83: invokespecial 66	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   86: putfield 410	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   89: new 210	java/util/ArrayList
    //   92: dup
    //   93: aload_1
    //   94: arraylength
    //   95: invokespecial 860	java/util/ArrayList:<init>	(I)V
    //   98: astore 4
    //   100: new 47	java/util/concurrent/ConcurrentHashMap
    //   103: dup
    //   104: aload_1
    //   105: arraylength
    //   106: invokespecial 66	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   109: astore 5
    //   111: aload_0
    //   112: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   115: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   123: iconst_0
    //   124: istore_2
    //   125: iload_2
    //   126: aload_1
    //   127: arraylength
    //   128: if_icmpge +60 -> 188
    //   131: aload 5
    //   133: new 124	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: iload_2
    //   142: aaload
    //   143: getfield 223	com/tencent/mobileqq/data/Groups:group_id	I
    //   146: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc 204
    //   151: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_1
    //   158: iload_2
    //   159: aaload
    //   160: invokevirtual 215	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload 4
    //   166: aload_1
    //   167: iload_2
    //   168: aaload
    //   169: invokevirtual 233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload_0
    //   174: aload_1
    //   175: iload_2
    //   176: aaload
    //   177: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   180: pop
    //   181: iload_2
    //   182: iconst_1
    //   183: iadd
    //   184: istore_2
    //   185: goto -60 -> 125
    //   188: aload_1
    //   189: arraylength
    //   190: iconst_1
    //   191: if_icmple +8 -> 199
    //   194: aload 4
    //   196: invokestatic 862	com/tencent/mobileqq/app/ContactSorter:a	(Ljava/util/ArrayList;)V
    //   199: aload_0
    //   200: getfield 410	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: invokevirtual 811	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   206: invokeinterface 268 1 0
    //   211: astore_1
    //   212: aload_1
    //   213: invokeinterface 170 1 0
    //   218: ifeq +91 -> 309
    //   221: aload_1
    //   222: invokeinterface 174 1 0
    //   227: checkcast 813	java/util/Map$Entry
    //   230: astore 6
    //   232: aload 5
    //   234: aload 6
    //   236: invokeinterface 865 1 0
    //   241: checkcast 187	java/lang/String
    //   244: invokevirtual 407	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   247: ifne -35 -> 212
    //   250: aload_0
    //   251: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   254: aload 6
    //   256: invokeinterface 816 1 0
    //   261: checkcast 176	com/tencent/mobileqq/persistence/Entity
    //   264: invokevirtual 521	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   267: pop
    //   268: goto -56 -> 212
    //   271: astore_1
    //   272: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +13 -> 288
    //   278: ldc 24
    //   280: iconst_2
    //   281: ldc_w 867
    //   284: aload_1
    //   285: invokestatic 502	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: aload_3
    //   289: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   292: aload_0
    //   293: aload 4
    //   295: putfield 217	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   298: aload_0
    //   299: aload 5
    //   301: putfield 410	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   304: aload_0
    //   305: invokevirtual 306	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   308: return
    //   309: aload_3
    //   310: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   313: aload_3
    //   314: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   317: goto -25 -> 292
    //   320: astore_1
    //   321: aload_3
    //   322: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   325: aload_1
    //   326: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	FriendsManager
    //   0	327	1	paramArrayOfGroups	Groups[]
    //   26	159	2	i	int
    //   19	303	3	localObject	Object
    //   98	196	4	localArrayList	ArrayList
    //   109	191	5	localConcurrentHashMap	ConcurrentHashMap
    //   230	25	6	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   119	123	271	java/lang/Exception
    //   125	181	271	java/lang/Exception
    //   188	199	271	java/lang/Exception
    //   199	212	271	java/lang/Exception
    //   212	268	271	java/lang/Exception
    //   309	313	271	java/lang/Exception
    //   119	123	320	finally
    //   125	181	320	finally
    //   188	199	320	finally
    //   199	212	320	finally
    //   212	268	320	finally
    //   272	288	320	finally
    //   309	313	320	finally
  }
  
  public boolean a()
  {
    boolean bool = b();
    a();
    return bool;
  }
  
  public boolean a(Card paramCard)
  {
    return a(paramCard);
  }
  
  public boolean a(ContactCard paramContactCard)
  {
    return a(paramContactCard);
  }
  
  protected boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while ((paramFriends.getStatus() != 1001) && (paramFriends.getStatus() != 1002));
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
    }
    QLog.d("Q.contacttab.friend", 2, "updateFriendEntity em closed f=" + paramFriends.uin);
    return false;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.h == null)
    {
      this.h = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.h.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.h.size());
      }
    }
    return this.h.containsKey(paramString);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 24
    //   11: iconst_2
    //   12: new 124	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 893
    //   22: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 270
    //   32: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 270
    //   42: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_3
    //   46: invokevirtual 423	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   59: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   62: astore 8
    //   64: aload 8
    //   66: astore 9
    //   68: aload 8
    //   70: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   73: aload 8
    //   75: astore 9
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 400	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   82: astore 10
    //   84: aload 8
    //   86: astore 9
    //   88: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +48 -> 139
    //   94: aload 8
    //   96: astore 9
    //   98: ldc_w 762
    //   101: iconst_2
    //   102: new 124	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 895
    //   112: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 897
    //   122: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 10
    //   127: getfield 182	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   130: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 8
    //   141: astore 9
    //   143: aload 10
    //   145: getfield 199	com/tencent/mobileqq/data/Friends:groupid	I
    //   148: iconst_m1
    //   149: if_icmpne +341 -> 490
    //   152: aload 8
    //   154: astore 9
    //   156: aload 10
    //   158: iload_2
    //   159: putfield 199	com/tencent/mobileqq/data/Friends:groupid	I
    //   162: iconst_m1
    //   163: istore 5
    //   165: iconst_1
    //   166: istore 7
    //   168: aload 8
    //   170: astore 9
    //   172: aload 10
    //   174: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   177: putfield 406	com/tencent/mobileqq/data/Friends:datetime	J
    //   180: iload_3
    //   181: ifeq +99 -> 280
    //   184: aload 8
    //   186: astore 9
    //   188: aload 10
    //   190: iconst_1
    //   191: putfield 182	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   194: aload 8
    //   196: astore 9
    //   198: aload 10
    //   200: ldc_w 899
    //   203: putfield 784	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   206: aload 8
    //   208: astore 9
    //   210: aload_0
    //   211: aload_0
    //   212: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   215: iconst_1
    //   216: iadd
    //   217: putfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   220: aload 8
    //   222: astore 9
    //   224: aload_0
    //   225: aload 10
    //   227: getfield 279	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   230: invokevirtual 702	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   233: astore 11
    //   235: aload 11
    //   237: ifnull +43 -> 280
    //   240: aload 8
    //   242: astore 9
    //   244: aload 11
    //   246: getfield 902	com/tencent/mobileqq/data/Card:shGender	S
    //   249: ifne +268 -> 517
    //   252: iconst_1
    //   253: istore 4
    //   255: aload 8
    //   257: astore 9
    //   259: aload 10
    //   261: iload 4
    //   263: putfield 669	com/tencent/mobileqq/data/Friends:gender	B
    //   266: aload 8
    //   268: astore 9
    //   270: aload 10
    //   272: aload 11
    //   274: getfield 904	com/tencent/mobileqq/data/Card:age	B
    //   277: putfield 672	com/tencent/mobileqq/data/Friends:age	I
    //   280: aload 8
    //   282: astore 9
    //   284: aload_0
    //   285: aload 10
    //   287: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   290: pop
    //   291: aload 8
    //   293: astore 9
    //   295: aload_0
    //   296: iload_2
    //   297: invokestatic 248	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   300: invokevirtual 507	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   303: astore 10
    //   305: aload 10
    //   307: ifnull +61 -> 368
    //   310: aload 8
    //   312: astore 9
    //   314: aload 10
    //   316: aload 10
    //   318: getfield 226	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   321: iconst_1
    //   322: iadd
    //   323: putfield 226	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   326: aload 8
    //   328: astore 9
    //   330: aload_0
    //   331: aload_1
    //   332: invokevirtual 483	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   335: ifeq +19 -> 354
    //   338: aload 8
    //   340: astore 9
    //   342: aload 10
    //   344: aload 10
    //   346: getfield 510	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   349: iconst_1
    //   350: iadd
    //   351: putfield 510	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   354: aload 8
    //   356: astore 9
    //   358: aload_0
    //   359: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   362: aload 10
    //   364: invokevirtual 551	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   367: pop
    //   368: iload 7
    //   370: ifne +89 -> 459
    //   373: iload 5
    //   375: iflt +84 -> 459
    //   378: iload 5
    //   380: iload_2
    //   381: if_icmpeq +78 -> 459
    //   384: aload 8
    //   386: astore 9
    //   388: aload_0
    //   389: iload 5
    //   391: invokestatic 248	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: invokevirtual 507	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   397: astore 10
    //   399: aload 10
    //   401: ifnull +58 -> 459
    //   404: aload 8
    //   406: astore 9
    //   408: aload 10
    //   410: aload 10
    //   412: getfield 226	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   415: iconst_1
    //   416: isub
    //   417: putfield 226	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   420: aload 8
    //   422: astore 9
    //   424: aload_0
    //   425: aload_1
    //   426: invokevirtual 483	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   429: ifeq +19 -> 448
    //   432: aload 8
    //   434: astore 9
    //   436: aload 10
    //   438: aload 10
    //   440: getfield 510	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   443: iconst_1
    //   444: isub
    //   445: putfield 510	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   448: aload 8
    //   450: astore 9
    //   452: aload_0
    //   453: aload 10
    //   455: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   458: pop
    //   459: aload 8
    //   461: astore 9
    //   463: aload 8
    //   465: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   468: iload 7
    //   470: istore_3
    //   471: aload 8
    //   473: ifnull +11 -> 484
    //   476: aload 8
    //   478: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   481: iload 7
    //   483: istore_3
    //   484: aload_0
    //   485: invokevirtual 306	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   488: iload_3
    //   489: ireturn
    //   490: aload 8
    //   492: astore 9
    //   494: aload 10
    //   496: getfield 199	com/tencent/mobileqq/data/Friends:groupid	I
    //   499: istore 5
    //   501: aload 8
    //   503: astore 9
    //   505: aload 10
    //   507: iload_2
    //   508: putfield 199	com/tencent/mobileqq/data/Friends:groupid	I
    //   511: iconst_0
    //   512: istore 7
    //   514: goto -346 -> 168
    //   517: aload 8
    //   519: astore 9
    //   521: aload 11
    //   523: getfield 902	com/tencent/mobileqq/data/Card:shGender	S
    //   526: istore 6
    //   528: iload 6
    //   530: iconst_1
    //   531: if_icmpne -276 -> 255
    //   534: iconst_2
    //   535: istore 4
    //   537: goto -282 -> 255
    //   540: astore_1
    //   541: aconst_null
    //   542: astore 8
    //   544: iconst_0
    //   545: istore 7
    //   547: aload 8
    //   549: astore 9
    //   551: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +17 -> 571
    //   557: aload 8
    //   559: astore 9
    //   561: ldc 24
    //   563: iconst_2
    //   564: ldc_w 906
    //   567: aload_1
    //   568: invokestatic 502	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   571: iload 7
    //   573: istore_3
    //   574: aload 8
    //   576: ifnull -92 -> 484
    //   579: aload 8
    //   581: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   584: iload 7
    //   586: istore_3
    //   587: goto -103 -> 484
    //   590: astore_1
    //   591: aconst_null
    //   592: astore 9
    //   594: aload 9
    //   596: ifnull +8 -> 604
    //   599: aload 9
    //   601: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   604: aload_1
    //   605: athrow
    //   606: astore_1
    //   607: goto -13 -> 594
    //   610: astore_1
    //   611: iconst_0
    //   612: istore 7
    //   614: goto -67 -> 547
    //   617: astore_1
    //   618: goto -71 -> 547
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	FriendsManager
    //   0	621	1	paramString	String
    //   0	621	2	paramInt	int
    //   0	621	3	paramBoolean	boolean
    //   1	535	4	b1	byte
    //   163	337	5	i	int
    //   526	6	6	j	int
    //   166	447	7	bool	boolean
    //   62	518	8	localEntityTransaction1	EntityTransaction
    //   66	534	9	localEntityTransaction2	EntityTransaction
    //   82	424	10	localObject	Object
    //   233	289	11	localCard	Card
    // Exception table:
    //   from	to	target	type
    //   55	64	540	java/lang/Exception
    //   55	64	590	finally
    //   68	73	606	finally
    //   77	84	606	finally
    //   88	94	606	finally
    //   98	139	606	finally
    //   143	152	606	finally
    //   156	162	606	finally
    //   172	180	606	finally
    //   188	194	606	finally
    //   198	206	606	finally
    //   210	220	606	finally
    //   224	235	606	finally
    //   244	252	606	finally
    //   259	266	606	finally
    //   270	280	606	finally
    //   284	291	606	finally
    //   295	305	606	finally
    //   314	326	606	finally
    //   330	338	606	finally
    //   342	354	606	finally
    //   358	368	606	finally
    //   388	399	606	finally
    //   408	420	606	finally
    //   424	432	606	finally
    //   436	448	606	finally
    //   452	459	606	finally
    //   463	468	606	finally
    //   494	501	606	finally
    //   505	511	606	finally
    //   521	528	606	finally
    //   551	557	606	finally
    //   561	571	606	finally
    //   68	73	610	java/lang/Exception
    //   77	84	610	java/lang/Exception
    //   88	94	610	java/lang/Exception
    //   98	139	610	java/lang/Exception
    //   143	152	610	java/lang/Exception
    //   156	162	610	java/lang/Exception
    //   494	501	610	java/lang/Exception
    //   505	511	610	java/lang/Exception
    //   172	180	617	java/lang/Exception
    //   188	194	617	java/lang/Exception
    //   198	206	617	java/lang/Exception
    //   210	220	617	java/lang/Exception
    //   224	235	617	java/lang/Exception
    //   244	252	617	java/lang/Exception
    //   259	266	617	java/lang/Exception
    //   270	280	617	java/lang/Exception
    //   284	291	617	java/lang/Exception
    //   295	305	617	java/lang/Exception
    //   314	326	617	java/lang/Exception
    //   330	338	617	java/lang/Exception
    //   342	354	617	java/lang/Exception
    //   358	368	617	java/lang/Exception
    //   388	399	617	java/lang/Exception
    //   408	420	617	java/lang/Exception
    //   424	432	617	java/lang/Exception
    //   436	448	617	java/lang/Exception
    //   452	459	617	java/lang/Exception
    //   463	468	617	java/lang/Exception
    //   521	528	617	java/lang/Exception
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      int i = 0;
      while (i < paramInt)
      {
        ContactSorter.a(paramArrayOfFriends[i]);
        a(paramArrayOfFriends[i]);
        i += 1;
      }
      localEntityTransaction.c();
      return true;
    }
    catch (Exception paramArrayOfFriends)
    {
      paramArrayOfFriends.printStackTrace();
      return true;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int b(String paramString)
  {
    int j = 0;
    int i;
    if ((paramString == null) || (paramString.length() == 0)) {
      i = -1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.e == null);
      i = j;
    } while (!this.e.containsKey(paramString));
    return ((Integer)this.e.get(paramString)).intValue();
  }
  
  public Card b(String paramString)
  {
    Card localCard2 = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    Card localCard1 = localCard2;
    if (localCard2 == null)
    {
      localCard1 = new Card();
      localCard1.uin = paramString;
      localCard1.shGender = -1;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard1);
    }
    return localCard1;
  }
  
  public ContactCard b(String paramString)
  {
    ContactCard localContactCard2 = (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = new ContactCard();
      localContactCard1.mobileNo = paramString;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localContactCard1);
    }
    return localContactCard1;
  }
  
  public Friends b(String paramString)
  {
    Friends localFriends2 = c(paramString);
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = paramString;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFriends1);
      a(localFriends1);
    }
    return localFriends1;
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = b(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      ContactSorter.a(localFriends);
      a(localFriends);
      a();
    }
    return localFriends;
  }
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.f.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List b()
  {
    List localList = a();
    if (localList != null) {
      Collections.sort(localList, new hjy(this));
    }
    return localList;
  }
  
  public ConcurrentHashMap b()
  {
    return a(false);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    if (!this.jdField_b_of_type_Boolean) {
      if (!this.jdField_b_of_type_Boolean) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo = (ExtensionInfo)localIterator.next();
          if ((localExtensionInfo != null) && (localExtensionInfo.uin != null)) {
            synchronized (this.d)
            {
              this.d.put(localExtensionInfo.uin, localExtensionInfo);
            }
          }
        }
      }
      this.jdField_b_of_type_Boolean = true;
    }
    QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.d.size());
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected void b(String paramString)
  {
    if (this.h != null) {
      this.h.remove(paramString);
    }
    paramString = b(paramString);
    paramString.groupid = -1;
    a(paramString);
  }
  
  void b(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null) {
      paramString.status = ((byte)paramInt);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
    NearbyPeopleCard localNearbyPeopleCard1 = localNearbyPeopleCard2;
    if (localNearbyPeopleCard2 == null)
    {
      localNearbyPeopleCard1 = new NearbyPeopleCard();
      localNearbyPeopleCard1.uin = paramString1;
    }
    localNearbyPeopleCard1.lastUpdateNickTime = System.currentTimeMillis();
    localNearbyPeopleCard1.nickname = paramString2;
    a(localNearbyPeopleCard1);
    a(localNearbyPeopleCard1);
  }
  
  void b(ArrayList paramArrayList)
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return;
    }
    int j = 0;
    label11:
    Friends localFriends;
    boolean bool;
    label79:
    byte b1;
    label91:
    int k;
    int i;
    if (j < paramArrayList.size())
    {
      RequestPushFStatus localRequestPushFStatus = (RequestPushFStatus)paramArrayList.get(j);
      localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localRequestPushFStatus.lUin + "");
      if (localRequestPushFStatus.uClientType == 99) {
        break label192;
      }
      bool = true;
      if (localRequestPushFStatus.uClientType != 110) {
        break label198;
      }
      b1 = 1;
      k = localRequestPushFStatus.cStatus;
      if (!bool) {
        break label203;
      }
      i = 1;
      label105:
      k += i;
      if ((20 != k) && (21 != k) && (40 != k) && (41 != k)) {
        break label208;
      }
      i = 20;
      label142:
      if (localFriends != null) {
        break label225;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "update Friend status Fail:" + localRequestPushFStatus.lUin);
      }
    }
    for (;;)
    {
      j += 1;
      break label11;
      break;
      label192:
      bool = false;
      break label79;
      label198:
      b1 = 0;
      break label91;
      label203:
      i = 0;
      break label105;
      label208:
      if (b1 == 1)
      {
        i = 11;
        break label142;
      }
      i = 10;
      break label142;
      label225:
      localFriends.status = ((byte)i);
      localFriends.detalStatusFlag = ((byte)k);
      localFriends.isMqqOnLine = bool;
      localFriends.isIphoneOnline = b1;
    }
  }
  
  public void b(ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveRecommGatherList  list size : " + paramArrayList.size());
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramArrayList.iterator();
    Friends localFriends;
    while (((Iterator)localObject2).hasNext())
    {
      localFriends = (Friends)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(localFriends.uin + ",");
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveRecommGatherList : " + ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 2) {
            localFriends.gathtertype = 0;
          }
          a(localFriends);
        }
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 2;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  public void b(List arg1)
  {
    if ((??? == null) || (???.size() == 0)) {}
    for (;;)
    {
      return;
      if (???.size() == 1)
      {
        a((ExtensionInfo)???.get(0));
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject1).a();
      try
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo2 = (ExtensionInfo)localIterator.next();
          if (!TextUtils.isEmpty(localExtensionInfo2.uin)) {
            a(localExtensionInfo2);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.extension", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)localObject1).b();
        for (;;)
        {
          localObject1 = ???.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ExtensionInfo localExtensionInfo1 = (ExtensionInfo)((Iterator)localObject1).next();
            if ((!TextUtils.isEmpty(localExtensionInfo1.uin)) && (this.d != null)) {
              synchronized (this.d)
              {
                this.d.put(localExtensionInfo1.uin, localExtensionInfo1);
              }
            }
          }
          localObject2.c();
          localObject2.b();
        }
      }
      finally
      {
        localObject2.b();
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache begin");
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "initFriendCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    int i;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    label131:
    Friends localFriends;
    if (localObject2 != null)
    {
      i = ((ArrayList)localObject2).size();
      localConcurrentHashMap = new ConcurrentHashMap(i);
      this.jdField_b_of_type_Int = 0;
      localStringBuilder = new StringBuilder();
      new ArrayList();
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label356;
      }
      localArrayList = new ArrayList();
      i = 0;
      if (i >= ((ArrayList)localObject2).size()) {
        break label287;
      }
      localFriends = (Friends)((ArrayList)localObject2).get(i);
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        ContactSorter.a(localFriends);
        localArrayList.add(localFriends);
      }
      localConcurrentHashMap.put(localFriends.uin, localFriends);
      if (localFriends.gathtertype == 1) {
        localStringBuilder.append(localFriends.uin + ";");
      }
      if (localFriends.gathtertype != 2) {
        break label265;
      }
      this.jdField_b_of_type_Int += 1;
    }
    for (;;)
    {
      i += 1;
      break label131;
      i = 0;
      break;
      label265:
      if (localFriends.gathtertype == 1) {
        this.jdField_c_of_type_Int += 1;
      }
    }
    label287:
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      i = 0;
    }
    try
    {
      while (i < localArrayList.size())
      {
        a((Entity)localArrayList.get(i));
        i += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label356:
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "mRecomCount: " + this.jdField_b_of_type_Int + " ; mGatheredCount = " + this.jdField_c_of_type_Int + " ; initFriendCache gathered : " + localStringBuilder);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (localConcurrentHashMap.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((Friends)localIterator.next()).isFriend()) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public Friends c(String paramString)
  {
    Object localObject2;
    if (!f(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      do
      {
        return localObject2;
        localObject2 = a(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.contacttab.", 2, "findFriendEntityByUin from db isFriendCacheInited=" + this.jdField_a_of_type_Boolean + " f=" + localObject2 + " uin=" + paramString);
            localObject1 = localObject2;
          }
        }
        localObject2 = localObject1;
      } while (localObject1 == null);
      localObject2 = localObject1;
    } while (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    return localObject1;
  }
  
  public ArrayList c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      c();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(MayKnowRecommend.class, false, null, null, null, null, null, null);
  }
  
  public ConcurrentHashMap c()
  {
    return a(true);
  }
  
  public void c()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localGroups.group_id + "", localGroups);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList end: " + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hjx(this, paramString));
  }
  
  /* Error */
  public void c(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 447 1 0
    //   10: ifne +19 -> 29
    //   13: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 18
    //   21: iconst_2
    //   22: ldc_w 1015
    //   25: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: return
    //   29: aload_1
    //   30: invokeinterface 447 1 0
    //   35: iconst_1
    //   36: if_icmpne +18 -> 54
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokeinterface 808 2 0
    //   47: checkcast 425	com/tencent/mobileqq/data/SpecialCareInfo
    //   50: invokevirtual 1017	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   53: return
    //   54: aload_0
    //   55: getfield 75	com/tencent/mobileqq/app/FriendsManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: ifnull +73 -> 131
    //   61: aload_0
    //   62: getfield 75	com/tencent/mobileqq/app/FriendsManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: astore_2
    //   66: aload_2
    //   67: monitorenter
    //   68: aload_1
    //   69: invokeinterface 459 1 0
    //   74: astore_3
    //   75: aload_3
    //   76: invokeinterface 170 1 0
    //   81: ifeq +48 -> 129
    //   84: aload_3
    //   85: invokeinterface 174 1 0
    //   90: checkcast 425	com/tencent/mobileqq/data/SpecialCareInfo
    //   93: astore 4
    //   95: aload 4
    //   97: getfield 570	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   100: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne -28 -> 75
    //   106: aload_0
    //   107: getfield 75	com/tencent/mobileqq/app/FriendsManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   110: aload 4
    //   112: getfield 570	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   115: aload 4
    //   117: invokevirtual 215	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: goto -46 -> 75
    //   124: astore_1
    //   125: aload_2
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: aload_2
    //   130: monitorexit
    //   131: aload_0
    //   132: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   135: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   143: aload_1
    //   144: invokeinterface 459 1 0
    //   149: astore_1
    //   150: aload_1
    //   151: invokeinterface 170 1 0
    //   156: ifeq +108 -> 264
    //   159: aload_1
    //   160: invokeinterface 174 1 0
    //   165: checkcast 425	com/tencent/mobileqq/data/SpecialCareInfo
    //   168: astore_3
    //   169: aload_3
    //   170: getfield 570	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   173: invokestatic 315	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne -26 -> 150
    //   179: aload_0
    //   180: aload_3
    //   181: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   184: pop
    //   185: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -38 -> 150
    //   191: ldc 18
    //   193: iconst_2
    //   194: new 124	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 1019
    //   204: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokevirtual 575	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   211: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -70 -> 150
    //   223: astore_1
    //   224: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +32 -> 259
    //   230: ldc 21
    //   232: iconst_2
    //   233: new 124	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 1021
    //   243: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 851	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_2
    //   260: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   263: return
    //   264: aload_2
    //   265: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   268: aload_2
    //   269: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   272: return
    //   273: astore_1
    //   274: aload_2
    //   275: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   278: aload_1
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	FriendsManager
    //   0	280	1	paramList	List
    //   65	210	2	localObject1	Object
    //   74	134	3	localObject2	Object
    //   93	23	4	localSpecialCareInfo	SpecialCareInfo
    // Exception table:
    //   from	to	target	type
    //   68	75	124	finally
    //   75	121	124	finally
    //   125	127	124	finally
    //   129	131	124	finally
    //   143	150	223	java/lang/Exception
    //   150	220	223	java/lang/Exception
    //   264	268	223	java/lang/Exception
    //   143	150	273	finally
    //   150	220	273	finally
    //   224	259	273	finally
    //   264	268	273	finally
  }
  
  public boolean c()
  {
    return (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0));
  }
  
  public boolean c(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.isOnline();
    }
    return false;
  }
  
  public int d()
  {
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return 0;
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() - this.jdField_c_of_type_Int;
  }
  
  public ArrayList d()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)localIterator.next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject1 != null) {
        synchronized (this.g)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject1).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.g.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache end: " + this.g.size());
    }
  }
  
  public void d(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    label276:
    Object localObject4;
    for (Object localObject3 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);; localObject4 = null)
    {
      if (localObject3 != null)
      {
        if (((Friends)localObject3).gathtertype != 2) {
          break label276;
        }
        this.jdField_b_of_type_Int -= 1;
      }
      for (;;)
      {
        try
        {
          localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localEntityTransaction.a();
          Object localObject5 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localObject5 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
          }
          if (localObject5 != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localObject3 = a(String.valueOf(((Friends)localObject5).groupid));
            if (localObject3 != null)
            {
              localObject1 = localEntityTransaction;
              localObject2 = localEntityTransaction;
              ((Groups)localObject3).group_friend_count -= 1;
              localObject1 = localEntityTransaction;
              localObject2 = localEntityTransaction;
              if (((Friends)localObject5).isOnline())
              {
                localObject1 = localEntityTransaction;
                localObject2 = localEntityTransaction;
                ((Groups)localObject3).group_online_friend_count -= 1;
              }
              localObject1 = localEntityTransaction;
              localObject2 = localEntityTransaction;
              a((Entity)localObject3);
            }
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject5);
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localEntityTransaction.c();
        }
        catch (Exception localException)
        {
          EntityTransaction localEntityTransaction;
          localObject2 = localObject1;
          QLog.e("Q.contacttab.", 1, "", localException);
          if (localObject1 == null) {
            continue;
          }
          localObject1.b();
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            continue;
          }
          localObject2.b();
        }
        a();
        if (QvipSpecialCareManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          QvipSpecialCareManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if (QvipSpecialCareManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          QvipSpecialCareManager.c(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        e(paramString);
        return;
        if (((Friends)localObject3).gathtertype == 1) {
          this.jdField_c_of_type_Int -= 1;
        }
      }
    }
  }
  
  /* Error */
  public void d(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 447 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   26: aload_1
    //   27: invokeinterface 459 1 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface 170 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_1
    //   43: invokeinterface 174 1 0
    //   48: checkcast 187	java/lang/String
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 50	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_3
    //   57: invokevirtual 208	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 178	com/tencent/mobileqq/data/Friends
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -32 -> 33
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 182	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 486	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   78: pop
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   84: iconst_1
    //   85: isub
    //   86: putfield 92	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_Int	I
    //   89: goto -56 -> 33
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 778	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   101: aload_0
    //   102: invokevirtual 306	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   105: return
    //   106: aload_2
    //   107: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   110: aload_2
    //   111: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   114: goto -13 -> 101
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	FriendsManager
    //   0	124	1	paramList	List
    //   21	98	2	localEntityTransaction	EntityTransaction
    //   51	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	92	java/lang/Exception
    //   33	64	92	java/lang/Exception
    //   68	89	92	java/lang/Exception
    //   106	110	92	java/lang/Exception
    //   22	33	117	finally
    //   33	64	117	finally
    //   68	89	117	finally
    //   93	97	117	finally
    //   106	110	117	finally
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    long l2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    }
    while (l2 == 0L)
    {
      return false;
      l2 = a().getLong(paramString, 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramString.startsWith("+")) {
          l1 = a().getLong(paramString.replace("+", ""), 0L);
        }
      }
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (paramString.startsWith("+86")) {
          l2 = a().getLong(paramString.replace("+86", ""), 0L);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l2));
    }
    long l1 = System.currentTimeMillis() - l2;
    if ((l1 > 0L) && (l1 < 500654080L)) {
      return true;
    }
    a().edit().remove(paramString).commit();
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
    return false;
  }
  
  public int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  void e()
  {
    c();
    a();
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "deleteSpecialCareInfo: uin=" + paramString);
    }
    SpecialCareInfo localSpecialCareInfo = null;
    if (this.g != null) {}
    synchronized (this.g)
    {
      localSpecialCareInfo = (SpecialCareInfo)this.g.remove(paramString);
      ??? = localSpecialCareInfo;
      if (localSpecialCareInfo == null) {
        ??? = (SpecialCareInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SpecialCareInfo.class, paramString);
      }
      if (??? != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)???);
      }
      return;
    }
  }
  
  public void e(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject == null) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 2) {
          this.jdField_b_of_type_Int -= 1;
        }
        if ((((Friends)localObject).gathtertype != 2) && (((Friends)localObject).gathtertype != 0)) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 0) {
          ((Friends)localObject).recommReason = "手工设置";
        }
        ((Friends)localObject).gathtertype = 1;
        localCard = a(((Friends)localObject).uin);
        if (localCard == null) {
          continue;
        }
        if (localCard.shGender != 0) {
          continue;
        }
        b1 = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Card localCard;
        paramList.printStackTrace();
        localEntityTransaction.b();
        return;
        if (localCard.shGender != 1) {
          break label238;
        }
        b1 = 2;
        continue;
        localEntityTransaction.c();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      ((Friends)localObject).gender = b1;
      ((Friends)localObject).age = localCard.age;
      a((Friends)localObject);
      this.jdField_c_of_type_Int += 1;
      continue;
      label238:
      byte b1 = 0;
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean e(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public void f(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "key : " + str + " ; reason : " + (String)localObject);
        }
      }
    }
  }
  
  /* Error */
  public void g(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 431	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 481	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   12: aload_0
    //   13: getfield 115	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   16: ldc_w 1101
    //   19: invokevirtual 833	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   22: pop
    //   23: aload_1
    //   24: ifnull +67 -> 91
    //   27: aload_1
    //   28: invokeinterface 447 1 0
    //   33: ifle +58 -> 91
    //   36: aload_1
    //   37: invokeinterface 459 1 0
    //   42: astore_1
    //   43: aload_1
    //   44: invokeinterface 170 1 0
    //   49: ifeq +42 -> 91
    //   52: aload_0
    //   53: aload_1
    //   54: invokeinterface 174 1 0
    //   59: checkcast 997	com/tencent/mobileqq/data/MayKnowRecommend
    //   62: invokevirtual 513	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   65: pop
    //   66: goto -23 -> 43
    //   69: astore_1
    //   70: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +13 -> 86
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 1103
    //   82: aload_1
    //   83: invokestatic 1105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   90: return
    //   91: aload_2
    //   92: invokevirtual 522	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   95: aload_2
    //   96: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   99: return
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 504	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	FriendsManager
    //   0	107	1	paramList	List
    //   7	95	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   8	23	69	java/lang/Exception
    //   27	43	69	java/lang/Exception
    //   43	66	69	java/lang/Exception
    //   91	95	69	java/lang/Exception
    //   8	23	100	finally
    //   27	43	100	finally
    //   43	66	100	finally
    //   70	86	100	finally
    //   91	95	100	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManager
 * JD-Core Version:    0.7.0.1
 */