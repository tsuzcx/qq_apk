package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WABSPatch;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;

public class BSPatchJNIWrapper
  implements IBSPatchJNIService
{
  public int bspatch(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129208);
    int i = WABSPatch.bspatch(paramString1, paramString2, paramString3);
    AppMethodBeat.o(129208);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.BSPatchJNIWrapper
 * JD-Core Version:    0.7.0.1
 */