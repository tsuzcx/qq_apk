package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ag$1
  implements n.a
{
  public final void bU(String paramString)
  {
    AppMethodBeat.i(140811);
    ab.e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", new Object[] { "WASourceMap.js", paramString });
    AppMethodBeat.o(140811);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(140810);
    ab.i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", new Object[] { "WASourceMap.js", paramString });
    AppMethodBeat.o(140810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.1
 * JD-Core Version:    0.7.0.1
 */