package com.tencent.tmassistant.common.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.tmassistantbase.a.k;

public abstract class d
  extends SQLiteOpenHelper
{
  public d(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    k.c("sqliteHelper", "tables count:" + b().length);
    Class[] arrayOfClass = b();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Object localObject = arrayOfClass[i];
      try
      {
        localObject = ((c)((Class)localObject).newInstance()).b();
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          paramSQLiteDatabase.execSQL((String)localObject);
        }
        k.c("sqliteHelper", "sql=" + (String)localObject);
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          localInstantiationException.printStackTrace();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      i += 1;
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Class[] arrayOfClass = b();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          paramSQLiteDatabase.delete(((c)localClass.newInstance()).a(), null, null);
          i += 1;
        }
        catch (InstantiationException localInstantiationException)
        {
          for (;;)
          {
            localInstantiationException.printStackTrace();
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
          }
        }
      }
    }
  }
  
  public abstract int a();
  
  public abstract Class[] b();
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 85	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   11: ifne +12 -> 23
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 92	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   20: ifeq +19 -> 39
    //   23: ldc2_w 93
    //   26: invokestatic 100	android/os/SystemClock:sleep	(J)V
    //   29: goto -22 -> 7
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   37: aload_1
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -18 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	d
    //   6	32	1	localSQLiteDatabase1	SQLiteDatabase
    //   43	4	1	localObject1	Object
    //   50	1	1	localObject2	Object
    //   15	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   32	2	2	localException1	Exception
    //   38	4	2	localSQLiteDatabase3	SQLiteDatabase
    //   48	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	32	java/lang/Exception
    //   16	23	32	java/lang/Exception
    //   23	29	32	java/lang/Exception
    //   2	7	43	finally
    //   7	14	43	finally
    //   16	23	43	finally
    //   23	29	43	finally
    //   33	37	43	finally
    //   2	7	48	java/lang/Exception
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 104	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   11: ifne +12 -> 23
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: invokevirtual 92	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   20: ifeq +19 -> 39
    //   23: ldc2_w 93
    //   26: invokestatic 100	android/os/SystemClock:sleep	(J)V
    //   29: goto -22 -> 7
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   37: aload_1
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_2
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -18 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	d
    //   6	32	1	localSQLiteDatabase1	SQLiteDatabase
    //   43	4	1	localObject1	Object
    //   50	1	1	localObject2	Object
    //   15	1	2	localSQLiteDatabase2	SQLiteDatabase
    //   32	2	2	localException1	Exception
    //   38	4	2	localSQLiteDatabase3	SQLiteDatabase
    //   48	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	32	java/lang/Exception
    //   16	23	32	java/lang/Exception
    //   23	29	32	java/lang/Exception
    //   2	7	43	finally
    //   7	14	43	finally
    //   16	23	43	finally
    //   23	29	43	finally
    //   33	37	43	finally
    //   2	7	48	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    b(paramSQLiteDatabase);
    a(paramSQLiteDatabase);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    int i = paramSQLiteDatabase.getVersion();
    k.c("sqliteHelper", " dbversion:" + i + " newVersion:" + a());
    if (i == 0) {
      return;
    }
    if (i < a())
    {
      onUpgrade(paramSQLiteDatabase, i, a());
      return;
    }
    if (i > a())
    {
      onDowngrade(paramSQLiteDatabase, i, a());
      return;
    }
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      Class[] arrayOfClass = b();
      int k = arrayOfClass.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          Object localObject = arrayOfClass[i];
          try
          {
            localObject = ((c)((Class)localObject).newInstance()).a(paramInt1, paramInt1 + 1);
            k.c("sqliteHelper", " upgrade:" + localObject);
            if (localObject != null)
            {
              int j = 0;
              while (j < localObject.length)
              {
                paramSQLiteDatabase.execSQL(localObject[j]);
                j += 1;
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i += 1;
          }
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.a.d
 * JD-Core Version:    0.7.0.1
 */