package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "followConfirmSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "isFollowed", "", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "topicHeader", "Landroid/view/View;", "addTopicHeader", "", "isShowTag", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "cloneTopicInfo", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$TopicInfo;", "topicStr", "", "confirmFollow", "createHotTopicLayout", "getTopicHeaderView", "getTopicMaxTextWidth", "getTopicTimelineHeaderView", "handleFollowAction", "onClickHotTopic", "optFakeTopics", "", "refreshHeader", "setFollowView", "setNewsText", "topicCount", "setViewFollowed", "Companion", "TopicInfo", "plugin-finder_release"})
public final class ad
{
  public static final a xzG;
  final MMActivity iXq;
  private final RefreshLoadMoreLayout xvJ;
  private final int xzD;
  private boolean xzE;
  private View xzF;
  
  static
  {
    AppMethodBeat.i(236287);
    xzG = new a((byte)0);
    AppMethodBeat.o(236287);
  }
  
  public ad(MMActivity paramMMActivity, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(236285);
    this.iXq = paramMMActivity;
    this.xvJ = paramRefreshLoadMoreLayout;
    this.xzD = 30000;
    AppMethodBeat.o(236285);
  }
  
  private final void My(int paramInt)
  {
    AppMethodBeat.i(236282);
    View localView1 = this.xzF;
    if (localView1 != null)
    {
      if (paramInt == 0)
      {
        localView2 = localView1.findViewById(b.f.topic_news_count_text);
        p.j(localView2, "findViewById<TextView>(R.id.topic_news_count_text)");
        ((TextView)localView2).setText((CharSequence)localView1.getContext().getString(b.j.finder_news_count_num, new Object[] { m.gY(2, 5) }));
        AppMethodBeat.o(236282);
        return;
      }
      View localView2 = localView1.findViewById(b.f.topic_news_count_text);
      p.j(localView2, "findViewById<TextView>(R.id.topic_news_count_text)");
      ((TextView)localView2).setText((CharSequence)localView1.getContext().getString(b.j.finder_news_count_num, new Object[] { m.gY(2, paramInt) }));
      AppMethodBeat.o(236282);
      return;
    }
    AppMethodBeat.o(236282);
  }
  
  private final void b(final bkr parambkr)
  {
    boolean bool = false;
    AppMethodBeat.i(236283);
    if (parambkr != null) {}
    for (int i = parambkr.followFlag;; i = 0)
    {
      if (i > 0) {
        bool = true;
      }
      this.xzE = bool;
      ot(this.xzE);
      Log.i("Finder.FinderNewsTopicHelper", "setFollowView topicHeader " + this.xzF);
      View localView = this.xzF;
      if (localView == null) {
        break;
      }
      localView.findViewById(b.f.topic_news_follow).setOnClickListener((View.OnClickListener)new b(this, parambkr));
      AppMethodBeat.o(236283);
      return;
    }
    AppMethodBeat.o(236283);
  }
  
  private final void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(236284);
    Log.i("Finder.FinderNewsTopicHelper", "setViewFollowed topicHeader " + this.xzF);
    View localView = this.xzF;
    if (localView != null)
    {
      if (paramBoolean)
      {
        ((TextView)localView.findViewById(b.f.topic_news_follow_text)).setText(b.j.has_follow_tip);
        localTextView = (TextView)localView.findViewById(b.f.topic_news_follow_text);
        localContext = localView.getContext();
        p.j(localContext, "context");
        localTextView.setTextColor(localContext.getResources().getColor(b.c.black));
        localView.findViewById(b.f.topic_news_follow).setBackgroundResource(b.e.finder_news_followed_bg);
        AppMethodBeat.o(236284);
        return;
      }
      ((TextView)localView.findViewById(b.f.topic_news_follow_text)).setText(b.j.to_follow_tip);
      TextView localTextView = (TextView)localView.findViewById(b.f.topic_news_follow_text);
      Context localContext = localView.getContext();
      p.j(localContext, "context");
      localTextView.setTextColor(localContext.getResources().getColor(b.c.white));
      localView.findViewById(b.f.topic_news_follow).setBackgroundResource(b.e.finder_news_follow_bg);
      AppMethodBeat.o(236284);
      return;
    }
    AppMethodBeat.o(236284);
  }
  
  public final void a(bkr parambkr)
  {
    AppMethodBeat.i(236281);
    Log.i("Finder.FinderNewsTopicHelper", "refreshHeader ".concat(String.valueOf(parambkr)));
    if (parambkr != null)
    {
      My(parambkr.feedCount);
      b(parambkr);
    }
    if (parambkr == null)
    {
      My(5);
      b(parambkr);
    }
    AppMethodBeat.o(236281);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(ad paramad, bkr parambkr) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289315);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      ad.a(this.xzH, parambkr);
      paramView = this.xzH;
      if (!ad.a(this.xzH)) {}
      for (boolean bool = true;; bool = false)
      {
        ad.a(paramView, bool);
        ad.b(this.xzH, ad.a(this.xzH));
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289315);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ad
 * JD-Core Version:    0.7.0.1
 */