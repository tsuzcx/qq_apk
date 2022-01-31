package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

public class k
  extends j
{
  public final String f(c paramc, String paramString)
  {
    AppMethodBeat.i(74739);
    try
    {
      if ((paramc.wX() instanceof s))
      {
        Object localObject = ((IWxaFileSystemWithModularizing)((s)paramc.wX()).Y(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(paramString);
        if (localObject != null)
        {
          localObject = ((ao)localObject).gVL.getAbsolutePath();
          AppMethodBeat.o(74739);
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      d.e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", new Object[] { paramString, localException });
      paramc = (h)paramc.U(h.class);
      if (paramc == null)
      {
        ab.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
        AppMethodBeat.o(74739);
        return "";
      }
      if (paramc.hiX == null)
      {
        ab.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
        AppMethodBeat.o(74739);
        return "";
      }
      ab.d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", new Object[] { paramc.hiX.gUy });
      paramc = paramc.hiX.gUy;
      AppMethodBeat.o(74739);
    }
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.k
 * JD-Core Version:    0.7.0.1
 */