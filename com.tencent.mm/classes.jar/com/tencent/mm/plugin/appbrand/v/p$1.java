package com.tencent.mm.plugin.appbrand.v;

import com.tencent.mm.sdk.platformtools.y;

final class p$1
  implements k.a
{
  public final void fM(String paramString)
  {
    y.e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", new Object[] { "WASourceMap.js", paramString });
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", new Object[] { "WASourceMap.js", paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.p.1
 * JD-Core Version:    0.7.0.1
 */