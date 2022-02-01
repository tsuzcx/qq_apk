package com.tencent.mm.plugin.finder.live.view.adapter;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "applyLinkUserDescMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUserDesc;", "(Ljava/util/HashMap;)V", "TAG", "getApplyLinkUserDescMap", "()Ljava/util/HashMap;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "keyword", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "onHungupLinkUser", "hungupUser", "getOnHungupLinkUser", "setOnHungupLinkUser", "getDataList", "", "getItemCount", "", "handleDescTv", "holder", "data", "indexOfData", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "removeAndNotify", "micUser", "updateData", "ApplyLinkViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends RecyclerView.a<a>
{
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.data.i> DLm;
  public kotlin.g.a.b<? super h, ah> DPK;
  public kotlin.g.a.b<? super h, ah> DQm;
  private final String TAG;
  private String hAB;
  public final ArrayList<h> pUj;
  
  public i(HashMap<String, com.tencent.mm.plugin.finder.live.viewmodel.data.i> paramHashMap)
  {
    AppMethodBeat.i(358627);
    this.DLm = paramHashMap;
    this.TAG = "Finder.FinderLiveApplyLinkSearchAdapter";
    this.pUj = new ArrayList();
    this.hAB = "";
    AppMethodBeat.o(358627);
  }
  
  private static final void a(i parami, int paramInt, View paramView)
  {
    ??? = null;
    AppMethodBeat.i(358640);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parami);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parami, "this$0");
    localObject1 = (h)p.ae((List)parami.pUj, paramInt);
    if (localObject1 != null)
    {
      paramView = parami.CvU;
      if (paramView != null) {
        break label147;
      }
      paramView = ???;
      if (paramView == null) {
        break label265;
      }
      parami = parami.DQm;
      if (parami != null) {
        parami.invoke(localObject1);
      }
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(358640);
        return;
        label147:
        localObject2 = (j)paramView.business(j.class);
        paramView = ???;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((j)localObject2).Efw;
        paramView = ???;
        if (localObject2 == null) {
          break;
        }
        synchronized ((Iterable)localObject2)
        {
          localObject2 = ???.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              paramView = ((Iterator)localObject2).next();
              boolean bool = Util.isEqual(((h)paramView).mXL, ((h)localObject1).mXL);
              if (bool)
              {
                paramView = (h)paramView;
                break;
              }
            }
          }
          paramView = null;
        }
      }
      label265:
      parami = parami.DPK;
      if (parami != null) {
        parami.invoke(localObject1);
      }
    }
  }
  
  public final int f(h paramh)
  {
    AppMethodBeat.i(358672);
    s.u(paramh, "data");
    Object localObject = (List)this.pUj;
    int i = 0;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      if (Util.isEqual(((h)((Iterator)localObject).next()).username, paramh.username))
      {
        AppMethodBeat.o(358672);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(358672);
    return -1;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358654);
    int i = this.pUj.size();
    AppMethodBeat.o(358654);
    return i;
  }
  
  public final void l(List<h> paramList, String paramString)
  {
    AppMethodBeat.i(358663);
    s.u(paramList, "data");
    s.u(paramString, "keyword");
    this.hAB = paramString;
    this.pUj.clear();
    this.pUj.addAll((Collection)paramList);
    AppMethodBeat.o(358663);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveApplyLinkSearchAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "descTv", "getDescTv", "nicknameTv", "getNicknameTv", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "typeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTypeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final TextView DPM;
    final WeImageView DQn;
    final TextView descTv;
    final TextView nicknameTv;
    final ProgressBar vfR;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(359104);
      this.nicknameTv = ((TextView)paramView.findViewById(p.e.BMN));
      this.DQn = ((WeImageView)paramView.findViewById(p.e.BMP));
      this.DPM = ((TextView)paramView.findViewById(p.e.BML));
      this.descTv = ((TextView)paramView.findViewById(p.e.BMM));
      this.vfR = ((ProgressBar)paramView.findViewById(p.e.BMO));
      AppMethodBeat.o(359104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.i
 * JD-Core Version:    0.7.0.1
 */