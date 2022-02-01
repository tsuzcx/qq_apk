package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.sdk.platformtools.ad;

public final class u
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public u(float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112818);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cub();
    ((b.a)localObject).hNN = new cuc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((b.a)localObject).funcId = 1253;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cub)this.rr.hNK.hNQ;
    ((cub)localObject).latitude = paramFloat1;
    ((cub)localObject).longitude = paramFloat2;
    ((cub)localObject).dHX = paramString1;
    ((cub)localObject).oxM = paramString2;
    ((cub)localObject).HlY = paramInt;
    AppMethodBeat.o(112818);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112819);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112819);
    return i;
  }
  
  public final int getType()
  {
    return 1253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112820);
    ad.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.u
 * JD-Core Version:    0.7.0.1
 */