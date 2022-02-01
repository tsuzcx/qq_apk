package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e
  extends MAutoStorage<com.tencent.mm.plugin.exdevice.g.b.a.e>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(23586);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.e.info, "HardDeviceLikeUser") };
    AppMethodBeat.o(23586);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.exdevice.g.b.a.e.info, "HardDeviceLikeUser", null);
    AppMethodBeat.i(23583);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    AppMethodBeat.o(23583);
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> paramArrayList)
  {
    AppMethodBeat.i(23585);
    if (!Util.isNullOrNil(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList != null) {
        break;
      }
      Log.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
      AppMethodBeat.o(23585);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.g.b.a.e locale = (com.tencent.mm.plugin.exdevice.g.b.a.e)paramArrayList.next();
      if (locale != null) {}
      for (bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        if (!update(locale, new String[] { "rankID", "username" })) {
          break label122;
        }
        Log.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
        break;
      }
      label122:
      if (insert(locale)) {
        Log.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
      } else {
        Log.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
      }
    }
    ae.cZH().a("HardDeviceLikeUser", new d(paramString1, paramString2, null));
    AppMethodBeat.o(23585);
  }
  
  public final ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> avF(String paramString)
  {
    com.tencent.mm.plugin.exdevice.g.b.a.e locale = null;
    AppMethodBeat.i(23584);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
      AppMethodBeat.o(23584);
      return null;
    }
    Object localObject = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceLikeUser", "rankID", "timestamp" });
    localObject = this.db.rawQuery((String)localObject, new String[] { Util.nullAs(paramString, "") }, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
      AppMethodBeat.o(23584);
      return null;
    }
    paramString = locale;
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        locale = new com.tencent.mm.plugin.exdevice.g.b.a.e();
        locale.convertFrom((Cursor)localObject);
        paramString.add(locale);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(23584);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.e
 * JD-Core Version:    0.7.0.1
 */