package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;

public final class b
  extends a
  implements d
{
  private final d qgP;
  
  public b(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(23797);
    a(this);
    this.qgP = paramd;
    AppMethodBeat.o(23797);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23798);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.exdevice.i.b localb;
    if (2 == ((h)this.qgM).ckS())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
      localb = com.tencent.mm.plugin.exdevice.model.ad.clt().acI(this.qgM.nTx);
      if (localb == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[] { Long.valueOf(this.qgM.nTx) });
        if (this.qgP != null) {
          this.qgP.a(paramLong, paramInt1, paramInt2, paramString);
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
      if (this.qgP != null) {
        this.qgP.a(paramLong, paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(23798);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.qgM.nTx) });
      if (u.clV().qas != null)
      {
        u.clV().qas.uJ(this.qgM.nTx);
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.qgM.nTx) });
        if (!com.tencent.mm.plugin.exdevice.i.a.ae("shut_down_device", this.qgM.nTx)) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.b
 * JD-Core Version:    0.7.0.1
 */