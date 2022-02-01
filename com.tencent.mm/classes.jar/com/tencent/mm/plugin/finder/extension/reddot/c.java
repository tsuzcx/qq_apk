package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "isNotify", "keys", "", "", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Z[Ljava/lang/String;)Z", "isExist", "id", "queryAll", "", "replace", "update", "Companion", "plugin-finder_release"})
public final class c
  extends j<i>
{
  private static final String[] SQL_CREATE;
  public static final a saq;
  private final e db;
  
  static
  {
    AppMethodBeat.i(178147);
    saq = new a((byte)0);
    i.a locala = i.sbG;
    SQL_CREATE = new String[] { j.getCreateSQLs(i.access$getInfo$cp(), "FinderRedDotInfo") };
    AppMethodBeat.o(178147);
  }
  
  public c(e parame)
  {
    super(parame, i.access$getInfo$cp(), "FinderRedDotInfo", cj.INDEX_CREATE);
    AppMethodBeat.i(178146);
    this.db = parame;
    AppMethodBeat.o(178146);
  }
  
  /* Error */
  public final java.util.List<i> coU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 106
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   11: lstore_1
    //   12: new 114	java/util/LinkedList
    //   15: dup
    //   16: invokespecial 116	java/util/LinkedList:<init>	()V
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 120	com/tencent/mm/plugin/finder/extension/reddot/c:getAll	()Landroid/database/Cursor;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +71 -> 99
    //   31: aload 5
    //   33: checkcast 122	java/io/Closeable
    //   36: astore 5
    //   38: aload 5
    //   40: checkcast 124	android/database/Cursor
    //   43: astore 6
    //   45: aload 6
    //   47: invokeinterface 128 1 0
    //   52: ifeq +36 -> 88
    //   55: new 58	com/tencent/mm/plugin/finder/extension/reddot/i
    //   58: dup
    //   59: invokespecial 129	com/tencent/mm/plugin/finder/extension/reddot/i:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: aload 6
    //   68: invokevirtual 133	com/tencent/mm/plugin/finder/extension/reddot/i:convertFrom	(Landroid/database/Cursor;)V
    //   71: aload_3
    //   72: aload 7
    //   74: invokevirtual 137	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: invokeinterface 140 1 0
    //   85: ifne -30 -> 55
    //   88: getstatic 146	d/z:Nhr	Ld/z;
    //   91: astore 6
    //   93: aload 5
    //   95: aconst_null
    //   96: invokestatic 151	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   99: ldc 153
    //   101: new 155	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 157
    //   107: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: invokestatic 112	java/lang/System:currentTimeMillis	()J
    //   113: lload_1
    //   114: lsub
    //   115: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   118: ldc 166
    //   120: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 178	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_3
    //   130: checkcast 180	java/util/List
    //   133: astore_3
    //   134: ldc 106
    //   136: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_3
    //   140: areturn
    //   141: astore 4
    //   143: ldc 106
    //   145: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload 4
    //   150: athrow
    //   151: astore_3
    //   152: aload 5
    //   154: aload 4
    //   156: invokestatic 151	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   159: ldc 106
    //   161: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_3
    //   165: athrow
    //   166: astore_3
    //   167: goto -15 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	c
    //   11	103	1	l	long
    //   19	121	3	localObject1	Object
    //   151	14	3	localObject2	Object
    //   166	1	3	localObject3	Object
    //   1	1	4	localObject4	Object
    //   141	14	4	localThrowable	java.lang.Throwable
    //   24	129	5	localObject5	Object
    //   43	49	6	localObject6	Object
    //   62	11	7	locali	i
    // Exception table:
    //   from	to	target	type
    //   38	55	141	java/lang/Throwable
    //   55	88	141	java/lang/Throwable
    //   88	93	141	java/lang/Throwable
    //   143	151	151	finally
    //   38	55	166	finally
    //   55	88	166	finally
    //   88	93	166	finally
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.c
 * JD-Core Version:    0.7.0.1
 */