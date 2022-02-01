package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginCodeVersionInfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "getPluginStringVersion", "", "id", "version", "", "hasRecord", "", "record", "insertOrUpdate", "runInDataBaseTransaction", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "setPluginStringVersion", "", "stringVersion", "Companion", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bs
  extends c<br>
{
  private static final bs.a qHY;
  private final ISQLiteDatabaseEx qGR;
  
  static
  {
    AppMethodBeat.i(320182);
    qHY = new bs.a((byte)0);
    AppMethodBeat.o(320182);
  }
  
  public bs(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, br.nVV, "WxaPluginCodeVersionInfo", br.INDEX_CREATE);
    AppMethodBeat.i(320163);
    this.qGR = paramISQLiteDatabaseEx;
    AppMethodBeat.o(320163);
  }
  
  /* Error */
  private final boolean a(br parambr)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 95	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 97
    //   11: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 104	com/tencent/mm/plugin/appbrand/appcache/bs:getTableName	()Ljava/lang/String;
    //   18: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: ldc 110
    //   23: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 90	com/tencent/mm/plugin/appbrand/appcache/bs:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   35: aload 4
    //   37: iconst_2
    //   38: anewarray 118	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_1
    //   44: getfield 122	com/tencent/mm/plugin/appbrand/appcache/br:field_pluginAppID	Ljava/lang/String;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_1
    //   51: getfield 126	com/tencent/mm/plugin/appbrand/appcache/br:field_pluginAppVersion	I
    //   54: invokestatic 130	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   57: aastore
    //   58: invokeinterface 136 3 0
    //   63: astore_1
    //   64: aload_1
    //   65: ifnonnull +10 -> 75
    //   68: ldc 93
    //   70: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_0
    //   74: ireturn
    //   75: aload_1
    //   76: checkcast 138	java/io/Closeable
    //   79: astore_1
    //   80: aload_1
    //   81: checkcast 140	android/database/Cursor
    //   84: astore 4
    //   86: aload 4
    //   88: invokeinterface 144 1 0
    //   93: ifeq +35 -> 128
    //   96: aload 4
    //   98: iconst_0
    //   99: invokeinterface 148 2 0
    //   104: istore_2
    //   105: iload_2
    //   106: ifle +17 -> 123
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_1
    //   112: aconst_null
    //   113: invokestatic 153	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: ldc 93
    //   118: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_3
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_3
    //   125: goto -14 -> 111
    //   128: iconst_0
    //   129: istore_3
    //   130: goto -19 -> 111
    //   133: astore 4
    //   135: ldc 93
    //   137: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload 4
    //   142: athrow
    //   143: astore 5
    //   145: aload_1
    //   146: aload 4
    //   148: invokestatic 153	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   151: ldc 93
    //   153: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload 5
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	bs
    //   0	159	1	parambr	br
    //   104	2	2	i	int
    //   110	20	3	bool	boolean
    //   29	68	4	localObject1	Object
    //   133	14	4	localThrowable	java.lang.Throwable
    //   143	14	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   80	105	133	finally
    //   135	143	143	finally
  }
  
  public final <R> R aj(a<? extends R> parama)
  {
    AppMethodBeat.i(320194);
    long l = this.qGR.beginTransaction(Thread.currentThread().getId());
    try
    {
      parama = parama.invoke();
      return parama;
    }
    finally
    {
      this.qGR.endTransaction(l);
      AppMethodBeat.o(320194);
    }
  }
  
  public final String bJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(182794);
    s.u(paramString, "id");
    Object localObject = new br();
    ((br)localObject).field_pluginAppID = paramString;
    ((br)localObject).field_pluginAppVersion = paramInt;
    if (get((IAutoDBItem)localObject, new String[0])) {}
    for (localObject = ((br)localObject).field_pluginStringVersion;; localObject = null)
    {
      Log.i("Luggage.WxaPluginCodeVersionInfoStorage", "getPluginStringVersion with id:" + paramString + " version:" + paramInt + ", returns:" + localObject);
      AppMethodBeat.o(182794);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements a<Boolean>
  {
    public b(bs parambs, br parambr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bs
 * JD-Core Version:    0.7.0.1
 */