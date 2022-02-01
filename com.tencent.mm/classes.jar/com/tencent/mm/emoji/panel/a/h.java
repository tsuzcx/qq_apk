package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.aa;
import com.tencent.mm.emoji.a.a.ac;
import d.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "()V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Lkotlin/collections/ArrayList;", "addData", "", "items", "", "addDataByIndex", "index", "", "item", "getItem", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ListenerToAdapter", "plugin-emojisdk_release"})
public class h
  extends RecyclerView.a<q<?>>
{
  private final String TAG;
  private final ArrayList<ac> gnG;
  public n gnv;
  
  public h()
  {
    AppMethodBeat.i(105665);
    this.TAG = "MicroMsg.EmojiPanelItemAdapter";
    this.gnG = new ArrayList();
    AppMethodBeat.o(105665);
  }
  
  public final void V(List<? extends ac> paramList)
  {
    AppMethodBeat.i(105656);
    d.g.b.p.h(paramList, "items");
    this.gnG.clear();
    this.gnG.addAll((Collection)paramList);
    AppMethodBeat.o(105656);
  }
  
  public final void a(int paramInt, ac paramac)
  {
    AppMethodBeat.i(105657);
    d.g.b.p.h(paramac, "item");
    this.gnG.add(paramInt, paramac);
    AppMethodBeat.o(105657);
  }
  
  public void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105663);
    d.g.b.p.h(paramq, "holder");
    Object localObject = this.gnG.get(paramInt);
    d.g.b.p.g(localObject, "itemList[position]");
    paramq.a((ac)localObject);
    AppMethodBeat.o(105663);
  }
  
  public q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105661);
    d.g.b.p.h(paramViewGroup, "parent");
    Object localObject = com.tencent.mm.emoji.a.a.q.glu;
    localObject = com.tencent.mm.emoji.a.a.q.lZ(paramInt);
    if (localObject != null)
    {
      paramViewGroup = ((com.tencent.mm.emoji.a.a.p)localObject).d(paramViewGroup);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493781, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new k(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 1: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493784, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new w(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 2: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493785, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new y(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 3: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131495478, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new l(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 4: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493783, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new m(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 5: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131495479, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = new q(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 6: 
      paramViewGroup = ((LayoutInflater)localObject).inflate(2131493782, paramViewGroup, false);
      d.g.b.p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new b(paramViewGroup, this.gnv);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    paramViewGroup = ((LayoutInflater)localObject).inflate(2131493780, paramViewGroup, false);
    d.g.b.p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new a(paramViewGroup, this.gnv);
    AppMethodBeat.o(105661);
    return paramViewGroup;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105659);
    int i = this.gnG.size();
    AppMethodBeat.o(105659);
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105660);
    ac localac = mb(paramInt);
    if (localac != null)
    {
      paramInt = localac.type;
      AppMethodBeat.o(105660);
      return paramInt;
    }
    AppMethodBeat.o(105660);
    return 0;
  }
  
  public final ac mb(int paramInt)
  {
    AppMethodBeat.i(105658);
    ac localac = (ac)j.E((List)this.gnG, paramInt);
    AppMethodBeat.o(105658);
    return localac;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;)V", "onGroupItemsChange", "", "start", "", "count", "onGroupItemsInsert", "onGroupItemsMoved", "from", "to", "onGroupItemsRemove", "onUpdateData", "data", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "plugin-emojisdk_release"})
  public static final class a
    implements aa
  {
    private final h gnz;
    
    public a(h paramh)
    {
      AppMethodBeat.i(105655);
      this.gnz = paramh;
      AppMethodBeat.o(105655);
    }
    
    public final void b(com.tencent.mm.emoji.a.a.w paramw)
    {
      AppMethodBeat.i(105650);
      d.g.b.p.h(paramw, "data");
      this.gnz.V(paramw.afl());
      AppMethodBeat.o(105650);
    }
    
    public final void cA(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105651);
      this.gnz.ar(paramInt1, paramInt2);
      AppMethodBeat.o(105651);
    }
    
    public final void cB(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105652);
      this.gnz.as(paramInt1, paramInt2);
      AppMethodBeat.o(105652);
    }
    
    public final void cC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105653);
      this.gnz.aq(paramInt1, paramInt2);
      AppMethodBeat.o(105653);
    }
    
    public final void cD(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105654);
      this.gnz.ap(paramInt1, paramInt2);
      AppMethodBeat.o(105654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.h
 * JD-Core Version:    0.7.0.1
 */