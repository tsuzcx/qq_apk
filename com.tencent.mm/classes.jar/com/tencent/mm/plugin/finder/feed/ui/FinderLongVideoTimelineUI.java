package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.megavideo.uic.b;
import com.tencent.mm.plugin.finder.megavideo.uic.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.j;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "router", "", "getRouter", "()I", "setRouter", "(I)V", "getCommentScene", "getForceOrientation", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public class FinderLongVideoTimelineUI
  extends MMFinderUI
{
  public static final a xQK;
  private HashMap _$_findViewCache;
  public int xQJ;
  
  static
  {
    AppMethodBeat.i(285807);
    xQK = new a((byte)0);
    AppMethodBeat.o(285807);
  }
  
  public FinderLongVideoTimelineUI()
  {
    this.AwU = true;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285809);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285809);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(285808);
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
    AppMethodBeat.o(285808);
    return localView1;
  }
  
  public final int duR()
  {
    return 4;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(285806);
    int i = a.MP(this.xQJ);
    AppMethodBeat.o(285806);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(285802);
    this.xQJ = getIntent().getIntExtra("KEY_ROUTER_UI", 0);
    Object localObject;
    switch (this.xQJ)
    {
    case 4: 
    default: 
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.d.class;
    }
    for (;;)
    {
      localObject = ak.setOf(new Class[] { localObject, j.class });
      AppMethodBeat.o(285802);
      return localObject;
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.d.class;
      continue;
      localObject = b.class;
      continue;
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.c.class;
      continue;
      localObject = e.class;
      continue;
      localObject = com.tencent.mm.plugin.finder.megavideo.uic.d.class;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(285805);
    super.onBackPressed();
    overridePendingTransition(b.a.anim_not_change, b.a.sight_slide_bottom_out);
    AppMethodBeat.o(285805);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(285804);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1792);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    setNavigationbarColor(getResources().getColor(b.c.transparent));
    com.tencent.mm.danmaku.a.c.h(getApplication());
    AppMethodBeat.o(285804);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI$Companion;", "", "()V", "TAG", "", "getMegaVideoCommentScene", "", "router", "plugin-finder_release"})
  public static final class a
  {
    public static int MP(int paramInt)
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