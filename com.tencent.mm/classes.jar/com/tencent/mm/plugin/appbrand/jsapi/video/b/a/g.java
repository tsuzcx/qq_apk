package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.net.MalformedURLException;
import java.net.URL;

public final class g
  implements e
{
  public final String cj(String paramString)
  {
    AppMethodBeat.i(328303);
    if (!URLUtil.isNetworkUrl(paramString))
    {
      AppMethodBeat.o(328303);
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
        paramString = MD5Util.getMD5String(str).substring(0, 20);
        AppMethodBeat.o(328303);
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        h.log(6, "DefaultCacheKeyGenerator", h.s(paramString));
        paramString = null;
      }
      AppMethodBeat.o(328303);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g
 * JD-Core Version:    0.7.0.1
 */