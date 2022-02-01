package com.tencent.mm.plugin.finder.feed.component;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedAdPosJumperObserver;", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$FeedJumperObserver;", "()V", "onBindView", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "jumpView", "Landroid/view/View;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "source", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends f.b
{
  public static final a EIY;
  
  static
  {
    AppMethodBeat.i(370858);
    EIY = new a((byte)0);
    AppMethodBeat.o(370858);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, j paramj, View paramView, com.tencent.mm.plugin.finder.feed.jumper.k paramk, String paramString)
  {
    AppMethodBeat.i(370860);
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    s.u(paramString, "source");
    paramBaseFinderFeed = (TextView)paramView.findViewById(e.e.strong_red_packet_tv);
    if (paramBaseFinderFeed != null)
    {
      paramBaseFinderFeed.setText((CharSequence)paramk.hVf.wording);
      if ((paramk.hVf.banner_type != 1) && (paramk.hVf.banner_type != 2)) {
        break label185;
      }
    }
    label185:
    for (float f = 0.5F;; f = 1.0F)
    {
      paramBaseFinderFeed.setAlpha(f);
      Log.i("FeedAdPosJumperObserver", "onBindView: wording = " + paramk.hVf.wording + ", banner_type = " + paramk.hVf.banner_type);
      if (paramView.getVisibility() != 0)
      {
        paramView.setVisibility(0);
        paramView.setAlpha(0.0F);
        paramView.animate().alpha(1.0F).setDuration(280L).start();
      }
      AppMethodBeat.o(370860);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedAdPosJumperObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.k
 * JD-Core Version:    0.7.0.1
 */