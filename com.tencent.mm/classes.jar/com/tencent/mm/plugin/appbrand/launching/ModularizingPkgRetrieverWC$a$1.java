package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;

final class ModularizingPkgRetrieverWC$a$1
  extends o.c
{
  ModularizingPkgRetrieverWC$a$1(ModularizingPkgRetrieverWC.a parama) {}
  
  public final void a(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
  {
    AppMethodBeat.i(131928);
    if (ModularizingPkgRetrieverWC.a.a(this.iml) != null)
    {
      ModularizingPkgRetrieverWC.a.a(this.iml).ad(new ModularizingPkgRetrieverWC.WxaPkgResultProgressPair(paramWxaPkgWrappingInfo));
      ModularizingPkgRetrieverWC.a.b(this.iml);
    }
    AppMethodBeat.o(131928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.a.1
 * JD-Core Version:    0.7.0.1
 */