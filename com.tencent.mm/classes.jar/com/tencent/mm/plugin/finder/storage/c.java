package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.api.g.a;
import com.tencent.mm.sdk.e.j;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "replaceContactInDB", "", "ct", "updateContact", "Companion", "plugin-finder_release"})
public final class c
  extends j<cd>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a sxC;
  public final com.tencent.mm.sdk.e.e sxB;
  
  static
  {
    AppMethodBeat.i(166958);
    sxC = new a((byte)0);
    Object localObject = g.rHB;
    SQL_CREATE = new String[] { j.getCreateSQLs(g.access$getInfo$cp(), "FinderContact") };
    localObject = cd.INDEX_CREATE;
    p.g(localObject, "BaseFinderContact.INDEX_CREATE");
    localObject = d.a.e.X((Object[])localObject);
    ((List)localObject).add(0, "DROP INDEX username_index");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(166958);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(166958);
  }
  
  public c(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, g.access$getInfo$cp(), "FinderContact", INDEX_CREATE);
    AppMethodBeat.i(166957);
    this.sxB = parame;
    AppMethodBeat.o(166957);
  }
  
  /* Error */
  public final g agW(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 139
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 140
    //   10: invokestatic 126	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 142	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 144
    //   19: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 151	com/tencent/mm/storagebase/h:wo	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 132	com/tencent/mm/plugin/finder/storage/c:sxB	Lcom/tencent/mm/sdk/e/e;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 164 4 0
    //   45: checkcast 166	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 168	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 172 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 58	com/tencent/mm/plugin/finder/api/g
    //   74: dup
    //   75: invokespecial 174	com/tencent/mm/plugin/finder/api/g:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 178	com/tencent/mm/plugin/finder/api/g:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 184	d/z:MKo	Ld/z;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 189	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 139
    //   97: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 139
    //   110: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 189	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 139
    //   123: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   107	11	2	localThrowable	Throwable
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "getSQL_CREATE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.c
 * JD-Core Version:    0.7.0.1
 */