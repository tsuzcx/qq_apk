package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/OnMonitoredBluetoothDeviceFoundEvent$runOnAppBrandCreate$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onCreate", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r$d
  extends k.c
{
  r$d(a<ah> parama, String paramString) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(329607);
    this.$block.invoke();
    k.b(this.eug, (k.c)this);
    AppMethodBeat.o(329607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.r.d
 * JD-Core Version:    0.7.0.1
 */