package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ar
  extends MAutoStorage<aq>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(232354);
    lqL = new String[] { MAutoStorage.getCreateSQLs(aq.nFK, "PluginDevLaunchInfo") };
    AppMethodBeat.o(232354);
  }
  
  public ar(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aq.nFK, "PluginDevLaunchInfo", aq.INDEX_CREATE);
  }
  
  public final long ev(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232352);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("PluginDevLaunchInfoStorage", "getDevKey appId null");
      AppMethodBeat.o(232352);
      return 0L;
    }
    aq localaq = new aq();
    localaq.field_appId = paramString1;
    localaq.field_versionDesc = paramString2;
    if (super.get(localaq, aq.nDP))
    {
      Log.i("PluginDevLaunchInfoStorage", "getDevKey appId:%s,versionDesc:%s success devKey:%d", new Object[] { paramString1, paramString2, Long.valueOf(localaq.field_devKey) });
      long l = localaq.field_devKey;
      AppMethodBeat.o(232352);
      return l;
    }
    Log.i("PluginDevLaunchInfoStorage", "getDevKey appId:%s,versionDesc:%s fail", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(232352);
    return 0L;
  }
  
  public final boolean ew(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232353);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(232353);
      return false;
    }
    aq localaq = new aq();
    localaq.field_appId = paramString1;
    localaq.field_versionDesc = paramString2;
    if (super.delete(localaq, aq.nDP))
    {
      AppMethodBeat.o(232353);
      return true;
    }
    AppMethodBeat.o(232353);
    return false;
  }
  
  public final boolean j(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(232349);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(232349);
      return false;
    }
    aq localaq = new aq();
    localaq.field_appId = paramString1;
    localaq.field_versionDesc = paramString2;
    localaq.field_devKey = paramLong;
    boolean bool;
    if (super.get(localaq, aq.nDP))
    {
      localaq.field_devKey = paramLong;
      bool = super.update(localaq, new String[0]);
      Log.i("PluginDevLaunchInfoStorage", "setPluginInfo update appId:%s,versionDesc:%s,devUin:%d ret:%b", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), Boolean.valueOf(bool) });
    }
    for (;;)
    {
      AppMethodBeat.o(232349);
      return bool;
      bool = super.insert(localaq);
      Log.i("PluginDevLaunchInfoStorage", "setPluginInfo insert appId:%s,versionDesc:%s,devUin:%d ret:%b", new Object[] { paramString1, paramString2, Long.valueOf(paramLong), Boolean.valueOf(bool) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ar
 * JD-Core Version:    0.7.0.1
 */