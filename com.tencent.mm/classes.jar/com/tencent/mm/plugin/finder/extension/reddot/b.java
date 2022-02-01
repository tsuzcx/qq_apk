package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "isNotify", "keys", "", "", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Z[Ljava/lang/String;)Z", "isExist", "id", "queryAll", "", "replace", "update", "Companion", "plugin-finder_release"})
public final class b
  extends j<h>
{
  private static final String[] SQL_CREATE;
  public static final b.a reh;
  private final e db;
  
  static
  {
    AppMethodBeat.i(178147);
    reh = new b.a((byte)0);
    h.a locala = h.rfv;
    SQL_CREATE = new String[] { j.getCreateSQLs(h.access$getInfo$cp(), "FinderRedDotInfo") };
    AppMethodBeat.o(178147);
  }
  
  public b(e parame)
  {
    super(parame, h.access$getInfo$cp(), "FinderRedDotInfo", cg.INDEX_CREATE);
    AppMethodBeat.i(178146);
    this.db = parame;
    AppMethodBeat.o(178146);
  }
  
  /* Error */
  public final java.util.List<h> ctx()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 105
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   11: lstore_1
    //   12: new 113	java/util/LinkedList
    //   15: dup
    //   16: invokespecial 115	java/util/LinkedList:<init>	()V
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 119	com/tencent/mm/plugin/finder/extension/reddot/b:getAll	()Landroid/database/Cursor;
    //   24: astore 5
    //   26: aload 5
    //   28: ifnull +71 -> 99
    //   31: aload 5
    //   33: checkcast 121	java/io/Closeable
    //   36: astore 5
    //   38: aload 5
    //   40: checkcast 123	android/database/Cursor
    //   43: astore 6
    //   45: aload 6
    //   47: invokeinterface 127 1 0
    //   52: ifeq +36 -> 88
    //   55: new 57	com/tencent/mm/plugin/finder/extension/reddot/h
    //   58: dup
    //   59: invokespecial 128	com/tencent/mm/plugin/finder/extension/reddot/h:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: aload 6
    //   68: invokevirtual 132	com/tencent/mm/plugin/finder/extension/reddot/h:convertFrom	(Landroid/database/Cursor;)V
    //   71: aload_3
    //   72: aload 7
    //   74: invokevirtual 136	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 6
    //   80: invokeinterface 139 1 0
    //   85: ifne -30 -> 55
    //   88: getstatic 145	d/y:KTp	Ld/y;
    //   91: astore 6
    //   93: aload 5
    //   95: aconst_null
    //   96: invokestatic 151	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   99: ldc 153
    //   101: new 155	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 157
    //   107: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   113: lload_1
    //   114: lsub
    //   115: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   118: ldc 166
    //   120: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 178	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_3
    //   130: checkcast 180	java/util/List
    //   133: astore_3
    //   134: ldc 105
    //   136: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_3
    //   140: areturn
    //   141: astore 4
    //   143: ldc 105
    //   145: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload 4
    //   150: athrow
    //   151: astore_3
    //   152: aload 5
    //   154: aload 4
    //   156: invokestatic 151	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   159: ldc 105
    //   161: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_3
    //   165: athrow
    //   166: astore_3
    //   167: goto -15 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	b
    //   11	103	1	l	long
    //   19	121	3	localObject1	java.lang.Object
    //   151	14	3	localObject2	java.lang.Object
    //   166	1	3	localObject3	java.lang.Object
    //   1	1	4	localObject4	java.lang.Object
    //   141	14	4	localThrowable	java.lang.Throwable
    //   24	129	5	localObject5	java.lang.Object
    //   43	49	6	localObject6	java.lang.Object
    //   62	11	7	localh	h
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.b
 * JD-Core Version:    0.7.0.1
 */