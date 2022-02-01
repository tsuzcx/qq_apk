package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.post.PostEditUIC;
import com.tencent.mm.plugin.finder.ui.post.PostLocationUIC;
import com.tencent.mm.plugin.finder.ui.post.PostMainUIC;
import com.tencent.mm.plugin.finder.ui.post.SdkShareUIC;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@a(17)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderPostUI
  extends MMFinderUI
{
  private static final int udd = 10000;
  public static final a vNe;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(252601);
    vNe = new a((byte)0);
    udd = 10000;
    AppMethodBeat.o(252601);
  }
  
  public FinderPostUI()
  {
    AppMethodBeat.i(167543);
    AppMethodBeat.o(167543);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252603);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252603);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252602);
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
    AppMethodBeat.o(252602);
    return localView1;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252600);
    Set localSet = ak.setOf(new Class[] { SdkShareUIC.class, PostEditUIC.class, PostLocationUIC.class, PostMainUIC.class });
    AppMethodBeat.o(252600);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderPostUI$Companion;", "", "()V", "MENU_ID_POST", "", "getMENU_ID_POST", "()I", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostUI
 * JD-Core Version:    0.7.0.1
 */