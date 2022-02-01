package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.jm;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  LinkedList<cmf> gUk = null;
  LinkedList<bhm> gUl = null;
  
  public k(LinkedList<cmf> paramLinkedList)
  {
    this.gUk = paramLinkedList;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(150294);
    if ((this.gUk == null) || (this.gUk.size() <= 0))
    {
      ad.e("MicroMsg.NetSceneBatchGetHeadImg", f.XJ() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new jm();
    paramg.gUV = new jn();
    paramg.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramg.funcId = 123;
    paramg.reqCmdId = 15;
    paramg.respCmdId = 1000000015;
    paramg = paramg.atI();
    jm localjm = (jm)paramg.gUS.gUX;
    localjm.Cxc = this.gUk;
    localjm.mAK = this.gUk.size();
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
    ad.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.gUl = ((jn)((b)paramq).gUT.gUX).CEI;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.k
 * JD-Core Version:    0.7.0.1
 */