package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/SelectDistrictUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "()V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SelectDistrictUI
  extends FinderSelectDistrictUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.SelectDistrictUI
 * JD-Core Version:    0.7.0.1
 */