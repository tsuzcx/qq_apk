package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  boolean fKO;
  int fKP;
  private b rr;
  
  public a(int paramInt, String paramString)
  {
    AppMethodBeat.i(78417);
    this.fKO = false;
    this.fKP = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bou();
    ((b.a)localObject).fsY = new bov();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((b.a)localObject).funcId = 597;
    this.rr = ((b.a)localObject).ado();
    localObject = (bou)this.rr.fsV.fta;
    ((bou)localObject).xCT = paramInt;
    ((bou)localObject).xCU = 1;
    ((bou)localObject).wxP = paramString;
    this.fKP = paramInt;
    AppMethodBeat.o(78417);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78419);
    ab.d("MicroMsg.NetScenePushNewTips", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78419);
    return i;
  }
  
  public final int getType()
  {
    return 597;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78418);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetScenePushNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78418);
      return;
    }
    this.fKO = ((bov)((b)paramq).fsW.fta).xCV;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ax.a
 * JD-Core Version:    0.7.0.1
 */