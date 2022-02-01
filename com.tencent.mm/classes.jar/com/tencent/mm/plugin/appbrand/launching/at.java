package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class at
  extends MAutoStorage<as>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(320709);
    nVW = new String[] { MAutoStorage.getCreateSQLs(as.DB_INFO, "PluginDevLaunchInfo") };
    AppMethodBeat.o(320709);
  }
  
  public at(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, as.DB_INFO, "PluginDevLaunchInfo", as.INDEX_CREATE);
  }
  
  public final long eN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320721);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("PluginDevLaunchInfoStorage", "getDevKey appId null");
      AppMethodBeat.o(320721);
      return 0L;
    }
    as localas = new as();
    localas.field_appId = paramString1;
    localas.field_versionDesc = paramString2;
    if (super.get(localas, as.qDJ))
    {
      Log.i("PluginDevLaunchInfoStorage", "getDevKey appId:%s,versionDesc:%s success devKey:%d", new Object[] { paramString1, paramString2, Long.valueOf(localas.field_devKey) });
      long l = localas.field_devKey;
      AppMethodBeat.o(320721);
      return l;
    }
    Log.i("PluginDevLaunchInfoStorage", "getDevKey appId:%s,versionDesc:%s fail", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(320721);
    return 0L;
  }
  
  public final boolean eO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320727);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(320727);
      return false;
    }
    as localas = new as();
    localas.field_appId = paramString1;
    localas.field_versionDesc = paramString2;
    if (super.delete(localas, as.qDJ))
    {
      AppMethodBeat.o(320727);
      return true;
    }
    AppMethodBeat.o(320727);
    return false;
  }
  
  public final boolean j(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(320718);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(320718);
      return false;
    }
    as localas = new as();
    localas.field_appId = paramString1;
    localas.field_versionDesc = paramString2;
    localas.field_devKey = paramLong;
    boolean bool;
    if (super.get(localas, as.qDJ))
    {
      localas.field_devKey = paramLong;
      bool = super.update(localas, new String[0]);
      Log.i("PluginDevLaunchInfoStorage", "setPluginInfo update appId:%s,versionDesc:%s,devUin:%d ret:%b", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(320718);
      return bool;
      bool = super.insert(localas);
      Log.i("PluginDevLaunchInfoStorage", "setPluginInfo insert appId:%s,versionDesc:%s,devUin:%d ret:%b", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), Boolean.valueOf(bool) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.at
 * JD-Core Version:    0.7.0.1
 */