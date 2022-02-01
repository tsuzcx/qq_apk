package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c
  extends MAutoStorage<b>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(318603);
    nVW = new String[] { MAutoStorage.getCreateSQLs(b.DB_INFO, "WxaCheckDemoInfo") };
    AppMethodBeat.o(318603);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.DB_INFO, "WxaCheckDemoInfo", b.INDEX_CREATE);
  }
  
  private boolean aS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(318601);
    b localb = new b();
    localb.field_appId = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_permissionDemo = paramBoolean;
    localb.field_versiontime = Util.nowSecond();
    if (bool)
    {
      paramBoolean = update(localb, new String[0]);
      AppMethodBeat.o(318601);
      return paramBoolean;
    }
    paramBoolean = insert(localb);
    AppMethodBeat.o(318601);
    return paramBoolean;
  }
  
  public final int Xw(String paramString)
  {
    AppMethodBeat.i(318633);
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
          AppMethodBeat.o(318633);
          return 0;
        }
        boolean bool = localb.field_permissionDemo;
        if (bool)
        {
          AppMethodBeat.o(318633);
          return 2;
        }
        AppMethodBeat.o(318633);
        return 1;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(318633);
      return 0;
    }
    AppMethodBeat.o(318633);
    return 0;
  }
  
  public final boolean aR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(318625);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData,invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(318625);
      return false;
    }
    if (aS(paramString, paramBoolean))
    {
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData appId:%s ok", new Object[] { paramString });
      AppMethodBeat.o(318625);
      return true;
    }
    AppMethodBeat.o(318625);
    return false;
  }
  
  public final void cju()
  {
    AppMethodBeat.i(318646);
    try
    {
      Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "deleteAll");
      super.execSQL("WxaCheckDemoInfo", "delete from WxaCheckDemoInfo");
      AppMethodBeat.o(318646);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", localException, " deleteAll Exception", new Object[0]);
      AppMethodBeat.o(318646);
    }
  }
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(318639);
    Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "delete appId(%s)", new Object[] { paramString });
    b localb = new b();
    localb.field_appId = paramString;
    boolean bool = delete(localb, new String[0]);
    AppMethodBeat.o(318639);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.c
 * JD-Core Version:    0.7.0.1
 */