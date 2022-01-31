package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "errCode", "resultCallback"})
final class e$a$a
  implements e.c
{
  e$a$a(com.tencent.mm.ah.e parame, e.b paramb, String paramString) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134657);
    ab.i(e.access$getTAG$cp(), "GetHDHeadImg errType=%d  errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hDr.acU();
    e.b localb = this.hDs;
    if (localb != null)
    {
      o.acQ();
      String str2 = d.D(this.hDt, false);
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localb.BR(str1);
    }
    AppMethodBeat.o(134657);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.e.a.a
 * JD-Core Version:    0.7.0.1
 */