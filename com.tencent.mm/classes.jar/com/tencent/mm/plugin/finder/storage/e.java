package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cf;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.api.i.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "", "insertContact", "", "contact", "replaceContactInDB", "", "ct", "reportSize", "", "updateContact", "Companion", "plugin-finder-base_release"})
public final class e
  extends MAutoStorage<cf>
{
  public static final a AkB;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase AkA;
  
  static
  {
    AppMethodBeat.i(166958);
    AkB = new a((byte)0);
    Object localObject = i.xai;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.access$getInfo$cp(), "FinderContact") };
    localObject = cf.INDEX_CREATE;
    p.j(localObject, "BaseFinderContact.INDEX_CREATE");
    localObject = kotlin.a.e.ab((Object[])localObject);
    ((List)localObject).add(0, "DROP INDEX username_index");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(166958);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(166958);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, i.access$getInfo$cp(), "FinderContact", INDEX_CREATE);
    AppMethodBeat.i(166957);
    this.AkA = paramISQLiteDatabase;
    AppMethodBeat.o(166957);
  }
  
  /* Error */
  public final i aAK(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 138
    //   5: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 139
    //   11: invokestatic 125	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 141	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 143
    //   20: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokestatic 150	com/tencent/mm/storagebase/h:Mi	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: invokestatic 164	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore_2
    //   39: aload_0
    //   40: getfield 131	com/tencent/mm/plugin/finder/storage/e:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   43: aload 5
    //   45: aconst_null
    //   46: iconst_2
    //   47: invokeinterface 170 4 0
    //   52: astore_1
    //   53: new 172	com/tencent/mm/plugin/finder/conv/c$a
    //   56: dup
    //   57: invokespecial 174	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   60: astore 6
    //   62: invokestatic 180	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   65: astore 7
    //   67: aload 7
    //   69: ldc 182
    //   71: invokestatic 88	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   74: aload 7
    //   76: invokevirtual 185	java/lang/Thread:getName	()Ljava/lang/String;
    //   79: astore 7
    //   81: aload 7
    //   83: ldc 187
    //   85: invokestatic 88	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   88: aload 6
    //   90: aload 7
    //   92: invokevirtual 191	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   95: aload 5
    //   97: invokevirtual 194	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   100: astore 5
    //   102: aload 5
    //   104: invokestatic 164	android/os/SystemClock:uptimeMillis	()J
    //   107: lload_2
    //   108: lsub
    //   109: putfield 198	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   112: aload 5
    //   114: ldc 200
    //   116: invokevirtual 203	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   119: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   122: invokevirtual 212	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   125: aload_1
    //   126: checkcast 214	java/io/Closeable
    //   129: astore 5
    //   131: aload 5
    //   133: checkcast 216	android/database/Cursor
    //   136: astore 6
    //   138: aload 6
    //   140: ifnull +46 -> 186
    //   143: aload 6
    //   145: invokeinterface 220 1 0
    //   150: iconst_1
    //   151: if_icmpne +69 -> 220
    //   154: new 58	com/tencent/mm/plugin/finder/api/i
    //   157: dup
    //   158: invokespecial 221	com/tencent/mm/plugin/finder/api/i:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: aload 6
    //   165: invokevirtual 225	com/tencent/mm/plugin/finder/api/i:convertFrom	(Landroid/database/Cursor;)V
    //   168: getstatic 231	kotlin/x:aazN	Lkotlin/x;
    //   171: astore 6
    //   173: aload 5
    //   175: aconst_null
    //   176: invokestatic 236	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   179: ldc 138
    //   181: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: areturn
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -20 -> 168
    //   191: astore 4
    //   193: ldc 138
    //   195: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 4
    //   200: athrow
    //   201: astore_1
    //   202: aload 5
    //   204: aload 4
    //   206: invokestatic 236	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   209: ldc 138
    //   211: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: goto -15 -> 202
    //   220: aconst_null
    //   221: astore_1
    //   222: goto -54 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	e
    //   0	225	1	paramString	String
    //   38	70	2	l	long
    //   1	1	4	localObject1	Object
    //   191	14	4	localThrowable	Throwable
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderContactStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "getSQL_CREATE", "TAG", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.e
 * JD-Core Version:    0.7.0.1
 */