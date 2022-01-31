package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(73614);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "ExptKeyMapId") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(73614);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "ExptKeyMapId", INDEX_CREATE);
    this.db = parame;
  }
  
  /* Error */
  public final int MU(String paramString)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/e/b:db	Lcom/tencent/mm/sdk/e/e;
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
    //   124: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  public final a Na(String paramString)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/e/b:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 29
    //   11: aconst_null
    //   12: ldc 57
    //   14: iconst_1
    //   15: anewarray 21	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokeinterface 63 8 0
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +150 -> 182
    //   35: aload_3
    //   36: astore 4
    //   38: aload_3
    //   39: invokeinterface 69 1 0
    //   44: ifeq +138 -> 182
    //   47: aload_3
    //   48: astore 4
    //   50: new 23	com/tencent/mm/plugin/expt/e/a
    //   53: dup
    //   54: invokespecial 97	com/tencent/mm/plugin/expt/e/a:<init>	()V
    //   57: astore_2
    //   58: aload_3
    //   59: astore 4
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 101	com/tencent/mm/plugin/expt/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   66: aload_2
    //   67: astore_1
    //   68: aload_1
    //   69: astore 4
    //   71: aload_3
    //   72: ifnull +12 -> 84
    //   75: aload_3
    //   76: invokeinterface 76 1 0
    //   81: aload_1
    //   82: astore 4
    //   84: ldc 95
    //   86: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload 4
    //   91: areturn
    //   92: astore 5
    //   94: aconst_null
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_3
    //   99: astore 4
    //   101: ldc 78
    //   103: ldc 80
    //   105: iconst_2
    //   106: anewarray 82	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload 5
    //   117: invokevirtual 86	java/lang/Exception:toString	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_2
    //   125: astore 4
    //   127: aload_3
    //   128: ifnull -44 -> 84
    //   131: aload_3
    //   132: invokeinterface 76 1 0
    //   137: aload_2
    //   138: astore 4
    //   140: goto -56 -> 84
    //   143: astore_1
    //   144: aconst_null
    //   145: astore 4
    //   147: aload 4
    //   149: ifnull +10 -> 159
    //   152: aload 4
    //   154: invokeinterface 76 1 0
    //   159: ldc 95
    //   161: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: goto -20 -> 147
    //   170: astore 5
    //   172: aconst_null
    //   173: astore_2
    //   174: goto -76 -> 98
    //   177: astore 5
    //   179: goto -81 -> 98
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -116 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	b
    //   0	187	1	paramString	String
    //   57	117	2	locala	a
    //   30	102	3	localCursor	android.database.Cursor
    //   36	117	4	localObject	Object
    //   92	24	5	localException1	Exception
    //   170	1	5	localException2	Exception
    //   177	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   5	31	92	java/lang/Exception
    //   5	31	143	finally
    //   38	47	166	finally
    //   50	58	166	finally
    //   61	66	166	finally
    //   101	124	166	finally
    //   38	47	170	java/lang/Exception
    //   50	58	170	java/lang/Exception
    //   61	66	177	java/lang/Exception
  }
  
  public final int bA(List<a> paramList)
  {
    long l = -1L;
    AppMethodBeat.i(73611);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(73611);
      return 0;
    }
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(-1L);
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
        ab.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", new Object[] { localException1.toString() });
        j = i;
        if (localh != null)
        {
          localh.nY(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.nY(l);
        }
        AppMethodBeat.o(73611);
      }
    }
  }
  
  public final int bB(List<Integer> paramList)
  {
    AppMethodBeat.i(73612);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(73612);
      return 0;
    }
    int j = 0;
    int i = 0;
    long l = -1L;
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(-1L);
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
          localh.nY(l);
          k = i;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", new Object[] { localException.toString(), Integer.valueOf(j) });
        int k = j;
        if (localh == null) {
          continue;
        }
        localh.nY(l);
        k = j;
        continue;
      }
      finally
      {
        if (localh == null) {
          continue;
        }
        localh.nY(l);
        AppMethodBeat.o(73612);
      }
      ab.i("MicroMsg.ExptKeyMapIdStorage", "deleteExptKeyMapIdById exptIds size[%d] ret[%d]", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k) });
      AppMethodBeat.o(73612);
      return k;
      localh = null;
    }
  }
  
  public final int btl()
  {
    int i = 0;
    AppMethodBeat.i(73613);
    try
    {
      int j = this.db.delete("ExptKeyMapId", null, null);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", new Object[] { localException.toString() });
      }
    }
    AppMethodBeat.o(73613);
    return i;
  }
  
  public final int bz(List<a> paramList)
  {
    long l = -1L;
    AppMethodBeat.i(73610);
    if (paramList.size() <= 0)
    {
      AppMethodBeat.o(73610);
      return 0;
    }
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(-1L);
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
        ab.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", new Object[] { localException1.toString() });
        j = i;
        if (localh != null)
        {
          localh.nY(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.nY(l);
        }
        AppMethodBeat.o(73610);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */