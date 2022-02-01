package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSessionStatus;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMsgGetSessionReqItem;", "(Ljava/util/LinkedList;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderMsgSessionInfo;", "sessionId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cg
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public cg(LinkedList<azi> paramLinkedList)
  {
    AppMethodBeat.i(242508);
    this.TAG = "Finder.NetSceneFinderSessionStatus";
    d.a locala = new d.a();
    locala.sG(getType());
    atj localatj = new atj();
    am localam = am.tuw;
    localatj.LAI = am.cXY();
    localatj.pUc = paramLinkedList;
    locala.c((a)localatj);
    locala.d((a)new atk());
    locala.MB("/cgi-bin/micromsg-bin/findergetmsgsession");
    paramLinkedList = locala.aXF();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    Log.i(this.TAG, "NetSceneFinderSessionStatus");
    AppMethodBeat.o(242508);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242506);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      h.CyF.a(20492, new Object[] { Long.valueOf(7L), paramInt2 + ',' + paramInt3 });
      h.CyF.n(1473L, 7L, 1L);
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242506);
  }
  
  public final LinkedList<azj> cZe()
  {
    AppMethodBeat.i(242507);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMsgSessionProfileResponse");
      AppMethodBeat.o(242507);
      throw ((Throwable)localObject);
    }
    localObject = ((atk)localObject).LEl;
    AppMethodBeat.o(242507);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242505);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242505);
    return i;
  }
  
  public final int getType()
  {
    return 6218;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cg
 * JD-Core Version:    0.7.0.1
 */