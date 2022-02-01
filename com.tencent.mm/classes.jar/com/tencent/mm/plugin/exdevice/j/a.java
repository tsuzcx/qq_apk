package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
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
  private long yuP = -1L;
  protected com.tencent.mm.plugin.exdevice.c.c ywg = null;
  protected d ywh = null;
  private m ywi = null;
  
  public a(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    this.ywg = paramc;
    this.ywh = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23796);
    Log.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.ywg.vyj), Short.valueOf(this.ywg.dFh()), Short.valueOf(this.ywg.yoQ) });
    long l = this.ywg.vyj;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.B(l, i);
      if ((paramp == null) || (paramp == this.ywi)) {
        break;
      }
      Log.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      AppMethodBeat.o(23796);
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.ywg.yoR != null)
    {
      i = this.ywg.yoR.ytv;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        Log.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.ywg.yoR.ytv), Long.valueOf(this.ywg.vyj) });
        if ((u.dGE().yps == null) || (!u.dGE().yps.lI(this.ywg.vyj))) {
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
      if (this.ywh != null) {
        this.ywh.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.ywi = null;
      AppMethodBeat.o(23796);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.ywh = paramd;
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
    if (this.ywi != null)
    {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    Log.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.ywg.dFh()), Short.valueOf(this.ywg.yoQ), Long.valueOf(this.ywg.vyj) });
    m localm = new m(this.ywg, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      Log.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    this.ywi = localm;
    this.yuP = l;
    paramm = this.ywi;
    Assert.assertNotNull(paramm.ywC);
    paramm = paramm.ywC;
    paramm.ywv = false;
    paramm.yww = false;
    bh.baH().getWorkerHandler().postDelayed(paramm.ywx, 15000L);
    AppMethodBeat.o(23795);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */