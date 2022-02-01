package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getPluginStringVersion", "", "id", "version", "", "hasRecord", "", "record", "insertOrUpdate", "runInDataBaseTransaction", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "setPluginStringVersion", "", "stringVersion", "Companion", "data-storage_release"})
public final class bs
  extends c<br>
{
  @Deprecated
  public static final a nIi;
  private final ISQLiteDatabaseEx nHd;
  
  static
  {
    AppMethodBeat.i(232668);
    nIi = new a((byte)0);
    AppMethodBeat.o(232668);
  }
  
  public bs(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, br.lqK, "WxaPluginCodeVersionInfo", br.INDEX_CREATE);
    AppMethodBeat.i(232666);
    this.nHd = paramISQLiteDatabaseEx;
    AppMethodBeat.o(232666);
  }
  
  /* Error */
  private final boolean a(br parambr)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 95	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 97
    //   11: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 104	com/tencent/mm/plugin/appbrand/appcache/bs:getTableName	()Ljava/lang/String;
    //   18: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 110
    //   23: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 89	com/tencent/mm/plugin/appbrand/appcache/bs:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   35: aload 4
    //   37: iconst_2
    //   38: anewarray 115	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: getfield 119	com/tencent/mm/plugin/appbrand/appcache/br:field_pluginAppID	Ljava/lang/String;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_1
    //   51: getfield 123	com/tencent/mm/plugin/appbrand/appcache/br:field_pluginAppVersion	I
    //   54: invokestatic 127	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   57: aastore
    //   58: invokeinterface 133 3 0
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +86 -> 151
    //   68: aload_1
    //   69: checkcast 135	java/io/Closeable
    //   72: astore 5
    //   74: aload 5
    //   76: checkcast 137	android/database/Cursor
    //   79: astore_1
    //   80: aload_1
    //   81: invokeinterface 141 1 0
    //   86: ifeq +35 -> 121
    //   89: aload_1
    //   90: iconst_0
    //   91: invokeinterface 145 2 0
    //   96: istore_2
    //   97: iload_2
    //   98: ifle +18 -> 116
    //   101: iconst_1
    //   102: istore_3
    //   103: aload 5
    //   105: aconst_null
    //   106: invokestatic 150	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   109: ldc 93
    //   111: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iload_3
    //   115: ireturn
    //   116: iconst_0
    //   117: istore_3
    //   118: goto -15 -> 103
    //   121: iconst_0
    //   122: istore_3
    //   123: goto -20 -> 103
    //   126: astore 4
    //   128: ldc 93
    //   130: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload 4
    //   135: athrow
    //   136: astore_1
    //   137: aload 5
    //   139: aload 4
    //   141: invokestatic 150	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: ldc 93
    //   146: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    //   151: ldc 93
    //   153: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_1
    //   159: aconst_null
    //   160: astore 4
    //   162: goto -25 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	bs
    //   0	165	1	parambr	br
    //   96	2	2	i	int
    //   102	21	3	bool	boolean
    //   29	7	4	str	String
    //   126	14	4	localThrowable	java.lang.Throwable
    //   160	1	4	localObject	Object
    //   72	66	5	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   74	97	126	java/lang/Throwable
    //   128	136	136	finally
    //   74	97	158	finally
  }
  
  public final String bs(String paramString, int paramInt)
  {
    AppMethodBeat.i(182794);
    p.k(paramString, "id");
    Object localObject = new br();
    ((br)localObject).field_pluginAppID = paramString;
    ((br)localObject).field_pluginAppVersion = paramInt;
    if (get((IAutoDBItem)localObject, new String[0])) {}
    for (localObject = ((br)localObject).field_pluginStringVersion;; localObject = null)
    {
      Log.i("Luggage.WxaPluginCodeVersionInfoStorage", "getPluginStringVersion with id:" + paramString + " version:" + paramInt + ", returns:" + (String)localObject);
      AppMethodBeat.o(182794);
      return localObject;
    }
  }
  
  public final <R> R r(a<? extends R> parama)
  {
    AppMethodBeat.i(232656);
    ISQLiteDatabaseEx localISQLiteDatabaseEx = this.nHd;
    Thread localThread = Thread.currentThread();
    p.j(localThread, "Thread.currentThread()");
    long l = localISQLiteDatabaseEx.beginTransaction(localThread.getId());
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.nHd.endTransaction(l);
      AppMethodBeat.o(232656);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage$Companion;", "", "()V", "TAG", "", "data-storage_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements a<Boolean>
  {
    public b(bs parambs, br parambr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bs
 * JD-Core Version:    0.7.0.1
 */