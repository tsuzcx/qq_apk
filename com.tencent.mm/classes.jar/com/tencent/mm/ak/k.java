package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.f callback;
  LinkedList<cwt> hNb = null;
  LinkedList<bpo> hNc = null;
  
  public k(LinkedList<cwt> paramLinkedList)
  {
    this.hNb = paramLinkedList;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(150294);
    if ((this.hNb == null) || (this.hNb.size() <= 0))
    {
      ad.e("MicroMsg.NetSceneBatchGetHeadImg", com.tencent.mm.compatible.util.f.abi() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new kb();
    paramf.hNN = new kc();
    paramf.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramf.funcId = 123;
    paramf.hNO = 15;
    paramf.respCmdId = 1000000015;
    paramf = paramf.aDC();
    kb localkb = (kb)paramf.hNK.hNQ;
    localkb.FuM = this.hNb;
    localkb.nDi = this.hNb.size();
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
    ad.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.hNc = ((kc)((b)paramq).hNL.hNQ).FCE;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.k
 * JD-Core Version:    0.7.0.1
 */