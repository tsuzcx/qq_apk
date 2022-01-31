package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.ah.f
{
  public f jyx;
  public com.tencent.mm.plugin.exdevice.f.a.f jyy;
  
  public c()
  {
    y.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
    au.Dk().a(1042, this);
    au.Dk().a(1041, this);
    au.Dk().a(1043, this);
    au.Dk().a(1040, this);
  }
  
  public static ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> By(String paramString)
  {
    com.tencent.mm.plugin.exdevice.f.b.a.d locald = null;
    y.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
    if (!bk.bl(paramString))
    {
      Object localObject = ad.aLM();
      if (bk.bl(paramString))
      {
        y.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
        return null;
      }
      String str = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceRankInfo", "rankID", "score" });
      localObject = ((com.tencent.mm.plugin.exdevice.f.b.b.d)localObject).dXw.a(str, new String[] { bk.aM(paramString, "") }, 2);
      if (localObject == null)
      {
        y.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        return null;
      }
      if (((Cursor)localObject).moveToFirst())
      {
        paramString = new ArrayList();
        do
        {
          locald = new com.tencent.mm.plugin.exdevice.f.b.a.d();
          locald.d((Cursor)localObject);
          paramString.add(locald);
        } while (((Cursor)localObject).moveToNext());
      }
      for (;;)
      {
        ((Cursor)localObject).close();
        return paramString;
        y.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
        paramString = locald;
      }
    }
    y.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
    return null;
  }
  
  public static void d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    au.Dk().a(new l(paramString3, paramString2, paramInt, paramString1), 0);
  }
  
  public static void d(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList)
  {
    com.tencent.mm.plugin.exdevice.f.b.b.d locald = ad.aLM();
    if (!bk.bl(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList == null) {
        break label196;
      }
      String str = String.format("select COUNT(*) from %s where %s = ?", new Object[] { "HardDeviceRankInfo", "rankID" });
      paramString = locald.dXw.a(str, new String[] { bk.aM(paramString, "") }, 2);
      if (paramString != null) {
        break;
      }
      y.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
      i = 0;
      if (i != 0) {
        break label163;
      }
      paramString = paramArrayList.iterator();
      while (paramString.hasNext()) {
        locald.a((com.tencent.mm.plugin.exdevice.f.b.a.d)paramString.next(), false);
      }
    }
    if (paramString.moveToFirst()) {}
    for (int i = paramString.getInt(0);; i = 0)
    {
      paramString.close();
      break;
      y.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
    }
    label163:
    paramString = paramArrayList.iterator();
    while (paramString.hasNext()) {
      locald.b((com.tencent.mm.plugin.exdevice.f.b.a.d)paramString.next(), false);
    }
    label196:
    y.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof j)) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        y.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramm instanceof l)) {
          break;
        }
      } while ((paramInt1 == 0) && (paramInt2 == 0));
      y.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
      return;
    } while ((!(paramm instanceof com.tencent.mm.plugin.exdevice.f.a.m)) || ((paramInt1 == 0) && (paramInt2 == 0)));
    y.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.c
 * JD-Core Version:    0.7.0.1
 */