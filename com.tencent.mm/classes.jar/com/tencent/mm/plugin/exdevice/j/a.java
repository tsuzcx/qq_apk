package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.f.e;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import junit.framework.Assert;

public class a
  implements c
{
  private long qmk = -1L;
  protected com.tencent.mm.plugin.exdevice.c.c qnr = null;
  protected d qns = null;
  private m qnt = null;
  
  public a(com.tencent.mm.plugin.exdevice.c.c paramc, d paramd)
  {
    this.qnr = paramc;
    this.qns = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23796);
    ae.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.qnr.nZd), Short.valueOf(this.qnr.cme()), Short.valueOf(this.qnr.qgB) });
    long l = this.qnr.nZd;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.h.a.t(l, i);
      if ((paramp == null) || (paramp == this.qnt)) {
        break;
      }
      ae.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      AppMethodBeat.o(23796);
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      ae.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.qnr.qgC != null)
    {
      i = this.qnr.qgC.qkQ;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        ae.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.qnr.qgC.qkQ), Long.valueOf(this.qnr.nZd) });
        if ((u.cnl().qgX == null) || (!u.cnl().qgX.va(this.qnr.nZd))) {
          break label329;
        }
      }
    }
    label329:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ae.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
      }
      if (this.qns != null) {
        this.qns.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.qnt = null;
      AppMethodBeat.o(23796);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.qns = paramd;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.service.m paramm)
  {
    AppMethodBeat.i(23795);
    if (paramm == null)
    {
      ae.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
      AppMethodBeat.o(23795);
      return false;
    }
    if (this.qnt != null)
    {
      ae.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    ae.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.qnr.cme()), Short.valueOf(this.qnr.qgB), Long.valueOf(this.qnr.nZd) });
    m localm = new m(this.qnr, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      ae.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      AppMethodBeat.o(23795);
      return false;
    }
    this.qnt = localm;
    this.qmk = l;
    paramm = this.qnt;
    Assert.assertNotNull(paramm.qnN);
    paramm = paramm.qnN;
    paramm.qnG = false;
    paramm.qnH = false;
    bc.ajU().cZF().postDelayed(paramm.qnI, 15000L);
    AppMethodBeat.o(23795);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.a
 * JD-Core Version:    0.7.0.1
 */