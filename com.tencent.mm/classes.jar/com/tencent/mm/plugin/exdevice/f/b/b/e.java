package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e
  extends j<com.tencent.mm.plugin.exdevice.f.b.a.e>
{
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(19518);
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.exdevice.f.b.a.e.info, "HardDeviceLikeUser") };
    AppMethodBeat.o(19518);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.exdevice.f.b.a.e.info, "HardDeviceLikeUser", null);
    AppMethodBeat.i(19515);
    this.db = parame;
    parame.execSQL("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    AppMethodBeat.o(19515);
  }
  
  public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> LF(String paramString)
  {
    com.tencent.mm.plugin.exdevice.f.b.a.e locale = null;
    AppMethodBeat.i(19516);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
      AppMethodBeat.o(19516);
      return null;
    }
    Object localObject = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[] { "HardDeviceLikeUser", "rankID", "timestamp" });
    localObject = this.db.a((String)localObject, new String[] { bo.bf(paramString, "") }, 2);
    if (localObject == null)
    {
      ab.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
      AppMethodBeat.o(19516);
      return null;
    }
    paramString = locale;
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new ArrayList();
      do
      {
        locale = new com.tencent.mm.plugin.exdevice.f.b.a.e();
        locale.convertFrom((Cursor)localObject);
        paramString.add(locale);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(19516);
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> paramArrayList)
  {
    AppMethodBeat.i(19517);
    if (!bo.isNullOrNil(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (paramArrayList != null) {
        break;
      }
      ab.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
      AppMethodBeat.o(19517);
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
        if (!update(locale, new String[] { "rankID", "username" })) {
          break label122;
        }
        ab.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
        break;
      }
      label122:
      if (insert(locale)) {
        ab.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
      } else {
        ab.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
      }
    }
    ad.bqh().a("HardDeviceLikeUser", new d(paramString1, paramString2, null));
    AppMethodBeat.o(19517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.b.e
 * JD-Core Version:    0.7.0.1
 */