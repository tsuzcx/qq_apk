package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ai
  extends MAutoStorage<aj>
{
  public static final String pWF;
  
  static
  {
    AppMethodBeat.i(47281);
    pWF = MAutoStorage.getCreateSQLs(aj.nFK, "LaunchWxaAppRespTable");
    AppMethodBeat.o(47281);
  }
  
  public ai(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aj.nFK, "LaunchWxaAppRespTable", aj.INDEX_CREATE);
  }
  
  private boolean a(aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(47275);
    paramaj.field_appIdHash = paramaj.field_appId.hashCode();
    super.insertNotify(paramaj, paramBoolean);
    paramBoolean = a(paramaj, new String[] { "appId" });
    Log.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[] { paramaj.field_appId, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(47275);
    return paramBoolean;
  }
  
  private boolean a(aj paramaj, boolean paramBoolean, String... paramVarArgs)
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
          paramaj.field_appIdHash = paramaj.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.delete(paramaj, paramBoolean, paramVarArgs);
        AppMethodBeat.o(47273);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  private boolean b(aj paramaj, boolean paramBoolean, String... paramVarArgs)
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
          paramaj.field_appIdHash = paramaj.field_appId.hashCode();
        }
      }
      else
      {
        paramBoolean = super.updateNotify(paramaj, paramBoolean, paramVarArgs);
        Log.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[] { paramaj.field_appId, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(47276);
        return paramBoolean;
      }
      i += 1;
    }
  }
  
  public final aj a(String paramString, cqa paramcqa)
  {
    AppMethodBeat.i(47271);
    if ((Util.isNullOrNil(paramString)) || (paramcqa == null))
    {
      AppMethodBeat.o(47271);
      return null;
    }
    aj localaj = new aj();
    localaj.b(paramcqa);
    localaj.field_appId = paramString;
    paramcqa = new aj();
    paramcqa.field_appId = paramString;
    boolean bool1;
    boolean bool2;
    if (!a(paramcqa, new String[] { "appId" }))
    {
      bool1 = true;
      if ((!bool1) && (paramcqa.equals(localaj))) {
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
        a(localaj, false);
      }
    }
    for (;;)
    {
      if (!bool2) {
        break label199;
      }
      if (!a(paramcqa, new String[] { "appId" })) {
        break label199;
      }
      AppMethodBeat.o(47271);
      return paramcqa;
      bool1 = false;
      break;
      label173:
      bool2 = false;
      break label92;
      label179:
      b(localaj, false, new String[] { "appId" });
    }
    label199:
    AppMethodBeat.o(47271);
    return localaj;
  }
  
  public final boolean a(aj paramaj, String... paramVarArgs)
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
          paramaj.field_appIdHash = paramaj.field_appId.hashCode();
        }
      }
      else
      {
        boolean bool = super.get(paramaj, paramVarArgs);
        AppMethodBeat.o(47274);
        return bool;
      }
      i += 1;
    }
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(47272);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47272);
      return false;
    }
    aj localaj = new aj();
    localaj.field_appId = paramString;
    boolean bool = a(localaj, false, new String[] { "appId" });
    AppMethodBeat.o(47272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai
 * JD-Core Version:    0.7.0.1
 */