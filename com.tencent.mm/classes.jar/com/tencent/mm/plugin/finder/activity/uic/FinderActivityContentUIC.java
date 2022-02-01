package com.tencent.mm.plugin.finder.activity.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.av.a;
import com.tencent.mm.plugin.finder.feed.av.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "emptyView", "Landroid/widget/FrameLayout;", "encryptedEventTopicId", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "feedStickyListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1;", "finderEventTopicId", "", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "retryView", "Landroid/widget/TextView;", "topic", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "convertInnerTabType", "", "getCommentScene", "getLayoutId", "handleStickyEvent", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderActivityContentUIC
  extends UIComponent
{
  private String dST;
  private ProgressBar progressBar;
  public av.a tqH;
  private av.b tqI;
  private FinderTopicFeedLoader tqJ;
  private long tqK;
  private String tqL;
  private TextView tqM;
  private final b tqN;
  private final a tqO;
  private FrameLayout tqq;
  
  public FinderActivityContentUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242050);
    this.dST = "生活大爆炸";
    this.tqN = new b(this);
    this.tqO = new a(this);
    AppMethodBeat.o(242050);
  }
  
  public final int getLayoutId()
  {
    return 2131494199;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242048);
    super.onCreate(paramBundle);
    this.tqN.alive();
    this.tqK = getIntent().getLongExtra("key_activity_id", 0L);
    this.tqL = getIntent().getStringExtra("key_encrypted_topic_id");
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242048);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramBundle).get(FinderReporterUIC.class)).dIx();
    int i;
    if ((getFragment() instanceof FinderHomeTabFragment))
    {
      localObject = getFragment();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        AppMethodBeat.o(242048);
        throw paramBundle;
      }
      i = ((FinderHomeTabFragment)localObject).dLS;
      Log.i("SimpleUIComponent", "convertInnerTabType : ".concat(String.valueOf(i)));
      i += 1;
    }
    for (;;)
    {
      paramBundle = new FinderTopicFeedLoader(7, this.dST, paramBundle);
      paramBundle.initFromCache(getIntent());
      paramBundle.tTG = paramBundle.tTG;
      paramBundle.twd = this.tqK;
      paramBundle.tTQ = this.tqL;
      paramBundle.tTH = i;
      paramBundle.tXN = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0L));
      this.tqJ = paramBundle;
      paramBundle = new StringBuilder("feedLoader : ");
      localObject = this.tqJ;
      if (localObject == null) {
        p.btv("feedLoader");
      }
      paramBundle = paramBundle.append(localObject).append(" this.innerTabType : ");
      localObject = this.tqJ;
      if (localObject == null) {
        p.btv("feedLoader");
      }
      Log.i("SimpleUIComponent", ((FinderTopicFeedLoader)localObject).tTH);
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242048);
      throw paramBundle;
      i = 1;
    }
    paramBundle = (MMActivity)paramBundle;
    Object localObject = this.tqJ;
    if (localObject == null) {
      p.btv("feedLoader");
    }
    paramBundle = new av.a(paramBundle, (BaseFinderFeedLoader)localObject);
    paramBundle.atn(paramBundle.dST);
    paramBundle.type = 7;
    this.tqH = paramBundle;
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242048);
      throw paramBundle;
    }
    paramBundle = new av.b((MMActivity)paramBundle, 59, (byte)0);
    paramBundle.atn(paramBundle.dST);
    paramBundle.type = 7;
    localObject = (RefreshLoadMoreLayout)((FragmentActivity)getActivity()).findViewById(2131307118);
    p.g(localObject, "activity.rl_layout");
    paramBundle.setRlLayout((RefreshLoadMoreLayout)localObject);
    paramBundle.tTH = i;
    this.tqI = paramBundle;
    paramBundle = this.tqI;
    if (paramBundle == null) {
      p.btv("viewCallback");
    }
    localObject = this.tqH;
    if (localObject == null) {
      p.btv("presenter");
    }
    paramBundle.a((c.a)localObject);
    paramBundle = this.tqH;
    if (paramBundle == null) {
      p.btv("presenter");
    }
    localObject = this.tqI;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    paramBundle.a((c.b)localObject);
    this.tqM = ((TextView)getActivity().findViewById(2131307047));
    this.tqq = ((FrameLayout)getActivity().findViewById(2131300111));
    this.progressBar = ((ProgressBar)getActivity().findViewById(2131296482));
    paramBundle = this.tqM;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    }
    this.tqO.alive();
    Log.i("SimpleUIComponent", "finderEventTopicId:" + this.tqK + ", encryptedEventTopicId:" + this.tqL);
    AppMethodBeat.o(242048);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242049);
    av.a locala = this.tqH;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onDetach();
    super.onDestroy();
    this.tqN.dead();
    this.tqO.dead();
    AppMethodBeat.o(242049);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$feedStickyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hm>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<ih>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderActivityContentUIC paramFinderActivityContentUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242047);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("SimpleUIComponent", "progressBar FinderActivityContentUIC visible");
      paramView = FinderActivityContentUIC.a(this.tqP);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = FinderActivityContentUIC.b(this.tqP);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      FinderActivityContentUIC.c(this.tqP).dbY();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityContentUIC$onCreate$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityContentUIC
 * JD-Core Version:    0.7.0.1
 */