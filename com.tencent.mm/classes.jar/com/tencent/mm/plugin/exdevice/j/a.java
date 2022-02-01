package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.f.e;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import junit.framework.Assert;

public class a
  implements c
{
  private long rDg = -1L;
  private m rEA = null;
  protected com.tencent.mm.plugin.exdevice.c.c rEy = null;
  protected d rEz = null;
  
  public a(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    this.rEy = paramc;
    this.rEz = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23796);
    Log.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.rEy.pkb), Short.valueOf(this.rEy.cKg()), Short.valueOf(this.rEy.rxx) });
    long l = this.rEy.pkb;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.q(l, i);
      if ((paramp == null) || (paramp == this.rEA)) {
        break;
      }
      Log.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      AppMethodBeat.o(23796);
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.rEy.rxy != null)
    {
      i = this.rEy.rxy.rBL;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        Log.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.rEy.rxy.rBL), Long.valueOf(this.rEy.pkb) });
        if ((u.cLy().rxT == null) || (!u.cLy().rxT.De(this.rEy.pkb))) {
          break label329;
        }
      }
    }
    label329:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        Log.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
      }
      if (this.rEz != null) {
        this.rEz.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.rEA = null;
      AppMethodBeat.o(23796);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.rEz = paramd;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.service.m paramm)
  {
    AppMethodBeat.i(23795);
    if (paramm == null)
    {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
      AppMethodBeat.o(23795);
      return false;
    }
    if (this.rEA != null)
    {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    Log.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.rEy.cKg()), Short.valueOf(this.rEy.rxx), Long.valueOf(this.rEy.pkb) });
    m localm = new m(this.rEy, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    this.rEA = localm;
    this.rDg = l;
    paramm = this.rEA;
    Assert.assertNotNull(paramm.rEU);
    paramm = paramm.rEU;
    paramm.rEN = false;
    paramm.rEO = false;
    bg.aAk().getWorkerHandler().postDelayed(paramm.rEP, 15000L);
    AppMethodBeat.o(23795);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */