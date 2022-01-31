package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class aa
  extends j<ab>
{
  public static final String ime;
  
  static
  {
    AppMethodBeat.i(131920);
    ime = j.getCreateSQLs(ab.gUb, "LaunchWxaAppRespTable");
    AppMethodBeat.o(131920);
  }
  
  public aa(e parame)
  {
    super(parame, ab.gUb, "LaunchWxaAppRespTable", ab.INDEX_CREATE);
  }
  
  private boolean a(ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(131914);
    paramab.field_appIdHash = paramab.field_appId.hashCode();
    super.insertNotify(paramab, paramBoolean);
    paramBoolean = a(paramab, new String[] { "appId" });
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramab.field_appId, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(131914);
    return paramBoolean;
  }
  
  private boolean a(ab paramab, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(131912);
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
          paramab.field_appIdHash = paramab.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.delete(paramab, paramBoolean, paramVarArgs);
        AppMethodBeat.o(131912);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  private boolean b(ab paramab, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(131915);
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
          paramab.field_appIdHash = paramab.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramab, paramBoolean, paramVarArgs);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramab.field_appId, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(131915);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final ab a(String paramString, azn paramazn)
  {
    AppMethodBeat.i(131910);
    if ((bo.isNullOrNil(paramString)) || (paramazn == null))
    {
      AppMethodBeat.o(131910);
      return null;
    }
    ab localab = new ab();
    localab.a(paramazn);
    localab.field_appId = paramString;
    paramazn = new ab();
    paramazn.field_appId = paramString;
    boolean bool1;
    boolean bool2;
    if (!a(paramazn, new String[] { "appId" }))
    {
      bool1 = true;
      if ((!bool1) && (paramazn.equals(localab))) {
        break label173;
      }
      bool2 = true;
      label92:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[] { paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        if (!bool1) {
          break label179;
        }
        a(localab, false);
      }
    }
    for (;;)
    {
      if (!bool2) {
        break label199;
      }
      if (!a(paramazn, new String[] { "appId" })) {
        break label199;
      }
      AppMethodBeat.o(131910);
      return paramazn;
      bool1 = false;
      break;
      label173:
      bool2 = false;
      break label92;
      label179:
      b(localab, false, new String[] { "appId" });
    }
    label199:
    AppMethodBeat.o(131910);
    return localab;
  }
  
  public final boolean a(ab paramab, String... paramVarArgs)
  {
    AppMethodBeat.i(131913);
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
          paramab.field_appIdHash = paramab.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramab, paramVarArgs);
        AppMethodBeat.o(131913);
        return bool;
      }
      i += 1;
    }
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(131911);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131911);
      return false;
    }
    ab localab = new ab();
    localab.field_appId = paramString;
    boolean bool = a(localab, false, new String[] { "appId" });
    AppMethodBeat.o(131911);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aa
 * JD-Core Version:    0.7.0.1
 */