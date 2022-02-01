package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.am.f;
import com.tencent.mm.ui.base.aa;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter$PromotionViewHolder;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onItemLongClickListener", "Lkotlin/Function3;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAnchor;", "Lkotlin/ParameterName;", "name", "info", "Landroid/view/View;", "view", "", "prosition", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "promoteInfoList", "Ljava/util/LinkedList;", "size4A", "getSize4A", "()I", "size4A$delegate", "Lkotlin/Lazy;", "size6A", "getSize6A", "size6A$delegate", "add", "data", "del", "", "getItemCount", "isContainSameInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAvailableItem;", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "pushOrCancelPromote", "item", "update", "PromotionViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends RecyclerView.a<a>
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  public LinkedList<bkv> DQf;
  private final j DQg;
  private final j DQh;
  public q<? super bkv, ? super View, ? super Integer, ah> DQi;
  private final String TAG;
  private final Context context;
  private RecyclerView mRecyclerView;
  private final com.tencent.mm.live.b.b nfT;
  
  public h(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(358628);
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveAnchorPromoteInfoAdapter";
    this.DQg = k.cm((kotlin.g.a.a)c.DQl);
    this.DQh = k.cm((kotlin.g.a.a)b.DQk);
    AppMethodBeat.o(358628);
  }
  
  private static final Object a(h paramh, bkv parambkv, Context paramContext, b.a parama)
  {
    int j = 4;
    int k = 0;
    AppMethodBeat.i(358717);
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(parambkv, "$item");
    kotlin.g.b.s.u(paramContext, "$context");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.model.context.a locala = paramh.CvU;
      kotlin.g.b.s.u(locala, "liveData");
      kotlin.g.b.s.u(parambkv, "item");
      int i = -1;
      parama = "";
      switch (parambkv.type)
      {
      default: 
        if (parambkv.ZTV) {
          j = 5;
        }
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(locala, j, i, parama);
        if (!parambkv.ZTV)
        {
          bool = true;
          label138:
          parambkv.ZTV = bool;
          parama = paramh.DQf;
          if (parama != null) {
            break label489;
          }
          parama = null;
          label155:
          if (parama != null) {
            break label501;
          }
          label159:
          i = 1;
          label162:
          if (i == 0) {
            break label516;
          }
        }
        break;
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              if (parama != null) {
                paramh.fV(((Number)parama).intValue());
              }
              parama = paramh.mRecyclerView;
              if (parama != null) {
                break label521;
              }
              AppMethodBeat.o(358717);
              return null;
              localObject = new bmt();
              locala1 = (com.tencent.mm.bx.a)localObject;
              parama = parambkv.ZTU;
              if (parama == null) {
                parama = null;
              }
              try
              {
                for (;;)
                {
                  locala1.parseFrom(parama);
                  parama = String.valueOf(((bmt)localObject).DUP);
                  i = 4;
                  break;
                  parama = parama.toByteArray();
                }
              }
              catch (Exception parama)
              {
                for (;;)
                {
                  Log.printDebugStack("safeParser", "", new Object[] { parama });
                }
              }
            }
            i = 1;
            break;
            localObject = new bkx();
            locala1 = (com.tencent.mm.bx.a)localObject;
            parama = parambkv.ZTU;
            if (parama == null) {
              parama = null;
            }
            try
            {
              for (;;)
              {
                locala1.parseFrom(parama);
                parama = ((bkx)localObject).url;
                if (parama != null) {
                  break label362;
                }
                parama = "";
                i = 2;
                break;
                parama = parama.toByteArray();
              }
            }
            catch (Exception parama)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { parama });
                continue;
                label362:
                localObject = parama.toString();
                parama = (b.a)localObject;
                if (localObject == null) {
                  parama = "";
                }
              }
            }
          }
          Object localObject = new bky();
          com.tencent.mm.bx.a locala1 = (com.tencent.mm.bx.a)localObject;
          parama = parambkv.ZTU;
          if (parama == null) {
            parama = null;
          }
          try
          {
            for (;;)
            {
              locala1.parseFrom(parama);
              parama = ((bky)localObject).ZUc;
              if (parama != null) {
                break label463;
              }
              parama = "";
              i = 3;
              break;
              parama = parama.toByteArray();
            }
          }
          catch (Exception parama)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { parama });
              continue;
              label463:
              localObject = parama.toString();
              parama = (b.a)localObject;
              if (localObject == null) {
                parama = "";
              }
            }
          }
        }
        bool = false;
        break label138;
        label489:
        parama = Integer.valueOf(parama.indexOf(parambkv));
        break label155;
        label501:
        i = k;
        if (parama.intValue() == 1) {
          break label162;
        }
        break label159;
        label516:
        parama = null;
      }
      label521:
      boolean bool = parama.post(new h..ExternalSyntheticLambda5(parambkv, paramContext, paramh));
      AppMethodBeat.o(358717);
      return Boolean.valueOf(bool);
    }
    Log.i(paramh.TAG, "[pushOrCancelPromote] id:" + parambkv.id + ", promoting:" + parambkv.ZTV + ",errCode:" + parama.errCode);
    paramh = ah.aiuX;
    AppMethodBeat.o(358717);
    return paramh;
  }
  
  private static final void a(h paramh, Context paramContext, bkv parambkv, View paramView)
  {
    AppMethodBeat.i(358661);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramContext);
    localb.cH(parambkv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.s(paramContext, "context");
    new com.tencent.mm.plugin.finder.live.cgi.s(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramh.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramh.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, parambkv).bFJ().g(new h..ExternalSyntheticLambda3(paramh, parambkv, paramContext));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358661);
  }
  
  private static final void a(h paramh, bkv parambkv)
  {
    AppMethodBeat.i(358650);
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(parambkv, "$data");
    LinkedList localLinkedList = paramh.DQf;
    kotlin.g.b.s.checkNotNull(localLinkedList);
    localLinkedList.remove(0);
    localLinkedList = paramh.DQf;
    kotlin.g.b.s.checkNotNull(localLinkedList);
    localLinkedList.add(0, parambkv);
    paramh.fV(0);
    AppMethodBeat.o(358650);
  }
  
  private static final void a(bkv parambkv, Context paramContext, h paramh)
  {
    AppMethodBeat.i(358695);
    kotlin.g.b.s.u(parambkv, "$item");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramh, "this$0");
    if (parambkv.ZTV) {
      aa.y(paramContext, paramContext.getResources().getString(p.h.CrG), am.f.icons_filled_done);
    }
    b.b.a(paramh.nfT, b.c.ndK);
    AppMethodBeat.o(358695);
  }
  
  private static final boolean a(h paramh, a parama, View paramView)
  {
    AppMethodBeat.i(358683);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    kotlin.g.b.s.u(parama, "$holder");
    paramh = paramh.DQi;
    if (paramh != null)
    {
      localObject = paramView.getTag();
      if (localObject == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLivePromoteInfoAnchor");
        AppMethodBeat.o(358683);
        throw paramh;
      }
      localObject = (bkv)localObject;
      kotlin.g.b.s.s(paramView, "view");
      paramh.invoke(localObject, paramView, Integer.valueOf(parama.KJ()));
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(358683);
    return true;
  }
  
  private static final void e(Context paramContext, View paramView)
  {
    AppMethodBeat.i(358669);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    aa.showTextToast(paramContext, paramContext.getResources().getString(p.h.CrF));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358669);
  }
  
  private final int evL()
  {
    AppMethodBeat.i(358633);
    int i = ((Number)this.DQg.getValue()).intValue();
    AppMethodBeat.o(358633);
    return i;
  }
  
  private final int evM()
  {
    AppMethodBeat.i(358641);
    int i = ((Number)this.DQh.getValue()).intValue();
    AppMethodBeat.o(358641);
    return i;
  }
  
  public final void a(bkv parambkv)
  {
    AppMethodBeat.i(358785);
    kotlin.g.b.s.u(parambkv, "data");
    if (this.DQf == null) {
      this.DQf = new LinkedList();
    }
    Object localObject = this.DQf;
    kotlin.g.b.s.checkNotNull(localObject);
    bkv localbkv = new bkv();
    localbkv.type = -1000;
    ah localah = ah.aiuX;
    ((LinkedList)localObject).add(0, localbkv);
    fW(0);
    localObject = this.mRecyclerView;
    if (localObject != null) {
      ((RecyclerView)localObject).postDelayed(new h..ExternalSyntheticLambda4(this, parambkv), 1000L);
    }
    AppMethodBeat.o(358785);
  }
  
  public final boolean b(bkw parambkw)
  {
    Object localObject2 = null;
    bkx localbkx = null;
    AppMethodBeat.i(358777);
    kotlin.g.b.s.u(parambkw, "info");
    Object localObject1 = this.DQf;
    if (localObject1 == null) {
      localObject1 = localbkx;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(358777);
      return false;
      Object localObject3 = ((Iterable)localObject1).iterator();
      label59:
      int i;
      label95:
      label99:
      bkv localbkv;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        if (((bkv)localObject1).type == parambkw.type)
        {
          i = 1;
          if (i == 0) {
            break label147;
          }
          localbkv = (bkv)localObject1;
          localObject1 = localbkx;
          if (localbkv == null) {
            continue;
          }
          if ((localbkv.type != 1) && (localbkv.type != 3)) {
            break label155;
          }
        }
      }
      for (bool = true;; bool = false) {
        for (;;)
        {
          localObject1 = Boolean.valueOf(bool);
          break;
          i = 0;
          break label95;
          label147:
          break label59;
          localObject1 = null;
          break label99;
          label155:
          if (localbkv.type == 2)
          {
            localbkx = new bkx();
            localObject3 = (com.tencent.mm.bx.a)localbkx;
            localObject1 = localbkv.ZTU;
            if (localObject1 == null) {
              localObject1 = null;
            }
            try
            {
              ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
              localObject1 = new bkx();
              localObject3 = (com.tencent.mm.bx.a)localObject1;
              parambkw = parambkw.ZTX;
              if (parambkw == null) {
                parambkw = localObject2;
              }
            }
            catch (Exception localException)
            {
              try
              {
                for (;;)
                {
                  ((com.tencent.mm.bx.a)localObject3).parseFrom(parambkw);
                  bool = kotlin.g.b.s.p(localbkx.url, ((bkx)localObject1).url);
                  break;
                  localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray();
                  continue;
                  localException = localException;
                  Log.printDebugStack("safeParser", "", new Object[] { localException });
                  continue;
                  parambkw = parambkw.toByteArray();
                }
              }
              catch (Exception parambkw)
              {
                for (;;)
                {
                  Log.printDebugStack("safeParser", "", new Object[] { parambkw });
                }
              }
            }
          }
        }
      }
    }
    boolean bool = localException.booleanValue();
    AppMethodBeat.o(358777);
    return bool;
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(358766);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.mRecyclerView = paramRecyclerView;
    AppMethodBeat.o(358766);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358792);
    LinkedList localLinkedList = this.DQf;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(358792);
      return 0;
    }
    int i = localLinkedList.size();
    AppMethodBeat.o(358792);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter$PromotionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorPromoteInfoAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(358873);
      AppMethodBeat.o(358873);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b DQk;
    
    static
    {
      AppMethodBeat.i(358881);
      DQk = new b();
      AppMethodBeat.o(358881);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c DQl;
    
    static
    {
      AppMethodBeat.i(358883);
      DQl = new c();
      AppMethodBeat.o(358883);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.h
 * JD-Core Version:    0.7.0.1
 */