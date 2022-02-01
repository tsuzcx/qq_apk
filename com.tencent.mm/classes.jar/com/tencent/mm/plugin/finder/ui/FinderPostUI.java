package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.ui.post.b;
import com.tencent.mm.plugin.finder.live.ui.post.d;
import com.tencent.mm.plugin.finder.live.ui.post.e;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@com.tencent.mm.ui.base.a(17)
@com.tencent.mm.ui.widget.pulldown.c(0)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderPostUI
  extends MMFinderUI
{
  public static final a AtW;
  private static final int xSK = 10000;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(270563);
    AtW = new a((byte)0);
    xSK = 10000;
    AppMethodBeat.o(270563);
  }
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    AppMethodBeat.o(167543);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(270565);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(270565);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(270564);
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
    AppMethodBeat.o(270564);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(270562);
    Set localSet = ak.setOf(new Class[] { e.class, com.tencent.mm.plugin.finder.live.ui.post.a.class, b.class, com.tencent.mm.plugin.finder.live.ui.post.c.class, d.class });
    AppMethodBeat.o(270562);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167528);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    AppMethodBeat.o(167528);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI$Companion;", "", "()V", "MENU_ID_POST", "", "getMENU_ID_POST", "()I", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */