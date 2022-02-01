package com.tencent.mm.plugin.finder.uniComments.storge;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abj;
import com.tencent.mm.autogen.b.hz;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.wcdb.database.SQLiteException;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/UniActionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniAction;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "DB_SELECT", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanCanRemoveFeed", "", "getAllFailedCommentFeedIds", "", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniActionStorage$FeedAndNonceId;", "getAllFailedCommentsByFeedId", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "feedId", "", "getAllUnsentCommentsByFeedId", "getByLocalCommentId", "localCommentId", "getRecentAction", "actionType", "", "insertNewAction", "action", "markUnsentCommentsCanRemove", "postEvent", "commentId", "opType", "commentInfo", "removeUnsentComment", "", "removeUnsentCommentByFeedId", "feedid", "testDB", "sql", "updateByLocal", "comment", "notify", "Companion", "FeedAndNonceId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MAutoStorage<a>
{
  private static final int FAo;
  private static final int FAp;
  private static final int FAq;
  public static final a Gbn;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TABLE_NAME;
  private static final String TAG;
  private final String FAn;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(341719);
    Gbn = new a((byte)0);
    TAG = "MicroMsg.MusicUni.UniActionStorage";
    FAo = 1;
    FAp = 2;
    FAq = 3;
    Object localObject = a.Gbl;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "UniAction") };
    TABLE_NAME = "UniAction";
    localObject = hz.INDEX_CREATE;
    s.s(localObject, "INDEX_CREATE");
    localObject = k.af((Object[])localObject);
    StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    a.a locala = a.Gbl;
    ((List)localObject).add(a.eZG() + " ON " + TABLE_NAME + " ( actionType,state,postTime )");
    localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    locala = a.Gbl;
    ((List)localObject).add(a.eZH() + " ON " + TABLE_NAME + " (actionType,feedId, postTime)");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(341719);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(341719);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "UniAction", INDEX_CREATE);
    AppMethodBeat.i(341690);
    this.db = paramISQLiteDatabase;
    this.FAn = "SELECT * FROM UniAction";
    AppMethodBeat.o(341690);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, b paramb)
  {
    AppMethodBeat.i(341697);
    abj localabj = new abj();
    localabj.ieX.feedId = paramLong1;
    localabj.ieX.commentId = paramLong2;
    localabj.ieX.hJY = paramLong3;
    localabj.ieX.opType = paramInt;
    localabj.ieX.ieY = ((hz)paramb);
    Log.i(TAG, "postEvent, feedId:" + paramLong1 + ", commentId:" + paramLong2 + ", localId:" + paramLong3 + ", opType:" + paramInt);
    localabj.publish();
    AppMethodBeat.o(341697);
  }
  
  public final boolean a(long paramLong, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(341765);
    s.u(paramb, "comment");
    ContentValues localContentValues = paramb.convertTo();
    localContentValues.remove("rowid");
    if (this.db.update("UniAction", localContentValues, "localCommentId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = FAq;
      if (paramBoolean) {
        a(paramb.field_feedId, paramb.eZI().commentId, paramb.field_localCommentId, i, paramb);
      }
      AppMethodBeat.o(341765);
      return bool;
    }
  }
  
  public final long d(b paramb)
  {
    AppMethodBeat.i(341739);
    s.u(paramb, "action");
    long l1 = com.tencent.mm.kernel.h.baE().ban().a(at.a.acZQ, 1L);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acZQ, Long.valueOf(1L + l1));
    paramb.field_localCommentId = l1;
    ContentValues localContentValues = paramb.convertTo();
    long l2 = this.db.insert("UniAction", "localCommentId", localContentValues);
    Log.i(TAG, "new feed action rowId " + l2 + ' ' + com.tencent.mm.ae.f.dg(paramb) + " localID: " + l1);
    a(paramb.field_feedId, paramb.eZI().commentId, paramb.field_localCommentId, FAq, paramb);
    AppMethodBeat.o(341739);
    return l1;
  }
  
  public final b fdP()
  {
    AppMethodBeat.i(341728);
    Object localObject1 = new com.tencent.mm.ae.c("getRecentAction");
    localObject3 = this.FAn + " WHERE actionType = 1 and state == 1 ORDER BY postTime DESC limit 1";
    Object localObject4 = this.db.rawQuery((String)localObject3, null, 2);
    Log.i(TAG, "getRecentAction " + localObject1 + ' ' + (String)localObject3);
    localObject3 = (Closeable)localObject4;
    try
    {
      if (!((Cursor)localObject4).moveToFirst()) {
        break label175;
      }
      do
      {
        localObject1 = new b();
        ((b)localObject1).convertFrom((Cursor)localObject4);
      } while (((Cursor)localObject4).moveToNext());
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(341728);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject3, localThrowable);
          AppMethodBeat.o(341728);
        }
        Object localObject2 = null;
      }
    }
    localObject4 = ah.aiuX;
    kotlin.f.b.a((Closeable)localObject3, null);
    Log.i(TAG, s.X("getRecentAction ", localObject1));
    AppMethodBeat.o(341728);
    return localObject1;
  }
  
  public final List<b> pU(long paramLong)
  {
    AppMethodBeat.i(341750);
    Object localObject1 = this.FAn + " WHERE actionType = 1 and feedId = " + paramLong + " ORDER BY postTime DESC";
    Object localObject2 = this.db.rawQuery((String)localObject1, null, 2);
    Log.i(TAG, "getAllUnsentCommentsByFeedId " + paramLong + ' ' + (String)localObject1);
    LinkedList localLinkedList = new LinkedList();
    localObject1 = (Closeable)localObject2;
    try
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          b localb = new b();
          localb.convertFrom((Cursor)localObject2);
          localLinkedList.add(localb);
        } while (((Cursor)localObject2).moveToNext());
      }
      localObject2 = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      localObject1 = (List)localLinkedList;
      AppMethodBeat.o(341750);
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(341750);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(341750);
      }
    }
  }
  
  public final boolean pW(long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(341757);
    if (this.db.delete("UniAction", "localCommentId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0) {}
    for (;;)
    {
      Log.i(TAG, "removeUnsentComment " + paramLong + " ret:" + bool);
      AppMethodBeat.o(341757);
      return bool;
      bool = false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/storge/UniActionStorage$Companion;", "", "()V", "ACTION_TYPE_COMMENT", "", "ACTION_TYPE_LIKE", "ACTION_TYPE_LIKE_COMMENT", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "OpType_Add", "getOpType_Add", "()I", "OpType_Del", "getOpType_Del", "OpType_Mod", "getOpType_Mod", "SQL_CREATE", "getSQL_CREATE", "TABLE_NAME", "TAG", "getTAG", "()Ljava/lang/String;", "realStorage", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniActionStorage;", "getRealStorage", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/UniActionStorage;", "collectUniDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStorage", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static c fdQ()
    {
      AppMethodBeat.i(341692);
      Object localObject1 = new com.tencent.mm.storagebase.h();
      Object localObject2 = s.X(com.tencent.mm.kernel.h.baE().cachePath, "UniComment.db");
      a locala = c.Gbn;
      if (!((com.tencent.mm.storagebase.h)localObject1).a((String)localObject2, fdR(), true))
      {
        localObject1 = new SQLiteException("db init failed");
        AppMethodBeat.o(341692);
        throw ((Throwable)localObject1);
      }
      localObject2 = ah.aiuX;
      localObject1 = new c((ISQLiteDatabase)localObject1);
      AppMethodBeat.o(341692);
      return localObject1;
    }
    
    private static HashMap<Integer, h.b> fdR()
    {
      AppMethodBeat.i(341699);
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put(Integer.valueOf(c.TABLE_NAME.hashCode()), c.a..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(341699);
      return localHashMap;
    }
    
    private static final String[] fdS()
    {
      AppMethodBeat.i(341705);
      Object localObject = c.Gbn;
      localObject = c.dZh();
      AppMethodBeat.o(341705);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.storge.c
 * JD-Core Version:    0.7.0.1
 */