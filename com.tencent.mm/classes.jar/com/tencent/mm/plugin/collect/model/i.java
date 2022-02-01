package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.sdk.platformtools.ac;

public final class i
  extends n
  implements k
{
  private g callback;
  public String dbJ;
  public int dbL;
  public long fe;
  private com.tencent.mm.ak.b gvE;
  public st owX;
  public long owY;
  private long owZ;
  
  public i(int paramInt1, com.tencent.mm.bw.b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ss();
    ((b.a)localObject).hvu = new st();
    ((b.a)localObject).funcId = 1384;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gvE = ((b.a)localObject).aAz();
    localObject = (ss)this.gvE.hvr.hvw;
    ((ss)localObject).uiK = paramInt1;
    ((ss)localObject).EgR = 0;
    ((ss)localObject).oxD = paramString;
    ((ss)localObject).EmP = null;
    ((ss)localObject).EmQ = paramb;
    this.dbJ = paramString;
    this.dbL = paramInt2;
    this.fe = paramLong;
    this.owZ = System.currentTimeMillis();
    ac.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63820);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(63820);
    return i;
  }
  
  public final int getType()
  {
    return 1384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63821);
    ac.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.owX = ((st)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.owX.dae), this.owX.oxf, Integer.valueOf(this.owX.EgR) });
    this.owY = (System.currentTimeMillis() - this.owZ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.i
 * JD-Core Version:    0.7.0.1
 */