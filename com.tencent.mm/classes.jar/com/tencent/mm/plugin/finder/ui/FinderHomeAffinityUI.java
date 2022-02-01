package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.r;
import kotlin.v;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "()V", "hasHookTransition", "", "isLagerThanAndroid12", "()Z", "isLagerThanAndroid12$delegate", "Lkotlin/Lazy;", "hookExitTransition", "", "isTaskRoot", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSwipeStartDrag", "edgeFlags", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderHomeAffinityUI
  extends FinderHomeUI
{
  private boolean FQP;
  private final j FQQ;
  
  public FinderHomeAffinityUI()
  {
    AppMethodBeat.i(347076);
    this.FQQ = k.cm((kotlin.g.a.a)FinderHomeAffinityUI.a.FQR);
    AppMethodBeat.o(347076);
  }
  
  private static final Map a(FinderHomeAffinityUI paramFinderHomeAffinityUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(347087);
    s.u(paramFinderHomeAffinityUI, "this$0");
    paramString = paramFinderHomeAffinityUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label208;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label208:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramFinderHomeAffinityUI = paramFinderHomeAffinityUI.getIntent();
      if (paramFinderHomeAffinityUI == null) {}
      for (paramFinderHomeAffinityUI = localObject2;; paramFinderHomeAffinityUI = paramFinderHomeAffinityUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderHomeAffinityUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramFinderHomeAffinityUI)) });
        AppMethodBeat.o(347087);
        return paramFinderHomeAffinityUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private final boolean fbi()
  {
    AppMethodBeat.i(347082);
    boolean bool = ((Boolean)this.FQQ.getValue()).booleanValue();
    AppMethodBeat.o(347082);
    return bool;
  }
  
  public final void TH(int paramInt)
  {
    AppMethodBeat.i(347105);
    super.TH(paramInt);
    if (paramInt == 1)
    {
      com.tencent.mm.ui.base.b.a((Activity)this, null);
      getSwipeBackLayout().Nl(true);
    }
    AppMethodBeat.o(347105);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean isTaskRoot()
  {
    AppMethodBeat.i(347118);
    if (this.FQP)
    {
      AppMethodBeat.o(347118);
      return false;
    }
    boolean bool = super.isTaskRoot();
    AppMethodBeat.o(347118);
    return bool;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(347114);
    if (fbi()) {}
    try
    {
      Object localObject1 = Activity.class.getDeclaredField("mActivityTransitionState");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(this);
      Field localField = Class.forName("android.app.ActivityTransitionState").getDeclaredField("mPendingExitNames");
      localField.setAccessible(true);
      localField.set(localObject1, new ArrayList());
      this.FQP = true;
      super.onBackPressed();
      AppMethodBeat.o(347114);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("Finder.HomeUI", "hookExitTransition: ", new Object[] { localObject2 });
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347099);
    if (!h.baz())
    {
      Log.e("Finder.HomeUI", "onCreate: acc has not ready");
      finishAndRemoveTask();
      AppMethodBeat.o(347099);
      return;
    }
    if (fbi()) {
      getWindow().requestFeature(12);
    }
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.svg.a.a.b(getContext().getResources(), e.g.icons_filled_finder, 3.0F);
    setTaskDescription(new ActivityManager.TaskDescription(getContext().getString(e.h.find_friends_by_finder), paramBundle, 0));
    if (fbi())
    {
      paramBundle = new Slide();
      paramBundle.setSlideEdge(5);
      getWindow().setEnterTransition((Transition)paramBundle);
    }
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgq);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderHomeAffinityUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(347099);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI
 * JD-Core Version:    0.7.0.1
 */