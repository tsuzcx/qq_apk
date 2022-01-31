package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$2
  implements Application.ActivityLifecycleCallbacks
{
  private boolean isPaused = false;
  
  d$2(d paramd) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(141905);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityPaused");
    a.hUM.dismissDialog();
    this.isPaused = true;
    AppMethodBeat.o(141905);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(141904);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onActivityResumed");
    if (this.isPaused)
    {
      ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo onActivityResumed isPaused and do checLogic");
      this.isPaused = false;
      a.hUM.aDZ();
    }
    AppMethodBeat.o(141904);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.2
 * JD-Core Version:    0.7.0.1
 */