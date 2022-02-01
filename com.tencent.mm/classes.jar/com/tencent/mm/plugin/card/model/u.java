package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.sdk.platformtools.ae;

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
    ((b.a)localObject).hQF = new cuv();
    ((b.a)localObject).hQG = new cuw();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((b.a)localObject).funcId = 1253;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cuv)this.rr.hQD.hQJ;
    ((cuv)localObject).latitude = paramFloat1;
    ((cuv)localObject).longitude = paramFloat2;
    ((cuv)localObject).dJb = paramString1;
    ((cuv)localObject).oEo = paramString2;
    ((cuv)localObject).HFy = paramInt;
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
    ae.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.u
 * JD-Core Version:    0.7.0.1
 */