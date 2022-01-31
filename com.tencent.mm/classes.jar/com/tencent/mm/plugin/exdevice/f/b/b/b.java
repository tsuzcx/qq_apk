package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class b
  extends i<com.tencent.mm.plugin.exdevice.f.b.a.a>
{
  public static final String[] dXp = { i.a(com.tencent.mm.plugin.exdevice.f.b.a.a.buS, "HardDeviceChampionInfo") };
  private e dXw;
  
  public b(e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.f.b.a.a.buS, "HardDeviceChampionInfo", null);
    this.dXw = parame;
    parame.gk("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
  }
  
  public final com.tencent.mm.plugin.exdevice.f.b.a.a BC(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = String.format("select *, rowid from %s where %s = ? limit 1", new Object[] { "HardDeviceChampionInfo", "username" });
    localObject2 = this.dXw.a((String)localObject2, new String[] { bk.aM(paramString, "") }, 2);
    if (localObject2 == null)
    {
      y.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new com.tencent.mm.plugin.exdevice.f.b.a.a();
      paramString.d((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      return paramString;
      y.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
      paramString = localObject1;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.a parama)
  {
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!c(parama, new String[] { "username" })) {
        break;
      }
      y.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
      ad.aLU().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      return true;
    }
    if (b(parama))
    {
      y.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
      ad.aLU().a("HardDeviceChampionInfo", new d(null, null, parama.field_username));
      return true;
    }
    y.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.b
 * JD-Core Version:    0.7.0.1
 */