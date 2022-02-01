package com.tencent.mm.plugin.ai.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(240085);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "FinderRedDotHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(240085);
  }
  
  /* Error */
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: getstatic 27	com/tencent/mm/plugin/ai/f/c:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   7: ldc 29
    //   9: getstatic 37	com/tencent/mm/plugin/ai/f/d:INDEX_CREATE	[Ljava/lang/String;
    //   12: invokespecial 48	com/tencent/mm/sdk/storage/MAutoStorage:<init>	(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V
    //   15: ldc 49
    //   17: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 51	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   25: aload_0
    //   26: getfield 51	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   29: ldc 53
    //   31: aconst_null
    //   32: iconst_2
    //   33: invokeinterface 59 4 0
    //   38: astore_3
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: invokeinterface 65 1 0
    //   47: ifeq +13 -> 60
    //   50: aload_3
    //   51: astore_1
    //   52: aload_3
    //   53: iconst_0
    //   54: invokeinterface 69 2 0
    //   59: istore_2
    //   60: aload_3
    //   61: astore_1
    //   62: aload_3
    //   63: invokeinterface 72 1 0
    //   68: iload_2
    //   69: ldc 73
    //   71: if_icmplt +17 -> 88
    //   74: aload_0
    //   75: getfield 51	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   78: ldc 29
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokeinterface 77 4 0
    //   87: pop
    //   88: ldc 49
    //   90: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_1
    //   100: ldc 79
    //   102: new 81	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 83
    //   108: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload 4
    //   113: invokevirtual 90	java/lang/Exception:toString	()Ljava/lang/String;
    //   116: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_3
    //   126: ifnull +35 -> 161
    //   129: aload_3
    //   130: invokeinterface 72 1 0
    //   135: ldc 49
    //   137: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +9 -> 154
    //   148: aload_1
    //   149: invokeinterface 72 1 0
    //   154: ldc 49
    //   156: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_3
    //   160: athrow
    //   161: ldc 49
    //   163: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: astore_3
    //   168: goto -24 -> 144
    //   171: astore 4
    //   173: goto -75 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	d
    //   0	176	1	paramISQLiteDatabase	ISQLiteDatabase
    //   1	71	2	i	int
    //   38	92	3	localCursor	Cursor
    //   141	19	3	localObject1	Object
    //   167	1	3	localObject2	Object
    //   94	18	4	localException1	Exception
    //   171	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   25	39	94	java/lang/Exception
    //   74	88	94	java/lang/Exception
    //   25	39	141	finally
    //   74	88	141	finally
    //   41	50	167	finally
    //   52	60	167	finally
    //   62	68	167	finally
    //   100	125	167	finally
    //   41	50	171	java/lang/Exception
    //   52	60	171	java/lang/Exception
    //   62	68	171	java/lang/Exception
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(240065);
    boolean bool = super.insertNotify(paramc, false);
    AppMethodBeat.o(240065);
    return bool;
  }
  
  /* Error */
  public final java.util.HashSet<java.lang.Integer> bBs()
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 113	com/tencent/mm/pointers/PInt
    //   8: dup
    //   9: invokespecial 115	com/tencent/mm/pointers/PInt:<init>	()V
    //   12: astore_1
    //   13: new 113	com/tencent/mm/pointers/PInt
    //   16: dup
    //   17: invokespecial 115	com/tencent/mm/pointers/PInt:<init>	()V
    //   20: astore_2
    //   21: iconst_3
    //   22: invokestatic 121	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   25: aload_1
    //   26: aload_2
    //   27: invokestatic 126	com/tencent/mm/plugin/ai/c/a:a	(IJLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   30: ifne +10 -> 40
    //   33: ldc 111
    //   35: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 128	java/util/HashSet
    //   43: dup
    //   44: invokespecial 129	java/util/HashSet:<init>	()V
    //   47: astore 4
    //   49: new 81	java/lang/StringBuilder
    //   52: dup
    //   53: ldc 131
    //   55: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: getfield 135	com/tencent/mm/pointers/PInt:value	I
    //   62: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 140
    //   67: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: getfield 135	com/tencent/mm/pointers/PInt:value	I
    //   74: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 142
    //   79: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_1
    //   86: aload_0
    //   87: getfield 51	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   90: aload_1
    //   91: aconst_null
    //   92: invokeinterface 145 3 0
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +74 -> 173
    //   102: aload_2
    //   103: astore_1
    //   104: aload_2
    //   105: invokeinterface 65 1 0
    //   110: ifeq +63 -> 173
    //   113: aload_2
    //   114: astore_1
    //   115: aload 4
    //   117: aload_2
    //   118: iconst_0
    //   119: invokeinterface 69 2 0
    //   124: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokevirtual 155	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: goto -29 -> 102
    //   134: astore_3
    //   135: aload_2
    //   136: astore_1
    //   137: ldc 79
    //   139: ldc 157
    //   141: iconst_1
    //   142: anewarray 159	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_3
    //   148: invokevirtual 90	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: ifnull +9 -> 165
    //   159: aload_2
    //   160: invokeinterface 72 1 0
    //   165: ldc 111
    //   167: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload 4
    //   172: areturn
    //   173: aload_2
    //   174: ifnull -9 -> 165
    //   177: aload_2
    //   178: invokeinterface 72 1 0
    //   183: goto -18 -> 165
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +9 -> 199
    //   193: aload_1
    //   194: invokeinterface 72 1 0
    //   199: ldc 111
    //   201: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_2
    //   205: athrow
    //   206: astore_2
    //   207: goto -18 -> 189
    //   210: astore_3
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -78 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	d
    //   12	182	1	localObject1	Object
    //   20	158	2	localObject2	Object
    //   186	19	2	localObject3	Object
    //   206	1	2	localObject4	Object
    //   212	1	2	localObject5	Object
    //   134	14	3	localException1	Exception
    //   210	1	3	localException2	Exception
    //   47	124	4	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   104	113	134	java/lang/Exception
    //   115	131	134	java/lang/Exception
    //   86	98	186	finally
    //   104	113	206	finally
    //   115	131	206	finally
    //   137	155	206	finally
    //   86	98	210	java/lang/Exception
  }
  
  public final int yE(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(240069);
    Object localObject4 = new PInt();
    PInt localPInt = new PInt();
    if (!a.a(7, Util.nowMilliSecond(), (PInt)localObject4, localPInt))
    {
      AppMethodBeat.o(240069);
      return 0;
    }
    localObject4 = "SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( ds >= " + ((PInt)localObject4).value + " AND ds <= " + localPInt.value + " )  AND hour = " + paramInt;
    try
    {
      localObject4 = this.db.rawQuery((String)localObject4, null);
      paramInt = i;
      if (localObject4 != null)
      {
        paramInt = i;
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          paramInt = ((Cursor)localObject4).getInt(0);
        }
      }
      i = paramInt;
      if (localObject4 != null)
      {
        ((Cursor)localObject4).close();
        i = paramInt;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", new Object[] { localException.toString() });
        i = j;
        if (localObject1 != null)
        {
          localObject1.close();
          i = j;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label238;
      }
      localObject3.close();
      AppMethodBeat.o(240069);
    }
    AppMethodBeat.o(240069);
    return i;
  }
  
  public final int yF(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(240071);
    Object localObject4 = new PInt();
    PInt localPInt = new PInt();
    if (!a.a(7, Util.nowMilliSecond(), (PInt)localObject4, localPInt))
    {
      AppMethodBeat.o(240071);
      return 0;
    }
    localObject4 = "SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( ds >= " + ((PInt)localObject4).value + " AND ds <= " + localPInt.value + " )  AND hour = " + paramInt + " AND isGoToFinderUI = 1 ";
    try
    {
      localObject4 = this.db.rawQuery((String)localObject4, null);
      paramInt = i;
      if (localObject4 != null)
      {
        paramInt = i;
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          paramInt = ((Cursor)localObject4).getInt(0);
        }
      }
      i = paramInt;
      if (localObject4 != null)
      {
        ((Cursor)localObject4).close();
        i = paramInt;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", new Object[] { localException.toString() });
        i = j;
        if (localObject1 != null)
        {
          localObject1.close();
          i = j;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label243;
      }
      localObject3.close();
      AppMethodBeat.o(240071);
    }
    AppMethodBeat.o(240071);
    return i;
  }
  
  public final int yG(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(240075);
    long l1 = Util.nowMilliSecond();
    long l2 = paramInt * 60 * 1000;
    Object localObject4 = "SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( actionMs >= " + (l1 - l2) + " AND actionMs <= " + l1 + " ) ";
    try
    {
      localObject4 = this.db.rawQuery((String)localObject4, null);
      paramInt = i;
      if (localObject4 != null)
      {
        paramInt = i;
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          paramInt = ((Cursor)localObject4).getInt(0);
        }
      }
      i = paramInt;
      if (localObject4 != null)
      {
        ((Cursor)localObject4).close();
        i = paramInt;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", new Object[] { localException.toString() });
        i = j;
        if (localObject1 != null)
        {
          localObject1.close();
          i = j;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label207;
      }
      localObject3.close();
      AppMethodBeat.o(240075);
    }
    AppMethodBeat.o(240075);
    return i;
  }
  
  public final boolean yH(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(240080);
    Object localObject4 = "SELECT * FROM FinderRedDotHistory WHERE ds = " + paramInt + " AND isGoToFinderUI = 1 ";
    try
    {
      localObject4 = this.db.rawQuery((String)localObject4, null);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        boolean bool = ((Cursor)localObject4).moveToFirst();
        if (bool)
        {
          if (localObject4 != null) {
            ((Cursor)localObject4).close();
          }
          AppMethodBeat.o(240080);
          return true;
        }
      }
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", new Object[] { localException.toString() });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label159;
      }
      localObject3.close();
      AppMethodBeat.o(240080);
    }
    AppMethodBeat.o(240080);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.d
 * JD-Core Version:    0.7.0.1
 */