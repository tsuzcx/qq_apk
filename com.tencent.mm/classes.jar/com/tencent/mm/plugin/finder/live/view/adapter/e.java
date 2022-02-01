package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "MUSIC_ANIMATION_FILE", "", "getMUSIC_ANIMATION_FILE", "()Ljava/lang/String;", "MUSIC_COUNT_ITEM", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "getMUSIC_COUNT_ITEM", "()Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "setMUSIC_COUNT_ITEM", "(Lcom/tencent/mm/plugin/finder/live/model/MusicItem;)V", "TAG", "getTAG", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "descDataList", "getDescDataList", "setDescDataList", "isPagEnable", "", "()Z", "itemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "musicItem", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "musicDataList", "getMusicDataList", "setMusicDataList", "onLongClickListener", "getOnLongClickListener", "setOnLongClickListener", "deleteMusicItem", "position", "getItemCount", "getItemViewType", "notifyMusicItemChange", "rawOriPos", "rawNewPos", "notifyMusicItemRemove", "onBindMusicCountHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicCountViewHolder;", "onBindMusicHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicViewHolder;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "setPagViewState", "pagView", "Lorg/libpag/PAGView;", "musicState", "updateMusicList", "notifyDataSetChange", "AbsMuscViewHolder", "MusicCountViewHolder", "MusicViewHolder", "plugin-finder_release"})
public final class e
  extends RecyclerView.a<a>
{
  public final String TAG;
  private ArrayList<aq> mXB;
  private final com.tencent.mm.plugin.finder.live.model.context.a xYp;
  final String yVW;
  public ArrayList<aq> yVX;
  private aq yVY;
  private ArrayList<aq> yVZ;
  public q<? super View, ? super Integer, ? super aq, x> yWa;
  public q<? super View, ? super Integer, ? super aq, x> yWb;
  private final boolean yaB;
  
  public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(253779);
    this.xYp = parama;
    this.TAG = "FinderLiveAnchorMusicAdapter";
    this.yVW = "finder_live_music_play.pag";
    this.mXB = new ArrayList();
    this.yVX = new ArrayList();
    this.yVY = new aq(new bbg(), 0, 1, 16);
    this.yVZ = new ArrayList();
    parama = h.ag(PluginFinder.class);
    p.j(parama, "MMKernel.plugin(PluginFinder::class.java)");
    this.yaB = ((PluginFinder)parama).isPagEnable();
    parama = aj.AGc;
    aj.aFQ("FinderLiveAnchorMusicAdapter");
    this.yVX.add(this.yVY);
    this.yVZ.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.ydi);
    this.mXB.addAll((Collection)this.yVX);
    this.mXB.addAll((Collection)this.yVZ);
    AppMethodBeat.o(253779);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(253775);
    int i = this.mXB.size();
    AppMethodBeat.o(253775);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(253773);
    paramInt = ((aq)this.mXB.get(paramInt)).type;
    AppMethodBeat.o(253773);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;Landroid/view/View;)V", "plugin-finder_release"})
  public class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(281773);
      AppMethodBeat.o(281773);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicCountViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;Landroid/view/View;)V", "musicCount", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMusicCount", "()Landroid/widget/TextView;", "setMusicCount", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class b
    extends e.a
  {
    TextView yWd;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(285414);
      this.yWd = ((TextView)localObject.findViewById(b.f.music_count_tv));
      AppMethodBeat.o(285414);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;Landroid/view/View;)V", "musicIcon", "Lorg/libpag/PAGView;", "kotlin.jvm.PlatformType", "getMusicIcon", "()Lorg/libpag/PAGView;", "setMusicIcon", "(Lorg/libpag/PAGView;)V", "musicName", "Landroid/widget/TextView;", "getMusicName", "()Landroid/widget/TextView;", "setMusicName", "(Landroid/widget/TextView;)V", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getPlayIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPlayIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "singer", "getSinger", "setSinger", "plugin-finder_release"})
  public final class c
    extends e.a
  {
    PAGView yWe;
    TextView yWf;
    TextView yWg;
    WeImageView yWh;
    
    public c()
    {
      super((View)localObject1);
      AppMethodBeat.i(278316);
      this.yWe = ((PAGView)((View)localObject1).findViewById(b.f.music_icon));
      this.yWf = ((TextView)((View)localObject1).findViewById(b.f.music_name));
      this.yWg = ((TextView)((View)localObject1).findViewById(b.f.singer));
      this.yWh = ((WeImageView)((View)localObject1).findViewById(b.f.play_icon));
      Object localObject1 = this.yWe;
      if (localObject1 != null)
      {
        Object localObject2 = this.yWe;
        p.j(localObject2, "musicIcon");
        localObject2 = ((PAGView)localObject2).getContext();
        p.j(localObject2, "musicIcon.context");
        ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), e.this.yVW));
      }
      this$1 = this.yWe;
      if (e.this != null)
      {
        e.this.setRepeatCount(0);
        AppMethodBeat.o(278316);
        return;
      }
      AppMethodBeat.o(278316);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(e parame, int paramInt, aq paramaq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(271672);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$onBindMusicHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Log.i(this.yWc.TAG, "itemClickListener position:" + this.jEN + ",descDataList.size:" + this.yWc.yVX.size());
      localObject = this.yWc.yWa;
      if (localObject != null)
      {
        p.j(paramView, "it");
        ((q)localObject).c(paramView, Integer.valueOf(this.jEN - this.yWc.yVX.size()), this.xZa);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$onBindMusicHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271672);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class e
    implements View.OnLongClickListener
  {
    e(e parame, int paramInt, aq paramaq) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(284962);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$onBindMusicHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Log.i(this.yWc.TAG, "onLongClickListener position:" + this.jEN + ",descDataList.size:" + this.yWc.yVX.size());
      localObject = this.yWc.yWb;
      if (localObject != null)
      {
        p.j(paramView, "it");
        ((q)localObject).c(paramView, Integer.valueOf(this.jEN - this.yWc.yVX.size()), this.xZa);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$onBindMusicHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(284962);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.e
 * JD-Core Version:    0.7.0.1
 */