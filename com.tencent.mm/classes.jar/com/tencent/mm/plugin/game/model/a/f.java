package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "GameSilentDownload") };
  
  public f(e parame)
  {
    super(parame, c.buS, "GameSilentDownload", null);
  }
  
  public final c EQ(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
      return null;
    }
    Cursor localCursor = rawQuery(String.format("select * from %s where %s=?", new Object[] { "GameSilentDownload", "appId" }), new String[] { paramString });
    if (localCursor == null)
    {
      y.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new c();
      paramString.d(localCursor);
      localCursor.close();
      return paramString;
    }
    y.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", new Object[] { paramString });
    localCursor.close();
    return null;
  }
  
  public final boolean ER(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
    }
    do
    {
      return false;
      paramString = EQ(paramString);
    } while (paramString == null);
    paramString.field_noWifi = false;
    boolean bool = super.c(paramString, new String[0]);
    y.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean ES(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
    }
    do
    {
      return false;
      paramString = EQ(paramString);
    } while (paramString == null);
    paramString.field_noSdcard = false;
    boolean bool = super.c(paramString, new String[0]);
    y.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean ET(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
    }
    do
    {
      return false;
      paramString = EQ(paramString);
    } while (paramString == null);
    paramString.field_noEnoughSpace = false;
    boolean bool = super.c(paramString, new String[0]);
    y.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean EU(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
    }
    do
    {
      return false;
      paramString = EQ(paramString);
    } while (paramString == null);
    paramString.field_lowBattery = false;
    boolean bool = super.c(paramString, new String[0]);
    y.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean EV(String paramString)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
    }
    do
    {
      return false;
      paramString = EQ(paramString);
    } while (paramString == null);
    paramString.field_continueDelay = false;
    boolean bool = super.c(paramString, new String[0]);
    y.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean F(String paramString, long paramLong)
  {
    if ((bk.bl(paramString)) || (paramLong < 0L))
    {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
      return false;
    }
    boolean bool = gk("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", new Object[] { "GameSilentDownload", "nextCheckTime", String.valueOf(paramLong), "appId", paramString }));
    y.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public final boolean aH(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {
      y.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
    }
    do
    {
      return false;
      paramString = EQ(paramString);
    } while (paramString == null);
    paramString.field_isRunning = paramBoolean;
    paramBoolean = super.c(paramString, new String[0]);
    y.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.f
 * JD-Core Version:    0.7.0.1
 */