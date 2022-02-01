package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Objects;

public class o
  extends n
{
  public final WxaPkg.Info e(f paramf, String paramString)
  {
    AppMethodBeat.i(182767);
    try
    {
      if ((paramf.getFileSystem() instanceof ac))
      {
        paramf = ((IWxaFileSystemWithModularizing)Objects.requireNonNull((IWxaFileSystemWithModularizing)((ac)paramf.getFileSystem()).aR(IWxaFileSystemWithModularizing.class))).openReadPartialInfo(paramString);
        AppMethodBeat.o(182767);
        return paramf;
      }
    }
    catch (Exception paramf)
    {
      Log.e("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", new Object[] { paramString, paramf });
      AppMethodBeat.o(182767);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.o
 * JD-Core Version:    0.7.0.1
 */