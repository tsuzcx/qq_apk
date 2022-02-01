package com.tencent.mm.plugin.appbrand.headless;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/headless/AppBrandHeadlessStartService$start$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$d
  implements f
{
  public a$d(int paramInt, long paramLong, f paramf) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(317587);
    Object localObject = new StringBuilder("onError, requestId:").append(this.qrX).append(", errCode:");
    f.b localb = f.b.qAE;
    Log.e("MicroMsg.AppBrandHeadlessStartService", f.b.zh(paramInt) + ", errMsg:" + paramString + ", cost:" + Util.ticksToNow(this.qrY));
    localObject = this.qrT;
    if (localObject != null) {
      ((f)localObject).onError(paramInt, paramString);
    }
    AppMethodBeat.o(317587);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(317575);
    Log.i("MicroMsg.AppBrandHeadlessStartService", "onSuccess, requestId:" + this.qrX + ", cost:" + Util.ticksToNow(this.qrY));
    f localf = this.qrT;
    if (localf != null) {
      localf.onSuccess();
    }
    AppMethodBeat.o(317575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.a.d
 * JD-Core Version:    0.7.0.1
 */