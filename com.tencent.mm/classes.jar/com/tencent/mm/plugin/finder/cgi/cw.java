package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMarkRead;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sendMarkReadList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(Ljava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSendMarkReadList", "()Ljava/util/LinkedList;", "setSendMarkReadList", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cw
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d rr;
  public LinkedList<cve> xev;
  
  public cw(LinkedList<cve> paramLinkedList)
  {
    AppMethodBeat.i(178091);
    this.xev = paramLinkedList;
    this.TAG = "Finder.NetSceneMarkRead";
    paramLinkedList = new d.a();
    paramLinkedList.vD(getType());
    Object localObject1 = new bdy();
    ((bdy)localObject1).SPe = this.xev;
    Object localObject2 = ao.xcj;
    localObject2 = ao.dnO();
    Iterator localIterator = ((Iterable)this.xev).iterator();
    while (localIterator.hasNext())
    {
      cve localcve = (cve)localIterator.next();
      LinkedList localLinkedList = ((aqe)localObject2).SDw;
      if (localLinkedList != null)
      {
        bft localbft = new bft();
        localbft.SHp = localcve.sessionBuffer;
        localLinkedList.add(localbft);
      }
    }
    ((bdy)localObject1).SDi = ((aqe)localObject2);
    paramLinkedList.c((a)localObject1);
    localObject1 = new bdz();
    ((bdz)localObject1).setBaseResponse(new jh());
    paramLinkedList.d((a)localObject1);
    paramLinkedList.TW("/cgi-bin/micromsg-bin/findermarkread");
    paramLinkedList = paramLinkedList.bgN();
    p.j(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(178091);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(270438);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ' + this.xev.size());
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(270438);
      return;
    }
    AppMethodBeat.o(270438);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cw
 * JD-Core Version:    0.7.0.1
 */