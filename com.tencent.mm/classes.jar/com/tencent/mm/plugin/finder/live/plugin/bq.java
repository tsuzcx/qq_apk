package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.co;
import com.tencent.mm.plugin.finder.live.model.af.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.sidebar.d.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.widget.FinderLivePromoteBannerWidget;
import com.tencent.mm.plugin.finder.live.widget.FinderLivePromoteBannerWidget.b;
import com.tencent.mm.plugin.finder.live.widget.FinderLivePromoteBannerWidget.c;
import com.tencent.mm.plugin.finder.live.widget.FinderLivePromoteBannerWidget.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.Html5Info;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "bannerJumpInfosList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "Lkotlin/collections/ArrayList;", "getBannerJumpInfosList", "()Ljava/util/ArrayList;", "setBannerJumpInfosList", "(Ljava/util/ArrayList;)V", "closeBanner", "", "getCloseBanner", "()Z", "setCloseBanner", "(Z)V", "container", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget;", "getContainer", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget;", "setContainer", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget;)V", "currentBannerId", "", "getCurrentBannerId", "()Ljava/lang/String;", "setCurrentBannerId", "(Ljava/lang/String;)V", "currentBannerInfo", "getCurrentBannerInfo", "()Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "setCurrentBannerInfo", "(Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;)V", "isMount", "setMount", "isStarted", "setStarted", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "loadOutsideBannerJob", "Lkotlinx/coroutines/Job;", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "loopBannerExposed", "loopBannerJumpList", "mDialog", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "getMDialog", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;", "setMDialog", "(Lcom/tencent/mm/plugin/webview/ui/tools/widget/HalfScreenWebView;)V", "mWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "getMWebViewController", "()Lcom/tencent/mm/plugin/webview/core/WebViewController;", "setMWebViewController", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "preloading", "getPreloading", "setPreloading", "updateWidgetMaxCount", "", "getUpdateWidgetMaxCount", "()I", "setUpdateWidgetMaxCount", "(I)V", "bannerJumpImpl", "", "context", "Landroid/content/Context;", "jumpInfo", "canClearScreen", "canShow", "checkVisible", "doCloseLive", "doDislikeBanner", "dislikeId", "doPreload", "url", "doReportExposeBanner", "bannerId", "fetchSideBarInfo", "bannerJumpInfoList", "getBannerHalfParam", "getBannerReportJson", "id", "actionType", "getCurrentShowFinderJumpInfo", "getLoopBannerList", "isSameBannerList", "new", "old", "isShow", "isShowHalfScreen", "html5Info", "Lcom/tencent/mm/protocal/protobuf/Html5Info;", "mount", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "preCreateWebView", "remove", "reportBannerAction", "result", "setVisible", "visible", "showDislikeBannerBottomSheet", "fromLongClick", "showShareBottomSheet", "startPollingBannerData", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateBanner", "updateBannerJumpInfoList", "jump_infos", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
  extends b
{
  public static final bq.a DhE;
  private static final int DhQ;
  private static final int DhR;
  private static final int DhS = 0;
  private static final String TAG;
  private final ViewGroup CZa;
  private FinderLivePromoteBannerWidget DhF;
  ArrayList<com.tencent.mm.plugin.finder.live.model.b> DhG;
  com.tencent.mm.plugin.finder.live.model.b DhH;
  String DhI;
  private boolean DhJ;
  private int DhK;
  private ArrayList<com.tencent.mm.plugin.finder.live.model.b> DhL;
  private ArrayList<String> DhM;
  private com.tencent.mm.plugin.webview.ui.tools.widget.a DhN;
  private boolean DhO;
  private com.tencent.mm.plugin.webview.core.k DhP;
  private final Activity activity;
  private cb akfh;
  private boolean isStarted;
  long lastClickTime;
  private final Object lock;
  private final aq mainScope;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355847);
    DhE = new bq.a((byte)0);
    TAG = "Finder.FinderLivePromoteBannerPlugin";
    DhQ = 50;
    DhR = 90;
    AppMethodBeat.o(355847);
  }
  
  public bq(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355490);
    this.CZa = paramViewGroup;
    this.nfT = paramb;
    this.mainScope = ar.kBZ();
    paramViewGroup = this.mJe.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(355490);
      throw paramViewGroup;
    }
    this.activity = ((Activity)paramViewGroup);
    paramViewGroup = this.CZa.findViewById(p.e.BRq);
    kotlin.g.b.s.s(paramViewGroup, "entranceRoot.findViewByI…promote_banner_container)");
    this.DhF = ((FinderLivePromoteBannerWidget)paramViewGroup);
    this.DhG = new ArrayList();
    this.DhI = "";
    this.lock = new Object();
    this.DhL = new ArrayList();
    this.DhM = new ArrayList();
    this.DhF.setListener((FinderLivePromoteBannerWidget.c)new FinderLivePromoteBannerWidget.c()
    {
      public final void a(com.tencent.mm.plugin.finder.live.model.b paramAnonymousb)
      {
        AppMethodBeat.i(354958);
        kotlin.g.b.s.u(paramAnonymousb, "jumpInfo");
        Object localObject = bq.DhE;
        Log.i(bq.access$getTAG$cp(), "onClick jump");
        long l = System.currentTimeMillis();
        if (l - this.DhT.lastClickTime < 500L)
        {
          paramAnonymousb = bq.DhE;
          Log.i(bq.access$getTAG$cp(), "don't click again in 500ms");
          AppMethodBeat.o(354958);
          return;
        }
        this.DhT.lastClickTime = l;
        localObject = this.DhT;
        Context localContext = bq.d(this.DhT).getContext();
        kotlin.g.b.s.s(localContext, "entranceRoot.context");
        bq.a((bq)localObject, localContext, paramAnonymousb);
        bq.axg(bq.axh(this.DhT.DhI));
        AppMethodBeat.o(354958);
      }
      
      public final void a(com.tencent.mm.plugin.finder.live.model.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(354980);
        kotlin.g.b.s.u(paramAnonymousb, "jumpInfo");
        Object localObject1 = bq.DhE;
        Object localObject2 = bq.access$getTAG$cp();
        localObject1 = paramAnonymousb.CDz;
        bfn localbfn;
        if (localObject1 == null)
        {
          localObject1 = null;
          Log.i((String)localObject2, "onFlipperToIndex index:%d, wording:%s", new Object[] { Integer.valueOf(paramAnonymousInt), localObject1 });
          localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
          localbfn = com.tencent.mm.plugin.finder.live.sidebar.a.axE(paramAnonymousb.CDz.ext_info);
          bq localbq = this.DhT;
          if (localbfn != null) {
            break label131;
          }
          localObject1 = "";
          label83:
          bq.b(localbq, (String)localObject1);
          this.DhT.DhH = paramAnonymousb;
          localObject2 = this.DhT;
          if (localbfn != null) {
            break label152;
          }
          paramAnonymousb = "";
        }
        for (;;)
        {
          ((bq)localObject2).DhI = paramAnonymousb;
          AppMethodBeat.o(354980);
          return;
          localObject1 = ((FinderJumpInfo)localObject1).wording;
          break;
          label131:
          localObject2 = localbfn.id;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label83;
          }
          localObject1 = "";
          break label83;
          label152:
          localObject1 = localbfn.id;
          paramAnonymousb = (com.tencent.mm.plugin.finder.live.model.b)localObject1;
          if (localObject1 == null) {
            paramAnonymousb = "";
          }
        }
      }
      
      public final void b(com.tencent.mm.plugin.finder.live.model.b paramAnonymousb)
      {
        AppMethodBeat.i(354969);
        kotlin.g.b.s.u(paramAnonymousb, "jumpInfo");
        bq.a locala = bq.DhE;
        Log.i(bq.access$getTAG$cp(), "onLongClick jump");
        bq.b(this.DhT, paramAnonymousb);
        AppMethodBeat.o(354969);
      }
    });
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp.size() > 0) {
      this.DhG.addAll((Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp);
    }
    AppMethodBeat.o(355490);
  }
  
  private final void a(Context paramContext, final com.tencent.mm.plugin.finder.live.model.b paramb)
  {
    AppMethodBeat.i(355616);
    Log.i(TAG, "bannerJumpImpl business_type:%d", new Object[] { Integer.valueOf(paramb.CDz.business_type) });
    if (paramb.CDz.business_type != 5)
    {
      Log.e(TAG, "business_type is not emFinderJumperBusinessType_LiveRoomBanner");
      AppMethodBeat.o(355616);
      return;
    }
    switch (paramb.CDz.jumpinfo_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355616);
      return;
      Object localObject1 = paramb.CDz.html5_info;
      if (localObject1 == null) {
        localObject1 = "";
      }
      Object localObject2;
      for (;;)
      {
        Log.i(TAG, "jump half h5 url:%s", new Object[] { localObject1 });
        if ((paramb.CDz.html5_info != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          break;
        }
        Log.e(TAG, "jumpToHalfScreenH5 html5_info is null or url is empty");
        AppMethodBeat.o(355616);
        return;
        localObject2 = ((Html5Info)localObject1).url;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      if (a(paramb.CDz.html5_info))
      {
        if (isLandscape())
        {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edq = true;
          paramContext = (b)this;
          paramb = cg.Dlc;
          b.a(paramContext, cg.esE());
          Log.i(TAG, "change to portrait and show dialog");
          AppMethodBeat.o(355616);
          return;
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edq = false;
        paramContext = paramb.CDz.html5_info;
        if (paramContext == null) {}
        for (int i = 0;; i = paramContext.height_percent)
        {
          Log.i(TAG, kotlin.g.b.s.X("show HalfScreenWebView heightPercent:", Integer.valueOf(i)));
          int j;
          if (i >= DhQ)
          {
            j = i;
            if (i <= DhR) {}
          }
          else
          {
            j = 75;
          }
          float f = j / 100.0F;
          Log.i(TAG, kotlin.g.b.s.X("realScreenHeightPercent:", Float.valueOf(f)));
          paramContext = this.CZa.getContext();
          kotlin.g.b.s.s(paramContext, "entranceRoot.context");
          this.DhN = new com.tencent.mm.plugin.webview.ui.tools.widget.a(paramContext, (String)localObject1, new com.tencent.mm.plugin.webview.ui.tools.widget.c(f, erB(), false, true, 0, 116), 4);
          paramContext = this.DhN;
          if (paramContext != null) {
            paramContext.show();
          }
          paramContext = this.DhN;
          if (paramContext != null) {
            paramContext.a((com.tencent.mm.plugin.webview.ui.tools.widget.u)new c(this, paramb));
          }
          paramContext = this.DhN;
          if (paramContext != null) {
            paramContext.setOnDismissListener(new bq..ExternalSyntheticLambda0(this, paramb));
          }
          this.DhP = null;
          this.DhF.eBv();
          AppMethodBeat.o(355616);
          return;
        }
      }
      Log.i(TAG, "show FullScreenWebView");
      paramb = new Intent();
      paramb.putExtra("rawUrl", (String)localObject1);
      paramb.putExtra("convertActivityFromTranslucent", true);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramb);
      AppMethodBeat.o(355616);
      return;
      Log.e(TAG, "jump mini app not implement");
      AppMethodBeat.o(355616);
      return;
      localObject1 = paramb.CDz.native_info;
      if (localObject1 == null)
      {
        localObject1 = null;
        paramb = paramb.CDz.native_info;
        if (paramb != null) {
          break label687;
        }
        paramb = "";
        label595:
        Log.i(TAG, "jump native necessary_params:%s", new Object[] { paramb });
      }
      label687:
      label835:
      do
      {
        do
        {
          do
          {
            do
            {
              try
              {
                paramb = new JSONObject(paramb);
                localObject2 = paramb;
                if (paramb == null) {
                  localObject2 = new JSONObject();
                }
                if (localObject1 == null)
                {
                  if (localObject1 != null) {
                    continue;
                  }
                  if (localObject1 != null) {
                    break label783;
                  }
                  if (localObject1 != null) {
                    break label809;
                  }
                  if (localObject1 != null) {
                    break label835;
                  }
                  if (localObject1 != null) {
                    break label925;
                  }
                  AppMethodBeat.o(355616);
                  return;
                  localObject1 = Integer.valueOf(((NativeInfo)localObject1).native_type);
                  break;
                  localObject2 = paramb.necessary_params;
                  paramb = (com.tencent.mm.plugin.finder.live.model.b)localObject2;
                  if (localObject2 != null) {
                    break label595;
                  }
                  paramb = "";
                }
              }
              catch (JSONException paramb)
              {
                do
                {
                  for (;;)
                  {
                    Log.printErrStackTrace(TAG, (Throwable)paramb, "", new Object[0]);
                    paramb = null;
                  }
                } while (((Integer)localObject1).intValue() != 1);
                paramb = com.tencent.mm.plugin.finder.live.util.l.DJa;
                com.tencent.mm.plugin.finder.live.util.l.b(paramContext, (JSONObject)localObject2);
                AppMethodBeat.o(355616);
                return;
              }
            } while (((Integer)localObject1).intValue() != 2);
            paramb = com.tencent.mm.plugin.finder.live.util.l.DJa;
            com.tencent.mm.plugin.finder.live.util.l.c(paramContext, (JSONObject)localObject2);
            AppMethodBeat.o(355616);
            return;
          } while (((Integer)localObject1).intValue() != 3);
          paramb = com.tencent.mm.plugin.finder.live.util.l.DJa;
          com.tencent.mm.plugin.finder.live.util.l.d(paramContext, (JSONObject)localObject2);
          AppMethodBeat.o(355616);
          return;
        } while (((Integer)localObject1).intValue() != 4);
        paramb = com.tencent.mm.plugin.finder.live.util.l.DJa;
        com.tencent.mm.plugin.finder.live.util.l.e(paramContext, (JSONObject)localObject2);
        AppMethodBeat.o(355616);
        return;
      } while (((Integer)localObject1).intValue() != 5);
      try
      {
        label783:
        label809:
        paramb = new JSONObject();
        ((JSONObject)localObject2).put("action", "openFinderMultiMoreLive");
        paramb.put("extInfo", localObject2);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderUI(paramContext, paramb.toString());
        AppMethodBeat.o(355616);
        return;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "openFinderView", new Object[0]);
        AppMethodBeat.o(355616);
        return;
      }
      label925:
      if (((Integer)localObject1).intValue() == 9)
      {
        paramContext = com.tencent.mm.ui.component.k.aeZF;
        paramContext = this.CZa.getContext();
        kotlin.g.b.s.s(paramContext, "entranceRoot.context");
        paramContext = com.tencent.mm.ui.component.k.nq(paramContext).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
        kotlin.g.b.s.s(paramContext, "UICProvider.of(entranceR…veSideBarUIC::class.java)");
        paramContext = (com.tencent.mm.plugin.finder.live.sidebar.d)paramContext;
        paramb = paramContext.DGE;
        if (paramb != null) {
          com.tencent.mm.plugin.finder.live.sidebar.c.b(paramb);
        }
        paramContext.DGH.etI();
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.model.b paramb, bq parambq, boolean paramBoolean, ah.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(371489);
    kotlin.g.b.s.u(paramb, "$jumpInfo");
    kotlin.g.b.s.u(parambq, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    if (paramMenuItem.getItemId() == DhS)
    {
      Log.i(TAG, "click dislike banner menu");
      paramMenuItem = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
      paramMenuItem = com.tencent.mm.plugin.finder.live.sidebar.a.axE(paramb.CDz.ext_info);
      if (paramMenuItem != null) {
        break label350;
      }
      paramMenuItem = "";
      if (!TextUtils.isEmpty((CharSequence)paramMenuItem)) {
        break label374;
      }
      Log.e(TAG, "dislikeId is empty");
    }
    for (;;)
    {
      Object localObject2;
      FinderLivePromoteBannerWidget localFinderLivePromoteBannerWidget;
      ah.f localf;
      synchronized (parambq.lock)
      {
        if (parambq.DhG.contains(paramb))
        {
          parambq.DhG.remove(paramb);
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp.remove(paramb);
        }
        localObject2 = ah.aiuX;
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveDislikeBannerStorage().axG(paramMenuItem);
        localFinderLivePromoteBannerWidget = parambq.DhF;
        if (localFinderLivePromoteBannerWidget != null)
        {
          if (parambq.DhN == null)
          {
            bool = true;
            ??? = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
            if (paramb != null) {
              break label533;
            }
            ??? = null;
            ??? = com.tencent.mm.plugin.finder.live.sidebar.a.axE((String)???);
            localf = new ah.f();
            if (??? != null) {
              break label560;
            }
            ??? = "";
            localf.aqH = ???;
            if (!TextUtils.isEmpty((CharSequence)localf.aqH)) {
              break label584;
            }
            Log.e(localFinderLivePromoteBannerWidget.TAG, "dislike id is empty!!");
          }
        }
        else
        {
          Log.i(TAG, "onDislike bannerId:%s", new Object[] { paramMenuItem });
          if (parambq.DhG.size() == 1)
          {
            parambq.tO(8);
            parambq.DhJ = true;
            Log.i(TAG, "only one banner gone banner plugin");
          }
          if (!paramBoolean) {
            break label727;
          }
          axc(ex(paramMenuItem, 5));
          b.b.a(parambq.nfT, b.c.nfq);
          ((com.tencent.mm.ui.widget.a.f)paramf.aqH).cyW();
          AppMethodBeat.o(371489);
          return;
          label350:
          ??? = paramMenuItem.id;
          paramMenuItem = (MenuItem)???;
          if (??? != null) {
            break;
          }
          paramMenuItem = "";
          break;
          label374:
          ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parambq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
          {
            ??? = z.bAW();
            kotlin.g.b.s.s(???, "getMyFinderUsername()");
          }
          long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
          long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
          localObject2 = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
          kotlin.g.b.s.s(localObject2, "copyFrom(business(LiveCo…:class.java).liveCookies)");
          new com.tencent.mm.plugin.finder.cgi.af(l1, l2, (com.tencent.mm.bx.b)localObject2, (String)???, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)parambq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId, paramMenuItem).bFJ().g(bq..ExternalSyntheticLambda9.INSTANCE);
        }
      }
      boolean bool = false;
      continue;
      label533:
      ??? = paramb.CDz;
      if (??? == null)
      {
        ??? = null;
      }
      else
      {
        ??? = ((FinderJumpInfo)???).ext_info;
        continue;
        label560:
        localObject2 = ((bfn)???).id;
        ??? = localObject2;
        if (localObject2 == null)
        {
          ??? = "";
          continue;
          label584:
          localObject2 = (FinderLivePromoteBannerWidget.b)localFinderLivePromoteBannerWidget.Ets.remove(localf.aqH);
          if (localObject2 == null)
          {
            ??? = null;
            label610:
            if (??? != null) {
              ((LinearLayout)???).setVisibility(8);
            }
            if (localObject2 != null) {
              break label717;
            }
          }
          label717:
          for (??? = null;; ??? = ((FinderLivePromoteBannerWidget.b)localObject2).EtD)
          {
            if (??? != null) {
              ((LinearLayout)???).setVisibility(0);
            }
            ??? = AnimationUtils.loadAnimation(localFinderLivePromoteBannerWidget.getContext(), p.a.ByI);
            ((Animation)???).cancel();
            ((Animation)???).setAnimationListener((Animation.AnimationListener)new FinderLivePromoteBannerWidget.d((FinderLivePromoteBannerWidget.b)localObject2, localFinderLivePromoteBannerWidget, paramb, localf, bool));
            if (localObject2 == null) {
              break;
            }
            paramb = ((FinderLivePromoteBannerWidget.b)localObject2).EtB;
            if (paramb == null) {
              break;
            }
            paramb.startAnimation((Animation)???);
            break;
            ??? = ((FinderLivePromoteBannerWidget.b)localObject2).Api;
            break label610;
          }
          label727:
          axc(ex(paramMenuItem, 4));
        }
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.model.b paramb, ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(371481);
    kotlin.g.b.s.u(paramb, "$bannerJumpInfo");
    kotlin.g.b.s.u(paramArrayList, "$invalidList");
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof co)) && (((co)paramp).dVP().size() > 0))
    {
      paramArrayList = (Iterable)((co)paramp).dVP();
      Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramArrayList, 10));
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        Object localObject3 = (FinderObject)localIterator.next();
        paramArrayList = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        paramArrayList = FinderItem.Companion;
        e.a.s(FinderItem.a.e((FinderObject)localObject3, 16384));
        long l3 = ((FinderObject)localObject3).id;
        paramArrayList = ((FinderObject)localObject3).liveInfo;
        long l1;
        label150:
        label202:
        String str2;
        label222:
        label237:
        label251:
        String str3;
        String str1;
        long l2;
        if (paramArrayList == null)
        {
          l1 = 0L;
          paramArrayList = ((FinderObject)localObject3).username;
          localObject1 = paramArrayList;
          if (paramArrayList == null) {
            localObject1 = "";
          }
          paramArrayList = ((FinderObject)localObject3).objectNonceId;
          localObject2 = paramArrayList;
          if (paramArrayList == null) {
            localObject2 = "";
          }
          paramArrayList = aw.Gjk;
          paramArrayList = ((FinderObject)localObject3).objectDesc;
          if (paramArrayList != null) {
            break label373;
          }
          paramArrayList = null;
          str2 = aw.e(paramArrayList);
          paramArrayList = ((FinderObject)localObject3).liveInfo;
          if (paramArrayList != null) {
            break label401;
          }
          paramArrayList = "";
          paramString = ((FinderObject)localObject3).liveInfo;
          if (paramString != null) {
            break label422;
          }
          paramString = null;
          if (paramString != null) {
            break label453;
          }
          paramString = e.b.mKf;
          paramInt1 = e.b.bcu();
          str3 = ((FinderObject)localObject3).sessionBuffer;
          paramString = ((FinderObject)localObject3).nickname;
          str1 = paramString;
          if (paramString == null) {
            str1 = "";
          }
          paramString = ((FinderObject)localObject3).liveInfo;
          if (paramString != null) {
            break label462;
          }
          l2 = 0L;
          label294:
          paramString = ((FinderObject)localObject3).liveInfo;
          if (paramString != null) {
            break label472;
          }
          paramString = null;
          label309:
          localObject3 = ((FinderObject)localObject3).liveInfo;
          if (localObject3 != null) {
            break label500;
          }
        }
        label401:
        label422:
        label453:
        label462:
        label472:
        label500:
        for (localObject3 = null;; localObject3 = ((bip)localObject3).ZSn)
        {
          localCollection.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.f(l3, l1, (String)localObject1, (String)localObject2, str2, paramArrayList, paramInt1, str3, str1, l2, paramString, (bgr)localObject3));
          break;
          l1 = paramArrayList.liveId;
          break label150;
          label373:
          paramArrayList = paramArrayList.media;
          if (paramArrayList == null)
          {
            paramArrayList = null;
            break label202;
          }
          paramArrayList = (FinderMedia)kotlin.a.p.oL((List)paramArrayList);
          break label202;
          paramString = paramArrayList.mIE;
          paramArrayList = paramString;
          if (paramString != null) {
            break label222;
          }
          paramArrayList = "";
          break label222;
          paramString = paramString.ZRQ;
          if (paramString == null)
          {
            paramString = null;
            break label237;
          }
          paramString = Integer.valueOf(paramString.mNn);
          break label237;
          paramInt1 = paramString.intValue();
          break label251;
          l2 = paramString.ZFH;
          break label294;
          paramString = paramString.ZOg;
          if (paramString == null)
          {
            paramString = null;
            break label309;
          }
          paramString = paramString.toByteArray();
          break label309;
        }
      }
      paramArrayList = (List)localCollection;
      Log.i(TAG, kotlin.g.b.s.X("appenddata before ", kotlin.a.p.a((Iterable)paramArrayList, null, null, null, 0, null, (kotlin.g.a.b)f.DhW, 31)));
      paramString = ((Iterable)paramArrayList).iterator();
      label641:
      label668:
      label678:
      while (paramString.hasNext())
      {
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.f)paramString.next();
        localObject2 = (List)paramb.CDA;
        paramInt1 = 0;
        localObject2 = ((List)localObject2).iterator();
        label601:
        if (((Iterator)localObject2).hasNext()) {
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.f)((Iterator)localObject2).next()).Ebr.liveId == ((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1).Ebr.liveId)
          {
            paramInt2 = 1;
            if (paramInt2 == 0) {
              break label668;
            }
          }
        }
        for (;;)
        {
          if (paramInt1 != -1) {
            break label678;
          }
          paramb.CDA.add(localObject1);
          break;
          paramInt2 = 0;
          break label641;
          paramInt1 += 1;
          break label601;
          paramInt1 = -1;
        }
      }
      Log.i(TAG, kotlin.g.b.s.X("appenddata after ", kotlin.a.p.a((Iterable)paramArrayList, null, null, null, 0, null, (kotlin.g.a.b)g.DhX, 31)));
      paramb.CDB = ((co)paramp).dVJ();
      paramb.hasMore = ((co)paramp).dVN();
      AppMethodBeat.o(371481);
      return;
    }
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder("invalid because cgi failed. ").append(paramInt1).append(", ").append(paramInt2).append(", ").append(paramp instanceof co).append(", ");
    if ((paramp instanceof co))
    {
      paramString = (co)paramp;
      if (paramString != null) {
        break label851;
      }
      paramString = null;
    }
    for (;;)
    {
      Log.i((String)localObject1, paramString);
      paramArrayList.add(paramb);
      AppMethodBeat.o(371481);
      return;
      paramString = null;
      break;
      label851:
      paramString = paramString.dVP();
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = Integer.valueOf(paramString.size());
      }
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.model.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(355635);
    ah.f localf = new ah.f();
    localf.aqH = new com.tencent.mm.ui.widget.a.f(this.CZa.getContext(), 1, true);
    ((com.tencent.mm.ui.widget.a.f)localf.aqH).Vtg = new bq..ExternalSyntheticLambda4(this);
    ((com.tencent.mm.ui.widget.a.f)localf.aqH).GAC = new bq..ExternalSyntheticLambda5(paramb, this, paramBoolean, localf);
    ((com.tencent.mm.ui.widget.a.f)localf.aqH).aeLi = new bq..ExternalSyntheticLambda8(this);
    ((com.tencent.mm.ui.widget.a.f)localf.aqH).NE(true);
    ((com.tencent.mm.ui.widget.a.f)localf.aqH).h((CharSequence)this.CZa.getContext().getString(p.h.CjP), 17, 0);
    ((com.tencent.mm.ui.widget.a.f)localf.aqH).dDn();
    AppMethodBeat.o(355635);
  }
  
  private static final void a(bq parambq)
  {
    AppMethodBeat.i(371491);
    kotlin.g.b.s.u(parambq, "this$0");
    if (parambq.DhN == null) {
      parambq.DhF.eBt();
    }
    AppMethodBeat.o(371491);
  }
  
  private static final void a(bq parambq, final com.tencent.mm.plugin.finder.live.model.b paramb, DialogInterface paramDialogInterface)
  {
    int i = 1;
    AppMethodBeat.i(371485);
    kotlin.g.b.s.u(parambq, "this$0");
    kotlin.g.b.s.u(paramb, "$jumpInfo");
    Log.i(TAG, "dismiss half dialog");
    parambq.DhN = null;
    paramDialogInterface = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
    paramDialogInterface = com.tencent.mm.plugin.finder.live.sidebar.a.axE(paramb.CDz.ext_info);
    if (paramDialogInterface != null) {
      if (paramDialogInterface.ZPu != 1) {
        break label99;
      }
    }
    for (;;)
    {
      if (i != 0) {
        com.tencent.mm.ae.d.a(2000L, (kotlin.g.a.a)new d(parambq, paramb));
      }
      parambq.DhF.eBt();
      AppMethodBeat.o(371485);
      return;
      label99:
      i = 0;
    }
  }
  
  private static final void a(bq parambq, com.tencent.mm.plugin.finder.live.model.b paramb, ah.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(371494);
    kotlin.g.b.s.u(parambq, "this$0");
    kotlin.g.b.s.u(paramb, "$jumpInfo");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    if (paramMenuItem == null) {}
    for (paramMenuItem = null;; paramMenuItem = Integer.valueOf(paramMenuItem.getItemId()))
    {
      paramInt = DhS;
      if (paramMenuItem != null) {
        break;
      }
      AppMethodBeat.o(371494);
      return;
    }
    if (paramMenuItem.intValue() == paramInt)
    {
      Log.i(TAG, "click dislike banner menu from share menu");
      parambq.a(paramb, false);
      ((com.tencent.mm.ui.widget.a.f)paramf.aqH).cyW();
    }
    AppMethodBeat.o(371494);
  }
  
  private static final void a(bq parambq, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371487);
    kotlin.g.b.s.u(parambq, "this$0");
    params.c(DhS, (CharSequence)parambq.CZa.getContext().getString(p.h.CjQ));
    AppMethodBeat.o(371487);
  }
  
  private static final void a(HashMap paramHashMap, CountDownLatch paramCountDownLatch, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(371482);
    kotlin.g.b.s.u(paramHashMap, "$netSceneMap");
    kotlin.g.b.s.u(paramCountDownLatch, "$countDownLatch");
    paramHashMap = (com.tencent.mm.am.h)paramHashMap.get(paramp);
    if (paramHashMap != null)
    {
      paramHashMap.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      paramCountDownLatch.countDown();
      Log.i(TAG, "countdown " + paramp.hashCode() + ", remain" + paramCountDownLatch.getCount());
    }
    AppMethodBeat.o(371482);
  }
  
  private static boolean a(Html5Info paramHtml5Info)
  {
    return (paramHtml5Info != null) && (paramHtml5Info.style == 1);
  }
  
  private static void axc(String paramString)
  {
    AppMethodBeat.i(355506);
    Log.i(TAG, "reportBannerAction  result:%s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrM, paramString);
      AppMethodBeat.o(355506);
      return;
    }
    localObject = com.tencent.mm.plugin.finder.live.report.k.Doi;
    kotlin.g.b.s.u(paramString, "actionResult");
    com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCN, paramString.toString(), 0L, null, null, null, 60);
    AppMethodBeat.o(355506);
  }
  
  private final void axd(String paramString)
  {
    AppMethodBeat.i(355524);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(355524);
      return;
    }
    if (this.DhM.contains(paramString))
    {
      AppMethodBeat.o(355524);
      return;
    }
    if ((this.mJe.getVisibility() == 8) && (this.CTm == 65535) && (TextUtils.isEmpty((CharSequence)this.DhI)))
    {
      Log.i(TAG, "reportBannerAction 1");
      axc(ex(paramString, 1));
      this.DhM.add(paramString);
      AppMethodBeat.o(355524);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)this.DhI))
    {
      Log.i(TAG, "reportBannerAction 2");
      axc(ex(paramString, 1));
      this.DhM.add(paramString);
      AppMethodBeat.o(355524);
      return;
    }
    if (!n.T(this.DhI, paramString, false))
    {
      Log.i(TAG, "reportBannerAction 3");
      axc(ex(paramString, 1));
      this.DhM.add(paramString);
    }
    AppMethodBeat.o(355524);
  }
  
  private final void axe(String paramString)
  {
    AppMethodBeat.i(355590);
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(355590);
      return;
    }
    if ((this.DhP == null) && (!this.DhO))
    {
      Log.i(TAG, "begin load wv");
      synchronized (this.lock)
      {
        this.DhO = true;
        ah localah = ah.aiuX;
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(355590);
          throw paramString;
        }
      }
      axf(paramString);
    }
    AppMethodBeat.o(355590);
  }
  
  /* Error */
  private final void axf(String arg1)
  {
    // Byte code:
    //   0: ldc_w 1438
    //   3: invokestatic 207	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 1444	com/tencent/mm/plugin/webview/k/l:Xtf	Lcom/tencent/mm/plugin/webview/k/l;
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 1448	com/tencent/mm/plugin/webview/k/l:bmX	(Ljava/lang/String;)Z
    //   14: ifeq +78 -> 92
    //   17: ldc_w 1450
    //   20: invokestatic 1454	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   23: checkcast 1450	com/tencent/mm/api/ab
    //   26: new 1456	android/content/MutableContextWrapper
    //   29: dup
    //   30: aload_0
    //   31: getfield 290	com/tencent/mm/plugin/finder/live/plugin/bq:CZa	Landroid/view/ViewGroup;
    //   34: invokevirtual 311	android/view/ViewGroup:getContext	()Landroid/content/Context;
    //   37: invokespecial 1459	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   40: checkcast 1136	android/content/Context
    //   43: invokestatic 1465	com/tencent/mm/ui/widget/MMWebView$a:nL	(Landroid/content/Context;)Lcom/tencent/mm/ui/widget/MMWebView;
    //   46: new 1467	com/tencent/mm/plugin/webview/core/BaseWebViewController$d
    //   49: dup
    //   50: aconst_null
    //   51: iconst_0
    //   52: iconst_0
    //   53: iconst_0
    //   54: iconst_0
    //   55: iconst_0
    //   56: bipush 105
    //   58: invokespecial 1470	com/tencent/mm/plugin/webview/core/BaseWebViewController$d:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$g;ZZZZZI)V
    //   61: aconst_null
    //   62: invokeinterface 1473 4 0
    //   67: astore_2
    //   68: getstatic 1444	com/tencent/mm/plugin/webview/k/l:Xtf	Lcom/tencent/mm/plugin/webview/k/l;
    //   71: astore_3
    //   72: aload_2
    //   73: ldc_w 1475
    //   76: invokestatic 335	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   79: aload_1
    //   80: aload_2
    //   81: invokestatic 1478	com/tencent/mm/plugin/webview/k/l:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V
    //   84: aload_0
    //   85: aload_2
    //   86: checkcast 1480	com/tencent/mm/plugin/webview/core/k
    //   89: putfield 520	com/tencent/mm/plugin/finder/live/plugin/bq:DhP	Lcom/tencent/mm/plugin/webview/core/k;
    //   92: aload_0
    //   93: getfield 353	com/tencent/mm/plugin/finder/live/plugin/bq:lock	Ljava/lang/Object;
    //   96: astore_1
    //   97: aload_1
    //   98: monitorenter
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield 1430	com/tencent/mm/plugin/finder/live/plugin/bq:DhO	Z
    //   104: getstatic 705	kotlin/ah:aiuX	Lkotlin/ah;
    //   107: astore_2
    //   108: aload_1
    //   109: monitorexit
    //   110: getstatic 272	com/tencent/mm/plugin/finder/live/plugin/bq:TAG	Ljava/lang/String;
    //   113: ldc_w 1482
    //   116: invokestatic 469	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: ldc_w 1438
    //   122: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: astore_1
    //   127: getstatic 272	com/tencent/mm/plugin/finder/live/plugin/bq:TAG	Ljava/lang/String;
    //   130: aload_1
    //   131: ldc_w 346
    //   134: iconst_0
    //   135: anewarray 350	java/lang/Object
    //   138: invokestatic 577	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: getstatic 1444	com/tencent/mm/plugin/webview/k/l:Xtf	Lcom/tencent/mm/plugin/webview/k/l;
    //   144: astore_1
    //   145: invokestatic 1485	com/tencent/mm/plugin/webview/k/l:clear	()V
    //   148: goto -56 -> 92
    //   151: astore_2
    //   152: aload_1
    //   153: monitorexit
    //   154: ldc_w 1438
    //   157: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_2
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	bq
    //   9	99	2	localObject1	Object
    //   151	10	2	localObject2	Object
    //   71	1	3	locall	com.tencent.mm.plugin.webview.k.l
    // Exception table:
    //   from	to	target	type
    //   6	92	126	finally
    //   99	108	151	finally
  }
  
  private static final void b(bq parambq)
  {
    AppMethodBeat.i(371495);
    kotlin.g.b.s.u(parambq, "this$0");
    if (parambq.DhN == null) {
      parambq.DhF.eBt();
    }
    AppMethodBeat.o(371495);
  }
  
  private static final void b(bq parambq, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(371493);
    kotlin.g.b.s.u(parambq, "this$0");
    params.a(DhS, (CharSequence)parambq.CZa.getContext().getString(p.h.CjQ), p.g.finder_feed_dislike);
    AppMethodBeat.o(371493);
  }
  
  private final ArrayList<com.tencent.mm.plugin.finder.live.model.b> erA()
  {
    AppMethodBeat.i(355562);
    if (this.DhG.isEmpty())
    {
      AppMethodBeat.o(355562);
      return null;
    }
    ArrayList localArrayList;
    for (;;)
    {
      synchronized (this.lock)
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.DhG.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        com.tencent.mm.plugin.finder.live.model.b localb = (com.tencent.mm.plugin.finder.live.model.b)localIterator.next();
        Object localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
        localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.axE(localb.CDz.ext_info);
        if (localObject1 == null) {
          continue;
        }
        com.tencent.d.a.a.a.d.d locald = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveDislikeBannerStorage();
        String str = ((bfn)localObject1).id;
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        if (locald.axH((String)localObject1)) {
          continue;
        }
        localObject1 = localb.CDz.native_info;
        if ((localObject1 != null) && (((NativeInfo)localObject1).native_type == 9))
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          localArrayList.add(localb);
        }
      }
      int i = 0;
    }
    AppMethodBeat.o(355562);
    return localArrayList;
  }
  
  private final String erB()
  {
    AppMethodBeat.i(355625);
    String str = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC;
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      str = z.bAW();
      kotlin.g.b.s.s(str, "getMyFinderUsername()");
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).putOpt("finderId", str);
    ((JSONObject)localObject).putOpt("liveId", Long.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
    Log.i(TAG, "getBannerHalfParam:%s", new Object[] { ((JSONObject)localObject).toString() });
    str = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(str, "obj.toString()");
    AppMethodBeat.o(355625);
    return str;
  }
  
  private final void ery()
  {
    AppMethodBeat.i(355541);
    if (this.DhJ)
    {
      Log.i(TAG, "banner is closed by user");
      tO(8);
      AppMethodBeat.o(355541);
      return;
    }
    com.tencent.mm.plugin.finder.live.model.b localb = erz();
    if (localb == null)
    {
      Log.i(TAG, "updateBanner bannerInfo is null");
      tO(8);
      AppMethodBeat.o(355541);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
    localObject1 = localb.CDz;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.axE((String)localObject1);
      if (localObject1 != null) {
        break label154;
      }
      localObject1 = "";
    }
    label154:
    Object localObject2;
    for (;;)
    {
      axd((String)localObject1);
      if (!kotlin.g.b.s.p(this.DhH, localb)) {
        break label172;
      }
      if (this.DhK < 5)
      {
        this.DhF.ery();
        this.DhK += 1;
      }
      AppMethodBeat.o(355541);
      return;
      localObject1 = ((FinderJumpInfo)localObject1).ext_info;
      break;
      localObject2 = ((bfn)localObject1).id;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    label172:
    this.DhK = 0;
    localObject1 = localb.CDz;
    int i;
    label252:
    bfn localbfn;
    if (localObject1 != null)
    {
      localObject1 = ((FinderJumpInfo)localObject1).native_info;
      if ((localObject1 != null) && (((NativeInfo)localObject1).native_type == 9))
      {
        i = 1;
        if (i == 0) {
          break label595;
        }
        this.DhH = localb;
        this.DhF.setJumpInfo(this.DhH);
        this.DhL.clear();
        localObject1 = this.DhF;
        if (localObject1 != null) {
          ((FinderLivePromoteBannerWidget)localObject1).ar(this.DhL);
        }
        localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
        localObject1 = this.DhH;
        if (localObject1 != null) {
          break label818;
        }
        localObject1 = null;
        label267:
        localbfn = com.tencent.mm.plugin.finder.live.sidebar.a.axE((String)localObject1);
        if (localbfn != null) {
          break label840;
        }
        localObject1 = "";
        label282:
        this.DhI = ((String)localObject1);
        this.DhF.ery();
        tO(0);
        localObject1 = (bh)getPlugin(bh.class);
        if ((localObject1 == null) || (((com.tencent.mm.live.b.a)localObject1).mJe.getVisibility() != 0)) {
          break label859;
        }
        i = 1;
        label326:
        if ((i != 0) && (localObject1 != null)) {
          ((bh)localObject1).erq();
        }
        label402:
        if ((this.DhH != null) && (localbfn != null))
        {
          localObject1 = this.DhH;
          if (localObject1 != null) {
            break label864;
          }
          localObject1 = null;
          label361:
          if (localObject1 != null)
          {
            localObject1 = this.DhH;
            if (localObject1 != null) {
              break label886;
            }
            localObject1 = null;
            label376:
            if (a((Html5Info)localObject1))
            {
              i = localbfn.ZPu;
              localObject1 = this.DhH;
              if (localObject1 != null) {
                break label908;
              }
              localObject1 = "";
              if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (this.DhP == null))
              {
                localObject2 = com.tencent.mm.plugin.webview.k.l.Xtf;
                if (com.tencent.mm.plugin.webview.k.l.bmX((String)localObject1))
                {
                  Log.i(TAG, "need preload webview");
                  axe((String)localObject1);
                }
              }
            }
          }
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = this.CZa.getContext();
        kotlin.g.b.s.s(localObject1, "entranceRoot.context");
        localObject1 = com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
        kotlin.g.b.s.s(localObject1, "UICProvider.of(entranceR…veSideBarUIC::class.java)");
        localObject2 = (com.tencent.mm.plugin.finder.live.sidebar.d)localObject1;
        if (((com.tencent.mm.plugin.finder.live.sidebar.d)localObject2).DGD) {
          break label1006;
        }
        if ((localb.CDA.size() <= 0) || (isLandscape())) {
          break label963;
        }
        Log.i(TAG, kotlin.g.b.s.X("mount, sideBarList size:", Integer.valueOf(localb.CDA.size())));
        localObject1 = eoH();
        if (!(localObject1 instanceof FinderLiveVisitorPluginLayout)) {
          break label958;
        }
        localObject1 = (FinderLiveVisitorPluginLayout)localObject1;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = ((FinderLiveVisitorPluginLayout)localObject1).getData();
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject2).a((com.tencent.mm.plugin.finder.live.viewmodel.data.f)localObject1, localb);
          ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject2).DGH.etH();
          AppMethodBeat.o(355541);
          return;
          i = 0;
          break;
          label595:
          this.DhF.setJumpInfo(null);
          localObject1 = erA();
          this.DhL.clear();
          localObject2 = (Collection)localObject1;
          if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
          {
            i = 1;
            label635:
            if (i == 0) {
              this.DhL.addAll((Collection)localObject1);
            }
            localObject2 = this.DhL;
            localObject1 = this.DhF;
            if (localObject1 != null) {
              break label700;
            }
            localObject1 = null;
          }
          for (;;)
          {
            if (g((ArrayList)localObject2, (ArrayList)localObject1))
            {
              if (this.DhL.size() == 1)
              {
                this.DhH = localb;
                break;
                i = 0;
                break label635;
                label700:
                localObject1 = ((FinderLivePromoteBannerWidget)localObject1).getLoopDataList();
                continue;
              }
              if (this.DhL.size() <= 1) {
                break;
              }
              localObject1 = this.DhF;
              if (localObject1 == null) {}
              for (localObject1 = null;; localObject1 = Integer.valueOf(((FinderLivePromoteBannerWidget)localObject1).getLoopDisplayIndex()))
              {
                i = ((Integer)localObject1).intValue();
                if ((i >= this.DhL.size()) || (i < 0)) {
                  break;
                }
                this.DhH = ((com.tencent.mm.plugin.finder.live.model.b)this.DhL.get(i));
                break;
              }
            }
          }
          this.DhH = localb;
          localObject1 = this.DhF;
          if (localObject1 != null) {
            ((FinderLivePromoteBannerWidget)localObject1).eBs();
          }
          localObject1 = this.DhF;
          if (localObject1 == null) {
            break label252;
          }
          ((FinderLivePromoteBannerWidget)localObject1).ar(this.DhL);
          break label252;
          label818:
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label267;
          }
          localObject1 = ((FinderJumpInfo)localObject1).ext_info;
          break label267;
          label840:
          localObject2 = localbfn.id;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label282;
          }
          localObject1 = "";
          break label282;
          label859:
          i = 0;
          break label326;
          label864:
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label361;
          }
          localObject1 = ((FinderJumpInfo)localObject1).html5_info;
          break label361;
          label886:
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label376;
          }
          localObject1 = ((FinderJumpInfo)localObject1).html5_info;
          break label376;
          label908:
          localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz;
          if (localObject1 == null)
          {
            localObject1 = "";
            break label402;
          }
          localObject1 = ((FinderJumpInfo)localObject1).html5_info;
          if (localObject1 == null)
          {
            localObject1 = "";
            break label402;
          }
          localObject2 = ((Html5Info)localObject1).url;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label402;
          }
          localObject1 = "";
          break label402;
          label958:
          localObject1 = null;
          continue;
          label963:
          Log.i(TAG, "not mount, because isLandscape():" + isLandscape() + ", size:" + localb.CDA.size());
        }
      }
    }
    label1006:
    AppMethodBeat.o(355541);
  }
  
  private final com.tencent.mm.plugin.finder.live.model.b erz()
  {
    AppMethodBeat.i(355553);
    if (this.DhG.isEmpty())
    {
      AppMethodBeat.o(355553);
      return null;
    }
    ArrayList localArrayList;
    com.tencent.mm.plugin.finder.live.model.b localb;
    synchronized (this.lock)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.DhG.iterator();
      bfn localbfn;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localb = (com.tencent.mm.plugin.finder.live.model.b)localIterator.next();
        localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
        localbfn = com.tencent.mm.plugin.finder.live.sidebar.a.axE(localb.CDz.ext_info);
      } while (localbfn == null);
      com.tencent.d.a.a.a.d.d locald = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveDislikeBannerStorage();
      String str = localbfn.id;
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      if (locald.axH((String)localObject1))
      {
        localArrayList.add(localb);
        Log.e(TAG, "getCurrentShowFinderJumpInfo id:%s is marked dis, should be removed", new Object[] { localbfn.id });
      }
    }
    if (!localArrayList.isEmpty())
    {
      Log.i(TAG, "getCurrentShowFinderJumpInfo remove list size:%d", new Object[] { Integer.valueOf(localArrayList.size()) });
      this.DhG.removeAll((Collection)localArrayList);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp.removeAll((Collection)localArrayList);
    }
    if (isLandscape())
    {
      localObject3 = localb.CDz.native_info;
      if ((localObject3 != null) && (((NativeInfo)localObject3).native_type == 9)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i(TAG, "sidebar not show when landscape");
        AppMethodBeat.o(355553);
        return null;
      }
    }
    AppMethodBeat.o(355553);
    return localb;
    if (!localArrayList.isEmpty())
    {
      Log.i(TAG, "getCurrentShowFinderJumpInfo remove list size:%d", new Object[] { Integer.valueOf(localArrayList.size()) });
      this.DhG.removeAll((Collection)localArrayList);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp.removeAll((Collection)localArrayList);
    }
    Object localObject3 = ah.aiuX;
    AppMethodBeat.o(355553);
    return null;
  }
  
  private static String ex(String paramString, int paramInt)
  {
    AppMethodBeat.i(355515);
    JSONObject localJSONObject = new JSONObject();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localJSONObject.putOpt("bannerid", str);
    localJSONObject.putOpt("type", Integer.valueOf(paramInt));
    paramString = localJSONObject.toString();
    kotlin.g.b.s.s(paramString, "obj.toString()");
    AppMethodBeat.o(355515);
    return paramString;
  }
  
  private static final ah g(b.a parama)
  {
    AppMethodBeat.i(371484);
    if ((parama.errType != 0) || (parama.errCode != 0)) {
      Log.e(TAG, "ljd do CgiFinderLiveDislikeBanner fail errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    }
    parama = ah.aiuX;
    AppMethodBeat.o(371484);
    return parama;
  }
  
  private static boolean g(ArrayList<com.tencent.mm.plugin.finder.live.model.b> paramArrayList1, ArrayList<com.tencent.mm.plugin.finder.live.model.b> paramArrayList2)
  {
    AppMethodBeat.i(355571);
    if ((paramArrayList1.isEmpty()) || (paramArrayList2.isEmpty()))
    {
      AppMethodBeat.o(355571);
      return false;
    }
    if (paramArrayList1.size() != paramArrayList2.size())
    {
      AppMethodBeat.o(355571);
      return false;
    }
    int k = paramArrayList1.size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject1 = paramArrayList1.get(i);
      kotlin.g.b.s.s(localObject1, "new[index]");
      localObject1 = (com.tencent.mm.plugin.finder.live.model.b)localObject1;
      Object localObject2 = paramArrayList2.get(i);
      kotlin.g.b.s.s(localObject2, "old[index]");
      localObject2 = (com.tencent.mm.plugin.finder.live.model.b)localObject2;
      if ((((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz == null) || (((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz.ext_info == null) || (((com.tencent.mm.plugin.finder.live.model.b)localObject2).CDz == null) || (((com.tencent.mm.plugin.finder.live.model.b)localObject2).CDz.ext_info == null))
      {
        AppMethodBeat.o(355571);
        return false;
      }
      if (!n.T(((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz.ext_info, ((com.tencent.mm.plugin.finder.live.model.b)localObject2).CDz.ext_info, false))
      {
        AppMethodBeat.o(355571);
        return false;
      }
      if (j >= k)
      {
        AppMethodBeat.o(355571);
        return true;
      }
    }
  }
  
  private final void gC(List<com.tencent.mm.plugin.finder.live.model.b> paramList)
  {
    AppMethodBeat.i(355579);
    synchronized (this.lock)
    {
      this.DhG.clear();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp.clear();
      Log.i(TAG, "result or jump_infos size is %d", new Object[] { Integer.valueOf(paramList.size()) });
      if (!paramList.isEmpty())
      {
        this.DhG.addAll((Collection)paramList);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edp.addAll((Collection)paramList);
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          com.tencent.mm.plugin.finder.live.model.b localb = (com.tencent.mm.plugin.finder.live.model.b)paramList.next();
          Log.i(TAG, "wording:%s, businessType:%d, jumpType:%d, extInfo:%s", new Object[] { localb.CDz.wording, Integer.valueOf(localb.CDz.business_type), Integer.valueOf(localb.CDz.jumpinfo_type), localb.CDz.ext_info });
        }
      }
    }
    paramList = ah.aiuX;
    AppMethodBeat.o(355579);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(355951);
    ery();
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edq) && (this.DhH != null) && (!isLandscape()))
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edq = false;
      Log.i(TAG, "jump from landscape click");
      Context localContext = this.CZa.getContext();
      kotlin.g.b.s.s(localContext, "entranceRoot.context");
      com.tencent.mm.plugin.finder.live.model.b localb = this.DhH;
      kotlin.g.b.s.checkNotNull(localb);
      a(localContext, localb);
    }
    AppMethodBeat.o(355951);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean erx()
  {
    AppMethodBeat.i(355945);
    if (this.DhJ)
    {
      AppMethodBeat.o(355945);
      return false;
    }
    if (erz() != null)
    {
      AppMethodBeat.o(355945);
      return true;
    }
    AppMethodBeat.o(355945);
    return false;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(356007);
    super.mount();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.CZa.getContext();
    kotlin.g.b.s.s(localObject, "entranceRoot.context");
    localObject = com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(entranceR…veSideBarUIC::class.java)");
    localObject = (com.tencent.mm.plugin.finder.live.sidebar.d)localObject;
    if (!((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGD)
    {
      if (this.isStarted)
      {
        Log.i(TAG, "startPollingBannerData is done");
        AppMethodBeat.o(356007);
        return;
      }
      if (!this.DhG.isEmpty())
      {
        Log.i(TAG, "bannerJumpInfosList is not empty, return");
        AppMethodBeat.o(356007);
        return;
      }
      Log.i(TAG, "startPollingBannerData");
      this.isStarted = true;
      localObject = new bwu();
      aj localaj = aj.CGT;
      aj.elm().a(3, (com.tencent.mm.bx.a)localObject, (af.c)new h(this, bwv.class));
      AppMethodBeat.o(356007);
      return;
    }
    gC((List)((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGG);
    AppMethodBeat.o(356007);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(355967);
    super.onConfigurationChanged(paramConfiguration);
    Log.i(TAG, "onConfigurationChanged");
    AppMethodBeat.o(355967);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(355982);
    kotlin.g.b.s.u(paramc, "status");
    switch (bq.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355982);
      return;
      eoD();
      AppMethodBeat.o(355982);
      return;
      if ((paramBundle != null) && (!paramBundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", false)))
      {
        paramc = this.activity.getIntent().getByteArrayExtra("FINDER_JUMP_INFO_WITH_OUTSIDE");
        if (paramc != null)
        {
          int i;
          if (paramc.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label174;
            }
            i = j;
            label113:
            if (i == 0) {
              break label179;
            }
          }
          for (;;)
          {
            if (paramc != null)
            {
              this.activity.getIntent().removeExtra("FINDER_JUMP_INFO_WITH_OUTSIDE");
              paramc = new bcg().parseFrom(paramc);
              if (paramc == null)
              {
                paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderJumpInfoWithOutside");
                AppMethodBeat.o(355982);
                throw paramc;
                i = 0;
                break;
                label174:
                i = 0;
                break label113;
                label179:
                paramc = null;
                continue;
              }
              Object localObject = (bcg)paramc;
              paramBundle = ((bcg)localObject).ZNm;
              paramc = paramBundle;
              if (paramBundle == null) {
                paramc = new FinderJumpInfo();
              }
              paramc = new com.tencent.mm.plugin.finder.live.model.b(paramc);
              paramBundle = new ArrayList();
              localObject = ((bcg)localObject).ZIQ;
              kotlin.g.b.s.s(localObject, "outsideData.objects");
              localObject = ((Iterable)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                FinderObject localFinderObject = (FinderObject)((Iterator)localObject).next();
                kotlin.g.b.s.s(localFinderObject, "fo");
                paramBundle.add(new com.tencent.mm.plugin.finder.live.viewmodel.data.f(localFinderObject));
              }
              paramc.CDA.addAll((Collection)paramBundle);
              this.akfh = kotlinx.coroutines.j.a(this.mainScope, null, null, (m)new bq.i(this, paramc, null), 3);
            }
          }
        }
      }
      eoD();
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(355992);
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).isLiveStarted()) && (paramInt == 0))
    {
      Object localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((ap)localObject).at((View)this.CZa, paramInt);
        AppMethodBeat.o(355992);
      }
    }
    else
    {
      super.tO(paramInt);
    }
    AppMethodBeat.o(355992);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(356011);
    super.unMount();
    Log.i(TAG, "unMount");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.CZa.getContext();
    kotlin.g.b.s.s(localObject, "entranceRoot.context");
    localObject = (com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
    if (!((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGD)
    {
      com.tencent.mm.plugin.finder.live.model.b localb = this.DhH;
      if ((localb != null) && (((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGG.contains(localb))) {
        ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).unMount();
      }
    }
    this.isStarted = false;
    this.DhP = null;
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edq)
    {
      Log.i(TAG, "landscape click don't clear webview controller");
      if (com.tencent.mm.plugin.webview.k.l.Xtf != null) {
        com.tencent.mm.plugin.webview.k.l.clear();
      }
    }
    this.DhJ = false;
    this.isStarted = false;
    this.lastClickTime = 0L;
    this.DhG.clear();
    this.DhI = "";
    localObject = this.DhF;
    if (localObject != null) {
      ((FinderLivePromoteBannerWidget)localObject).eBu();
    }
    localObject = this.DhF;
    if (localObject != null)
    {
      ((FinderLivePromoteBannerWidget)localObject).Etw.clear();
      ((FinderLivePromoteBannerWidget)localObject).eBs();
    }
    this.DhL.clear();
    this.DhM.clear();
    this.activity.getIntent().removeExtra("FINDER_JUMP_INFO_WITH_OUTSIDE");
    localObject = this.akfh;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    AppMethodBeat.o(356011);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin$bannerJumpImpl$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewHalfScreenCallback;", "onMenuClick", "", "url", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.webview.ui.tools.widget.u
  {
    c(bq parambq, com.tencent.mm.plugin.finder.live.model.b paramb) {}
    
    public final void dcJ()
    {
      AppMethodBeat.i(353755);
      bq.a locala = bq.DhE;
      Log.i(bq.access$getTAG$cp(), "onMenuClick");
      bq.a(this.DhT, paramb);
      AppMethodBeat.o(353755);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(bq parambq, com.tencent.mm.plugin.finder.live.model.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.f, CharSequence>
  {
    public static final f DhW;
    
    static
    {
      AppMethodBeat.i(353761);
      DhW = new f();
      AppMethodBeat.o(353761);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.data.f, CharSequence>
  {
    public static final g DhX;
    
    static
    {
      AppMethodBeat.i(353731);
      DhX = new g();
      AppMethodBeat.o(353731);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLivePromoteBannerPlugin$startPollingBannerData$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protocal/protobuf/FinderSyncBannerInfoResp;", "onPollingSuccess", "", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends af.c<bwv>
  {
    h(bq parambq, Class<bwv> paramClass)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(bq parambq)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bq
 * JD-Core Version:    0.7.0.1
 */