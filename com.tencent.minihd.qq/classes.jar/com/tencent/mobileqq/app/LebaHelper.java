package com.tencent.mobileqq.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hks;
import hkt;
import hku;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceReqInfoV2;

public class LebaHelper
{
  public static final String a = "qzone_feedlist";
  private static final int jdField_b_of_type_Int = 3;
  public static final String b = "nearby_friends";
  public static final String c = "nearby_troops";
  public static final String d = "com.tx.xingqubuluo.android";
  public static final String e = "hot_chat";
  private static final String f = "LebaHelper";
  private static final String g = "mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.minihd.qq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s";
  private static final String h = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
  private static final String i = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.tencent.mobileqq.troop.activity.NearbyTroopsActivity";
  private static final String j = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=aHR0cDovL3hpYW9xdS5xcS5jb20vbW9iaWxlL2luZGV4Lmh0bWw/X3d2PTEwMjcmX2JpZD0xMjgjZnJvbT1kb25ndGFpJnRhcmdldD1ob3Q=";
  private static final String k = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.tencent.mobileqq.activity.HotChatListActivity";
  private static final String l = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.dataline.activities.LiteActivity";
  private static final String m = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.dataline.activities.PrinterActivity";
  int jdField_a_of_type_Int = 0;
  public QQAppInterface a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  List jdField_a_of_type_JavaUtilList;
  public Set a;
  private ServerConfigObserver jdField_a_of_type_MqqObserverServerConfigObserver = new hks(this);
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  List jdField_b_of_type_JavaUtilList;
  public List c;
  public List d;
  
  public LebaHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(10);
    this.b = new ArrayList(10);
    this.c = new ArrayList(2);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.d = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private Bitmap a(File paramFile)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
    int n = localOptions.outWidth;
    int i1 = localOptions.outHeight;
    if ((n > 300) && (i1 > 300)) {
      localOptions.inSampleSize = 3;
    }
    localOptions.inJustDecodeBounds = false;
    return BitmapManager.a(paramFile.getAbsolutePath(), localOptions);
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.b(paramRunnable);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "Download success icon key = " + paramString);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Map localMap;
    while (localIterator.hasNext())
    {
      localMap = (Map)localIterator.next();
      if (localMap != null)
      {
        String str = (String)localMap.get("KEY");
        if ((str != null) && (str.equals(paramString))) {
          if (!localMap.containsKey("TIME")) {
            break label180;
          }
        }
      }
    }
    label180:
    for (int n = ((Integer)localMap.get("TIME")).intValue();; n = 0)
    {
      if (n >= 3) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localMap);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaHelper", 2, "Download failed icon key = " + paramString + ",time=" + n);
        }
        return;
        n += 1;
        localMap.put("TIME", Integer.valueOf(n));
        localMap.put("LOADING", Boolean.valueOf(false));
      }
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 73	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 233	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 73	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 236	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   25: ldc 238
    //   27: iconst_0
    //   28: invokevirtual 244	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   31: astore_2
    //   32: aload_2
    //   33: new 144	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   40: ldc 246
    //   42: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 73	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: invokevirtual 248	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   52: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: iconst_1
    //   59: invokeinterface 254 3 0
    //   64: ifeq -47 -> 17
    //   67: invokestatic 257	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   70: ifeq +12 -> 82
    //   73: ldc 25
    //   75: iconst_4
    //   76: ldc_w 259
    //   79: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 73	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   86: invokevirtual 262	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   89: invokevirtual 268	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   92: astore_1
    //   93: aload_1
    //   94: bipush 64
    //   96: iconst_0
    //   97: invokestatic 274	com/tencent/mobileqq/data/ResourcePluginInfo:getAll	(Lcom/tencent/mobileqq/persistence/EntityManager;IZ)Ljava/util/List;
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +123 -> 225
    //   105: aload_3
    //   106: invokeinterface 277 1 0
    //   111: astore_3
    //   112: aload_3
    //   113: invokeinterface 166 1 0
    //   118: ifeq +107 -> 225
    //   121: aload_3
    //   122: invokeinterface 170 1 0
    //   127: checkcast 270	com/tencent/mobileqq/data/ResourcePluginInfo
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull -22 -> 112
    //   137: aload 4
    //   139: getfield 281	com/tencent/mobileqq/data/ResourcePluginInfo:cDataType	B
    //   142: iconst_1
    //   143: if_icmpne -31 -> 112
    //   146: aload 4
    //   148: getfield 284	com/tencent/mobileqq/data/ResourcePluginInfo:iPluginType	I
    //   151: bipush 64
    //   153: if_icmpne -41 -> 112
    //   156: aload_1
    //   157: aload 4
    //   159: getfield 287	com/tencent/mobileqq/data/ResourcePluginInfo:strPkgName	Ljava/lang/String;
    //   162: invokestatic 290	com/tencent/mobileqq/data/ResourcePluginInfo:remove	(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;)V
    //   165: goto -53 -> 112
    //   168: astore_3
    //   169: aload_3
    //   170: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   173: aload_1
    //   174: invokevirtual 297	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   177: aload_2
    //   178: invokeinterface 301 1 0
    //   183: astore_1
    //   184: aload_1
    //   185: new 144	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   192: ldc 246
    //   194: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 73	com/tencent/mobileqq/app/LebaHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: invokevirtual 248	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   204: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: iconst_0
    //   211: invokeinterface 307 3 0
    //   216: pop
    //   217: aload_1
    //   218: invokeinterface 310 1 0
    //   223: pop
    //   224: return
    //   225: aload_1
    //   226: invokevirtual 297	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   229: goto -52 -> 177
    //   232: astore_2
    //   233: aload_1
    //   234: invokevirtual 297	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   237: aload_2
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	LebaHelper
    //   92	142	1	localObject1	Object
    //   31	147	2	localSharedPreferences	android.content.SharedPreferences
    //   232	6	2	localObject2	Object
    //   100	22	3	localObject3	Object
    //   168	2	3	localException	Exception
    //   130	28	4	localResourcePluginInfo	ResourcePluginInfo
    // Exception table:
    //   from	to	target	type
    //   93	101	168	java/lang/Exception
    //   105	112	168	java/lang/Exception
    //   112	132	168	java/lang/Exception
    //   137	165	168	java/lang/Exception
    //   93	101	232	finally
    //   105	112	232	finally
    //   112	132	232	finally
    //   137	165	232	finally
    //   169	173	232	finally
  }
  
  private void f()
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "qzone_feedlist";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366548);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_feeds";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 0;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = String.format("mqqapi://app/action?src_type=app&version=1&plg_sid=1&plg_ha3=1&plg_nickname=1&plg_newflag=1&plg_launchtime=1&pkg=com.tencent.minihd.qq&cmp=com.qzone.feed.ui.activity.QZoneFriendFeedActivity&isFromQQ=true&qzone_uin=%s&page=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "tab_qzone" });
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 860;
    this.b.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "nearby_friends";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366537);
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_neighbour";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367678);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.tencent.mobileqq.activity.NearPeopleActivity";
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 270;
    this.b.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = "com.tx.xingqubuluo.android";
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366557);
    localResourcePluginInfo.strResURL = "qb_leba_xingqu_buluo";
    localResourcePluginInfo.strResDesc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366557);
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 1;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.uiResId = 826L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://forward/url?src_type=internal&plg_auth=1&version=1&style=home&url_prefix=aHR0cDovL3hpYW9xdS5xcS5jb20vbW9iaWxlL2luZGV4Lmh0bWw/X3d2PTEwMjcmX2JpZD0xMjgjZnJvbT1kb25ndGFpJnRhcmdldD1ob3Q=";
    localResourcePluginInfo.iPluginType = 64;
    localResourcePluginInfo.sPriority = 0;
    this.b.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = AppConstants.Y;
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366558);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_computer";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 0;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 330;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.dataline.activities.LiteActivity";
    localResourcePluginInfo.iPluginType = 64;
    this.b.add(localResourcePluginInfo);
    localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = AppConstants.Z;
    localResourcePluginInfo.strResName = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131362094);
    localResourcePluginInfo.strResDesc = "";
    localResourcePluginInfo.strResURL = "qq_leba_list_seek_computer";
    localResourcePluginInfo.sResSubType = 2;
    localResourcePluginInfo.cCanChangeState = 1;
    localResourcePluginInfo.cDefaultState = 0;
    localResourcePluginInfo.cLocalState = 0;
    localResourcePluginInfo.cDataType = 1;
    localResourcePluginInfo.isNew = 1;
    localResourcePluginInfo.sLanType = 1;
    localResourcePluginInfo.sPriority = 330;
    localResourcePluginInfo.uiResId = 0L;
    localResourcePluginInfo.strGotoUrl = "mqqapi://app/action?src_type=app&version=1&pkg=com.tencent.minihd.qq&cmp=com.dataline.activities.PrinterActivity";
    localResourcePluginInfo.iPluginType = 64;
    this.b.add(localResourcePluginInfo);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LebaHelper", 2, "error happens: loadAllPlugins while app is null || app is not login");
      }
      return;
    }
    this.b.clear();
    try
    {
      f();
      h();
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "loadServerPlugins");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    Object localObject2 = ResourcePluginInfo.getAll((EntityManager)localObject1, 64, false);
    ((EntityManager)localObject1).a();
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      localObject1 = ((List)localObject2).iterator();
    }
    label205:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResourcePluginInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((ResourcePluginInfo)localObject2).strPkgName != null))
        {
          Iterator localIterator = this.b.iterator();
          ResourcePluginInfo localResourcePluginInfo;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
          } while ((localResourcePluginInfo == null) || (localResourcePluginInfo.strPkgName == null) || (localResourcePluginInfo.strPkgName.compareTo(((ResourcePluginInfo)localObject2).strPkgName) != 0));
        }
      }
      else
      {
        for (int n = 1;; n = 0)
        {
          if (n != 0) {
            break label205;
          }
          this.b.add(localObject2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LebaHelper", 2, "addItem=" + localObject2);
          break;
          return;
        }
      }
    }
  }
  
  private void i()
  {
    Iterator localIterator = new ArrayList(this.c).iterator();
    while (localIterator.hasNext()) {
      ResourcePluginListener.a((ResourcePluginListener)localIterator.next(), (byte)5, 1);
    }
  }
  
  public ResourcePluginInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    List localList = ResourcePluginInfo.getAll((EntityManager)localObject, 64, false);
    ((EntityManager)localObject).a();
    if ((localList != null) && (localList.size() > 0))
    {
      int n = 0;
      while (n < localList.size())
      {
        localObject = (ResourcePluginInfo)localList.get(n);
        if (((ResourcePluginInfo)localObject).uiResId == paramInt) {
          return localObject;
        }
        n += 1;
      }
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "LebaHelper  init");
    }
    a(new hkt(this));
  }
  
  public void a(PluginConfigProxy paramPluginConfigProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "send to get leba config");
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localIterator.next();
        if (localResourcePluginInfo.cDataType == 0)
        {
          GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
          localGetResourceReqInfoV2.cState = 0;
          localGetResourceReqInfoV2.sLanType = localResourcePluginInfo.sLanType;
          localGetResourceReqInfoV2.sResSubType = 0;
          localGetResourceReqInfoV2.strPkgName = localResourcePluginInfo.strPkgName;
          localGetResourceReqInfoV2.uiCurVer = localResourcePluginInfo.uiCurVer;
          localArrayList.add(localGetResourceReqInfoV2);
        }
      }
    }
    HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    if (QLog.isColorLevel()) {
      QLog.d("LebaHelper", 2, "on Get Leba start send: " + localArrayList.size());
    }
    paramPluginConfigProxy.a(64, localArrayList, this.jdField_a_of_type_MqqObserverServerConfigObserver);
  }
  
  public void a(DownloadIconsListener paramDownloadIconsListener)
  {
    if (!this.d.contains(paramDownloadIconsListener)) {
      this.d.add(paramDownloadIconsListener);
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    if (!this.c.contains(paramResourcePluginListener)) {
      this.c.add(paramResourcePluginListener);
    }
  }
  
  public void a(String paramString, URL paramURL, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaHelper", 2, "Download icon for " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hku(this, paramURL, paramFile, paramString));
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.i("LebaHelper", 2, "Download " + paramList.size() + " icons");
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str = (String)localMap.get("KEY");
        paramList = (URL)localMap.get("URL");
        Object localObject = MsfSdkUtils.insertMtype("Dynamic", paramList.toString());
        try
        {
          localObject = new URL((String)localObject);
          paramList = (List)localObject;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
          }
        }
        localObject = (File)localMap.get("FILE");
        if (this.jdField_a_of_type_JavaUtilSet.add(str))
        {
          a(str, paramList, (File)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "Download icon key = " + str);
          }
          localMap.put("LOADING", Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < 3))
    {
      this.jdField_a_of_type_Boolean = false;
      PluginConfigProxy localPluginConfigProxy = new PluginConfigProxy();
      a(localPluginConfigProxy);
      localPluginConfigProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void b(DownloadIconsListener paramDownloadIconsListener)
  {
    this.d.remove(paramDownloadIconsListener);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    this.c.remove(paramResourcePluginListener);
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
      while (localIterator.hasNext())
      {
        Map localMap = (Map)localIterator.next();
        String str;
        Object localObject1;
        if (localMap != null)
        {
          str = (String)localMap.get("KEY");
          localObject1 = (URL)localMap.get("URL");
          localObject2 = MsfSdkUtils.insertMtype("Dynamic", ((URL)localObject1).toString());
        }
        try
        {
          localObject2 = new URL((String)localObject2);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject3;
            QLog.d("LebaHelper", 1, "add mType failed. " + localMalformedURLException, localMalformedURLException);
            continue;
            boolean bool = false;
          }
        }
        Object localObject2 = (File)localMap.get("FILE");
        localObject3 = localMap.get("LOADING");
        if ((localObject3 == null) || (!(localObject3 instanceof Boolean))) {
          break label273;
        }
        bool = ((Boolean)localObject3).booleanValue();
        if ((!TextUtils.isEmpty(str)) && (!bool) && (this.jdField_a_of_type_JavaUtilSet.add(str)))
        {
          a(str, (URL)localObject1, (File)localObject2);
          localMap.put("LOADING", Boolean.valueOf(true));
          if (QLog.isColorLevel()) {
            QLog.d("LebaHelper", 2, "reDownload icon key = " + str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LebaHelper
 * JD-Core Version:    0.7.0.1
 */