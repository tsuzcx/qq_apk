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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "scene", "getScene", "setScene", "topPlaceCount", "getTopPlaceCount", "setTopPlaceCount", "delConv", "", "conv", "formatTime", "", "context", "Landroid/content/Context;", "getItem", "position", "getItemCount", "insertOrUpdateConv", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshList", "data", "", "removeConversation", "sessionId", "setConvRead", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "setOrCancelTopPlace", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "submitList", "datas", "updateConv", "OnItemClickListener", "OnItemLongClickListener", "plugin-finder_release"})
public final class d
  extends RecyclerView.a<a>
{
  public LinkedList<c> nZa;
  public int pageType;
  public HashMap<String, c> rLo;
  public a rLp;
  public b rLq;
  public int scene;
  
  public d()
  {
    AppMethodBeat.i(201273);
    this.nZa = new LinkedList();
    this.rLo = new HashMap();
    this.pageType = 1;
    this.scene = 2;
    AppMethodBeat.o(201273);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(201271);
    p.h(paramc, "conv");
    Object localObject2;
    if ((paramc.field_type == 1) && (this.pageType == 1) && (this.scene == 2))
    {
      localObject2 = (c)this.rLo.get("findersayhisessionholder");
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
        ((Map)this.rLo).put("findersayhisessionholder", localObject1);
      }
      p.g(localObject1, "dataMap[ContactStorageLo…DER] = this\n            }");
      ((c)localObject1).field_unReadCount += paramc.field_unReadCount;
      ((c)localObject1).field_digest = paramc.field_digest;
      ((c)localObject1).field_updateTime = paramc.field_updateTime;
      ((c)localObject1).field_readStatus = paramc.field_readStatus;
      i = this.nZa.indexOf(localObject1);
      if (i >= 0)
      {
        cj(i);
        AppMethodBeat.o(201271);
        return;
      }
      this.nZa.add(0, localObject1);
      ck(i);
      AppMethodBeat.o(201271);
      return;
    }
    Object localObject1 = (c)this.rLo.get(paramc.field_sessionId);
    int i = j.a((List)this.nZa, localObject1);
    if (i >= 0)
    {
      this.nZa.remove(i);
      cl(i);
    }
    paramc.prepare();
    localObject1 = (List)this.nZa;
    localObject1 = ((List)localObject1).listIterator(((List)localObject1).size());
    while (((ListIterator)localObject1).hasPrevious()) {
      if (((c)((ListIterator)localObject1).previous()).cyS())
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
      this.nZa.add(i, paramc);
      ck(i);
      this.rLo.remove(paramc.field_sessionId);
      localObject1 = (Map)this.rLo;
      localObject2 = paramc.field_sessionId;
      p.g(localObject2, "conv.field_sessionId");
      ((Map)localObject1).put(localObject2, paramc);
      AppMethodBeat.o(201271);
      return;
      i = -1;
      break;
      label388:
      i += 1;
    }
  }
  
  public final void dz(List<c> paramList)
  {
    AppMethodBeat.i(201270);
    if (paramList != null)
    {
      com.tencent.mm.ad.c.g((d.g.a.a)new f(paramList, this));
      AppMethodBeat.o(201270);
      return;
    }
    AppMethodBeat.o(201270);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(201272);
    int i = this.nZa.size();
    AppMethodBeat.o(201272);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(View paramView, c paramc);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, c paramc);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class c
    implements View.OnLongClickListener
  {
    c(d paramd, a parama, View paramView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(201264);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
      paramView = (c)this.rLs.fQC();
      localObject = d.a(this.rLr);
      if (localObject != null)
      {
        View localView = this.pVk;
        int i = this.rLs.lN();
        p.g(paramView, "item");
        ((d.b)localObject).a(localView, i, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(201264);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(d paramd, a parama, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201265);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = (c)this.rLs.fQC();
      localObject = d.b(this.rLr);
      if (localObject != null)
      {
        View localView = this.pVk;
        this.rLs.lN();
        p.g(paramView, "item");
        ((d.a)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201265);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$refreshList$1$1"})
  public static final class e
    extends q
    implements d.g.a.a<z>
  {
    public e(d paramd, List paramList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$submitList$1$1"})
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