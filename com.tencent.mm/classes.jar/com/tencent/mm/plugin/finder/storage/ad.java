package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cs;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.model.bk.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderOrAliasDeletingInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderOrAliasDeletingInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllDeletingInfo", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"})
public final class ad
  extends MAutoStorage<bk>
{
  public static final a Amo;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(278586);
    Amo = new a((byte)0);
    bk.a locala = bk.zBl;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bk.access$getInfo$cp(), "FinderOrAliasDeletingInfo") };
    AppMethodBeat.o(278586);
  }
  
  public ad(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bk.access$getInfo$cp(), "FinderOrAliasDeletingInfo", cs.INDEX_CREATE);
    AppMethodBeat.i(278585);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(278585);
  }
  
  /* Error */
  public final java.util.LinkedList<bk> dYR()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 95
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 97
    //   9: ldc 98
    //   11: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 105	java/util/LinkedList
    //   17: dup
    //   18: invokespecial 107	java/util/LinkedList:<init>	()V
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 88	com/tencent/mm/plugin/finder/storage/ad:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   26: ldc 109
    //   28: aconst_null
    //   29: invokeinterface 115 3 0
    //   34: checkcast 117	java/io/Closeable
    //   37: astore_3
    //   38: aload_3
    //   39: checkcast 119	android/database/Cursor
    //   42: astore 4
    //   44: aload 4
    //   46: invokeinterface 123 1 0
    //   51: ifeq +50 -> 101
    //   54: new 48	com/tencent/mm/plugin/finder/model/bk
    //   57: dup
    //   58: invokespecial 124	com/tencent/mm/plugin/finder/model/bk:<init>	()V
    //   61: astore 5
    //   63: aload 5
    //   65: aload 4
    //   67: invokevirtual 128	com/tencent/mm/plugin/finder/model/bk:convertFrom	(Landroid/database/Cursor;)V
    //   70: aload_1
    //   71: aload 5
    //   73: invokevirtual 132	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -33 -> 44
    //   80: astore_2
    //   81: ldc 95
    //   83: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_2
    //   87: athrow
    //   88: astore_1
    //   89: aload_3
    //   90: aload_2
    //   91: invokestatic 137	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   94: ldc 95
    //   96: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    //   101: getstatic 143	kotlin/x:aazN	Lkotlin/x;
    //   104: astore 4
    //   106: aload_3
    //   107: aconst_null
    //   108: invokestatic 137	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   111: ldc 95
    //   113: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: areturn
    //   118: astore_1
    //   119: goto -30 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	ad
    //   21	50	1	localLinkedList	java.util.LinkedList
    //   88	29	1	localLinkedList1	java.util.LinkedList<bk>
    //   118	1	1	localObject1	Object
    //   1	1	2	localObject2	Object
    //   80	11	2	localThrowable	java.lang.Throwable
    //   37	70	3	localCloseable	java.io.Closeable
    //   42	63	4	localObject3	Object
    //   61	11	5	localbk	bk
    // Exception table:
    //   from	to	target	type
    //   38	44	80	java/lang/Throwable
    //   44	77	80	java/lang/Throwable
    //   101	106	80	java/lang/Throwable
    //   81	88	88	finally
    //   38	44	118	finally
    //   44	77	118	finally
    //   101	106	118	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderOrAliasDeletingInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ad
 * JD-Core Version:    0.7.0.1
 */