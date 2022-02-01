package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cq;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.av.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getAllData", "", "getByMediaId", "mediaId", "", "getByOriginMediaId", "Ljava/util/LinkedList;", "originMediaId", "insert", "", "item", "isExist", "isExistWithOriginMediaId", "update", "Companion", "plugin-finder_release"})
public final class t
  extends MAutoStorage<av>
{
  public static final a Alx;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(167026);
    Alx = new a((byte)0);
    av.a locala = av.zBi;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(av.access$getInfo$cp(), "FinderMediaCacheInfoV2") };
    AppMethodBeat.o(167026);
  }
  
  public t(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, av.access$getInfo$cp(), "FinderMediaCacheInfoV2", cq.INDEX_CREATE);
    AppMethodBeat.i(167025);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(167025);
  }
  
  public final av aEJ(String paramString)
  {
    AppMethodBeat.i(167023);
    p.k(paramString, "mediaId");
    Object localObject = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    av localav = new av();
    localav.field_mediaId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localav.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    for (;;)
    {
      AppMethodBeat.o(167023);
      return localav;
      Log.w("Finder.FinderMediaCacheStorage", "getByMediaId mediaId:" + paramString + ", cursor is null.");
    }
  }
  
  public final boolean b(av paramav)
  {
    AppMethodBeat.i(167020);
    p.k(paramav, "item");
    boolean bool = super.insert((IAutoDBItem)paramav);
    AppMethodBeat.o(167020);
    return bool;
  }
  
  public final boolean c(av paramav)
  {
    boolean bool = true;
    AppMethodBeat.i(167022);
    p.k(paramav, "item");
    ContentValues localContentValues = paramav.convertTo();
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
      Log.e("Finder.FinderMediaCacheStorage", "[update] failure. " + paramav.field_mediaId);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "Table", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */