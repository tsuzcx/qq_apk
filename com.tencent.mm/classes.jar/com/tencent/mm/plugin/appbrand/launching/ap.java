package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ap
  extends MAutoStorage<ao>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(273018);
    lqL = new String[] { MAutoStorage.getCreateSQLs(ao.nFK, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(273018);
  }
  
  public ap(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ao.nFK, "WxaJsApiPluginInfo", ao.INDEX_CREATE);
  }
  
  public final yw akb(String paramString)
  {
    AppMethodBeat.i(273017);
    try
    {
      ao localao = new ao();
      localao.field_appId = paramString;
      if (get(localao, new String[0]))
      {
        Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        yw localyw = new yw();
        localyw.parseFrom(localao.field_permissionProtoBlob);
        int i = localyw.SkZ.UH.length;
        if (i > 0)
        {
          AppMethodBeat.o(273017);
          return localyw;
        }
        Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(273017);
      return null;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(273017);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ap
 * JD-Core Version:    0.7.0.1
 */