package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.vfs.s;

public final class h
  implements l
{
  public final boolean cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226308);
    boolean bool = AppBrandCommonBindingJni.nativeBrotliDecompress(s.k(paramString1, false), s.k(paramString2, true));
    AppMethodBeat.o(226308);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h
 * JD-Core Version:    0.7.0.1
 */