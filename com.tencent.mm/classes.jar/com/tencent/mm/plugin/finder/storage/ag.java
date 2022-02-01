package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.da;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.bo.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderOrAliasDeletingInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderOrAliasDeletingInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllDeletingInfo", "Ljava/util/LinkedList;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends MAutoStorage<bo>
{
  public static final a FMg;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(339432);
    FMg = new a((byte)0);
    bo.a locala = bo.EDu;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(bo.access$getInfo$cp(), "FinderOrAliasDeletingInfo") };
    AppMethodBeat.o(339432);
  }
  
  public ag(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bo.access$getInfo$cp(), "FinderOrAliasDeletingInfo", da.INDEX_CREATE);
    AppMethodBeat.i(339420);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(339420);
  }
  
  /* Error */
  public final java.util.LinkedList<bo> eZA()
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 98
    //   7: ldc 99
    //   9: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: new 106	java/util/LinkedList
    //   15: dup
    //   16: invokespecial 108	java/util/LinkedList:<init>	()V
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 91	com/tencent/mm/plugin/finder/storage/ag:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   24: ldc 110
    //   26: aconst_null
    //   27: invokeinterface 116 3 0
    //   32: checkcast 118	java/io/Closeable
    //   35: astore_1
    //   36: aload_1
    //   37: checkcast 120	android/database/Cursor
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface 124 1 0
    //   47: ifeq +49 -> 96
    //   50: new 51	com/tencent/mm/plugin/finder/model/bo
    //   53: dup
    //   54: invokespecial 125	com/tencent/mm/plugin/finder/model/bo:<init>	()V
    //   57: astore 4
    //   59: aload 4
    //   61: aload_3
    //   62: invokevirtual 129	com/tencent/mm/plugin/finder/model/bo:convertFrom	(Landroid/database/Cursor;)V
    //   65: aload_2
    //   66: aload 4
    //   68: invokevirtual 133	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   71: pop
    //   72: goto -31 -> 41
    //   75: astore_2
    //   76: ldc 96
    //   78: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    //   83: astore_3
    //   84: aload_1
    //   85: aload_2
    //   86: invokestatic 138	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   89: ldc 96
    //   91: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_3
    //   95: athrow
    //   96: getstatic 144	kotlin/ah:aiuX	Lkotlin/ah;
    //   99: astore_3
    //   100: aload_1
    //   101: aconst_null
    //   102: invokestatic 138	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   105: ldc 96
    //   107: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_2
    //   111: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ag
    //   35	66	1	localCloseable	java.io.Closeable
    //   19	47	2	localLinkedList	java.util.LinkedList
    //   75	36	2	localThrowable	java.lang.Throwable
    //   40	22	3	localCursor	android.database.Cursor
    //   83	12	3	localObject	Object
    //   99	1	3	localah	kotlin.ah
    //   57	10	4	localbo	bo
    // Exception table:
    //   from	to	target	type
    //   36	41	75	finally
    //   41	72	75	finally
    //   96	100	75	finally
    //   76	83	83	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderOrAliasDeletingInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ag
 * JD-Core Version:    0.7.0.1
 */