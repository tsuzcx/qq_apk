package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements k.a
{
  e$2(e parame, String paramString) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject failed", new Object[] { this.fxH.fxC.mAppId, this.fxI });
    this.fxH.cC(false);
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", new Object[] { this.fxH.fxC.mAppId, this.fxI });
    this.fxH.cC(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.2
 * JD-Core Version:    0.7.0.1
 */