package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.sdk.platformtools.ac;

public final class u
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public u(float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(112818);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cow();
    ((b.a)localObject).hvu = new cox();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((b.a)localObject).funcId = 1253;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cow)this.rr.hvr.hvw;
    ((cow)localObject).latitude = paramFloat1;
    ((cow)localObject).longitude = paramFloat2;
    ((cow)localObject).dvO = paramString1;
    ((cow)localObject).nUr = paramString2;
    ((cow)localObject).FBJ = paramInt;
    AppMethodBeat.o(112818);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112819);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.u
 * JD-Core Version:    0.7.0.1
 */