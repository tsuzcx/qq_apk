package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.at.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"})
public final class w
  extends MAutoStorage<at>
{
  private static final String[] SQL_CREATE;
  public static final a vEm;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(167026);
    vEm = new a((byte)0);
    at.a locala = at.uON;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(at.access$getInfo$cp(), "FinderMediaCacheInfoV2") };
    AppMethodBeat.o(167026);
  }
  
  public w(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, at.access$getInfo$cp(), "FinderMediaCacheInfoV2", cl.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(167025);
  }
  
  public final at avt(String paramString)
  {
    AppMethodBeat.i(167023);
    p.h(paramString, "mediaId");
    Object localObject = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    at localat = new at();
    localat.field_mediaId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localat.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(167023);
    return localat;
  }
  
  public final boolean b(at paramat)
  {
    AppMethodBeat.i(167020);
    p.h(paramat, "item");
    boolean bool = super.insert((IAutoDBItem)paramat);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(at paramat)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    p.h(paramat, "item");
    ContentValues localContentValues = paramat.convertTo();
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
      Log.e("Finder.FinderMediaCacheStorage", "[update] failure. " + paramat.field_mediaId);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.w
 * JD-Core Version:    0.7.0.1
 */