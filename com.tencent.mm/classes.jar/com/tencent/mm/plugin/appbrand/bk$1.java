package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.sdk.platformtools.Log;

final class bk$1
  implements z.a
{
  public final void eW(String paramString)
  {
    AppMethodBeat.i(146926);
    Log.e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", new Object[] { "WASourceMap.js", paramString });
    AppMethodBeat.o(146926);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(146925);
    Log.i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", new Object[] { "WASourceMap.js", paramString });
    AppMethodBeat.o(146925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bk.1
 * JD-Core Version:    0.7.0.1
 */