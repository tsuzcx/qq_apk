package com.tencent.tmassistant.common.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements c
{
  /* Error */
  public b a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 17	com/tencent/tmassistant/common/a/b
    //   6: dup
    //   7: invokespecial 18	com/tencent/tmassistant/common/a/b:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: new 20	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 21	java/util/ArrayList:<init>	()V
    //   21: putfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   24: aload 7
    //   26: new 20	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 21	java/util/ArrayList:<init>	()V
    //   33: putfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   36: iload_1
    //   37: ifle +255 -> 292
    //   40: new 29	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   47: ldc 32
    //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 5
    //   61: aload_0
    //   62: invokevirtual 47	com/tencent/tmassistant/common/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   65: invokevirtual 53	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnull +151 -> 223
    //   75: aload 6
    //   77: aload_0
    //   78: invokevirtual 56	com/tencent/tmassistant/common/a/a:d	()Ljava/lang/String;
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: ldc 58
    //   88: aload 5
    //   90: invokevirtual 64	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore 6
    //   95: aload 6
    //   97: ifnull +114 -> 211
    //   100: aload 6
    //   102: astore 5
    //   104: aload 6
    //   106: invokeinterface 70 1 0
    //   111: ifeq +100 -> 211
    //   114: aload 6
    //   116: astore 5
    //   118: aload 6
    //   120: aload 6
    //   122: ldc 72
    //   124: invokeinterface 76 2 0
    //   129: invokeinterface 80 2 0
    //   134: lstore_2
    //   135: aload 6
    //   137: astore 5
    //   139: aload 7
    //   141: getfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   144: lload_2
    //   145: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: invokeinterface 92 2 0
    //   153: pop
    //   154: aload 6
    //   156: astore 5
    //   158: aload 6
    //   160: aload 6
    //   162: ldc 94
    //   164: invokeinterface 76 2 0
    //   169: invokeinterface 98 2 0
    //   174: astore 9
    //   176: aload 6
    //   178: astore 5
    //   180: aload 7
    //   182: getfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   185: aload 9
    //   187: invokeinterface 92 2 0
    //   192: pop
    //   193: aload 6
    //   195: astore 5
    //   197: aload 6
    //   199: invokeinterface 101 1 0
    //   204: istore 4
    //   206: iload 4
    //   208: ifne -94 -> 114
    //   211: aload 6
    //   213: ifnull +10 -> 223
    //   216: aload 6
    //   218: invokeinterface 104 1 0
    //   223: aload 7
    //   225: astore 5
    //   227: aload 5
    //   229: areturn
    //   230: astore 7
    //   232: aconst_null
    //   233: astore 6
    //   235: aload 6
    //   237: astore 5
    //   239: aload 7
    //   241: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   244: aload 8
    //   246: astore 5
    //   248: aload 6
    //   250: ifnull -23 -> 227
    //   253: aload 6
    //   255: invokeinterface 104 1 0
    //   260: aconst_null
    //   261: areturn
    //   262: astore 6
    //   264: aconst_null
    //   265: astore 5
    //   267: aload 5
    //   269: ifnull +10 -> 279
    //   272: aload 5
    //   274: invokeinterface 104 1 0
    //   279: aload 6
    //   281: athrow
    //   282: astore 6
    //   284: goto -17 -> 267
    //   287: astore 7
    //   289: goto -54 -> 235
    //   292: aconst_null
    //   293: astore 5
    //   295: goto -234 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	a
    //   0	298	1	paramInt	int
    //   134	11	2	l	long
    //   204	3	4	bool	boolean
    //   59	235	5	localObject1	Object
    //   68	186	6	localObject2	Object
    //   262	18	6	localObject3	Object
    //   282	1	6	localObject4	Object
    //   10	214	7	localb	b
    //   230	10	7	localException1	Exception
    //   287	1	7	localException2	Exception
    //   1	244	8	localObject5	Object
    //   174	12	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   75	95	230	java/lang/Exception
    //   75	95	262	finally
    //   104	114	282	finally
    //   118	135	282	finally
    //   139	154	282	finally
    //   158	176	282	finally
    //   180	193	282	finally
    //   197	206	282	finally
    //   239	244	282	finally
    //   104	114	287	java/lang/Exception
    //   118	135	287	java/lang/Exception
    //   139	154	287	java/lang/Exception
    //   158	176	287	java/lang/Exception
    //   180	193	287	java/lang/Exception
    //   197	206	287	java/lang/Exception
  }
  
  public String a()
  {
    return d();
  }
  
  public boolean a(List paramList)
  {
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = c().getWritableDatabase();
        if (localSQLiteDatabase != null) {
          try
          {
            localSQLiteDatabase.beginTransaction();
            SQLiteStatement localSQLiteStatement = localSQLiteDatabase.compileStatement(f());
            paramList = paramList.iterator();
            if (paramList.hasNext())
            {
              localSQLiteStatement.bindBlob(1, (byte[])paramList.next());
              localSQLiteStatement.executeInsert();
              continue;
            }
            paramList = finally;
          }
          catch (Exception paramList)
          {
            paramList.printStackTrace();
            bool = false;
            localSQLiteDatabase.endTransaction();
            return bool;
            localSQLiteDatabase.setTransactionSuccessful();
          }
          finally
          {
            localSQLiteDatabase.endTransaction();
          }
        }
        boolean bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 155	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 156	android/content/ContentValues:<init>	()V
    //   9: astore 5
    //   11: aload 5
    //   13: ldc 94
    //   15: aload_1
    //   16: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   19: aload_0
    //   20: invokevirtual 47	com/tencent/tmassistant/common/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   23: invokevirtual 111	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: aload_0
    //   27: invokevirtual 56	com/tencent/tmassistant/common/a/a:d	()Ljava/lang/String;
    //   30: aconst_null
    //   31: aload 5
    //   33: invokevirtual 164	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   36: lstore_2
    //   37: lload_2
    //   38: lconst_0
    //   39: lcmp
    //   40: ifle +11 -> 51
    //   43: iconst_1
    //   44: istore 4
    //   46: aload_0
    //   47: monitorexit
    //   48: iload 4
    //   50: ireturn
    //   51: iconst_0
    //   52: istore 4
    //   54: goto -8 -> 46
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	a
    //   0	62	1	paramArrayOfByte	byte[]
    //   36	2	2	l	long
    //   44	9	4	bool	boolean
    //   9	23	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   2	37	57	finally
  }
  
  public String[] a(int paramInt1, int paramInt2)
  {
    return b(paramInt2);
  }
  
  public String b()
  {
    return e();
  }
  
  public boolean b(List paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      StringBuffer localStringBuffer;
      try
      {
        int i = paramList.size();
        if (i <= 0)
        {
          bool = false;
          return bool;
        }
        localStringBuffer = new StringBuffer("(");
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localStringBuffer.append((Long)paramList.next());
          localStringBuffer.append(",");
          continue;
        }
        if (localStringBuffer.length() <= 0) {
          break label102;
        }
      }
      finally {}
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      label102:
      localStringBuffer.append(")");
      paramList = c().getWritableDatabase();
      if (paramList != null) {
        paramList.delete(d(), "_id in " + localStringBuffer, null);
      }
      boolean bool = true;
    }
  }
  
  protected abstract String[] b(int paramInt);
  
  public d c()
  {
    return com.tencent.tmassistantsdk.internal.d.a.a.c();
  }
  
  protected abstract String d();
  
  protected abstract String e();
  
  protected abstract String f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.a.a
 * JD-Core Version:    0.7.0.1
 */