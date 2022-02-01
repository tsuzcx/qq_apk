package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSessionStatus;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "(Ljava/util/LinkedList;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderMsgSessionInfo;", "sessionId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dl
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public dl(LinkedList<bqh> paramLinkedList)
  {
    AppMethodBeat.i(336883);
    this.TAG = "Finder.NetSceneFinderSessionStatus";
    c.a locala = new c.a();
    locala.funcId = getType();
    bam localbam = new bam();
    bi localbi = bi.ABn;
    localbam.ZEc = bi.dVu();
    localbam.wuC = paramLinkedList;
    locala.otE = ((a)localbam);
    locala.otF = ((a)new ban());
    locala.uri = "/cgi-bin/micromsg-bin/findergetmsgsession";
    paramLinkedList = locala.bEF();
    kotlin.g.b.s.s(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    Log.i(this.TAG, "NetSceneFinderSessionStatus");
    AppMethodBeat.o(336883);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336908);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(20492, new Object[] { Long.valueOf(7L), paramInt2 + ',' + paramInt3 });
      com.tencent.mm.plugin.report.service.h.OAn.p(1473L, 7L, 1L);
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336908);
  }
  
  public final LinkedList<bqi> dWv()
  {
    AppMethodBeat.i(336916);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMsgSessionResponse");
      AppMethodBeat.o(336916);
      throw ((Throwable)localObject);
    }
    localObject = ((ban)localObject).ZLu;
    AppMethodBeat.o(336916);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336889);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336889);
    return i;
  }
  
  public final int getType()
  {
    return 6218;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dl
 * JD-Core Version:    0.7.0.1
 */