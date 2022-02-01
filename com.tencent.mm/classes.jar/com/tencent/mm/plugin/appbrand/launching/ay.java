package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;

public final class ay
  extends j<ax>
{
  public static final String[] gLs;
  
  static
  {
    AppMethodBeat.i(196017);
    gLs = new String[] { j.getCreateSQLs(ax.iMP, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(196017);
  }
  
  public ay(e parame)
  {
    super(parame, ax.iMP, "WxaJsApiPluginInfo", ax.INDEX_CREATE);
  }
  
  public final uw Kn(String paramString)
  {
    AppMethodBeat.i(196016);
    try
    {
      ax localax = new ax();
      localax.field_appId = paramString;
      if (get(localax, new String[0]))
      {
        ad.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        uw localuw = new uw();
        localuw.parseFrom(localax.field_permissionProtoBlob);
        int i = localuw.CWN.wA.length;
        if (i > 0)
        {
          AppMethodBeat.o(196016);
          return localuw;
        }
        ad.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(196016);
      return null;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(196016);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ay
 * JD-Core Version:    0.7.0.1
 */