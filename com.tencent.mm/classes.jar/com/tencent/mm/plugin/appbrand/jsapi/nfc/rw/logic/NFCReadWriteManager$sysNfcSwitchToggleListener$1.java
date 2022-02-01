package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-commons-jsapi-nfc-ext_release"})
public final class NFCReadWriteManager$sysNfcSwitchToggleListener$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(207156);
    if (paramIntent != null)
    {
      int i = ((Number)Integer.valueOf(paramIntent.getIntExtra("android.nfc.extra.ADAPTER_STATE", -1))).intValue();
      if (-1 == i)
      {
        Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, state is invalid");
        AppMethodBeat.o(207156);
        return;
      }
      if (3 == i) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, isNFCEnabled: ".concat(String.valueOf(bool)));
        if (!bool)
        {
          c.a(this.miP).set(false);
          c.a(this.miP, false);
        }
        AppMethodBeat.o(207156);
        return;
      }
    }
    Log.w("MicroMsg.AppBrand.NFCReadWriteManager", "onReceive#sysNfcSwitchToggleListener, state is null");
    AppMethodBeat.o(207156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.NFCReadWriteManager.sysNfcSwitchToggleListener.1
 * JD-Core Version:    0.7.0.1
 */