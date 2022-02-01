package com.tencent.mm.plugin.gamelife.ui;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.view.recyclerview.e;
import d.a.ae;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "getDataList", "()Ljava/util/LinkedList;", "interactionMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "normalViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "value", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClickListener", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "serviceMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "viewProvider", "", "", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "dataPosToListPos", "dataPos", "deleteConversation", "", "conversation", "getDataListNum", "getItem", "pos", "getItemCount", "getItemViewType", "position", "insertOrUpdateConversation", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "refreshList", "data", "", "replaceConversation", "reportConversationItemExpose", "item", "submitList", "viewResume", "Companion", "ConversationViewHolder", "OnItemClickListener", "OnItemLongClickListener", "plugin-gamelife_release"})
public final class b
  extends RecyclerView.a<b>
  implements f.a
{
  public static final a uyJ;
  final LinkedList<com.tencent.mm.plugin.gamelife.e.a> nZa;
  final d uyD;
  final a uyE;
  final g uyF;
  private final Map<Integer, f> uyG;
  c uyH;
  d uyI;
  
  static
  {
    AppMethodBeat.i(211431);
    uyJ = new a((byte)0);
    AppMethodBeat.o(211431);
  }
  
  public b()
  {
    AppMethodBeat.i(211430);
    this.uyD = new d((f.a)this);
    this.uyE = new a((f.a)this);
    this.uyF = new g((f.a)this);
    this.uyG = ae.a(new o[] { u.S(Integer.valueOf(0), this.uyD), u.S(Integer.valueOf(1), this.uyE), u.S(Integer.valueOf(2), this.uyF) });
    this.nZa = new LinkedList();
    AppMethodBeat.o(211430);
  }
  
  public final com.tencent.mm.plugin.gamelife.e.a Ie(int paramInt)
  {
    AppMethodBeat.i(211428);
    Object localObject = this.nZa.get(paramInt - 2);
    p.g(localObject, "dataList[pos - EXTRA_VIEW_COUNT]");
    localObject = (com.tencent.mm.plugin.gamelife.e.a)localObject;
    AppMethodBeat.o(211428);
    return localObject;
  }
  
  public final int daM()
  {
    AppMethodBeat.i(221746);
    int i = this.nZa.size();
    AppMethodBeat.o(221746);
    return i;
  }
  
  public final void dz(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(211426);
    p.h(paramList, "data");
    c.g((d.g.a.a)new i(this, paramList));
    AppMethodBeat.o(211426);
  }
  
  public final void eh(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(211425);
    p.h(paramList, "data");
    c.g((d.g.a.a)new g(this, paramList));
    AppMethodBeat.o(211425);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(211424);
    int i = this.nZa.size();
    AppMethodBeat.o(211424);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$Companion;", "", "()V", "EXTRA_VIEW_COUNT", "", "TAG", "", "VIEW_TYPE_INTERACTION_NOTIFY", "VIEW_TYPE_NORMAL", "VIEW_TYPE_SERVICE_NOTIFY", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-gamelife_release"})
  public static final class b
    extends e
  {
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(211416);
      AppMethodBeat.o(211416);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.gamelife.e.a parama);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "totalDataNum", "plugin-gamelife_release"})
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(b paramb, List paramList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<z>
  {
    i(b paramb, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.b
 * JD-Core Version:    0.7.0.1
 */