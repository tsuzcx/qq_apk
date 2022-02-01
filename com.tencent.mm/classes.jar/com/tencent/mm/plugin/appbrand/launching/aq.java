package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class aq
  extends MAutoStorage<ap>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(320716);
    nVW = new String[] { MAutoStorage.getCreateSQLs(ap.DB_INFO, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(320716);
  }
  
  public aq(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ap.DB_INFO, "WxaJsApiPluginInfo", ap.INDEX_CREATE);
  }
  
  public final aat adg(String paramString)
  {
    AppMethodBeat.i(320722);
    try
    {
      ap localap = new ap();
      localap.field_appId = paramString;
      if (get(localap, new String[0]))
      {
        Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        aat localaat = new aat();
        localaat.parseFrom(localap.field_permissionProtoBlob);
        int i = localaat.Zjj.Op.length;
        if (i > 0)
        {
          AppMethodBeat.o(320722);
          return localaat;
        }
        Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(320722);
      return null;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(320722);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aq
 * JD-Core Version:    0.7.0.1
 */