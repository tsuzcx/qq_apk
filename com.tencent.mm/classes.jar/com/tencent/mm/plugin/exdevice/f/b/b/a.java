package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "HardDeviceRankFollowInfo") };
  private e dXw;
  
  public a(e parame)
  {
    super(parame, c.buS, "HardDeviceRankFollowInfo", null);
    this.dXw = parame;
    parame.gk("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
  }
  
  private boolean a(c paramc)
  {
    boolean bool2 = false;
    if (paramc != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      c localc = a(new b(paramc.field_rankID, paramc.field_appusername, paramc.field_username));
      if (localc == null) {
        break label98;
      }
      localc.field_step = paramc.field_step;
      c(localc, new String[] { "rankID", "appusername", "username" });
      y.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label103;
      }
      return true;
      bool1 = false;
      break;
    }
    label103:
    boolean bool1 = bool2;
    if (paramc != null) {
      bool1 = true;
    }
    Assert.assertTrue(bool1);
    b(paramc);
    y.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
    return true;
  }
  
  public final boolean BA(String paramString)
  {
    String str = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[] { "HardDeviceRankFollowInfo", "rankID", "appusername", "username" });
    paramString = this.dXw.a(str, new String[] { bk.aM("hardcode_rank_id", ""), bk.aM("hardcode_app_name", ""), bk.aM(paramString, "") }, 2);
    if (paramString == null)
    {
      y.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    y.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean BB(String paramString)
  {
    paramString = a(new b("hardcode_rank_id", "hardcode_app_name", paramString));
    if (paramString != null)
    {
      a(paramString, new String[] { "rankID", "appusername", "username" });
      y.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
      return true;
    }
    return false;
  }
  
  public final c a(b paramb)
  {
    Object localObject1 = null;
    Object localObject2 = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[] { "HardDeviceRankFollowInfo", "rankID", "username", "appusername" });
    localObject2 = this.dXw.a((String)localObject2, new String[] { bk.aM(paramb.jyd, ""), bk.aM(paramb.username, ""), bk.aM(paramb.appName, "") }, 2);
    if (localObject2 == null)
    {
      y.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramb = new c();
      paramb.d((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      return paramb;
      y.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
      paramb = localObject1;
    }
  }
  
  public final void a(ArrayList<zh> paramArrayList, String paramString1, String paramString2)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        zh localzh = (zh)paramArrayList.next();
        c localc = new c();
        localc.field_rankID = paramString1;
        localc.field_step = localzh.ghE;
        localc.field_username = localzh.username;
        localc.field_appusername = paramString2;
        a(localc);
      }
    }
  }
  
  public final ArrayList<c> aLZ()
  {
    ArrayList localArrayList = null;
    Object localObject = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[] { "HardDeviceRankFollowInfo", "rankID", "appusername" });
    localObject = this.dXw.a((String)localObject, new String[] { "hardcode_rank_id", "hardcode_app_name" }, 2);
    if (localObject == null)
    {
      y.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        c localc = new c();
        localc.d((Cursor)localObject);
        y.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", new Object[] { Integer.valueOf(((Cursor)localObject).getColumnIndex("rowid")), localc.toString() });
        localArrayList.add(localc);
      } while (((Cursor)localObject).moveToNext());
      y.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", new Object[] { Integer.valueOf(localArrayList.size()), localArrayList.toString() });
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      return localArrayList;
      y.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
    }
  }
  
  public final void be(List<c> paramList)
  {
    if ((bk.bl("hardcode_rank_id")) || (bk.bl("hardcode_app_name"))) {
      y.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
    }
    while (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        c localc = (c)paramList.next();
        localc.field_rankID = "hardcode_rank_id";
        localc.field_appusername = "hardcode_app_name";
        a(localc);
      }
      y.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", new Object[] { "hardcode_rank_id", "hardcode_app_name", Integer.valueOf(this.dXw.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[] { "hardcode_rank_id", "hardcode_app_name" })) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.a
 * JD-Core Version:    0.7.0.1
 */