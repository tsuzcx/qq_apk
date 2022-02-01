package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileActionBarUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileDistrictTipUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileFloatBallUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder_release"})
public final class FinderProfileUI
  extends MMFinderUI
{
  private static final int ucA = 2001;
  public static final a ucB;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(166213);
    ucB = new a((byte)0);
    ucA = 2001;
    AppMethodBeat.o(166213);
  }
  
  public FinderProfileUI()
  {
    AppMethodBeat.i(166212);
    AppMethodBeat.o(166212);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245492);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245492);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245491);
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
    AppMethodBeat.o(245491);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    int j = 0;
    AppMethodBeat.i(245490);
    String str = getIntent().getStringExtra("finder_username");
    boolean bool = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    int i = j;
    if (p.j(str, z.aUg()))
    {
      i = j;
      if (bool) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(245490);
      return 33;
    }
    AppMethodBeat.o(245490);
    return 32;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245489);
    Set localSet = ak.setOf(new Class[] { FinderProfileTabUIC.class, FinderProfileActionBarUIC.class, FinderProfileHeaderUIC.class, FinderProfileDistrictTipUIC.class, FinderProfileEduUIC.class, FinderLivePostBtnUIC.class, FinderProfileFloatBallUIC.class });
    AppMethodBeat.o(245489);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$Companion;", "", "()V", "MARK_READ_PAYLOAD", "", "getMARK_READ_PAYLOAD", "()I", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI
 * JD-Core Version:    0.7.0.1
 */