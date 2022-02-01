package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.autogen.a.im;
import com.tencent.mm.autogen.b.ch;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderAction;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "DB_SELECT", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanCanRemoveFeed", "", "getAllFailedCommentFeedIds", "", "Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$FeedAndNonceId;", "getAllFailedCommentsByFeedId", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "feedId", "", "getAllUnsentCommentsByFeedId", "getByLocalCommentId", "localCommentId", "getRecentAction", "actionType", "", "insertNewAction", "action", "markUnsentCommentsCanRemove", "postEvent", "commentId", "opType", "commentInfo", "removeUnsentComment", "", "removeUnsentCommentByFeedId", "feedid", "testDB", "sql", "updateByLocal", "comment", "notify", "Companion", "FeedAndNonceId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MAutoStorage<at>
{
  public static final a FAm;
  private static final int FAo;
  private static final int FAp;
  private static final int FAq;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final String TAG;
  private final String FAn;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(166896);
    FAm = new a((byte)0);
    TAG = "Finder.FinderActionStorage";
    FAo = 1;
    FAp = 2;
    FAq = 3;
    Object localObject = at.FMA;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(at.access$getInfo$cp(), "FinderAction") };
    localObject = ch.INDEX_CREATE;
    s.s(localObject, "INDEX_CREATE");
    localObject = k.af((Object[])localObject);
    StringBuilder localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    at.a locala = at.FMA;
    ((List)localObject).add(at.eZG() + " ON FinderAction ( actionType,state,postTime )");
    localStringBuilder = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    locala = at.FMA;
    ((List)localObject).add(at.eZH() + " ON FinderAction (actionType,feedId, postTime)");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(166896);
      throw ((Throwable)localObject);
    }
    INDEX_CREATE = (String[])localObject;
    AppMethodBeat.o(166896);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, at.access$getInfo$cp(), "FinderAction", INDEX_CREATE);
    AppMethodBeat.i(166895);
    this.db = paramISQLiteDatabase;
    this.FAn = "SELECT * FROM FinderAction";
    AppMethodBeat.o(166895);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3, int paramInt, au paramau)
  {
    AppMethodBeat.i(166894);
    im localim = new im();
    localim.hJX.feedId = paramLong1;
    localim.hJX.commentId = paramLong2;
    localim.hJX.hJY = paramLong3;
    localim.hJX.opType = paramInt;
    localim.hJX.hJZ = ((ch)paramau);
    Log.i(TAG, "postEvent, feedId:" + paramLong1 + ", commentId:" + paramLong2 + ", localId:" + paramLong3 + ", opType:" + paramInt);
    localim.publish();
    AppMethodBeat.o(166894);
  }
  
  private List<au> pV(long paramLong)
  {
    AppMethodBeat.i(166888);
    String str = this.FAn + " WHERE actionType = 1 and feedId = " + paramLong + " and state = -1 ORDER BY postTime DESC";
    Object localObject3 = this.db.rawQuery(str, null, 2);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Closeable)localObject3;
    try
    {
      if (((Cursor)localObject3).moveToFirst()) {
        do
        {
          au localau = new au();
          localau.convertFrom((Cursor)localObject3);
          localLinkedList.add(localau);
        } while (((Cursor)localObject3).moveToNext());
      }
      localObject3 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      Log.i(TAG, "getAllFailedCommentsByFeedId " + paramLong + ' ' + str + " listsize:" + localLinkedList);
      localObject1 = (List)localLinkedList;
      AppMethodBeat.o(166888);
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(166888);
        throw localThrowable;
      }
      finally
      {
        b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(166888);
      }
    }
  }
  
  public final boolean a(long paramLong, au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(166892);
    s.u(paramau, "comment");
    ContentValues localContentValues = paramau.convertTo();
    localContentValues.remove("rowid");
    if (this.db.update("FinderAction", localContentValues, "localCommentId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = FAq;
      if (paramBoolean) {
        a(paramau.field_feedId, paramau.eZI().commentId, paramau.field_localCommentId, i, paramau);
      }
      AppMethodBeat.o(166892);
      return bool;
    }
  }
  
  public final long c(au paramau)
  {
    AppMethodBeat.i(166886);
    s.u(paramau, "action");
    long l1 = h.baE().ban().a(com.tencent.mm.storage.at.a.acZP, 1L);
    h.baE().ban().set(com.tencent.mm.storage.at.a.acZP, Long.valueOf(1L + l1));
    paramau.field_localCommentId = l1;
    ContentValues localContentValues = paramau.convertTo();
    long l2 = this.db.insert("FinderAction", "localCommentId", localContentValues);
    Log.i(TAG, "new feed action rowId " + l2 + ' ' + com.tencent.mm.ae.f.dg(paramau) + " localID: " + l1);
    a(paramau.field_feedId, paramau.eZI().commentId, paramau.field_localCommentId, FAq, paramau);
    AppMethodBeat.o(166886);
    return l1;
  }
  
  public final au ePF()
  {
    AppMethodBeat.i(166885);
    Object localObject1 = new c("getRecentAction");
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
        localObject1 = new au();
        ((au)localObject1).convertFrom((Cursor)localObject4);
      } while (((Cursor)localObject4).moveToNext());
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(166885);
          throw localThrowable;
        }
        finally
        {
          b.a((Closeable)localObject3, localThrowable);
          AppMethodBeat.o(166885);
        }
        Object localObject2 = null;
      }
    }
    localObject4 = ah.aiuX;
    b.a((Closeable)localObject3, null);
    Log.i(TAG, s.X("getRecentAction ", localObject1));
    AppMethodBeat.o(166885);
    return localObject1;
  }
  
  public final List<a.b> ePG()
  {
    AppMethodBeat.i(166889);
    String str = s.X(this.FAn, " WHERE actionType = 1 and state = -1 and  canRemove = 0 group By feedId");
    Object localObject3 = this.db.rawQuery(str, null, 2);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Closeable)localObject3;
    try
    {
      if (((Cursor)localObject3).moveToFirst()) {
        do
        {
          au localau = new au();
          localau.convertFrom((Cursor)localObject3);
          localLinkedList.add(new a.b(localau.field_feedId, localau.getObjectNonceId()));
        } while (((Cursor)localObject3).moveToNext());
      }
      localObject3 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      Log.i(TAG, "getAllFailedCommentFeedIds " + str + " listSize:" + localLinkedList.size());
      localObject1 = (List)localLinkedList;
      AppMethodBeat.o(166889);
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(166889);
        throw localThrowable;
      }
      finally
      {
        b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(166889);
      }
    }
  }
  
  public final void pT(long paramLong)
  {
    AppMethodBeat.i(339219);
    Log.i(TAG, s.X("markUnsentCommentsCanRemove ", Long.valueOf(paramLong)));
    Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getFinderActionStorage().pV(paramLong)).iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      localau.field_canRemove = 1;
      a(localau.field_localCommentId, localau, true);
    }
    AppMethodBeat.o(339219);
  }
  
  public final List<au> pU(long paramLong)
  {
    AppMethodBeat.i(166887);
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
          au localau = new au();
          localau.convertFrom((Cursor)localObject2);
          localLinkedList.add(localau);
        } while (((Cursor)localObject2).moveToNext());
      }
      localObject2 = ah.aiuX;
      b.a((Closeable)localObject1, null);
      localObject1 = (List)localLinkedList;
      AppMethodBeat.o(166887);
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(166887);
        throw localThrowable;
      }
      finally
      {
        b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(166887);
      }
    }
  }
  
  public final boolean pW(long paramLong)
  {
    boolean bool = true;
    AppMethodBeat.i(166891);
    if (this.db.delete("FinderAction", "localCommentId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0) {}
    for (;;)
    {
      Log.i(TAG, "removeUnsentComment " + paramLong + " ret:" + bool);
      AppMethodBeat.o(166891);
      return bool;
      bool = false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderActionStorage$Companion;", "", "()V", "ACTION_TYPE_COMMENT", "", "ACTION_TYPE_LIKE", "ACTION_TYPE_LIKE_COMMENT", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "OpType_Add", "getOpType_Add", "()I", "OpType_Del", "getOpType_Del", "OpType_Mod", "getOpType_Mod", "SQL_CREATE", "getSQL_CREATE", "TABLE_NAME", "TAG", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.a
 * JD-Core Version:    0.7.0.1
 */