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
import com.tencent.mm.plugin.finder.report.i;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "checkJumpFollow", "", "intent", "Landroid/content/Intent;", "checkJumpHot", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "Companion", "plugin-finder_release"})
public final class FinderHomeUI
  extends MMFinderUI
{
  public static final FinderHomeUI.a sNM;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(204613);
    sNM = new FinderHomeUI.a((byte)0);
    AppMethodBeat.o(204613);
  }
  
  private final void am(Intent paramIntent)
  {
    AppMethodBeat.i(204612);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);; bool = false)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.a.KEX;
        paramIntent = com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderHomeUIC.class);
        p.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        paramIntent.r(3, localBundle);
      }
      AppMethodBeat.o(204612);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204614);
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
    AppMethodBeat.o(204614);
    return localView1;
  }
  
  public final int cCL()
  {
    AppMethodBeat.i(204609);
    Object localObject = i.syT;
    localObject = com.tencent.mm.ui.component.a.KEX;
    int i = i.Fw(((FinderHomeUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderHomeUIC.class)).cQU());
    AppMethodBeat.o(204609);
    return i;
  }
  
  public final int cDL()
  {
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(204608);
    Set localSet = ak.setOf(new Class[] { FinderHomeUIC.class, FinderHomeActionBarUIC.class, FinderTouchMediaPreviewUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class, FinderFavAnimUIC.class });
    AppMethodBeat.o(204608);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204611);
    super.onCreate(paramBundle);
    e.ywz.idkeyStat(1279L, 41L, 1L, false);
    if (getIntent().getBooleanExtra("key_form_sns", false))
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramBundle = (Context)this;
      Intent localIntent = new Intent();
      FinderSelfUI.a locala = FinderSelfUI.sRG;
      localIntent.putExtra(FinderSelfUI.cMU(), true);
      com.tencent.mm.plugin.finder.utils.a.y(paramBundle, localIntent);
    }
    am(getIntent());
    AppMethodBeat.o(204611);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(204610);
    super.onNewIntent(paramIntent);
    am(paramIntent);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);; bool = false)
    {
      Object localObject = getIntent();
      if (localObject != null) {
        ((Intent)localObject).putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", bool);
      }
      if (bool)
      {
        localObject = com.tencent.mm.ui.component.a.KEX;
        localObject = com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderHomeUIC.class);
        p.g(localObject, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        localObject = (FinderHomeUIC)localObject;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        ((FinderHomeUIC)localObject).r(4, localBundle);
      }
      if (paramIntent == null) {
        break;
      }
      getIntent().putExtra("key_finder_post_local_id", paramIntent.getLongExtra("key_finder_post_local_id", -1L));
      AppMethodBeat.o(204610);
      return;
    }
    AppMethodBeat.o(204610);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */