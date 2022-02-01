package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.component.n.a;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$MusicViewHolder;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "setFav", "favTips", "Landroid/widget/TextView;", "fav", "", "updateSuggestList", "suggests", "", "MusicViewHolder", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.a<a>
{
  private final n.a Cxs;
  public ArrayList<at> pUj;
  
  public g(n.a parama)
  {
    AppMethodBeat.i(358580);
    this.Cxs = parama;
    this.pUj = new ArrayList();
    AppMethodBeat.o(358580);
  }
  
  private static final void a(g paramg, a parama, at paramat, View paramView)
  {
    AppMethodBeat.i(358606);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(parama);
    localb.cH(paramat);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    s.u(parama, "$holder");
    s.u(paramat, "$musicItem");
    if (!paramg.Cxs.ehL())
    {
      aa.makeText(parama.caK.getContext(), (CharSequence)parama.caK.getContext().getResources().getString(p.h.Cik), 0).show();
      a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(358606);
      return;
    }
    paramat.CIv = 51;
    paramg.Cxs.a(paramat);
    paramg = parama.DQd;
    s.s(paramg, "holder.musicFavTips");
    e(paramg, true);
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358606);
  }
  
  private static void e(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(358595);
    if (paramBoolean)
    {
      paramTextView.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Cih));
      paramTextView.setTextColor(paramTextView.getContext().getResources().getColor(p.b.finder_live_logo_color));
      paramTextView.setEnabled(false);
      AppMethodBeat.o(358595);
      return;
    }
    paramTextView.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Cin));
    paramTextView.setTextColor(paramTextView.getContext().getResources().getColor(p.b.BW_0));
    paramTextView.setEnabled(true);
    AppMethodBeat.o(358595);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358624);
    int i = this.pUj.size();
    AppMethodBeat.o(358624);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$MusicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;Landroid/view/View;)V", "musicDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMusicDesc", "()Landroid/widget/TextView;", "setMusicDesc", "(Landroid/widget/TextView;)V", "musicFavTips", "getMusicFavTips", "setMusicFavTips", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    TextView DQc;
    TextView DQd;
    
    public a()
    {
      super();
      AppMethodBeat.i(359125);
      this.DQc = ((TextView)localObject.findViewById(p.e.BYe));
      this.DQd = ((TextView)localObject.findViewById(p.e.BEd));
      AppMethodBeat.o(359125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.g
 * JD-Core Version:    0.7.0.1
 */