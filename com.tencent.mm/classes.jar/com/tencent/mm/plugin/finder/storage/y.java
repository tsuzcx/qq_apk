package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cf;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.api.i.a;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "replaceContact", "", "ct", "isUpdateTime", "reportSize", "", "updateContact", "Companion", "plugin-finder_release"})
public final class y
  extends MAutoStorage<cf>
{
  public static final a Amd;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase AkA;
  
  static
  {
    AppMethodBeat.i(249181);
    Amd = new a((byte)0);
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderMsgAliasContactStorage_username_index ON FinderMsgAliasContactStorage(username)" };
    i.a locala = i.xai;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.access$getInfo$cp(), "FinderMsgAliasContactStorage") };
    AppMethodBeat.o(249181);
  }
  
  public y(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, i.access$getInfo$cp(), "FinderMsgAliasContactStorage", INDEX_CREATE);
    AppMethodBeat.i(249177);
    this.AkA = paramISQLiteDatabase;
    AppMethodBeat.o(249177);
  }
  
  /* Error */
  public final i aAK(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 111
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 112
    //   11: invokestatic 92	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 114	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 116
    //   20: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokestatic 125	com/tencent/mm/storagebase/h:Mi	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: invokestatic 139	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore_2
    //   39: aload_0
    //   40: getfield 98	com/tencent/mm/plugin/finder/storage/y:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   43: aload 5
    //   45: aconst_null
    //   46: iconst_2
    //   47: invokeinterface 145 4 0
    //   52: astore_1
    //   53: new 147	com/tencent/mm/plugin/finder/conv/c$a
    //   56: dup
    //   57: invokespecial 149	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   60: astore 6
    //   62: invokestatic 155	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   65: astore 7
    //   67: aload 7
    //   69: ldc 157
    //   71: invokestatic 160	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   74: aload 7
    //   76: invokevirtual 163	java/lang/Thread:getName	()Ljava/lang/String;
    //   79: astore 7
    //   81: aload 7
    //   83: ldc 165
    //   85: invokestatic 160	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   88: aload 6
    //   90: aload 7
    //   92: invokevirtual 169	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   95: aload 5
    //   97: invokevirtual 172	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   100: astore 5
    //   102: aload 5
    //   104: invokestatic 139	android/os/SystemClock:uptimeMillis	()J
    //   107: lload_2
    //   108: lsub
    //   109: putfield 176	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   112: aload 5
    //   114: ldc 178
    //   116: invokevirtual 181	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   119: invokevirtual 185	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   122: invokevirtual 190	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   125: aload_1
    //   126: checkcast 192	java/io/Closeable
    //   129: astore 5
    //   131: aload 5
    //   133: checkcast 194	android/database/Cursor
    //   136: astore 6
    //   138: aload 6
    //   140: ifnull +46 -> 186
    //   143: aload 6
    //   145: invokeinterface 198 1 0
    //   150: iconst_1
    //   151: if_icmpne +69 -> 220
    //   154: new 65	com/tencent/mm/plugin/finder/api/i
    //   157: dup
    //   158: invokespecial 199	com/tencent/mm/plugin/finder/api/i:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: aload 6
    //   165: invokevirtual 203	com/tencent/mm/plugin/finder/api/i:convertFrom	(Landroid/database/Cursor;)V
    //   168: getstatic 209	kotlin/x:aazN	Lkotlin/x;
    //   171: astore 6
    //   173: aload 5
    //   175: aconst_null
    //   176: invokestatic 214	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   179: ldc 111
    //   181: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: areturn
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -20 -> 168
    //   191: astore 4
    //   193: ldc 111
    //   195: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 4
    //   200: athrow
    //   201: astore_1
    //   202: aload 5
    //   204: aload 4
    //   206: invokestatic 214	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   209: ldc 111
    //   211: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: goto -15 -> 202
    //   220: aconst_null
    //   221: astore_1
    //   222: goto -54 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	y
    //   0	225	1	paramString	String
    //   38	70	2	l	long
    //   1	1	4	localObject1	Object
    //   191	14	4	localThrowable	java.lang.Throwable
    //   33	170	5	localObject2	Object
    //   60	112	6	localObject3	Object
    //   65	26	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   131	138	191	java/lang/Throwable
    //   143	168	191	java/lang/Throwable
    //   168	173	191	java/lang/Throwable
    //   193	201	201	finally
    //   131	138	216	finally
    //   143	168	216	finally
    //   168	173	216	finally
  }
  
  public final boolean g(i parami)
  {
    boolean bool = true;
    AppMethodBeat.i(249173);
    p.k(parami, "ct");
    parami.field_updateTime = cm.bfE();
    Object localObject1;
    long l1;
    Object localObject2;
    if (aAK(parami.getUsername()) == null)
    {
      p.k(parami, "contact");
      localObject1 = parami.convertTo();
      l1 = SystemClock.uptimeMillis();
      long l2 = this.AkA.insert("FinderMsgAliasContactStorage", "", (ContentValues)localObject1);
      localObject1 = new c.a();
      localObject2 = Thread.currentThread();
      p.j(localObject2, "Thread.currentThread()");
      localObject2 = ((Thread)localObject2).getName();
      p.j(localObject2, "Thread.currentThread().name");
      localObject1 = ((c.a)localObject1).aAY((String)localObject2).aAX("insertContact");
      ((c.a)localObject1).duration = (SystemClock.uptimeMillis() - l1);
      ((c.a)localObject1).aAW("FinderMsgAliasContactStorage.insertContact").dpk().report();
      Log.i("Finder.FinderMsgAliasContactStorage", "insert contact " + parami + ' ' + l2);
      parami.systemRowid = l2;
      if (l2 <= 0L) {}
    }
    for (;;)
    {
      if (bool) {
        doNotify("FinderMsgAliasContactStorage", 4, parami.getUsername());
      }
      AppMethodBeat.o(249173);
      return bool;
      bool = false;
      continue;
      p.k(parami, "contact");
      localObject1 = parami.convertTo();
      ((ContentValues)localObject1).remove("rowid");
      l1 = SystemClock.uptimeMillis();
      int i = this.AkA.update("FinderMsgAliasContactStorage", (ContentValues)localObject1, "username=?", new String[] { parami.field_username });
      localObject1 = new c.a();
      localObject2 = Thread.currentThread();
      p.j(localObject2, "Thread.currentThread()");
      localObject2 = ((Thread)localObject2).getName();
      p.j(localObject2, "Thread.currentThread().name");
      localObject1 = ((c.a)localObject1).aAY((String)localObject2).aAX("updateContact");
      ((c.a)localObject1).duration = (SystemClock.uptimeMillis() - l1);
      ((c.a)localObject1).aAW("FinderMsgAliasContactStorage.updateContact").dpk().report();
      Log.i("Finder.FinderMsgAliasContactStorage", "updateContact " + parami.dnq() + ' ' + i);
      if (i <= 0) {
        bool = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMsgAliasContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "TABLE_NAME", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.y
 * JD-Core Version:    0.7.0.1
 */