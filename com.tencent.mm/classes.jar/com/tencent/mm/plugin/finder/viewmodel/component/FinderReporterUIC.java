package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.c.a;
import com.tencent.mm.plugin.finder.report.c.b;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.a.ae;
import d.g.b.q;
import d.l;
import d.n.n;
import d.u;
import d.v;
import d.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "clickFeedContextId", "", "getClickFeedContextId", "()Ljava/lang/String;", "setClickFeedContextId", "(Ljava/lang/String;)V", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "firstFragmentVisible", "", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "isFirstOnResume", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "machineSubscriber", "reportType", "getReportType", "setReportType", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "initActivityReporter", "isHome", "isSingleFeedFlow", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPause", "onResume", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "sendStatsList", "Companion", "plugin-finder_release"})
public final class FinderReporterUIC
  extends UIComponent
  implements com.tencent.mm.plugin.finder.view.h
{
  private static final int STOP = 2;
  private static final String TAG = "Finder.FinderReporterUIC";
  private static final int sks = 1;
  private static final String tcK = "FinderReporterThread";
  private static final long tcL = 60000L;
  public static final a tcM;
  private int dFx;
  public String qXj;
  public String qXu;
  private com.tencent.mm.plugin.finder.event.base.c rQJ;
  public int rTD;
  public int sZg;
  public String sessionId;
  private j tcA;
  private k tcB;
  private com.tencent.mm.plugin.finder.event.base.c tcC;
  private com.tencent.mm.plugin.finder.event.a tcD;
  private j tcE;
  private com.tencent.mm.plugin.finder.report.d tcF;
  private boolean tcG;
  private boolean tcH;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> tcI;
  private final c tcJ;
  long tcj;
  String tck;
  public int tcl;
  int tcm;
  public int tcn;
  public String tco;
  private com.tencent.mm.plugin.finder.event.a tcp;
  private j tcq;
  private k tcr;
  private com.tencent.mm.plugin.finder.report.o tcs;
  private com.tencent.mm.plugin.finder.report.p tct;
  private com.tencent.mm.plugin.finder.event.base.c tcu;
  private com.tencent.mm.plugin.finder.event.a tcv;
  private j tcw;
  private k tcx;
  private com.tencent.mm.plugin.finder.event.base.c tcy;
  private com.tencent.mm.plugin.finder.event.a tcz;
  
  static
  {
    AppMethodBeat.i(205656);
    tcM = new a((byte)0);
    tcK = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    sks = 1;
    STOP = 2;
    tcL = 60000L;
    AppMethodBeat.o(205656);
  }
  
  public FinderReporterUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205655);
    this.tco = "";
    this.tcG = true;
    this.tcH = true;
    this.tcI = new LinkedList();
    this.tcJ = new c(this, tcK);
    AppMethodBeat.o(205655);
  }
  
  private com.tencent.mm.plugin.finder.report.c Gw(int paramInt)
  {
    AppMethodBeat.i(205646);
    ad.i(TAG, "getHomeFlowReporter ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localc = (com.tencent.mm.plugin.finder.report.c)this.tcr;
      AppMethodBeat.o(205646);
      return localc;
    case 3: 
      localc = (com.tencent.mm.plugin.finder.report.c)this.tcx;
      AppMethodBeat.o(205646);
      return localc;
    case 1: 
      localc = (com.tencent.mm.plugin.finder.report.c)this.tcB;
      AppMethodBeat.o(205646);
      return localc;
    }
    com.tencent.mm.plugin.finder.report.c localc = (com.tencent.mm.plugin.finder.report.c)this.tcF;
    AppMethodBeat.o(205646);
    return localc;
  }
  
  private boolean cOs()
  {
    return this.dFx == 2;
  }
  
  private boolean cOt()
  {
    return this.dFx == 3;
  }
  
  public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205649);
    ad.i(TAG, "onFragmentChange ".concat(String.valueOf(paramInt4)));
    Object localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
    this.rTD = com.tencent.mm.plugin.finder.report.h.Fa(paramInt4);
    this.sZg = paramInt4;
    if (paramInt1 >= 0) {
      this.qXj = a.Gz(paramInt4);
    }
    localObject1 = Gs(paramInt4);
    Object localObject2;
    switch (paramInt4)
    {
    case 2: 
    default: 
      localObject2 = com.tencent.mm.ui.component.a.KiD;
      localObject2 = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).getActiveFragment().En;
      if (localObject2 == null) {
        break;
      }
    }
    for (paramInt1 = ((Bundle)localObject2).getInt("Source", 0);; paramInt1 = 0)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(paramInt3, paramInt4, (aqy)localObject1, paramInt1);
      if (paramInt3 <= 0) {
        break label320;
      }
      localObject1 = Gu(paramInt3);
      if (localObject1 == null) {
        break label320;
      }
      if ((localObject1 instanceof k))
      {
        localObject1 = (k)localObject1;
        localObject2 = com.tencent.mm.plugin.finder.report.c.snN;
        ((k)localObject1).ahO(c.a.Y(ae.a(new d.o[] { u.S("feedActionType", Integer.valueOf(2)), u.S("toTab", Integer.valueOf(paramInt4)), u.S("fromTab", Integer.valueOf(paramInt3)) })));
      }
      AppMethodBeat.o(205649);
      return;
      localObject2 = this.tcx;
      if (localObject2 == null) {
        break;
      }
      ((k)localObject2).c((aqy)localObject1);
      break;
      localObject2 = this.tcB;
      if (localObject2 == null) {
        break;
      }
      ((k)localObject2).c((aqy)localObject1);
      break;
      localObject2 = this.tcF;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.d)localObject2).c((aqy)localObject1);
      break;
    }
    label320:
    AppMethodBeat.o(205649);
  }
  
  public final aqy Gs(int paramInt)
  {
    AppMethodBeat.i(205638);
    aqy localaqy = new aqy();
    localaqy.tcl = this.tcl;
    localaqy.sessionId = this.sessionId;
    localaqy.qXu = this.qXu;
    localaqy.qXj = this.qXj;
    localaqy.tcj = this.tcj;
    localaqy.tck = this.tck;
    com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.soM;
    localaqy.rTD = com.tencent.mm.plugin.finder.report.h.Fa(paramInt);
    localaqy.tcn = this.tcn;
    localaqy.tcm = this.tcm;
    localaqy.tco = this.tco;
    AppMethodBeat.o(205638);
    return localaqy;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c Gt(int paramInt)
  {
    AppMethodBeat.i(205639);
    if (cOr())
    {
      if (paramInt == -1)
      {
        localc = Gy(this.sZg);
        AppMethodBeat.o(205639);
        return localc;
      }
      localc = Gy(paramInt);
      AppMethodBeat.o(205639);
      return localc;
    }
    com.tencent.mm.plugin.finder.event.base.c localc = this.rQJ;
    AppMethodBeat.o(205639);
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.report.c Gu(int paramInt)
  {
    AppMethodBeat.i(205642);
    com.tencent.mm.plugin.finder.report.c localc;
    if (cOr())
    {
      if (paramInt == -1)
      {
        localc = Gw(this.sZg);
        AppMethodBeat.o(205642);
        return localc;
      }
      localc = Gw(paramInt);
      AppMethodBeat.o(205642);
      return localc;
    }
    if (cOs())
    {
      localc = (com.tencent.mm.plugin.finder.report.c)this.tcr;
      AppMethodBeat.o(205642);
      return localc;
    }
    if (cOt())
    {
      localc = (com.tencent.mm.plugin.finder.report.c)this.tct;
      AppMethodBeat.o(205642);
      return localc;
    }
    AppMethodBeat.o(205642);
    return null;
  }
  
  public final f Gv(int paramInt)
  {
    AppMethodBeat.i(205644);
    f localf;
    if (cOr())
    {
      if (paramInt == -1)
      {
        localf = Gx(this.sZg);
        AppMethodBeat.o(205644);
        return localf;
      }
      localf = Gx(paramInt);
      AppMethodBeat.o(205644);
      return localf;
    }
    if (cOs())
    {
      localf = (f)this.tcq;
      AppMethodBeat.o(205644);
      return localf;
    }
    if (cOt())
    {
      localf = (f)this.tcs;
      AppMethodBeat.o(205644);
      return localf;
    }
    AppMethodBeat.o(205644);
    return null;
  }
  
  public final f Gx(int paramInt)
  {
    AppMethodBeat.i(205647);
    ad.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localf = (f)this.tcq;
      AppMethodBeat.o(205647);
      return localf;
    case 3: 
      localf = (f)this.tcw;
      AppMethodBeat.o(205647);
      return localf;
    case 1: 
      localf = (f)this.tcA;
      AppMethodBeat.o(205647);
      return localf;
    }
    f localf = (f)this.tcE;
    AppMethodBeat.o(205647);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c Gy(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.rQJ;
    case 3: 
      return this.tcu;
    case 1: 
      return this.tcy;
    }
    return this.tcC;
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(205648);
    d.g.b.p.h(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
      d.g.b.p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      localObject = (FinderHomeTabStateVM)localObject;
      if (!this.tcG) {
        break label442;
      }
      if (((FinderHomeTabStateVM)localObject).fsM() != paramFinderHomeTabFragment.duh) {
        break label144;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (!((FinderHomeTabStateVM)localObject).Gg(paramFinderHomeTabFragment.duh)) {}
      for (paramInt = 3;; paramInt = 2)
      {
        localObject = Gs(paramFinderHomeTabFragment.duh);
        switch (paramFinderHomeTabFragment.duh)
        {
        }
        for (;;)
        {
          this.tcG = false;
          AppMethodBeat.o(205648);
          return;
          label144:
          paramBoolean = false;
          break;
          paramFinderHomeTabFragment = this.tcw;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tcx;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tcA;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcB;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcE;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcF;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
          d.a.b(paramInt, (aqy)localObject, this.sZg, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.tcA;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tcB;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tcw;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcx;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcE;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcF;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
          d.a.a(paramInt, (aqy)localObject, this.sZg, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.tcE;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tcF;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tcA;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcB;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcw;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tcx;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
          d.a.c(paramInt, (aqy)localObject, this.sZg, paramBoolean);
        }
      }
      label442:
      paramBoolean = false;
    }
  }
  
  public final void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(205635);
    super.ac(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
      localObject = this.qXu;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      com.tencent.mm.plugin.finder.report.h.gn(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.c.snN;
      paramBundle = cOu();
      localObject = com.tencent.mm.plugin.finder.report.c.snN;
      localObject = c.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      d.g.b.p.g(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      c.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.c.snN;
      paramBundle = cOu();
      localObject = com.tencent.mm.plugin.finder.report.c.snN;
      localObject = c.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      d.g.b.p.g(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      c.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    paramBundle = x.skz;
    x.startTimer();
    this.tcJ.sendEmptyMessage(sks);
    AppMethodBeat.o(205635);
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(205634);
    super.ad(paramBundle);
    paramBundle = getActivity();
    if ((getActivity() instanceof MMFinderUI)) {}
    while (paramBundle != null) {
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(205634);
        throw paramBundle;
        paramBundle = null;
      }
      else
      {
        fZ(((MMFinderUI)paramBundle).cAZ(), ((MMFinderUI)paramBundle).cBZ());
        AppMethodBeat.o(205634);
        return;
      }
    }
    AppMethodBeat.o(205634);
  }
  
  public final boolean cOr()
  {
    return this.dFx == 1;
  }
  
  public final aqy cOu()
  {
    AppMethodBeat.i(205637);
    if (cOr())
    {
      localObject = com.tencent.mm.ui.component.a.KiD;
      localObject = Gs(((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).cOp());
      AppMethodBeat.o(205637);
      return localObject;
    }
    Object localObject = new aqy();
    ((aqy)localObject).tcl = this.tcl;
    ((aqy)localObject).rTD = this.rTD;
    ((aqy)localObject).sessionId = this.sessionId;
    ((aqy)localObject).qXu = this.qXu;
    ((aqy)localObject).qXj = this.qXj;
    ((aqy)localObject).tcj = this.tcj;
    ((aqy)localObject).tck = this.tck;
    ((aqy)localObject).tcn = this.tcn;
    ((aqy)localObject).tcm = this.tcm;
    ((aqy)localObject).tco = this.tco;
    AppMethodBeat.o(205637);
    return localObject;
  }
  
  public final void fZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205636);
    this.tcl = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 0)
    {
      this.rTD = this.tcl;
      this.dFx = paramInt2;
      localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
        localObject1 = com.tencent.mm.plugin.finder.report.h.cDy();
      }
      this.qXu = ((String)localObject1);
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sessionId = ((String)localObject1);
      this.tcj = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
      this.tck = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
      this.tcm = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
      this.tcn = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
      if (!cOr()) {
        break label660;
      }
      localObject1 = com.tencent.mm.ui.component.a.KiD;
      this.sZg = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).cOp();
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      this.rTD = com.tencent.mm.plugin.finder.report.h.Fa(this.sZg);
      this.qXj = a.Gz(this.sZg);
      label240:
      ad.i(TAG, "initActivityReporter reportType:" + this.dFx + " commentScene:" + this.rTD + " fromCommentScene:" + this.tcl + " sessionId:" + this.sessionId + " contextId:" + this.qXu + " clickTabContextId:" + this.qXj + " currentTabType:" + this.sZg);
      if (!cOr()) {
        break label781;
      }
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(tcK);
      this.tcw = new j((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.tcv = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cHQ()) {
        break label715;
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.d(getActivity(), Gs(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.d)localObject1).onInvisible();
      localObject1 = (k)localObject1;
      label434:
      this.tcx = ((k)localObject1);
      this.tcu = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(tcK);
      this.tcA = new j((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.tcz = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cHQ()) {
        break label748;
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.d(getActivity(), Gs(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.d)localObject1).onInvisible();
      localObject1 = (k)localObject1;
    }
    for (;;)
    {
      this.tcB = ((k)localObject1);
      this.tcy = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(tcK);
      this.tcE = new j((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.tcD = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new com.tencent.mm.plugin.finder.report.d(getActivity(), Gs(4));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      ((com.tencent.mm.plugin.finder.report.d)localObject2).onInvisible();
      this.tcF = ((com.tencent.mm.plugin.finder.report.d)localObject2);
      this.tcC = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject1 = com.tencent.mm.ui.component.a.KiD;
      ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).tbN.add(this);
      AppMethodBeat.o(205636);
      return;
      this.rTD = paramInt1;
      break;
      label660:
      localObject2 = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.qXj = ((String)localObject1);
      if (!bt.isNullOrNil(this.qXj)) {
        break label240;
      }
      this.qXj = a.Gz(paramInt1 + 100);
      break label240;
      label715:
      localObject1 = new k(getActivity(), Gs(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((k)localObject1).onInvisible();
      break label434;
      label748:
      localObject1 = new k(getActivity(), Gs(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((k)localObject1).onInvisible();
    }
    label781:
    if (cOs())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(tcK);
      this.tcp = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.tcq = new j((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new k(getActivity(), cOu());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.tcr = ((k)localObject2);
      this.rQJ = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(205636);
      return;
    }
    if (cOt())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(tcK);
      this.tcp = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.tcs = new com.tencent.mm.plugin.finder.report.o((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new com.tencent.mm.plugin.finder.report.p(getActivity(), cOu());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.tct = ((com.tencent.mm.plugin.finder.report.p)localObject2);
      this.rQJ = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
    }
    AppMethodBeat.o(205636);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(205654);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = Gs(this.sZg);
      com.tencent.mm.plugin.finder.report.h localh = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.a(2, this.sZg, paramIntent);
    }
    AppMethodBeat.o(205654);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205652);
    Object localObject = Gu(-1);
    if ((localObject != null) && ((localObject instanceof k)))
    {
      localObject = (k)localObject;
      c.a locala = com.tencent.mm.plugin.finder.report.c.snN;
      ((k)localObject).ahO(c.a.Y(ae.c(u.S("feedActionType", Integer.valueOf(5)))));
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(205652);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205653);
    ad.i(TAG, "onDestroy");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.snN;
      localObject1 = cOu();
      localObject2 = c.b.snP;
      c.a.a((aqy)localObject1, 0L, 9, c.b.cDq());
      localObject1 = com.tencent.mm.plugin.finder.report.h.soM;
      localObject2 = this.qXu;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.report.h.gn((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.snN;
      localObject1 = cOu();
      localObject2 = c.b.snP;
      c.a.a((aqy)localObject1, 0L, 9, c.b.cDq());
    }
    Object localObject1 = this.rQJ;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.tcu;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.tcy;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.tcC;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = x.skz;
    x.stopTimer();
    this.tcJ.removeCallbacksAndMessages(null);
    this.tcJ.sendEmptyMessage(STOP);
    super.onDestroy();
    AppMethodBeat.o(205653);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205651);
    super.onPause();
    if (cOr()) {
      switch (this.sZg)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.tcI).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.tcw;
      if (localObject != null) {
        ((j)localObject).onInvisible();
      }
      localObject = this.tcx;
      if (localObject != null)
      {
        ((k)localObject).onInvisible();
        continue;
        localObject = this.tcA;
        if (localObject != null) {
          ((j)localObject).onInvisible();
        }
        localObject = this.tcB;
        if (localObject != null)
        {
          ((k)localObject).onInvisible();
          continue;
          localObject = this.tcE;
          if (localObject != null) {
            ((j)localObject).onInvisible();
          }
          localObject = this.tcF;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.report.d)localObject).onInvisible();
            continue;
            if (cOs())
            {
              localObject = this.tcq;
              if (localObject != null) {
                ((j)localObject).onInvisible();
              }
              localObject = this.tcr;
              if (localObject != null) {
                ((k)localObject).onInvisible();
              }
            }
            else if (cOt())
            {
              localObject = this.tcs;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.o)localObject).onInvisible();
              }
              localObject = this.tct;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.p)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(205651);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205650);
    super.onResume();
    if (this.tcH)
    {
      this.tcH = false;
      AppMethodBeat.o(205650);
      return;
    }
    Object localObject1;
    if (cOr())
    {
      localObject1 = Gs(this.sZg);
      switch (this.sZg)
      {
      case 2: 
      default: 
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
        d.a.a(1, cOu(), this.sZg, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
        d.a.b(1, cOu(), this.sZg, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
        d.a.c(1, cOu(), this.sZg, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
        d.a.a(1, cOu());
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
        d.a.a(1, cOu(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.tcI).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.tcx;
      if (localObject2 != null) {
        ((k)localObject2).c((aqy)localObject1);
      }
      localObject1 = this.tcw;
      if (localObject1 != null) {
        ((j)localObject1).onVisible();
      }
      localObject1 = this.tcx;
      if (localObject1 == null) {
        break;
      }
      ((k)localObject1).onVisible();
      break;
      localObject2 = this.tcB;
      if (localObject2 != null) {
        ((k)localObject2).c((aqy)localObject1);
      }
      localObject1 = this.tcA;
      if (localObject1 != null) {
        ((j)localObject1).onVisible();
      }
      localObject1 = this.tcB;
      if (localObject1 == null) {
        break;
      }
      ((k)localObject1).onVisible();
      break;
      localObject2 = this.tcF;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.d)localObject2).c((aqy)localObject1);
      }
      localObject1 = this.tcE;
      if (localObject1 != null) {
        ((j)localObject1).onVisible();
      }
      localObject1 = this.tcF;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.d)localObject1).onVisible();
      break;
      if (cOs())
      {
        localObject1 = this.tcq;
        if (localObject1 != null) {
          ((j)localObject1).onVisible();
        }
        localObject1 = this.tcr;
        if (localObject1 != null) {
          ((k)localObject1).onVisible();
        }
      }
      else if (cOt())
      {
        localObject1 = this.tcs;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.o)localObject1).onVisible();
        }
        localObject1 = this.tct;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.p)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(205650);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"})
  public static final class a
  {
    public static String Gz(int paramInt)
    {
      AppMethodBeat.i(205631);
      String str1 = paramInt + '-' + cf.aCM();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGZ, "100");
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        ad.i(FinderReporterUIC.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", new Object[] { str1, localObject, str2 });
        try
        {
          d.g.b.p.g(str2, "blacklist");
          localObject = ((Iterable)n.c((CharSequence)str2, new char[] { ';' })).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!d.g.b.p.i((String)((Iterator)localObject).next(), String.valueOf(paramInt)));
          AppMethodBeat.o(205631);
          return str1;
        }
        catch (Exception localException)
        {
          e locale = g.ajC();
          d.g.b.p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IIT, str1);
          AppMethodBeat.o(205631);
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
    
    public static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(205628);
      d.g.b.p.h(paramContext, "context");
      d.g.b.p.h(paramIntent, "intent");
      if ((paramContext instanceof MMActivity))
      {
        Object localObject1 = com.tencent.mm.ui.component.a.KiD;
        int i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).rTD;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.FU(i))
        {
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tcl);
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          paramIntent.putExtra("key_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).qXu);
          if (!paramBoolean) {
            break label498;
          }
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).sZg;
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).qXj = Gz(i);
          Object localObject2 = Gz(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject2);
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          Object localObject3 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class);
          if (localObject3 != null)
          {
            localObject1 = ((FinderReporterUIC)localObject3).cOu();
            ((aqy)localObject1).qXj = ((String)localObject2);
            localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
            com.tencent.mm.plugin.finder.report.h.a(i, 2, (aqy)localObject1);
            localObject2 = ((FinderReporterUIC)localObject3).Gu(i);
            if ((localObject2 != null) && ((localObject2 instanceof k)))
            {
              localObject2 = (k)localObject2;
              localObject3 = com.tencent.mm.plugin.finder.report.c.snN;
              ((k)localObject2).ahO(c.a.Y(ae.a(new d.o[] { u.S("feedActionType", Integer.valueOf(2)), u.S("toTab", Integer.valueOf(2)), u.S("fromTab", Integer.valueOf(i)) })));
            }
            localObject2 = com.tencent.mm.plugin.finder.extension.reddot.d.rRT;
            d.a.a(2, (aqy)localObject1);
          }
          label349:
          if (paramLong == 0L) {
            break label531;
          }
          paramIntent.putExtra("key_click_feed_id", paramLong);
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tck;
          if (localObject1 != null) {
            paramIntent.putExtra("key_click_feed_context_id", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tcn;
          if (i != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", i);
          }
          if (paramInt == 0) {
            break label573;
          }
          paramIntent.putExtra("key_enter_profile_type", paramInt);
          AppMethodBeat.o(205628);
          return;
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).rTD);
          break;
          label498:
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          paramIntent.putExtra("key_click_tab_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).qXj);
          break label349;
          label531:
          localObject1 = com.tencent.mm.ui.component.a.KiD;
          paramLong = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tcj;
          if (paramLong != 0L) {
            paramIntent.putExtra("key_click_feed_id", paramLong);
          }
        }
        label573:
        localObject1 = com.tencent.mm.ui.component.a.KiD;
        paramInt = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tcm;
        if (paramInt != 0) {
          paramIntent.putExtra("key_enter_profile_type", paramInt);
        }
        AppMethodBeat.o(205628);
        return;
      }
      ad.w(FinderReporterUIC.access$getTAG$cp(), "initIntentParams context is not MMActivity");
      AppMethodBeat.o(205628);
    }
    
    public static FinderReporterUIC eY(Context paramContext)
    {
      AppMethodBeat.i(205630);
      d.g.b.p.h(paramContext, "context");
      if ((paramContext instanceof MMActivity))
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
        paramContext = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class);
        AppMethodBeat.o(205630);
        return paramContext;
      }
      AppMethodBeat.o(205630);
      return null;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements d.g.a.a<z>
  {
    public b(FinderReporterUIC paramFinderReporterUIC, WxRecyclerAdapter paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class c
    extends ap
  {
    c(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(205633);
      if (paramMessage != null)
      {
        int i = paramMessage.what;
        if (i == FinderReporterUIC.cOv())
        {
          FinderReporterUIC.e(this.tcN);
          sendEmptyMessageDelayed(FinderReporterUIC.cOv(), FinderReporterUIC.cOw());
          AppMethodBeat.o(205633);
          return;
        }
        if (i == FinderReporterUIC.cOx())
        {
          FinderReporterUIC.e(this.tcN);
          paramMessage = FinderReporterUIC.f(this.tcN);
          if (paramMessage != null) {
            paramMessage.cDp();
          }
          removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(205633);
        return;
      }
      AppMethodBeat.o(205633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC
 * JD-Core Version:    0.7.0.1
 */