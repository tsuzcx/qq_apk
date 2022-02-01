package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.finder.report.t.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnhanceStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enhanceFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lastStreamBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "statsList", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "unreadFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderObject;Lcom/tencent/mm/protobuf/ByteString;Ljava/util/List;Ljava/util/List;I)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderEnhanceReq;", "getUnreadFeedList", "()Ljava/util/List;", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class j
  extends c<asd>
{
  public static final a xaD;
  private final asc xaB;
  private final List<bku> xaC;
  
  static
  {
    AppMethodBeat.i(279609);
    xaD = new a((byte)0);
    AppMethodBeat.o(279609);
  }
  
  public j(bid parambid, FinderObject paramFinderObject, b paramb, List<? extends emr> paramList, List<? extends bku> paramList1, int paramInt)
  {
    super(parambid);
    AppMethodBeat.i(279608);
    this.xaC = paramList1;
    this.xaB = new asc();
    paramList1 = g.Xox;
    paramList1 = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    Object localObject1 = this.xaB;
    Object localObject2 = ao.xcj;
    ((asc)localObject1).RLM = ao.a(parambid);
    this.xaB.SDI = paramb;
    this.xaB.longitude = ((Number)paramList1.Mx).floatValue();
    this.xaB.latitude = ((Number)paramList1.My).floatValue();
    this.xaB.object_id = paramFinderObject.id;
    this.xaB.object_nonce_id = paramFinderObject.objectNonceId;
    this.xaB.SFB.addAll((Collection)paramList);
    this.xaB.SFC.addAll((Collection)this.xaC);
    this.xaB.SFA = paramInt;
    paramList1 = this.xaB;
    localObject1 = ao.xcj;
    paramList1.SCW = ao.dnP();
    if ((1 >= Log.getLogLevel()) && ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())))
    {
      paramList1 = ((Iterable)paramList).iterator();
      while (paramList1.hasNext())
      {
        localObject1 = (emr)paramList1.next();
        localObject2 = t.zXK;
        t.a.a((emr)localObject1, "Cgi.FinderEnhanceStream");
      }
    }
    paramList1 = ao.xcj;
    paramList1 = this.xaB.RLM;
    localObject1 = this.xaB.SFC;
    p.j(localObject1, "request.mark_unread_object_list");
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      bku localbku = (bku)((Iterator)localObject2).next();
      if (parambid != null) {}
      for (int i = parambid.xkX;; i = 0)
      {
        ((Collection)localObject1).add(new o(Integer.valueOf(i), Long.valueOf(localbku.xbk)));
        break;
      }
    }
    ao.a(paramList1, (List)localObject1);
    parambid = new StringBuilder("[INIT] tabType=").append(paramInt).append(" lastStreamBuffer=");
    if (paramb != null) {}
    for (boolean bool = true;; bool = false)
    {
      parambid = parambid.append(bool).append(" object_id=").append(d.Fw(paramFinderObject.id)).append(' ').append("statsList=");
      paramb = (Iterable)paramList;
      paramFinderObject = (Collection)new ArrayList(kotlin.a.j.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramFinderObject.add(d.Fw(((emr)paramb.next()).xbk));
      }
    }
    parambid = parambid.append((List)paramFinderObject).append(' ').append("unreadFeedList=");
    paramb = (Iterable)this.xaC;
    paramFinderObject = (Collection)new ArrayList(kotlin.a.j.a(paramb, 10));
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      paramFinderObject.add(d.Fw(((bku)paramb.next()).xbk));
    }
    Log.i("Cgi.FinderEnhanceStream", (List)paramFinderObject);
    parambid = new d.a();
    parambid.c((com.tencent.mm.cd.a)this.xaB);
    paramFinderObject = new asd();
    paramFinderObject.setBaseResponse(new jh());
    paramFinderObject.getBaseResponse().Tef = new eaf();
    parambid.d((com.tencent.mm.cd.a)paramFinderObject);
    parambid.TW("/cgi-bin/micromsg-bin/finderenhance");
    parambid.vD(4004);
    c(parambid.bgN());
    AppMethodBeat.o(279608);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnhanceStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */