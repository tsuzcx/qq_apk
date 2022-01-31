package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.plugin.appbrand.u.l;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;

public final class i
  extends com.tencent.mm.sdk.e.i<j>
{
  public static final String fQV = com.tencent.mm.sdk.e.i.a(j.fCU, "LaunchWxaWidgetRespData");
  
  public i(e parame)
  {
    super(parame, j.fCU, "LaunchWxaWidgetRespData", j.cqY);
  }
  
  private boolean a(j paramj, boolean paramBoolean)
  {
    paramj.field_appIdHash = paramj.field_appId.hashCode();
    super.a(paramj, paramBoolean);
    return a(paramj, new String[] { "appId" });
  }
  
  private boolean a(j paramj, boolean paramBoolean, String... paramVarArgs)
  {
    int i;
    if (!bk.H(paramVarArgs)) {
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
      else {
        return super.b(paramj, paramBoolean, paramVarArgs);
      }
      i += 1;
    }
  }
  
  public final j a(String paramString, int paramInt1, int paramInt2, atk paramatk)
  {
    if ((bk.bl(paramString)) || (paramatk == null)) {
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
      if (l.a(localj.field_launchAction, paramatk.tpc)) {
        break label276;
      }
      localj.field_launchAction = paramatk.tpc;
    }
    label276:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!l.a(localj.field_jsApiInfo, paramatk.toW))
      {
        localj.field_jsApiInfo = paramatk.toW;
        paramInt1 = 1;
      }
      if (!l.a(localj.field_versionInfo, paramatk.tpd))
      {
        localj.field_versionInfo = paramatk.tpd;
        paramInt1 = 1;
      }
      if (!l.a(localj.field_widgetSetting, paramatk.tpe))
      {
        localj.field_widgetSetting = paramatk.tpe;
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramInt2 == 0) {
          break label246;
        }
        a(localj, false);
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          a(localj, new String[] { "appId", "pkgType", "widgetType" });
        }
        return localj;
        paramInt2 = 0;
        break;
        label246:
        a(localj, false, new String[] { "appId", "pkgType", "widgetType" });
      }
    }
  }
  
  public final boolean a(j paramj, String... paramVarArgs)
  {
    int i;
    if (!bk.H(paramVarArgs)) {
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
      else {
        return super.b(paramj, paramVarArgs);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i
 * JD-Core Version:    0.7.0.1
 */