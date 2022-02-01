package com.tencent.mm.plugin.exdevice.g.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a;
import com.tencent.mm.plugin.exdevice.g.b.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e
  extends j<com.tencent.mm.plugin.exdevice.g.b.a.e>
{
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(23586);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.exdevice.g.b.a.e.info, "HardDeviceLikeUser") };
    AppMethodBeat.o(23586);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.g.b.a.e.info, "HardDeviceLikeUser", null);
    AppMethodBeat.i(23583);
    this.db = parame;
    parame.execSQL("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    AppMethodBeat.o(23583);
  }
  
  public final ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> UO(String paramString)
  {
    com.tencent.mm.plugin.exdevice.g.b.a.e locale = null;
    AppMethodBeat.i(23584);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
      AppMethodBeat.o(23584);
      return null;
    }
    Object localObject = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceLikeUser", "rankID", "timestamp" });
    localObject = this.db.a((String)localObject, new String[] { bt.by(paramString, "") }, 2);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
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
  
  public final void b(String paramString1, String paramString2, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.e> paramArrayList)
  {
    AppMethodBeat.i(23585);
    if (!bt.isNullOrNil(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
        break;
      }
      label122:
      if (insert(locale)) {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
      } else {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
      }
    }
    com.tencent.mm.plugin.exdevice.model.ad.bZP().a("HardDeviceLikeUser", new d(paramString1, paramString2, null));
    AppMethodBeat.o(23585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.b.e
 * JD-Core Version:    0.7.0.1
 */