package com.tencent.mm.plugin.ai.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;

public final class f
  extends MAutoStorage<e>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private r.a nqN;
  
  static
  {
    AppMethodBeat.i(239342);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.info, "WechatAppHistory") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(239342);
  }
  
  /* Error */
  public f(r.a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: getstatic 27	com/tencent/mm/plugin/ai/f/e:info	Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;
    //   7: ldc 29
    //   9: getstatic 37	com/tencent/mm/plugin/ai/f/f:INDEX_CREATE	[Ljava/lang/String;
    //   12: invokespecial 48	com/tencent/mm/sdk/storage/MAutoStorage:<init>	(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V
    //   15: ldc 49
    //   17: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 51	com/tencent/mm/plugin/ai/f/f:nqN	Lcom/tencent/mm/platformtools/r$a;
    //   25: aload_0
    //   26: getfield 51	com/tencent/mm/plugin/ai/f/f:nqN	Lcom/tencent/mm/platformtools/r$a;
    //   29: ldc 53
    //   31: aconst_null
    //   32: iconst_2
    //   33: invokevirtual 59	com/tencent/mm/platformtools/r$a:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   36: astore_3
    //   37: aload_3
    //   38: astore_1
    //   39: aload_3
    //   40: invokeinterface 65 1 0
    //   45: ifeq +13 -> 58
    //   48: aload_3
    //   49: astore_1
    //   50: aload_3
    //   51: iconst_0
    //   52: invokeinterface 69 2 0
    //   57: istore_2
    //   58: aload_3
    //   59: astore_1
    //   60: aload_3
    //   61: invokeinterface 72 1 0
    //   66: iload_2
    //   67: ldc 73
    //   69: if_icmplt +15 -> 84
    //   72: aload_0
    //   73: getfield 51	com/tencent/mm/plugin/ai/f/f:nqN	Lcom/tencent/mm/platformtools/r$a;
    //   76: ldc 29
    //   78: aconst_null
    //   79: aconst_null
    //   80: invokevirtual 77	com/tencent/mm/platformtools/r$a:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   83: pop
    //   84: ldc 79
    //   86: ldc 81
    //   88: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc 49
    //   93: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: astore 4
    //   99: aconst_null
    //   100: astore_3
    //   101: aload_3
    //   102: astore_1
    //   103: ldc 79
    //   105: new 88	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 90
    //   111: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload 4
    //   116: invokevirtual 97	java/lang/Exception:toString	()Ljava/lang/String;
    //   119: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: ifnull -45 -> 84
    //   132: aload_3
    //   133: invokeinterface 72 1 0
    //   138: goto -54 -> 84
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
    //   161: astore_3
    //   162: goto -18 -> 144
    //   165: astore 4
    //   167: goto -66 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	f
    //   0	170	1	parama	r.a
    //   1	69	2	i	int
    //   36	97	3	localCursor	Cursor
    //   141	19	3	localObject1	Object
    //   161	1	3	localObject2	Object
    //   97	18	4	localException1	Exception
    //   165	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   25	37	97	java/lang/Exception
    //   72	84	97	java/lang/Exception
    //   25	37	141	finally
    //   72	84	141	finally
    //   39	48	161	finally
    //   50	58	161	finally
    //   60	66	161	finally
    //   103	128	161	finally
    //   39	48	165	java/lang/Exception
    //   50	58	165	java/lang/Exception
    //   60	66	165	java/lang/Exception
  }
  
  public final int aZ(List<e> paramList)
  {
    AppMethodBeat.i(239337);
    l4 = Util.currentTicks();
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(239337);
      return 0;
    }
    l3 = 0L;
    l1 = l3;
    try
    {
      l2 = this.nqN.beginTransaction(Thread.currentThread().getId());
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
        this.nqN.endTransaction(l1);
      }
    }
    finally
    {
      this.nqN.endTransaction(l3);
      AppMethodBeat.o(239337);
    }
    l3 = l2;
  }
  
  public final long aby(String paramString)
  {
    localObject2 = null;
    localObject1 = null;
    AppMethodBeat.i(239339);
    l2 = 0L;
    try
    {
      Cursor localCursor = this.nqN.rawQuery(paramString, null);
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
      AppMethodBeat.o(239339);
    }
    AppMethodBeat.o(239339);
    return l3;
  }
  
  public final long yI(int paramInt)
  {
    AppMethodBeat.i(239338);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    if (!a.a(7, Util.nowMilliSecond(), localPInt1, localPInt2))
    {
      AppMethodBeat.o(239338);
      return 0L;
    }
    long l = aby("SELECT SUM( appIn ) FROM WechatAppHistory WHERE  ( appDs >= " + localPInt1.value + " AND appDs <= " + localPInt2.value + " )  AND appHour = " + paramInt);
    AppMethodBeat.o(239338);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.f.f
 * JD-Core Version:    0.7.0.1
 */