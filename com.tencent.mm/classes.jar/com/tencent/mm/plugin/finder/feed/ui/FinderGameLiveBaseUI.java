package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.FinderGameEventListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveBaseUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "gameEventListener", "Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "getGameEventListener", "()Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "setGameEventListener", "(Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderGameLiveBaseUI
  extends MMFinderUI
{
  public FinderGameEventListener BnV;
  
  public void _$_clearFindViewByIdCache() {}
  
  public final FinderGameEventListener eeY()
  {
    FinderGameEventListener localFinderGameEventListener = this.BnV;
    if (localFinderGameEventListener != null) {
      return localFinderGameEventListener;
    }
    s.bIx("gameEventListener");
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new FinderGameEventListener(new WeakReference(this));
    s.u(paramBundle, "<set-?>");
    this.BnV = paramBundle;
    eeY().alive();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    eeY().dead();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveBaseUI
 * JD-Core Version:    0.7.0.1
 */