package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.plugin.finder.accessibility.i;
import com.tencent.mm.plugin.finder.accessibility.j;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.viewmodel.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;)V", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBusinessPermissionDenied", "permission", "onBusinessPermissionGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLiveAnchorWithoutAffinityUI
  extends MMFinderUI
{
  public boolean BoA;
  private FinderLiveAnchorFragment BoB;
  private final String TAG = "FinderLiveAnchorWithoutAffinityUI";
  
  public void _$_clearFindViewByIdCache() {}
  
  public void finish()
  {
    AppMethodBeat.i(365083);
    Object localObject = this.BoB;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    overridePendingTransition(p.a.anim_not_change, p.a.sight_slide_bottom_out);
    AppMethodBeat.o(365083);
  }
  
  public int getLayoutId()
  {
    return p.f.CcO;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365059);
    Set localSet = ar.setOf(new Class[] { k.class, j.class, i.class });
    AppMethodBeat.o(365059);
    return localSet;
  }
  
  public void onBusinessPermissionDenied(String paramString)
  {
    AppMethodBeat.i(365097);
    s.u(paramString, "permission");
    if (s.p(paramString, d.c.actx.value))
    {
      finish();
      AppMethodBeat.o(365097);
      return;
    }
    s.p(paramString, d.c.acty.value);
    AppMethodBeat.o(365097);
  }
  
  public void onBusinessPermissionGranted(String paramString)
  {
    AppMethodBeat.i(365093);
    s.u(paramString, "permission");
    if (s.p(paramString, d.c.actx.value))
    {
      paramString = aj.CGT;
      paramString = aj.getLiveCore();
      if ((paramString instanceof b)) {}
      for (paramString = (b)paramString; paramString != null; paramString = null)
      {
        Object localObject = aj.CGT;
        localObject = aj.bhX();
        aj localaj = aj.CGT;
        paramString.a((com.tencent.mm.live.core.b.a)localObject, aj.bhY());
        AppMethodBeat.o(365093);
        return;
      }
    }
    if (s.p(paramString, d.c.acty.value))
    {
      paramString = aj.CGT;
      paramString = aj.getLiveCore();
      if (!(paramString instanceof b)) {
        break label127;
      }
    }
    label127:
    for (paramString = (b)paramString;; paramString = null)
    {
      if (paramString != null) {
        paramString.startLocalAudio(true);
      }
      AppMethodBeat.o(365093);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365026);
    supportRequestWindowFeature(1);
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).checkFinishWhenDiffTask((Activity)this);
    }
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.BoB = new FinderLiveAnchorFragment();
    paramBundle = this.BoB;
    if (paramBundle != null) {
      paramBundle.CDr = false;
    }
    paramBundle = this.BoB;
    if (paramBundle != null)
    {
      localObject = getSupportFragmentManager().beginTransaction();
      s.s(localObject, "supportFragmentManager.beginTransaction()");
      ((r)localObject).b(p.e.fragment_container, (Fragment)paramBundle);
      ((r)localObject).FY();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(365026);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(365054);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(365054);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(365040);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(365040);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(365035);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(365035);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(365029);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(365029);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(365049);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(365049);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(365075);
    super.onSwipeBack();
    this.BoA = true;
    AppMethodBeat.o(365075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI
 * JD-Core Version:    0.7.0.1
 */