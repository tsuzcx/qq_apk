package com.tencent.mm.plugin.finder.live.component.msginterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.commentitem.d;
import com.tencent.mm.plugin.finder.live.model.commentitem.e;
import com.tencent.mm.plugin.finder.live.model.commentitem.f;
import com.tencent.mm.plugin.finder.live.model.commentitem.g;
import com.tencent.mm.plugin.finder.live.model.commentitem.h;
import com.tencent.mm.plugin.finder.live.model.commentitem.i;
import com.tencent.mm.plugin.finder.live.model.commentitem.j;
import com.tencent.mm.plugin.finder.live.model.commentitem.k;
import com.tencent.mm.plugin.finder.live.model.commentitem.l;
import com.tencent.mm.plugin.finder.live.model.commentitem.m;
import com.tencent.mm.plugin.finder.live.model.commentitem.n;
import com.tencent.mm.plugin.finder.live.model.commentitem.o;
import com.tencent.mm.plugin.finder.live.model.commentitem.q;
import com.tencent.mm.plugin.finder.live.model.commentitem.t;
import com.tencent.mm.plugin.finder.live.model.commentitem.u;
import com.tencent.mm.plugin.finder.live.model.commentitem.v;
import com.tencent.mm.plugin.finder.live.model.commentitem.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItemService;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "commentListWidth", "", "getCommentListWidth", "()I", "setCommentListWidth", "(I)V", "itemMap", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "", "legaLItemType", "", "getLegaLItemType", "()[I", "setLegaLItemType", "([I)V", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "init", "onCleared", "registItem", "item", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.viewmodel.data.business.c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public final Map<Integer, b> CBE;
  private int[] CBF;
  public int CBG;
  public final String TAG;
  
  public c(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353169);
    this.TAG = "FinderLiveCommentItemService";
    this.CBE = Collections.synchronizedMap((Map)new HashMap());
    this.CBF = new int[0];
    this.CBG = -1;
    AppMethodBeat.o(353169);
  }
  
  private final void a(b paramb)
  {
    AppMethodBeat.i(353178);
    if (!this.CBE.containsKey(Integer.valueOf(paramb.eiV())))
    {
      Map localMap = this.CBE;
      kotlin.g.b.s.s(localMap, "itemMap");
      localMap.put(Integer.valueOf(paramb.eiV()), paramb);
    }
    AppMethodBeat.o(353178);
  }
  
  public final int[] ejg()
  {
    AppMethodBeat.i(353187);
    if (this.CBE.isEmpty()) {
      init();
    }
    if (this.CBF.length == this.CBE.size())
    {
      localObject1 = this.CBF;
      AppMethodBeat.o(353187);
      return localObject1;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.CBE;
    kotlin.g.b.s.s(localObject1, "itemMap");
    try
    {
      Object localObject3 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(((Map.Entry)((Iterator)localObject3).next()).getKey());
      }
      localObject3 = ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(353187);
    }
    this.CBF = kotlin.a.p.I((Collection)localObject2);
    localObject1 = this.CBF;
    AppMethodBeat.o(353187);
    return localObject1;
  }
  
  public final void init()
  {
    AppMethodBeat.i(353197);
    a((b)new v(this.CBK));
    a((b)new com.tencent.mm.plugin.finder.live.model.commentitem.a(this.CBK));
    a((b)new g(this.CBK));
    a((b)new e(this.CBK));
    a((b)new d(this.CBK));
    a((b)new f(this.CBK));
    a((b)new h(this.CBK));
    a((b)new j(this.CBK));
    a((b)new l(this.CBK));
    a((b)new n(this.CBK));
    a((b)new o(this.CBK));
    a((b)new com.tencent.mm.plugin.finder.live.model.commentitem.p(this.CBK));
    a((b)new q(this.CBK));
    a((b)new u(this.CBK));
    a((b)new com.tencent.mm.plugin.finder.live.model.commentitem.s(this.CBK));
    a((b)new t(this.CBK));
    a((b)new x(this.CBK));
    a((b)new com.tencent.mm.plugin.finder.live.model.commentitem.b(this.CBK));
    a((b)new m(this.CBK));
    a((b)new k(this.CBK));
    a((b)new i(this.CBK));
    AppMethodBeat.o(353197);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(353206);
    Iterator localIterator = ((Iterable)this.CBE.entrySet()).iterator();
    while (localIterator.hasNext()) {
      ((b)((Map.Entry)localIterator.next()).getValue()).onCleared();
    }
    this.CBE.clear();
    AppMethodBeat.o(353206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.c
 * JD-Core Version:    0.7.0.1
 */