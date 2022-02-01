package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.f.a.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.t;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.report.m.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.action.f.b;
import com.tencent.mm.plugin.finder.upload.action.f.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.af;
import com.tencent.mm.plugin.finder.viewmodel.component.al;
import com.tencent.mm.plugin.finder.viewmodel.component.aq;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.av;
import com.tencent.mm.plugin.finder.viewmodel.component.ay;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.finder.viewmodel.component.bd;
import com.tencent.mm.plugin.finder.viewmodel.component.be;
import com.tencent.mm.plugin.finder.viewmodel.component.bf;
import com.tencent.mm.plugin.finder.viewmodel.component.i;
import com.tencent.mm.plugin.finder.viewmodel.d.a;
import com.tencent.mm.plugin.findersdk.a.ap;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "()V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "isFinishBySwipe", "", "backToFindPage", "", "backToMainPage", "checkAppPush", "intent", "Landroid/content/Intent;", "checkJumpFollow", "checkJumpFriend", "fromNewIntent", "checkJumpHot", "checkRoute", "checkShareToTimeline", "finish", "getCommentScene", "", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isHideStatusBar", "jumpFinderPersonCenter", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onResume", "onSwipeBack", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderHomeUI
  extends MMFinderFeedDetailUI
{
  public static final a FQS;
  private boolean FQT;
  private final com.tencent.mm.model.d nmW;
  
  static
  {
    AppMethodBeat.i(346970);
    FQS = new a((byte)0);
    AppMethodBeat.o(346970);
  }
  
  public FinderHomeUI()
  {
    AppMethodBeat.i(346905);
    this.nmW = new com.tencent.mm.model.d();
    AppMethodBeat.o(346905);
  }
  
  private static final void a(FinderHomeUIC paramFinderHomeUIC)
  {
    Object localObject1 = null;
    AppMethodBeat.i(346957);
    kotlin.g.b.s.u(paramFinderHomeUIC, "$this_apply");
    Object localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcR;
    paramFinderHomeUIC = paramFinderHomeUIC.fragments;
    kotlin.g.b.s.u(paramFinderHomeUIC, "fragments");
    if (com.tencent.mm.plugin.finder.upload.action.f.feg())
    {
      Log.i("Finder.FeedCleaner", "cleanTimeline return for record empty");
      AppMethodBeat.o(346957);
      return;
    }
    com.tencent.mm.plugin.finder.upload.action.f.fef();
    Iterator localIterator = ((Iterable)paramFinderHomeUIC).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (FinderHomeTabFragment)localIterator.next();
      paramFinderHomeUIC = com.tencent.mm.ui.component.k.aeZF;
      FinderTimelineFeedLoader localFinderTimelineFeedLoader = ((bd)com.tencent.mm.ui.component.k.y((Fragment)localObject3).q(bd.class)).fpq();
      paramFinderHomeUIC = com.tencent.mm.plugin.finder.upload.action.f.GcR;
      int i = ((FinderHomeTabFragment)localObject3).hJx;
      label125:
      List localList;
      if (localFinderTimelineFeedLoader == null)
      {
        paramFinderHomeUIC = null;
        localList = (List)paramFinderHomeUIC;
        if (com.tencent.mm.plugin.finder.upload.action.f.TN(i)) {
          break label238;
        }
        Log.i("Finder.FeedCleaner", "cleanFeed: " + i + " return");
      }
      for (;;)
      {
        if (localFinderTimelineFeedLoader != null)
        {
          paramFinderHomeUIC = localFinderTimelineFeedLoader.dispatcher();
          if (paramFinderHomeUIC != null) {
            paramFinderHomeUIC.onChanged();
          }
        }
        paramFinderHomeUIC = com.tencent.mm.plugin.finder.upload.action.f.GcR;
        i = ((FinderHomeTabFragment)localObject3).hJx;
        if (com.tencent.mm.plugin.finder.upload.action.f.TN(i)) {
          break label457;
        }
        Log.i("Finder.FeedCleaner", "cleanTimelinePage: " + i + " return");
        break;
        paramFinderHomeUIC = localFinderTimelineFeedLoader.getDataList();
        break label125;
        label238:
        localObject2 = new StringBuilder("cleanFeed: ").append(i).append(" size: ");
        if (localList == null) {}
        for (paramFinderHomeUIC = null;; paramFinderHomeUIC = Integer.valueOf(localList.size()))
        {
          Log.i("Finder.FeedCleaner", paramFinderHomeUIC);
          StringBuilder localStringBuilder = new StringBuilder("followRecorder size: ");
          localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcS;
          paramFinderHomeUIC = (FinderHomeUIC)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("followRecorder");
            paramFinderHomeUIC = null;
          }
          localStringBuilder = localStringBuilder.append(paramFinderHomeUIC.Gda.size()).append(" noSeeAuthorRecorder:");
          localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcT;
          paramFinderHomeUIC = (FinderHomeUIC)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("noSeeAuthorRecorder");
            paramFinderHomeUIC = null;
          }
          Log.i("Finder.FeedCleaner", paramFinderHomeUIC.Gda.size());
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
            p.e(localList, (kotlin.g.a.b)f.c.GcZ);
            break;
          }
        }
        if (localList != null) {
          p.e(localList, (kotlin.g.a.b)f.b.GcY);
        }
      }
      label457:
      Log.i("Finder.FeedCleaner", kotlin.g.b.s.X("cleanTimelinePage: ", Integer.valueOf(i)));
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
          localObject3 = com.tencent.mm.plugin.finder.storage.data.k.FNg;
          localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcT;
          paramFinderHomeUIC = (FinderHomeUIC)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("noSeeAuthorRecorder");
            paramFinderHomeUIC = null;
          }
          k.a.a((k.a)localObject3, i, p.p((Iterable)paramFinderHomeUIC.Gda));
          break;
          localObject3 = new HashSet();
          localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcS;
          paramFinderHomeUIC = (FinderHomeUIC)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("followRecorder");
            paramFinderHomeUIC = null;
          }
          ((HashSet)localObject3).addAll((Collection)paramFinderHomeUIC.Gda);
          localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcT;
          paramFinderHomeUIC = (FinderHomeUIC)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("noSeeAuthorRecorder");
            paramFinderHomeUIC = null;
          }
          ((HashSet)localObject3).addAll((Collection)paramFinderHomeUIC.Gda);
          k.a.a(com.tencent.mm.plugin.finder.storage.data.k.FNg, 7, p.p((Iterable)localObject3));
          break;
        }
      }
    }
    localObject2 = com.tencent.mm.plugin.finder.upload.action.f.GcS;
    paramFinderHomeUIC = (FinderHomeUIC)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("followRecorder");
      paramFinderHomeUIC = null;
    }
    paramFinderHomeUIC.clear();
    paramFinderHomeUIC = com.tencent.mm.plugin.finder.upload.action.f.GcT;
    if (paramFinderHomeUIC == null)
    {
      kotlin.g.b.s.bIx("noSeeAuthorRecorder");
      paramFinderHomeUIC = localObject1;
    }
    for (;;)
    {
      paramFinderHomeUIC.clear();
      AppMethodBeat.o(346957);
      return;
    }
  }
  
  private final void aK(Intent paramIntent)
  {
    AppMethodBeat.i(346915);
    if (paramIntent == null) {}
    for (boolean bool = false;; bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false))
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).fps();
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        paramIntent = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(FinderHomeUIC.class);
        kotlin.g.b.s.s(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        kotlin.ah localah = kotlin.ah.aiuX;
        paramIntent.u(1, localBundle);
      }
      AppMethodBeat.o(346915);
      return;
    }
  }
  
  private final void aL(Intent paramIntent)
  {
    AppMethodBeat.i(346920);
    if (paramIntent == null) {}
    for (boolean bool = false;; bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false))
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", bool);
      }
      if (bool)
      {
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).fps();
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        paramIntent = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(FinderHomeUIC.class);
        kotlin.g.b.s.s(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", 0);
        kotlin.ah localah = kotlin.ah.aiuX;
        paramIntent.u(3, localBundle);
      }
      AppMethodBeat.o(346920);
      return;
    }
  }
  
  private final void aM(Intent paramIntent)
  {
    AppMethodBeat.i(346925);
    boolean bool1;
    boolean bool2;
    if (paramIntent == null)
    {
      bool1 = false;
      if (paramIntent != null) {
        break label148;
      }
      bool2 = false;
      label19:
      if (paramIntent != null) {
        break label161;
      }
    }
    label148:
    label161:
    for (int i = 0;; i = paramIntent.getIntExtra("Source", 0))
    {
      paramIntent = getIntent();
      if (paramIntent != null) {
        paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", bool1);
      }
      if (bool1)
      {
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        ((be)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(be.class)).fps();
        paramIntent = com.tencent.mm.ui.component.k.aeZF;
        paramIntent = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(FinderHomeUIC.class);
        kotlin.g.b.s.s(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
        paramIntent = (FinderHomeUIC)paramIntent;
        Bundle localBundle = new Bundle();
        localBundle.putInt("Source", i);
        kotlin.ah localah = kotlin.ah.aiuX;
        paramIntent.a(bool2, localBundle);
      }
      AppMethodBeat.o(346925);
      return;
      bool1 = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
      break;
      bool2 = paramIntent.getBooleanExtra("KEY_FINDER_JUMP_HOT_TAB_WITH_ANIM", true);
      break label19;
    }
  }
  
  private final void aN(Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(346930);
    Object localObject;
    if (paramIntent == null)
    {
      localObject = null;
      if (paramIntent != null) {
        break label113;
      }
    }
    for (;;)
    {
      Log.i("Finder.HomeUI", "checkRoute " + localObject + ' ' + bool);
      if (kotlin.g.b.s.p(ai.cz(FinderSelfUI.class).klt(), localObject)) {
        fbj();
      }
      if (bool)
      {
        localObject = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
        com.tencent.mm.plugin.finder.feed.jumper.r.a(paramIntent, (kotlin.g.a.b)new b(this));
      }
      AppMethodBeat.o(346930);
      return;
      localObject = paramIntent.getStringExtra("KEY_ROUTE_TO_PAGE");
      break;
      label113:
      bool = paramIntent.getBooleanExtra("KEY_ROUTE_TO_TOPIC", false);
    }
  }
  
  private final void fbj()
  {
    AppMethodBeat.i(346934);
    Log.i("Finder.HomeUI", "jumpFinderPersonCenter");
    Intent localIntent = new Intent();
    localIntent.putExtra("RED_DOT_EXIST_ON_ENTER", true);
    Object localObject = as.GSQ;
    as.a.a((Context)this, localIntent, 0L, 0, false, 124);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI((Context)this, localIntent);
    AppMethodBeat.o(346934);
  }
  
  private final void fbk()
  {
    AppMethodBeat.i(346941);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.putExtra("preferred_tab", 2);
    com.tencent.mm.br.c.g((Context)this, ".ui.LauncherUI", localIntent);
    overridePendingTransition(e.a.slide_left_in, e.a.slide_right_out);
    AppMethodBeat.o(346941);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 1;
  }
  
  public void finish()
  {
    AppMethodBeat.i(347032);
    Object localObject = as.GSQ;
    localObject = as.a.hu((Context)this);
    if (localObject != null)
    {
      localObject = as.a((as)localObject);
      if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.finder.report.ae)))
      {
        localObject = (com.tencent.mm.plugin.finder.report.ae)localObject;
        m.a locala = m.Fpx;
        ((com.tencent.mm.plugin.finder.report.ae)localObject).azV(m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(5)))));
      }
    }
    int i = getIntent().getIntExtra("FROM_SCENE_KEY", 0);
    if (i == 5)
    {
      if (!getContext().getIntent().getBooleanExtra("KEY_PUSH_FAIL_RETURN_READY", false))
      {
        fbk();
        AppMethodBeat.o(347032);
        return;
      }
      localObject = getIntent().getStringExtra("KEY_TASK_ID");
      com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject, "fail_return_to", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(1), Integer.valueOf(1) });
      i = getIntent().getIntExtra("KEY_PUSH_RETURN_TO", -1);
      localObject = t.AHw;
      if (i == t.dXt())
      {
        localObject = new Intent();
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("preferred_tab", 0);
        com.tencent.mm.br.c.g((Context)this, ".ui.LauncherUI", (Intent)localObject);
        overridePendingTransition(e.a.slide_left_in, e.a.slide_right_out);
      }
    }
    for (;;)
    {
      com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new c(this));
      AppMethodBeat.o(347032);
      return;
      localObject = t.AHw;
      if (i == t.dXu())
      {
        fbk();
      }
      else
      {
        super.finish();
        AppMethodBeat.o(347032);
        return;
        if ((getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false)) || (i == 4))
        {
          fbk();
        }
        else
        {
          localObject = com.tencent.mm.ui.component.k.aeZF;
          if ((!((com.tencent.mm.plugin.finder.viewmodel.component.w)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.w.class)).AEE) && (!this.FQT) && (i != 6)) {
            fbk();
          }
        }
      }
    }
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(346996);
    Object localObject = z.FrZ;
    localObject = com.tencent.mm.ui.component.k.aeZF;
    int i = z.SD(((FinderHomeUIC)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(FinderHomeUIC.class)).fnX());
    AppMethodBeat.o(346996);
    return i;
  }
  
  public int getLayoutId()
  {
    return e.f.finder_home_ui;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346984);
    Set localSet = kotlin.a.ar.setOf(new Class[] { FinderHomeUIC.class, af.class, i.class, com.tencent.mm.plugin.finder.viewmodel.component.r.class, al.class, com.tencent.mm.plugin.finder.preload.f.class, as.class, aq.class, com.tencent.mm.plugin.finder.viewmodel.component.ah.class, az.class, com.tencent.mm.plugin.finder.viewmodel.component.ar.class, av.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class, av.class, ay.class, com.tencent.mm.plugin.finder.accessibility.s.class, com.tencent.mm.plugin.finder.viewmodel.component.w.class, com.tencent.mm.ui.component.l.a(ai.cz(ap.class)), bf.class, com.tencent.mm.plugin.finder.viewmodel.component.ae.class });
    AppMethodBeat.o(346984);
    return localSet;
  }
  
  public boolean isHideStatusBar()
  {
    return true;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(347049);
    super.onBackPressed();
    if (getContext().getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false))
    {
      com.tencent.mm.br.c.b((Context)getContext(), "sns", ".ui.SnsTimeLineUI", getIntent());
      overridePendingTransition(e.a.slide_left_in, e.a.slide_right_out);
    }
    AppMethodBeat.o(347049);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347024);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 41L, 1L, false);
    Object localObject;
    if (getIntent().getBooleanExtra("key_form_sns", false))
    {
      paramBundle = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramBundle = (Context)this;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_from_sns_post", true);
      kotlin.ah localah = kotlin.ah.aiuX;
      com.tencent.mm.plugin.finder.utils.a.enterFinderSelfUI(paramBundle, (Intent)localObject);
    }
    aL(getIntent());
    aK(getIntent());
    aM(getIntent());
    aN(getIntent());
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      paramBundle = null;
      boolean bool = kotlin.g.b.s.p(paramBundle, "appPush");
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      if ((((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(4).GKD) && (!bool))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.w.FrV;
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)this);
        if (paramBundle != null) {
          break label303;
        }
        paramBundle = "";
        label186:
        com.tencent.mm.plugin.finder.report.w.azS(paramBundle);
      }
      if (bool) {
        overridePendingTransition(e.a.slide_right_in, e.a.slide_left_out);
      }
      paramBundle = getIntent();
      if ((paramBundle == null) || (paramBundle.getIntExtra("FROM_SCENE_KEY", 2) != 6)) {
        break label324;
      }
    }
    label303:
    label324:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        overridePendingTransition(e.a.slide_right_in, e.a.slide_left_out);
      }
      paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eXD())
      {
        Log.i("Finder.HomeUI", "onCreate: multi task is close, clear all finder task");
        paramBundle = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
        kotlin.g.b.s.s(paramBundle, "service(IFinderMultiTaskService::class.java)");
        ((com.tencent.mm.plugin.l)paramBundle).hG(false);
      }
      AppMethodBeat.o(347024);
      return;
      paramBundle = paramBundle.getStringExtra("KEY_FROM_PATH");
      break;
      localObject = paramBundle.zIO;
      paramBundle = (Bundle)localObject;
      if (localObject != null) {
        break label186;
      }
      paramBundle = "";
      break label186;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(347043);
    super.onDestroy();
    if (!com.tencent.mm.n.a.q(null, false))
    {
      ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUs();
      localObject = com.tencent.mm.live.core.core.f.a.mUf;
      a.a.clear();
    }
    Object localObject = com.tencent.mm.plugin.finder.report.r.Fqi;
    com.tencent.mm.plugin.finder.report.r.clearData();
    localObject = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    com.tencent.mm.plugin.finder.live.fluent.g.release();
    AppMethodBeat.o(347043);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(347016);
    super.onNewIntent(paramIntent);
    int i;
    Object localObject;
    as localas;
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_need_change_reporter", false) == true))
    {
      i = 1;
      if (i != 0)
      {
        localObject = as.GSQ;
        localas = as.a.hu((Context)this);
        if (localas != null)
        {
          localObject = paramIntent.getStringExtra("key_context_id");
          if (localObject != null)
          {
            if (((CharSequence)localObject).length() != 0) {
              break label280;
            }
            i = 1;
            label77:
            if (i != 0) {
              break label285;
            }
            i = 1;
            label83:
            if (i == 0) {
              break label290;
            }
            label87:
            if (localObject != null)
            {
              localas.zIO = ((String)localObject);
              getIntent().putExtra("key_context_id", (String)localObject);
            }
          }
          localObject = paramIntent.getStringExtra("key_extra_info");
          if (localObject != null)
          {
            if (((CharSequence)localObject).length() != 0) {
              break label295;
            }
            i = 1;
            label135:
            if (i != 0) {
              break label300;
            }
            i = 1;
            label141:
            if (i == 0) {
              break label305;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localas.extraInfo = ((String)localObject);
        getIntent().putExtra("key_extra_info", (String)localObject);
      }
      aL(paramIntent);
      aK(paramIntent);
      aM(paramIntent);
      aN(paramIntent);
      if (paramIntent != null)
      {
        getIntent().putExtra("KEY_POST_DIRECTLY_FROM_SNS", paramIntent.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false));
        getIntent().putExtra("key_finder_post_local_id", paramIntent.getLongExtra("key_finder_post_local_id", -1L));
        getIntent().putExtra("KEY_PUSH_RETURN_TO", paramIntent.getIntExtra("KEY_PUSH_RETURN_TO", -1));
        getIntent().putExtra("KEY_TASK_ID", paramIntent.getStringExtra("KEY_TASK_ID"));
      }
      AppMethodBeat.o(347016);
      return;
      i = 0;
      break;
      label280:
      i = 0;
      break label77;
      label285:
      i = 0;
      break label83;
      label290:
      localObject = null;
      break label87;
      label295:
      i = 0;
      break label135;
      label300:
      i = 0;
      break label141;
      label305:
      localObject = null;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(347035);
    super.onPause();
    this.nmW.gR(false);
    AppMethodBeat.o(347035);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(347039);
    super.onResume();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = (FinderHomeUIC)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(FinderHomeUIC.class);
    ((FinderHomeUIC)localObject).getRootView().post(new FinderHomeUI..ExternalSyntheticLambda0((FinderHomeUIC)localObject));
    com.tencent.mm.model.d.a(this.nmW, "Finder.HomeUI");
    AppMethodBeat.o(347039);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(347026);
    this.FQT = true;
    super.onSwipeBack();
    AppMethodBeat.o(347026);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<FinderJumpInfo, kotlin.ah>
  {
    b(FinderHomeUI paramFinderHomeUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(FinderHomeUI paramFinderHomeUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */