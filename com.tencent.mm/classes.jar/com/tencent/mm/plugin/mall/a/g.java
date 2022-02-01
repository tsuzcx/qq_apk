package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private b iaa;
  private aya tsp;
  public ayb tsq;
  
  public g()
  {
    AppMethodBeat.i(65997);
    b.a locala = new b.a();
    locala.gUU = new aya();
    locala.gUV = new ayb();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.tsp = ((aya)this.iaa.gUS.gUX);
    AppMethodBeat.o(65997);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(65998);
    ad.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.tsq = ((ayb)this.iaa.gUT.gUX);
      paramq = this.tsq.title;
      paramArrayOfByte = this.tsq.DwM;
      if (this.tsq.DwM == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.tsq.DwM.size();; paramInt1 = 0)
    {
      ad.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { paramq, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65999);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */