package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "applyLinkUserDescMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUserDesc;", "(Ljava/util/HashMap;)V", "TAG", "getApplyLinkUserDescMap", "()Ljava/util/HashMap;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "keyword", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "onHungupLinkUser", "hungupUser", "getOnHungupLinkUser", "setOnHungupLinkUser", "getDataList", "", "getItemCount", "", "handleDescTv", "holder", "data", "indexOfData", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "removeAndNotify", "micUser", "updateData", "ApplyLinkViewHolder", "plugin-finder_release"})
public final class h
  extends RecyclerView.a<a>
{
  private final String TAG;
  private String fwe;
  public final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.h> mXB;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final HashMap<String, i> ySS;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.viewmodel.data.h, x> yVS;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.finder.live.viewmodel.data.h, x> yWq;
  
  public h(HashMap<String, i> paramHashMap)
  {
    AppMethodBeat.i(270560);
    this.ySS = paramHashMap;
    this.TAG = "Finder.FinderLiveApplyLinkSearchAdapter";
    this.mXB = new ArrayList();
    this.fwe = "";
    AppMethodBeat.o(270560);
  }
  
  public final int f(com.tencent.mm.plugin.finder.live.viewmodel.data.h paramh)
  {
    AppMethodBeat.i(270559);
    p.k(paramh, "data");
    Object localObject = (List)this.mXB;
    int i = 0;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      if (Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)((Iterator)localObject).next()).username, paramh.username))
      {
        AppMethodBeat.o(270559);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(270559);
    return -1;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(270556);
    int i = this.mXB.size();
    AppMethodBeat.o(270556);
    return i;
  }
  
  public final void i(List<com.tencent.mm.plugin.finder.live.viewmodel.data.h> paramList, String paramString)
  {
    AppMethodBeat.i(270558);
    p.k(paramList, "data");
    p.k(paramString, "keyword");
    this.fwe = paramString;
    this.mXB.clear();
    this.mXB.addAll((Collection)paramList);
    AppMethodBeat.o(270558);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "descTv", "getDescTv", "nicknameTv", "getNicknameTv", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "typeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTypeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView kEs;
    final ProgressBar rUC;
    final TextView xoK;
    final TextView yVU;
    final WeImageView yWr;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(275391);
      this.xoK = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_nickname_tv));
      this.yWr = ((WeImageView)paramView.findViewById(b.f.finder_live_link_apply_item_type_icon));
      this.yVU = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_accept_btn));
      this.kEs = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_desc_tv));
      this.rUC = ((ProgressBar)paramView.findViewById(b.f.finder_live_link_apply_item_progress));
      AppMethodBeat.o(275391);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290468);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)j.M((List)h.a(this.yWs), this.jEN);
      if (localObject != null)
      {
        paramView = this.yWs.xYp;
        if (paramView == null) {
          break label215;
        }
        paramView = (f)paramView.business(f.class);
        if (paramView == null) {
          break label215;
        }
        paramView = paramView.zhm;
        if (paramView == null) {
          break label215;
        }
      }
      for (;;)
      {
        synchronized ((Iterable)paramView)
        {
          Iterator localIterator = ???.iterator();
          if (localIterator.hasNext())
          {
            paramView = localIterator.next();
            boolean bool = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramView).ktR, ((com.tencent.mm.plugin.finder.live.viewmodel.data.h)localObject).ktR);
            if (!bool) {
              continue;
            }
            paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramView;
            if (paramView == null) {
              break label220;
            }
            paramView = this.yWs.yWq;
            if (paramView != null) {
              paramView.invoke(localObject);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(290468);
            return;
          }
          paramView = null;
        }
        label215:
        paramView = null;
        continue;
        label220:
        paramView = this.yWs.yVS;
        if (paramView != null) {
          paramView.invoke(localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.h
 * JD-Core Version:    0.7.0.1
 */