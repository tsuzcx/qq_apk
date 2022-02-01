package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cf;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.api.i.a;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "removeCacheFromWx", "", "replaceContact", "", "ct", "isUpdateTime", "reportSize", "updateContact", "Companion", "plugin-finder_release"})
public final class z
  extends MAutoStorage<cf>
{
  public static final a Ame;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase AkA;
  
  static
  {
    AppMethodBeat.i(282938);
    Ame = new a((byte)0);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderMsgContactStorage_username_index ON FinderMsgContactStorage(username)" };
    i.a locala = i.xai;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.access$getInfo$cp(), "FinderMsgContactStorage") };
    AppMethodBeat.o(282938);
  }
  
  public z(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, i.access$getInfo$cp(), "FinderMsgContactStorage", INDEX_CREATE);
    AppMethodBeat.i(282937);
    this.AkA = paramISQLiteDatabase;
    AppMethodBeat.o(282937);
  }
  
  private static void h(i parami)
  {
    AppMethodBeat.i(282936);
    Object localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbL();
    String str = ((PluginFinder)h.ag(PluginFinder.class)).getSessionInfoStorage().dZ(parami.getUsername(), 3);
    ((bv)localObject).aHy(parami.getUsername());
    ((bv)localObject).aHy(str);
    AppMethodBeat.o(282936);
  }
  
  public final boolean a(i parami, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(282934);
    p.k(parami, "ct");
    if (paramBoolean) {
      parami.field_updateTime = cm.bfE();
    }
    Object localObject1;
    long l1;
    Object localObject2;
    if (aAK(parami.getUsername()) == null)
    {
      p.k(parami, "contact");
      localObject1 = parami.convertTo();
      l1 = SystemClock.uptimeMillis();
      long l2 = this.AkA.insert("FinderMsgContactStorage", "", (ContentValues)localObject1);
      localObject1 = new c.a();
      localObject2 = Thread.currentThread();
      p.j(localObject2, "Thread.currentThread()");
      localObject2 = ((Thread)localObject2).getName();
      p.j(localObject2, "Thread.currentThread().name");
      localObject1 = ((c.a)localObject1).aAY((String)localObject2).aAX("insertContact");
      ((c.a)localObject1).duration = (SystemClock.uptimeMillis() - l1);
      ((c.a)localObject1).aAW("FinderMsgStrangerContactStorage.insertContact").dpk().report();
      Log.i("Finder.MsgContactStorage", "insert contact " + parami + ' ' + l2);
      parami.systemRowid = l2;
      if (l2 > 0L) {
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        h(parami);
        doNotify("FinderMsgContactStorage", 4, parami.getUsername());
      }
      AppMethodBeat.o(282934);
      return paramBoolean;
      paramBoolean = false;
      continue;
      p.k(parami, "contact");
      localObject1 = parami.convertTo();
      ((ContentValues)localObject1).remove("rowid");
      l1 = SystemClock.uptimeMillis();
      int i = this.AkA.update("FinderMsgContactStorage", (ContentValues)localObject1, "username=?", new String[] { parami.field_username });
      localObject1 = new c.a();
      localObject2 = Thread.currentThread();
      p.j(localObject2, "Thread.currentThread()");
      localObject2 = ((Thread)localObject2).getName();
      p.j(localObject2, "Thread.currentThread().name");
      localObject1 = ((c.a)localObject1).aAY((String)localObject2).aAX("updateContact");
      ((c.a)localObject1).duration = (SystemClock.uptimeMillis() - l1);
      ((c.a)localObject1).aAW("FinderMsgStrangerContactStorage.updateContact").dpk().report();
      Log.i("Finder.MsgContactStorage", "updateContact " + parami.dnq() + ' ' + i);
      if (i > 0) {
        h(parami);
      }
      paramBoolean = bool;
      if (i <= 0) {
        paramBoolean = false;
      }
    }
  }
  
  /* Error */
  public final i aAK(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 297
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc_w 298
    //   13: invokestatic 93	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: new 231	java/lang/StringBuilder
    //   19: dup
    //   20: ldc_w 300
    //   23: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: invokestatic 306	com/tencent/mm/storagebase/h:Mi	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   41: lstore_2
    //   42: aload_0
    //   43: getfield 99	com/tencent/mm/plugin/finder/storage/z:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   46: aload 5
    //   48: aconst_null
    //   49: iconst_2
    //   50: invokeinterface 310 4 0
    //   55: astore_1
    //   56: new 187	com/tencent/mm/plugin/finder/conv/c$a
    //   59: dup
    //   60: invokespecial 189	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   63: astore 6
    //   65: invokestatic 195	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   68: astore 7
    //   70: aload 7
    //   72: ldc 197
    //   74: invokestatic 122	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   77: aload 7
    //   79: invokevirtual 200	java/lang/Thread:getName	()Ljava/lang/String;
    //   82: astore 7
    //   84: aload 7
    //   86: ldc 202
    //   88: invokestatic 122	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload 6
    //   93: aload 7
    //   95: invokevirtual 206	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   98: aload 5
    //   100: invokevirtual 210	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   103: astore 5
    //   105: aload 5
    //   107: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   110: lload_2
    //   111: lsub
    //   112: putfield 213	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   115: aload 5
    //   117: ldc_w 312
    //   120: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   123: invokevirtual 222	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   126: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   129: aload_1
    //   130: checkcast 314	java/io/Closeable
    //   133: astore 5
    //   135: aload 5
    //   137: checkcast 316	android/database/Cursor
    //   140: astore 6
    //   142: aload 6
    //   144: ifnull +47 -> 191
    //   147: aload 6
    //   149: invokeinterface 320 1 0
    //   154: iconst_1
    //   155: if_icmpne +72 -> 227
    //   158: new 66	com/tencent/mm/plugin/finder/api/i
    //   161: dup
    //   162: invokespecial 321	com/tencent/mm/plugin/finder/api/i:<init>	()V
    //   165: astore_1
    //   166: aload_1
    //   167: aload 6
    //   169: invokevirtual 325	com/tencent/mm/plugin/finder/api/i:convertFrom	(Landroid/database/Cursor;)V
    //   172: getstatic 331	kotlin/x:aazN	Lkotlin/x;
    //   175: astore 6
    //   177: aload 5
    //   179: aconst_null
    //   180: invokestatic 336	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   183: ldc_w 297
    //   186: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: areturn
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -21 -> 172
    //   196: astore 4
    //   198: ldc_w 297
    //   201: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload 4
    //   206: athrow
    //   207: astore_1
    //   208: aload 5
    //   210: aload 4
    //   212: invokestatic 336	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   215: ldc_w 297
    //   218: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: goto -16 -> 208
    //   227: aconst_null
    //   228: astore_1
    //   229: goto -57 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	z
    //   0	232	1	paramString	String
    //   41	70	2	l	long
    //   1	1	4	localObject1	Object
    //   196	15	4	localThrowable	java.lang.Throwable
    //   36	173	5	localObject2	Object
    //   63	113	6	localObject3	Object
    //   68	26	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   135	142	196	java/lang/Throwable
    //   147	172	196	java/lang/Throwable
    //   172	177	196	java/lang/Throwable
    //   198	207	207	finally
    //   135	142	223	finally
    //   147	172	223	finally
    //   172	177	223	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE_NAME", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.z
 * JD-Core Version:    0.7.0.1
 */