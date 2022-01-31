package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(19502);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "HardDeviceRankFollowInfo") };
    AppMethodBeat.o(19502);
  }
  
  public a(e parame)
  {
    super(parame, c.info, "HardDeviceRankFollowInfo", null);
    AppMethodBeat.i(19490);
    this.db = parame;
    parame.execSQL("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
    AppMethodBeat.o(19490);
  }
  
  private boolean O(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(19493);
    String str = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[] { "HardDeviceRankFollowInfo", "rankID", "appusername", "username" });
    paramString1 = this.db.a(str, new String[] { bo.bf(paramString1, ""), bo.bf(paramString2, ""), bo.bf(paramString3, "") }, 2);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
      AppMethodBeat.o(19493);
      return false;
    }
    boolean bool = paramString1.moveToFirst();
    paramString1.close();
    ab.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(19493);
    return bool;
  }
  
  private boolean P(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(19499);
    paramString1 = a(new b(paramString1, paramString2, paramString3));
    if (paramString1 != null)
    {
      delete(paramString1, new String[] { "rankID", "appusername", "username" });
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
      AppMethodBeat.o(19499);
      return true;
    }
    AppMethodBeat.o(19499);
    return false;
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(19497);
    if (b(paramc))
    {
      AppMethodBeat.o(19497);
      return true;
    }
    c(paramc);
    AppMethodBeat.o(19497);
    return true;
  }
  
  private boolean b(c paramc)
  {
    AppMethodBeat.i(19500);
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
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
      AppMethodBeat.o(19500);
      return true;
    }
    AppMethodBeat.o(19500);
    return false;
  }
  
  private boolean c(c paramc)
  {
    AppMethodBeat.i(19501);
    if (paramc != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      insert(paramc);
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
      AppMethodBeat.o(19501);
      return true;
    }
  }
  
  public final boolean LC(String paramString)
  {
    AppMethodBeat.i(19492);
    boolean bool = O("hardcode_rank_id", "hardcode_app_name", paramString);
    AppMethodBeat.o(19492);
    return bool;
  }
  
  public final boolean LD(String paramString)
  {
    AppMethodBeat.i(19498);
    boolean bool = P("hardcode_rank_id", "hardcode_app_name", paramString);
    AppMethodBeat.o(19498);
    return bool;
  }
  
  public final c a(b paramb)
  {
    AppMethodBeat.i(19491);
    Object localObject = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[] { "HardDeviceRankFollowInfo", "rankID", "username", "appusername" });
    localObject = this.db.a((String)localObject, new String[] { bo.bf(paramb.lHC, ""), bo.bf(paramb.username, ""), bo.bf(paramb.appName, "") }, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
      AppMethodBeat.o(19491);
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
      AppMethodBeat.o(19491);
      return paramb;
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
    }
  }
  
  public final void a(ArrayList<adu> paramArrayList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(19495);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        adu localadu = (adu)paramArrayList.next();
        c localc = new c();
        localc.field_rankID = paramString1;
        localc.field_step = localadu.hAu;
        localc.field_username = localadu.username;
        localc.field_appusername = paramString2;
        a(localc);
      }
    }
    AppMethodBeat.o(19495);
  }
  
  public final ArrayList<c> bqm()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(19494);
    Object localObject = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[] { "HardDeviceRankFollowInfo", "rankID", "appusername" });
    localObject = this.db.a((String)localObject, new String[] { "hardcode_rank_id", "hardcode_app_name" }, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
      AppMethodBeat.o(19494);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        c localc = new c();
        localc.convertFrom((Cursor)localObject);
        ab.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", new Object[] { Integer.valueOf(((Cursor)localObject).getColumnIndex("rowid")), localc.toString() });
        localArrayList.add(localc);
      } while (((Cursor)localObject).moveToNext());
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", new Object[] { Integer.valueOf(localArrayList.size()), localArrayList.toString() });
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(19494);
      return localArrayList;
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
    }
  }
  
  public final void bv(List<c> paramList)
  {
    AppMethodBeat.i(19496);
    if ((bo.isNullOrNil("hardcode_rank_id")) || (bo.isNullOrNil("hardcode_app_name"))) {
      ab.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
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
      ab.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", new Object[] { "hardcode_rank_id", "hardcode_app_name", Integer.valueOf(this.db.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[] { "hardcode_rank_id", "hardcode_app_name" })) });
    }
    AppMethodBeat.o(19496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.a
 * JD-Core Version:    0.7.0.1
 */