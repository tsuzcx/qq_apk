package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ca;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.api.f.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "replaceContactInDB", "", "ct", "updateContact", "Companion", "plugin-finder_release"})
public final class c
  extends j<ca>
{
  private static final String[] SQL_CREATE;
  public static final a qJF;
  public final e qJE;
  
  static
  {
    AppMethodBeat.i(166958);
    qJF = new a((byte)0);
    f.a locala = f.qok;
    SQL_CREATE = new String[] { j.getCreateSQLs(f.access$getInfo$cp(), "FinderContact") };
    AppMethodBeat.o(166958);
  }
  
  public c(e parame)
  {
    super(parame, f.access$getInfo$cp(), "FinderContact", null);
    AppMethodBeat.i(166957);
    this.qJE = parame;
    AppMethodBeat.o(166957);
  }
  
  /* Error */
  public final f YL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 100
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 101
    //   10: invokestatic 87	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 103	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 105
    //   19: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 114	com/tencent/mm/storagebase/h:qj	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 93	com/tencent/mm/plugin/finder/storage/c:qJE	Lcom/tencent/mm/sdk/e/e;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 127 4 0
    //   45: checkcast 129	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 131	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 135 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 57	com/tencent/mm/plugin/finder/api/f
    //   74: dup
    //   75: invokespecial 137	com/tencent/mm/plugin/finder/api/f:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 141	com/tencent/mm/plugin/finder/api/f:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 147	d/y:JfV	Ld/y;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 152	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 100
    //   97: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 100
    //   110: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 152	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 100
    //   123: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.c
 * JD-Core Version:    0.7.0.1
 */