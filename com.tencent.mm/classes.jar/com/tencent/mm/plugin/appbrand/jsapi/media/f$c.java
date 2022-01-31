package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class f$c<T>
  implements d.a<Object>
{
  f$c(f paramf, c paramc, int paramInt) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(143824);
    if ((paramObject instanceof Exception))
    {
      Object localObject = ((Exception)paramObject).getMessage();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      localObject = this.hRP;
      int i = this.hAB;
      f localf = this.hRO;
      if (m.jw(paramObject, "fail")) {}
      for (;;)
      {
        ((c)localObject).h(i, localf.BL(paramObject));
        AppMethodBeat.o(143824);
        return;
        paramObject = "fail ".concat(String.valueOf(paramObject));
      }
    }
    f.aDQ();
    ab.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + paramObject + ')');
    this.hRP.h(this.hAB, this.hRO.BL("fail:internal error"));
    AppMethodBeat.o(143824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f.c
 * JD-Core Version:    0.7.0.1
 */