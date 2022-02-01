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
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b rr;
  
  public h(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20786);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cgv();
    ((b.a)localObject).gUV = new cgw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((b.a)localObject).funcId = 418;
    ((b.a)localObject).reqCmdId = 203;
    ((b.a)localObject).respCmdId = 1000000203;
    this.rr = ((b.a)localObject).atI();
    localObject = (cgv)this.rr.gUS.gUX;
    ((cgv)localObject).Ecd = new cgo();
    ((cgv)localObject).Ecd.id = paramb.id;
    ((cgv)localObject).Ecd.Eck = new cmf().aEE(bt.by(paramb.iyP, ""));
    ((cgv)localObject).Ecd.Eci = new cmf().aEE(bt.by(paramb.iyN, ""));
    ((cgv)localObject).Ecd.Ecn = new cmf().aEE(bt.by(paramb.iyS, ""));
    ((cgv)localObject).Ecd.Ecl = new cmf().aEE(bt.by(paramb.iyQ, ""));
    ((cgv)localObject).Ecd.Eco = new cmf().aEE(bt.by(paramb.iyT, ""));
    ((cgv)localObject).Ecd.Ecp = new cmf().aEE(bt.by(paramb.iyU, ""));
    ((cgv)localObject).Ecd.Ecj = new cmf().aEE(bt.by(paramb.iyO, ""));
    ((cgv)localObject).Ecd.Ecm = new cmf().aEE(bt.by(paramb.iyR, ""));
    ((cgv)localObject).Ecd.Ecq = new cmf().aEE(bt.by(paramb.iyV, ""));
    AppMethodBeat.o(20786);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20788);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20788);
    return i;
  }
  
  public final int getType()
  {
    return 418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20787);
    ad.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cgw)((com.tencent.mm.al.b)paramq).gUT.gUX;
      if (paramq.Ece.Ech != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Ece.Ech.size());
        a.aKO();
        a.aKQ().t(paramq.Ece.Ech);
        a.aKO();
        a.aKQ().aKS();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */