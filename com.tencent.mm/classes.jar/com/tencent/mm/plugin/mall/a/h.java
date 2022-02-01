package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private f callback;
  private b gRX;
  private bgm vPr;
  public bgn vPs;
  
  public h()
  {
    AppMethodBeat.i(65997);
    b.a locala = new b.a();
    locala.hQF = new bgm();
    locala.hQG = new bgn();
    locala.funcId = 1754;
    locala.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.vPr = ((bgm)this.gRX.hQD.hQJ);
    AppMethodBeat.o(65997);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65998);
    ae.d("MicroMsg.NetSceneGetPayMenu", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.vPs = ((bgn)this.gRX.hQE.hQJ);
      paramq = this.vPs.title;
      paramArrayOfByte = this.vPs.GUZ;
      if (this.vPs.GUZ == null) {
        break label142;
      }
    }
    label142:
    for (paramInt1 = this.vPs.GUZ.size();; paramInt1 = 0)
    {
      ae.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", new Object[] { paramq, paramArrayOfByte, Integer.valueOf(paramInt1) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(65999);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.h
 * JD-Core Version:    0.7.0.1
 */