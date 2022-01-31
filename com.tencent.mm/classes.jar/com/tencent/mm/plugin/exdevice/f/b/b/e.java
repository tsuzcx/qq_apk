package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e
  extends i<com.tencent.mm.plugin.exdevice.f.b.a.e>
{
  public static final String[] dXp = { i.a(com.tencent.mm.plugin.exdevice.f.b.a.e.buS, "HardDeviceLikeUser") };
  private com.tencent.mm.sdk.e.e dXw;
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.f.b.a.e.buS, "HardDeviceLikeUser", null);
    this.dXw = parame;
    parame.gk("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
  }
  
  public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> BD(String paramString)
  {
    com.tencent.mm.plugin.exdevice.f.b.a.e locale = null;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
      return null;
    }
    Object localObject = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceLikeUser", "rankID", "timestamp" });
    localObject = this.dXw.a((String)localObject, new String[] { bk.aM(paramString, "") }, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
      return null;
    }
    paramString = locale;
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        locale = new com.tencent.mm.plugin.exdevice.f.b.a.e();
        locale.d((Cursor)localObject);
        paramString.add(locale);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> paramArrayList)
  {
    if (!bk.bl(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList != null) {
        break;
      }
      y.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.f.b.a.e locale = (com.tencent.mm.plugin.exdevice.f.b.a.e)paramArrayList.next();
      if (locale != null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        if (!c(locale, new String[] { "rankID", "username" })) {
          break label110;
        }
        y.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
        break;
      }
      label110:
      if (b(locale)) {
        y.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
      } else {
        y.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
      }
    }
    ad.aLU().a("HardDeviceLikeUser", new d(paramString1, paramString2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.e
 * JD-Core Version:    0.7.0.1
 */