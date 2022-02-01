package com.tencent.mm.plugin.gamelife.ui;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "getDataList", "()Ljava/util/LinkedList;", "interactionMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "normalViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "value", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClickListener", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "serviceMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "viewProvider", "", "", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "dataPosToListPos", "dataPos", "deleteConversation", "", "conversation", "getDataListNum", "getItem", "pos", "getItemCount", "getItemViewType", "position", "insertOrUpdateConversation", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "refreshGameCenterMsg", "refreshList", "data", "", "replaceConversation", "reportConversationItemExpose", "item", "submitList", "Companion", "ConversationViewHolder", "OnItemClickListener", "OnItemLongClickListener", "plugin-gamelife_release"})
public final class b
  extends RecyclerView.a<b.b>
  implements f.a
{
  public static final b.a ycH;
  final LinkedList<com.tencent.mm.plugin.gamelife.e.a> ppH;
  final d ycB;
  private final a ycC;
  private final g ycD;
  private final Map<Integer, f> ycE;
  c ycF;
  d ycG;
  
  static
  {
    AppMethodBeat.i(241453);
    ycH = new b.a((byte)0);
    AppMethodBeat.o(241453);
  }
  
  public b()
  {
    AppMethodBeat.i(241452);
    this.ycB = new d((f.a)this);
    this.ycC = new a((f.a)this);
    this.ycD = new g((f.a)this);
    this.ycE = ae.e(new o[] { s.U(Integer.valueOf(0), this.ycB), s.U(Integer.valueOf(1), this.ycC), s.U(Integer.valueOf(2), this.ycD) });
    this.ppH = new LinkedList();
    AppMethodBeat.o(241452);
  }
  
  public final com.tencent.mm.plugin.gamelife.e.a OD(int paramInt)
  {
    AppMethodBeat.i(241450);
    Object localObject = this.ppH.get(paramInt - 2);
    p.g(localObject, "dataList[pos - EXTRA_VIEW_COUNT]");
    localObject = (com.tencent.mm.plugin.gamelife.e.a)localObject;
    AppMethodBeat.o(241450);
    return localObject;
  }
  
  public final void b(final com.tencent.mm.plugin.gamelife.e.a parama)
  {
    AppMethodBeat.i(241445);
    p.h(parama, "conversation");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, parama));
    AppMethodBeat.o(241445);
  }
  
  public final void dR(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(241447);
    p.h(paramList, "data");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new i(this, paramList));
    AppMethodBeat.o(241447);
  }
  
  public final void dXn()
  {
    AppMethodBeat.i(241448);
    this.ycC.refreshView();
    g localg = this.ycD;
    b.b localb = localg.ycy;
    if (localb != null)
    {
      localg.a(localb, 0);
      AppMethodBeat.o(241448);
      return;
    }
    AppMethodBeat.o(241448);
  }
  
  public final int dXo()
  {
    AppMethodBeat.i(258734);
    int i = this.ppH.size();
    AppMethodBeat.o(258734);
    return i;
  }
  
  public final void fe(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(241446);
    p.h(paramList, "data");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this, paramList));
    AppMethodBeat.o(241446);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(241444);
    int i = this.ppH.size();
    AppMethodBeat.o(241444);
    return i + 2;
  }
  
  public final int getItemViewType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.gamelife.e.a parama);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "totalDataNum", "plugin-gamelife_release"})
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(b paramb, List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(b paramb, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.b
 * JD-Core Version:    0.7.0.1
 */