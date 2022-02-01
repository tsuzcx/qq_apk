package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;

public final class b
  extends a
  implements d
{
  private final d oZZ;
  
  public b(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(23797);
    a(this);
    this.oZZ = paramd;
    AppMethodBeat.o(23797);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23798);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.exdevice.i.b localb;
    if (2 == ((h)this.oZW).bZf())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
      localb = com.tencent.mm.plugin.exdevice.model.ad.bZG().UQ(this.oZW.mQq);
      if (localb == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[] { Long.valueOf(this.oZW.mQq) });
        if (this.oZZ != null) {
          this.oZZ.a(paramLong, paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(23798);
        return;
      }
      switch (localb.field_closeStrategy)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[] { Integer.valueOf(localb.field_closeStrategy) });
      }
    }
    for (;;)
    {
      if (this.oZZ != null) {
        this.oZZ.a(paramLong, paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(23798);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.oZW.mQq) });
      if (u.cai().oTC != null)
      {
        u.cai().oTC.oZ(this.oZW.mQq);
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.oZW.mQq) });
        if (!com.tencent.mm.plugin.exdevice.i.a.W("shut_down_device", this.oZW.mQq)) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.b
 * JD-Core Version:    0.7.0.1
 */