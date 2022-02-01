package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.a.ib;
import com.tencent.mm.f.c.ce;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "DB_SELECT", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanCanRemoveFeed", "", "getAllFailedCommentFeedIds", "", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$FeedAndNonceId;", "getAllFailedCommentsByFeedId", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "feedId", "", "getAllUnsentCommentsByFeedId", "getByLocalCommentId", "localCommentId", "getRecentAction", "actionType", "", "insertNewAction", "action", "markUnsentCommentsCanRemove", "postEvent", "commentId", "opType", "commentInfo", "removeUnsentComment", "", "removeUnsentCommentByFeedId", "feedid", "testDB", "sql", "updateByLocal", "comment", "notify", "Companion", "FeedAndNonceId", "plugin-finder_release"})
public final class a
  extends MAutoStorage<al>
{
  private static final int AdM = 1;
  private static final int AdN = 2;
  private static final int AdO = 3;
  public static final a AdP;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TAG = "Finder.FinderActionStorage";
  private final String AdL;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(166896);
    AdP = new a((byte)0);
    TAG = "Finder.FinderActionStorage";
    AdM = 1;
    AdN = 2;
    AdO = 3;
    Object localObject = al.AmK;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(al.access$getInfo$cp(), "FinderAction") };
    localObject = ce.INDEX_CREATE;
    p.j(localObject, "BaseFinderAction.INDEX_CREATE");
    localObject = e.ab((Object[])localObject);
    StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    al.a locala = al.AmK;
    ((List)localObject).add(al.dYW() + " ON FinderAction ( actionType,state,postTime )");
    localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    locala = al.AmK;
    ((List)localObject).add(al.dYX() + " ON FinderAction (actionType,feedId, postTime)");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(166896);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(166896);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, al.access$getInfo$cp(), "FinderAction", INDEX_CREATE);
    AppMethodBeat.i(166895);
    this.db = paramISQLiteDatabase;
    this.AdL = "SELECT * FROM FinderAction";
    AppMethodBeat.o(166895);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, am paramam)
  {
    AppMethodBeat.i(166894);
    ib localib = new ib();
    localib.fFf.feedId = paramLong1;
    localib.fFf.commentId = paramLong2;
    localib.fFf.fFg = paramLong3;
    localib.fFf.opType = paramInt;
    localib.fFf.fFh = ((ce)paramam);
    Log.i(TAG, "postEvent, feedId:" + paramLong1 + ", commentId:" + paramLong2 + ", localId:" + paramLong3 + ", opType:" + paramInt);
    EventCenter.instance.publish((IEvent)localib);
    AppMethodBeat.o(166894);
  }
  
  /* Error */
  public final List<am> MC(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 267
    //   6: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 135	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: getfield 195	com/tencent/mm/plugin/finder/storage/a:AdL	Ljava/lang/String;
    //   20: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 270
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_1
    //   30: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 272
    //   36: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload_0
    //   45: getfield 191	com/tencent/mm/plugin/finder/storage/a:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   48: aload 5
    //   50: aconst_null
    //   51: iconst_2
    //   52: invokeinterface 278 4 0
    //   57: astore_3
    //   58: getstatic 89	com/tencent/mm/plugin/finder/storage/a:TAG	Ljava/lang/String;
    //   61: new 135	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 280
    //   68: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: lload_1
    //   72: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   75: bipush 32
    //   77: invokevirtual 283	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   80: aload 5
    //   82: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: new 285	java/util/LinkedList
    //   94: dup
    //   95: invokespecial 286	java/util/LinkedList:<init>	()V
    //   98: astore 6
    //   100: aload_3
    //   101: checkcast 288	java/io/Closeable
    //   104: astore 5
    //   106: aload_3
    //   107: invokeinterface 294 1 0
    //   112: ifeq +35 -> 147
    //   115: new 296	com/tencent/mm/plugin/finder/storage/am
    //   118: dup
    //   119: invokespecial 297	com/tencent/mm/plugin/finder/storage/am:<init>	()V
    //   122: astore 7
    //   124: aload 7
    //   126: aload_3
    //   127: invokevirtual 301	com/tencent/mm/plugin/finder/storage/am:convertFrom	(Landroid/database/Cursor;)V
    //   130: aload 6
    //   132: aload 7
    //   134: invokevirtual 302	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: aload_3
    //   139: invokeinterface 305 1 0
    //   144: ifne -29 -> 115
    //   147: getstatic 311	kotlin/x:aazN	Lkotlin/x;
    //   150: astore_3
    //   151: aload 5
    //   153: aconst_null
    //   154: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   157: aload 6
    //   159: checkcast 155	java/util/List
    //   162: astore_3
    //   163: ldc_w 267
    //   166: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_3
    //   170: areturn
    //   171: astore 4
    //   173: ldc_w 267
    //   176: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 4
    //   181: athrow
    //   182: astore_3
    //   183: aload 5
    //   185: aload 4
    //   187: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   190: ldc_w 267
    //   193: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_3
    //   197: athrow
    //   198: astore_3
    //   199: goto -16 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	a
    //   0	202	1	paramLong	long
    //   57	113	3	localObject1	Object
    //   182	15	3	localObject2	Object
    //   198	1	3	localObject3	Object
    //   1	1	4	localObject4	Object
    //   171	15	4	localThrowable	Throwable
    //   42	142	5	localObject5	Object
    //   98	60	6	localLinkedList	java.util.LinkedList
    //   122	11	7	localam	am
    // Exception table:
    //   from	to	target	type
    //   106	115	171	java/lang/Throwable
    //   115	147	171	java/lang/Throwable
    //   147	151	171	java/lang/Throwable
    //   173	182	182	finally
    //   106	115	198	finally
    //   115	147	198	finally
    //   147	151	198	finally
  }
  
  /* Error */
  public final List<am> MD(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 320
    //   6: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 135	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: getfield 195	com/tencent/mm/plugin/finder/storage/a:AdL	Ljava/lang/String;
    //   20: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 270
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_1
    //   30: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 322
    //   36: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 191	com/tencent/mm/plugin/finder/storage/a:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   47: aload_3
    //   48: aconst_null
    //   49: iconst_2
    //   50: invokeinterface 278 4 0
    //   55: astore 7
    //   57: new 285	java/util/LinkedList
    //   60: dup
    //   61: invokespecial 286	java/util/LinkedList:<init>	()V
    //   64: astore 6
    //   66: aload 7
    //   68: checkcast 288	java/io/Closeable
    //   71: astore 5
    //   73: aload 7
    //   75: invokeinterface 294 1 0
    //   80: ifeq +37 -> 117
    //   83: new 296	com/tencent/mm/plugin/finder/storage/am
    //   86: dup
    //   87: invokespecial 297	com/tencent/mm/plugin/finder/storage/am:<init>	()V
    //   90: astore 8
    //   92: aload 8
    //   94: aload 7
    //   96: invokevirtual 301	com/tencent/mm/plugin/finder/storage/am:convertFrom	(Landroid/database/Cursor;)V
    //   99: aload 6
    //   101: aload 8
    //   103: invokevirtual 302	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload 7
    //   109: invokeinterface 305 1 0
    //   114: ifne -31 -> 83
    //   117: getstatic 311	kotlin/x:aazN	Lkotlin/x;
    //   120: astore 7
    //   122: aload 5
    //   124: aconst_null
    //   125: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   128: getstatic 89	com/tencent/mm/plugin/finder/storage/a:TAG	Ljava/lang/String;
    //   131: new 135	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 324
    //   138: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: lload_1
    //   142: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: bipush 32
    //   147: invokevirtual 283	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   150: aload_3
    //   151: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 326
    //   157: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 6
    //   162: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 6
    //   173: checkcast 155	java/util/List
    //   176: astore_3
    //   177: ldc_w 320
    //   180: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_3
    //   184: areturn
    //   185: astore 4
    //   187: ldc_w 320
    //   190: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload 4
    //   195: athrow
    //   196: astore_3
    //   197: aload 5
    //   199: aload 4
    //   201: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   204: ldc_w 320
    //   207: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_3
    //   211: athrow
    //   212: astore_3
    //   213: goto -16 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	a
    //   0	216	1	paramLong	long
    //   42	142	3	localObject1	Object
    //   196	15	3	localObject2	Object
    //   212	1	3	localObject3	Object
    //   1	1	4	localObject4	Object
    //   185	15	4	localThrowable	Throwable
    //   71	127	5	localCloseable	java.io.Closeable
    //   64	108	6	localLinkedList	java.util.LinkedList
    //   55	66	7	localObject5	Object
    //   90	12	8	localam	am
    // Exception table:
    //   from	to	target	type
    //   73	83	185	java/lang/Throwable
    //   83	117	185	java/lang/Throwable
    //   117	122	185	java/lang/Throwable
    //   187	196	196	finally
    //   73	83	212	finally
    //   83	117	212	finally
    //   117	122	212	finally
  }
  
  /* Error */
  public final am ME(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 332
    //   6: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 135	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: getfield 195	com/tencent/mm/plugin/finder/storage/a:AdL	Ljava/lang/String;
    //   20: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 334
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_1
    //   30: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: aload_0
    //   39: getfield 191	com/tencent/mm/plugin/finder/storage/a:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   42: aload 5
    //   44: aconst_null
    //   45: iconst_2
    //   46: invokeinterface 278 4 0
    //   51: astore_3
    //   52: getstatic 89	com/tencent/mm/plugin/finder/storage/a:TAG	Ljava/lang/String;
    //   55: new 135	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 336
    //   62: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload 5
    //   67: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: bipush 32
    //   72: invokevirtual 283	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: lload_1
    //   76: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_3
    //   86: checkcast 288	java/io/Closeable
    //   89: astore 5
    //   91: aload_3
    //   92: invokeinterface 294 1 0
    //   97: ifeq +23 -> 120
    //   100: new 296	com/tencent/mm/plugin/finder/storage/am
    //   103: dup
    //   104: invokespecial 297	com/tencent/mm/plugin/finder/storage/am:<init>	()V
    //   107: aload_3
    //   108: invokevirtual 301	com/tencent/mm/plugin/finder/storage/am:convertFrom	(Landroid/database/Cursor;)V
    //   111: aload_3
    //   112: invokeinterface 305 1 0
    //   117: ifne -17 -> 100
    //   120: getstatic 311	kotlin/x:aazN	Lkotlin/x;
    //   123: astore_3
    //   124: aload 5
    //   126: aconst_null
    //   127: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   130: ldc_w 332
    //   133: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore 4
    //   140: ldc_w 332
    //   143: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 4
    //   148: athrow
    //   149: astore_3
    //   150: aload 5
    //   152: aload 4
    //   154: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   157: ldc_w 332
    //   160: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_3
    //   164: athrow
    //   165: astore_3
    //   166: goto -16 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	a
    //   0	169	1	paramLong	long
    //   51	73	3	localObject1	Object
    //   149	15	3	localObject2	Object
    //   165	1	3	localObject3	Object
    //   1	1	4	localObject4	Object
    //   138	15	4	localThrowable	Throwable
    //   36	115	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   91	100	138	java/lang/Throwable
    //   100	120	138	java/lang/Throwable
    //   120	124	138	java/lang/Throwable
    //   140	149	149	finally
    //   91	100	165	finally
    //   100	120	165	finally
    //   120	124	165	finally
  }
  
  public final boolean MF(long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(166891);
    if (this.db.delete("FinderAction", "localCommentId=?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (;;)
    {
      Log.i(TAG, "removeUnsentComment " + paramLong + " ret:" + bool);
      AppMethodBeat.o(166891);
      return bool;
      bool = false;
    }
  }
  
  public final long a(am paramam)
  {
    AppMethodBeat.i(166886);
    p.k(paramam, "action");
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    long l1 = ((f)localObject).aHp().a(ar.a.VxW, 1L);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((f)localObject).aHp().set(ar.a.VxW, Long.valueOf(1L + l1));
    paramam.field_localCommentId = l1;
    localObject = paramam.convertTo();
    long l2 = this.db.insert("FinderAction", "localCommentId", (ContentValues)localObject);
    Log.i(TAG, "new feed action rowId " + l2 + ' ' + g.bN(paramam) + " localID: " + l1);
    a(paramam.field_feedId, paramam.dYY().commentId, paramam.field_localCommentId, AdO, paramam);
    AppMethodBeat.o(166886);
    return l1;
  }
  
  public final boolean a(long paramLong, am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(166892);
    p.k(paramam, "comment");
    ContentValues localContentValues = paramam.convertTo();
    localContentValues.remove("rowid");
    if (this.db.update("FinderAction", localContentValues, "localCommentId=?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = AdO;
      if (paramBoolean) {
        a(paramam.field_feedId, paramam.dYY().commentId, paramam.field_localCommentId, i, paramam);
      }
      AppMethodBeat.o(166892);
      return bool;
    }
  }
  
  /* Error */
  public final am dRs()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 443
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 445	com/tencent/mm/ae/c
    //   11: dup
    //   12: ldc_w 446
    //   15: invokespecial 447	com/tencent/mm/ae/c:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: new 135	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: getfield 195	com/tencent/mm/plugin/finder/storage/a:AdL	Ljava/lang/String;
    //   30: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 449
    //   36: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 191	com/tencent/mm/plugin/finder/storage/a:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   47: aload_3
    //   48: aconst_null
    //   49: iconst_2
    //   50: invokeinterface 278 4 0
    //   55: astore 4
    //   57: getstatic 89	com/tencent/mm/plugin/finder/storage/a:TAG	Ljava/lang/String;
    //   60: new 135	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 451
    //   67: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: bipush 32
    //   76: invokevirtual 283	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 4
    //   91: checkcast 288	java/io/Closeable
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 294 1 0
    //   102: ifeq +88 -> 190
    //   105: new 296	com/tencent/mm/plugin/finder/storage/am
    //   108: dup
    //   109: invokespecial 297	com/tencent/mm/plugin/finder/storage/am:<init>	()V
    //   112: astore_1
    //   113: aload_1
    //   114: aload 4
    //   116: invokevirtual 301	com/tencent/mm/plugin/finder/storage/am:convertFrom	(Landroid/database/Cursor;)V
    //   119: aload 4
    //   121: invokeinterface 305 1 0
    //   126: ifne -21 -> 105
    //   129: getstatic 311	kotlin/x:aazN	Lkotlin/x;
    //   132: astore 4
    //   134: aload_3
    //   135: aconst_null
    //   136: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   139: getstatic 89	com/tencent/mm/plugin/finder/storage/a:TAG	Ljava/lang/String;
    //   142: ldc_w 451
    //   145: aload_1
    //   146: invokestatic 454	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   149: invokevirtual 458	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: ldc_w 443
    //   158: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: areturn
    //   163: astore_2
    //   164: ldc_w 443
    //   167: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_2
    //   171: athrow
    //   172: astore_1
    //   173: aload_3
    //   174: aload_2
    //   175: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   178: ldc_w 443
    //   181: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: goto -14 -> 173
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -63 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	a
    //   18	144	1	localObject1	Object
    //   172	13	1	localObject2	Object
    //   186	1	1	localObject3	Object
    //   191	1	1	localObject4	Object
    //   1	1	2	localObject5	Object
    //   163	12	2	localThrowable	Throwable
    //   42	132	3	localObject6	Object
    //   55	78	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   95	105	163	java/lang/Throwable
    //   105	129	163	java/lang/Throwable
    //   129	134	163	java/lang/Throwable
    //   164	172	172	finally
    //   95	105	186	finally
    //   105	129	186	finally
    //   129	134	186	finally
  }
  
  /* Error */
  public final List<a.b> dRt()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 461
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 135	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: getfield 195	com/tencent/mm/plugin/finder/storage/a:AdL	Ljava/lang/String;
    //   19: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 463
    //   25: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 191	com/tencent/mm/plugin/finder/storage/a:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   36: aload_1
    //   37: aconst_null
    //   38: iconst_2
    //   39: invokeinterface 278 4 0
    //   44: astore 5
    //   46: new 285	java/util/LinkedList
    //   49: dup
    //   50: invokespecial 286	java/util/LinkedList:<init>	()V
    //   53: astore 4
    //   55: aload 5
    //   57: checkcast 288	java/io/Closeable
    //   60: astore_3
    //   61: aload 5
    //   63: invokeinterface 294 1 0
    //   68: ifeq +52 -> 120
    //   71: new 296	com/tencent/mm/plugin/finder/storage/am
    //   74: dup
    //   75: invokespecial 297	com/tencent/mm/plugin/finder/storage/am:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: aload 5
    //   84: invokevirtual 301	com/tencent/mm/plugin/finder/storage/am:convertFrom	(Landroid/database/Cursor;)V
    //   87: aload 4
    //   89: new 10	com/tencent/mm/plugin/finder/storage/a$b
    //   92: dup
    //   93: aload 6
    //   95: getfield 418	com/tencent/mm/plugin/finder/storage/am:field_feedId	J
    //   98: aload 6
    //   100: invokevirtual 466	com/tencent/mm/plugin/finder/storage/am:getObjectNonceId	()Ljava/lang/String;
    //   103: invokespecial 469	com/tencent/mm/plugin/finder/storage/a$b:<init>	(JLjava/lang/String;)V
    //   106: invokevirtual 302	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: aload 5
    //   112: invokeinterface 305 1 0
    //   117: ifne -46 -> 71
    //   120: getstatic 311	kotlin/x:aazN	Lkotlin/x;
    //   123: astore 5
    //   125: aload_3
    //   126: aconst_null
    //   127: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   130: getstatic 89	com/tencent/mm/plugin/finder/storage/a:TAG	Ljava/lang/String;
    //   133: new 135	java/lang/StringBuilder
    //   136: dup
    //   137: ldc_w 471
    //   140: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 473
    //   150: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 476	java/util/LinkedList:size	()I
    //   158: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 4
    //   169: checkcast 155	java/util/List
    //   172: astore_1
    //   173: ldc_w 461
    //   176: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: areturn
    //   181: astore_2
    //   182: ldc_w 461
    //   185: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_3
    //   192: aload_2
    //   193: invokestatic 316	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   196: ldc_w 461
    //   199: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: goto -14 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	a
    //   31	149	1	localObject1	Object
    //   190	13	1	localObject2	Object
    //   204	1	1	localObject3	Object
    //   1	1	2	localObject4	Object
    //   181	12	2	localThrowable	Throwable
    //   60	132	3	localCloseable	java.io.Closeable
    //   53	115	4	localLinkedList	java.util.LinkedList
    //   44	80	5	localObject5	Object
    //   78	21	6	localam	am
    // Exception table:
    //   from	to	target	type
    //   61	71	181	java/lang/Throwable
    //   71	120	181	java/lang/Throwable
    //   120	125	181	java/lang/Throwable
    //   182	190	190	finally
    //   61	71	204	finally
    //   71	120	204	finally
    //   120	125	204	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$Companion;", "", "()V", "ACTION_TYPE_COMMENT", "", "ACTION_TYPE_LIKE", "ACTION_TYPE_LIKE_COMMENT", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "OpType_Add", "getOpType_Add", "()I", "OpType_Del", "getOpType_Del", "OpType_Mod", "getOpType_Mod", "SQL_CREATE", "getSQL_CREATE", "TABLE_NAME", "TAG", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.a
 * JD-Core Version:    0.7.0.1
 */