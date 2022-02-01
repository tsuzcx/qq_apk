package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends a
  implements d
{
  private final d pDk;
  
  public b(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(23797);
    a(this);
    this.pDk = paramd;
    AppMethodBeat.o(23797);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23798);
    ac.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.exdevice.i.b localb;
    if (2 == ((h)this.pDh).cgo())
    {
      ac.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
      localb = ad.cgP().Zc(this.pDh.nsB);
      if (localb == null)
      {
        ac.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[] { Long.valueOf(this.pDh.nsB) });
        if (this.pDk != null) {
          this.pDk.a(paramLong, paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(23798);
        return;
      }
      switch (localb.field_closeStrategy)
      {
      default: 
        ac.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[] { Integer.valueOf(localb.field_closeStrategy) });
      }
    }
    for (;;)
    {
      if (this.pDk != null) {
        this.pDk.a(paramLong, paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(23798);
      return;
      ac.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.pDh.nsB) });
      if (u.chr().pwN != null)
      {
        u.chr().pwN.sL(this.pDh.nsB);
        continue;
        ac.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.pDh.nsB) });
        if (!com.tencent.mm.plugin.exdevice.i.a.X("shut_down_device", this.pDh.nsB)) {
          ac.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.b
 * JD-Core Version:    0.7.0.1
 */