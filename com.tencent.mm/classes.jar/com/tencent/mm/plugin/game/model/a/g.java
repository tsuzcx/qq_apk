package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends j<d>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(41699);
    SQL_CREATE = new String[] { j.getCreateSQLs(d.info, "GameSilentDownload") };
    AppMethodBeat.o(41699);
  }
  
  public g(e parame)
  {
    super(parame, d.info, "GameSilentDownload", null);
  }
  
  public final boolean ahA(String paramString)
  {
    AppMethodBeat.i(41693);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
      AppMethodBeat.o(41693);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41693);
      return false;
    }
    paramString.field_noWifi = false;
    boolean bool = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41693);
    return bool;
  }
  
  public final boolean ahB(String paramString)
  {
    AppMethodBeat.i(41694);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
      AppMethodBeat.o(41694);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41694);
      return false;
    }
    paramString.field_noSdcard = false;
    boolean bool = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41694);
    return bool;
  }
  
  public final boolean ahC(String paramString)
  {
    AppMethodBeat.i(41695);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
      AppMethodBeat.o(41695);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41695);
      return false;
    }
    paramString.field_noEnoughSpace = false;
    boolean bool = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41695);
    return bool;
  }
  
  public final boolean ahD(String paramString)
  {
    AppMethodBeat.i(41696);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
      AppMethodBeat.o(41696);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41696);
      return false;
    }
    paramString.field_lowBattery = false;
    boolean bool = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41696);
    return bool;
  }
  
  public final boolean ahE(String paramString)
  {
    AppMethodBeat.i(41697);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
      AppMethodBeat.o(41697);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41697);
      return false;
    }
    paramString.field_continueDelay = false;
    boolean bool = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41697);
    return bool;
  }
  
  public final d ahz(String paramString)
  {
    AppMethodBeat.i(41689);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
      AppMethodBeat.o(41689);
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "GameSilentDownload", "appId" }), new String[] { paramString });
    if (localCursor == null)
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
      AppMethodBeat.o(41689);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new d();
      paramString.convertFrom(localCursor);
      localCursor.close();
      AppMethodBeat.o(41689);
      return paramString;
    }
    ac.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    AppMethodBeat.o(41689);
    return null;
  }
  
  public final boolean av(String paramString, long paramLong)
  {
    AppMethodBeat.i(41691);
    if ((bs.isNullOrNil(paramString)) || (paramLong < 0L))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
      AppMethodBeat.o(41691);
      return false;
    }
    boolean bool = execSQL("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[] { "GameSilentDownload", "nextCheckTime", String.valueOf(paramLong), "appId", paramString }));
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41691);
    return bool;
  }
  
  public final boolean bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41692);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
      AppMethodBeat.o(41692);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41692);
      return false;
    }
    paramString.field_isRunning = paramBoolean;
    paramBoolean = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(41692);
    return paramBoolean;
  }
  
  public final List<d> cRe()
  {
    AppMethodBeat.i(41690);
    Cursor localCursor = rawQuery(String.format("select * from %s", new Object[] { "GameSilentDownload" }), new String[0]);
    if (localCursor == null)
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
      AppMethodBeat.o(41690);
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
      ac.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
      AppMethodBeat.o(41690);
      return localArrayList;
    }
    localCursor.close();
    ac.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
    AppMethodBeat.o(41690);
    return null;
  }
  
  public final boolean dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(41698);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.GameSilentDownloadStorage", "updateForceUpdateFlag: appid is null");
      AppMethodBeat.o(41698);
      return false;
    }
    paramString = ahz(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(41698);
      return false;
    }
    paramString.field_forceUpdateFlag = paramInt;
    boolean bool = super.update(paramString, new String[0]);
    ac.i("MicroMsg.GameSilentDownloadStorage", "updateForceUpdateFlag, ret:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(41698);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.g
 * JD-Core Version:    0.7.0.1
 */