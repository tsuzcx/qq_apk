package com.tencent.mm.plugin.finder.nearby.live.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderVideoLiveFeedConvert;", "Lcom/tencent/mm/plugin/finder/nearby/live/convert/NearbyFinderSquareLiveFeedConvert;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "bindLive", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  private final Context context;
  
  public c(Context paramContext)
  {
    super(15, paramContext.getResources().getDimension(e.c.finder_0_25_A), false, true, paramContext);
    AppMethodBeat.i(340859);
    this.context = paramContext;
    AppMethodBeat.o(340859);
  }
  
  public final void j(j paramj, BaseFinderFeed paramBaseFinderFeed)
  {
    int i = 1;
    AppMethodBeat.i(340869);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "feed");
    super.j(paramj, paramBaseFinderFeed);
    FinderLiveOnliveWidget localFinderLiveOnliveWidget = (FinderLiveOnliveWidget)paramj.UH(e.e.finder_live_mask_view);
    View localView = paramj.UH(e.e.finder_live_onlive_widget_top);
    paramj = (TextView)paramj.UH(e.e.finder_desc);
    if (paramBaseFinderFeed.feedObject.isLiveFeed())
    {
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getLiveInfo();
      if ((paramBaseFinderFeed != null) && (paramBaseFinderFeed.liveStatus == 1)) {}
      while (i != 0)
      {
        localFinderLiveOnliveWidget.setVisibility(8);
        localView.setVisibility(0);
        paramj.setVisibility(8);
        AppMethodBeat.o(340869);
        return;
        i = 0;
      }
      localFinderLiveOnliveWidget.setVisibility(0);
      localView.setVisibility(8);
      AppMethodBeat.o(340869);
      return;
    }
    localFinderLiveOnliveWidget.setVisibility(8);
    localView.setVisibility(8);
    AppMethodBeat.o(340869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.convert.c
 * JD-Core Version:    0.7.0.1
 */