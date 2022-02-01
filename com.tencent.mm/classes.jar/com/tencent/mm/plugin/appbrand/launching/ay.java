package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;

public final class ay
  extends j<ax>
{
  public static final String[] hlS;
  
  static
  {
    AppMethodBeat.i(186841);
    hlS = new String[] { j.getCreateSQLs(ax.jmW, "WxaJsApiPluginInfo") };
    AppMethodBeat.o(186841);
  }
  
  public ay(e parame)
  {
    super(parame, ax.jmW, "WxaJsApiPluginInfo", ax.INDEX_CREATE);
  }
  
  public final vg Ou(String paramString)
  {
    AppMethodBeat.i(186840);
    try
    {
      ax localax = new ax();
      localax.field_appId = paramString;
      if (get(localax, new String[0]))
      {
        ac.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", new Object[] { paramString });
        vg localvg = new vg();
        localvg.parseFrom(localax.field_permissionProtoBlob);
        int i = localvg.Epw.xy.length;
        if (i > 0)
        {
          AppMethodBeat.o(186840);
          return localvg;
        }
        ac.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", new Object[] { paramString });
      }
      AppMethodBeat.o(186840);
      return null;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", localException, "get with appId(%s)", new Object[] { paramString });
      AppMethodBeat.o(186840);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ay
 * JD-Core Version:    0.7.0.1
 */