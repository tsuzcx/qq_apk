package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class b
  extends j<com.tencent.mm.plugin.exdevice.f.b.a.a>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(19506);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.exdevice.f.b.a.a.info, "HardDeviceChampionInfo") };
    AppMethodBeat.o(19506);
  }
  
  public b(e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.f.b.a.a.info, "HardDeviceChampionInfo", null);
    AppMethodBeat.i(19503);
    this.db = parame;
    parame.execSQL("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    AppMethodBeat.o(19503);
  }
  
  public final com.tencent.mm.plugin.exdevice.f.b.a.a LE(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(19504);
    Object localObject2 = String.format("select *, rowid from %s where %s = ? limit 1", new Object[] { "HardDeviceChampionInfo", "username" });
    localObject2 = this.db.a((String)localObject2, new String[] { bo.bf(paramString, "") }, 2);
    if (localObject2 == null)
    {
      ab.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
      AppMethodBeat.o(19504);
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new com.tencent.mm.plugin.exdevice.f.b.a.a();
      paramString.convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(19504);
      return paramString;
      ab.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
      paramString = localObject1;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.a parama)
  {
    AppMethodBeat.i(19505);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!update(parama, new String[] { "username" })) {
        break;
      }
      ab.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
      ad.bqh().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      AppMethodBeat.o(19505);
      return true;
    }
    if (insert(parama))
    {
      ab.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
      ad.bqh().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      AppMethodBeat.o(19505);
      return true;
    }
    ab.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
    AppMethodBeat.o(19505);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.b
 * JD-Core Version:    0.7.0.1
 */