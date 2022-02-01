package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.byu;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMarkRead;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sendMarkReadList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(Ljava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSendMarkReadList", "()Ljava/util/LinkedList;", "setSendMarkReadList", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bh
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public LinkedList<byu> rSv;
  private b rr;
  
  public bh(LinkedList<byu> paramLinkedList)
  {
    AppMethodBeat.i(178091);
    this.rSv = paramLinkedList;
    this.TAG = "Finder.NetSceneMarkRead";
    paramLinkedList = new b.a();
    paramLinkedList.oS(getType());
    Object localObject = new apm();
    ((apm)localObject).GGB = this.rSv;
    v localv = v.rRb;
    ((apm)localObject).GEg = v.czz();
    paramLinkedList.c((a)localObject);
    localObject = new apn();
    ((apn)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.DN("/cgi-bin/micromsg-bin/findermarkread");
    paramLinkedList = paramLinkedList.aDS();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(178091);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(178090);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(178090);
    return i;
  }
  
  public final int getType()
  {
    return 3520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(178089);
    ae.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ' + this.rSv.size());
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(178089);
      return;
    }
    AppMethodBeat.o(178089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bh
 * JD-Core Version:    0.7.0.1
 */