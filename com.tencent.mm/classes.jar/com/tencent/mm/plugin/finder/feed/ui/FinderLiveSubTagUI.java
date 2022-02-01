package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveSubTagFragment;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveSubTagUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveSubTagFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveSubTagFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveSubTagFragment;)V", "commitFragment", "", "finish", "getLayoutId", "", "getReportTag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSubTagUI
  extends MMFinderUI
{
  private FinderLiveSubTagFragment BpJ;
  private final String TAG = "Finder.FinderLiveSubTagUI";
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(364865);
    Object localObject = this.BpJ;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(364865);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfY;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364817);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.BpJ = new FinderLiveSubTagFragment();
    paramBundle = this.BpJ;
    if (paramBundle != null)
    {
      r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(p.e.fragment_container, (Fragment)paramBundle);
      localr.FY();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(364817);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364845);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(364845);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364834);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(364834);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364828);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(364828);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(364820);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(364820);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(364841);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(364841);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveSubTagUI
 * JD-Core Version:    0.7.0.1
 */