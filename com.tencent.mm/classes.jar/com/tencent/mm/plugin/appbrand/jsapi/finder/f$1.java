package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

final class f$1
  implements IPCRunCgi.a
{
  f$1(f paramf, s params, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(163958);
    paramd = new JSONObject();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.lsQ.i(this.cvP, a.a("", 0, paramd));
      AppMethodBeat.o(163958);
      return;
    }
    if (paramInt1 == 4)
    {
      this.lsQ.i(this.cvP, a.a(paramString, paramInt2, paramd));
      AppMethodBeat.o(163958);
      return;
    }
    this.lsQ.i(this.cvP, a.a(paramString, -1, paramd));
    AppMethodBeat.o(163958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.f.1
 * JD-Core Version:    0.7.0.1
 */