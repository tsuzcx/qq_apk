package com.tencent.mm.plugin.gamelife.ui;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "getDataList", "()Ljava/util/LinkedList;", "interactionMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "normalViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "value", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClickListener", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "serviceMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "viewProvider", "", "", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "dataPosToListPos", "dataPos", "deleteConversation", "", "conversation", "getDataListNum", "getItem", "pos", "getItemCount", "getItemViewType", "position", "insertOrUpdateConversation", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "refreshList", "data", "", "replaceConversation", "reportConversationItemExpose", "item", "submitList", "viewResume", "Companion", "ConversationViewHolder", "OnItemClickListener", "OnItemLongClickListener", "plugin-gamelife_release"})
public final class b
  extends RecyclerView.a<b>
  implements f.a
{
  public static final b.a uKm;
  final LinkedList<com.tencent.mm.plugin.gamelife.e.a> oeJ;
  final d uKg;
  final a uKh;
  final g uKi;
  private final Map<Integer, f> uKj;
  c uKk;
  d uKl;
  
  static
  {
    AppMethodBeat.i(212210);
    uKm = new b.a((byte)0);
    AppMethodBeat.o(212210);
  }
  
  public b()
  {
    AppMethodBeat.i(212209);
    this.uKg = new d((f.a)this);
    this.uKh = new a((f.a)this);
    this.uKi = new g((f.a)this);
    this.uKj = ae.a(new o[] { u.R(Integer.valueOf(0), this.uKg), u.R(Integer.valueOf(1), this.uKh), u.R(Integer.valueOf(2), this.uKi) });
    this.oeJ = new LinkedList();
    AppMethodBeat.o(212209);
  }
  
  public final com.tencent.mm.plugin.gamelife.e.a IC(int paramInt)
  {
    AppMethodBeat.i(212207);
    Object localObject = this.oeJ.get(paramInt - 2);
    p.g(localObject, "dataList[pos - EXTRA_VIEW_COUNT]");
    localObject = (com.tencent.mm.plugin.gamelife.e.a)localObject;
    AppMethodBeat.o(212207);
    return localObject;
  }
  
  public final void b(final com.tencent.mm.plugin.gamelife.e.a parama)
  {
    AppMethodBeat.i(212203);
    p.h(parama, "conversation");
    c.h((d.g.a.a)new h(this, parama));
    AppMethodBeat.o(212203);
  }
  
  public final void dC(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(212205);
    p.h(paramList, "data");
    c.h((d.g.a.a)new i(this, paramList));
    AppMethodBeat.o(212205);
  }
  
  public final int ddD()
  {
    AppMethodBeat.i(224514);
    int i = this.oeJ.size();
    AppMethodBeat.o(224514);
    return i;
  }
  
  public final void el(final List<com.tencent.mm.plugin.gamelife.e.a> paramList)
  {
    AppMethodBeat.i(212204);
    p.h(paramList, "data");
    c.h((d.g.a.a)new g(this, paramList));
    AppMethodBeat.o(212204);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(212202);
    int i = this.oeJ.size();
    AppMethodBeat.o(212202);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "plugin-gamelife_release"})
  public static final class b
    extends e
  {
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(212194);
      AppMethodBeat.o(212194);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"})
  public static abstract interface c
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.gamelife.e.a parama);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "totalDataNum", "plugin-gamelife_release"})
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(b paramb, List paramList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(b paramb, com.tencent.mm.plugin.gamelife.e.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.b
 * JD-Core Version:    0.7.0.1
 */