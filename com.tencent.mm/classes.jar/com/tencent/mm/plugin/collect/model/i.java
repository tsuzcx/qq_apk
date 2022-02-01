package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.ae;

public final class i
  extends n
  implements k
{
  private f callback;
  public String doh;
  public int doj;
  private com.tencent.mm.ak.b gRX;
  public long gW;
  public uq pgW;
  public long pgX;
  private long pgY;
  
  public i(int paramInt1, com.tencent.mm.bw.b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new up();
    ((b.a)localObject).hQG = new uq();
    ((b.a)localObject).funcId = 1384;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gRX = ((b.a)localObject).aDS();
    localObject = (up)this.gRX.hQD.hQJ;
    ((up)localObject).vxx = paramInt1;
    ((up)localObject).Ggx = 0;
    ((up)localObject).phC = paramString;
    ((up)localObject).Gmx = null;
    ((up)localObject).Gmy = paramb;
    this.doh = paramString;
    this.doj = paramInt2;
    this.gW = paramLong;
    this.pgY = System.currentTimeMillis();
    ae.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63820);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.pgW = ((uq)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.pgW.dmy), this.pgW.phe, Integer.valueOf(this.pgW.Ggx) });
    this.pgX = (System.currentTimeMillis() - this.pgY);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.i
 * JD-Core Version:    0.7.0.1
 */