package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends a
  implements d
{
  private final d jzP;
  
  public b(com.tencent.mm.plugin.exdevice.b.c paramc, d paramd)
  {
    super(paramc, paramd);
    a(this);
    this.jzP = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    y.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.exdevice.h.b localb;
    if (2 == ((h)this.jzM).aLl())
    {
      y.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
      localb = ad.aLL().BF(this.jzM.hXu);
      if (localb == null)
      {
        y.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[] { Long.valueOf(this.jzM.hXu) });
        if (this.jzP != null) {
          this.jzP.a(paramLong, paramInt1, paramInt2, paramString);
        }
        return;
      }
      switch (localb.field_closeStrategy)
      {
      default: 
        y.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[] { Integer.valueOf(localb.field_closeStrategy) });
      }
    }
    while (this.jzP != null)
    {
      this.jzP.a(paramLong, paramInt1, paramInt2, paramString);
      return;
      y.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.jzM.hXu) });
      if (u.aMn().jtr != null)
      {
        u.aMn().jtr.dZ(this.jzM.hXu);
        continue;
        y.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.jzM.hXu) });
        if (!com.tencent.mm.plugin.exdevice.h.a.B("shut_down_device", this.jzM.hXu)) {
          y.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.b
 * JD-Core Version:    0.7.0.1
 */