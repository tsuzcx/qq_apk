package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.f.e;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import junit.framework.Assert;

public class a
  implements c
{
  private long pCa = -1L;
  protected com.tencent.mm.plugin.exdevice.c.c pDh = null;
  protected d pDi = null;
  private m pDj = null;
  
  public a(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    this.pDh = paramc;
    this.pDi = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23796);
    ac.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.pDh.nsB), Short.valueOf(this.pDh.cgk()), Short.valueOf(this.pDh.pwr) });
    long l = this.pDh.nsB;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.t(l, i);
      if ((paramp == null) || (paramp == this.pDj)) {
        break;
      }
      ac.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      AppMethodBeat.o(23796);
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      ac.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.pDh.pws != null)
    {
      i = this.pDh.pws.pAG;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        ac.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.pDh.pws.pAG), Long.valueOf(this.pDh.nsB) });
        if ((u.chr().pwN == null) || (!u.chr().pwN.sL(this.pDh.nsB))) {
          break label329;
        }
      }
    }
    label329:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ac.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
      }
      if (this.pDi != null) {
        this.pDi.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.pDj = null;
      AppMethodBeat.o(23796);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.pDi = paramd;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.service.m paramm)
  {
    AppMethodBeat.i(23795);
    if (paramm == null)
    {
      ac.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
      AppMethodBeat.o(23795);
      return false;
    }
    if (this.pDj != null)
    {
      ac.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    ac.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.pDh.cgk()), Short.valueOf(this.pDh.pwr), Long.valueOf(this.pDh.nsB) });
    m localm = new m(this.pDh, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      ac.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    this.pDj = localm;
    this.pCa = l;
    paramm = this.pDj;
    Assert.assertNotNull(paramm.pDD);
    paramm = paramm.pDD;
    paramm.pDw = false;
    paramm.pDx = false;
    az.agU().cOC().postDelayed(paramm.pDy, 15000L);
    AppMethodBeat.o(23795);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */