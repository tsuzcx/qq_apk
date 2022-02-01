package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.y;
import org.json.JSONObject;

final class e$1
  implements IPCRunCgi.a
{
  e$1(e parame, y paramy, int paramInt) {}
  
  public final void callback(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(163958);
    paramc = new JSONObject();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rrw.callback(this.elZ, a.a("", 0, paramc));
      AppMethodBeat.o(163958);
      return;
    }
    if (paramInt1 == 4)
    {
      this.rrw.callback(this.elZ, a.a(paramString, paramInt2, paramc));
      AppMethodBeat.o(163958);
      return;
    }
    this.rrw.callback(this.elZ, a.a(paramString, -1, paramc));
    AppMethodBeat.o(163958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.e.1
 * JD-Core Version:    0.7.0.1
 */