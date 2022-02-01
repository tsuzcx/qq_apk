package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "followConfirmSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "isFollowed", "", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "topicHeader", "Landroid/view/View;", "addTopicHeader", "", "isShowTag", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "cloneTopicInfo", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$TopicInfo;", "topicStr", "", "confirmFollow", "createHotTopicLayout", "getTopicHeaderView", "getTopicMaxTextWidth", "getTopicTimelineHeaderView", "handleFollowAction", "onClickHotTopic", "optFakeTopics", "", "refreshHeader", "setFollowView", "setNewsText", "topicCount", "setViewFollowed", "Companion", "TopicInfo", "plugin-finder_release"})
public final class y
{
  public static final a tOU;
  final MMActivity gte;
  private final RefreshLoadMoreLayout tLS;
  private final int tOR;
  private boolean tOS;
  private View tOT;
  
  static
  {
    AppMethodBeat.i(244006);
    tOU = new a((byte)0);
    AppMethodBeat.o(244006);
  }
  
  public y(MMActivity paramMMActivity, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(244005);
    this.gte = paramMMActivity;
    this.tLS = paramRefreshLoadMoreLayout;
    this.tOR = 30000;
    AppMethodBeat.o(244005);
  }
  
  private final void IH(int paramInt)
  {
    AppMethodBeat.i(244002);
    View localView1 = this.tOT;
    if (localView1 != null)
    {
      if (paramInt == 0)
      {
        localView2 = localView1.findViewById(2131309346);
        p.g(localView2, "findViewById<TextView>(R.id.topic_news_count_text)");
        ((TextView)localView2).setText((CharSequence)localView1.getContext().getString(2131760327, new Object[] { k.gm(2, 5) }));
        AppMethodBeat.o(244002);
        return;
      }
      View localView2 = localView1.findViewById(2131309346);
      p.g(localView2, "findViewById<TextView>(R.id.topic_news_count_text)");
      ((TextView)localView2).setText((CharSequence)localView1.getContext().getString(2131760327, new Object[] { k.gm(2, paramInt) }));
      AppMethodBeat.o(244002);
      return;
    }
    AppMethodBeat.o(244002);
  }
  
  private final void b(final bds parambds)
  {
    boolean bool = false;
    AppMethodBeat.i(244003);
    if (parambds != null) {}
    for (int i = parambds.followFlag;; i = 0)
    {
      if (i > 0) {
        bool = true;
      }
      this.tOS = bool;
      mZ(this.tOS);
      Log.i("Finder.FinderNewsTopicHelper", "setFollowView topicHeader " + this.tOT);
      View localView = this.tOT;
      if (localView == null) {
        break;
      }
      localView.findViewById(2131309347).setOnClickListener((View.OnClickListener)new b(this, parambds));
      AppMethodBeat.o(244003);
      return;
    }
    AppMethodBeat.o(244003);
  }
  
  private final void mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(244004);
    Log.i("Finder.FinderNewsTopicHelper", "setViewFollowed topicHeader " + this.tOT);
    View localView = this.tOT;
    if (localView != null)
    {
      if (paramBoolean)
      {
        ((TextView)localView.findViewById(2131309348)).setText(2131761616);
        localTextView = (TextView)localView.findViewById(2131309348);
        localContext = localView.getContext();
        p.g(localContext, "context");
        localTextView.setTextColor(localContext.getResources().getColor(2131100042));
        localView.findViewById(2131309347).setBackgroundResource(2131232677);
        AppMethodBeat.o(244004);
        return;
      }
      ((TextView)localView.findViewById(2131309348)).setText(2131766785);
      TextView localTextView = (TextView)localView.findViewById(2131309348);
      Context localContext = localView.getContext();
      p.g(localContext, "context");
      localTextView.setTextColor(localContext.getResources().getColor(2131101424));
      localView.findViewById(2131309347).setBackgroundResource(2131232676);
      AppMethodBeat.o(244004);
      return;
    }
    AppMethodBeat.o(244004);
  }
  
  public final void a(bds parambds)
  {
    AppMethodBeat.i(244001);
    Log.i("Finder.FinderNewsTopicHelper", "refreshHeader ".concat(String.valueOf(parambds)));
    if (parambds != null)
    {
      IH(parambds.LzC);
      b(parambds);
    }
    if (parambds == null)
    {
      IH(5);
      b(parambds);
    }
    AppMethodBeat.o(244001);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(y paramy, bds parambds) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244000);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      y.a(this.tOV, parambds);
      paramView = this.tOV;
      if (!y.a(this.tOV)) {}
      for (boolean bool = true;; bool = false)
      {
        y.a(paramView, bool);
        y.b(this.tOV, y.a(this.tOV));
        a.a(this, "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$setFollowView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(244000);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y
 * JD-Core Version:    0.7.0.1
 */