package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "MUSIC_ANIMATION_FILE", "", "getMUSIC_ANIMATION_FILE", "()Ljava/lang/String;", "MUSIC_COUNT_ITEM", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "getMUSIC_COUNT_ITEM", "()Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "setMUSIC_COUNT_ITEM", "(Lcom/tencent/mm/plugin/finder/live/model/MusicItem;)V", "TAG", "getTAG", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "descDataList", "getDescDataList", "setDescDataList", "isPagEnable", "", "kotlin.jvm.PlatformType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "itemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "pos", "musicItem", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "musicDataList", "getMusicDataList", "setMusicDataList", "onLongClickListener", "getOnLongClickListener", "setOnLongClickListener", "deleteMusicItem", "position", "getItemCount", "getItemViewType", "notifyMusicItemChange", "rawOriPos", "rawNewPos", "notifyMusicItemRemove", "onBindMusicCountHolder", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicCountViewHolder;", "onBindMusicHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicViewHolder;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "setPagViewState", "pagView", "Lorg/libpag/PAGView;", "musicState", "updateMusicList", "notifyDataSetChange", "AbsMuscViewHolder", "MusicCountViewHolder", "MusicViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RecyclerView.a<a>
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final Boolean CyU;
  final String DPN;
  public ArrayList<at> DPO;
  private at DPP;
  private ArrayList<at> DPQ;
  public q<? super View, ? super Integer, ? super at, ah> DPR;
  public q<? super View, ? super Integer, ? super at, ah> DPS;
  public final String TAG;
  private ArrayList<at> pUj;
  
  public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(358553);
    this.CvU = parama;
    this.TAG = "FinderLiveAnchorMusicAdapter";
    this.DPN = "finder_live_music_play.pag";
    this.pUj = new ArrayList();
    this.DPO = new ArrayList();
    this.DPP = new at(new bkh(), 0, 1, 16);
    this.DPQ = new ArrayList();
    this.CyU = ((cn)h.az(cn.class)).isPagEnable();
    parama = aw.Gjk;
    aw.aBW("FinderLiveAnchorMusicAdapter");
    this.DPO.add(this.DPP);
    this.DPQ.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eee.CDH);
    this.pUj.addAll((Collection)this.DPO);
    this.pUj.addAll((Collection)this.DPQ);
    AppMethodBeat.o(358553);
  }
  
  private static final void a(e parame, int paramInt, at paramat, View paramView)
  {
    AppMethodBeat.i(358583);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.sc(paramInt);
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramat, "$musicItem");
    Log.i(parame.TAG, "itemClickListener position:" + paramInt + ",descDataList.size:" + parame.DPO.size());
    localObject = parame.DPR;
    if (localObject != null)
    {
      s.s(paramView, "it");
      ((q)localObject).invoke(paramView, Integer.valueOf(paramInt - parame.DPO.size()), paramat);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358583);
  }
  
  private static final boolean b(e parame, int paramInt, at paramat, View paramView)
  {
    AppMethodBeat.i(358597);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.sc(paramInt);
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramat, "$musicItem");
    Log.i(parame.TAG, "onLongClickListener position:" + paramInt + ",descDataList.size:" + parame.DPO.size());
    localObject = parame.DPS;
    if (localObject != null)
    {
      s.s(paramView, "it");
      ((q)localObject).invoke(paramView, Integer.valueOf(paramInt - parame.DPO.size()), paramat);
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(358597);
    return true;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358625);
    int i = this.pUj.size();
    AppMethodBeat.o(358625);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(358619);
    paramInt = ((at)this.pUj.get(paramInt)).type;
    AppMethodBeat.o(358619);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;Landroid/view/View;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public class a
    extends RecyclerView.v
  {
    public a()
    {
      super();
      AppMethodBeat.i(358588);
      AppMethodBeat.o(358588);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicCountViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;Landroid/view/View;)V", "musicCount", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMusicCount", "()Landroid/widget/TextView;", "setMusicCount", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends e.a
  {
    TextView DPU;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(358610);
      this.DPU = ((TextView)localObject.findViewById(p.e.BYd));
      AppMethodBeat.o(358610);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$MusicViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter$AbsMuscViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicAdapter;Landroid/view/View;)V", "musicIcon", "Lorg/libpag/PAGView;", "kotlin.jvm.PlatformType", "getMusicIcon", "()Lorg/libpag/PAGView;", "setMusicIcon", "(Lorg/libpag/PAGView;)V", "musicName", "Landroid/widget/TextView;", "getMusicName", "()Landroid/widget/TextView;", "setMusicName", "(Landroid/widget/TextView;)V", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getPlayIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPlayIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "singer", "getSinger", "setSinger", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends e.a
  {
    PAGView DPV;
    TextView DPW;
    TextView DPX;
    WeImageView DPY;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(359115);
      this.DPV = ((PAGView)localObject.findViewById(p.e.music_icon));
      this.DPW = ((TextView)localObject.findViewById(p.e.BYt));
      this.DPX = ((TextView)localObject.findViewById(p.e.Cbi));
      this.DPY = ((WeImageView)localObject.findViewById(p.e.play_icon));
      this$1 = this.DPV;
      if (e.this != null) {
        e.this.setFile(PAGFile.Load(this.DPV.getContext().getAssets(), e.this.DPN));
      }
      this$1 = this.DPV;
      if (e.this != null) {
        e.this.setRepeatCount(0);
      }
      AppMethodBeat.o(359115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.e
 * JD-Core Version:    0.7.0.1
 */