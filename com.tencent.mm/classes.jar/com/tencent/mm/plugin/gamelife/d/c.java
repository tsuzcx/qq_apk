package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "username", "", "", "", "insertContact", "", "contact", "replaceContact", "", "updateContact", "Companion", "plugin-gamelife_release"})
public final class c
  extends j<cu>
{
  private static final String[] SQL_CREATE;
  public static final a uxX;
  final e sxB;
  
  static
  {
    AppMethodBeat.i(211318);
    uxX = new a((byte)0);
    a.a locala = a.uxL;
    SQL_CREATE = new String[] { j.getCreateSQLs(a.access$getInfo$cp(), "GameLifeContact") };
    AppMethodBeat.o(211318);
  }
  
  public c(e parame)
  {
    super(parame, a.access$getInfo$cp(), "GameLifeContact", cu.INDEX_CREATE);
    AppMethodBeat.i(211317);
    this.sxB = parame;
    AppMethodBeat.o(211317);
  }
  
  /* Error */
  public final a amF(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 104
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 105
    //   10: invokestatic 86	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 107	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 109
    //   19: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 118	com/tencent/mm/storagebase/h:wo	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 97	com/tencent/mm/plugin/gamelife/d/c:sxB	Lcom/tencent/mm/sdk/e/e;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 131 4 0
    //   45: checkcast 133	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 135	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 139 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 56	com/tencent/mm/plugin/gamelife/d/a
    //   74: dup
    //   75: invokespecial 141	com/tencent/mm/plugin/gamelife/d/a:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 145	com/tencent/mm/plugin/gamelife/d/a:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 151	d/z:MKo	Ld/z;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 156	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 104
    //   97: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 104
    //   110: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 156	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 104
    //   123: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: goto -13 -> 116
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -49 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	c
    //   0	137	1	paramString	String
    //   1	1	2	localObject1	Object
    //   107	11	2	localThrowable	java.lang.Throwable
    //   48	69	3	localCloseable	java.io.Closeable
    //   53	36	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	107	java/lang/Throwable
    //   60	85	107	java/lang/Throwable
    //   85	90	107	java/lang/Throwable
    //   108	115	115	finally
    //   49	55	128	finally
    //   60	85	128	finally
    //   85	90	128	finally
  }
  
  /* Error */
  public final java.util.Map<String, a> eg(java.util.List<String> paramList)
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 105
    //   8: invokestatic 86	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: new 107	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 161
    //   17: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: getstatic 167	com/tencent/mm/plugin/gamelife/b:uwo	Lcom/tencent/mm/plugin/gamelife/b$a;
    //   24: astore_3
    //   25: aload_2
    //   26: aload_1
    //   27: invokestatic 173	com/tencent/mm/plugin/gamelife/b$a:ef	(Ljava/util/List;)Ljava/lang/String;
    //   30: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: new 175	java/util/HashMap
    //   40: dup
    //   41: invokespecial 176	java/util/HashMap:<init>	()V
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 97	com/tencent/mm/plugin/gamelife/d/c:sxB	Lcom/tencent/mm/sdk/e/e;
    //   49: aload_2
    //   50: aconst_null
    //   51: iconst_2
    //   52: invokeinterface 131 4 0
    //   57: checkcast 133	java/io/Closeable
    //   60: astore_3
    //   61: aload_3
    //   62: checkcast 135	android/database/Cursor
    //   65: astore_2
    //   66: aload_2
    //   67: invokeinterface 139 1 0
    //   72: ifeq +96 -> 168
    //   75: aload_2
    //   76: ldc 178
    //   78: invokestatic 181	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   81: aload_2
    //   82: invokeinterface 184 1 0
    //   87: ifne +81 -> 168
    //   90: new 56	com/tencent/mm/plugin/gamelife/d/a
    //   93: dup
    //   94: invokespecial 141	com/tencent/mm/plugin/gamelife/d/a:<init>	()V
    //   97: astore 4
    //   99: aload 4
    //   101: aload_2
    //   102: invokevirtual 145	com/tencent/mm/plugin/gamelife/d/a:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload_1
    //   106: checkcast 186	java/util/Map
    //   109: astore 5
    //   111: aload 4
    //   113: getfield 190	com/tencent/mm/plugin/gamelife/d/a:field_username	Ljava/lang/String;
    //   116: astore 6
    //   118: aload 6
    //   120: ldc 191
    //   122: invokestatic 181	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   125: aload 5
    //   127: aload 6
    //   129: aload 4
    //   131: invokeinterface 195 3 0
    //   136: pop
    //   137: aload_2
    //   138: invokeinterface 198 1 0
    //   143: pop
    //   144: goto -69 -> 75
    //   147: astore_2
    //   148: ldc 159
    //   150: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_3
    //   157: aload_2
    //   158: invokestatic 156	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   161: ldc 159
    //   163: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: getstatic 151	d/z:MKo	Ld/z;
    //   171: astore_2
    //   172: aload_3
    //   173: aconst_null
    //   174: invokestatic 156	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   177: aload_1
    //   178: checkcast 186	java/util/Map
    //   181: astore_1
    //   182: ldc 159
    //   184: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_1
    //   188: areturn
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: goto -36 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	c
    //   0	195	1	paramList	java.util.List<String>
    //   20	118	2	localObject1	Object
    //   147	11	2	localThrowable	java.lang.Throwable
    //   171	21	2	localz	d.z
    //   24	149	3	localObject2	Object
    //   97	33	4	locala	a
    //   109	17	5	localMap	java.util.Map
    //   116	12	6	str	String
    // Exception table:
    //   from	to	target	type
    //   61	75	147	java/lang/Throwable
    //   75	144	147	java/lang/Throwable
    //   168	172	147	java/lang/Throwable
    //   148	155	155	finally
    //   61	75	189	finally
    //   75	144	189	finally
    //   168	172	189	finally
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.c
 * JD-Core Version:    0.7.0.1
 */