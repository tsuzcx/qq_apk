package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveTagFragment;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveTagUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;)V", "commitFragment", "", "finish", "getLayoutId", "", "getReportTag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "plugin-finder-live_release"})
public final class FinderLiveTagUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderLiveTagUI";
  private HashMap _$_findViewCache;
  private FinderLiveTagFragment xPW;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233208);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233208);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233206);
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
    AppMethodBeat.o(233206);
    return localView1;
  }
  
  public final String dvl()
  {
    return this.TAG;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(233201);
    Object localObject = this.xPW;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(233201);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_visitor_fragment_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233189);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.xPW = new FinderLiveTagFragment();
    paramBundle = this.xPW;
    if (paramBundle != null)
    {
      i locali = getSupportFragmentManager().beginTransaction();
      p.j(locali, "supportFragmentManager.beginTransaction()");
      locali.b(b.f.fragment_container, (Fragment)paramBundle);
      locali.iq();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(233189);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233198);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(233198);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233194);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(233194);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233192);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(233192);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(233190);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(233190);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233195);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(233195);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveTagUI
 * JD-Core Version:    0.7.0.1
 */