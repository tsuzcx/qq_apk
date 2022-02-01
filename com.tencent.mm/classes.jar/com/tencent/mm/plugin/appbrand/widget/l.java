package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.j;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class l
  extends MAutoStorage<m>
{
  public static final String pWF;
  
  static
  {
    AppMethodBeat.i(76409);
    pWF = MAutoStorage.getCreateSQLs(m.nFK, "LaunchWxaWidgetRespData");
    AppMethodBeat.o(76409);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, m.nFK, "LaunchWxaWidgetRespData", m.INDEX_CREATE);
  }
  
  private boolean a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(76403);
    paramm.field_appIdHash = paramm.field_appId.hashCode();
    super.insertNotify(paramm, paramBoolean);
    paramBoolean = a(paramm, new String[] { "appId" });
    AppMethodBeat.o(76403);
    return paramBoolean;
  }
  
  private boolean a(m paramm, boolean paramBoolean, String... paramVarArgs)
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
          paramm.field_appIdHash = paramm.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramm, paramBoolean, paramVarArgs);
        AppMethodBeat.o(76404);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final m W(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76401);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(76401);
      return null;
    }
    m localm = new m();
    localm.field_appIdHash = paramString.hashCode();
    localm.field_appId = paramString;
    localm.field_pkgType = paramInt1;
    localm.field_widgetType = paramInt2;
    if (a(localm, new String[] { "appId", "pkgType", "widgetType" }))
    {
      AppMethodBeat.o(76401);
      return localm;
    }
    AppMethodBeat.o(76401);
    return null;
  }
  
  public final m a(String paramString, int paramInt1, int paramInt2, cqc paramcqc)
  {
    AppMethodBeat.i(76400);
    if ((Util.isNullOrNil(paramString)) || (paramcqc == null))
    {
      AppMethodBeat.o(76400);
      return null;
    }
    m localm = new m();
    localm.field_appIdHash = paramString.hashCode();
    localm.field_appId = paramString;
    localm.field_pkgType = paramInt1;
    localm.field_widgetType = paramInt2;
    if (!a(localm, new String[] { "appId", "pkgType", "widgetType" }))
    {
      paramInt2 = 1;
      if (j.a(localm.field_launchAction, paramcqc.TxB)) {
        break label291;
      }
      localm.field_launchAction = paramcqc.TxB;
    }
    label261:
    label291:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (!j.a(localm.field_jsApiInfo, paramcqc.Txv))
      {
        localm.field_jsApiInfo = paramcqc.Txv;
        paramInt1 = 1;
      }
      if (!j.a(localm.field_versionInfo, paramcqc.TxC))
      {
        localm.field_versionInfo = paramcqc.TxC;
        paramInt1 = 1;
      }
      if (!j.a(localm.field_widgetSetting, paramcqc.TxD))
      {
        localm.field_widgetSetting = paramcqc.TxD;
        paramInt1 = 1;
      }
      if (paramInt1 != 0)
      {
        if (paramInt2 == 0) {
          break label261;
        }
        a(localm, false);
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          a(localm, new String[] { "appId", "pkgType", "widgetType" });
        }
        AppMethodBeat.o(76400);
        return localm;
        paramInt2 = 0;
        break;
        a(localm, false, new String[] { "appId", "pkgType", "widgetType" });
      }
    }
  }
  
  public final boolean a(m paramm, String... paramVarArgs)
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
          paramm.field_appIdHash = paramm.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramm, paramVarArgs);
        AppMethodBeat.o(76402);
        return bool;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.l
 * JD-Core Version:    0.7.0.1
 */