package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.appcache.WABSPatch;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;

public class BSPatchJNIWrapper
  implements IBSPatchJNIService
{
  static
  {
    AppMethodBeat.i(44127);
    BSPatchJNIWrapper.class.getClassLoader();
    j.Ed("appbrandcommon");
    AppMethodBeat.o(44127);
  }
  
  public int bspatch(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(44126);
    int i = WABSPatch.bspatch(paramString1, paramString2, paramString3);
    AppMethodBeat.o(44126);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.BSPatchJNIWrapper
 * JD-Core Version:    0.7.0.1
 */