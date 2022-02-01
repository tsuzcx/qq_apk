package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private f callback;
  public String dnf;
  public int dnh;
  private com.tencent.mm.al.b gPp;
  public long gW;
  public uo pas;
  public long pat;
  private long pau;
  
  public i(int paramInt1, com.tencent.mm.bx.b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new un();
    ((b.a)localObject).hNN = new uo();
    ((b.a)localObject).funcId = 1384;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gPp = ((b.a)localObject).aDC();
    localObject = (un)this.gPp.hNK.hNQ;
    ((un)localObject).vls = paramInt1;
    ((un)localObject).FNY = 0;
    ((un)localObject).paY = paramString;
    ((un)localObject).FTY = null;
    ((un)localObject).FTZ = paramb;
    this.dnf = paramString;
    this.dnh = paramInt2;
    this.gW = paramLong;
    this.pau = System.currentTimeMillis();
    ad.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63820);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.pas = ((uo)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.pas.dlw), this.pas.paA, Integer.valueOf(this.pas.FNY) });
    this.pat = (System.currentTimeMillis() - this.pau);
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