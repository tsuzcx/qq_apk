package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.c.a;
import com.tencent.mm.plugin.finder.report.c.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.n.n;
import d.o;
import d.u;
import d.v;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "clickFeedContextId", "", "getClickFeedContextId", "()Ljava/lang/String;", "setClickFeedContextId", "(Ljava/lang/String;)V", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "enterSourceInfo", "getEnterSourceInfo", "setEnterSourceInfo", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "extraInfo", "getExtraInfo", "setExtraInfo", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "firstFragmentVisible", "", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "isFirstOnResume", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderHotFeedFlowReporter;", "machineSubscriber", "reportType", "getReportType", "setReportType", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "initActivityReporter", "isHome", "isSingleFeedFlow", "isSnsAdExtraInfo", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPause", "onResume", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "replaceExtraInfoFeedId", "contextObj", "sendStatsList", "feedId", "finderUserName", "setExtraInfoFeedId", "Companion", "plugin-finder_release"})
public final class FinderReporterUIC
  extends UIComponent
  implements h
{
  private static final int STOP = 2;
  public static final String TAG = "Finder.FinderReporterUIC";
  private static final int stp = 1;
  private static final String tnE = "FinderReporterThread";
  private static final long tnF = 60000L;
  public static final a tnG;
  private int dGC;
  String extraInfo;
  private com.tencent.mm.plugin.finder.event.base.c rZl;
  public String rfA;
  public String rfo;
  public String rfr;
  public int sch;
  public String sessionId;
  public int tku;
  private boolean tnA;
  private boolean tnB;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> tnC;
  private final c tnD;
  public long tnd;
  String tne;
  public int tnf;
  int tng;
  public int tnh;
  public String tni;
  private com.tencent.mm.plugin.finder.event.a tnj;
  private k tnk;
  public com.tencent.mm.plugin.finder.report.l tnl;
  private com.tencent.mm.plugin.finder.report.p tnm;
  public q tnn;
  private com.tencent.mm.plugin.finder.event.base.c tno;
  private com.tencent.mm.plugin.finder.event.a tnp;
  private k tnq;
  private com.tencent.mm.plugin.finder.report.l tnr;
  private com.tencent.mm.plugin.finder.event.base.c tns;
  private com.tencent.mm.plugin.finder.event.a tnt;
  private k tnu;
  private com.tencent.mm.plugin.finder.report.l tnv;
  private com.tencent.mm.plugin.finder.event.base.c tnw;
  private com.tencent.mm.plugin.finder.event.a tnx;
  private k tny;
  private com.tencent.mm.plugin.finder.report.d tnz;
  
  static
  {
    AppMethodBeat.i(206285);
    tnG = new a((byte)0);
    tnE = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    stp = 1;
    STOP = 2;
    tnF = 60000L;
    AppMethodBeat.o(206285);
  }
  
  public FinderReporterUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206284);
    this.tni = "";
    this.extraInfo = "";
    this.rfr = "";
    this.tnA = true;
    this.tnB = true;
    this.tnC = new LinkedList();
    this.tnD = new c(this, tnE);
    AppMethodBeat.o(206284);
  }
  
  private com.tencent.mm.plugin.finder.report.c GT(int paramInt)
  {
    AppMethodBeat.i(206275);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "getHomeFlowReporter ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localc = (com.tencent.mm.plugin.finder.report.c)this.tnl;
      AppMethodBeat.o(206275);
      return localc;
    case 3: 
      localc = (com.tencent.mm.plugin.finder.report.c)this.tnr;
      AppMethodBeat.o(206275);
      return localc;
    case 1: 
      localc = (com.tencent.mm.plugin.finder.report.c)this.tnv;
      AppMethodBeat.o(206275);
      return localc;
    }
    com.tencent.mm.plugin.finder.report.c localc = (com.tencent.mm.plugin.finder.report.c)this.tnz;
    AppMethodBeat.o(206275);
    return localc;
  }
  
  private static boolean akl(String paramString)
  {
    AppMethodBeat.i(206265);
    if ((paramString != null) && (n.a((CharSequence)paramString, (CharSequence)"sns_ad", false)))
    {
      AppMethodBeat.o(206265);
      return true;
    }
    AppMethodBeat.o(206265);
    return false;
  }
  
  private boolean cQX()
  {
    return this.dGC == 2;
  }
  
  private boolean cQY()
  {
    return this.dGC == 3;
  }
  
  public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206278);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "onFragmentChange ".concat(String.valueOf(paramInt4)));
    Object localObject1 = i.syT;
    this.sch = i.Fw(paramInt4);
    this.tku = paramInt4;
    if (paramInt1 >= 0) {
      this.rfo = a.GW(paramInt4);
    }
    localObject1 = GP(paramInt4);
    Object localObject2;
    switch (paramInt4)
    {
    case 2: 
    default: 
      localObject2 = com.tencent.mm.ui.component.a.KEX;
      localObject2 = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).getActiveFragment().En;
      if (localObject2 == null) {
        break;
      }
    }
    for (paramInt1 = ((Bundle)localObject2).getInt("Source", 0);; paramInt1 = 0)
    {
      localObject2 = i.syT;
      i.a(paramInt3, paramInt4, (arn)localObject1, paramInt1);
      if (paramInt3 <= 0) {
        break label320;
      }
      localObject1 = GR(paramInt3);
      if (localObject1 == null) {
        break label320;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.report.l))
      {
        localObject1 = (com.tencent.mm.plugin.finder.report.l)localObject1;
        localObject2 = com.tencent.mm.plugin.finder.report.c.sxE;
        ((com.tencent.mm.plugin.finder.report.l)localObject1).aiM(c.a.ae(d.a.ae.a(new o[] { u.R("feedActionType", Integer.valueOf(2)), u.R("toTab", Integer.valueOf(paramInt4)), u.R("fromTab", Integer.valueOf(paramInt3)) })));
      }
      AppMethodBeat.o(206278);
      return;
      localObject2 = this.tnr;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.l)localObject2).c((arn)localObject1);
      break;
      localObject2 = this.tnv;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.l)localObject2).c((arn)localObject1);
      break;
      localObject2 = this.tnz;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.d)localObject2).c((arn)localObject1);
      break;
    }
    label320:
    AppMethodBeat.o(206278);
  }
  
  public final arn GP(int paramInt)
  {
    AppMethodBeat.i(206267);
    arn localarn = new arn();
    localarn.tnf = this.tnf;
    localarn.sessionId = this.sessionId;
    localarn.rfA = this.rfA;
    localarn.rfo = this.rfo;
    localarn.tnd = this.tnd;
    localarn.tne = this.tne;
    Object localObject = i.syT;
    localarn.sch = i.Fw(paramInt);
    localarn.tnh = this.tnh;
    localarn.tng = this.tng;
    localarn.tni = this.tni;
    String str = this.extraInfo;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localarn.extraInfo = ((String)localObject);
    str = this.rfr;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localarn.rfr = ((String)localObject);
    AppMethodBeat.o(206267);
    return localarn;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c GQ(int paramInt)
  {
    AppMethodBeat.i(206268);
    if (cQW())
    {
      if (paramInt == -1)
      {
        localc = GV(this.tku);
        AppMethodBeat.o(206268);
        return localc;
      }
      localc = GV(paramInt);
      AppMethodBeat.o(206268);
      return localc;
    }
    com.tencent.mm.plugin.finder.event.base.c localc = this.rZl;
    AppMethodBeat.o(206268);
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.report.c GR(int paramInt)
  {
    AppMethodBeat.i(206271);
    com.tencent.mm.plugin.finder.report.c localc;
    if (cQW())
    {
      if (paramInt == -1)
      {
        localc = GT(this.tku);
        AppMethodBeat.o(206271);
        return localc;
      }
      localc = GT(paramInt);
      AppMethodBeat.o(206271);
      return localc;
    }
    if (cQX())
    {
      localc = (com.tencent.mm.plugin.finder.report.c)this.tnl;
      AppMethodBeat.o(206271);
      return localc;
    }
    if (cQY())
    {
      localc = (com.tencent.mm.plugin.finder.report.c)this.tnn;
      AppMethodBeat.o(206271);
      return localc;
    }
    AppMethodBeat.o(206271);
    return null;
  }
  
  public final f GS(int paramInt)
  {
    AppMethodBeat.i(206273);
    f localf;
    if (cQW())
    {
      if (paramInt == -1)
      {
        localf = GU(this.tku);
        AppMethodBeat.o(206273);
        return localf;
      }
      localf = GU(paramInt);
      AppMethodBeat.o(206273);
      return localf;
    }
    if (cQX())
    {
      localf = (f)this.tnk;
      AppMethodBeat.o(206273);
      return localf;
    }
    if (cQY())
    {
      localf = (f)this.tnm;
      AppMethodBeat.o(206273);
      return localf;
    }
    AppMethodBeat.o(206273);
    return null;
  }
  
  public final f GU(int paramInt)
  {
    AppMethodBeat.i(206276);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localf = (f)this.tnk;
      AppMethodBeat.o(206276);
      return localf;
    case 3: 
      localf = (f)this.tnq;
      AppMethodBeat.o(206276);
      return localf;
    case 1: 
      localf = (f)this.tnu;
      AppMethodBeat.o(206276);
      return localf;
    }
    f localf = (f)this.tny;
    AppMethodBeat.o(206276);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c GV(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.rZl;
    case 3: 
      return this.tno;
    case 1: 
      return this.tns;
    }
    return this.tnw;
  }
  
  public final void a(arn paramarn, String paramString)
  {
    AppMethodBeat.i(206264);
    if (paramarn != null)
    {
      if (akl(this.extraInfo)) {
        paramarn.rfr = paramString;
      }
      AppMethodBeat.o(206264);
      return;
    }
    AppMethodBeat.o(206264);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(206277);
    d.g.b.p.h(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
      d.g.b.p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      localObject = (FinderHomeTabStateVM)localObject;
      if (!this.tnA) {
        break label442;
      }
      if (((FinderHomeTabStateVM)localObject).cQO() != paramFinderHomeTabFragment.dvm) {
        break label144;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (!((FinderHomeTabStateVM)localObject).EX(paramFinderHomeTabFragment.dvm)) {}
      for (paramInt = 3;; paramInt = 2)
      {
        localObject = GP(paramFinderHomeTabFragment.dvm);
        switch (paramFinderHomeTabFragment.dvm)
        {
        }
        for (;;)
        {
          this.tnA = false;
          AppMethodBeat.o(206277);
          return;
          label144:
          paramBoolean = false;
          break;
          paramFinderHomeTabFragment = this.tnq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tnr;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tnu;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnv;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tny;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnz;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
          d.a.b(paramInt, (arn)localObject, this.tku, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.tnu;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tnv;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tnq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnr;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tny;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnz;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
          d.a.a(paramInt, (arn)localObject, this.tku, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.tny;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tnz;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.tnu;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnv;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.tnr;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
          d.a.c(paramInt, (arn)localObject, this.tku, paramBoolean);
        }
      }
      label442:
      paramBoolean = false;
    }
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(206262);
    super.ad(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = i.syT;
      localObject = this.rfA;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      i.gs(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.c.sxE;
      paramBundle = cQZ();
      localObject = com.tencent.mm.plugin.finder.report.c.sxE;
      localObject = c.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      d.g.b.p.g(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      c.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.c.sxE;
      paramBundle = cQZ();
      localObject = com.tencent.mm.plugin.finder.report.c.sxE;
      localObject = c.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      d.g.b.p.g(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      c.a.a(paramBundle, 0L, 8, (String)localObject);
    }
    paramBundle = y.stw;
    y.startTimer();
    this.tnD.sendEmptyMessage(stp);
    AppMethodBeat.o(206262);
  }
  
  public final void ae(Bundle paramBundle)
  {
    AppMethodBeat.i(206261);
    super.ae(paramBundle);
    paramBundle = getActivity();
    if ((getActivity() instanceof MMFinderUI)) {}
    while (paramBundle != null) {
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(206261);
        throw paramBundle;
        paramBundle = null;
      }
      else
      {
        fZ(((MMFinderUI)paramBundle).cCL(), ((MMFinderUI)paramBundle).cDL());
        AppMethodBeat.o(206261);
        return;
      }
    }
    AppMethodBeat.o(206261);
  }
  
  public final boolean cQW()
  {
    return this.dGC == 1;
  }
  
  public final arn cQZ()
  {
    AppMethodBeat.i(206266);
    if (cQW())
    {
      localObject = com.tencent.mm.ui.component.a.KEX;
      localObject = GP(((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).cQU());
      AppMethodBeat.o(206266);
      return localObject;
    }
    arn localarn = new arn();
    localarn.tnf = this.tnf;
    localarn.sch = this.sch;
    localarn.sessionId = this.sessionId;
    localarn.rfA = this.rfA;
    localarn.rfo = this.rfo;
    localarn.tnd = this.tnd;
    localarn.tne = this.tne;
    localarn.tnh = this.tnh;
    localarn.tng = this.tng;
    localarn.tni = this.tni;
    String str = this.extraInfo;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localarn.extraInfo = ((String)localObject);
    str = this.rfr;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localarn.rfr = ((String)localObject);
    AppMethodBeat.o(206266);
    return localarn;
  }
  
  public final void fZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206263);
    this.tnf = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 0)
    {
      this.sch = this.tnf;
      this.dGC = paramInt2;
      localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = i.syT;
        localObject1 = i.cFt();
      }
      this.rfA = ((String)localObject1);
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sessionId = ((String)localObject1);
      this.tnd = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
      this.tne = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
      this.tng = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
      this.tnh = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
      if (!cQW()) {
        break label782;
      }
      localObject1 = com.tencent.mm.ui.component.a.KEX;
      this.tku = ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).cQU();
      localObject1 = i.syT;
      this.sch = i.Fw(this.tku);
      this.rfo = a.GW(this.tku);
      label241:
      localObject2 = getActivity().getIntent().getStringExtra("key_ad_extra_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.extraInfo = ((String)localObject1);
      localObject2 = getActivity().getIntent().getStringExtra("key_ad_enter_source_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.rfr = ((String)localObject1);
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "initActivityReporter reportType:" + this.dGC + " commentScene:" + this.sch + " fromCommentScene:" + this.tnf + " sessionId:" + this.sessionId + " contextId:" + this.rfA + " clickTabContextId:" + this.rfo + " currentTabType:" + this.tku + " uxInfo:" + this.extraInfo);
      if (!cQW()) {
        break label904;
      }
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(tnE);
      this.tnq = new k((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.tnp = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cJN()) {
        break label838;
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.d(getActivity(), GP(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.d)localObject1).onInvisible();
      localObject1 = (com.tencent.mm.plugin.finder.report.l)localObject1;
      label512:
      this.tnr = ((com.tencent.mm.plugin.finder.report.l)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.tno = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(tnE);
      this.tnu = new k((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.tnt = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (!com.tencent.mm.plugin.finder.storage.b.cJN()) {
        break label871;
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.d(getActivity(), GP(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.d)localObject1).onInvisible();
      localObject1 = (com.tencent.mm.plugin.finder.report.l)localObject1;
    }
    for (;;)
    {
      this.tnv = ((com.tencent.mm.plugin.finder.report.l)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.tns = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(tnE);
      this.tny = new k((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.tnx = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new com.tencent.mm.plugin.finder.report.d(getActivity(), GP(4));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      ((com.tencent.mm.plugin.finder.report.d)localObject2).onInvisible();
      this.tnz = ((com.tencent.mm.plugin.finder.report.d)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.tnw = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject1 = com.tencent.mm.ui.component.a.KEX;
      ((FinderHomeUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderHomeUIC.class)).tmH.add(this);
      AppMethodBeat.o(206263);
      return;
      this.sch = paramInt1;
      break;
      label782:
      localObject2 = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.rfo = ((String)localObject1);
      if (!bu.isNullOrNil(this.rfo)) {
        break label241;
      }
      this.rfo = a.GW(paramInt1 + 100);
      break label241;
      label838:
      localObject1 = new com.tencent.mm.plugin.finder.report.l(getActivity(), GP(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.l)localObject1).onInvisible();
      break label512;
      label871:
      localObject1 = new com.tencent.mm.plugin.finder.report.l(getActivity(), GP(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.l)localObject1).onInvisible();
    }
    label904:
    if (cQX())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(tnE);
      this.tnj = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.tnk = new k((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new com.tencent.mm.plugin.finder.report.l(getActivity(), cQZ());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.tnl = ((com.tencent.mm.plugin.finder.report.l)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.rZl = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(206263);
      return;
    }
    if (cQY())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(tnE);
      this.tnj = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.tnm = new com.tencent.mm.plugin.finder.report.p((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new q(getActivity(), cQZ());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.tnn = ((q)localObject2);
      this.rZl = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
    }
    AppMethodBeat.o(206263);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206283);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = GP(this.tku);
      i locali = i.syT;
      i.b(2, this.tku, paramIntent);
    }
    AppMethodBeat.o(206283);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206281);
    Object localObject = GR(-1);
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.finder.report.l)))
    {
      localObject = (com.tencent.mm.plugin.finder.report.l)localObject;
      c.a locala = com.tencent.mm.plugin.finder.report.c.sxE;
      ((com.tencent.mm.plugin.finder.report.l)localObject).aiM(c.a.ae(d.a.ae.c(u.R("feedActionType", Integer.valueOf(5)))));
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(206281);
    return bool;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206282);
    com.tencent.mm.sdk.platformtools.ae.i(TAG, "onDestroy");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.sxE;
      localObject1 = cQZ();
      localObject2 = c.b.sxG;
      c.a.a((arn)localObject1, 0L, 9, c.b.cFi());
      localObject1 = i.syT;
      localObject2 = this.rfA;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      i.gs((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.sxE;
      localObject1 = cQZ();
      localObject2 = c.b.sxG;
      c.a.a((arn)localObject1, 0L, 9, c.b.cFi());
    }
    Object localObject1 = this.rZl;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.tno;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.tns;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.tnw;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = y.stw;
    y.stopTimer();
    this.tnD.removeCallbacksAndMessages(null);
    this.tnD.sendEmptyMessage(STOP);
    super.onDestroy();
    AppMethodBeat.o(206282);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206280);
    super.onPause();
    if (cQW()) {
      switch (this.tku)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.tnC).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.tnq;
      if (localObject != null) {
        ((k)localObject).onInvisible();
      }
      localObject = this.tnr;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
        continue;
        localObject = this.tnu;
        if (localObject != null) {
          ((k)localObject).onInvisible();
        }
        localObject = this.tnv;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
          continue;
          localObject = this.tny;
          if (localObject != null) {
            ((k)localObject).onInvisible();
          }
          localObject = this.tnz;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.report.d)localObject).onInvisible();
            continue;
            if (cQX())
            {
              localObject = this.tnk;
              if (localObject != null) {
                ((k)localObject).onInvisible();
              }
              localObject = this.tnl;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.l)localObject).onInvisible();
              }
            }
            else if (cQY())
            {
              localObject = this.tnm;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.p)localObject).onInvisible();
              }
              localObject = this.tnn;
              if (localObject != null) {
                ((q)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(206280);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206279);
    super.onResume();
    if (this.tnB)
    {
      this.tnB = false;
      AppMethodBeat.o(206279);
      return;
    }
    Object localObject1;
    if (cQW())
    {
      localObject1 = GP(this.tku);
      switch (this.tku)
      {
      case 2: 
      default: 
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
        d.a.a(1, cQZ(), this.tku, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
        d.a.b(1, cQZ(), this.tku, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
        d.a.c(1, cQZ(), this.tku, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
        d.a.a(1, cQZ());
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
        d.a.a(1, cQZ(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.tnC).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.tnr;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.l)localObject2).c((arn)localObject1);
      }
      localObject1 = this.tnq;
      if (localObject1 != null) {
        ((k)localObject1).onVisible();
      }
      localObject1 = this.tnr;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.l)localObject1).onVisible();
      break;
      localObject2 = this.tnv;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.l)localObject2).c((arn)localObject1);
      }
      localObject1 = this.tnu;
      if (localObject1 != null) {
        ((k)localObject1).onVisible();
      }
      localObject1 = this.tnv;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.l)localObject1).onVisible();
      break;
      localObject2 = this.tnz;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.d)localObject2).c((arn)localObject1);
      }
      localObject1 = this.tny;
      if (localObject1 != null) {
        ((k)localObject1).onVisible();
      }
      localObject1 = this.tnz;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.d)localObject1).onVisible();
      break;
      if (cQX())
      {
        localObject1 = this.tnk;
        if (localObject1 != null) {
          ((k)localObject1).onVisible();
        }
        localObject1 = this.tnl;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.l)localObject1).onVisible();
        }
      }
      else if (cQY())
      {
        localObject1 = this.tnm;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.p)localObject1).onVisible();
        }
        localObject1 = this.tnn;
        if (localObject1 != null) {
          ((q)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(206279);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"})
  public static final class a
  {
    public static String GW(int paramInt)
    {
      AppMethodBeat.i(206258);
      String str1 = paramInt + '-' + ch.aDc();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOF, "100");
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i(FinderReporterUIC.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", new Object[] { str1, localObject, str2 });
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
          AppMethodBeat.o(206258);
          return str1;
        }
        catch (Exception localException)
        {
          e locale = g.ajR();
          d.g.b.p.g(locale, "MMKernel.storage()");
          locale.ajA().set(am.a.Jdz, str1);
          AppMethodBeat.o(206258);
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
      AppMethodBeat.i(206255);
      d.g.b.p.h(paramContext, "context");
      d.g.b.p.h(paramIntent, "intent");
      if ((paramContext instanceof MMActivity))
      {
        Object localObject1 = com.tencent.mm.ui.component.a.KEX;
        int i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).sch;
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        if (com.tencent.mm.plugin.finder.utils.p.Gt(i))
        {
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tnf);
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          paramIntent.putExtra("key_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).rfA);
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).extraInfo;
          if (!bu.isNullOrNil((String)localObject1)) {
            paramIntent.putExtra("key_ad_extra_info", (String)localObject1);
          }
          Object localObject2 = com.tencent.mm.ui.component.a.KEX;
          localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).rfr;
          if (!bu.isNullOrNil((String)localObject1)) {
            paramIntent.putExtra("key_ad_enter_source_info", (String)localObject2);
          }
          if (!paramBoolean) {
            break label584;
          }
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tku;
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).rfo = GW(i);
          localObject2 = GW(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject2);
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          Object localObject3 = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class);
          if (localObject3 != null)
          {
            localObject1 = ((FinderReporterUIC)localObject3).cQZ();
            ((arn)localObject1).rfo = ((String)localObject2);
            localObject2 = i.syT;
            i.b(i, 2, (arn)localObject1);
            localObject2 = ((FinderReporterUIC)localObject3).GR(i);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.finder.report.l)))
            {
              localObject2 = (com.tencent.mm.plugin.finder.report.l)localObject2;
              localObject3 = com.tencent.mm.plugin.finder.report.c.sxE;
              ((com.tencent.mm.plugin.finder.report.l)localObject2).aiM(c.a.ae(d.a.ae.a(new o[] { u.R("feedActionType", Integer.valueOf(2)), u.R("toTab", Integer.valueOf(2)), u.R("fromTab", Integer.valueOf(i)) })));
            }
            localObject2 = com.tencent.mm.plugin.finder.extension.reddot.d.sav;
            d.a.a(2, (arn)localObject1);
          }
          label435:
          if (paramLong == 0L) {
            break label618;
          }
          paramIntent.putExtra("key_click_feed_id", paramLong);
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tne;
          if (localObject1 != null) {
            paramIntent.putExtra("key_click_feed_context_id", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tnh;
          if (i != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", i);
          }
          if (paramInt == 0) {
            break label660;
          }
          paramIntent.putExtra("key_enter_profile_type", paramInt);
          AppMethodBeat.o(206255);
          return;
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).sch);
          break;
          label584:
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          paramIntent.putExtra("key_click_tab_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).rfo);
          break label435;
          label618:
          localObject1 = com.tencent.mm.ui.component.a.KEX;
          paramLong = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tnd;
          if (paramLong != 0L) {
            paramIntent.putExtra("key_click_feed_id", paramLong);
          }
        }
        label660:
        localObject1 = com.tencent.mm.ui.component.a.KEX;
        paramInt = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class)).tng;
        if (paramInt != 0) {
          paramIntent.putExtra("key_enter_profile_type", paramInt);
        }
        AppMethodBeat.o(206255);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.w(FinderReporterUIC.access$getTAG$cp(), "initIntentParams context is not MMActivity");
      AppMethodBeat.o(206255);
    }
    
    public static FinderReporterUIC fc(Context paramContext)
    {
      AppMethodBeat.i(206257);
      d.g.b.p.h(paramContext, "context");
      if ((paramContext instanceof MMActivity))
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
        paramContext = (FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramContext).get(FinderReporterUIC.class);
        AppMethodBeat.o(206257);
        return paramContext;
      }
      AppMethodBeat.o(206257);
      return null;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class c
    extends aq
  {
    c(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(206260);
      if (paramMessage != null)
      {
        int i = paramMessage.what;
        if (i == FinderReporterUIC.cRa())
        {
          FinderReporterUIC.e(this.tnH);
          sendEmptyMessageDelayed(FinderReporterUIC.cRa(), FinderReporterUIC.cRb());
          AppMethodBeat.o(206260);
          return;
        }
        if (i == FinderReporterUIC.cRc())
        {
          FinderReporterUIC.e(this.tnH);
          paramMessage = FinderReporterUIC.f(this.tnH);
          if (paramMessage != null) {
            paramMessage.cFh();
          }
          removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(206260);
        return;
      }
      AppMethodBeat.o(206260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC
 * JD-Core Version:    0.7.0.1
 */