package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class ExdeviceAddDataSourceUI$7
  implements Runnable
{
  ExdeviceAddDataSourceUI$7(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(23849);
    Log.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
    wz localwz = new wz();
    EventCenter.instance.publish(localwz);
    AppMethodBeat.o(23849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.7
 * JD-Core Version:    0.7.0.1
 */