package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends j<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(122469);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "ExptItem") };
    INDEX_CREATE = new String[0];
    AppMethodBeat.o(122469);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "ExptItem", INDEX_CREATE);
    this.db = parame;
  }
  
  private boolean DE(int paramInt)
  {
    AppMethodBeat.i(122464);
    try
    {
      paramInt = this.db.delete("ExptItem", "exptId=?", new String[] { String.valueOf(paramInt) });
      if (paramInt > 0)
      {
        AppMethodBeat.o(122464);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExptStorage", "delete expt by id [%s]", new Object[] { localException.toString() });
        paramInt = 0;
      }
      AppMethodBeat.o(122464);
    }
    return false;
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(122465);
    if (paramc == null)
    {
      AppMethodBeat.o(122465);
      return false;
    }
    try
    {
      bool = super.replace(paramc);
      ad.d("MicroMsg.ExptStorage", "replace expt ret[%b] item[%s]", new Object[] { Boolean.valueOf(bool), paramc.toString() });
      AppMethodBeat.o(122465);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExptStorage", "replace expt error [%s]", new Object[] { localException.toString() });
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  public final c DD(int paramInt)
  {
    // Byte code:
    //   0: ldc 104
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/i/d:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 29
    //   11: aconst_null
    //   12: ldc 55
    //   14: iconst_1
    //   15: anewarray 21	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: iload_1
    //   21: invokestatic 59	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokeinterface 108 8 0
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +144 -> 179
    //   38: aload_3
    //   39: astore 4
    //   41: aload_3
    //   42: invokeinterface 114 1 0
    //   47: ifeq +132 -> 179
    //   50: aload_3
    //   51: astore 4
    //   53: new 23	com/tencent/mm/plugin/expt/h/c
    //   56: dup
    //   57: invokespecial 116	com/tencent/mm/plugin/expt/h/c:<init>	()V
    //   60: astore_2
    //   61: aload_3
    //   62: astore 4
    //   64: aload_2
    //   65: aload_3
    //   66: invokevirtual 120	com/tencent/mm/plugin/expt/h/c:convertFrom	(Landroid/database/Cursor;)V
    //   69: aload_2
    //   70: astore 4
    //   72: aload_3
    //   73: ifnull +12 -> 85
    //   76: aload_3
    //   77: invokeinterface 123 1 0
    //   82: aload_2
    //   83: astore 4
    //   85: ldc 104
    //   87: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload 4
    //   92: areturn
    //   93: astore 5
    //   95: aconst_null
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_3
    //   100: astore 4
    //   102: ldc 67
    //   104: ldc 125
    //   106: iconst_1
    //   107: anewarray 71	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 5
    //   114: invokevirtual 75	java/lang/Exception:toString	()Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_2
    //   122: astore 4
    //   124: aload_3
    //   125: ifnull -40 -> 85
    //   128: aload_3
    //   129: invokeinterface 123 1 0
    //   134: aload_2
    //   135: astore 4
    //   137: goto -52 -> 85
    //   140: astore_2
    //   141: aconst_null
    //   142: astore 4
    //   144: aload 4
    //   146: ifnull +10 -> 156
    //   149: aload 4
    //   151: invokeinterface 123 1 0
    //   156: ldc 104
    //   158: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: goto -20 -> 144
    //   167: astore 5
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -72 -> 99
    //   174: astore 5
    //   176: goto -77 -> 99
    //   179: aconst_null
    //   180: astore_2
    //   181: goto -112 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	d
    //   0	184	1	paramInt	int
    //   60	75	2	localc	c
    //   140	22	2	localObject1	Object
    //   163	1	2	localObject2	Object
    //   170	11	2	localObject3	Object
    //   33	96	3	localCursor	android.database.Cursor
    //   39	111	4	localObject4	Object
    //   93	20	5	localException1	Exception
    //   167	1	5	localException2	Exception
    //   174	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   5	34	93	java/lang/Exception
    //   5	34	140	finally
    //   41	50	163	finally
    //   53	61	163	finally
    //   64	69	163	finally
    //   102	121	163	finally
    //   41	50	167	java/lang/Exception
    //   53	61	167	java/lang/Exception
    //   64	69	174	java/lang/Exception
  }
  
  public final int crQ()
  {
    int i = 0;
    AppMethodBeat.i(122468);
    try
    {
      int j = this.db.delete("ExptItem", null, null);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.ExptStorage", "delete all expt error[%s]", new Object[] { localException.toString() });
      }
    }
    AppMethodBeat.o(122468);
    return i;
  }
  
  /* Error */
  public final List<c> crT()
  {
    // Byte code:
    //   0: ldc 133
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/i/d:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 135
    //   11: aconst_null
    //   12: invokeinterface 139 3 0
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +183 -> 202
    //   22: aload_2
    //   23: astore_3
    //   24: new 141	java/util/LinkedList
    //   27: dup
    //   28: invokespecial 142	java/util/LinkedList:<init>	()V
    //   31: astore_1
    //   32: aload_2
    //   33: astore_3
    //   34: aload_2
    //   35: invokeinterface 145 1 0
    //   40: ifeq +80 -> 120
    //   43: aload_2
    //   44: astore_3
    //   45: new 23	com/tencent/mm/plugin/expt/h/c
    //   48: dup
    //   49: invokespecial 116	com/tencent/mm/plugin/expt/h/c:<init>	()V
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload 4
    //   58: aload_2
    //   59: invokevirtual 120	com/tencent/mm/plugin/expt/h/c:convertFrom	(Landroid/database/Cursor;)V
    //   62: aload_2
    //   63: astore_3
    //   64: aload_1
    //   65: aload 4
    //   67: invokeinterface 151 2 0
    //   72: pop
    //   73: goto -41 -> 32
    //   76: astore 4
    //   78: aload_2
    //   79: astore_3
    //   80: ldc 67
    //   82: ldc 153
    //   84: iconst_1
    //   85: anewarray 71	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload 4
    //   92: invokevirtual 75	java/lang/Exception:toString	()Ljava/lang/String;
    //   95: aastore
    //   96: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: ifnull +11 -> 113
    //   105: aload_2
    //   106: invokeinterface 123 1 0
    //   111: aload_1
    //   112: astore_3
    //   113: ldc 133
    //   115: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_3
    //   119: areturn
    //   120: aload_2
    //   121: astore_3
    //   122: ldc 67
    //   124: ldc 155
    //   126: iconst_1
    //   127: anewarray 71	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_1
    //   133: invokeinterface 158 1 0
    //   138: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic 99	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_1
    //   146: astore_3
    //   147: aload_2
    //   148: ifnull -35 -> 113
    //   151: aload_2
    //   152: invokeinterface 123 1 0
    //   157: aload_1
    //   158: astore_3
    //   159: goto -46 -> 113
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_3
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: invokeinterface 123 1 0
    //   175: ldc 133
    //   177: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: goto -18 -> 165
    //   186: astore 4
    //   188: aconst_null
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -114 -> 78
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -121 -> 78
    //   202: aconst_null
    //   203: astore_1
    //   204: goto -59 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	d
    //   31	127	1	localLinkedList	LinkedList
    //   162	19	1	localObject1	Object
    //   182	1	1	localObject2	Object
    //   191	13	1	localObject3	Object
    //   17	173	2	localCursor	android.database.Cursor
    //   23	147	3	localObject4	Object
    //   52	14	4	localc	c
    //   76	15	4	localException1	Exception
    //   186	1	4	localException2	Exception
    //   195	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   34	43	76	java/lang/Exception
    //   45	54	76	java/lang/Exception
    //   56	62	76	java/lang/Exception
    //   64	73	76	java/lang/Exception
    //   122	145	76	java/lang/Exception
    //   5	18	162	finally
    //   24	32	182	finally
    //   34	43	182	finally
    //   45	54	182	finally
    //   56	62	182	finally
    //   64	73	182	finally
    //   80	99	182	finally
    //   122	145	182	finally
    //   5	18	186	java/lang/Exception
    //   24	32	195	java/lang/Exception
  }
  
  /* Error */
  public final java.util.ArrayList<Integer> crU()
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/tencent/mm/plugin/expt/i/d:db	Lcom/tencent/mm/sdk/e/e;
    //   9: ldc 170
    //   11: aconst_null
    //   12: invokeinterface 139 3 0
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +96 -> 115
    //   22: aload_2
    //   23: astore_3
    //   24: new 172	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 173	java/util/ArrayList:<init>	()V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_1
    //   36: aload_2
    //   37: astore_3
    //   38: aload_2
    //   39: invokeinterface 145 1 0
    //   44: ifeq +73 -> 117
    //   47: aload_2
    //   48: astore_3
    //   49: aload 5
    //   51: aload_2
    //   52: iconst_0
    //   53: invokeinterface 177 2 0
    //   58: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 178	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: goto -32 -> 33
    //   68: astore 4
    //   70: aload 5
    //   72: astore_1
    //   73: aload_2
    //   74: astore_3
    //   75: ldc 67
    //   77: ldc 180
    //   79: iconst_1
    //   80: anewarray 71	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload 4
    //   87: invokevirtual 75	java/lang/Exception:toString	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_1
    //   95: astore_3
    //   96: aload_2
    //   97: ifnull +11 -> 108
    //   100: aload_2
    //   101: invokeinterface 123 1 0
    //   106: aload_1
    //   107: astore_3
    //   108: ldc 168
    //   110: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_3
    //   114: areturn
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: astore_3
    //   119: aload_2
    //   120: ifnull -12 -> 108
    //   123: aload_2
    //   124: invokeinterface 123 1 0
    //   129: aload_1
    //   130: astore_3
    //   131: goto -23 -> 108
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +9 -> 147
    //   141: aload_3
    //   142: invokeinterface 123 1 0
    //   147: ldc 168
    //   149: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: goto -18 -> 137
    //   158: astore 4
    //   160: aconst_null
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -91 -> 73
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -98 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	d
    //   35	95	1	localArrayList1	java.util.ArrayList
    //   134	19	1	localObject1	Object
    //   154	1	1	localObject2	Object
    //   163	8	1	localObject3	Object
    //   17	145	2	localCursor	android.database.Cursor
    //   23	119	3	localObject4	Object
    //   68	18	4	localException1	Exception
    //   158	1	4	localException2	Exception
    //   167	1	4	localException3	Exception
    //   31	40	5	localArrayList2	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   38	47	68	java/lang/Exception
    //   49	65	68	java/lang/Exception
    //   5	18	134	finally
    //   24	33	154	finally
    //   38	47	154	finally
    //   49	65	154	finally
    //   75	94	154	finally
    //   5	18	158	java/lang/Exception
    //   24	33	167	java/lang/Exception
  }
  
  public final int de(List<Integer> paramList)
  {
    long l = -1L;
    int i = 0;
    AppMethodBeat.i(122467);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(122467);
      return 0;
    }
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.xO(-1L);
    }
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          boolean bool = DE(((Integer)paramList.next()).intValue());
          if (bool)
          {
            i += 1;
            continue;
          }
          continue;
        }
        return i;
      }
      finally
      {
        if (localh != null) {
          localh.sJ(l);
        }
        AppMethodBeat.o(122467);
      }
      localh = null;
    }
  }
  
  public final List<c> dk(List<c> paramList)
  {
    long l = -1L;
    AppMethodBeat.i(122466);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(122466);
      return null;
    }
    h localh;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.xO(-1L);
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
          c localc = (c)paramList.next();
          if (!a(localc)) {
            continue;
          }
          localLinkedList.add(localc);
          continue;
        }
        if (localh == null) {
          break label147;
        }
      }
      finally
      {
        if (localh != null) {
          localh.sJ(l);
        }
        AppMethodBeat.o(122466);
      }
      localh.sJ(l);
      label147:
      AppMethodBeat.o(122466);
      return localLinkedList;
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.i.d
 * JD-Core Version:    0.7.0.1
 */