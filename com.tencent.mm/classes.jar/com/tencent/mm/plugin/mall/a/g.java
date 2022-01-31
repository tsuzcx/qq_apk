package com.tencent.mm.plugin.mall.a;

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
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private f callback;
  private b goo;
  private anv oxP;
  public anw oxQ;
  
  public g()
  {
    AppMethodBeat.i(43102);
    b.a locala = new b.a();
    locala.fsX = new anv();
    locala.fsY = new anw();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.oxP = ((anv)this.goo.fsV.fta);
    AppMethodBeat.o(43102);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(43103);
    ab.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(43103);
    return i;
  }
  
  public final int getType()
  {
    return 1754;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43104);
    ab.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.oxQ = ((anw)this.goo.fsW.fta);
      paramq = this.oxQ.title;
      paramArrayOfByte = this.oxQ.xea;
      if (this.oxQ.xea == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.oxQ.xea.size();; paramInt1 = 0)
    {
      ab.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { paramq, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43104);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */