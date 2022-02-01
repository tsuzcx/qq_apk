package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "initAfterAttach", "", "initOnCreate", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderBaseGridFeedUI<V extends c.b, P extends c.a>
  extends MMFinderUI
{
  private static final boolean a(FinderBaseGridFeedUI paramFinderBaseGridFeedUI, MenuItem paramMenuItem)
  {
    s.u(paramFinderBaseGridFeedUI, "this$0");
    paramFinderBaseGridFeedUI.onBackPressed();
    return true;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public abstract P dVa();
  
  public abstract V dVb();
  
  public abstract void initOnCreate();
  
  public void onBackPressed()
  {
    if (!dVa().onBackPressed()) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initOnCreate();
    setBackBtn(new FinderBaseGridFeedUI..ExternalSyntheticLambda0(this));
    dVa().a(dVb());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dVa().onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    dVa().onUIPause();
  }
  
  public void onResume()
  {
    super.onResume();
    dVa().onUIResume();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderBaseGridFeedUI
 * JD-Core Version:    0.7.0.1
 */