package com.tencent.mm.plugin.gamelife.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$ConversationViewHolder;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider$Delegate;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "getDataList", "()Ljava/util/LinkedList;", "interactionMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameInteractionNotifyMsgViewProvider;", "normalViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationNormalViewProvider;", "value", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "onItemClickListener", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;)V", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "onLongClickListener", "getOnLongClickListener", "()Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;)V", "serviceMsgViewProvider", "Lcom/tencent/mm/plugin/gamelife/ui/GameServiceNotifyMsgViewProvider;", "viewProvider", "", "", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationViewProvider;", "dataPosToListPos", "dataPos", "deleteConversation", "", "conversation", "getDataListNum", "getItem", "pos", "getItemCount", "getItemViewType", "position", "insertOrUpdateConversation", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "refreshGameCenterMsg", "refreshList", "data", "", "replaceConversation", "reportConversationItemExpose", "item", "submitList", "Companion", "ConversationViewHolder", "OnItemClickListener", "OnItemLongClickListener", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<b.b>
  implements f.a
{
  public static final b.a JbW;
  final d JbX;
  final a JbY;
  final g JbZ;
  private final Map<Integer, f> Jca;
  c Jcb;
  d Jcc;
  final LinkedList<com.tencent.mm.plugin.gamelife.f.a> vEn;
  
  static
  {
    AppMethodBeat.i(267908);
    JbW = new b.a((byte)0);
    AppMethodBeat.o(267908);
  }
  
  public b()
  {
    AppMethodBeat.i(267896);
    this.JbX = new d((f.a)this);
    this.JbY = new a((f.a)this);
    this.JbZ = new g((f.a)this);
    this.Jca = ak.e(new r[] { v.Y(Integer.valueOf(0), this.JbX), v.Y(Integer.valueOf(1), this.JbY), v.Y(Integer.valueOf(2), this.JbZ) });
    this.vEn = new LinkedList();
    AppMethodBeat.o(267896);
  }
  
  public final com.tencent.mm.plugin.gamelife.f.a XT(int paramInt)
  {
    AppMethodBeat.i(267961);
    Object localObject = this.vEn.get(paramInt - 2);
    s.s(localObject, "dataList[pos - EXTRA_VIEW_COUNT]");
    localObject = (com.tencent.mm.plugin.gamelife.f.a)localObject;
    AppMethodBeat.o(267961);
    return localObject;
  }
  
  public final void b(final com.tencent.mm.plugin.gamelife.f.a parama)
  {
    AppMethodBeat.i(267936);
    s.u(parama, "conversation");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, parama));
    AppMethodBeat.o(267936);
  }
  
  public final int fIy()
  {
    AppMethodBeat.i(267967);
    int i = this.vEn.size();
    AppMethodBeat.o(267967);
    return i;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(267929);
    int i = this.vEn.size();
    AppMethodBeat.o(267929);
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
  
  public final void iu(final List<com.tencent.mm.plugin.gamelife.f.a> paramList)
  {
    AppMethodBeat.i(267950);
    s.u(paramList, "data");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramList));
    AppMethodBeat.o(267950);
  }
  
  public final void iv(final List<com.tencent.mm.plugin.gamelife.f.a> paramList)
  {
    AppMethodBeat.i(267954);
    s.u(paramList, "data");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, paramList));
    AppMethodBeat.o(267954);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "pos", "", "conversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(View paramView, com.tencent.mm.plugin.gamelife.f.a parama);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "totalDataNum", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.f.a parama, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b paramb, com.tencent.mm.plugin.gamelife.f.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(b paramb, com.tencent.mm.plugin.gamelife.f.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(b paramb, List<com.tencent.mm.plugin.gamelife.f.a> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(b paramb, com.tencent.mm.plugin.gamelife.f.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(b paramb, List<com.tencent.mm.plugin.gamelife.f.a> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.b
 * JD-Core Version:    0.7.0.1
 */