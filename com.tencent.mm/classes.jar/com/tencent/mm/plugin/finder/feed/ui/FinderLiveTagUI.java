package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveTagFragment;
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
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveTagUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;)V", "commitFragment", "", "finish", "getLayoutId", "", "getReportTag", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTagUI
  extends MMFinderUI
{
  private FinderLiveTagFragment BpK;
  private final String TAG = "Finder.FinderLiveTagUI";
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(365409);
    Object localObject = this.BpK;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(365409);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfY;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365365);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.BpK = new FinderLiveTagFragment();
    paramBundle = this.BpK;
    if (paramBundle != null)
    {
      r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(p.e.fragment_container, (Fragment)paramBundle);
      localr.FY();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(365365);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365399);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(365399);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(365387);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(365387);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365380);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(365380);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(365373);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(365373);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(365392);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(365392);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveTagUI
 * JD-Core Version:    0.7.0.1
 */