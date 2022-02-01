package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderPostTransitUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "()V", "TAG", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPostTransitUI
  extends FinderPostUI
{
  private final String TAG = "FinderPostTransitUI";
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347376);
    Log.i(this.TAG, "FinderPostTransitUI onCreate");
    super.onCreate(paramBundle);
    AppMethodBeat.o(347376);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostTransitUI
 * JD-Core Version:    0.7.0.1
 */