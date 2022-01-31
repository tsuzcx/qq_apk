package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public u(float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(87876);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new buc();
    ((b.a)localObject).fsY = new bud();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((b.a)localObject).funcId = 1253;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (buc)this.rr.fsV.fta;
    ((buc)localObject).latitude = paramFloat1;
    ((buc)localObject).longitude = paramFloat2;
    ((buc)localObject).cHn = paramString1;
    ((buc)localObject).kml = paramString2;
    ((buc)localObject).xHu = paramInt;
    AppMethodBeat.o(87876);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87877);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87877);
    return i;
  }
  
  public final int getType()
  {
    return 1253;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87878);
    ab.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.u
 * JD-Core Version:    0.7.0.1
 */