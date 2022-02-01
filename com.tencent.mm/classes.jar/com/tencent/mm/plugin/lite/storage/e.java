package com.tencent.mm.plugin.lite.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(271329);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.info, "LiteAppAuthInfo") };
    AppMethodBeat.o(271329);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, d.info, "LiteAppAuthInfo");
  }
  
  private e(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(271332);
    this.db.insert("LiteAppAuthInfo", "host", paramd.convertTo());
    AppMethodBeat.o(271332);
    return true;
  }
  
  /* Error */
  public final d aJY(String paramString)
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
    //   41: getfield 48	com/tencent/mm/plugin/lite/storage/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
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
    //   73: new 22	com/tencent/mm/plugin/lite/storage/d
    //   76: dup
    //   77: invokespecial 88	com/tencent/mm/plugin/lite/storage/d:<init>	()V
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload_2
    //   85: invokevirtual 92	com/tencent/mm/plugin/lite/storage/d:convertFrom	(Landroid/database/Cursor;)V
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
    //   0	186	0	this	e
    //   0	186	1	paramString	String
    //   55	95	2	localCursor	android.database.Cursor
    //   158	19	2	localObject1	java.lang.Object
    //   178	1	2	localObject2	java.lang.Object
    //   80	24	3	locald	d
    //   122	16	3	localException1	java.lang.Exception
    //   182	1	3	localException2	java.lang.Exception
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.e
 * JD-Core Version:    0.7.0.1
 */