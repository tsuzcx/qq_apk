package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends j<g>
{
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(11400);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "BizKF") };
    AppMethodBeat.o(11400);
  }
  
  public i(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, g.info, "BizKF", null);
    AppMethodBeat.i(11392);
    this.db = parame;
    parame.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
    parame.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    AppMethodBeat.o(11392);
  }
  
  public static boolean a(g paramg)
  {
    AppMethodBeat.i(11394);
    if (paramg != null)
    {
      if (System.currentTimeMillis() - paramg.field_updateTime >= 86400000L)
      {
        AppMethodBeat.o(11394);
        return true;
      }
      AppMethodBeat.o(11394);
      return false;
    }
    AppMethodBeat.o(11394);
    return false;
  }
  
  private boolean b(g paramg)
  {
    AppMethodBeat.i(11395);
    if ((paramg == null) || (bo.isNullOrNil(paramg.field_openId)) || (bo.isNullOrNil(paramg.field_brandUsername)))
    {
      ab.w("MicroMsg.BizKFStorage", "wrong argument");
      AppMethodBeat.o(11395);
      return false;
    }
    ContentValues localContentValues = paramg.convertTo();
    if (this.db.replace("BizKF", g.info.yrL, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[] { paramg.field_openId, paramg.field_brandUsername, Boolean.valueOf(bool) });
      AppMethodBeat.o(11395);
      return bool;
    }
  }
  
  public final int f(LinkedList<g> paramLinkedList)
  {
    AppMethodBeat.i(11398);
    if (paramLinkedList.size() <= 0)
    {
      ab.e("MicroMsg.BizKFStorage", "null kfs");
      AppMethodBeat.o(11398);
      return 0;
    }
    if ((this.db instanceof h)) {}
    for (long l = ((h)this.db).kr(Thread.currentThread().getId());; l = 0L)
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      if (paramLinkedList.hasNext())
      {
        g localg = (g)paramLinkedList.next();
        if ((localg == null) || (!b(localg))) {
          break label150;
        }
        i += 1;
      }
      label150:
      for (;;)
      {
        break;
        if ((this.db instanceof h)) {
          com.tencent.mm.kernel.g.RL().eHS.nY(l);
        }
        ab.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(11398);
        return i;
      }
    }
  }
  
  public final g sb(String paramString)
  {
    AppMethodBeat.i(11393);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(11393);
      return null;
    }
    Cursor localCursor = this.db.a("BizKF", null, "openId=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.BizKFStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(11393);
      return null;
    }
    paramString = new g();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(11393);
    return paramString;
  }
  
  public final g sc(String paramString)
  {
    AppMethodBeat.i(11396);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11396);
      return null;
    }
    Cursor localCursor = this.db.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      ab.w("MicroMsg.BizKFStorage", "get null with brandUsername:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(11396);
      return null;
    }
    paramString = new g();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(11396);
    return paramString;
  }
  
  public final int sd(String paramString)
  {
    AppMethodBeat.i(11397);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(11397);
      return -1;
    }
    int i = this.db.delete("BizKF", "brandUsername = ?", new String[] { paramString });
    ab.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(11397);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.i
 * JD-Core Version:    0.7.0.1
 */