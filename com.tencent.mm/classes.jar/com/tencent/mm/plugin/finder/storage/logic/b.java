package com.tencent.mm.plugin.finder.storage.logic;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.b.cm;
import com.tencent.mm.plugin.finder.storage.ah;
import com.tencent.mm.plugin.finder.storage.ax;
import com.tencent.mm.plugin.finder.storage.ax.a;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderDraftItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "NEW_VERSION", "NOT_DELETED", "NOT_POSTED", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clearAllDraft", "", "clearInvalidData", "deleteByLocalId", "", "localId", "", "cleanPage", "deleteByObjectId", "id", "drop", "getByLocalId", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getByLocalIdIgnoreMarkDeleted", "getByObjectId", "objectId", "getDraftBySongInfo", "", "songName", "singer", "getDrafts", "getOriginalVersionDrafts", "getUnsyncDrafts", "getWaitingPostDraft", "insertNewDraft", "draftItem", "markDeleted", "printAllItem", "tag", "updateByLocal", "updateBySvr", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<cm>
{
  private static final int DB_VERSION;
  private static final int FNB = 0;
  public static final a FNy;
  private static final String[] SQL_CREATE;
  private String FKG;
  private final ArrayList<Integer> FKI;
  private String FNA;
  public String FNz;
  private String NEW_VERSION;
  public final ISQLiteDatabase db;
  public final String ptT;
  
  static
  {
    AppMethodBeat.i(339530);
    FNy = new a((byte)0);
    i.a locala = i.FKa;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.access$getInfo$cp(), "FinderDraftItem") };
    DB_VERSION = 1;
    AppMethodBeat.o(339530);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, i.access$getInfo$cp(), "FinderDraftItem", cm.INDEX_CREATE);
    AppMethodBeat.i(339496);
    this.ptT = "FinderDraftItem";
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = ax.FMH;
    this.FKI = ax.a.hA(p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) }));
    paramISQLiteDatabase = new ArrayList();
    paramISQLiteDatabase.clear();
    localObject = this.FKI.iterator();
    Integer localInteger;
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) && ((localInteger.intValue() & 0x2) == 0) && ((localInteger.intValue() & 0x4) == 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ax.FMH;
    this.FKG = ax.a.t((List)paramISQLiteDatabase, "localFlag");
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
    this.FNA = ax.a.t((List)paramISQLiteDatabase, "localFlag");
    this.FNz = "(markDeleted=0)";
    this.NEW_VERSION = s.X("dbversion=", Integer.valueOf(DB_VERSION));
    Log.i("Finder.FinderDraftStorage", "CONDITION_POST " + this.FKG + "； NOT_DELETED " + this.FNz);
    AppMethodBeat.o(339496);
  }
  
  public final boolean a(long paramLong, i parami)
  {
    AppMethodBeat.i(339578);
    s.u(parami, "draftItem");
    parami.eYM();
    parami = parami.convertTo();
    parami.remove("rowid");
    if (this.db.update("FinderDraftItem", parami, "localId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0)
    {
      AppMethodBeat.o(339578);
      return true;
    }
    AppMethodBeat.o(339578);
    return false;
  }
  
  public final long f(i parami)
  {
    AppMethodBeat.i(339538);
    s.u(parami, "draftItem");
    parami.eYM();
    if (parami.field_finderItem == null)
    {
      Log.e("Finder.FinderDraftStorage", "insertNewDraft but field_finderItem is null");
      AppMethodBeat.o(339538);
      return -1L;
    }
    Object localObject = ah.FMh;
    long l1 = ah.eZC();
    parami.field_localId = l1;
    localObject = parami.convertTo();
    long l2 = this.db.insert(this.ptT, "localId", (ContentValues)localObject);
    Log.i("Finder.FinderDraftStorage", "new draft rowId " + l2 + ' ' + f.dg(parami) + " localID: " + l1);
    AppMethodBeat.o(339538);
    return l1;
  }
  
  public final List<i> fam()
  {
    AppMethodBeat.i(339592);
    Object localObject1 = new ArrayList();
    Object localObject2 = "SELECT * FROM FinderDraftItem  WHERE " + this.FNz + " AND " + this.FNA + " AND " + this.NEW_VERSION + " ORDER BY " + this.ptT + ".localId DESC";
    localObject2 = this.db.rawQuery((String)localObject2, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      i locali = new i();
      locali.convertFrom((Cursor)localObject2);
      ((ArrayList)localObject1).add(locali);
    }
    ((Cursor)localObject2).close();
    localObject1 = (List)localObject1;
    AppMethodBeat.o(339592);
    return localObject1;
  }
  
  public final i fan()
  {
    AppMethodBeat.i(339599);
    i locali = new i();
    String str = "SELECT * FROM FinderDraftItem  WHERE " + this.FNz + " AND " + this.FKG + " AND " + this.NEW_VERSION + " ORDER BY " + this.ptT + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.rawQuery(str, null, 2);
    Log.i("Finder.FinderDraftStorage", s.X("getWaitingPost ", str));
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(339599);
      return null;
    }
    locali.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(339599);
    return locali;
  }
  
  public final i qm(long paramLong)
  {
    i locali = null;
    AppMethodBeat.i(339549);
    Object localObject = "SELECT * FROM FinderDraftItem  WHERE " + this.FNz + " AND " + this.ptT + ".localId=" + paramLong;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locali = new i();
      locali.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(339549);
    return locali;
  }
  
  public final i qn(long paramLong)
  {
    i locali = null;
    AppMethodBeat.i(339556);
    Object localObject = "SELECT * FROM FinderDraftItem  WHERE " + this.ptT + ".localId=" + paramLong;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locali = new i();
      locali.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(339556);
    return locali;
  }
  
  public final void qo(long paramLong)
  {
    AppMethodBeat.i(339565);
    i locali = qm(paramLong);
    if (locali != null)
    {
      Log.i("Finder.FinderDraftStorage", s.X("markDeleted, ", locali.eYN()));
      locali.field_markDeleted = 1;
      a(paramLong, locali);
    }
    AppMethodBeat.o(339565);
  }
  
  public final i qp(long paramLong)
  {
    i locali = null;
    AppMethodBeat.i(339571);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(339571);
      return null;
    }
    Object localObject = "SELECT * FROM FinderDraftItem  WHERE " + this.ptT + ".objectId=" + paramLong;
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      locali = new i();
      locali.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(339571);
    return locali;
  }
  
  public final boolean qq(long paramLong)
  {
    AppMethodBeat.i(339583);
    if (paramLong != 0L)
    {
      if (this.db.delete("FinderDraftItem", "objectId=?", new String[] { s.X("", Long.valueOf(paramLong)) }) > 0)
      {
        AppMethodBeat.o(339583);
        return true;
      }
      AppMethodBeat.o(339583);
      return false;
    }
    AppMethodBeat.o(339583);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage$Companion;", "", "()V", "DB_ORIGIN_VERSION", "", "getDB_ORIGIN_VERSION", "()I", "DB_VERSION", "getDB_VERSION", "FILTER_MV", "", "FINDER_SELECT_BEGIN", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.b
 * JD-Core Version:    0.7.0.1
 */