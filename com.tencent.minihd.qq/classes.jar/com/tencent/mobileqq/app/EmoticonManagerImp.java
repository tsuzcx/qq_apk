package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import hjd;
import hje;
import hjf;
import hjg;
import hjh;
import hji;
import hjj;
import hjk;
import hjl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonManagerImp
  implements EmoticonManager
{
  public static final String a = "EmoticonManagerImp";
  public static final int c = 2;
  static final int d = 300;
  public int a;
  public QQAppInterface a;
  public EmoticonPackageDownloadListener a;
  public EntityManager a;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new hjd(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(100);
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map a;
  public boolean[] a;
  public int b;
  private DownloadListener jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new hjh(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  LRULinkedHashMap jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(250);
  LRULinkedHashMap c = new LRULinkedHashMap(1000);
  public LRULinkedHashMap d = new LRULinkedHashMap(9000);
  
  public EmoticonManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new hjg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    h();
  }
  
  private EmoticonTab a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class, paramString);
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    ThreadManager.a(new hjk(this, paramLong, paramBoolean));
  }
  
  private boolean a()
  {
    int m = 0;
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ArrayOfBoolean == null)
    {
      localObject1 = FileUtils.a(new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.b.a));
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ArrayOfBoolean = new boolean[8];
        i = 0;
        while (i < this.jdField_a_of_type_ArrayOfBoolean.length)
        {
          this.jdField_a_of_type_ArrayOfBoolean[i] = false;
          i += 1;
        }
        this.jdField_a_of_type_ArrayOfBoolean[1] = true;
      }
    }
    JSONObject localJSONObject;
    Object localObject2;
    label280:
    int k;
    for (;;)
    {
      try
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = new JSONObject((String)localObject1).getJSONObject("data").getJSONArray("vipEmojiKeywordTipsABTest");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = localJSONObject.getString("netEnv");
          if ("4G".equals(localObject2))
          {
            localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
            if (ClubContentJsonTask.a(localJSONObject, str, true)) {
              break label339;
            }
            j = 1;
            break label327;
          }
          if (!"3G".equals(localObject2)) {
            break;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
          if (ClubContentJsonTask.a(localJSONObject, str, true)) {
            break label280;
          }
          j = 1;
          localObject2[3] = j;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonManagerImp", 2, localJSONException.getMessage());
        }
      }
      i = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      int j = m;
      if (i >= 0)
      {
        j = m;
        if (this.jdField_a_of_type_ArrayOfBoolean != null)
        {
          j = m;
          if (i < this.jdField_a_of_type_ArrayOfBoolean.length) {
            j = this.jdField_a_of_type_ArrayOfBoolean[i];
          }
        }
      }
      return j;
      k = 0;
    }
    if ("2G".equals(localObject2))
    {
      localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
      if (!ClubContentJsonTask.a(localJSONObject, localJSONException, true)) {}
      for (k = 1;; k = 0)
      {
        localObject2[2] = k;
        break;
      }
    }
    for (;;)
    {
      label327:
      localObject2[4] = k;
      i += 1;
      break;
      label339:
      k = 0;
    }
  }
  
  private void d(String paramString)
  {
    Process.setThreadPriority(10);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class, EmoticonKeyword.class.getSimpleName(), false, "epId=?", new String[] { paramString }, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          EmoticonKeyword localEmoticonKeyword = (EmoticonKeyword)((Iterator)localObject).next();
          try
          {
            Thread.sleep(300L);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticonKeyword);
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, "asyncRemoveEmotionKeyword,epId=" + paramString);
    }
  }
  
  private void e(String paramString)
  {
    ThreadManager.a(new hjl(this, paramString));
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, "initTabs...start");
    }
    long l = System.currentTimeMillis();
    ??? = EmoticonPackage.class.getSimpleName();
    Object localObject2 = EmoticonTab.class.getSimpleName();
    Object localObject4 = new StringBuffer();
    ((StringBuffer)localObject4).append("select ").append((String)???).append(".* from ").append((String)???).append(" inner join ").append((String)localObject2).append(" on ").append((String)localObject2).append(".epId=").append((String)???).append(".epId order by ").append((String)localObject2).append("._id;");
    ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, ((StringBuffer)localObject4).toString(), null);
    if ((??? == null) || (((ArrayList)???).size() < 1)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = ((ArrayList)???).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (EmoticonPackage)((Iterator)localObject2).next();
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(((EmoticonPackage)localObject4).epId, localObject4);
          this.jdField_a_of_type_JavaUtilArrayList.add(0, ((EmoticonPackage)localObject4).epId);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonManagerImp", 2, "initTabs...end time=" + (System.currentTimeMillis() - l));
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   13: invokevirtual 364	com/tencent/util/LRULinkedHashMap:clear	()V
    //   16: new 31	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 32	java/util/ArrayList:<init>	()V
    //   23: astore 9
    //   25: aload_0
    //   26: getfield 94	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc_w 366
    //   32: iconst_0
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 369	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +79 -> 125
    //   49: aload 7
    //   51: invokeinterface 370 1 0
    //   56: iconst_1
    //   57: isub
    //   58: istore_1
    //   59: iload_1
    //   60: iflt +65 -> 125
    //   63: aload 7
    //   65: iload_1
    //   66: invokeinterface 374 2 0
    //   71: checkcast 366	com/tencent/mobileqq/data/RecentEmotionData
    //   74: astore 10
    //   76: aload 10
    //   78: ifnull +915 -> 993
    //   81: aload 10
    //   83: getfield 377	com/tencent/mobileqq/data/RecentEmotionData:type	I
    //   86: iconst_5
    //   87: if_icmpne +906 -> 993
    //   90: aload_0
    //   91: aload 10
    //   93: getfield 380	com/tencent/mobileqq/data/RecentEmotionData:emoIndex	I
    //   96: invokestatic 384	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   99: aload 10
    //   101: getfield 387	com/tencent/mobileqq/data/RecentEmotionData:emoPath	Ljava/lang/String;
    //   104: invokevirtual 390	com/tencent/mobileqq/app/EmoticonManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/Emoticon;
    //   107: astore 10
    //   109: aload 10
    //   111: ifnull +882 -> 993
    //   114: aload 9
    //   116: aload 10
    //   118: invokevirtual 392	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: goto +871 -> 993
    //   125: aload 9
    //   127: invokevirtual 338	java/util/ArrayList:size	()I
    //   130: istore 4
    //   132: iconst_0
    //   133: istore_1
    //   134: iload_1
    //   135: iload 4
    //   137: if_icmpge +525 -> 662
    //   140: aload 9
    //   142: iload_1
    //   143: invokevirtual 393	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   146: checkcast 395	com/tencent/mobileqq/data/Emoticon
    //   149: astore 10
    //   151: aload 10
    //   153: ifnull +18 -> 171
    //   156: aload 10
    //   158: getfield 398	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   161: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: istore 6
    //   166: iload 6
    //   168: ifeq +10 -> 178
    //   171: iload_1
    //   172: iconst_1
    //   173: iadd
    //   174: istore_1
    //   175: goto -41 -> 134
    //   178: aload 10
    //   180: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   183: ifnull +136 -> 319
    //   186: new 189	org/json/JSONArray
    //   189: dup
    //   190: aload 10
    //   192: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   195: invokespecial 408	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   198: astore 7
    //   200: aload 7
    //   202: invokevirtual 193	org/json/JSONArray:length	()I
    //   205: iconst_1
    //   206: if_icmpge +79 -> 285
    //   209: aload 10
    //   211: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   214: ifnull +25 -> 239
    //   217: aload 10
    //   219: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   222: invokevirtual 412	java/lang/String:length	()I
    //   225: ifle +14 -> 239
    //   228: aload 7
    //   230: aload 10
    //   232: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   235: invokevirtual 415	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   238: pop
    //   239: aload 10
    //   241: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   244: ifnull +41 -> 285
    //   247: aload 10
    //   249: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   252: invokevirtual 412	java/lang/String:length	()I
    //   255: ifle +30 -> 285
    //   258: aload 10
    //   260: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   263: aload 10
    //   265: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   268: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifne +14 -> 285
    //   274: aload 7
    //   276: aload 10
    //   278: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   281: invokevirtual 415	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   284: pop
    //   285: aload 7
    //   287: invokevirtual 193	org/json/JSONArray:length	()I
    //   290: istore 5
    //   292: iconst_0
    //   293: istore_2
    //   294: iload_2
    //   295: iload 5
    //   297: if_icmpge -126 -> 171
    //   300: aload 7
    //   302: iload_2
    //   303: invokevirtual 420	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   306: astore 11
    //   308: aload 11
    //   310: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifeq +18 -> 331
    //   316: goto +684 -> 1000
    //   319: new 189	org/json/JSONArray
    //   322: dup
    //   323: invokespecial 421	org/json/JSONArray:<init>	()V
    //   326: astore 7
    //   328: goto -128 -> 200
    //   331: aload 11
    //   333: invokevirtual 424	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   336: astore 12
    //   338: new 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   341: dup
    //   342: invokespecial 425	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   345: astore 11
    //   347: aload 11
    //   349: aload 10
    //   351: getfield 426	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   354: putfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   357: aload 11
    //   359: aload 10
    //   361: getfield 430	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   364: putfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   367: aload 11
    //   369: aload 10
    //   371: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   374: putfield 432	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   377: aload 11
    //   379: aload 10
    //   381: getfield 398	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   384: putfield 433	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   387: aload 11
    //   389: aload 12
    //   391: putfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   394: aload 11
    //   396: aload 10
    //   398: getfield 438	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   401: putfield 439	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   404: aload 11
    //   406: aload 10
    //   408: getfield 442	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   411: putfield 443	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   414: aload 11
    //   416: aload 10
    //   418: getfield 446	com/tencent/mobileqq/data/Emoticon:width	I
    //   421: putfield 447	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   424: aload 11
    //   426: aload 10
    //   428: getfield 450	com/tencent/mobileqq/data/Emoticon:height	I
    //   431: putfield 451	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   434: aload 11
    //   436: iload_1
    //   437: putfield 454	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   440: aload 11
    //   442: iconst_1
    //   443: putfield 457	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   446: aload_0
    //   447: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   450: aload 12
    //   452: invokevirtual 460	com/tencent/util/LRULinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   455: ifeq +148 -> 603
    //   458: aload_0
    //   459: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   462: aload 11
    //   464: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   467: invokevirtual 463	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   470: checkcast 257	java/util/List
    //   473: astore 12
    //   475: aload 12
    //   477: invokeinterface 370 1 0
    //   482: iconst_2
    //   483: if_icmpge +517 -> 1000
    //   486: aload 12
    //   488: invokeinterface 261 1 0
    //   493: astore 13
    //   495: aload 13
    //   497: invokeinterface 266 1 0
    //   502: ifeq +486 -> 988
    //   505: aload 13
    //   507: invokeinterface 270 1 0
    //   512: checkcast 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   515: astore 14
    //   517: aload 14
    //   519: getfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   522: aload 10
    //   524: getfield 430	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   527: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   530: ifeq -35 -> 495
    //   533: aload 14
    //   535: getfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   538: aload 10
    //   540: getfield 426	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   543: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   546: ifeq -51 -> 495
    //   549: iconst_1
    //   550: istore_3
    //   551: iload_3
    //   552: ifne +448 -> 1000
    //   555: aload 12
    //   557: aload 11
    //   559: invokeinterface 464 2 0
    //   564: pop
    //   565: goto +435 -> 1000
    //   568: astore 7
    //   570: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   573: ifeq -402 -> 171
    //   576: ldc 10
    //   578: iconst_2
    //   579: ldc_w 466
    //   582: aload 7
    //   584: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   587: goto -416 -> 171
    //   590: astore 7
    //   592: aload 7
    //   594: athrow
    //   595: astore 7
    //   597: aload 8
    //   599: monitorexit
    //   600: aload 7
    //   602: athrow
    //   603: new 31	java/util/ArrayList
    //   606: dup
    //   607: invokespecial 32	java/util/ArrayList:<init>	()V
    //   610: astore 12
    //   612: aload 12
    //   614: aload 11
    //   616: invokeinterface 464 2 0
    //   621: pop
    //   622: aload_0
    //   623: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   626: aload 11
    //   628: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   631: aload 12
    //   633: invokevirtual 352	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   636: pop
    //   637: goto +363 -> 1000
    //   640: astore 7
    //   642: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq -474 -> 171
    //   648: ldc 10
    //   650: iconst_2
    //   651: ldc_w 471
    //   654: aload 7
    //   656: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   659: goto -488 -> 171
    //   662: ldc 245
    //   664: invokevirtual 250	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   667: astore 7
    //   669: new 286	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 473
    //   679: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 7
    //   684: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 475
    //   690: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload 7
    //   695: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 477
    //   701: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: astore 7
    //   709: aload_0
    //   710: getfield 94	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   713: ldc 245
    //   715: aload 7
    //   717: aconst_null
    //   718: invokevirtual 335	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   721: checkcast 31	java/util/ArrayList
    //   724: astore 7
    //   726: aload 7
    //   728: ifnull +213 -> 941
    //   731: aload 7
    //   733: invokevirtual 338	java/util/ArrayList:size	()I
    //   736: ifle +205 -> 941
    //   739: aload 7
    //   741: invokevirtual 345	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   744: astore 7
    //   746: aload 7
    //   748: invokeinterface 266 1 0
    //   753: ifeq +188 -> 941
    //   756: aload 7
    //   758: invokeinterface 270 1 0
    //   763: checkcast 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   766: astore 9
    //   768: aload 9
    //   770: getfield 433	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   773: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   776: ifne -30 -> 746
    //   779: aload_0
    //   780: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   783: aload 9
    //   785: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   788: invokevirtual 460	com/tencent/util/LRULinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   791: ifeq +113 -> 904
    //   794: aload_0
    //   795: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   798: aload 9
    //   800: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   803: invokevirtual 463	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   806: checkcast 257	java/util/List
    //   809: astore 10
    //   811: aload 10
    //   813: invokeinterface 261 1 0
    //   818: astore 11
    //   820: aload 11
    //   822: invokeinterface 266 1 0
    //   827: ifeq +156 -> 983
    //   830: aload 11
    //   832: invokeinterface 270 1 0
    //   837: checkcast 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   840: astore 12
    //   842: aload 12
    //   844: getfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   847: aload 9
    //   849: getfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   852: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   855: ifeq -35 -> 820
    //   858: aload 12
    //   860: getfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   863: aload 9
    //   865: getfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   868: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   871: ifeq -51 -> 820
    //   874: iconst_1
    //   875: istore_1
    //   876: aload 10
    //   878: invokeinterface 370 1 0
    //   883: iconst_2
    //   884: if_icmpge -138 -> 746
    //   887: iload_1
    //   888: ifne -142 -> 746
    //   891: aload 10
    //   893: aload 9
    //   895: invokeinterface 464 2 0
    //   900: pop
    //   901: goto -155 -> 746
    //   904: new 31	java/util/ArrayList
    //   907: dup
    //   908: invokespecial 32	java/util/ArrayList:<init>	()V
    //   911: astore 10
    //   913: aload 10
    //   915: aload 9
    //   917: invokeinterface 464 2 0
    //   922: pop
    //   923: aload_0
    //   924: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   927: aload 9
    //   929: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   932: aload 10
    //   934: invokevirtual 352	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   937: pop
    //   938: goto -192 -> 746
    //   941: aload 8
    //   943: monitorexit
    //   944: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   947: ifeq +35 -> 982
    //   950: ldc 10
    //   952: iconst_2
    //   953: new 286	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   960: ldc_w 479
    //   963: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload_0
    //   967: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   970: invokevirtual 480	com/tencent/util/LRULinkedHashMap:size	()I
    //   973: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   976: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   982: return
    //   983: iconst_0
    //   984: istore_1
    //   985: goto -109 -> 876
    //   988: iconst_0
    //   989: istore_3
    //   990: goto -439 -> 551
    //   993: iload_1
    //   994: iconst_1
    //   995: isub
    //   996: istore_1
    //   997: goto -938 -> 59
    //   1000: iload_2
    //   1001: iconst_1
    //   1002: iadd
    //   1003: istore_2
    //   1004: goto -710 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	this	EmoticonManagerImp
    //   58	939	1	i	int
    //   293	711	2	j	int
    //   550	440	3	k	int
    //   130	8	4	m	int
    //   290	8	5	n	int
    //   164	3	6	bool	boolean
    //   42	285	7	localObject1	Object
    //   568	15	7	localJSONException	JSONException
    //   590	3	7	localObject2	Object
    //   595	6	7	localObject3	Object
    //   640	15	7	localException	Exception
    //   667	90	7	localObject4	Object
    //   4	938	8	localLRULinkedHashMap	LRULinkedHashMap
    //   23	905	9	localObject5	Object
    //   74	859	10	localObject6	Object
    //   306	525	11	localObject7	Object
    //   336	523	12	localObject8	Object
    //   493	13	13	localIterator	Iterator
    //   515	19	14	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   178	200	568	org/json/JSONException
    //   200	239	568	org/json/JSONException
    //   239	285	568	org/json/JSONException
    //   285	292	568	org/json/JSONException
    //   300	316	568	org/json/JSONException
    //   319	328	568	org/json/JSONException
    //   331	495	568	org/json/JSONException
    //   495	549	568	org/json/JSONException
    //   555	565	568	org/json/JSONException
    //   603	637	568	org/json/JSONException
    //   178	200	590	finally
    //   200	239	590	finally
    //   239	285	590	finally
    //   285	292	590	finally
    //   300	316	590	finally
    //   319	328	590	finally
    //   331	495	590	finally
    //   495	549	590	finally
    //   555	565	590	finally
    //   570	587	590	finally
    //   603	637	590	finally
    //   642	659	590	finally
    //   9	44	595	finally
    //   49	59	595	finally
    //   63	76	595	finally
    //   81	109	595	finally
    //   114	122	595	finally
    //   125	132	595	finally
    //   140	151	595	finally
    //   156	166	595	finally
    //   592	595	595	finally
    //   597	600	595	finally
    //   662	726	595	finally
    //   731	746	595	finally
    //   746	820	595	finally
    //   820	874	595	finally
    //   876	887	595	finally
    //   891	901	595	finally
    //   904	938	595	finally
    //   941	944	595	finally
    //   178	200	640	java/lang/Exception
    //   200	239	640	java/lang/Exception
    //   239	285	640	java/lang/Exception
    //   285	292	640	java/lang/Exception
    //   300	316	640	java/lang/Exception
    //   319	328	640	java/lang/Exception
    //   331	495	640	java/lang/Exception
    //   495	549	640	java/lang/Exception
    //   555	565	640	java/lang/Exception
    //   603	637	640	java/lang/Exception
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 486	com/tencent/mobileqq/app/EmoticonManagerImp:b	()Ljava/util/List;
    //   6: astore 6
    //   8: aload 6
    //   10: invokeinterface 370 1 0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_1
    //   18: iload_1
    //   19: iload_3
    //   20: if_icmpge +374 -> 394
    //   23: aload 6
    //   25: iload_1
    //   26: invokeinterface 374 2 0
    //   31: checkcast 311	com/tencent/mobileqq/data/EmoticonPackage
    //   34: astore 7
    //   36: aload 7
    //   38: ifnull +278 -> 316
    //   41: aload 7
    //   43: getfield 489	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   46: iconst_2
    //   47: if_icmpne +269 -> 316
    //   50: aload_0
    //   51: aload 7
    //   53: getfield 348	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   56: invokevirtual 492	com/tencent/mobileqq/app/EmoticonManagerImp:a	(Ljava/lang/String;)Ljava/util/List;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnull +253 -> 316
    //   66: aload_0
    //   67: getfield 94	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   70: invokevirtual 495	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   73: astore 5
    //   75: aload 5
    //   77: invokevirtual 499	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   80: aload 8
    //   82: invokeinterface 261 1 0
    //   87: astore 8
    //   89: aload 8
    //   91: invokeinterface 266 1 0
    //   96: ifeq +210 -> 306
    //   99: aload 8
    //   101: invokeinterface 270 1 0
    //   106: checkcast 395	com/tencent/mobileqq/data/Emoticon
    //   109: astore 9
    //   111: aload 9
    //   113: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   116: ifnull -27 -> 89
    //   119: aload 9
    //   121: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   124: invokevirtual 412	java/lang/String:length	()I
    //   127: ifle -38 -> 89
    //   130: new 189	org/json/JSONArray
    //   133: dup
    //   134: aload 9
    //   136: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   139: invokespecial 408	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   142: astore 10
    //   144: aload 10
    //   146: invokevirtual 193	org/json/JSONArray:length	()I
    //   149: istore 4
    //   151: iconst_0
    //   152: istore_2
    //   153: iload_2
    //   154: iload 4
    //   156: if_icmpge -67 -> 89
    //   159: aload 10
    //   161: iload_2
    //   162: invokevirtual 420	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   165: astore 11
    //   167: new 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   170: dup
    //   171: invokespecial 425	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   174: astore 12
    //   176: aload 12
    //   178: aload 9
    //   180: getfield 426	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   183: putfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   186: aload 12
    //   188: aload 9
    //   190: getfield 430	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   193: putfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   196: aload 12
    //   198: aload 9
    //   200: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   203: putfield 432	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   206: aload 12
    //   208: aload 9
    //   210: getfield 398	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   213: putfield 433	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   216: aload 11
    //   218: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +13 -> 234
    //   224: aload 12
    //   226: aload 11
    //   228: invokevirtual 424	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   231: putfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   234: aload 12
    //   236: aload 9
    //   238: getfield 438	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   241: putfield 439	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   244: aload 12
    //   246: aload 9
    //   248: getfield 442	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   251: putfield 443	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   254: aload 12
    //   256: aload 9
    //   258: getfield 446	com/tencent/mobileqq/data/Emoticon:width	I
    //   261: putfield 447	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   264: aload 12
    //   266: aload 9
    //   268: getfield 450	com/tencent/mobileqq/data/Emoticon:height	I
    //   271: putfield 451	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   274: aload 12
    //   276: iload_1
    //   277: putfield 454	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   280: aload 12
    //   282: aload 7
    //   284: getfield 500	com/tencent/mobileqq/data/EmoticonPackage:valid	Z
    //   287: putfield 457	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   290: aload_0
    //   291: getfield 94	com/tencent/mobileqq/app/EmoticonManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   294: aload 12
    //   296: invokevirtual 503	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   299: iload_2
    //   300: iconst_1
    //   301: iadd
    //   302: istore_2
    //   303: goto -150 -> 153
    //   306: aload 5
    //   308: invokevirtual 505	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   311: aload 5
    //   313: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   316: iload_1
    //   317: iconst_1
    //   318: iadd
    //   319: istore_1
    //   320: goto -302 -> 18
    //   323: astore 7
    //   325: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +14 -> 342
    //   331: ldc 10
    //   333: iconst_2
    //   334: ldc_w 509
    //   337: aload 7
    //   339: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: aload 5
    //   344: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   347: goto -31 -> 316
    //   350: astore 5
    //   352: aload_0
    //   353: monitorexit
    //   354: aload 5
    //   356: athrow
    //   357: astore 7
    //   359: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +14 -> 376
    //   365: ldc 10
    //   367: iconst_2
    //   368: ldc_w 511
    //   371: aload 7
    //   373: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   376: aload 5
    //   378: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   381: goto -65 -> 316
    //   384: astore 6
    //   386: aload 5
    //   388: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   391: aload 6
    //   393: athrow
    //   394: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +35 -> 432
    //   400: ldc 10
    //   402: iconst_2
    //   403: new 286	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 513
    //   413: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 6
    //   418: invokeinterface 370 1 0
    //   423: invokevirtual 483	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_0
    //   433: monitorexit
    //   434: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	EmoticonManagerImp
    //   17	303	1	i	int
    //   152	151	2	j	int
    //   15	6	3	k	int
    //   149	8	4	m	int
    //   73	270	5	localEntityTransaction	EntityTransaction
    //   350	37	5	localObject1	Object
    //   6	18	6	localList	List
    //   384	33	6	localObject2	Object
    //   34	249	7	localEmoticonPackage	EmoticonPackage
    //   323	15	7	localJSONException	JSONException
    //   357	15	7	localException	Exception
    //   59	41	8	localObject3	Object
    //   109	158	9	localEmoticon	Emoticon
    //   142	18	10	localJSONArray	JSONArray
    //   165	62	11	str	String
    //   174	121	12	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   75	89	323	org/json/JSONException
    //   89	151	323	org/json/JSONException
    //   159	234	323	org/json/JSONException
    //   234	299	323	org/json/JSONException
    //   306	311	323	org/json/JSONException
    //   2	16	350	finally
    //   23	36	350	finally
    //   41	61	350	finally
    //   66	75	350	finally
    //   311	316	350	finally
    //   342	347	350	finally
    //   376	381	350	finally
    //   386	394	350	finally
    //   394	432	350	finally
    //   75	89	357	java/lang/Exception
    //   89	151	357	java/lang/Exception
    //   159	234	357	java/lang/Exception
    //   234	299	357	java/lang/Exception
    //   306	311	357	java/lang/Exception
    //   75	89	384	finally
    //   89	151	384	finally
    //   159	234	384	finally
    //   234	299	384	finally
    //   306	311	384	finally
    //   325	342	384	finally
    //   359	376	384	finally
  }
  
  public int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.d.containsKey(paramString.toUpperCase())) && (a())) {
      return ((Integer)this.d.get(paramString.toUpperCase())).intValue();
    }
    return 0;
  }
  
  public Emoticon a(String paramString1, String arg2)
  {
    Emoticon localEmoticon = (Emoticon)this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramString1 + "_" + ???);
    Object localObject = localEmoticon;
    if (localEmoticon == null)
    {
      paramString1 = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { paramString1, ??? });
      localObject = paramString1;
      if (paramString1 != null) {
        synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(paramString1.getMapKey(), paramString1);
          return paramString1;
        }
      }
    }
    return localObject;
  }
  
  public EmoticonPackage a(String paramString)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
    ??? = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, paramString);
      ??? = localEmoticonPackage;
      if (localEmoticonPackage != null) {
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString, localEmoticonPackage);
          return localEmoticonPackage;
        }
      }
    }
    return ???;
  }
  
  public List a()
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonPackage.class, false, null, null, null, null, "order_", null);
    if (localArrayList != null)
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
        synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
        {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localEmoticonPackage.epId, localEmoticonPackage);
        }
      }
    }
    return localList;
  }
  
  public List a(String paramString)
  {
    paramString = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, false, "epId=? ", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          try
          {
            synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
            {
              this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(localEmoticon.getMapKey(), localEmoticon);
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    int i;
    do
    {
      return;
      int j = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).f();
      i = j;
      if (j > 2) {
        i = 2;
      }
    } while ((paramInt < 0) && (this.jdField_a_of_type_Int == i));
    Handler localHandler = ThreadManager.a();
    hjj localhjj = new hjj(this, paramInt, i);
    if (paramInt < 0) {}
    for (long l = 0L;; l = 20000L)
    {
      localHandler.postDelayed(localhjj, l);
      return;
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    int i = 0;
    if (paramEmoticon == null) {
      return;
    }
    Object localObject2;
    if (TextUtils.isEmpty(paramEmoticon.encryptKey))
    {
      localObject2 = (Emoticon)this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(paramEmoticon.epId + "_" + paramEmoticon.eId);
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (!TextUtils.isEmpty(((Emoticon)localObject2).encryptKey)) {}
      }
      else
      {
        ??? = (Emoticon)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Emoticon.class, "epId=? and eId=?", new String[] { paramEmoticon.epId, paramEmoticon.eId });
      }
      if ((??? != null) && (TextUtils.isEmpty(((Emoticon)???).encryptKey))) {
        paramEmoticon.encryptKey = ((Emoticon)???).encryptKey;
      }
    }
    Emoticon localEmoticon;
    synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(paramEmoticon.getMapKey(), paramEmoticon);
      if (!(paramEmoticon instanceof EmoticonKeywordForCloud)) {
        break label678;
      }
      localEmoticon = new Emoticon();
      localEmoticon.eId = paramEmoticon.eId;
      localEmoticon.encryptKey = paramEmoticon.encryptKey;
      localEmoticon.epId = paramEmoticon.epId;
      localEmoticon.name = paramEmoticon.name;
      localEmoticon.magicValue = paramEmoticon.magicValue;
      localEmoticon.keywords = paramEmoticon.keywords;
      localEmoticon.keyword = paramEmoticon.keyword;
      localEmoticon.jobType = paramEmoticon.jobType;
      localEmoticon.isSound = paramEmoticon.isSound;
      localEmoticon.height = paramEmoticon.height;
      localEmoticon.value = paramEmoticon.value;
      localEmoticon.width = paramEmoticon.width;
      localEmoticon.setStatus(paramEmoticon.getStatus());
      localEmoticon.setId(paramEmoticon.getId());
      a(localEmoticon);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    try
    {
      ((EntityTransaction)localObject2).a();
      if (localEmoticon.keywords != null) {}
      for (??? = new JSONArray(localEmoticon.keywords);; ??? = new JSONArray())
      {
        if (((JSONArray)???).length() < 1)
        {
          if ((localEmoticon.keyword != null) && (localEmoticon.keyword.length() > 0)) {
            ((JSONArray)???).put(localEmoticon.keyword);
          }
          if ((localEmoticon.name != null) && (localEmoticon.name.length() > 0) && (!localEmoticon.name.equals(localEmoticon.keyword))) {
            ((JSONArray)???).put(localEmoticon.name);
          }
        }
        int j = ((JSONArray)???).length();
        while (i < j)
        {
          String str = ((JSONArray)???).getString(i);
          EmoticonKeyword localEmoticonKeyword = new EmoticonKeyword();
          localEmoticonKeyword.epId = localEmoticon.epId;
          localEmoticonKeyword.eId = localEmoticon.eId;
          localEmoticonKeyword.name = localEmoticon.name;
          localEmoticonKeyword.encryptKey = localEmoticon.encryptKey;
          if (!TextUtils.isEmpty(str)) {
            localEmoticonKeyword.keyword = str.toUpperCase();
          }
          localEmoticonKeyword.isSound = localEmoticon.isSound;
          localEmoticonKeyword.jobType = localEmoticon.jobType;
          localEmoticonKeyword.width = localEmoticon.width;
          localEmoticonKeyword.height = localEmoticon.height;
          localEmoticonKeyword._index = ((EmoticonKeywordForCloud)paramEmoticon)._index;
          localEmoticonKeyword.valid = true;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticonKeyword);
          i += 1;
        }
        paramEmoticon = finally;
        throw paramEmoticon;
      }
      ((EntityTransaction)localObject2).c();
      return;
    }
    catch (JSONException paramEmoticon)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoticonManagerImp", 2, "saveEmoticon json parse error", paramEmoticon);
      }
      return;
    }
    catch (Exception paramEmoticon)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmoticonManagerImp", 2, "saveEmoticon error", paramEmoticon);
      }
      return;
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    label678:
    a(paramEmoticon);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null) {}
    synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramEmoticonPackage.epId, paramEmoticonPackage);
      a(paramEmoticonPackage);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      return;
    }
    EmoticonTab localEmoticonTab = new EmoticonTab();
    localEmoticonTab.epId = paramString;
    this.jdField_a_of_type_JavaUtilArrayList.add(0, paramString);
    a(localEmoticonTab);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramString1 = b(paramString1);
    if (paramString1 != null)
    {
      int i = paramString1.latestVersion;
      paramString1.updateFlag = paramInt2;
      paramString1.updateTip = paramString2;
      paramString1.latestVersion = paramInt1;
      if ((EmoticonUtils.a(paramInt2)) && (i < paramInt1)) {
        paramString1.hasReadUpdatePage = false;
      }
      a(paramString1);
    }
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    paramString = b(paramString);
    if ((paramString != null) && (paramString.hasReadUpdatePage != paramBoolean.booleanValue()))
    {
      paramString.hasReadUpdatePage = paramBoolean.booleanValue();
      a(paramString);
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((EmoticonPackage)paramList.next());
      }
    }
  }
  
  boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public EmoticonPackage b(String paramString)
  {
    if (paramString == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      return null;
    }
    return a(paramString);
  }
  
  public List b()
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    ArrayList localArrayList2 = new ArrayList();
    int j = localArrayList1.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)localArrayList1.get(i);
      if (str != null)
      {
        EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(str);
        EmoticonPackage localEmoticonPackage1 = localEmoticonPackage2;
        if (localEmoticonPackage2 == null) {
          localEmoticonPackage1 = a(str);
        }
        if (localEmoticonPackage1 != null) {
          localArrayList2.add(localEmoticonPackage1);
        }
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public List b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (List)this.c.get(paramString.toUpperCase());
    }
    return null;
  }
  
  public void b()
  {
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    localEmosmHandler.a(new hje(this, localEmosmHandler));
    localEmosmHandler.a(0, 0);
  }
  
  /* Error */
  public void b(Emoticon arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: getfield 398	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   8: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   19: astore 7
    //   21: aload 7
    //   23: monitorenter
    //   24: aload_1
    //   25: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   28: ifnull +127 -> 155
    //   31: new 189	org/json/JSONArray
    //   34: dup
    //   35: aload_1
    //   36: getfield 407	com/tencent/mobileqq/data/Emoticon:keywords	Ljava/lang/String;
    //   39: invokespecial 408	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: aload 5
    //   46: invokevirtual 193	org/json/JSONArray:length	()I
    //   49: iconst_1
    //   50: if_icmpge +71 -> 121
    //   53: aload_1
    //   54: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   57: ifnull +23 -> 80
    //   60: aload_1
    //   61: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   64: invokevirtual 412	java/lang/String:length	()I
    //   67: ifle +13 -> 80
    //   70: aload 5
    //   72: aload_1
    //   73: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   76: invokevirtual 415	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   79: pop
    //   80: aload_1
    //   81: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   84: ifnull +37 -> 121
    //   87: aload_1
    //   88: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   91: invokevirtual 412	java/lang/String:length	()I
    //   94: ifle +27 -> 121
    //   97: aload_1
    //   98: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   101: aload_1
    //   102: getfield 411	com/tencent/mobileqq/data/Emoticon:keyword	Ljava/lang/String;
    //   105: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +13 -> 121
    //   111: aload 5
    //   113: aload_1
    //   114: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   117: invokevirtual 415	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   120: pop
    //   121: aload 5
    //   123: invokevirtual 193	org/json/JSONArray:length	()I
    //   126: istore 4
    //   128: iconst_0
    //   129: istore_2
    //   130: iload_2
    //   131: iload 4
    //   133: if_icmpge +201 -> 334
    //   136: aload 5
    //   138: iload_2
    //   139: invokevirtual 420	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   142: astore 6
    //   144: aload 6
    //   146: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifeq +18 -> 167
    //   152: goto +363 -> 515
    //   155: new 189	org/json/JSONArray
    //   158: dup
    //   159: invokespecial 421	org/json/JSONArray:<init>	()V
    //   162: astore 5
    //   164: goto -120 -> 44
    //   167: aload 6
    //   169: invokevirtual 424	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   172: astore 8
    //   174: aload_1
    //   175: instanceof 245
    //   178: ifeq +166 -> 344
    //   181: aload_1
    //   182: checkcast 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   185: astore 6
    //   187: aload 6
    //   189: aload 8
    //   191: putfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   198: aload 8
    //   200: invokevirtual 460	com/tencent/util/LRULinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   203: ifeq +247 -> 450
    //   206: aload_0
    //   207: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   210: aload 6
    //   212: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   215: invokevirtual 463	com/tencent/util/LRULinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast 257	java/util/List
    //   221: astore 8
    //   223: iconst_0
    //   224: istore_3
    //   225: iload_3
    //   226: aload 8
    //   228: invokeinterface 370 1 0
    //   233: if_icmpge +277 -> 510
    //   236: aload 8
    //   238: iload_3
    //   239: invokeinterface 374 2 0
    //   244: checkcast 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   247: astore 9
    //   249: aload 9
    //   251: getfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   254: aload_1
    //   255: getfield 430	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   258: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifeq +261 -> 522
    //   264: aload 9
    //   266: getfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   269: aload_1
    //   270: getfield 426	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   273: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   276: ifeq +246 -> 522
    //   279: aload 8
    //   281: iload_3
    //   282: invokeinterface 653 2 0
    //   287: pop
    //   288: aload 8
    //   290: iconst_0
    //   291: aload 9
    //   293: invokeinterface 654 3 0
    //   298: iconst_1
    //   299: istore_3
    //   300: iload_3
    //   301: ifne +214 -> 515
    //   304: aload 8
    //   306: iconst_0
    //   307: aload 6
    //   309: invokeinterface 654 3 0
    //   314: goto +201 -> 515
    //   317: astore_1
    //   318: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +13 -> 334
    //   324: ldc 10
    //   326: iconst_2
    //   327: ldc_w 656
    //   330: aload_1
    //   331: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload 7
    //   336: monitorexit
    //   337: return
    //   338: astore_1
    //   339: aload 7
    //   341: monitorexit
    //   342: aload_1
    //   343: athrow
    //   344: new 245	com/tencent/mobileqq/data/EmoticonKeyword
    //   347: dup
    //   348: invokespecial 425	com/tencent/mobileqq/data/EmoticonKeyword:<init>	()V
    //   351: astore 6
    //   353: aload 6
    //   355: aload_1
    //   356: getfield 426	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   359: putfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   362: aload 6
    //   364: aload_1
    //   365: getfield 430	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   368: putfield 431	com/tencent/mobileqq/data/EmoticonKeyword:eId	Ljava/lang/String;
    //   371: aload 6
    //   373: aload_1
    //   374: getfield 418	com/tencent/mobileqq/data/Emoticon:name	Ljava/lang/String;
    //   377: putfield 432	com/tencent/mobileqq/data/EmoticonKeyword:name	Ljava/lang/String;
    //   380: aload 6
    //   382: aload_1
    //   383: getfield 398	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   386: putfield 433	com/tencent/mobileqq/data/EmoticonKeyword:encryptKey	Ljava/lang/String;
    //   389: aload 6
    //   391: aload_1
    //   392: getfield 438	com/tencent/mobileqq/data/Emoticon:isSound	Z
    //   395: putfield 439	com/tencent/mobileqq/data/EmoticonKeyword:isSound	Z
    //   398: aload 6
    //   400: aload_1
    //   401: getfield 442	com/tencent/mobileqq/data/Emoticon:jobType	I
    //   404: putfield 443	com/tencent/mobileqq/data/EmoticonKeyword:jobType	I
    //   407: aload 6
    //   409: aload_1
    //   410: getfield 446	com/tencent/mobileqq/data/Emoticon:width	I
    //   413: putfield 447	com/tencent/mobileqq/data/EmoticonKeyword:width	I
    //   416: aload 6
    //   418: aload_1
    //   419: getfield 450	com/tencent/mobileqq/data/Emoticon:height	I
    //   422: putfield 451	com/tencent/mobileqq/data/EmoticonKeyword:height	I
    //   425: aload 6
    //   427: aload 6
    //   429: getfield 427	com/tencent/mobileqq/data/EmoticonKeyword:epId	Ljava/lang/String;
    //   432: invokestatic 659	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   435: invokevirtual 521	java/lang/Integer:intValue	()I
    //   438: putfield 454	com/tencent/mobileqq/data/EmoticonKeyword:_index	I
    //   441: aload 6
    //   443: iconst_1
    //   444: putfield 457	com/tencent/mobileqq/data/EmoticonKeyword:valid	Z
    //   447: goto -260 -> 187
    //   450: new 31	java/util/ArrayList
    //   453: dup
    //   454: invokespecial 32	java/util/ArrayList:<init>	()V
    //   457: astore 8
    //   459: aload 8
    //   461: aload 6
    //   463: invokeinterface 464 2 0
    //   468: pop
    //   469: aload_0
    //   470: getfield 50	com/tencent/mobileqq/app/EmoticonManagerImp:c	Lcom/tencent/util/LRULinkedHashMap;
    //   473: aload 6
    //   475: getfield 434	com/tencent/mobileqq/data/EmoticonKeyword:keyword	Ljava/lang/String;
    //   478: aload 8
    //   480: invokevirtual 352	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: goto +31 -> 515
    //   487: astore_1
    //   488: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq -157 -> 334
    //   494: ldc 10
    //   496: iconst_2
    //   497: ldc_w 661
    //   500: aload_1
    //   501: invokestatic 469	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   504: goto -170 -> 334
    //   507: astore_1
    //   508: aload_1
    //   509: athrow
    //   510: iconst_0
    //   511: istore_3
    //   512: goto -212 -> 300
    //   515: iload_2
    //   516: iconst_1
    //   517: iadd
    //   518: istore_2
    //   519: goto -389 -> 130
    //   522: iload_3
    //   523: iconst_1
    //   524: iadd
    //   525: istore_3
    //   526: goto -301 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	EmoticonManagerImp
    //   129	390	2	i	int
    //   224	302	3	j	int
    //   126	8	4	k	int
    //   42	121	5	localJSONArray	JSONArray
    //   142	332	6	localObject1	Object
    //   19	321	7	localLRULinkedHashMap	LRULinkedHashMap
    //   172	307	8	localObject2	Object
    //   247	45	9	localEmoticonKeyword	EmoticonKeyword
    // Exception table:
    //   from	to	target	type
    //   24	44	317	org/json/JSONException
    //   44	80	317	org/json/JSONException
    //   80	121	317	org/json/JSONException
    //   121	128	317	org/json/JSONException
    //   136	152	317	org/json/JSONException
    //   155	164	317	org/json/JSONException
    //   167	187	317	org/json/JSONException
    //   187	223	317	org/json/JSONException
    //   225	298	317	org/json/JSONException
    //   304	314	317	org/json/JSONException
    //   344	447	317	org/json/JSONException
    //   450	484	317	org/json/JSONException
    //   334	337	338	finally
    //   339	342	338	finally
    //   508	510	338	finally
    //   24	44	487	java/lang/Exception
    //   44	80	487	java/lang/Exception
    //   80	121	487	java/lang/Exception
    //   121	128	487	java/lang/Exception
    //   136	152	487	java/lang/Exception
    //   155	164	487	java/lang/Exception
    //   167	187	487	java/lang/Exception
    //   187	223	487	java/lang/Exception
    //   225	298	487	java/lang/Exception
    //   304	314	487	java/lang/Exception
    //   344	447	487	java/lang/Exception
    //   450	484	487	java/lang/Exception
    //   24	44	507	finally
    //   44	80	507	finally
    //   80	121	507	finally
    //   121	128	507	finally
    //   136	152	507	finally
    //   155	164	507	finally
    //   167	187	507	finally
    //   187	223	507	finally
    //   225	298	507	finally
    //   304	314	507	finally
    //   318	334	507	finally
    //   344	447	507	finally
    //   450	484	507	finally
    //   488	504	507	finally
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
    EmoticonTab localEmoticonTab = (EmoticonTab)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class, paramString);
    if (localEmoticonTab != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticonTab);
    }
    EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    e(paramString);
  }
  
  public void b(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramString2 = b(paramString1);
    if (paramString2 == null) {
      return;
    }
    paramString2.jsonVersion = paramInt1;
    a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, paramInt1 + "==========KeywordJsonupdate============" + paramString1);
    }
    ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramString2.epId, EmojiManager.d, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a((String)paramList.get(i));
      i -= 1;
    }
    a(true, 300L);
  }
  
  public void c()
  {
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    localEmosmHandler.a(new hjf(this, localEmosmHandler));
    localEmosmHandler.a(0, 0);
  }
  
  public void c(String arg1)
  {
    ??? = (ArrayList)a(???);
    if (??? == null) {
      return;
    }
    Iterator localIterator = ???.iterator();
    while (localIterator.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)localIterator.next();
      synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
      {
        this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.remove(localEmoticon.getMapKey());
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localEmoticon);
      }
    }
  }
  
  public void c(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((Emoticon)paramList.next());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonTab.class.getSimpleName());
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    synchronized (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
    {
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
      synchronized (this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap)
      {
        this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.clear();
      }
    }
    synchronized (this.c)
    {
      this.c.clear();
      return;
      localObject1 = finally;
      throw localObject1;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(EmoticonKeyword.class.getSimpleName());
  }
  
  public void g()
  {
    ThreadManager.a(new hji(this));
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ArrayOfBoolean = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.EmoticonManagerImp
 * JD-Core Version:    0.7.0.1
 */