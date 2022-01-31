package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.auh;

final class ExdeviceManageDeviceUI$a$4
  implements Runnable
{
  ExdeviceManageDeviceUI$a$4(ExdeviceManageDeviceUI.a parama, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(19985);
    Object localObject = new auh();
    ((auh)localObject).jJD = this.lNg.field_deviceID;
    ((auh)localObject).wsq = this.lNg.field_deviceType;
    localObject = new x((auh)localObject, 2);
    aw.Rc().a((m)localObject, 0);
    AppMethodBeat.o(19985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.4
 * JD-Core Version:    0.7.0.1
 */