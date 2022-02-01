package com.tencent.mm.plugin.finder.conv;

import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "scene", "getScene", "setScene", "topPlaceCount", "getTopPlaceCount", "setTopPlaceCount", "delConv", "", "conv", "formatTime", "", "context", "Landroid/content/Context;", "getItem", "position", "getItemCount", "insertOrUpdateConv", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshList", "data", "", "removeConversation", "sessionId", "setConvRead", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "setOrCancelTopPlace", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "submitList", "datas", "updateConv", "OnItemClickListener", "OnItemLongClickListener", "plugin-finder_release"})
public final class d
  extends RecyclerView.a<a>
{
  public LinkedList<c> oeJ;
  public int pageType;
  public HashMap<String, c> rTC;
  public a rTD;
  public b rTE;
  public int scene;
  
  public d()
  {
    AppMethodBeat.i(201700);
    this.oeJ = new LinkedList();
    this.rTC = new HashMap();
    this.pageType = 1;
    this.scene = 2;
    AppMethodBeat.o(201700);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(201698);
    p.h(paramc, "conv");
    Object localObject2;
    if ((paramc.field_type == 1) && (this.pageType == 1) && (this.scene == 2))
    {
      localObject2 = (c)this.rTC.get("findersayhisessionholder");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new c();
        ((c)localObject1).field_sessionId = "findersayhisessionholder";
        ((c)localObject1).field_talker = "findersayhisessionholder";
        ((c)localObject1).field_placedFlag = 1000L;
        ((c)localObject1).field_type = 100;
        ((c)localObject1).field_scene = 2;
        ((c)localObject1).prepare();
        ((Map)this.rTC).put("findersayhisessionholder", localObject1);
      }
      p.g(localObject1, "dataMap[ContactStorageLo…DER] = this\n            }");
      ((c)localObject1).field_unReadCount += paramc.field_unReadCount;
      ((c)localObject1).field_digest = paramc.field_digest;
      ((c)localObject1).field_updateTime = paramc.field_updateTime;
      ((c)localObject1).field_readStatus = paramc.field_readStatus;
      i = this.oeJ.indexOf(localObject1);
      if (i >= 0)
      {
        cj(i);
        AppMethodBeat.o(201698);
        return;
      }
      this.oeJ.add(0, localObject1);
      ck(i);
      AppMethodBeat.o(201698);
      return;
    }
    Object localObject1 = (c)this.rTC.get(paramc.field_sessionId);
    int i = j.a((List)this.oeJ, localObject1);
    if (i >= 0)
    {
      this.oeJ.remove(i);
      cl(i);
    }
    paramc.prepare();
    localObject1 = (List)this.oeJ;
    localObject1 = ((List)localObject1).listIterator(((List)localObject1).size());
    while (((ListIterator)localObject1).hasPrevious()) {
      if (((c)((ListIterator)localObject1).previous()).cAw())
      {
        i = ((ListIterator)localObject1).nextIndex();
        if (i >= 0) {
          break label388;
        }
        i = 0;
      }
    }
    for (;;)
    {
      this.oeJ.add(i, paramc);
      ck(i);
      this.rTC.remove(paramc.field_sessionId);
      localObject1 = (Map)this.rTC;
      localObject2 = paramc.field_sessionId;
      p.g(localObject2, "conv.field_sessionId");
      ((Map)localObject1).put(localObject2, paramc);
      AppMethodBeat.o(201698);
      return;
      i = -1;
      break;
      label388:
      i += 1;
    }
  }
  
  public final void dC(List<c> paramList)
  {
    AppMethodBeat.i(201697);
    if (paramList != null)
    {
      com.tencent.mm.ac.c.h((d.g.a.a)new f(paramList, this));
      AppMethodBeat.o(201697);
      return;
    }
    AppMethodBeat.o(201697);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(201699);
    int i = this.oeJ.size();
    AppMethodBeat.o(201699);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(View paramView, c paramc);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, c paramc);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class c
    implements View.OnLongClickListener
  {
    c(d paramd, a parama, View paramView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201691);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
      paramView = (c)this.rTG.fUY();
      localObject = d.a(this.rTF);
      if (localObject != null)
      {
        View localView = this.qbP;
        int i = this.rTG.lN();
        p.g(paramView, "item");
        ((d.b)localObject).a(localView, i, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(201691);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(d paramd, a parama, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201692);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = (c)this.rTG.fUY();
      localObject = d.b(this.rTF);
      if (localObject != null)
      {
        View localView = this.qbP;
        this.rTG.lN();
        p.g(paramView, "item");
        ((d.a)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201692);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$refreshList$1$1"})
  public static final class e
    extends q
    implements d.g.a.a<z>
  {
    public e(d paramd, List paramList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$submitList$1$1"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(List paramList, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.d
 * JD-Core Version:    0.7.0.1
 */