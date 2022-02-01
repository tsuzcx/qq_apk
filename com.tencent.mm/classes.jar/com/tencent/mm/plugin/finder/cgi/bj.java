package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReportScreenShot;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "actionType", "", "extStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(ILjava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActionType", "()I", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getExtStats", "()Ljava/util/LinkedList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bj
  extends n
  implements k
{
  private final String TAG;
  private final int actionType;
  private f callback;
  private final LinkedList<aio> rSz;
  private b rr;
  
  public bj(LinkedList<aio> paramLinkedList)
  {
    AppMethodBeat.i(201598);
    this.actionType = 0;
    this.rSz = paramLinkedList;
    this.TAG = "Finder.NetSceneReportScreenShot";
    paramLinkedList = new b.a();
    paramLinkedList.oS(getType());
    Object localObject = new amx();
    ((amx)localObject).sbR = v.aAK();
    ((amx)localObject).actionType = this.actionType;
    ((amx)localObject).rSz = this.rSz;
    paramLinkedList.c((a)localObject);
    localObject = new amy();
    ((amy)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.DN("/cgi-bin/micromsg-bin/finderextstatsreport");
    paramLinkedList = paramLinkedList.aDS();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    paramLinkedList = new StringBuilder("");
    localObject = ((Iterable)this.rSz).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.append(c.rp(((aio)((Iterator)localObject).next()).rRn)).append(",");
    }
    ae.i(this.TAG, "NetSceneReportScreenShot start " + this.actionType + ", " + paramLinkedList);
    AppMethodBeat.o(201598);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201597);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201597);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201596);
    ae.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201596);
      return;
    }
    AppMethodBeat.o(201596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bj
 * JD-Core Version:    0.7.0.1
 */