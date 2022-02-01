package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b gvE;
  private bbs uAI;
  public bbt uAJ;
  
  public g()
  {
    AppMethodBeat.i(65997);
    b.a locala = new b.a();
    locala.hvt = new bbs();
    locala.hvu = new bbt();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.uAI = ((bbs)this.gvE.hvr.hvw);
    AppMethodBeat.o(65997);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(65998);
    ac.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(65998);
    return i;
  }
  
  public final int getType()
  {
    return 1754;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65999);
    ac.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.uAJ = ((bbt)this.gvE.hvs.hvw);
      paramq = this.uAJ.title;
      paramArrayOfByte = this.uAJ.ESh;
      if (this.uAJ.ESh == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.uAJ.ESh.size();; paramInt1 = 0)
    {
      ac.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { paramq, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65999);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */