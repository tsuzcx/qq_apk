package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "removeCacheFromWx", "", "replaceContact", "", "ct", "isUpdateTime", "updateContact", "Companion", "plugin-finder_release"})
public final class ab
  extends MAutoStorage<ce>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a vEP;
  private final ISQLiteDatabase vDi;
  
  static
  {
    AppMethodBeat.i(251823);
    vEP = new a((byte)0);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderMsgContactStorage_username_index ON FinderMsgContactStorage(username)" };
    g.a locala = com.tencent.mm.plugin.finder.api.g.tsD;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.finder.api.g.access$getInfo$cp(), "FinderMsgContactStorage") };
    AppMethodBeat.o(251823);
  }
  
  public ab(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.finder.api.g.access$getInfo$cp(), "FinderMsgContactStorage", INDEX_CREATE);
    AppMethodBeat.i(251822);
    this.vDi = paramISQLiteDatabase;
    AppMethodBeat.o(251822);
  }
  
  private static void g(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(251821);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN();
    String str = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getSessionInfoStorage().avA(paramg.getUsername());
    ((bv)localObject).ayf(paramg.getUsername());
    ((bv)localObject).ayf(str);
    AppMethodBeat.o(251821);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.api.g paramg, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(251819);
    p.h(paramg, "ct");
    if (paramBoolean) {
      paramg.field_updateTime = cl.aWA();
    }
    ContentValues localContentValues;
    if (asG(paramg.getUsername()) == null)
    {
      p.h(paramg, "contact");
      localContentValues = paramg.convertTo();
      long l = this.vDi.insert("FinderContact", "", localContentValues);
      Log.i("Finder.MsgContactStorage", "insert contact " + paramg + ' ' + l);
      paramg.systemRowid = l;
      if (l > 0L) {
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        g(paramg);
        doNotify("FinderContact", 4, paramg.getUsername());
      }
      AppMethodBeat.o(251819);
      return paramBoolean;
      paramBoolean = false;
      continue;
      p.h(paramg, "contact");
      localContentValues = paramg.convertTo();
      localContentValues.remove("rowid");
      int i = this.vDi.update("FinderContact", localContentValues, "username=?", new String[] { paramg.field_username });
      Log.i("Finder.MsgContactStorage", "updateContact " + paramg.cXL() + ' ' + i);
      if (i > 0) {
        g(paramg);
      }
      paramBoolean = bool;
      if (i <= 0) {
        paramBoolean = false;
      }
    }
  }
  
  /* Error */
  public final com.tencent.mm.plugin.finder.api.g asG(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 248
    //   4: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 249
    //   10: invokestatic 92	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 184	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 251
    //   19: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 256	com/tencent/mm/storagebase/h:Fl	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 98	com/tencent/mm/plugin/finder/storage/ab:vDi	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 260 4 0
    //   45: checkcast 262	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 264	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +45 -> 102
    //   60: aload 4
    //   62: invokeinterface 268 1 0
    //   67: iconst_1
    //   68: if_icmpne +64 -> 132
    //   71: new 65	com/tencent/mm/plugin/finder/api/g
    //   74: dup
    //   75: invokespecial 269	com/tencent/mm/plugin/finder/api/g:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 273	com/tencent/mm/plugin/finder/api/g:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 279	kotlin/x:SXb	Lkotlin/x;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 284	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: ldc 248
    //   97: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: aconst_null
    //   103: astore_1
    //   104: goto -19 -> 85
    //   107: astore_2
    //   108: ldc 248
    //   110: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aload_3
    //   117: aload_2
    //   118: invokestatic 284	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   121: ldc 248
    //   123: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: goto -13 -> 116
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -49 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	ab
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE_NAME", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ab
 * JD-Core Version:    0.7.0.1
 */