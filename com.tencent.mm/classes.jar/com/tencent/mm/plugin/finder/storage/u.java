package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cy;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.az.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends MAutoStorage<az>
{
  public static final u.a FKX;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(167026);
    FKX = new u.a((byte)0);
    az.a locala = az.EDr;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(az.access$getInfo$cp(), "FinderMediaCacheInfoV2") };
    AppMethodBeat.o(167026);
  }
  
  public u(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, az.access$getInfo$cp(), "FinderMediaCacheInfoV2", cy.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(167025);
  }
  
  public final az aAC(String paramString)
  {
    AppMethodBeat.i(167023);
    s.u(paramString, "mediaId");
    Object localObject = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    az localaz = new az();
    localaz.field_mediaId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localaz.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      AppMethodBeat.o(167023);
      return localaz;
      Log.w("Finder.FinderMediaCacheStorage", "getByMediaId mediaId:" + paramString + ", cursor is null.");
    }
  }
  
  public final boolean b(az paramaz)
  {
    AppMethodBeat.i(167020);
    s.u(paramaz, "item");
    boolean bool = super.insert((IAutoDBItem)paramaz);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(az paramaz)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    s.u(paramaz, "item");
    ContentValues localContentValues = paramaz.convertTo();
    localContentValues.remove("rowid");
    if (this.db.update(getTableName(), localContentValues, "mediaId = ?", new String[] { Util.nullAsNil(localContentValues.getAsString("mediaId")) }) > 0)
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
      Log.e("Finder.FinderMediaCacheStorage", s.X("[update] failure. ", paramaz.field_mediaId));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.u
 * JD-Core Version:    0.7.0.1
 */