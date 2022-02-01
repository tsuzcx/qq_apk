package com.tencent.mm.plugin.finder.storage.logic;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.c.ch;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.storage.ao.a;
import com.tencent.mm.plugin.finder.storage.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderDraftItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "DRAFT", "", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clearAllDraft", "", "deleteByLocalId", "", "localId", "", "cleanPage", "drop", "getByLocalId", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getDraftBySongInfo", "", "songName", "singer", "getDrafts", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "startTime", "endTime", "insertNewDraft", "draftItem", "printAllItem", "tag", "update", "updateByLocal", "Companion", "plugin-finder_release"})
public final class b
  extends MAutoStorage<ch>
{
  public static final a AnJ;
  private static final String[] SQL_CREATE;
  public final String Alf;
  private final ArrayList<Integer> Ali;
  public String AnI;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(273376);
    AnJ = new a((byte)0);
    h.a locala = com.tencent.mm.plugin.finder.storage.h.AkG;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.finder.storage.h.access$getInfo$cp(), "FinderDraftItem") };
    AppMethodBeat.o(273376);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.finder.storage.h.access$getInfo$cp(), "FinderDraftItem", ch.INDEX_CREATE);
    AppMethodBeat.i(273375);
    this.Alf = "FinderDraftItem";
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = com.tencent.mm.plugin.finder.storage.ao.AmN;
    this.Ali = ao.a.eO(j.listOf(Integer.valueOf(1)));
    paramISQLiteDatabase = new ArrayList();
    paramISQLiteDatabase.clear();
    localObject = this.Ali.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if ((localInteger.intValue() & 0x1) != 0) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = com.tencent.mm.plugin.finder.storage.ao.AmN;
    this.AnI = ao.a.m((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderDraftStorage", "DRAFT " + this.AnI);
    AppMethodBeat.o(273375);
  }
  
  public final long b(com.tencent.mm.plugin.finder.storage.h paramh)
  {
    AppMethodBeat.i(273373);
    p.k(paramh, "draftItem");
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    long l1 = ((f)localObject).aHp().a(ar.a.VxV, 1L);
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((f)localObject).aHp().set(ar.a.VxV, Long.valueOf(1L + l1));
    paramh.field_localId = l1;
    localObject = paramh.convertTo();
    long l2 = this.db.insert(this.Alf, "localId", (ContentValues)localObject);
    Log.i("Finder.FinderDraftStorage", "new draft rowId " + l2 + ' ' + g.bN(paramh) + " localID: " + l1);
    AppMethodBeat.o(273373);
    return l1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderDraftStorage$Companion;", "", "()V", "FILTER_MV", "", "FINDER_SELECT_BEGIN", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.b
 * JD-Core Version:    0.7.0.1
 */