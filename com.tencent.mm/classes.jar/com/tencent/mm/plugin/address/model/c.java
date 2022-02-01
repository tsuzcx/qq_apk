package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  public c(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20771);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new crg();
    ((b.a)localObject).hQG = new crh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((b.a)localObject).funcId = 415;
    ((b.a)localObject).hQH = 200;
    ((b.a)localObject).respCmdId = 1000000200;
    this.rr = ((b.a)localObject).aDS();
    localObject = (crg)this.rr.hQD.hQJ;
    ((crg)localObject).HCD = new crl();
    ((crg)localObject).HCD.HCK = new cxn().aQV(bu.bI(paramb.juU, ""));
    ((crg)localObject).HCD.HCI = new cxn().aQV(bu.bI(paramb.juS, ""));
    ((crg)localObject).HCD.HCN = new cxn().aQV(bu.bI(paramb.juX, ""));
    ((crg)localObject).HCD.HCL = new cxn().aQV(bu.bI(paramb.juV, ""));
    ((crg)localObject).HCD.HCO = new cxn().aQV(bu.bI(paramb.juY, ""));
    ((crg)localObject).HCD.HCP = new cxn().aQV(bu.bI(paramb.juZ, ""));
    ((crg)localObject).HCD.HCJ = new cxn().aQV(bu.bI(paramb.juT, ""));
    ((crg)localObject).HCD.HCM = new cxn().aQV(bu.bI(paramb.juW, ""));
    ((crg)localObject).HCD.HCQ = new cxn().aQV(bu.bI(paramb.jva, ""));
    AppMethodBeat.o(20771);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20773);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (crh)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      if (paramq.HCE.HCH != null)
      {
        ae.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.HCE.HCH.size());
        a.aVq();
        a.aVs().t(paramq.HCE.HCH);
        a.aVq();
        a.aVs().aVu();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */