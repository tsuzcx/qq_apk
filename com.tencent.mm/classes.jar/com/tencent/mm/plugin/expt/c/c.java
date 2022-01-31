package com.tencent.mm.plugin.expt.c;

import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class c
  extends i<b>
{
  public static final String[] cqY = new String[0];
  public static final String[] dXp = { i.a(b.buS, "ExptKeyMapId") };
  private e dXw;
  
  public c(e parame)
  {
    super(parame, b.buS, "ExptKeyMapId", cqY);
    this.dXw = parame;
  }
  
  /* Error */
  public final int BY(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/expt/c/c:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 22
    //   6: iconst_1
    //   7: anewarray 14	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc 44
    //   14: aastore
    //   15: ldc 46
    //   17: iconst_1
    //   18: anewarray 14	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokeinterface 52 8 0
    //   33: astore 4
    //   35: aload 4
    //   37: ifnull +111 -> 148
    //   40: aload 4
    //   42: astore_3
    //   43: aload 4
    //   45: invokeinterface 58 1 0
    //   50: ifeq +98 -> 148
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: iconst_0
    //   59: invokeinterface 62 2 0
    //   64: istore_2
    //   65: aload 4
    //   67: ifnull +10 -> 77
    //   70: aload 4
    //   72: invokeinterface 65 1 0
    //   77: iload_2
    //   78: ireturn
    //   79: astore 5
    //   81: aconst_null
    //   82: astore 4
    //   84: aload 4
    //   86: astore_3
    //   87: ldc 67
    //   89: ldc 69
    //   91: iconst_2
    //   92: anewarray 71	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload 5
    //   103: invokevirtual 75	java/lang/Exception:toString	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 81	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload 4
    //   112: ifnull +10 -> 122
    //   115: aload 4
    //   117: invokeinterface 65 1 0
    //   122: iconst_m1
    //   123: ireturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +9 -> 137
    //   131: aload_3
    //   132: invokeinterface 65 1 0
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: goto -13 -> 127
    //   143: astore 5
    //   145: goto -61 -> 84
    //   148: iconst_m1
    //   149: istore_2
    //   150: goto -85 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	c
    //   0	153	1	paramString	String
    //   64	86	2	i	int
    //   42	90	3	localCursor1	android.database.Cursor
    //   33	83	4	localCursor2	android.database.Cursor
    //   79	23	5	localException1	Exception
    //   143	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	35	79	java/lang/Exception
    //   0	35	124	finally
    //   43	53	139	finally
    //   56	65	139	finally
    //   87	110	139	finally
    //   43	53	143	java/lang/Exception
    //   56	65	143	java/lang/Exception
  }
  
  /* Error */
  public final b BZ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/expt/c/c:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 22
    //   6: aconst_null
    //   7: ldc 46
    //   9: iconst_1
    //   10: anewarray 14	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokeinterface 52 8 0
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +136 -> 163
    //   30: aload_3
    //   31: astore 4
    //   33: aload_3
    //   34: invokeinterface 58 1 0
    //   39: ifeq +124 -> 163
    //   42: aload_3
    //   43: astore 4
    //   45: new 16	com/tencent/mm/plugin/expt/c/b
    //   48: dup
    //   49: invokespecial 85	com/tencent/mm/plugin/expt/c/b:<init>	()V
    //   52: astore_2
    //   53: aload_3
    //   54: astore 4
    //   56: aload_2
    //   57: aload_3
    //   58: invokevirtual 89	com/tencent/mm/plugin/expt/c/b:d	(Landroid/database/Cursor;)V
    //   61: aload_2
    //   62: astore_1
    //   63: aload_1
    //   64: astore 4
    //   66: aload_3
    //   67: ifnull +12 -> 79
    //   70: aload_3
    //   71: invokeinterface 65 1 0
    //   76: aload_1
    //   77: astore 4
    //   79: aload 4
    //   81: areturn
    //   82: astore 5
    //   84: aconst_null
    //   85: astore_3
    //   86: aconst_null
    //   87: astore_2
    //   88: aload_3
    //   89: astore 4
    //   91: ldc 67
    //   93: ldc 69
    //   95: iconst_2
    //   96: anewarray 71	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload 5
    //   107: invokevirtual 75	java/lang/Exception:toString	()Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 81	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_2
    //   115: astore 4
    //   117: aload_3
    //   118: ifnull -39 -> 79
    //   121: aload_3
    //   122: invokeinterface 65 1 0
    //   127: aload_2
    //   128: areturn
    //   129: astore_1
    //   130: aconst_null
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull +10 -> 145
    //   138: aload 4
    //   140: invokeinterface 65 1 0
    //   145: aload_1
    //   146: athrow
    //   147: astore_1
    //   148: goto -15 -> 133
    //   151: astore 5
    //   153: aconst_null
    //   154: astore_2
    //   155: goto -67 -> 88
    //   158: astore 5
    //   160: goto -72 -> 88
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -102 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	c
    //   0	168	1	paramString	String
    //   52	103	2	localb	b
    //   25	97	3	localCursor	android.database.Cursor
    //   31	108	4	localObject	Object
    //   82	24	5	localException1	Exception
    //   151	1	5	localException2	Exception
    //   158	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	26	82	java/lang/Exception
    //   0	26	129	finally
    //   33	42	147	finally
    //   45	53	147	finally
    //   56	61	147	finally
    //   91	114	147	finally
    //   33	42	151	java/lang/Exception
    //   45	53	151	java/lang/Exception
    //   56	61	158	java/lang/Exception
  }
  
  public final int aNk()
  {
    try
    {
      int i = this.dXw.delete("ExptKeyMapId", null, null);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ExptKeyMapIdStorage", "delete all expt error[%s]", new Object[] { localException.toString() });
    }
    return 0;
  }
  
  public final int bi(List<b> paramList)
  {
    long l = -1L;
    if (paramList.size() <= 0) {
      return 0;
    }
    h localh;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(-1L);
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
        y.e("MicroMsg.ExptKeyMapIdStorage", "insert expt key map id [%s]", new Object[] { localException1.toString() });
        j = i;
        if (localh != null)
        {
          localh.hI(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.hI(l);
        }
      }
    }
  }
  
  public final int bj(List<b> paramList)
  {
    long l = -1L;
    if (paramList.size() <= 0) {
      return 0;
    }
    h localh;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(-1L);
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        b localb;
        boolean bool;
        int j;
        localh = null;
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        i = 0;
        y.e("MicroMsg.ExptKeyMapIdStorage", "update expt key map id [%s]", new Object[] { localException1.toString() });
        j = i;
        if (localh != null)
        {
          localh.hI(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.hI(l);
        }
      }
    }
  }
  
  public final int bk(List<Integer> paramList)
  {
    long l = -1L;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return 0;
    }
    h localh;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(-1L);
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        int i = 0;
        int j;
        localh = null;
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        i = 0;
        y.e("MicroMsg.ExptKeyMapIdStorage", "delete expt by id id [%s] ret[%d]", new Object[] { localException1.toString(), Integer.valueOf(i) });
        j = i;
        if (localh != null)
        {
          localh.hI(l);
          j = i;
        }
      }
      finally
      {
        if (localh != null) {
          localh.hI(l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.c
 * JD-Core Version:    0.7.0.1
 */