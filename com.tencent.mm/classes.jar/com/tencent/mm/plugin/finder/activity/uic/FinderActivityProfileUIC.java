package com.tencent.mm.plugin.finder.activity.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.av.a;
import com.tencent.mm.plugin.finder.feed.av.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTopicFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "finderEventTopicId", "", "isStickyChanged", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "topic", "", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderActivityProfileUIC
  extends UIComponent
{
  private String dST;
  private av.a tqH;
  private av.b tqI;
  private FinderTopicFeedLoader tqJ;
  private long tqK;
  
  public FinderActivityProfileUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(242114);
    this.dST = "生活大爆炸";
    AppMethodBeat.o(242114);
  }
  
  public final int getLayoutId()
  {
    return 2131494657;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242113);
    super.onCreate(paramBundle);
    this.tqK = getIntent().getLongExtra("key_activity_id", 0L);
    paramBundle = a.PRN;
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = paramBundle.getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242113);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)a.b((AppCompatActivity)paramBundle).get(FinderReporterUIC.class)).dIx();
    paramBundle = new FinderTopicFeedLoader(7, this.dST, paramBundle);
    paramBundle.initFromCache(getIntent());
    paramBundle.tTG = paramBundle.tTG;
    paramBundle.twd = this.tqK;
    paramBundle.tXN = Long.valueOf(getIntent().getLongExtra("key_feed_ref_id", 0L));
    this.tqJ = paramBundle;
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = paramBundle.getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242113);
      throw paramBundle;
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
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = paramBundle.getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242113);
      throw paramBundle;
    }
    paramBundle = new av.b((MMActivity)paramBundle, 26, (byte)0);
    paramBundle.atn(paramBundle.dST);
    paramBundle.type = 7;
    localObject = getFragment();
    if (localObject == null) {
      p.hyc();
    }
    localObject = (RefreshLoadMoreLayout)((Fragment)localObject).getView().findViewById(2131307118);
    p.g(localObject, "fragment!!.rl_layout");
    paramBundle.setRlLayout((RefreshLoadMoreLayout)localObject);
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
    AppMethodBeat.o(242113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityProfileUIC
 * JD-Core Version:    0.7.0.1
 */