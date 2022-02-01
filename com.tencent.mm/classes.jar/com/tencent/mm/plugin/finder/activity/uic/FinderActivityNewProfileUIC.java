package com.tencent.mm.plugin.finder.activity.uic;

import android.arch.lifecycle.ViewModelProvider;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityNewProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTopicFeedLoader;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "topic", "", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "getCommentScene", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderActivityNewProfileUIC
  extends UIComponent
{
  private String dST;
  private av.a tqH;
  private av.b tqI;
  private FinderTopicFeedLoader tqJ;
  
  public FinderActivityNewProfileUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(242090);
    this.dST = "美女";
    AppMethodBeat.o(242090);
  }
  
  public final int getLayoutId()
  {
    return 2131494657;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242088);
    super.onCreate(paramBundle);
    paramBundle = a.PRN;
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = paramBundle.getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242088);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)a.b((AppCompatActivity)paramBundle).get(FinderReporterUIC.class)).dIx();
    paramBundle = new FinderTopicFeedLoader(7, this.dST, paramBundle);
    paramBundle.initFromCache(getIntent());
    this.tqJ = paramBundle;
    paramBundle = getFragment();
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = paramBundle.getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(242088);
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
      AppMethodBeat.o(242088);
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
    AppMethodBeat.o(242088);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242089);
    av.a locala = this.tqH;
    if (locala == null) {
      p.btv("presenter");
    }
    locala.onDetach();
    super.onDestroy();
    AppMethodBeat.o(242089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityNewProfileUIC
 * JD-Core Version:    0.7.0.1
 */