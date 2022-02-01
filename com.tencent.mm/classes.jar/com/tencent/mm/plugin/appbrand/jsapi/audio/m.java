package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Objects;

public class m
  extends l
{
  public final WxaPkg.Info e(c paramc, String paramString)
  {
    AppMethodBeat.i(182767);
    try
    {
      if ((paramc.Fg() instanceof t))
      {
        paramc = ((IWxaFileSystemWithModularizing)Objects.requireNonNull(((t)paramc.Fg()).av(IWxaFileSystemWithModularizing.class))).openReadPartialInfo(paramString);
        AppMethodBeat.o(182767);
        return paramc;
      }
    }
    catch (Exception paramc)
    {
      ad.e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", new Object[] { paramString, paramc });
      AppMethodBeat.o(182767);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.m
 * JD-Core Version:    0.7.0.1
 */