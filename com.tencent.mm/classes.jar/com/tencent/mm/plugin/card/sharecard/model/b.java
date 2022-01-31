package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class b
  extends m
  implements k
{
  private f callback;
  public String koi;
  public String kpP;
  private final com.tencent.mm.ai.b rr;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(88018);
    this.kpP = "";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aii();
    ((b.a)localObject).fsY = new aij();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((b.a)localObject).funcId = 1164;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aii)this.rr.fsV.fta;
    ((aii)localObject).latitude = paramDouble1;
    ((aii)localObject).longitude = paramDouble2;
    ((aii)localObject).kpP = paramString;
    ((aii)localObject).xab = ((String)g.RL().Ru().get(ac.a.yyV, ""));
    ab.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((aii)localObject).xab);
    AppMethodBeat.o(88018);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(88020);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88020);
    return i;
  }
  
  public final int getType()
  {
    return 1164;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88019);
    ab.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aij)this.rr.fsW.fta;
      ab.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + paramq.koi);
      this.koi = paramq.koi;
      this.kpP = paramq.kpP;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */