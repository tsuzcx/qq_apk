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
import com.tencent.mm.plugin.finder.live.viewmodel.data.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$ApplyLinkViewHolder;", "applyLinkUserDescMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUserDesc;", "(Ljava/util/HashMap;)V", "MAX_COUNT", "", "getApplyLinkUserDescMap", "()Ljava/util/HashMap;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "Lkotlin/collections/ArrayList;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "onAcceptLinkUser", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "acceptUser", "", "getOnAcceptLinkUser", "()Lkotlin/jvm/functions/Function1;", "setOnAcceptLinkUser", "(Lkotlin/jvm/functions/Function1;)V", "onHungupLinkUser", "hungupUser", "getOnHungupLinkUser", "setOnHungupLinkUser", "getDataList", "", "getItemCount", "handleDescTv", "holder", "data", "indexOfData", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "removeAndNotify", "micUser", "updateData", "ApplyLinkViewHolder", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
  extends RecyclerView.a<a>
{
  public static final ah.b DTE;
  private static final String TAG;
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final HashMap<String, i> DLm;
  public kotlin.g.a.b<? super h, kotlin.ah> DPK;
  public kotlin.g.a.b<? super h, kotlin.ah> DQm;
  private final int MAX_COUNT;
  public final ArrayList<h> pUj;
  
  static
  {
    AppMethodBeat.i(358820);
    DTE = new ah.b((byte)0);
    TAG = "Finder.FinderLiveVisitorApplyLinkAdapter";
    AppMethodBeat.o(358820);
  }
  
  public ah(HashMap<String, i> paramHashMap)
  {
    AppMethodBeat.i(358802);
    this.DLm = paramHashMap;
    this.pUj = new ArrayList();
    this.MAX_COUNT = 300;
    AppMethodBeat.o(358802);
  }
  
  private static final void a(ah paramah, int paramInt, View paramView)
  {
    ??? = null;
    AppMethodBeat.i(358815);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramah);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramah, "this$0");
    localObject1 = (h)p.ae((List)paramah.pUj, paramInt);
    if (localObject1 != null)
    {
      paramView = paramah.CvU;
      if (paramView != null) {
        break label147;
      }
      paramView = ???;
      if (paramView == null) {
        break label265;
      }
      paramah = paramah.DQm;
      if (paramah != null) {
        paramah.invoke(localObject1);
      }
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(358815);
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
      paramah = paramah.DPK;
      if (paramah != null) {
        paramah.invoke(localObject1);
      }
    }
  }
  
  public final void bz(List<h> paramList)
  {
    AppMethodBeat.i(358843);
    s.u(paramList, "data");
    this.pUj.clear();
    ArrayList localArrayList = this.pUj;
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
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
    AppMethodBeat.o(358843);
  }
  
  public final int f(h paramh)
  {
    AppMethodBeat.i(358850);
    s.u(paramh, "data");
    Object localObject = (List)this.pUj;
    int i = 0;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      if (Util.isEqual(((h)((Iterator)localObject).next()).username, paramh.username))
      {
        AppMethodBeat.o(358850);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(358850);
    return -1;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358835);
    int i = this.pUj.size();
    AppMethodBeat.o(358835);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorApplyLinkAdapter$ApplyLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "acceptBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAcceptBtn", "()Landroid/widget/TextView;", "descTv", "getDescTv", "levelTv", "getLevelTv", "nicknameTv", "getNicknameTv", "progress", "Landroid/widget/ProgressBar;", "getProgress", "()Landroid/widget/ProgressBar;", "typeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTypeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final TextView DPM;
    final WeImageView DQn;
    final TextView descTv;
    final TextView nicknameTv;
    final TextView uSG;
    final ProgressBar vfR;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(358859);
      this.nicknameTv = ((TextView)paramView.findViewById(p.e.BMN));
      this.DQn = ((WeImageView)paramView.findViewById(p.e.BMP));
      this.DPM = ((TextView)paramView.findViewById(p.e.BML));
      this.descTv = ((TextView)paramView.findViewById(p.e.BMM));
      this.vfR = ((ProgressBar)paramView.findViewById(p.e.BMO));
      this.uSG = ((TextView)paramView.findViewById(p.e.BMQ));
      AppMethodBeat.o(358859);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ah
 * JD-Core Version:    0.7.0.1
 */