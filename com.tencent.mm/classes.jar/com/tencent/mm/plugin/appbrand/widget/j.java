package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  extends com.tencent.mm.sdk.e.j<k>
{
  public static final String ime;
  
  static
  {
    AppMethodBeat.i(70660);
    ime = com.tencent.mm.sdk.e.j.getCreateSQLs(k.gUb, "LaunchWxaWidgetRespData");
    AppMethodBeat.o(70660);
  }
  
  public j(e parame)
  {
    super(parame, k.gUb, "LaunchWxaWidgetRespData", k.INDEX_CREATE);
  }
  
  private boolean a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(70654);
    paramk.field_appIdHash = paramk.field_appId.hashCode();
    super.insertNotify(paramk, paramBoolean);
    paramBoolean = a(paramk, new String[] { "appId" });
    AppMethodBeat.o(70654);
    return paramBoolean;
  }
  
  private boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(70655);
    int i;
    if (!bo.Q(paramVarArgs)) {
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
        AppMethodBeat.o(70655);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final k V(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70652);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(70652);
      return null;
    }
    k localk = new k();
    localk.field_appIdHash = paramString.hashCode();
    localk.field_appId = paramString;
    localk.field_pkgType = paramInt1;
    localk.field_widgetType = paramInt2;
    if (a(localk, new String[] { "appId", "pkgType", "widgetType" }))
    {
      AppMethodBeat.o(70652);
      return localk;
    }
    AppMethodBeat.o(70652);
    return null;
  }
  
  public final k a(String paramString, int paramInt1, int paramInt2, azp paramazp)
  {
    AppMethodBeat.i(70651);
    if ((bo.isNullOrNil(paramString)) || (paramazp == null))
    {
      AppMethodBeat.o(70651);
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
      if (com.tencent.mm.plugin.appbrand.s.k.a(localk.field_launchAction, paramazp.xpa)) {
        break label291;
      }
      localk.field_launchAction = paramazp.xpa;
    }
    label261:
    label291:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!com.tencent.mm.plugin.appbrand.s.k.a(localk.field_jsApiInfo, paramazp.xoU))
      {
        localk.field_jsApiInfo = paramazp.xoU;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.s.k.a(localk.field_versionInfo, paramazp.xpb))
      {
        localk.field_versionInfo = paramazp.xpb;
        paramInt1 = 1;
      }
      if (!com.tencent.mm.plugin.appbrand.s.k.a(localk.field_widgetSetting, paramazp.xpc))
      {
        localk.field_widgetSetting = paramazp.xpc;
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
        AppMethodBeat.o(70651);
        return localk;
        paramInt2 = 0;
        break;
        a(localk, false, new String[] { "appId", "pkgType", "widgetType" });
      }
    }
  }
  
  public final boolean a(k paramk, String... paramVarArgs)
  {
    AppMethodBeat.i(70653);
    int i;
    if (!bo.Q(paramVarArgs)) {
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
        AppMethodBeat.o(70653);
        return bool;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j
 * JD-Core Version:    0.7.0.1
 */