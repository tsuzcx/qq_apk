package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.component.e.a;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$MusicViewHolder;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSearchMusicContract$Presenter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "i", "setFav", "favTips", "Landroid/widget/TextView;", "fav", "", "updateSuggestList", "suggests", "", "MusicViewHolder", "plugin-finder_release"})
public final class g
  extends RecyclerView.a<a>
{
  public ArrayList<aq> mXB;
  final e.a xZl;
  
  public g(e.a parama)
  {
    AppMethodBeat.i(291384);
    this.xZl = parama;
    this.mXB = new ArrayList();
    AppMethodBeat.o(291384);
  }
  
  private static void c(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(291383);
    if (paramBoolean)
    {
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      paramTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_anchor_music_fav_tips));
      localContext = paramTextView.getContext();
      p.j(localContext, "favTips.context");
      paramTextView.setTextColor(localContext.getResources().getColor(b.c.finder_live_logo_color));
      paramTextView.setEnabled(false);
      AppMethodBeat.o(291383);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    paramTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_anchor_music_waiting_fav_tips));
    localContext = paramTextView.getContext();
    p.j(localContext, "favTips.context");
    paramTextView.setTextColor(localContext.getResources().getColor(b.c.BW_0));
    paramTextView.setEnabled(true);
    AppMethodBeat.o(291383);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(291381);
    int i = this.mXB.size();
    AppMethodBeat.o(291381);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$MusicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter;Landroid/view/View;)V", "musicDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMusicDesc", "()Landroid/widget/TextView;", "setMusicDesc", "(Landroid/widget/TextView;)V", "musicFavTips", "getMusicFavTips", "setMusicFavTips", "plugin-finder_release"})
  public final class a
    extends RecyclerView.v
  {
    TextView yWm;
    TextView yWn;
    
    public a()
    {
      super();
      AppMethodBeat.i(234807);
      this.yWm = ((TextView)localObject.findViewById(b.f.music_desc));
      this.yWn = ((TextView)localObject.findViewById(b.f.fav_action));
      AppMethodBeat.o(234807);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(g paramg, g.a parama, aq paramaq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237925);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (!this.yWo.xZl.dxe())
      {
        paramView = this.yWp.amk;
        p.j(paramView, "holder.itemView");
        paramView = paramView.getContext();
        localObject = this.yWp.amk;
        p.j(localObject, "holder.itemView");
        localObject = ((View)localObject).getContext();
        p.j(localObject, "holder.itemView.context");
        w.makeText(paramView, (CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_anchor_music_oversize_tips), 0).show();
        a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(237925);
        return;
      }
      this.xZa.yio = 51;
      this.yWo.xZl.a(this.xZa);
      paramView = this.yWp.yWn;
      p.j(paramView, "holder.musicFavTips");
      g.r(paramView);
      a.a(this, "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveAnchorMusicSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237925);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.g
 * JD-Core Version:    0.7.0.1
 */