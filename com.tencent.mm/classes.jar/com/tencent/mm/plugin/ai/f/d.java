package com.tencent.mm.plugin.ai.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d
  extends MAutoStorage<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  private SimpleDateFormat kxO;
  
  static
  {
    AppMethodBeat.i(238948);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "FinderRedDotHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(238948);
  }
  
  /* Error */
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: getstatic 29	com/tencent/mm/plugin/ai/f/c:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   7: ldc 31
    //   9: getstatic 39	com/tencent/mm/plugin/ai/f/d:INDEX_CREATE	[Ljava/lang/String;
    //   12: invokespecial 50	com/tencent/mm/sdk/storage/MAutoStorage:<init>	(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V
    //   15: ldc 51
    //   17: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 53	com/tencent/mm/plugin/ai/f/d:kxO	Ljava/text/SimpleDateFormat;
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 55	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   30: aload_0
    //   31: getfield 55	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   34: ldc 57
    //   36: aconst_null
    //   37: iconst_2
    //   38: invokeinterface 63 4 0
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: invokeinterface 69 1 0
    //   52: ifeq +13 -> 65
    //   55: aload_3
    //   56: astore_1
    //   57: aload_3
    //   58: iconst_0
    //   59: invokeinterface 73 2 0
    //   64: istore_2
    //   65: aload_3
    //   66: astore_1
    //   67: aload_3
    //   68: invokeinterface 76 1 0
    //   73: iload_2
    //   74: ldc 77
    //   76: if_icmplt +17 -> 93
    //   79: aload_0
    //   80: getfield 55	com/tencent/mm/plugin/ai/f/d:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   83: ldc 31
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokeinterface 81 4 0
    //   92: pop
    //   93: ldc 51
    //   95: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: astore_1
    //   105: ldc 83
    //   107: new 85	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 87
    //   113: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload 4
    //   118: invokevirtual 94	java/lang/Exception:toString	()Ljava/lang/String;
    //   121: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_3
    //   131: ifnull +35 -> 166
    //   134: aload_3
    //   135: invokeinterface 76 1 0
    //   140: ldc 51
    //   142: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: return
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +9 -> 159
    //   153: aload_1
    //   154: invokeinterface 76 1 0
    //   159: ldc 51
    //   161: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_3
    //   165: athrow
    //   166: ldc 51
    //   168: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: return
    //   172: astore_3
    //   173: goto -24 -> 149
    //   176: astore 4
    //   178: goto -75 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	d
    //   0	181	1	paramISQLiteDatabase	ISQLiteDatabase
    //   1	76	2	i	int
    //   43	92	3	localCursor	Cursor
    //   146	19	3	localObject1	Object
    //   172	1	3	localObject2	Object
    //   99	18	4	localException1	Exception
    //   176	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   30	44	99	java/lang/Exception
    //   79	93	99	java/lang/Exception
    //   30	44	146	finally
    //   79	93	146	finally
    //   46	55	172	finally
    //   57	65	172	finally
    //   67	73	172	finally
    //   105	130	172	finally
    //   46	55	176	java/lang/Exception
    //   57	65	176	java/lang/Exception
    //   67	73	176	java/lang/Exception
  }
  
  private boolean a(long paramLong, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(238943);
    if (this.kxO == null) {
      this.kxO = new SimpleDateFormat("yyyyMMdd");
    }
    int i = Util.getInt(this.kxO.format(new Date(paramLong)), -1);
    if (i > 0)
    {
      paramPInt1.value = (i - 7);
      paramPInt2.value = (i - 1);
      Log.i("MicroMsg.FinderRedDotHistoryStorage", "to sql date [%d, %d] day[%d] timeMs[%d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(7), Long.valueOf(paramLong) });
      AppMethodBeat.o(238943);
      return true;
    }
    AppMethodBeat.o(238943);
    return false;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(238942);
    boolean bool = super.insertNotify(paramc, false);
    AppMethodBeat.o(238942);
    return bool;
  }
  
  public final int vu(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(238944);
    Object localObject4 = new PInt();
    PInt localPInt = new PInt();
    if (!a(Util.nowMilliSecond(), (PInt)localObject4, localPInt))
    {
      AppMethodBeat.o(238944);
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
        break label237;
      }
      localObject3.close();
      AppMethodBeat.o(238944);
    }
    AppMethodBeat.o(238944);
    return i;
  }
  
  public final int vv(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(238945);
    Object localObject4 = new PInt();
    PInt localPInt = new PInt();
    if (!a(Util.nowMilliSecond(), (PInt)localObject4, localPInt))
    {
      AppMethodBeat.o(238945);
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
        break label242;
      }
      localObject3.close();
      AppMethodBeat.o(238945);
    }
    AppMethodBeat.o(238945);
    return i;
  }
  
  public final int vw(int paramInt)
  {
    localObject3 = null;
    localObject1 = null;
    j = 0;
    i = 0;
    AppMethodBeat.i(238946);
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
      AppMethodBeat.o(238946);
    }
    AppMethodBeat.o(238946);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.d
 * JD-Core Version:    0.7.0.1
 */