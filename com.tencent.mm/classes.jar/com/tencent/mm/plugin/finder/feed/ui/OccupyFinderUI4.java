package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI4;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI4
  extends MMFinderUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365515);
    super.onCreate(paramBundle);
    setMMTitle("");
    AppMethodBeat.o(365515);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI4
 * JD-Core Version:    0.7.0.1
 */