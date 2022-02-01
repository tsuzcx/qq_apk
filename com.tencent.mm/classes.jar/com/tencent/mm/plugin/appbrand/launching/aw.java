package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class aw
  extends j<ax>
{
  public static final String lOU;
  
  static
  {
    AppMethodBeat.i(47281);
    lOU = j.getCreateSQLs(ax.jJU, "LaunchWxaAppRespTable");
    AppMethodBeat.o(47281);
  }
  
  public aw(e parame)
  {
    super(parame, ax.jJU, "LaunchWxaAppRespTable", ax.INDEX_CREATE);
  }
  
  private boolean a(ax paramax, boolean paramBoolean)
  {
    AppMethodBeat.i(47275);
    paramax.field_appIdHash = paramax.field_appId.hashCode();
    super.insertNotify(paramax, paramBoolean);
    paramBoolean = a(paramax, new String[] { "appId" });
    ae.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramax.field_appId, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(47275);
    return paramBoolean;
  }
  
  private boolean a(ax paramax, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47273);
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
          paramax.field_appIdHash = paramax.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.delete(paramax, paramBoolean, paramVarArgs);
        AppMethodBeat.o(47273);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  private boolean b(ax paramax, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47276);
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
          paramax.field_appIdHash = paramax.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramax, paramBoolean, paramVarArgs);
        ae.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramax.field_appId, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(47276);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(47272);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47272);
      return false;
    }
    ax localax = new ax();
    localax.field_appId = paramString;
    boolean bool = a(localax, false, new String[] { "appId" });
    AppMethodBeat.o(47272);
    return bool;
  }
  
  public final ax a(String paramString, bua parambua)
  {
    AppMethodBeat.i(47271);
    if ((bu.isNullOrNil(paramString)) || (parambua == null))
    {
      AppMethodBeat.o(47271);
      return null;
    }
    ax localax = new ax();
    localax.a(parambua);
    localax.field_appId = paramString;
    parambua = new ax();
    parambua.field_appId = paramString;
    boolean bool1;
    boolean bool2;
    if (!a(parambua, new String[] { "appId" }))
    {
      bool1 = true;
      if ((!bool1) && (parambua.equals(localax))) {
        break label173;
      }
      bool2 = true;
      label92:
      ae.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[] { paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        if (!bool1) {
          break label179;
        }
        a(localax, false);
      }
    }
    for (;;)
    {
      if (!bool2) {
        break label199;
      }
      if (!a(parambua, new String[] { "appId" })) {
        break label199;
      }
      AppMethodBeat.o(47271);
      return parambua;
      bool1 = false;
      break;
      label173:
      bool2 = false;
      break label92;
      label179:
      b(localax, false, new String[] { "appId" });
    }
    label199:
    AppMethodBeat.o(47271);
    return localax;
  }
  
  public final boolean a(ax paramax, String... paramVarArgs)
  {
    AppMethodBeat.i(47274);
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
          paramax.field_appIdHash = paramax.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramax, paramVarArgs);
        AppMethodBeat.o(47274);
        return bool;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aw
 * JD-Core Version:    0.7.0.1
 */