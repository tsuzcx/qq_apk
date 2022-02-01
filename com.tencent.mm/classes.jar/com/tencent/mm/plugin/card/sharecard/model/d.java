package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private g callback;
  public String ntw;
  public int ntx;
  public String nty;
  private final b rr;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(112963);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bai();
    ((b.a)localObject).gUV = new baj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((b.a)localObject).funcId = 910;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bai)this.rr.gUS.gUX;
    ((bai)localObject).dyc = paramString1;
    ((bai)localObject).scene = 20;
    ((bai)localObject).nrr = paramString2;
    ((bai)localObject).code = paramString3;
    AppMethodBeat.o(112963);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112965);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112965);
    return i;
  }
  
  public final int getType()
  {
    return 910;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112964);
    ad.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (baj)this.rr.gUT.gUX;
      ad.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + paramq.ntw);
      this.ntw = paramq.ntw;
      this.nty = paramq.nty;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */