package com.tencent.mm.al;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends MAutoStorage<h>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(124085);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(h.info, "BizKF") };
    AppMethodBeat.o(124085);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.info, "BizKF", null);
    AppMethodBeat.i(124077);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
    paramISQLiteDatabase.execSQL("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    AppMethodBeat.o(124077);
  }
  
  public static boolean a(h paramh)
  {
    AppMethodBeat.i(124079);
    if (paramh != null)
    {
      if (System.currentTimeMillis() - paramh.field_updateTime >= 86400000L)
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
  
  private boolean b(h paramh)
  {
    AppMethodBeat.i(124080);
    if ((paramh == null) || (Util.isNullOrNil(paramh.field_openId)) || (Util.isNullOrNil(paramh.field_brandUsername)))
    {
      Log.w("MicroMsg.BizKFStorage", "wrong argument");
      AppMethodBeat.o(124080);
      return false;
    }
    ContentValues localContentValues = paramh.convertTo();
    if (this.db.replace("BizKF", h.info.primaryKey, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", new Object[] { paramh.field_openId, paramh.field_brandUsername, Boolean.valueOf(bool) });
      AppMethodBeat.o(124080);
      return bool;
    }
  }
  
  public final h Nm(String paramString)
  {
    AppMethodBeat.i(124078);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(124078);
      return null;
    }
    Cursor localCursor = this.db.query("BizKF", null, "openId=?", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      Log.w("MicroMsg.BizKFStorage", "get null with openId:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(124078);
      return null;
    }
    paramString = new h();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(124078);
    return paramString;
  }
  
  public final h Nn(String paramString)
  {
    AppMethodBeat.i(124081);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124081);
      return null;
    }
    Cursor localCursor = this.db.query("BizKF", null, "brandUsername = ? order by kfType desc ", new String[] { paramString }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      Log.w("MicroMsg.BizKFStorage", "get null with brandUsername:".concat(String.valueOf(paramString)));
      localCursor.close();
      AppMethodBeat.o(124081);
      return null;
    }
    paramString = new h();
    paramString.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(124081);
    return paramString;
  }
  
  public final int No(String paramString)
  {
    AppMethodBeat.i(124082);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(124082);
      return -1;
    }
    int i = this.db.delete("BizKF", "brandUsername = ?", new String[] { paramString });
    Log.i("MicroMsg.BizKFStorage", "deleteKFWorker by brand username(u:%s, r:%d).", new Object[] { paramString, Integer.valueOf(i) });
    AppMethodBeat.o(124082);
    return i;
  }
  
  public final int f(LinkedList<h> paramLinkedList)
  {
    AppMethodBeat.i(124083);
    if (paramLinkedList.size() <= 0)
    {
      Log.e("MicroMsg.BizKFStorage", "null kfs");
      AppMethodBeat.o(124083);
      return 0;
    }
    if ((this.db instanceof com.tencent.mm.storagebase.h)) {}
    for (long l = ((com.tencent.mm.storagebase.h)this.db).beginTransaction(Thread.currentThread().getId());; l = 0L)
    {
      paramLinkedList = paramLinkedList.iterator();
      int i = 0;
      if (paramLinkedList.hasNext())
      {
        h localh = (h)paramLinkedList.next();
        if ((localh == null) || (!b(localh))) {
          break label147;
        }
        i += 1;
      }
      label147:
      for (;;)
      {
        break;
        if ((this.db instanceof com.tencent.mm.storagebase.h)) {
          g.aAh().hqK.endTransaction(l);
        }
        Log.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124083);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.j
 * JD-Core Version:    0.7.0.1
 */