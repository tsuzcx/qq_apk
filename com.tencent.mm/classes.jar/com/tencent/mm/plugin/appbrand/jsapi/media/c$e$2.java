package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.b;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onResult", "([Ljava/lang/String;[I)V"})
final class c$e$2
  implements e.d
{
  c$e$2(b paramb, ArrayList paramArrayList) {}
  
  public final void n(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(143795);
    j.p(paramArrayOfInt, "grantResults");
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramArrayOfInt[j] != 0)
      {
        this.hEh.cK(new IllegalAccessException("fail:system permission denied"));
        ab.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "interrupt pipeline, " + (String)this.hQu.get(i) + " denied by user");
        AppMethodBeat.o(143795);
        return;
      }
      j += 1;
      i += 1;
    }
    this.hEh.C(new Object[] { Boolean.TRUE });
    AppMethodBeat.o(143795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.e.2
 * JD-Core Version:    0.7.0.1
 */