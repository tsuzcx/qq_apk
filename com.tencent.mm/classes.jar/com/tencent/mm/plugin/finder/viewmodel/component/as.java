package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment;
import com.tencent.mm.plugin.finder.event.b;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.report.ad;
import com.tencent.mm.plugin.finder.report.ae;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.report.au;
import com.tencent.mm.plugin.finder.report.aw;
import com.tencent.mm.plugin.finder.report.m.c;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/view/FinderFragmentChangeListener;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderReporterUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "changeByClick", "", "chnlExtra", "", "getChnlExtra", "()Ljava/lang/String;", "setChnlExtra", "(Ljava/lang/String;)V", "clickFeedContextId", "getClickFeedContextId", "setClickFeedContextId", "clickFeedId", "", "getClickFeedId", "()J", "setClickFeedId", "(J)V", "clickSubTabContextId", "getClickSubTabContextId", "setClickSubTabContextId", "clickTabContextId", "getClickTabContextId", "setClickTabContextId", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "commonExtraInfo", "getCommonExtraInfo", "setCommonExtraInfo", "contextId", "getContextId", "setContextId", "currentTabType", "getCurrentTabType", "setCurrentTabType", "currentTopicPageTag", "getCurrentTopicPageTag", "setCurrentTopicPageTag", "dataAdapterListener", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getDataAdapterListener", "()Ljava/util/LinkedList;", "setDataAdapterListener", "(Ljava/util/LinkedList;)V", "enterProfileType", "getEnterProfileType", "setEnterProfileType", "enterSourceInfo", "getEnterSourceInfo", "setEnterSourceInfo", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "extraInfo", "getExtraInfo", "setExtraInfo", "feedSubscriber", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "firstFragmentVisible", "followEventDispatcher", "followFeedSubscriber", "followReporter", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowReporter;", "followSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderSingleFeedFlowEventSubscriber;", "friendEventDispatcher", "friendFeedSubscriber", "friendReporter", "friendSubscriber", "fromCommentScene", "getFromCommentScene", "setFromCommentScene", "fromProfileShareScene", "getFromProfileShareScene", "setFromProfileShareScene", "hashTagInfo", "getHashTagInfo", "setHashTagInfo", "isBlockTwoFeedReport", "()Z", "setBlockTwoFeedReport", "(Z)V", "isFirstOnResume", "isMegaVideo", "setMegaVideo", "jumpId", "getJumpId", "setJumpId", "lbsCardFlowReporter", "Lcom/tencent/mm/plugin/finder/report/LbsCardFlowReporter;", "machineEventDispatcher", "machineFeedSubscriber", "machineReporter", "Lcom/tencent/mm/plugin/finder/report/FinderImportantFeedFlowReporter;", "machineSubscriber", "megaVideoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/MegaVideoFeedFlowReporter;", "reportType", "getReportType", "setReportType", "scrollByUser", "sessionId", "getSessionId", "setSessionId", "singleFeedFlowReporter", "singleFeedFlowSubscriber", "timer", "com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1;", "twoFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowReporter;", "twoFeedFlowSubscriber", "Lcom/tencent/mm/plugin/finder/report/FinderTwoFeedFlowEventSubscriber;", "addDataAdapter", "", "adapter", "appendChnlExtra", "key", "value", "assignChnlExtra", "_chnlExtra", "assignClickSubTabContextId", "_clickSubTabContextId", "assignClickTabContextId", "_clickTabContextId", "assignContextId", "_contextId", "getAllDispatcher", "", "getCurrentReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "getFeedEventDispatcher", "getFeedEventSubscriber", "getFeedFlowEventSubscriber", "Lcom/tencent/mm/plugin/finder/event/base/FinderFeedFlowEventSubscriber;", "getFeedFlowReporter", "Lcom/tencent/mm/plugin/finder/report/FinderFeedFlowReporter;", "getHomeFeedEventDispatcher", "getHomeFeedEventSubscriber", "getHomeFlowEventSubscriber", "getHomeFlowReporter", "getLastVisibleExtStats", "Lcom/tencent/mm/protocal/protobuf/ExtStats;", "getReportChnlExtra", "getReportClickSubTabContextId", "getReportCommentScene", "getReportContextId", "initActivityReporter", "initIntentParams", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "enterLbsUI", "isCampaign", "isHome", "isLbsCardFlow", "isMegaVideoFeedFlow", "isNearby", "isSingleFeedFlow", "isSnsAdExtraInfo", "isTwoFeedFlow", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onFragmentChange", "from", "to", "fromType", "toType", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPause", "onPreDestroyed", "onResume", "onUserVisibleFocused", "onUserVisibleFragmentChange", "isUserVisibleFocused", "index", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "onUserVisibleUnFocused", "replaceExtraInfoFeedId", "contextObj", "sendStatsList", "finderUserName", "setExtraInfoFeedId", "setTwoFeedReportVisible", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  extends UIComponent
  implements com.tencent.mm.plugin.finder.view.h, bn
{
  public static final a GSQ;
  private static final int GTx;
  private static final int GTy;
  private static final long GTz;
  private static final String TAG;
  private static final String THREAD_TAG;
  long ADF;
  public int AJo;
  private com.tencent.mm.plugin.finder.event.base.c ANW;
  public String DUN;
  public String DnS;
  private String DnT;
  public int GKp;
  String GSR;
  private String GSS;
  int GST;
  public int GSU;
  public String GSV;
  String GSW;
  private boolean GSX;
  public boolean GSY;
  private com.tencent.mm.plugin.finder.event.a GSZ;
  private ad GTa;
  private ae GTb;
  private aw GTc;
  private al GTd;
  public am GTe;
  private au GTf;
  private com.tencent.mm.plugin.finder.event.base.c GTg;
  private com.tencent.mm.plugin.finder.event.a GTh;
  private ad GTi;
  private ae GTj;
  private com.tencent.mm.plugin.finder.event.base.c GTk;
  private com.tencent.mm.plugin.finder.event.a GTl;
  private ad GTm;
  private ae GTn;
  private com.tencent.mm.plugin.finder.event.base.c GTo;
  private com.tencent.mm.plugin.finder.event.a GTp;
  private ad GTq;
  private q GTr;
  private boolean GTs;
  private boolean GTt;
  private boolean GTu;
  public LinkedList<WeakReference<WxRecyclerAdapter<?>>> GTv;
  private final c GTw;
  public String extraInfo;
  public int hLK;
  private int hYb;
  private boolean isFirstOnResume;
  public String sessionId;
  public String zIB;
  public String zIE;
  public String zIO;
  
  static
  {
    AppMethodBeat.i(338260);
    GSQ = new a((byte)0);
    THREAD_TAG = "FinderReporterThread";
    TAG = "Finder.FinderReporterUIC";
    GTx = 1;
    GTy = 2;
    GTz = 60000L;
    AppMethodBeat.o(338260);
  }
  
  public as(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338108);
    this.GSS = "";
    this.DnT = "{}";
    this.GSV = "";
    this.extraInfo = "";
    this.GSW = "";
    this.zIE = "";
    this.DUN = "";
    this.GTs = true;
    this.GTt = true;
    this.isFirstOnResume = true;
    this.GTv = new LinkedList();
    this.GTw = new c(this, THREAD_TAG);
    AppMethodBeat.o(338108);
  }
  
  public as(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338119);
    this.GSS = "";
    this.DnT = "{}";
    this.GSV = "";
    this.extraInfo = "";
    this.GSW = "";
    this.zIE = "";
    this.DUN = "";
    this.GTs = true;
    this.GTt = true;
    this.isFirstOnResume = true;
    this.GTv = new LinkedList();
    this.GTw = new c(this, THREAD_TAG);
    AppMethodBeat.o(338119);
  }
  
  private com.tencent.mm.plugin.finder.report.m Vp(int paramInt)
  {
    AppMethodBeat.i(338212);
    Log.i(TAG, s.X("getHomeFlowReporter ", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTb;
      AppMethodBeat.o(338212);
      return localm;
    case 3: 
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTj;
      AppMethodBeat.o(338212);
      return localm;
    case 1: 
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTn;
      AppMethodBeat.o(338212);
      return localm;
    }
    com.tencent.mm.plugin.finder.report.m localm = (com.tencent.mm.plugin.finder.report.m)this.GTr;
    AppMethodBeat.o(338212);
    return localm;
  }
  
  private static void a(bui parambui, String paramString)
  {
    if (parambui != null) {
      parambui.zIE = paramString;
    }
  }
  
  private boolean foq()
  {
    return this.hYb == 2;
  }
  
  private boolean jdMethod_for()
  {
    return this.hYb == 3;
  }
  
  private boolean fos()
  {
    return this.hYb == 4;
  }
  
  private final boolean fot()
  {
    return this.hYb == 5;
  }
  
  private boolean isNearby()
  {
    AppMethodBeat.i(338138);
    boolean bool = ((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).isNearby(getFragment());
    AppMethodBeat.o(338138);
    return bool;
  }
  
  public final void K(long paramLong, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(338348);
    Log.i(TAG, "setEnterSourceInfo:" + paramLong + "  finderUserName:" + paramString + '}');
    Object localObject3 = new JSONObject();
    Object localObject1 = z.FrZ;
    String str = z.pL(paramLong);
    this.ADF = paramLong;
    ((JSONObject)localObject3).put("feedid", str);
    if (paramString == null)
    {
      localObject1 = "";
      ((JSONObject)localObject3).put("finderusername", localObject1);
      localObject3 = ((JSONObject)localObject3).toString();
      s.s(localObject3, "enterSourceJson.toString()");
      this.zIE = ((String)localObject3);
      localObject1 = this.GTb;
      if (localObject1 != null) {
        break label227;
      }
      localObject1 = null;
      label138:
      a((bui)localObject1, (String)localObject3);
      localObject1 = this.GTe;
      if (localObject1 != null) {
        break label237;
      }
    }
    label227:
    label237:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.finder.report.m)localObject1).Auc)
    {
      a((bui)localObject1, (String)localObject3);
      getActivity().getIntent().putExtra("key_enter_source_info", this.zIE);
      if (!Util.isNullOrNil(this.extraInfo))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.m.Fpx;
        com.tencent.mm.plugin.finder.report.m.a.v(this.zIO, this.extraInfo, str, paramString);
      }
      AppMethodBeat.o(338348);
      return;
      localObject1 = paramString;
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.report.m)localObject1).Auc;
      break label138;
    }
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(338503);
    Log.i(TAG, s.X("onFragmentChange ", Integer.valueOf(paramInt4)));
    Object localObject1 = z.FrZ;
    this.AJo = z.SD(paramInt4);
    this.GKp = paramInt4;
    if (paramInt1 >= 0) {
      this.zIB = a.Vs(paramInt4);
    }
    localObject1 = Vl(paramInt4);
    Object localObject2;
    switch (paramInt4)
    {
    case 2: 
    default: 
      if (this.GTt)
      {
        localObject2 = k.aeZF;
        localObject2 = ((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).getActiveFragment().EHy;
        if (localObject2 == null) {
          paramInt1 = 1;
        }
      }
      break;
    }
    for (;;)
    {
      localObject2 = z.FrZ;
      z.a(paramInt3, paramInt4, (bui)localObject1, paramInt1);
      if (paramInt3 > 0)
      {
        localObject1 = Vn(paramInt3);
        if ((localObject1 != null) && ((localObject1 instanceof ae)))
        {
          localObject1 = (ae)localObject1;
          localObject2 = com.tencent.mm.plugin.finder.report.m.Fpx;
          ((ae)localObject1).azV(com.tencent.mm.plugin.finder.report.m.a.aj(ak.e(new r[] { v.Y("feedActionType", Integer.valueOf(2)), v.Y("toTab", Integer.valueOf(paramInt4)), v.Y("fromTab", Integer.valueOf(paramInt3)) })));
        }
      }
      AppMethodBeat.o(338503);
      return;
      localObject2 = this.GTj;
      if (localObject2 == null) {
        break;
      }
      ((ae)localObject2).f((bui)localObject1);
      break;
      localObject2 = this.GTn;
      if (localObject2 == null) {
        break;
      }
      ((ae)localObject2).f((bui)localObject1);
      break;
      localObject2 = this.GTr;
      if (localObject2 == null) {
        break;
      }
      ((q)localObject2).f((bui)localObject1);
      break;
      paramInt1 = ((Bundle)localObject2).getInt("Source", 0);
      continue;
      this.GTt = true;
      paramInt1 = 6;
    }
  }
  
  public final bui Vl(int paramInt)
  {
    AppMethodBeat.i(338383);
    bui localbui = new bui();
    localbui.hLK = this.hLK;
    localbui.sessionId = this.sessionId;
    localbui.zIO = this.zIO;
    localbui.zIB = this.zIB;
    localbui.ADF = this.ADF;
    localbui.GSR = this.GSR;
    Object localObject = z.FrZ;
    localbui.AJo = z.SD(paramInt);
    localbui.GSU = this.GSU;
    localbui.GST = this.GST;
    localbui.GSV = this.GSV;
    String str = this.GSW;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbui.GSW = ((String)localObject);
    str = this.extraInfo;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbui.extraInfo = ((String)localObject);
    str = this.zIE;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbui.zIE = ((String)localObject);
    localbui.GSX = false;
    localbui.GSS = this.GSS;
    AppMethodBeat.o(338383);
    return localbui;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c Vm(int paramInt)
  {
    AppMethodBeat.i(338392);
    if (fop())
    {
      if (paramInt == -1)
      {
        localc = Vr(this.GKp);
        AppMethodBeat.o(338392);
        return localc;
      }
      localc = Vr(paramInt);
      AppMethodBeat.o(338392);
      return localc;
    }
    com.tencent.mm.plugin.finder.event.base.c localc = this.ANW;
    AppMethodBeat.o(338392);
    return localc;
  }
  
  public final com.tencent.mm.plugin.finder.report.m Vn(int paramInt)
  {
    AppMethodBeat.i(338460);
    com.tencent.mm.plugin.finder.report.m localm;
    if (fop())
    {
      if (paramInt == -1)
      {
        localm = Vp(this.GKp);
        AppMethodBeat.o(338460);
        return localm;
      }
      localm = Vp(paramInt);
      AppMethodBeat.o(338460);
      return localm;
    }
    if (foq())
    {
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTb;
      AppMethodBeat.o(338460);
      return localm;
    }
    if (jdMethod_for())
    {
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTe;
      AppMethodBeat.o(338460);
      return localm;
    }
    if (fos())
    {
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTc;
      AppMethodBeat.o(338460);
      return localm;
    }
    if (fot())
    {
      localm = (com.tencent.mm.plugin.finder.report.m)this.GTf;
      AppMethodBeat.o(338460);
      return localm;
    }
    AppMethodBeat.o(338460);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.f Vo(int paramInt)
  {
    AppMethodBeat.i(338466);
    com.tencent.mm.plugin.finder.event.base.f localf;
    if (fop())
    {
      if (paramInt == -1)
      {
        localf = Vq(this.GKp);
        AppMethodBeat.o(338466);
        return localf;
      }
      localf = Vq(paramInt);
      AppMethodBeat.o(338466);
      return localf;
    }
    if (foq())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTa;
      AppMethodBeat.o(338466);
      return localf;
    }
    if (jdMethod_for())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTd;
      AppMethodBeat.o(338466);
      return localf;
    }
    if (fos())
    {
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTa;
      AppMethodBeat.o(338466);
      return localf;
    }
    AppMethodBeat.o(338466);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.f Vq(int paramInt)
  {
    AppMethodBeat.i(338475);
    Log.i(TAG, s.X("getHomeFlowEventSubscriber ", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    case 2: 
    default: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTa;
      AppMethodBeat.o(338475);
      return localf;
    case 3: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTi;
      AppMethodBeat.o(338475);
      return localf;
    case 1: 
      localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTm;
      AppMethodBeat.o(338475);
      return localf;
    }
    com.tencent.mm.plugin.finder.event.base.f localf = (com.tencent.mm.plugin.finder.event.base.f)this.GTq;
    AppMethodBeat.o(338475);
    return localf;
  }
  
  public final com.tencent.mm.plugin.finder.event.base.c Vr(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.ANW;
    case 3: 
      return this.GTg;
    case 1: 
      return this.GTk;
    }
    return this.GTo;
  }
  
  public final void a(final WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(338543);
    s.u(paramWxRecyclerAdapter, "adapter");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramWxRecyclerAdapter));
    AppMethodBeat.o(338543);
  }
  
  public final void a(boolean paramBoolean, int paramInt, FinderHomeTabFragment paramFinderHomeTabFragment)
  {
    AppMethodBeat.i(338489);
    s.u(paramFinderHomeTabFragment, "fragment");
    Object localObject;
    if (paramBoolean)
    {
      localObject = k.aeZF;
      localObject = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
      s.s(localObject, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      localObject = (com.tencent.mm.plugin.finder.viewmodel.d)localObject;
      if (!this.GTs) {
        break label442;
      }
      if (((com.tencent.mm.plugin.finder.viewmodel.d)localObject).fmM() != paramFinderHomeTabFragment.hJx) {
        break label144;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.finder.viewmodel.d)localObject).Rp(paramFinderHomeTabFragment.hJx)) {}
      for (paramInt = 3;; paramInt = 2)
      {
        localObject = Vl(paramFinderHomeTabFragment.hJx);
        switch (paramFinderHomeTabFragment.hJx)
        {
        }
        for (;;)
        {
          this.GTs = false;
          AppMethodBeat.o(338489);
          return;
          label144:
          paramBoolean = false;
          break;
          paramFinderHomeTabFragment = this.GTi;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.GTj;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.GTm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTn;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTr;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
          com.tencent.mm.plugin.finder.extension.reddot.m.a.b(paramInt, (bui)localObject, this.GKp, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.GTm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.GTn;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.GTi;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTj;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTr;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
          com.tencent.mm.plugin.finder.extension.reddot.m.a.a(paramInt, (bui)localObject, this.GKp, paramBoolean);
          continue;
          paramFinderHomeTabFragment = this.GTq;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.GTr;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onVisible();
          }
          paramFinderHomeTabFragment = this.GTm;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTn;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTi;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = this.GTj;
          if (paramFinderHomeTabFragment != null) {
            paramFinderHomeTabFragment.onInvisible();
          }
          paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
          com.tencent.mm.plugin.finder.extension.reddot.m.a.c(paramInt, (bui)localObject, this.GKp, paramBoolean);
        }
      }
      label442:
      paramBoolean = false;
    }
  }
  
  public final void aA(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(338572);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    a.a(paramContext, paramIntent, 0L, null, 0, 0, false);
    AppMethodBeat.o(338572);
  }
  
  public final void aCN(String paramString)
  {
    this.zIO = paramString;
  }
  
  public final void aCO(String paramString)
  {
    this.zIB = paramString;
  }
  
  public final void aCP(String paramString)
  {
    this.DnS = paramString;
  }
  
  public final void aCQ(String paramString)
  {
    AppMethodBeat.i(338443);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.DnT = "{}";
      AppMethodBeat.o(338443);
      return;
    }
    this.DnT = paramString;
    AppMethodBeat.o(338443);
  }
  
  public final void ayc(String paramString)
  {
    AppMethodBeat.i(338268);
    s.u(paramString, "<set-?>");
    this.DUN = paramString;
    AppMethodBeat.o(338268);
  }
  
  public final String foA()
  {
    return this.DnT;
  }
  
  public final List<aps> foB()
  {
    AppMethodBeat.i(338590);
    com.tencent.mm.plugin.finder.report.m localm = Vn(-1);
    LinkedList localLinkedList = new LinkedList();
    if ((localm instanceof ae))
    {
      Iterator localIterator = ((Map)((ae)localm).Fsu).entrySet().iterator();
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        aps localaps = new aps();
        localaps.hKN = ((af)((Map.Entry)localObject).getValue()).feedId;
        localObject = ((af)((Map.Entry)localObject).getValue()).ANj;
        if (localObject == null) {
          localObject = "";
        }
        for (;;)
        {
          localaps.finderUsername = ((String)localObject);
          localObject = z.FrZ;
          String str = z.p(localaps.hKN, ((ae)localm).Auc.AJo);
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localaps.sessionBuffer = ((String)localObject);
          localLinkedList.add(localaps);
          break;
          str = ((FinderItem)localObject).getUserName();
          localObject = str;
          if (str == null) {
            localObject = "";
          }
        }
      }
    }
    Object localObject = (List)localLinkedList;
    AppMethodBeat.o(338590);
    return localObject;
  }
  
  public final boolean fop()
  {
    return this.hYb == 1;
  }
  
  public final bui fou()
  {
    AppMethodBeat.i(338358);
    if (fop())
    {
      localObject = k.aeZF;
      localObject = Vl(((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).fnX());
      AppMethodBeat.o(338358);
      return localObject;
    }
    bui localbui = new bui();
    localbui.hLK = this.hLK;
    localbui.AJo = this.AJo;
    localbui.sessionId = this.sessionId;
    localbui.zIO = this.zIO;
    localbui.zIB = this.zIB;
    localbui.ADF = this.ADF;
    localbui.GSR = this.GSR;
    localbui.GSU = this.GSU;
    localbui.GST = this.GST;
    localbui.GSV = this.GSV;
    String str = this.GSW;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbui.GSW = ((String)localObject);
    str = this.extraInfo;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbui.extraInfo = ((String)localObject);
    str = this.zIE;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localbui.zIE = ((String)localObject);
    localbui.GSX = this.GSX;
    localbui.hJx = this.GKp;
    localbui.GSS = this.GSS;
    localbui.DUN = this.DUN;
    AppMethodBeat.o(338358);
    return localbui;
  }
  
  public final String fov()
  {
    return this.zIO;
  }
  
  public final int fow()
  {
    return this.AJo;
  }
  
  public final List<com.tencent.mm.plugin.finder.event.base.c> fox()
  {
    AppMethodBeat.i(338398);
    if (fop())
    {
      localList = (List)p.al(new com.tencent.mm.plugin.finder.event.base.c[] { this.GTg, this.GTk, this.GTo });
      AppMethodBeat.o(338398);
      return localList;
    }
    List localList = (List)p.al(new com.tencent.mm.plugin.finder.event.base.c[] { this.ANW });
    AppMethodBeat.o(338398);
    return localList;
  }
  
  public final com.tencent.mm.plugin.finder.event.a foy()
  {
    AppMethodBeat.i(338409);
    if (fop())
    {
      int i = this.GKp;
      Log.i(TAG, s.X("getHomeFeedEventSubscriber ", Integer.valueOf(i)));
      switch (i)
      {
      case 2: 
      default: 
        locala = this.GSZ;
        AppMethodBeat.o(338409);
        return locala;
      case 3: 
        locala = this.GTh;
        AppMethodBeat.o(338409);
        return locala;
      case 1: 
        locala = this.GTl;
        AppMethodBeat.o(338409);
        return locala;
      }
      locala = this.GTp;
      AppMethodBeat.o(338409);
      return locala;
    }
    com.tencent.mm.plugin.finder.event.a locala = this.GSZ;
    AppMethodBeat.o(338409);
    return locala;
  }
  
  public final String foz()
  {
    return this.DnS;
  }
  
  public final void iI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(338325);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.u.GgT;
    this.DUN = com.tencent.mm.plugin.finder.utils.u.aN((Activity)getActivity());
    this.hLK = getActivity().getIntent().getIntExtra("key_from_comment_scene", 0);
    Object localObject2;
    if (paramInt1 == 0)
    {
      this.AJo = this.hLK;
      this.hYb = paramInt2;
      this.GSX = fos();
      localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = z.FrZ;
        localObject1 = z.bUm();
      }
      this.zIO = ((String)localObject1);
      localObject2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sessionId = ((String)localObject1);
      this.ADF = getActivity().getIntent().getLongExtra("key_click_feed_id", 0L);
      this.GSR = getActivity().getIntent().getStringExtra("key_click_feed_context_id");
      this.GST = getActivity().getIntent().getIntExtra("key_enter_profile_type", 0);
      this.GSU = getActivity().getIntent().getIntExtra("key_from_profile_share_scene", 0);
      if (!fop()) {
        break label875;
      }
      localObject1 = k.aeZF;
      this.GKp = ((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).fnX();
      localObject1 = z.FrZ;
      this.AJo = z.SD(this.GKp);
      this.zIB = a.Vs(this.GKp);
      label267:
      localObject2 = getActivity().getIntent().getStringExtra("key_common_extra_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.GSW = ((String)localObject1);
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
      this.zIE = ((String)localObject1);
      Log.i(TAG, "initActivityReporter reportType:" + this.hYb + " commentScene:" + this.AJo + " fromCommentScene:" + this.hLK + " sessionId:" + this.sessionId + " contextId:" + this.zIO + " clickTabContextId:" + this.zIB + " currentTabType:" + this.GKp + " uxInfo:" + this.extraInfo + " commonExtraInfo:" + this.GSW);
      if (!fop()) {
        break label1318;
      }
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.GTi = new ad((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.GTh = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eTm()) {
        break label1246;
      }
      localObject1 = new q((MMFragmentActivity)getActivity(), Vl(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((q)localObject1).onInvisible();
      localObject1 = (ae)localObject1;
      label586:
      this.GTj = ((ae)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new b());
      localObject1 = ah.aiuX;
      this.GTg = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.GTm = new ad((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.GTl = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eTm()) {
        break label1282;
      }
      localObject1 = new q((MMFragmentActivity)getActivity(), Vl(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((q)localObject1).onInvisible();
      localObject1 = (ae)localObject1;
    }
    for (;;)
    {
      this.GTn = ((ae)localObject1);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new b());
      localObject1 = ah.aiuX;
      this.GTk = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.GTq = new ad((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.GTp = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new q((MMFragmentActivity)getActivity(), Vl(4));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      ((q)localObject2).onInvisible();
      this.GTr = ((q)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new b());
      localObject2 = ah.aiuX;
      this.GTo = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject1 = k.aeZF;
      ((FinderHomeUIC)k.d(getActivity()).q(FinderHomeUIC.class)).GRB.add(this);
      AppMethodBeat.o(338325);
      return;
      this.AJo = paramInt1;
      break;
      label875:
      if (isNearby())
      {
        this.GKp = ((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).getTabType(getFragment());
        this.AJo = ((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).getCommentScene(getFragment());
        this.zIB = (((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).getClickTabId(getFragment()) + '-' + cn.bDw());
        break label267;
      }
      if ((getFragment() instanceof FinderActivityFragment))
      {
        localObject1 = getFragment();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
          AppMethodBeat.o(338325);
          throw ((Throwable)localObject1);
        }
        this.GKp = (((FinderActivityFragment)localObject1).hJx + 1);
        if (getFragment() == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
          AppMethodBeat.o(338325);
          throw ((Throwable)localObject1);
        }
        this.AJo = 59;
        localObject1 = new JSONObject();
        localObject2 = getFragment();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
          AppMethodBeat.o(338325);
          throw ((Throwable)localObject1);
        }
        localObject2 = com.tencent.mm.ae.d.hF(((FinderActivityFragment)localObject2).AtC);
        Fragment localFragment = getFragment();
        if (localFragment == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.activity.fragment.FinderActivityFragment");
          AppMethodBeat.o(338325);
          throw ((Throwable)localObject1);
        }
        ((JSONObject)localObject1).put((String)localObject2, ((FinderActivityFragment)localFragment).AtD);
        localObject2 = ah.aiuX;
        localObject1 = ((JSONObject)localObject1).toString();
        s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
        this.GSS = ((String)localObject1);
        this.zIB = a.Vs(paramInt1 + 100);
        break label267;
      }
      localObject2 = getActivity().getIntent().getStringExtra("key_click_tab_context_id");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.zIB = ((String)localObject1);
      if (!Util.isNullOrNil(this.zIB)) {
        break label267;
      }
      this.zIB = a.Vs(paramInt1 + 100);
      break label267;
      label1246:
      localObject1 = new ae((MMFragmentActivity)getActivity(), Vl(3));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((ae)localObject1).onInvisible();
      break label586;
      label1282:
      localObject1 = new ae((MMFragmentActivity)getActivity(), Vl(1));
      ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
      ((ae)localObject1).onInvisible();
    }
    label1318:
    if (foq())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.GSZ = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.GTa = new ad((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new ae((MMFragmentActivity)getActivity(), fou());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.GTb = ((ae)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new b());
      localObject2 = ah.aiuX;
      this.ANW = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(338325);
      return;
    }
    if (jdMethod_for())
    {
      localObject2 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.GSZ = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      this.GTd = new al((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      if ((getFragment() instanceof FinderActivityFragment)) {}
      for (localObject1 = (am)new com.tencent.mm.plugin.finder.report.e((MMFragmentActivity)getActivity(), fou());; localObject1 = new am((MMFragmentActivity)getActivity(), fou()))
      {
        this.GTe = ((am)localObject1);
        localObject1 = this.GTe;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        this.ANW = ((com.tencent.mm.plugin.finder.event.base.c)localObject2);
        AppMethodBeat.o(338325);
        return;
      }
    }
    if (fos())
    {
      localObject1 = new com.tencent.mm.plugin.finder.event.base.c(THREAD_TAG);
      this.GSZ = new com.tencent.mm.plugin.finder.event.a((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      this.GTa = new ad((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      localObject2 = new aw((MMFragmentActivity)getActivity(), fou());
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject2);
      this.GTc = ((aw)localObject2);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)new b());
      localObject2 = ah.aiuX;
      this.ANW = ((com.tencent.mm.plugin.finder.event.base.c)localObject1);
      AppMethodBeat.o(338325);
      return;
    }
    if (fot()) {
      this.GTf = new au((MMActivity)getActivity(), fou());
    }
    AppMethodBeat.o(338325);
  }
  
  public final void iw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(338450);
    s.u(paramString1, "key");
    s.u(paramString2, "value");
    try
    {
      JSONObject localJSONObject = new JSONObject(n.m(this.DnT, ";", ",", false));
      localJSONObject.put(paramString1, paramString2);
      paramString1 = localJSONObject.toString();
      s.s(paramString1, "jsonObject.toString()");
      this.DnT = n.bV(paramString1, ",", ";");
      AppMethodBeat.o(338450);
      return;
    }
    catch (Exception paramString1)
    {
      Log.i(TAG, String.valueOf(paramString1.getMessage()));
      AppMethodBeat.o(338450);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(338581);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 19999)
    {
      paramIntent = Vl(this.GKp);
      z localz = z.FrZ;
      z.b(2, this.GKp, paramIntent);
    }
    AppMethodBeat.o(338581);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(338558);
    Object localObject = Vn(-1);
    if ((localObject != null) && ((localObject instanceof ae)) && (!(getActivity() instanceof FinderHomeUI)))
    {
      localObject = (ae)localObject;
      com.tencent.mm.plugin.finder.report.m.a locala = com.tencent.mm.plugin.finder.report.m.Fpx;
      ((ae)localObject).azV(com.tencent.mm.plugin.finder.report.m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(5)))));
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(338558);
    return bool;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(338292);
    super.onCreateAfter(paramBundle);
    Object localObject;
    if ((getActivity() instanceof FinderHomeUI))
    {
      paramBundle = z.FrZ;
      localObject = this.zIO;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      z.id(paramBundle, "OnCreate");
      paramBundle = com.tencent.mm.plugin.finder.report.m.Fpx;
      paramBundle = fou();
      localObject = com.tencent.mm.plugin.finder.report.m.Fpx;
      localObject = com.tencent.mm.plugin.finder.report.m.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2)) }).toString();
      s.s(localObject, "FinderFeedFlowReporter.b…ORE_FRIEND)}\").toString()");
      com.tencent.mm.plugin.finder.report.m.a.a(paramBundle, 0L, 8, (String)localObject, 0L, null, 48);
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      paramBundle = com.tencent.mm.plugin.finder.report.m.Fpx;
      paramBundle = fou();
      localObject = com.tencent.mm.plugin.finder.report.m.Fpx;
      localObject = com.tencent.mm.plugin.finder.report.m.a.a(8, new String[] { String.valueOf(getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 1)) }).toString();
      s.s(localObject, "FinderFeedFlowReporter.b…ARE_DETAIL)}\").toString()");
      com.tencent.mm.plugin.finder.report.m.a.a(paramBundle, 0L, 8, (String)localObject, 0L, null, 48);
    }
    paramBundle = ay.EDk;
    ay.startTimer();
    this.GTw.sendEmptyMessage(GTx);
    AppMethodBeat.o(338292);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(338282);
    super.onCreateBefore(paramBundle);
    paramBundle = getFragment();
    int i;
    label39:
    as localas;
    if ((isNearby()) || ((getFragment() instanceof FinderActivityFragment)))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      if (paramBundle != null) {
        break label124;
      }
      paramBundle = null;
      if (paramBundle == null)
      {
        localas = (as)this;
        Log.i(TAG, s.X("onCreateBefore activity:", localas.getActivity()));
        paramBundle = localas.getActivity();
        if (!(localas.getActivity() instanceof MMFinderUI)) {
          break label210;
        }
      }
    }
    for (;;)
    {
      if (paramBundle != null) {
        localas.iI(((MMFinderUI)paramBundle).getCommentScene(), ((MMFinderUI)paramBundle).edC());
      }
      AppMethodBeat.o(338282);
      return;
      i = 0;
      break;
      label119:
      paramBundle = null;
      break label39;
      label124:
      Log.i(TAG, s.X("onCreateBefore fragment:", getFragment()));
      if (isNearby()) {
        iI(((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).getCommentScene(getFragment()), ((com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class)).getReportType(getFragment()));
      }
      for (;;)
      {
        break;
        if ((getFragment() instanceof FinderActivityFragment)) {
          iI(59, 3);
        }
      }
      label210:
      paramBundle = null;
    }
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.GTu = true;
      return;
    }
    this.GTu = false;
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.GTu)
    {
      this.GTt = false;
      this.GTu = false;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338533);
    super.onPause();
    if (fop()) {
      switch (this.GKp)
      {
      }
    }
    for (;;)
    {
      Object localObject = ((Iterable)this.GTv).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject).next()).get();
        if (localWxRecyclerAdapter != null) {
          localWxRecyclerAdapter.onPause();
        }
      }
      localObject = this.GTi;
      if (localObject != null) {
        ((ad)localObject).onInvisible();
      }
      localObject = this.GTj;
      if (localObject != null)
      {
        ((ae)localObject).onInvisible();
        continue;
        localObject = this.GTm;
        if (localObject != null) {
          ((ad)localObject).onInvisible();
        }
        localObject = this.GTn;
        if (localObject != null)
        {
          ((ae)localObject).onInvisible();
          continue;
          localObject = this.GTq;
          if (localObject != null) {
            ((ad)localObject).onInvisible();
          }
          localObject = this.GTr;
          if (localObject != null)
          {
            ((q)localObject).onInvisible();
            continue;
            if (foq())
            {
              localObject = this.GTa;
              if (localObject != null) {
                ((ad)localObject).onInvisible();
              }
              localObject = this.GTb;
              if (localObject != null) {
                ((ae)localObject).onInvisible();
              }
            }
            else if (jdMethod_for())
            {
              localObject = this.GTd;
              if (localObject != null) {
                ((al)localObject).onInvisible();
              }
              localObject = this.GTe;
              if (localObject != null) {
                ((am)localObject).onInvisible();
              }
            }
            else if (fos())
            {
              localObject = this.GTa;
              if (localObject != null) {
                ((ad)localObject).onInvisible();
              }
              localObject = this.GTc;
              if (localObject != null) {
                ((aw)localObject).onInvisible();
              }
            }
            else if (fot())
            {
              localObject = this.GTf;
              if (localObject != null) {
                ((au)localObject).onInvisible();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(338533);
  }
  
  public final void onPreDestroyed()
  {
    AppMethodBeat.i(338566);
    super.onPreDestroyed();
    Log.i(TAG, "onPreDestroyed");
    Object localObject2;
    if ((getActivity() instanceof FinderHomeUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.m.Fpx;
      localObject1 = fou();
      localObject2 = m.c.FpF;
      com.tencent.mm.plugin.finder.report.m.a.a((bui)localObject1, 0L, 9, m.c.eMy(), 0L, null, 48);
      localObject1 = z.FrZ;
      localObject2 = this.zIO;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      z.id((String)localObject1, "Exit");
    }
    if ((getActivity() instanceof FinderShareFeedRelUI))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.m.Fpx;
      localObject1 = fou();
      localObject2 = m.c.FpF;
      com.tencent.mm.plugin.finder.report.m.a.a((bui)localObject1, 0L, 9, m.c.eMy(), 0L, null, 48);
    }
    Object localObject1 = this.ANW;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.GTg;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.GTk;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = this.GTo;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).onRelease();
    }
    localObject1 = ay.EDk;
    ay.stopTimer();
    this.GTw.removeCallbacksAndMessages(null);
    this.GTw.sendEmptyMessage(GTy);
    AppMethodBeat.o(338566);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338525);
    super.onResume();
    if (this.isFirstOnResume)
    {
      this.isFirstOnResume = false;
      AppMethodBeat.o(338525);
      return;
    }
    Object localObject1;
    if (fop())
    {
      localObject1 = Vl(this.GKp);
      switch (this.GKp)
      {
      case 2: 
      default: 
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        com.tencent.mm.plugin.finder.extension.reddot.m.a.a(1, fou(), this.GKp, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        com.tencent.mm.plugin.finder.extension.reddot.m.a.b(1, fou(), this.GKp, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        com.tencent.mm.plugin.finder.extension.reddot.m.a.c(1, fou(), this.GKp, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        com.tencent.mm.plugin.finder.extension.reddot.m.a.a(1, fou());
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        com.tencent.mm.plugin.finder.extension.reddot.m.a.a(1, fou(), "");
      }
    }
    for (;;)
    {
      localObject1 = ((Iterable)this.GTv).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WxRecyclerAdapter)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((WxRecyclerAdapter)localObject2).onResume();
        }
      }
      Object localObject2 = this.GTj;
      if (localObject2 != null) {
        ((ae)localObject2).f((bui)localObject1);
      }
      localObject1 = this.GTi;
      if (localObject1 != null) {
        ((ad)localObject1).onVisible();
      }
      localObject1 = this.GTj;
      if (localObject1 == null) {
        break;
      }
      ((ae)localObject1).onVisible();
      break;
      localObject2 = this.GTn;
      if (localObject2 != null) {
        ((ae)localObject2).f((bui)localObject1);
      }
      localObject1 = this.GTm;
      if (localObject1 != null) {
        ((ad)localObject1).onVisible();
      }
      localObject1 = this.GTn;
      if (localObject1 == null) {
        break;
      }
      ((ae)localObject1).onVisible();
      break;
      localObject2 = this.GTr;
      if (localObject2 != null) {
        ((q)localObject2).f((bui)localObject1);
      }
      localObject1 = this.GTq;
      if (localObject1 != null) {
        ((ad)localObject1).onVisible();
      }
      localObject1 = this.GTr;
      if (localObject1 == null) {
        break;
      }
      ((q)localObject1).onVisible();
      break;
      if (foq())
      {
        localObject1 = this.GTa;
        if (localObject1 != null) {
          ((ad)localObject1).onVisible();
        }
        localObject1 = this.GTb;
        if (localObject1 != null) {
          ((ae)localObject1).onVisible();
        }
      }
      else if (jdMethod_for())
      {
        localObject1 = this.GTd;
        if (localObject1 != null) {
          ((al)localObject1).onVisible();
        }
        localObject1 = this.GTe;
        if (localObject1 != null) {
          ((am)localObject1).onVisible();
        }
      }
      else if (fos())
      {
        localObject1 = this.GTa;
        if (localObject1 != null) {
          ((ad)localObject1).onVisible();
        }
        localObject1 = this.GTc;
        if (localObject1 != null) {
          ((aw)localObject1).onVisible();
        }
      }
      else if (fot())
      {
        localObject1 = this.GTf;
        if (localObject1 != null) {
          ((au)localObject1).onVisible();
        }
      }
    }
    AppMethodBeat.o(338525);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(338549);
    super.onUserVisibleFocused();
    if (jdMethod_for())
    {
      Object localObject = this.GTd;
      if (localObject != null) {
        ((al)localObject).onVisible();
      }
      localObject = this.GTe;
      if (localObject != null) {
        ((am)localObject).onVisible();
      }
    }
    AppMethodBeat.o(338549);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(338554);
    super.onUserVisibleUnFocused();
    if (jdMethod_for())
    {
      Object localObject = this.GTd;
      if (localObject != null) {
        ((al)localObject).onInvisible();
      }
      localObject = this.GTe;
      if (localObject != null) {
        ((am)localObject).onInvisible();
      }
    }
    AppMethodBeat.o(338554);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$Companion;", "", "()V", "CYCLE_TIME", "", "SEND", "", "STOP", "TAG", "", "THREAD_TAG", "getTHREAD_TAG", "()Ljava/lang/String;", "genClickTabContextId", "tabType", "initIntentParams", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "feedId", "clickFeedContextId", "fromProfileShareScene", "enterProfileType", "enterLbsUI", "", "uic", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String Vs(int paramInt)
    {
      AppMethodBeat.i(338735);
      String str1 = paramInt + '-' + cn.bDw();
      String str2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpd, "100");
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = "unknown";
      }
      for (;;)
      {
        Log.i(as.access$getTAG$cp(), "genClickTabContextId [%s] uiTabIndex[%s] blacklist[%s]", new Object[] { str1, localObject, str2 });
        try
        {
          s.s(str2, "blacklist");
          localObject = ((Iterable)n.a((CharSequence)str2, new char[] { ';' }, 0, 6)).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!s.p((String)((Iterator)localObject).next(), String.valueOf(paramInt)));
          AppMethodBeat.o(338735);
          return str1;
        }
        catch (Exception localException)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adeW, str1);
          AppMethodBeat.o(338735);
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
    
    public static void a(Context paramContext, Intent paramIntent, long paramLong, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(338708);
      s.u(paramContext, "context");
      s.u(paramIntent, "intent");
      if ((paramContext instanceof MMFragmentActivity))
      {
        paramString = k.aeZF;
        int i = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).AJo;
        paramString = av.GiL;
        if (av.Um(i))
        {
          paramString = k.aeZF;
          paramIntent.putExtra("key_from_comment_scene", ((as)k.d((AppCompatActivity)paramContext).q(as.class)).hLK);
          paramString = k.aeZF;
          paramString = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).zIO;
          Object localObject1 = (CharSequence)paramString;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label752;
          }
          paramInt1 = 1;
          label142:
          if (paramInt1 == 0) {
            paramIntent.putExtra("key_context_id", paramString);
          }
          paramString = k.aeZF;
          paramString = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).GSW;
          if (!Util.isNullOrNil(paramString)) {
            paramIntent.putExtra("key_common_extra_info", paramString);
          }
          paramString = k.aeZF;
          paramString = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).extraInfo;
          if (!Util.isNullOrNil(paramString)) {
            paramIntent.putExtra("key_extra_info", paramString);
          }
          paramString = k.aeZF;
          paramString = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).zIE;
          if (!Util.isNullOrNil(paramString)) {
            paramIntent.putExtra("key_enter_source_info", paramString);
          }
          if (!paramBoolean) {
            break label758;
          }
          paramString = k.aeZF;
          paramInt1 = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).GKp;
          paramString = k.aeZF;
          ((as)k.d((AppCompatActivity)paramContext).q(as.class)).zIB = Vs(paramInt1);
          localObject1 = Vs(2);
          paramIntent.putExtra("key_click_tab_context_id", (String)localObject1);
          paramString = k.aeZF;
          Object localObject2 = (as)k.d((AppCompatActivity)paramContext).q(as.class);
          if (localObject2 != null)
          {
            paramString = ((as)localObject2).fou();
            paramString.zIB = ((String)localObject1);
            localObject1 = z.FrZ;
            z.b(paramInt1, 2, paramString);
            localObject1 = ((as)localObject2).Vn(paramInt1);
            if ((localObject1 != null) && ((localObject1 instanceof ae)))
            {
              localObject1 = (ae)localObject1;
              localObject2 = com.tencent.mm.plugin.finder.report.m.Fpx;
              ((ae)localObject1).azV(com.tencent.mm.plugin.finder.report.m.a.aj(ak.e(new r[] { v.Y("feedActionType", Integer.valueOf(2)), v.Y("toTab", Integer.valueOf(2)), v.Y("fromTab", Integer.valueOf(paramInt1)) })));
            }
            localObject1 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
            com.tencent.mm.plugin.finder.extension.reddot.m.a.a(2, paramString);
          }
          label513:
          if (paramLong == 0L) {
            break label792;
          }
          paramIntent.putExtra("key_click_feed_id", paramLong);
          label528:
          paramString = k.aeZF;
          paramString = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).GSR;
          if (paramString != null) {
            paramIntent.putExtra("key_click_feed_context_id", paramString);
          }
          paramString = k.aeZF;
          paramInt1 = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).GSU;
          if (paramInt1 != 0) {
            paramIntent.putExtra("key_from_profile_share_scene", paramInt1);
          }
          if (paramInt2 == 0) {
            break label834;
          }
          paramIntent.putExtra("key_enter_profile_type", paramInt2);
        }
        for (;;)
        {
          paramInt1 = paramIntent.getIntExtra("key_entrance_type", -1);
          paramInt2 = paramIntent.getIntExtra("key_to_comment_scene", 0);
          if ((paramInt2 == 0) || (paramInt1 < 0)) {
            break label877;
          }
          Log.i(as.access$getTAG$cp(), "[initIntentParams] commentScene=" + i + " toCommentScene=" + paramInt2 + " entranceType=" + paramInt1);
          paramString = com.tencent.mm.plugin.finder.utils.u.GgT;
          com.tencent.mm.plugin.finder.utils.u.a(paramContext, paramIntent, paramInt2, paramInt1);
          AppMethodBeat.o(338708);
          return;
          paramString = k.aeZF;
          paramIntent.putExtra("key_from_comment_scene", ((as)k.d((AppCompatActivity)paramContext).q(as.class)).AJo);
          break;
          label752:
          paramInt1 = 0;
          break label142;
          label758:
          paramString = k.aeZF;
          paramIntent.putExtra("key_click_tab_context_id", ((as)k.d((AppCompatActivity)paramContext).q(as.class)).zIB);
          break label513;
          label792:
          paramString = k.aeZF;
          paramLong = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).ADF;
          if (paramLong == 0L) {
            break label528;
          }
          paramIntent.putExtra("key_click_feed_id", paramLong);
          break label528;
          label834:
          paramString = k.aeZF;
          paramInt1 = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).GST;
          if (paramInt1 != 0) {
            paramIntent.putExtra("key_enter_profile_type", paramInt1);
          }
        }
        label877:
        paramContext = ((MMFragmentActivity)paramContext).getIntent().getStringExtra("key_jump_id");
        paramString = (CharSequence)paramContext;
        if ((paramString == null) || (paramString.length() == 0)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((paramInt1 == 0) && (!paramIntent.hasExtra("key_jump_id"))) {
            paramIntent.putExtra("key_jump_id", paramContext);
          }
          Log.i(as.access$getTAG$cp(), s.X("[initIntentParams] jumpId=", paramContext));
          AppMethodBeat.o(338708);
          return;
        }
      }
      Log.w(as.access$getTAG$cp(), "initIntentParams context is not MMFragmentActivity");
      AppMethodBeat.o(338708);
    }
    
    public static as hu(Context paramContext)
    {
      AppMethodBeat.i(338724);
      s.u(paramContext, "context");
      if ((paramContext instanceof MMFragmentActivity))
      {
        k localk = k.aeZF;
        paramContext = (as)k.d((AppCompatActivity)paramContext).q(as.class);
        AppMethodBeat.o(338724);
        return paramContext;
      }
      AppMethodBeat.o(338724);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(as paramas, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderReporterUIC$timer$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends MMHandler
  {
    c(as paramas, String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(338677);
      if (paramMessage != null)
      {
        as localas = this.GTA;
        int i = paramMessage.what;
        if (i == as.foD())
        {
          as.c(localas);
          sendEmptyMessageDelayed(as.foD(), as.foE());
          AppMethodBeat.o(338677);
          return;
        }
        if (i == as.foF())
        {
          as.c(localas);
          removeCallbacksAndMessages(null);
        }
      }
      AppMethodBeat.o(338677);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.as
 * JD-Core Version:    0.7.0.1
 */