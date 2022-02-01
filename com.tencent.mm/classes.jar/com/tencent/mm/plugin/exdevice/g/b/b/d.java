package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d
  extends j<com.tencent.mm.plugin.exdevice.g.b.a.d>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(23582);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.d.info, "HardDeviceRankInfo") };
    AppMethodBeat.o(23582);
  }
  
  public d(e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.g.b.a.d.info, "HardDeviceRankInfo", null);
    AppMethodBeat.i(23576);
    this.db = parame;
    parame.execSQL("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
    AppMethodBeat.o(23576);
  }
  
  private boolean c(com.tencent.mm.plugin.exdevice.g.b.a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23581);
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      insert(paramd);
      ae.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
      if (paramBoolean) {
        ad.cmS().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      }
      AppMethodBeat.o(23581);
      return true;
    }
  }
  
  public final com.tencent.mm.plugin.exdevice.g.b.a.d a(com.tencent.mm.plugin.exdevice.g.b.d paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(23577);
    Object localObject2 = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[] { "HardDeviceRankInfo", "rankID", "username" });
    localObject2 = this.db.a((String)localObject2, new String[] { bu.bI(paramd.qlH, ""), bu.bI(paramd.username, "") }, 2);
    if (localObject2 == null)
    {
      ae.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
      AppMethodBeat.o(23577);
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramd = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      paramd.convertFrom((Cursor)localObject2);
    }
    for (;;)
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(23577);
      return paramd;
      ae.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
      paramd = localObject1;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.g.b.a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23579);
    if (b(paramd, paramBoolean))
    {
      AppMethodBeat.o(23579);
      return true;
    }
    c(paramd, paramBoolean);
    AppMethodBeat.o(23579);
    return true;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.g.b.a.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23580);
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      com.tencent.mm.plugin.exdevice.g.b.a.d locald = a(new com.tencent.mm.plugin.exdevice.g.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      if (locald == null) {
        break;
      }
      locald.field_likecount = paramd.field_likecount;
      locald.field_selfLikeState = paramd.field_selfLikeState;
      update(locald, new String[] { "rankID", "username" });
      ae.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
      if (paramBoolean) {
        ad.cmS().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      }
      AppMethodBeat.o(23580);
      return true;
    }
    AppMethodBeat.o(23580);
    return false;
  }
  
  public final void f(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(23578);
    if ((bu.isNullOrNil(paramString)) || (paramArrayList == null))
    {
      ae.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
      AppMethodBeat.o(23578);
      return;
    }
    ae.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    int i = 0;
    while (i < paramArrayList.size())
    {
      a((com.tencent.mm.plugin.exdevice.g.b.a.d)paramArrayList.get(i), false);
      i += 1;
    }
    ad.cmS().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(paramString, null, null));
    AppMethodBeat.o(23578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.d
 * JD-Core Version:    0.7.0.1
 */