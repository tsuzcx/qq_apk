package com.tencent.mm.plugin.expt.c;

import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends i<a>
{
  public static final String[] cqY = new String[0];
  public static final String[] dXp = { i.a(a.buS, "ExptItem") };
  private e dXw;
  
  public d(e parame)
  {
    super(parame, a.buS, "ExptItem", cqY);
    this.dXw = parame;
  }
  
  private boolean a(a parama)
  {
    if (parama == null) {
      return false;
    }
    try
    {
      bool = super.a(parama);
      y.d("MicroMsg.ExptStorage", "replace expt ret[%b] item[%s]", new Object[] { Boolean.valueOf(bool), parama.toString() });
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ExptStorage", "replace expt error [%s]", new Object[] { localException.toString() });
        boolean bool = false;
      }
    }
  }
  
  private boolean qE(int paramInt)
  {
    try
    {
      paramInt = this.dXw.delete("ExptItem", "exptId=?", new String[] { String.valueOf(paramInt) });
      if (paramInt > 0) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ExptStorage", "delete expt by id [%s]", new Object[] { localException.toString() });
        paramInt = 0;
      }
    }
    return false;
  }
  
  public final int aNk()
  {
    try
    {
      int i = this.dXw.delete("ExptItem", null, null);
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ExptStorage", "delete all expt error[%s]", new Object[] { localException.toString() });
    }
    return 0;
  }
  
  /* Error */
  public final List<a> aNl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/expt/c/d:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 95
    //   6: aconst_null
    //   7: invokeinterface 99 3 0
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +170 -> 184
    //   17: aload_2
    //   18: astore_3
    //   19: new 101	java/util/LinkedList
    //   22: dup
    //   23: invokespecial 103	java/util/LinkedList:<init>	()V
    //   26: astore_1
    //   27: aload_2
    //   28: astore_3
    //   29: aload_2
    //   30: invokeinterface 109 1 0
    //   35: ifeq +75 -> 110
    //   38: aload_2
    //   39: astore_3
    //   40: new 16	com/tencent/mm/plugin/expt/c/a
    //   43: dup
    //   44: invokespecial 110	com/tencent/mm/plugin/expt/c/a:<init>	()V
    //   47: astore 4
    //   49: aload_2
    //   50: astore_3
    //   51: aload 4
    //   53: aload_2
    //   54: invokevirtual 113	com/tencent/mm/plugin/expt/c/a:d	(Landroid/database/Cursor;)V
    //   57: aload_2
    //   58: astore_3
    //   59: aload_1
    //   60: aload 4
    //   62: invokeinterface 119 2 0
    //   67: pop
    //   68: goto -41 -> 27
    //   71: astore 4
    //   73: aload_2
    //   74: astore_3
    //   75: ldc 46
    //   77: ldc 121
    //   79: iconst_1
    //   80: anewarray 50	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload 4
    //   87: invokevirtual 69	java/lang/Exception:toString	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 72	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_1
    //   95: astore_3
    //   96: aload_2
    //   97: ifnull +11 -> 108
    //   100: aload_2
    //   101: invokeinterface 124 1 0
    //   106: aload_1
    //   107: astore_3
    //   108: aload_3
    //   109: areturn
    //   110: aload_2
    //   111: astore_3
    //   112: ldc 46
    //   114: ldc 126
    //   116: iconst_1
    //   117: anewarray 50	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_1
    //   123: invokeinterface 129 1 0
    //   128: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 66	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_1
    //   136: astore_3
    //   137: aload_2
    //   138: ifnull -30 -> 108
    //   141: aload_2
    //   142: invokeinterface 124 1 0
    //   147: aload_1
    //   148: areturn
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +9 -> 162
    //   156: aload_3
    //   157: invokeinterface 124 1 0
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: goto -13 -> 152
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -101 -> 73
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -108 -> 73
    //   184: aconst_null
    //   185: astore_1
    //   186: goto -51 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	d
    //   26	122	1	localLinkedList	LinkedList
    //   149	14	1	localObject1	Object
    //   164	1	1	localObject2	Object
    //   173	13	1	localObject3	Object
    //   12	160	2	localCursor	android.database.Cursor
    //   18	139	3	localObject4	Object
    //   47	14	4	locala	a
    //   71	15	4	localException1	Exception
    //   168	1	4	localException2	Exception
    //   177	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   29	38	71	java/lang/Exception
    //   40	49	71	java/lang/Exception
    //   51	57	71	java/lang/Exception
    //   59	68	71	java/lang/Exception
    //   112	135	71	java/lang/Exception
    //   0	13	149	finally
    //   19	27	164	finally
    //   29	38	164	finally
    //   40	49	164	finally
    //   51	57	164	finally
    //   59	68	164	finally
    //   75	94	164	finally
    //   112	135	164	finally
    //   0	13	168	java/lang/Exception
    //   19	27	177	java/lang/Exception
  }
  
  /* Error */
  public final java.util.ArrayList<Integer> aNm()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/expt/c/d:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 140
    //   6: aconst_null
    //   7: invokeinterface 99 3 0
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +91 -> 105
    //   17: aload_2
    //   18: astore_3
    //   19: new 142	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 143	java/util/ArrayList:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: astore_1
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: invokeinterface 109 1 0
    //   39: ifeq +68 -> 107
    //   42: aload_2
    //   43: astore_3
    //   44: aload 5
    //   46: aload_2
    //   47: iconst_0
    //   48: invokeinterface 147 2 0
    //   53: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   59: pop
    //   60: goto -32 -> 28
    //   63: astore 4
    //   65: aload 5
    //   67: astore_1
    //   68: aload_2
    //   69: astore_3
    //   70: ldc 46
    //   72: ldc 150
    //   74: iconst_1
    //   75: anewarray 50	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload 4
    //   82: invokevirtual 69	java/lang/Exception:toString	()Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 72	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_1
    //   90: astore_3
    //   91: aload_2
    //   92: ifnull +11 -> 103
    //   95: aload_2
    //   96: invokeinterface 124 1 0
    //   101: aload_1
    //   102: astore_3
    //   103: aload_3
    //   104: areturn
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_3
    //   109: aload_2
    //   110: ifnull -7 -> 103
    //   113: aload_2
    //   114: invokeinterface 124 1 0
    //   119: aload_1
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_3
    //   124: aload_3
    //   125: ifnull +9 -> 134
    //   128: aload_3
    //   129: invokeinterface 124 1 0
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: goto -13 -> 124
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: goto -78 -> 68
    //   149: astore 4
    //   151: aconst_null
    //   152: astore_1
    //   153: goto -85 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	d
    //   30	90	1	localArrayList1	java.util.ArrayList
    //   121	14	1	localObject1	Object
    //   136	1	1	localObject2	Object
    //   145	8	1	localObject3	Object
    //   12	132	2	localCursor	android.database.Cursor
    //   18	111	3	localObject4	Object
    //   63	18	4	localException1	Exception
    //   140	1	4	localException2	Exception
    //   149	1	4	localException3	Exception
    //   26	40	5	localArrayList2	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   33	42	63	java/lang/Exception
    //   44	60	63	java/lang/Exception
    //   0	13	121	finally
    //   19	28	136	finally
    //   33	42	136	finally
    //   44	60	136	finally
    //   70	89	136	finally
    //   0	13	140	java/lang/Exception
    //   19	28	149	java/lang/Exception
  }
  
  public final int bh(List<Integer> paramList)
  {
    long l = -1L;
    int k = 0;
    int i = 0;
    int j = i;
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        j = i;
      }
    }
    else {
      return j;
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
        paramList = paramList.iterator();
        i = k;
        if (paramList.hasNext())
        {
          boolean bool = qE(((Integer)paramList.next()).intValue());
          if (bool)
          {
            i += 1;
            continue;
          }
          continue;
        }
        j = i;
        return i;
      }
      finally
      {
        if (localh != null) {
          localh.hI(l);
        }
      }
      localh = null;
    }
  }
  
  public final List<a> bl(List<a> paramList)
  {
    long l = -1L;
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    h localh;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(-1L);
    }
    for (;;)
    {
      LinkedList localLinkedList;
      try
      {
        localLinkedList = new LinkedList();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          a locala = (a)paramList.next();
          if (!a(locala)) {
            continue;
          }
          localLinkedList.add(locala);
          continue;
        }
        if (localh == null) {
          break label132;
        }
      }
      finally
      {
        if (localh != null) {
          localh.hI(l);
        }
      }
      localh.hI(l);
      label132:
      return localLinkedList;
      localh = null;
    }
  }
  
  /* Error */
  public final a qD(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/plugin/expt/c/d:dXw	Lcom/tencent/mm/sdk/e/e;
    //   4: ldc 22
    //   6: aconst_null
    //   7: ldc 76
    //   9: iconst_1
    //   10: anewarray 14	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: iload_1
    //   16: invokestatic 79	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   19: aastore
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokeinterface 195 8 0
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +130 -> 160
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: invokeinterface 198 1 0
    //   42: ifeq +118 -> 160
    //   45: aload_3
    //   46: astore 4
    //   48: new 16	com/tencent/mm/plugin/expt/c/a
    //   51: dup
    //   52: invokespecial 110	com/tencent/mm/plugin/expt/c/a:<init>	()V
    //   55: astore_2
    //   56: aload_3
    //   57: astore 4
    //   59: aload_2
    //   60: aload_3
    //   61: invokevirtual 113	com/tencent/mm/plugin/expt/c/a:d	(Landroid/database/Cursor;)V
    //   64: aload_2
    //   65: astore 4
    //   67: aload_3
    //   68: ifnull +12 -> 80
    //   71: aload_3
    //   72: invokeinterface 124 1 0
    //   77: aload_2
    //   78: astore 4
    //   80: aload 4
    //   82: areturn
    //   83: astore 5
    //   85: aconst_null
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_3
    //   90: astore 4
    //   92: ldc 46
    //   94: ldc 200
    //   96: iconst_1
    //   97: anewarray 50	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 5
    //   104: invokevirtual 69	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: aastore
    //   108: invokestatic 72	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_2
    //   112: astore 4
    //   114: aload_3
    //   115: ifnull -35 -> 80
    //   118: aload_3
    //   119: invokeinterface 124 1 0
    //   124: aload_2
    //   125: areturn
    //   126: astore_2
    //   127: aconst_null
    //   128: astore 4
    //   130: aload 4
    //   132: ifnull +10 -> 142
    //   135: aload 4
    //   137: invokeinterface 124 1 0
    //   142: aload_2
    //   143: athrow
    //   144: astore_2
    //   145: goto -15 -> 130
    //   148: astore 5
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -63 -> 89
    //   155: astore 5
    //   157: goto -68 -> 89
    //   160: aconst_null
    //   161: astore_2
    //   162: goto -98 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	d
    //   0	165	1	paramInt	int
    //   55	70	2	locala	a
    //   126	17	2	localObject1	Object
    //   144	1	2	localObject2	Object
    //   151	11	2	localObject3	Object
    //   28	91	3	localCursor	android.database.Cursor
    //   34	102	4	localObject4	Object
    //   83	20	5	localException1	Exception
    //   148	1	5	localException2	Exception
    //   155	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	29	83	java/lang/Exception
    //   0	29	126	finally
    //   36	45	144	finally
    //   48	56	144	finally
    //   59	64	144	finally
    //   92	111	144	finally
    //   36	45	148	java/lang/Exception
    //   48	56	148	java/lang/Exception
    //   59	64	155	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.d
 * JD-Core Version:    0.7.0.1
 */