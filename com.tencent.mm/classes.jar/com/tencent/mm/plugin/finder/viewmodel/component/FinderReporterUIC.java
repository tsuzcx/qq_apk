package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.i.a;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.report.e.c;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.u;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bbn;
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
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "changeByClick", "", "clickFeedContextId", "", "getClickFeedContextId", "()Ljava/lang/String;", "setClickFeedContextId", "(Ljava/lang/String;)V", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "enterSourceInfo", "getEnterSourceInfo", "setEnterSourceInfo", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "extraInfo", "getExtraInfo", "setExtraInfo", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "firstFragmentVisible", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "isFirstOnResume", "isMegaVideo", "()Z", "setMegaVideo", "(Z)V", "lbsCardFlowReporter", "Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "machineSubscriber", "megaVideoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "reportType", "getReportType", "setReportType", "scrollByUser", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "initActivityReporter", "isHome", "isLbsCardFlow", "isMegaVideoFeedFlow", "isNearby", "isSingleFeedFlow", "isSnsAdExtraInfo", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "onUserVisibleUnFocused", "replaceExtraInfoFeedId", "contextObj", "sendStatsList", "feedId", "finderUserName", "setExtraInfoFeedId", "Companion", "plugin-finder_release"})
public final class FinderReporterUIC
  extends UIComponent
  implements h
{
  private static final int STOP = 2;
  private static final String TAG = "Finder.FinderReporterUIC";
  private static final String kWD = "FinderReporterThread";
  private static final int uOE = 1;
  private static final long wzB = 60000L;
  public static final a wzC;
  private int dYn;
  String extraInfo;
  public String sGE;
  String sGH;
  public String sGQ;
  public String sessionId;
  public int tCE;
  private com.tencent.mm.plugin.finder.event.base.c tId;
  public int tyh;
  public int wtW;
  long wyW;
  String wyX;
  int wyY;
  public int wyZ;
  private final c wzA;
  public String wza;
  private boolean wzb;
  private com.tencent.mm.plugin.finder.event.a wzc;
  private com.tencent.mm.plugin.finder.report.n wzd;
  private com.tencent.mm.plugin.finder.report.o wze;
  private com.tencent.mm.plugin.finder.report.ae wzf;
  private u wzg;
  private v wzh;
  private ac wzi;
  private com.tencent.mm.plugin.finder.event.base.c wzj;
  private com.tencent.mm.plugin.finder.event.a wzk;
  private com.tencent.mm.plugin.finder.report.n wzl;
  private com.tencent.mm.plugin.finder.report.o wzm;
  private com.tencent.mm.plugin.finder.event.base.c wzn;
  private com.tencent.mm.plugin.finder.event.a wzo;
  private com.tencent.mm.plugin.finder.report.n wzp;
  private com.tencent.mm.plugin.finder.report.o wzq;
  private com.tencent.mm.plugin.finder.event.base.c wzr;
  private com.tencent.mm.plugin.finder.event.a wzs;
  private com.tencent.mm.plugin.finder.report.n wzt;
  private com.tencent.mm.plugin.finder.report.g wzu;
  private boolean wzv;
  private boolean wzw;
  private boolean wzx;
  private boolean wzy;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> wzz;
  
  static
  {
    AppMethodBeat.i(255895);
    wzC = new a((byte)0);
    kWD = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    uOE = 1;
    STOP = 2;
    wzB = 60000L;
    AppMethodBeat.o(255895);
  }
  
  public FinderReporterUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255894);
    this.wza = "";
    this.extraInfo = "";
    this.sGH = "";
    this.wzv = true;
    this.wzw = true;
    this.wzy = true;
    this.wzz = new LinkedList();
    this.wzA = new c(this, kWD);
    AppMethodBeat.o(255894);
  }
  
  public FinderReporterUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255893);
    this.wza = "";
    this.extraInfo = "";
    this.sGH = "";
    this.wzv = true;
    this.wzw = true;
    this.wzy = true;
    this.wzz = new LinkedList();
    this.wzA = new c(this, kWD);
    AppMethodBeat.o(255893);
  }
  
  private com.tencent.mm.plugin.finder.report.e MD(int paramInt)
  {
    AppMethodBeat.i(255882);
    Log.i(TAG, "getHomeFlowReporter ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      locale = (com.tencent.mm.plugin.finder.report.e)this.wze;
      AppMethodBeat.o(255882);
      return locale;
    case 3: 
      locale = (com.tencent.mm.plugin.finder.report.e)this.wzm;
      AppMethodBeat.o(255882);
      return locale;
    case 1: 
      locale = (com.tencent.mm.plugin.finder.report.e)this.wzq;
      AppMethodBeat.o(255882);
      return locale;
    }
    com.tencent.mm.plugin.finder.report.e locale = (com.tencent.mm.plugin.finder.report.e)this.wzu;
    AppMethodBeat.o(255882);
    return locale;
  }
  
  private static void a(bbn parambbn, String paramString)
  {
    if (parambbn != null) {
      parambbn.sGH = paramString;
    }
  }
  
  private boolean dIt()
  {
    return this.dYn == 2;
  }
  
  private boolean dIu()
  {
    return this.dYn == 3;
  }
  
  private boolean dIv()
  {
    return this.dYn == 4;
  }
  
  private final boolean dIw()
  {
    return this.dYn == 5;
  }
  
  public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(255885);
    Log.i(TAG, "onFragmentChange ".concat(String.valueOf(paramInt4)));
    Object localObject1 = k.vfA;
    this.tCE = k.Kw(paramInt4);
    this.wtW = paramInt4;
    if (paramInt1 >= 0) {
      this.sGE = a.MG(paramInt4);
    }
    localObject1 = Mz(paramInt4);
    Object localObject2;
    switch (paramInt4)
    {
    case 2: 
    default: 
      if (this.wzw)
      {
        localObject2 = com.tencent.mm.ui.component.a.PRN;
        localObject2 = ((FinderHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).getActiveFragment().Ew;
        if (localObject2 != null) {
          paramInt1 = ((Bundle)localObject2).getInt("Source", 0);
        }
      }
      break;
    }
    for (;;)
    {
      localObject2 = k.vfA;
      k.a(paramInt3, paramInt4, (bbn)localObject1, paramInt1);
      if (paramInt3 <= 0) {
        break label338;
      }
      localObject1 = MB(paramInt3);
      if (localObject1 == null) {
        break label338;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.finder.report.o))
      {
        localObject1 = (com.tencent.mm.plugin.finder.report.o)localObject1;
        localObject2 = com.tencent.mm.plugin.finder.report.e.vdS;
        ((com.tencent.mm.plugin.finder.report.o)localObject1).auL(e.a.ah(kotlin.a.ae.e(new kotlin.o[] { s.U("feedActionType", Integer.valueOf(2)), s.U("toTab", Integer.valueOf(paramInt4)), s.U("fromTab", Integer.valueOf(paramInt3)) })));
      }
      AppMethodBeat.o(255885);
      return;
      localObject2 = this.wzm;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.o)localObject2).d((bbn)localObject1);
      break;
      localObject2 = this.wzq;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.o)localObject2).d((bbn)localObject1);
      break;
      localObject2 = this.wzu;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.g)localObject2).d((bbn)localObject1);
      break;
      paramInt1 = 0;
      continue;
      this.wzw = true;
      paramInt1 = 6;
    }
    label338:
    AppMethodBeat.o(255885);
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c MA(int paramInt)
  {
    AppMethodBeat.i(255875);
    if (dIs())
    {
      if (paramInt == -1)
      {
        localc = MF(this.wtW);
        AppMethodBeat.o(255875);
        return localc;
      }
      localc = MF(paramInt);
      AppMethodBeat.o(255875);
      return localc;
    }
    com.tencent.mm.plugin.finder.event.base.c localc = this.tId;
    AppMethodBeat.o(255875);
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.report.e MB(int paramInt)
  {
    AppMethodBeat.i(255878);
    com.tencent.mm.plugin.finder.report.e locale;
    if (dIs())
    {
      if (paramInt == -1)
      {
        locale = MD(this.wtW);
        AppMethodBeat.o(255878);
        return locale;
      }
      locale = MD(paramInt);
      AppMethodBeat.o(255878);
      return locale;
    }
    if (dIt())
    {
      locale = (com.tencent.mm.plugin.finder.report.e)this.wze;
      AppMethodBeat.o(255878);
      return locale;
    }
    if (dIu())
    {
      locale = (com.tencent.mm.plugin.finder.report.e)this.wzh;
      AppMethodBeat.o(255878);
      return locale;
    }
    if (dIv())
    {
      locale = (com.tencent.mm.plugin.finder.report.e)this.wzf;
      AppMethodBeat.o(255878);
      return locale;
    }
    if (dIw())
    {
      locale = (com.tencent.mm.plugin.finder.report.e)this.wzi;
      AppMethodBeat.o(255878);
      return locale;
    }
    AppMethodBeat.o(255878);
    return null;
  }
  
  public final f MC(int paramInt)
  {
    AppMethodBeat.i(255880);
    f localf;
    if (dIs())
    {
      if (paramInt == -1)
      {
        localf = ME(this.wtW);
        AppMethodBeat.o(255880);
        return localf;
      }
      localf = ME(paramInt);
      AppMethodBeat.o(255880);
      return localf;
    }
    if (dIt())
    {
      localf = (f)this.wzd;
      AppMethodBeat.o(255880);
      return localf;
    }
    if (dIu())
    {
      localf = (f)this.wzg;
      AppMethodBeat.o(255880);
      return localf;
    }
    if (dIv())
    {
      localf = (f)this.wzd;
      AppMethodBeat.o(255880);
      return localf;
    }
    AppMethodBeat.o(255880);
    return null;
  }
  
  public final f ME(int paramInt)
  {
    AppMethodBeat.i(255883);
    Log.i(TAG, "getHomeFlowEventSubscriber ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localf = (f)this.wzd;
      AppMethodBeat.o(255883);
      return localf;
    case 3: 
      localf = (f)this.wzl;
      AppMethodBeat.o(255883);
      return localf;
    case 1: 
      localf = (f)this.wzp;
      AppMethodBeat.o(255883);
      return localf;
    }
    f localf = (f)this.wzt;
    AppMethodBeat.o(255883);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c MF(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.tId;
    case 3: 
      return this.wzj;
    case 1: 
      return this.wzn;
    }
    return this.wzr;
  }
  
  public final bbn Mz(int paramInt)
  {
    AppMethodBeat.i(255874);
    bbn localbbn = new bbn();
    localbbn.tyh = this.tyh;
    localbbn.sessionId = this.sessionId;
    localbbn.sGQ = this.sGQ;
    localbbn.sGE = this.sGE;
    localbbn.wyW = this.wyW;
    localbbn.wyX = this.wyX;
    Object localObject = k.vfA;
    localbbn.tCE = k.Kw(paramInt);
    localbbn.wyZ = this.wyZ;
    localbbn.wyY = this.wyY;
    localbbn.wza = this.wza;
    String str = this.extraInfo;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbbn.extraInfo = ((String)localObject);
    str = this.sGH;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbbn.sGH = ((String)localObject);
    localbbn.wzb = false;
    AppMethodBeat.o(255874);
    return localbbn;
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(255884);
    p.h(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
      p.g(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      localObject = (FinderHomeTabStateVM)localObject;
      if (!this.wzv) {
        break label442;
      }
      if (((FinderHomeTabStateVM)localObject).dHR() != paramFinderHomeTabFragment.dLS) {
        break label144;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (!((FinderHomeTabStateVM)localObject).JN(paramFinderHomeTabFragment.dLS)) {}
      for (paramInt = 3;; paramInt = 2)
      {
        localObject = Mz(paramFinderHomeTabFragment.dLS);
        switch (paramFinderHomeTabFragment.dLS)
        {
        }
        for (;;)
        {
          this.wzv = false;
          AppMethodBeat.o(255884);
          return;
          label144:
          paramBoolean = false;
          break;
          paramFinderHomeTabFragment = this.wzl;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.wzm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.wzp;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzt;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzu;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = i.tLi;
          i.a.b(paramInt, (bbn)localObject, this.wtW, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.wzp;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.wzq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.wzl;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzt;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzu;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = i.tLi;
          i.a.a(paramInt, (bbn)localObject, this.wtW, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.wzt;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.wzu;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.wzp;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzl;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.wzm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = i.tLi;
          i.a.c(paramInt, (bbn)localObject, this.wtW, paramBoolean);
        }
      }
      label442:
      paramBoolean = false;
    }
  }
  
  public final boolean dIs()
  {
    return this.dYn == 1;
  }
  
  public final bbn dIx()
  {
    AppMethodBeat.i(255873);
    if (dIs())
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = Mz(((FinderHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).dIf());
      AppMethodBeat.o(255873);
      return localObject;
    }
    bbn localbbn = new bbn();
    localbbn.tyh = this.tyh;
    localbbn.tCE = this.tCE;
    localbbn.sessionId = this.sessionId;
    localbbn.sGQ = this.sGQ;
    localbbn.sGE = this.sGE;
    localbbn.wyW = this.wyW;
    localbbn.wyX = this.wyX;
    localbbn.wyZ = this.wyZ;
    localbbn.wyY = this.wyY;
    localbbn.wza = this.wza;
    String str = this.extraInfo;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbbn.extraInfo = ((String)localObject);
    str = this.sGH;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbbn.sGH = ((String)localObject);
    localbbn.wzb = this.wzb;
    AppMethodBeat.o(255873);
    return localbbn;
  }
  
  public final void gv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255871);
    this.tyh = getActivity().getIntent().getIntExtra("key_comment_scene", 0);
    if (paramInt1 == 0)
    {
      this.tCE = this.tyh;
      this.dYn = paramInt2;
      this.wzb = dIv();
      localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = k.vfA;
        localObject1 = k.doc();
      }
      this.sGQ = ((String)localObject1);
      localObject2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sessionId = ((String)localObject1);
      this.wyW = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
      this.wyX = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
      this.wyY = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
      this.wyZ = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
      if (!dIs()) {
        break label521;
      }
      localObject1 = com.tencent.mm.ui.component.a.PRN;
      this.wtW = ((FinderHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).dIf();
      localObject1 = k.vfA;
      this.tCE = k.Kw(this.wtW);
      this.sGE = a.MG(this.wtW);
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
      this.sGH = ((String)localObject1);
      Log.i(TAG, "initActivityReporter reportType:" + this.dYn + " commentScene:" + this.tCE + " fromCommentScene:" + this.tyh + " sessionId:" + this.sessionId + " contextId:" + this.sGQ + " clickTabContextId:" + this.sGE + " currentTabType:" + this.wtW + " uxInfo:" + this.extraInfo);
      if (!dIs()) {
        break label1185;
      }
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
      this.wzl = new com.tencent.mm.plugin.finder.report.n((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.wzk = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.dtE()) {
        break label844;
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break label707;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(255871);
      throw ((Throwable)localObject1);
      this.tCE = paramInt1;
      break;
      label521:
      if ((getFragment() instanceof AbsNearByFragment))
      {
        localObject1 = getFragment();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
          AppMethodBeat.o(255871);
          throw ((Throwable)localObject1);
        }
        this.wtW = ((AbsNearByFragment)localObject1).dLS;
        localObject1 = getFragment();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
          AppMethodBeat.o(255871);
          throw ((Throwable)localObject1);
        }
        this.tCE = ((AbsNearByFragment)localObject1).getCommentScene();
        localObject1 = getFragment();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
          AppMethodBeat.o(255871);
          throw ((Throwable)localObject1);
        }
        this.sGE = ((AbsNearByFragment)localObject1).ack();
      }
      else
      {
        localObject2 = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        this.sGE = ((String)localObject1);
        if (Util.isNullOrNil(this.sGE)) {
          this.sGE = a.MG(paramInt1 + 100);
        }
      }
    }
    label707:
    Object localObject1 = new com.tencent.mm.plugin.finder.report.g((MMFragmentActivity)localObject1, Mz(3));
    ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((d)localObject1);
    ((com.tencent.mm.plugin.finder.report.g)localObject1).onInvisible();
    localObject1 = (com.tencent.mm.plugin.finder.report.o)localObject1;
    for (;;)
    {
      this.wzm = ((com.tencent.mm.plugin.finder.report.o)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((d)new com.tencent.mm.plugin.finder.event.b());
      this.wzj = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
      this.wzp = new com.tencent.mm.plugin.finder.report.n((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.wzo = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (!com.tencent.mm.plugin.finder.storage.c.dtE()) {
        break label1031;
      }
      localObject1 = getActivity();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(255871);
      throw ((Throwable)localObject1);
      label844:
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject1);
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.o((MMFragmentActivity)localObject1, Mz(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((d)localObject1);
      ((com.tencent.mm.plugin.finder.report.o)localObject1).onInvisible();
    }
    localObject1 = new com.tencent.mm.plugin.finder.report.g((MMFragmentActivity)localObject1, Mz(1));
    ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((d)localObject1);
    ((com.tencent.mm.plugin.finder.report.g)localObject1).onInvisible();
    localObject1 = (com.tencent.mm.plugin.finder.report.o)localObject1;
    for (;;)
    {
      this.wzq = ((com.tencent.mm.plugin.finder.report.o)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((d)new com.tencent.mm.plugin.finder.event.b());
      this.wzn = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
      this.wzt = new com.tencent.mm.plugin.finder.report.n((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.wzs = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(255871);
      throw ((Throwable)localObject1);
      label1031:
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject1);
      }
      localObject1 = new com.tencent.mm.plugin.finder.report.o((MMFragmentActivity)localObject1, Mz(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((d)localObject1);
      ((com.tencent.mm.plugin.finder.report.o)localObject1).onInvisible();
    }
    Object localObject2 = new com.tencent.mm.plugin.finder.report.g((MMFragmentActivity)localObject2, Mz(4));
    ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)localObject2);
    ((com.tencent.mm.plugin.finder.report.g)localObject2).onInvisible();
    this.wzu = ((com.tencent.mm.plugin.finder.report.g)localObject2);
    ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)new com.tencent.mm.plugin.finder.event.b());
    this.wzr = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderHomeUIC.class)).wxj.add(this);
    AppMethodBeat.o(255871);
    return;
    label1185:
    if (dIt())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
      this.wzc = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.wzd = new com.tencent.mm.plugin.finder.report.n((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject1);
      }
      localObject2 = new com.tencent.mm.plugin.finder.report.o((MMFragmentActivity)localObject2, dIx());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)localObject2);
      this.wze = ((com.tencent.mm.plugin.finder.report.o)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)new com.tencent.mm.plugin.finder.event.b());
      this.tId = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(255871);
      return;
    }
    if (dIu())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
      this.wzc = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.wzg = new u((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject1);
      }
      localObject2 = new v((MMFragmentActivity)localObject2, dIx());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)localObject2);
      this.wzh = ((v)localObject2);
      this.tId = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(255871);
      return;
    }
    if (dIv())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(kWD);
      this.wzc = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.wzd = new com.tencent.mm.plugin.finder.report.n((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = getActivity();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject1);
      }
      localObject2 = new com.tencent.mm.plugin.finder.report.ae((MMFragmentActivity)localObject2, dIx());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)localObject2);
      this.wzf = ((com.tencent.mm.plugin.finder.report.ae)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((d)new com.tencent.mm.plugin.finder.event.b());
      this.tId = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(255871);
      return;
    }
    if (dIw())
    {
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255871);
        throw ((Throwable)localObject1);
      }
      this.wzi = new ac((MMActivity)localObject1, dIx());
    }
    AppMethodBeat.o(255871);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255892);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = Mz(this.wtW);
      k localk = k.vfA;
      k.a(2, this.wtW, paramIntent);
    }
    AppMethodBeat.o(255892);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255890);
    Object localObject = MB(-1);
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.finder.report.o)) && (!(getActivity() instanceof FinderHomeUI)))
    {
      localObject = (com.tencent.mm.plugin.finder.report.o)localObject;
      e.a locala = com.tencent.mm.plugin.finder.report.e.vdS;
      ((com.tencent.mm.plugin.finder.report.o)localObject).auL(e.a.ah(kotlin.a.ae.b(s.U("feedActionType", Integer.valueOf(5)))));
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(255890);
    return bool;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255870);
    super.onCreateAfter(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = k.vfA;
      localObject = this.sGQ;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      k.gS(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.e.vdS;
      paramBundle = dIx();
      localObject = com.tencent.mm.plugin.finder.report.e.vdS;
      localObject = e.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      p.g(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      e.a.a(paramBundle, 0L, 8, (String)localObject, 0L, null, 48);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.e.vdS;
      paramBundle = dIx();
      localObject = com.tencent.mm.plugin.finder.report.e.vdS;
      localObject = e.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      p.g(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      e.a.a(paramBundle, 0L, 8, (String)localObject, 0L, null, 48);
    }
    paramBundle = as.uOL;
    as.startTimer();
    this.wzA.sendEmptyMessage(uOE);
    AppMethodBeat.o(255870);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(255869);
    super.onCreateBefore(paramBundle);
    paramBundle = getFragment();
    if ((getFragment() instanceof AbsNearByFragment)) {}
    while (paramBundle != null) {
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment");
        AppMethodBeat.o(255869);
        throw paramBundle;
        paramBundle = null;
      }
      else
      {
        gv(((AbsNearByFragment)paramBundle).getCommentScene(), ((AbsNearByFragment)paramBundle).ddN());
        if (paramBundle != null) {
          break label150;
        }
      }
    }
    FinderReporterUIC localFinderReporterUIC = (FinderReporterUIC)this;
    paramBundle = localFinderReporterUIC.getActivity();
    if ((localFinderReporterUIC.getActivity() instanceof MMFinderUI)) {}
    while (paramBundle != null) {
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
        AppMethodBeat.o(255869);
        throw paramBundle;
        paramBundle = null;
      }
      else
      {
        localFinderReporterUIC.gv(((MMFinderUI)paramBundle).getCommentScene(), ((MMFinderUI)paramBundle).ddN());
      }
    }
    label150:
    AppMethodBeat.o(255869);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255891);
    Log.i(TAG, "onDestroy");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.e.vdS;
      localObject1 = dIx();
      localObject2 = e.c.vdX;
      e.a.a((bbn)localObject1, 0L, 9, e.c.dnN(), 0L, null, 48);
      localObject1 = k.vfA;
      localObject2 = this.sGQ;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      k.gS((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.e.vdS;
      localObject1 = dIx();
      localObject2 = e.c.vdX;
      e.a.a((bbn)localObject1, 0L, 9, e.c.dnN(), 0L, null, 48);
    }
    Object localObject1 = this.tId;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.wzj;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.wzn;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.wzr;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = as.uOL;
    as.stopTimer();
    this.wzA.removeCallbacksAndMessages(null);
    this.wzA.sendEmptyMessage(STOP);
    super.onDestroy();
    AppMethodBeat.o(255891);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.wzx = true;
      return;
    }
    this.wzx = false;
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.wzx)
    {
      this.wzw = false;
      this.wzx = false;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255887);
    super.onPause();
    if (dIs()) {
      switch (this.wtW)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.wzz).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.wzl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.report.n)localObject).onInvisible();
      }
      localObject = this.wzm;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.report.o)localObject).onInvisible();
        continue;
        localObject = this.wzp;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.report.n)localObject).onInvisible();
        }
        localObject = this.wzq;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.report.o)localObject).onInvisible();
          continue;
          localObject = this.wzt;
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.report.n)localObject).onInvisible();
          }
          localObject = this.wzu;
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.finder.report.g)localObject).onInvisible();
            continue;
            if (dIt())
            {
              localObject = this.wzd;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.n)localObject).onInvisible();
              }
              localObject = this.wze;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.o)localObject).onInvisible();
              }
            }
            else if (dIu())
            {
              localObject = this.wzg;
              if (localObject != null) {
                ((u)localObject).onInvisible();
              }
              localObject = this.wzh;
              if (localObject != null) {
                ((v)localObject).onInvisible();
              }
            }
            else if (dIv())
            {
              localObject = this.wzd;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.n)localObject).onInvisible();
              }
              localObject = this.wzf;
              if (localObject != null) {
                ((com.tencent.mm.plugin.finder.report.ae)localObject).onInvisible();
              }
            }
            else if (dIw())
            {
              localObject = this.wzi;
              if (localObject != null) {
                ((ac)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(255887);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255886);
    super.onResume();
    if (this.wzy)
    {
      this.wzy = false;
      AppMethodBeat.o(255886);
      return;
    }
    Object localObject1;
    if (dIs())
    {
      localObject1 = Mz(this.wtW);
      switch (this.wtW)
      {
      case 2: 
      default: 
        localObject1 = i.tLi;
        i.a.a(1, dIx(), this.wtW, false);
        localObject1 = i.tLi;
        i.a.b(1, dIx(), this.wtW, false);
        localObject1 = i.tLi;
        i.a.c(1, dIx(), this.wtW, false);
        localObject1 = i.tLi;
        i.a.a(1, dIx());
        localObject1 = i.tLi;
        i.a.a(1, dIx(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.wzz).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.wzm;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.o)localObject2).d((bbn)localObject1);
      }
      localObject1 = this.wzl;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.n)localObject1).onVisible();
      }
      localObject1 = this.wzm;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.o)localObject1).onVisible();
      break;
      localObject2 = this.wzq;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.o)localObject2).d((bbn)localObject1);
      }
      localObject1 = this.wzp;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.n)localObject1).onVisible();
      }
      localObject1 = this.wzq;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.o)localObject1).onVisible();
      break;
      localObject2 = this.wzu;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.report.g)localObject2).d((bbn)localObject1);
      }
      localObject1 = this.wzt;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.report.n)localObject1).onVisible();
      }
      localObject1 = this.wzu;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.report.g)localObject1).onVisible();
      break;
      if (dIt())
      {
        localObject1 = this.wzd;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.n)localObject1).onVisible();
        }
        localObject1 = this.wze;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.o)localObject1).onVisible();
        }
      }
      else if (dIu())
      {
        localObject1 = this.wzg;
        if (localObject1 != null) {
          ((u)localObject1).onVisible();
        }
        localObject1 = this.wzh;
        if (localObject1 != null) {
          ((v)localObject1).onVisible();
        }
      }
      else if (dIv())
      {
        localObject1 = this.wzd;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.n)localObject1).onVisible();
        }
        localObject1 = this.wzf;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.report.ae)localObject1).onVisible();
        }
      }
      else if (dIw())
      {
        localObject1 = this.wzi;
        if (localObject1 != null) {
          ((ac)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(255886);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(255888);
    super.onUserVisibleFocused();
    if (dIu())
    {
      Object localObject = this.wzg;
      if (localObject != null) {
        ((u)localObject).onVisible();
      }
      localObject = this.wzh;
      if (localObject != null)
      {
        ((v)localObject).onVisible();
        AppMethodBeat.o(255888);
        return;
      }
    }
    AppMethodBeat.o(255888);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(255889);
    super.onUserVisibleUnFocused();
    if (dIu())
    {
      Object localObject = this.wzg;
      if (localObject != null) {
        ((u)localObject).onInvisible();
      }
      localObject = this.wzh;
      if (localObject != null)
      {
        ((v)localObject).onInvisible();
        AppMethodBeat.o(255889);
        return;
      }
    }
    AppMethodBeat.o(255889);
  }
  
  public final void s(long paramLong, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(255872);
    Log.i(TAG, "setEnterSourceInfo:" + paramLong + "  finderUserName:" + paramString + '}');
    Object localObject3 = new JSONObject();
    Object localObject1 = k.vfA;
    String str = k.Fg(paramLong);
    this.wyW = paramLong;
    ((JSONObject)localObject3).put("feedid", str);
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      ((JSONObject)localObject3).put("finderusername", localObject1);
      localObject3 = ((JSONObject)localObject3).toString();
      p.g(localObject3, "enterSourceJson.toString()");
      this.sGH = ((String)localObject3);
      localObject1 = this.wze;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.plugin.finder.report.e)localObject1).ttO;; localObject1 = null)
      {
        a((bbn)localObject1, (String)localObject3);
        v localv = this.wzh;
        localObject1 = localObject2;
        if (localv != null) {
          localObject1 = localv.ttO;
        }
        a((bbn)localObject1, (String)localObject3);
        getActivity().getIntent().putExtra("key_enter_source_info", this.sGH);
        if (!Util.isNullOrNil(this.extraInfo))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.e.vdS;
          e.a.o(this.sGQ, this.extraInfo, str, paramString);
        }
        AppMethodBeat.o(255872);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"})
  public static final class a
  {
    public static String MG(int paramInt)
    {
      AppMethodBeat.i(255866);
      String str1 = paramInt + '-' + cl.aWA();
      String str2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slL, "100");
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        Log.i(FinderReporterUIC.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", new Object[] { str1, localObject, str2 });
        try
        {
          p.g(str2, "blacklist");
          localObject = ((Iterable)kotlin.n.n.b((CharSequence)str2, new char[] { ';' })).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!p.j((String)((Iterator)localObject).next(), String.valueOf(paramInt)));
          AppMethodBeat.o(255866);
          return str1;
        }
        catch (Exception localException)
        {
          com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
          p.g(locale, "MMKernel.storage()");
          locale.azQ().set(ar.a.Onc, str1);
          AppMethodBeat.o(255866);
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
      AppMethodBeat.i(255863);
      p.h(paramContext, "context");
      p.h(paramIntent, "intent");
      if ((paramContext instanceof MMFragmentActivity))
      {
        Object localObject1 = com.tencent.mm.ui.component.a.PRN;
        int i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).tCE;
        localObject1 = y.vXH;
        if (y.LO(i))
        {
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).tyh);
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          paramIntent.putExtra("key_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).sGQ);
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).extraInfo;
          if (!Util.isNullOrNil((String)localObject1)) {
            paramIntent.putExtra("key_extra_info", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).sGH;
          if (!Util.isNullOrNil((String)localObject1)) {
            paramIntent.putExtra("key_enter_source_info", (String)localObject1);
          }
          if (!paramBoolean) {
            break label595;
          }
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).wtW;
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).sGE = MG(i);
          Object localObject2 = MG(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject2);
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          Object localObject3 = (FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class);
          if (localObject3 != null)
          {
            localObject1 = ((FinderReporterUIC)localObject3).dIx();
            ((bbn)localObject1).sGE = ((String)localObject2);
            localObject2 = k.vfA;
            k.a(i, 2, (bbn)localObject1);
            localObject2 = ((FinderReporterUIC)localObject3).MB(i);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.finder.report.o)))
            {
              localObject2 = (com.tencent.mm.plugin.finder.report.o)localObject2;
              localObject3 = com.tencent.mm.plugin.finder.report.e.vdS;
              ((com.tencent.mm.plugin.finder.report.o)localObject2).auL(e.a.ah(kotlin.a.ae.e(new kotlin.o[] { s.U("feedActionType", Integer.valueOf(2)), s.U("toTab", Integer.valueOf(2)), s.U("fromTab", Integer.valueOf(i)) })));
            }
            localObject2 = i.tLi;
            i.a.a(2, (bbn)localObject1);
          }
          label436:
          if (paramLong == 0L) {
            break label634;
          }
          p.g(paramIntent.putExtra("key_click_feed_id", paramLong), "intent.putExtra(Constant…EY_CLICK_FEED_ID, feedId)");
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).wyX;
          if (localObject1 != null) {
            paramIntent.putExtra("key_click_feed_context_id", (String)localObject1);
          }
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          i = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).wyZ;
          if (i != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", i);
          }
          if (paramInt == 0) {
            break label676;
          }
          p.g(paramIntent.putExtra("key_enter_profile_type", paramInt), "intent.putExtra(Constant…E_TYPE, enterProfileType)");
          AppMethodBeat.o(255863);
          return;
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          paramIntent.putExtra("key_comment_scene", ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).tCE);
          break;
          label595:
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          p.g(paramIntent.putExtra("key_click_tab_context_id", ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).sGE), "intent.putExtra(Constant….java).clickTabContextId)");
          break label436;
          label634:
          localObject1 = com.tencent.mm.ui.component.a.PRN;
          paramLong = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).wyW;
          if (paramLong != 0L) {
            paramIntent.putExtra("key_click_feed_id", paramLong);
          }
        }
        label676:
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        paramInt = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class)).wyY;
        if (paramInt != 0) {
          paramIntent.putExtra("key_enter_profile_type", paramInt);
        }
        AppMethodBeat.o(255863);
        return;
      }
      Log.w(FinderReporterUIC.access$getTAG$cp(), "initIntentParams context is not MMFragmentActivity");
      AppMethodBeat.o(255863);
    }
    
    public static FinderReporterUIC fH(Context paramContext)
    {
      AppMethodBeat.i(255865);
      p.h(paramContext, "context");
      if ((paramContext instanceof MMFragmentActivity))
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        paramContext = (FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderReporterUIC.class);
        AppMethodBeat.o(255865);
        return paramContext;
      }
      AppMethodBeat.o(255865);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(FinderReporterUIC paramFinderReporterUIC, WxRecyclerAdapter paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"})
  public static final class c
    extends MMHandler
  {
    c(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(255868);
      if (paramMessage != null)
      {
        int i = paramMessage.what;
        if (i == FinderReporterUIC.dIy())
        {
          FinderReporterUIC.e(this.wzD);
          sendEmptyMessageDelayed(FinderReporterUIC.dIy(), FinderReporterUIC.dIz());
          AppMethodBeat.o(255868);
          return;
        }
        if (i == FinderReporterUIC.dIA())
        {
          FinderReporterUIC.e(this.wzD);
          removeCallbacksAndMessages(null);
        }
        AppMethodBeat.o(255868);
        return;
      }
      AppMethodBeat.o(255868);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC
 * JD-Core Version:    0.7.0.1
 */