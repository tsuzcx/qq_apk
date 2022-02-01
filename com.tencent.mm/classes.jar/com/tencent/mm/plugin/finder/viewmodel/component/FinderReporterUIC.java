package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.c.a;
import com.tencent.mm.plugin.finder.report.a.a;
import com.tencent.mm.plugin.finder.report.a.b;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "clickFeedContextId", "", "getClickFeedContextId", "()Ljava/lang/String;", "setClickFeedContextId", "(Ljava/lang/String;)V", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "firstFragmentVisible", "", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "isFirstOnResume", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "machineSubscriber", "reportType", "getReportType", "setReportType", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "initActivityReporter", "isHome", "isSingleFeedFlow", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPause", "onResume", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "sendStatsList", "Companion", "plugin-finder_release"})
public final class FinderReporterUIC
  extends UIComponent
  implements com.tencent.mm.plugin.finder.view.f
{
  private static final int STOP = 2;
  private static final String TAG = "Finder.FinderReporterUIC";
  private static final int ruX = 1;
  private static final String seO = "FinderReporterThread";
  private static final long seP = 60000L;
  public static final a seQ;
  private int dtw;
  String qom;
  public String qox;
  private com.tencent.mm.plugin.finder.event.base.c rdn;
  public int rfR;
  public int sbQ;
  private com.tencent.mm.plugin.finder.report.f seA;
  private com.tencent.mm.plugin.finder.report.g seB;
  private com.tencent.mm.plugin.finder.event.base.c seC;
  private com.tencent.mm.plugin.finder.event.a seD;
  private com.tencent.mm.plugin.finder.report.f seE;
  private com.tencent.mm.plugin.finder.report.g seF;
  private com.tencent.mm.plugin.finder.event.base.c seG;
  private com.tencent.mm.plugin.finder.event.a seH;
  private com.tencent.mm.plugin.finder.report.f seI;
  private com.tencent.mm.plugin.finder.report.b seJ;
  private boolean seK;
  private boolean seL;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> seM;
  private final c seN;
  long sem;
  String sen;
  public int seo;
  int sep;
  public int ser;
  public String ses;
  public String sessionId;
  private com.tencent.mm.plugin.finder.event.a set;
  private com.tencent.mm.plugin.finder.report.f seu;
  private com.tencent.mm.plugin.finder.report.g sev;
  private j sew;
  private com.tencent.mm.plugin.finder.report.k sex;
  private com.tencent.mm.plugin.finder.event.base.c sey;
  private com.tencent.mm.plugin.finder.event.a sez;
  
  static
  {
    AppMethodBeat.i(204607);
    seQ = new a((byte)0);
    seO = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    ruX = 1;
    STOP = 2;
    seP = 60000L;
    AppMethodBeat.o(204607);
  }
  
  public FinderReporterUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204606);
    this.ses = "";
    this.seK = true;
    this.seL = true;
    this.seM = new LinkedList();
    this.seN = new c(this, seO);
    AppMethodBeat.o(204606);
  }
  
  private com.tencent.mm.plugin.finder.report.a Fg(int paramInt)
  {
    AppMethodBeat.i(204598);
    ac.i(TAG, "getHomeFlowReporter ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      locala = (com.tencent.mm.plugin.finder.report.a)this.sev;
      AppMethodBeat.o(204598);
      return locala;
    case 3: 
      locala = (com.tencent.mm.plugin.finder.report.a)this.seB;
      AppMethodBeat.o(204598);
      return locala;
    case 1: 
      locala = (com.tencent.mm.plugin.finder.report.a)this.seF;
      AppMethodBeat.o(204598);
      return locala;
    }
    com.tencent.mm.plugin.finder.report.a locala = (com.tencent.mm.plugin.finder.report.a)this.seJ;
    AppMethodBeat.o(204598);
    return locala;
  }
  
  private boolean cFZ()
  {
    return this.dtw == 2;
  }
  
  private boolean cGa()
  {
    return this.dtw == 3;
  }
  
  public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204601);
    ac.i(TAG, "onFragmentChange ".concat(String.valueOf(paramInt4)));
    Object localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
    this.rfR = com.tencent.mm.plugin.finder.report.d.DW(paramInt4);
    this.sbQ = paramInt4;
    if (paramInt1 >= 0) {
      this.qom = a.Fj(paramInt4);
    }
    localObject1 = Fc(paramInt4);
    switch (paramInt4)
    {
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(paramInt3, paramInt4, (anm)localObject1);
      AppMethodBeat.o(204601);
      return;
      localObject2 = this.seB;
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.finder.report.g)localObject2).b((anm)localObject1);
        continue;
        localObject2 = this.seF;
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.report.g)localObject2).b((anm)localObject1);
          continue;
          localObject2 = this.seJ;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.report.b)localObject2).b((anm)localObject1);
          }
        }
      }
    }
  }
  
  public final anm Fc(int paramInt)
  {
    AppMethodBeat.i(204590);
    anm localanm = new anm();
    localanm.seo = this.seo;
    localanm.sessionId = this.sessionId;
    localanm.qox = this.qox;
    localanm.qom = this.qom;
    localanm.sem = this.sem;
    localanm.sen = this.sen;
    com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
    localanm.rfR = com.tencent.mm.plugin.finder.report.d.DW(paramInt);
    localanm.ser = this.ser;
    localanm.sep = this.sep;
    localanm.ses = this.ses;
    AppMethodBeat.o(204590);
    return localanm;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c Fd(int paramInt)
  {
    AppMethodBeat.i(204591);
    if (cFY())
    {
      if (paramInt == -1)
      {
        localc = Fi(this.sbQ);
        AppMethodBeat.o(204591);
        return localc;
      }
      localc = Fi(paramInt);
      AppMethodBeat.o(204591);
      return localc;
    }
    com.tencent.mm.plugin.finder.event.base.c localc = this.rdn;
    AppMethodBeat.o(204591);
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.report.a Fe(int paramInt)
  {
    AppMethodBeat.i(204594);
    com.tencent.mm.plugin.finder.report.a locala;
    if (cFY())
    {
      if (paramInt == -1)
      {
        locala = Fg(this.sbQ);
        AppMethodBeat.o(204594);
        return locala;
      }
      locala = Fg(paramInt);
      AppMethodBeat.o(204594);
      return locala;
    }
    if (cFZ())
    {
      locala = (com.tencent.mm.plugin.finder.report.a)this.sev;
      AppMethodBeat.o(204594);
      return locala;
    }
    if (cGa())
    {
      locala = (com.tencent.mm.plugin.finder.report.a)this.sex;
      AppMethodBeat.o(204594);
      return locala;
    }
    AppMethodBeat.o(204594);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.f Ff(int paramInt)
  {
    AppMethodBeat.i(204596);
    com.tencent.mm.plugin.finder.event.base.f localf;
    if (cFY())
    {
      if (paramInt == -1)
      {
        localf = Fh(this.sbQ);
        AppMethodBeat.o(204596);
        return localf;
      }
      localf = Fh(paramInt);
      AppMethodBeat.o(204596);
      return localf;
    }
    if (cFZ())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.seu;
      AppMethodBeat.o(204596);
      return localf;
    }
    if (cGa())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.sew;
      AppMethodBeat.o(204596);
      return localf;
    }
    AppMethodBeat.o(204596);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.f Fh(int paramInt)
  {
    AppMethodBeat.i(204599);
    ac.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.seu;
      AppMethodBeat.o(204599);
      return localf;
    case 3: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.seA;
      AppMethodBeat.o(204599);
      return localf;
    case 1: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.seE;
      AppMethodBeat.o(204599);
      return localf;
    }
    com.tencent.mm.plugin.finder.event.base.f localf = (com.tencent.mm.plugin.finder.event.base.f)this.seI;
    AppMethodBeat.o(204599);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c Fi(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.rdn;
    case 3: 
      return this.sey;
    case 1: 
      return this.seC;
    }
    return this.seG;
  }
  
  public final void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(204588);
    super.Z(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
      localObject = this.qox;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      com.tencent.mm.plugin.finder.report.d.ge(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.a.rwX;
      paramBundle = cGb();
      localObject = com.tencent.mm.plugin.finder.report.a.rwX;
      localObject = a.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      d.g.b.k.g(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      a.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.a.rwX;
      paramBundle = cGb();
      localObject = com.tencent.mm.plugin.finder.report.a.rwX;
      localObject = a.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      d.g.b.k.g(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      a.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    paramBundle = com.tencent.mm.plugin.finder.model.v.rve;
    com.tencent.mm.plugin.finder.model.v.startTimer();
    this.seN.sendEmptyMessage(ruX);
    AppMethodBeat.o(204588);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(204600);
    d.g.b.k.h(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.IrY;
      localObject = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
      d.g.b.k.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      localObject = (FinderHomeTabStateVM)localObject;
      if (!this.seK) {
        break label442;
      }
      if (((FinderHomeTabStateVM)localObject).cFJ() != paramFinderHomeTabFragment.diw) {
        break label144;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (!((FinderHomeTabStateVM)localObject).ES(paramFinderHomeTabFragment.diw)) {}
      for (paramInt = 3;; paramInt = 2)
      {
        localObject = Fc(paramFinderHomeTabFragment.diw);
        switch (paramFinderHomeTabFragment.diw)
        {
        }
        for (;;)
        {
          this.seK = false;
          AppMethodBeat.o(204600);
          return;
          label144:
          paramBoolean = false;
          break;
          paramFinderHomeTabFragment = this.seA;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.seB;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.seE;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seF;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seI;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seJ;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
          c.a.b(paramInt, (anm)localObject, this.sbQ, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.seE;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.seF;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.seA;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seB;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seI;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seJ;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
          c.a.a(paramInt, (anm)localObject, this.sbQ, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.seI;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.seJ;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.seE;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seF;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seA;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.seB;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
          c.a.c(paramInt, (anm)localObject, this.sbQ, paramBoolean);
        }
      }
      label442:
      paramBoolean = false;
    }
  }
  
  public final void aa(Bundle paramBundle)
  {
    AppMethodBeat.i(204587);
    super.aa(paramBundle);
    paramBundle = getActivity();
    if ((getActivity() instanceof MMFinderUI)) {}
    while (paramBundle != null) {
      if (paramBundle == null)
      {
        paramBundle = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(204587);
        throw paramBundle;
        paramBundle = null;
      }
      else
      {
        int i = ((MMFinderUI)paramBundle).cuI();
        int j = ((MMFinderUI)paramBundle).cvJ();
        this.seo = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
        Object localObject;
        if (i == 0)
        {
          this.rfR = this.seo;
          this.dtw = j;
          localObject = getActivity().getIntent().getStringExtra("key_context_id");
          paramBundle = (Bundle)localObject;
          if (localObject == null)
          {
            paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
            paramBundle = com.tencent.mm.plugin.finder.report.d.cwT();
          }
          this.qox = paramBundle;
          localObject = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = "";
          }
          this.sessionId = paramBundle;
          this.sem = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
          this.sen = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
          this.sep = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
          this.ser = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
          if (!cFY()) {
            break label696;
          }
          paramBundle = com.tencent.mm.ui.component.a.IrY;
          this.sbQ = ((FinderHomeUIC)com.tencent.mm.ui.component.a.q(getActivity()).get(FinderHomeUIC.class)).cFV();
          paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
          this.rfR = com.tencent.mm.plugin.finder.report.d.DW(this.sbQ);
          this.qom = a.Fj(this.sbQ);
        }
        for (;;)
        {
          ac.i(TAG, "initActivityReporter reportType:" + this.dtw + " commentScene:" + this.rfR + " fromCommentScene:" + this.seo + " sessionId:" + this.sessionId + " contextId:" + this.qox + " clickTabContextId:" + this.qom + " currentTabType:" + this.sbQ);
          if (!cFY()) {
            break label751;
          }
          paramBundle = new com.tencent.mm.plugin.finder.event.base.c(seO);
          this.seA = new com.tencent.mm.plugin.finder.report.f(paramBundle);
          this.sez = new com.tencent.mm.plugin.finder.event.a(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.g(getActivity(), Fc(3));
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)localObject);
          ((com.tencent.mm.plugin.finder.report.g)localObject).onInvisible();
          this.seB = ((com.tencent.mm.plugin.finder.report.g)localObject);
          this.sey = paramBundle;
          paramBundle = new com.tencent.mm.plugin.finder.event.base.c(seO);
          this.seE = new com.tencent.mm.plugin.finder.report.f(paramBundle);
          this.seD = new com.tencent.mm.plugin.finder.event.a(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.g(getActivity(), Fc(1));
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)localObject);
          ((com.tencent.mm.plugin.finder.report.g)localObject).onInvisible();
          this.seF = ((com.tencent.mm.plugin.finder.report.g)localObject);
          this.seC = paramBundle;
          paramBundle = new com.tencent.mm.plugin.finder.event.base.c(seO);
          this.seI = new com.tencent.mm.plugin.finder.report.f(paramBundle);
          this.seH = new com.tencent.mm.plugin.finder.event.a(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.b(getActivity(), Fc(4));
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)localObject);
          ((com.tencent.mm.plugin.finder.report.b)localObject).onInvisible();
          this.seJ = ((com.tencent.mm.plugin.finder.report.b)localObject);
          this.seG = paramBundle;
          paramBundle = com.tencent.mm.ui.component.a.IrY;
          ((FinderHomeUIC)com.tencent.mm.ui.component.a.q(getActivity()).get(FinderHomeUIC.class)).sdQ.add(this);
          AppMethodBeat.o(204587);
          return;
          this.rfR = i;
          break;
          label696:
          localObject = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
          paramBundle = (Bundle)localObject;
          if (localObject == null) {
            paramBundle = "";
          }
          this.qom = paramBundle;
          if (bs.isNullOrNil(this.qom)) {
            this.qom = a.Fj(i + 100);
          }
        }
        label751:
        if (cFZ())
        {
          paramBundle = new com.tencent.mm.plugin.finder.event.base.c(seO);
          this.set = new com.tencent.mm.plugin.finder.event.a(paramBundle);
          this.seu = new com.tencent.mm.plugin.finder.report.f(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.g(getActivity(), cGb());
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)localObject);
          this.sev = ((com.tencent.mm.plugin.finder.report.g)localObject);
          this.rdn = paramBundle;
          AppMethodBeat.o(204587);
          return;
        }
        if (cGa())
        {
          paramBundle = new com.tencent.mm.plugin.finder.event.base.c(seO);
          this.set = new com.tencent.mm.plugin.finder.event.a(paramBundle);
          this.sew = new j(paramBundle);
          localObject = new com.tencent.mm.plugin.finder.report.k(getActivity(), cGb());
          paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)localObject);
          this.sex = ((com.tencent.mm.plugin.finder.report.k)localObject);
          this.rdn = paramBundle;
        }
        AppMethodBeat.o(204587);
        return;
      }
    }
    AppMethodBeat.o(204587);
  }
  
  public final boolean cFY()
  {
    return this.dtw == 1;
  }
  
  public final anm cGb()
  {
    AppMethodBeat.i(204589);
    if (cFY())
    {
      localObject = com.tencent.mm.ui.component.a.IrY;
      localObject = Fc(((FinderHomeUIC)com.tencent.mm.ui.component.a.q(getActivity()).get(FinderHomeUIC.class)).cFV());
      AppMethodBeat.o(204589);
      return localObject;
    }
    Object localObject = new anm();
    ((anm)localObject).seo = this.seo;
    ((anm)localObject).rfR = this.rfR;
    ((anm)localObject).sessionId = this.sessionId;
    ((anm)localObject).qox = this.qox;
    ((anm)localObject).qom = this.qom;
    ((anm)localObject).sem = this.sem;
    ((anm)localObject).sen = this.sen;
    ((anm)localObject).ser = this.ser;
    ((anm)localObject).sep = this.sep;
    ((anm)localObject).ses = this.ses;
    AppMethodBeat.o(204589);
    return localObject;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204605);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = Fc(this.sbQ);
      com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.a(2, this.sbQ, paramIntent);
    }
    AppMethodBeat.o(204605);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204604);
    ac.i(TAG, "onDestroy");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.a.rwX;
      localObject1 = cGb();
      localObject2 = a.b.rwZ;
      a.a.a((anm)localObject1, 0L, 9, a.b.cwO());
      localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
      localObject2 = this.qox;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.report.d.ge((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.a.rwX;
      localObject1 = cGb();
      localObject2 = a.b.rwZ;
      a.a.a((anm)localObject1, 0L, 9, a.b.cwO());
    }
    Object localObject1 = this.rdn;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.sey;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.seC;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.seG;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = com.tencent.mm.plugin.finder.model.v.rve;
    com.tencent.mm.plugin.finder.model.v.stopTimer();
    this.seN.removeCallbacksAndMessages(null);
    this.seN.sendEmptyMessage(STOP);
    super.onDestroy();
    AppMethodBeat.o(204604);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204603);
    super.onPause();
    if (cFY()) {
      switch (this.sbQ)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.seM).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.seA;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.report.f)localObject).onInvisible();
      }
      localObject = this.seB;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.report.g)localObject).onInvisible();
        continue;
        localObject = this.seE;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.report.f)localObject).onInvisible();
        }
        localObject = this.seF;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.report.g)localObject).onInvisible();
          continue;
          localObject = this.seI;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.report.f)localObject).onInvisible();
          }
          localObject = this.seJ;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.report.b)localObject).onInvisible();
            continue;
            if (cFZ())
            {
              localObject = this.seu;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.f)localObject).onInvisible();
              }
              localObject = this.sev;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.g)localObject).onInvisible();
              }
            }
            else if (cGa())
            {
              localObject = this.sew;
              if (localObject != null) {
                ((j)localObject).onInvisible();
              }
              localObject = this.sex;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.k)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(204603);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204602);
    super.onResume();
    if (this.seL)
    {
      this.seL = false;
      AppMethodBeat.o(204602);
      return;
    }
    Object localObject1;
    if (cFY())
    {
      localObject1 = Fc(this.sbQ);
      switch (this.sbQ)
      {
      case 2: 
      default: 
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
        c.a.a(1, cGb(), this.sbQ, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
        c.a.b(1, cGb(), this.sbQ, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
        c.a.c(1, cGb(), this.sbQ, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
        c.a.a(1, cGb());
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
        c.a.a(1, cGb(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.seM).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.seB;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.g)localObject2).b((anm)localObject1);
      }
      localObject1 = this.seA;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.f)localObject1).onVisible();
      }
      localObject1 = this.seB;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.g)localObject1).onVisible();
      break;
      localObject2 = this.seF;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.g)localObject2).b((anm)localObject1);
      }
      localObject1 = this.seE;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.f)localObject1).onVisible();
      }
      localObject1 = this.seF;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.g)localObject1).onVisible();
      break;
      localObject2 = this.seJ;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.b)localObject2).b((anm)localObject1);
      }
      localObject1 = this.seI;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.f)localObject1).onVisible();
      }
      localObject1 = this.seJ;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.b)localObject1).onVisible();
      break;
      if (cFZ())
      {
        localObject1 = this.seu;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.f)localObject1).onVisible();
        }
        localObject1 = this.sev;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.g)localObject1).onVisible();
        }
      }
      else if (cGa())
      {
        localObject1 = this.sew;
        if (localObject1 != null) {
          ((j)localObject1).onVisible();
        }
        localObject1 = this.sex;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.k)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(204602);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"})
  public static final class a
  {
    public static String Fj(int paramInt)
    {
      AppMethodBeat.i(204584);
      String str1 = paramInt + '-' + ce.azJ();
      String str2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbx, "100");
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        ac.i(FinderReporterUIC.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", new Object[] { str1, localObject, str2 });
        try
        {
          d.g.b.k.g(str2, "blacklist");
          localObject = ((Iterable)d.n.n.c((CharSequence)str2, new char[] { ';' })).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!d.g.b.k.g((String)((Iterator)localObject).next(), String.valueOf(paramInt)));
          AppMethodBeat.o(204584);
          return str1;
        }
        catch (Exception localException)
        {
          e locale = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.agA().set(ah.a.GVY, str1);
          AppMethodBeat.o(204584);
        }
        localObject = "1";
        continue;
        localObject = "3";
        continue;
        localObject = "0";
        continue;
        localObject = "2";
      }
      return str1;
    }
    
    private static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(204581);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramIntent, "intent");
      if ((paramContext instanceof MMActivity))
      {
        Object localObject1 = com.tencent.mm.ui.component.a.IrY;
        int i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).rfR;
        localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (com.tencent.mm.plugin.finder.utils.n.EK(i))
        {
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).seo);
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          paramIntent.putExtra("key_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).qox);
          if (!paramBoolean) {
            break label409;
          }
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).sbQ;
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).qom = Fj(i);
          localObject1 = Fj(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject1);
          Object localObject2 = com.tencent.mm.ui.component.a.IrY;
          localObject2 = (FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class);
          if (localObject2 != null)
          {
            localObject2 = ((FinderReporterUIC)localObject2).cGb();
            ((anm)localObject2).qom = ((String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.a(i, 2, (anm)localObject2);
            localObject1 = com.tencent.mm.plugin.finder.extension.reddot.c.rem;
            c.a.a(2, (anm)localObject2);
          }
          label260:
          if (paramLong == 0L) {
            break label442;
          }
          paramIntent.putExtra("key_click_feed_id", paramLong);
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).sen;
          if (localObject1 != null) {
            paramIntent.putExtra("key_click_feed_context_id", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).ser;
          if (i != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", i);
          }
          if (paramInt == 0) {
            break label484;
          }
          paramIntent.putExtra("key_enter_profile_type", paramInt);
          AppMethodBeat.o(204581);
          return;
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).rfR);
          break;
          label409:
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          paramIntent.putExtra("key_click_tab_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).qom);
          break label260;
          label442:
          localObject1 = com.tencent.mm.ui.component.a.IrY;
          paramLong = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).sem;
          if (paramLong != 0L) {
            paramIntent.putExtra("key_click_feed_id", paramLong);
          }
        }
        label484:
        localObject1 = com.tencent.mm.ui.component.a.IrY;
        paramInt = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class)).sep;
        if (paramInt != 0) {
          paramIntent.putExtra("key_enter_profile_type", paramInt);
        }
        AppMethodBeat.o(204581);
        return;
      }
      ac.w(FinderReporterUIC.access$getTAG$cp(), "initIntentParams context is not MMActivity");
      AppMethodBeat.o(204581);
    }
    
    public static FinderReporterUIC eV(Context paramContext)
    {
      AppMethodBeat.i(204583);
      d.g.b.k.h(paramContext, "context");
      if ((paramContext instanceof MMActivity))
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
        paramContext = (FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramContext).get(FinderReporterUIC.class);
        AppMethodBeat.o(204583);
        return paramContext;
      }
      AppMethodBeat.o(204583);
      return null;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class c
    extends ao
  {
    c(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(204586);
      if (paramMessage != null)
      {
        int i = paramMessage.what;
        if (i == FinderReporterUIC.cGc())
        {
          FinderReporterUIC.e(this.seR);
          sendEmptyMessageDelayed(FinderReporterUIC.cGc(), FinderReporterUIC.cGd());
          AppMethodBeat.o(204586);
          return;
        }
        if (i == FinderReporterUIC.cGe())
        {
          FinderReporterUIC.e(this.seR);
          paramMessage = FinderReporterUIC.f(this.seR);
          if (paramMessage != null) {
            paramMessage.cwN();
          }
          removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(204586);
        return;
      }
      AppMethodBeat.o(204586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC
 * JD-Core Version:    0.7.0.1
 */