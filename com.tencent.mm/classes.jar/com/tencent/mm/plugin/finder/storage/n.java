package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.b.cn;
import com.tencent.mm.plugin.finder.storage.data.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.q;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "FAIL_OR_WAITING", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clean", "", "sourceFlag", "clearAllPostFeed", "", "deleteByGroupId", "objectIds", "", "", "includePostDb", "deleteById", "objectId", "deleteByLocalId", "localId", "cleanPage", "drop", "getAllWaitingPostFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getById", "id", "getByLocalId", "getFailAndWaitingPostFeed", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "getWaitingPostFeed", "insertNewFeed", "finderObj", "printAllItem", "tag", "testDB", "sql", "update", "svrId", "finder", "updateByLocal", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends MAutoStorage<cn>
{
  public static final a FKF;
  private static final Object FKJ;
  private static final String[] SQL_CREATE;
  private String FKG;
  private String FKH;
  private final ArrayList<Integer> FKI;
  public final ISQLiteDatabase db;
  private final String ptT;
  
  static
  {
    AppMethodBeat.i(166976);
    FKF = new a((byte)0);
    FinderItem.a locala = FinderItem.Companion;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(FinderItem.a.eZl(), "FinderFeedItem") };
    FKJ = new Object();
    AppMethodBeat.o(166976);
  }
  
  public n(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, FinderItem.a.eZl(), "FinderFeedItem", cn.INDEX_CREATE);
    AppMethodBeat.i(166975);
    this.ptT = "FinderFeedItem";
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = ax.FMH;
    this.FKI = ax.a.hA(p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
    paramISQLiteDatabase = new ArrayList();
    localObject = this.FKI.iterator();
    Integer localInteger;
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) && ((localInteger.intValue() & 0x2) == 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ax.FMH;
    this.FKG = ax.a.t((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderFeedStorage", s.X("CONDITION_POST ", this.FKG));
    paramISQLiteDatabase.clear();
    localObject = this.FKI.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) || ((localInteger.intValue() & 0x2) != 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ax.FMH;
    this.FKH = ax.a.t((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderFeedStorage", s.X("FAIL_OR_WAITING ", this.FKH));
    AppMethodBeat.o(166975);
  }
  
  public final boolean I(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166971);
    if (paramBoolean)
    {
      k.a locala = k.FNg;
      k.a.ql(paramLong);
    }
    if (this.db.delete("FinderFeedItem", "localId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0)
    {
      AppMethodBeat.o(166971);
      return true;
    }
    AppMethodBeat.o(166971);
    return false;
  }
  
  public final LinkedList<FinderItem> an(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339240);
    s.u(paramString, "username");
    c localc = new c("getLocalSenderFeedBeforeTime");
    paramString = "SELECT * FROM FinderFeedItem   WHERE createTime >= " + paramInt1 + " AND createTime < " + paramInt2 + "  ORDER BY createTime DESC";
    Object localObject2 = this.db.rawQuery(paramString, null, 2);
    Log.i("Finder.FinderFeedStorage", s.X("getLocalSenderFeedBeforeTime1 ", localc));
    LinkedList localLinkedList = new LinkedList();
    paramString = (Closeable)localObject2;
    try
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          FinderItem localFinderItem = new FinderItem();
          s.s(localObject2, "cu");
          localFinderItem.convertFrom((Cursor)localObject2);
          localFinderItem.getFeedObject();
          localLinkedList.add(localFinderItem);
        } while (((Cursor)localObject2).moveToNext());
      }
      localObject2 = kotlin.ah.aiuX;
      b.a(paramString, null);
      Log.i("Finder.FinderFeedStorage", s.X("getLocalSenderFeedBeforeTime2 ", localc));
      AppMethodBeat.o(339240);
      return localLinkedList;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(339240);
        throw localThrowable;
      }
      finally
      {
        b.a(paramString, localThrowable);
        AppMethodBeat.o(339240);
      }
    }
  }
  
  public final boolean b(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(339216);
    s.u(paramFinderItem, "finder");
    if (paramLong == 0L) {
      Log.printInfoStack("Finder.FinderFeedStorage", "update svrId " + paramLong + ' ' + paramFinderItem.info() + ' ' + Util.getStack(), new Object[0]);
    }
    paramFinderItem = paramFinderItem.convertTo();
    paramFinderItem.remove("rowid");
    if (this.db.update("FinderFeedItem", paramFinderItem, "id=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0)
    {
      AppMethodBeat.o(339216);
      return true;
    }
    AppMethodBeat.o(339216);
    return false;
  }
  
  public final boolean c(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166968);
    s.u(paramFinderItem, "finderObj");
    paramFinderItem = paramFinderItem.convertTo();
    paramFinderItem.remove("rowid");
    if (this.db.update("FinderFeedItem", paramFinderItem, "localId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0)
    {
      AppMethodBeat.o(166968);
      return true;
    }
    AppMethodBeat.o(166968);
    return false;
  }
  
  public final FinderItem eZh()
  {
    AppMethodBeat.i(166973);
    FinderItem localFinderItem = new FinderItem();
    String str = "SELECT * FROM FinderFeedItem  WHERE " + this.FKG + " ORDER BY " + this.ptT + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.rawQuery(str, null, 2);
    Log.d("Finder.FinderFeedStorage", s.X("getWaitingPost ", str));
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(166973);
      return null;
    }
    s.s(localCursor, "cr");
    localFinderItem.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(166973);
    return localFinderItem;
  }
  
  public final List<FinderItem> eZi()
  {
    AppMethodBeat.i(339278);
    Object localObject1 = new ArrayList();
    Object localObject2 = "SELECT * FROM FinderFeedItem  WHERE " + this.FKG + " ORDER BY " + this.ptT + ".localId ASC";
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      FinderItem localFinderItem = new FinderItem();
      s.s(localObject2, "cr");
      localFinderItem.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(localFinderItem);
    }
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(339278);
    return localObject1;
  }
  
  public final List<FinderItem> eZj()
  {
    AppMethodBeat.i(166974);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE localFlag IN (1, 2);", null, 2);
    while (localCursor.moveToNext())
    {
      FinderItem localFinderItem = new FinderItem();
      s.s(localCursor, "cr");
      localFinderItem.convertFrom(localCursor);
      ((ArrayList)localObject).add(localFinderItem);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(166974);
    return localObject;
  }
  
  public final void hz(List<Long> paramList)
  {
    AppMethodBeat.i(339266);
    s.u(paramList, "objectIds");
    long l1 = SystemClock.uptimeMillis();
    Object localObject1 = k.FNg;
    s.u(paramList, "svrIds");
    p.o((Iterable)paramList);
    Object localObject3 = k.fag();
    int j = localObject3.length;
    int i = 0;
    Object localObject4;
    if (i < j)
    {
      int k = ((Number)localObject3[i]).intValue();
      localObject1 = k.FNg;
      k.a.Tw(k);
      localObject1 = k.faf().Tx(k).FMI.KNn;
      if (localObject1 != null)
      {
        localObject1 = (axv)p.ae((List)localObject1, 0);
        if (localObject1 != null)
        {
          localObject1 = ((axv)localObject1).lPK;
          if (localObject1 != null)
          {
            localObject4 = h.FMZ;
            if (h.c(paramList, (LinkedList)localObject1)) {
              if (BuildInfo.DEBUG)
              {
                localObject1 = k.faf().Tx(k).FMI.KNn;
                if (localObject1 != null) {
                  break label210;
                }
                localObject1 = null;
              }
            }
          }
        }
      }
      for (;;)
      {
        Log.i("Finder.FinderPage", s.X("[deletePageData] ", localObject1));
        localObject1 = k.FNg;
        k.a.a(k.faf().Tx(k));
        i += 1;
        break;
        label210:
        localObject1 = (axv)p.ae((List)localObject1, 0);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((axv)localObject1).lPK;
        }
      }
    }
    localObject1 = new LongSparseArray();
    localObject3 = (Closeable)this.db.rawQuery("SELECT id, createTime from FinderFeedItem ORDER BY createTime DESC LIMIT 100", null, 2);
    try
    {
      localObject4 = (Cursor)localObject3;
      long l2;
      if (((Cursor)localObject4).moveToFirst()) {
        while (!((Cursor)localObject4).isAfterLast())
        {
          l2 = ((Cursor)localObject4).getLong(0);
          if (l2 != 0L) {
            ((LongSparseArray)localObject1).put(l2, Long.valueOf(l2));
          }
          ((Cursor)localObject4).moveToNext();
        }
      }
      return;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(339266);
        throw paramList;
      }
      finally
      {
        b.a((Closeable)localObject3, paramList);
        AppMethodBeat.o(339266);
      }
      localObject4 = kotlin.ah.aiuX;
      b.a((Closeable)localObject3, null);
      localObject3 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        l2 = ((Number)((Iterator)localObject3).next()).longValue();
        localObject4 = e.FMN;
        e.a.ky(l2);
        if (localObject2.indexOfKey(l2) >= 0) {
          this.db.delete("FinderFeedItem", "id=?", new String[] { s.X("", Long.valueOf(l2)) });
        }
      }
      if (BuildInfo.DEBUG) {
        Log.d("Finder.FinderFeedStorage", s.X("[deleteByGroupId] objectIds=", paramList));
      }
      Log.i("Finder.FinderFeedStorage", "[deleteByGroupId] size=" + paramList.size() + " COST=" + (SystemClock.uptimeMillis() - l1) + "ms");
      AppMethodBeat.o(339266);
    }
  }
  
  public final FinderItem jn(long paramLong)
  {
    AppMethodBeat.i(339227);
    Object localObject1 = s.X("SELECT * FROM FinderFeedItem  WHERE id = ", Long.valueOf(paramLong));
    Object localObject2 = this.db.rawQuery((String)localObject1, null, 2);
    FinderItem localFinderItem = new FinderItem();
    if (localObject2 != null) {
      localObject1 = (Closeable)localObject2;
    }
    try
    {
      if (((Cursor)localObject2).moveToFirst())
      {
        s.s(localObject2, "cursor");
        localFinderItem.convertFrom((Cursor)localObject2);
      }
      localObject2 = kotlin.ah.aiuX;
      b.a((Closeable)localObject1, null);
      AppMethodBeat.o(339227);
      return localFinderItem;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(339227);
        throw localThrowable;
      }
      finally
      {
        b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(339227);
      }
    }
  }
  
  public final long q(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166969);
    s.u(paramFinderItem, "finderObj");
    Object localObject = ah.FMh;
    long l1 = ah.eZC();
    paramFinderItem.setLocalId(l1);
    localObject = paramFinderItem.convertTo();
    long l2 = this.db.insert("FinderFeedItem", "localId", (ContentValues)localObject);
    Log.i("Finder.FinderFeedStorage", "new feed rowId " + l2 + ' ' + f.dg(paramFinderItem.getFeedObject()) + " localID: " + l1);
    AppMethodBeat.o(166969);
    return l1;
  }
  
  public final FinderItem qc(long paramLong)
  {
    FinderItem localFinderItem = null;
    AppMethodBeat.i(166966);
    Object localObject = s.X("SELECT * FROM FinderFeedItem  WHERE FinderFeedItem.localId=", Long.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localFinderItem = new FinderItem();
      s.s(localObject, "cu");
      localFinderItem.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(166966);
    return localFinderItem;
  }
  
  public final boolean qd(long paramLong)
  {
    AppMethodBeat.i(166970);
    Object localObject = e.FMN;
    boolean bool = e.a.ky(paramLong);
    localObject = k.FNg;
    localObject = k.fag();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)localObject[i]).intValue();
      k.a locala = k.FNg;
      k.a.ad(paramLong, k);
      i += 1;
    }
    if (this.db.delete("FinderFeedItem", "id=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0) {}
    for (i = 1; (bool) || (i != 0); i = 0)
    {
      AppMethodBeat.o(166970);
      return true;
    }
    AppMethodBeat.o(166970);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage$Companion;", "", "()V", "FINDER_SELECT_BEGIN", "", "ID_LOCK", "Ljava/lang/Object;", "getID_LOCK", "()Ljava/lang/Object;", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.n
 * JD-Core Version:    0.7.0.1
 */