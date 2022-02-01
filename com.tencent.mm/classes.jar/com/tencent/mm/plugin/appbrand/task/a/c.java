package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c
  extends MAutoStorage<b>
{
  public static final String[] iBh;
  
  static
  {
    AppMethodBeat.i(227539);
    iBh = new String[] { MAutoStorage.getCreateSQLs(b.kLR, "WxaCheckDemoInfo") };
    AppMethodBeat.o(227539);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.kLR, "WxaCheckDemoInfo", b.INDEX_CREATE);
  }
  
  private boolean aE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(227535);
    b localb = new b();
    localb.field_appId = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_permissionDemo = paramBoolean;
    localb.field_versiontime = Util.nowSecond();
    if (bool)
    {
      paramBoolean = update(localb, new String[0]);
      AppMethodBeat.o(227535);
      return paramBoolean;
    }
    paramBoolean = insert(localb);
    AppMethodBeat.o(227535);
    return paramBoolean;
  }
  
  public final int Xi(String paramString)
  {
    AppMethodBeat.i(227536);
    try
    {
      b localb = new b();
      localb.field_appId = paramString;
      if (get(localb, new String[0]))
      {
        Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "found info with appId(%s) versiontime(%d)", new Object[] { paramString, Long.valueOf(localb.field_versiontime) });
        long l = Util.secondsToNow(localb.field_versiontime);
        if (l > 86400L)
        {
          AppMethodBeat.o(227536);
          return 0;
        }
        boolean bool = localb.field_permissionDemo;
        if (bool)
        {
          AppMethodBeat.o(227536);
          return 2;
        }
        AppMethodBeat.o(227536);
        return 1;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(227536);
      return 0;
    }
    AppMethodBeat.o(227536);
    return 0;
  }
  
  public final boolean aD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(227534);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData,invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(227534);
      return false;
    }
    if (aE(paramString, paramBoolean))
    {
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData appId:%s ok", new Object[] { paramString });
      AppMethodBeat.o(227534);
      return true;
    }
    AppMethodBeat.o(227534);
    return false;
  }
  
  public final void byC()
  {
    AppMethodBeat.i(227538);
    try
    {
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "deleteAll");
      super.execSQL("WxaCheckDemoInfo", "delete from WxaCheckDemoInfo");
      AppMethodBeat.o(227538);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", localException, " deleteAll Exception", new Object[0]);
      AppMethodBeat.o(227538);
    }
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(227537);
    Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "delete appId(%s)", new Object[] { paramString });
    b localb = new b();
    localb.field_appId = paramString;
    boolean bool = delete(localb, new String[0]);
    AppMethodBeat.o(227537);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.c
 * JD-Core Version:    0.7.0.1
 */