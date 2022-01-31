package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class ax$b$a
{
  static final Map<Class, ax.b> gWS;
  
  static
  {
    AppMethodBeat.i(86813);
    HashMap localHashMap = new HashMap();
    gWS = localHashMap;
    localHashMap.put(InputStream.class, new ax.c((byte)0));
    gWS.put(WebResourceResponse.class, new ax.e((byte)0));
    gWS.put(String.class, new ax.d((byte)0));
    gWS.put([B.class, new ax.a((byte)0));
    AppMethodBeat.o(86813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax.b.a
 * JD-Core Version:    0.7.0.1
 */