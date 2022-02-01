package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqv;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class b
  extends c<aqw>
{
  public static final a xan;
  private final List<bku> xam;
  
  static
  {
    AppMethodBeat.i(272380);
    xan = new a((byte)0);
    AppMethodBeat.o(272380);
  }
  
  public b(List<? extends bku> paramList, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(272379);
    this.xam = paramList;
    paramList = new d.a();
    Object localObject1 = new aqv();
    Object localObject2 = ao.xcj;
    ((aqv)localObject1).SDi = ao.a(parambid);
    ((aqv)localObject1).SDZ.addAll((Collection)this.xam);
    paramList.c((a)localObject1);
    localObject2 = ao.xcj;
    localObject1 = ((aqv)localObject1).SDi;
    Object localObject3 = (Iterable)this.xam;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      bku localbku = (bku)((Iterator)localObject3).next();
      if (parambid != null) {}
      for (int i = parambid.xkX;; i = 0)
      {
        ((Collection)localObject2).add(new o(Integer.valueOf(i), Long.valueOf(localbku.xbk)));
        break;
      }
    }
    ao.a((aqe)localObject1, (List)localObject2);
    parambid = new aqw();
    parambid.setBaseResponse(new jh());
    parambid.getBaseResponse().Tef = new eaf();
    paramList.d((a)parambid);
    paramList.TW("/cgi-bin/micromsg-bin/findercollectunread");
    paramList.vD(3980);
    c(paramList.bgN());
    paramList = new StringBuilder("unreadList=");
    localObject1 = (Iterable)this.xam;
    parambid = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      parambid.add(d.Fw(((bku)((Iterator)localObject1).next()).xbk));
    }
    Log.i("CgiCollectUnreadItem", (List)parambid);
    AppMethodBeat.o(272379);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */