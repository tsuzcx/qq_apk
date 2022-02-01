package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.ai;
import java.net.MalformedURLException;
import java.net.URL;

public final class g
  implements e
{
  public final String generate(String paramString)
  {
    AppMethodBeat.i(205992);
    if (!URLUtil.isNetworkUrl(paramString))
    {
      AppMethodBeat.o(205992);
      return paramString;
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("http://mpvideo.qpic.cn")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    try
    {
      paramString = new URL(str);
      if (paramString != null)
      {
        paramString = ai.ee(str).substring(0, 20);
        AppMethodBeat.o(205992);
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        h.log(6, "DefaultCacheKeyGenerator", h.h(paramString));
        paramString = null;
      }
      AppMethodBeat.o(205992);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g
 * JD-Core Version:    0.7.0.1
 */