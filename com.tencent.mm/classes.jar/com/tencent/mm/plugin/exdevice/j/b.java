package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends a
  implements d
{
  private final d rEB;
  
  public b(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    super(paramc, paramd);
    AppMethodBeat.i(23797);
    a(this);
    this.rEB = paramd;
    AppMethodBeat.o(23797);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23798);
    Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.plugin.exdevice.i.b localb;
    if (2 == ((h)this.rEy).cKk())
    {
      Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
      localb = ad.cKL().anI(this.rEy.pkb);
      if (localb == null)
      {
        Log.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", new Object[] { Long.valueOf(this.rEy.pkb) });
        if (this.rEB != null) {
          this.rEB.a(paramLong, paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(23798);
        return;
      }
      switch (localb.field_closeStrategy)
      {
      default: 
        Log.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", new Object[] { Integer.valueOf(localb.field_closeStrategy) });
      }
    }
    for (;;)
    {
      if (this.rEB != null) {
        this.rEB.a(paramLong, paramInt1, paramInt2, paramString);
      }
      AppMethodBeat.o(23798);
      return;
      Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.rEy.pkb) });
      if (u.cLy().rxT != null)
      {
        u.cLy().rxT.De(this.rEy.pkb);
        continue;
        Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", new Object[] { Integer.valueOf(localb.field_closeStrategy), Long.valueOf(this.rEy.pkb) });
        if (!com.tencent.mm.plugin.exdevice.i.a.ad("shut_down_device", this.rEy.pkb)) {
          Log.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.b
 * JD-Core Version:    0.7.0.1
 */