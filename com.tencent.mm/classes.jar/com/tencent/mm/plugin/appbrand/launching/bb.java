package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;

public final class bb
  extends j<ba>
{
  public static final String[] hGX;
  
  static
  {
    AppMethodBeat.i(222781);
    hGX = new String[] { j.getCreateSQLs(ba.jJU, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(222781);
  }
  
  public bb(e parame)
  {
    super(parame, ba.jJU, "WxaJsApiPluginInfo", ba.INDEX_CREATE);
  }
  
  public final xi SD(String paramString)
  {
    AppMethodBeat.i(222780);
    try
    {
      ba localba = new ba();
      localba.field_appId = paramString;
      if (get(localba, new String[0]))
      {
        ae.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        xi localxi = new xi();
        localxi.parseFrom(localba.field_permissionProtoBlob);
        int i = localxi.Gph.zr.length;
        if (i > 0)
        {
          AppMethodBeat.o(222780);
          return localxi;
        }
        ae.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(222780);
      return null;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(222780);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */