package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends q
  implements m
{
  private i callback;
  LinkedList<eaf> lBi = null;
  LinkedList<clt> lBj = null;
  
  public l(LinkedList<eaf> paramLinkedList)
  {
    this.lBi = paramLinkedList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150294);
    if ((this.lBi == null) || (this.lBi.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneBatchGetHeadImg", f.avD() + "doScene ReqSize==0");
      AppMethodBeat.o(150294);
      return -1;
    }
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new kg();
    parami.lBV = new kh();
    parami.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    parami.funcId = 123;
    parami.lBW = 15;
    parami.respCmdId = 1000000015;
    parami = parami.bgN();
    kg localkg = (kg)d.b.b(parami.lBR);
    localkg.RIj = this.lBi;
    localkg.rVx = this.lBi.size();
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
    this.lBj = ((kh)d.c.b(((d)params).lBS)).RPG;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150295);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.l
 * JD-Core Version:    0.7.0.1
 */