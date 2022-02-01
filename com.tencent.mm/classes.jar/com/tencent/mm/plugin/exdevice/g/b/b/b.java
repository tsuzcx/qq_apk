package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class b
  extends j<com.tencent.mm.plugin.exdevice.g.b.a.a>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(23574);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.a.info, "HardDeviceChampionInfo") };
    AppMethodBeat.o(23574);
  }
  
  public b(e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.g.b.a.a.info, "HardDeviceChampionInfo", null);
    AppMethodBeat.i(23571);
    this.db = parame;
    parame.execSQL("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    AppMethodBeat.o(23571);
  }
  
  public final com.tencent.mm.plugin.exdevice.g.b.a.a UN(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(23572);
    Object localObject2 = String.format("select *, rowid from %s where %s = ? limit 1", new Object[] { "HardDeviceChampionInfo", "username" });
    localObject2 = this.db.a((String)localObject2, new String[] { bt.by(paramString, "") }, 2);
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
      paramString = localObject1;
    }
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
      com.tencent.mm.plugin.exdevice.model.ad.bZP().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      AppMethodBeat.o(23573);
      return true;
    }
    if (insert(parama))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
      com.tencent.mm.plugin.exdevice.model.ad.bZP().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      AppMethodBeat.o(23573);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
    AppMethodBeat.o(23573);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.b
 * JD-Core Version:    0.7.0.1
 */