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
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$ApplyLinkViewHolder;", "applyLinkUserDescMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUserDesc;", "(Ljava/util/HashMap;)V", "MAX_COUNT", "", "getApplyLinkUserDescMap", "()Ljava/util/HashMap;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "onHungupLinkUser", "hungupUser", "getOnHungupLinkUser", "setOnHungupLinkUser", "getDataList", "", "getItemCount", "handleDescTv", "holder", "data", "indexOfData", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "removeAndNotify", "micUser", "updateData", "ApplyLinkViewHolder", "Companion", "plugin-finder_release"})
public final class y
  extends RecyclerView.a<a>
{
  private static final String TAG = "Finder.FinderLiveVisitorApplyLinkAdapter";
  public static final b yZX;
  private final int MAX_COUNT;
  public final ArrayList<h> mXB;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final HashMap<String, i> ySS;
  public kotlin.g.a.b<? super h, x> yVS;
  public kotlin.g.a.b<? super h, x> yWq;
  
  static
  {
    AppMethodBeat.i(276578);
    yZX = new b((byte)0);
    TAG = "Finder.FinderLiveVisitorApplyLinkAdapter";
    AppMethodBeat.o(276578);
  }
  
  public y(HashMap<String, i> paramHashMap)
  {
    AppMethodBeat.i(276577);
    this.ySS = paramHashMap;
    this.mXB = new ArrayList();
    this.MAX_COUNT = 300;
    AppMethodBeat.o(276577);
  }
  
  public final void aa(List<h> paramList)
  {
    AppMethodBeat.i(276575);
    p.k(paramList, "data");
    this.mXB.clear();
    ArrayList localArrayList = this.mXB;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      if (i < this.MAX_COUNT) {}
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          paramList.add(localObject2);
        }
        i += 1;
        break;
      }
    }
    localArrayList.addAll((Collection)paramList);
    AppMethodBeat.o(276575);
  }
  
  public final int f(h paramh)
  {
    AppMethodBeat.i(276576);
    p.k(paramh, "data");
    Object localObject = (List)this.mXB;
    int i = 0;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      if (Util.isEqual(((h)((Iterator)localObject).next()).username, paramh.username))
      {
        AppMethodBeat.o(276576);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(276576);
    return -1;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(276573);
    int i = this.mXB.size();
    AppMethodBeat.o(276573);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "descTv", "getDescTv", "levelTv", "getLevelTv", "nicknameTv", "getNicknameTv", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "typeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTypeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView kEs;
    final TextView rHr;
    final ProgressBar rUC;
    final TextView xoK;
    final TextView yVU;
    final WeImageView yWr;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(279898);
      this.xoK = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_nickname_tv));
      this.yWr = ((WeImageView)paramView.findViewById(b.f.finder_live_link_apply_item_type_icon));
      this.yVU = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_accept_btn));
      this.kEs = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_desc_tv));
      this.rUC = ((ProgressBar)paramView.findViewById(b.f.finder_live_link_apply_item_progress));
      this.rHr = ((TextView)paramView.findViewById(b.f.finder_live_link_apply_item_user_level));
      AppMethodBeat.o(279898);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(y paramy, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227542);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = (h)j.M((List)y.a(this.yZY), this.jEN);
      if (localObject != null)
      {
        paramView = this.yZY.xYp;
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
            boolean bool = Util.isEqual(((h)paramView).ktR, ((h)localObject).ktR);
            if (!bool) {
              continue;
            }
            paramView = (h)paramView;
            if (paramView == null) {
              break label220;
            }
            paramView = this.yZY.yWq;
            if (paramView != null) {
              paramView.invoke(localObject);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(227542);
            return;
          }
          paramView = null;
        }
        label215:
        paramView = null;
        continue;
        label220:
        paramView = this.yZY.yVS;
        if (paramView != null) {
          paramView.invoke(localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.y
 * JD-Core Version:    0.7.0.1
 */