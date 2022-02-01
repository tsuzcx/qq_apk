package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.model.y.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"})
public final class q
  extends j<y>
{
  private static final String[] SQL_CREATE;
  public static final a syC;
  public final e db;
  
  static
  {
    AppMethodBeat.i(167026);
    syC = new a((byte)0);
    y.a locala = y.skB;
    SQL_CREATE = new String[] { j.getCreateSQLs(y.access$getInfo$cp(), "FinderMediaCacheInfo") };
    AppMethodBeat.o(167026);
  }
  
  public q(e parame)
  {
    super(parame, y.access$getInfo$cp(), "FinderMediaCacheInfo", ch.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = parame;
    AppMethodBeat.o(167025);
  }
  
  public final y ait(String paramString)
  {
    AppMethodBeat.i(167023);
    p.h(paramString, "mediaId");
    Object localObject = "select *, rowid from FinderMediaCacheInfo  where mediaId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    y localy = new y();
    localy.field_mediaId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localy.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(167023);
    return localy;
  }
  
  public final boolean b(y paramy)
  {
    AppMethodBeat.i(167020);
    p.h(paramy, "item");
    boolean bool = super.insert((c)paramy);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(y paramy)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    p.h(paramy, "item");
    ContentValues localContentValues = paramy.convertTo();
    localContentValues.remove("rowid");
    if (this.db.update(getTableName(), localContentValues, "mediaId = ?", new String[] { bt.nullAsNil(localContentValues.getAsString("mediaId")) }) > 0)
    {
      if (!bool) {
        break label79;
      }
      doNotify();
    }
    for (;;)
    {
      AppMethodBeat.o(167022);
      return bool;
      bool = false;
      break;
      label79:
      ad.e("Finder.FinderMediaCacheStorage", "[update] failure. " + paramy.field_mediaId);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.q
 * JD-Core Version:    0.7.0.1
 */