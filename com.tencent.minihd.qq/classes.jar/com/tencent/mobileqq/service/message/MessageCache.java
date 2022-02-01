package com.tencent.mobileqq.service.message;

import PushNotifyPack.DisMsgReadedNotify;
import PushNotifyPack.GroupMsgReadedNotify;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jvf;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageCache
{
  public static final int a = 0;
  public static final String a = "recv_msg_notify";
  public static final int b = 1;
  public static final String b = "recv_msg_back_group";
  public static final int c = 2;
  public static final String c = "recv_msg_back_public";
  public static final String d = "recv_msg_back_notify_group";
  public static final String e = "recv_msg_fore_notify_group";
  public static final String f = "recv_msg_fore_num_group";
  public static final String g = "pull_num_group_msg";
  public static final String h = "SendMessageStatistic";
  public static final String i = "RecvMessageStatistic";
  private static String jdField_j_of_type_JavaLangString = "Q.msg.MessageCache";
  private ConcurrentHashMap A = new ConcurrentHashMap();
  private ConcurrentHashMap B = new ConcurrentHashMap();
  private ConcurrentHashMap C = new ConcurrentHashMap();
  private ConcurrentHashMap D = new ConcurrentHashMap();
  private ConcurrentHashMap E = new ConcurrentHashMap();
  private ConcurrentHashMap F = new ConcurrentHashMap();
  private ConcurrentHashMap G = new ConcurrentHashMap();
  private ConcurrentHashMap H = new ConcurrentHashMap();
  private ConcurrentHashMap I = new ConcurrentHashMap();
  private ConcurrentHashMap J = new ConcurrentHashMap();
  private ConcurrentHashMap K = new ConcurrentHashMap();
  private ConcurrentHashMap L = new ConcurrentHashMap();
  private ConcurrentHashMap M = new ConcurrentHashMap();
  private ConcurrentHashMap N = new ConcurrentHashMap();
  private ConcurrentHashMap O = new ConcurrentHashMap();
  private ConcurrentHashMap P = new ConcurrentHashMap();
  private ConcurrentHashMap Q = new ConcurrentHashMap();
  private ConcurrentHashMap R = new ConcurrentHashMap();
  private ConcurrentHashMap S = new ConcurrentHashMap();
  private ConcurrentHashMap T = new ConcurrentHashMap();
  private ConcurrentHashMap U = new ConcurrentHashMap();
  private ConcurrentHashMap V = new ConcurrentHashMap();
  private ConcurrentHashMap W = new ConcurrentHashMap();
  private ConcurrentHashMap X = new ConcurrentHashMap();
  private ConcurrentHashMap Y = new ConcurrentHashMap();
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap a;
  public AtomicInteger a;
  private jvf jdField_a_of_type_Jvf;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = null;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public ConcurrentHashMap b;
  private JSONObject jdField_b_of_type_OrgJsonJSONObject = null;
  private ArrayList c;
  public ConcurrentHashMap c;
  private int d;
  public ConcurrentHashMap d;
  private int jdField_e_of_type_Int = -1;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap f = new ConcurrentHashMap();
  private ConcurrentHashMap g = new ConcurrentHashMap();
  private ConcurrentHashMap h = new ConcurrentHashMap();
  private ConcurrentHashMap i = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_j_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap k = new ConcurrentHashMap();
  private ConcurrentHashMap l = new ConcurrentHashMap();
  private ConcurrentHashMap m = new ConcurrentHashMap();
  private ConcurrentHashMap n = new ConcurrentHashMap();
  private ConcurrentHashMap o = new ConcurrentHashMap();
  private ConcurrentHashMap p = new ConcurrentHashMap();
  private ConcurrentHashMap q = new ConcurrentHashMap();
  private ConcurrentHashMap r = new ConcurrentHashMap();
  private ConcurrentHashMap s = new ConcurrentHashMap();
  private ConcurrentHashMap t = new ConcurrentHashMap();
  private ConcurrentHashMap u = new ConcurrentHashMap();
  private ConcurrentHashMap v = new ConcurrentHashMap();
  private ConcurrentHashMap w = new ConcurrentHashMap();
  private ConcurrentHashMap x = new ConcurrentHashMap();
  private ConcurrentHashMap y = new ConcurrentHashMap();
  private ConcurrentHashMap z = new ConcurrentHashMap();
  
  public MessageCache(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    this.jdField_a_of_type_Jvf = new jvf(this, this.jdField_a_of_type_AndroidContentSharedPreferences.edit());
  }
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  private String a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localStringBuilder.append(paramList.get(i1) + "|");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(paramList.get(i1));
      }
    }
    return localStringBuilder.toString();
  }
  
  private List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString == null) || (paramString.length() == 0)) {
      return localArrayList;
    }
    paramString = paramString.split("\\|");
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramString[i1];
      try
      {
        localArrayList.add(Integer.valueOf(str));
        label59:
        i1 += 1;
      }
      catch (Exception localException)
      {
        break label59;
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        String str;
        if (this.jdField_a_of_type_OrgJsonJSONObject == null)
        {
          str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("sendMessageType", null);
          if ((str == null) || (str.length() == 0)) {
            this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
          }
        }
        else
        {
          return;
        }
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(str);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_OrgJsonJSONObject == null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        String str;
        if (this.jdField_b_of_type_OrgJsonJSONObject == null)
        {
          str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("recvMessageStatistic", null);
          if ((str == null) || (str.length() == 0)) {
            this.jdField_b_of_type_OrgJsonJSONObject = new JSONObject();
          }
        }
        else
        {
          return;
        }
        this.jdField_b_of_type_OrgJsonJSONObject = new JSONObject(str);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_e_of_type_Int == -1) {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("DS_SEND_KEY", 0);
    }
    this.jdField_e_of_type_Int += 1;
    this.jdField_a_of_type_Jvf.putInt("DS_SEND_KEY", this.jdField_e_of_type_Int);
    return this.jdField_e_of_type_Int;
  }
  
  /* Error */
  public int a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokespecial 361	com/tencent/mobileqq/service/message/MessageCache:j	()V
    //   11: iload_3
    //   12: istore_2
    //   13: aload_0
    //   14: getfield 204	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   17: astore 6
    //   19: iload_3
    //   20: istore_2
    //   21: aload 6
    //   23: monitorenter
    //   24: iload 4
    //   26: istore_3
    //   27: aload_0
    //   28: getfield 202	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   31: iload_1
    //   32: invokestatic 364	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   35: invokevirtual 368	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   38: ifeq +137 -> 175
    //   41: iload 4
    //   43: istore_3
    //   44: aload_0
    //   45: getfield 202	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   48: iload_1
    //   49: invokestatic 364	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 371	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   55: istore_2
    //   56: iload_2
    //   57: iconst_0
    //   58: iadd
    //   59: istore_2
    //   60: aload 6
    //   62: monitorexit
    //   63: invokestatic 376	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   66: ifeq +39 -> 105
    //   69: ldc 33
    //   71: iconst_4
    //   72: new 289	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 378
    //   82: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: iload_2
    //   86: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: ldc_w 383
    //   92: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_1
    //   96: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: iload_2
    //   106: ireturn
    //   107: astore 5
    //   109: iload_3
    //   110: istore_2
    //   111: iload_2
    //   112: istore_3
    //   113: aload 6
    //   115: monitorexit
    //   116: aload 5
    //   118: athrow
    //   119: astore 5
    //   121: iload_2
    //   122: istore_3
    //   123: iload_3
    //   124: istore_2
    //   125: invokestatic 389	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq -65 -> 63
    //   131: ldc 33
    //   133: iconst_2
    //   134: new 289	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 391
    //   144: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload_1
    //   148: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc_w 393
    //   154: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: iload_3
    //   166: istore_2
    //   167: goto -104 -> 63
    //   170: astore 5
    //   172: goto -61 -> 111
    //   175: iconst_0
    //   176: istore_2
    //   177: goto -117 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	MessageCache
    //   0	180	1	paramInt	int
    //   6	171	2	i1	int
    //   1	165	3	i2	int
    //   3	39	4	i3	int
    //   107	10	5	localObject1	Object
    //   119	42	5	localException	Exception
    //   170	1	5	localObject2	Object
    //   17	97	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   27	41	107	finally
    //   44	56	107	finally
    //   113	116	107	finally
    //   7	11	119	java/lang/Exception
    //   13	19	119	java/lang/Exception
    //   21	24	119	java/lang/Exception
    //   116	119	119	java/lang/Exception
    //   60	63	170	finally
  }
  
  public int a(String paramString)
  {
    if (!this.P.containsKey(paramString)) {
      this.P.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.P.get(paramString)).intValue();
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt).iterator();
    for (paramInt = 0; paramString.hasNext(); paramInt = Math.max(((Integer)paramString.next()).intValue(), paramInt)) {}
    return paramInt + 1;
  }
  
  public long a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    if (!this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopLastMessageTime" + paramString, 0L);
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
  }
  
  public long a(String paramString, int paramInt)
  {
    String str = MsgProxyUtils.a(paramString, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "getMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + 0);
      }
      return 0L;
    }
    if (!this.G.containsKey(str))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDelMsgLastSeq" + str, 0L);
      this.G.put(str, Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "getMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l1);
      }
    }
    return ((Long)this.G.get(str)).longValue();
  }
  
  public DisMsgReadedNotify a(String paramString)
  {
    return (DisMsgReadedNotify)this.V.remove(paramString);
  }
  
  public GroupMsgReadedNotify a(String paramString)
  {
    return (GroupMsgReadedNotify)this.W.remove(paramString);
  }
  
  public Pair a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      localObject = null;
    }
    Pair localPair;
    do
    {
      return localObject;
      localPair = (Pair)this.n.get(paramString);
      localObject = localPair;
    } while (localPair != null);
    Object localObject = new Pair(Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDisscussionInfoSeq" + paramString, 0L)), Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDisscussionInfoLastTime" + paramString, 0L)));
    this.n.put(paramString, localObject);
    return localObject;
  }
  
  public AppShareID a(String paramString)
  {
    if (!this.X.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      AppShareID localAppShareID = (AppShareID)localEntityManager.a(AppShareID.class, "strPkgName=?", new String[] { paramString });
      if (localAppShareID != null)
      {
        a(paramString, localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Add cache from db appid = " + paramString);
        }
        localEntityManager.a();
      }
    }
    for (;;)
    {
      if (this.X.get(paramString) != AppShareIDUtil.a) {
        break label187;
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Not exist in db appid = " + paramString);
      }
      a(paramString, AppShareIDUtil.a);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Already in cache appid = " + paramString);
      }
    }
    label187:
    return (AppShareID)this.X.get(paramString);
  }
  
  public MessageRecord a(int paramInt, String paramString, long paramLong)
  {
    paramString = String.valueOf(paramInt) + "_" + paramString + "_" + paramLong;
    MessageRecord localMessageRecord = (MessageRecord)this.N.get(paramString);
    this.N.remove(paramString);
    return localMessageRecord;
  }
  
  public OpenID a(String paramString)
  {
    if (!this.Y.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      OpenID localOpenID = (OpenID)localEntityManager.a(OpenID.class, paramString);
      if (localOpenID != null)
      {
        a(paramString, localOpenID);
        if (QLog.isColorLevel()) {
          QLog.d("openid", 2, "Add cache from db appid = " + paramString);
        }
      }
      localEntityManager.a();
    }
    for (;;)
    {
      return (OpenID)this.Y.get(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("openid", 2, "Already in cache appid = " + paramString + ",openid=" + ((OpenID)this.Y.get(paramString)).openID);
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("dumpUnFinishGrpMsgJob : ");
    if (this.h.isEmpty()) {
      localStringBuilder.append("AllFinish.");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      Iterator localIterator = this.h.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("grpUin:").append(str).append(";");
      }
    }
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "crm", 0).getString(paramString + "ext", null);
      if (str == null) {
        return "";
      }
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, str);
    }
    return (String)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a()
  {
    return this.jdField_c_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(long paramLong)
  {
    return (ArrayList)this.R.get(Long.valueOf(paramLong));
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.Q.get(paramString);
  }
  
  public List a(String paramString, int paramInt)
  {
    String str = MsgProxyUtils.a(paramString, paramInt);
    if (!this.s.containsKey(str))
    {
      paramString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getLongMsgIdArray" + MsgProxyUtils.a(paramString, paramInt), "");
      this.s.put(str, a(paramString));
    }
    return (List)this.s.get(str);
  }
  
  public Map a(String paramString, int paramInt)
  {
    String str = MsgProxyUtils.a(paramString, paramInt);
    if ((this.L.containsKey(str)) && (this.L.get(str) != null))
    {
      Map localMap = (Map)this.L.get(str);
      paramString = localMap;
      if (localMap != null)
      {
        paramString = localMap;
        if (localMap.isEmpty())
        {
          this.L.remove(str);
          paramString = null;
        }
      }
      return paramString;
    }
    return null;
  }
  
  public Set a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = MsgProxyUtils.a(paramString1, paramInt);
    if ((this.L.containsKey(paramString1)) && (this.L.get(paramString1) != null))
    {
      paramString1 = (Map)this.L.get(paramString1);
      if ((paramString1 != null) && (paramString1.containsKey(paramString2))) {
        return (Set)paramString1.get(paramString2);
      }
    }
    return null;
  }
  
  public ConcurrentHashMap a()
  {
    return this.P;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "clearDiscNumInfoCache");
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_a_of_type_Jvf.putInt("getlastMessageTime", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "--->>setBuddyMsgLastSeq lastseq = " + paramInt);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.R.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.I.put("last_friend_seq_47", Long.valueOf(paramLong1));
    this.I.put("last_group_seq", Long.valueOf(paramLong2));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str != null)
    {
      this.jdField_a_of_type_Jvf.putLong("last_friend_seq_47" + str, paramLong1).commit();
      this.jdField_a_of_type_Jvf.putLong("last_group_seq" + str, paramLong2).commit();
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    Object localObject1 = localObject2;
    long l1;
    long l2;
    long l3;
    if (localObject2 == null) {
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 20)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        l1 = 0L;
        if (!((Iterator)localObject1).hasNext()) {
          break label232;
        }
        l2 = ((Long)((Iterator)localObject1).next()).longValue();
        l3 = Long.parseLong((String)((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l2))).get(0));
        if (paramLong2 - l3 <= 300L) {
          break label202;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l2));
      localObject1 = new ArrayList();
      if (((ArrayList)localObject1).size() >= 20) {
        ((ArrayList)localObject1).remove(0);
      }
      localObject2 = Long.toString(paramLong2);
      if (((ArrayList)localObject1).size() == 0)
      {
        ((ArrayList)localObject1).add(localObject2);
        label180:
        ((ArrayList)localObject1).add(paramString);
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), localObject1);
        return;
        label202:
        if (l3 >= paramLong2) {
          break label229;
        }
        l1 = l2;
      }
      label229:
      for (;;)
      {
        break;
        ((ArrayList)localObject1).set(0, localObject2);
        break label180;
      }
      label232:
      l2 = l1;
    }
  }
  
  public void a(long paramLong, List paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.R.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.R.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (!paramMessageRecord.isLongMsg()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addOnlineLongMsgFragment longid=" + paramMessageRecord.getLongMsgInfoString());
    }
    Object localObject = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    String str = MsgProxyUtils.a(paramMessageRecord);
    ConcurrentHashMap localConcurrentHashMap;
    if ((this.L.containsKey(localObject)) && (this.L.get(localObject) != null))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.L.get(localObject);
      if (localConcurrentHashMap != null) {
        break label231;
      }
      localConcurrentHashMap = new ConcurrentHashMap();
      this.L.put(localObject, localConcurrentHashMap);
    }
    label231:
    for (;;)
    {
      if (localConcurrentHashMap.containsKey(str))
      {
        localObject = (Set)localConcurrentHashMap.get(str);
        ((Set)localObject).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
        if (paramMessageRecord.longMsgCount > ((Set)localObject).size()) {
          break;
        }
        localConcurrentHashMap.remove(str);
        return;
        localConcurrentHashMap = new ConcurrentHashMap();
        this.L.put(localObject, localConcurrentHashMap);
        continue;
      }
      localObject = new HashSet();
      ((Set)localObject).add(Integer.valueOf(paramMessageRecord.longMsgIndex));
      localConcurrentHashMap.put(str, localObject);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.P.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "setTroopMsgResponseState state: " + paramString + " state: " + paramInt);
      }
      if (paramInt == 2) {
        f(paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1).add(Integer.valueOf(paramInt2));
    if (a(paramString, paramInt1).size() > 50)
    {
      paramInt2 = 0;
      while (paramInt2 < 10)
      {
        a(paramString, paramInt1).remove(0);
        paramInt2 += 1;
      }
    }
    this.jdField_a_of_type_Jvf.putString("getLongMsgIdArray" + MsgProxyUtils.a(paramString, paramInt1), a(a(paramString, paramInt1))).commit();
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    long l1;
    if (paramInt == 1) {
      l1 = Math.max(paramLong, a(paramString));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "addMsgDelLastSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l1);
      }
      this.G.put(MsgProxyUtils.a(paramString, paramInt), Long.valueOf(Math.max(l1, a(paramString, paramInt))));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_Jvf.putLong("getDelMsgLastSeq" + MsgProxyUtils.a(paramString, paramInt), l1).commit();
      }
      return;
      if (paramInt == 3000)
      {
        l1 = Math.max(paramLong, g(paramString));
      }
      else
      {
        List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt);
        l1 = paramLong;
        if (localList != null)
        {
          l1 = paramLong;
          if (!localList.isEmpty()) {
            l1 = Math.max(paramLong, ((MessageRecord)localList.get(localList.size() - 1)).time);
          }
        }
        b(paramString, 0L, 0L);
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = a(paramString1, paramInt);
    if (paramString1 == null) {}
    while (!paramString1.containsKey(paramString2)) {
      return;
    }
    paramString1.remove(paramString2);
  }
  
  public void a(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, a(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addGroupMsgLastSeq " + paramLong);
    }
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getTroopLastMessageTime" + paramString, paramLong);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.n.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_a_of_type_Jvf.putLong("getDisscussionInfoSeq" + paramString, paramLong1);
      this.jdField_a_of_type_Jvf.putLong("getDisscussionInfoLastTime" + paramString, paramLong2);
    }
  }
  
  public void a(String paramString, DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    this.V.put(paramString, paramDisMsgReadedNotify);
  }
  
  public void a(String paramString, GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    this.W.put(paramString, paramGroupMsgReadedNotify);
  }
  
  public void a(String paramString, AppShareID paramAppShareID)
  {
    this.X.put(paramString, paramAppShareID);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "add share appid to cache = " + paramString);
    }
  }
  
  public void a(String paramString, OpenID paramOpenID)
  {
    this.Y.put(paramString, paramOpenID);
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "add openid to cache = " + paramOpenID);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "crm", 0).edit();
        localEditor.putString(paramString1 + "ext", paramString2);
        localEditor.commit();
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addWpaMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.t.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.t.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        paramArrayOfByte = HexUtil.a(paramArrayOfByte);
        this.jdField_a_of_type_Jvf.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.Q.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.Q.put(paramString, localArrayList1);
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 389	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +42 -> 47
    //   8: getstatic 94	com/tencent/mobileqq/service/message/MessageCache:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   11: astore_3
    //   12: new 289	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 742
    //   22: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: astore 4
    //   27: aload_1
    //   28: ifnonnull +31 -> 59
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_3
    //   34: iconst_2
    //   35: aload 4
    //   37: iload_2
    //   38: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: getfield 125	com/tencent/mobileqq/service/message/MessageCache:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: aload_1
    //   52: invokevirtual 637	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   55: pop
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: aload_1
    //   60: invokeinterface 294 1 0
    //   65: istore_2
    //   66: goto -33 -> 33
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	MessageCache
    //   0	74	1	paramList	List
    //   32	34	2	i1	int
    //   11	23	3	str	String
    //   25	11	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	27	69	finally
    //   33	47	69	finally
    //   47	56	69	finally
    //   59	66	69	finally
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      String str = HexUtil.a(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "--->>setLastSyncCookie lastSyncCookie:" + str);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "--->>setBuddyMsgLastSeq cookie = " + HexUtil.a(paramArrayOfByte));
      }
      this.jdField_a_of_type_Jvf.putString("getMsgV4_vSyncCookie", str);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("removeDiscPullSeqCache, uinArray: ");
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        localStringBuilder.append(str).append(",");
        if (this.l.containsKey(str)) {
          this.l.remove(str);
        }
        i1 += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_j_of_type_JavaLangString, 2, localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    paramString = String.valueOf(paramInt) + "_" + paramString + "_" + paramLong;
    return this.N.containsKey(paramString);
  }
  
  public boolean a(long paramLong, String paramString)
  {
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return false;
    }
    localObject = ((ArrayList)localObject).iterator();
    ((Iterator)localObject).next();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals((String)((Iterator)localObject).next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.istroop, MsgProxyUtils.a(paramMessageRecord));
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = a(paramString, paramInt1).iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() == paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_j_of_type_JavaLangString, 2, "long msg id is exist! uin=" + paramString + ",istroop=" + paramInt1 + ",longMsgID=" + paramInt2);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = a(paramString1, paramInt);
    if (paramString1 == null) {
      return false;
    }
    if (paramString1.containsKey(paramString2))
    {
      if (((Set)paramString1.get(paramString2)).isEmpty())
      {
        paramString1.remove(paramString2);
        return false;
      }
      return true;
    }
    return false;
  }
  
  public byte[] a()
  {
    String str;
    if (((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null))
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("getMsgV4_vSyncCookie", "");
      if (str.length() != 0) {
        break label97;
      }
    }
    label97:
    for (this.jdField_a_of_type_ArrayOfByte = null;; this.jdField_a_of_type_ArrayOfByte = HexUtil.a(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "--->>getLastSyncCookie lastSyncCookie:" + HexUtil.a(this.jdField_a_of_type_ArrayOfByte));
      }
      return this.jdField_a_of_type_ArrayOfByte;
    }
  }
  
  public byte[] a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {}
    do
    {
      return null;
      if (this.y.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "pub", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.a((String)localObject);
    this.y.put(paramString, localObject);
    return (byte[])this.y.get(paramString);
  }
  
  public Object[] a(String paramString)
  {
    if (this.g.containsKey(paramString)) {
      return (Object[])this.g.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionMemberSeq" + paramString, -1L);
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionConfigSeq" + paramString, -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  public int b()
  {
    if ((this.jdField_d_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("getlastMessageTime", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "--->>getBuddyMsgLastSeq: " + this.jdField_d_of_type_Int);
    }
    return this.jdField_d_of_type_Int;
  }
  
  public int b(String paramString)
  {
    if (!this.T.containsKey(paramString)) {
      this.T.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.T.get(paramString)).intValue();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    if (!this.jdField_j_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopExpiredSeq" + paramString, 0L);
      this.jdField_j_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.jdField_j_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
  }
  
  public long b(String paramString, int paramInt)
  {
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "getBreakPointSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + 0);
      }
      return 0L;
    }
    if (!this.J.containsKey(localPair))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getBreakPointSeq" + paramString + "_" + paramInt, 0L);
      this.J.put(localPair, Long.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "getBreakPointSeq uin = " + paramString + ",type = " + paramInt + " , lastSeqId = " + l1);
      }
    }
    return ((Long)this.J.get(localPair)).longValue();
  }
  
  public Pair b(String paramString)
  {
    paramString = MD5.toMD5(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return null;
    }
    if (!this.o.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getC2CLastMessageTime" + paramString, 0L);
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getC2CLastMessageTimeRand" + paramString, 0L);
      this.o.put(paramString, new Pair(Long.valueOf(l1), Long.valueOf(l2)));
    }
    return (Pair)this.o.get(paramString);
  }
  
  public OpenID b(String paramString)
  {
    return (OpenID)this.Y.get(paramString);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("dumpUnFinishDisMsgJob : ");
    if (this.i.isEmpty()) {
      localStringBuilder.append("AllFinish.");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      Iterator localIterator = this.i.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("disUin:").append(str).append(";");
      }
    }
  }
  
  public ArrayList b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "cloneDiscNumInfoCache size = " + this.jdField_b_of_type_JavaUtilArrayList.size());
      }
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
    finally {}
  }
  
  public ArrayList b(long paramLong)
  {
    return (ArrayList)this.S.get(Long.valueOf(paramLong));
  }
  
  public ArrayList b(String paramString)
  {
    return (ArrayList)this.U.get(paramString);
  }
  
  public ConcurrentHashMap b()
  {
    return this.T;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "clearDiscPullSeqCache");
    }
    this.l.clear();
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        j();
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SendMessageStatistic", 2, "addSendMessageStatistic exception", localException);
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_OrgJsonJSONObject.has(String.valueOf(paramInt)))
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put(String.valueOf(paramInt), this.jdField_a_of_type_OrgJsonJSONObject.getInt(String.valueOf(paramInt)) + 1);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
            this.jdField_a_of_type_Jvf.putString("sendMessageType", this.jdField_a_of_type_OrgJsonJSONObject.toString());
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("SendMessageStatistic", 4, "SendMessageStatistic=" + this.jdField_a_of_type_OrgJsonJSONObject.toString());
          }
          return;
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put(String.valueOf(paramInt), 1);
      }
    }
  }
  
  public void b(long paramLong)
  {
    this.S.remove(Long.valueOf(paramLong));
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    this.I.put("following_friend_seq_47", Long.valueOf(paramLong1));
    this.I.put("following_group_seq", Long.valueOf(paramLong2));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str != null)
    {
      this.jdField_a_of_type_Jvf.putLong("following_friend_seq_47" + str, paramLong1).commit();
      this.jdField_a_of_type_Jvf.putLong("following_group_seq" + str, paramLong2).commit();
    }
  }
  
  public void b(long paramLong, List paramList)
  {
    ArrayList localArrayList2 = (ArrayList)this.S.get(Long.valueOf(paramLong));
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.addAll(paramList);
    this.S.put(Long.valueOf(paramLong), localArrayList1);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = String.valueOf(paramMessageRecord.istroop) + "_" + paramMessageRecord.frienduin + "_" + paramMessageRecord.uniseq;
    this.N.put(str, paramMessageRecord);
  }
  
  public void b(String paramString)
  {
    this.Q.remove(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    this.T.put(paramString, Integer.valueOf(paramInt));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setDiscussionMsgState discussionUin: ").append(paramString).append(" state: ").append(paramInt);
        QLog.d(jdField_j_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      if (paramInt == 2) {
        h(paramString);
      }
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    this.K.put(new Pair(paramString, Integer.valueOf(paramInt)), Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getAIOLastSeq" + paramString + "_" + paramInt, paramLong);
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, b(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addGroupExpiredSeq " + paramLong);
    }
    this.jdField_j_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getTroopExpiredSeq" + paramString, paramLong);
    }
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    paramString = MD5.toMD5(paramString);
    this.o.put(paramString, new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2)));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_a_of_type_Jvf.putLong("getC2CLastMessageTime" + paramString, paramLong1);
      this.jdField_a_of_type_Jvf.putLong("getC2CLastMessageTimeRand" + paramString, paramLong2);
    }
  }
  
  public void b(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addPCQQSearchMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.u.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.u.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        paramArrayOfByte = HexUtil.a(paramArrayOfByte);
        this.jdField_a_of_type_Jvf.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void b(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.g.put(paramString, paramArrayOfObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        this.jdField_a_of_type_Jvf.putLong("getDiscussionMemberSeq" + paramString, ((Long)paramArrayOfObject[0]).longValue());
        this.jdField_a_of_type_Jvf.putLong("getDiscussionConfigSeq" + paramString, ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((MessageRecord)paramList.next());
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty();
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        if (paramMessageRecord.isLongMsg())
        {
          if ((this.M.containsKey(localObject)) && (((ConcurrentHashMap)this.M.get(localObject)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId)))) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      } while (!this.q.containsKey(localObject));
      localObject = (ConcurrentHashMap)this.q.get(localObject);
    } while ((localObject == null) || (!((ConcurrentHashMap)localObject).containsKey(Long.valueOf(paramMessageRecord.uniseq))));
    return true;
  }
  
  public byte[] b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "getWpaMsgKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.t.containsKey(paramString)) {
        break label150;
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_j_of_type_JavaLangString, 2, "getWpaMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = HexUtil.a((String)localObject);
    this.t.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "getWpaMsgKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a((byte[])this.t.get(paramString)));
    }
    return (byte[])this.t.get(paramString);
  }
  
  public Object[] b(String paramString)
  {
    if (this.f.containsKey(paramString)) {
      return (Object[])this.f.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopMemberSeq" + paramString, -1L);
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getTroopConfigSeq" + paramString, -1L);
      if (l1 != 0L) {
        return new Object[] { Long.valueOf(l1), Long.valueOf(l2) };
      }
    }
    return null;
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: iconst_0
    //   9: istore 4
    //   11: iload_2
    //   12: istore_1
    //   13: aload_0
    //   14: invokespecial 361	com/tencent/mobileqq/service/message/MessageCache:j	()V
    //   17: iload_2
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 204	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   23: astore 8
    //   25: iload_2
    //   26: istore_1
    //   27: aload 8
    //   29: monitorenter
    //   30: iload 5
    //   32: istore_3
    //   33: iload 6
    //   35: istore_2
    //   36: aload_0
    //   37: getfield 202	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   40: ifnull +83 -> 123
    //   43: iload 5
    //   45: istore_3
    //   46: iload 6
    //   48: istore_2
    //   49: aload_0
    //   50: getfield 202	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   53: invokevirtual 867	org/json/JSONObject:length	()I
    //   56: ifle +67 -> 123
    //   59: iload 6
    //   61: istore_2
    //   62: aload_0
    //   63: getfield 202	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   66: invokevirtual 871	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   69: astore 7
    //   71: iconst_0
    //   72: istore_2
    //   73: iload 4
    //   75: istore_1
    //   76: iload_2
    //   77: istore 4
    //   79: iload_1
    //   80: istore_3
    //   81: iload_1
    //   82: istore_2
    //   83: iload 4
    //   85: aload 7
    //   87: invokevirtual 874	org/json/JSONArray:length	()I
    //   90: if_icmpge +33 -> 123
    //   93: iload_1
    //   94: istore_2
    //   95: aload_0
    //   96: getfield 202	com/tencent/mobileqq/service/message/MessageCache:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   99: aload 7
    //   101: iload 4
    //   103: invokevirtual 876	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   106: invokevirtual 371	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   109: istore_3
    //   110: iload 4
    //   112: iconst_1
    //   113: iadd
    //   114: istore 4
    //   116: iload_3
    //   117: iload_1
    //   118: iadd
    //   119: istore_1
    //   120: goto -41 -> 79
    //   123: aload 8
    //   125: monitorexit
    //   126: invokestatic 376	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   129: ifeq +29 -> 158
    //   132: ldc 33
    //   134: iconst_4
    //   135: new 289	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 878
    //   145: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_3
    //   149: invokevirtual 381	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iload_3
    //   159: ireturn
    //   160: astore 7
    //   162: iload_2
    //   163: istore_1
    //   164: iload_1
    //   165: istore_2
    //   166: aload 8
    //   168: monitorexit
    //   169: aload 7
    //   171: athrow
    //   172: astore 7
    //   174: iload_1
    //   175: istore_3
    //   176: invokestatic 389	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq -53 -> 126
    //   182: ldc 33
    //   184: iconst_2
    //   185: ldc_w 880
    //   188: aload 7
    //   190: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: iload_1
    //   194: istore_3
    //   195: goto -69 -> 126
    //   198: astore 7
    //   200: iload_3
    //   201: istore_1
    //   202: goto -38 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	MessageCache
    //   12	190	1	i1	int
    //   7	159	2	i2	int
    //   32	169	3	i3	int
    //   9	106	4	i4	int
    //   1	43	5	i5	int
    //   4	56	6	i6	int
    //   69	31	7	localJSONArray	JSONArray
    //   160	10	7	localObject1	Object
    //   172	17	7	localException	Exception
    //   198	1	7	localObject2	Object
    //   23	144	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	43	160	finally
    //   49	59	160	finally
    //   62	71	160	finally
    //   83	93	160	finally
    //   95	110	160	finally
    //   166	169	160	finally
    //   13	17	172	java/lang/Exception
    //   19	25	172	java/lang/Exception
    //   27	30	172	java/lang/Exception
    //   169	172	172	java/lang/Exception
    //   123	126	198	finally
  }
  
  public int c(String paramString)
  {
    i2 = 0;
    try
    {
      k();
      i1 = i2;
      if (this.jdField_b_of_type_OrgJsonJSONObject.has(paramString))
      {
        i1 = this.jdField_b_of_type_OrgJsonJSONObject.getInt(paramString);
        i1 = 0 + i1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.e("RecvMessageStatistic", 2, "getRecvMessageCount type=" + paramString + " exception", localException);
          i1 = i2;
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecvMessageStatistic", 4, "getRecvMessageCount=" + i1 + ",type=" + paramString);
    }
    return i1;
  }
  
  public long c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    if (!this.k.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionExpiredSeq" + paramString, 0L);
      this.k.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.k.get(paramString)).longValue();
  }
  
  public long c(String paramString, int paramInt)
  {
    Pair localPair = new Pair(paramString, Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    if (!this.K.containsKey(localPair))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getAIOLastSeq" + paramString + "_" + paramInt, 0L);
      this.K.put(localPair, Long.valueOf(l1));
    }
    return ((Long)this.K.get(localPair)).longValue();
  }
  
  public ConcurrentHashMap c()
  {
    return this.r;
  }
  
  public void c()
  {
    this.O.clear();
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    String str = MsgProxyUtils.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    Object localObject1 = new MessageCache.MsgSendingInfo(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    if (this.q.containsKey(str))
    {
      localObject2 = (ConcurrentHashMap)this.q.get(str);
      if (localObject2 != null) {
        ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      }
    }
    for (;;)
    {
      if (paramMessageRecord.isLongMsg())
      {
        if (!this.M.containsKey(str)) {
          break label276;
        }
        if (!((ConcurrentHashMap)this.M.get(str)).containsKey(Integer.valueOf(paramMessageRecord.longMsgId))) {
          break;
        }
        ((Set)((ConcurrentHashMap)this.M.get(str)).get(Integer.valueOf(paramMessageRecord.longMsgId))).add(Long.valueOf(paramMessageRecord.uniseq));
      }
      return;
      localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      this.q.put(str, localObject2);
      continue;
      localObject2 = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject2).put(Long.valueOf(paramMessageRecord.uniseq), localObject1);
      this.q.put(str, localObject2);
    }
    localObject1 = new HashSet();
    ((Set)localObject1).add(Long.valueOf(paramMessageRecord.uniseq));
    ((ConcurrentHashMap)this.M.get(str)).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject1);
    return;
    label276:
    localObject1 = new ConcurrentHashMap();
    Object localObject2 = new HashSet();
    ((Set)localObject2).add(Long.valueOf(paramMessageRecord.uniseq));
    ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramMessageRecord.longMsgId), localObject2);
    this.M.put(str, localObject1);
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      this.l.put(paramString, Boolean.valueOf(true));
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    try
    {
      k();
      if (this.jdField_b_of_type_OrgJsonJSONObject.has(paramString)) {
        this.jdField_b_of_type_OrgJsonJSONObject.put(paramString, this.jdField_b_of_type_OrgJsonJSONObject.getInt(paramString) + paramInt);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          this.jdField_a_of_type_Jvf.putString("recvMessageStatistic", this.jdField_b_of_type_OrgJsonJSONObject.toString());
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("RecvMessageStatistic", 4, "recvMessageStatistic=" + this.jdField_b_of_type_OrgJsonJSONObject.toString());
        return;
        this.jdField_b_of_type_OrgJsonJSONObject.put(paramString, paramInt);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecvMessageStatistic", 2, "addRecvMessageStatistic exception", paramString);
      }
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong)
  {
    this.J.put(new Pair(paramString, Integer.valueOf(paramInt)), Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getBreakPointSeq" + paramString + "_" + paramInt, paramLong);
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, c(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addDiscExpiredSeq " + paramLong);
    }
    this.k.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getDiscussionExpiredSeq" + paramString, paramLong);
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addBusinessCrmMsgKey----> sig:" + HexUtil.a(paramArrayOfByte) + ",length:" + paramArrayOfByte.length);
    }
    byte[] arrayOfByte = (byte[])this.v.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte)))
    {
      this.v.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        paramArrayOfByte = HexUtil.a(paramArrayOfByte);
        this.jdField_a_of_type_Jvf.putString(paramString, paramArrayOfByte);
      }
    }
  }
  
  public void c(String paramString, Object[] paramArrayOfObject)
  {
    if (paramString != null)
    {
      this.f.put(paramString, paramArrayOfObject);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        this.jdField_a_of_type_Jvf.putLong("getTroopMemberSeq" + paramString, ((Long)paramArrayOfObject[0]).longValue());
        this.jdField_a_of_type_Jvf.putLong("getTroopConfigSeq" + paramString, ((Long)paramArrayOfObject[1]).longValue());
      }
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "isDiscPullSeqFinish size = " + this.l.size());
    }
    return this.l.isEmpty();
  }
  
  public byte[] c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "pcQQSearchKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.u.containsKey(paramString)) {
        break label150;
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_j_of_type_JavaLangString, 2, "pcQQSearchKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = HexUtil.a((String)localObject);
    this.u.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "pcQQSearchKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a((byte[])this.u.get(paramString)));
    }
    return (byte[])this.u.get(paramString);
  }
  
  public int d()
  {
    int i4 = 0;
    int i5 = 0;
    int i1 = 0;
    int i2 = i4;
    try
    {
      k();
      i2 = i4;
      int i3 = i5;
      if (this.jdField_b_of_type_OrgJsonJSONObject != null)
      {
        i2 = i4;
        i3 = i5;
        if (this.jdField_b_of_type_OrgJsonJSONObject.length() > 0)
        {
          i2 = i4;
          JSONArray localJSONArray = this.jdField_b_of_type_OrgJsonJSONObject.names();
          i4 = 0;
          for (;;)
          {
            i2 = i1;
            i3 = i1;
            if (i4 >= localJSONArray.length()) {
              break;
            }
            i2 = i1;
            i3 = this.jdField_b_of_type_OrgJsonJSONObject.getInt(localJSONArray.getString(i4));
            i4 += 1;
            i1 = i3 + i1;
          }
        }
      }
      return i3;
    }
    catch (Exception localException)
    {
      i3 = i2;
      if (QLog.isColorLevel())
      {
        QLog.e("RecvMessageStatistic", 2, "getRecvMessageCount exception", localException);
        i3 = i2;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("RecvMessageStatistic", 4, "getRecvMessageCount=" + i3);
      }
    }
  }
  
  public long d(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str == null) {
      return 0L;
    }
    if (!this.I.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString + str, 0L);
      this.I.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.I.get(paramString)).longValue();
  }
  
  public void d()
  {
    if ((this.q != null) && (!this.q.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.q.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        if ((((Map.Entry)localObject).getValue() != null) && (!((ConcurrentHashMap)((Map.Entry)localObject).getValue()).isEmpty()))
        {
          localObject = ((ConcurrentHashMap)((Map.Entry)localObject).getValue()).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("uin", ((MessageCache.MsgSendingInfo)localEntry.getValue()).jdField_a_of_type_JavaLangString);
              localJSONObject.put("type", ((MessageCache.MsgSendingInfo)localEntry.getValue()).jdField_a_of_type_Int);
              localJSONObject.put("uniseq", ((MessageCache.MsgSendingInfo)localEntry.getValue()).jdField_a_of_type_Long);
              localJSONArray.put(localJSONObject);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        this.jdField_a_of_type_Jvf.putString("msgSending", localJSONArray.toString());
        if (QLog.isColorLevel()) {
          QLog.d(jdField_j_of_type_JavaLangString, 2, "msgSending:write msgSending file before exit," + localJSONArray.toString());
        }
      }
    }
    e();
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.Q.clear();
    this.m.clear();
    this.U.clear();
    this.V.clear();
    this.W.clear();
    this.o.clear();
    this.jdField_a_of_type_Long = 0L;
    this.X.clear();
    this.Y.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.q.clear();
    this.r.clear();
    this.f.clear();
    this.g.clear();
    this.i.clear();
    this.h.clear();
    this.H.clear();
  }
  
  public void d(String paramString)
  {
    this.U.remove(paramString);
  }
  
  public void d(String paramString, int paramInt, long paramLong)
  {
    paramString = MsgProxyUtils.a(paramString, paramInt);
    Object localObject;
    if (this.q.containsKey(paramString))
    {
      localObject = (ConcurrentHashMap)this.q.get(paramString);
      if (localObject != null) {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong));
      }
      if ((localObject != null) && (((ConcurrentHashMap)localObject).isEmpty())) {
        this.q.remove(paramString);
      }
    }
    if ((!f()) && (this.r.containsKey(paramString)))
    {
      localObject = (ConcurrentHashMap)this.r.get(paramString);
      if (localObject != null) {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong));
      }
      if ((localObject != null) && (((ConcurrentHashMap)localObject).isEmpty())) {
        this.r.remove(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "msgSending:delete result in messageSendingTemp " + this.r);
      }
    }
    int i1;
    if (this.M.containsKey(paramString))
    {
      int i2 = 0;
      localObject = ((ConcurrentHashMap)this.M.get(paramString)).keySet().iterator();
      Set localSet;
      do
      {
        paramInt = i2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        i1 = ((Integer)((Iterator)localObject).next()).intValue();
        localSet = (Set)((ConcurrentHashMap)this.M.get(paramString)).get(Integer.valueOf(i1));
      } while (!localSet.contains(Long.valueOf(paramLong)));
      localSet.remove(Long.valueOf(paramLong));
      if (!localSet.isEmpty()) {
        break label368;
      }
    }
    label368:
    for (paramInt = i1;; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "removeSendingCache uniseq=" + paramLong + "longid=" + i1);
      }
      for (;;)
      {
        if (paramInt != 0) {
          ((ConcurrentHashMap)this.M.get(paramString)).remove(Integer.valueOf(paramInt));
        }
        return;
      }
    }
  }
  
  public void d(String paramString, long paramLong)
  {
    this.I.put(paramString, Long.valueOf(paramLong));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (str != null) {
      this.jdField_a_of_type_Jvf.putLong(paramString + str, paramLong).commit();
    }
  }
  
  public void d(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addBusinessCrmSigt uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a(paramArrayOfByte));
    }
    byte[] arrayOfByte = (byte[])this.w.get(paramString);
    if ((arrayOfByte == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte))) {
      this.w.put(paramString, paramArrayOfByte);
    }
  }
  
  public void d(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.U.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.U.put(paramString, localArrayList1);
  }
  
  public boolean d()
  {
    return this.h.isEmpty();
  }
  
  public byte[] d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "getBusinessCrmKey uin:null peerUin:" + paramString + " key:null");
      }
    }
    do
    {
      return null;
      if (this.v.containsKey(paramString)) {
        break label150;
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_j_of_type_JavaLangString, 2, "businessCrmKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:null");
    return null;
    Object localObject = HexUtil.a((String)localObject);
    this.v.put(paramString, localObject);
    label150:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "businessCrmKey uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a((byte[])this.v.get(paramString)));
    }
    return (byte[])this.v.get(paramString);
  }
  
  public long e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    if (!this.H.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getFriendFeedLastTime" + paramString, -1L);
      this.H.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.H.get(paramString)).longValue();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Jvf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "msgCache commit.");
      }
      this.jdField_a_of_type_Jvf.commit();
    }
  }
  
  public void e(String paramString)
  {
    this.h.put(paramString, Boolean.valueOf(true));
  }
  
  public void e(String paramString, int paramInt, long paramLong)
  {
    String str = MsgProxyUtils.a(paramString, paramInt);
    paramString = new MessageCache.MsgSendingInfo(this, paramString, paramInt, paramLong);
    ConcurrentHashMap localConcurrentHashMap;
    if (this.r.containsKey(str))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.r.get(str);
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "msgSending:addSendingCacheTemp,msgSendingTemp:" + this.r + " msgCache:" + hashCode());
      }
      return;
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.r.put(str, localConcurrentHashMap);
      continue;
      localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(Long.valueOf(paramLong), paramString);
      this.r.put(str, localConcurrentHashMap);
    }
  }
  
  public void e(String paramString, long paramLong)
  {
    this.H.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getFriendFeedLastTime" + paramString, paramLong);
    }
  }
  
  public void e(String paramString, byte[] paramArrayOfByte) {}
  
  public boolean e()
  {
    return this.i.isEmpty();
  }
  
  public byte[] e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_j_of_type_JavaLangString, 2, "businessCrmSigt uin:null peerUin:" + paramString + " key:null");
      }
    }
    while (!this.w.containsKey(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "businessCrmSigt uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "peerUin:" + paramString + " key:" + HexUtil.a((byte[])this.w.get(paramString)));
    }
    return (byte[])this.w.get(paramString);
  }
  
  public long f(String paramString)
  {
    paramString = (Long)this.O.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "dumpGroupMsgJob size = " + this.h.size());
    }
  }
  
  public void f(String paramString)
  {
    if (this.h.containsKey(paramString)) {
      this.h.remove(paramString);
    }
  }
  
  public void f(String paramString, long paramLong)
  {
    this.O.put(paramString, Long.valueOf(paramLong));
  }
  
  public void f(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.y.get(paramString);
    if ((localObject == null) || (!localObject.equals(paramArrayOfByte)))
    {
      this.y.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "pub", 0);
        paramArrayOfByte = PkgTools.b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public boolean f()
  {
    return (this.r == null) || (this.r.isEmpty());
  }
  
  public byte[] f(String paramString)
  {
    return null;
  }
  
  public long g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    if (!this.m.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getDiscussionLastMessageTime" + paramString, 0L);
      this.m.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.m.get(paramString)).longValue();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "dumpDiscMsgJob size = " + this.i.size());
    }
  }
  
  public void g(String paramString)
  {
    this.i.put(paramString, Boolean.valueOf(true));
  }
  
  public void g(String paramString, long paramLong)
  {
    paramLong = Math.max(paramLong, g(paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "addDiscussionMsgLastSeq " + paramLong);
    }
    this.m.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getDiscussionLastMessageTime" + paramString, paramLong);
    }
  }
  
  public void g(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.z.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.z.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "same_state", 0);
        paramArrayOfByte = PkgTools.b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {}
    do
    {
      return null;
      if (this.D.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "circle_group", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.a((String)localObject);
    this.D.put(paramString, localObject);
    return (byte[])this.D.get(paramString);
  }
  
  public long h(String paramString)
  {
    long l1 = g(paramString);
    long l2 = c(paramString);
    long l3 = a(paramString, 3000);
    return Math.max(Math.max(l1, l2), l3);
  }
  
  public void h()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_OrgJsonJSONObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_Jvf.remove("sendMessageType").commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMessageStatistic", 2, "clear");
      }
      return;
    }
  }
  
  public void h(String paramString)
  {
    if (this.i.containsKey(paramString)) {
      this.i.remove(paramString);
    }
  }
  
  public void h(String paramString, long paramLong)
  {
    this.p.put(paramString, Long.valueOf(paramLong));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_Jvf.putLong("getMsgBoxLastEnterTime" + paramString, paramLong);
    }
  }
  
  public void h(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.A.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "accost", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.A.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.A.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.b(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {}
    do
    {
      return null;
      if (this.E.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "circle_group_av", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.a((String)localObject);
    this.E.put(paramString, localObject);
    return (byte[])this.E.get(paramString);
  }
  
  public long i(String paramString)
  {
    long l1 = a(paramString, 1);
    long l2 = a(paramString);
    long l3 = b(paramString);
    return Math.max(Math.max(l2, l1), l3);
  }
  
  public void i()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_OrgJsonJSONObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_Jvf.remove("recvMessageStatistic").commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecvMessageStatistic", 2, "clear");
      }
      return;
    }
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_j_of_type_JavaLangString, 2, "removeHotChatSeq groupUin:" + paramString);
    }
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(0L));
    this.f.put(paramString, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
    this.jdField_j_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(0L));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      this.jdField_a_of_type_Jvf.remove("getTroopLastMessageTime" + paramString);
      this.jdField_a_of_type_Jvf.remove("getTroopMemberSeq" + paramString);
      this.jdField_a_of_type_Jvf.remove("getTroopConfigSeq" + paramString);
      this.jdField_a_of_type_Jvf.remove("getTroopExpiredSeq" + paramString);
    }
  }
  
  public void i(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.B.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "nearby_assistant", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.B.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.B.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.b(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] i(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {}
    do
    {
      return null;
      if (this.F.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "friend_validation", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.a((String)localObject);
    this.F.put(paramString, localObject);
    return (byte[])this.F.get(paramString);
  }
  
  public long j(String paramString)
  {
    if (!this.p.containsKey(paramString))
    {
      long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("getMsgBoxLastEnterTime" + paramString, 0L);
      this.p.put(paramString, Long.valueOf(l1));
    }
    return ((Long)this.p.get(paramString)).longValue();
  }
  
  public void j(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = (byte[])this.C.get(paramString);
        if (((localObject != null) && (Arrays.equals((byte[])localObject, paramArrayOfByte))) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "dating", 0).edit();
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          this.C.remove(paramString);
          ((SharedPreferences.Editor)localObject).remove(paramString);
        }
        for (;;)
        {
          ((SharedPreferences.Editor)localObject).commit();
          return;
          this.C.put(paramString, paramArrayOfByte);
          ((SharedPreferences.Editor)localObject).putString(paramString, PkgTools.b(paramArrayOfByte));
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public byte[] j(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {}
    do
    {
      return null;
      if (this.z.containsKey(paramString)) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "same_state", 0).getString(paramString, null);
    } while (localObject == null);
    Object localObject = PkgTools.a((String)localObject);
    this.z.put(paramString, localObject);
    return (byte[])this.z.get(paramString);
  }
  
  public void k(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.D.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.D.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "circle_group", 0);
        paramArrayOfByte = PkgTools.b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] k(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
      return null;
    }
    if (!this.A.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "accost", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.a((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.A.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.A.get(paramString);
    }
    return null;
  }
  
  public void l(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.E.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.E.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "circle_group_av", 0);
        paramArrayOfByte = PkgTools.b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] l(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
      return null;
    }
    if (!this.B.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "nearby_assistant", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.a((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.B.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.B.get(paramString);
    }
    return null;
  }
  
  public void m(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (byte[])this.F.get(paramString);
    if ((localObject == null) || (!Arrays.equals((byte[])localObject, paramArrayOfByte)))
    {
      this.F.put(paramString, paramArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "friend_validation", 0);
        paramArrayOfByte = PkgTools.b(paramArrayOfByte);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, paramArrayOfByte);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public byte[] m(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null)) {
      return null;
    }
    if (!this.C.containsKey(paramString))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "dating", 0).getString(paramString, null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = PkgTools.a((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          this.C.put(paramString, localObject);
          return localObject;
        }
      }
    }
    else
    {
      return (byte[])this.C.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageCache
 * JD-Core Version:    0.7.0.1
 */