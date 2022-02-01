package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.model.w.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"})
public final class l
  extends j<w>
{
  private static final String[] SQL_CREATE;
  public static final l.a rDP;
  public final e db;
  
  static
  {
    AppMethodBeat.i(167026);
    rDP = new l.a((byte)0);
    w.a locala = w.rvg;
    SQL_CREATE = new String[] { j.getCreateSQLs(w.access$getInfo$cp(), "FinderMediaCacheInfo") };
    AppMethodBeat.o(167026);
  }
  
  public l(e parame)
  {
    super(parame, w.access$getInfo$cp(), "FinderMediaCacheInfo", ce.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = parame;
    AppMethodBeat.o(167025);
  }
  
  public final boolean b(w paramw)
  {
    AppMethodBeat.i(167020);
    k.h(paramw, "item");
    boolean bool = super.insert((c)paramw);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(w paramw)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    k.h(paramw, "item");
    paramw = paramw.convertTo();
    if (this.db.update(getTableName(), paramw, "mediaId = ?", new String[] { bs.nullAsNil(paramw.getAsString("mediaId")) }) > 0) {}
    for (;;)
    {
      doNotify();
      AppMethodBeat.o(167022);
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */