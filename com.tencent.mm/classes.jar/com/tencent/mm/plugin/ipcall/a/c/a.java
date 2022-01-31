package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  public v2protocal nOc;
  private ak nOd;
  private boolean nOe;
  public boolean nOf;
  public boolean nOg;
  public a.a nOh;
  
  public a()
  {
    AppMethodBeat.i(21823);
    this.nOe = false;
    this.nOf = false;
    this.nOg = false;
    this.nOh = null;
    this.nOd = new a.1(this, Looper.getMainLooper());
    this.nOc = new v2protocal(this.nOd);
    AppMethodBeat.o(21823);
  }
  
  public final void aEa()
  {
    this.nOf = false;
    this.nOe = false;
    this.nOg = false;
  }
  
  public final void bJH()
  {
    AppMethodBeat.i(21824);
    ab.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
    if (!this.nOf) {
      ab.d("MicroMsg.IPCallEngineManager", "channel not connect now");
    }
    this.nOc.setActive();
    AppMethodBeat.o(21824);
  }
  
  public final void bJI()
  {
    AppMethodBeat.i(21825);
    if (this.nOe)
    {
      ab.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
      AppMethodBeat.o(21825);
      return;
    }
    ab.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
    com.tencent.mm.plugin.ipcall.a.a.c localc = i.bJn().nMs;
    if (localc != null)
    {
      if (localc.jCd != null)
      {
        crn localcrn1 = com.tencent.mm.plugin.ipcall.b.c.aj(localc.jCd);
        crn localcrn2 = com.tencent.mm.plugin.ipcall.b.c.aj(localc.nNx);
        csx localcsx = new csx();
        localcsx.ybW = 0;
        localcsx.ybX = 0;
        localcsx.ybY = 0;
        localcsx.userName = "";
        localcsx.gFE = "";
        this.nOc.a(localcrn1, localcrn1, localcrn2, localcsx, null);
      }
      ab.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
      this.nOc.tAf = localc.nNs;
      this.nOc.tBe = localc.nNv;
      if (localc.nNw != null) {
        this.nOc.tBf = localc.nNw.toByteArray();
      }
      if (localc.nNt != null) {
        this.nOc.tAg = localc.nNt.toByteArray();
      }
      this.nOc.nMZ = localc.nMZ;
      this.nOc.nNa = localc.nNa;
      this.nOc.nNh = localc.nNh;
      this.nOc.tAi = localc.nNq;
      this.nOc.tAh = localc.nNr;
      this.nOc.tAj = localc.nNy;
      if (this.nOc.tAg != null) {
        break label465;
      }
    }
    label465:
    for (int i = 0;; i = this.nOc.tAg.length)
    {
      int j = this.nOc.setConfigInfo(this.nOc.tAa, this.nOc.nMZ, this.nOc.nNh, this.nOc.nNa, this.nOc.field_peerId, 1, this.nOc.tAh, this.nOc.tAi, this.nOc.tAf, i, this.nOc.tAg, this.nOc.tAj, 0, 0, this.nOc.tBe, this.nOc.tBf, 255, 0, 0, null, 0);
      ab.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", new Object[] { Integer.valueOf(j) });
      i = j;
      if (j == 0) {
        i = this.nOc.connectToPeer();
      }
      if (i < 0)
      {
        ab.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", new Object[] { Integer.valueOf(i) });
        if (this.nOh != null) {
          this.nOh.xD(21);
        }
      }
      this.nOe = true;
      AppMethodBeat.o(21825);
      return;
    }
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(21827);
    if (paramBoolean) {}
    for (int i = this.nOc.setAppCmd(401);; i = this.nOc.setAppCmd(402))
    {
      if (i < 0) {
        ab.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(21827);
      return;
    }
  }
  
  public final void xJ(int paramInt)
  {
    AppMethodBeat.i(21826);
    if (!this.nOf)
    {
      AppMethodBeat.o(21826);
      return;
    }
    ab.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[] { Integer.valueOf(paramInt) });
    paramInt = this.nOc.SetDTMFPayload(paramInt);
    if (paramInt < 0) {
      ab.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(21826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.c.a
 * JD-Core Version:    0.7.0.1
 */