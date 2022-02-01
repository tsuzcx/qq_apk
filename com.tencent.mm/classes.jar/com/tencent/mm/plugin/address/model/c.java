package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b rr;
  
  public c(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20771);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cgj();
    ((b.a)localObject).gUV = new cgk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((b.a)localObject).funcId = 415;
    ((b.a)localObject).reqCmdId = 200;
    ((b.a)localObject).respCmdId = 1000000200;
    this.rr = ((b.a)localObject).atI();
    localObject = (cgj)this.rr.gUS.gUX;
    ((cgj)localObject).Ecd = new cgo();
    ((cgj)localObject).Ecd.Eck = new cmf().aEE(bt.by(paramb.iyP, ""));
    ((cgj)localObject).Ecd.Eci = new cmf().aEE(bt.by(paramb.iyN, ""));
    ((cgj)localObject).Ecd.Ecn = new cmf().aEE(bt.by(paramb.iyS, ""));
    ((cgj)localObject).Ecd.Ecl = new cmf().aEE(bt.by(paramb.iyQ, ""));
    ((cgj)localObject).Ecd.Eco = new cmf().aEE(bt.by(paramb.iyT, ""));
    ((cgj)localObject).Ecd.Ecp = new cmf().aEE(bt.by(paramb.iyU, ""));
    ((cgj)localObject).Ecd.Ecj = new cmf().aEE(bt.by(paramb.iyO, ""));
    ((cgj)localObject).Ecd.Ecm = new cmf().aEE(bt.by(paramb.iyR, ""));
    ((cgj)localObject).Ecd.Ecq = new cmf().aEE(bt.by(paramb.iyV, ""));
    AppMethodBeat.o(20771);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20773);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20773);
    return i;
  }
  
  public final int getType()
  {
    return 415;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20772);
    ad.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cgk)((com.tencent.mm.al.b)paramq).gUT.gUX;
      if (paramq.Ece.Ech != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Ece.Ech.size());
        a.aKO();
        a.aKQ().t(paramq.Ece.Ech);
        a.aKO();
        a.aKQ().aKS();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */