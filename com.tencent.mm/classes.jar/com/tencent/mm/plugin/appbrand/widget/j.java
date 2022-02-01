package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bs;

public final class j
  extends com.tencent.mm.sdk.e.j<k>
{
  public static final String lna;
  
  static
  {
    AppMethodBeat.i(76409);
    lna = com.tencent.mm.sdk.e.j.getCreateSQLs(k.jmW, "LaunchWxaWidgetRespData");
    AppMethodBeat.o(76409);
  }
  
  public j(e parame)
  {
    super(parame, k.jmW, "LaunchWxaWidgetRespData", k.INDEX_CREATE);
  }
  
  private boolean a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(76403);
    paramk.field_appIdHash = paramk.field_appId.hashCode();
    super.insertNotify(paramk, paramBoolean);
    paramBoolean = a(paramk, new String[] { "appId" });
    AppMethodBeat.o(76403);
    return paramBoolean;
  }
  
  private boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(76404);
    int i;
    if (!bs.T(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramk.field_appIdHash = paramk.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramk, paramBoolean, paramVarArgs);
        AppMethodBeat.o(76404);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final k R(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76401);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76401);
      return null;
    }
    k localk = new k();
    localk.field_appIdHash = paramString.hashCode();
    localk.field_appId = paramString;
    localk.field_pkgType = paramInt1;
    localk.field_widgetType = paramInt2;
    if (a(localk, new String[] { "appId", "pkgType", "widgetType" }))
    {
      AppMethodBeat.o(76401);
      return localk;
    }
    AppMethodBeat.o(76401);
    return null;
  }
  
  public final k a(String paramString, int paramInt1, int paramInt2, bov parambov)
  {
    AppMethodBeat.i(76400);
    if ((bs.isNullOrNil(paramString)) || (parambov == null))
    {
      AppMethodBeat.o(76400);
      return null;
    }
    k localk = new k();
    localk.field_appIdHash = paramString.hashCode();
    localk.field_appId = paramString;
    localk.field_pkgType = paramInt1;
    localk.field_widgetType = paramInt2;
    if (!a(localk, new String[] { "appId", "pkgType", "widgetType" }))
    {
      paramInt2 = 1;
      if (com.tencent.mm.plugin.appbrand.z.j.a(localk.field_launchAction, parambov.Fem)) {
        break label291;
      }
      localk.field_launchAction = parambov.Fem;
    }
    label261:
    label291:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!com.tencent.mm.plugin.appbrand.z.j.a(localk.field_jsApiInfo, parambov.Feg))
      {
        localk.field_jsApiInfo = parambov.Feg;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.z.j.a(localk.field_versionInfo, parambov.Fen))
      {
        localk.field_versionInfo = parambov.Fen;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.z.j.a(localk.field_widgetSetting, parambov.Feo))
      {
        localk.field_widgetSetting = parambov.Feo;
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramInt2 == 0) {
          break label261;
        }
        a(localk, false);
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          a(localk, new String[] { "appId", "pkgType", "widgetType" });
        }
        AppMethodBeat.o(76400);
        return localk;
        paramInt2 = 0;
        break;
        a(localk, false, new String[] { "appId", "pkgType", "widgetType" });
      }
    }
  }
  
  public final boolean a(k paramk, String... paramVarArgs)
  {
    AppMethodBeat.i(76402);
    int i;
    if (!bs.T(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramk.field_appIdHash = paramk.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramk, paramVarArgs);
        AppMethodBeat.o(76402);
        return bool;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j
 * JD-Core Version:    0.7.0.1
 */