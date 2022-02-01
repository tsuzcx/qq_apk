package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import junit.framework.Assert;

public final class b
  extends MAutoStorage<com.tencent.mm.plugin.exdevice.g.b.a.a>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(23574);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.a.info, "HardDeviceChampionInfo") };
    AppMethodBeat.o(23574);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.exdevice.g.b.a.a.info, "HardDeviceChampionInfo", null);
    AppMethodBeat.i(23571);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    AppMethodBeat.o(23571);
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.g.b.a.a parama)
  {
    AppMethodBeat.i(23573);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!update(parama, new String[] { "username" })) {
        break;
      }
      Log.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
      ad.cKU().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      AppMethodBeat.o(23573);
      return true;
    }
    if (insert(parama))
    {
      Log.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
      ad.cKU().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      AppMethodBeat.o(23573);
      return true;
    }
    Log.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
    AppMethodBeat.o(23573);
    return false;
  }
  
  public final com.tencent.mm.plugin.exdevice.g.b.a.a anF(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(23572);
    Object localObject2 = String.format("select *, rowid from %s where %s = ? limit 1", new Object[] { "HardDeviceChampionInfo", "username" });
    localObject2 = this.db.rawQuery((String)localObject2, new String[] { Util.nullAs(paramString, "") }, 2);
    if (localObject2 == null)
    {
      Log.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
      AppMethodBeat.o(23572);
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new com.tencent.mm.plugin.exdevice.g.b.a.a();
      paramString.convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(23572);
      return paramString;
      Log.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
      paramString = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.b
 * JD-Core Version:    0.7.0.1
 */