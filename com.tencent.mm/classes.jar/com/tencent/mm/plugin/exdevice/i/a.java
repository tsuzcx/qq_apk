package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.e.e;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public class a
  implements c
{
  private long jyG = -1L;
  protected com.tencent.mm.plugin.exdevice.b.c jzM = null;
  protected d jzN = null;
  private m jzO = null;
  
  public a(com.tencent.mm.plugin.exdevice.b.c paramc, d paramd)
  {
    this.jzM = paramc;
    this.jzN = paramd;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int j = 1;
    y.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(this.jzM.hXu), Short.valueOf(this.jzM.aLh()), Short.valueOf(this.jzM.jsV) });
    long l = this.jzM.hXu;
    if (paramInt1 == 0) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.exdevice.g.a.k(l, i);
      if ((paramp == null) || (paramp == this.jzO)) {
        break;
      }
      y.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
      return;
    }
    if ((-1 == paramInt1) && (-2 == paramInt2)) {
      y.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
    }
    if (this.jzM.jsW != null)
    {
      i = this.jzM.jsW.jxl;
      if ((-5 == i) || (-3 == i) || (-4 == i))
      {
        y.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[] { Integer.valueOf(this.jzM.jsW.jxl), Long.valueOf(this.jzM.hXu) });
        if ((u.aMn().jtr == null) || (!u.aMn().jtr.dZ(this.jzM.hXu))) {
          break label315;
        }
      }
    }
    label315:
    for (i = j;; i = 0)
    {
      if (i == 0) {
        y.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
      }
      if (this.jzN != null) {
        this.jzN.a(paramLong, paramInt1, paramInt2, paramString);
      }
      this.jzO = null;
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    this.jzN = paramd;
  }
  
  public final boolean b(com.tencent.mm.plugin.exdevice.service.m paramm)
  {
    if (paramm == null)
    {
      y.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
      return false;
    }
    if (this.jzO != null)
    {
      y.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
      return false;
    }
    y.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[] { Short.valueOf(this.jzM.aLh()), Short.valueOf(this.jzM.jsV), Long.valueOf(this.jzM.hXu) });
    m localm = new m(this.jzM, this);
    long l = paramm.a(localm);
    if (-1L == l)
    {
      y.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
      return false;
    }
    this.jzO = localm;
    this.jyG = l;
    paramm = this.jzO;
    Assert.assertNotNull(paramm.jAj);
    paramm = paramm.jAj;
    paramm.jAc = false;
    paramm.jAd = false;
    au.DS().crf().postDelayed(paramm.jAe, 15000L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.a
 * JD-Core Version:    0.7.0.1
 */