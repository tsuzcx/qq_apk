package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.l;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class o
  extends MAutoStorage<p>
{
  public static final String tbu;
  
  static
  {
    AppMethodBeat.i(76409);
    tbu = MAutoStorage.getCreateSQLs(p.DB_INFO, "LaunchWxaWidgetRespData");
    AppMethodBeat.o(76409);
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, p.DB_INFO, "LaunchWxaWidgetRespData", p.INDEX_CREATE);
  }
  
  private boolean a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(76403);
    paramp.field_appIdHash = paramp.field_appId.hashCode();
    super.insertNotify(paramp, paramBoolean);
    paramBoolean = a(paramp, new String[] { "appId" });
    AppMethodBeat.o(76403);
    return paramBoolean;
  }
  
  private boolean a(p paramp, boolean paramBoolean, String... paramVarArgs)
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
          paramp.field_appIdHash = paramp.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramp, paramBoolean, paramVarArgs);
        AppMethodBeat.o(76404);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final p a(String paramString, int paramInt1, int paramInt2, dgw paramdgw)
  {
    AppMethodBeat.i(76400);
    if ((Util.isNullOrNil(paramString)) || (paramdgw == null))
    {
      AppMethodBeat.o(76400);
      return null;
    }
    p localp = new p();
    localp.field_appIdHash = paramString.hashCode();
    localp.field_appId = paramString;
    localp.field_pkgType = paramInt1;
    localp.field_widgetType = paramInt2;
    if (!a(localp, new String[] { "appId", "pkgType", "widgetType" }))
    {
      paramInt2 = 1;
      if (l.a(localp.field_launchAction, paramdgw.aaMi)) {
        break label291;
      }
      localp.field_launchAction = paramdgw.aaMi;
    }
    label261:
    label291:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!l.a(localp.field_jsApiInfo, paramdgw.aaMa))
      {
        localp.field_jsApiInfo = paramdgw.aaMa;
        paramInt1 = 1;
      }
      if (!l.a(localp.field_versionInfo, paramdgw.aaMj))
      {
        localp.field_versionInfo = paramdgw.aaMj;
        paramInt1 = 1;
      }
      if (!l.a(localp.field_widgetSetting, paramdgw.aaMk))
      {
        localp.field_widgetSetting = paramdgw.aaMk;
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramInt2 == 0) {
          break label261;
        }
        a(localp, false);
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          a(localp, new String[] { "appId", "pkgType", "widgetType" });
        }
        AppMethodBeat.o(76400);
        return localp;
        paramInt2 = 0;
        break;
        a(localp, false, new String[] { "appId", "pkgType", "widgetType" });
      }
    }
  }
  
  public final boolean a(p paramp, String... paramVarArgs)
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
          paramp.field_appIdHash = paramp.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramp, paramVarArgs);
        AppMethodBeat.o(76402);
        return bool;
      }
      i += 1;
    }
  }
  
  public final p aa(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76401);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76401);
      return null;
    }
    p localp = new p();
    localp.field_appIdHash = paramString.hashCode();
    localp.field_appId = paramString;
    localp.field_pkgType = paramInt1;
    localp.field_widgetType = paramInt2;
    if (a(localp, new String[] { "appId", "pkgType", "widgetType" }))
    {
      AppMethodBeat.o(76401);
      return localp;
    }
    AppMethodBeat.o(76401);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.o
 * JD-Core Version:    0.7.0.1
 */