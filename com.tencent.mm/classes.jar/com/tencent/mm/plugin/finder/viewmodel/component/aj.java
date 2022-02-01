package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.c.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.ah;
import com.tencent.mm.plugin.finder.report.g.c;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.findersdk.a.aa;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderReporterUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "changeByClick", "", "chnlExtra", "", "getChnlExtra", "()Ljava/lang/String;", "setChnlExtra", "(Ljava/lang/String;)V", "clickFeedContextId", "getClickFeedContextId", "setClickFeedContextId", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickSubTabContextId", "getClickSubTabContextId", "setClickSubTabContextId", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "enterSourceInfo", "getEnterSourceInfo", "setEnterSourceInfo", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "extraInfo", "getExtraInfo", "setExtraInfo", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "firstFragmentVisible", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "isBlockTwoFeedReport", "()Z", "setBlockTwoFeedReport", "(Z)V", "isFirstOnResume", "isMegaVideo", "setMegaVideo", "lbsCardFlowReporter", "Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "machineSubscriber", "megaVideoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "reportType", "getReportType", "setReportType", "scrollByUser", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "getLastVisibleExtStats", "", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "initActivityReporter", "isCampaign", "isHome", "isLbsCardFlow", "isMegaVideoFeedFlow", "isNearby", "isSingleFeedFlow", "isSnsAdExtraInfo", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "onUserVisibleUnFocused", "replaceExtraInfoFeedId", "contextObj", "sendStatsList", "feedId", "finderUserName", "setExtraInfoFeedId", "Companion", "plugin-finder_release"})
public final class aj
  extends UIComponent
  implements com.tencent.mm.plugin.finder.view.i, aa
{
  private static final long Bnt = 60000L;
  public static final a Bnu;
  private static final String TAG = "Finder.FinderReporterUIC";
  private static final String THREAD_TAG = "FinderReporterThread";
  private static final int zAW = 1;
  private static final int zBa = 2;
  public int Bgp;
  long BmO;
  String BmP;
  int BmQ;
  public int BmR;
  public String BmS;
  private boolean BmT;
  public boolean BmU;
  private com.tencent.mm.plugin.finder.event.a BmV;
  private r BmW;
  private com.tencent.mm.plugin.finder.report.s BmX;
  private ah BmY;
  private y BmZ;
  private z Bna;
  private ag Bnb;
  private com.tencent.mm.plugin.finder.event.base.c Bnc;
  private com.tencent.mm.plugin.finder.event.a Bnd;
  private r Bne;
  private com.tencent.mm.plugin.finder.report.s Bnf;
  private com.tencent.mm.plugin.finder.event.base.c Bng;
  private com.tencent.mm.plugin.finder.event.a Bnh;
  private r Bni;
  private com.tencent.mm.plugin.finder.report.s Bnj;
  private com.tencent.mm.plugin.finder.event.base.c Bnk;
  private com.tencent.mm.plugin.finder.event.a Bnl;
  private r Bnm;
  private com.tencent.mm.plugin.finder.report.i Bnn;
  private boolean Bno;
  private boolean Bnp;
  private boolean Bnq;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> Bnr;
  private final c Bns;
  public String extraInfo;
  public int fGo;
  private int fSe;
  public String sessionId;
  String wmC;
  public String wmL;
  public String wmz;
  public int xkX;
  private com.tencent.mm.plugin.finder.event.base.c xqM;
  public String yAU;
  public String yAV;
  private boolean zEs;
  
  static
  {
    AppMethodBeat.i(277283);
    Bnu = new a((byte)0);
    THREAD_TAG = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    zAW = 1;
    zBa = 2;
    Bnt = 60000L;
    AppMethodBeat.o(277283);
  }
  
  public aj(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(277281);
    this.BmS = "";
    this.extraInfo = "";
    this.wmC = "";
    this.Bno = true;
    this.Bnp = true;
    this.zEs = true;
    this.Bnr = new LinkedList();
    this.Bns = new c(this, THREAD_TAG);
    AppMethodBeat.o(277281);
  }
  
  public aj(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(277282);
    this.BmS = "";
    this.extraInfo = "";
    this.wmC = "";
    this.Bno = true;
    this.Bnp = true;
    this.zEs = true;
    this.Bnr = new LinkedList();
    this.Bns = new c(this, THREAD_TAG);
    AppMethodBeat.o(277282);
  }
  
  private com.tencent.mm.plugin.finder.report.g RX(int paramInt)
  {
    AppMethodBeat.i(277267);
    Log.i(TAG, "getHomeFlowReporter ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localg = (com.tencent.mm.plugin.finder.report.g)this.BmX;
      AppMethodBeat.o(277267);
      return localg;
    case 3: 
      localg = (com.tencent.mm.plugin.finder.report.g)this.Bnf;
      AppMethodBeat.o(277267);
      return localg;
    case 1: 
      localg = (com.tencent.mm.plugin.finder.report.g)this.Bnj;
      AppMethodBeat.o(277267);
      return localg;
    }
    com.tencent.mm.plugin.finder.report.g localg = (com.tencent.mm.plugin.finder.report.g)this.Bnn;
    AppMethodBeat.o(277267);
    return localg;
  }
  
  private static void a(bid parambid, String paramString)
  {
    if (parambid != null) {
      parambid.wmC = paramString;
    }
  }
  
  private boolean ekU()
  {
    return this.fSe == 2;
  }
  
  private boolean ekV()
  {
    return this.fSe == 3;
  }
  
  private boolean ekW()
  {
    return this.fSe == 4;
  }
  
  private final boolean ekX()
  {
    return this.fSe == 5;
  }
  
  private boolean isNearby()
  {
    AppMethodBeat.i(277250);
    boolean bool = ((e)h.ag(e.class)).isNearby(getFragment());
    AppMethodBeat.o(277250);
    return bool;
  }
  
  public final void H(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(277271);
    Log.i(TAG, "onFragmentChange ".concat(String.valueOf(paramInt4)));
    Object localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
    this.xkX = com.tencent.mm.plugin.finder.report.n.Pz(paramInt4);
    this.Bgp = paramInt4;
    if (paramInt1 >= 0) {
      this.wmz = a.Sa(paramInt4);
    }
    localObject1 = RT(paramInt4);
    Object localObject2;
    switch (paramInt4)
    {
    case 2: 
    default: 
      if (this.Bnp)
      {
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        localObject2 = ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).getActiveFragment().zDr;
        if (localObject2 != null) {
          paramInt1 = ((Bundle)localObject2).getInt("Source", 0);
        }
      }
      break;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a(paramInt3, paramInt4, (bid)localObject1, paramInt1);
      if (paramInt3 <= 0) {
        break label338;
      }
      localObject1 = RV(paramInt3);
      if (localObject1 == null) {
        break label338;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.report.s))
      {
        localObject1 = (com.tencent.mm.plugin.finder.report.s)localObject1;
        localObject2 = com.tencent.mm.plugin.finder.report.g.zUU;
        ((com.tencent.mm.plugin.finder.report.s)localObject1).aEe(com.tencent.mm.plugin.finder.report.g.a.aa(ae.e(new o[] { kotlin.s.M("feedActionType", Integer.valueOf(2)), kotlin.s.M("toTab", Integer.valueOf(paramInt4)), kotlin.s.M("fromTab", Integer.valueOf(paramInt3)) })));
      }
      AppMethodBeat.o(277271);
      return;
      localObject2 = this.Bnf;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.s)localObject2).f((bid)localObject1);
      break;
      localObject2 = this.Bnj;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.s)localObject2).f((bid)localObject1);
      break;
      localObject2 = this.Bnn;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.i)localObject2).f((bid)localObject1);
      break;
      paramInt1 = 0;
      continue;
      this.Bnp = true;
      paramInt1 = 6;
    }
    label338:
    AppMethodBeat.o(277271);
  }
  
  public final bid RT(int paramInt)
  {
    AppMethodBeat.i(277257);
    bid localbid = new bid();
    localbid.fGo = this.fGo;
    localbid.sessionId = this.sessionId;
    localbid.wmL = this.wmL;
    localbid.wmz = this.wmz;
    localbid.BmO = this.BmO;
    localbid.BmP = this.BmP;
    Object localObject = com.tencent.mm.plugin.finder.report.n.zWF;
    localbid.xkX = com.tencent.mm.plugin.finder.report.n.Pz(paramInt);
    localbid.BmR = this.BmR;
    localbid.BmQ = this.BmQ;
    localbid.BmS = this.BmS;
    String str = this.extraInfo;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbid.extraInfo = ((String)localObject);
    str = this.wmC;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbid.wmC = ((String)localObject);
    localbid.BmT = false;
    AppMethodBeat.o(277257);
    return localbid;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c RU(int paramInt)
  {
    AppMethodBeat.i(277259);
    if (ekT())
    {
      if (paramInt == -1)
      {
        localc = RZ(this.Bgp);
        AppMethodBeat.o(277259);
        return localc;
      }
      localc = RZ(paramInt);
      AppMethodBeat.o(277259);
      return localc;
    }
    com.tencent.mm.plugin.finder.event.base.c localc = this.xqM;
    AppMethodBeat.o(277259);
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.report.g RV(int paramInt)
  {
    AppMethodBeat.i(277262);
    com.tencent.mm.plugin.finder.report.g localg;
    if (ekT())
    {
      if (paramInt == -1)
      {
        localg = RX(this.Bgp);
        AppMethodBeat.o(277262);
        return localg;
      }
      localg = RX(paramInt);
      AppMethodBeat.o(277262);
      return localg;
    }
    if (ekU())
    {
      localg = (com.tencent.mm.plugin.finder.report.g)this.BmX;
      AppMethodBeat.o(277262);
      return localg;
    }
    if (ekV())
    {
      localg = (com.tencent.mm.plugin.finder.report.g)this.Bna;
      AppMethodBeat.o(277262);
      return localg;
    }
    if (ekW())
    {
      localg = (com.tencent.mm.plugin.finder.report.g)this.BmY;
      AppMethodBeat.o(277262);
      return localg;
    }
    if (ekX())
    {
      localg = (com.tencent.mm.plugin.finder.report.g)this.Bnb;
      AppMethodBeat.o(277262);
      return localg;
    }
    AppMethodBeat.o(277262);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.f RW(int paramInt)
  {
    AppMethodBeat.i(277264);
    com.tencent.mm.plugin.finder.event.base.f localf;
    if (ekT())
    {
      if (paramInt == -1)
      {
        localf = RY(this.Bgp);
        AppMethodBeat.o(277264);
        return localf;
      }
      localf = RY(paramInt);
      AppMethodBeat.o(277264);
      return localf;
    }
    if (ekU())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.BmW;
      AppMethodBeat.o(277264);
      return localf;
    }
    if (ekV())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.BmZ;
      AppMethodBeat.o(277264);
      return localf;
    }
    if (ekW())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.BmW;
      AppMethodBeat.o(277264);
      return localf;
    }
    AppMethodBeat.o(277264);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.f RY(int paramInt)
  {
    AppMethodBeat.i(277268);
    Log.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.BmW;
      AppMethodBeat.o(277268);
      return localf;
    case 3: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.Bne;
      AppMethodBeat.o(277268);
      return localf;
    case 1: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.Bni;
      AppMethodBeat.o(277268);
      return localf;
    }
    com.tencent.mm.plugin.finder.event.base.f localf = (com.tencent.mm.plugin.finder.event.base.f)this.Bnm;
    AppMethodBeat.o(277268);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c RZ(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.xqM;
    case 3: 
      return this.Bnc;
    case 1: 
      return this.Bng;
    }
    return this.Bnk;
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(277269);
    p.k(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class);
      p.j(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      localObject = (com.tencent.mm.plugin.finder.viewmodel.b)localObject;
      if (!this.Bno) {
        break label442;
      }
      if (((com.tencent.mm.plugin.finder.viewmodel.b)localObject).ekb() != paramFinderHomeTabFragment.fEH) {
        break label144;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.finder.viewmodel.b)localObject).OO(paramFinderHomeTabFragment.fEH)) {}
      for (paramInt = 3;; paramInt = 2)
      {
        localObject = RT(paramFinderHomeTabFragment.fEH);
        switch (paramFinderHomeTabFragment.fEH)
        {
        }
        for (;;)
        {
          this.Bno = false;
          AppMethodBeat.o(277269);
          return;
          label144:
          paramBoolean = false;
          break;
          paramFinderHomeTabFragment = this.Bne;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.Bnf;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.Bni;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnj;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnn;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
          i.a.b(paramInt, (bid)localObject, this.Bgp, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.Bni;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.Bnj;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.Bne;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnf;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnn;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
          i.a.a(paramInt, (bid)localObject, this.Bgp, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.Bnm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.Bnn;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.Bni;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnj;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bne;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.Bnf;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
          i.a.c(paramInt, (bid)localObject, this.Bgp, paramBoolean);
        }
      }
      label442:
      paramBoolean = false;
    }
  }
  
  public final boolean ekT()
  {
    return this.fSe == 1;
  }
  
  public final bid ekY()
  {
    AppMethodBeat.i(277254);
    if (ekT())
    {
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = RT(((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).ekL());
      AppMethodBeat.o(277254);
      return localObject;
    }
    bid localbid = new bid();
    localbid.fGo = this.fGo;
    localbid.xkX = this.xkX;
    localbid.sessionId = this.sessionId;
    localbid.wmL = this.wmL;
    localbid.wmz = this.wmz;
    localbid.BmO = this.BmO;
    localbid.BmP = this.BmP;
    localbid.BmR = this.BmR;
    localbid.BmQ = this.BmQ;
    localbid.BmS = this.BmS;
    String str = this.extraInfo;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbid.extraInfo = ((String)localObject);
    str = this.wmC;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbid.wmC = ((String)localObject);
    localbid.BmT = this.BmT;
    localbid.fEH = this.Bgp;
    AppMethodBeat.o(277254);
    return localbid;
  }
  
  public final List<amd> ekZ()
  {
    AppMethodBeat.i(277280);
    com.tencent.mm.plugin.finder.report.g localg = RV(-1);
    LinkedList localLinkedList = new LinkedList();
    if ((localg instanceof com.tencent.mm.plugin.finder.report.s))
    {
      Iterator localIterator = ((Map)((com.tencent.mm.plugin.finder.report.s)localg).zWQ).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        amd localamd = new amd();
        localamd.xbk = ((com.tencent.mm.plugin.finder.report.t)((Map.Entry)localObject).getValue()).feedId;
        localObject = ((com.tencent.mm.plugin.finder.report.t)((Map.Entry)localObject).getValue()).xpY;
        if (localObject != null)
        {
          str = ((FinderItem)localObject).getUserName();
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localamd.finderUsername = ((String)localObject);
        localObject = com.tencent.mm.plugin.finder.report.n.zWF;
        String str = com.tencent.mm.plugin.finder.report.n.N(localamd.xbk, localg.xbu.xkX);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localamd.sessionBuffer = ((String)localObject);
        localLinkedList.add(localamd);
      }
    }
    Object localObject = (List)localLinkedList;
    AppMethodBeat.o(277280);
    return localObject;
  }
  
  public final void hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277249);
    this.fGo = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
    if (paramInt1 == 0)
    {
      this.xkX = this.fGo;
      this.fSe = paramInt2;
      this.BmT = ekW();
      localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.dPD();
      }
      this.wmL = ((String)localObject1);
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sessionId = ((String)localObject1);
      this.BmO = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
      this.BmP = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
      this.BmQ = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
      this.BmR = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
      if (!ekT()) {
        break label521;
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      this.Bgp = ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).ekL();
      localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
      this.xkX = com.tencent.mm.plugin.finder.report.n.Pz(this.Bgp);
      this.wmz = a.Sa(this.Bgp);
    }
    for (;;)
    {
      localObject2 = getActivity().getIntent().getStringExtra("key_extra_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.extraInfo = ((String)localObject1);
      localObject2 = getActivity().getIntent().getStringExtra("key_enter_source_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.wmC = ((String)localObject1);
      Log.i(TAG, "initActivityReporter reportType:" + this.fSe + " commentScene:" + this.xkX + " fromCommentScene:" + this.fGo + " sessionId:" + this.sessionId + " contextId:" + this.wmL + " clickTabContextId:" + this.wmz + " currentTabType:" + this.Bgp + " uxInfo:" + this.extraInfo);
      if (!ekT()) {
        break label1252;
      }
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.Bne = new r((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.Bnd = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dUN()) {
        break label911;
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break label774;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(277249);
      throw ((Throwable)localObject1);
      this.xkX = paramInt1;
      break;
      label521:
      if (isNearby())
      {
        this.Bgp = ((e)h.ag(e.class)).getTabType(getFragment());
        this.xkX = ((e)h.ag(e.class)).getCommentScene(getFragment());
        this.wmz = (((e)h.ag(e.class)).getClickTabId(getFragment()) + '-' + cm.bfE());
      }
      else if ((getFragment() instanceof FinderActivityFragment))
      {
        localObject1 = getFragment();
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
          AppMethodBeat.o(277249);
          throw ((Throwable)localObject1);
        }
        this.Bgp = (((FinderActivityFragment)localObject1).fEH + 1);
        if (getFragment() == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
          AppMethodBeat.o(277249);
          throw ((Throwable)localObject1);
        }
        this.xkX = 59;
        this.wmz = a.Sa(paramInt1 + 100);
      }
      else
      {
        localObject2 = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        this.wmz = ((String)localObject1);
        if (Util.isNullOrNil(this.wmz)) {
          this.wmz = a.Sa(paramInt1 + 100);
        }
      }
    }
    label774:
    Object localObject1 = new com.tencent.mm.plugin.finder.report.i((MMFragmentActivity)localObject1, RT(3));
    ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
    ((com.tencent.mm.plugin.finder.report.i)localObject1).onInvisible();
    localObject1 = (com.tencent.mm.plugin.finder.report.s)localObject1;
    for (;;)
    {
      this.Bnf = ((com.tencent.mm.plugin.finder.report.s)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.Bnc = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.Bni = new r((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.Bnh = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!com.tencent.mm.plugin.finder.storage.d.dUN()) {
        break label1098;
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(277249);
      throw ((Throwable)localObject1);
      label911:
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(277249);
        throw ((Throwable)localObject1);
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.s((MMFragmentActivity)localObject1, RT(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.s)localObject1).onInvisible();
    }
    localObject1 = new com.tencent.mm.plugin.finder.report.i((MMFragmentActivity)localObject1, RT(1));
    ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
    ((com.tencent.mm.plugin.finder.report.i)localObject1).onInvisible();
    localObject1 = (com.tencent.mm.plugin.finder.report.s)localObject1;
    for (;;)
    {
      this.Bnj = ((com.tencent.mm.plugin.finder.report.s)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.Bng = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.Bnm = new r((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.Bnl = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(277249);
      throw ((Throwable)localObject1);
      label1098:
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(277249);
        throw ((Throwable)localObject1);
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.s((MMFragmentActivity)localObject1, RT(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((com.tencent.mm.plugin.finder.report.s)localObject1).onInvisible();
    }
    Object localObject2 = new com.tencent.mm.plugin.finder.report.i((MMFragmentActivity)localObject2, RT(4));
    ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
    ((com.tencent.mm.plugin.finder.report.i)localObject2).onInvisible();
    this.Bnn = ((com.tencent.mm.plugin.finder.report.i)localObject2);
    ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
    this.Bnk = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
    localObject1 = com.tencent.mm.ui.component.g.Xox;
    ((FinderHomeUIC)com.tencent.mm.ui.component.g.b(getActivity()).i(FinderHomeUIC.class)).Bls.add(this);
    AppMethodBeat.o(277249);
    return;
    label1252:
    if (ekU())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.BmV = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.BmW = new r((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(277249);
        throw ((Throwable)localObject1);
      }
      localObject2 = new com.tencent.mm.plugin.finder.report.s((MMFragmentActivity)localObject2, ekY());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.BmX = ((com.tencent.mm.plugin.finder.report.s)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.xqM = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(277249);
      return;
    }
    if (ekV())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.BmV = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.BmZ = new y((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(277249);
        throw ((Throwable)localObject1);
      }
      localObject2 = new z((MMFragmentActivity)localObject2, ekY());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.Bna = ((z)localObject2);
      this.xqM = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(277249);
      return;
    }
    if (ekW())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.BmV = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.BmW = new r((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(277249);
        throw ((Throwable)localObject1);
      }
      localObject2 = new ah((MMFragmentActivity)localObject2, ekY());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.BmY = ((ah)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new com.tencent.mm.plugin.finder.event.b());
      this.xqM = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(277249);
      return;
    }
    if (ekX())
    {
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(277249);
        throw ((Throwable)localObject1);
      }
      this.Bnb = new ag((MMActivity)localObject1, ekY());
    }
    AppMethodBeat.o(277249);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(277278);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = RT(this.Bgp);
      com.tencent.mm.plugin.finder.report.n localn = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.a(2, this.Bgp, paramIntent);
    }
    AppMethodBeat.o(277278);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(277276);
    Object localObject = RV(-1);
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.finder.report.s)) && (!(getActivity() instanceof FinderHomeUI)))
    {
      localObject = (com.tencent.mm.plugin.finder.report.s)localObject;
      com.tencent.mm.plugin.finder.report.g.a locala = com.tencent.mm.plugin.finder.report.g.zUU;
      ((com.tencent.mm.plugin.finder.report.s)localObject).aEe(com.tencent.mm.plugin.finder.report.g.a.aa(ae.d(kotlin.s.M("feedActionType", Integer.valueOf(5)))));
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(277276);
    return bool;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(277246);
    super.onCreateAfter(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
      localObject = this.wmL;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      com.tencent.mm.plugin.finder.report.n.hj(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.g.zUU;
      paramBundle = ekY();
      localObject = com.tencent.mm.plugin.finder.report.g.zUU;
      localObject = com.tencent.mm.plugin.finder.report.g.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      p.j(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      com.tencent.mm.plugin.finder.report.g.a.a(paramBundle, 0L, 8, (String)localObject, 0L, null, 48);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.g.zUU;
      paramBundle = ekY();
      localObject = com.tencent.mm.plugin.finder.report.g.zUU;
      localObject = com.tencent.mm.plugin.finder.report.g.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      p.j(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      com.tencent.mm.plugin.finder.report.g.a.a(paramBundle, 0L, 8, (String)localObject, 0L, null, 48);
    }
    paramBundle = au.zBf;
    au.startTimer();
    this.Bns.sendEmptyMessage(zAW);
    AppMethodBeat.o(277246);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(277245);
    super.onCreateBefore(paramBundle);
    paramBundle = getFragment();
    int i;
    label39:
    label90:
    aj localaj;
    if ((isNearby()) || ((getFragment() instanceof FinderActivityFragment)))
    {
      i = 1;
      if (i == 0) {
        break label146;
      }
      if (paramBundle != null)
      {
        if (!isNearby()) {
          break label151;
        }
        hm(((e)h.ag(e.class)).getCommentScene(getFragment()), ((e)h.ag(e.class)).getReportType(getFragment()));
        if (paramBundle != null) {
          break label217;
        }
      }
      localaj = (aj)this;
      paramBundle = localaj.getActivity();
      if (!(localaj.getActivity() instanceof MMFinderUI)) {
        break label194;
      }
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        if (paramBundle == null)
        {
          paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
          AppMethodBeat.o(277245);
          throw paramBundle;
          i = 0;
          break;
          label146:
          paramBundle = null;
          break label39;
          label151:
          if (!(getFragment() instanceof FinderActivityFragment)) {
            break label90;
          }
          if (paramBundle == null)
          {
            paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
            AppMethodBeat.o(277245);
            throw paramBundle;
          }
          hm(59, 3);
          break label90;
          label194:
          paramBundle = null;
          continue;
        }
        localaj.hm(((MMFinderUI)paramBundle).getCommentScene(), ((MMFinderUI)paramBundle).duR());
      }
    }
    label217:
    AppMethodBeat.o(277245);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277277);
    Log.i(TAG, "onDestroy");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.g.zUU;
      localObject1 = ekY();
      localObject2 = g.c.zUZ;
      com.tencent.mm.plugin.finder.report.g.a.a((bid)localObject1, 0L, 9, g.c.dPm(), 0L, null, 48);
      localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
      localObject2 = this.wmL;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.report.n.hj((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.g.zUU;
      localObject1 = ekY();
      localObject2 = g.c.zUZ;
      com.tencent.mm.plugin.finder.report.g.a.a((bid)localObject1, 0L, 9, g.c.dPm(), 0L, null, 48);
    }
    if (!this.BmU)
    {
      localObject1 = this.xqM;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
      }
    }
    Object localObject1 = this.Bnc;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.Bng;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.Bnk;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = au.zBf;
    au.stopTimer();
    this.Bns.removeCallbacksAndMessages(null);
    this.Bns.sendEmptyMessage(zBa);
    super.onDestroy();
    AppMethodBeat.o(277277);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.Bnq = true;
      return;
    }
    this.Bnq = false;
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.Bnq)
    {
      this.Bnp = false;
      this.Bnq = false;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(277273);
    super.onPause();
    if (ekT()) {
      switch (this.Bgp)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.Bnr).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.Bne;
      if (localObject != null) {
        ((r)localObject).onInvisible();
      }
      localObject = this.Bnf;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.report.s)localObject).onInvisible();
        continue;
        localObject = this.Bni;
        if (localObject != null) {
          ((r)localObject).onInvisible();
        }
        localObject = this.Bnj;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.report.s)localObject).onInvisible();
          continue;
          localObject = this.Bnm;
          if (localObject != null) {
            ((r)localObject).onInvisible();
          }
          localObject = this.Bnn;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.report.i)localObject).onInvisible();
            continue;
            if (ekU())
            {
              localObject = this.BmW;
              if (localObject != null) {
                ((r)localObject).onInvisible();
              }
              localObject = this.BmX;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.s)localObject).onInvisible();
              }
            }
            else if (ekV())
            {
              localObject = this.BmZ;
              if (localObject != null) {
                ((y)localObject).onInvisible();
              }
              if (!this.BmU)
              {
                localObject = this.Bna;
                if (localObject != null) {
                  ((z)localObject).onInvisible();
                }
              }
            }
            else if (ekW())
            {
              localObject = this.BmW;
              if (localObject != null) {
                ((r)localObject).onInvisible();
              }
              localObject = this.BmY;
              if (localObject != null) {
                ((ah)localObject).onInvisible();
              }
            }
            else if (ekX())
            {
              localObject = this.Bnb;
              if (localObject != null) {
                ((ag)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(277273);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(277272);
    super.onResume();
    if (this.zEs)
    {
      this.zEs = false;
      AppMethodBeat.o(277272);
      return;
    }
    Object localObject1;
    if (ekT())
    {
      localObject1 = RT(this.Bgp);
      switch (this.Bgp)
      {
      case 2: 
      default: 
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.a(1, ekY(), this.Bgp, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.b(1, ekY(), this.Bgp, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.c(1, ekY(), this.Bgp, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.a(1, ekY());
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
        i.a.a(1, ekY(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.Bnr).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.Bnf;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.s)localObject2).f((bid)localObject1);
      }
      localObject1 = this.Bne;
      if (localObject1 != null) {
        ((r)localObject1).onVisible();
      }
      localObject1 = this.Bnf;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.s)localObject1).onVisible();
      break;
      localObject2 = this.Bnj;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.s)localObject2).f((bid)localObject1);
      }
      localObject1 = this.Bni;
      if (localObject1 != null) {
        ((r)localObject1).onVisible();
      }
      localObject1 = this.Bnj;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.s)localObject1).onVisible();
      break;
      localObject2 = this.Bnn;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.i)localObject2).f((bid)localObject1);
      }
      localObject1 = this.Bnm;
      if (localObject1 != null) {
        ((r)localObject1).onVisible();
      }
      localObject1 = this.Bnn;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.i)localObject1).onVisible();
      break;
      if (ekU())
      {
        localObject1 = this.BmW;
        if (localObject1 != null) {
          ((r)localObject1).onVisible();
        }
        localObject1 = this.BmX;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.s)localObject1).onVisible();
        }
      }
      else if (ekV())
      {
        localObject1 = this.BmZ;
        if (localObject1 != null) {
          ((y)localObject1).onVisible();
        }
        localObject1 = this.Bna;
        if (localObject1 != null) {
          ((z)localObject1).onVisible();
        }
      }
      else if (ekW())
      {
        localObject1 = this.BmW;
        if (localObject1 != null) {
          ((r)localObject1).onVisible();
        }
        localObject1 = this.BmY;
        if (localObject1 != null) {
          ((ah)localObject1).onVisible();
        }
      }
      else if (ekX())
      {
        localObject1 = this.Bnb;
        if (localObject1 != null) {
          ((ag)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(277272);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(277274);
    super.onUserVisibleFocused();
    if (ekV())
    {
      Object localObject = this.BmZ;
      if (localObject != null) {
        ((y)localObject).onVisible();
      }
      localObject = this.Bna;
      if (localObject != null)
      {
        ((z)localObject).onVisible();
        AppMethodBeat.o(277274);
        return;
      }
    }
    AppMethodBeat.o(277274);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(277275);
    super.onUserVisibleUnFocused();
    if (ekV())
    {
      Object localObject = this.BmZ;
      if (localObject != null) {
        ((y)localObject).onInvisible();
      }
      localObject = this.Bna;
      if (localObject != null)
      {
        ((z)localObject).onInvisible();
        AppMethodBeat.o(277275);
        return;
      }
    }
    AppMethodBeat.o(277275);
  }
  
  public final void z(long paramLong, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(277252);
    Log.i(TAG, "setEnterSourceInfo:" + paramLong + "  finderUserName:" + paramString + '}');
    Object localObject3 = new JSONObject();
    Object localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
    String str = com.tencent.mm.plugin.finder.report.n.Mp(paramLong);
    this.BmO = paramLong;
    ((JSONObject)localObject3).put("feedid", str);
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      ((JSONObject)localObject3).put("finderusername", localObject1);
      localObject3 = ((JSONObject)localObject3).toString();
      p.j(localObject3, "enterSourceJson.toString()");
      this.wmC = ((String)localObject3);
      localObject1 = this.BmX;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.finder.report.g)localObject1).xbu;; localObject1 = null)
      {
        a((bid)localObject1, (String)localObject3);
        z localz = this.Bna;
        localObject1 = localObject2;
        if (localz != null) {
          localObject1 = localz.xbu;
        }
        a((bid)localObject1, (String)localObject3);
        getActivity().getIntent().putExtra("key_enter_source_info", this.wmC);
        if (!Util.isNullOrNil(this.extraInfo))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.g.zUU;
          com.tencent.mm.plugin.finder.report.g.a.s(this.wmL, this.extraInfo, str, paramString);
        }
        AppMethodBeat.o(277252);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"})
  public static final class a
  {
    public static String Sa(int paramInt)
    {
      AppMethodBeat.i(268490);
      String str1 = paramInt + '-' + cm.bfE();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWy, "100");
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        Log.i(aj.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", new Object[] { str1, localObject, str2 });
        try
        {
          p.j(str2, "blacklist");
          localObject = ((Iterable)kotlin.n.n.b((CharSequence)str2, new char[] { ';' })).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!p.h((String)((Iterator)localObject).next(), String.valueOf(paramInt)));
          AppMethodBeat.o(268490);
          return str1;
        }
        catch (Exception localException)
        {
          com.tencent.mm.kernel.f localf = h.aHG();
          p.j(localf, "MMKernel.storage()");
          localf.aHp().set(ar.a.VCi, str1);
          AppMethodBeat.o(268490);
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
      AppMethodBeat.i(268487);
      p.k(paramContext, "context");
      p.k(paramIntent, "intent");
      if ((paramContext instanceof MMFragmentActivity))
      {
        Object localObject1 = com.tencent.mm.ui.component.g.Xox;
        int i = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).xkX;
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.Rb(i))
        {
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          paramIntent.putExtra("key_comment_scene", ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).fGo);
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          paramIntent.putExtra("key_context_id", ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).wmL);
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          localObject1 = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).extraInfo;
          if (!Util.isNullOrNil((String)localObject1)) {
            paramIntent.putExtra("key_extra_info", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          localObject1 = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).wmC;
          if (!Util.isNullOrNil((String)localObject1)) {
            paramIntent.putExtra("key_enter_source_info", (String)localObject1);
          }
          if (!paramBoolean) {
            break label594;
          }
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          i = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).Bgp;
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).wmz = Sa(i);
          Object localObject2 = Sa(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject2);
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          Object localObject3 = (aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class);
          if (localObject3 != null)
          {
            localObject1 = ((aj)localObject3).ekY();
            ((bid)localObject1).wmz = ((String)localObject2);
            localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
            com.tencent.mm.plugin.finder.report.n.a(i, 2, (bid)localObject1);
            localObject2 = ((aj)localObject3).RV(i);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.finder.report.s)))
            {
              localObject2 = (com.tencent.mm.plugin.finder.report.s)localObject2;
              localObject3 = com.tencent.mm.plugin.finder.report.g.zUU;
              ((com.tencent.mm.plugin.finder.report.s)localObject2).aEe(com.tencent.mm.plugin.finder.report.g.a.aa(ae.e(new o[] { kotlin.s.M("feedActionType", Integer.valueOf(2)), kotlin.s.M("toTab", Integer.valueOf(2)), kotlin.s.M("fromTab", Integer.valueOf(i)) })));
            }
            localObject2 = com.tencent.mm.plugin.finder.extension.reddot.i.xuG;
            i.a.a(2, (bid)localObject1);
          }
          label435:
          if (paramLong == 0L) {
            break label633;
          }
          p.j(paramIntent.putExtra("key_click_feed_id", paramLong), "intent.putExtra(Constant…EY_CLICK_FEED_ID, feedId)");
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          localObject1 = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).BmP;
          if (localObject1 != null) {
            paramIntent.putExtra("key_click_feed_context_id", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          i = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).BmR;
          if (i != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", i);
          }
          if (paramInt == 0) {
            break label675;
          }
          p.j(paramIntent.putExtra("key_enter_profile_type", paramInt), "intent.putExtra(Constant…E_TYPE, enterProfileType)");
          AppMethodBeat.o(268487);
          return;
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          paramIntent.putExtra("key_comment_scene", ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).xkX);
          break;
          label594:
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          p.j(paramIntent.putExtra("key_click_tab_context_id", ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).wmz), "intent.putExtra(Constant….java).clickTabContextId)");
          break label435;
          label633:
          localObject1 = com.tencent.mm.ui.component.g.Xox;
          paramLong = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).BmO;
          if (paramLong != 0L) {
            paramIntent.putExtra("key_click_feed_id", paramLong);
          }
        }
        label675:
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        paramInt = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class)).BmQ;
        if (paramInt != 0) {
          paramIntent.putExtra("key_enter_profile_type", paramInt);
        }
        AppMethodBeat.o(268487);
        return;
      }
      Log.w(aj.access$getTAG$cp(), "initIntentParams context is not MMFragmentActivity");
      AppMethodBeat.o(268487);
    }
    
    public static aj fZ(Context paramContext)
    {
      AppMethodBeat.i(268489);
      p.k(paramContext, "context");
      if ((paramContext instanceof MMFragmentActivity))
      {
        com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
        paramContext = (aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(aj.class);
        AppMethodBeat.o(268489);
        return paramContext;
      }
      AppMethodBeat.o(268489);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(aj paramaj, WxRecyclerAdapter paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class c
    extends MMHandler
  {
    c(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(282800);
      if (paramMessage != null)
      {
        int i = paramMessage.what;
        if (i == aj.ela())
        {
          aj.e(this.Bnv);
          sendEmptyMessageDelayed(aj.ela(), aj.elb());
          AppMethodBeat.o(282800);
          return;
        }
        if (i == aj.elc())
        {
          aj.e(this.Bnv);
          removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(282800);
        return;
      }
      AppMethodBeat.o(282800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aj
 * JD-Core Version:    0.7.0.1
 */