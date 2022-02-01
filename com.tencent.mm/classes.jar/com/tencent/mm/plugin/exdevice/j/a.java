package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.f.e;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import junit.framework.Assert;

public class a
  implements c
{
  private long oYP = -1L;
  protected com.tencent.mm.plugin.exdevice.c.c oZW = null;
  protected d oZX = null;
  private m oZY = null;
  
  public a(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    this.oZW = paramc;
    this.oZX = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23796);
    ad.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.oZW.mQq), Short.valueOf(this.oZW.bZb()), Short.valueOf(this.oZW.oTg) });
    long l = this.oZW.mQq;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.s(l, i);
      if ((paramp == null) || (paramp == this.oZY)) {
        break;
      }
      ad.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      AppMethodBeat.o(23796);
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      ad.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.oZW.oTh != null)
    {
      i = this.oZW.oTh.oXv;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        ad.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.oZW.oTh.oXv), Long.valueOf(this.oZW.mQq) });
        if ((u.cai().oTC == null) || (!u.cai().oTC.oZ(this.oZW.mQq))) {
          break label329;
        }
      }
    }
    label329:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ad.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
      }
      if (this.oZX != null) {
        this.oZX.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.oZY = null;
      AppMethodBeat.o(23796);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.oZX = paramd;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.service.m paramm)
  {
    AppMethodBeat.i(23795);
    if (paramm == null)
    {
      ad.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
      AppMethodBeat.o(23795);
      return false;
    }
    if (this.oZY != null)
    {
      ad.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    ad.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.oZW.bZb()), Short.valueOf(this.oZW.oTg), Long.valueOf(this.oZW.mQq) });
    m localm = new m(this.oZW, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      ad.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    this.oZY = localm;
    this.oYP = l;
    paramm = this.oZY;
    Assert.assertNotNull(paramm.pas);
    paramm = paramm.pas;
    paramm.pal = false;
    paramm.pam = false;
    az.afE().cBt().postDelayed(paramm.pan, 15000L);
    AppMethodBeat.o(23795);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */