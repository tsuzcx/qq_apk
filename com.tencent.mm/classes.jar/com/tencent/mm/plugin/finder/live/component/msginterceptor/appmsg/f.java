package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.c;
import com.tencent.mm.plugin.finder.live.model.ab;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.cgi.aw;
import com.tencent.mm.plugin.finder.live.model.l.a;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveCommentMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "addLocalGiftToMsg", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "saveMyselfComment", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "extraFilter", "appMsg", "intercept", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "legalMsgType", "", "topSelfComment", "liveMsg", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private boolean CBO;
  private boolean CBP;
  private final String TAG;
  
  public f(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353278);
    this.CBK = parama;
    this.TAG = "LiveCommentMsgInterceptor";
    this.CBO = true;
    this.CBP = true;
    parama = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSC().bmg()).intValue() == 0)
    {
      bool1 = true;
      this.CBO = bool1;
      parama = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jSD().bmg()).intValue() != 0) {
        break label139;
      }
    }
    label139:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.CBP = bool1;
      Log.i(this.TAG, "saveMyselfCommentValue:" + this.CBP + ", sendLocalGiftToMsgValue :" + this.CBO);
      AppMethodBeat.o(353278);
      return;
      bool1 = false;
      break;
    }
  }
  
  private final boolean a(aq paramaq)
  {
    l.a locala = null;
    AppMethodBeat.i(353311);
    label169:
    label177:
    label206:
    label214:
    int i;
    label388:
    label440:
    label825:
    if (((paramaq.getType() != 20013) || (this.CBO)) && (paramaq.getType() != 20014) && (paramaq.getType() != 20019) && (paramaq.getType() != 20020) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eea.contains(paramaq.eky())))
    {
      Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeb;
      s.s(localObject1, "liveContext.business(Liv…).myLocalTextCommentCache");
      Object localObject3 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label230:
      label238:
      long l;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = ((Iterator)localObject3).next();
        aq localaq = (aq)localObject2;
        if ((localaq instanceof am))
        {
          localObject1 = (am)localaq;
          if (localObject1 != null) {
            break label512;
          }
          localObject1 = null;
          if (!s.p(localObject1, paramaq.eky()))
          {
            if (!(localaq instanceof t)) {
              break label540;
            }
            localObject1 = (t)localaq;
            if (localObject1 != null) {
              break label546;
            }
            localObject1 = null;
            if (!s.p(localObject1, paramaq.eky())) {
              break label574;
            }
          }
          i = 1;
          if (i == 0) {
            break label577;
          }
          localObject1 = localObject2;
          localObject1 = (aq)localObject1;
          if (localObject1 != null)
          {
            if (!(localObject1 instanceof am)) {
              break label634;
            }
            localObject2 = (am)localObject1;
            l = paramaq.dFp();
            ((am)localObject2).CIc.seq = l;
            localObject2 = paramaq.eku();
            if (localObject2 != null) {
              ((am)localObject1).CIc.EbJ = ((bgh)localObject2);
            }
            localObject2 = this.TAG;
            localObject3 = new StringBuilder("fillback selfcomment, text, content:").append(paramaq.getContent()).append(", seq:").append(paramaq.dFp()).append(", contact sex:");
            localObject1 = ((am)localObject1).CIc.EbJ;
            if (localObject1 != null) {
              break label585;
            }
            localObject1 = null;
            label373:
            Log.i((String)localObject2, localObject1);
            if (s.p(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eec, paramaq.eky()))
            {
              Log.i(this.TAG, "selfcomment hit topComment");
              if (!(paramaq instanceof am)) {
                break label825;
              }
              localObject1 = ((am)paramaq).CIc;
              if (localObject1 != null)
              {
                locala = com.tencent.mm.plugin.finder.live.model.l.CFt;
                if (!l.a.OP(paramaq.getType())) {
                  break label971;
                }
              }
            }
          }
        }
      }
      label574:
      label577:
      label585:
      label971:
      for (i = 1;; i = 0)
      {
        new aw(this.CBK, (bke)localObject1, i).bFJ();
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).aym("");
        AppMethodBeat.o(353311);
        return false;
        localObject1 = null;
        break label169;
        localObject1 = ((am)localObject1).CIc;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label177;
        }
        localObject1 = ((bke)localObject1).kLn;
        break label177;
        localObject1 = null;
        break label206;
        localObject1 = ((t)localObject1).CER;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label214;
        }
        localObject1 = ((bdm)localObject1).Tro;
        break label214;
        i = 0;
        break label230;
        break;
        localObject1 = null;
        break label238;
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label373;
        }
        localObject1 = ((FinderContact)localObject1).extInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label373;
        }
        localObject1 = Integer.valueOf(((avl)localObject1).sex);
        break label373;
        label634:
        if (!(localObject1 instanceof t)) {
          break label388;
        }
        localObject2 = (t)localObject1;
        l = paramaq.dFp();
        ((t)localObject2).CER.seq = l;
        localObject2 = paramaq.eku();
        if (localObject2 != null) {
          ((t)localObject1).CER.ZOb = ((bgh)localObject2);
        }
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("fillback selfcomment, interactive, content:").append(paramaq.getContent()).append(", seq:").append(paramaq.dFp()).append(", contact sex:");
        localObject1 = ((t)localObject1).CER.ZOb;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          Log.i((String)localObject2, localObject1);
          break;
          localObject1 = ((bgh)localObject1).contact;
          if (localObject1 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = ((FinderContact)localObject1).extInfo;
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = Integer.valueOf(((avl)localObject1).sex);
            }
          }
        }
        if ((paramaq instanceof t))
        {
          localObject1 = new bke();
          ((bke)localObject1).nickname = paramaq.ekt();
          ((bke)localObject1).content = paramaq.getContent();
          ((bke)localObject1).type = 1;
          ((bke)localObject1).username = paramaq.djQ();
          ((bke)localObject1).seq = paramaq.dFp();
          ((bke)localObject1).kLn = ((t)paramaq).CER.Tro;
          ((bke)localObject1).EbJ = ((t)paramaq).CER.ZOb;
          ((bke)localObject1).ZTq = ((t)paramaq).CER.ZNW;
          ((bke)localObject1).ZTp = ((t)paramaq).CER.ZOc;
          break label440;
        }
        Log.i(this.TAG, "selfcomment topCommentMsg null");
        localObject1 = locala;
        break label440;
      }
    }
    label512:
    label540:
    label546:
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdH.get(Long.valueOf(paramaq.dFp())) != null)
    {
      AppMethodBeat.o(353311);
      return false;
    }
    if ((paramaq.getType() == 20013) && (this.CBO) && ((s.p(paramaq.djQ(), z.bAM())) || (s.p(paramaq.djQ(), z.bAW()))))
    {
      AppMethodBeat.o(353311);
      return false;
    }
    if (paramaq.getType() == 20036)
    {
      paramaq = (CharSequence)paramaq.getContent();
      if ((paramaq == null) || (paramaq.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(353311);
        return false;
      }
    }
    AppMethodBeat.o(353311);
    return true;
  }
  
  private final void ap(LinkedList<aq> paramLinkedList)
  {
    AppMethodBeat.i(353296);
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (aq)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdH.put(Long.valueOf(((aq)localObject2).dFp()), localObject2);
      Map localMap = (Map)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcN;
      String str = ((aq)localObject2).djQ();
      localObject2 = ((aq)localObject2).eku();
      if ((localObject2 != null) && (((bgh)localObject2).ZPQ == 1)) {}
      for (boolean bool = true;; bool = false)
      {
        localMap.put(str, Boolean.valueOf(bool));
        break;
      }
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcM = (kotlin.k.k.bR(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcM, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE.size()) + paramLinkedList.size());
    if (this.CBP)
    {
      localObject1 = ab.CGy;
      ab.c(this.CBK, paramLinkedList);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.l)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.l.class)).EgE.addAll((Collection)paramLinkedList);
      AppMethodBeat.o(353296);
      return;
      localObject1 = ab.CGy;
      ab.b(this.CBK, paramLinkedList);
    }
  }
  
  private final int[] ejj()
  {
    AppMethodBeat.i(353283);
    int[] arrayOfInt = ((c)this.CBK.business(c.class)).ejg();
    AppMethodBeat.o(353283);
    return arrayOfInt;
  }
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353324);
    s.u(parama, "respWrapper");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = parama.CBm;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label340;
      }
      if (((Collection)localObject1).isEmpty()) {
        break label335;
      }
      i = 1;
      label51:
      if (i != 1) {
        break label340;
      }
      i = 1;
      label58:
      if (i == 0) {
        break label345;
      }
      label62:
      if (localObject1 == null) {
        break label365;
      }
      localObject2 = ((Iterable)localObject1).iterator();
    }
    label77:
    Object localObject3;
    label181:
    Object localObject4;
    label335:
    label340:
    label345:
    label358:
    label360:
    label363:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label365;
      }
      localObject1 = (bdm)((Iterator)localObject2).next();
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, s.X("LiveCommentMsgInterceptor before extraFilter msg_type:", Integer.valueOf(((bdm)localObject1).msg_type)));
      localObject3 = (c)this.CBK.business(c.class);
      s.s(localObject1, "it");
      s.u(localObject1, "msg");
      localObject3 = (com.tencent.mm.plugin.finder.live.component.msginterceptor.b)((c)localObject3).CBE.get(Integer.valueOf(((bdm)localObject1).msg_type));
      if (localObject3 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label358;
        }
        if (!a((aq)localObject1)) {
          break label360;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label363;
        }
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, s.X("LiveCommentMsgInterceptor after extraFilter msg_type:", Integer.valueOf(((aq)localObject1).getType())));
        localLinkedList.add(localObject1);
        break label77;
        localObject1 = ((azp)localObject1).ZJV;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          localObject4 = (bdm)localObject3;
          if (kotlin.a.k.contains(ejj(), ((bdm)localObject4).msg_type)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject1 = (List)localObject1;
        break;
        i = 0;
        break label51;
        i = 0;
        break label58;
        localObject1 = null;
        break label62;
        localObject1 = ((com.tencent.mm.plugin.finder.live.component.msginterceptor.b)localObject3).a((bdm)localObject1);
        break label181;
        break label77;
        localObject1 = null;
      }
    }
    label365:
    localObject1 = parama.CBm;
    if (localObject1 != null)
    {
      localObject1 = ((azp)localObject1).ZJV;
      if (localObject1 != null) {
        an.hA((Collection)localObject1).removeAll((Collection)localLinkedList);
      }
    }
    Object localObject2 = new LinkedList();
    localObject1 = parama.CBm;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label676;
      }
      if (((Collection)localObject1).isEmpty()) {
        break label671;
      }
      i = 1;
      label439:
      if (i != 1) {
        break label676;
      }
      i = 1;
      label446:
      if (i == 0) {
        break label681;
      }
      label450:
      if (localObject1 == null) {
        break label701;
      }
      localObject3 = ((Iterable)localObject1).iterator();
    }
    label544:
    label676:
    label681:
    label694:
    label696:
    label699:
    for (;;)
    {
      label465:
      if (!((Iterator)localObject3).hasNext()) {
        break label701;
      }
      localObject1 = (bke)((Iterator)localObject3).next();
      localObject4 = (c)this.CBK.business(c.class);
      s.s(localObject1, "it");
      s.u(localObject1, "msg");
      localObject4 = (com.tencent.mm.plugin.finder.live.component.msginterceptor.b)((c)localObject4).CBE.get(Integer.valueOf(((bke)localObject1).type));
      if (localObject4 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label694;
        }
        if (!a((aq)localObject1)) {
          break label696;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label699;
        }
        ((LinkedList)localObject2).add(localObject1);
        break label465;
        localObject1 = ((azp)localObject1).PmC;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          bke localbke = (bke)localObject4;
          if (kotlin.a.k.contains(ejj(), localbke.type)) {
            ((Collection)localObject1).add(localObject4);
          }
        }
        localObject1 = (List)localObject1;
        break;
        i = 0;
        break label439;
        i = 0;
        break label446;
        localObject1 = null;
        break label450;
        localObject1 = ((com.tencent.mm.plugin.finder.live.component.msginterceptor.b)localObject4).a((bke)localObject1);
        break label544;
        break label465;
        localObject1 = null;
      }
    }
    label671:
    label701:
    parama = parama.CBm;
    if (parama != null)
    {
      parama = parama.PmC;
      if (parama != null) {
        an.hA((Collection)parama).removeAll((Collection)localObject2);
      }
    }
    localLinkedList.addAll((Collection)localObject2);
    p.a((List)localLinkedList, (Comparator)new a());
    ap(localLinkedList);
    AppMethodBeat.o(353324);
    return true;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(353306);
      int i = kotlin.b.a.b((Comparable)Long.valueOf(((aq)paramT1).dFp()), (Comparable)Long.valueOf(((aq)paramT2).dFp()));
      AppMethodBeat.o(353306);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.f
 * JD-Core Version:    0.7.0.1
 */