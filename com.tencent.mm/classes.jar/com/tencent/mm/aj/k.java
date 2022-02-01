package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  LinkedList<cxn> hPU = null;
  LinkedList<bqh> hPV = null;
  
  public k(LinkedList<cxn> paramLinkedList)
  {
    this.hPU = paramLinkedList;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(150294);
    if ((this.hPU == null) || (this.hPU.size() <= 0))
    {
      ae.e("MicroMsg.NetSceneBatchGetHeadImg", com.tencent.mm.compatible.util.f.abr() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new kb();
    paramf.hQG = new kc();
    paramf.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramf.funcId = 123;
    paramf.hQH = 15;
    paramf.respCmdId = 1000000015;
    paramf = paramf.aDS();
    kb localkb = (kb)paramf.hQD.hQJ;
    localkb.FNk = this.hPU;
    localkb.nID = this.hPU.size();
    int i = dispatch(parame, paramf, this);
    AppMethodBeat.o(150294);
    return i;
  }
  
  public final int getType()
  {
    return 123;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150295);
    ae.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.hPV = ((kc)((b)paramq).hQE.hQJ).FUZ;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.k
 * JD-Core Version:    0.7.0.1
 */