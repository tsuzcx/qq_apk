package com.tencent.mm.plugin.finder.storage.logic;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.storage.ap;
import com.tencent.mm.plugin.finder.storage.ap.a;
import com.tencent.mm.plugin.finder.storage.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderDraftItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "DRAFT", "", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clearAllDraft", "", "deleteByLocalId", "", "localId", "", "cleanPage", "drop", "getByLocalId", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getDrafts", "", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "startTime", "endTime", "insertNewDraft", "draftItem", "printAllItem", "tag", "update", "updateByLocal", "Companion", "plugin-finder_release"})
public final class b
  extends MAutoStorage<cg>
{
  private static final String[] SQL_CREATE;
  public static final a vGL;
  public final String TABLE;
  public final ISQLiteDatabase db;
  private final ArrayList<Integer> vDL;
  public String vGK;
  
  static
  {
    AppMethodBeat.i(252059);
    vGL = new a((byte)0);
    g.a locala = com.tencent.mm.plugin.finder.storage.g.vDm;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.finder.storage.g.access$getInfo$cp(), "FinderDraftItem") };
    AppMethodBeat.o(252059);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.finder.storage.g.access$getInfo$cp(), "FinderDraftItem", cg.INDEX_CREATE);
    AppMethodBeat.i(252058);
    this.TABLE = "FinderDraftItem";
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = ap.vFv;
    this.vDL = ap.a.eu(j.listOf(Integer.valueOf(1)));
    paramISQLiteDatabase = new ArrayList();
    paramISQLiteDatabase.clear();
    localObject = this.vDL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if ((localInteger.intValue() & 0x1) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ap.vFv;
    this.vGK = ap.a.k((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderDraftStorage", "DRAFT " + this.vGK);
    AppMethodBeat.o(252058);
  }
  
  public final long b(com.tencent.mm.plugin.finder.storage.g paramg)
  {
    AppMethodBeat.i(252056);
    p.h(paramg, "draftItem");
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    long l1 = ((e)localObject).azQ().a(ar.a.OjE, 1L);
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).azQ().set(ar.a.OjE, Long.valueOf(1L + l1));
    paramg.field_localId = l1;
    localObject = paramg.convertTo();
    long l2 = this.db.insert(this.TABLE, "localId", (ContentValues)localObject);
    Log.i("Finder.FinderDraftStorage", "new draft rowId " + l2 + ' ' + com.tencent.mm.ac.g.bN(paramg) + " localID: " + l1);
    AppMethodBeat.o(252056);
    return l1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage$Companion;", "", "()V", "FINDER_SELECT_BEGIN", "", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.b
 * JD-Core Version:    0.7.0.1
 */