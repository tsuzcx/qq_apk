package com.tencent.mm.am;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends j<g>
{
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(124085);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "BizKF") };
    AppMethodBeat.o(124085);
  }
  
  public i(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, g.info, "BizKF", null);
    AppMethodBeat.i(124077);
    this.db = parame;
    parame.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
    parame.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    AppMethodBeat.o(124077);
  }
  
  public static boolean a(g paramg)
  {
    AppMethodBeat.i(124079);
    if (paramg != null)
    {
      if (System.currentTimeMillis() - paramg.field_updateTime >= 86400000L)
      {
        AppMethodBeat.o(124079);
        return true;
      }
      AppMethodBeat.o(124079);
      return false;
    }
    AppMethodBeat.o(124079);
    return false;
  }
  
  private boolean b(g paramg)
  {
    AppMethodBeat.i(124080);
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_openId)) || (bt.isNullOrNil(paramg.field_brandUsername)))
    {
      ad.w("MicroMsg.BizKFStorage", "wrong argument");
      AppMethodBeat.o(124080);
      return false;
    }
    ContentValues localContentValues = paramg.convertTo();
    if (this.db.replace("BizKF", g.info.EYu, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[] { paramg.field_openId, paramg.field_brandUsername, Boolean.valueOf(bool) });
      AppMethodBeat.o(124080);
      return bool;
    }
  }
  
  public final int f(LinkedList<g> paramLinkedList)
  {
    AppMethodBeat.i(124083);
    if (paramLinkedList.size() <= 0)
    {
      ad.e("MicroMsg.BizKFStorage", "null kfs");
      AppMethodBeat.o(124083);
      return 0;
    }
    if ((this.db instanceof h)) {}
    for (long l = ((h)this.db).rb(Thread.currentThread().getId());; l = 0L)
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      if (paramLinkedList.hasNext())
      {
        g localg = (g)paramLinkedList.next();
        if ((localg == null) || (!b(localg))) {
          break label147;
        }
        i += 1;
      }
      label147:
      for (;;)
      {
        break;
        if ((this.db instanceof h)) {
          com.tencent.mm.kernel.g.afB().gda.mX(l);
        }
        ad.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124083);
        return i;
      }
    }
  }
  
  public final g wR(String paramString)
  {
    AppMethodBeat.i(124078);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(124078);
      return null;
    }
    Cursor localCursor = this.db.a("BizKF", null, "openId=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ad.w("MicroMsg.BizKFStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(124078);
      return null;
    }
    paramString = new g();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(124078);
    return paramString;
  }
  
  public final g wS(String paramString)
  {
    AppMethodBeat.i(124081);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124081);
      return null;
    }
    Cursor localCursor = this.db.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ad.w("MicroMsg.BizKFStorage", "get null with brandUsername:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(124081);
      return null;
    }
    paramString = new g();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(124081);
    return paramString;
  }
  
  public final int wT(String paramString)
  {
    AppMethodBeat.i(124082);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124082);
      return -1;
    }
    int i = this.db.delete("BizKF", "brandUsername = ?", new String[] { paramString });
    ad.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(124082);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.i
 * JD-Core Version:    0.7.0.1
 */