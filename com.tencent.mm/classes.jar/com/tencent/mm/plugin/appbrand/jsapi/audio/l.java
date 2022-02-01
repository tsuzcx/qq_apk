package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Objects;

public class l
  extends k
{
  public final WxaPkg.Info e(c paramc, String paramString)
  {
    AppMethodBeat.i(182767);
    try
    {
      if ((paramc.Ee() instanceof t))
      {
        paramc = ((IWxaFileSystemWithModularizing)Objects.requireNonNull(((t)paramc.Ee()).av(IWxaFileSystemWithModularizing.class))).openReadPartialInfo(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.l
 * JD-Core Version:    0.7.0.1
 */