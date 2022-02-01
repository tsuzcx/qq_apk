package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class at
  extends j<au>
{
  public static final String kLE;
  
  static
  {
    AppMethodBeat.i(47281);
    kLE = j.getCreateSQLs(au.iMP, "LaunchWxaAppRespTable");
    AppMethodBeat.o(47281);
  }
  
  public at(e parame)
  {
    super(parame, au.iMP, "LaunchWxaAppRespTable", au.INDEX_CREATE);
  }
  
  private boolean a(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(47275);
    paramau.field_appIdHash = paramau.field_appId.hashCode();
    super.insertNotify(paramau, paramBoolean);
    paramBoolean = a(paramau, new String[] { "appId" });
    ad.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramau.field_appId, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(47275);
    return paramBoolean;
  }
  
  private boolean a(au paramau, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47273);
    int i;
    if (!bt.T(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramau.field_appIdHash = paramau.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.delete(paramau, paramBoolean, paramVarArgs);
        AppMethodBeat.o(47273);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  private boolean b(au paramau, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47276);
    int i;
    if (!bt.T(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramau.field_appIdHash = paramau.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramau, paramBoolean, paramVarArgs);
        ad.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramau.field_appId, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(47276);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final au a(String paramString, bkx parambkx)
  {
    AppMethodBeat.i(47271);
    if ((bt.isNullOrNil(paramString)) || (parambkx == null))
    {
      AppMethodBeat.o(47271);
      return null;
    }
    au localau = new au();
    localau.a(parambkx);
    localau.field_appId = paramString;
    parambkx = new au();
    parambkx.field_appId = paramString;
    boolean bool1;
    boolean bool2;
    if (!a(parambkx, new String[] { "appId" }))
    {
      bool1 = true;
      if ((!bool1) && (parambkx.equals(localau))) {
        break label173;
      }
      bool2 = true;
      label92:
      ad.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[] { paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        if (!bool1) {
          break label179;
        }
        a(localau, false);
      }
    }
    for (;;)
    {
      if (!bool2) {
        break label199;
      }
      if (!a(parambkx, new String[] { "appId" })) {
        break label199;
      }
      AppMethodBeat.o(47271);
      return parambkx;
      bool1 = false;
      break;
      label173:
      bool2 = false;
      break label92;
      label179:
      b(localau, false, new String[] { "appId" });
    }
    label199:
    AppMethodBeat.o(47271);
    return localau;
  }
  
  public final boolean a(au paramau, String... paramVarArgs)
  {
    AppMethodBeat.i(47274);
    int i;
    if (!bt.T(paramVarArgs)) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("appId"))
        {
          paramVarArgs[i] = "appIdHash";
          paramau.field_appIdHash = paramau.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramau, paramVarArgs);
        AppMethodBeat.o(47274);
        return bool;
      }
      i += 1;
    }
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(47272);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47272);
      return false;
    }
    au localau = new au();
    localau.field_appId = paramString;
    boolean bool = a(localau, false, new String[] { "appId" });
    AppMethodBeat.o(47272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.at
 * JD-Core Version:    0.7.0.1
 */