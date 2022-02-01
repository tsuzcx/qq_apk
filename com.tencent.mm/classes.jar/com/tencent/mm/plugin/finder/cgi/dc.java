package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReportScreenShot;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "actionType", "", "extStats", "", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(ILjava/util/List;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActionType", "()I", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getExtStats", "()Ljava/util/List;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder-base_release"})
public final class dc
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private final int actionType;
  private i callback;
  private com.tencent.mm.an.d rr;
  private final List<amd> xeC;
  
  public dc(List<? extends amd> paramList)
  {
    AppMethodBeat.i(258790);
    this.actionType = 0;
    this.xeC = paramList;
    this.TAG = "Finder.NetSceneReportScreenShot";
    paramList = new d.a();
    paramList.vD(getType());
    Object localObject1 = new asj();
    Object localObject2 = ao.xcj;
    ((asj)localObject1).SDi = ao.dnO();
    ((asj)localObject1).finderUsername = z.bdh();
    ((asj)localObject1).actionType = this.actionType;
    ((asj)localObject1).SFO.addAll((Collection)this.xeC);
    localObject2 = ao.xcj;
    localObject2 = ((asj)localObject1).SDi;
    Object localObject3 = (Iterable)this.xeC;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      amd localamd = (amd)((Iterator)localObject3).next();
      bid localbid = this.xbu;
      if (localbid != null) {}
      for (int i = localbid.xkX;; i = 0)
      {
        localCollection.add(new o(Integer.valueOf(i), Long.valueOf(localamd.xbk)));
        break;
      }
    }
    ao.a((aqe)localObject2, (List)localCollection);
    paramList.c((a)localObject1);
    localObject1 = new ask();
    ((ask)localObject1).setBaseResponse(new jh());
    paramList.d((a)localObject1);
    paramList.TW("/cgi-bin/micromsg-bin/finderextstatsreport");
    paramList = paramList.bgN();
    p.j(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = new StringBuilder("");
    localObject1 = ((Iterable)this.xeC).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.append(com.tencent.mm.ae.d.Fw(((amd)((Iterator)localObject1).next()).xbk)).append(",");
    }
    Log.i(this.TAG, "NetSceneReportScreenShot start " + this.actionType + ", " + paramList);
    AppMethodBeat.o(258790);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(258787);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(258787);
      return;
    }
    AppMethodBeat.o(258787);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(258789);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(258789);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dc
 * JD-Core Version:    0.7.0.1
 */