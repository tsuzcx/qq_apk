package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
  extends com.tencent.mm.sdk.e.j<k>
{
  public static final String lOU;
  
  static
  {
    AppMethodBeat.i(76409);
    lOU = com.tencent.mm.sdk.e.j.getCreateSQLs(k.jJU, "LaunchWxaWidgetRespData");
    AppMethodBeat.o(76409);
  }
  
  public j(e parame)
  {
    super(parame, k.jJU, "LaunchWxaWidgetRespData", k.INDEX_CREATE);
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
    if (!bu.V(paramVarArgs)) {
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
  
  public final k T(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76401);
    if (bu.isNullOrNil(paramString))
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
  
  public final k a(String paramString, int paramInt1, int paramInt2, buc parambuc)
  {
    AppMethodBeat.i(76400);
    if ((bu.isNullOrNil(paramString)) || (parambuc == null))
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
      if (com.tencent.mm.plugin.appbrand.y.j.a(localk.field_launchAction, parambuc.Hhq)) {
        break label291;
      }
      localk.field_launchAction = parambuc.Hhq;
    }
    label261:
    label291:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!com.tencent.mm.plugin.appbrand.y.j.a(localk.field_jsApiInfo, parambuc.Hhk))
      {
        localk.field_jsApiInfo = parambuc.Hhk;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.y.j.a(localk.field_versionInfo, parambuc.Hhr))
      {
        localk.field_versionInfo = parambuc.Hhr;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.y.j.a(localk.field_widgetSetting, parambuc.Hhs))
      {
        localk.field_widgetSetting = parambuc.Hhs;
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
    if (!bu.V(paramVarArgs)) {
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