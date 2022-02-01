package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "username", "", "", "", "insertContact", "", "contact", "replaceContact", "", "updateContact", "Companion", "plugin-gamelife_release"})
public final class c
  extends MAutoStorage<cz>
{
  private static final String[] SQL_CREATE;
  public static final c.a ybR;
  final ISQLiteDatabase vDi;
  
  static
  {
    AppMethodBeat.i(241327);
    ybR = new c.a((byte)0);
    a.a locala = a.ybF;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameLifeContact") };
    AppMethodBeat.o(241327);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameLifeContact", cz.INDEX_CREATE);
    AppMethodBeat.i(241326);
    this.vDi = paramISQLiteDatabase;
    AppMethodBeat.o(241326);
  }
  
  /* Error */
  public final a aAZ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 101
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 102
    //   10: invokestatic 83	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 104	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 106
    //   19: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 115	com/tencent/mm/storagebase/h:Fl	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 94	com/tencent/mm/plugin/gamelife/d/c:vDi	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 129 4 0
    //   45: checkcast 131	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 133	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 137 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 54	com/tencent/mm/plugin/gamelife/d/a
    //   74: dup
    //   75: invokespecial 139	com/tencent/mm/plugin/gamelife/d/a:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 143	com/tencent/mm/plugin/gamelife/d/a:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 149	kotlin/x:SXb	Lkotlin/x;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 155	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 101
    //   97: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 101
    //   110: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 155	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 101
    //   123: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   1	1	2	localObject1	java.lang.Object
    //   107	11	2	localThrowable	java.lang.Throwable
    //   48	69	3	localCloseable	java.io.Closeable
    //   53	36	4	localObject2	java.lang.Object
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
  public final java.util.Map<String, a> fd(java.util.List<String> paramList)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 102
    //   8: invokestatic 83	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: new 104	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 160
    //   17: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: getstatic 166	com/tencent/mm/plugin/gamelife/b:xZZ	Lcom/tencent/mm/plugin/gamelife/b$a;
    //   24: astore_3
    //   25: aload_2
    //   26: aload_1
    //   27: invokestatic 172	com/tencent/mm/plugin/gamelife/b$a:fc	(Ljava/util/List;)Ljava/lang/String;
    //   30: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: new 174	java/util/HashMap
    //   40: dup
    //   41: invokespecial 175	java/util/HashMap:<init>	()V
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 94	com/tencent/mm/plugin/gamelife/d/c:vDi	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   49: aload_2
    //   50: aconst_null
    //   51: iconst_2
    //   52: invokeinterface 129 4 0
    //   57: checkcast 131	java/io/Closeable
    //   60: astore_3
    //   61: aload_3
    //   62: checkcast 133	android/database/Cursor
    //   65: astore_2
    //   66: aload_2
    //   67: invokeinterface 137 1 0
    //   72: ifeq +96 -> 168
    //   75: aload_2
    //   76: ldc 177
    //   78: invokestatic 180	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   81: aload_2
    //   82: invokeinterface 183 1 0
    //   87: ifne +81 -> 168
    //   90: new 54	com/tencent/mm/plugin/gamelife/d/a
    //   93: dup
    //   94: invokespecial 139	com/tencent/mm/plugin/gamelife/d/a:<init>	()V
    //   97: astore 4
    //   99: aload 4
    //   101: aload_2
    //   102: invokevirtual 143	com/tencent/mm/plugin/gamelife/d/a:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload_1
    //   106: checkcast 185	java/util/Map
    //   109: astore 5
    //   111: aload 4
    //   113: getfield 189	com/tencent/mm/plugin/gamelife/d/a:field_username	Ljava/lang/String;
    //   116: astore 6
    //   118: aload 6
    //   120: ldc 190
    //   122: invokestatic 180	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   125: aload 5
    //   127: aload 6
    //   129: aload 4
    //   131: invokeinterface 194 3 0
    //   136: pop
    //   137: aload_2
    //   138: invokeinterface 197 1 0
    //   143: pop
    //   144: goto -69 -> 75
    //   147: astore_2
    //   148: ldc 158
    //   150: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_3
    //   157: aload_2
    //   158: invokestatic 155	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   161: ldc 158
    //   163: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: getstatic 149	kotlin/x:SXb	Lkotlin/x;
    //   171: astore_2
    //   172: aload_3
    //   173: aconst_null
    //   174: invokestatic 155	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   177: aload_1
    //   178: checkcast 185	java/util/Map
    //   181: astore_1
    //   182: ldc 158
    //   184: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   20	118	2	localObject1	java.lang.Object
    //   147	11	2	localThrowable	java.lang.Throwable
    //   171	21	2	localx	kotlin.x
    //   24	149	3	localObject2	java.lang.Object
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.c
 * JD-Core Version:    0.7.0.1
 */