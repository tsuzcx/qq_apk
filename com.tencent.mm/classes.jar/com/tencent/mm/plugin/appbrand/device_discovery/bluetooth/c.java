package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.device_discovery.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/AutoConnectGattSimpleStrategy;", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IAutoConnectGattStrategy;", "deviceId", "", "gattConnectListener", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/IGattConnectListener;)V", "myTag", "connect", "", "disconnect", "pauseConnect", "", "resumeConnect", "canReset", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements j
{
  public static final c.a rgH;
  private final String djQ;
  private final String hEl;
  private final l rgz;
  
  static
  {
    AppMethodBeat.i(321641);
    rgH = new c.a((byte)0);
    AppMethodBeat.o(321641);
  }
  
  public c(String paramString, l paraml)
  {
    AppMethodBeat.i(321635);
    this.hEl = paramString;
    this.rgz = paraml;
    this.djQ = s.X("MicroMsg.AppBrand.AutoConnectGattSimpleStrategy#", Integer.valueOf(hashCode()));
    AppMethodBeat.o(321635);
  }
  
  public final boolean cmB()
  {
    AppMethodBeat.i(321648);
    Object localObject = a.rfZ;
    a.i(this.djQ, "connect");
    localObject = e.rgJ;
    boolean bool = e.b(this.hEl, this.rgz);
    AppMethodBeat.o(321648);
    return bool;
  }
  
  public final void cmC()
  {
    AppMethodBeat.i(321661);
    a locala = a.rfZ;
    a.i(this.djQ, "pauseConnect");
    AppMethodBeat.o(321661);
  }
  
  public final boolean disconnect()
  {
    AppMethodBeat.i(321656);
    Object localObject = a.rfZ;
    a.i(this.djQ, "disconnect");
    localObject = e.rgJ;
    boolean bool = e.YF(this.hEl);
    AppMethodBeat.o(321656);
    return bool;
  }
  
  public final void iO(boolean paramBoolean)
  {
    AppMethodBeat.i(321667);
    a locala = a.rfZ;
    a.i(this.djQ, s.X("resumeConnect, canReset: ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(321667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.c
 * JD-Core Version:    0.7.0.1
 */