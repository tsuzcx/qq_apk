package com.tencent.mm.plugin.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getManifestId", "", "host", "getPrefetcherId", "appId", "webview-sdk_release"})
public final class e
{
  public static final String biE(String paramString)
  {
    AppMethodBeat.i(205294);
    p.k(paramString, "host");
    paramString = "_manifest_" + paramString.hashCode();
    AppMethodBeat.o(205294);
    return paramString;
  }
  
  public static final String biF(String paramString)
  {
    AppMethodBeat.i(205295);
    p.k(paramString, "appId");
    paramString = "_prefetcher_".concat(String.valueOf(paramString));
    AppMethodBeat.o(205295);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.e
 * JD-Core Version:    0.7.0.1
 */