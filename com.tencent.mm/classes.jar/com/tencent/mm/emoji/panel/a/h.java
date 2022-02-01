package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.aa;
import com.tencent.mm.emoji.b.b.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "()V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Lkotlin/collections/ArrayList;", "addData", "", "items", "", "addDataByIndex", "index", "", "item", "clearData", "getItem", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ListenerToAdapter", "plugin-emojisdk_release"})
public class h
  extends RecyclerView.a<q<?>>
{
  private final String TAG;
  public final ArrayList<com.tencent.mm.emoji.b.b.ac> gUV;
  public n haK;
  
  public h()
  {
    AppMethodBeat.i(105665);
    this.TAG = "MicroMsg.EmojiPanelItemAdapter";
    this.gUV = new ArrayList();
    AppMethodBeat.o(105665);
  }
  
  public final void a(int paramInt, com.tencent.mm.emoji.b.b.ac paramac)
  {
    AppMethodBeat.i(105657);
    kotlin.g.b.p.h(paramac, "item");
    this.gUV.add(paramInt, paramac);
    AppMethodBeat.o(105657);
  }
  
  public void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105663);
    kotlin.g.b.p.h(paramq, "holder");
    Object localObject = this.gUV.get(paramInt);
    kotlin.g.b.p.g(localObject, "itemList[position]");
    paramq.a((com.tencent.mm.emoji.b.b.ac)localObject);
    AppMethodBeat.o(105663);
  }
  
  public final void ad(List<? extends com.tencent.mm.emoji.b.b.ac> paramList)
  {
    AppMethodBeat.i(105656);
    kotlin.g.b.p.h(paramList, "items");
    this.gUV.clear();
    this.gUV.addAll((Collection)paramList);
    AppMethodBeat.o(105656);
  }
  
  public q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105661);
    kotlin.g.b.p.h(paramViewGroup, "parent");
    Object localObject = com.tencent.mm.emoji.b.b.q.gYK;
    localObject = com.tencent.mm.emoji.b.b.q.pk(paramInt);
    if (localObject != null)
    {
      paramViewGroup = ((com.tencent.mm.emoji.b.b.p)localObject).d(paramViewGroup);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493930, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new k(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 1: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493937, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new ac(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 2: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493938, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new ae(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 3: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131496353, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new l(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 4: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493932, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new m(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 5: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131496354, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = new q(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 6: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493931, paramViewGroup, false);
      kotlin.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new b(paramViewGroup, this.haK);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    paramViewGroup = ((LayoutInflater)localObject).inflate(2131493929, paramViewGroup, false);
    kotlin.g.b.p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new a(paramViewGroup, this.haK);
    AppMethodBeat.o(105661);
    return paramViewGroup;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105659);
    int i = this.gUV.size();
    AppMethodBeat.o(105659);
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105660);
    com.tencent.mm.emoji.b.b.ac localac = pm(paramInt);
    if (localac != null)
    {
      paramInt = localac.type;
      AppMethodBeat.o(105660);
      return paramInt;
    }
    AppMethodBeat.o(105660);
    return 0;
  }
  
  public final com.tencent.mm.emoji.b.b.ac pm(int paramInt)
  {
    AppMethodBeat.i(105658);
    com.tencent.mm.emoji.b.b.ac localac = (com.tencent.mm.emoji.b.b.ac)j.L((List)this.gUV, paramInt);
    AppMethodBeat.o(105658);
    return localac;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;)V", "onGroupItemsChange", "", "start", "", "count", "onGroupItemsInsert", "onGroupItemsMoved", "from", "to", "onGroupItemsRemove", "onUpdateData", "data", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "plugin-emojisdk_release"})
  public static final class a
    implements aa
  {
    private final h haQ;
    
    public a(h paramh)
    {
      AppMethodBeat.i(105655);
      this.haQ = paramh;
      AppMethodBeat.o(105655);
    }
    
    public final void b(w paramw)
    {
      AppMethodBeat.i(105650);
      kotlin.g.b.p.h(paramw, "data");
      this.haQ.ad(paramw.avn());
      AppMethodBeat.o(105650);
    }
    
    public final void cD(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105651);
      this.haQ.as(paramInt1, paramInt2);
      AppMethodBeat.o(105651);
    }
    
    public final void cE(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105652);
      this.haQ.at(paramInt1, paramInt2);
      AppMethodBeat.o(105652);
    }
    
    public final void cF(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105653);
      this.haQ.ar(paramInt1, paramInt2);
      AppMethodBeat.o(105653);
    }
    
    public final void cG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105654);
      this.haQ.aq(paramInt1, paramInt2);
      AppMethodBeat.o(105654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.h
 * JD-Core Version:    0.7.0.1
 */