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
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMarkRead;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sendMarkReadList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(Ljava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSendMarkReadList", "()Ljava/util/LinkedList;", "setSendMarkReadList", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cq
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d rr;
  public LinkedList<cmm> twF;
  
  public cq(LinkedList<cmm> paramLinkedList)
  {
    AppMethodBeat.i(178091);
    this.twF = paramLinkedList;
    this.TAG = "Finder.NetSceneMarkRead";
    paramLinkedList = new d.a();
    paramLinkedList.sG(getType());
    Object localObject = new aye();
    ((aye)localObject).LIs = this.twF;
    am localam = am.tuw;
    ((aye)localObject).LAI = am.cXY();
    paramLinkedList.c((a)localObject);
    localObject = new ayf();
    ((ayf)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.MB("/cgi-bin/micromsg-bin/findermarkread");
    paramLinkedList = paramLinkedList.aXF();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(178091);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242545);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ' + this.twF.size());
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242545);
      return;
    }
    AppMethodBeat.o(242545);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(178090);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(178090);
    return i;
  }
  
  public final int getType()
  {
    return 3520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cq
 * JD-Core Version:    0.7.0.1
 */