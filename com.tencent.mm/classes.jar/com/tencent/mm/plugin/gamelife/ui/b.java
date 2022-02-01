package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "getDataList", "()Ljava/util/LinkedList;", "interactionMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "normalViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "value", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClickListener", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "serviceMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "viewProvider", "", "", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "dataPosToListPos", "dataPos", "deleteConversation", "", "conversation", "getDataListNum", "getItem", "pos", "getItemCount", "getItemViewType", "position", "insertOrUpdateConversation", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "refreshGameCenterMsg", "refreshList", "data", "", "replaceConversation", "reportConversationItemExpose", "item", "submitList", "Companion", "ConversationViewHolder", "OnItemClickListener", "OnItemLongClickListener", "plugin-gamelife_release"})
public final class b
  extends RecyclerView.a<b.b>
  implements f.a
{
  public static final b.a Dim;
  final d Dig;
  final a Dih;
  final g Dii;
  private final Map<Integer, f> Dij;
  c Dik;
  d Dil;
  final LinkedList<com.tencent.mm.plugin.gamelife.e.a> syG;
  
  static
  {
    AppMethodBeat.i(202867);
    Dim = new b.a((byte)0);
    AppMethodBeat.o(202867);
  }
  
  public b()
  {
    AppMethodBeat.i(202865);
    this.Dig = new d((f.a)this);
    this.Dih = new a((f.a)this);
    this.Dii = new g((f.a)this);
    this.Dij = ae.e(new o[] { s.M(Integer.valueOf(0), this.Dig), s.M(Integer.valueOf(1), this.Dih), s.M(Integer.valueOf(2), this.Dii) });
    this.syG = new LinkedList();
    AppMethodBeat.o(202865);
  }
  
  public final com.tencent.mm.plugin.gamelife.e.a TY(int paramInt)
  {
    AppMethodBeat.i(202860);
    Object localObject = this.syG.get(paramInt - 2);
    p.j(localObject, "dataList[pos - EXTRA_VIEW_COUNT]");
    localObject = (com.tencent.mm.plugin.gamelife.e.a)localObject;
    AppMethodBeat.o(202860);
    return localObject;
  }
  
  public final void b(final com.tencent.mm.plugin.gamelife.e.a parama)
  {
    AppMethodBeat.i(202849);
    p.k(parama, "conversation");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, parama));
    AppMethodBeat.o(202849);
  }
  
  public final void dZ(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(202853);
    p.k(paramList, "data");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, paramList));
    AppMethodBeat.o(202853);
  }
  
  public final int eAx()
  {
    AppMethodBeat.i(292721);
    int i = this.syG.size();
    AppMethodBeat.o(292721);
    return i;
  }
  
  public final void fy(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(202851);
    p.k(paramList, "data");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramList));
    AppMethodBeat.o(202851);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(202847);
    int i = this.syG.size();
    AppMethodBeat.o(202847);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.gamelife.e.a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "totalDataNum", "plugin-gamelife_release"})
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(b paramb, List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.b
 * JD-Core Version:    0.7.0.1
 */