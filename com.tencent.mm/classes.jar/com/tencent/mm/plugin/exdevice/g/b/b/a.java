package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a.c;
import com.tencent.mm.plugin.exdevice.g.b.b;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(23570);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "HardDeviceRankFollowInfo") };
    AppMethodBeat.o(23570);
  }
  
  public a(e parame)
  {
    super(parame, c.info, "HardDeviceRankFollowInfo", null);
    AppMethodBeat.i(23558);
    this.db = parame;
    parame.execSQL("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
    AppMethodBeat.o(23558);
  }
  
  private boolean R(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23561);
    String str = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[] { "HardDeviceRankFollowInfo", "rankID", "appusername", "username" });
    paramString1 = this.db.a(str, new String[] { bs.bG(paramString1, ""), bs.bG(paramString2, ""), bs.bG(paramString3, "") }, 2);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
      AppMethodBeat.o(23561);
      return false;
    }
    boolean bool = paramString1.moveToFirst();
    paramString1.close();
    ac.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23561);
    return bool;
  }
  
  private boolean S(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23567);
    paramString1 = a(new b(paramString1, paramString2, paramString3));
    if (paramString1 != null)
    {
      delete(paramString1, new String[] { "rankID", "appusername", "username" });
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
      AppMethodBeat.o(23567);
      return true;
    }
    AppMethodBeat.o(23567);
    return false;
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(23565);
    if (b(paramc))
    {
      AppMethodBeat.o(23565);
      return true;
    }
    c(paramc);
    AppMethodBeat.o(23565);
    return true;
  }
  
  private boolean b(c paramc)
  {
    AppMethodBeat.i(23568);
    if (paramc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      c localc = a(new b(paramc.field_rankID, paramc.field_appusername, paramc.field_username));
      if (localc == null) {
        break;
      }
      localc.field_step = paramc.field_step;
      update(localc, new String[] { "rankID", "appusername", "username" });
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
      AppMethodBeat.o(23568);
      return true;
    }
    AppMethodBeat.o(23568);
    return false;
  }
  
  private boolean c(c paramc)
  {
    AppMethodBeat.i(23569);
    if (paramc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      insert(paramc);
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
      AppMethodBeat.o(23569);
      return true;
    }
  }
  
  public final boolean YX(String paramString)
  {
    AppMethodBeat.i(23560);
    boolean bool = R("hardcode_rank_id", "hardcode_app_name", paramString);
    AppMethodBeat.o(23560);
    return bool;
  }
  
  public final boolean YY(String paramString)
  {
    AppMethodBeat.i(23566);
    boolean bool = S("hardcode_rank_id", "hardcode_app_name", paramString);
    AppMethodBeat.o(23566);
    return bool;
  }
  
  public final c a(b paramb)
  {
    AppMethodBeat.i(23559);
    Object localObject = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[] { "HardDeviceRankFollowInfo", "rankID", "username", "appusername" });
    localObject = this.db.a((String)localObject, new String[] { bs.bG(paramb.pBx, ""), bs.bG(paramb.username, ""), bs.bG(paramb.appName, "") }, 2);
    if (localObject == null)
    {
      ac.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
      AppMethodBeat.o(23559);
      return null;
    }
    paramb = null;
    if (((Cursor)localObject).moveToFirst())
    {
      paramb = new c();
      paramb.convertFrom((Cursor)localObject);
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(23559);
      return paramb;
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
    }
  }
  
  public final void a(ArrayList<api> paramArrayList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23563);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        api localapi = (api)paramArrayList.next();
        c localc = new c();
        localc.field_rankID = paramString1;
        localc.field_step = localapi.kar;
        localc.field_username = localapi.username;
        localc.field_appusername = paramString2;
        a(localc);
      }
    }
    AppMethodBeat.o(23563);
  }
  
  public final void cV(List<c> paramList)
  {
    AppMethodBeat.i(23564);
    if ((bs.isNullOrNil("hardcode_rank_id")) || (bs.isNullOrNil("hardcode_app_name"))) {
      ac.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
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
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", new Object[] { "hardcode_rank_id", "hardcode_app_name", Integer.valueOf(this.db.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[] { "hardcode_rank_id", "hardcode_app_name" })) });
    }
    AppMethodBeat.o(23564);
  }
  
  public final ArrayList<c> chd()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(23562);
    Object localObject = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[] { "HardDeviceRankFollowInfo", "rankID", "appusername" });
    localObject = this.db.a((String)localObject, new String[] { "hardcode_rank_id", "hardcode_app_name" }, 2);
    if (localObject == null)
    {
      ac.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
      AppMethodBeat.o(23562);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject);
        ac.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", new Object[] { Integer.valueOf(((Cursor)localObject).getColumnIndex("rowid")), localc.toString() });
        localArrayList.add(localc);
      } while (((Cursor)localObject).moveToNext());
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", new Object[] { Integer.valueOf(localArrayList.size()), localArrayList.toString() });
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(23562);
      return localArrayList;
      ac.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.a
 * JD-Core Version:    0.7.0.1
 */