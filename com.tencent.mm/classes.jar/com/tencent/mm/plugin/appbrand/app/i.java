package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.vfs.y;

public final class i
  implements m
{
  public final boolean cM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317793);
    boolean bool = AppBrandCommonBindingJni.nativeBrotliDecompress(y.n(paramString1, false), y.n(paramString2, true));
    AppMethodBeat.o(317793);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.i
 * JD-Core Version:    0.7.0.1
 */