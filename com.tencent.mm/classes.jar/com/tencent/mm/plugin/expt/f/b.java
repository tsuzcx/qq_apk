package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;

public final class b
  extends j<a>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(122452);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "ExptKeyMapId") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(122452);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "ExptKeyMapId", INDEX_CREATE);
    this.db = parame;
  }
  
  /* Error */
  public final int Xn(String paramString)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/f/b:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 29
    //   11: iconst_1
    //   12: anewarray 21	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc 55
    //   19: aastore
    //   20: ldc 57
    //   22: iconst_1
    //   23: anewarray 21	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokeinterface 63 8 0
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +134 -> 176
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: invokeinterface 69 1 0
    //   56: ifeq +120 -> 176
    //   59: aload 5
    //   61: astore 4
    //   63: aload 5
    //   65: iconst_0
    //   66: invokeinterface 73 2 0
    //   71: istore_2
    //   72: iload_2
    //   73: istore_3
    //   74: aload 5
    //   76: ifnull +12 -> 88
    //   79: aload 5
    //   81: invokeinterface 76 1 0
    //   86: iload_2
    //   87: istore_3
    //   88: ldc 53
    //   90: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iload_3
    //   94: ireturn
    //   95: astore 6
    //   97: aconst_null
    //   98: astore 5
    //   100: aload 5
    //   102: astore 4
    //   104: ldc 78
    //   106: ldc 80
    //   108: iconst_2
    //   109: anewarray 82	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_1
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload 6
    //   120: invokevirtual 86	java/lang/Exception:toString	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 92	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload 5
    //   129: ifnull +10 -> 139
    //   132: aload 5
    //   134: invokeinterface 76 1 0
    //   139: iconst_m1
    //   140: istore_3
    //   141: goto -53 -> 88
    //   144: astore_1
    //   145: aconst_null
    //   146: astore 4
    //   148: aload 4
    //   150: ifnull +10 -> 160
    //   153: aload 4
    //   155: invokeinterface 76 1 0
    //   160: ldc 53
    //   162: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: goto -20 -> 148
    //   171: astore 6
    //   173: goto -73 -> 100
    //   176: iconst_m1
    //   177: istore_2
    //   178: goto -106 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	b
    //   0	181	1	paramString	String
    //   71	107	2	i	int
    //   73	68	3	j	int
    //   47	107	4	localCursor1	android.database.Cursor
    //   38	95	5	localCursor2	android.database.Cursor
    //   95	24	6	localException1	Exception
    //   171	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	40	95	java/lang/Exception
    //   5	40	144	finally
    //   49	59	167	finally
    //   63	72	167	finally
    //   104	127	167	finally
    //   49	59	171	java/lang/Exception
    //   63	72	171	java/lang/Exception
  }
  
  /* Error */
  public final a Xt(String paramString)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/f/b:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 29
    //   11: getstatic 27	com/tencent/mm/plugin/expt/f/a:info	Lcom/tencent/mm/sdk/e/c$a;
    //   14: getfield 100	com/tencent/mm/sdk/e/c$a:columns	[Ljava/lang/String;
    //   17: ldc 57
    //   19: iconst_1
    //   20: anewarray 21	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokeinterface 63 8 0
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +150 -> 187
    //   40: aload_3
    //   41: astore 4
    //   43: aload_3
    //   44: invokeinterface 69 1 0
    //   49: ifeq +138 -> 187
    //   52: aload_3
    //   53: astore 4
    //   55: new 23	com/tencent/mm/plugin/expt/f/a
    //   58: dup
    //   59: invokespecial 102	com/tencent/mm/plugin/expt/f/a:<init>	()V
    //   62: astore_2
    //   63: aload_3
    //   64: astore 4
    //   66: aload_2
    //   67: aload_3
    //   68: invokevirtual 106	com/tencent/mm/plugin/expt/f/a:convertFrom	(Landroid/database/Cursor;)V
    //   71: aload_2
    //   72: astore_1
    //   73: aload_1
    //   74: astore 4
    //   76: aload_3
    //   77: ifnull +12 -> 89
    //   80: aload_3
    //   81: invokeinterface 76 1 0
    //   86: aload_1
    //   87: astore 4
    //   89: ldc 95
    //   91: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload 4
    //   96: areturn
    //   97: astore 5
    //   99: aconst_null
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_3
    //   104: astore 4
    //   106: ldc 78
    //   108: ldc 80
    //   110: iconst_2
    //   111: anewarray 82	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload 5
    //   122: invokevirtual 86	java/lang/Exception:toString	()Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 92	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_2
    //   130: astore 4
    //   132: aload_3
    //   133: ifnull -44 -> 89
    //   136: aload_3
    //   137: invokeinterface 76 1 0
    //   142: aload_2
    //   143: astore 4
    //   145: goto -56 -> 89
    //   148: astore_1
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 4
    //   154: ifnull +10 -> 164
    //   157: aload 4
    //   159: invokeinterface 76 1 0
    //   164: ldc 95
    //   166: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: goto -20 -> 152
    //   175: astore 5
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -76 -> 103
    //   182: astore 5
    //   184: goto -81 -> 103
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -116 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	b
    //   0	192	1	paramString	String
    //   62	117	2	locala	a
    //   35	102	3	localCursor	android.database.Cursor
    //   41	117	4	localObject	Object
    //   97	24	5	localException1	Exception
    //   175	1	5	localException2	Exception
    //   182	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   5	36	97	java/lang/Exception
    //   5	36	148	finally
    //   43	52	171	finally
    //   55	63	171	finally
    //   66	71	171	finally
    //   106	129	171	finally
    //   43	52	175	java/lang/Exception
    //   55	63	175	java/lang/Exception
    //   66	71	182	java/lang/Exception
  }
  
  public final int ceE()
  {
    int i = 0;
    AppMethodBeat.i(122451);
    try
    {
      int j = this.db.delete("ExptKeyMapId", null, null);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", new Object[] { localException.toString() });
      }
    }
    AppMethodBeat.o(122451);
    return i;
  }
  
  public final int db(List<a> paramList)
  {
    long l = -1L;
    AppMethodBeat.i(122448);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(122448);
      return 0;
    }
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.rb(-1L);
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        boolean bool;
        int j;
        localh = null;
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        i = 0;
        ad.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", new Object[] { localException1.toString() });
        j = i;
        if (localh != null)
        {
          localh.mX(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.mX(l);
        }
        AppMethodBeat.o(122448);
      }
    }
  }
  
  public final int dc(List<a> paramList)
  {
    long l = -1L;
    AppMethodBeat.i(122449);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(122449);
      return 0;
    }
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.rb(-1L);
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        a locala;
        boolean bool;
        int j;
        localh = null;
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        i = 0;
        ad.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", new Object[] { localException1.toString() });
        j = i;
        if (localh != null)
        {
          localh.mX(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.mX(l);
        }
        AppMethodBeat.o(122449);
      }
    }
  }
  
  public final int dd(List<Integer> paramList)
  {
    AppMethodBeat.i(122450);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(122450);
      return 0;
    }
    int j = 0;
    int i = 0;
    long l = -1L;
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.rb(-1L);
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        j = i;
        if (localIterator.hasNext())
        {
          j = i;
          k = ((Integer)localIterator.next()).intValue();
          j = i;
          k = this.db.delete("ExptKeyMapId", "exptId=?", new String[] { String.valueOf(k) });
          if (k > 0)
          {
            i += 1;
            continue;
          }
          continue;
        }
        k = i;
        if (localh != null)
        {
          localh.mX(l);
          k = i;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", new Object[] { localException.toString(), Integer.valueOf(j) });
        int k = j;
        if (localh == null) {
          continue;
        }
        localh.mX(l);
        k = j;
        continue;
      }
      finally
      {
        if (localh == null) {
          continue;
        }
        localh.mX(l);
        AppMethodBeat.o(122450);
      }
      ad.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k) });
      AppMethodBeat.o(122450);
      return k;
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.b
 * JD-Core Version:    0.7.0.1
 */