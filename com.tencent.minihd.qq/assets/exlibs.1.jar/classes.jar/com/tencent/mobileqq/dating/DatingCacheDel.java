package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingApplyInfoDel;
import com.tencent.mobileqq.data.DatingPublishInfoDel;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatingCacheDel
  implements Handler.Callback
{
  public static final int a = 100;
  public static final long a = 60000L;
  public static final String a = "sp_file_del_dating";
  public static final int b = 5;
  private static final SparseArray jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(2);
  private static final int c = 1;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final byte[] jdField_a_of_type_ArrayOfByte = { 0, 0, 0, 0 };
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { null, "data_type_my_published", "data_type_my_applied", null };
  private final byte[] jdField_b_of_type_ArrayOfByte = { 0, 0, 0, 0 };
  private final String[] jdField_b_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_b_of_type_AndroidUtilSparseArray.put(1, DatingPublishInfoDel.class);
    jdField_b_of_type_AndroidUtilSparseArray.put(2, DatingApplyInfoDel.class);
  }
  
  protected DatingCacheDel(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new ArrayList());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new ArrayList());
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    this.jdField_a_of_type_AndroidOsHandler = new CustomHandler(ThreadManager.a(), this);
    DatingUtil.a("init", new Object[] { "dataToDel" });
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount() + "sp_file_del_dating", 0);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangString[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_b_of_type_ArrayOfJavaLangString[i] = paramQQAppInterface.getString("latest_id_" + this.jdField_a_of_type_ArrayOfJavaLangString[i], "");
        paramEntityManager = new ArrayList();
        ??? = (Class)jdField_b_of_type_AndroidUtilSparseArray.get(i);
        ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Class)???);
        paramEntityManager.clear();
        if (??? != null)
        {
          ??? = ((List)???).iterator();
          while ((??? != null) && (((Iterator)???).hasNext()))
          {
            String str = DatingCacheMng.a((Entity)((Iterator)???).next());
            if (!TextUtils.isEmpty(str)) {
              paramEntityManager.add(str);
            }
          }
        }
        synchronized ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i, null))
        {
          ((ArrayList)???).clear();
          ((ArrayList)???).addAll(paramEntityManager);
        }
      }
    }
  }
  
  private void a(int paramInt, byte paramByte)
  {
    DatingUtil.a("updateDelCacheFlag", new Object[] { Integer.valueOf(paramInt), Byte.valueOf(paramByte) });
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_ArrayOfByte.length))
    {
      this.jdField_a_of_type_ArrayOfByte[paramInt] = paramByte;
      if ((paramByte != 0) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 60000L);
      }
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 55	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   7: arraylength
    //   8: if_icmpge +356 -> 364
    //   11: aload_0
    //   12: getfield 58	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfByte	[B
    //   15: iload_1
    //   16: baload
    //   17: ifeq +12 -> 29
    //   20: aload_0
    //   21: getfield 55	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   24: iload_1
    //   25: aaload
    //   26: ifnonnull +10 -> 36
    //   29: iload_1
    //   30: iconst_1
    //   31: iadd
    //   32: istore_1
    //   33: goto -31 -> 2
    //   36: aload_0
    //   37: getfield 66	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   40: iload_1
    //   41: invokevirtual 131	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   44: checkcast 68	java/util/ArrayList
    //   47: astore 4
    //   49: aload_0
    //   50: getfield 62	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 97	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: new 99	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   63: aload_0
    //   64: getfield 62	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 104	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   70: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 15
    //   75: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: iconst_0
    //   82: invokevirtual 117	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   85: invokeinterface 215 1 0
    //   90: astore 5
    //   92: aload 5
    //   94: new 99	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   101: ldc 119
    //   103: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 55	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   110: iload_1
    //   111: aaload
    //   112: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: aload_0
    //   119: getfield 71	com/tencent/mobileqq/dating/DatingCacheDel:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   122: iload_1
    //   123: aaload
    //   124: invokeinterface 221 3 0
    //   129: pop
    //   130: aload 5
    //   132: invokeinterface 224 1 0
    //   137: pop
    //   138: getstatic 35	com/tencent/mobileqq/dating/DatingCacheDel:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   141: iload_1
    //   142: invokevirtual 131	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   145: checkcast 133	java/lang/Class
    //   148: astore 5
    //   150: aload 4
    //   152: monitorenter
    //   153: aload 4
    //   155: invokevirtual 228	java/util/ArrayList:size	()I
    //   158: anewarray 49	java/lang/String
    //   161: astore 6
    //   163: aload 4
    //   165: aload 6
    //   167: invokevirtual 232	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   170: pop
    //   171: aload 4
    //   173: monitorexit
    //   174: aload 6
    //   176: ifnull +10 -> 186
    //   179: aload 6
    //   181: arraylength
    //   182: iconst_1
    //   183: if_icmpge +53 -> 236
    //   186: aload_0
    //   187: getfield 64	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   190: aload 5
    //   192: invokevirtual 235	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   195: checkcast 159	com/tencent/mobileqq/persistence/Entity
    //   198: invokevirtual 238	com/tencent/mobileqq/persistence/Entity:getTableName	()Ljava/lang/String;
    //   201: invokevirtual 241	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/String;)Z
    //   204: pop
    //   205: goto -176 -> 29
    //   208: astore 4
    //   210: aload 4
    //   212: invokevirtual 244	java/lang/InstantiationException:printStackTrace	()V
    //   215: goto -186 -> 29
    //   218: astore 5
    //   220: aload 4
    //   222: monitorexit
    //   223: aload 5
    //   225: athrow
    //   226: astore 4
    //   228: aload 4
    //   230: invokevirtual 245	java/lang/IllegalAccessException:printStackTrace	()V
    //   233: goto -204 -> 29
    //   236: aload_0
    //   237: getfield 64	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   240: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   243: astore 4
    //   245: aload 4
    //   247: invokevirtual 252	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   250: aload 5
    //   252: aload 6
    //   254: iconst_0
    //   255: aaload
    //   256: invokestatic 255	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   259: astore 7
    //   261: aload_0
    //   262: getfield 64	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   265: aload 7
    //   267: invokevirtual 258	com/tencent/mobileqq/persistence/EntityManager:c	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   270: aload 6
    //   272: arraylength
    //   273: istore_3
    //   274: iconst_0
    //   275: istore_2
    //   276: iload_2
    //   277: iload_3
    //   278: if_icmpge +63 -> 341
    //   281: aload 6
    //   283: iload_2
    //   284: aaload
    //   285: astore 7
    //   287: aload 7
    //   289: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: ifeq +6 -> 298
    //   295: goto +70 -> 365
    //   298: aload 5
    //   300: aload 7
    //   302: invokestatic 255	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   305: astore 7
    //   307: aload_0
    //   308: getfield 64	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   311: aload 7
    //   313: invokevirtual 260	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   316: goto +49 -> 365
    //   319: astore 5
    //   321: aload 5
    //   323: invokevirtual 261	java/lang/Exception:printStackTrace	()V
    //   326: aload 4
    //   328: invokevirtual 263	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   331: aload_0
    //   332: getfield 58	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfByte	[B
    //   335: iload_1
    //   336: iconst_0
    //   337: bastore
    //   338: goto -309 -> 29
    //   341: aload 4
    //   343: invokevirtual 265	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   346: aload 4
    //   348: invokevirtual 263	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   351: goto -20 -> 331
    //   354: astore 5
    //   356: aload 4
    //   358: invokevirtual 263	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   361: aload 5
    //   363: athrow
    //   364: return
    //   365: iload_2
    //   366: iconst_1
    //   367: iadd
    //   368: istore_2
    //   369: goto -93 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	DatingCacheDel
    //   1	335	1	i	int
    //   275	94	2	j	int
    //   273	6	3	k	int
    //   47	125	4	localArrayList	ArrayList
    //   208	13	4	localInstantiationException	java.lang.InstantiationException
    //   226	3	4	localIllegalAccessException	java.lang.IllegalAccessException
    //   243	114	4	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   90	101	5	localObject1	Object
    //   218	81	5	localClass	Class
    //   319	3	5	localException	java.lang.Exception
    //   354	8	5	localObject2	Object
    //   161	121	6	arrayOfString	String[]
    //   259	53	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   186	205	208	java/lang/InstantiationException
    //   153	174	218	finally
    //   220	223	218	finally
    //   186	205	226	java/lang/IllegalAccessException
    //   245	274	319	java/lang/Exception
    //   287	295	319	java/lang/Exception
    //   298	316	319	java/lang/Exception
    //   341	346	319	java/lang/Exception
    //   245	274	354	finally
    //   287	295	354	finally
    //   298	316	354	finally
    //   321	326	354	finally
    //   341	346	354	finally
  }
  
  public Boolean a(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).contains(paramString));
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      return null;
    }
    return this.jdField_b_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public ArrayList a(int paramInt)
  {
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return localObject;
      localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      localObject = localArrayList;
    } while (localArrayList.size() <= 100);
    return new ArrayList(localArrayList.subList(0, 99));
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
          if (localObject1 != null) {}
        }
        else
        {
          return;
        }
        Object localObject1 = this.jdField_b_of_type_ArrayOfByte;
        int i;
        if (paramBoolean)
        {
          i = 1;
          localObject1[paramInt] = ((byte)i);
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    DatingUtil.a("onDelResult", new Object[] { "type:" + paramInt, "success:" + paramBoolean2, "clearAction:" + paramBoolean1, "idSize:" + paramArrayList.size() });
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {}
    do
    {
      return;
      a(paramInt, false);
    } while (!paramBoolean2);
    localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        paramArrayList = (String)paramArrayList.get(0);
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ArrayOfJavaLangString[paramInt])) && (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] == paramArrayList)) {
          this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = "";
        }
        a(paramInt, (byte)1);
        return;
      }
      finally {}
      if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
        localArrayList.removeAll(paramArrayList);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] == null)) {
      return;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = paramString;
        localArrayList.clear();
        a(paramInt, (byte)1);
        DatingUtil.a("addToDelCache", new Object[] { "dataType:" + paramInt, "clear:" + paramBoolean, "datingId:" + paramString, "cacheDelSize:" + localArrayList.size(), " latest:" + this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] });
        return;
      }
      finally {}
      try
      {
        localArrayList.add(paramString);
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_3
    //   5: istore_2
    //   6: iload_1
    //   7: iflt +29 -> 36
    //   10: iload_3
    //   11: istore_2
    //   12: iload_1
    //   13: aload_0
    //   14: getfield 55	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   17: arraylength
    //   18: if_icmpge +18 -> 36
    //   21: aload_0
    //   22: getfield 55	com/tencent/mobileqq/dating/DatingCacheDel:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   25: iload_1
    //   26: aaload
    //   27: astore 4
    //   29: aload 4
    //   31: ifnonnull +9 -> 40
    //   34: iload_3
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: aload_0
    //   41: getfield 60	com/tencent/mobileqq/dating/DatingCacheDel:jdField_b_of_type_ArrayOfByte	[B
    //   44: iload_1
    //   45: baload
    //   46: istore_1
    //   47: iload_3
    //   48: istore_2
    //   49: iload_1
    //   50: ifle -14 -> 36
    //   53: iconst_1
    //   54: istore_2
    //   55: goto -19 -> 36
    //   58: astore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 4
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	DatingCacheDel
    //   0	65	1	paramInt	int
    //   5	50	2	bool1	boolean
    //   1	47	3	bool2	boolean
    //   27	3	4	str	String
    //   58	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	29	58	finally
    //   40	47	58	finally
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (this.jdField_a_of_type_ArrayOfJavaLangString[paramInt1] == null)) {
      return false;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    return (!TextUtils.isEmpty(this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1])) || (localArrayList.size() >= paramInt2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingCacheDel
 * JD-Core Version:    0.7.0.1
 */