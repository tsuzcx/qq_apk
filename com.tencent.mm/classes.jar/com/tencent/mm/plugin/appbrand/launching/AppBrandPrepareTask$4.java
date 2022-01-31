package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandPrepareTask$4
  implements Runnable
{
  AppBrandPrepareTask$4(AppBrandPrepareTask paramAppBrandPrepareTask, WxaPkgWrappingInfo paramWxaPkgWrappingInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(131735);
    ab.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", new Object[] { Integer.valueOf(this.ijZ.gXf), bo.nU(this.ijZ.gXg) });
    AppMethodBeat.o(131735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.4
 * JD-Core Version:    0.7.0.1
 */