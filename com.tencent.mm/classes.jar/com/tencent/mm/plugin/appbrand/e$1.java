package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  implements k.a
{
  e$1(e parame, d paramd, String paramString) {}
  
  public final void fM(String paramString)
  {
    y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject failed", new Object[] { this.fxH.fxC.mAppId, Integer.valueOf(this.fxF.agf()), this.fxG });
    this.fxH.cD(false);
  }
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject succeed", new Object[] { this.fxH.fxC.mAppId, Integer.valueOf(this.fxF.agf()), this.fxG });
    this.fxH.cD(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.1
 * JD-Core Version:    0.7.0.1
 */