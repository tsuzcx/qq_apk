package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class i
  extends MAutoStorage<j>
{
  public static final String mWc;
  
  static
  {
    AppMethodBeat.i(76409);
    mWc = MAutoStorage.getCreateSQLs(j.kLR, "LaunchWxaWidgetRespData");
    AppMethodBeat.o(76409);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, j.kLR, "LaunchWxaWidgetRespData", j.INDEX_CREATE);
  }
  
  private boolean a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(76403);
    paramj.field_appIdHash = paramj.field_appId.hashCode();
    super.insertNotify(paramj, paramBoolean);
    paramBoolean = a(paramj, new String[] { "appId" });
    AppMethodBeat.o(76403);
    return paramBoolean;
  }
  
  private boolean a(j paramj, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(76404);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramj.field_appIdHash = paramj.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramj, paramBoolean, paramVarArgs);
        AppMethodBeat.o(76404);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final j U(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76401);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76401);
      return null;
    }
    j localj = new j();
    localj.field_appIdHash = paramString.hashCode();
    localj.field_appId = paramString;
    localj.field_pkgType = paramInt1;
    localj.field_widgetType = paramInt2;
    if (a(localj, new String[] { "appId", "pkgType", "widgetType" }))
    {
      AppMethodBeat.o(76401);
      return localj;
    }
    AppMethodBeat.o(76401);
    return null;
  }
  
  public final j a(String paramString, int paramInt1, int paramInt2, chg paramchg)
  {
    AppMethodBeat.i(76400);
    if ((Util.isNullOrNil(paramString)) || (paramchg == null))
    {
      AppMethodBeat.o(76400);
      return null;
    }
    j localj = new j();
    localj.field_appIdHash = paramString.hashCode();
    localj.field_appId = paramString;
    localj.field_pkgType = paramInt1;
    localj.field_widgetType = paramInt2;
    if (!a(localj, new String[] { "appId", "pkgType", "widgetType" }))
    {
      paramInt2 = 1;
      if (com.tencent.mm.plugin.appbrand.ac.j.a(localj.field_launchAction, paramchg.MmG)) {
        break label291;
      }
      localj.field_launchAction = paramchg.MmG;
    }
    label261:
    label291:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!com.tencent.mm.plugin.appbrand.ac.j.a(localj.field_jsApiInfo, paramchg.MmA))
      {
        localj.field_jsApiInfo = paramchg.MmA;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.ac.j.a(localj.field_versionInfo, paramchg.MmH))
      {
        localj.field_versionInfo = paramchg.MmH;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.ac.j.a(localj.field_widgetSetting, paramchg.MmI))
      {
        localj.field_widgetSetting = paramchg.MmI;
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramInt2 == 0) {
          break label261;
        }
        a(localj, false);
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          a(localj, new String[] { "appId", "pkgType", "widgetType" });
        }
        AppMethodBeat.o(76400);
        return localj;
        paramInt2 = 0;
        break;
        a(localj, false, new String[] { "appId", "pkgType", "widgetType" });
      }
    }
  }
  
  public final boolean a(j paramj, String... paramVarArgs)
  {
    AppMethodBeat.i(76402);
    int i;
    if (!Util.isNullOrNil(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramj.field_appIdHash = paramj.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramj, paramVarArgs);
        AppMethodBeat.o(76402);
        return bool;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i
 * JD-Core Version:    0.7.0.1
 */