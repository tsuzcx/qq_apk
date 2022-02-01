package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCollectUnreadResponse;", "unreadList", "", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.findersdk.b.c<ava>
{
  public static final a Ayq;
  private final List<byg> Ayr;
  
  static
  {
    AppMethodBeat.i(336297);
    Ayq = new a((byte)0);
    AppMethodBeat.o(336297);
  }
  
  public c(List<? extends byg> paramList, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336290);
    this.Ayr = paramList;
    paramList = new com.tencent.mm.am.c.a();
    Object localObject1 = new auz();
    Object localObject2 = bi.ABn;
    ((auz)localObject1).ZEc = bi.a(parambui);
    ((auz)localObject1).ZFq.addAll((Collection)this.Ayr);
    paramList.otE = ((a)localObject1);
    localObject2 = bi.ABn;
    localObject1 = ((auz)localObject1).ZEc;
    Object localObject3 = (Iterable)this.Ayr;
    localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      byg localbyg = (byg)((Iterator)localObject3).next();
      if (parambui == null) {}
      for (int i = 0;; i = parambui.AJo)
      {
        ((Collection)localObject2).add(new r(Integer.valueOf(i), Long.valueOf(localbyg.hKN)));
        break;
      }
    }
    bi.a((atz)localObject1, (List)localObject2);
    parambui = new ava();
    parambui.setBaseResponse(new kd());
    parambui.getBaseResponse().akjO = new etl();
    paramList.otF = ((a)parambui);
    paramList.uri = "/cgi-bin/micromsg-bin/findercollectunread";
    paramList.funcId = 3980;
    c(paramList.bEF());
    parambui = (Iterable)this.Ayr;
    paramList = (Collection)new ArrayList(p.a(parambui, 10));
    parambui = parambui.iterator();
    while (parambui.hasNext()) {
      paramList.add(d.hF(((byg)parambui.next()).hKN));
    }
    Log.i("CgiCollectUnreadItem", s.X("unreadList=", (List)paramList));
    AppMethodBeat.o(336290);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiCollectUnreadItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */