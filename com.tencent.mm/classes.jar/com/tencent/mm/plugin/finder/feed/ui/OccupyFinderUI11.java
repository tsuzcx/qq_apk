package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.nearby.NearbyActionBarUIC;
import com.tencent.mm.plugin.finder.nearby.NearbyHomeUIC;
import com.tencent.mm.plugin.finder.nearby.report.c;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI11;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finish", "", "getReportType", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI11
  extends MMFinderUI
{
  public static final a udZ;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(245661);
    udZ = new a((byte)0);
    AppMethodBeat.o(245661);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245663);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245663);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245662);
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
    AppMethodBeat.o(245662);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245659);
    d locald = d.uTq;
    d.dlC();
    super.finish();
    AppMethodBeat.o(245659);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245656);
    Set localSet = ak.setOf(new Class[] { NearbyHomeUIC.class, NearbyActionBarUIC.class, FinderReporterUIC.class });
    AppMethodBeat.o(245656);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245658);
    super.onCreate(paramBundle);
    paramBundle = as.uOL;
    as.startTimer();
    AppMethodBeat.o(245658);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245660);
    super.onDestroy();
    Object localObject = as.uOL;
    as.stopTimer();
    localObject = c.uTk;
    c.clear();
    AppMethodBeat.o(245660);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245657);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(245657);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI11$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI11
 * JD-Core Version:    0.7.0.1
 */