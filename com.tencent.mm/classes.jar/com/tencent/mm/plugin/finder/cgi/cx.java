package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReportScreenShot;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "actionType", "", "extStats", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(ILjava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActionType", "()I", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getExtStats", "()Ljava/util/LinkedList;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cx
  extends ax
  implements m
{
  private final String TAG;
  private final int actionType;
  private i callback;
  private com.tencent.mm.ak.d rr;
  private final LinkedList<alc> twP;
  
  public cx(LinkedList<alc> paramLinkedList)
  {
    AppMethodBeat.i(242571);
    this.actionType = 0;
    this.twP = paramLinkedList;
    this.TAG = "Finder.NetSceneReportScreenShot";
    paramLinkedList = new d.a();
    paramLinkedList.sG(getType());
    Object localObject = new aqn();
    ((aqn)localObject).finderUsername = z.aUg();
    ((aqn)localObject).actionType = this.actionType;
    ((aqn)localObject).twP = this.twP;
    paramLinkedList.c((a)localObject);
    localObject = new aqo();
    ((aqo)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.MB("/cgi-bin/micromsg-bin/finderextstatsreport");
    paramLinkedList = paramLinkedList.aXF();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    paramLinkedList = new StringBuilder("");
    localObject = ((Iterable)this.twP).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.append(com.tencent.mm.ac.d.zs(((alc)((Iterator)localObject).next()).hFK)).append(",");
    }
    Log.i(this.TAG, "NetSceneReportScreenShot start " + this.actionType + ", " + paramLinkedList);
    AppMethodBeat.o(242571);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242569);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242569);
      return;
    }
    AppMethodBeat.o(242569);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242570);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242570);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cx
 * JD-Core Version:    0.7.0.1
 */