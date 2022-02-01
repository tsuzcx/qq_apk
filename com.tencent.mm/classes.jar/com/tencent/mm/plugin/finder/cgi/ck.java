package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSessionStatus;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "(Ljava/util/LinkedList;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderMsgSessionInfo;", "sessionId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ck
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public ck(LinkedList<bfe> paramLinkedList)
  {
    AppMethodBeat.i(291957);
    this.TAG = "Finder.NetSceneFinderSessionStatus";
    d.a locala = new d.a();
    locala.vD(getType());
    avm localavm = new avm();
    ao localao = ao.xcj;
    localavm.SDi = ao.dnO();
    localavm.tqd = paramLinkedList;
    locala.c((a)localavm);
    locala.d((a)new avn());
    locala.TW("/cgi-bin/micromsg-bin/findergetmsgsession");
    paramLinkedList = locala.bgN();
    p.j(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    Log.i(this.TAG, "NetSceneFinderSessionStatus");
    AppMethodBeat.o(291957);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(291955);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.IzE.a(20492, new Object[] { Long.valueOf(7L), paramInt2 + ',' + paramInt3 });
      h.IzE.p(1473L, 7L, 1L);
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(291955);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(291954);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(291954);
    return i;
  }
  
  public final LinkedList<bff> doV()
  {
    AppMethodBeat.i(291956);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMsgSessionResponse");
      AppMethodBeat.o(291956);
      throw ((Throwable)localObject);
    }
    localObject = ((avn)localObject).SHT;
    AppMethodBeat.o(291956);
    return localObject;
  }
  
  public final int getType()
  {
    return 6218;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ck
 * JD-Core Version:    0.7.0.1
 */