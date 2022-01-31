package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cfm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public v2protocal lqG = new v2protocal(this.lqH);
  private ah lqH = new a.1(this, Looper.getMainLooper());
  private boolean lqI = false;
  public boolean lqJ = false;
  public boolean lqK = false;
  public a.a lqL = null;
  
  public final void bcA()
  {
    if (this.lqI) {
      y.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
    }
    com.tencent.mm.plugin.ipcall.a.a.c localc;
    do
    {
      return;
      y.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
      localc = i.bcg().loW;
    } while (localc == null);
    if (localc.hID != null)
    {
      cec localcec1 = com.tencent.mm.plugin.ipcall.b.c.ab(localc.hID);
      cec localcec2 = com.tencent.mm.plugin.ipcall.b.c.ab(localc.lqb);
      cfm localcfm = new cfm();
      localcfm.tUF = 0;
      localcfm.tUG = 0;
      localcfm.tUH = 0;
      localcfm.userName = "";
      localcfm.foj = "";
      this.lqG.a(localcec1, localcec1, localcec2, localcfm, null);
    }
    y.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
    this.lqG.pUE = localc.lpW;
    this.lqG.pVz = localc.lpZ;
    if (localc.lqa != null) {
      this.lqG.pVA = localc.lqa.toByteArray();
    }
    if (localc.lpX != null) {
      this.lqG.pUF = localc.lpX.toByteArray();
    }
    this.lqG.lpD = localc.lpD;
    this.lqG.lpE = localc.lpE;
    this.lqG.lpL = localc.lpL;
    this.lqG.pUH = localc.lpU;
    this.lqG.pUG = localc.lpV;
    this.lqG.pUI = localc.lqc;
    if (this.lqG.pUF == null) {}
    for (int i = 0;; i = this.lqG.pUF.length)
    {
      int j = this.lqG.setConfigInfo(this.lqG.pUz, this.lqG.lpD, this.lqG.lpL, this.lqG.lpE, this.lqG.field_peerId, 1, this.lqG.pUG, this.lqG.pUH, this.lqG.pUE, i, this.lqG.pUF, this.lqG.pUI, 0, 0, this.lqG.pVz, this.lqG.pVA, 255, 0, 0, null);
      y.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j == 0) {
        i = this.lqG.connectToPeer();
      }
      if (i < 0)
      {
        y.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.lqL != null) {
          this.lqL.sD(21);
        }
      }
      this.lqI = true;
      return;
    }
  }
  
  public final void bcB()
  {
    this.lqJ = false;
    this.lqI = false;
    this.lqK = false;
  }
  
  public final void bcz()
  {
    y.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.lqJ) {
      y.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.lqG.setActive();
  }
  
  public final void sI(int paramInt)
  {
    if (!this.lqJ) {}
    do
    {
      return;
      y.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
      paramInt = this.lqG.SetDTMFPayload(paramInt);
    } while (paramInt >= 0);
    y.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c.a
 * JD-Core Version:    0.7.0.1
 */