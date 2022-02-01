package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends j<b>
{
  public static final String[] hGX;
  
  static
  {
    AppMethodBeat.i(223022);
    hGX = new String[] { j.getCreateSQLs(b.jJU, "WxaCheckDemoInfo") };
    AppMethodBeat.o(223022);
  }
  
  public c(e parame)
  {
    super(parame, b.jJU, "WxaCheckDemoInfo", b.INDEX_CREATE);
  }
  
  private boolean aC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223018);
    b localb = new b();
    localb.field_appId = paramString;
    boolean bool = get(localb, new String[0]);
    localb.field_permissionDemo = paramBoolean;
    localb.field_versiontime = bu.aRi();
    if (bool)
    {
      paramBoolean = update(localb, new String[0]);
      AppMethodBeat.o(223018);
      return paramBoolean;
    }
    paramBoolean = insert(localb);
    AppMethodBeat.o(223018);
    return paramBoolean;
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(223020);
    ae.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "delete appId(%s)", new Object[] { paramString });
    b localb = new b();
    localb.field_appId = paramString;
    boolean bool = delete(localb, new String[0]);
    AppMethodBeat.o(223020);
    return bool;
  }
  
  public final int NZ(String paramString)
  {
    AppMethodBeat.i(223019);
    try
    {
      b localb = new b();
      localb.field_appId = paramString;
      if (get(localb, new String[0]))
      {
        ae.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "found info with appId(%s) versiontime(%d)", new Object[] { paramString, Long.valueOf(localb.field_versiontime) });
        long l = bu.rZ(localb.field_versiontime);
        if (l > 86400L)
        {
          AppMethodBeat.o(223019);
          return 0;
        }
        boolean bool = localb.field_permissionDemo;
        if (bool)
        {
          AppMethodBeat.o(223019);
          return 2;
        }
        AppMethodBeat.o(223019);
        return 1;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(223019);
      return 0;
    }
    AppMethodBeat.o(223019);
    return 0;
  }
  
  public final boolean aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223017);
    if (bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData,invalid input %s", new Object[] { paramString });
      AppMethodBeat.o(223017);
      return false;
    }
    if (aC(paramString, paramBoolean))
    {
      ae.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData appId:%s ok", new Object[] { paramString });
      AppMethodBeat.o(223017);
      return true;
    }
    AppMethodBeat.o(223017);
    return false;
  }
  
  public final void bdi()
  {
    AppMethodBeat.i(223021);
    try
    {
      ae.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "deleteAll");
      super.execSQL("WxaCheckDemoInfo", "delete from WxaCheckDemoInfo");
      AppMethodBeat.o(223021);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", localException, " deleteAll Exception", new Object[0]);
      AppMethodBeat.o(223021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.c
 * JD-Core Version:    0.7.0.1
 */