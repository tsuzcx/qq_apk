package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.extension.reddot.b.a;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.report.c.a;
import com.tencent.mm.plugin.finder.report.c.b;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "clickFeedContextId", "", "getClickFeedContextId", "()Ljava/lang/String;", "setClickFeedContextId", "(Ljava/lang/String;)V", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "isFirstOnResume", "", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "machineSubscriber", "reportType", "getReportType", "setReportType", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "initActivityReporter", "isHome", "isSingleFeedFlow", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPause", "onResume", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "sendStatsList", "Companion", "plugin-finder_release"})
public final class FinderReporterUIC
  extends UIComponent
  implements com.tencent.mm.plugin.finder.view.g
{
  private static final String Ljj = "FinderReporterThread";
  private static final long Ljk = 60000L;
  public static final a Ljl;
  private static final int STOP = 2;
  private static final String TAG = "Finder.FinderReporterUIC";
  private static final int qDI = 1;
  String KHW;
  int Lha;
  long LiJ;
  String LiK;
  public int LiL;
  int LiM;
  public int LiN;
  public String LiO;
  private com.tencent.mm.plugin.finder.event.c LiP;
  private com.tencent.mm.plugin.finder.report.k LiQ;
  private com.tencent.mm.plugin.finder.report.l LiR;
  private n LiS;
  private o LiT;
  private d LiU;
  private com.tencent.mm.plugin.finder.event.c LiV;
  private com.tencent.mm.plugin.finder.report.k LiW;
  private com.tencent.mm.plugin.finder.report.l LiX;
  private d LiY;
  private com.tencent.mm.plugin.finder.event.c LiZ;
  private com.tencent.mm.plugin.finder.report.k Lja;
  private com.tencent.mm.plugin.finder.report.l Ljb;
  private d Ljc;
  private com.tencent.mm.plugin.finder.event.c Ljd;
  private com.tencent.mm.plugin.finder.report.k Lje;
  private com.tencent.mm.plugin.finder.report.f Ljf;
  private boolean Ljg;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> Ljh;
  private final c Lji;
  private int dvJ;
  public int qqE;
  private d qsx;
  public String qwV;
  public String sessionId;
  
  static
  {
    AppMethodBeat.i(200479);
    Ljl = new a((byte)0);
    Ljj = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    qDI = 1;
    STOP = 2;
    Ljk = 60000L;
    AppMethodBeat.o(200479);
  }
  
  public FinderReporterUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200478);
    this.LiO = "";
    this.Ljg = true;
    this.Ljh = new LinkedList();
    this.Lji = new c(this, Ljj);
    AppMethodBeat.o(200478);
  }
  
  private boolean fXq()
  {
    return this.dvJ == 2;
  }
  
  private boolean fXr()
  {
    return this.dvJ == 3;
  }
  
  public final void X(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200473);
    ad.i(TAG, "onFragmentChange ".concat(String.valueOf(paramInt4)));
    Object localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
    this.qqE = com.tencent.mm.plugin.finder.report.b.ahq(paramInt4);
    this.Lha = paramInt4;
    if (paramInt1 >= 0) {
      this.KHW = a.aia(paramInt4);
    }
    localObject1 = ahV(paramInt4);
    switch (paramInt4)
    {
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(paramInt3, paramInt4, (dzp)localObject1);
      AppMethodBeat.o(200473);
      return;
      localObject2 = this.LiX;
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.finder.report.l)localObject2).b((dzp)localObject1);
        continue;
        localObject2 = this.Ljb;
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.report.l)localObject2).b((dzp)localObject1);
          continue;
          localObject2 = this.Ljf;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.report.f)localObject2).b((dzp)localObject1);
          }
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(200472);
    d.g.b.k.h(paramFinderHomeTabFragment, "fragment");
    dzp localdzp;
    if (paramBoolean)
    {
      localdzp = ahV(paramFinderHomeTabFragment.IoU);
      switch (paramFinderHomeTabFragment.IoU)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200472);
      return;
      paramFinderHomeTabFragment = this.LiW;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onVisible();
      }
      paramFinderHomeTabFragment = this.LiX;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onVisible();
      }
      paramFinderHomeTabFragment = this.Lja;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.Ljb;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.Lje;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.Ljf;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
      b.a.b(2, localdzp, this.Lha);
      AppMethodBeat.o(200472);
      return;
      paramFinderHomeTabFragment = this.Lja;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onVisible();
      }
      paramFinderHomeTabFragment = this.Ljb;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onVisible();
      }
      paramFinderHomeTabFragment = this.LiW;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.LiX;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.Lje;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.Ljf;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
      b.a.a(2, localdzp, this.Lha);
      AppMethodBeat.o(200472);
      return;
      paramFinderHomeTabFragment = this.Lje;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onVisible();
      }
      paramFinderHomeTabFragment = this.Ljf;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onVisible();
      }
      paramFinderHomeTabFragment = this.Lja;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.Ljb;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.LiW;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = this.LiX;
      if (paramFinderHomeTabFragment != null) {
        paramFinderHomeTabFragment.onInvisible();
      }
      paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
      b.a.c(2, localdzp, this.Lha);
    }
  }
  
  public final dzp ahV(int paramInt)
  {
    AppMethodBeat.i(200464);
    dzp localdzp = new dzp();
    localdzp.LiL = this.LiL;
    localdzp.sessionId = this.sessionId;
    localdzp.qwV = this.qwV;
    localdzp.KHW = this.KHW;
    localdzp.LiJ = this.LiJ;
    localdzp.LiK = this.LiK;
    com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
    localdzp.qqE = com.tencent.mm.plugin.finder.report.b.ahq(paramInt);
    localdzp.LiN = this.LiN;
    localdzp.LiM = this.LiM;
    localdzp.LiO = this.LiO;
    AppMethodBeat.o(200464);
    return localdzp;
  }
  
  public final d ahW(int paramInt)
  {
    AppMethodBeat.i(200465);
    if (fXp())
    {
      if (paramInt == -1)
      {
        locald = ahZ(this.Lha);
        AppMethodBeat.o(200465);
        return locald;
      }
      locald = ahZ(paramInt);
      AppMethodBeat.o(200465);
      return locald;
    }
    d locald = this.qsx;
    AppMethodBeat.o(200465);
    return locald;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.e ahX(int paramInt)
  {
    AppMethodBeat.i(200469);
    com.tencent.mm.plugin.finder.event.base.e locale;
    if (fXp())
    {
      if (paramInt == -1)
      {
        locale = ahY(this.Lha);
        AppMethodBeat.o(200469);
        return locale;
      }
      locale = ahY(paramInt);
      AppMethodBeat.o(200469);
      return locale;
    }
    if (fXq())
    {
      locale = (com.tencent.mm.plugin.finder.event.base.e)this.LiQ;
      AppMethodBeat.o(200469);
      return locale;
    }
    if (fXr())
    {
      locale = (com.tencent.mm.plugin.finder.event.base.e)this.LiS;
      AppMethodBeat.o(200469);
      return locale;
    }
    AppMethodBeat.o(200469);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.e ahY(int paramInt)
  {
    AppMethodBeat.i(200471);
    ad.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      locale = (com.tencent.mm.plugin.finder.event.base.e)this.LiQ;
      AppMethodBeat.o(200471);
      return locale;
    case 3: 
      locale = (com.tencent.mm.plugin.finder.event.base.e)this.LiW;
      AppMethodBeat.o(200471);
      return locale;
    case 1: 
      locale = (com.tencent.mm.plugin.finder.event.base.e)this.Lja;
      AppMethodBeat.o(200471);
      return locale;
    }
    com.tencent.mm.plugin.finder.event.base.e locale = (com.tencent.mm.plugin.finder.event.base.e)this.Lje;
    AppMethodBeat.o(200471);
    return locale;
  }
  
  public final d ahZ(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.qsx;
    case 3: 
      return this.LiU;
    case 1: 
      return this.LiY;
    }
    return this.Ljc;
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(200462);
    super.ba(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
      localObject = this.qwV;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      com.tencent.mm.plugin.finder.report.b.fQ(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.c.KUz;
      paramBundle = fXs();
      localObject = com.tencent.mm.plugin.finder.report.c.KUz;
      localObject = c.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      d.g.b.k.g(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      c.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.c.KUz;
      paramBundle = fXs();
      localObject = com.tencent.mm.plugin.finder.report.c.KUz;
      localObject = c.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      d.g.b.k.g(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      c.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    paramBundle = q.qDO;
    q.startTimer();
    this.Lji.sendEmptyMessage(qDI);
    AppMethodBeat.o(200462);
  }
  
  public final void be(Bundle paramBundle)
  {
    AppMethodBeat.i(200461);
    super.be(paramBundle);
    paramBundle = getActivity();
    if ((getActivity() instanceof MMFinderUI)) {}
    while (paramBundle != null) {
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(200461);
        throw paramBundle;
        paramBundle = null;
      }
      else
      {
        int i = ((MMFinderUI)paramBundle).getCommentScene();
        int j = ((MMFinderUI)paramBundle).fTB();
        this.LiL = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
        Object localObject;
        if (i == 0)
        {
          this.qqE = this.LiL;
          this.dvJ = j;
          localObject = getActivity().getIntent().getStringExtra("key_context_id");
          paramBundle = (Bundle)localObject;
          if (localObject == null)
          {
            paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
            paramBundle = com.tencent.mm.plugin.finder.report.b.fTV();
          }
          this.qwV = paramBundle;
          localObject = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = "";
          }
          this.sessionId = paramBundle;
          this.LiJ = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
          this.LiK = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
          this.LiM = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
          this.LiN = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
          if (!fXp()) {
            break label696;
          }
          paramBundle = com.tencent.mm.ui.component.a.LCX;
          this.Lha = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).fXm();
          paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
          this.qqE = com.tencent.mm.plugin.finder.report.b.ahq(this.Lha);
          this.KHW = a.aia(this.Lha);
        }
        for (;;)
        {
          ad.i(TAG, "initActivityReporter reportType:" + this.dvJ + " commentScene:" + this.qqE + " fromCommentScene:" + this.LiL + " sessionId:" + this.sessionId + " contextId:" + this.qwV + " clickTabContextId:" + this.KHW + " currentTabType:" + this.Lha);
          if (!fXp()) {
            break label751;
          }
          paramBundle = new d(Ljj);
          this.LiW = new com.tencent.mm.plugin.finder.report.k(paramBundle);
          this.LiV = new com.tencent.mm.plugin.finder.event.c(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.l(getActivity(), ahV(3));
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)localObject);
          ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
          this.LiX = ((com.tencent.mm.plugin.finder.report.l)localObject);
          this.LiU = paramBundle;
          paramBundle = new d(Ljj);
          this.Lja = new com.tencent.mm.plugin.finder.report.k(paramBundle);
          this.LiZ = new com.tencent.mm.plugin.finder.event.c(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.l(getActivity(), ahV(1));
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)localObject);
          ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
          this.Ljb = ((com.tencent.mm.plugin.finder.report.l)localObject);
          this.LiY = paramBundle;
          paramBundle = new d(Ljj);
          this.Lje = new com.tencent.mm.plugin.finder.report.k(paramBundle);
          this.Ljd = new com.tencent.mm.plugin.finder.event.c(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.f(getActivity(), ahV(4));
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)localObject);
          ((com.tencent.mm.plugin.finder.report.f)localObject).onInvisible();
          this.Ljf = ((com.tencent.mm.plugin.finder.report.f)localObject);
          this.Ljc = paramBundle;
          paramBundle = com.tencent.mm.ui.component.a.LCX;
          ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).Lin.add(this);
          AppMethodBeat.o(200461);
          return;
          this.qqE = i;
          break;
          label696:
          localObject = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = "";
          }
          this.KHW = paramBundle;
          if (bt.isNullOrNil(this.KHW)) {
            this.KHW = a.aia(i + 100);
          }
        }
        label751:
        if (fXq())
        {
          paramBundle = new d(Ljj);
          this.LiP = new com.tencent.mm.plugin.finder.event.c(paramBundle);
          this.LiQ = new com.tencent.mm.plugin.finder.report.k(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.l(getActivity(), fXs());
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)localObject);
          this.LiR = ((com.tencent.mm.plugin.finder.report.l)localObject);
          this.qsx = paramBundle;
          AppMethodBeat.o(200461);
          return;
        }
        if (fXr())
        {
          paramBundle = new d(Ljj);
          this.LiP = new com.tencent.mm.plugin.finder.event.c(paramBundle);
          this.LiS = new n(paramBundle);
          localObject = new o(getActivity(), fXs());
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)localObject);
          this.LiT = ((o)localObject);
          this.qsx = paramBundle;
        }
        AppMethodBeat.o(200461);
        return;
      }
    }
    AppMethodBeat.o(200461);
  }
  
  public final boolean fXp()
  {
    return this.dvJ == 1;
  }
  
  public final dzp fXs()
  {
    AppMethodBeat.i(200463);
    if (fXp())
    {
      localObject = com.tencent.mm.ui.component.a.LCX;
      localObject = ahV(((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).fXm());
      AppMethodBeat.o(200463);
      return localObject;
    }
    Object localObject = new dzp();
    ((dzp)localObject).LiL = this.LiL;
    ((dzp)localObject).qqE = this.qqE;
    ((dzp)localObject).sessionId = this.sessionId;
    ((dzp)localObject).qwV = this.qwV;
    ((dzp)localObject).KHW = this.KHW;
    ((dzp)localObject).LiJ = this.LiJ;
    ((dzp)localObject).LiK = this.LiK;
    ((dzp)localObject).LiN = this.LiN;
    ((dzp)localObject).LiM = this.LiM;
    ((dzp)localObject).LiO = this.LiO;
    AppMethodBeat.o(200463);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(200477);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = ahV(this.Lha);
      com.tencent.mm.plugin.finder.report.b localb = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(2, this.Lha, paramIntent);
    }
    AppMethodBeat.o(200477);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200476);
    ad.i(TAG, "onDestroy");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.KUz;
      localObject1 = fXs();
      localObject2 = c.b.KUB;
      c.a.a((dzp)localObject1, 0L, 9, c.b.fTT());
      localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
      localObject2 = this.qwV;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.report.b.fQ((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.KUz;
      localObject1 = fXs();
      localObject2 = c.b.KUB;
      c.a.a((dzp)localObject1, 0L, 9, c.b.fTT());
    }
    Object localObject1 = this.qsx;
    if (localObject1 != null) {
      ((d)localObject1).onRelease();
    }
    localObject1 = this.LiU;
    if (localObject1 != null) {
      ((d)localObject1).onRelease();
    }
    localObject1 = this.LiY;
    if (localObject1 != null) {
      ((d)localObject1).onRelease();
    }
    localObject1 = this.Ljc;
    if (localObject1 != null) {
      ((d)localObject1).onRelease();
    }
    localObject1 = q.qDO;
    q.stopTimer();
    this.Lji.removeCallbacksAndMessages(null);
    this.Lji.sendEmptyMessage(STOP);
    super.onDestroy();
    AppMethodBeat.o(200476);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200475);
    super.onPause();
    if (fXp()) {
      switch (this.Lha)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.Ljh).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.LiW;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.report.k)localObject).onInvisible();
      }
      localObject = this.LiX;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
        continue;
        localObject = this.Lja;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.report.k)localObject).onInvisible();
        }
        localObject = this.Ljb;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
          continue;
          localObject = this.Lje;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.report.k)localObject).onInvisible();
          }
          localObject = this.Ljf;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.report.f)localObject).onInvisible();
            continue;
            if (fXq())
            {
              localObject = this.LiQ;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.k)localObject).onInvisible();
              }
              localObject = this.LiR;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
              }
            }
            else if (fXr())
            {
              localObject = this.LiS;
              if (localObject != null) {
                ((n)localObject).onInvisible();
              }
              localObject = this.LiT;
              if (localObject != null) {
                ((o)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(200475);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200474);
    super.onResume();
    if (this.Ljg)
    {
      this.Ljg = false;
      AppMethodBeat.o(200474);
      return;
    }
    Object localObject1;
    if (fXp())
    {
      localObject1 = ahV(this.Lha);
      switch (this.Lha)
      {
      case 2: 
      default: 
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
        b.a.a(1, fXs(), this.Lha);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
        b.a.b(1, fXs(), this.Lha);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
        b.a.c(1, fXs(), this.Lha);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
        b.a.a(1, fXs());
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
        b.a.a(1, fXs(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.Ljh).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.LiX;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.l)localObject2).b((dzp)localObject1);
      }
      localObject1 = this.LiW;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.k)localObject1).onVisible();
      }
      localObject1 = this.LiX;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.l)localObject1).onVisible();
      break;
      localObject2 = this.Ljb;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.l)localObject2).b((dzp)localObject1);
      }
      localObject1 = this.Lja;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.k)localObject1).onVisible();
      }
      localObject1 = this.Ljb;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.l)localObject1).onVisible();
      break;
      localObject2 = this.Ljf;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.f)localObject2).b((dzp)localObject1);
      }
      localObject1 = this.Lje;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.k)localObject1).onVisible();
      }
      localObject1 = this.Ljf;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.f)localObject1).onVisible();
      break;
      if (fXq())
      {
        localObject1 = this.LiQ;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.k)localObject1).onVisible();
        }
        localObject1 = this.LiR;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.l)localObject1).onVisible();
        }
      }
      else if (fXr())
      {
        localObject1 = this.LiS;
        if (localObject1 != null) {
          ((n)localObject1).onVisible();
        }
        localObject1 = this.LiT;
        if (localObject1 != null) {
          ((o)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(200474);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"})
  public static final class a
  {
    private static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(200455);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramIntent, "intent");
      if ((paramContext instanceof MMActivity))
      {
        Object localObject1 = com.tencent.mm.ui.component.a.LCX;
        int i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).qqE;
        localObject1 = i.qTa;
        if (i.ahJ(i))
        {
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).LiL);
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          paramIntent.putExtra("key_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).qwV);
          if (!paramBoolean) {
            break label405;
          }
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).Lha;
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).KHW = aia(i);
          localObject1 = aia(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject1);
          Object localObject2 = com.tencent.mm.ui.component.a.LCX;
          localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).fXs();
            ((dzp)localObject2).KHW = ((String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.report.b.qFq;
            com.tencent.mm.plugin.finder.report.b.a(i, 2, (dzp)localObject2);
            localObject1 = com.tencent.mm.plugin.finder.extension.reddot.b.qtb;
            b.a.a(2, (dzp)localObject2);
          }
          label260:
          if (paramLong == 0L) {
            break label438;
          }
          paramIntent.putExtra("key_click_feed_id", paramLong);
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).LiK;
          if (localObject1 != null) {
            paramIntent.putExtra("key_click_feed_context_id", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).LiN;
          if (i != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", i);
          }
          if (paramInt == 0) {
            break label479;
          }
          paramIntent.putExtra("key_enter_profile_type", paramInt);
          AppMethodBeat.o(200455);
          return;
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).qqE);
          break;
          label405:
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          paramIntent.putExtra("key_click_tab_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).KHW);
          break label260;
          label438:
          localObject1 = com.tencent.mm.ui.component.a.LCX;
          paramLong = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).LiJ;
          if (paramLong != 0L) {
            paramIntent.putExtra("key_click_feed_id", paramLong);
          }
        }
        label479:
        localObject1 = com.tencent.mm.ui.component.a.LCX;
        paramInt = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).LiM;
        if (paramInt != 0) {
          paramIntent.putExtra("key_enter_profile_type", paramInt);
        }
        AppMethodBeat.o(200455);
        return;
      }
      ad.w(FinderReporterUIC.access$getTAG$cp(), "initIntentParams context is not MMActivity");
      AppMethodBeat.o(200455);
    }
    
    public static String aia(int paramInt)
    {
      AppMethodBeat.i(200458);
      String str = paramInt + '-' + ce.asS();
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.LBA, str);
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        ad.i(FinderReporterUIC.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s]", new Object[] { str, localObject });
        AppMethodBeat.o(200458);
        return str;
        localObject = "1";
        continue;
        localObject = "3";
        continue;
        localObject = "0";
        continue;
        localObject = "2";
      }
    }
    
    public static FinderReporterUIC lB(Context paramContext)
    {
      AppMethodBeat.i(200457);
      d.g.b.k.h(paramContext, "context");
      if ((paramContext instanceof MMActivity))
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
        paramContext = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class);
        AppMethodBeat.o(200457);
        return paramContext;
      }
      AppMethodBeat.o(200457);
      return null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(FinderReporterUIC paramFinderReporterUIC, WxRecyclerAdapter paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class c
    extends ap
  {
    c(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(200460);
      if (paramMessage != null)
      {
        int i = paramMessage.what;
        if (i == FinderReporterUIC.fXt())
        {
          FinderReporterUIC.e(this.Ljm);
          sendEmptyMessageDelayed(FinderReporterUIC.fXt(), FinderReporterUIC.fXu());
          AppMethodBeat.o(200460);
          return;
        }
        if (i == FinderReporterUIC.fXv())
        {
          FinderReporterUIC.e(this.Ljm);
          paramMessage = FinderReporterUIC.f(this.Ljm);
          if (paramMessage != null) {
            paramMessage.fTS();
          }
          removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(200460);
        return;
      }
      AppMethodBeat.o(200460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC
 * JD-Core Version:    0.7.0.1
 */