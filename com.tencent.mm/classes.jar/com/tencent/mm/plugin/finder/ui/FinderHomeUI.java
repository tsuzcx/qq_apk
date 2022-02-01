package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.action.f.b;
import com.tencent.mm.plugin.finder.upload.action.f.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.aa;
import com.tencent.mm.plugin.finder.viewmodel.component.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.ah;
import com.tencent.mm.plugin.finder.viewmodel.component.ai;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "backToFindPage", "", "checkJumpFollow", "intent", "Landroid/content/Intent;", "checkJumpFriend", "checkJumpHot", "checkRoute", "finish", "getCommentScene", "", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isHideStatusBar", "", "jumpFinderPersonCenter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderHomeUI
  extends MMFinderUI
{
  public static final a Arp;
  private HashMap _$_findViewCache;
  private final d kKI;
  
  static
  {
    AppMethodBeat.i(235678);
    Arp = new a((byte)0);
    AppMethodBeat.o(235678);
  }
  
  public FinderHomeUI()
  {
    AppMethodBeat.i(235677);
    this.kKI = d.bcs();
    AppMethodBeat.o(235677);
  }
  
  private final void as(Intent paramIntent)
  {
    AppMethodBeat.i(235656);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false);; bool = false)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        ((as)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(as.class)).elA();
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(FinderHomeUIC.class);
        p.j(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        paramIntent.r(1, localBundle);
      }
      AppMethodBeat.o(235656);
      return;
    }
  }
  
  private final void at(Intent paramIntent)
  {
    AppMethodBeat.i(235659);
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);; bool = false)
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        ((as)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(as.class)).elA();
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(FinderHomeUIC.class);
        p.j(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        paramIntent.r(3, localBundle);
      }
      AppMethodBeat.o(235659);
      return;
    }
  }
  
  private final void au(Intent paramIntent)
  {
    AppMethodBeat.i(235664);
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
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        ((as)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(as.class)).elA();
        paramIntent = com.tencent.mm.ui.component.g.Xox;
        paramIntent = com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(FinderHomeUIC.class);
        p.j(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", i);
        paramIntent.a(bool2, localBundle);
      }
      AppMethodBeat.o(235664);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label30;
    }
  }
  
  private final void av(Intent paramIntent)
  {
    AppMethodBeat.i(235667);
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("KEY_ROUTE_TO_PAGE");; paramIntent = null)
    {
      Log.i("Finder.HomeUI", "checkRoute ".concat(String.valueOf(paramIntent)));
      if (p.h(ab.bO(FinderSelfUI.class).iCe(), paramIntent)) {
        eau();
      }
      AppMethodBeat.o(235667);
      return;
    }
  }
  
  private final void eau()
  {
    AppMethodBeat.i(235671);
    Log.i("Finder.HomeUI", "jumpFinderPersonCenter");
    Intent localIntent = new Intent();
    Object localObject = FinderSelfUI.Avb;
    localIntent.putExtra(FinderSelfUI.eaU(), true);
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    aj.a.a((Context)this, localIntent, 0L, 0, false, 124);
    localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)this, localIntent);
    AppMethodBeat.o(235671);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(235680);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(235680);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(235679);
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
    AppMethodBeat.o(235679);
    return localView1;
  }
  
  public final int duR()
  {
    return 1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(235654);
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.c((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.finder.report.s)))
      {
        localObject = (com.tencent.mm.plugin.finder.report.s)localObject;
        com.tencent.mm.plugin.finder.report.g.a locala = com.tencent.mm.plugin.finder.report.g.zUU;
        ((com.tencent.mm.plugin.finder.report.s)localObject).aEe(com.tencent.mm.plugin.finder.report.g.a.aa(kotlin.a.ae.d(kotlin.s.M("feedActionType", Integer.valueOf(5)))));
      }
    }
    if (getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("preferred_tab", 2);
      com.tencent.mm.by.c.f((Context)this, ".ui.LauncherUI", (Intent)localObject);
      overridePendingTransition(b.a.slide_left_in, b.a.slide_right_out);
      AppMethodBeat.o(235654);
      return;
    }
    super.finish();
    AppMethodBeat.o(235654);
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(235647);
    Object localObject = n.zWF;
    localObject = com.tencent.mm.ui.component.g.Xox;
    int i = n.Pz(((FinderHomeUIC)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(FinderHomeUIC.class)).ekL());
    AppMethodBeat.o(235647);
    return i;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_home_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(235643);
    Set localSet = ak.setOf(new Class[] { FinderHomeUIC.class, aa.class, com.tencent.mm.plugin.finder.viewmodel.component.j.class, r.class, com.tencent.mm.plugin.finder.viewmodel.component.ae.class, com.tencent.mm.plugin.finder.preload.c.class, com.tencent.mm.plugin.finder.viewmodel.component.aj.class, ah.class, ac.class, an.class, ai.class, al.class });
    AppMethodBeat.o(235643);
    return localSet;
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(235652);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 41L, 1L, false);
    if (getIntent().getBooleanExtra("key_form_sns", false))
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramBundle = (Context)this;
      Intent localIntent = new Intent();
      FinderSelfUI.a locala = FinderSelfUI.Avb;
      localIntent.putExtra(FinderSelfUI.eaV(), true);
      com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI(paramBundle, localIntent);
    }
    at(getIntent());
    as(getIntent());
    au(getIntent());
    av(getIntent());
    AppMethodBeat.o(235652);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(235676);
    super.onDestroy();
    if (!com.tencent.mm.q.a.q(null, false))
    {
      Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.T(true, true);
      localObject = com.tencent.mm.live.core.core.c.a.kqk;
      a.a.clear();
    }
    AppMethodBeat.o(235676);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(235651);
    super.onNewIntent(paramIntent);
    at(paramIntent);
    as(paramIntent);
    au(paramIntent);
    av(paramIntent);
    if (paramIntent != null)
    {
      getIntent().putExtra("KEY_POST_DIRECTLY_FROM_SNS", paramIntent.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false));
      getIntent().putExtra("key_finder_post_local_id", paramIntent.getLongExtra("key_finder_post_local_id", -1L));
      AppMethodBeat.o(235651);
      return;
    }
    AppMethodBeat.o(235651);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(235672);
    super.onPause();
    this.kKI.avz();
    AppMethodBeat.o(235672);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(235675);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (!com.tencent.mm.plugin.finder.utils.aj.isAnyHomeTabEnableFullScreenEnjoy())
    {
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject = getWindow();
      p.j(localObject, "window");
      if (com.tencent.mm.ui.ar.isDarkMode()) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.finder.utils.aj.b((Window)localObject, bool);
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = (FinderHomeUIC)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(FinderHomeUIC.class);
      ((FinderHomeUIC)localObject).getRootView().post((Runnable)new b((FinderHomeUIC)localObject));
      d.a(this.kKI, "Finder.HomeUI");
      AppMethodBeat.o(235675);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderHomeUIC paramFinderHomeUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(290223);
      Object localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABS;
      localObject1 = this.Arq.fragments;
      p.k(localObject1, "fragments");
      if (com.tencent.mm.plugin.finder.upload.action.f.ecA())
      {
        Log.i("Finder.FeedCleaner", "cleanTimeline return for record empty");
        AppMethodBeat.o(290223);
        return;
      }
      com.tencent.mm.plugin.finder.upload.action.f.ecz();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (FinderHomeTabFragment)localIterator.next();
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        FinderTimelineFeedLoader localFinderTimelineFeedLoader = ((com.tencent.mm.plugin.finder.viewmodel.component.ar)com.tencent.mm.ui.component.g.h((Fragment)localObject2).i(com.tencent.mm.plugin.finder.viewmodel.component.ar.class)).elz();
        localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABS;
        int i = ((FinderHomeTabFragment)localObject2).fEH;
        label121:
        List localList;
        if (localFinderTimelineFeedLoader != null)
        {
          localObject1 = localFinderTimelineFeedLoader.getDataList();
          localList = (List)localObject1;
          if (com.tencent.mm.plugin.finder.upload.action.f.QE(i)) {
            break label230;
          }
          Log.i("Finder.FeedCleaner", "cleanFeed: " + i + " return");
        }
        for (;;)
        {
          if (localFinderTimelineFeedLoader != null)
          {
            localObject1 = localFinderTimelineFeedLoader.dispatcher();
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.finder.feed.model.internal.f)localObject1).onChanged();
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABS;
          i = ((FinderHomeTabFragment)localObject2).fEH;
          if (com.tencent.mm.plugin.finder.upload.action.f.QE(i)) {
            break label440;
          }
          Log.i("Finder.FeedCleaner", "cleanTimelinePage: " + i + " return");
          break;
          localObject1 = null;
          break label121;
          label230:
          Object localObject3 = new StringBuilder("cleanFeed: ").append(i).append(" size: ");
          if (localList != null) {}
          for (localObject1 = Integer.valueOf(localList.size());; localObject1 = null)
          {
            Log.i("Finder.FeedCleaner", localObject1);
            localObject1 = new StringBuilder("followRecorder size: ");
            localObject3 = com.tencent.mm.plugin.finder.upload.action.f.ABN;
            if (localObject3 == null) {
              p.bGy("followRecorder");
            }
            localObject1 = ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.finder.upload.action.g)localObject3).ABW.size()).append(" noSeeAuthorRecorder:");
            localObject3 = com.tencent.mm.plugin.finder.upload.action.f.ABO;
            if (localObject3 == null) {
              p.bGy("noSeeAuthorRecorder");
            }
            Log.i("Finder.FeedCleaner", ((com.tencent.mm.plugin.finder.upload.action.g)localObject3).ABW.size());
            switch (i)
            {
            case 2: 
            default: 
              break;
            case 1: 
            case 4: 
              if (localList == null) {
                break;
              }
              kotlin.a.j.c(localList, (kotlin.g.a.b)f.c.ABV);
              break;
            }
          }
          if (localList != null) {
            kotlin.a.j.c(localList, (kotlin.g.a.b)f.b.ABU);
          }
        }
        label440:
        Log.i("Finder.FeedCleaner", "cleanTimelinePage: ".concat(String.valueOf(i)));
        switch (i)
        {
        case 2: 
        default: 
          break;
        case 1: 
        case 4: 
          if (i != 1) {}
        case 3: 
          for (i = 5;; i = 8)
          {
            localObject1 = k.Anu;
            localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABO;
            if (localObject1 == null) {
              p.bGy("noSeeAuthorRecorder");
            }
            k.a.p(i, kotlin.a.j.p((Iterable)((com.tencent.mm.plugin.finder.upload.action.g)localObject1).ABW));
            break;
            localObject1 = new HashSet();
            localObject2 = com.tencent.mm.plugin.finder.upload.action.f.ABN;
            if (localObject2 == null) {
              p.bGy("followRecorder");
            }
            ((HashSet)localObject1).addAll((Collection)((com.tencent.mm.plugin.finder.upload.action.g)localObject2).ABW);
            localObject2 = com.tencent.mm.plugin.finder.upload.action.f.ABO;
            if (localObject2 == null) {
              p.bGy("noSeeAuthorRecorder");
            }
            ((HashSet)localObject1).addAll((Collection)((com.tencent.mm.plugin.finder.upload.action.g)localObject2).ABW);
            localObject2 = k.Anu;
            k.a.p(7, kotlin.a.j.p((Iterable)localObject1));
            break;
          }
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABN;
      if (localObject1 == null) {
        p.bGy("followRecorder");
      }
      ((com.tencent.mm.plugin.finder.upload.action.g)localObject1).clear();
      localObject1 = com.tencent.mm.plugin.finder.upload.action.f.ABO;
      if (localObject1 == null) {
        p.bGy("noSeeAuthorRecorder");
      }
      ((com.tencent.mm.plugin.finder.upload.action.g)localObject1).clear();
      AppMethodBeat.o(290223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */