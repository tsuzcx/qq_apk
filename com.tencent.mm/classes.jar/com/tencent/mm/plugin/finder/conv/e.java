package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.tools.w;
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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "()V", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "onLongClickListener", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "scene", "getScene", "setScene", "topPlaceCount", "getTopPlaceCount", "setTopPlaceCount", "delConv", "", "conv", "formatTime", "", "context", "Landroid/content/Context;", "getItem", "position", "getItemCount", "insertOrUpdateConv", "notifyConvItemChanged", "index", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshList", "data", "", "removeConversation", "sessionId", "setConvRead", "setOnItemClickListener", "listener", "setOnItemLongClickListener", "setOrCancelTopPlace", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "submitList", "datas", "updateConv", "OnItemClickListener", "OnItemLongClickListener", "plugin-finder_release"})
public class e
  extends RecyclerView.a<a>
{
  public int pageType;
  public int scene;
  public LinkedList<d> syG;
  public HashMap<String, d> xge;
  private a xgf;
  private b xgg;
  
  public e()
  {
    AppMethodBeat.i(286099);
    this.syG = new LinkedList();
    this.xge = new HashMap();
    this.pageType = 1;
    this.scene = 2;
    AppMethodBeat.o(286099);
  }
  
  public void LW(int paramInt)
  {
    AppMethodBeat.i(286088);
    cL(paramInt);
    AppMethodBeat.o(286088);
  }
  
  public void LX(int paramInt)
  {
    AppMethodBeat.i(286090);
    cM(paramInt);
    AppMethodBeat.o(286090);
  }
  
  public void LY(int paramInt)
  {
    AppMethodBeat.i(286092);
    cN(paramInt);
    AppMethodBeat.o(286092);
  }
  
  public d LZ(int paramInt)
  {
    AppMethodBeat.i(286097);
    Object localObject = this.syG.get(paramInt);
    p.j(localObject, "dataList[position]");
    localObject = (d)localObject;
    AppMethodBeat.o(286097);
    return localObject;
  }
  
  public void a(a parama, int paramInt)
  {
    AppMethodBeat.i(286084);
    p.k(parama, "holder");
    View localView = parama.amk;
    p.j(localView, "holder.itemView");
    d locald = LZ(paramInt);
    if (locald == null)
    {
      AppMethodBeat.o(286084);
      return;
    }
    parama.ez(locald);
    com.tencent.mm.ui.h.a.a.c((ImageView)localView.findViewById(b.f.avatarIv), locald.field_sessionId);
    parama = (TextView)localView.findViewById(b.f.conversationName);
    p.j(parama, "itemView.conversationName");
    parama.setText(locald.xgc);
    TextView localTextView = (TextView)localView.findViewById(b.f.descTv);
    p.j(localTextView, "itemView.descTv");
    parama = MMApplicationContext.getContext();
    Object localObject = (CharSequence)locald.field_editingMsg;
    if ((localObject == null) || (n.ba((CharSequence)localObject)))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label356;
      }
      parama = com.tencent.mm.pluginsdk.ui.span.l.c(parama, (CharSequence)locald.field_digest);
      p.j(parama, "MMSpanManager.spanForSmiley(context, field_digest)");
      parama = (CharSequence)parama;
      label167:
      localTextView.setText(parama);
      if (!locald.dpm()) {
        break label451;
      }
      localView.setBackgroundResource(b.e.list_item_top_selector);
      label188:
      localTextView = (TextView)localView.findViewById(b.f.timeTv);
      p.j(localTextView, "itemView.timeTv");
      parama = localView.getContext();
      p.j(parama, "itemView.context");
      if (locald.field_status != 1) {
        break label461;
      }
      parama = (CharSequence)parama.getString(b.j.finder_sending);
      label240:
      localTextView.setText((CharSequence)String.valueOf(parama));
      if ((!p.h(locald.field_sessionId, "findersayhisessionholder")) && (!p.h(locald.field_sessionId, "finderaliassessionholder"))) {
        break label481;
      }
      parama = (TextView)localView.findViewById(b.f.tipNomalTv);
      p.j(parama, "itemView.tipNomalTv");
      if ((locald.field_unReadCount <= 0) || (locald.field_readStatus != 0)) {
        break label475;
      }
    }
    label451:
    label461:
    label475:
    for (paramInt = 0;; paramInt = 8)
    {
      parama.setVisibility(paramInt);
      parama = (TextView)localView.findViewById(b.f.tipCountTv);
      p.j(parama, "itemView.tipCountTv");
      parama.setVisibility(8);
      AppMethodBeat.o(286084);
      return;
      paramInt = 0;
      break;
      label356:
      localObject = new SpannableStringBuilder((CharSequence)parama.getString(b.j.finder_message_draf));
      p.j(parama, "context");
      ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(parama.getResources().getColor(b.c.red_text_color)), 0, ((SpannableStringBuilder)localObject).length(), 33);
      ((SpannableStringBuilder)localObject).append((CharSequence)" ").append((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(parama, (CharSequence)locald.field_editingMsg));
      parama = (CharSequence)localObject;
      break label167;
      localView.setBackgroundResource(b.e.comm_list_item_selector);
      break label188;
      parama = f.d(parama, locald.field_updateTime, true);
      break label240;
    }
    label481:
    parama = (TextView)localView.findViewById(b.f.tipCountTv);
    p.j(parama, "itemView.tipCountTv");
    if ((locald.field_unReadCount > 0) && (locald.field_readStatus == 0)) {}
    for (paramInt = 0;; paramInt = 8)
    {
      parama.setVisibility(paramInt);
      parama = (TextView)localView.findViewById(b.f.tipCountTv);
      p.j(parama, "itemView.tipCountTv");
      parama.setText((CharSequence)String.valueOf(locald.field_unReadCount));
      ((TextView)localView.findViewById(b.f.tipCountTv)).setBackgroundResource(w.bj(localView.getContext(), locald.field_unReadCount));
      ((TextView)localView.findViewById(b.f.tipCountTv)).setTextSize(0, com.tencent.mm.ci.a.aZ(localView.getContext(), b.d.unReadCountTextSize) * com.tencent.mm.ci.a.km(localView.getContext()));
      parama = (TextView)localView.findViewById(b.f.tipNomalTv);
      p.j(parama, "itemView.tipNomalTv");
      parama.setVisibility(8);
      AppMethodBeat.o(286084);
      return;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(286094);
    p.k(paramd, "conv");
    Object localObject2;
    if ((paramd.field_type == 1) && (this.pageType == 1) && (this.scene == 2))
    {
      localObject2 = (d)this.xge.get("findersayhisessionholder");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new d();
        ((d)localObject1).field_sessionId = "findersayhisessionholder";
        ((d)localObject1).field_talker = "findersayhisessionholder";
        ((d)localObject1).field_placedFlag = 1000L;
        ((d)localObject1).field_type = 100;
        ((d)localObject1).field_scene = 2;
        ((d)localObject1).prepare();
        ((Map)this.xge).put("findersayhisessionholder", localObject1);
      }
      p.j(localObject1, "dataMap[ContactStorageLo… = this\n                }");
      ((d)localObject1).field_unReadCount += paramd.field_unReadCount;
      ((d)localObject1).field_digest = paramd.field_digest;
      ((d)localObject1).field_updateTime = paramd.field_updateTime;
      ((d)localObject1).field_readStatus = paramd.field_readStatus;
      i = this.syG.indexOf(localObject1);
      if (i >= 0)
      {
        LW(i);
        AppMethodBeat.o(286094);
        return;
      }
      this.syG.add(0, localObject1);
      LX(i);
      AppMethodBeat.o(286094);
      return;
    }
    if ((paramd.field_type == 3) && (this.pageType == 1) && (this.scene == 1))
    {
      localObject2 = (d)this.xge.get("finderaliassessionholder");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new d();
        ((d)localObject1).field_sessionId = "finderaliassessionholder";
        ((d)localObject1).field_talker = "finderaliassessionholder";
        ((d)localObject1).field_placedFlag = 0L;
        ((d)localObject1).field_type = 200;
        ((d)localObject1).field_scene = 1;
        ((d)localObject1).prepare();
        ((Map)this.xge).put("finderaliassessionholder", localObject1);
      }
      p.j(localObject1, "dataMap[ContactStorageLo… = this\n                }");
      ((d)localObject1).field_unReadCount += paramd.field_unReadCount;
      ((d)localObject1).field_digest = paramd.field_digest;
      ((d)localObject1).field_updateTime = paramd.field_updateTime;
      ((d)localObject1).field_readStatus = paramd.field_readStatus;
      i = this.syG.indexOf(localObject1);
      if (i >= 0)
      {
        LW(i);
        AppMethodBeat.o(286094);
        return;
      }
      this.syG.add(0, localObject1);
      LX(i);
      AppMethodBeat.o(286094);
      return;
    }
    Object localObject1 = (d)this.xge.get(paramd.field_sessionId);
    int i = j.a((List)this.syG, localObject1);
    if (i >= 0)
    {
      this.syG.remove(i);
      LY(i);
    }
    paramd.prepare();
    localObject1 = (List)this.syG;
    localObject1 = ((List)localObject1).listIterator(((List)localObject1).size());
    while (((ListIterator)localObject1).hasPrevious()) {
      if (((d)((ListIterator)localObject1).previous()).dpl())
      {
        i = ((ListIterator)localObject1).nextIndex();
        if (i >= 0) {
          break label585;
        }
        i = 0;
      }
    }
    for (;;)
    {
      this.syG.add(i, paramd);
      LX(i);
      this.xge.remove(paramd.field_sessionId);
      localObject1 = (Map)this.xge;
      localObject2 = paramd.field_sessionId;
      p.j(localObject2, "conv.field_sessionId");
      ((Map)localObject1).put(localObject2, paramd);
      AppMethodBeat.o(286094);
      return;
      i = -1;
      break;
      label585:
      i += 1;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(286095);
    p.k(parama, "listener");
    this.xgf = parama;
    AppMethodBeat.o(286095);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(286096);
    p.k(paramb, "listener");
    this.xgg = paramb;
    AppMethodBeat.o(286096);
  }
  
  public final void dZ(List<d> paramList)
  {
    AppMethodBeat.i(286087);
    if (paramList != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(paramList, this));
      AppMethodBeat.o(286087);
      return;
    }
    AppMethodBeat.o(286087);
  }
  
  public int getItemCount()
  {
    AppMethodBeat.i(286098);
    int i = this.syG.size();
    AppMethodBeat.o(286098);
    return i;
  }
  
  public void gw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286091);
    aG(paramInt1, paramInt2);
    AppMethodBeat.o(286091);
  }
  
  public void gx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286093);
    aH(paramInt1, paramInt2);
    AppMethodBeat.o(286093);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(View paramView, d paramd);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "", "onItemLongClick", "", "view", "Landroid/view/View;", "position", "", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, d paramd);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class c
    implements View.OnLongClickListener
  {
    c(e parame, a parama, View paramView) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(286437);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
      paramView = (d)this.xgi.ihX();
      localObject = e.a(this.xgh);
      if (localObject != null)
      {
        View localView = this.jLG;
        int i = this.xgi.md();
        p.j(paramView, "item");
        ((e.b)localObject).a(localView, i, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(286437);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(e parame, a parama, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(292075);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = (d)this.xgi.ihX();
      localObject = e.b(this.xgh);
      if (localObject != null)
      {
        View localView = this.jLG;
        this.xgi.md();
        p.j(paramView, "item");
        ((e.a)localObject).a(localView, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292075);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$refreshList$1$1"})
  public static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public e(e parame, List paramList)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/conv/FinderConversationAdapter$submitList$1$1"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(List paramList, e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.e
 * JD-Core Version:    0.7.0.1
 */