package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  public String ozQ;
  public int ozR;
  public String ozS;
  private final b rr;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(112963);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bii();
    ((b.a)localObject).hNN = new bij();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((b.a)localObject).funcId = 910;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bii)this.rr.hNK.hNQ;
    ((bii)localObject).dHX = paramString1;
    ((bii)localObject).scene = 20;
    ((bii)localObject).oxM = paramString2;
    ((bii)localObject).code = paramString3;
    AppMethodBeat.o(112963);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112965);
    this.callback = paramf;
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
      paramq = (bij)this.rr.hNL.hNQ;
      ad.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + paramq.ozQ);
      this.ozQ = paramq.ozQ;
      this.ozS = paramq.ozS;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */