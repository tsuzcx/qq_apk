package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d
  extends j<com.tencent.mm.plugin.exdevice.f.b.a.d>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(19514);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.exdevice.f.b.a.d.info, "HardDeviceRankInfo") };
    AppMethodBeat.o(19514);
  }
  
  public d(e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.f.b.a.d.info, "HardDeviceRankInfo", null);
    AppMethodBeat.i(19508);
    this.db = parame;
    parame.execSQL("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
    AppMethodBeat.o(19508);
  }
  
  private boolean c(com.tencent.mm.plugin.exdevice.f.b.a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(19513);
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      insert(paramd);
      ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
      if (paramBoolean) {
        ad.bqh().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      }
      AppMethodBeat.o(19513);
      return true;
    }
  }
  
  public final com.tencent.mm.plugin.exdevice.f.b.a.d a(com.tencent.mm.plugin.exdevice.f.b.d paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(19509);
    Object localObject2 = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[] { "HardDeviceRankInfo", "rankID", "username" });
    localObject2 = this.db.a((String)localObject2, new String[] { bo.bf(paramd.lHC, ""), bo.bf(paramd.username, "") }, 2);
    if (localObject2 == null)
    {
      ab.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
      AppMethodBeat.o(19509);
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramd = new com.tencent.mm.plugin.exdevice.f.b.a.d();
      paramd.convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(19509);
      return paramd;
      ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
      paramd = localObject1;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(19511);
    if (b(paramd, paramBoolean))
    {
      AppMethodBeat.o(19511);
      return true;
    }
    c(paramd, paramBoolean);
    AppMethodBeat.o(19511);
    return true;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.f.b.a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(19512);
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
      update(locald, new String[] { "rankID", "username" });
      ab.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
      if (paramBoolean) {
        ad.bqh().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      }
      AppMethodBeat.o(19512);
      return true;
    }
    AppMethodBeat.o(19512);
    return false;
  }
  
  public final void g(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(19510);
    if ((bo.isNullOrNil(paramString)) || (paramArrayList == null))
    {
      ab.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
      AppMethodBeat.o(19510);
      return;
    }
    ab.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    int i = 0;
    while (i < paramArrayList.size())
    {
      a((com.tencent.mm.plugin.exdevice.f.b.a.d)paramArrayList.get(i), false);
      i += 1;
    }
    ad.bqh().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(paramString, null, null));
    AppMethodBeat.o(19510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.d
 * JD-Core Version:    0.7.0.1
 */