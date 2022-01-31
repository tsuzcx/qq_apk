package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.c.aop;

final class ExdeviceManageDeviceUI$a$4
  implements Runnable
{
  ExdeviceManageDeviceUI$a$4(ExdeviceManageDeviceUI.a parama, b paramb) {}
  
  public final void run()
  {
    Object localObject = new aop();
    ((aop)localObject).hQb = this.jDI.field_deviceID;
    ((aop)localObject).syI = this.jDI.field_deviceType;
    localObject = new x((aop)localObject, 2);
    au.Dk().a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.4
 * JD-Core Version:    0.7.0.1
 */