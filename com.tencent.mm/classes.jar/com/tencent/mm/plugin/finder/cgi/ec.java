package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
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
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneReportScreenShot;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "actionType", "", "extStats", "", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "(ILjava/util/List;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActionType", "()I", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getExtStats", "()Ljava/util/List;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ec
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final List<aps> ADN;
  private final String TAG;
  private final int actionType;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public ec(List<? extends aps> paramList)
  {
    AppMethodBeat.i(336782);
    this.actionType = 0;
    this.ADN = paramList;
    this.TAG = "Finder.NetSceneReportScreenShot";
    paramList = new c.a();
    paramList.funcId = getType();
    Object localObject1 = new awy();
    Object localObject2 = bi.ABn;
    ((awy)localObject1).ZEc = bi.dVu();
    ((awy)localObject1).finderUsername = z.bAW();
    ((awy)localObject1).actionType = this.actionType;
    ((awy)localObject1).ZIn.addAll((Collection)this.ADN);
    localObject2 = bi.ABn;
    localObject2 = ((awy)localObject1).ZEc;
    Object localObject3 = (Iterable)this.ADN;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      aps localaps = (aps)((Iterator)localObject3).next();
      bui localbui = getContextObj();
      if (localbui == null) {}
      for (int i = 0;; i = localbui.AJo)
      {
        localCollection.add(new r(Integer.valueOf(i), Long.valueOf(localaps.hKN)));
        break;
      }
    }
    bi.a((atz)localObject2, (List)localCollection);
    paramList.otE = ((a)localObject1);
    localObject1 = new awz();
    ((awz)localObject1).setBaseResponse(new kd());
    paramList.otF = ((a)localObject1);
    paramList.uri = "/cgi-bin/micromsg-bin/finderextstatsreport";
    paramList = paramList.bEF();
    kotlin.g.b.s.s(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = new StringBuilder("");
    localObject1 = ((Iterable)this.ADN).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.append(d.hF(((aps)((Iterator)localObject1).next()).hKN)).append(",");
    }
    Log.i(this.TAG, "NetSceneReportScreenShot start " + this.actionType + ", " + paramList);
    AppMethodBeat.o(336782);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336793);
    Log.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString + ' ');
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(336793);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336809);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336809);
    return i;
  }
  
  public final int getType()
  {
    return 6681;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ec
 * JD-Core Version:    0.7.0.1
 */