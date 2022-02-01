package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.search.eventsearch.FinderActivitySearchLoader;
import com.tencent.mm.plugin.finder.search.ui.FinderSearchBaseUI;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI26;", "Lcom/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "feedloader", "Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader;", "getFeedloader", "()Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader;", "setFeedloader", "(Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchLoader;)V", "vc", "Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchViewConfig;", "getVc", "()Lcom/tencent/mm/plugin/finder/search/eventsearch/FinderActivitySearchViewConfig;", "enterActivityDescUI", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "i", "Landroid/content/Intent;", "requestCode", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/search/ui/IFinderSearchLoader;", "getViewConfig", "onActivityResult", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSelectActivity", "eventInfo", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI26
  extends FinderSearchBaseUI
{
  private final com.tencent.mm.plugin.finder.search.eventsearch.a Btb;
  public FinderActivitySearchLoader Btc;
  private final String TAG;
  
  public OccupyFinderUI26()
  {
    AppMethodBeat.i(365817);
    this.TAG = "Finder.FinderActivitySearchUI";
    this.Btb = new com.tencent.mm.plugin.finder.search.eventsearch.a();
    AppMethodBeat.o(365817);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final FinderActivitySearchLoader egc()
  {
    AppMethodBeat.i(365836);
    FinderActivitySearchLoader localFinderActivitySearchLoader = this.Btc;
    if (localFinderActivitySearchLoader != null)
    {
      AppMethodBeat.o(365836);
      return localFinderActivitySearchLoader;
    }
    s.bIx("feedloader");
    AppMethodBeat.o(365836);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.search.ui.a egd()
  {
    AppMethodBeat.i(365839);
    com.tencent.mm.plugin.finder.search.ui.a locala = (com.tencent.mm.plugin.finder.search.ui.a)egc();
    AppMethodBeat.o(365839);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_activity_search_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365857);
    setResult(-1, paramIntent);
    if ((paramInt2 == -1) && (!isFinishing())) {
      finish();
    }
    AppMethodBeat.o(365857);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365845);
    final FinderActivitySearchLoader localFinderActivitySearchLoader = new FinderActivitySearchLoader();
    localFinderActivitySearchLoader.BgZ = ((b)new a(this, localFinderActivitySearchLoader));
    ah localah = ah.aiuX;
    s.u(localFinderActivitySearchLoader, "<set-?>");
    this.Btc = localFinderActivitySearchLoader;
    super.onCreate(paramBundle);
    getAdapter().agOe = ((i.c)new b(this));
    AppMethodBeat.o(365845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "originSize", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, ah>
  {
    a(OccupyFinderUI26 paramOccupyFinderUI26, FinderActivitySearchLoader paramFinderActivitySearchLoader)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI26$onCreate$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements i.c<j>
  {
    b(OccupyFinderUI26 paramOccupyFinderUI26) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI26
 * JD-Core Version:    0.7.0.1
 */