package com.tencent.mm.plugin.boots.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends j<com.tencent.mm.plugin.boots.a.a>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(117376);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.boots.a.a.info, "ActiveInfo") };
    AppMethodBeat.o(117376);
  }
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.plugin.boots.a.a.info, "ActiveInfo", null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final List<com.tencent.mm.plugin.boots.a.a> bMT()
  {
    AppMethodBeat.i(117375);
    ArrayList localArrayList = new ArrayList();
    long l = bt.flO();
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.db.a("select * from ActiveInfo where useTime >= ?", new String[] { String.valueOf(l - 86400000L) }, 2);
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
            locala.convertFrom(localCursor);
            localObject1 = localCursor;
            localObject3 = localCursor;
            localArrayList.add(locala);
            localObject1 = localCursor;
            localObject3 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        ad.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", localException, "getDayActiveFeature failed.", new Object[0]);
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label214;
      }
      localObject3.close();
      AppMethodBeat.o(117375);
    }
    AppMethodBeat.o(117375);
    return localArrayList;
  }
  
  public final String getTableName()
  {
    return "ActiveInfo";
  }
  
  /* Error */
  public final int yZ(int paramInt)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 24	com/tencent/mm/plugin/boots/a/a
    //   8: dup
    //   9: invokespecial 84	com/tencent/mm/plugin/boots/a/a:<init>	()V
    //   12: astore 9
    //   14: aload_0
    //   15: getfield 47	com/tencent/mm/plugin/boots/b/a/a:db	Lcom/tencent/mm/sdk/e/e;
    //   18: ldc 30
    //   20: aconst_null
    //   21: ldc 121
    //   23: iconst_1
    //   24: anewarray 22	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: iload_1
    //   30: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokeinterface 128 8 0
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +147 -> 193
    //   49: aload 7
    //   51: astore 6
    //   53: aload 7
    //   55: invokeinterface 83 1 0
    //   60: ifeq +133 -> 193
    //   63: aload 7
    //   65: astore 6
    //   67: aload 9
    //   69: aload 7
    //   71: invokevirtual 88	com/tencent/mm/plugin/boots/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   74: iconst_0
    //   75: istore_2
    //   76: iload_2
    //   77: istore_3
    //   78: aload 7
    //   80: ifnull +12 -> 92
    //   83: aload 7
    //   85: invokeinterface 100 1 0
    //   90: iload_2
    //   91: istore_3
    //   92: aload 9
    //   94: getfield 132	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   97: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:flO	()J
    //   100: ldc2_w 67
    //   103: lsub
    //   104: lcmp
    //   105: iflt +170 -> 275
    //   108: aload 9
    //   110: getfield 132	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   113: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:flO	()J
    //   116: lcmp
    //   117: ifgt +158 -> 275
    //   120: aload 9
    //   122: getfield 136	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: aload 9
    //   130: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   133: putfield 132	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   136: aload 9
    //   138: iload_2
    //   139: putfield 136	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   142: aload 9
    //   144: iconst_1
    //   145: putfield 144	com/tencent/mm/plugin/boots/a/a:field_mau	I
    //   148: iload_3
    //   149: ifeq +169 -> 318
    //   152: aload_0
    //   153: getfield 47	com/tencent/mm/plugin/boots/b/a/a:db	Lcom/tencent/mm/sdk/e/e;
    //   156: ldc 30
    //   158: ldc 146
    //   160: aload 9
    //   162: invokevirtual 150	com/tencent/mm/plugin/boots/a/a:convertTo	()Landroid/content/ContentValues;
    //   165: invokeinterface 154 4 0
    //   170: lstore 4
    //   172: lload 4
    //   174: lconst_0
    //   175: lcmp
    //   176: ifge +10 -> 186
    //   179: ldc 102
    //   181: ldc 156
    //   183: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc 119
    //   188: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: iload_2
    //   192: ireturn
    //   193: iconst_1
    //   194: istore_3
    //   195: iconst_1
    //   196: istore_2
    //   197: aload 7
    //   199: astore 6
    //   201: aload 9
    //   203: iload_1
    //   204: putfield 163	com/tencent/mm/plugin/boots/a/a:field_key	I
    //   207: goto -131 -> 76
    //   210: astore 8
    //   212: iload_3
    //   213: istore_2
    //   214: aload 7
    //   216: astore 6
    //   218: ldc 102
    //   220: aload 8
    //   222: ldc 165
    //   224: iconst_0
    //   225: anewarray 106	java/lang/Object
    //   228: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: iload_2
    //   232: istore_3
    //   233: aload 7
    //   235: ifnull -143 -> 92
    //   238: aload 7
    //   240: invokeinterface 100 1 0
    //   245: iload_2
    //   246: istore_3
    //   247: goto -155 -> 92
    //   250: astore 7
    //   252: aconst_null
    //   253: astore 6
    //   255: aload 6
    //   257: ifnull +10 -> 267
    //   260: aload 6
    //   262: invokeinterface 100 1 0
    //   267: ldc 119
    //   269: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload 7
    //   274: athrow
    //   275: aload 9
    //   277: getfield 132	com/tencent/mm/plugin/boots/a/a:field_useTime	J
    //   280: invokestatic 64	com/tencent/mm/sdk/platformtools/bt:flO	()J
    //   283: ldc2_w 67
    //   286: lsub
    //   287: lcmp
    //   288: iflt +25 -> 313
    //   291: aload 9
    //   293: getfield 136	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   296: ifle +12 -> 308
    //   299: aload 9
    //   301: getfield 136	com/tencent/mm/plugin/boots/a/a:field_dau	I
    //   304: istore_2
    //   305: goto -177 -> 128
    //   308: iconst_1
    //   309: istore_2
    //   310: goto -182 -> 128
    //   313: iconst_1
    //   314: istore_2
    //   315: goto -187 -> 128
    //   318: aload_0
    //   319: getfield 47	com/tencent/mm/plugin/boots/b/a/a:db	Lcom/tencent/mm/sdk/e/e;
    //   322: ldc 30
    //   324: aload 9
    //   326: invokevirtual 150	com/tencent/mm/plugin/boots/a/a:convertTo	()Landroid/content/ContentValues;
    //   329: ldc 121
    //   331: iconst_1
    //   332: anewarray 22	java/lang/String
    //   335: dup
    //   336: iconst_0
    //   337: iload_1
    //   338: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   341: aastore
    //   342: invokeinterface 169 5 0
    //   347: i2l
    //   348: lstore 4
    //   350: goto -178 -> 172
    //   353: astore 7
    //   355: goto -100 -> 255
    //   358: astore 8
    //   360: iconst_0
    //   361: istore_2
    //   362: aconst_null
    //   363: astore 7
    //   365: goto -151 -> 214
    //   368: astore 8
    //   370: iconst_0
    //   371: istore_2
    //   372: goto -158 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	a
    //   0	375	1	paramInt	int
    //   75	297	2	i	int
    //   77	170	3	j	int
    //   170	179	4	l	long
    //   51	210	6	localCursor1	Cursor
    //   42	197	7	localCursor2	Cursor
    //   250	23	7	localObject1	Object
    //   353	1	7	localObject2	Object
    //   363	1	7	localObject3	Object
    //   210	11	8	localException1	Exception
    //   358	1	8	localException2	Exception
    //   368	1	8	localException3	Exception
    //   12	313	9	locala	com.tencent.mm.plugin.boots.a.a
    // Exception table:
    //   from	to	target	type
    //   201	207	210	java/lang/Exception
    //   14	44	250	finally
    //   53	63	353	finally
    //   67	74	353	finally
    //   201	207	353	finally
    //   218	231	353	finally
    //   14	44	358	java/lang/Exception
    //   53	63	368	java/lang/Exception
    //   67	74	368	java/lang/Exception
  }
  
  /* Error */
  public final com.tencent.mm.plugin.boots.a.a za(int paramInt)
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 24	com/tencent/mm/plugin/boots/a/a
    //   8: dup
    //   9: invokespecial 84	com/tencent/mm/plugin/boots/a/a:<init>	()V
    //   12: astore 5
    //   14: aload_0
    //   15: getfield 47	com/tencent/mm/plugin/boots/b/a/a:db	Lcom/tencent/mm/sdk/e/e;
    //   18: ldc 30
    //   20: aconst_null
    //   21: ldc 174
    //   23: iconst_1
    //   24: anewarray 22	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: iload_1
    //   30: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokeinterface 128 8 0
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +22 -> 66
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokeinterface 83 1 0
    //   55: ifeq +11 -> 66
    //   58: aload_3
    //   59: astore_2
    //   60: aload 5
    //   62: aload_3
    //   63: invokevirtual 88	com/tencent/mm/plugin/boots/a/a:convertFrom	(Landroid/database/Cursor;)V
    //   66: aload_3
    //   67: ifnull +9 -> 76
    //   70: aload_3
    //   71: invokeinterface 100 1 0
    //   76: ldc 172
    //   78: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload 5
    //   83: areturn
    //   84: astore 4
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_3
    //   89: astore_2
    //   90: ldc 102
    //   92: aload 4
    //   94: ldc 176
    //   96: iconst_1
    //   97: anewarray 106	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload_1
    //   103: invokestatic 181	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_3
    //   111: ifnull -35 -> 76
    //   114: aload_3
    //   115: invokeinterface 100 1 0
    //   120: goto -44 -> 76
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokeinterface 100 1 0
    //   136: ldc 172
    //   138: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_3
    //   142: athrow
    //   143: astore_3
    //   144: goto -18 -> 126
    //   147: astore 4
    //   149: goto -61 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	a
    //   0	152	1	paramInt	int
    //   48	83	2	localCursor1	Cursor
    //   42	73	3	localCursor2	Cursor
    //   123	19	3	localObject1	Object
    //   143	1	3	localObject2	Object
    //   84	9	4	localException1	Exception
    //   147	1	4	localException2	Exception
    //   12	70	5	locala	com.tencent.mm.plugin.boots.a.a
    // Exception table:
    //   from	to	target	type
    //   14	43	84	java/lang/Exception
    //   14	43	123	finally
    //   49	58	143	finally
    //   60	66	143	finally
    //   90	110	143	finally
    //   49	58	147	java/lang/Exception
    //   60	66	147	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.boots.b.a.a
 * JD-Core Version:    0.7.0.1
 */