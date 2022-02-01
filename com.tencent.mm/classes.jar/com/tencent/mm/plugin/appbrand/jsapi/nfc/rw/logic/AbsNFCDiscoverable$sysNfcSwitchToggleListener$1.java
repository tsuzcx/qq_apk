package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/AbsNFCDiscoverable$sysNfcSwitchToggleListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AbsNFCDiscoverable$sysNfcSwitchToggleListener$1
  extends BroadcastReceiver
{
  AbsNFCDiscoverable$sysNfcSwitchToggleListener$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(328072);
    if (paramIntent == null) {}
    a locala;
    int i;
    for (paramContext = null;; paramContext = paramIntent)
    {
      if (paramContext == null) {
        Log.w("MicroMsg.AppBrand.AbsNFCDiscoverable", "onReceive#sysNfcSwitchToggleListener, state is null");
      }
      AppMethodBeat.o(328072);
      return;
      paramIntent = Integer.valueOf(paramIntent.getIntExtra("android.nfc.extra.ADAPTER_STATE", -1));
      locala = this.sma;
      i = ((Number)paramIntent).intValue();
      if (-1 != i) {
        break;
      }
      Log.w("MicroMsg.AppBrand.AbsNFCDiscoverable", "onReceive#sysNfcSwitchToggleListener, state is invalid");
    }
    if (3 == i) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.AbsNFCDiscoverable", s.X("onReceive#sysNfcSwitchToggleListener, isNFCEnabled: ", Boolean.valueOf(bool)));
      paramContext = paramIntent;
      if (bool) {
        break;
      }
      locala.slX.set(false);
      locala.slY = false;
      paramContext = paramIntent;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.AbsNFCDiscoverable.sysNfcSwitchToggleListener.1
 * JD-Core Version:    0.7.0.1
 */