package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public class l
  extends k
{
  public final String f(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    try
    {
      if ((paramc.Zl() instanceof com.tencent.mm.plugin.appbrand.appstorage.l))
      {
        Object localObject = ((IWxaFileSystemWithModularizing)((com.tencent.mm.plugin.appbrand.appstorage.l)paramc.Zl()).H(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(paramString);
        if (localObject != null)
        {
          localObject = ((ai)localObject).fDw.getAbsolutePath();
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.j.c.e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", new Object[] { paramString, localException });
      paramc = (i)paramc.D(i.class);
      if (paramc == null)
      {
        y.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
        return "";
      }
      if (paramc.fPS == null)
      {
        y.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
        return "";
      }
      y.d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", new Object[] { paramc.fPS.fCl });
    }
    return paramc.fPS.fCl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */