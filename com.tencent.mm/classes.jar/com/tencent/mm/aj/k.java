package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  LinkedList<crm> huJ = null;
  LinkedList<ble> huK = null;
  
  public k(LinkedList<crm> paramLinkedList)
  {
    this.huJ = paramLinkedList;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150294);
    if ((this.huJ == null) || (this.huJ.size() <= 0))
    {
      ac.e("MicroMsg.NetSceneBatchGetHeadImg", f.YG() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new js();
    paramg.hvu = new jt();
    paramg.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramg.funcId = 123;
    paramg.reqCmdId = 15;
    paramg.respCmdId = 1000000015;
    paramg = paramg.aAz();
    js localjs = (js)paramg.hvr.hvw;
    localjs.DPy = this.huJ;
    localjs.ncL = this.huJ.size();
    int i = dispatch(parame, paramg, this);
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
    ac.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.huK = ((jt)((b)paramq).hvs.hvw).DXi;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.k
 * JD-Core Version:    0.7.0.1
 */