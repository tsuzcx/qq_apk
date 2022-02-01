package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFavAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initJumpFollow", "", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "Companion", "plugin-finder_release"})
public final class FinderHomeUI
  extends MMFinderUI
{
  public static final a sCN;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(204017);
    sCN = new a((byte)0);
    AppMethodBeat.o(204017);
  }
  
  private final void al(Intent paramIntent)
  {
    AppMethodBeat.i(204016);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);; bool = false)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.a.KiD;
        paramIntent = com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderHomeUIC.class);
        p.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        paramIntent.r(3, localBundle);
      }
      AppMethodBeat.o(204016);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204018);
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
    AppMethodBeat.o(204018);
    return localView1;
  }
  
  public final int cAZ()
  {
    AppMethodBeat.i(204013);
    Object localObject = h.soM;
    localObject = com.tencent.mm.ui.component.a.KiD;
    int i = h.Fa(((FinderHomeUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderHomeUIC.class)).cOp());
    AppMethodBeat.o(204013);
    return i;
  }
  
  public final int cBZ()
  {
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> cCu()
  {
    AppMethodBeat.i(204012);
    Set localSet = ak.setOf(new Class[] { FinderHomeUIC.class, FinderHomeActionBarUIC.class, FinderTouchMediaPreviewUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class, FinderFavAnimUIC.class });
    AppMethodBeat.o(204012);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204015);
    super.onCreate(paramBundle);
    e.ygI.idkeyStat(1279L, 41L, 1L, false);
    if (getIntent().getBooleanExtra("key_form_sns", false))
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramBundle = (Context)this;
      Intent localIntent = new Intent();
      FinderSelfUI.a locala = FinderSelfUI.sGL;
      localIntent.putExtra(FinderSelfUI.cKr(), true);
      com.tencent.mm.plugin.finder.utils.a.y(paramBundle, localIntent);
    }
    al(getIntent());
    AppMethodBeat.o(204015);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(204014);
    super.onNewIntent(paramIntent);
    al(paramIntent);
    getIntent().removeExtra("key_finder_post_local_id");
    AppMethodBeat.o(204014);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */