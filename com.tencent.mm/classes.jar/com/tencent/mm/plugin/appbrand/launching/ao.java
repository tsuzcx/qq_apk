package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ao
  extends MAutoStorage<ap>
{
  public static final String mWc;
  
  static
  {
    AppMethodBeat.i(47281);
    mWc = MAutoStorage.getCreateSQLs(ap.kLR, "LaunchWxaAppRespTable");
    AppMethodBeat.o(47281);
  }
  
  public ao(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ap.kLR, "LaunchWxaAppRespTable", ap.INDEX_CREATE);
  }
  
  private boolean a(ap paramap, boolean paramBoolean)
  {
    AppMethodBeat.i(47275);
    paramap.field_appIdHash = paramap.field_appId.hashCode();
    super.insertNotify(paramap, paramBoolean);
    paramBoolean = a(paramap, new String[] { "appId" });
    Log.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramap.field_appId, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(47275);
    return paramBoolean;
  }
  
  private boolean a(ap paramap, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47273);
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
          paramap.field_appIdHash = paramap.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.delete(paramap, paramBoolean, paramVarArgs);
        AppMethodBeat.o(47273);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  private boolean b(ap paramap, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(47276);
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
          paramap.field_appIdHash = paramap.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramap, paramBoolean, paramVarArgs);
        Log.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramap.field_appId, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(47276);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final ap a(String paramString, che paramche)
  {
    AppMethodBeat.i(47271);
    if ((Util.isNullOrNil(paramString)) || (paramche == null))
    {
      AppMethodBeat.o(47271);
      return null;
    }
    ap localap = new ap();
    localap.b(paramche);
    localap.field_appId = paramString;
    paramche = new ap();
    paramche.field_appId = paramString;
    boolean bool1;
    boolean bool2;
    if (!a(paramche, new String[] { "appId" }))
    {
      bool1 = true;
      if ((!bool1) && (paramche.equals(localap))) {
        break label173;
      }
      bool2 = true;
      label92:
      Log.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[] { paramString, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (bool2)
      {
        if (!bool1) {
          break label179;
        }
        a(localap, false);
      }
    }
    for (;;)
    {
      if (!bool2) {
        break label199;
      }
      if (!a(paramche, new String[] { "appId" })) {
        break label199;
      }
      AppMethodBeat.o(47271);
      return paramche;
      bool1 = false;
      break;
      label173:
      bool2 = false;
      break label92;
      label179:
      b(localap, false, new String[] { "appId" });
    }
    label199:
    AppMethodBeat.o(47271);
    return localap;
  }
  
  public final boolean a(ap paramap, String... paramVarArgs)
  {
    AppMethodBeat.i(47274);
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
          paramap.field_appIdHash = paramap.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramap, paramVarArgs);
        AppMethodBeat.o(47274);
        return bool;
      }
      i += 1;
    }
  }
  
  public final boolean gC(String paramString)
  {
    AppMethodBeat.i(47272);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47272);
      return false;
    }
    ap localap = new ap();
    localap.field_appId = paramString;
    boolean bool = a(localap, false, new String[] { "appId" });
    AppMethodBeat.o(47272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao
 * JD-Core Version:    0.7.0.1
 */