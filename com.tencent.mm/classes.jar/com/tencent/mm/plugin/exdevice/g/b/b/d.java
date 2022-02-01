package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d
  extends MAutoStorage<com.tencent.mm.plugin.exdevice.g.b.a.d>
{
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(23582);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.d.info, "HardDeviceRankInfo") };
    AppMethodBeat.o(23582);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.exdevice.g.b.a.d.info, "HardDeviceRankInfo", null);
    AppMethodBeat.i(23576);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
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
      Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
      if (paramBoolean) {
        ah.dGa().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
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
    localObject2 = this.db.rawQuery((String)localObject2, new String[] { Util.nullAs(paramd.yuk, ""), Util.nullAs(paramd.username, "") }, 2);
    if (localObject2 == null)
    {
      Log.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
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
      Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
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
    if (c(paramd, paramBoolean))
    {
      AppMethodBeat.o(23579);
      return true;
    }
    AppMethodBeat.o(23579);
    return false;
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
      Log.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
      if (paramBoolean) {
        ah.dGa().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(paramd.field_rankID, paramd.field_appusername, paramd.field_username));
      }
      AppMethodBeat.o(23580);
      return true;
    }
    AppMethodBeat.o(23580);
    return false;
  }
  
  public final void g(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(23578);
    if ((Util.isNullOrNil(paramString)) || (paramArrayList == null))
    {
      Log.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
      AppMethodBeat.o(23578);
      return;
    }
    Log.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", new Object[] { paramString, Integer.valueOf(paramArrayList.size()) });
    int i = 0;
    while (i < paramArrayList.size())
    {
      a((com.tencent.mm.plugin.exdevice.g.b.a.d)paramArrayList.get(i), false);
      i += 1;
    }
    ah.dGa().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.g.b.d(paramString, null, null));
    AppMethodBeat.o(23578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.d
 * JD-Core Version:    0.7.0.1
 */