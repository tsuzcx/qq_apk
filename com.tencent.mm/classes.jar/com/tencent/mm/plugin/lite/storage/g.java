package com.tencent.mm.plugin.lite.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends MAutoStorage<f>
{
  public static final String[] SQL_CREATE;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(271316);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.info, "LiteAppBaselibInfo") };
    AppMethodBeat.o(271316);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, f.info, "LiteAppBaselibInfo");
  }
  
  private g(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(271321);
    this.db.insert("LiteAppBaselibInfo", "majorVersion", paramf.convertTo());
    AppMethodBeat.o(271321);
    return true;
  }
  
  /* Error */
  public final f aJZ(String paramString)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 68
    //   11: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: ldc 70
    //   18: iconst_3
    //   19: anewarray 72	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: ldc 28
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 53
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_1
    //   35: aastore
    //   36: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 48	com/tencent/mm/plugin/lite/storage/g:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   44: aload_1
    //   45: iconst_0
    //   46: anewarray 20	java/lang/String
    //   49: iconst_2
    //   50: invokeinterface 80 4 0
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +48 -> 105
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: invokeinterface 86 1 0
    //   68: ifeq +37 -> 105
    //   71: aload_2
    //   72: astore_1
    //   73: new 22	com/tencent/mm/plugin/lite/storage/f
    //   76: dup
    //   77: invokespecial 88	com/tencent/mm/plugin/lite/storage/f:<init>	()V
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload_2
    //   85: invokevirtual 92	com/tencent/mm/plugin/lite/storage/f:convertFrom	(Landroid/database/Cursor;)V
    //   88: aload_2
    //   89: ifnull +9 -> 98
    //   92: aload_2
    //   93: invokeinterface 95 1 0
    //   98: ldc 68
    //   100: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_3
    //   104: areturn
    //   105: aload_2
    //   106: ifnull +9 -> 115
    //   109: aload_2
    //   110: invokeinterface 95 1 0
    //   115: ldc 68
    //   117: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: ldc 97
    //   129: ldc 99
    //   131: iconst_1
    //   132: anewarray 72	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_3
    //   138: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_2
    //   146: ifnull -31 -> 115
    //   149: aload_2
    //   150: invokeinterface 95 1 0
    //   155: goto -40 -> 115
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +9 -> 171
    //   165: aload_1
    //   166: invokeinterface 95 1 0
    //   171: ldc 68
    //   173: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_2
    //   177: athrow
    //   178: astore_2
    //   179: goto -18 -> 161
    //   182: astore_3
    //   183: goto -58 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	g
    //   0	186	1	paramString	String
    //   55	95	2	localCursor	Cursor
    //   158	19	2	localObject1	Object
    //   178	1	2	localObject2	Object
    //   80	24	3	localf	f
    //   122	16	3	localException1	Exception
    //   182	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   40	56	122	java/lang/Exception
    //   40	56	158	finally
    //   62	71	178	finally
    //   73	81	178	finally
    //   83	88	178	finally
    //   127	145	178	finally
    //   62	71	182	java/lang/Exception
    //   73	81	182	java/lang/Exception
    //   83	88	182	java/lang/Exception
  }
  
  /* Error */
  public final f fUp()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore_1
    //   5: ldc 114
    //   7: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 116
    //   12: iconst_1
    //   13: anewarray 72	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 28
    //   20: aastore
    //   21: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 48	com/tencent/mm/plugin/lite/storage/g:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   30: aload 4
    //   32: iconst_0
    //   33: anewarray 20	java/lang/String
    //   36: iconst_2
    //   37: invokeinterface 80 4 0
    //   42: astore 5
    //   44: aload 5
    //   46: astore 6
    //   48: aload 5
    //   50: invokeinterface 86 1 0
    //   55: istore_3
    //   56: iload_3
    //   57: ifeq +241 -> 298
    //   60: aload 5
    //   62: astore 6
    //   64: aload 8
    //   66: astore 7
    //   68: new 22	com/tencent/mm/plugin/lite/storage/f
    //   71: dup
    //   72: invokespecial 88	com/tencent/mm/plugin/lite/storage/f:<init>	()V
    //   75: astore 9
    //   77: aload 5
    //   79: astore 6
    //   81: aload 8
    //   83: astore 7
    //   85: aload 9
    //   87: aload 5
    //   89: invokevirtual 92	com/tencent/mm/plugin/lite/storage/f:convertFrom	(Landroid/database/Cursor;)V
    //   92: iload_1
    //   93: istore_2
    //   94: aload 8
    //   96: astore 4
    //   98: aload 5
    //   100: astore 6
    //   102: aload 8
    //   104: astore 7
    //   106: aload 9
    //   108: getfield 120	com/tencent/mm/plugin/lite/storage/f:field_majorVersion	Ljava/lang/String;
    //   111: invokestatic 126	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: iload_1
    //   115: if_icmplt +24 -> 139
    //   118: aload 5
    //   120: astore 6
    //   122: aload 8
    //   124: astore 7
    //   126: aload 9
    //   128: getfield 120	com/tencent/mm/plugin/lite/storage/f:field_majorVersion	Ljava/lang/String;
    //   131: invokestatic 126	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   134: istore_2
    //   135: aload 9
    //   137: astore 4
    //   139: aload 5
    //   141: astore 6
    //   143: aload 4
    //   145: astore 7
    //   147: aload 5
    //   149: invokeinterface 129 1 0
    //   154: istore_3
    //   155: iload_2
    //   156: istore_1
    //   157: aload 4
    //   159: astore 8
    //   161: iload_3
    //   162: ifne -102 -> 60
    //   165: aload 4
    //   167: astore 6
    //   169: aload 5
    //   171: ifnull +14 -> 185
    //   174: aload 5
    //   176: invokeinterface 95 1 0
    //   181: aload 4
    //   183: astore 6
    //   185: ldc 114
    //   187: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload 6
    //   192: areturn
    //   193: astore 7
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 4
    //   201: aload 5
    //   203: astore 6
    //   205: ldc 97
    //   207: ldc 131
    //   209: iconst_1
    //   210: anewarray 72	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload 7
    //   217: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload 4
    //   226: astore 6
    //   228: aload 5
    //   230: ifnull -45 -> 185
    //   233: aload 5
    //   235: invokeinterface 95 1 0
    //   240: aload 4
    //   242: astore 6
    //   244: goto -59 -> 185
    //   247: astore 4
    //   249: aconst_null
    //   250: astore 6
    //   252: aload 6
    //   254: ifnull +10 -> 264
    //   257: aload 6
    //   259: invokeinterface 95 1 0
    //   264: ldc 114
    //   266: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload 4
    //   271: athrow
    //   272: astore 4
    //   274: goto -22 -> 252
    //   277: astore 7
    //   279: aconst_null
    //   280: astore 4
    //   282: goto -81 -> 201
    //   285: astore 6
    //   287: aload 7
    //   289: astore 4
    //   291: aload 6
    //   293: astore 7
    //   295: goto -94 -> 201
    //   298: aconst_null
    //   299: astore 4
    //   301: goto -136 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	g
    //   4	153	1	i	int
    //   93	63	2	j	int
    //   55	107	3	bool	boolean
    //   24	217	4	localObject1	Object
    //   247	23	4	localObject2	Object
    //   272	1	4	localObject3	Object
    //   280	20	4	localObject4	Object
    //   42	192	5	localCursor	Cursor
    //   46	212	6	localObject5	Object
    //   285	7	6	localException1	Exception
    //   66	80	7	localObject6	Object
    //   193	23	7	localException2	Exception
    //   277	11	7	localException3	Exception
    //   293	1	7	localException4	Exception
    //   1	159	8	localObject7	Object
    //   75	61	9	localf	f
    // Exception table:
    //   from	to	target	type
    //   26	44	193	java/lang/Exception
    //   26	44	247	finally
    //   48	56	272	finally
    //   68	77	272	finally
    //   85	92	272	finally
    //   106	118	272	finally
    //   126	135	272	finally
    //   147	155	272	finally
    //   205	224	272	finally
    //   48	56	277	java/lang/Exception
    //   68	77	285	java/lang/Exception
    //   85	92	285	java/lang/Exception
    //   106	118	285	java/lang/Exception
    //   126	135	285	java/lang/Exception
    //   147	155	285	java/lang/Exception
  }
  
  public final List<f> fUq()
  {
    AppMethodBeat.i(271338);
    Object localObject4 = String.format("select * from %s ", new Object[] { "LiteAppBaselibInfo" });
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.db.rawQuery((String)localObject4, new String[0], 2);
      localObject1 = localObject4;
      localObject3 = localObject4;
      if (((Cursor)localObject4).moveToFirst())
      {
        boolean bool;
        do
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          f localf = new f();
          localObject1 = localObject4;
          localObject3 = localObject4;
          localf.convertFrom((Cursor)localObject4);
          localObject1 = localObject4;
          localObject3 = localObject4;
          localArrayList.add(localf);
          localObject1 = localObject4;
          localObject3 = localObject4;
          bool = ((Cursor)localObject4).moveToNext();
        } while (bool);
      }
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.e("MicroMsg.LiteAppBaselibInfoStorage", "getLiteAppBaselibList failed. :%s", new Object[] { Util.stackTraceToString(localException) });
        if (localObject1 != null) {
          localObject1.close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label197;
      }
      localObject3.close();
      AppMethodBeat.o(271338);
    }
    AppMethodBeat.o(271338);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.g
 * JD-Core Version:    0.7.0.1
 */