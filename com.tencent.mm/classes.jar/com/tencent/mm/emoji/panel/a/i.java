package com.tencent.mm.emoji.panel.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.q;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.plugin.m.a.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "()V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Lkotlin/collections/ArrayList;", "addData", "", "items", "", "addDataByIndex", "index", "", "item", "clearData", "getItem", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ListenerToAdapter", "plugin-emojisdk_release"})
public class i
  extends RecyclerView.a<s<?>>
{
  private final String TAG;
  public final ArrayList<com.tencent.mm.emoji.b.b.ae> jFL;
  public p jLP;
  
  public i()
  {
    AppMethodBeat.i(105665);
    this.TAG = "MicroMsg.EmojiPanelItemAdapter";
    this.jFL = new ArrayList();
    AppMethodBeat.o(105665);
  }
  
  public final void a(int paramInt, com.tencent.mm.emoji.b.b.ae paramae)
  {
    AppMethodBeat.i(105657);
    kotlin.g.b.p.k(paramae, "item");
    this.jFL.add(paramInt, paramae);
    AppMethodBeat.o(105657);
  }
  
  public void a(s<?> params, int paramInt)
  {
    AppMethodBeat.i(105663);
    kotlin.g.b.p.k(params, "holder");
    Object localObject = this.jFL.get(paramInt);
    kotlin.g.b.p.j(localObject, "itemList[position]");
    params.a((com.tencent.mm.emoji.b.b.ae)localObject);
    AppMethodBeat.o(105663);
  }
  
  public final void aa(List<? extends com.tencent.mm.emoji.b.b.ae> paramList)
  {
    AppMethodBeat.i(105656);
    kotlin.g.b.p.k(paramList, "items");
    this.jFL.clear();
    this.jFL.addAll((Collection)paramList);
    AppMethodBeat.o(105656);
  }
  
  public s<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105661);
    kotlin.g.b.p.k(paramViewGroup, "parent");
    Object localObject = q.jJK;
    localObject = q.rD(paramInt);
    if (localObject != null)
    {
      paramViewGroup = ((com.tencent.mm.emoji.b.b.p)localObject).e(paramViewGroup);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_emoji, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new l(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 1: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_smiley, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new ae(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 2: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_title, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new ag(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 3: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.smiley_grid_item_entrance, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new m(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 4: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_expand, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new n(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 9: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_sync, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new o(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 5: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.smiley_grid_item_tail, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = new s(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 8: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_load_more, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new d(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 6: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_emoji_loading, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new b(paramViewGroup, this.jLP);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    paramViewGroup = ((LayoutInflater)localObject).inflate(a.h.emoji_panel_item_capture_empty, paramViewGroup, false);
    kotlin.g.b.p.j(paramViewGroup, "itemView");
    paramViewGroup = (s)new a(paramViewGroup, this.jLP);
    AppMethodBeat.o(105661);
    return paramViewGroup;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105659);
    int i = this.jFL.size();
    AppMethodBeat.o(105659);
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105660);
    com.tencent.mm.emoji.b.b.ae localae = rF(paramInt);
    if (localae != null)
    {
      paramInt = localae.type;
      AppMethodBeat.o(105660);
      return paramInt;
    }
    AppMethodBeat.o(105660);
    return 0;
  }
  
  public final com.tencent.mm.emoji.b.b.ae rF(int paramInt)
  {
    AppMethodBeat.i(105658);
    com.tencent.mm.emoji.b.b.ae localae = (com.tencent.mm.emoji.b.b.ae)j.M((List)this.jFL, paramInt);
    AppMethodBeat.o(105658);
    return localae;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;)V", "onGroupItemsChange", "", "start", "", "count", "onGroupItemsInsert", "onGroupItemsMoved", "from", "to", "onGroupItemsRemove", "onUpdateData", "data", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "plugin-emojisdk_release"})
  public static class a
    implements ac
  {
    private final i jLV;
    
    public a(i parami)
    {
      AppMethodBeat.i(105655);
      this.jLV = parami;
      AppMethodBeat.o(105655);
    }
    
    public void b(y paramy)
    {
      AppMethodBeat.i(105650);
      kotlin.g.b.p.k(paramy, "data");
      this.jLV.aa(paramy.aCj());
      AppMethodBeat.o(105650);
    }
    
    public final void cX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105651);
      this.jLV.aG(paramInt1, paramInt2);
      AppMethodBeat.o(105651);
    }
    
    public final void cY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105652);
      this.jLV.aH(paramInt1, paramInt2);
      AppMethodBeat.o(105652);
    }
    
    public final void cZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105653);
      this.jLV.aF(paramInt1, paramInt2);
      AppMethodBeat.o(105653);
    }
    
    public final void da(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105654);
      this.jLV.aE(paramInt1, paramInt2);
      AppMethodBeat.o(105654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.i
 * JD-Core Version:    0.7.0.1
 */