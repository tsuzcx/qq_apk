package com.tencent.mm.plugin.finder.live.component.msginterceptor;

import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bke;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "legalMsgType", "", "getLegalMsgType", "()[I", "legalMsgType$delegate", "Lkotlin/Lazy;", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "dealWithMsgListOnEmpty", "", "extraFilter", "appMsg", "intercept", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g
  extends e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final j CBL;
  
  public g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    this.CBK = parama;
    this.CBL = kotlin.k.cm((kotlin.g.a.a)new a(this));
  }
  
  public final boolean a(a.a parama)
  {
    s.u(parama, "respWrapper");
    parama = parama.CBm;
    if (parama == null)
    {
      parama = null;
      if (parama != null) {
        break label160;
      }
      parama = null;
    }
    for (;;)
    {
      if (parama != null) {
        break label237;
      }
      return false;
      parama = parama.PmC;
      if (parama == null)
      {
        parama = null;
        break;
      }
      Object localObject1 = (Iterable)parama;
      parama = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      int i;
      label150:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        bke localbke = (bke)localObject2;
        if (kotlin.a.k.contains((int[])this.CBL.getValue(), localbke.type))
        {
          s.s(localbke, "it");
          if (!b(localbke)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label150;
          }
          parama.add(localObject2);
          break;
        }
      }
      parama = (List)parama;
      break;
      label160:
      if (!((Collection)parama).isEmpty())
      {
        i = 1;
        label174:
        if ((i == 0) && (!ejk())) {
          break label205;
        }
        i = 1;
        label187:
        if (i == 0) {
          break label210;
        }
      }
      for (;;)
      {
        if (parama != null) {
          break label215;
        }
        parama = null;
        break;
        i = 0;
        break label174;
        label205:
        i = 0;
        break label187;
        label210:
        parama = null;
      }
      label215:
      ap(new LinkedList((Collection)parama));
      parama = Boolean.TRUE;
    }
    label237:
    return parama.booleanValue();
  }
  
  public abstract void ap(LinkedList<bke> paramLinkedList);
  
  public boolean b(bke parambke)
  {
    s.u(parambke, "appMsg");
    return true;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.context.a eji()
  {
    return this.CBK;
  }
  
  public abstract int[] ejj();
  
  public boolean ejk()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<int[]>
  {
    a(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.g
 * JD-Core Version:    0.7.0.1
 */