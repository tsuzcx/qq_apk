package com.tencent.mm.plugin.ai.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class g
  extends a<f>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(267392);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.info, "FinderRedDotHistory") };
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderRedDotHistoryActionIndex ON FinderRedDotHistory(actionMs)" };
    AppMethodBeat.o(267392);
  }
  
  public g(o.a parama)
  {
    super(parama, f.info, "FinderRedDotHistory", INDEX_CREATE);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(267409);
    boolean bool = super.insertNotify(paramf, false);
    AppMethodBeat.o(267409);
    return bool;
  }
  
  public final boolean c(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    localObject2 = null;
    localObject1 = null;
    bool3 = false;
    bool2 = false;
    AppMethodBeat.i(267433);
    long l1 = Util.nowMilliSecond();
    long l2 = paramInt * 60 * 1000;
    Object localObject3 = "SELECT SUM(hadFinderRedDot), SUM(hadFinderLiveRedDot) FROM FinderRedDotHistory WHERE  ( actionMs >= " + (l1 - l2) + " AND actionMs <= " + l1 + " ) ";
    paramPInt2.value = 0;
    paramPInt1.value = 0;
    try
    {
      localObject3 = this.qpk.rawQuery((String)localObject3, null);
      boolean bool1 = bool2;
      if (localObject3 != null)
      {
        bool1 = bool2;
        localObject1 = localObject3;
        localObject2 = localObject3;
        if (((Cursor)localObject3).moveToFirst())
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramPInt1.value = ((Cursor)localObject3).getInt(0);
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramPInt2.value = ((Cursor)localObject3).getInt(1);
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (localObject3 != null)
      {
        ((Cursor)localObject3).close();
        bool2 = bool1;
      }
    }
    catch (Exception paramPInt1)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.e("MicroMsg.FinderRedDotHistoryStorage", "select exposure error[%s]", new Object[] { paramPInt1.toString() });
        bool2 = bool3;
        if (localObject1 != null)
        {
          localObject1.close();
          bool2 = bool3;
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label253;
      }
      localObject2.close();
      AppMethodBeat.o(267433);
    }
    AppMethodBeat.o(267433);
    return bool2;
  }
  
  public final int caF()
  {
    return 7;
  }
  
  public final String caG()
  {
    return "ds";
  }
  
  /* Error */
  public final java.util.HashSet<java.lang.Integer> caI()
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 90	com/tencent/mm/pointers/PInt
    //   8: dup
    //   9: invokespecial 140	com/tencent/mm/pointers/PInt:<init>	()V
    //   12: astore_1
    //   13: new 90	com/tencent/mm/pointers/PInt
    //   16: dup
    //   17: invokespecial 140	com/tencent/mm/pointers/PInt:<init>	()V
    //   20: astore_2
    //   21: iconst_3
    //   22: invokestatic 66	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   25: aload_1
    //   26: aload_2
    //   27: invokestatic 145	com/tencent/mm/plugin/ai/b/a:a	(IJLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   30: ifne +10 -> 40
    //   33: ldc 138
    //   35: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: new 147	java/util/HashSet
    //   43: dup
    //   44: invokespecial 148	java/util/HashSet:<init>	()V
    //   47: astore 4
    //   49: new 68	java/lang/StringBuilder
    //   52: dup
    //   53: ldc 150
    //   55: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: getfield 94	com/tencent/mm/pointers/PInt:value	I
    //   62: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 155
    //   67: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_2
    //   71: getfield 94	com/tencent/mm/pointers/PInt:value	I
    //   74: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 157
    //   79: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_1
    //   86: aload_0
    //   87: getfield 98	com/tencent/mm/plugin/ai/d/g:qpk	Lcom/tencent/mm/platformtools/o$a;
    //   90: aload_1
    //   91: aconst_null
    //   92: invokevirtual 104	com/tencent/mm/platformtools/o$a:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull +74 -> 171
    //   100: aload_2
    //   101: astore_1
    //   102: aload_2
    //   103: invokeinterface 110 1 0
    //   108: ifeq +63 -> 171
    //   111: aload_2
    //   112: astore_1
    //   113: aload 4
    //   115: aload_2
    //   116: iconst_0
    //   117: invokeinterface 114 2 0
    //   122: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 167	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   128: pop
    //   129: goto -29 -> 100
    //   132: astore_3
    //   133: aload_2
    //   134: astore_1
    //   135: ldc 119
    //   137: ldc 121
    //   139: iconst_1
    //   140: anewarray 123	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_3
    //   146: invokevirtual 124	java/lang/Exception:toString	()Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_2
    //   154: ifnull +9 -> 163
    //   157: aload_2
    //   158: invokeinterface 117 1 0
    //   163: ldc 138
    //   165: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload 4
    //   170: areturn
    //   171: aload_2
    //   172: ifnull -9 -> 163
    //   175: aload_2
    //   176: invokeinterface 117 1 0
    //   181: goto -18 -> 163
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +9 -> 197
    //   191: aload_1
    //   192: invokeinterface 117 1 0
    //   197: ldc 138
    //   199: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_2
    //   203: athrow
    //   204: astore_2
    //   205: goto -18 -> 187
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_2
    //   211: goto -78 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	g
    //   12	180	1	localObject1	Object
    //   20	156	2	localObject2	Object
    //   184	19	2	localObject3	Object
    //   204	1	2	localObject4	Object
    //   210	1	2	localObject5	Object
    //   132	14	3	localException1	Exception
    //   208	1	3	localException2	Exception
    //   47	122	4	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   102	111	132	java/lang/Exception
    //   113	129	132	java/lang/Exception
    //   86	96	184	finally
    //   102	111	204	finally
    //   113	129	204	finally
    //   135	153	204	finally
    //   86	96	208	java/lang/Exception
  }
  
  public final String tableName()
  {
    return "FinderRedDotHistory";
  }
  
  public final int yM(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(267419);
    Object localObject4 = new PInt();
    PInt localPInt = new PInt();
    if (!com.tencent.mm.plugin.ai.b.a.a(7, Util.nowMilliSecond(), (PInt)localObject4, localPInt))
    {
      AppMethodBeat.o(267419);
      return 0;
    }
    localObject4 = "SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( ds >= " + ((PInt)localObject4).value + " AND ds <= " + localPInt.value + " )  AND hour = " + paramInt;
    try
    {
      localObject4 = this.qpk.rawQuery((String)localObject4, null);
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
        break label236;
      }
      localObject3.close();
      AppMethodBeat.o(267419);
    }
    AppMethodBeat.o(267419);
    return i;
  }
  
  public final int yN(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(267425);
    Object localObject4 = new PInt();
    PInt localPInt = new PInt();
    if (!com.tencent.mm.plugin.ai.b.a.a(7, Util.nowMilliSecond(), (PInt)localObject4, localPInt))
    {
      AppMethodBeat.o(267425);
      return 0;
    }
    localObject4 = "SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( ds >= " + ((PInt)localObject4).value + " AND ds <= " + localPInt.value + " )  AND hour = " + paramInt + " AND isGoToFinderUI = 1 ";
    try
    {
      localObject4 = this.qpk.rawQuery((String)localObject4, null);
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
        break label241;
      }
      localObject3.close();
      AppMethodBeat.o(267425);
    }
    AppMethodBeat.o(267425);
    return i;
  }
  
  public final int yO(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(267437);
    long l1 = Util.nowMilliSecond();
    long l2 = paramInt * 60 * 1000;
    Object localObject4 = "SELECT COUNT(*) FROM FinderRedDotHistory WHERE  ( actionMs >= " + (l1 - l2) + " AND actionMs <= " + l1 + " ) ";
    try
    {
      localObject4 = this.qpk.rawQuery((String)localObject4, null);
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
        break label205;
      }
      localObject3.close();
      AppMethodBeat.o(267437);
    }
    AppMethodBeat.o(267437);
    return i;
  }
  
  public final boolean yP(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(267452);
    Object localObject4 = "SELECT * FROM FinderRedDotHistory WHERE ds = " + paramInt + " AND isGoToFinderUI = 1 ";
    try
    {
      localObject4 = this.qpk.rawQuery((String)localObject4, null);
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
          AppMethodBeat.o(267452);
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
        break label157;
      }
      localObject3.close();
      AppMethodBeat.o(267452);
    }
    AppMethodBeat.o(267452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.g
 * JD-Core Version:    0.7.0.1
 */