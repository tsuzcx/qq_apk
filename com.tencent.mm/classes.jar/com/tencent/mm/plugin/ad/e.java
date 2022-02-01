package com.tencent.mm.plugin.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"getManifestId", "", "host", "webview-sdk_release"})
public final class e
{
  public static final String aWU(String paramString)
  {
    AppMethodBeat.i(224951);
    p.h(paramString, "host");
    paramString = "_manifest_" + paramString.hashCode();
    AppMethodBeat.o(224951);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.e
 * JD-Core Version:    0.7.0.1
 */