package com.tencent.mm.plugin.lite.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;

public final class c
  extends j<b>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(208164);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "LiteAppInfo") };
    AppMethodBeat.o(208164);
  }
  
  public c(e parame)
  {
    this(parame, b.info, "LiteAppInfo");
  }
  
  private c(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  /* Error */
  public final b ajL(String paramString)
  {
    // Byte code:
    //   0: ldc 57
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 57
    //   11: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: ldc 59
    //   18: iconst_3
    //   19: anewarray 61	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: ldc 30
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc 63
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_1
    //   35: aastore
    //   36: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 50	com/tencent/mm/plugin/lite/d/c:db	Lcom/tencent/mm/sdk/e/e;
    //   44: aload_1
    //   45: iconst_0
    //   46: anewarray 22	java/lang/String
    //   49: iconst_2
    //   50: invokeinterface 72 4 0
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +48 -> 105
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: invokeinterface 78 1 0
    //   68: ifeq +37 -> 105
    //   71: aload_2
    //   72: astore_1
    //   73: new 24	com/tencent/mm/plugin/lite/d/b
    //   76: dup
    //   77: invokespecial 80	com/tencent/mm/plugin/lite/d/b:<init>	()V
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload_2
    //   85: invokevirtual 84	com/tencent/mm/plugin/lite/d/b:convertFrom	(Landroid/database/Cursor;)V
    //   88: aload_2
    //   89: ifnull +9 -> 98
    //   92: aload_2
    //   93: invokeinterface 87 1 0
    //   98: ldc 57
    //   100: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_3
    //   104: areturn
    //   105: aload_2
    //   106: ifnull +9 -> 115
    //   109: aload_2
    //   110: invokeinterface 87 1 0
    //   115: ldc 57
    //   117: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: ldc 89
    //   129: ldc 91
    //   131: iconst_1
    //   132: anewarray 61	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_3
    //   138: invokestatic 97	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_2
    //   146: ifnull -31 -> 115
    //   149: aload_2
    //   150: invokeinterface 87 1 0
    //   155: goto -40 -> 115
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +9 -> 171
    //   165: aload_1
    //   166: invokeinterface 87 1 0
    //   171: ldc 57
    //   173: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_2
    //   177: athrow
    //   178: astore_2
    //   179: goto -18 -> 161
    //   182: astore_3
    //   183: goto -58 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	c
    //   0	186	1	paramString	String
    //   55	95	2	localCursor	android.database.Cursor
    //   158	19	2	localObject1	java.lang.Object
    //   178	1	2	localObject2	java.lang.Object
    //   80	24	3	localb	b
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
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(208160);
    this.db.insert("LiteAppInfo", "appId", paramb.convertTo());
    AppMethodBeat.o(208160);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d.c
 * JD-Core Version:    0.7.0.1
 */