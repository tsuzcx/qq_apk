package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d
  extends i<com.tencent.mm.plugin.exdevice.f.b.a.d>
{
  public static final String[] dXp = { i.a(com.tencent.mm.plugin.exdevice.f.b.a.d.buS, "HardDeviceRankInfo") };
  public e dXw;
  
  public d(e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.f.b.a.d.buS, "HardDeviceRankInfo", null);
    this.dXw = parame;
    parame.gk("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
  }
  
  public final com.tencent.mm.plugin.exdevice.f.b.a.d a(com.tencent.mm.plugin.exdevice.f.b.d paramd)
  {
    Object localObject1 = null;
    Object localObject2 = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[] { "HardDeviceRankInfo", "rankID", "username" });
    localObject2 = this.dXw.a((String)localObject2, new String[] { bk.aM(paramd.jyd, ""), bk.aM(paramd.username, "") }, 2);
    if (localObject2 == null)
    {
      y.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramd = new com.tencent.mm.plugin.exdevice.f.b.a.d();
      paramd.d((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      return paramd;
      y.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
      paramd = localObject1;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.d paramd, boolean paramBoolean)
  {
    if (b(paramd, paramBoolean)) {
      return true;
    }
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      b(paramd);
      y.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
      if (!paramBoolean) {
        break;
      }
      ad.aLU().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      return true;
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.f.b.a.d paramd, boolean paramBoolean)
  {
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.plugin.exdevice.f.b.a.d locald = a(new com.tencent.mm.plugin.exdevice.f.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      if (locald == null) {
        break;
      }
      locald.field_likecount = paramd.field_likecount;
      locald.field_selfLikeState = paramd.field_selfLikeState;
      c(locald, new String[] { "rankID", "username" });
      y.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
      if (paramBoolean) {
        ad.aLU().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      }
      return true;
    }
    return false;
  }
  
  public final void e(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList)
  {
    if ((bk.bl(paramString)) || (paramArrayList == null))
    {
      y.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
      return;
    }
    y.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    int i = 0;
    while (i < paramArrayList.size())
    {
      a((com.tencent.mm.plugin.exdevice.f.b.a.d)paramArrayList.get(i), false);
      i += 1;
    }
    ad.aLU().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(paramString, null, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.d
 * JD-Core Version:    0.7.0.1
 */