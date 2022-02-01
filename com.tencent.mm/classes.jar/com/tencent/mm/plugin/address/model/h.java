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
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  public h(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20786);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new crs();
    ((b.a)localObject).hQG = new crt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((b.a)localObject).funcId = 418;
    ((b.a)localObject).hQH = 203;
    ((b.a)localObject).respCmdId = 1000000203;
    this.rr = ((b.a)localObject).aDS();
    localObject = (crs)this.rr.hQD.hQJ;
    ((crs)localObject).HCD = new crl();
    ((crs)localObject).HCD.id = paramb.id;
    ((crs)localObject).HCD.HCK = new cxn().aQV(bu.bI(paramb.juU, ""));
    ((crs)localObject).HCD.HCI = new cxn().aQV(bu.bI(paramb.juS, ""));
    ((crs)localObject).HCD.HCN = new cxn().aQV(bu.bI(paramb.juX, ""));
    ((crs)localObject).HCD.HCL = new cxn().aQV(bu.bI(paramb.juV, ""));
    ((crs)localObject).HCD.HCO = new cxn().aQV(bu.bI(paramb.juY, ""));
    ((crs)localObject).HCD.HCP = new cxn().aQV(bu.bI(paramb.juZ, ""));
    ((crs)localObject).HCD.HCJ = new cxn().aQV(bu.bI(paramb.juT, ""));
    ((crs)localObject).HCD.HCM = new cxn().aQV(bu.bI(paramb.juW, ""));
    ((crs)localObject).HCD.HCQ = new cxn().aQV(bu.bI(paramb.jva, ""));
    AppMethodBeat.o(20786);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20788);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (crt)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      if (paramq.HCE.HCH != null)
      {
        ae.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.HCE.HCH.size());
        a.aVq();
        a.aVs().t(paramq.HCE.HCH);
        a.aVq();
        a.aVs().aVu();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */