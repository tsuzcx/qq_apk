package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private i callback;
  LinkedList<dqi> iLb = null;
  LinkedList<ccz> iLc = null;
  
  public k(LinkedList<dqi> paramLinkedList)
  {
    this.iLb = paramLinkedList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150294);
    if ((this.iLb == null) || (this.iLb.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneBatchGetHeadImg", f.apq() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new kq();
    parami.iLO = new kr();
    parami.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    parami.funcId = 123;
    parami.iLP = 15;
    parami.respCmdId = 1000000015;
    parami = parami.aXF();
    kq localkq = (kq)parami.iLK.iLR;
    localkq.KGP = this.iLb;
    localkq.oTz = this.iLb.size();
    int i = dispatch(paramg, parami, this);
    AppMethodBeat.o(150294);
    return i;
  }
  
  public final int getType()
  {
    return 123;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150295);
    Log.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.iLc = ((kr)((d)params).iLL.iLR).KOI;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.k
 * JD-Core Version:    0.7.0.1
 */