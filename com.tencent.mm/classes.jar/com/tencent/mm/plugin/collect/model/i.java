package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public String dFw;
  public long gY;
  private d hJu;
  public vx qwf;
  public long qwg;
  private long qwh;
  public int source;
  
  public i(int paramInt1, b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new vw();
    ((d.a)localObject).iLO = new vx();
    ((d.a)localObject).funcId = 1384;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hJu = ((d.a)localObject).aXF();
    localObject = (vw)this.hJu.iLK.iLR;
    ((vw)localObject).yRL = paramInt1;
    ((vw)localObject).Lba = 0;
    ((vw)localObject).qwM = paramString;
    ((vw)localObject).Lhb = null;
    ((vw)localObject).Lhc = paramb;
    this.dFw = paramString;
    this.source = paramInt2;
    this.gY = paramLong;
    this.qwh = System.currentTimeMillis();
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(63820);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(63820);
    return i;
  }
  
  public final int getType()
  {
    return 1384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63821);
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.qwf = ((vx)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.qwf.dDN), this.qwf.qwn, Integer.valueOf(this.qwf.Lba) });
    this.qwg = (System.currentTimeMillis() - this.qwh);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.i
 * JD-Core Version:    0.7.0.1
 */