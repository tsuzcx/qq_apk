package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneExtStatsReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "actionType", "", "extStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/ExtStats;)V", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/util/List;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderExtStatsReportRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bu
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private b AAa;
  private awy ABL;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public bu(bui parambui, int paramInt, aps paramaps)
  {
    this(parambui, paramInt, (List)kotlin.a.p.al(new aps[] { paramaps }));
    AppMethodBeat.i(336346);
    AppMethodBeat.o(336346);
  }
  
  public bu(bui parambui, int paramInt, List<? extends aps> paramList)
  {
    super(parambui);
    AppMethodBeat.i(336361);
    this.TAG = "Finder.NetSceneExtStatsReport";
    this.AAa = b.Hdf;
    c.a locala = new c.a();
    locala.funcId = getType();
    Object localObject1 = new awy();
    ((awy)localObject1).finderUsername = z.bAW();
    ((awy)localObject1).actionType = paramInt;
    ((awy)localObject1).ZIn.addAll((Collection)paramList);
    Object localObject2 = bi.ABn;
    ((awy)localObject1).ZEc = bi.a(parambui);
    localObject2 = ah.aiuX;
    this.ABL = ((awy)localObject1);
    localObject1 = bi.ABn;
    localObject1 = this.ABL.ZEc;
    localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      aps localaps = (aps)((Iterator)localObject2).next();
      if (parambui == null) {}
      for (paramInt = 0;; paramInt = parambui.AJo)
      {
        paramList.add(new r(Integer.valueOf(paramInt), Long.valueOf(localaps.hKN)));
        break;
      }
    }
    bi.a((atz)localObject1, (List)paramList, parambui);
    locala.otE = ((a)this.ABL);
    parambui = new awz();
    parambui.setBaseResponse(new kd());
    locala.otF = ((a)parambui);
    locala.uri = "/cgi-bin/micromsg-bin/finderextstatsreport";
    parambui = locala.bEF();
    kotlin.g.b.s.s(parambui, "builder.buildInstance()");
    this.rr = parambui;
    AppMethodBeat.o(336361);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336389);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    if (paramInt2 >= 4) {
      this.AAa = b.Hdd;
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(336389);
  }
  
  public final b dVi()
  {
    return this.AAa;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336375);
    this.callback = paramh;
    paramh = this.ABL.ZIn;
    kotlin.g.b.s.s(paramh, "request.extStats");
    aps localaps = (aps)kotlin.a.p.ae((List)paramh, 0);
    String str;
    StringBuilder localStringBuilder;
    if (localaps != null)
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder("doExtStatsReport scene=");
      paramh = this.ABL.ZEc;
      if (paramh != null) {
        break label157;
      }
    }
    label157:
    for (paramh = null;; paramh = Integer.valueOf(paramh.scene))
    {
      Log.i(str, paramh + " feedActionValue=" + localaps.ZwW + " objectId=" + localaps.hKN + " username=" + localaps.finderUsername);
      int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
      AppMethodBeat.o(336375);
      return i;
    }
  }
  
  public final int getType()
  {
    return 6681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bu
 * JD-Core Version:    0.7.0.1
 */