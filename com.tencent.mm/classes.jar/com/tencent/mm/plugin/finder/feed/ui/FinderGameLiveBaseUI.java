package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.n;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGameLiveBaseUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "gameEventListener", "Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "getGameEventListener", "()Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "setGameEventListener", "(Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public abstract class FinderGameLiveBaseUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  public n xNU;
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final n dvi()
  {
    n localn = this.xNU;
    if (localn == null) {
      p.bGy("gameEventListener");
    }
    return localn;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.xNU = new n(new WeakReference(this));
    paramBundle = this.xNU;
    if (paramBundle == null) {
      p.bGy("gameEventListener");
    }
    paramBundle.alive();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    n localn = this.xNU;
    if (localn == null) {
      p.bGy("gameEventListener");
    }
    localn.dead();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveBaseUI
 * JD-Core Version:    0.7.0.1
 */