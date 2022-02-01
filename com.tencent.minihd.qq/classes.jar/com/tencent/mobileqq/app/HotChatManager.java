package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import hko;
import hkp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;

public class HotChatManager
  implements Handler.Callback, Runnable, Manager
{
  public static final int a = 1;
  private static Boolean jdField_a_of_type_JavaLangBoolean = null;
  public static final String a = "HotChatManager";
  public static final boolean a = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "CMCC", "CMCC-AUTO", "CMCC-FREE", "ChinaUnicom", "ChinaNet" };
  public static final int b = 2;
  public static final String b = "NOT_SHOW_WIFI_USER_OPERED";
  public static final int c = 3;
  public static final String c = "#";
  public static final int d = 4;
  private static final String d = "hotchat_version";
  public static final int e = 10;
  private static final String e = "KEY_GET_SHELL_TAB_TIME";
  private static final int jdField_f_of_type_Int = 1;
  private static final String jdField_f_of_type_JavaLangString = "KEY_GET_SHELL_TAB_SWITCH";
  private static final int jdField_g_of_type_Int = 5;
  private static final String jdField_g_of_type_JavaLangString = "hotchat_shell_config";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HotChatInfo jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private hkp jdField_a_of_type_Hkp;
  private final Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private boolean b = false;
  
  public HotChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    a();
    e();
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = ((HotChatManager)paramQQAppInterface.getManager(58)).a(paramString);
    if ((paramString != null) && (!paramString.isWifiHotChat))
    {
      switch (paramString.hotThemeGroupFlag)
      {
      default: 
        if (paramString.faceId == 2) {
          return 2130839225;
        }
        break;
      case 1: 
        return 2130839235;
      }
      if (paramString.faceId == 1) {
        return 2130839227;
      }
      if (paramString.faceId == 3) {
        return 2130839230;
      }
      return 2130839227;
    }
    return 2130839232;
  }
  
  private RecentUser a(boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {}
    RecentUserProxy localRecentUserProxy;
    do
    {
      return null;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while (localRecentUserProxy.b(paramHotChatInfo.troopUin, 1) != null);
    RecentUser localRecentUser = a(paramBoolean);
    if (localRecentUser == null) {}
    for (paramHotChatInfo = HotChatInfo.createRecentUser(paramHotChatInfo, false);; paramHotChatInfo = localRecentUser)
    {
      localRecentUserProxy.a(paramHotChatInfo);
      return paramHotChatInfo;
      localRecentUser.troopUin = paramHotChatInfo.troopUin;
      localRecentUser.uin = paramHotChatInfo.troopUin;
    }
  }
  
  public static String a()
  {
    String str;
    try
    {
      Object localObject = ((ConnectivityManager)BaseApplicationImpl.a().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject != null)
      {
        if (!((NetworkInfo)localObject).isConnected()) {
          return null;
        }
        if (((NetworkInfo)localObject).getType() != 1) {
          localObject = null;
        } else {
          localObject = a(((WifiManager)BaseApplicationImpl.a().getSystemService("wifi")).getConnectionInfo());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      str = null;
    }
    return null;
    return str;
  }
  
  public static String a(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      paramWifiInfo = "";
    }
    String str;
    do
    {
      do
      {
        return paramWifiInfo;
        str = paramWifiInfo.getSSID();
        if (str == null) {
          break;
        }
        paramWifiInfo = str;
      } while (!str.startsWith("\""));
      paramWifiInfo = str;
    } while (!str.endsWith("\""));
    return str.substring(1, str.length() - 1);
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getPreferences().edit().putBoolean("NOT_SHOW_WIFI_USER_OPERED", true).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HotChatInfo paramHotChatInfo)
  {
    Object localObject = ((ConnectivityManager)BaseApplicationImpl.a().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {}
    for (;;)
    {
      return;
      if (!paramHotChatInfo.isWifiHotChat) {
        break;
      }
      if (((NetworkInfo)localObject).getType() != 1) {}
      for (localObject = null; (localObject != null) && (((String)localObject).equals(paramHotChatInfo.name)); localObject = a(((WifiManager)BaseApplicationImpl.a().getSystemService("wifi")).getConnectionInfo()))
      {
        ((HotChatHandler)paramQQAppInterface.a(37)).a(HotChatInfo.createWifiPOIInfo(paramHotChatInfo), paramHotChatInfo.isWifiHotChat, 1);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004B5F", "0X8004B5F", 0, 0, "", "", "", "");
        return;
      }
    }
    ((HotChatHandler)paramQQAppInterface.a(37)).a(HotChatInfo.createWifiPOIInfo(paramHotChatInfo), paramHotChatInfo.isWifiHotChat, 1);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004B60", "0X8004B60", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getPreferences().edit();
    localEditor.putBoolean("DOES_SUPPORT_HOT_CHAT", paramBoolean);
    localEditor.commit();
    if (((jdField_a_of_type_JavaLangBoolean == null) || (!jdField_a_of_type_JavaLangBoolean.booleanValue())) && (paramBoolean))
    {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      ((HotChatManager)paramQQAppInterface.getManager(58)).b = true;
      ((HotChatHandler)paramQQAppInterface.a(37)).a();
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "doesSupportHotChat:" + jdField_a_of_type_JavaLangBoolean);
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label40;
      }
      if (paramString.equals(arrayOfString[i])) {
        break;
      }
      i += 1;
    }
    label40:
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "hotchat_shell_config");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      try
      {
        localObject = ((String)localObject).split(":");
        if (paramBoolean)
        {
          if (Integer.parseInt(localObject[1]) != 1) {
            break label65;
          }
          return true;
        }
        int i = Integer.parseInt(localObject[0]);
        if (i != 1) {
          return false;
        }
      }
      catch (Exception localException) {}
    } else {
      return true;
    }
    label65:
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getPreferences().edit();
    localEditor.putBoolean("NOT_SHOW_WIFI_SHELL", paramBoolean);
    if (paramBoolean)
    {
      HotChatRecentUserMgr.a(paramQQAppInterface);
      HotChatRecentUserMgr.b(paramQQAppInterface);
    }
    localEditor.commit();
  }
  
  private void b(HotChatInfo paramHotChatInfo, EntityManager paramEntityManager)
  {
    int i = 0;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004B37", "0X8004B37", 0, 0, "", "", "", "");
    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369523, new Object[] { paramHotChatInfo.name }), false);
    paramHotChatInfo = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if (localHotChatInfo.state == 2) {
        paramHotChatInfo.add(localHotChatInfo);
      }
    }
    int j = paramHotChatInfo.size() - 5;
    if (j > 0)
    {
      Collections.sort(paramHotChatInfo, new hko(this));
      while (i < j)
      {
        paramEntityManager.b((Entity)paramHotChatInfo.get(i));
        i += 1;
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_SHELL", false);
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getPreferences().getBoolean("KEY_GET_SHELL_TAB_SWITCH", paramBoolean);
  }
  
  public static boolean b(String paramString)
  {
    return TextUtils.equals(paramString, AppConstants.aq);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_USER_OPERED", false);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "notShowWiFiUserOpered = " + bool);
    }
    return bool;
  }
  
  private static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    long l = System.currentTimeMillis();
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putLong("KEY_GET_SHELL_TAB_TIME", l);
    paramQQAppInterface.putBoolean("KEY_GET_SHELL_TAB_SWITCH", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  private boolean d()
  {
    return a(false);
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (c(paramQQAppInterface)) {}
    long l;
    do
    {
      return false;
      l = paramQQAppInterface.getPreferences().getLong("KEY_GET_SHELL_TAB_TIME", 0L);
    } while (System.currentTimeMillis() - l <= 86400000L);
    return true;
  }
  
  private void e()
  {
    boolean bool = a().getBoolean("HAS_USING_HOTCHAT", false);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "hasJoinedHotChat = " + bool);
    }
    if ((bool) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        label236:
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if (localHotChatInfo.state != 5) {
            this.jdField_a_of_type_JavaUtilMap.put(localHotChatInfo.troopUin, localHotChatInfo);
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label236;
            }
            QLog.d("HotChatManager", 2, "initCache  HotChatInfo = " + localHotChatInfo);
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) && (TextUtils.equals(localHotChatInfo.name, a())))
            {
              this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = localHotChatInfo;
              if (QLog.isColorLevel()) {
                QLog.d("HotChatManager", 2, "initCache  mWifiShell = " + this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
              }
            }
          }
        }
      }
    }
  }
  
  private boolean e()
  {
    return a(true);
  }
  
  public SharedPreferences a()
  {
    return BaseApplicationImpl.a.getSharedPreferences("Config_Before_load_RU" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
  }
  
  public HotChatInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo;
  }
  
  public HotChatInfo a(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo.isWifiHotChat == paramBoolean) && (localHotChatInfo.state == paramInt)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public HotChatInfo a(String paramString)
  {
    return (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public RecentUser a(boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
        if (localHotChatInfo.isWifiHotChat == paramBoolean)
        {
          localObject2 = localRecentUserProxy.b(localHotChatInfo.troopUin, 1);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
            if (localHotChatInfo.state == 1)
            {
              localHotChatInfo.state = 4;
              ((EntityManager)localObject1).a(localHotChatInfo);
            }
            ((EntityManager)localObject1).a();
            localRecentUserProxy.b((RecentUser)localObject2);
          }
        }
      }
      else
      {
        return localObject2;
      }
    }
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (HotChatInfo)localIterator.next();
        if ((localObject != null) && (((HotChatInfo)localObject).troopCode != null) && (((HotChatInfo)localObject).troopCode.equals(paramString)))
        {
          localObject = ((HotChatInfo)localObject).troopUin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public List a()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences.getInt("hotchat_version", 0) < 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "upgrade version 2");
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      Object localObject2 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = ((RecentUserProxy)localObject1).b(((HotChatInfo)((Iterator)localObject2).next()).troopUin, 1);
        if (localRecentUser != null) {
          ((RecentUserProxy)localObject1).b(localRecentUser);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = (ArrayList)((EntityManager)localObject1).a(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((EntityManager)localObject1).b((Entity)((Iterator)localObject2).next());
        }
      }
      ((EntityManager)localObject1).a();
      HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = null;
      localSharedPreferences.edit().putInt("hotchat_version", 1).commit();
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onJoinedHotChat hc = " + paramHotChatInfo + ", preState:" + paramInt);
    }
    Object localObject;
    if (paramHotChatInfo.isWifiHotChat)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid.equals(paramHotChatInfo.uuid))) {
        this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = null;
      }
      localObject = b();
      if ((localObject != null) && (!TextUtils.equals(paramHotChatInfo.troopUin, ((HotChatInfo)localObject).troopUin))) {
        a((HotChatInfo)localObject, HotChatManager.HotChatStateWrapper.wrap(paramInt));
      }
      HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(true, paramHotChatInfo);
      paramHotChatInfo.state = 0;
      paramHotChatInfo.ruState = 0;
      c(paramHotChatInfo.name);
      this.jdField_a_of_type_JavaUtilMap.put(paramHotChatInfo.troopUin, paramHotChatInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      ((EntityManager)localObject).b(paramHotChatInfo);
      ((EntityManager)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramHotChatInfo.troopUin, paramInt);
      HotChatRecentUserMgr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramHotChatInfo = a().edit();
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        break label295;
      }
    }
    for (;;)
    {
      paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatInfo.commit();
      return;
      localObject = c();
      if ((localObject != null) && (!TextUtils.equals(paramHotChatInfo.troopUin, ((HotChatInfo)localObject).troopUin))) {
        a((HotChatInfo)localObject, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      }
      a(false, paramHotChatInfo);
      break;
      label295:
      bool = false;
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    boolean bool = false;
    int i = paramHotChatStateWrapper.targetState;
    int j = paramHotChatStateWrapper.action;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "onExitHotChat hc = " + paramHotChatInfo + ", ts = " + i + ", action = " + j);
    }
    if (paramHotChatInfo.state == i) {
      return;
    }
    paramHotChatInfo.state = i;
    paramHotChatInfo.leftTime = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (i == 4)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramHotChatInfo.troopUin);
      ((EntityManager)localObject).b(paramHotChatInfo);
      if ((paramHotChatInfo.isWifiHotChat) && (j == 3)) {
        b(paramHotChatInfo.name);
      }
      label147:
      ((EntityManager)localObject).a();
      if ((i != 1) && (i != 2)) {
        break label263;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("HotChatManager", 2, "onExitHotChat no need to clear message");
      }
    }
    for (;;)
    {
      paramHotChatInfo = a().edit();
      if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        bool = true;
      }
      paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatInfo.commit();
      if ((!paramHotChatStateWrapper.hasAction()) || (paramHotChatStateWrapper.action != 1)) {
        break;
      }
      c();
      return;
      ((EntityManager)localObject).a(paramHotChatInfo);
      if (i != 2) {
        break label147;
      }
      b(paramHotChatInfo, (EntityManager)localObject);
      break label147;
      label263:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      RecentUser localRecentUser = ((RecentUserProxy)localObject).b(paramHotChatInfo.troopUin, 1);
      if (localRecentUser != null) {
        ((RecentUserProxy)localObject).b(localRecentUser);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramHotChatInfo.troopUin, 1, true, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i(paramHotChatInfo.troopUin);
      HotChatRecentUserMgr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onExitHotChat message clear done");
      }
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, EntityManager paramEntityManager)
  {
    if (paramHotChatInfo != null) {
      paramEntityManager.b(paramHotChatInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString.ruState = 1;
    localEntityManager.a(paramString);
    localEntityManager.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    HotChatInfo localHotChatInfo = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onPullRecentGroupMsg troopUin = " + paramString + ", doSome:" + paramInt + ", hotChat = " + localHotChatInfo);
    }
    if (localHotChatInfo != null)
    {
      if (paramInt != 2) {
        break label101;
      }
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369524, new Object[] { localHotChatInfo.name }), true);
    }
    label101:
    do
    {
      return;
      if (paramInt == 1)
      {
        HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369525), true);
        return;
      }
    } while (paramInt != 4);
    if (localHotChatInfo.isWifiHotChat)
    {
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369504, new Object[] { localHotChatInfo.name }), true);
      return;
    }
    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369503, new Object[] { localHotChatInfo.name }), true);
  }
  
  final void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    HashSet localHashSet = new HashSet();
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject3 = paramList.iterator();
      paramList = (List)localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (HotChatInfo)((Iterator)localObject3).next();
        if (((HotChatInfo)localObject2).isWifiHotChat)
        {
          if (!QLog.isColorLevel()) {
            break label1116;
          }
          QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newWifiHotChat = " + localObject2);
          localObject1 = localObject2;
        }
        for (;;)
        {
          label112:
          break;
          if (QLog.isColorLevel()) {
            QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newPOIHotChat = " + localObject2);
          }
          paramList = (List)localObject2;
        }
      }
    }
    for (;;)
    {
      localObject3 = a();
      localObject2 = b();
      if (localObject2 == null) {
        localObject2 = c((String)localObject3);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "onGetJoinedHotChatList preWifiHotChat = " + localObject2 + ", ssid = " + (String)localObject3);
        }
        if ((localObject1 != null) && (TextUtils.equals((CharSequence)localObject3, ((HotChatInfo)localObject1).name))) {
          if (localObject2 == null)
          {
            a((HotChatInfo)localObject1, 4);
            localHashSet.add(((HotChatInfo)localObject1).troopUin);
            label259:
            if (paramList == null) {
              break label1002;
            }
            localObject1 = c();
            if ((localObject1 == null) || (!((HotChatInfo)localObject1).troopUin.equals(paramList.troopUin))) {
              break label983;
            }
            ((HotChatInfo)localObject1).state = 0;
            ((HotChatInfo)localObject1).faceId = paramList.faceId;
            ((HotChatInfo)localObject1).isWifiHotChat = paramList.isWifiHotChat;
            ((HotChatInfo)localObject1).memberCount = paramList.memberCount;
            ((HotChatInfo)localObject1).signature = paramList.signature;
            ((HotChatInfo)localObject1).uuid = paramList.uuid;
            ((HotChatInfo)localObject1).name = paramList.name;
            paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
            paramList.a((Entity)localObject1);
            paramList.a();
            label360:
            HotChatRecentUserMgr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramList = a().edit();
            if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
              break label1022;
            }
          }
        }
        label983:
        label1002:
        label1022:
        for (boolean bool = true;; bool = false)
        {
          paramList.putBoolean("HAS_USING_HOTCHAT", bool);
          paramList.commit();
          if (!this.b) {
            break;
          }
          this.b = false;
          localObject1 = a();
          if (!QLog.isColorLevel()) {
            break label1053;
          }
          localObject2 = ((List)localObject1).iterator();
          for (paramList = ""; ((Iterator)localObject2).hasNext(); paramList = paramList + " " + ((HotChatInfo)localObject3).troopUin) {
            localObject3 = (HotChatInfo)((Iterator)localObject2).next();
          }
          if ((TextUtils.equals(((HotChatInfo)localObject2).name, ((HotChatInfo)localObject1).name)) && (((HotChatInfo)localObject2).troopUin.equals(((HotChatInfo)localObject1).troopUin)))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
            ((HotChatInfo)localObject2).state = 0;
            ((HotChatInfo)localObject2).faceId = ((HotChatInfo)localObject1).faceId;
            ((HotChatInfo)localObject2).isWifiHotChat = ((HotChatInfo)localObject1).isWifiHotChat;
            ((HotChatInfo)localObject2).memberCount = ((HotChatInfo)localObject1).memberCount;
            ((HotChatInfo)localObject2).signature = ((HotChatInfo)localObject1).signature;
            ((HotChatInfo)localObject2).uuid = ((HotChatInfo)localObject1).uuid;
            ((HotChatInfo)localObject2).name = ((HotChatInfo)localObject1).name;
            ((HotChatInfo)localObject2).hotThemeGroupFlag = ((HotChatInfo)localObject1).hotThemeGroupFlag;
            ((EntityManager)localObject3).a((Entity)localObject2);
            ((EntityManager)localObject3).a();
            break label259;
          }
          a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT__SWITCH_WIFI);
          ((HotChatInfo)localObject1).state = 0;
          this.jdField_a_of_type_JavaUtilMap.put(((HotChatInfo)localObject1).troopUin, localObject1);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          ((EntityManager)localObject2).b((Entity)localObject1);
          ((EntityManager)localObject2).a();
          break label259;
          if (localObject2 != null)
          {
            if ((localObject1 != null) && (TextUtils.equals(((HotChatInfo)localObject2).troopUin, ((HotChatInfo)localObject1).troopUin)) && (!NetworkUtil.g(BaseApplicationImpl.getContext())))
            {
              ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(37)).a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT__SWITCH_WIFI__ACTION_KEEP_RU);
              break label259;
            }
            if (((HotChatInfo)localObject2).state == 1) {
              break label259;
            }
          }
          HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(37);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject3 = c((String)localObject3);
            if ((localObject3 != null) && ((((HotChatInfo)localObject3).state == 2) || (((HotChatInfo)localObject3).state == 0)))
            {
              if ((((HotChatInfo)localObject3).state == 0) && (TextUtils.equals(((HotChatInfo)localObject3).troopUin, ((HotChatInfo)localObject2).troopUin))) {
                a((HotChatInfo)localObject3, HotChatManager.HotChatStateWrapper.STATE_LEFT__SWITCH_WIFI);
              }
              if (QLog.isColorLevel()) {
                QLog.d("HotChatManager", 2, "onGetJoinedHotChatList join recent hotChatInfo = " + localObject3);
              }
              localHotChatHandler.a(HotChatInfo.createWifiPOIInfo((HotChatInfo)localObject3), true, 2);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004B61", "0X8004B61", 0, 0, "", "", "", "");
              break label259;
            }
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("HotChatManager", 2, "onGetJoinedHotChatList exit and pull shell");
              }
              localHotChatHandler.a((HotChatInfo)localObject1, HotChatManager.HotChatStateWrapper.STATE_SWITCH_WIFI_PULL_SHELL);
              break label259;
            }
            if (localObject2 != null) {
              a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT__SWITCH_WIFI);
            }
            c();
            break label259;
          }
          if (localObject2 != null) {
            a((HotChatInfo)localObject2, HotChatManager.HotChatStateWrapper.STATE_LEFT__SWITCH_WIFI);
          }
          HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break label259;
          a(paramList, 4);
          localHashSet.add(paramList.troopUin);
          break label360;
          paramList = c();
          if (paramList == null) {
            break label360;
          }
          a(paramList, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
          break label360;
        }
        QLog.d("HotChatManager", 2, "troopUin:" + paramList);
        label1053:
        paramList = ((List)localObject1).iterator();
        while (paramList.hasNext())
        {
          localObject1 = (HotChatInfo)paramList.next();
          if ((localObject1 != null) && (!localHashSet.contains(((HotChatInfo)localObject1).troopUin))) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((HotChatInfo)localObject1).troopUin);
          }
        }
        break;
      }
      label1116:
      localObject1 = localObject2;
      break label112;
      paramList = null;
      localObject1 = localObject3;
    }
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_introduce_dialog", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_introduce_dialog", false).commit();
    }
    return bool;
  }
  
  public HotChatInfo b()
  {
    return a(0, true);
  }
  
  public HotChatInfo b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (TextUtils.equals(localHotChatInfo.troopCode, paramString))) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void b()
  {
    b(a().name);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = String.valueOf(paramString.hashCode());
    SharedPreferences localSharedPreferences = a();
    Object localObject = localSharedPreferences.getString("DELETED_WIFI_SHELL_SSID2", "");
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "addShellInRecentDelList readDelList = " + (String)localObject + " pSsid = " + paramString + " pSsidHash = " + str);
    }
    paramString = TextUtils.split((String)localObject, "#");
    localObject = new ArrayList(paramString.length);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(paramString[i]);
      i += 1;
    }
    i = ((List)localObject).indexOf(str);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "addShellInRecentDelList index = " + i + " SHELL_DELETE_LIMIT = " + 10);
    }
    if (i > -1)
    {
      ((List)localObject).remove(i);
      ((List)localObject).add(0, str);
    }
    for (;;)
    {
      paramString = TextUtils.join("#", (Iterable)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "addShellInRecentDelList writeDelList = " + paramString);
      }
      localSharedPreferences.edit().putString("DELETED_WIFI_SHELL_SSID2", paramString).commit();
      return;
      ((List)localObject).add(0, str);
      i = ((List)localObject).size();
      while (i > 10)
      {
        ((List)localObject).remove(i - 1);
        i -= 1;
      }
    }
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_wifi_shell_setting", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_wifi_shell_setting", false).commit();
    }
    return bool;
  }
  
  public HotChatInfo c()
  {
    return a(0, false);
  }
  
  public HotChatInfo c(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (TextUtils.equals(localHotChatInfo.name, paramString))) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void c()
  {
    boolean bool2 = false;
    Object localObject = BaseApplicationImpl.getContext();
    boolean bool1;
    if (b() != null)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("HotChatManager", 2, "reqShell joined");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "<<---reqShell needReq = " + bool1);
      }
      if (bool1)
      {
        this.jdField_a_of_type_Hkp = new hkp(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Hkp, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
        do
        {
          return;
          if (NetworkUtil.g((Context)localObject)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("HotChatManager", 2, "reqShell no wifi");
        return;
        if (c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          if (b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HotChatManager", 2, "reqShell not show msg");
            bool1 = bool2;
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "reqShell no oper");
        }
        localObject = a();
        if (e((String)localObject))
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HotChatManager", 2, "reqShell recent del");
          bool1 = bool2;
          continue;
        }
        localObject = a((String)localObject);
        if ((localObject != null) && (((HotChatInfo)localObject).state == 2))
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HotChatManager", 2, "reqShell recent wifi");
          bool1 = bool2;
        }
      }
      else
      {
        HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      bool1 = true;
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = String.valueOf(paramString.hashCode());
    SharedPreferences localSharedPreferences = a();
    Object localObject = localSharedPreferences.getString("DELETED_WIFI_SHELL_SSID2", "");
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "removeFromRecnetDelList writeDelList = " + (String)localObject + " pSsid = " + paramString + " pSsidHash = " + str);
    }
    paramString = TextUtils.split((String)localObject, "#");
    localObject = new ArrayList(paramString.length);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(paramString[i]);
      i += 1;
    }
    ((List)localObject).remove(str);
    paramString = TextUtils.join("#", (Iterable)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "removeFromRecnetDelList writeDelList = " + paramString);
    }
    localSharedPreferences.edit().putString("DELETED_WIFI_SHELL_SSID2", paramString).commit();
  }
  
  public boolean c()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_hotchat_guide", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_hotchat_guide", false).commit();
    }
    return bool;
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.state == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void d()
  {
    c();
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public boolean e(String paramString)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    String str;
    String[] arrayOfString;
    int j;
    int k;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      str = a().getString("DELETED_WIFI_SHELL_SSID2", "");
      arrayOfString = TextUtils.split(str, "#");
      j = paramString.hashCode();
      k = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      boolean bool1 = bool3;
      if (i < k)
      {
        if (TextUtils.equals(arrayOfString[i], String.valueOf(paramString.hashCode()))) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("HotChatManager", 2, "isShellInRecentDelList readDelList = " + str + " pSsid = " + paramString + ", pSsidHash = " + String.valueOf(j) + " result = " + bool1);
          bool2 = bool1;
        }
        return bool2;
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaLangBoolean = null;
  }
  
  public void run()
  {
    HotChatHandler localHotChatHandler = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(37);
    boolean bool = d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "isNeedRequestShellSwitch = " + bool);
    }
    localHotChatHandler.a(true, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager
 * JD-Core Version:    0.7.0.1
 */