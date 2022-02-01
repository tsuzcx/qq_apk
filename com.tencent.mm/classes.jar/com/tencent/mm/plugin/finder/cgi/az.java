package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.findersdk.b.a.b;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneExtStatsReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "actionType", "", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/ExtStats;)V", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderExtStatsReportRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class az
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d rr;
  private b xbn;
  private asj xcz;
  
  public az(bid parambid, amd paramamd)
  {
    this(parambid, (List)j.ag(new amd[] { paramamd }));
    AppMethodBeat.i(290744);
    AppMethodBeat.o(290744);
  }
  
  public az(bid parambid, List<? extends amd> paramList)
  {
    super(parambid);
    AppMethodBeat.i(290745);
    this.TAG = "Finder.NetSceneExtStatsReport";
    this.xbn = b.BvV;
    d.a locala = new d.a();
    locala.vD(getType());
    Object localObject1 = new asj();
    ((asj)localObject1).finderUsername = z.bdh();
    ((asj)localObject1).actionType = 18054;
    ((asj)localObject1).SFO.addAll((Collection)paramList);
    Object localObject2 = ao.xcj;
    ((asj)localObject1).SDi = ao.a(parambid);
    this.xcz = ((asj)localObject1);
    localObject1 = ao.xcj;
    localObject1 = this.xcz.SDi;
    localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      amd localamd = (amd)((Iterator)localObject2).next();
      if (parambid != null) {}
      for (int i = parambid.xkX;; i = 0)
      {
        paramList.add(new o(Integer.valueOf(i), Long.valueOf(localamd.xbk)));
        break;
      }
    }
    ao.a((aqe)localObject1, (List)paramList);
    locala.c((a)this.xcz);
    parambid = new ask();
    parambid.setBaseResponse(new jh());
    locala.d((a)parambid);
    locala.TW("/cgi-bin/micromsg-bin/finderextstatsreport");
    parambid = locala.bgN();
    p.j(parambid, "builder.buildInstance()");
    this.rr = parambid;
    AppMethodBeat.o(290745);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(290743);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    if (paramInt2 >= 4) {
      this.xbn = b.BvT;
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(290743);
      return;
    }
    AppMethodBeat.o(290743);
  }
  
  public final b dnF()
  {
    return this.xbn;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(290742);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(290742);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.az
 * JD-Core Version:    0.7.0.1
 */