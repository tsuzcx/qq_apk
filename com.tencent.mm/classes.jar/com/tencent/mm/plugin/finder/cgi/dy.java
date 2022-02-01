package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMarkRead;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sendMarkReadList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(Ljava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSendMarkReadList", "()Ljava/util/LinkedList;", "setSendMarkReadList", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dy
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public LinkedList<dmk> ADI;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public dy(LinkedList<dmk> paramLinkedList)
  {
    AppMethodBeat.i(178091);
    this.ADI = paramLinkedList;
    this.TAG = "Finder.NetSceneMarkRead";
    paramLinkedList = new c.a();
    paramLinkedList.funcId = getType();
    Object localObject1 = new bow();
    ((bow)localObject1).ZXp = this.ADI;
    Object localObject2 = bi.ABn;
    localObject2 = bi.dVu();
    Object localObject3 = ((Iterable)this.ADI).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (dmk)((Iterator)localObject3).next();
      LinkedList localLinkedList = ((atz)localObject2).ZEu;
      if (localLinkedList != null)
      {
        bra localbra = new bra();
        localbra.ZJK = ((dmk)localObject4).sessionBuffer;
        localObject4 = ah.aiuX;
        localLinkedList.add(localbra);
      }
    }
    localObject3 = ah.aiuX;
    ((bow)localObject1).ZEc = ((atz)localObject2);
    paramLinkedList.otE = ((a)localObject1);
    localObject1 = new box();
    ((box)localObject1).setBaseResponse(new kd());
    paramLinkedList.otF = ((a)localObject1);
    paramLinkedList.uri = "/cgi-bin/micromsg-bin/findermarkread";
    paramLinkedList = paramLinkedList.bEF();
    kotlin.g.b.s.s(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(178091);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336783);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ' + this.ADI.size());
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336783);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(178090);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(178090);
    return i;
  }
  
  public final int getType()
  {
    return 3520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dy
 * JD-Core Version:    0.7.0.1
 */