package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.feed.jumper.k;
import com.tencent.mm.plugin.finder.feed.jumper.l;
import com.tencent.mm.plugin.finder.feed.jumper.r;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedAdCommonJumperObserver;", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$FeedJumperObserver;", "()V", "onBindView", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "jumpView", "Landroid/view/View;", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "source", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f.b
{
  public static final a BbX;
  
  static
  {
    AppMethodBeat.i(364063);
    BbX = new a((byte)0);
    AppMethodBeat.o(364063);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, View paramView, k paramk, String paramString)
  {
    AppMethodBeat.i(364085);
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramj, "holder");
    s.u(paramView, "jumpView");
    s.u(paramk, "infoEx");
    s.u(paramString, "source");
    FinderJumpInfo localFinderJumpInfo = paramk.hVf;
    Log.i("Finder.FeedAdCommonJumperObserver", "[onBindView] hashCode:" + hashCode() + " position: " + paramj.getPosition() + " feedId=" + d.hF(this.feedId) + " jumpType=" + localFinderJumpInfo.jumpinfo_type + " title=" + localFinderJumpInfo.recommend_reason + '|' + localFinderJumpInfo.wording + " icon_url=" + localFinderJumpInfo.icon_url + " ext_info=" + localFinderJumpInfo.ext_info + ' ');
    WeImageView localWeImageView = (WeImageView)paramView.findViewById(e.e.finder_feed_ad_icon);
    TextView localTextView = (TextView)paramView.findViewById(e.e.finder_feed_ad_title);
    localWeImageView.clearColorFilter();
    localWeImageView.setLayerPaint(null);
    localWeImageView.setIconColor(0);
    paramBaseFinderFeed = paramk.Bea;
    label276:
    Object localObject;
    if (paramBaseFinderFeed == null)
    {
      paramBaseFinderFeed = null;
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = r.Bej;
        paramBaseFinderFeed = new com.tencent.mm.plugin.finder.feed.jumper.j();
        paramBaseFinderFeed.iconUrl = localFinderJumpInfo.icon_url;
      }
      switch (localFinderJumpInfo.business_type)
      {
      default: 
        localObject = ah.aiuX;
        s.s(localWeImageView, "iconView");
        r.a(paramBaseFinderFeed, localWeImageView, paramj);
        paramBaseFinderFeed = r.Bej;
        paramBaseFinderFeed = paramj.context;
        s.s(paramBaseFinderFeed, "holder.context");
        localTextView.setText((CharSequence)r.a(paramBaseFinderFeed, localFinderJumpInfo));
        paramBaseFinderFeed = localTextView.getText();
        if ((paramBaseFinderFeed != null) && (paramBaseFinderFeed.length() != 0)) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label472;
      }
      paramView.setVisibility(8);
      Log.w("Finder.FeedAdCommonJumperObserver", "title is null.");
      AppMethodBeat.o(364085);
      return;
      localObject = r.Bej;
      s.s(localWeImageView, "iconView");
      r.a(paramBaseFinderFeed, localWeImageView, paramj);
      if ((paramBaseFinderFeed instanceof l)) {
        localObject = r.Bej;
      }
      for (paramBaseFinderFeed = (CharSequence)r.a(paramj, (l)paramBaseFinderFeed);; paramBaseFinderFeed = paramBaseFinderFeed.title)
      {
        localTextView.setText(paramBaseFinderFeed);
        paramBaseFinderFeed = ah.aiuX;
        break;
      }
      paramBaseFinderFeed.BdY = e.d.icons_filled_tencent_video;
      paramBaseFinderFeed.BdZ = 0;
      break label276;
      paramBaseFinderFeed.BdY = e.g.icons_filled_sticker;
      paramBaseFinderFeed.BdZ = e.b.Yellow;
      break label276;
    }
    label472:
    paramView.setVisibility(0);
    if (s.p(paramString, "comment")) {
      localTextView.setTextColor(localTextView.getContext().getResources().getColor(e.b.Link_100));
    }
    for (;;)
    {
      paramBaseFinderFeed = z.FrZ;
      paramBaseFinderFeed = paramj.context;
      s.s(paramBaseFinderFeed, "holder.context");
      z.a(paramBaseFinderFeed, this.feedId, "universal_jumpinfo", paramk);
      AppMethodBeat.o(364085);
      return;
      localTextView.setTextColor(Color.parseColor("#DEE9FF"));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FeedAdCommonJumperObserver$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.b
 * JD-Core Version:    0.7.0.1
 */