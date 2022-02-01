package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderScanPreviewLogic;", "", "()V", "TAG", "", "isScanPreview", "", "shareScene", "", "modifyActionBar", "", "ui", "Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "modifyConvertUILogic", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderScanPreviewLogic";
  public static final d xFu;
  
  static
  {
    AppMethodBeat.i(276686);
    xFu = new d();
    TAG = "Finder.FinderScanPreviewLogic";
    AppMethodBeat.o(276686);
  }
  
  public static boolean MD(int paramInt)
  {
    return paramInt == 22;
  }
  
  public static void a(FinderShareFeedRelUI paramFinderShareFeedRelUI)
  {
    AppMethodBeat.i(276685);
    p.k(paramFinderShareFeedRelUI, "ui");
    paramFinderShareFeedRelUI.setMMTitle(b.j.finder_scan_preview_feed);
    View localView = paramFinderShareFeedRelUI.findViewById(b.f.backBtnIv);
    if ((localView instanceof WeImageView))
    {
      ((WeImageView)localView).setImageResource(b.i.icons_outlined_close);
      ((WeImageView)localView).setIconColor(paramFinderShareFeedRelUI.getResources().getColor(b.c.hot_tab_selected_color));
    }
    AppMethodBeat.o(276685);
  }
  
  public static void q(i parami)
  {
    AppMethodBeat.i(276684);
    p.k(parami, "holder");
    Object localObject = (ImageView)parami.RD(b.f.icon_feed_comment);
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(b.i.finder_full_comment);
    }
    localObject = (TextView)parami.RD(b.f.comment_count_tv);
    Context localContext;
    if (localObject != null)
    {
      localContext = parami.getContext();
      p.j(localContext, "holder.context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_3));
    }
    localObject = (TextView)parami.RD(b.f.like_count_tv);
    if (localObject != null)
    {
      localContext = parami.getContext();
      p.j(localContext, "holder.context");
      ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_3));
    }
    localObject = (ViewGroup)parami.RD(b.f.finder_seek_bar_footer_layout);
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).findViewById(b.f.awesome_ground_layout);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
    }
    parami = parami.RD(b.f.full_seek_bar_layout);
    if (parami != null)
    {
      if ((parami instanceof FinderFullSeekBarLayout)) {
        ((FinderFullSeekBarLayout)parami).setHidePrivateLike(true);
      }
      AppMethodBeat.o(276684);
      return;
    }
    AppMethodBeat.o(276684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.d
 * JD-Core Version:    0.7.0.1
 */