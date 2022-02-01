package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finish", "", "getReportTag", "", "getReportType", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder-nearby_release"})
public final class NearbyUI
  extends MMFinderUI
{
  public static final a zCQ;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(201012);
    zCQ = new a((byte)0);
    AppMethodBeat.o(201012);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(201017);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(201017);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(201015);
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
    AppMethodBeat.o(201015);
    return localView1;
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final String dvl()
  {
    return "NearbyUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(201005);
    com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.dMB();
    super.finish();
    AppMethodBeat.o(201005);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(201001);
    Set localSet = ak.setOf(new Class[] { e.class, c.class, b.class });
    AppMethodBeat.o(201001);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201003);
    super.onCreate(paramBundle);
    paramBundle = au.zBf;
    au.startTimer();
    AppMethodBeat.o(201003);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201007);
    super.onDestroy();
    Object localObject = au.zBf;
    au.stopTimer();
    localObject = d.zJm;
    d.clear();
    if (!com.tencent.mm.q.a.q(null, false))
    {
      localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.T(true, true);
      localObject = com.tencent.mm.live.core.core.c.a.kqk;
      a.a.clear();
    }
    AppMethodBeat.o(201007);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(201002);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(201002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.NearbyUI
 * JD-Core Version:    0.7.0.1
 */