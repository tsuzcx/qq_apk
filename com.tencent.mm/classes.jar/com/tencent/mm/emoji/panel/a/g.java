package com.tencent.mm.emoji.panel.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.y;
import com.tencent.mm.plugin.m.a.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "()V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Lkotlin/collections/ArrayList;", "addData", "", "items", "", "addDataByIndex", "index", "", "item", "clearData", "getItem", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ListenerToAdapter", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  extends RecyclerView.a<q<?>>
{
  private final String TAG;
  public final ArrayList<com.tencent.mm.emoji.c.b.ae> mfy;
  public n mkY;
  
  public g()
  {
    AppMethodBeat.i(105665);
    this.TAG = "MicroMsg.EmojiPanelItemAdapter";
    this.mfy = new ArrayList();
    AppMethodBeat.o(105665);
  }
  
  public final void a(int paramInt, com.tencent.mm.emoji.c.b.ae paramae)
  {
    AppMethodBeat.i(105657);
    s.u(paramae, "item");
    this.mfy.add(paramInt, paramae);
    AppMethodBeat.o(105657);
  }
  
  public void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105663);
    s.u(paramq, "holder");
    Object localObject = this.mfy.get(paramInt);
    s.s(localObject, "itemList[position]");
    paramq.a((com.tencent.mm.emoji.c.b.ae)localObject);
    AppMethodBeat.o(105663);
  }
  
  public final void bz(List<? extends com.tencent.mm.emoji.c.b.ae> paramList)
  {
    AppMethodBeat.i(105656);
    s.u(paramList, "items");
    this.mfy.clear();
    this.mfy.addAll((Collection)paramList);
    AppMethodBeat.o(105656);
  }
  
  public q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105661);
    s.u(paramViewGroup, "parent");
    Object localObject = com.tencent.mm.emoji.c.b.q.mja;
    localObject = com.tencent.mm.emoji.c.b.q.rF(paramInt);
    if (localObject != null)
    {
      paramViewGroup = ((com.tencent.mm.emoji.c.b.p)localObject).h(paramViewGroup);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_emoji, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new j(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 1: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_smiley, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new ac(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 2: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_title, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new ae(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 3: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.smiley_grid_item_entrance, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new k(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 4: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_expand, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new l(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 9: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_sync, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new m(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 5: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.smiley_grid_item_tail, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = new q(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 8: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_load_more, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new c(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 6: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_emoji_loading, paramViewGroup, false);
      s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new b(paramViewGroup, this.mkY);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_capture_empty, paramViewGroup, false);
    s.s(paramViewGroup, "itemView");
    paramViewGroup = (q)new a(paramViewGroup, this.mkY);
    AppMethodBeat.o(105661);
    return paramViewGroup;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105659);
    int i = this.mfy.size();
    AppMethodBeat.o(105659);
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105660);
    com.tencent.mm.emoji.c.b.ae localae = rH(paramInt);
    if (localae == null)
    {
      AppMethodBeat.o(105660);
      return 0;
    }
    paramInt = localae.type;
    AppMethodBeat.o(105660);
    return paramInt;
  }
  
  public final com.tencent.mm.emoji.c.b.ae rH(int paramInt)
  {
    AppMethodBeat.i(105658);
    com.tencent.mm.emoji.c.b.ae localae = (com.tencent.mm.emoji.c.b.ae)kotlin.a.p.ae((List)this.mfy, paramInt);
    AppMethodBeat.o(105658);
    return localae;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;)V", "onGroupItemsChange", "", "start", "", "count", "onGroupItemsInsert", "onGroupItemsMoved", "from", "to", "onGroupItemsRemove", "onUpdateData", "data", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class a
    implements com.tencent.mm.emoji.c.b.ac
  {
    private final g mlb;
    
    public a(g paramg)
    {
      AppMethodBeat.i(105655);
      this.mlb = paramg;
      AppMethodBeat.o(105655);
    }
    
    public void b(y paramy)
    {
      AppMethodBeat.i(105650);
      s.u(paramy, "data");
      this.mlb.bz(paramy.aVf());
      AppMethodBeat.o(105650);
    }
    
    public final void dK(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105651);
      this.mlb.bA(paramInt1, paramInt2);
      AppMethodBeat.o(105651);
    }
    
    public final void dL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105652);
      this.mlb.bB(paramInt1, paramInt2);
      AppMethodBeat.o(105652);
    }
    
    public final void dM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105653);
      this.mlb.bz(paramInt1, paramInt2);
      AppMethodBeat.o(105653);
    }
    
    public final void dN(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105654);
      this.mlb.by(paramInt1, paramInt2);
      AppMethodBeat.o(105654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.g
 * JD-Core Version:    0.7.0.1
 */