package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.dp;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "MENU_ID_SET_NO_FOLLOW_CONFIRM", "", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "followConfirmSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "isFollowed", "", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "topicHeader", "Landroid/view/View;", "cloneTopicInfo", "Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$TopicInfo;", "topicInfo", "topicStr", "", "confirmFollow", "", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getTopicHeaderView", "isShowTag", "getTopicMaxTextWidth", "handleFollowAction", "onClickHotTopic", "optFakeTopics", "", "refreshHeader", "setFollowView", "setNewsText", "topicCount", "setViewFollowed", "Companion", "TopicInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final a AXd;
  private final RefreshLoadMoreLayout ATx;
  private final int AXe;
  private boolean AXf;
  private View AXg;
  final MMActivity lzt;
  
  static
  {
    AppMethodBeat.i(363122);
    AXd = new a((byte)0);
    AppMethodBeat.o(363122);
  }
  
  public ah(MMActivity paramMMActivity, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(363075);
    this.lzt = paramMMActivity;
    this.ATx = paramRefreshLoadMoreLayout;
    this.AXe = 30000;
    AppMethodBeat.o(363075);
  }
  
  private final void NF(int paramInt)
  {
    AppMethodBeat.i(363085);
    View localView = this.AXg;
    if (localView != null)
    {
      if (paramInt == 0)
      {
        ((TextView)localView.findViewById(e.e.topic_news_count_text)).setText((CharSequence)localView.getContext().getString(e.h.finder_news_count_num, new Object[] { r.ip(2, 5) }));
        AppMethodBeat.o(363085);
        return;
      }
      ((TextView)localView.findViewById(e.e.topic_news_count_text)).setText((CharSequence)localView.getContext().getString(e.h.finder_news_count_num, new Object[] { r.ip(2, paramInt) }));
    }
    AppMethodBeat.o(363085);
  }
  
  private static final void a(ah paramah, bxv parambxv, View paramView)
  {
    AppMethodBeat.i(363113);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramah);
    localb.cH(parambxv);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramah, "this$0");
    int i;
    if (parambxv != null)
    {
      if (paramah.AXf)
      {
        paramView = dp.ADn;
        i = dp.dVe();
        long l = parambxv.ADo;
        paramView = parambxv.ADp;
        parambxv = paramView;
        if (paramView == null) {
          parambxv = "";
        }
        paramView = k.aeZF;
        parambxv = new dp(l, parambxv, i, ((as)k.d((AppCompatActivity)paramah.lzt).q(as.class)).fou());
        h.aZW().a((p)parambxv, 0);
      }
    }
    else {
      if (paramah.AXf) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      paramah.AXf = bool;
      paramah.pV(paramah.AXf);
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(363113);
      return;
      paramView = dp.ADn;
      i = dp.dVd();
      break;
    }
  }
  
  private final void c(bxv parambxv)
  {
    boolean bool = false;
    AppMethodBeat.i(363095);
    if (parambxv == null) {}
    for (int i = 0;; i = parambxv.followFlag)
    {
      if (i > 0) {
        bool = true;
      }
      this.AXf = bool;
      pV(this.AXf);
      Log.i("Finder.FinderNewsTopicHelper", kotlin.g.b.s.X("setFollowView topicHeader ", this.AXg));
      View localView = this.AXg;
      if (localView != null) {
        localView.findViewById(e.e.topic_news_follow).setOnClickListener(new ah..ExternalSyntheticLambda0(this, parambxv));
      }
      AppMethodBeat.o(363095);
      return;
    }
  }
  
  private final void pV(boolean paramBoolean)
  {
    AppMethodBeat.i(363102);
    Log.i("Finder.FinderNewsTopicHelper", kotlin.g.b.s.X("setViewFollowed topicHeader ", this.AXg));
    View localView = this.AXg;
    if (localView != null)
    {
      if (paramBoolean)
      {
        ((TextView)localView.findViewById(e.e.topic_news_follow_text)).setText(e.h.has_follow_tip);
        ((TextView)localView.findViewById(e.e.topic_news_follow_text)).setTextColor(localView.getContext().getResources().getColor(e.b.black));
        localView.findViewById(e.e.topic_news_follow).setBackgroundResource(e.d.finder_news_followed_bg);
        AppMethodBeat.o(363102);
        return;
      }
      ((TextView)localView.findViewById(e.e.topic_news_follow_text)).setText(e.h.to_follow_tip);
      ((TextView)localView.findViewById(e.e.topic_news_follow_text)).setTextColor(localView.getContext().getResources().getColor(e.b.white));
      localView.findViewById(e.e.topic_news_follow).setBackgroundResource(e.d.finder_news_follow_bg);
    }
    AppMethodBeat.o(363102);
  }
  
  public final void b(bxv parambxv)
  {
    AppMethodBeat.i(363139);
    Log.i("Finder.FinderNewsTopicHelper", kotlin.g.b.s.X("refreshHeader ", parambxv));
    if (parambxv != null)
    {
      NF(parambxv.feedCount);
      c(parambxv);
    }
    if (parambxv == null)
    {
      NF(5);
      c(parambxv);
    }
    AppMethodBeat.o(363139);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderNewsTopicHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ah
 * JD-Core Version:    0.7.0.1
 */