package com.tencent.mobileqq.app;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.CircleFriendInfo;
import SecurityAccountServer.MobileContactsDetailInfoEncrypt;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.data.RecommendContact;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.newfriend.RecommendMessage;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import hmc;
import hme;
import hmf;
import hmg;
import hmh;
import hmi;
import hmj;
import hmk;
import hml;
import hmm;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.tools.MD5;

public class PhoneContactManagerImp
  implements PhoneContactManager
{
  static final long jdField_a_of_type_Long = 120000L;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "data1", "display_name", "contact_id", "data2", "data3" };
  public static int b = 0;
  public static int c = 0;
  public static boolean c = false;
  private static final boolean jdField_f_of_type_Boolean = true;
  public volatile int a;
  public SharedPreferences a;
  private ContentObserver jdField_a_of_type_AndroidDatabaseContentObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new hmc(this);
  private hmm jdField_a_of_type_Hmm;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  public Vector a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public long b;
  private SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  volatile boolean jdField_b_of_type_Boolean;
  public long c;
  private String jdField_c_of_type_JavaLangString = "";
  private List jdField_c_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public long d;
  private List jdField_d_of_type_JavaUtilList = null;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean d;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_e_of_type_Boolean = false;
  private ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_c_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 2;
  }
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.f = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_b_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info_global", 0);
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("session_id", "").getBytes();
    this.jdField_b_of_type_JavaLangString = d();
    this.jdField_a_of_type_Int = a(a());
    paramQQAppInterface = (ContactSyncManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(40);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    n();
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "getSelfBindState : " + this.jdField_b_of_type_JavaLangString + " " + paramRespondQueryQQBindingStat.mobileNo + " " + paramRespondQueryQQBindingStat.originBinder + " " + paramRespondQueryQQBindingStat.MobileUniqueNo + " " + paramRespondQueryQQBindingStat.lastUsedFlag + " " + paramRespondQueryQQBindingStat.isRecommend + " " + paramRespondQueryQQBindingStat.bindingTime);
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo)) {
        return 1;
      }
      if ((paramRespondQueryQQBindingStat.originBinder == 2L) || (paramRespondQueryQQBindingStat.originBinder == 3L)) {
        return 2;
      }
    } while (paramRespondQueryQQBindingStat.originBinder != 1L);
    if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
      paramRespondQueryQQBindingStat.MobileUniqueNo = null;
    }
    if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 4;
    }
    if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 7;
    }
    return 3;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c1 = paramString.charAt(i);
      if ((c1 == ' ') || (c1 == '-') || (c1 == ')') || (c1 == '(') || (c1 == '_')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c1);
      }
    }
    return localStringBuffer.toString();
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes();
    byte[] arrayOfByte = paramString2.getBytes();
    if (paramString1.length > 10)
    {
      paramString2 = new byte[10];
      System.arraycopy(paramString1, 0, paramString2, 0, 10);
      paramString1 = paramString2;
    }
    for (;;)
    {
      return MD5.toMD5(ByteBuffer.allocate(paramString1.length + arrayOfByte.length).put(paramString1).put(arrayOfByte).array());
    }
  }
  
  private String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    paramString = paramString.getBytes();
    int j = paramString.length;
    paramArrayOfByte = a(paramArrayOfByte);
    paramString = a(paramString);
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramString[i] ^ paramArrayOfByte[i]));
      i += 1;
    }
    j = paramArrayOfByte.length;
    i = j - 1;
    if (i >= 0) {
      if (paramArrayOfByte[i] == 0) {}
    }
    for (;;)
    {
      if (i != j - 1)
      {
        paramString = new byte[i + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, i + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(a(paramArrayOfByte));
        i -= 1;
        break;
      }
      i = 0;
    }
  }
  
  /* Error */
  private ArrayList a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: invokespecial 321	com/tencent/mobileqq/app/PhoneContactManagerImp:o	()V
    //   7: aload_0
    //   8: getfield 112	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   14: invokevirtual 325	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   17: getstatic 331	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   20: getstatic 48	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 337	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore 5
    //   31: new 339	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 340	java/util/ArrayList:<init>	()V
    //   38: astore 8
    //   40: aload 5
    //   42: ifnull +585 -> 627
    //   45: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   48: lstore_3
    //   49: aload 5
    //   51: invokeinterface 349 1 0
    //   56: istore_1
    //   57: aload 8
    //   59: iload_1
    //   60: invokevirtual 352	java/util/ArrayList:ensureCapacity	(I)V
    //   63: new 71	java/util/concurrent/ConcurrentHashMap
    //   66: dup
    //   67: iload_1
    //   68: invokespecial 353	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   71: astore 9
    //   73: aload 7
    //   75: astore 6
    //   77: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +34 -> 114
    //   83: aload 7
    //   85: astore 6
    //   87: ldc_w 355
    //   90: iconst_2
    //   91: new 119	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 357
    //   101: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_1
    //   105: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 7
    //   116: astore 6
    //   118: aload_0
    //   119: getfield 112	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   125: invokestatic 202	com/tencent/mobileqq/utils/ChnToSpell:a	(Landroid/content/Context;)V
    //   128: aload 7
    //   130: astore 6
    //   132: aload_0
    //   133: getfield 186	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   136: invokevirtual 365	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload 7
    //   147: invokevirtual 369	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   150: aload 7
    //   152: astore 6
    //   154: aload 5
    //   156: invokeinterface 372 1 0
    //   161: pop
    //   162: aload 7
    //   164: astore 6
    //   166: aload 5
    //   168: invokeinterface 375 1 0
    //   173: ifne +360 -> 533
    //   176: aload 7
    //   178: astore 6
    //   180: aload 5
    //   182: aload 5
    //   184: ldc 38
    //   186: invokeinterface 379 2 0
    //   191: invokeinterface 382 2 0
    //   196: invokestatic 384	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 10
    //   201: aload 7
    //   203: astore 6
    //   205: aload 5
    //   207: aload 5
    //   209: ldc 40
    //   211: invokeinterface 379 2 0
    //   216: invokeinterface 382 2 0
    //   221: astore 11
    //   223: aload 7
    //   225: astore 6
    //   227: aload 5
    //   229: aload 5
    //   231: ldc 42
    //   233: invokeinterface 379 2 0
    //   238: invokeinterface 388 2 0
    //   243: istore_1
    //   244: aload 7
    //   246: astore 6
    //   248: aload 5
    //   250: aload 5
    //   252: ldc 44
    //   254: invokeinterface 379 2 0
    //   259: invokeinterface 388 2 0
    //   264: istore_2
    //   265: aload 7
    //   267: astore 6
    //   269: aload 5
    //   271: aload 5
    //   273: ldc 46
    //   275: invokeinterface 379 2 0
    //   280: invokeinterface 382 2 0
    //   285: astore 12
    //   287: aload 7
    //   289: astore 6
    //   291: aload 10
    //   293: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifne +15 -> 311
    //   299: aload 7
    //   301: astore 6
    //   303: aload 11
    //   305: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: ifeq +53 -> 361
    //   311: aload 7
    //   313: astore 6
    //   315: aload 5
    //   317: invokeinterface 391 1 0
    //   322: pop
    //   323: goto -161 -> 162
    //   326: astore 7
    //   328: aload 6
    //   330: ifnull +8 -> 338
    //   333: aload 6
    //   335: invokevirtual 393	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   338: aload 5
    //   340: invokeinterface 396 1 0
    //   345: aload 7
    //   347: athrow
    //   348: astore 5
    //   350: aload 5
    //   352: invokevirtual 399	java/lang/Exception:printStackTrace	()V
    //   355: aconst_null
    //   356: astore 5
    //   358: goto -327 -> 31
    //   361: aload 7
    //   363: astore 6
    //   365: new 401	com/tencent/mobileqq/data/PhoneContact
    //   368: dup
    //   369: invokespecial 402	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   372: astore 13
    //   374: aload 7
    //   376: astore 6
    //   378: aload 13
    //   380: aload 10
    //   382: putfield 403	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   385: aload 7
    //   387: astore 6
    //   389: aload 13
    //   391: aload 11
    //   393: putfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   396: aload 7
    //   398: astore 6
    //   400: aload 13
    //   402: iload_1
    //   403: putfield 409	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   406: aload 7
    //   408: astore 6
    //   410: aload 13
    //   412: iload_2
    //   413: putfield 412	com/tencent/mobileqq/data/PhoneContact:type	I
    //   416: aload 7
    //   418: astore 6
    //   420: aload 13
    //   422: aload 12
    //   424: putfield 415	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   427: aload 7
    //   429: astore 6
    //   431: aload 13
    //   433: lload_3
    //   434: putfield 418	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   437: aload 7
    //   439: astore 6
    //   441: aload 13
    //   443: aload 11
    //   445: iconst_1
    //   446: invokestatic 421	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   449: putfield 424	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   452: aload 7
    //   454: astore 6
    //   456: aload 13
    //   458: aload 11
    //   460: iconst_2
    //   461: invokestatic 421	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   464: putfield 427	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   467: aload 7
    //   469: astore 6
    //   471: aload 13
    //   473: aload_0
    //   474: aload 11
    //   476: aload 10
    //   478: invokespecial 429	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   481: putfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   484: aload 7
    //   486: astore 6
    //   488: aload 9
    //   490: aload 10
    //   492: aload 13
    //   494: invokevirtual 435	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: pop
    //   498: aload 7
    //   500: astore 6
    //   502: aload_0
    //   503: getfield 97	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   506: aload 13
    //   508: getfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   511: aload 13
    //   513: invokevirtual 435	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   516: pop
    //   517: aload 7
    //   519: astore 6
    //   521: aload_0
    //   522: getfield 186	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   525: aload 13
    //   527: invokevirtual 438	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   530: goto -219 -> 311
    //   533: aload 7
    //   535: astore 6
    //   537: aload 7
    //   539: invokevirtual 440	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   542: aload 7
    //   544: ifnull +8 -> 552
    //   547: aload 7
    //   549: invokevirtual 393	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   552: aload 5
    //   554: invokeinterface 396 1 0
    //   559: aload_0
    //   560: aload 9
    //   562: invokespecial 443	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   565: aload_0
    //   566: getfield 91	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   569: invokevirtual 447	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   572: invokeinterface 453 1 0
    //   577: astore 5
    //   579: aload 5
    //   581: invokeinterface 458 1 0
    //   586: ifeq +41 -> 627
    //   589: aload 5
    //   591: invokeinterface 462 1 0
    //   596: checkcast 401	com/tencent/mobileqq/data/PhoneContact
    //   599: astore 6
    //   601: aload 8
    //   603: new 464	SecurityAccountServer/AddressBookItem
    //   606: dup
    //   607: aload 6
    //   609: getfield 403	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   612: aload 6
    //   614: getfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   617: invokespecial 467	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   623: pop
    //   624: goto -45 -> 579
    //   627: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +34 -> 664
    //   633: ldc_w 355
    //   636: iconst_2
    //   637: new 119	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 472
    //   647: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload 8
    //   652: invokevirtual 475	java/util/ArrayList:size	()I
    //   655: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   664: aload 8
    //   666: areturn
    //   667: astore 5
    //   669: goto -110 -> 559
    //   672: astore 5
    //   674: goto -329 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	PhoneContactManagerImp
    //   56	347	1	i	int
    //   264	149	2	j	int
    //   48	386	3	l	long
    //   29	310	5	localCursor	android.database.Cursor
    //   348	3	5	localException1	Exception
    //   356	234	5	localIterator	Iterator
    //   667	1	5	localException2	Exception
    //   672	1	5	localException3	Exception
    //   75	538	6	localObject1	Object
    //   1	311	7	localEntityTransaction	EntityTransaction
    //   326	222	7	localObject2	Object
    //   38	627	8	localArrayList	ArrayList
    //   71	490	9	localConcurrentHashMap	ConcurrentHashMap
    //   199	292	10	str1	String
    //   221	254	11	str2	String
    //   285	138	12	str3	String
    //   372	154	13	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   77	83	326	finally
    //   87	114	326	finally
    //   118	128	326	finally
    //   132	141	326	finally
    //   145	150	326	finally
    //   154	162	326	finally
    //   166	176	326	finally
    //   180	201	326	finally
    //   205	223	326	finally
    //   227	244	326	finally
    //   248	265	326	finally
    //   269	287	326	finally
    //   291	299	326	finally
    //   303	311	326	finally
    //   315	323	326	finally
    //   365	374	326	finally
    //   378	385	326	finally
    //   389	396	326	finally
    //   400	406	326	finally
    //   410	416	326	finally
    //   420	427	326	finally
    //   431	437	326	finally
    //   441	452	326	finally
    //   456	467	326	finally
    //   471	484	326	finally
    //   488	498	326	finally
    //   502	517	326	finally
    //   521	530	326	finally
    //   537	542	326	finally
    //   7	31	348	java/lang/Exception
    //   552	559	667	java/lang/Exception
    //   338	345	672	java/lang/Exception
  }
  
  /* Error */
  private ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    // Byte code:
    //   0: new 480	java/util/HashMap
    //   3: dup
    //   4: invokespecial 481	java/util/HashMap:<init>	()V
    //   7: astore 11
    //   9: new 339	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 340	java/util/ArrayList:<init>	()V
    //   16: astore 10
    //   18: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: aload_0
    //   24: getfield 112	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 325	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 7
    //   35: aload 7
    //   37: getstatic 331	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   40: getstatic 48	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 337	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 7
    //   51: aload 7
    //   53: ifnull +997 -> 1050
    //   56: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +36 -> 95
    //   62: ldc_w 355
    //   65: iconst_2
    //   66: new 119	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 483
    //   76: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 7
    //   81: invokeinterface 349 1 0
    //   86: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: astore 9
    //   98: aload_0
    //   99: getfield 112	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   105: invokestatic 202	com/tencent/mobileqq/utils/ChnToSpell:a	(Landroid/content/Context;)V
    //   108: aload_0
    //   109: getfield 186	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   112: invokevirtual 365	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   115: astore 8
    //   117: aload 8
    //   119: invokevirtual 369	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   122: aload 7
    //   124: invokeinterface 372 1 0
    //   129: pop
    //   130: aload 7
    //   132: invokeinterface 375 1 0
    //   137: ifne +495 -> 632
    //   140: aload 7
    //   142: aload 7
    //   144: ldc 38
    //   146: invokeinterface 379 2 0
    //   151: invokeinterface 382 2 0
    //   156: invokestatic 384	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 9
    //   161: aload 7
    //   163: aload 7
    //   165: ldc 40
    //   167: invokeinterface 379 2 0
    //   172: invokeinterface 382 2 0
    //   177: astore 12
    //   179: aload 7
    //   181: aload 7
    //   183: ldc 42
    //   185: invokeinterface 379 2 0
    //   190: invokeinterface 388 2 0
    //   195: istore_3
    //   196: aload 7
    //   198: aload 7
    //   200: ldc 44
    //   202: invokeinterface 379 2 0
    //   207: invokeinterface 388 2 0
    //   212: istore 4
    //   214: aload 7
    //   216: aload 7
    //   218: ldc 46
    //   220: invokeinterface 379 2 0
    //   225: invokeinterface 382 2 0
    //   230: astore 13
    //   232: aload 9
    //   234: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne +11 -> 248
    //   240: aload 12
    //   242: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifeq +43 -> 288
    //   248: aload 7
    //   250: invokeinterface 391 1 0
    //   255: pop
    //   256: goto -126 -> 130
    //   259: astore_1
    //   260: aload 8
    //   262: astore_2
    //   263: aload_2
    //   264: ifnull +7 -> 271
    //   267: aload_2
    //   268: invokevirtual 393	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   271: aload 7
    //   273: invokeinterface 396 1 0
    //   278: aload_1
    //   279: athrow
    //   280: astore 7
    //   282: aconst_null
    //   283: astore 7
    //   285: goto -234 -> 51
    //   288: aload_0
    //   289: getfield 91	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   292: aload 9
    //   294: invokevirtual 487	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   297: checkcast 401	com/tencent/mobileqq/data/PhoneContact
    //   300: astore 14
    //   302: aload 14
    //   304: ifnonnull +142 -> 446
    //   307: new 401	com/tencent/mobileqq/data/PhoneContact
    //   310: dup
    //   311: invokespecial 402	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   314: astore 14
    //   316: aload 14
    //   318: aload 9
    //   320: putfield 403	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   323: aload 14
    //   325: aload 12
    //   327: putfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   330: aload 14
    //   332: iload_3
    //   333: putfield 409	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   336: aload 14
    //   338: iload 4
    //   340: putfield 412	com/tencent/mobileqq/data/PhoneContact:type	I
    //   343: aload 14
    //   345: aload 13
    //   347: putfield 415	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   350: aload 14
    //   352: lload 5
    //   354: putfield 418	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   357: aload 14
    //   359: aload 12
    //   361: iconst_1
    //   362: invokestatic 421	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   365: putfield 424	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   368: aload 14
    //   370: aload 12
    //   372: iconst_2
    //   373: invokestatic 421	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   376: putfield 427	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   379: aload_0
    //   380: getfield 91	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   383: aload 9
    //   385: aload 14
    //   387: invokevirtual 435	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   390: pop
    //   391: aload 14
    //   393: aload_0
    //   394: aload 12
    //   396: aload 9
    //   398: invokespecial 429	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   401: putfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   404: aload_0
    //   405: getfield 97	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   408: aload 14
    //   410: getfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   413: aload 14
    //   415: invokevirtual 435	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: aload 10
    //   421: aload 14
    //   423: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   426: pop
    //   427: aload_1
    //   428: new 464	SecurityAccountServer/AddressBookItem
    //   431: dup
    //   432: aload 9
    //   434: aload 12
    //   436: invokespecial 467	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   442: pop
    //   443: goto -195 -> 248
    //   446: aload 14
    //   448: iload_3
    //   449: putfield 409	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   452: aload 14
    //   454: lload 5
    //   456: putfield 418	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   459: aload 14
    //   461: getfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   464: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: ifeq +34 -> 501
    //   470: aload 14
    //   472: aload_0
    //   473: aload 14
    //   475: getfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   478: aload 9
    //   480: invokespecial 429	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   483: putfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   486: aload_0
    //   487: getfield 97	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   490: aload 14
    //   492: getfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   495: aload 14
    //   497: invokevirtual 435	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: pop
    //   501: aload 14
    //   503: getfield 490	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   506: ifeq +99 -> 605
    //   509: aload 12
    //   511: aload 14
    //   513: getfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   516: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   519: ifne +75 -> 594
    //   522: aload 11
    //   524: aload 9
    //   526: aload 12
    //   528: invokevirtual 491	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   531: pop
    //   532: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq -287 -> 248
    //   538: ldc_w 355
    //   541: iconst_2
    //   542: new 119	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 493
    //   552: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 14
    //   557: getfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   560: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: ldc_w 495
    //   566: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 12
    //   571: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: ldc_w 497
    //   577: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 9
    //   582: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: goto -343 -> 248
    //   594: aload 11
    //   596: aload 9
    //   598: invokevirtual 500	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   601: pop
    //   602: goto -354 -> 248
    //   605: aload_1
    //   606: new 464	SecurityAccountServer/AddressBookItem
    //   609: dup
    //   610: aload 9
    //   612: aload 12
    //   614: invokespecial 467	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   620: pop
    //   621: aload 10
    //   623: aload 14
    //   625: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   628: pop
    //   629: goto -381 -> 248
    //   632: aload 11
    //   634: invokevirtual 504	java/util/HashMap:keySet	()Ljava/util/Set;
    //   637: invokeinterface 507 1 0
    //   642: astore 9
    //   644: aload 9
    //   646: invokeinterface 458 1 0
    //   651: ifeq +164 -> 815
    //   654: aload 9
    //   656: invokeinterface 462 1 0
    //   661: checkcast 36	java/lang/String
    //   664: astore 12
    //   666: aload_0
    //   667: getfield 91	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   670: aload 12
    //   672: invokevirtual 487	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   675: checkcast 401	com/tencent/mobileqq/data/PhoneContact
    //   678: astore 13
    //   680: aload 13
    //   682: ifnull -38 -> 644
    //   685: aload 11
    //   687: aload 12
    //   689: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   692: checkcast 36	java/lang/String
    //   695: astore 14
    //   697: aload_2
    //   698: new 464	SecurityAccountServer/AddressBookItem
    //   701: dup
    //   702: aload 12
    //   704: aload 13
    //   706: getfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   709: invokespecial 467	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   715: pop
    //   716: aload_1
    //   717: new 464	SecurityAccountServer/AddressBookItem
    //   720: dup
    //   721: aload 12
    //   723: aload 14
    //   725: invokespecial 467	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   728: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   731: pop
    //   732: aload 13
    //   734: aload 14
    //   736: putfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   739: aload 13
    //   741: aload 14
    //   743: iconst_1
    //   744: invokestatic 421	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   747: putfield 424	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   750: aload 13
    //   752: aload 14
    //   754: iconst_2
    //   755: invokestatic 421	com/tencent/mobileqq/utils/ChnToSpell:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   758: putfield 427	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   761: aload_0
    //   762: getfield 97	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   765: aload 13
    //   767: getfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   770: aload 13
    //   772: invokevirtual 511	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   775: pop
    //   776: aload 13
    //   778: aload_0
    //   779: aload 14
    //   781: aload 12
    //   783: invokespecial 429	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   786: putfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   789: aload_0
    //   790: getfield 97	com/tencent/mobileqq/app/PhoneContactManagerImp:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   793: aload 13
    //   795: getfield 432	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   798: aload 13
    //   800: invokevirtual 435	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   803: pop
    //   804: aload 10
    //   806: aload 13
    //   808: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   811: pop
    //   812: goto -168 -> 644
    //   815: new 339	java/util/ArrayList
    //   818: dup
    //   819: invokespecial 340	java/util/ArrayList:<init>	()V
    //   822: astore 9
    //   824: aload_0
    //   825: getfield 91	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   828: invokevirtual 514	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   831: invokeinterface 507 1 0
    //   836: astore 11
    //   838: aload 11
    //   840: invokeinterface 458 1 0
    //   845: ifeq +183 -> 1028
    //   848: aload 11
    //   850: invokeinterface 462 1 0
    //   855: checkcast 516	java/util/Map$Entry
    //   858: invokeinterface 519 1 0
    //   863: checkcast 401	com/tencent/mobileqq/data/PhoneContact
    //   866: astore 12
    //   868: aload 12
    //   870: getfield 418	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   873: lload 5
    //   875: lcmp
    //   876: ifeq -38 -> 838
    //   879: aload 12
    //   881: getfield 522	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   884: invokestatic 246	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   887: ifne +16 -> 903
    //   890: aload_0
    //   891: getfield 93	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   894: aload 12
    //   896: getfield 522	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   899: invokevirtual 523	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   902: pop
    //   903: aload 11
    //   905: invokeinterface 525 1 0
    //   910: aload_0
    //   911: getfield 186	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   914: aload 12
    //   916: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   919: pop
    //   920: aload_2
    //   921: new 464	SecurityAccountServer/AddressBookItem
    //   924: dup
    //   925: aload 12
    //   927: getfield 403	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   930: aload 12
    //   932: getfield 406	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   935: invokespecial 467	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   941: pop
    //   942: aload_0
    //   943: getfield 106	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   946: invokevirtual 529	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   949: astore 13
    //   951: aload 13
    //   953: invokeinterface 458 1 0
    //   958: ifeq +52 -> 1010
    //   961: aload 13
    //   963: invokeinterface 462 1 0
    //   968: checkcast 531	com/tencent/mobileqq/data/RecommendContact
    //   971: astore 14
    //   973: aload 12
    //   975: getfield 403	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   978: aload 14
    //   980: getfield 534	com/tencent/mobileqq/data/RecommendContact:key	Ljava/lang/String;
    //   983: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   986: ifeq -35 -> 951
    //   989: aload 9
    //   991: aload 14
    //   993: invokevirtual 470	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   996: pop
    //   997: aload_0
    //   998: getfield 186	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1001: aload 14
    //   1003: invokevirtual 528	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1006: pop
    //   1007: goto -56 -> 951
    //   1010: aload_0
    //   1011: getfield 106	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   1014: aload 9
    //   1016: invokevirtual 538	java/util/Vector:removeAll	(Ljava/util/Collection;)Z
    //   1019: pop
    //   1020: aload 9
    //   1022: invokevirtual 541	java/util/ArrayList:clear	()V
    //   1025: goto -187 -> 838
    //   1028: aload 8
    //   1030: invokevirtual 440	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1033: aload 8
    //   1035: ifnull +8 -> 1043
    //   1038: aload 8
    //   1040: invokevirtual 393	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1043: aload 7
    //   1045: invokeinterface 396 1 0
    //   1050: aload_2
    //   1051: invokevirtual 475	java/util/ArrayList:size	()I
    //   1054: ifeq +12 -> 1066
    //   1057: aload_0
    //   1058: invokespecial 544	com/tencent/mobileqq/app/PhoneContactManagerImp:q	()V
    //   1061: aload_0
    //   1062: iconst_0
    //   1063: invokevirtual 547	com/tencent/mobileqq/app/PhoneContactManagerImp:b	(Z)V
    //   1066: aload_0
    //   1067: iconst_0
    //   1068: putfield 89	com/tencent/mobileqq/app/PhoneContactManagerImp:jdField_d_of_type_Boolean	Z
    //   1071: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq +35 -> 1109
    //   1077: ldc_w 355
    //   1080: iconst_2
    //   1081: new 119	java/lang/StringBuilder
    //   1084: dup
    //   1085: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1088: ldc_w 549
    //   1091: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: invokestatic 344	java/lang/System:currentTimeMillis	()J
    //   1097: lload 5
    //   1099: lsub
    //   1100: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq +33 -> 1145
    //   1115: ldc_w 355
    //   1118: iconst_2
    //   1119: new 119	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1126: ldc_w 551
    //   1129: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: aload_1
    //   1133: invokevirtual 475	java/util/ArrayList:size	()I
    //   1136: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1139: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1142: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1145: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1148: ifeq +33 -> 1181
    //   1151: ldc_w 355
    //   1154: iconst_2
    //   1155: new 119	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   1162: ldc_w 553
    //   1165: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: aload_2
    //   1169: invokevirtual 475	java/util/ArrayList:size	()I
    //   1172: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: aload 10
    //   1183: areturn
    //   1184: astore 7
    //   1186: goto -136 -> 1050
    //   1189: astore_2
    //   1190: goto -912 -> 278
    //   1193: astore_1
    //   1194: aload 9
    //   1196: astore_2
    //   1197: goto -934 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1200	0	this	PhoneContactManagerImp
    //   0	1200	1	paramArrayList1	ArrayList
    //   0	1200	2	paramArrayList2	ArrayList
    //   195	254	3	i	int
    //   212	127	4	j	int
    //   21	1077	5	l	long
    //   33	239	7	localObject1	Object
    //   280	1	7	localThrowable	Throwable
    //   283	761	7	localObject2	Object
    //   1184	1	7	localException	Exception
    //   115	924	8	localEntityTransaction	EntityTransaction
    //   96	1099	9	localObject3	Object
    //   16	1166	10	localArrayList	ArrayList
    //   7	897	11	localObject4	Object
    //   177	797	12	localObject5	Object
    //   230	732	13	localObject6	Object
    //   300	702	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	130	259	finally
    //   130	248	259	finally
    //   248	256	259	finally
    //   288	302	259	finally
    //   307	443	259	finally
    //   446	501	259	finally
    //   501	591	259	finally
    //   594	602	259	finally
    //   605	629	259	finally
    //   632	644	259	finally
    //   644	680	259	finally
    //   685	812	259	finally
    //   815	838	259	finally
    //   838	903	259	finally
    //   903	951	259	finally
    //   951	1007	259	finally
    //   1010	1025	259	finally
    //   1028	1033	259	finally
    //   35	51	280	java/lang/Throwable
    //   1043	1050	1184	java/lang/Exception
    //   271	278	1189	java/lang/Exception
    //   98	117	1193	finally
  }
  
  private void a(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 29);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("getRecommendedTimeStamp", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("getRecommendedTimeStamp", 0L));
    localNewIntent.putExtra("session_id", new byte[0]);
    localNewIntent.putExtra("recommend_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("queryContactTimeStamp", paramLong).commit();
  }
  
  private void a(String paramString, ArrayList paramArrayList)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = paramArrayList;
    if (paramArrayList == null) {
      localArrayList = new ArrayList(0);
    }
    paramArrayList = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    paramArrayList.putExtra("req_type", 14);
    paramArrayList.putExtra("unique_phone_no", paramString);
    paramArrayList.putExtra("next_flag", 0L);
    paramArrayList.putExtra("upload_package_no", 0);
    paramArrayList.putExtra("contact_list", localArrayList);
    paramArrayList.putExtra("session_id", new byte[0]);
    paramArrayList.putExtra("is_resend", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramArrayList);
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    if (paramString == null) {}
    while ((paramArrayList1 == null) && (paramArrayList2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 15);
    localNewIntent.putExtra("unique_phone_no", paramString);
    localNewIntent.putExtra("add_contact_list", paramArrayList1);
    localNewIntent.putExtra("del_contact_list", paramArrayList2);
    localNewIntent.putExtra("rename_contact_list", paramArrayList3);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("upload_package_no", 0);
    localNewIntent.putExtra("session_id", new byte[0]);
    localNewIntent.putExtra("is_resend", false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(ConcurrentHashMap paramConcurrentHashMap)
  {
    Object localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      PhoneContact localPhoneContact = (PhoneContact)((Map.Entry)localObject2).getValue();
      localObject2 = (PhoneContact)paramConcurrentHashMap.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (localPhoneContact != null))
      {
        ((PhoneContact)localObject2).uin = localPhoneContact.uin;
        ((PhoneContact)localObject2).nationCode = localPhoneContact.nationCode;
        ((PhoneContact)localObject2).mobileCode = localPhoneContact.mobileCode;
        ((PhoneContact)localObject2).bindingDate = localPhoneContact.bindingDate;
        ((PhoneContact)localObject2).nickName = localPhoneContact.nickName;
        ((PhoneContact)localObject2).isUploaded = localPhoneContact.isUploaded;
        ((PhoneContact)localObject2).originBinder = localPhoneContact.originBinder;
        ((PhoneContact)localObject2).ability = localPhoneContact.ability;
      }
    }
    localObject1 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = paramConcurrentHashMap;
    ((ConcurrentHashMap)localObject1).clear();
  }
  
  private boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i = a(paramRespondQueryQQBindingStat);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "syncBindState newState = " + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = i;
      }
      return bool1;
      if (this.jdField_a_of_type_Int != i) {
        t();
      }
      this.jdField_a_of_type_Int = i;
      continue;
      if (paramRespondQueryQQBindingStat.lastUsedFlag == 2L) {
        bool1 = true;
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = i;
        break;
        bool1 = bool2;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L)
        {
          t();
          bool1 = bool2;
        }
      }
      this.jdField_a_of_type_Int = i;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length - 1;
    while (k > j * 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(k - j)];
      paramArrayOfByte[(k - j)] = i;
      j += 1;
    }
    return paramArrayOfByte;
  }
  
  private String d()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contact_bind_info_unique", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      return localObject1;
    }
    Object localObject2 = e();
    localObject1 = localObject2;
    if (((String)localObject2).equals("|")) {
      localObject1 = e();
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("|"))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "|" + ((Random)localObject1).nextLong();
    }
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject1).putString("contact_bind_info_unique", (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    return localObject2;
  }
  
  private List d()
  {
    if (this.jdField_a_of_type_JavaUtilVector == null) {}
    while (this.jdField_a_of_type_JavaUtilVector.size() <= 0) {
      return null;
    }
    Object localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilVector.size());
    Object localObject1 = this.jdField_a_of_type_JavaUtilVector.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (RecommendContact)((Iterator)localObject1).next();
      if (!((RecommendContact)localObject3).isRead) {
        ((ArrayList)localObject2).add(localObject3);
      }
    }
    localObject1 = new ArrayList(((ArrayList)localObject2).size());
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    int i = ((ArrayList)localObject1).size() - 1;
    if (i >= 0)
    {
      localObject2 = (RecommendContact)((ArrayList)localObject1).get(i);
      if (((RecommendContact)localObject2).type == 0)
      {
        localObject3 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((RecommendContact)localObject2).key);
        if ((localObject3 != null) && (((PhoneContact)localObject3).uin != null)) {
          break label161;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label161:
        ((RecommendContact)localObject2).nationCode = ((PhoneContact)localObject3).nationCode;
        ((RecommendContact)localObject2).mobileCode = ((PhoneContact)localObject3).mobileCode;
        ((RecommendContact)localObject2).contactName = ((PhoneContact)localObject3).name;
        ((RecommendContact)localObject2).uin = ((PhoneContact)localObject3).uin;
        ((RecommendContact)localObject2).nickName = ((PhoneContact)localObject3).nickName;
        ((RecommendContact)localObject2).originBinder = ((PhoneContact)localObject3).originBinder;
        localObject3 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(((PhoneContact)localObject3).uin);
        if ((localObject3 != null) && (((Friends)localObject3).groupid >= 0))
        {
          if ((((Friends)localObject3).remark != null) && (((Friends)localObject3).remark.length() > 0)) {
            ((RecommendContact)localObject2).nickName = ((Friends)localObject3).remark;
          } else if ((((Friends)localObject3).name != null) && (((Friends)localObject3).name.length() > 0)) {
            ((RecommendContact)localObject2).nickName = ((Friends)localObject3).name;
          }
        }
        else {
          ((RecommendContact)localObject2).uin = "0";
        }
      }
    }
    return localObject1;
  }
  
  private void d(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hml(this, paramList));
  }
  
  private String e()
  {
    try
    {
      String str = QQDeviceInfo.a("master");
      return str + "|" + "";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private static String e(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = "#";; paramString = String.valueOf(paramString.charAt(0)).toUpperCase())
    {
      String str = paramString;
      if (!StringUtil.c(paramString.charAt(0))) {
        str = "#";
      }
      return str;
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidDatabaseContentObserver = new hme(this, new Handler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper()));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_AndroidDatabaseContentObserver);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    a(0L);
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.f.clear();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      i();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void p()
  {
    if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_a_of_type_Int = 9;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 28);
    localNewIntent.putExtra("next_flag", 0L);
    localNewIntent.putExtra("time_stamp", this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L));
    localNewIntent.putExtra("session_id", new byte[0]);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "updateRecommandList " + this.jdField_a_of_type_JavaUtilVector.size());
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_JavaUtilVector.size() - 1;
    if (i >= 0)
    {
      RecommendContact localRecommendContact = (RecommendContact)this.jdField_a_of_type_JavaUtilVector.get(i);
      String str;
      if (localRecommendContact.type == 0)
      {
        str = localRecommendContact.key;
        if ((str != null) && (str.length() > 0))
        {
          PhoneContact localPhoneContact = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if ((localPhoneContact != null) && (!TextUtils.isEmpty(localPhoneContact.uin)) && (!localHashSet.contains(str))) {
            break label175;
          }
          localArrayList.add(localRecommendContact);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localRecommendContact);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label175:
        localHashSet.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "updateRecommandList delList size :" + localArrayList.size());
    }
    if (localArrayList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilVector.removeAll(localArrayList);
      b(false);
    }
  }
  
  private void r()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = a(localArrayList1, localArrayList2);
      if ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()))
      {
        a(this.jdField_b_of_type_JavaLangString, localArrayList1, localArrayList2, localArrayList3);
        e();
      }
      return;
    }
    finally {}
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "initRecommendList");
    }
    if ((this.jdField_a_of_type_JavaUtilVector == null) || (!this.jdField_a_of_type_JavaUtilVector.isEmpty())) {}
    List localList;
    do
    {
      return;
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class);
    } while ((localList == null) || (localList.isEmpty()));
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.addAll(localList);
        if (NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break;
        }
        if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
        {
          bool = true;
          b(bool);
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("contact_bind_info_upload", false).commit();
    u();
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.jdField_b_of_type_Boolean = false;
    a(0L);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.f.clear();
    e();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new PhoneContact().getTableName(), null, null);
      i();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilVector.size();
  }
  
  public int a(List paramList)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if (localRespondQueryQQBindingStat == null) {
      return jdField_c_of_type_Int;
    }
    if (this.jdField_a_of_type_Hmm != null) {
      this.jdField_a_of_type_Hmm.cancel(true);
    }
    this.jdField_a_of_type_Hmm = new hmm(this, null);
    this.jdField_a_of_type_Hmm.a(paramList);
    this.jdField_a_of_type_Hmm.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return jdField_b_of_type_Int;
  }
  
  public RespondQueryQQBindingStat a()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    if (localSharedPreferences == null) {}
    do
    {
      return null;
      localRespondQueryQQBindingStat.nationCode = localSharedPreferences.getString("contact_bind_info_nation", null);
    } while (localRespondQueryQQBindingStat.nationCode == null);
    localRespondQueryQQBindingStat.mobileNo = localSharedPreferences.getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = localSharedPreferences.getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = localSharedPreferences.getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = localSharedPreferences.getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = localSharedPreferences.getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = localSharedPreferences.getLong("contact_bind_info_flag", 0L);
    localRespondQueryQQBindingStat.type = localSharedPreferences.getInt("contact_bind_type", 0);
    return localRespondQueryQQBindingStat;
  }
  
  public PhoneContact a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public RecommendContact a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0) {
      return (RecommendContact)this.jdField_a_of_type_JavaUtilVector.get(this.jdField_a_of_type_JavaUtilVector.size() - 1);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public List a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, localException.toString());
        }
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseContentObserver != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_AndroidDatabaseContentObserver);
      this.jdField_a_of_type_AndroidDatabaseContentObserver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("contact_bind_strategy_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "localVersion=" + l + "|configVersion=" + paramLong1 + "|popWindowsCount=" + paramLong2 + "|popWindowsTime=" + paramLong3 + "|popCloseCount=" + paramLong4);
    }
    if (l != paramLong1)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      l = paramLong3;
      if (paramLong3 < 86400L) {
        l = 86400L;
      }
      paramLong3 = paramLong2;
      if (paramLong2 <= 0L) {
        paramLong3 = 1L;
      }
      localEditor.putLong("contact_bind_strategy_version", paramLong1);
      localEditor.putLong("contact_bind_strategy_popcount", paramLong3);
      localEditor.putLong("contact_bind_strategy_poptime", l);
      localEditor.putLong("contact_bind_strategy_closecount", paramLong4);
      localEditor.putLong("contact_bind_strategy_forcepopup", paramLong5);
      localEditor.putLong("contact_bind_strategy_user_closecount", 0L);
      localEditor.commit();
      ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(long paramLong1, long paramLong2, List paramList1, List paramList2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "saveContactFromServer start");
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = paramList1;
      }
      while (paramLong1 != 4294967295L)
      {
        return;
        this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
      }
      paramLong1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("queryContactTimeStamp", 0L);
    }
    finally {}
    a(paramLong2);
    Object localObject1;
    if ((paramLong1 != 0L) && (paramLong1 != paramLong2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "saveContactFromServer localTimestamp != timestamp");
      }
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramList1.a();
      try
      {
        paramList2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.elements();
        while (paramList2.hasMoreElements())
        {
          localObject1 = (PhoneContact)paramList2.nextElement();
          if ((((PhoneContact)localObject1).uin != null) && (((PhoneContact)localObject1).uin.length() > 0))
          {
            ((PhoneContact)localObject1).bindingDate = 0L;
            ((PhoneContact)localObject1).isRecommend = 0;
            ((PhoneContact)localObject1).uin = "";
            ((PhoneContact)localObject1).originBinder = 0L;
            ((PhoneContact)localObject1).ability = 0;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
          }
        }
      }
      finally
      {
        paramList1.b();
      }
      paramList1.b();
    }
    boolean bool;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramList2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      try
      {
        paramList1.a();
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact", 2, "md52PhoneContact size = " + this.f.size());
          }
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (MobileContactsDetailInfoEncrypt)((Iterator)localObject1).next();
            PhoneContact localPhoneContact = (PhoneContact)this.f.get(((MobileContactsDetailInfoEncrypt)localObject2).contactsInfoEncrypt.toUpperCase());
            if (localPhoneContact != null)
            {
              localPhoneContact.uin = ((MobileContactsDetailInfoEncrypt)localObject2).QQ;
              localPhoneContact.bindingDate = ((MobileContactsDetailInfoEncrypt)localObject2).bindingDate;
              localPhoneContact.nickName = ((MobileContactsDetailInfoEncrypt)localObject2).nickname;
              localPhoneContact.isUploaded = true;
              localPhoneContact.originBinder = ((MobileContactsDetailInfoEncrypt)localObject2).originBinder;
              localPhoneContact.ability = ((MobileContactsDetailInfoEncrypt)localObject2).accountAbi;
              localPhoneContact.unifiedCode = a(((MobileContactsDetailInfoEncrypt)localObject2).MobileNoMask, localPhoneContact.mobileNo);
              localPhoneContact.mobileCode = localPhoneContact.unifiedCode;
              localPhoneContact.nationCode = "";
              localPhoneContact.isUpdated = true;
              if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0")))
              {
                localObject2 = paramList2.c(localPhoneContact.uin);
                if (localObject2 != null) {
                  localPhoneContact.nickName = ((Friends)localObject2).name;
                }
                this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
                paramList2.a(localPhoneContact.unifiedCode, false);
              }
              if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.unifiedCode, localPhoneContact);
              }
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
            }
          }
        }
        paramList2 = this.f.entrySet().iterator();
      }
      finally
      {
        paramList1.b();
      }
      bool = false;
    }
    for (;;)
    {
      if (paramList2.hasNext())
      {
        localObject1 = (PhoneContact)((Map.Entry)paramList2.next()).getValue();
        if (!((PhoneContact)localObject1).isUpdated)
        {
          if ((!TextUtils.isEmpty(((PhoneContact)localObject1).uin)) && (!((PhoneContact)localObject1).uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PhoneContact)localObject1).uin);
          }
          ((PhoneContact)localObject1).uin = "";
          ((PhoneContact)localObject1).isUploaded = true;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject1);
          bool = true;
        }
        else
        {
          ((PhoneContact)localObject1).isUpdated = false;
        }
      }
      else
      {
        paramList1.c();
        paramList1.b();
        for (;;)
        {
          if (bool) {
            q();
          }
          if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) {
            this.jdField_b_of_type_Boolean = true;
          }
          this.jdField_a_of_type_JavaUtilList = null;
          this.jdField_b_of_type_JavaUtilList = null;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PhoneContact", 2, "saveContactFromServer end hasNoBindData = " + bool);
          break;
          bool = false;
        }
      }
    }
  }
  
  public void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = a(a());
    }
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = paramRespondQueryQQBindingStat;
    if (paramRespondQueryQQBindingStat == null) {
      localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
    }
    paramRespondQueryQQBindingStat = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", localRespondQueryQQBindingStat.mobileNo);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", localRespondQueryQQBindingStat.nationCode);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", localRespondQueryQQBindingStat.MobileUniqueNo);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", localRespondQueryQQBindingStat.isRecommend);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", localRespondQueryQQBindingStat.originBinder);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", localRespondQueryQQBindingStat.bindingTime);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", localRespondQueryQQBindingStat.lastUsedFlag);
    paramRespondQueryQQBindingStat.putInt("contact_bind_type", localRespondQueryQQBindingStat.type);
    paramRespondQueryQQBindingStat.commit();
    if (a(localRespondQueryQQBindingStat)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hmk(this));
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.jdField_a_of_type_ArrayOfByte);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 13);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "updateRenameList");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    EntityTransaction localEntityTransaction;
    label135:
    do
    {
      for (;;)
      {
        return;
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label135;
            }
            localPhoneContact = (PhoneContact)paramArrayList.next();
            if (localPhoneContact.getStatus() != 1000) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            PhoneContact localPhoneContact;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContactManager", 2, paramArrayList.getMessage());
            }
            return;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.b();
          }
        }
      }
      localEntityTransaction.c();
    } while (localEntityTransaction == null);
    localEntityTransaction.b();
  }
  
  public void a(List paramList)
  {
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(5);
      Message localMessage = localHandler.obtainMessage(5);
      localMessage.obj = paramList;
      localHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void a(List paramList, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "saveRecommendContact start recommendList size = " + paramList.size());
    }
    if ((paramList != null) && (paramList.size() != 0)) {
      for (;;)
      {
        int i;
        synchronized (this.jdField_a_of_type_JavaUtilVector)
        {
          EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          try
          {
            localEntityTransaction.a();
            i = paramList.size() - 1;
            if (i >= 0)
            {
              Object localObject = (MobileContactsDetailInfoEncrypt)paramList.get(i);
              PhoneContact localPhoneContact = null;
              if (localObject != null) {
                localPhoneContact = (PhoneContact)this.f.get(((MobileContactsDetailInfoEncrypt)localObject).contactsInfoEncrypt.toUpperCase());
              }
              if (localPhoneContact != null)
              {
                if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
                  this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localPhoneContact.unifiedCode);
                }
                localPhoneContact.uin = ((MobileContactsDetailInfoEncrypt)localObject).QQ;
                localPhoneContact.bindingDate = ((MobileContactsDetailInfoEncrypt)localObject).bindingDate;
                localPhoneContact.nickName = ((MobileContactsDetailInfoEncrypt)localObject).nickname;
                localPhoneContact.originBinder = ((MobileContactsDetailInfoEncrypt)localObject).originBinder;
                localPhoneContact.ability = ((MobileContactsDetailInfoEncrypt)localObject).accountAbi;
                if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
                  this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.unifiedCode, localPhoneContact);
                }
                this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localPhoneContact);
                if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
                  this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
                }
                if (((((MobileContactsDetailInfoEncrypt)localObject).QQ == null) || (((MobileContactsDetailInfoEncrypt)localObject).QQ.length() == 0) || (((MobileContactsDetailInfoEncrypt)localObject).QQ.equals("0"))) && ((RecommendContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class, String.valueOf(localPhoneContact.mobileCode)) == null))
                {
                  localObject = new RecommendContact();
                  ((RecommendContact)localObject).mobileNo = localPhoneContact.mobileNo;
                  ((RecommendContact)localObject).uin = localPhoneContact.uin;
                  ((RecommendContact)localObject).timeStamp = paramLong;
                  ((RecommendContact)localObject).isRead = false;
                  ((RecommendContact)localObject).type = 0;
                  ((RecommendContact)localObject).key = localPhoneContact.mobileNo;
                  this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
                  if (!this.jdField_a_of_type_JavaUtilVector.contains(localObject)) {
                    this.jdField_a_of_type_JavaUtilVector.add(localObject);
                  }
                }
              }
            }
            else
            {
              localEntityTransaction.c();
              localEntityTransaction.b();
              NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
              e();
              q();
              b(false);
              j();
              if (QLog.isColorLevel()) {
                QLog.d("PhoneContact", 2, "saveRecommendContact end");
              }
              return;
            }
          }
          finally
          {
            localEntityTransaction.b();
          }
        }
        i -= 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((g()) && ((paramBoolean) || (this.jdField_d_of_type_Boolean))) {
      r();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactManager", 2, "onFirstQueryResp" + jdField_c_of_type_Boolean);
    }
    for (;;)
    {
      int i;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          i = d();
          bool = c();
          if ((i != 7) || (bool)) {
            break label111;
          }
          f();
          return true;
          if (!g()) {
            continue;
          }
          a(true);
        }
      }
      return false;
      label111:
      if ((i != 4) || (!bool)) {}
    }
  }
  
  public int b()
  {
    return d();
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {
      return (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (localEntityManager == null) {
        return null;
      }
      PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.a(PhoneNumInfo.class, paramString);
      if (localPhoneNumInfo != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localPhoneNumInfo.uin);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneNumInfo.uin, paramString);
      }
      localEntityManager.a();
    }
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List b()
  {
    long l = System.currentTimeMillis();
    Object localObject2;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    FriendManager localFriendManager;
    Object localObject1;
    label236:
    String str2;
    label286:
    label289:
    label306:
    int j;
    label446:
    int i;
    label466:
    int k;
    label479:
    int m;
    label500:
    Friends localFriends;
    label508:
    int n;
    if (this.jdField_c_of_type_JavaUtilList == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values());
      Collections.sort((List)localObject2, new hmf(this));
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (((List)localObject2).size() > 0)
      {
        if (a() == null)
        {
          localObject1 = null;
          return localObject1;
        }
        String str1 = a().mobileNo;
        localObject1 = null;
        Iterator localIterator = ((List)localObject2).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (PhoneContact)localIterator.next();
            if ((str1 == null) || (!str1.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
            {
              localObject2 = (PhoneContact)((PhoneContact)localObject2).clone();
              if (((PhoneContact)localObject2).pinyinFirst == null) {
                ((PhoneContact)localObject2).pinyinFirst = e(((PhoneContact)localObject2).pinyinInitial);
              }
              if (localObject1 == null)
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(((PhoneContact)localObject2).uin))
                {
                  if (!((PhoneContact)localObject2).uin.equals("0")) {
                    break label289;
                  }
                  localObject1 = null;
                  if ((localObject1 == null) || (((Friends)localObject1).groupid < 0)) {
                    break label306;
                  }
                  ((PhoneContact)localObject2).nickName = ContactSorter.a((Friends)localObject1);
                  ((PhoneContact)localObject2).remark = ((Friends)localObject1).remark;
                  ((PhoneContact)localObject2).faceUrl = Short.toString(((Friends)localObject1).faceid);
                }
                for (localObject1 = localObject2;; localObject1 = localObject2)
                {
                  break;
                  localObject1 = localFriendManager.c(((PhoneContact)localObject2).uin);
                  break label236;
                  ((PhoneContact)localObject2).uin = "0";
                }
              }
              if (((PhoneContact)localObject2).contactID == ((PhoneContact)localObject1).contactID)
              {
                str2 = ((PhoneContact)localObject1).mobileNo + "|" + ((PhoneContact)localObject2).mobileNo;
                if (QLog.isColorLevel()) {
                  QLog.d("PhoneContactManager", 2, "getContactListForDisplay: conbine contact contact name is:" + ((PhoneContact)localObject1).name + "uin is :" + ((PhoneContact)localObject1).uin + "number is:" + ((PhoneContact)localObject1).mobileNo);
                }
                if (!TextUtils.isEmpty(((PhoneContact)localObject1).uin))
                {
                  j = 1;
                  if ((j == 0) || (((PhoneContact)localObject1).uin.equals("0"))) {
                    break label610;
                  }
                  i = 1;
                  if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
                    break label615;
                  }
                  k = 1;
                  if ((k == 0) || (((PhoneContact)localObject2).uin.equals("0"))) {
                    break label620;
                  }
                  m = 1;
                  if (m != 0) {
                    break label626;
                  }
                  localFriends = null;
                  if ((localFriends == null) || (localFriends.groupid < 0)) {
                    break label643;
                  }
                  m = 1;
                  label524:
                  n = 2;
                  if (i == 0) {
                    break label649;
                  }
                  i = 0;
                  label533:
                  if (m == 0) {
                    break label661;
                  }
                  j = 0;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label540:
      if (i > j)
      {
        localObject1 = localObject2;
        if (k != 0)
        {
          if (m == 0) {
            break label670;
          }
          ((PhoneContact)localObject2).nickName = ContactSorter.a(localFriends);
          ((PhoneContact)localObject2).remark = localFriends.remark;
          ((PhoneContact)localObject2).faceUrl = Short.toString(localFriends.faceid);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        ((PhoneContact)localObject1).mobileNo = str2;
        break label286;
        j = 0;
        break label446;
        label610:
        i = 0;
        break label466;
        label615:
        k = 0;
        break label479;
        label620:
        m = 0;
        break label500;
        label626:
        localFriends = localFriendManager.c(((PhoneContact)localObject2).uin);
        break label508;
        label643:
        m = 0;
        break label524;
        label649:
        i = n;
        if (j == 0) {
          break label533;
        }
        i = 1;
        break label533;
        label661:
        if (k == 0) {
          break label940;
        }
        j = 1;
        break label540;
        label670:
        ((PhoneContact)localObject2).uin = "0";
        localObject1 = localObject2;
        continue;
        localArrayList1.add(localObject1);
        localObject1 = localObject2;
        if (TextUtils.isEmpty(((PhoneContact)localObject2).uin)) {
          break label286;
        }
        if (((PhoneContact)localObject2).uin.equals("0")) {}
        for (localObject1 = null;; localObject1 = localFriendManager.c(((PhoneContact)localObject2).uin))
        {
          if ((localObject1 == null) || (((Friends)localObject1).groupid < 0)) {
            break label795;
          }
          ((PhoneContact)localObject2).nickName = ContactSorter.a((Friends)localObject1);
          ((PhoneContact)localObject2).remark = ((Friends)localObject1).remark;
          ((PhoneContact)localObject2).faceUrl = Short.toString(((Friends)localObject1).faceid);
          localObject1 = localObject2;
          break;
        }
        label795:
        ((PhoneContact)localObject2).uin = "0";
        localObject1 = localObject2;
        break label286;
        if (localObject1 != null) {
          localArrayList1.add(localObject1);
        }
        localObject1 = new hmg(this);
        Collections.sort(localArrayList1, (Comparator)localObject1);
        Collections.sort(localArrayList2, (Comparator)localObject1);
        this.jdField_c_of_type_JavaUtilList = localArrayList1;
        this.jdField_d_of_type_JavaUtilList = localArrayList2;
        localObject2 = new ArrayList();
        ((List)localObject2).add(this.jdField_c_of_type_JavaUtilList);
        ((List)localObject2).add(this.jdField_d_of_type_JavaUtilList);
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PhoneContactManager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l));
        return localObject2;
      }
      label940:
      j = 2;
    }
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.f.clear();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject).next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
          if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.uin, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPhoneContact.unifiedCode, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.md5)) {
            this.f.put(localPhoneContact.md5, localPhoneContact);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContactManager", 2, "No contacts.");
      }
      this.jdField_b_of_type_Boolean = true;
      e();
      s();
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hmi(this, paramString));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext())
        {
          RecommendContactMsg localRecommendContactMsg = (RecommendContactMsg)paramList.next();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
          if (localIterator.hasNext())
          {
            RecommendContact localRecommendContact = (RecommendContact)localIterator.next();
            if ((!localRecommendContact.key.equals(localRecommendContactMsg.mobileNo)) && (!localRecommendContact.key.equals(localRecommendContactMsg.uin))) {
              break;
            }
            if (!localRecommendContact.isRead)
            {
              localRecommendContact.isRead = true;
              localArrayList.add(localRecommendContact);
            }
          }
        }
      }
    }
    b(false);
    d(localArrayList);
  }
  
  public void b(List paramList, long paramLong)
  {
    EntityTransaction localEntityTransaction;
    if ((paramList != null) && (paramList.size() > 0)) {
      localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
    for (;;)
    {
      int i;
      try
      {
        localEntityTransaction.a();
        i = paramList.size() - 1;
        if (i >= 0)
        {
          CircleFriendInfo localCircleFriendInfo = (CircleFriendInfo)paramList.get(i);
          if ((localCircleFriendInfo != null) && (localCircleFriendInfo.uin >= 0L) && ((RecommendContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class, String.valueOf(localCircleFriendInfo.uin)) == null))
          {
            RecommendContact localRecommendContact = new RecommendContact();
            localRecommendContact.uin = String.valueOf(localCircleFriendInfo.uin);
            localRecommendContact.nickName = localCircleFriendInfo.strRemark;
            localRecommendContact.source = localCircleFriendInfo.source;
            localRecommendContact.timeStamp = paramLong;
            localRecommendContact.type = 1;
            localRecommendContact.isRead = false;
            localRecommendContact.key = String.valueOf(localCircleFriendInfo.uin);
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localRecommendContact);
            if (!this.jdField_a_of_type_JavaUtilVector.contains(localRecommendContact)) {
              this.jdField_a_of_type_JavaUtilVector.add(localRecommendContact);
            }
          }
        }
        else
        {
          localEntityTransaction.c();
          return;
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
      i -= 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      RecommendMessage localRecommendMessage = new RecommendMessage(d(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a(localRecommendMessage);
    }
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public PhoneContact c(String paramString)
  {
    PhoneContact localPhoneContact = null;
    if (this.jdField_b_of_type_Boolean) {
      localPhoneContact = (PhoneContact)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      return localPhoneContact;
    }
    return (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PhoneContact.class, "mobileCode=?", new String[] { paramString });
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public String c(String paramString)
  {
    Object localObject = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localObject == null) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).a(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public List c()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (;;)
    {
      HashSet localHashSet;
      int i;
      Object localObject2;
      RecommendContactMsg localRecommendContactMsg;
      Object localObject1;
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContactManager", 2, "getRecommendContactList size is " + this.jdField_a_of_type_JavaUtilVector.size());
        }
        localArrayList2.addAll(this.jdField_a_of_type_JavaUtilVector);
        if (localArrayList2.isEmpty()) {
          return null;
        }
        localHashSet = new HashSet();
        i = localArrayList2.size() - 1;
        if (i < 0) {
          break label696;
        }
        localObject2 = (RecommendContact)localArrayList2.get(i);
        localRecommendContactMsg = new RecommendContactMsg();
        if ((((RecommendContact)localObject2).type != 1) || (((RecommendContact)localObject2).uin == null) || (((RecommendContact)localObject2).uin.length() <= 0)) {
          break label353;
        }
        if (localObject2 == null) {
          break label712;
        }
        localRecommendContactMsg.timeStamp = ((RecommendContact)localObject2).timeStamp;
        localRecommendContactMsg.uin = ((RecommendContact)localObject2).uin;
        localRecommendContactMsg.nickName = ((RecommendContact)localObject2).nickName;
        localRecommendContactMsg.source = ((RecommendContact)localObject2).source;
        localRecommendContactMsg.isRead = ((RecommendContact)localObject2).isRead;
        localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject1 != null) && (((FriendManager)localObject1).b(localRecommendContactMsg.uin)))
        {
          localRecommendContactMsg.friendStatus = 2;
          if (!localHashSet.add(localRecommendContactMsg.uin)) {
            break label712;
          }
          localArrayList1.add(localRecommendContactMsg);
          break label712;
        }
        if ((localObject1 != null) && ((((FriendManager)localObject1).e(localRecommendContactMsg.uin)) || (((FriendManager)localObject1).e(localRecommendContactMsg.nationCode + localRecommendContactMsg.mobileCode)))) {
          localRecommendContactMsg.friendStatus = 1;
        }
      }
      localRecommendContactMsg.friendStatus = 0;
      continue;
      label353:
      if (((RecommendContact)localObject2).type == 0)
      {
        localObject1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((RecommendContact)localObject2).key);
        if ((localObject1 != null) && (((PhoneContact)localObject1).uin != null))
        {
          localRecommendContactMsg.timeStamp = ((RecommendContact)localObject2).timeStamp;
          localRecommendContactMsg.mobileNo = ((RecommendContact)localObject2).key;
          localRecommendContactMsg.nationCode = ((PhoneContact)localObject1).nationCode;
          localRecommendContactMsg.mobileCode = ((PhoneContact)localObject1).mobileCode;
          localRecommendContactMsg.contactName = ((PhoneContact)localObject1).name;
          localRecommendContactMsg.uin = ((PhoneContact)localObject1).uin;
          localRecommendContactMsg.nickName = ((PhoneContact)localObject1).nickName;
          localRecommendContactMsg.isRead = ((RecommendContact)localObject2).isRead;
          localRecommendContactMsg.originBinder = ((PhoneContact)localObject1).originBinder;
          localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          localObject1 = ((FriendManager)localObject2).c(((PhoneContact)localObject1).uin);
          if ((localObject1 != null) && (((Friends)localObject1).groupid >= 0)) {
            if ((((Friends)localObject1).remark != null) && (((Friends)localObject1).remark.length() > 0))
            {
              localRecommendContactMsg.nickName = ((Friends)localObject1).remark;
              localRecommendContactMsg.faceid = ((Friends)localObject1).faceid;
              localRecommendContactMsg.groupId = ((Friends)localObject1).groupid;
              localRecommendContactMsg.friendStatus = 2;
            }
          }
          for (;;)
          {
            if (localHashSet.add(localRecommendContactMsg.mobileCode))
            {
              localList.add(localRecommendContactMsg);
              break label712;
              if ((((Friends)localObject1).name == null) || (((Friends)localObject1).name.length() <= 0)) {
                break;
              }
              localRecommendContactMsg.nickName = ((Friends)localObject1).name;
              break;
              localRecommendContactMsg.uin = "0";
              if (((FriendManager)localObject2).e(localRecommendContactMsg.nationCode + localRecommendContactMsg.mobileCode))
              {
                localRecommendContactMsg.friendStatus = 1;
              }
              else
              {
                localRecommendContactMsg.friendStatus = 0;
                continue;
                Collections.sort(localList, new hmh(this));
                return localList;
              }
            }
          }
        }
      }
      label696:
      label712:
      i -= 1;
    }
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 12);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void c(String paramString1, String paramString2)
  {
    int i = 0;
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      paramString1 = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString1 != null)
      {
        int j = 1;
        paramString1.uin = paramString2;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramString1);
        i = j;
        if (!TextUtils.isEmpty(paramString1.uin))
        {
          i = j;
          if (!paramString1.uin.equals("0"))
          {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
            i = j;
          }
        }
      }
      localEntityTransaction.c();
      localEntityTransaction.b();
      if (i != 0) {}
      return;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public void c(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        try
        {
          localEntityTransaction.a();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.b();
        }
        localEntityTransaction.c();
      }
      finally {}
      localEntityTransaction.b();
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("contact_bind_info_upload", false);
  }
  
  public int d()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.jdField_a_of_type_Int = a(a());
      return d();
    case 6: 
      return 6;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return 7;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void d()
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ContactBindServlet.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramString1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).b(localPhoneNumInfo);
        ((EntityManager)localObject).a();
      }
    }
  }
  
  public boolean d()
  {
    if (!"5.9.3".equals(this.jdField_b_of_type_AndroidContentSharedPreferences.getString("phone_version_run", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.jdField_b_of_type_AndroidContentSharedPreferences.edit().remove("phone_app_first_run").commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactListView.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 100L);
    }
    localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ContactsInnerFrame.class);
    if (localHandler != null)
    {
      localHandler.removeMessages(3);
      localHandler.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public boolean e()
  {
    if (!"5.9.3".equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("phone_contact_need_star_v", ""))) {}
    for (boolean bool = true; bool; bool = false)
    {
      int i = d();
      if ((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 6)) {
        break;
      }
      return false;
    }
    return bool;
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Int = 6;
      ArrayList localArrayList = a();
      a(this.jdField_b_of_type_JavaLangString, localArrayList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean f()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ab, 4000);
    if (localList == null) {
      return false;
    }
    int i = localList.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0) && ((localMessageRecord.msgtype == 1) || (localMessageRecord.msgtype == 0)) && (!localMessageRecord.isread)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hmj(this));
    }
  }
  
  public boolean g()
  {
    int i = d();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + i);
    }
    return i >= 7;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "deleteRecommendListSync ");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class);
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Int != 6)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int != 3) {}
    }
    else
    {
      bool1 = bool2;
      if (a() != null)
      {
        bool1 = bool2;
        if (a().lastUsedFlag == 2L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_JavaUtilVector == null) || (this.jdField_a_of_type_JavaUtilVector.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteContactRecommendList ");
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
    j();
    ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).d();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RecommendContact.class);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendListView.class);
      if (localHandler != null) {
        localHandler.sendEmptyMessage(0);
      }
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "runPhoneContact");
    }
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("phone_version_run", "5.9.3");
    localEditor.commit();
  }
  
  public void l()
  {
    k();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("phone_contact_need_star_v", "5.9.3");
    localEditor.commit();
  }
  
  public void m()
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject1 = new NewFriendMessage(0, 0, false);
        ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a((NewFriendMessage)localObject1);
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        RecommendContact localRecommendContact = (RecommendContact)((Iterator)localObject1).next();
        if (!localRecommendContact.isRead) {
          localRecommendContact.isRead = true;
        }
      }
    }
    d(this.jdField_a_of_type_JavaUtilVector);
  }
  
  public void onDestroy()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_JavaUtilVector.clear();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */