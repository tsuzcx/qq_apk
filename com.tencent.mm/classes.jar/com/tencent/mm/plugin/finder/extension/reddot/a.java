package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "isNotify", "keys", "", "", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Z[Ljava/lang/String;)Z", "queryAll", "", "replace", "Companion", "plugin-finder_release"})
public final class a
  extends j<f>
{
  private static final String[] SQL_CREATE;
  public static final a qta;
  private final e db;
  
  static
  {
    AppMethodBeat.i(178147);
    qta = new a((byte)0);
    f.a locala = f.qtN;
    SQL_CREATE = new String[] { j.getCreateSQLs(f.access$getInfo$cp(), "FinderRedDotInfo") };
    AppMethodBeat.o(178147);
  }
  
  public a(e parame)
  {
    super(parame, f.access$getInfo$cp(), "FinderRedDotInfo", ce.INDEX_CREATE);
    AppMethodBeat.i(178146);
    this.db = parame;
    AppMethodBeat.o(178146);
  }
  
  /* Error */
  public final java.util.List<f> clj()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 103
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   11: lstore_1
    //   12: new 111	java/util/LinkedList
    //   15: dup
    //   16: invokespecial 113	java/util/LinkedList:<init>	()V
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 117	com/tencent/mm/plugin/finder/extension/reddot/a:getAll	()Landroid/database/Cursor;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +71 -> 99
    //   31: aload 5
    //   33: checkcast 119	java/io/Closeable
    //   36: astore 5
    //   38: aload 5
    //   40: checkcast 121	android/database/Cursor
    //   43: astore 6
    //   45: aload 6
    //   47: invokeinterface 125 1 0
    //   52: ifeq +36 -> 88
    //   55: new 55	com/tencent/mm/plugin/finder/extension/reddot/f
    //   58: dup
    //   59: invokespecial 126	com/tencent/mm/plugin/finder/extension/reddot/f:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: aload 6
    //   68: invokevirtual 130	com/tencent/mm/plugin/finder/extension/reddot/f:convertFrom	(Landroid/database/Cursor;)V
    //   71: aload_3
    //   72: aload 7
    //   74: invokevirtual 134	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: invokeinterface 137 1 0
    //   85: ifne -30 -> 55
    //   88: getstatic 143	d/y:JfV	Ld/y;
    //   91: astore 6
    //   93: aload 5
    //   95: aconst_null
    //   96: invokestatic 148	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   99: new 150	java/lang/StringBuilder
    //   102: dup
    //   103: ldc 152
    //   105: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   111: lload_1
    //   112: lsub
    //   113: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: ldc 161
    //   118: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: invokestatic 169	com/tencent/d/f/h:fmz	()V
    //   125: aload_3
    //   126: checkcast 171	java/util/List
    //   129: astore_3
    //   130: ldc 103
    //   132: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: areturn
    //   137: astore 4
    //   139: ldc 103
    //   141: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload 4
    //   146: athrow
    //   147: astore_3
    //   148: aload 5
    //   150: aload 4
    //   152: invokestatic 148	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   155: ldc 103
    //   157: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_3
    //   161: athrow
    //   162: astore_3
    //   163: goto -15 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	a
    //   11	101	1	l	long
    //   19	117	3	localObject1	Object
    //   147	14	3	localObject2	Object
    //   162	1	3	localObject3	Object
    //   1	1	4	localObject4	Object
    //   137	14	4	localThrowable	java.lang.Throwable
    //   24	125	5	localObject5	Object
    //   43	49	6	localObject6	Object
    //   62	11	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   38	55	137	java/lang/Throwable
    //   55	88	137	java/lang/Throwable
    //   88	93	137	java/lang/Throwable
    //   139	147	147	finally
    //   38	55	162	finally
    //   55	88	162	finally
    //   88	93	162	finally
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.a
 * JD-Core Version:    0.7.0.1
 */