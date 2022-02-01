package com.tencent.mm.plugin.finder.feed.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderLoaderFeedUI$a
  implements MenuItem.OnMenuItemClickListener
{
  FinderLoaderFeedUI$a(FinderLoaderFeedUI paramFinderLoaderFeedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(166128);
    this.qzC.onBackPressed();
    AppMethodBeat.o(166128);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI.a
 * JD-Core Version:    0.7.0.1
 */