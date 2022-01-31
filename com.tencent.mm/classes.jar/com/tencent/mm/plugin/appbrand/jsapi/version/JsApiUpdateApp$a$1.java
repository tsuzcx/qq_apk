package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.d.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiUpdateApp$a$1
  implements d.a
{
  JsApiUpdateApp$a$1(JsApiUpdateApp.a parama, JsApiUpdateApp.SyncRequest paramSyncRequest, c paramc, LaunchParcel paramLaunchParcel) {}
  
  public final void a(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject, int paramInt)
  {
    AppMethodBeat.i(138129);
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] invalid result[%d]", new Object[] { JsApiUpdateApp.SyncRequest.a(this.iby).appId, Integer.valueOf(JsApiUpdateApp.SyncRequest.b(this.iby).scene), Integer.valueOf(paramInt) });
      this.eEg.ad(new JsApiUpdateApp.SyncResult(false, null));
      AppMethodBeat.o(138129);
      return;
    case 2: 
      ab.e("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] failed", new Object[] { JsApiUpdateApp.SyncRequest.a(this.iby).appId, Integer.valueOf(JsApiUpdateApp.SyncRequest.b(this.iby).scene) });
      this.eEg.ad(new JsApiUpdateApp.SyncResult(false, null));
      AppMethodBeat.o(138129);
      return;
    }
    ab.i("MicroMsg.AppBrand.JsApiUpdateApp", "IpcSyncAttr appId[%s] scene[%d] succeed", new Object[] { JsApiUpdateApp.SyncRequest.a(this.iby).appId, Integer.valueOf(JsApiUpdateApp.SyncRequest.b(this.iby).scene) });
    this.hTq.c(paramAppBrandInitConfigLU);
    this.eEg.ad(new JsApiUpdateApp.SyncResult(true, (AppBrandInitConfigWC)paramAppBrandInitConfigLU));
    AppMethodBeat.o(138129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.a.1
 * JD-Core Version:    0.7.0.1
 */