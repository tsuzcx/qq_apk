package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.e.e;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import junit.framework.Assert;

public class a
  implements c
{
  private long lIf = -1L;
  protected com.tencent.mm.plugin.exdevice.b.c lJl = null;
  protected d lJm = null;
  private m lJn = null;
  
  public a(com.tencent.mm.plugin.exdevice.b.c paramc, d paramd)
  {
    this.lJl = paramc;
    this.lJm = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(19728);
    ab.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.lJl.jRn), Short.valueOf(this.lJl.bpu()), Short.valueOf(this.lJl.lCu) });
    long l = this.lJl.jRn;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.g.a.p(l, i);
      if ((paramp == null) || (paramp == this.lJn)) {
        break;
      }
      ab.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      AppMethodBeat.o(19728);
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      ab.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.lJl.lCv != null)
    {
      i = this.lJl.lCv.lGK;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        ab.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.lJl.lCv.lGK), Long.valueOf(this.lJl.jRn) });
        if ((u.bqA().lCQ == null) || (!u.bqA().lCQ.jr(this.lJl.jRn))) {
          break label329;
        }
      }
    }
    label329:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ab.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
      }
      if (this.lJm != null) {
        this.lJm.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.lJn = null;
      AppMethodBeat.o(19728);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.lJm = paramd;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.service.m paramm)
  {
    AppMethodBeat.i(19727);
    if (paramm == null)
    {
      ab.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
      AppMethodBeat.o(19727);
      return false;
    }
    if (this.lJn != null)
    {
      ab.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      AppMethodBeat.o(19727);
      return false;
    }
    ab.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.lJl.bpu()), Short.valueOf(this.lJl.lCu), Long.valueOf(this.lJl.jRn) });
    m localm = new m(this.lJl, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      ab.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      AppMethodBeat.o(19727);
      return false;
    }
    this.lJn = localm;
    this.lIf = l;
    paramm = this.lJn;
    Assert.assertNotNull(paramm.lJI);
    paramm = paramm.lJI;
    paramm.lJB = false;
    paramm.lJC = false;
    aw.RO().caB().postDelayed(paramm.lJD, 15000L);
    AppMethodBeat.o(19727);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.a
 * JD-Core Version:    0.7.0.1
 */