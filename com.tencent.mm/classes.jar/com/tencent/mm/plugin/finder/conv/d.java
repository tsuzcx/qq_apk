package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "scene", "getScene", "setScene", "topPlaceCount", "getTopPlaceCount", "setTopPlaceCount", "delConv", "", "conv", "formatTime", "", "context", "Landroid/content/Context;", "getItem", "position", "getItemCount", "insertOrUpdateConv", "notifyConvItemChanged", "index", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshList", "data", "", "removeConversation", "sessionId", "setConvRead", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "setOrCancelTopPlace", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "submitList", "datas", "updateConv", "OnItemClickListener", "OnItemLongClickListener", "plugin-finder_release"})
public class d
  extends RecyclerView.a<a>
{
  public int pageType;
  public LinkedList<c> ppH;
  public int scene;
  public HashMap<String, c> tyt;
  private a tyu;
  private b tyv;
  
  public d()
  {
    AppMethodBeat.i(242722);
    this.ppH = new LinkedList();
    this.tyt = new HashMap();
    this.pageType = 1;
    this.scene = 2;
    AppMethodBeat.o(242722);
  }
  
  public void Il(int paramInt)
  {
    AppMethodBeat.i(242712);
    ci(paramInt);
    AppMethodBeat.o(242712);
  }
  
  public void Im(int paramInt)
  {
    AppMethodBeat.i(242713);
    cj(paramInt);
    AppMethodBeat.o(242713);
  }
  
  public void In(int paramInt)
  {
    AppMethodBeat.i(242715);
    ck(paramInt);
    AppMethodBeat.o(242715);
  }
  
  public c Io(int paramInt)
  {
    AppMethodBeat.i(242720);
    Object localObject = this.ppH.get(paramInt);
    p.g(localObject, "dataList[position]");
    localObject = (c)localObject;
    AppMethodBeat.o(242720);
    return localObject;
  }
  
  public void a(a parama, int paramInt)
  {
    AppMethodBeat.i(242709);
    p.h(parama, "holder");
    View localView = parama.aus;
    p.g(localView, "holder.itemView");
    c localc = Io(paramInt);
    if (localc == null)
    {
      AppMethodBeat.o(242709);
      return;
    }
    parama.et(localc);
    com.tencent.mm.ui.g.a.a.c((ImageView)localView.findViewById(2131297121), localc.field_sessionId);
    parama = (TextView)localView.findViewById(2131299242);
    p.g(parama, "itemView.conversationName");
    parama.setText(localc.tyr);
    TextView localTextView = (TextView)localView.findViewById(2131299497);
    p.g(localTextView, "itemView.descTv");
    parama = MMApplicationContext.getContext();
    Object localObject = (CharSequence)localc.field_editingMsg;
    if ((localObject == null) || (n.aL((CharSequence)localObject)))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label396;
      }
      parama = com.tencent.mm.pluginsdk.ui.span.l.c(parama, (CharSequence)localc.field_digest);
      p.g(parama, "MMSpanManager.spanForSmiley(context, field_digest)");
      parama = (CharSequence)parama;
      label168:
      localTextView.setText(parama);
      if (!localc.cZw()) {
        break label491;
      }
      localView.setBackgroundResource(2131233332);
      label189:
      localTextView = (TextView)localView.findViewById(2131309090);
      p.g(localTextView, "itemView.timeTv");
      parama = localView.getContext();
      p.g(parama, "itemView.context");
      if (localc.field_status != 1) {
        break label501;
      }
      parama = (CharSequence)parama.getString(2131760545);
      label241:
      localTextView.setText((CharSequence)String.valueOf(parama));
      if (!p.j(localc.field_sessionId, "findersayhisessionholder")) {
        break label521;
      }
      parama = (TextView)localView.findViewById(2131309143);
      p.g(parama, "itemView.tipNomalTv");
      if ((localc.field_unReadCount <= 0) || (localc.field_readStatus != 0)) {
        break label515;
      }
    }
    label515:
    for (paramInt = 0;; paramInt = 8)
    {
      parama.setVisibility(paramInt);
      parama = (TextView)localView.findViewById(2131309142);
      p.g(parama, "itemView.tipCountTv");
      parama.setVisibility(8);
      ((TextView)localView.findViewById(2131309143)).setBackgroundResource(v.kH(localView.getContext()));
      ((TextView)localView.findViewById(2131309143)).setTextSize(0, com.tencent.mm.cb.a.aH(localView.getContext(), 2131167084) * com.tencent.mm.cb.a.ji(localView.getContext()));
      AppMethodBeat.o(242709);
      return;
      paramInt = 0;
      break;
      label396:
      localObject = new SpannableStringBuilder((CharSequence)parama.getString(2131760252));
      p.g(parama, "context");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parama.getResources().getColor(2131100996)), 0, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append((CharSequence)" ").append((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(parama, (CharSequence)localc.field_editingMsg));
      parama = (CharSequence)localObject;
      break label168;
      label491:
      localView.setBackgroundResource(2131231898);
      break label189;
      label501:
      parama = f.c(parama, localc.field_updateTime, true);
      break label241;
    }
    label521:
    parama = (TextView)localView.findViewById(2131309142);
    p.g(parama, "itemView.tipCountTv");
    if ((localc.field_unReadCount > 0) && (localc.field_readStatus == 0)) {}
    for (paramInt = 0;; paramInt = 8)
    {
      parama.setVisibility(paramInt);
      parama = (TextView)localView.findViewById(2131309142);
      p.g(parama, "itemView.tipCountTv");
      parama.setText((CharSequence)String.valueOf(localc.field_unReadCount));
      ((TextView)localView.findViewById(2131309142)).setBackgroundResource(v.aQ(localView.getContext(), localc.field_unReadCount));
      ((TextView)localView.findViewById(2131309142)).setTextSize(0, com.tencent.mm.cb.a.aH(localView.getContext(), 2131167084) * com.tencent.mm.cb.a.ji(localView.getContext()));
      parama = (TextView)localView.findViewById(2131309143);
      p.g(parama, "itemView.tipNomalTv");
      parama.setVisibility(8);
      AppMethodBeat.o(242709);
      return;
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(242717);
    p.h(paramc, "conv");
    Object localObject2;
    if ((paramc.field_type == 1) && (this.pageType == 1) && (this.scene == 2))
    {
      localObject2 = (c)this.tyt.get("findersayhisessionholder");
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
        ((Map)this.tyt).put("findersayhisessionholder", localObject1);
      }
      p.g(localObject1, "dataMap[ContactStorageLo… = this\n                }");
      ((c)localObject1).field_unReadCount += paramc.field_unReadCount;
      ((c)localObject1).field_digest = paramc.field_digest;
      ((c)localObject1).field_updateTime = paramc.field_updateTime;
      ((c)localObject1).field_readStatus = paramc.field_readStatus;
      i = this.ppH.indexOf(localObject1);
      if (i >= 0)
      {
        Il(i);
        AppMethodBeat.o(242717);
        return;
      }
      this.ppH.add(0, localObject1);
      Im(i);
      AppMethodBeat.o(242717);
      return;
    }
    Object localObject1 = (c)this.tyt.get(paramc.field_sessionId);
    int i = j.a((List)this.ppH, localObject1);
    if (i >= 0)
    {
      this.ppH.remove(i);
      In(i);
    }
    paramc.prepare();
    localObject1 = (List)this.ppH;
    localObject1 = ((List)localObject1).listIterator(((List)localObject1).size());
    while (((ListIterator)localObject1).hasPrevious()) {
      if (((c)((ListIterator)localObject1).previous()).cZv())
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
      this.ppH.add(i, paramc);
      Im(i);
      this.tyt.remove(paramc.field_sessionId);
      localObject1 = (Map)this.tyt;
      localObject2 = paramc.field_sessionId;
      p.g(localObject2, "conv.field_sessionId");
      ((Map)localObject1).put(localObject2, paramc);
      AppMethodBeat.o(242717);
      return;
      i = -1;
      break;
      label388:
      i += 1;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(242718);
    p.h(parama, "listener");
    this.tyu = parama;
    AppMethodBeat.o(242718);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(242719);
    p.h(paramb, "listener");
    this.tyv = paramb;
    AppMethodBeat.o(242719);
  }
  
  public final void dR(List<c> paramList)
  {
    AppMethodBeat.i(242711);
    if (paramList != null)
    {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(paramList, this));
      AppMethodBeat.o(242711);
      return;
    }
    AppMethodBeat.o(242711);
  }
  
  public void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242714);
    as(paramInt1, paramInt2);
    AppMethodBeat.o(242714);
  }
  
  public void fZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242716);
    at(paramInt1, paramInt2);
    AppMethodBeat.o(242716);
  }
  
  public int getItemCount()
  {
    AppMethodBeat.i(242721);
    int i = this.ppH.size();
    AppMethodBeat.o(242721);
    return i;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(View paramView, c paramc);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, c paramc);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class c
    implements View.OnLongClickListener
  {
    c(d paramd, a parama, View paramView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(242704);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
      paramView = (c)this.tyx.hgv();
      localObject = d.a(this.tyw);
      if (localObject != null)
      {
        View localView = this.rsM;
        int i = this.tyx.lR();
        p.g(paramView, "item");
        ((d.b)localObject).a(localView, i, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(242704);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(d paramd, a parama, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242705);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = (c)this.tyx.hgv();
      localObject = d.b(this.tyw);
      if (localObject != null)
      {
        View localView = this.rsM;
        this.tyx.lR();
        p.g(paramView, "item");
        ((d.a)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242705);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$refreshList$1$1"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(d paramd, List paramList)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$submitList$1$1"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(List paramList, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.d
 * JD-Core Version:    0.7.0.1
 */