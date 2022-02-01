package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMarkRead;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sendMarkReadList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(Ljava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSendMarkReadList", "()Ljava/util/LinkedList;", "setSendMarkReadList", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bg
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public LinkedList<bya> rKj;
  private b rr;
  
  public bg(LinkedList<bya> paramLinkedList)
  {
    AppMethodBeat.i(178091);
    this.rKj = paramLinkedList;
    this.TAG = "Finder.NetSceneMarkRead";
    paramLinkedList = new b.a();
    paramLinkedList.oP(getType());
    Object localObject = new aoz();
    ((aoz)localObject).Gnv = this.rKj;
    v localv = v.rIR;
    ((aoz)localObject).Gle = v.cxY();
    paramLinkedList.c((a)localObject);
    localObject = new apa();
    ((apa)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.Dl("/cgi-bin/micromsg-bin/findermarkread");
    paramLinkedList = paramLinkedList.aDC();
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
    ad.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ' + this.rKj.size());
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
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bg
 * JD-Core Version:    0.7.0.1
 */