package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class EntityManager
{
  private static final String jdField_a_of_type_JavaLangString = "EntityManager";
  private static final Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private static final String b = "The EntityManager has been already closed";
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  private EntityTransaction jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction;
  
  EntityManager(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  private List a(Class paramClass, String paramString, Cursor paramCursor)
  {
    localObject3 = null;
    localObject2 = null;
    Object localObject1 = localObject2;
    if (paramCursor != null)
    {
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    try
    {
      int i;
      if (paramCursor.moveToFirst())
      {
        localObject2 = localObject3;
        i = paramCursor.getCount();
        localObject1 = null;
      }
      Entity localEntity;
      boolean bool;
      for (;;)
      {
        localObject3 = localObject1;
      }
    }
    catch (Exception paramClass)
    {
      do
      {
        try
        {
          localEntity = a(paramClass, paramString, paramCursor);
          localObject2 = localObject1;
          if (localEntity != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject3 = localObject1;
              localObject2 = new ArrayList(i);
            }
            localObject3 = localObject2;
            ((List)localObject2).add(localEntity);
          }
          localObject1 = localObject2;
          localObject2 = localObject1;
          bool = paramCursor.moveToNext();
          if (bool) {
            break label162;
          }
          return localObject1;
        }
        catch (Exception paramClass)
        {
          for (;;)
          {
            localObject2 = localObject3;
          }
        }
        paramClass = paramClass;
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
      return localObject2;
    }
  }
  
  private void a(Entity paramEntity, boolean paramBoolean)
  {
    long l3 = System.nanoTime();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    String str;
    if (paramEntity._status == 1000)
    {
      str = paramEntity.getTableName();
      a(str, paramEntity, false);
      paramEntity.prewrite();
    }
    for (;;)
    {
      try
      {
        localContentValues = a(paramEntity);
        if (!paramBoolean) {
          continue;
        }
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(str, null, localContentValues);
        l2 = l1;
        if (l1 == -1L)
        {
          l2 = l1;
          if (a(str, paramEntity, true))
          {
            if (!paramBoolean) {
              continue;
            }
            l2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(str, null, localContentValues);
          }
        }
        if (l2 != -1L)
        {
          paramEntity._id = l2;
          paramEntity._status = 1001;
        }
      }
      catch (Exception localException)
      {
        ContentValues localContentValues;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
        continue;
      }
      paramEntity.postwrite();
      OGStat.a().a("insertOrReplace", paramEntity, l3);
      return;
      l1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
      continue;
      l2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
    }
  }
  
  private boolean a(String paramString, Entity paramEntity, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramBoolean)
    {
      bool1 = bool2;
      if (jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) {
        bool1 = ((Boolean)jdField_a_of_type_JavaUtilHashtable.get(paramString)).booleanValue();
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(TableBuilder.a(paramEntity));
      jdField_a_of_type_JavaUtilHashtable.put(paramString, Boolean.valueOf(bool1));
      if (QLog.isColorLevel()) {
        QLog.d("EntityManager", 2, "createTable, tableName=" + paramString + ", isCreated=" + bool1 + ", isForceCreate=" + paramBoolean);
      }
      bool2 = bool1;
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramString);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  protected ContentValues a(Entity paramEntity)
  {
    long l = System.nanoTime();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = TableBuilder.a(paramEntity.getClassForTable()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Field)localIterator.next();
      String str = ((Field)localObject).getName();
      if (!((Field)localObject).isAccessible()) {
        ((Field)localObject).setAccessible(true);
      }
      localObject = ((Field)localObject).get(paramEntity);
      if ((localObject instanceof Integer)) {
        localContentValues.put(str, (Integer)localObject);
      } else if ((localObject instanceof Long)) {
        localContentValues.put(str, (Long)localObject);
      } else if ((localObject instanceof String)) {
        localContentValues.put(str, (String)localObject);
      } else if ((localObject instanceof byte[])) {
        localContentValues.put(str, (byte[])localObject);
      } else if ((localObject instanceof Short)) {
        localContentValues.put(str, (Short)localObject);
      } else if ((localObject instanceof Boolean)) {
        localContentValues.put(str, (Boolean)localObject);
      } else if ((localObject instanceof Double)) {
        localContentValues.put(str, (Double)localObject);
      } else if ((localObject instanceof Float)) {
        localContentValues.put(str, (Float)localObject);
      } else if ((localObject instanceof Byte)) {
        localContentValues.put(str, (Byte)localObject);
      } else if ((localObject instanceof Boolean)) {
        localContentValues.put(str, (Boolean)localObject);
      }
    }
    OGStat.a().a("createContentValue", paramEntity, l);
    return localContentValues;
  }
  
  public Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      if (d(paramString1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.b().a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString5, paramString6);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = paramString1;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
      }
      return null;
    }
    finally {}
  }
  
  public Entity a(Class paramClass, long paramLong)
  {
    paramClass = a(paramClass, false, "_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public Entity a(Class paramClass, Cursor paramCursor)
  {
    try
    {
      paramClass = a(paramClass, ((Entity)paramClass.newInstance()).getTableName(), paramCursor);
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  public Entity a(Class paramClass, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = TableBuilder.a(paramClass).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (Field)localIterator.next();
    } while (!((Field)localObject1).isAnnotationPresent(unique.class));
    Object localObject1 = ((Field)localObject1).getName();
    paramClass = a(paramClass, false, (String)localObject1 + "=?", new String[] { paramString }, null, null, null, null);
    localObject1 = localObject2;
    if (paramClass != null)
    {
      localObject1 = localObject2;
      if (paramClass.size() > 0) {
        localObject1 = (Entity)paramClass.get(0);
      }
    }
    return localObject1;
  }
  
  public Entity a(Class paramClass, String paramString, Cursor paramCursor)
  {
    long l2 = System.nanoTime();
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    long l1 = -1L;
    Entity localEntity2;
    Field localField;
    Class localClass;
    int i;
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l1 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
      Object localObject;
      try
      {
        localEntity2 = (Entity)paramClass.newInstance();
        localObject = localEntity2;
        if (localEntity2 != null)
        {
          localEntity2._id = l1;
          if (localEntity2.entityByCursor(paramCursor)) {
            break label490;
          }
          localObject = TableBuilder.a(localEntity2).iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label490;
            }
            localField = (Field)((Iterator)localObject).next();
            localClass = localField.getType();
            if (Entity.class.isAssignableFrom(localClass))
            {
              Entity localEntity3 = a(localClass, paramCursor);
              localEntity3._status = 1002;
              localField.set(localEntity2, localEntity3);
            }
            i = paramCursor.getColumnIndex(localField.getName());
            if (i != -1)
            {
              if (!localField.isAccessible()) {
                localField.setAccessible(true);
              }
              if (localClass != Long.TYPE) {
                break;
              }
              localField.set(localEntity2, Long.valueOf(paramCursor.getLong(i)));
            }
          }
        }
        OGStat.a().a("cursor2Entity", paramClass, l2);
      }
      catch (Exception paramString)
      {
        localObject = null;
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = -1L;
        continue;
        if (localClass == Integer.TYPE)
        {
          localField.set(localEntity2, Integer.valueOf(paramCursor.getInt(i)));
        }
        else if (localClass == String.class)
        {
          localField.set(localEntity2, paramCursor.getString(i));
        }
        else if (localClass == Byte.TYPE)
        {
          localField.set(localEntity2, Byte.valueOf((byte)paramCursor.getShort(i)));
        }
        else if (localClass == [B.class)
        {
          localField.set(localEntity2, paramCursor.getBlob(i));
        }
        else
        {
          if (localClass != Short.TYPE) {
            break;
          }
          localField.set(localEntity2, Short.valueOf(paramCursor.getShort(i)));
        }
      }
      if (localClass != Boolean.TYPE) {
        break label432;
      }
    }
    if (paramCursor.getInt(i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localField.set(localEntity2, Boolean.valueOf(bool));
      break;
      label432:
      if (localClass == Float.TYPE)
      {
        localField.set(localEntity2, Float.valueOf(paramCursor.getFloat(i)));
        break;
      }
      if (localClass != Double.TYPE) {
        break;
      }
      localField.set(localEntity2, Double.valueOf(paramCursor.getDouble(i)));
      break;
      label490:
      if ((l1 != -1L) && (paramString != null)) {}
      for (localEntity2._status = 1001;; localEntity2._status = 1002)
      {
        localEntity2.postRead();
        Entity localEntity1 = localEntity2;
        break;
      }
    }
  }
  
  public Entity a(Class paramClass, String paramString, String[] paramArrayOfString)
  {
    paramClass = a(paramClass, true, paramString, paramArrayOfString, null, null, null, "1");
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public Entity a(Class paramClass, String... paramVarArgs)
  {
    if (!paramClass.isAnnotationPresent(uniqueConstraints.class)) {
      throw new IllegalStateException("No uniqueConstraints annotation in the Entity " + paramClass.getSimpleName());
    }
    String[] arrayOfString = ((uniqueConstraints)paramClass.getAnnotation(uniqueConstraints.class)).columnNames().split(",");
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < arrayOfString.length)
    {
      localStringBuffer.append(arrayOfString[i]);
      if (i == arrayOfString.length - 1) {
        localStringBuffer.append("=?");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append("=? and ");
      }
    }
    paramClass = a(paramClass, false, localStringBuffer.toString(), paramVarArgs, null, null, null, null);
    if (paramClass != null) {
      return (Entity)paramClass.get(0);
    }
    return null;
  }
  
  public EntityTransaction a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction = new EntityTransaction(this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityTransaction;
  }
  
  public List a(Class paramClass)
  {
    return a(paramClass, false, null, null, null, null, null, null);
  }
  
  /* Error */
  public List a(Class paramClass, String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: invokestatic 81	java/lang/System:nanoTime	()J
    //   3: lstore 10
    //   5: iconst_0
    //   6: ifeq +72 -> 78
    //   9: aload_0
    //   10: getfield 29	com/tencent/mobileqq/persistence/EntityManager:jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   13: invokevirtual 272	com/tencent/mobileqq/app/SQLiteOpenHelper:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   16: aconst_null
    //   17: aload_2
    //   18: aload 4
    //   20: aload 5
    //   22: invokevirtual 445	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnull +151 -> 180
    //   32: aload 4
    //   34: astore 5
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: aload 4
    //   41: invokespecial 447	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   44: astore_2
    //   45: aload_2
    //   46: astore 5
    //   48: aload 4
    //   50: ifnull +13 -> 63
    //   53: aload 4
    //   55: invokeinterface 450 1 0
    //   60: aload_2
    //   61: astore 5
    //   63: invokestatic 126	com/tencent/mobileqq/persistence/OGStat:a	()Lcom/tencent/mobileqq/persistence/OGStat;
    //   66: ldc_w 452
    //   69: aload_1
    //   70: lload 10
    //   72: invokevirtual 348	com/tencent/mobileqq/persistence/OGStat:a	(Ljava/lang/String;Ljava/lang/Class;J)V
    //   75: aload 5
    //   77: areturn
    //   78: aload_0
    //   79: iload_3
    //   80: aload_2
    //   81: aconst_null
    //   82: aload 4
    //   84: aload 5
    //   86: aload 6
    //   88: aload 7
    //   90: aload 8
    //   92: aload 9
    //   94: invokevirtual 454	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore 4
    //   99: goto -72 -> 27
    //   102: astore_2
    //   103: aconst_null
    //   104: astore 4
    //   106: aload 4
    //   108: astore 5
    //   110: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +17 -> 130
    //   116: aload 4
    //   118: astore 5
    //   120: ldc 8
    //   122: iconst_2
    //   123: aload_2
    //   124: invokestatic 70	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   127: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 4
    //   132: ifnull +42 -> 174
    //   135: aload 4
    //   137: invokeinterface 450 1 0
    //   142: aconst_null
    //   143: astore 5
    //   145: goto -82 -> 63
    //   148: astore_1
    //   149: aconst_null
    //   150: astore 5
    //   152: aload 5
    //   154: ifnull +10 -> 164
    //   157: aload 5
    //   159: invokeinterface 450 1 0
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: goto -15 -> 152
    //   170: astore_2
    //   171: goto -65 -> 106
    //   174: aconst_null
    //   175: astore 5
    //   177: goto -114 -> 63
    //   180: aconst_null
    //   181: astore_2
    //   182: goto -137 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	EntityManager
    //   0	185	1	paramClass	Class
    //   0	185	2	paramString1	String
    //   0	185	3	paramBoolean	boolean
    //   0	185	4	paramString2	String
    //   0	185	5	paramArrayOfString	String[]
    //   0	185	6	paramString3	String
    //   0	185	7	paramString4	String
    //   0	185	8	paramString5	String
    //   0	185	9	paramString6	String
    //   3	68	10	l	long
    // Exception table:
    //   from	to	target	type
    //   9	27	102	java/lang/Exception
    //   78	99	102	java/lang/Exception
    //   9	27	148	finally
    //   78	99	148	finally
    //   36	45	166	finally
    //   110	116	166	finally
    //   120	130	166	finally
    //   36	45	170	java/lang/Exception
  }
  
  /* Error */
  public List a(Class paramClass, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 81	java/lang/System:nanoTime	()J
    //   9: lstore 4
    //   11: aload_0
    //   12: getfield 29	com/tencent/mobileqq/persistence/EntityManager:jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper	Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   15: invokevirtual 272	com/tencent/mobileqq/app/SQLiteOpenHelper:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   18: aload_2
    //   19: aload_3
    //   20: invokevirtual 458	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_2
    //   24: aload 6
    //   26: astore_3
    //   27: aload_2
    //   28: ifnull +17 -> 45
    //   31: aload_2
    //   32: astore_3
    //   33: aload_0
    //   34: aload_1
    //   35: aconst_null
    //   36: aload_2
    //   37: invokespecial 447	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;Landroid/database/Cursor;)Ljava/util/List;
    //   40: astore 6
    //   42: aload 6
    //   44: astore_3
    //   45: aload_3
    //   46: astore 6
    //   48: aload_2
    //   49: ifnull +12 -> 61
    //   52: aload_2
    //   53: invokeinterface 450 1 0
    //   58: aload_3
    //   59: astore 6
    //   61: invokestatic 126	com/tencent/mobileqq/persistence/OGStat:a	()Lcom/tencent/mobileqq/persistence/OGStat;
    //   64: ldc_w 460
    //   67: aload_1
    //   68: lload 4
    //   70: invokevirtual 348	com/tencent/mobileqq/persistence/OGStat:a	(Ljava/lang/String;Ljava/lang/Class;J)V
    //   73: aload 6
    //   75: areturn
    //   76: astore 6
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_2
    //   81: astore_3
    //   82: invokestatic 64	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +16 -> 101
    //   88: aload_2
    //   89: astore_3
    //   90: ldc 8
    //   92: iconst_2
    //   93: aload 6
    //   95: invokestatic 70	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   98: invokestatic 74	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload 7
    //   103: astore 6
    //   105: aload_2
    //   106: ifnull -45 -> 61
    //   109: aload_2
    //   110: invokeinterface 450 1 0
    //   115: aload 7
    //   117: astore 6
    //   119: goto -58 -> 61
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull +9 -> 135
    //   129: aload_3
    //   130: invokeinterface 450 1 0
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: goto -13 -> 125
    //   141: astore 6
    //   143: goto -63 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	EntityManager
    //   0	146	1	paramClass	Class
    //   0	146	2	paramString	String
    //   0	146	3	paramArrayOfString	String[]
    //   9	60	4	l	long
    //   4	70	6	localObject1	Object
    //   76	18	6	localException1	Exception
    //   103	15	6	localObject2	Object
    //   141	1	6	localException2	Exception
    //   1	115	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	24	76	java/lang/Exception
    //   11	24	122	finally
    //   33	42	137	finally
    //   82	88	137	finally
    //   90	101	137	finally
    //   33	42	141	java/lang/Exception
  }
  
  public List a(Class paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = a(paramClass, ((Entity)paramClass.newInstance()).getTableName(), paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("EntityManager", 2, "query Exception, table : " + paramClass);
        QLog.d("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(Entity paramEntity)
  {
    try
    {
      a(paramEntity, false);
      return;
    }
    catch (Throwable paramEntity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EntityManager", 2, "persist error", paramEntity);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Entity paramEntity)
  {
    long l = System.nanoTime();
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    paramEntity.prewrite();
    try
    {
      if ((paramEntity._status == 1001) || (paramEntity._status == 1002))
      {
        ContentValues localContentValues = a(paramEntity);
        int i = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramEntity.getTableName(), localContentValues, "_id=?", new String[] { String.valueOf(paramEntity._id) });
        return i > 0;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
      }
      paramEntity.postwrite();
      OGStat.a().a("update", paramEntity, l);
    }
    return false;
  }
  
  public boolean a(Class paramClass)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    try
    {
      paramClass = ((Entity)paramClass.newInstance()).getTableName();
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("DROP TABLE IF EXISTS " + paramClass);
      jdField_a_of_type_JavaUtilHashtable.remove(paramClass);
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(paramClass);
      return true;
    }
    catch (Exception paramClass)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramClass));
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("DROP TABLE IF EXISTS " + paramString);
      jdField_a_of_type_JavaUtilHashtable.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b(paramString);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    boolean bool = false;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
      int i = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramString1, paramContentValues, paramString2, paramArrayOfString);
      if (i > 0) {
        bool = true;
      }
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString1));
    }
    return bool;
    return false;
  }
  
  public boolean a(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramString, paramArrayOfObject);
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString));
        }
      }
    }
  }
  
  public void b(Entity paramEntity)
  {
    try
    {
      a(paramEntity, true);
      return;
    }
    catch (Throwable paramEntity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EntityManager", 2, "persistOrReplace error", paramEntity);
    }
  }
  
  public boolean b(Entity paramEntity)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    paramEntity.prewrite();
    if (paramEntity._status == 1001) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(paramEntity.getTableName(), "_id=?", new String[] { String.valueOf(paramEntity._id) }) > 0) {
        paramEntity._status = 1003;
      }
    }
    for (;;)
    {
      paramEntity.postwrite();
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.b().a(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(paramString));
      }
      return false;
    }
    finally {}
  }
  
  public void c(Entity paramEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.a();
    }
    String str = paramEntity.getTableName();
    a(str, paramEntity, false);
    paramEntity.prewrite();
    try
    {
      ContentValues localContentValues = a(paramEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a("delete from " + str);
      long l2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
      long l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (a(str, paramEntity, true)) {
          l1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a(str, null, localContentValues);
        }
      }
      if (l1 != -1L)
      {
        paramEntity._id = l1;
        paramEntity._status = 1001;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EntityManager", 2, MsfSdkUtils.getStackTraceString(localException));
        }
      }
    }
    paramEntity.postwrite();
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, null);
  }
  
  public boolean d(String paramString)
  {
    boolean bool1;
    if (paramString == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      if ("Sqlite_master".equalsIgnoreCase(paramString)) {
        return true;
      }
      bool2 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper.b().b(paramString);
      bool1 = bool2;
    } while (!QLog.isDevelopLevel());
    QLog.d("EntityManager", 2, " TABLECACHE tabbleIsExist : tableName:" + paramString + " isExist:" + bool2);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManager
 * JD-Core Version:    0.7.0.1
 */