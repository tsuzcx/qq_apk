package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.in;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private f callback;
  LinkedList<bwc> fsp = null;
  LinkedList<awg> fsq = null;
  
  public j(LinkedList<bwc> paramLinkedList)
  {
    this.fsp = paramLinkedList;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(77930);
    if ((this.fsp == null) || (this.fsp.size() <= 0))
    {
      ab.e("MicroMsg.NetSceneBatchGetHeadImg", g.Ml() + "doScene ReqSize==0");
      AppMethodBeat.o(77930);
      return -1;
    }
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new in();
    paramf.fsY = new io();
    paramf.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramf.funcId = 123;
    paramf.reqCmdId = 15;
    paramf.respCmdId = 1000000015;
    paramf = paramf.ado();
    in localin = (in)paramf.fsV.fta;
    localin.wou = this.fsp;
    localin.jJu = this.fsp.size();
    int i = dispatch(parame, paramf, this);
    AppMethodBeat.o(77930);
    return i;
  }
  
  public final int getType()
  {
    return 123;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77931);
    ab.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.fsq = ((io)((b)paramq).fsW.fta).wuQ;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(77931);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ah.j
 * JD-Core Version:    0.7.0.1
 */