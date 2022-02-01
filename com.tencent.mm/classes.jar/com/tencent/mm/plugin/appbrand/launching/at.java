package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class at
  extends MAutoStorage<as>
{
  public static final String[] iBh;
  
  static
  {
    AppMethodBeat.i(227093);
    iBh = new String[] { MAutoStorage.getCreateSQLs(as.kLR, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(227093);
  }
  
  public at(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, as.kLR, "WxaJsApiPluginInfo", as.INDEX_CREATE);
  }
  
  public final ys ach(String paramString)
  {
    AppMethodBeat.i(227092);
    try
    {
      as localas = new as();
      localas.field_appId = paramString;
      if (get(localas, new String[0]))
      {
        Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        ys localys = new ys();
        localys.parseFrom(localas.field_permissionProtoBlob);
        int i = localys.LjS.zy.length;
        if (i > 0)
        {
          AppMethodBeat.o(227092);
          return localys;
        }
        Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(227092);
      return null;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(227092);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.at
 * JD-Core Version:    0.7.0.1
 */