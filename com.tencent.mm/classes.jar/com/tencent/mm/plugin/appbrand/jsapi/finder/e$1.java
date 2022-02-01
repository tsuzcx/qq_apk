package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.v;
import org.json.JSONObject;

final class e$1
  implements IPCRunCgi.a
{
  e$1(e parame, v paramv, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(163956);
    paramd = new JSONObject();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.onN.j(this.cuf, a.a("", 0, paramd));
      AppMethodBeat.o(163956);
      return;
    }
    if (paramInt1 == 4)
    {
      this.onN.j(this.cuf, a.a(paramString, paramInt2, paramd));
      AppMethodBeat.o(163956);
      return;
    }
    this.onN.j(this.cuf, a.a(paramString, -1, paramd));
    AppMethodBeat.o(163956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.e.1
 * JD-Core Version:    0.7.0.1
 */