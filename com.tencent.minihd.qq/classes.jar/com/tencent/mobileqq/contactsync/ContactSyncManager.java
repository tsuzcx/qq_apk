package com.tencent.mobileqq.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Handler;
import android.os.RemoteException;
import android.provider.ContactsContract.AggregationExceptions;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import hxx;
import hxy;
import hxz;
import hya;
import hyd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;

public class ContactSyncManager
  implements Manager
{
  private static final int jdField_a_of_type_Int = 500;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.Manager";
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static String jdField_b_of_type_JavaLangString = Constants.jdField_d_of_type_JavaLangString;
  private static final String jdField_c_of_type_JavaLangString = "contactsync";
  private static final String e = "pref_remove_account_prefix";
  private Account jdField_a_of_type_AndroidAccountsAccount = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public QQAppInterface a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new hxx(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new hxz(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private volatile boolean jdField_c_of_type_Boolean;
  private final String jdField_d_of_type_JavaLangString = "pref_sync_contact";
  private volatile boolean jdField_d_of_type_Boolean = false;
  private String f = "com.android.contacts";
  
  public ContactSyncManager(QQAppInterface paramQQAppInterface)
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "ContactSyncManager onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("contactsync", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_sync_contact", true);
    for (;;)
    {
      try
      {
        b();
        boolean bool = d();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "ContactSyncManager oncreate | support = " + bool);
        }
        if (!bool) {
          continue;
        }
        paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ContactSync.Manager", 2, "initSyncAccount e = ", localThrowable);
        continue;
      }
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("pref_remove_account_prefix" + paramQQAppInterface.a(), false);
      return;
      c();
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public static String a(String paramString)
  {
    String str = paramString;
    if (Build.MANUFACTURER.contains("OPPO")) {
      str = paramString.replace("'", "").replace("%", "").replace("_", "-").replace("/", "").replace("[", "").replace("]", "").replace("&", "");
    }
    return str;
  }
  
  /* Error */
  private List a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_1
    //   11: aload_1
    //   12: aload_0
    //   13: invokespecial 194	com/tencent/mobileqq/contactsync/ContactSyncManager:c	()Ljava/lang/String;
    //   16: invokestatic 199	hyd:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   19: ldc 201
    //   21: aconst_null
    //   22: invokevirtual 207	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   25: pop
    //   26: new 209	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 210	java/util/ArrayList:<init>	()V
    //   33: astore 4
    //   35: aload_1
    //   36: aload_0
    //   37: invokespecial 194	com/tencent/mobileqq/contactsync/ContactSyncManager:c	()Ljava/lang/String;
    //   40: invokestatic 199	hyd:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: getstatic 213	hyd:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +158 -> 212
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: aload_2
    //   62: invokeinterface 223 1 0
    //   67: invokevirtual 227	java/util/ArrayList:ensureCapacity	(I)V
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: invokeinterface 230 1 0
    //   78: ifeq +134 -> 212
    //   81: aload_2
    //   82: astore_1
    //   83: new 232	com/tencent/mobileqq/contactsync/RawContact
    //   86: dup
    //   87: invokespecial 233	com/tencent/mobileqq/contactsync/RawContact:<init>	()V
    //   90: astore_3
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: aload_2
    //   95: iconst_0
    //   96: invokeinterface 237 2 0
    //   101: putfield 239	com/tencent/mobileqq/contactsync/RawContact:jdField_a_of_type_Long	J
    //   104: aload_2
    //   105: astore_1
    //   106: aload_3
    //   107: aload_2
    //   108: iconst_1
    //   109: invokeinterface 243 2 0
    //   114: putfield 245	com/tencent/mobileqq/contactsync/RawContact:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   117: aload_2
    //   118: astore_1
    //   119: aload_3
    //   120: aload_2
    //   121: iconst_2
    //   122: invokeinterface 249 2 0
    //   127: putfield 251	com/tencent/mobileqq/contactsync/RawContact:jdField_a_of_type_Int	I
    //   130: aload_2
    //   131: astore_1
    //   132: aload 4
    //   134: aload_3
    //   135: invokevirtual 255	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: goto -69 -> 70
    //   142: astore_3
    //   143: aload_2
    //   144: astore_1
    //   145: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +15 -> 163
    //   151: aload_2
    //   152: astore_1
    //   153: ldc 15
    //   155: iconst_2
    //   156: ldc_w 257
    //   159: aload_3
    //   160: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: ifnull +9 -> 173
    //   167: aload_2
    //   168: invokeinterface 260 1 0
    //   173: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +33 -> 209
    //   179: ldc 15
    //   181: iconst_2
    //   182: new 116	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 262
    //   192: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 4
    //   197: invokevirtual 265	java/util/ArrayList:size	()I
    //   200: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload 4
    //   211: areturn
    //   212: aload_2
    //   213: ifnull -40 -> 173
    //   216: aload_2
    //   217: invokeinterface 260 1 0
    //   222: goto -49 -> 173
    //   225: astore_1
    //   226: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -56 -> 173
    //   232: ldc 15
    //   234: iconst_2
    //   235: ldc_w 270
    //   238: aload_1
    //   239: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   242: goto -69 -> 173
    //   245: astore_1
    //   246: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq -76 -> 173
    //   252: ldc 15
    //   254: iconst_2
    //   255: ldc_w 270
    //   258: aload_1
    //   259: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: goto -89 -> 173
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_1
    //   268: aload_1
    //   269: ifnull +9 -> 278
    //   272: aload_1
    //   273: invokeinterface 260 1 0
    //   278: aload_2
    //   279: athrow
    //   280: astore_1
    //   281: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq -6 -> 278
    //   287: ldc 15
    //   289: iconst_2
    //   290: ldc_w 270
    //   293: aload_1
    //   294: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   297: goto -19 -> 278
    //   300: astore_2
    //   301: goto -33 -> 268
    //   304: astore_3
    //   305: aconst_null
    //   306: astore_2
    //   307: goto -164 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	ContactSyncManager
    //   10	143	1	localObject1	Object
    //   225	14	1	localThrowable1	Throwable
    //   245	14	1	localThrowable2	Throwable
    //   267	6	1	localObject2	Object
    //   280	14	1	localThrowable3	Throwable
    //   52	165	2	localCursor	android.database.Cursor
    //   265	14	2	localObject3	Object
    //   300	1	2	localObject4	Object
    //   306	1	2	localObject5	Object
    //   90	45	3	localRawContact	RawContact
    //   142	18	3	localException1	java.lang.Exception
    //   304	1	3	localException2	java.lang.Exception
    //   33	177	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   59	70	142	java/lang/Exception
    //   72	81	142	java/lang/Exception
    //   83	91	142	java/lang/Exception
    //   93	104	142	java/lang/Exception
    //   106	117	142	java/lang/Exception
    //   119	130	142	java/lang/Exception
    //   132	139	142	java/lang/Exception
    //   216	222	225	java/lang/Throwable
    //   167	173	245	java/lang/Throwable
    //   35	53	265	finally
    //   272	278	280	java/lang/Throwable
    //   59	70	300	finally
    //   72	81	300	finally
    //   83	91	300	finally
    //   93	104	300	finally
    //   106	117	300	finally
    //   119	130	300	finally
    //   132	139	300	finally
    //   145	151	300	finally
    //   153	163	300	finally
    //   35	53	304	java/lang/Exception
  }
  
  private Map a()
  {
    List localList = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if (localList != null)
    {
      HashMap localHashMap = new HashMap(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (!TextUtils.isEmpty(localPhoneContact.uin)) {
          localHashMap.put(localPhoneContact.mobileNo, localPhoneContact);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "getQQContacts | allList.size = " + localList.size() + " | map.size=" + localHashMap.size());
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  /* Error */
  private Set a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokestatic 331	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   10: invokevirtual 335	android/accounts/AccountManager:getAccounts	()[Landroid/accounts/Account;
    //   13: pop
    //   14: aload_0
    //   15: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   24: astore_2
    //   25: new 41	java/util/HashSet
    //   28: dup
    //   29: invokespecial 44	java/util/HashSet:<init>	()V
    //   32: astore_1
    //   33: aload_2
    //   34: getstatic 341	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   37: iconst_1
    //   38: anewarray 158	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc_w 343
    //   46: aastore
    //   47: ldc_w 345
    //   50: iconst_1
    //   51: anewarray 158	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc_w 347
    //   59: aastore
    //   60: aconst_null
    //   61: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +254 -> 320
    //   69: aload_2
    //   70: astore_3
    //   71: new 41	java/util/HashSet
    //   74: dup
    //   75: aload_2
    //   76: invokeinterface 223 1 0
    //   81: invokespecial 348	java/util/HashSet:<init>	(I)V
    //   84: astore 4
    //   86: aload_2
    //   87: astore_3
    //   88: aload_2
    //   89: invokeinterface 230 1 0
    //   94: ifeq +107 -> 201
    //   97: aload_2
    //   98: astore_3
    //   99: aload 4
    //   101: aload_2
    //   102: iconst_0
    //   103: invokeinterface 237 2 0
    //   108: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokeinterface 357 2 0
    //   116: pop
    //   117: goto -31 -> 86
    //   120: astore_3
    //   121: aload 4
    //   123: astore_1
    //   124: aload_3
    //   125: astore 4
    //   127: aload_2
    //   128: astore_3
    //   129: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +16 -> 148
    //   135: aload_2
    //   136: astore_3
    //   137: ldc 15
    //   139: iconst_2
    //   140: ldc_w 359
    //   143: aload 4
    //   145: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_1
    //   149: astore_3
    //   150: aload_2
    //   151: ifnull +11 -> 162
    //   154: aload_2
    //   155: invokeinterface 260 1 0
    //   160: aload_1
    //   161: astore_3
    //   162: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +34 -> 199
    //   168: ldc 15
    //   170: iconst_2
    //   171: new 116	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 361
    //   181: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_3
    //   185: invokeinterface 362 1 0
    //   190: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_3
    //   200: areturn
    //   201: aload 4
    //   203: astore_1
    //   204: aload_1
    //   205: astore_3
    //   206: aload_2
    //   207: ifnull -45 -> 162
    //   210: aload_2
    //   211: invokeinterface 260 1 0
    //   216: aload_1
    //   217: astore_3
    //   218: goto -56 -> 162
    //   221: astore_2
    //   222: aload_1
    //   223: astore_3
    //   224: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq -65 -> 162
    //   230: ldc 15
    //   232: iconst_2
    //   233: ldc_w 364
    //   236: aload_2
    //   237: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_1
    //   241: astore_3
    //   242: goto -80 -> 162
    //   245: astore_2
    //   246: aload_1
    //   247: astore_3
    //   248: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -89 -> 162
    //   254: ldc 15
    //   256: iconst_2
    //   257: ldc_w 364
    //   260: aload_2
    //   261: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload_1
    //   265: astore_3
    //   266: goto -104 -> 162
    //   269: astore_1
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: ifnull +9 -> 282
    //   276: aload_3
    //   277: invokeinterface 260 1 0
    //   282: aload_1
    //   283: athrow
    //   284: astore_2
    //   285: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -6 -> 282
    //   291: ldc 15
    //   293: iconst_2
    //   294: ldc_w 364
    //   297: aload_2
    //   298: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: goto -19 -> 282
    //   304: astore_1
    //   305: goto -33 -> 272
    //   308: astore 4
    //   310: aconst_null
    //   311: astore_2
    //   312: goto -185 -> 127
    //   315: astore 4
    //   317: goto -190 -> 127
    //   320: goto -116 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	ContactSyncManager
    //   32	233	1	localObject1	Object
    //   269	14	1	localObject2	Object
    //   304	1	1	localObject3	Object
    //   24	187	2	localObject4	Object
    //   221	16	2	localThrowable1	Throwable
    //   245	16	2	localThrowable2	Throwable
    //   284	14	2	localThrowable3	Throwable
    //   311	1	2	localObject5	Object
    //   70	29	3	localObject6	Object
    //   120	5	3	localException1	java.lang.Exception
    //   128	149	3	localObject7	Object
    //   84	118	4	localObject8	Object
    //   308	1	4	localException2	java.lang.Exception
    //   315	1	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   88	97	120	java/lang/Exception
    //   99	117	120	java/lang/Exception
    //   210	216	221	java/lang/Throwable
    //   154	160	245	java/lang/Throwable
    //   33	65	269	finally
    //   276	282	284	java/lang/Throwable
    //   71	86	304	finally
    //   88	97	304	finally
    //   99	117	304	finally
    //   129	135	304	finally
    //   137	148	304	finally
    //   33	65	308	java/lang/Exception
    //   71	86	315	java/lang/Exception
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | current authority = " + this.f);
    }
    if (this.f.equals("com.android.contacts"))
    {
      Object localObject = d();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "onAuthorityUnknown | find substitute authority = " + (String)localObject);
        }
        this.f = ((String)localObject);
        localObject = this.jdField_a_of_type_AndroidAccountsAccount;
        if (localObject != null) {
          ContentResolver.setSyncAutomatically((Account)localObject, this.f, true);
        }
        b();
      }
    }
  }
  
  private void a(long paramLong, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", jdField_b_of_type_JavaLangString).build(), "_id = ?", new String[] { paramLong + "" });
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteRawContact | leave");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Account paramAccount)
  {
    synchronized (jdField_a_of_type_JavaUtilSet)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "markAccountDeleteByUser | accountSetIDel = " + jdField_a_of_type_JavaUtilSet + " | name = " + paramAccount.name + " | contain = " + jdField_a_of_type_JavaUtilSet.contains(paramAccount.name));
      }
      if (jdField_a_of_type_JavaUtilSet.remove(paramAccount.name)) {
        return;
      }
      paramQQAppInterface.a().getSharedPreferences("contactsync", 0).edit().putBoolean("pref_remove_account_prefix" + paramAccount.name, true).commit();
      ??? = (ContactSyncManager)paramQQAppInterface.getManager(40);
      if (??? != null)
      {
        if ((!TextUtils.isEmpty(paramQQAppInterface.a())) && (e(paramAccount.name).equals(paramQQAppInterface.a()))) {
          ((ContactSyncManager)???).jdField_b_of_type_Boolean = true;
        }
        ((ContactSyncManager)???).jdField_a_of_type_AndroidAccountsAccount = null;
        ((ContactSyncManager)???).jdField_d_of_type_Boolean = false;
        return;
      }
    }
  }
  
  private void a(List paramList, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id1", Long.valueOf(paramLong1));
    localContentValues.put("raw_contact_id2", Long.valueOf(paramLong2));
    localContentValues.put("type", Integer.valueOf(1));
    paramList.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI).withValues(localContentValues).withYieldAllowed(true).build());
  }
  
  private void a(List paramList, PhoneContact paramPhoneContact)
  {
    paramList = ContactOperation.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, c(), paramPhoneContact.mobileNo, paramPhoneContact.nationCode, paramPhoneContact.mobileCode, paramPhoneContact.ability, paramPhoneContact.contactID);
    paramList.b(paramPhoneContact.name);
    paramList.d(paramPhoneContact.mobileNo);
  }
  
  /* Error */
  private void a(List paramList, PhoneContact paramPhoneContact, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: aload_1
    //   5: lload_3
    //   6: invokestatic 512	com/tencent/mobileqq/contactsync/ContactOperation:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;J)Lcom/tencent/mobileqq/contactsync/ContactOperation;
    //   9: astore 6
    //   11: aload_0
    //   12: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15: invokevirtual 516	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   18: invokevirtual 519	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore_1
    //   22: aload_1
    //   23: getstatic 523	hyb:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   26: getstatic 524	hyb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   29: ldc_w 526
    //   32: iconst_1
    //   33: anewarray 158	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: lload_3
    //   39: invokestatic 529	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +114 -> 165
    //   54: aload 5
    //   56: astore_1
    //   57: aload 5
    //   59: invokeinterface 230 1 0
    //   64: ifeq +101 -> 165
    //   67: aload 5
    //   69: astore_1
    //   70: aload 5
    //   72: iconst_1
    //   73: invokeinterface 243 2 0
    //   78: ldc_w 531
    //   81: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -30 -> 54
    //   87: aload 5
    //   89: astore_1
    //   90: aload 5
    //   92: iconst_2
    //   93: invokeinterface 243 2 0
    //   98: astore 7
    //   100: aload 5
    //   102: astore_1
    //   103: aload 7
    //   105: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +18 -> 126
    //   111: aload 5
    //   113: astore_1
    //   114: aload 7
    //   116: aload_2
    //   117: getfield 503	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   120: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +42 -> 165
    //   126: aload 5
    //   128: astore_1
    //   129: aload 5
    //   131: iconst_0
    //   132: invokeinterface 237 2 0
    //   137: lstore_3
    //   138: aload 5
    //   140: astore_1
    //   141: getstatic 523	hyb:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   144: lload_3
    //   145: invokestatic 537	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   148: astore 7
    //   150: aload 5
    //   152: astore_1
    //   153: aload 6
    //   155: aload_2
    //   156: getfield 503	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   159: aload 7
    //   161: invokevirtual 540	com/tencent/mobileqq/contactsync/ContactOperation:a	(Ljava/lang/String;Landroid/net/Uri;)Lcom/tencent/mobileqq/contactsync/ContactOperation;
    //   164: pop
    //   165: aload 5
    //   167: ifnull +10 -> 177
    //   170: aload 5
    //   172: invokeinterface 260 1 0
    //   177: return
    //   178: astore_1
    //   179: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq -5 -> 177
    //   185: ldc 15
    //   187: iconst_2
    //   188: ldc_w 542
    //   191: aload_1
    //   192: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: return
    //   196: astore_2
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: astore_1
    //   203: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +16 -> 222
    //   209: aload 5
    //   211: astore_1
    //   212: ldc 15
    //   214: iconst_2
    //   215: ldc_w 544
    //   218: aload_2
    //   219: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload 5
    //   224: ifnull -47 -> 177
    //   227: aload 5
    //   229: invokeinterface 260 1 0
    //   234: return
    //   235: astore_1
    //   236: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -62 -> 177
    //   242: ldc 15
    //   244: iconst_2
    //   245: ldc_w 542
    //   248: aload_1
    //   249: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: return
    //   253: astore_2
    //   254: aconst_null
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +9 -> 266
    //   260: aload_1
    //   261: invokeinterface 260 1 0
    //   266: aload_2
    //   267: athrow
    //   268: astore_1
    //   269: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq -6 -> 266
    //   275: ldc 15
    //   277: iconst_2
    //   278: ldc_w 542
    //   281: aload_1
    //   282: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: goto -19 -> 266
    //   288: astore_2
    //   289: goto -33 -> 256
    //   292: astore_2
    //   293: goto -93 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	ContactSyncManager
    //   0	296	1	paramList	List
    //   0	296	2	paramPhoneContact	PhoneContact
    //   0	296	3	paramLong	long
    //   47	181	5	localCursor	android.database.Cursor
    //   9	145	6	localContactOperation	ContactOperation
    //   98	62	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   170	177	178	java/lang/Throwable
    //   22	49	196	java/lang/Exception
    //   227	234	235	java/lang/Throwable
    //   22	49	253	finally
    //   260	266	268	java/lang/Throwable
    //   57	67	288	finally
    //   70	87	288	finally
    //   90	100	288	finally
    //   103	111	288	finally
    //   114	126	288	finally
    //   129	138	288	finally
    //   141	150	288	finally
    //   153	165	288	finally
    //   203	209	288	finally
    //   212	222	288	finally
    //   57	67	292	java/lang/Exception
    //   70	87	292	java/lang/Exception
    //   90	100	292	java/lang/Exception
    //   103	111	292	java/lang/Exception
    //   114	126	292	java/lang/Exception
    //   129	138	292	java/lang/Exception
    //   141	150	292	java/lang/Exception
    //   153	165	292	java/lang/Exception
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "applyBatch | enter");
    }
    boolean bool = true;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().applyBatch(this.f, paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "applyBatch | result = " + bool + " | leave");
      }
      return bool;
    }
    catch (RemoteException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | RemoteException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (OperationApplicationException paramArrayList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | OperationApplicationException:", paramArrayList);
        }
        bool = false;
      }
    }
    catch (IllegalArgumentException paramArrayList)
    {
      for (;;)
      {
        String str = Log.getStackTraceString(paramArrayList);
        if ((!TextUtils.isEmpty(str)) && (str.contains("Unknown authority"))) {
          a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | IllegalArgumentException: ", paramArrayList);
        }
        bool = false;
      }
    }
  }
  
  private boolean a(Map paramMap)
  {
    for (;;)
    {
      boolean bool;
      Object localObject3;
      ArrayList localArrayList;
      Object localObject2;
      Object localObject1;
      int i;
      RawContact localRawContact;
      String str;
      try
      {
        if (g())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = enter");
          }
          bool = false;
          return bool;
        }
        localObject3 = a();
        localArrayList = new ArrayList();
        localObject2 = new HashSet(paramMap.size());
        localObject1 = new HashSet();
        localObject3 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label338;
        }
        localRawContact = (RawContact)((Iterator)localObject3).next();
        if (g())
        {
          if (!QLog.isColorLevel()) {
            break label1142;
          }
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for1");
          break label1142;
        }
        str = localRawContact.jdField_a_of_type_JavaLangString;
        if ((paramMap == null) || (TextUtils.isEmpty(str)) || (!paramMap.containsKey(localRawContact.jdField_a_of_type_JavaLangString)))
        {
          a(localRawContact.jdField_a_of_type_Long, localArrayList);
          i += 1;
          continue;
        }
        if ((paramMap == null) || (TextUtils.isEmpty(str)) || (!paramMap.containsKey(str))) {
          continue;
        }
        if (((Set)localObject2).contains(Integer.valueOf(localRawContact.jdField_a_of_type_Int)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ContactSync.Manager", 2, "doSyncContacts | error: duplicate contact id");
          }
          a(localRawContact.jdField_a_of_type_Long, localArrayList);
          paramMap.remove(str);
          continue;
        }
        ((Set)localObject2).add(Integer.valueOf(localRawContact.jdField_a_of_type_Int));
      }
      finally {}
      if (((PhoneContact)paramMap.get(str)).contactID != localRawContact.jdField_a_of_type_Int)
      {
        ((Set)localObject1).add(localRawContact.jdField_a_of_type_JavaLangString);
        a(localArrayList, (PhoneContact)paramMap.get(str), localRawContact.jdField_a_of_type_Long);
        continue;
        label338:
        paramMap = paramMap.values();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | delete count = " + i + " | reaggregate count = " + ((Set)localObject1).size() + " | will insert count = " + paramMap.size());
        }
        if ((localArrayList.size() > 0) && (!g()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply update ops | size = " + localArrayList.size());
          }
          a(localArrayList);
          localArrayList.clear();
        }
        paramMap = paramMap.iterator();
        label683:
        while (paramMap.hasNext())
        {
          localObject3 = (PhoneContact)paramMap.next();
          if (g())
          {
            if (!QLog.isColorLevel()) {
              break label1147;
            }
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | shouldStopSync = true | pos = for2");
            break label1147;
          }
          if (!((Set)localObject2).contains(Integer.valueOf(((PhoneContact)localObject3).contactID)))
          {
            a(localArrayList, (PhoneContact)localObject3);
            ((Set)localObject2).add(Integer.valueOf(((PhoneContact)localObject3).contactID));
            ((Set)localObject1).add(((PhoneContact)localObject3).mobileNo);
          }
          for (;;)
          {
            if (localArrayList.size() <= 500) {
              break label683;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size());
            }
            a(localArrayList);
            localArrayList.clear();
            break;
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | contact " + ((PhoneContact)localObject3).contactID + " has two match phonenum");
            }
          }
        }
        if ((localArrayList.size() > 0) && (!g()))
        {
          bool = a(localArrayList);
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply insert ops  | size = " + localArrayList.size() + " | result = " + bool);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "doSyncContacts | aggregateMap.size = " + ((Set)localObject1).size());
        }
        if (((Set)localObject1).size() == 0)
        {
          bool = true;
        }
        else
        {
          localArrayList.clear();
          localArrayList.ensureCapacity(((Set)localObject1).size());
          localObject2 = a();
          paramMap = b();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (RawContact)((Iterator)localObject2).next();
            if ((((Set)localObject1).contains(((RawContact)localObject3).jdField_a_of_type_JavaLangString)) && (paramMap.containsKey(((RawContact)localObject3).jdField_a_of_type_JavaLangString)))
            {
              a(localArrayList, ((RawContact)localObject3).jdField_a_of_type_Long, ((Long)paramMap.get(((RawContact)localObject3).jdField_a_of_type_JavaLangString)).longValue());
              ((Set)localObject1).remove(((RawContact)localObject3).jdField_a_of_type_JavaLangString);
            }
            if (localArrayList.size() > 500)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply aggregate batch | size = " + localArrayList.size());
              }
              a(localArrayList);
              localArrayList.clear();
            }
          }
          if (QLog.isColorLevel())
          {
            paramMap = ((Set)localObject1).iterator();
            while (paramMap.hasNext())
            {
              localObject1 = (String)paramMap.next();
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | remain source ID = " + c((String)localObject1));
            }
          }
          if ((localArrayList.size() > 0) && (!g()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSync.Manager", 2, "doSyncContacts | apply aggregate batch | size = " + localArrayList.size());
            }
            a(localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Manager", 2, "doSyncContacts | leave");
          }
          bool = true;
          continue;
          label1142:
          bool = false;
          continue;
          label1147:
          bool = false;
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid uin";
    }
    return paramString.substring(0, 3);
  }
  
  /* Error */
  private Map b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: new 281	java/util/HashMap
    //   14: dup
    //   15: invokespecial 324	java/util/HashMap:<init>	()V
    //   18: astore_1
    //   19: aload_2
    //   20: getstatic 670	hyc:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   23: getstatic 671	hyc:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +216 -> 250
    //   37: aload_2
    //   38: astore_3
    //   39: new 281	java/util/HashMap
    //   42: dup
    //   43: aload_2
    //   44: invokeinterface 223 1 0
    //   49: invokespecial 286	java/util/HashMap:<init>	(I)V
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload_2
    //   57: invokeinterface 230 1 0
    //   62: ifeq +78 -> 140
    //   65: aload_2
    //   66: astore_3
    //   67: aload 4
    //   69: aload_2
    //   70: iconst_0
    //   71: invokeinterface 243 2 0
    //   76: invokestatic 675	com/tencent/mobileqq/app/PhoneContactManagerImp:a	(Ljava/lang/String;)Ljava/lang/String;
    //   79: aload_2
    //   80: iconst_3
    //   81: invokeinterface 237 2 0
    //   86: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 676	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: goto -39 -> 54
    //   96: astore_3
    //   97: aload 4
    //   99: astore_1
    //   100: aload_3
    //   101: astore 4
    //   103: aload_2
    //   104: astore_3
    //   105: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +16 -> 124
    //   111: aload_2
    //   112: astore_3
    //   113: ldc 15
    //   115: iconst_2
    //   116: ldc_w 678
    //   119: aload 4
    //   121: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: astore_3
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokeinterface 260 1 0
    //   136: aload_1
    //   137: astore_3
    //   138: aload_3
    //   139: areturn
    //   140: aload 4
    //   142: astore_1
    //   143: aload_1
    //   144: astore_3
    //   145: aload_2
    //   146: ifnull -8 -> 138
    //   149: aload_2
    //   150: invokeinterface 260 1 0
    //   155: aload_1
    //   156: areturn
    //   157: astore_2
    //   158: aload_1
    //   159: astore_3
    //   160: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq -25 -> 138
    //   166: ldc 15
    //   168: iconst_2
    //   169: ldc_w 680
    //   172: aload_2
    //   173: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: areturn
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -46 -> 138
    //   187: ldc 15
    //   189: iconst_2
    //   190: ldc_w 680
    //   193: aload_2
    //   194: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_1
    //   198: areturn
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_3
    //   203: ifnull +9 -> 212
    //   206: aload_3
    //   207: invokeinterface 260 1 0
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -6 -> 212
    //   221: ldc 15
    //   223: iconst_2
    //   224: ldc_w 680
    //   227: aload_2
    //   228: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: goto -19 -> 212
    //   234: astore_1
    //   235: goto -33 -> 202
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_2
    //   242: goto -139 -> 103
    //   245: astore 4
    //   247: goto -144 -> 103
    //   250: goto -107 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	ContactSyncManager
    //   18	180	1	localObject1	Object
    //   199	14	1	localObject2	Object
    //   234	1	1	localObject3	Object
    //   10	140	2	localObject4	Object
    //   157	16	2	localThrowable1	Throwable
    //   178	16	2	localThrowable2	Throwable
    //   214	14	2	localThrowable3	Throwable
    //   241	1	2	localObject5	Object
    //   38	29	3	localObject6	Object
    //   96	5	3	localException1	java.lang.Exception
    //   104	103	3	localObject7	Object
    //   52	89	4	localObject8	Object
    //   238	1	4	localException2	java.lang.Exception
    //   245	1	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   56	65	96	java/lang/Exception
    //   67	93	96	java/lang/Exception
    //   149	155	157	java/lang/Throwable
    //   130	136	178	java/lang/Throwable
    //   19	33	199	finally
    //   206	212	214	java/lang/Throwable
    //   39	54	234	finally
    //   56	65	234	finally
    //   67	93	234	finally
    //   105	111	234	finally
    //   113	124	234	finally
    //   19	33	238	java/lang/Exception
    //   39	54	245	java/lang/Exception
  }
  
  private void b()
  {
    AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.tencent.mobileqq.account");
    if (arrayOfAccount.length > 0)
    {
      this.jdField_a_of_type_AndroidAccountsAccount = arrayOfAccount[0];
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "initSyncAccount | syncAccount = " + this.jdField_a_of_type_AndroidAccountsAccount);
      }
      int i = 1;
      while (i < arrayOfAccount.length)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "initSyncAccount | delAccount = " + arrayOfAccount[i]);
        }
        localAccountManager.removeAccount(arrayOfAccount[i], null, null);
        i += 1;
      }
    }
  }
  
  private String c()
  {
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    if (localAccount != null) {
      return localAccount.name;
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 3)) {
      return "invalid phone num";
    }
    return paramString.substring(paramString.length() - 3);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAccountsAccount = null;
    try
    {
      AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      Account[] arrayOfAccount = localAccountManager.getAccountsByType("com.tencent.mobileqq.account");
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "removeSyncAccount | account.length = " + arrayOfAccount.length);
      }
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Account localAccount = arrayOfAccount[i];
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "removeSyncAccount | a.name = " + b(localAccount.name));
        }
        synchronized (jdField_a_of_type_JavaUtilSet)
        {
          jdField_a_of_type_JavaUtilSet.add(localAccount.name);
          localAccountManager.removeAccount(localAccount, new hya(this), null);
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "removeSyncAccount | e = ", localThrowable);
      }
    }
  }
  
  private String d()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageManager().getInstalledPackages(8).iterator();
    while (localIterator.hasNext())
    {
      ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)localIterator.next()).providers;
      if (arrayOfProviderInfo != null)
      {
        int j = arrayOfProviderInfo.length;
        int i = 0;
        while (i < j)
        {
          ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
          if ((localProviderInfo.authority.contains("contacts")) && (!localProviderInfo.authority.equals("com.android.contacts"))) {
            return localProviderInfo.authority;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() > 4))
    {
      localObject = new StringBuilder();
      int j = paramString.length() - 4;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append("*");
        i += 1;
      }
      ((StringBuilder)localObject).append(paramString.substring(j));
      localObject = ((StringBuilder)localObject).toString();
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramString != null);
    return "";
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("pref_remove_account_prefix" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
  }
  
  private static String e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("(");
      int j = paramString.lastIndexOf(")");
      if ((i != -1) && (j != -1)) {
        return paramString.substring(i + 1, j);
      }
    }
    return null;
  }
  
  private boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldAddAccount | is device support = " + d() + " | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean + " | hasIRemovedByUser = " + this.jdField_b_of_type_Boolean);
    }
    if ((d()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      Object localObject = a();
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldAddAccount | syncUin = " + b((String)localObject) + " | currentUin = " + b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
        return false;
      }
      localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("coundlAddAccount | pcm = ").append(localObject).append(" | bindState = ");
        if (localObject == null) {
          break label310;
        }
      }
      label310:
      for (int i = ((PhoneContactManager)localObject).b();; i = -1000)
      {
        QLog.d("ContactSync.Manager", 2, i);
        if ((localObject == null) || (!((PhoneContactManager)localObject).g())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "couldAddAccount | bind state = " + ((PhoneContactManager)localObject).b());
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "couldSyncContact | app is login=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin() + " | syncContactAllowed=" + this.jdField_a_of_type_Boolean);
    }
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject = a();
        PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("couldSyncContact | bind state = ");
          if (localPhoneContactManager == null) {
            break label288;
          }
          i = 7;
          QLog.d("ContactSync.Manager", 2, i + " | account.name = " + b((String)localObject));
        }
        bool1 = bool2;
        if (localPhoneContactManager != null)
        {
          bool1 = bool2;
          if (localPhoneContactManager.g())
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject))
            {
              localObject = this.jdField_a_of_type_AndroidAccountsAccount;
              if (localObject == null) {
                break label300;
              }
              bool2 = ContentResolver.getSyncAutomatically((Account)localObject, this.f);
              if (ContentResolver.getIsSyncable((Account)localObject, this.f) <= 0) {
                break label295;
              }
              bool1 = true;
              label226:
              bool3 = ContentResolver.getMasterSyncAutomatically();
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "couldSyncContact | isSystemSyncAutomatic = " + bool2 + " | isSystemSyncable = " + bool1 + " | isMasterSyncAutomatic = " + bool3);
      }
      bool1 = bool2;
      return bool1;
      label288:
      i = -100000;
      break;
      label295:
      bool1 = false;
      break label226;
      label300:
      bool1 = false;
      bool2 = false;
    }
  }
  
  private boolean g()
  {
    boolean bool2 = true;
    Account localAccount = this.jdField_a_of_type_AndroidAccountsAccount;
    boolean bool1;
    StringBuilder localStringBuilder;
    if ((localAccount == null) || (Thread.interrupted()))
    {
      bool1 = true;
      if ((bool1) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder().append("shouldStopSync | account = ");
        if (localAccount != null) {
          break label82;
        }
      }
    }
    for (;;)
    {
      QLog.d("ContactSync.Manager", 2, bool2 + " | interrupted = " + Thread.interrupted());
      return bool1;
      bool1 = false;
      break;
      label82:
      bool2 = false;
    }
  }
  
  private boolean h()
  {
    boolean bool = e();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "addSyncAccount | could add account = " + bool);
    }
    if (!bool) {
      return false;
    }
    try
    {
      AccountManager localAccountManager = AccountManager.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      Account localAccount = new Account(a(String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() })), "com.tencent.mobileqq.account");
      if (localAccountManager.addAccountExplicitly(localAccount, null, null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly success");
        }
        this.jdField_a_of_type_AndroidAccountsAccount = localAccount;
        ContentResolver.setIsSyncable(this.jdField_a_of_type_AndroidAccountsAccount, this.f, 1);
        ContentResolver.setSyncAutomatically(localAccount, this.f, true);
        b();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | addAcountExplicitly fail");
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "addSyncAccount | e = ", localThrowable);
      }
    }
    return true;
  }
  
  /* Error */
  public SimplePhoneContact a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 6
    //   12: aload 6
    //   14: aload_1
    //   15: iconst_1
    //   16: anewarray 158	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 837
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +681 -> 714
    //   36: aload_1
    //   37: astore 4
    //   39: aload_1
    //   40: invokeinterface 230 1 0
    //   45: ifeq +669 -> 714
    //   48: aload_1
    //   49: astore 4
    //   51: aload_1
    //   52: iconst_0
    //   53: invokeinterface 237 2 0
    //   58: lstore_2
    //   59: aload_1
    //   60: ifnull +651 -> 711
    //   63: aload_1
    //   64: invokeinterface 260 1 0
    //   69: lload_2
    //   70: ldc2_w 838
    //   73: lcmp
    //   74: ifne +137 -> 211
    //   77: aconst_null
    //   78: areturn
    //   79: astore 4
    //   81: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +14 -> 98
    //   87: ldc 15
    //   89: iconst_2
    //   90: ldc_w 841
    //   93: aload 4
    //   95: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: goto -29 -> 69
    //   101: astore 5
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore 4
    //   108: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +17 -> 128
    //   114: aload_1
    //   115: astore 4
    //   117: ldc 15
    //   119: iconst_2
    //   120: ldc_w 843
    //   123: aload 5
    //   125: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull +575 -> 704
    //   132: aload_1
    //   133: invokeinterface 260 1 0
    //   138: ldc2_w 838
    //   141: lstore_2
    //   142: goto -73 -> 69
    //   145: astore 4
    //   147: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +14 -> 164
    //   153: ldc 15
    //   155: iconst_2
    //   156: ldc_w 841
    //   159: aload 4
    //   161: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: ldc2_w 838
    //   167: lstore_2
    //   168: goto -99 -> 69
    //   171: astore_1
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +10 -> 187
    //   180: aload 4
    //   182: invokeinterface 260 1 0
    //   187: aload_1
    //   188: athrow
    //   189: astore 4
    //   191: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -7 -> 187
    //   197: ldc 15
    //   199: iconst_2
    //   200: ldc_w 841
    //   203: aload 4
    //   205: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: goto -21 -> 187
    //   211: new 845	com/tencent/mobileqq/contactsync/SimplePhoneContact
    //   214: dup
    //   215: invokespecial 846	com/tencent/mobileqq/contactsync/SimplePhoneContact:<init>	()V
    //   218: astore 7
    //   220: aload 6
    //   222: getstatic 523	hyb:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   225: getstatic 524	hyb:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   228: ldc_w 526
    //   231: iconst_1
    //   232: anewarray 158	java/lang/String
    //   235: dup
    //   236: iconst_0
    //   237: lload_2
    //   238: invokestatic 529	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   241: aastore
    //   242: aconst_null
    //   243: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   246: astore 4
    //   248: aload 4
    //   250: astore_1
    //   251: aload_1
    //   252: ifnull +49 -> 301
    //   255: aload_1
    //   256: astore 4
    //   258: aload_1
    //   259: invokeinterface 230 1 0
    //   264: ifeq +37 -> 301
    //   267: aload_1
    //   268: astore 4
    //   270: aload_1
    //   271: iconst_1
    //   272: invokeinterface 243 2 0
    //   277: ldc_w 531
    //   280: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq -28 -> 255
    //   286: aload_1
    //   287: astore 4
    //   289: aload 7
    //   291: aload_1
    //   292: iconst_2
    //   293: invokeinterface 243 2 0
    //   298: putfield 847	com/tencent/mobileqq/contactsync/SimplePhoneContact:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   301: aload_1
    //   302: astore 4
    //   304: aload_1
    //   305: ifnull +393 -> 698
    //   308: aload_1
    //   309: invokeinterface 260 1 0
    //   314: aload 6
    //   316: getstatic 341	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   319: getstatic 849	hyd:b	[Ljava/lang/String;
    //   322: ldc_w 851
    //   325: iconst_1
    //   326: anewarray 158	java/lang/String
    //   329: dup
    //   330: iconst_0
    //   331: lload_2
    //   332: invokestatic 529	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   335: aastore
    //   336: aconst_null
    //   337: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   340: astore 4
    //   342: aload 4
    //   344: ifnull +64 -> 408
    //   347: aload 4
    //   349: astore_1
    //   350: aload 4
    //   352: invokeinterface 230 1 0
    //   357: ifeq +51 -> 408
    //   360: aload 4
    //   362: astore_1
    //   363: aload 7
    //   365: aload 4
    //   367: iconst_0
    //   368: invokeinterface 243 2 0
    //   373: putfield 852	com/tencent/mobileqq/contactsync/SimplePhoneContact:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   376: aload 4
    //   378: astore_1
    //   379: aload 7
    //   381: aload 4
    //   383: iconst_1
    //   384: invokeinterface 243 2 0
    //   389: putfield 854	com/tencent/mobileqq/contactsync/SimplePhoneContact:c	Ljava/lang/String;
    //   392: aload 4
    //   394: astore_1
    //   395: aload 7
    //   397: aload 4
    //   399: iconst_2
    //   400: invokeinterface 249 2 0
    //   405: putfield 855	com/tencent/mobileqq/contactsync/SimplePhoneContact:jdField_a_of_type_Int	I
    //   408: aload 4
    //   410: ifnull +10 -> 420
    //   413: aload 4
    //   415: invokeinterface 260 1 0
    //   420: aload 7
    //   422: areturn
    //   423: astore 4
    //   425: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +14 -> 442
    //   431: ldc 15
    //   433: iconst_2
    //   434: ldc_w 857
    //   437: aload 4
    //   439: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: goto -128 -> 314
    //   445: astore 5
    //   447: aload_1
    //   448: astore 4
    //   450: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +17 -> 470
    //   456: aload_1
    //   457: astore 4
    //   459: ldc 15
    //   461: iconst_2
    //   462: ldc_w 843
    //   465: aload 5
    //   467: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_1
    //   471: astore 4
    //   473: aload_1
    //   474: ifnull +224 -> 698
    //   477: aload_1
    //   478: invokeinterface 260 1 0
    //   483: goto -169 -> 314
    //   486: astore 4
    //   488: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +14 -> 505
    //   494: ldc 15
    //   496: iconst_2
    //   497: ldc_w 857
    //   500: aload 4
    //   502: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   505: goto -191 -> 314
    //   508: astore 5
    //   510: aload_1
    //   511: astore 4
    //   513: aload 5
    //   515: astore_1
    //   516: aload 4
    //   518: ifnull +10 -> 528
    //   521: aload 4
    //   523: invokeinterface 260 1 0
    //   528: aload_1
    //   529: athrow
    //   530: astore 4
    //   532: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq -7 -> 528
    //   538: ldc 15
    //   540: iconst_2
    //   541: ldc_w 857
    //   544: aload 4
    //   546: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: goto -21 -> 528
    //   552: astore_1
    //   553: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq -136 -> 420
    //   559: ldc 15
    //   561: iconst_2
    //   562: ldc_w 859
    //   565: aload_1
    //   566: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   569: goto -149 -> 420
    //   572: astore 5
    //   574: aload_1
    //   575: astore 4
    //   577: aload 4
    //   579: astore_1
    //   580: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +17 -> 600
    //   586: aload 4
    //   588: astore_1
    //   589: ldc 15
    //   591: iconst_2
    //   592: ldc_w 843
    //   595: aload 5
    //   597: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   600: aload 4
    //   602: ifnull -182 -> 420
    //   605: aload 4
    //   607: invokeinterface 260 1 0
    //   612: goto -192 -> 420
    //   615: astore_1
    //   616: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq -199 -> 420
    //   622: ldc 15
    //   624: iconst_2
    //   625: ldc_w 859
    //   628: aload_1
    //   629: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   632: goto -212 -> 420
    //   635: astore 4
    //   637: aload_1
    //   638: ifnull +9 -> 647
    //   641: aload_1
    //   642: invokeinterface 260 1 0
    //   647: aload 4
    //   649: athrow
    //   650: astore_1
    //   651: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -7 -> 647
    //   657: ldc 15
    //   659: iconst_2
    //   660: ldc_w 859
    //   663: aload_1
    //   664: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: goto -20 -> 647
    //   670: astore 4
    //   672: goto -35 -> 637
    //   675: astore 5
    //   677: goto -100 -> 577
    //   680: astore_1
    //   681: goto -165 -> 516
    //   684: astore 5
    //   686: goto -239 -> 447
    //   689: astore_1
    //   690: goto -515 -> 175
    //   693: astore 5
    //   695: goto -590 -> 105
    //   698: aload 4
    //   700: astore_1
    //   701: goto -387 -> 314
    //   704: ldc2_w 838
    //   707: lstore_2
    //   708: goto -639 -> 69
    //   711: goto -642 -> 69
    //   714: ldc2_w 838
    //   717: lstore_2
    //   718: goto -659 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	ContactSyncManager
    //   0	721	1	paramUri	Uri
    //   58	660	2	l	long
    //   37	13	4	localUri1	Uri
    //   79	15	4	localThrowable1	Throwable
    //   106	10	4	localUri2	Uri
    //   145	15	4	localThrowable2	Throwable
    //   173	8	4	localObject1	Object
    //   189	15	4	localThrowable3	Throwable
    //   246	168	4	localObject2	Object
    //   423	15	4	localThrowable4	Throwable
    //   448	24	4	localUri3	Uri
    //   486	15	4	localThrowable5	Throwable
    //   511	11	4	localUri4	Uri
    //   530	15	4	localThrowable6	Throwable
    //   575	31	4	localUri5	Uri
    //   635	13	4	localObject3	Object
    //   670	29	4	localObject4	Object
    //   101	23	5	localException1	java.lang.Exception
    //   445	21	5	localException2	java.lang.Exception
    //   508	6	5	localObject5	Object
    //   572	24	5	localException3	java.lang.Exception
    //   675	1	5	localException4	java.lang.Exception
    //   684	1	5	localException5	java.lang.Exception
    //   693	1	5	localException6	java.lang.Exception
    //   10	305	6	localContentResolver	ContentResolver
    //   218	203	7	localSimplePhoneContact	SimplePhoneContact
    // Exception table:
    //   from	to	target	type
    //   63	69	79	java/lang/Throwable
    //   12	32	101	java/lang/Exception
    //   132	138	145	java/lang/Throwable
    //   12	32	171	finally
    //   180	187	189	java/lang/Throwable
    //   308	314	423	java/lang/Throwable
    //   220	248	445	java/lang/Exception
    //   477	483	486	java/lang/Throwable
    //   220	248	508	finally
    //   521	528	530	java/lang/Throwable
    //   413	420	552	java/lang/Throwable
    //   314	342	572	java/lang/Exception
    //   605	612	615	java/lang/Throwable
    //   314	342	635	finally
    //   641	647	650	java/lang/Throwable
    //   350	360	670	finally
    //   363	376	670	finally
    //   379	392	670	finally
    //   395	408	670	finally
    //   580	586	670	finally
    //   589	600	670	finally
    //   350	360	675	java/lang/Exception
    //   363	376	675	java/lang/Exception
    //   379	392	675	java/lang/Exception
    //   395	408	675	java/lang/Exception
    //   258	267	680	finally
    //   270	286	680	finally
    //   289	301	680	finally
    //   450	456	680	finally
    //   459	470	680	finally
    //   258	267	684	java/lang/Exception
    //   270	286	684	java/lang/Exception
    //   289	301	684	java/lang/Exception
    //   39	48	689	finally
    //   51	59	689	finally
    //   108	114	689	finally
    //   117	128	689	finally
    //   39	48	693	java/lang/Exception
    //   51	59	693	java/lang/Exception
  }
  
  public String a()
  {
    String str = c();
    if (!TextUtils.isEmpty(str)) {
      return e(str);
    }
    return null;
  }
  
  /* Error */
  public String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 158	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 862
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 230 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 243 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 260 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 864
    //   82: aload_1
    //   83: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 15
    //   103: iconst_2
    //   104: ldc_w 866
    //   107: aload_3
    //   108: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 260 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 864
    //   136: aload_1
    //   137: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 260 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 15
    //   166: iconst_2
    //   167: ldc_w 864
    //   170: aload_2
    //   171: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	java.lang.Exception
    //   181	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String a(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    int i;
    int j;
    if ((paramGetOnlineInfoResp.iTermType == 65793L) || (paramGetOnlineInfoResp.iTermType == 67586L))
    {
      i = 1;
      j = (int)paramGetOnlineInfoResp.dwStatus;
      if ((20 != j) && (21 != j) && (40 != j) && (41 != j)) {
        break label90;
      }
    }
    for (;;)
    {
      i = ContactUtils.a(j, (int)paramGetOnlineInfoResp.iTermType);
      if ((i == 0) || (i == 6)) {
        break label97;
      }
      return paramGetOnlineInfoResp.strTermDesc;
      i = 0;
      break;
      label90:
      if (i == 0) {}
    }
    label97:
    return null;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "deleteSyncContact | mobileNo = " + c(paramString));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getContentResolver().delete(hyd.a(c()), "sourceid=?", new String[] { paramString });
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "setSyncContactAllowed | allow = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("pref_sync_contact", paramBoolean).commit();
    if (paramBoolean)
    {
      this.jdField_d_of_type_Boolean = false;
      h();
      return;
    }
    if (this.c)
    {
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    c();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncAllContacts | isSyncing = " + this.c);
    }
    if ((this.c) || (!f())) {
      return false;
    }
    this.c = true;
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    boolean bool = a(a());
    if (this.jdField_d_of_type_Boolean)
    {
      c();
      this.jdField_d_of_type_Boolean = false;
    }
    this.c = false;
    return bool;
  }
  
  /* Error */
  public String b(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/mobileqq/contactsync/ContactSyncManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 94	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 192	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_2
    //   11: aload_2
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 158	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 916
    //   22: aastore
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 217	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +154 -> 185
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: invokeinterface 230 1 0
    //   42: ifeq +143 -> 185
    //   45: aload_1
    //   46: astore_2
    //   47: aload_1
    //   48: iconst_0
    //   49: invokeinterface 243 2 0
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: ifnull +9 -> 67
    //   61: aload_1
    //   62: invokeinterface 260 1 0
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq -6 -> 67
    //   76: ldc 15
    //   78: iconst_2
    //   79: ldc_w 918
    //   82: aload_1
    //   83: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload_2
    //   87: areturn
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: aload_1
    //   100: astore_2
    //   101: ldc 15
    //   103: iconst_2
    //   104: ldc_w 920
    //   107: aload_3
    //   108: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 260 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +13 -> 140
    //   130: ldc 15
    //   132: iconst_2
    //   133: ldc_w 918
    //   136: aload_1
    //   137: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 260 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_2
    //   158: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -6 -> 155
    //   164: ldc 15
    //   166: iconst_2
    //   167: ldc_w 918
    //   170: aload_2
    //   171: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -19 -> 155
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore_3
    //   182: goto -91 -> 91
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -130 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	ContactSyncManager
    //   0	190	1	paramUri	Uri
    //   10	140	2	localObject1	Object
    //   157	14	2	localThrowable	Throwable
    //   186	1	2	localObject2	Object
    //   54	2	3	str	String
    //   88	20	3	localException1	java.lang.Exception
    //   181	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   61	67	69	java/lang/Throwable
    //   11	30	88	java/lang/Exception
    //   115	121	123	java/lang/Throwable
    //   11	30	142	finally
    //   149	155	157	java/lang/Throwable
    //   36	45	177	finally
    //   47	55	177	finally
    //   93	99	177	finally
    //   101	111	177	finally
    //   36	45	181	java/lang/Exception
    //   47	55	181	java/lang/Exception
  }
  
  public String b(GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp == null) {
      return null;
    }
    String str1 = "";
    String str2 = "";
    int i;
    switch (paramGetOnlineInfoResp.eNetworkType)
    {
    default: 
      i = 0;
      paramGetOnlineInfoResp = str2;
    }
    while (i != 0)
    {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getResources().getString(2131369295), new Object[] { str1, paramGetOnlineInfoResp });
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369302);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369305);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369302);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369306);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369302);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369307);
      i = 1;
      continue;
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369304);
      paramGetOnlineInfoResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().getString(2131369308);
      i = 1;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "syncBindContactList");
    }
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (!this.c) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new hxy(this));
    }
    for (;;)
    {
      return true;
      BaseApplicationImpl.a.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean d()
  {
    String str = Build.MANUFACTURER;
    return (!str.toLowerCase().contains("samsung")) && (!str.toLowerCase().contains("oppo"));
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager
 * JD-Core Version:    0.7.0.1
 */