package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ht;
import com.tencent.mm.f.a.iw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.bb.b;
import com.tencent.mm.plugin.finder.feed.bb.c;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "emptyView", "Landroid/widget/FrameLayout;", "encryptedEventTopicId", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "feedStickyListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1;", "finderEventTopicId", "", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "retryView", "Landroid/widget/TextView;", "tabType", "", "topic", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "convertInnerTabType", "getCommentScene", "getLayoutId", "handleStickyEvent", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "initLoader", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "FinderHottestFeedLoader", "FinderNewestLoader", "plugin-finder_release"})
public final class FinderActivityContentUIC
  extends UIComponent
{
  public static final a wXz;
  private int fEH;
  private ProgressBar progressBar;
  private String topic;
  private FrameLayout wWY;
  public bb.b wXr;
  private bb.c wXs;
  private FinderTopicFeedLoader wXt;
  private long wXu;
  private String wXv;
  private TextView wXw;
  private final c wXx;
  private final b wXy;
  
  static
  {
    AppMethodBeat.i(289021);
    wXz = new a((byte)0);
    AppMethodBeat.o(289021);
  }
  
  public FinderActivityContentUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(289020);
    this.topic = "生活大爆炸";
    this.wXx = new c(this);
    this.wXy = new b(this);
    AppMethodBeat.o(289020);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_activity_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289016);
    super.onCreate(paramBundle);
    this.wXx.alive();
    int i;
    if ((getFragment() instanceof FinderHomeTabFragment))
    {
      paramBundle = getFragment();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(289016);
        throw paramBundle;
      }
      i = ((FinderHomeTabFragment)paramBundle).fEH;
      Log.i("SimpleUIComponent", "convertInnerTabType : ".concat(String.valueOf(i)));
      if (i != 0)
      {
        i = 2;
        this.fEH = i;
        this.wXu = getIntent().getLongExtra("key_activity_id", 0L);
        this.wXv = getIntent().getStringExtra("key_encrypted_topic_id");
        paramBundle = com.tencent.mm.ui.component.g.Xox;
        paramBundle = getFragment();
        if (paramBundle == null) {
          p.iCn();
        }
        paramBundle = ((aj)com.tencent.mm.ui.component.g.h(paramBundle).i(aj.class)).ekY();
        if (this.fEH != 1) {
          break label336;
        }
        paramBundle = new FinderHottestFeedLoader(this.topic, paramBundle);
        paramBundle.initFromCache(getIntent());
        paramBundle.xEv = paramBundle.xEv;
        paramBundle.xdR = this.wXu;
        paramBundle.xEG = this.wXv;
        paramBundle.xEw = this.fEH;
        paramBundle.xJH = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0L));
      }
    }
    for (this.wXt = ((FinderTopicFeedLoader)paramBundle);; this.wXt = ((FinderTopicFeedLoader)paramBundle))
    {
      paramBundle = new StringBuilder("feedLoader : ");
      localObject = this.wXt;
      if (localObject == null) {
        p.bGy("feedLoader");
      }
      paramBundle = paramBundle.append(localObject).append(" this.innerTabType : ");
      localObject = this.wXt;
      if (localObject == null) {
        p.bGy("feedLoader");
      }
      Log.i("SimpleUIComponent", ((FinderTopicFeedLoader)localObject).xEw);
      paramBundle = getActivity();
      if (paramBundle != null) {
        break label419;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(289016);
      throw paramBundle;
      i = 1;
      break;
      label336:
      paramBundle = new FinderNewestLoader(this.topic, paramBundle);
      paramBundle.initFromCache(getIntent());
      paramBundle.xEv = paramBundle.xEv;
      paramBundle.xdR = this.wXu;
      paramBundle.xEG = this.wXv;
      paramBundle.xEw = this.fEH;
      paramBundle.xJH = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0L));
    }
    label419:
    paramBundle = (MMActivity)paramBundle;
    Object localObject = this.wXt;
    if (localObject == null) {
      p.bGy("feedLoader");
    }
    paramBundle = new bb.b(paramBundle, (BaseFinderFeedLoader)localObject);
    paramBundle.aBE(paramBundle.topic);
    paramBundle.type = 7;
    this.wXr = paramBundle;
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(289016);
      throw paramBundle;
    }
    paramBundle = new bb.c((MMActivity)paramBundle, 59, (byte)0);
    paramBundle.aBE(paramBundle.topic);
    paramBundle.type = 7;
    localObject = getFragment();
    if (localObject == null) {
      p.iCn();
    }
    localObject = (RefreshLoadMoreLayout)((Fragment)localObject).getView().findViewById(b.f.rl_layout);
    p.j(localObject, "fragment!!.rl_layout");
    p.k(localObject, "<set-?>");
    paramBundle.xvJ = ((RefreshLoadMoreLayout)localObject);
    paramBundle.xvJ.setSuperNestedScroll(true);
    paramBundle.xEw = this.fEH;
    paramBundle.xEy = getRootView().findViewById(b.f.empty_view);
    this.wXs = paramBundle;
    localObject = getFragment();
    if (localObject != null)
    {
      paramBundle = this.wXs;
      if (paramBundle == null) {
        p.bGy("viewCallback");
      }
      p.k(localObject, "fragment");
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      localObject = aj.d((aj)com.tencent.mm.ui.component.g.h((Fragment)localObject).i(aj.class));
      if (localObject != null) {
        ((f)localObject).k(paramBundle.xvJ.getRecyclerView());
      }
    }
    paramBundle = this.wXs;
    if (paramBundle == null) {
      p.bGy("viewCallback");
    }
    localObject = this.wXr;
    if (localObject == null) {
      p.bGy("presenter");
    }
    paramBundle.a((c.a)localObject);
    paramBundle = this.wXr;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    localObject = this.wXs;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    paramBundle.a((c.b)localObject);
    this.wXw = ((TextView)getActivity().findViewById(b.f.retry_tip));
    this.wWY = ((FrameLayout)getActivity().findViewById(b.f.empty_view));
    this.progressBar = ((ProgressBar)getActivity().findViewById(b.f.activity_progress));
    paramBundle = this.wXw;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    }
    this.wXy.alive();
    Log.i("SimpleUIComponent", "finderEventTopicId:" + this.wXu + ", encryptedEventTopicId:" + this.wXv);
    AppMethodBeat.o(289016);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289019);
    bb.b localb = this.wXr;
    if (localb == null) {
      p.bGy("presenter");
    }
    localb.onDetach();
    super.onDestroy();
    this.wXx.dead();
    this.wXy.dead();
    AppMethodBeat.o(289019);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(289018);
    super.onPause();
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    int i = ((g)com.tencent.mm.ui.component.g.b(getActivity()).i(g.class)).elu();
    if (this.fEH - 1 == i)
    {
      localObject = this.wXt;
      if (localObject == null) {
        p.bGy("feedLoader");
      }
      ((FinderTopicFeedLoader)localObject).xJI = this.fEH;
    }
    Log.i("SimpleUIComponent", "onPause activeIndex :".concat(String.valueOf(i)));
    AppMethodBeat.o(289018);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(289017);
    super.onResume();
    Log.i("SimpleUIComponent", "onResume");
    FinderTopicFeedLoader localFinderTopicFeedLoader = this.wXt;
    if (localFinderTopicFeedLoader == null) {
      p.bGy("feedLoader");
    }
    localFinderTopicFeedLoader.xJI = -1;
    AppMethodBeat.o(289017);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$FinderHottestFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "topicType", "", "topicContent", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getTopicType", "()I", "interceptPostStart", "", "plugin-finder_release"})
  public final class FinderHottestFeedLoader
    extends FinderTopicFeedLoader
  {
    private final int wXA;
    private final String wXB;
    
    public FinderHottestFeedLoader(bid parambid)
    {
      super(parambid, localbid);
      AppMethodBeat.i(269369);
      this.wXA = 7;
      this.wXB = parambid;
      AppMethodBeat.o(269369);
    }
    
    public final boolean interceptPostStart()
    {
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$FinderNewestLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "topicType", "", "topicContent", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getTopicType", "()I", "onPostStart", "", "localId", "", "plugin-finder_release"})
  public final class FinderNewestLoader
    extends FinderTopicFeedLoader
  {
    private final int wXA;
    private final String wXB;
    
    public FinderNewestLoader(bid parambid)
    {
      super(parambid, localbid);
      AppMethodBeat.i(286515);
      this.wXA = 7;
      this.wXB = parambid;
      AppMethodBeat.o(286515);
    }
    
    public final void onPostStart(long paramLong)
    {
      AppMethodBeat.i(286514);
      super.onPostStart(paramLong);
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      FinderTabUIC.a((g)com.tencent.mm.ui.component.g.b(FinderActivityContentUIC.this.getActivity()).i(g.class), 1);
      AppMethodBeat.o(286514);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$Companion;", "", "()V", "HOTTEST", "", "LATEST", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<ht>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<iw>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderActivityContentUIC paramFinderActivityContentUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290453);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("SimpleUIComponent", "progressBar FinderActivityContentUIC visible");
      paramView = FinderActivityContentUIC.a(this.wXC);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = FinderActivityContentUIC.b(this.wXC);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      FinderActivityContentUIC.c(this.wXC).dsm();
      a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC
 * JD-Core Version:    0.7.0.1
 */