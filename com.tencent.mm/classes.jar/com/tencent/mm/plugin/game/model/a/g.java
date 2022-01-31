package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends j<d>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(111533);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "GameSilentDownload") };
    AppMethodBeat.o(111533);
  }
  
  public g(e parame)
  {
    super(parame, d.info, "GameSilentDownload", null);
  }
  
  public final d Qi(String paramString)
  {
    AppMethodBeat.i(111524);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
      AppMethodBeat.o(111524);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "GameSilentDownload", "appId" }), new String[] { paramString });
    if (localCursor == null)
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
      AppMethodBeat.o(111524);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new d();
      paramString.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(111524);
      return paramString;
    }
    ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(111524);
    return null;
  }
  
  public final boolean Qj(String paramString)
  {
    AppMethodBeat.i(111528);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
      AppMethodBeat.o(111528);
      return false;
    }
    paramString = Qi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(111528);
      return false;
    }
    paramString.field_noWifi = false;
    boolean bool = super.update(paramString, new String[0]);
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(111528);
    return bool;
  }
  
  public final boolean Qk(String paramString)
  {
    AppMethodBeat.i(111529);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
      AppMethodBeat.o(111529);
      return false;
    }
    paramString = Qi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(111529);
      return false;
    }
    paramString.field_noSdcard = false;
    boolean bool = super.update(paramString, new String[0]);
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(111529);
    return bool;
  }
  
  public final boolean Ql(String paramString)
  {
    AppMethodBeat.i(111530);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
      AppMethodBeat.o(111530);
      return false;
    }
    paramString = Qi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(111530);
      return false;
    }
    paramString.field_noEnoughSpace = false;
    boolean bool = super.update(paramString, new String[0]);
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(111530);
    return bool;
  }
  
  public final boolean Qm(String paramString)
  {
    AppMethodBeat.i(111531);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
      AppMethodBeat.o(111531);
      return false;
    }
    paramString = Qi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(111531);
      return false;
    }
    paramString.field_lowBattery = false;
    boolean bool = super.update(paramString, new String[0]);
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(111531);
    return bool;
  }
  
  public final boolean Qn(String paramString)
  {
    AppMethodBeat.i(111532);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
      AppMethodBeat.o(111532);
      return false;
    }
    paramString = Qi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(111532);
      return false;
    }
    paramString.field_continueDelay = false;
    boolean bool = super.update(paramString, new String[0]);
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(111532);
    return bool;
  }
  
  public final boolean X(String paramString, long paramLong)
  {
    AppMethodBeat.i(111526);
    if ((bo.isNullOrNil(paramString)) || (paramLong < 0L))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
      AppMethodBeat.o(111526);
      return false;
    }
    boolean bool = execSQL("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[] { "GameSilentDownload", "nextCheckTime", String.valueOf(paramLong), "appId", paramString }));
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(111526);
    return bool;
  }
  
  public final boolean aW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(111527);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
      AppMethodBeat.o(111527);
      return false;
    }
    paramString = Qi(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(111527);
      return false;
    }
    paramString.field_isRunning = paramBoolean;
    paramBoolean = super.update(paramString, new String[0]);
    ab.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(111527);
    return paramBoolean;
  }
  
  public final d bGZ()
  {
    AppMethodBeat.i(111523);
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[] { "GameSilentDownload", "isRunning" }), new String[0]);
    if (localCursor == null)
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
      AppMethodBeat.o(111523);
      return null;
    }
    d locald;
    if (localCursor.moveToFirst())
    {
      locald = new d();
      locald.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(111523);
      return locald;
    }
    ab.i("MicroMsg.GameSilentDownloadStorage", "no running task");
    localCursor.close();
    localCursor = rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[] { "GameSilentDownload", "nextCheckTime" }), new String[] { String.valueOf(bo.aox()) });
    if (localCursor == null)
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
      AppMethodBeat.o(111523);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      locald = new d();
      locald.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(111523);
      return locald;
    }
    localCursor.close();
    ab.i("MicroMsg.GameSilentDownloadStorage", "no record");
    AppMethodBeat.o(111523);
    return null;
  }
  
  public final List<d> bHa()
  {
    AppMethodBeat.i(111525);
    Cursor localCursor = rawQuery(String.format("select * from %s", new Object[] { "GameSilentDownload" }), new String[0]);
    if (localCursor == null)
    {
      ab.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
      AppMethodBeat.o(111525);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        d locald = new d();
        locald.convertFrom(localCursor);
        localArrayList.add(locald);
      } while (localCursor.moveToNext());
      localCursor.close();
      ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
      AppMethodBeat.o(111525);
      return localArrayList;
    }
    localCursor.close();
    ab.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
    AppMethodBeat.o(111525);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.g
 * JD-Core Version:    0.7.0.1
 */