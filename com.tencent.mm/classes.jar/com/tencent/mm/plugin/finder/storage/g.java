package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cc;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.model.r.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"})
public final class g
  extends j<r>
{
  private static final String[] SQL_CREATE;
  public static final a qJX;
  public final e db;
  
  static
  {
    AppMethodBeat.i(167026);
    qJX = new a((byte)0);
    r.a locala = r.qDQ;
    SQL_CREATE = new String[] { j.getCreateSQLs(r.access$getInfo$cp(), "FinderMediaCacheInfo") };
    AppMethodBeat.o(167026);
  }
  
  public g(e parame)
  {
    super(parame, r.access$getInfo$cp(), "FinderMediaCacheInfo", cc.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = parame;
    AppMethodBeat.o(167025);
  }
  
  public final boolean b(r paramr)
  {
    AppMethodBeat.i(167020);
    k.h(paramr, "item");
    boolean bool = super.insert((c)paramr);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(r paramr)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    k.h(paramr, "item");
    paramr = paramr.convertTo();
    if (this.db.update(getTableName(), paramr, "mediaId = ?", new String[] { bt.nullAsNil(paramr.getAsString("mediaId")) }) > 0) {}
    for (;;)
    {
      doNotify();
      AppMethodBeat.o(167022);
      return bool;
      bool = false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.g
 * JD-Core Version:    0.7.0.1
 */