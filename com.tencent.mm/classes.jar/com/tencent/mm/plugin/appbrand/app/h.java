package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.vfs.u;

public final class h
  implements l
{
  public final boolean cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(274570);
    boolean bool = AppBrandCommonBindingJni.nativeBrotliDecompress(u.n(paramString1, false), u.n(paramString2, true));
    AppMethodBeat.o(274570);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h
 * JD-Core Version:    0.7.0.1
 */