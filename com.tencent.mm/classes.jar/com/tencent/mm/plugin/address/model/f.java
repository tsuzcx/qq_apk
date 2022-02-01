package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private g callback;
  public int iyx;
  private b rr;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(20780);
    this.iyx = 0;
    b.a locala = new b.a();
    locala.gUU = new cgr();
    locala.gUV = new cgs();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
    locala.funcId = 416;
    locala.reqCmdId = 201;
    locala.respCmdId = 1000000201;
    this.rr = locala.atI();
    this.iyx = paramInt;
    ad.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(paramInt)));
    ((cgr)this.rr.gUS.gUX).id = paramInt;
    AppMethodBeat.o(20780);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20782);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20782);
    return i;
  }
  
  public final int getType()
  {
    return 416;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20781);
    ad.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cgs)((b)paramq).gUT.gUX;
      if (paramq.Ece.Ech != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Ece.Ech.size());
        a.aKO();
        a.aKQ().t(paramq.Ece.Ech);
        a.aKO();
        a.aKQ().aKS();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.f
 * JD-Core Version:    0.7.0.1
 */