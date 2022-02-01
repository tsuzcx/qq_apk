package com.tencent.mm.plugin.ai.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.text.SimpleDateFormat;
import java.util.List;

public final class f
  extends MAutoStorage<e>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private SimpleDateFormat kxO;
  private r.a kxP;
  
  static
  {
    AppMethodBeat.i(238956);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.info, "WechatAppHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(238956);
  }
  
  /* Error */
  public f(r.a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: getstatic 29	com/tencent/mm/plugin/ai/f/e:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   7: ldc 31
    //   9: getstatic 39	com/tencent/mm/plugin/ai/f/f:INDEX_CREATE	[Ljava/lang/String;
    //   12: invokespecial 50	com/tencent/mm/sdk/storage/MAutoStorage:<init>	(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V
    //   15: ldc 51
    //   17: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 53	com/tencent/mm/plugin/ai/f/f:kxO	Ljava/text/SimpleDateFormat;
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 55	com/tencent/mm/plugin/ai/f/f:kxP	Lcom/tencent/mm/platformtools/r$a;
    //   30: aload_0
    //   31: getfield 55	com/tencent/mm/plugin/ai/f/f:kxP	Lcom/tencent/mm/platformtools/r$a;
    //   34: ldc 57
    //   36: aconst_null
    //   37: iconst_2
    //   38: invokevirtual 63	com/tencent/mm/platformtools/r$a:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   41: astore_3
    //   42: aload_3
    //   43: astore_1
    //   44: aload_3
    //   45: invokeinterface 69 1 0
    //   50: ifeq +13 -> 63
    //   53: aload_3
    //   54: astore_1
    //   55: aload_3
    //   56: iconst_0
    //   57: invokeinterface 73 2 0
    //   62: istore_2
    //   63: aload_3
    //   64: astore_1
    //   65: aload_3
    //   66: invokeinterface 76 1 0
    //   71: iload_2
    //   72: ldc 77
    //   74: if_icmplt +15 -> 89
    //   77: aload_0
    //   78: getfield 55	com/tencent/mm/plugin/ai/f/f:kxP	Lcom/tencent/mm/platformtools/r$a;
    //   81: ldc 31
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokevirtual 81	com/tencent/mm/platformtools/r$a:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   88: pop
    //   89: ldc 83
    //   91: ldc 85
    //   93: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 51
    //   98: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: return
    //   102: astore 4
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_3
    //   107: astore_1
    //   108: ldc 83
    //   110: new 92	java/lang/StringBuilder
    //   113: dup
    //   114: ldc 94
    //   116: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload 4
    //   121: invokevirtual 101	java/lang/Exception:toString	()Ljava/lang/String;
    //   124: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_3
    //   134: ifnull -45 -> 89
    //   137: aload_3
    //   138: invokeinterface 76 1 0
    //   143: goto -54 -> 89
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
    //   166: astore_3
    //   167: goto -18 -> 149
    //   170: astore 4
    //   172: goto -66 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	f
    //   0	175	1	parama	r.a
    //   1	74	2	i	int
    //   41	97	3	localCursor	Cursor
    //   146	19	3	localObject1	Object
    //   166	1	3	localObject2	Object
    //   102	18	4	localException1	Exception
    //   170	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   30	42	102	java/lang/Exception
    //   77	89	102	java/lang/Exception
    //   30	42	146	finally
    //   77	89	146	finally
    //   44	53	166	finally
    //   55	63	166	finally
    //   65	71	166	finally
    //   108	133	166	finally
    //   44	53	170	java/lang/Exception
    //   55	63	170	java/lang/Exception
    //   65	71	170	java/lang/Exception
  }
  
  public final long TO(String paramString)
  {
    localObject2 = null;
    localObject1 = null;
    AppMethodBeat.i(238954);
    l2 = 0L;
    try
    {
      Cursor localCursor = this.kxP.rawQuery(paramString, null);
      long l1 = l2;
      if (localCursor != null)
      {
        l1 = l2;
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          l1 = localCursor.getLong(0);
        }
      }
      l3 = l1;
      if (localCursor != null)
      {
        localCursor.close();
        l3 = l1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = localObject1;
        Log.e("MicroMsg.WechatDurationHistoryStorage", "do sql error[%s] sql[%s]", new Object[] { localException.toString(), paramString });
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
      if (localObject2 == null) {
        break label162;
      }
      localObject2.close();
      AppMethodBeat.o(238954);
    }
    AppMethodBeat.o(238954);
    return l3;
  }
  
  public final int bb(List<e> paramList)
  {
    AppMethodBeat.i(238952);
    l4 = Util.currentTicks();
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(238952);
      return 0;
    }
    l3 = 0L;
    l1 = l3;
    try
    {
      l2 = this.kxP.beginTransaction(Thread.currentThread().getId());
      l1 = l2;
      l3 = l2;
      paramList = paramList.iterator();
      i = 0;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList = paramList;
        int i = 0;
        this.kxP.endTransaction(l1);
      }
    }
    finally
    {
      this.kxP.endTransaction(l3);
      AppMethodBeat.o(238952);
    }
    l3 = l2;
  }
  
  public final SimpleDateFormat bqD()
  {
    AppMethodBeat.i(238953);
    if (this.kxO == null) {
      this.kxO = new SimpleDateFormat("yyyyMMdd");
    }
    SimpleDateFormat localSimpleDateFormat = this.kxO;
    AppMethodBeat.o(238953);
    return localSimpleDateFormat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.f
 * JD-Core Version:    0.7.0.1
 */