package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bo;

final class i$1
  extends e.c
{
  i$1(String paramString1, String paramString2, String paramString3, long paramLong, AppBrandStatObject paramAppBrandStatObject) {}
  
  private void a(e.d paramd, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131346);
    i.a(paramd, paramString1, paramString2, paramString3, bo.aoy() - this.fET);
    this.hTt.hST = null;
    e.b(paramString1, this);
    AppMethodBeat.o(131346);
  }
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(131344);
    a(paramd, this.val$appId, this.val$path, this.hTs);
    AppMethodBeat.o(131344);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(131345);
    a(e.xX(this.val$appId), this.val$appId, this.val$path, this.hTs);
    AppMethodBeat.o(131345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i.1
 * JD-Core Version:    0.7.0.1
 */