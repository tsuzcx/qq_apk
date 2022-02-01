package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SecMsgSession;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.secmsg.ipc.SecMsgResultReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

@TargetApi(10)
public class SecMsgManager
  implements Manager
{
  public static final int A = -170010;
  public static final int B = -170011;
  public static final int C = -170012;
  public static final int D = -170013;
  private static final int E = 10;
  private static final int F = 15;
  public static final int a = 1;
  public static final long a = 16L;
  public static SecMsgSession a;
  private static final String jdField_a_of_type_JavaLangString = "SecMsgManager";
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  private static final String jdField_b_of_type_JavaLangString = "secmsg_common_config";
  public static final int c = 3;
  private static final String jdField_c_of_type_JavaLangString = "secmsg_";
  public static final int d = 4;
  private static final String jdField_d_of_type_JavaLangString = "sp_key_show_in_pa_list";
  public static final int e = 5;
  private static final String jdField_e_of_type_JavaLangString = "sp_key_sec_msg_shield_list";
  public static final int f = 6;
  private static final String f = "sp_key_sec_msg_last_fetch_seq";
  public static final int g = 7;
  private static final String g = "sp_key_sec_msg_last_msg_time";
  public static final int h = 8;
  private static final String h = "sp_key_forbidden";
  public static final int i = 0;
  private static final String i = "sp_key_in_white_list";
  public static final int j = 1;
  private static final String j = "sp_key_disable";
  public static final int k = 2;
  private static final String k = "sp_key_newest_seq";
  public static final int l = 3;
  private static final String l = "sp_key_feature_state";
  public static final int m = 4;
  private static final String m = "sp_key_is_spread_user";
  public static final int n = 5;
  private static final String n = "sp_key_has_new_msg";
  public static final int o = 6;
  private static final String o = "sp_key_entrance_new_msg";
  public static final int p = 20;
  private static final String p = ",";
  public static final int q = 15;
  private static final String q = "first_install";
  public static final int r = -170001;
  public static final int s = -170002;
  public static final int t = -170003;
  public static final int u = -170004;
  public static final int v = -170005;
  public static final int w = -170006;
  public static final int x = -170007;
  public static final int y = -170008;
  public static final int z = -170009;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SecMsgManager.SecMsgBaseInfo jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public SecMsgResultReceiver a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private long jdField_b_of_type_Long = -1L;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = 0L;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  
  public SecMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_CooperationSecmsgIpcSecMsgResultReceiver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_CooperationSecmsgIpcSecMsgResultReceiver = new SecMsgResultReceiver(paramQQAppInterface, ThreadManager.c());
  }
  
  private String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      String str = (String)paramList.get(i1);
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        if (i1 != i2 - 1) {
          localStringBuilder.append(",");
        }
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List a()
  {
    int i1;
    Object localObject1;
    Object localObject2;
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
      if (!((SharedPreferences)localObject1).contains("sp_key_sec_msg_shield_list")) {
        break label134;
      }
      localObject1 = ((SharedPreferences)localObject1).getString("sp_key_sec_msg_shield_list", null);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label145;
      }
      localObject1 = ((String)localObject1).split(",");
      if (localObject1 == null) {
        break label145;
      }
      localObject2 = Arrays.asList((Object[])localObject1);
      localObject1 = new ArrayList(((List)localObject2).size());
      ((List)localObject1).addAll((Collection)localObject2);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      return localObject2;
      i1 = 0;
      break;
      label134:
      localObject1 = new ArrayList();
      continue;
      label145:
      localObject1 = null;
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 157	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   12: ldc 231
    //   14: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 233
    //   19: invokevirtual 238	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   22: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 240
    //   27: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 4
    //   35: iconst_0
    //   36: istore_3
    //   37: iconst_0
    //   38: istore_2
    //   39: aload_0
    //   40: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   43: aload 4
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 248	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore 4
    //   53: iload_2
    //   54: istore_1
    //   55: aload 4
    //   57: ifnull +28 -> 85
    //   60: iload_2
    //   61: istore_1
    //   62: iload_3
    //   63: istore_2
    //   64: aload 4
    //   66: invokeinterface 254 1 0
    //   71: ifeq +14 -> 85
    //   74: iload_3
    //   75: istore_2
    //   76: aload 4
    //   78: iconst_0
    //   79: invokeinterface 258 2 0
    //   84: istore_1
    //   85: iload_1
    //   86: istore_2
    //   87: aload_0
    //   88: ldc_w 260
    //   91: ldc 155
    //   93: ldc 155
    //   95: ldc_w 262
    //   98: ldc_w 264
    //   101: iconst_0
    //   102: iconst_0
    //   103: iload_1
    //   104: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   107: ldc 155
    //   109: ldc 155
    //   111: ldc 155
    //   113: invokestatic 273	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 4
    //   118: ifnull +415 -> 533
    //   121: aload 4
    //   123: invokeinterface 276 1 0
    //   128: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +29 -> 160
    //   134: ldc 30
    //   136: iconst_2
    //   137: new 157	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 283
    //   147: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_0
    //   161: bipush 55
    //   163: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   166: checkcast 2	com/tencent/mobileqq/app/SecMsgManager
    //   169: astore 5
    //   171: aload 5
    //   173: ifnull -169 -> 4
    //   176: aload 5
    //   178: invokevirtual 295	com/tencent/mobileqq/app/SecMsgManager:a	()Z
    //   181: ifeq +312 -> 493
    //   184: ldc_w 297
    //   187: astore 4
    //   189: aload_0
    //   190: ldc_w 260
    //   193: ldc 155
    //   195: ldc 155
    //   197: ldc_w 262
    //   200: ldc_w 299
    //   203: iconst_0
    //   204: iconst_0
    //   205: ldc 155
    //   207: ldc 155
    //   209: aload 4
    //   211: ldc 155
    //   213: invokestatic 273	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   216: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +33 -> 252
    //   222: ldc 30
    //   224: iconst_2
    //   225: new 157	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 301
    //   235: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 5
    //   240: invokevirtual 295	com/tencent/mobileqq/app/SecMsgManager:a	()Z
    //   243: invokevirtual 304	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   246: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload 5
    //   254: invokevirtual 307	com/tencent/mobileqq/app/SecMsgManager:a	()Lcom/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo;
    //   257: getfield 312	com/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   260: astore 4
    //   262: aload 4
    //   264: ifnonnull +237 -> 501
    //   267: iconst_0
    //   268: istore_1
    //   269: aload_0
    //   270: ldc_w 260
    //   273: ldc 155
    //   275: ldc 155
    //   277: ldc_w 262
    //   280: ldc_w 314
    //   283: iconst_0
    //   284: iconst_0
    //   285: iload_1
    //   286: invokestatic 268	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   289: ldc 155
    //   291: ldc 155
    //   293: ldc 155
    //   295: invokestatic 273	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   298: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +29 -> 330
    //   304: ldc 30
    //   306: iconst_2
    //   307: new 157	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 316
    //   317: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: iload_1
    //   321: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload 5
    //   332: getfield 318	com/tencent/mobileqq/app/SecMsgManager:jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo	Lcom/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo;
    //   335: getfield 320	com/tencent/mobileqq/app/SecMsgManager$SecMsgBaseInfo:jdField_b_of_type_Boolean	Z
    //   338: aload 5
    //   340: getfield 322	com/tencent/mobileqq/app/SecMsgManager:jdField_c_of_type_Boolean	Z
    //   343: ior
    //   344: ifeq +168 -> 512
    //   347: ldc_w 324
    //   350: astore 4
    //   352: aload_0
    //   353: ldc_w 260
    //   356: ldc 155
    //   358: ldc 155
    //   360: ldc_w 262
    //   363: ldc_w 326
    //   366: iconst_0
    //   367: iconst_0
    //   368: ldc 155
    //   370: ldc 155
    //   372: aload 4
    //   374: ldc 155
    //   376: invokestatic 273	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   379: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -378 -> 4
    //   385: ldc 30
    //   387: iconst_2
    //   388: new 157	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 328
    //   398: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 4
    //   403: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: return
    //   413: astore 5
    //   415: aconst_null
    //   416: astore 4
    //   418: iconst_0
    //   419: istore_2
    //   420: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq +33 -> 456
    //   426: ldc 30
    //   428: iconst_2
    //   429: new 157	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 330
    //   439: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 5
    //   444: invokevirtual 333	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   447: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: iload_2
    //   457: istore_1
    //   458: aload 4
    //   460: ifnull -332 -> 128
    //   463: aload 4
    //   465: invokeinterface 276 1 0
    //   470: iload_2
    //   471: istore_1
    //   472: goto -344 -> 128
    //   475: astore_0
    //   476: aconst_null
    //   477: astore 4
    //   479: aload 4
    //   481: ifnull +10 -> 491
    //   484: aload 4
    //   486: invokeinterface 276 1 0
    //   491: aload_0
    //   492: athrow
    //   493: ldc_w 337
    //   496: astore 4
    //   498: goto -309 -> 189
    //   501: aload 4
    //   503: invokeinterface 153 1 0
    //   508: istore_1
    //   509: goto -240 -> 269
    //   512: ldc_w 339
    //   515: astore 4
    //   517: goto -165 -> 352
    //   520: astore_0
    //   521: goto -42 -> 479
    //   524: astore_0
    //   525: goto -46 -> 479
    //   528: astore 5
    //   530: goto -110 -> 420
    //   533: goto -405 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	paramQQAppInterface	QQAppInterface
    //   54	455	1	i1	int
    //   38	433	2	i2	int
    //   36	39	3	i3	int
    //   33	483	4	localObject	Object
    //   169	170	5	localSecMsgManager	SecMsgManager
    //   413	30	5	localException1	java.lang.Exception
    //   528	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   39	53	413	java/lang/Exception
    //   39	53	475	finally
    //   64	74	520	finally
    //   76	85	520	finally
    //   87	116	520	finally
    //   420	456	524	finally
    //   64	74	528	java/lang/Exception
    //   76	85	528	java/lang/Exception
    //   87	116	528	java/lang/Exception
  }
  
  public long a()
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      }
    }
    for (this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).getLong("sp_key_sec_msg_last_fetch_seq", 0L);; this.jdField_b_of_type_Long = 0L)
    {
      return this.jdField_b_of_type_Long;
      i1 = 0;
      break;
    }
  }
  
  public SecMsgManager.SecMsgBaseInfo a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo = new SecMsgManager.SecMsgBaseInfo();
    int i1;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      if (Build.VERSION.SDK_INT > 10)
      {
        i1 = 4;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("sp_key_forbidden", false);
          this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_c_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("sp_key_disable", false);
          this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("sp_key_in_white_list", false);
          this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList = a();
          this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d = ((SharedPreferences)localObject).getInt("sp_key_feature_state", 0);
          this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("sp_key_newest_seq", 0L);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("now getBaseInfo,    mIsForbidden=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean).append(",mIsWhiteUser=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean).append(",mIsDisable=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_c_of_type_Boolean).append(",mNewestSeq=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long).append(",mServerTimestamp=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Long).append(",mFeatureState=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d).append(",mShieldSessionList=").append(this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList);
        QLog.d("SecMsgManager", 2, ((StringBuffer)localObject).toString());
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo;
      i1 = 0;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d = 0;
    }
  }
  
  public void a()
  {
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      SecMsgHandler localSecMsgHandler = (SecMsgHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42);
      if (localSecMsgHandler != null) {
        localSecMsgHandler.a(16L, SecMsgUtil.a());
      }
    }
  }
  
  public void a(SecMsgManager.SecMsgBaseInfo paramSecMsgBaseInfo, long paramLong)
  {
    if (paramSecMsgBaseInfo == null) {
      return;
    }
    int i1;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    if (Build.VERSION.SDK_INT > 10)
    {
      i1 = 4;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
      localEditor = localSharedPreferences.edit();
      if ((paramLong >>> 0 & 1L) != 1L) {
        break label300;
      }
      localEditor.putBoolean("sp_key_forbidden", paramSecMsgBaseInfo.jdField_a_of_type_Boolean);
      label88:
      if ((paramLong >>> 1 & 1L) != 1L) {
        break label338;
      }
      localEditor.putBoolean("sp_key_in_white_list", paramSecMsgBaseInfo.jdField_b_of_type_Boolean);
      label112:
      if ((paramLong >>> 2 & 1L) != 1L) {
        break label376;
      }
      localEditor.putBoolean("sp_key_disable", paramSecMsgBaseInfo.jdField_c_of_type_Boolean);
      label136:
      if ((paramLong >>> 4 & 1L) != 1L) {
        break label414;
      }
      localEditor.putLong("sp_key_newest_seq", paramSecMsgBaseInfo.jdField_a_of_type_Long);
      label160:
      if ((a() < paramSecMsgBaseInfo.jdField_a_of_type_Long) && (paramSecMsgBaseInfo.d == 1) && (!paramSecMsgBaseInfo.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        localEditor.putBoolean("sp_key_is_spread_user", true);
      }
      if ((paramLong >>> 3 & 1L) != 1L) {
        break label452;
      }
      if (paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList != null) {
        localEditor.putString("sp_key_sec_msg_shield_list", a(paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList));
      }
      label245:
      if (((paramLong >>> 5 & 1L) == 1L) && ((paramLong >>> 6 & 1L) != 1L)) {
        break label484;
      }
      localEditor.putInt("sp_key_feature_state", paramSecMsgBaseInfo.d);
    }
    for (;;)
    {
      localEditor.commit();
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo = paramSecMsgBaseInfo;
      return;
      i1 = 0;
      break;
      label300:
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null)
      {
        paramSecMsgBaseInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Boolean;
        break label88;
      }
      paramSecMsgBaseInfo.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("sp_key_forbidden", false);
      break label88;
      label338:
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null)
      {
        paramSecMsgBaseInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean;
        break label112;
      }
      paramSecMsgBaseInfo.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("sp_key_in_white_list", false);
      break label112;
      label376:
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null)
      {
        paramSecMsgBaseInfo.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_c_of_type_Boolean;
        break label136;
      }
      paramSecMsgBaseInfo.jdField_c_of_type_Boolean = localSharedPreferences.getBoolean("sp_key_disable", false);
      break label136;
      label414:
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null)
      {
        paramSecMsgBaseInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long;
        break label160;
      }
      paramSecMsgBaseInfo.jdField_a_of_type_Long = localSharedPreferences.getLong("sp_key_newest_seq", 0L);
      break label160;
      label452:
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null)
      {
        paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList;
        break label245;
      }
      paramSecMsgBaseInfo.jdField_a_of_type_JavaUtilList = a();
      break label245;
      label484:
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null) {
        paramSecMsgBaseInfo.d = this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d;
      } else {
        paramSecMsgBaseInfo.d = localSharedPreferences.getInt("sp_key_feature_state", 0);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramString2 == null)
    {
      paramString2 = "";
      if (paramString3 != null) {
        break label74;
      }
      paramString3 = "";
      label28:
      if (paramString4 != null) {
        break label77;
      }
      paramString4 = "";
      label37:
      if (paramString5 != null) {
        break label80;
      }
      paramString5 = "";
    }
    label74:
    label77:
    label80:
    for (;;)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "AnonyMsg", paramString1, 0, 1, paramString2, paramString3, paramString4, paramString5);
      return;
      break;
      break label28;
      break label37;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgManager", 2, "savePAListConfig, flag=" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_common_config", 0).edit();
      localEditor.putBoolean("sp_key_show_in_pa_list", paramBoolean);
      localEditor.commit();
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
      a();
    }
    return !this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_c_of_type_Boolean;
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecMsgManager", 2, "add secmsg to ru show=" + paramBoolean + ", msgTime=" + paramLong);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecMsgManager", 2, "mApp or app.getProxyManager is null!!");
      }
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(AppConstants.as, 9001);
    if (paramBoolean)
    {
      localRecentUser.uin = AppConstants.as;
      localRecentUser.type = 9001;
      if (localRecentUser.lastmsgtime < paramLong) {
        localRecentUser.lastmsgtime = paramLong;
      }
      ((RecentUserProxy)localObject).a(localRecentUser);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        if (localObject != null) {
          ((Handler)localObject).sendEmptyMessage(1009);
        }
      }
      return true;
      ((RecentUserProxy)localObject).b(localRecentUser);
    }
  }
  
  public long b()
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      if (Build.VERSION.SDK_INT > 10) {
        i1 = 4;
      }
    }
    for (this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).getLong("sp_key_sec_msg_last_msg_time", 0L);; this.jdField_c_of_type_Long = 0L)
    {
      return this.jdField_c_of_type_Long / 1000L;
      i1 = 0;
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo == null) {
      a();
    }
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).edit();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        localEditor.putBoolean("sp_key_is_spread_user", true);
      }
      this.e = true;
      this.d = true;
      localEditor.putBoolean("sp_key_has_new_msg", true);
      localEditor.putBoolean("sp_key_entrance_new_msg", true);
      localEditor.commit();
      return;
    }
  }
  
  public boolean b()
  {
    a();
    return (!this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d != 0);
  }
  
  public boolean c()
  {
    a();
    return (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d == 2) || ((this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.d == 1) && ((this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)));
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i1 = 4;; i1 = 0)
    {
      boolean bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
        {
          SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("secmsg_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1);
          this.d = localSharedPreferences.getBoolean("sp_key_has_new_msg", false);
          this.e = localSharedPreferences.getBoolean("sp_key_entrance_new_msg", false);
          if (!this.d)
          {
            bool1 = bool2;
            if (a() >= this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_Long) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
  }
  
  public boolean e()
  {
    return (this.jdField_b_of_type_Boolean) && (c());
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo.jdField_a_of_type_JavaUtilList = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppSecMsgManager$SecMsgBaseInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SecMsgManager
 * JD-Core Version:    0.7.0.1
 */