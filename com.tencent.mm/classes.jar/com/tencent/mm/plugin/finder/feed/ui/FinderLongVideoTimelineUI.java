package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoFavTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoLikeTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoNormalTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoProfileTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoShareTLUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.statusbar.d;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "router", "", "getRouter", "()I", "setRouter", "(I)V", "getCommentScene", "getForceOrientation", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public class FinderLongVideoTimelineUI
  extends MMFinderUI
{
  public static final a ubS;
  private HashMap _$_findViewCache;
  private int ubR;
  
  static
  {
    AppMethodBeat.i(245432);
    ubS = new a((byte)0);
    AppMethodBeat.o(245432);
  }
  
  public FinderLongVideoTimelineUI()
  {
    this.vPS = true;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245434);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245434);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245433);
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
    AppMethodBeat.o(245433);
    return localView1;
  }
  
  public final int ddN()
  {
    return 4;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245431);
    int i = a.IS(this.ubR);
    AppMethodBeat.o(245431);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245429);
    this.ubR = getIntent().getIntExtra("KEY_ROUTER_UI", 0);
    Object localObject;
    switch (this.ubR)
    {
    default: 
      localObject = FinderMegaVideoNormalTLUIC.class;
    }
    for (;;)
    {
      localObject = ak.setOf(new Class[] { localObject, FinderCommentDrawerUIC.class });
      AppMethodBeat.o(245429);
      return localObject;
      localObject = FinderMegaVideoNormalTLUIC.class;
      continue;
      localObject = FinderMegaVideoFavTLUIC.class;
      continue;
      localObject = FinderMegaVideoLikeTLUIC.class;
      continue;
      localObject = FinderMegaVideoProfileTLUIC.class;
      continue;
      localObject = FinderMegaVideoShareTLUIC.class;
      continue;
      localObject = FinderMegaVideoNormalTLUIC.class;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245430);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    d.e(getWindow());
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    setNavigationbarColor(getResources().getColor(2131101287));
    AppMethodBeat.o(245430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI$Companion;", "", "()V", "TAG", "", "getMegaVideoCommentScene", "", "router", "plugin-finder_release"})
  public static final class a
  {
    public static int IS(int paramInt)
    {
      int i = 45;
      switch (paramInt)
      {
      default: 
        i = 0;
      case 0: 
      case 5: 
        return i;
      case 1: 
        return 47;
      case 2: 
        return 46;
      case 3: 
        return 48;
      }
      return 53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI
 * JD-Core Version:    0.7.0.1
 */