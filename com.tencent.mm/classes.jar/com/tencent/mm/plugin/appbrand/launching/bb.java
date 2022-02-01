package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class bb
  extends j<ba>
{
  public static final String[] hEf;
  
  static
  {
    AppMethodBeat.i(188622);
    hEf = new String[] { j.getCreateSQLs(ba.jGU, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(188622);
  }
  
  public bb(e parame)
  {
    super(parame, ba.jGU, "WxaJsApiPluginInfo", ba.INDEX_CREATE);
  }
  
  public final xf RU(String paramString)
  {
    AppMethodBeat.i(188621);
    try
    {
      ba localba = new ba();
      localba.field_appId = paramString;
      if (get(localba, new String[0]))
      {
        ad.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        xf localxf = new xf();
        localxf.parseFrom(localba.field_permissionProtoBlob);
        int i = localxf.FWI.zr.length;
        if (i > 0)
        {
          AppMethodBeat.o(188621);
          return localxf;
        }
        ad.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(188621);
      return null;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(188621);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */