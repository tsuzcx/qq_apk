package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.api.g.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collection;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "replaceContactInDB", "", "ct", "updateContact", "Companion", "plugin-finder_release"})
public final class d
  extends MAutoStorage<ce>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a vDj;
  public final ISQLiteDatabase vDi;
  
  static
  {
    AppMethodBeat.i(166958);
    vDj = new a((byte)0);
    Object localObject = g.tsD;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(g.access$getInfo$cp(), "FinderContact") };
    localObject = ce.INDEX_CREATE;
    p.g(localObject, "BaseFinderContact.INDEX_CREATE");
    localObject = e.X((Object[])localObject);
    ((List)localObject).add(0, "DROP INDEX username_index");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(166958);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(166958);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.access$getInfo$cp(), "FinderContact", INDEX_CREATE);
    AppMethodBeat.i(166957);
    this.vDi = paramISQLiteDatabase;
    AppMethodBeat.o(166957);
  }
  
  /* Error */
  public final g asG(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 137
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 138
    //   10: invokestatic 124	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 140	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 142
    //   19: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 149	com/tencent/mm/storagebase/h:Fl	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 130	com/tencent/mm/plugin/finder/storage/d:vDi	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 163 4 0
    //   45: checkcast 165	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 167	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 171 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 57	com/tencent/mm/plugin/finder/api/g
    //   74: dup
    //   75: invokespecial 173	com/tencent/mm/plugin/finder/api/g:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 177	com/tencent/mm/plugin/finder/api/g:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 183	kotlin/x:SXb	Lkotlin/x;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 188	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 137
    //   97: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 137
    //   110: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 188	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 137
    //   123: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: goto -13 -> 116
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -49 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	d
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "getSQL_CREATE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.d
 * JD-Core Version:    0.7.0.1
 */