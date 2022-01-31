package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a
  implements d
{
  private final d lJo;
  
  public b(com.tencent.mm.plugin.exdevice.b.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(19729);
    a(this);
    this.lJo = paramd;
    AppMethodBeat.o(19729);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19730);
    ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.exdevice.h.b localb;
    if (2 == ((h)this.lJl).bpy())
    {
      ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
      localb = ad.bpY().LH(this.lJl.jRn);
      if (localb == null)
      {
        ab.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[] { Long.valueOf(this.lJl.jRn) });
        if (this.lJo != null) {
          this.lJo.a(paramLong, paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(19730);
        return;
      }
      switch (localb.field_closeStrategy)
      {
      default: 
        ab.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[] { Integer.valueOf(localb.field_closeStrategy) });
      }
    }
    for (;;)
    {
      if (this.lJo != null) {
        this.lJo.a(paramLong, paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(19730);
      return;
      ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.lJl.jRn) });
      if (u.bqA().lCQ != null)
      {
        u.bqA().lCQ.jr(this.lJl.jRn);
        continue;
        ab.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.lJl.jRn) });
        if (!com.tencent.mm.plugin.exdevice.h.a.L("shut_down_device", this.lJl.jRn)) {
          ab.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.b
 * JD-Core Version:    0.7.0.1
 */