package com.tencent.mm.plugin.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(18640);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex" };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) " };
    AppMethodBeat.o(18640);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "WxFileIndex2", INDEX_CREATE);
    this.db = parame;
  }
  
  /* Error */
  public final List<a> S(com.tencent.mm.storage.bi parambi)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: sipush 18637
    //   7: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: ifnonnull +11 -> 22
    //   14: sipush 18637
    //   17: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: new 59	java/lang/StringBuilder
    //   25: dup
    //   26: ldc 61
    //   28: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_1
    //   32: getfield 70	com/tencent/mm/g/c/dd:field_msgId	J
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc 76
    //   40: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: getfield 83	com/tencent/mm/g/c/dd:field_talker	Ljava/lang/String;
    //   47: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 85
    //   52: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 5
    //   60: new 91	java/util/ArrayList
    //   63: dup
    //   64: invokespecial 93	java/util/ArrayList:<init>	()V
    //   67: astore 4
    //   69: aload_3
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 53	com/tencent/mm/plugin/f/b/b:db	Lcom/tencent/mm/sdk/e/e;
    //   75: aload 5
    //   77: aconst_null
    //   78: invokeinterface 99 3 0
    //   83: astore_3
    //   84: aload_3
    //   85: astore_1
    //   86: aload_3
    //   87: astore_2
    //   88: aload_3
    //   89: invokeinterface 105 1 0
    //   94: ifeq +63 -> 157
    //   97: aload_3
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: new 22	com/tencent/mm/plugin/f/b/a
    //   104: dup
    //   105: invokespecial 106	com/tencent/mm/plugin/f/b/a:<init>	()V
    //   108: astore 5
    //   110: aload_3
    //   111: astore_1
    //   112: aload_3
    //   113: astore_2
    //   114: aload 5
    //   116: aload_3
    //   117: invokevirtual 110	com/tencent/mm/plugin/f/b/a:convertFrom	(Landroid/database/Cursor;)V
    //   120: aload_3
    //   121: astore_1
    //   122: aload_3
    //   123: astore_2
    //   124: aload 4
    //   126: aload 5
    //   128: invokeinterface 116 2 0
    //   133: pop
    //   134: goto -50 -> 84
    //   137: astore_2
    //   138: aload_1
    //   139: ifnull +9 -> 148
    //   142: aload_1
    //   143: invokeinterface 119 1 0
    //   148: sipush 18637
    //   151: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload 4
    //   156: areturn
    //   157: aload_3
    //   158: ifnull -10 -> 148
    //   161: aload_3
    //   162: invokeinterface 119 1 0
    //   167: goto -19 -> 148
    //   170: astore_1
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 119 1 0
    //   181: sipush 18637
    //   184: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_1
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	b
    //   0	189	1	parambi	com.tencent.mm.storage.bi
    //   1	123	2	localObject1	Object
    //   137	39	2	localException	Exception
    //   3	159	3	localCursor	Cursor
    //   67	88	4	localArrayList	java.util.ArrayList
    //   58	69	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   71	84	137	java/lang/Exception
    //   88	97	137	java/lang/Exception
    //   101	110	137	java/lang/Exception
    //   114	120	137	java/lang/Exception
    //   124	134	137	java/lang/Exception
    //   71	84	170	finally
    //   88	97	170	finally
    //   101	110	170	finally
    //   114	120	170	finally
    //   124	134	170	finally
  }
  
  public final int ba(List<a> paramList)
  {
    AppMethodBeat.i(18638);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(18638);
      return 0;
    }
    long l = bo.yB();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (insertNotify((a)localIterator.next(), false)) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    ab.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()), Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(18638);
    return i;
  }
  
  public final long bav()
  {
    Object localObject1 = null;
    AppMethodBeat.i(18633);
    long l2 = 0L;
    try
    {
      Cursor localCursor = this.db.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
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
      AppMethodBeat.o(18633);
    }
  }
  
  public final Cursor baw()
  {
    Object localObject = null;
    AppMethodBeat.i(18634);
    try
    {
      Cursor localCursor = this.db.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
      localObject = localCursor;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    AppMethodBeat.o(18634);
    return localObject;
  }
  
  public final int bb(List<a> paramList)
  {
    AppMethodBeat.i(18639);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(18639);
      return 0;
    }
    long l = bo.yB();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (update(locala.systemRowid, locala, false)) {}
      for (int j = 1;; j = 0)
      {
        i = j + i;
        break;
      }
    }
    ab.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramList.size()), Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(18639);
    return i;
  }
  
  public final boolean delete()
  {
    AppMethodBeat.i(18630);
    try
    {
      int i = this.db.delete("WxFileIndex2", null, null);
      l = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
      AppMethodBeat.o(18630);
    }
    if (l > 0L)
    {
      AppMethodBeat.o(18630);
      return true;
    }
    return false;
  }
  
  /* Error */
  public final List<a> q(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: sipush 18635
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 132	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   9: lstore 6
    //   11: new 59	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 213
    //   17: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 215
    //   26: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_2
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc 217
    //   35: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: lload 4
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: ldc 219
    //   45: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 11
    //   53: new 91	java/util/ArrayList
    //   56: dup
    //   57: invokespecial 93	java/util/ArrayList:<init>	()V
    //   60: astore 12
    //   62: aconst_null
    //   63: astore 9
    //   65: aconst_null
    //   66: astore 8
    //   68: aload_0
    //   69: getfield 53	com/tencent/mm/plugin/f/b/b:db	Lcom/tencent/mm/sdk/e/e;
    //   72: aload 11
    //   74: aconst_null
    //   75: invokeinterface 99 3 0
    //   80: astore 10
    //   82: aload 10
    //   84: ifnull +158 -> 242
    //   87: aload 10
    //   89: astore 8
    //   91: aload 10
    //   93: astore 9
    //   95: aload 10
    //   97: invokeinterface 105 1 0
    //   102: ifeq +140 -> 242
    //   105: aload 10
    //   107: astore 8
    //   109: aload 10
    //   111: astore 9
    //   113: new 22	com/tencent/mm/plugin/f/b/a
    //   116: dup
    //   117: invokespecial 106	com/tencent/mm/plugin/f/b/a:<init>	()V
    //   120: astore 13
    //   122: aload 10
    //   124: astore 8
    //   126: aload 10
    //   128: astore 9
    //   130: aload 13
    //   132: aload 10
    //   134: invokevirtual 110	com/tencent/mm/plugin/f/b/a:convertFrom	(Landroid/database/Cursor;)V
    //   137: aload 10
    //   139: astore 8
    //   141: aload 10
    //   143: astore 9
    //   145: aload 12
    //   147: aload 13
    //   149: invokeinterface 116 2 0
    //   154: pop
    //   155: goto -68 -> 87
    //   158: astore 10
    //   160: aload 8
    //   162: astore 9
    //   164: ldc 151
    //   166: aload 10
    //   168: ldc 221
    //   170: iconst_1
    //   171: anewarray 155	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload 11
    //   178: aastore
    //   179: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload 8
    //   184: ifnull +10 -> 194
    //   187: aload 8
    //   189: invokeinterface 119 1 0
    //   194: ldc 151
    //   196: ldc 227
    //   198: iconst_3
    //   199: anewarray 155	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload 12
    //   210: invokeinterface 165 1 0
    //   215: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: aastore
    //   219: dup
    //   220: iconst_2
    //   221: lload 6
    //   223: invokestatic 169	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   226: invokestatic 174	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   229: aastore
    //   230: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: sipush 18635
    //   236: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload 12
    //   241: areturn
    //   242: aload 10
    //   244: ifnull -50 -> 194
    //   247: aload 10
    //   249: invokeinterface 119 1 0
    //   254: goto -60 -> 194
    //   257: astore_1
    //   258: aload 9
    //   260: ifnull +10 -> 270
    //   263: aload 9
    //   265: invokeinterface 119 1 0
    //   270: sipush 18635
    //   273: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_1
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	b
    //   0	278	1	paramString	String
    //   0	278	2	paramLong1	long
    //   0	278	4	paramLong2	long
    //   9	213	6	l	long
    //   66	122	8	localObject1	Object
    //   63	201	9	localObject2	Object
    //   80	62	10	localCursor	Cursor
    //   158	90	10	localException	Exception
    //   51	126	11	str	String
    //   60	180	12	localArrayList	java.util.ArrayList
    //   120	28	13	locala	a
    // Exception table:
    //   from	to	target	type
    //   68	82	158	java/lang/Exception
    //   95	105	158	java/lang/Exception
    //   113	122	158	java/lang/Exception
    //   130	137	158	java/lang/Exception
    //   145	155	158	java/lang/Exception
    //   68	82	257	finally
    //   95	105	257	finally
    //   113	122	257	finally
    //   130	137	257	finally
    //   145	155	257	finally
    //   164	182	257	finally
  }
  
  /* Error */
  public final List<a> r(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: sipush 18636
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 132	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   9: lstore 6
    //   11: new 59	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 213
    //   17: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 215
    //   26: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_2
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc 217
    //   35: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: lload 4
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: ldc 233
    //   45: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 11
    //   53: new 91	java/util/ArrayList
    //   56: dup
    //   57: invokespecial 93	java/util/ArrayList:<init>	()V
    //   60: astore 12
    //   62: aconst_null
    //   63: astore 9
    //   65: aconst_null
    //   66: astore 8
    //   68: aload_0
    //   69: getfield 53	com/tencent/mm/plugin/f/b/b:db	Lcom/tencent/mm/sdk/e/e;
    //   72: aload 11
    //   74: aconst_null
    //   75: invokeinterface 99 3 0
    //   80: astore 10
    //   82: aload 10
    //   84: ifnull +158 -> 242
    //   87: aload 10
    //   89: astore 8
    //   91: aload 10
    //   93: astore 9
    //   95: aload 10
    //   97: invokeinterface 105 1 0
    //   102: ifeq +140 -> 242
    //   105: aload 10
    //   107: astore 8
    //   109: aload 10
    //   111: astore 9
    //   113: new 22	com/tencent/mm/plugin/f/b/a
    //   116: dup
    //   117: invokespecial 106	com/tencent/mm/plugin/f/b/a:<init>	()V
    //   120: astore 13
    //   122: aload 10
    //   124: astore 8
    //   126: aload 10
    //   128: astore 9
    //   130: aload 13
    //   132: aload 10
    //   134: invokevirtual 110	com/tencent/mm/plugin/f/b/a:convertFrom	(Landroid/database/Cursor;)V
    //   137: aload 10
    //   139: astore 8
    //   141: aload 10
    //   143: astore 9
    //   145: aload 12
    //   147: aload 13
    //   149: invokeinterface 116 2 0
    //   154: pop
    //   155: goto -68 -> 87
    //   158: astore 10
    //   160: aload 8
    //   162: astore 9
    //   164: ldc 151
    //   166: aload 10
    //   168: ldc 221
    //   170: iconst_1
    //   171: anewarray 155	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload 11
    //   178: aastore
    //   179: invokestatic 225	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload 8
    //   184: ifnull +10 -> 194
    //   187: aload 8
    //   189: invokeinterface 119 1 0
    //   194: ldc 151
    //   196: ldc 235
    //   198: iconst_3
    //   199: anewarray 155	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload 12
    //   210: invokeinterface 165 1 0
    //   215: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: aastore
    //   219: dup
    //   220: iconst_2
    //   221: lload 6
    //   223: invokestatic 169	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   226: invokestatic 174	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   229: aastore
    //   230: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: sipush 18636
    //   236: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload 12
    //   241: areturn
    //   242: aload 10
    //   244: ifnull -50 -> 194
    //   247: aload 10
    //   249: invokeinterface 119 1 0
    //   254: goto -60 -> 194
    //   257: astore_1
    //   258: aload 9
    //   260: ifnull +10 -> 270
    //   263: aload 9
    //   265: invokeinterface 119 1 0
    //   270: sipush 18636
    //   273: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_1
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	b
    //   0	278	1	paramString	String
    //   0	278	2	paramLong1	long
    //   0	278	4	paramLong2	long
    //   9	213	6	l	long
    //   66	122	8	localObject1	Object
    //   63	201	9	localObject2	Object
    //   80	62	10	localCursor	Cursor
    //   158	90	10	localException	Exception
    //   51	126	11	str	String
    //   60	180	12	localArrayList	java.util.ArrayList
    //   120	28	13	locala	a
    // Exception table:
    //   from	to	target	type
    //   68	82	158	java/lang/Exception
    //   95	105	158	java/lang/Exception
    //   113	122	158	java/lang/Exception
    //   130	137	158	java/lang/Exception
    //   145	155	158	java/lang/Exception
    //   68	82	257	finally
    //   95	105	257	finally
    //   113	122	257	finally
    //   130	137	257	finally
    //   145	155	257	finally
    //   164	182	257	finally
  }
  
  public final long sS(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(18631);
    l2 = 0L;
    Object localObject4 = "select sum(size)  from WxFileIndex2  where msgType=".concat(String.valueOf(paramInt));
    try
    {
      localObject4 = this.db.rawQuery((String)localObject4, null);
      long l1 = l2;
      if (localObject4 != null)
      {
        l1 = l2;
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          l1 = ((Cursor)localObject4).getLong(0);
        }
      }
      l3 = l1;
      if (localObject4 != null)
      {
        ((Cursor)localObject4).close();
        l3 = l1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", localException, "getSumByMsgType error", new Object[0]);
        long l3 = l2;
        if (localObject1 != null)
        {
          localObject1.close();
          l3 = l2;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label169;
      }
      localObject3.close();
      AppMethodBeat.o(18631);
    }
    AppMethodBeat.o(18631);
    return l3;
  }
  
  public final long sT(int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(18632);
    long l2 = 0L;
    Object localObject2 = "select count(*)  from WxFileIndex2  where msgType=" + paramInt + " and size>0";
    try
    {
      localObject2 = this.db.rawQuery((String)localObject2, null);
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
      AppMethodBeat.o(18632);
      return l1;
    }
    finally
    {
      if (localObject1 != null) {
        localObject1.close();
      }
      AppMethodBeat.o(18632);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.b
 * JD-Core Version:    0.7.0.1
 */