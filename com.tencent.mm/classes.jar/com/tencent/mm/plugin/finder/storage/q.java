package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.model.z.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"})
public final class q
  extends j<z>
{
  private static final String[] SQL_CREATE;
  public static final q.a sJt;
  public final e db;
  
  static
  {
    AppMethodBeat.i(167026);
    sJt = new q.a((byte)0);
    z.a locala = z.sty;
    SQL_CREATE = new String[] { j.getCreateSQLs(z.access$getInfo$cp(), "FinderMediaCacheInfoV2") };
    AppMethodBeat.o(167026);
  }
  
  public q(e parame)
  {
    super(parame, z.access$getInfo$cp(), "FinderMediaCacheInfoV2", ch.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = parame;
    AppMethodBeat.o(167025);
  }
  
  public final z ajq(String paramString)
  {
    AppMethodBeat.i(167023);
    p.h(paramString, "mediaId");
    Object localObject = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    z localz = new z();
    localz.field_mediaId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localz.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(167023);
    return localz;
  }
  
  public final boolean b(z paramz)
  {
    AppMethodBeat.i(167020);
    p.h(paramz, "item");
    boolean bool = super.insert((c)paramz);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(z paramz)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    p.h(paramz, "item");
    ContentValues localContentValues = paramz.convertTo();
    localContentValues.remove("rowid");
    if (this.db.update(getTableName(), localContentValues, "mediaId = ?", new String[] { bu.nullAsNil(localContentValues.getAsString("mediaId")) }) > 0)
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
      ae.e("Finder.FinderMediaCacheStorage", "[update] failure. " + paramz.field_mediaId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.q
 * JD-Core Version:    0.7.0.1
 */