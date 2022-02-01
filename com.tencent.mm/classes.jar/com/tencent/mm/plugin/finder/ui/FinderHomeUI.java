package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "backToFindPage", "", "checkJumpFollow", "intent", "Landroid/content/Intent;", "checkJumpFriend", "checkJumpHot", "finish", "getCommentScene", "", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isHideStatusBar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onResume", "Companion", "plugin-finder_release"})
public final class FinderHomeUI
  extends MMFinderUI
{
  public static final a vKx;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(252431);
    vKx = new a((byte)0);
    AppMethodBeat.o(252431);
  }
  
  private final void an(Intent paramIntent)
  {
    AppMethodBeat.i(252427);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);; bool = false)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).dIQ();
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        paramIntent = com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderHomeUIC.class);
        p.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        paramIntent.p(1, localBundle);
      }
      AppMethodBeat.o(252427);
      return;
    }
  }
  
  private final void ao(Intent paramIntent)
  {
    AppMethodBeat.i(252428);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);; bool = false)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).dIQ();
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        paramIntent = com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderHomeUIC.class);
        p.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        paramIntent.p(3, localBundle);
      }
      AppMethodBeat.o(252428);
      return;
    }
  }
  
  private final void ap(Intent paramIntent)
  {
    AppMethodBeat.i(252429);
    boolean bool1;
    boolean bool2;
    if (paramIntent != null)
    {
      bool1 = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
      if (paramIntent == null) {
        break label147;
      }
      bool2 = paramIntent.getBooleanExtra("KEY_FINDER_JUMP_HOT_TAB_WITH_ANIM", true);
      label30:
      if (paramIntent == null) {
        break label153;
      }
    }
    label147:
    label153:
    for (int i = paramIntent.getIntExtra("Source", 0);; i = 0)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", bool1);
      }
      if (bool1)
      {
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).dIQ();
        paramIntent = com.tencent.mm.ui.component.a.PRN;
        paramIntent = com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderHomeUIC.class);
        p.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", i);
        paramIntent.a(bool2, localBundle);
      }
      AppMethodBeat.o(252429);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label30;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252433);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252433);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252432);
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
    AppMethodBeat.o(252432);
    return localView1;
  }
  
  public final int ddN()
  {
    return 1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252426);
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.c((FinderReporterUIC)localObject);
      if ((localObject != null) && ((localObject instanceof o)))
      {
        localObject = (o)localObject;
        e.a locala = com.tencent.mm.plugin.finder.report.e.vdS;
        ((o)localObject).auL(e.a.ah(ae.b(s.U("feedActionType", Integer.valueOf(5)))));
      }
    }
    if (getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("preferred_tab", 2);
      c.f((Context)this, ".ui.LauncherUI", (Intent)localObject);
      overridePendingTransition(2130772165, 2130772170);
      AppMethodBeat.o(252426);
      return;
    }
    super.finish();
    AppMethodBeat.o(252426);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(252423);
    Object localObject = k.vfA;
    localObject = com.tencent.mm.ui.component.a.PRN;
    int i = k.Kw(((FinderHomeUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderHomeUIC.class)).dIf());
    AppMethodBeat.o(252423);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131494342;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(252422);
    Set localSet = ak.setOf(new Class[] { FinderHomeUIC.class, FinderHomeActionBarUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class, FinderLikeGuideUIC.class });
    AppMethodBeat.o(252422);
    return localSet;
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252425);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 41L, 1L, false);
    if (getIntent().getBooleanExtra("key_form_sns", false))
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramBundle = (Context)this;
      Intent localIntent = new Intent();
      FinderSelfUI.a locala = FinderSelfUI.vOh;
      localIntent.putExtra(FinderSelfUI.dAe(), true);
      com.tencent.mm.plugin.finder.utils.a.z(paramBundle, localIntent);
    }
    ao(getIntent());
    an(getIntent());
    ap(getIntent());
    AppMethodBeat.o(252425);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(252424);
    super.onNewIntent(paramIntent);
    ao(paramIntent);
    an(paramIntent);
    ap(paramIntent);
    if (paramIntent != null)
    {
      getIntent().putExtra("KEY_POST_DIRECTLY_FROM_SNS", paramIntent.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false));
      getIntent().putExtra("key_finder_post_local_id", paramIntent.getLongExtra("key_finder_post_local_id", -1L));
      AppMethodBeat.o(252424);
      return;
    }
    AppMethodBeat.o(252424);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252430);
    super.onResume();
    Object localObject = y.vXH;
    if (!y.isAnyHomeTabEnableFullScreenEnjoy())
    {
      localObject = y.vXH;
      localObject = getWindow();
      p.g(localObject, "window");
      if (ao.isDarkMode()) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      y.b((Window)localObject, bool);
      AppMethodBeat.o(252430);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */