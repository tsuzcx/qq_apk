package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.af.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnhanceStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceResp;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enhanceFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lastStreamBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "statsList", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "unreadFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "tabType", "", "listen_event_type", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderObject;Lcom/tencent/mm/protobuf/ByteString;Ljava/util/List;Ljava/util/List;II)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderEnhanceReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderEnhanceReq;", "getUnreadFeedList", "()Ljava/util/List;", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c<awp>
{
  public static final a AyK;
  private final List<byg> AyL;
  private final awo AyM;
  
  static
  {
    AppMethodBeat.i(336351);
    AyK = new a((byte)0);
    AppMethodBeat.o(336351);
  }
  
  public l(bui parambui, FinderObject paramFinderObject, com.tencent.mm.bx.b paramb, List<? extends fhp> paramList, List<? extends byg> paramList1, int paramInt1, int paramInt2)
  {
    super(parambui);
    AppMethodBeat.i(336344);
    this.AyL = paramList1;
    this.AyM = new awo();
    paramList1 = k.aeZF;
    paramList1 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    Object localObject1 = this.AyM;
    Object localObject2 = bi.ABn;
    ((awo)localObject1).YIY = bi.a(parambui);
    this.AyM.ZEQ = paramb;
    this.AyM.longitude = ((Number)paramList1.bsC).floatValue();
    this.AyM.latitude = ((Number)paramList1.bsD).floatValue();
    this.AyM.object_id = paramFinderObject.id;
    this.AyM.object_nonce_id = paramFinderObject.objectNonceId;
    this.AyM.ZHE.addAll((Collection)paramList);
    this.AyM.ZHF.addAll((Collection)this.AyL);
    this.AyM.ZHD = paramInt1;
    this.AyM.ZHG = paramInt2;
    paramList1 = this.AyM;
    localObject1 = bi.ABn;
    paramList1.ZDQ = bi.bTZ();
    if ((1 <= Log.getLogLevel()) && ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())))
    {
      paramList1 = ((Iterable)paramList).iterator();
      while (paramList1.hasNext())
      {
        localObject1 = (fhp)paramList1.next();
        localObject2 = af.FsA;
        af.a.a((fhp)localObject1, "Cgi.FinderEnhanceStream");
      }
    }
    paramList1 = bi.ABn;
    paramList1 = this.AyM.YIY;
    localObject1 = this.AyM.ZHF;
    s.s(localObject1, "request.mark_unread_object_list");
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      byg localbyg = (byg)((Iterator)localObject2).next();
      if (parambui == null) {}
      for (int i = 0;; i = parambui.AJo)
      {
        ((Collection)localObject1).add(new r(Integer.valueOf(i), Long.valueOf(localbyg.hKN)));
        break;
      }
    }
    bi.a(paramList1, (List)localObject1);
    parambui = new StringBuilder("[INIT] tabType=").append(paramInt1).append(" listen_event_type=").append(paramInt2).append(" lastStreamBuffer=");
    if (paramb != null) {}
    for (boolean bool = true;; bool = false)
    {
      parambui = parambui.append(bool).append(" object_id=").append(d.hF(paramFinderObject.id)).append(" statsList=");
      paramb = (Iterable)paramList;
      paramFinderObject = (Collection)new ArrayList(p.a(paramb, 10));
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        paramFinderObject.add(d.hF(((fhp)paramb.next()).hKN));
      }
    }
    parambui = parambui.append((List)paramFinderObject).append(" unreadFeedList=");
    paramb = (Iterable)this.AyL;
    paramFinderObject = (Collection)new ArrayList(p.a(paramb, 10));
    paramb = paramb.iterator();
    while (paramb.hasNext()) {
      paramFinderObject.add(d.hF(((byg)paramb.next()).hKN));
    }
    Log.i("Cgi.FinderEnhanceStream", (List)paramFinderObject);
    parambui = new c.a();
    parambui.otE = ((a)this.AyM);
    paramFinderObject = new awp();
    paramFinderObject.setBaseResponse(new kd());
    paramFinderObject.getBaseResponse().akjO = new etl();
    parambui.otF = ((a)paramFinderObject);
    parambui.uri = "/cgi-bin/micromsg-bin/finderenhance";
    parambui.funcId = 4004;
    c(parambui.bEF());
    AppMethodBeat.o(336344);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnhanceStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */