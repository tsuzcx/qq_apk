package com.tencent.mm.plugin.h.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class b
  extends i<a>
{
  public static final String[] cqY = { "CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) " };
  public static final String[] dXp = { i.a(a.buS, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex" };
  public e dXw;
  
  public b(e parame)
  {
    super(parame, a.buS, "WxFileIndex2", cqY);
    this.dXw = parame;
  }
  
  /* Error */
  public final List<a> O(com.tencent.mm.storage.bi parambi)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: new 50	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 52
    //   16: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: getfield 61	com/tencent/mm/h/c/cs:field_msgId	J
    //   23: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: ldc 67
    //   28: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: getfield 74	com/tencent/mm/h/c/cs:field_talker	Ljava/lang/String;
    //   35: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 76
    //   40: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 5
    //   48: new 82	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 84	java/util/ArrayList:<init>	()V
    //   55: astore 4
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 44	com/tencent/mm/plugin/h/b/b:dXw	Lcom/tencent/mm/sdk/e/e;
    //   63: aload 5
    //   65: aconst_null
    //   66: invokeinterface 90 3 0
    //   71: astore_3
    //   72: aload_3
    //   73: astore_1
    //   74: aload_3
    //   75: astore_2
    //   76: aload_3
    //   77: invokeinterface 96 1 0
    //   82: ifeq +57 -> 139
    //   85: aload_3
    //   86: astore_1
    //   87: aload_3
    //   88: astore_2
    //   89: new 16	com/tencent/mm/plugin/h/b/a
    //   92: dup
    //   93: invokespecial 97	com/tencent/mm/plugin/h/b/a:<init>	()V
    //   96: astore 5
    //   98: aload_3
    //   99: astore_1
    //   100: aload_3
    //   101: astore_2
    //   102: aload 5
    //   104: aload_3
    //   105: invokevirtual 101	com/tencent/mm/plugin/h/b/a:d	(Landroid/database/Cursor;)V
    //   108: aload_3
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: aload 4
    //   114: aload 5
    //   116: invokeinterface 107 2 0
    //   121: pop
    //   122: goto -50 -> 72
    //   125: astore_2
    //   126: aload_1
    //   127: ifnull +9 -> 136
    //   130: aload_1
    //   131: invokeinterface 110 1 0
    //   136: aload 4
    //   138: areturn
    //   139: aload_3
    //   140: ifnull -4 -> 136
    //   143: aload_3
    //   144: invokeinterface 110 1 0
    //   149: goto -13 -> 136
    //   152: astore_1
    //   153: aload_2
    //   154: ifnull +9 -> 163
    //   157: aload_2
    //   158: invokeinterface 110 1 0
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	b
    //   0	165	1	parambi	com.tencent.mm.storage.bi
    //   1	111	2	localObject1	Object
    //   125	33	2	localException	Exception
    //   3	141	3	localCursor	Cursor
    //   55	82	4	localArrayList	java.util.ArrayList
    //   46	69	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	72	125	java/lang/Exception
    //   76	85	125	java/lang/Exception
    //   89	98	125	java/lang/Exception
    //   102	108	125	java/lang/Exception
    //   112	122	125	java/lang/Exception
    //   59	72	152	finally
    //   76	85	152	finally
    //   89	98	152	finally
    //   102	108	152	finally
    //   112	122	152	finally
  }
  
  public final int aN(List<a> paramList)
  {
    if (paramList.isEmpty()) {
      return 0;
    }
    long l = bk.UZ();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (a((a)localIterator.next(), false)) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    y.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()), Long.valueOf(bk.cp(l)) });
    return i;
  }
  
  public final int aO(List<a> paramList)
  {
    if (paramList.isEmpty()) {
      return 0;
    }
    long l = bk.UZ();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (a(locala.ujK, locala, false)) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    y.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()), Long.valueOf(bk.cp(l)) });
    return i;
  }
  
  public final long ayO()
  {
    Object localObject1 = null;
    long l2 = 0L;
    try
    {
      Cursor localCursor = this.dXw.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
      long l1 = l2;
      if (localCursor != null)
      {
        l1 = l2;
        localObject1 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          l1 = localCursor.getLong(0);
        }
      }
      return l1;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.close();
      }
    }
  }
  
  public final Cursor ayP()
  {
    try
    {
      Cursor localCursor = this.dXw.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
      return localCursor;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final boolean delete()
  {
    try
    {
      int i = this.dXw.delete("WxFileIndex2", null, null);
      l = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
    return l > 0L;
  }
  
  /* Error */
  public final List<a> j(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 123	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   3: lstore 6
    //   5: new 50	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 201
    //   11: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 203
    //   20: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_2
    //   24: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 205
    //   29: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: lload 4
    //   34: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc 207
    //   39: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 11
    //   47: new 82	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 84	java/util/ArrayList:<init>	()V
    //   54: astore 12
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 8
    //   62: aload_0
    //   63: getfield 44	com/tencent/mm/plugin/h/b/b:dXw	Lcom/tencent/mm/sdk/e/e;
    //   66: aload 11
    //   68: aconst_null
    //   69: invokeinterface 90 3 0
    //   74: astore 10
    //   76: aload 10
    //   78: ifnull +152 -> 230
    //   81: aload 10
    //   83: astore 8
    //   85: aload 10
    //   87: astore 9
    //   89: aload 10
    //   91: invokeinterface 96 1 0
    //   96: ifeq +134 -> 230
    //   99: aload 10
    //   101: astore 8
    //   103: aload 10
    //   105: astore 9
    //   107: new 16	com/tencent/mm/plugin/h/b/a
    //   110: dup
    //   111: invokespecial 97	com/tencent/mm/plugin/h/b/a:<init>	()V
    //   114: astore 13
    //   116: aload 10
    //   118: astore 8
    //   120: aload 10
    //   122: astore 9
    //   124: aload 13
    //   126: aload 10
    //   128: invokevirtual 101	com/tencent/mm/plugin/h/b/a:d	(Landroid/database/Cursor;)V
    //   131: aload 10
    //   133: astore 8
    //   135: aload 10
    //   137: astore 9
    //   139: aload 12
    //   141: aload 13
    //   143: invokeinterface 107 2 0
    //   148: pop
    //   149: goto -68 -> 81
    //   152: astore 10
    //   154: aload 8
    //   156: astore 9
    //   158: ldc 141
    //   160: aload 10
    //   162: ldc 209
    //   164: iconst_1
    //   165: anewarray 145	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload 11
    //   172: aastore
    //   173: invokestatic 213	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload 8
    //   178: ifnull +10 -> 188
    //   181: aload 8
    //   183: invokeinterface 110 1 0
    //   188: ldc 141
    //   190: ldc 215
    //   192: iconst_3
    //   193: anewarray 145	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload 12
    //   204: invokeinterface 155 1 0
    //   209: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: lload 6
    //   217: invokestatic 159	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   220: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   223: aastore
    //   224: invokestatic 218	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload 12
    //   229: areturn
    //   230: aload 10
    //   232: ifnull -44 -> 188
    //   235: aload 10
    //   237: invokeinterface 110 1 0
    //   242: goto -54 -> 188
    //   245: astore_1
    //   246: aload 9
    //   248: ifnull +10 -> 258
    //   251: aload 9
    //   253: invokeinterface 110 1 0
    //   258: aload_1
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	b
    //   0	260	1	paramString	String
    //   0	260	2	paramLong1	long
    //   0	260	4	paramLong2	long
    //   3	213	6	l	long
    //   60	122	8	localObject1	Object
    //   57	195	9	localObject2	Object
    //   74	62	10	localCursor	Cursor
    //   152	84	10	localException	Exception
    //   45	126	11	str	String
    //   54	174	12	localArrayList	java.util.ArrayList
    //   114	28	13	locala	a
    // Exception table:
    //   from	to	target	type
    //   62	76	152	java/lang/Exception
    //   89	99	152	java/lang/Exception
    //   107	116	152	java/lang/Exception
    //   124	131	152	java/lang/Exception
    //   139	149	152	java/lang/Exception
    //   62	76	245	finally
    //   89	99	245	finally
    //   107	116	245	finally
    //   124	131	245	finally
    //   139	149	245	finally
    //   158	176	245	finally
  }
  
  /* Error */
  public final List<a> k(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: invokestatic 123	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   3: lstore 6
    //   5: new 50	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 201
    //   11: invokespecial 55	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 203
    //   20: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_2
    //   24: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 205
    //   29: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: lload 4
    //   34: invokevirtual 65	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: ldc 222
    //   39: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 11
    //   47: new 82	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 84	java/util/ArrayList:<init>	()V
    //   54: astore 12
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 8
    //   62: aload_0
    //   63: getfield 44	com/tencent/mm/plugin/h/b/b:dXw	Lcom/tencent/mm/sdk/e/e;
    //   66: aload 11
    //   68: aconst_null
    //   69: invokeinterface 90 3 0
    //   74: astore 10
    //   76: aload 10
    //   78: ifnull +152 -> 230
    //   81: aload 10
    //   83: astore 8
    //   85: aload 10
    //   87: astore 9
    //   89: aload 10
    //   91: invokeinterface 96 1 0
    //   96: ifeq +134 -> 230
    //   99: aload 10
    //   101: astore 8
    //   103: aload 10
    //   105: astore 9
    //   107: new 16	com/tencent/mm/plugin/h/b/a
    //   110: dup
    //   111: invokespecial 97	com/tencent/mm/plugin/h/b/a:<init>	()V
    //   114: astore 13
    //   116: aload 10
    //   118: astore 8
    //   120: aload 10
    //   122: astore 9
    //   124: aload 13
    //   126: aload 10
    //   128: invokevirtual 101	com/tencent/mm/plugin/h/b/a:d	(Landroid/database/Cursor;)V
    //   131: aload 10
    //   133: astore 8
    //   135: aload 10
    //   137: astore 9
    //   139: aload 12
    //   141: aload 13
    //   143: invokeinterface 107 2 0
    //   148: pop
    //   149: goto -68 -> 81
    //   152: astore 10
    //   154: aload 8
    //   156: astore 9
    //   158: ldc 141
    //   160: aload 10
    //   162: ldc 209
    //   164: iconst_1
    //   165: anewarray 145	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload 11
    //   172: aastore
    //   173: invokestatic 213	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload 8
    //   178: ifnull +10 -> 188
    //   181: aload 8
    //   183: invokeinterface 110 1 0
    //   188: ldc 141
    //   190: ldc 224
    //   192: iconst_3
    //   193: anewarray 145	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_1
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload 12
    //   204: invokeinterface 155 1 0
    //   209: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: lload 6
    //   217: invokestatic 159	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   220: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   223: aastore
    //   224: invokestatic 218	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload 12
    //   229: areturn
    //   230: aload 10
    //   232: ifnull -44 -> 188
    //   235: aload 10
    //   237: invokeinterface 110 1 0
    //   242: goto -54 -> 188
    //   245: astore_1
    //   246: aload 9
    //   248: ifnull +10 -> 258
    //   251: aload 9
    //   253: invokeinterface 110 1 0
    //   258: aload_1
    //   259: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	b
    //   0	260	1	paramString	String
    //   0	260	2	paramLong1	long
    //   0	260	4	paramLong2	long
    //   3	213	6	l	long
    //   60	122	8	localObject1	Object
    //   57	195	9	localObject2	Object
    //   74	62	10	localCursor	Cursor
    //   152	84	10	localException	Exception
    //   45	126	11	str	String
    //   54	174	12	localArrayList	java.util.ArrayList
    //   114	28	13	locala	a
    // Exception table:
    //   from	to	target	type
    //   62	76	152	java/lang/Exception
    //   89	99	152	java/lang/Exception
    //   107	116	152	java/lang/Exception
    //   124	131	152	java/lang/Exception
    //   139	149	152	java/lang/Exception
    //   62	76	245	finally
    //   89	99	245	finally
    //   107	116	245	finally
    //   124	131	245	finally
    //   139	149	245	finally
    //   158	176	245	finally
  }
  
  public final long oI(int paramInt)
  {
    Object localObject1 = null;
    long l2 = 0L;
    Object localObject2 = "select sum(size)  from WxFileIndex2  where msgType=" + paramInt;
    try
    {
      localObject2 = this.dXw.rawQuery((String)localObject2, null);
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        localObject1 = localObject2;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = localObject2;
          l1 = ((Cursor)localObject2).getLong(0);
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      return l1;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.close();
      }
    }
  }
  
  public final long oJ(int paramInt)
  {
    Object localObject1 = null;
    long l2 = 0L;
    Object localObject2 = "select count(*)  from WxFileIndex2  where msgType=" + paramInt + " and size>0";
    try
    {
      localObject2 = this.dXw.rawQuery((String)localObject2, null);
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        localObject1 = localObject2;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = localObject2;
          l1 = ((Cursor)localObject2).getLong(0);
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      return l1;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.b
 * JD-Core Version:    0.7.0.1
 */