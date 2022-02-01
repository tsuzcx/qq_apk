package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI1;", "Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "()V", "plugin-finder_release"})
public final class OccupyFinderUI1
  extends FinderSelectDistrictUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI1
 * JD-Core Version:    0.7.0.1
 */