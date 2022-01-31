package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.mm.pluginsdk.ui.tools.s.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$3$1
  implements s.a
{
  e$3$1(e.3 param3) {}
  
  public final void uK(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
      return;
    }
    e.c(this.gGF.gGA, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.3.1
 * JD-Core Version:    0.7.0.1
 */