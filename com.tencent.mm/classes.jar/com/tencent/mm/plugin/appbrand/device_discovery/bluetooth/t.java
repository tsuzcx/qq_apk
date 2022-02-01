package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/WeAppRunningState;", "", "flattenVal", "", "(Ljava/lang/String;II)V", "getFlattenVal", "()I", "FOREGROUND", "BACKGROUND", "SUSPEND", "NOT_ALIVE", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum t
{
  public static final a rhC;
  final int rht;
  
  static
  {
    AppMethodBeat.i(321642);
    rhD = new t("FOREGROUND", 0, 0);
    rhE = new t("BACKGROUND", 1, 1);
    rhF = new t("SUSPEND", 2, 2);
    rhG = new t("NOT_ALIVE", 3, 3);
    rhH = new t[] { rhD, rhE, rhF, rhG };
    rhC = new a((byte)0);
    AppMethodBeat.o(321642);
  }
  
  private t(int paramInt)
  {
    this.rht = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/WeAppRunningState$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/WeAppRunningState;", "flattenVal", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.t
 * JD-Core Version:    0.7.0.1
 */