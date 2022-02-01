package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

final class e$1
  implements IPCRunCgi.a
{
  e$1(e parame, q paramq, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(163956);
    paramb = new JSONObject();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jRD.h(this.bZy, a.a("", 0, paramb));
      AppMethodBeat.o(163956);
      return;
    }
    if (paramInt1 == 4)
    {
      this.jRD.h(this.bZy, a.a(paramString, paramInt2, paramb));
      AppMethodBeat.o(163956);
      return;
    }
    this.jRD.h(this.bZy, a.a(paramString, -1, paramb));
    AppMethodBeat.o(163956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.e.1
 * JD-Core Version:    0.7.0.1
 */