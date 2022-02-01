package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.s;
import d.a.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "()V", "TAG", "", "clickListener", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "getClickListener", "()Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "setClickListener", "(Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "clickListenerWrap", "getClickListenerWrap", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "Lkotlin/collections/ArrayList;", "addData", "", "items", "", "addDataByIndex", "index", "", "item", "getItem", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ListenerToAdapter", "plugin-emojisdk_release"})
public class h
  extends RecyclerView.a<q<?>>
{
  private final String TAG;
  public n fPW;
  private final ArrayList<com.tencent.mm.emoji.a.a.y> fQh;
  protected final n fQi;
  
  public h()
  {
    AppMethodBeat.i(105665);
    this.TAG = "MicroMsg.EmojiPanelItemAdapter";
    this.fQh = new ArrayList();
    this.fQi = ((n)new b(this));
    AppMethodBeat.o(105665);
  }
  
  public final void a(int paramInt, com.tencent.mm.emoji.a.a.y paramy)
  {
    AppMethodBeat.i(105657);
    d.g.b.k.h(paramy, "item");
    this.fQh.add(paramInt, paramy);
    AppMethodBeat.o(105657);
  }
  
  public void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(105663);
    d.g.b.k.h(paramq, "holder");
    Object localObject = this.fQh.get(paramInt);
    d.g.b.k.g(localObject, "itemList[position]");
    localObject = (com.tencent.mm.emoji.a.a.y)localObject;
    paramq.fQw = this.fQi;
    paramq.a((com.tencent.mm.emoji.a.a.y)localObject);
    AppMethodBeat.o(105663);
  }
  
  public final void ad(List<? extends com.tencent.mm.emoji.a.a.y> paramList)
  {
    AppMethodBeat.i(105656);
    d.g.b.k.h(paramList, "items");
    this.fQh.clear();
    this.fQh.addAll((Collection)paramList);
    AppMethodBeat.o(105656);
  }
  
  public q<?> e(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105661);
    d.g.b.k.h(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = localLayoutInflater.inflate(2131493781, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new k(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 1: 
      paramViewGroup = localLayoutInflater.inflate(2131493784, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new w(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 2: 
      paramViewGroup = localLayoutInflater.inflate(2131493785, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new y(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 3: 
      paramViewGroup = localLayoutInflater.inflate(2131495478, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new l(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 4: 
      paramViewGroup = localLayoutInflater.inflate(2131493783, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new m(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 5: 
      paramViewGroup = localLayoutInflater.inflate(2131495479, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = new q(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    case 6: 
      paramViewGroup = localLayoutInflater.inflate(2131493782, paramViewGroup, false);
      d.g.b.k.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new b(paramViewGroup, this.fQi);
      AppMethodBeat.o(105661);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(2131493780, paramViewGroup, false);
    d.g.b.k.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new a(paramViewGroup, this.fQi);
    AppMethodBeat.o(105661);
    return paramViewGroup;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(105659);
    int i = this.fQh.size();
    AppMethodBeat.o(105659);
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(105660);
    com.tencent.mm.emoji.a.a.y localy = lE(paramInt);
    if (localy != null)
    {
      paramInt = localy.type;
      AppMethodBeat.o(105660);
      return paramInt;
    }
    AppMethodBeat.o(105660);
    return 0;
  }
  
  public final com.tencent.mm.emoji.a.a.y lE(int paramInt)
  {
    AppMethodBeat.i(105658);
    com.tencent.mm.emoji.a.a.y localy = (com.tencent.mm.emoji.a.a.y)j.C((List)this.fQh, paramInt);
    AppMethodBeat.o(105658);
    return localy;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$ListenerToAdapter;", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "adapter", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "(Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;)V", "onGroupItemsChange", "", "start", "", "count", "onGroupItemsInsert", "onGroupItemsMoved", "from", "to", "onGroupItemsRemove", "onUpdateData", "data", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.emoji.a.a.w
  {
    private final h fQa;
    
    public a(h paramh)
    {
      AppMethodBeat.i(105655);
      this.fQa = paramh;
      AppMethodBeat.o(105655);
    }
    
    public final void b(s params)
    {
      AppMethodBeat.i(105650);
      d.g.b.k.h(params, "data");
      this.fQa.ad(params.getItemList());
      AppMethodBeat.o(105650);
    }
    
    public final void cA(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105651);
      this.fQa.aq(paramInt1, paramInt2);
      AppMethodBeat.o(105651);
    }
    
    public final void cB(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105652);
      this.fQa.ar(paramInt1, paramInt2);
      AppMethodBeat.o(105652);
    }
    
    public final void cC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105653);
      this.fQa.ap(paramInt1, paramInt2);
      AppMethodBeat.o(105653);
    }
    
    public final void cD(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105654);
      this.fQa.ao(paramInt1, paramInt2);
      AppMethodBeat.o(105654);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter$clickListenerWrap$1", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "plugin-emojisdk_release"})
  public static final class b
    implements n
  {
    public final void a(Context paramContext, int paramInt, com.tencent.mm.emoji.a.a.y paramy)
    {
      AppMethodBeat.i(183960);
      d.g.b.k.h(paramContext, "context");
      paramy = this.fQj.fPW;
      if (paramy != null)
      {
        paramy.a(paramContext, paramInt, (com.tencent.mm.emoji.a.a.y)j.C((List)h.a(this.fQj), paramInt));
        AppMethodBeat.o(183960);
        return;
      }
      AppMethodBeat.o(183960);
    }
    
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(193413);
      d.g.b.k.h(paramContext, "context");
      n localn = this.fQj.fPW;
      if (localn != null)
      {
        j.C((List)h.a(this.fQj), paramInt);
        localn.a(paramView, paramContext, paramInt);
        AppMethodBeat.o(193413);
        return;
      }
      AppMethodBeat.o(193413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.h
 * JD-Core Version:    0.7.0.1
 */