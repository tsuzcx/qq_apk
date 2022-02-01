package com.tencent.mm.plugin.finder.feed.logic;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderScanPreviewLogic;", "", "()V", "isScanPreview", "", "shareScene", "", "modifyActionBar", "", "ui", "Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "modifyConvertUILogic", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Beq;
  
  static
  {
    AppMethodBeat.i(363743);
    Beq = new d();
    AppMethodBeat.o(363743);
  }
  
  public static boolean Oa(int paramInt)
  {
    return paramInt == 22;
  }
  
  public static void a(FinderShareFeedRelUI paramFinderShareFeedRelUI)
  {
    AppMethodBeat.i(363738);
    s.u(paramFinderShareFeedRelUI, "ui");
    paramFinderShareFeedRelUI.setMMTitle(e.h.finder_scan_preview_feed);
    View localView = paramFinderShareFeedRelUI.findViewById(e.e.backBtnIv);
    if ((localView instanceof WeImageView))
    {
      ((WeImageView)localView).setImageResource(e.g.icons_outlined_close);
      ((WeImageView)localView).setIconColor(paramFinderShareFeedRelUI.getResources().getColor(e.b.hot_tab_selected_color));
    }
    AppMethodBeat.o(363738);
  }
  
  public static void w(j paramj)
  {
    AppMethodBeat.i(363731);
    s.u(paramj, "holder");
    int j = a.w(paramj.context, e.b.finder_btn_fullscreen_disable_color);
    Object localObject = (WeImageView)paramj.UH(e.e.icon_feed_comment);
    int i;
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYE().bmg()).intValue() == 1)
      {
        i = 1;
        if (i == 0) {
          break label234;
        }
        ((WeImageView)localObject).setImageResource(e.g.finder_full_comment_outlined);
        label71:
        ((WeImageView)localObject).setIconColor(j);
      }
    }
    else
    {
      localObject = paramj.UH(e.e.comment_icon_container);
      if (localObject != null) {
        ((View)localObject).setEnabled(false);
      }
      localObject = (TextView)paramj.UH(e.e.comment_count_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(j);
      }
      localObject = (WeImageView)paramj.UH(e.e.icon_feed_like);
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(j);
      }
      localObject = paramj.UH(e.e.awesome_icon_container);
      if (localObject != null) {
        ((View)localObject).setEnabled(false);
      }
      localObject = (TextView)paramj.UH(e.e.like_count_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(j);
      }
      localObject = (ViewGroup)paramj.UH(e.e.finder_seek_bar_footer_layout);
      if (localObject != null) {
        break label244;
      }
    }
    label234:
    label244:
    for (localObject = null;; localObject = ((ViewGroup)localObject).findViewById(e.e.awesome_ground_layout))
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      paramj = paramj.UH(e.e.full_seek_bar_layout);
      if ((paramj != null) && ((paramj instanceof FinderFullSeekBarLayout))) {
        ((FinderFullSeekBarLayout)paramj).setHidePrivateLike(true);
      }
      AppMethodBeat.o(363731);
      return;
      i = 0;
      break;
      ((WeImageView)localObject).setImageResource(e.g.finder_full_comment);
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.d
 * JD-Core Version:    0.7.0.1
 */