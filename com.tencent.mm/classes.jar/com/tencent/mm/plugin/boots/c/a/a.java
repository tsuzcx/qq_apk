package com.tencent.mm.plugin.boots.c.a;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends i<com.tencent.mm.plugin.boots.a.a>
  implements g.a
{
  public static final String[] dXp = { i.a(com.tencent.mm.plugin.boots.a.a.buS, "ActiveInfo") };
  private e dXw;
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.plugin.boots.a.a.buS, "ActiveInfo", null);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> awD()
  {
    localArrayList = new ArrayList();
    long l = bk.crX();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localCursor = this.dXw.a("select * from ActiveInfo where useTime >= ?", new String[] { String.valueOf(l - 86400000L) }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            com.tencent.mm.plugin.boots.a.a locala = new com.tencent.mm.plugin.boots.a.a();
            localObject1 = localCursor;
            localObject3 = localCursor;
            locala.d(localCursor);
            localObject1 = localCursor;
            localObject3 = localCursor;
            localArrayList.add(locala);
            localObject1 = localCursor;
            localObject3 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
      }
    }
    catch (Exception localException)
    {
      Cursor localCursor;
      localObject3 = localObject1;
      y.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", localException, "getDayActiveFeature failed.", new Object[0]);
      return localArrayList;
    }
    finally
    {
      if (localObject3 == null) {
        break label204;
      }
      localObject3.close();
    }
    return localArrayList;
  }
  
  public final String getTableName()
  {
    return "ActiveInfo";
  }
  
  /* Error */
  public final int od(int paramInt)
  {
    // Byte code:
    //   0: new 17	com/tencent/mm/plugin/boots/a/a
    //   3: dup
    //   4: invokespecial 72	com/tencent/mm/plugin/boots/a/a:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 37	com/tencent/mm/plugin/boots/c/a/a:dXw	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc 23
    //   15: aconst_null
    //   16: ldc 108
    //   18: iconst_1
    //   19: anewarray 15	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 111	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokeinterface 115 8 0
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +134 -> 175
    //   44: aload 6
    //   46: invokeinterface 71 1 0
    //   51: ifeq +124 -> 175
    //   54: aload 7
    //   56: aload 6
    //   58: invokevirtual 76	com/tencent/mm/plugin/boots/a/a:d	(Landroid/database/Cursor;)V
    //   61: iconst_0
    //   62: istore_2
    //   63: iload_2
    //   64: istore_3
    //   65: aload 6
    //   67: ifnull +12 -> 79
    //   70: aload 6
    //   72: invokeinterface 88 1 0
    //   77: iload_2
    //   78: istore_3
    //   79: aload 7
    //   81: getfield 119	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   84: invokestatic 52	com/tencent/mm/sdk/platformtools/bk:crX	()J
    //   87: ldc2_w 55
    //   90: lsub
    //   91: lcmp
    //   92: iflt +140 -> 232
    //   95: aload 7
    //   97: getfield 119	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   100: invokestatic 52	com/tencent/mm/sdk/platformtools/bk:crX	()J
    //   103: lcmp
    //   104: ifgt +128 -> 232
    //   107: aload 7
    //   109: getfield 123	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   112: iconst_1
    //   113: iadd
    //   114: istore_2
    //   115: aload 7
    //   117: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   120: putfield 119	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   123: aload 7
    //   125: iload_2
    //   126: putfield 123	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   129: aload 7
    //   131: iconst_1
    //   132: putfield 131	com/tencent/mm/plugin/boots/a/a:field_mau	I
    //   135: iload_3
    //   136: ifeq +139 -> 275
    //   139: aload_0
    //   140: getfield 37	com/tencent/mm/plugin/boots/c/a/a:dXw	Lcom/tencent/mm/sdk/e/e;
    //   143: ldc 23
    //   145: ldc 133
    //   147: aload 7
    //   149: invokevirtual 137	com/tencent/mm/plugin/boots/a/a:vf	()Landroid/content/ContentValues;
    //   152: invokeinterface 141 4 0
    //   157: lstore 4
    //   159: lload 4
    //   161: lconst_0
    //   162: lcmp
    //   163: ifge +10 -> 173
    //   166: ldc 90
    //   168: ldc 143
    //   170: invokestatic 147	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload_2
    //   174: ireturn
    //   175: aload 7
    //   177: iload_1
    //   178: putfield 150	com/tencent/mm/plugin/boots/a/a:field_key	I
    //   181: iconst_1
    //   182: istore_2
    //   183: goto -120 -> 63
    //   186: astore 6
    //   188: iconst_0
    //   189: istore_2
    //   190: aconst_null
    //   191: astore 6
    //   193: iload_2
    //   194: istore_3
    //   195: aload 6
    //   197: ifnull -118 -> 79
    //   200: aload 6
    //   202: invokeinterface 88 1 0
    //   207: iload_2
    //   208: istore_3
    //   209: goto -130 -> 79
    //   212: astore 7
    //   214: aconst_null
    //   215: astore 6
    //   217: aload 6
    //   219: ifnull +10 -> 229
    //   222: aload 6
    //   224: invokeinterface 88 1 0
    //   229: aload 7
    //   231: athrow
    //   232: aload 7
    //   234: getfield 119	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   237: invokestatic 52	com/tencent/mm/sdk/platformtools/bk:crX	()J
    //   240: ldc2_w 55
    //   243: lsub
    //   244: lcmp
    //   245: iflt +25 -> 270
    //   248: aload 7
    //   250: getfield 123	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   253: ifle +12 -> 265
    //   256: aload 7
    //   258: getfield 123	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   261: istore_2
    //   262: goto -147 -> 115
    //   265: iconst_1
    //   266: istore_2
    //   267: goto -152 -> 115
    //   270: iconst_1
    //   271: istore_2
    //   272: goto -157 -> 115
    //   275: aload_0
    //   276: getfield 37	com/tencent/mm/plugin/boots/c/a/a:dXw	Lcom/tencent/mm/sdk/e/e;
    //   279: ldc 23
    //   281: aload 7
    //   283: invokevirtual 137	com/tencent/mm/plugin/boots/a/a:vf	()Landroid/content/ContentValues;
    //   286: ldc 108
    //   288: iconst_1
    //   289: anewarray 15	java/lang/String
    //   292: dup
    //   293: iconst_0
    //   294: iload_1
    //   295: invokestatic 111	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   298: aastore
    //   299: invokeinterface 154 5 0
    //   304: i2l
    //   305: lstore 4
    //   307: goto -148 -> 159
    //   310: astore 7
    //   312: goto -95 -> 217
    //   315: astore 8
    //   317: iconst_0
    //   318: istore_2
    //   319: goto -126 -> 193
    //   322: astore 8
    //   324: iconst_1
    //   325: istore_2
    //   326: goto -133 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	a
    //   0	329	1	paramInt	int
    //   62	264	2	i	int
    //   64	145	3	j	int
    //   157	149	4	l	long
    //   37	34	6	localCursor	Cursor
    //   186	1	6	localException1	Exception
    //   191	32	6	localObject1	Object
    //   7	169	7	locala	com.tencent.mm.plugin.boots.a.a
    //   212	70	7	localObject2	Object
    //   310	1	7	localObject3	Object
    //   315	1	8	localException2	Exception
    //   322	1	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   9	39	186	java/lang/Exception
    //   9	39	212	finally
    //   44	61	310	finally
    //   175	181	310	finally
    //   44	61	315	java/lang/Exception
    //   175	181	322	java/lang/Exception
  }
  
  /* Error */
  public final com.tencent.mm.plugin.boots.a.a oe(int paramInt)
  {
    // Byte code:
    //   0: new 17	com/tencent/mm/plugin/boots/a/a
    //   3: dup
    //   4: invokespecial 72	com/tencent/mm/plugin/boots/a/a:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 37	com/tencent/mm/plugin/boots/c/a/a:dXw	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc 23
    //   15: aconst_null
    //   16: ldc 158
    //   18: iconst_1
    //   19: anewarray 15	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 111	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokeinterface 115 8 0
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull +22 -> 61
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: invokeinterface 71 1 0
    //   50: ifeq +11 -> 61
    //   53: aload_3
    //   54: astore_2
    //   55: aload 5
    //   57: aload_3
    //   58: invokevirtual 76	com/tencent/mm/plugin/boots/a/a:d	(Landroid/database/Cursor;)V
    //   61: aload_3
    //   62: ifnull +9 -> 71
    //   65: aload_3
    //   66: invokeinterface 88 1 0
    //   71: aload 5
    //   73: areturn
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: ldc 90
    //   82: aload 4
    //   84: ldc 160
    //   86: iconst_1
    //   87: anewarray 94	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: iload_1
    //   93: invokestatic 165	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   96: aastore
    //   97: invokestatic 100	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_3
    //   101: ifnull -30 -> 71
    //   104: aload_3
    //   105: invokeinterface 88 1 0
    //   110: aload 5
    //   112: areturn
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +9 -> 126
    //   120: aload_2
    //   121: invokeinterface 88 1 0
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: goto -13 -> 116
    //   132: astore 4
    //   134: goto -56 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	a
    //   0	137	1	paramInt	int
    //   43	78	2	localCursor1	Cursor
    //   37	68	3	localCursor2	Cursor
    //   113	14	3	localObject1	Object
    //   128	1	3	localObject2	Object
    //   74	9	4	localException1	Exception
    //   132	1	4	localException2	Exception
    //   7	104	5	locala	com.tencent.mm.plugin.boots.a.a
    // Exception table:
    //   from	to	target	type
    //   9	38	74	java/lang/Exception
    //   9	38	113	finally
    //   44	53	128	finally
    //   55	61	128	finally
    //   80	100	128	finally
    //   44	53	132	java/lang/Exception
    //   55	61	132	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.c.a.a
 * JD-Core Version:    0.7.0.1
 */