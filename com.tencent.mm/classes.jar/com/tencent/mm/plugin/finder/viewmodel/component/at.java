package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.d.a.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.br;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.ba;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.ui.FinderExposeUI;
import com.tencent.mm.plugin.finder.ui.FinderFollowListUI;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.view.e.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "autoShow", "", "getAutoShow", "()Z", "setAutoShow", "(Z)V", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "enterTimeStamp", "", "getEnterTimeStamp", "()J", "setEnterTimeStamp", "(J)V", "finderCanPostNoContact", "Landroid/widget/TextView;", "finderLiveCanPostNoContact", "finderLivePosBtn", "Landroid/view/View;", "finderLivePostNewFeed", "finderPosBtn", "finderPostNewFeed", "finderRedPackEntrance", "hasExposeCreatorEntranceTips", "", "getHasExposeCreatorEntranceTips", "()Ljava/lang/String;", "setHasExposeCreatorEntranceTips", "(Ljava/lang/String;)V", "hasExposeFinderHiMsgTips", "getHasExposeFinderHiMsgTips", "setHasExposeFinderHiMsgTips", "hasExposeFinderMsgTips", "getHasExposeFinderMsgTips", "setHasExposeFinderMsgTips", "hasExposeLiveEntranceTips", "getHasExposeLiveEntranceTips", "setHasExposeLiveEntranceTips", "hasExposeLiveIncomeEntranceTips", "getHasExposeLiveIncomeEntranceTips", "setHasExposeLiveIncomeEntranceTips", "hasExposeProfileEntranceTips", "getHasExposeProfileEntranceTips", "setHasExposeProfileEntranceTips", "hasExposeWXMsgTips", "getHasExposeWXMsgTips", "setHasExposeWXMsgTips", "hasReportFinderMsg", "getHasReportFinderMsg", "setHasReportFinderMsg", "isEnableSendMsgEntrance", "isFromSnsPost", "isReportRedDotExpose", "lastFavTipsId", "livePostHelper", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostHelper;", "livePostUic", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;", "getLivePostUic", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;", "livePostUic$delegate", "Lkotlin/Lazy;", "myFinderUsername", "needDonePostAction", "getNeedDonePostAction", "setNeedDonePostAction", "postItemMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/PostActionSheet;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "progressBar", "Landroid/widget/ProgressBar;", "redDotExistOnEnter", "getRedDotExistOnEnter", "setRedDotExistOnEnter", "accountAbnormal", "", "hasContactContainer", "noContactContainer", "canPostButNoAccountUi", "canPostButRevingUi", "checkAutoShowPost", "checkTeenMode", "checkUserState", "doClickPostAction", "doPrepareUser", "doReviewJump", "prepareResponse", "getEntranceType", "getLayoutId", "getWXMsgCount", "getWxFinderPrivateMsgRedDotCount", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "scene", "initLiveRewardGainCell", "initPostBtn", "initPosterEntrance", "initView", "noPostQualityUI", "normalOrAbNomalUi", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "refreshSelf", "reportTabExposure", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends UIComponent
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.api.k
{
  public static final a GTB;
  private static String GTZ;
  private bys AwM;
  private HashMap<Integer, efo> Bsq;
  private final kotlin.j FcH;
  private String GTC;
  private boolean GTD;
  private com.tencent.mm.plugin.findersdk.a.aw GTE;
  private View GTF;
  private TextView GTG;
  private TextView GTH;
  private View GTI;
  private TextView GTJ;
  private TextView GTK;
  private View GTL;
  private boolean GTM;
  private boolean GTN;
  private boolean GTO;
  private String GTP;
  private String GTQ;
  private String GTR;
  private String GTS;
  private String GTT;
  private String GTU;
  private boolean GTV;
  private final boolean GTW;
  private boolean GTX;
  private String GTY;
  private String Gms;
  private ProgressBar progressBar;
  private long zVt;
  
  static
  {
    AppMethodBeat.i(338675);
    GTB = new a((byte)0);
    GTZ = "";
    AppMethodBeat.o(338675);
  }
  
  public at(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338113);
    this.Bsq = new HashMap();
    this.GTP = "";
    this.GTQ = "";
    this.GTR = "";
    this.GTS = "";
    this.GTT = "";
    this.GTU = "";
    this.Gms = "";
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eTo().bmg()).intValue() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.GTW = bool;
      this.FcH = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
      this.GTY = "";
      AppMethodBeat.o(338113);
      return;
    }
  }
  
  private static final void a(int paramInt, at paramat, com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq, View paramView)
  {
    AppMethodBeat.i(338611);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramat);
    localb.cH(paramp);
    localb.cH(parambxq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    int i;
    if (paramInt > 0)
    {
      paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
        break label443;
      }
      i = 0;
      if (paramInt > 0)
      {
        paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramView = as.GSQ;
        paramView = as.a.hu((Context)paramat.getActivity());
        if (paramView != null) {
          break label449;
        }
        paramView = null;
        label146:
        com.tencent.mm.plugin.finder.report.z.a("4", 1, 2, 5, i, paramInt, null, null, 0L, paramView, 0, 0, 3520);
      }
    }
    label206:
    boolean bool1;
    if ((paramp != null) && (parambxq != null))
    {
      localObject = w.FrV;
      paramView = as.GSQ;
      paramView = as.a.hu((Context)paramat.getActivity());
      if (paramView == null)
      {
        paramView = null;
        w.a((w)localObject, "4", paramp, parambxq, 2, paramView, 0, null, 0, 480);
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("AuthorProfileNotify");
      }
    }
    else
    {
      paramp = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramp = (Context)paramat.getActivity();
      long l = paramat.zVt;
      boolean bool2 = paramat.GTM;
      if (paramInt <= 0) {
        break label469;
      }
      bool1 = true;
      label274:
      com.tencent.mm.plugin.finder.report.z.a(paramp, l, bool2, 2L, 5L, bool1, paramInt);
      paramp = new Intent();
      parambxq = com.tencent.mm.plugin.finder.api.d.AwY;
      parambxq = d.a.auT(com.tencent.mm.model.z.bAW());
      kotlin.g.b.s.checkNotNull(parambxq);
      if (!parambxq.isBlock()) {
        break label475;
      }
      paramp.setClass((Context)paramat.getActivity(), FinderExposeUI.class);
      paramat = paramat.getActivity();
      paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
      com.tencent.mm.hellhoundlib.a.a.b(paramat, paramp.aYi(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "normalOrAbNomalUi$lambda-56", "(ILcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramat.startActivity((Intent)paramp.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramat, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "normalOrAbNomalUi$lambda-56", "(ILcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338611);
      return;
      label443:
      i = 2;
      break;
      label449:
      paramView = paramView.fou();
      break label146;
      paramView = paramView.fou();
      break label206;
      label469:
      bool1 = false;
      break label274;
      label475:
      parambxq = as.GSQ;
      as.a.a((Context)paramat.getActivity(), paramp, 0L, 0, false, 124);
      parambxq = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ao((Context)paramat.getActivity(), paramp);
    }
  }
  
  private static final void a(int paramInt1, String paramString1, at paramat, String paramString2, MenuItem paramMenuItem, int paramInt2)
  {
    Object localObject = null;
    AppMethodBeat.i(338656);
    kotlin.g.b.s.u(paramString1, "$clickId");
    kotlin.g.b.s.u(paramat, "this$0");
    kotlin.g.b.s.u(paramString2, "$postId");
    Intent localIntent = new Intent();
    if (paramMenuItem.getItemId() == 1001)
    {
      paramMenuItem = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.aP(paramInt1, false);
      paramMenuItem = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.azR(paramString1);
      localIntent.putExtra("key_finder_post_router", 2);
      paramString1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramString1 = as.GSQ;
      paramString1 = as.a.hu((Context)paramat.getContext());
      if (paramString1 == null)
      {
        paramString1 = null;
        com.tencent.mm.plugin.finder.report.z.b(1, "post_acionsheet_camera", "", paramString1);
      }
    }
    label316:
    do
    {
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        localIntent.putExtra("key_finder_post_id", paramString2);
        paramString1 = com.tencent.mm.plugin.finder.utils.u.GgT;
        com.tencent.mm.plugin.finder.utils.u.a((Context)paramat.getActivity(), localIntent, 132, 9);
        paramString1 = com.tencent.mm.plugin.finder.utils.a.GfO;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramat.getActivity(), localIntent);
        AppMethodBeat.o(338656);
        return;
        paramString1 = paramString1.fou();
        break;
        if (paramMenuItem.getItemId() == 1002)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.report.v.FrN;
          com.tencent.mm.plugin.finder.report.v.aP(paramInt1, false);
          paramMenuItem = com.tencent.mm.plugin.finder.report.v.FrN;
          com.tencent.mm.plugin.finder.report.v.azR(paramString1);
          localIntent.putExtra("key_finder_post_router", 3);
          localIntent.putExtra("key_maas_entrance", 1);
          paramString1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          paramString1 = as.GSQ;
          paramString1 = as.a.hu((Context)paramat.getContext());
          if (paramString1 == null) {}
          for (paramString1 = localObject;; paramString1 = paramString1.fou())
          {
            com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_album", "", paramString1);
            break;
          }
        }
        if (paramMenuItem.getItemId() != 1031) {
          break label316;
        }
        localIntent.putExtra("key_finder_post_router", 16);
      }
    } while (!paramat.Bsq.containsKey(Integer.valueOf(paramMenuItem.getItemId())));
    paramString1 = am.GhD;
    am.a((Context)paramat.getActivity(), (efo)paramat.Bsq.get(Integer.valueOf(paramMenuItem.getItemId())));
    paramString1 = com.tencent.mm.plugin.finder.report.v.FrN;
    if (paramat.GTV) {}
    for (paramInt1 = 4;; paramInt1 = 3)
    {
      com.tencent.mm.plugin.finder.report.v.aP(paramInt1, false);
      break;
    }
  }
  
  private static final void a(Intent paramIntent, at paramat)
  {
    AppMethodBeat.i(338592);
    paramIntent.putExtra("finder_username", paramat.GTC);
    paramIntent.putExtra("KEY_FINDER_SELF_FLAG", true);
    paramIntent.putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
    as.a locala = as.GSQ;
    as.a.a((Context)paramat.getActivity(), paramIntent, 0L, 0, false, 124);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)paramat.getActivity(), paramIntent);
    AppMethodBeat.o(338592);
  }
  
  private static final void a(l.a parama, at paramat, View paramView)
  {
    AppMethodBeat.i(338560);
    kotlin.g.b.s.u(paramat, "this$0");
    Object localObject2;
    if (parama != null)
    {
      parama = parama.ASh;
      if (parama != null)
      {
        parama = parama.ASz;
        if (parama != null)
        {
          paramView = parama.aabJ;
          if (paramView != null)
          {
            parama = new dou();
            parama.parseFrom(paramView.toByteArray());
            paramView = parama.aaVE;
            localObject1 = parama.YBQ;
            if ((paramView != null) && (localObject1 != null))
            {
              localObject2 = com.tencent.mm.plugin.finder.utils.a.GfO;
              localObject2 = (Context)paramat.getContext();
              int i = parama.YBS;
              parama = com.tencent.mm.plugin.finder.storage.d.FAy;
              com.tencent.mm.plugin.finder.utils.a.a((Context)localObject2, paramView, (String)localObject1, i, "", (Boolean)com.tencent.mm.plugin.finder.storage.d.eWh().bmg());
            }
            parama = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.bB(2, "");
          }
        }
      }
    }
    paramView = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("CreateFinderEntrance");
    Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("CreateFinderEntrance");
    if ((localObject1 != null) && (paramView != null))
    {
      localObject2 = w.FrV;
      parama = as.GSQ;
      parama = as.a.hu((Context)paramat.getActivity());
      if (parama != null) {
        break label236;
      }
    }
    label236:
    for (parama = null;; parama = parama.fou())
    {
      w.a((w)localObject2, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, paramView, 2, parama, 0, null, 0, 480);
      AppMethodBeat.o(338560);
      return;
    }
  }
  
  private static final void a(at paramat)
  {
    AppMethodBeat.i(338319);
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.efU();
    AppMethodBeat.o(338319);
  }
  
  private static final void a(at paramat, View paramView)
  {
    AppMethodBeat.i(338330);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = new Intent();
    localObject = as.GSQ;
    as.a.a((Context)paramat.getActivity(), paramView, 0L, 0, false, 124);
    paramView.setClass((Context)paramat.getActivity(), FinderFollowListUI.class);
    localObject = paramat.getActivity();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "initView$lambda-2", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((AppCompatActivity)localObject).startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "initView$lambda-2", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a((Context)paramat.getActivity(), paramat.zVt, paramat.GTM, 2L, 1L, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338330);
  }
  
  private static final void a(at paramat, l.a parama)
  {
    AppMethodBeat.i(338387);
    kotlin.g.b.s.u(paramat, "this$0");
    boolean bool;
    int i;
    label57:
    Object localObject1;
    label81:
    Object localObject2;
    if ((parama != null) && (parama.hBY == true))
    {
      bool = true;
      Log.i("SimpleUIComponent", kotlin.g.b.s.X("[SHOW first_fav] red=", Boolean.valueOf(bool)));
      if ((parama == null) || (parama.hBY != true)) {
        break label229;
      }
      i = 1;
      if (i == 0) {
        break label294;
      }
      paramat.findViewById(e.e.finder_first_fav).setVisibility(0);
      if (parama != null) {
        break label234;
      }
      localObject1 = "";
      if (kotlin.g.b.s.p(localObject1, paramat.GTY)) {
        break label306;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = as.GSQ;
      localObject2 = as.a.hu((Context)paramat.getActivity());
      if (localObject2 != null) {
        break label276;
      }
      localObject2 = null;
      label123:
      com.tencent.mm.plugin.finder.report.z.a("4", 6, 1, 0, 0, 0, null, null, 0L, (bui)localObject2, 0, 0, 3520);
      paramat.GTY = ((String)localObject1);
      localObject1 = parama.ASh;
      parama = parama.ASg;
      if ((localObject1 == null) || (parama == null)) {
        break label306;
      }
      localObject2 = w.FrV;
      as.a locala = as.GSQ;
      paramat = as.a.hu((Context)paramat.getActivity());
      if (paramat != null) {
        break label286;
      }
    }
    label276:
    label286:
    for (paramat = null;; paramat = paramat.fou())
    {
      w.a((w)localObject2, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, parama, 1, paramat, 0, null, 0, 480);
      AppMethodBeat.o(338387);
      return;
      bool = false;
      break;
      label229:
      i = 0;
      break label57;
      label234:
      localObject1 = parama.ASh;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label81;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_tipsId;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label81;
      }
      break label81;
      localObject2 = ((as)localObject2).fou();
      break label123;
    }
    label294:
    paramat.findViewById(e.e.finder_first_fav).setVisibility(8);
    label306:
    AppMethodBeat.o(338387);
  }
  
  private static final void a(at paramat, com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq, View paramView)
  {
    AppMethodBeat.i(338496);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramp);
    localb.cH(parambxq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.foG().exO();
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().a(q.br.DBW);
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).C(q.a.DqE.mwI, "");
    paramView = paramat.GTK;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    if ((paramp != null) && (parambxq != null))
    {
      paramView = w.FrV;
      localObject = as.GSQ;
      paramat = as.a.hu((Context)paramat.getActivity());
      if (paramat != null) {
        break label296;
      }
    }
    label296:
    for (paramat = null;; paramat = paramat.fou())
    {
      w.a(paramView, "4", paramp, parambxq, 2, paramat, 0, null, 0, 480);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("FinderSelfLiveEntrance");
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().d("FinderEntrance", new int[] { 1010 });
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().d("TLPersonalCenter", new int[] { 1010 });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338496);
      return;
    }
  }
  
  private static final void a(at paramat, com.tencent.mm.plugin.finder.extension.reddot.p paramp, bxq parambxq, l.a parama)
  {
    AppMethodBeat.i(338506);
    kotlin.g.b.s.u(paramat, "this$0");
    int i;
    label55:
    Object localObject;
    if ((parama != null) && (parama.hBY == true))
    {
      i = 1;
      if (i == 0) {
        break label187;
      }
      parama = paramat.GTK;
      if (parama != null) {
        parama.setVisibility(0);
      }
      if (paramp != null) {
        break label142;
      }
      parama = "";
      if (kotlin.g.b.s.p(parama, paramat.GTT)) {
        break label202;
      }
      kotlin.g.b.s.u(parama, "<set-?>");
      paramat.GTT = parama;
      if ((paramp == null) || (parambxq == null)) {
        break label202;
      }
      parama = w.FrV;
      localObject = as.GSQ;
      paramat = as.a.hu((Context)paramat.getActivity());
      if (paramat != null) {
        break label179;
      }
    }
    label142:
    label179:
    for (paramat = null;; paramat = paramat.fou())
    {
      w.a(parama, "4", paramp, parambxq, 1, paramat, 0, null, 0, 480);
      AppMethodBeat.o(338506);
      return;
      i = 0;
      break;
      parama = paramp.field_ctrInfo;
      if (parama == null)
      {
        parama = "";
        break label55;
      }
      localObject = parama.ZYN;
      parama = (l.a)localObject;
      if (localObject != null) {
        break label55;
      }
      parama = "";
      break label55;
    }
    label187:
    paramat = paramat.GTK;
    if (paramat != null) {
      paramat.setVisibility(8);
    }
    label202:
    AppMethodBeat.o(338506);
  }
  
  private static final void a(at paramat, pu parampu, View paramView)
  {
    AppMethodBeat.i(338528);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(parampu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = as.GSQ;
    paramView = as.a.hu((Context)paramat.getActivity());
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.fou())
    {
      localObject = bb.FuK;
      bb.a(paramView, "biz_identity_tips", 1);
      if (parampu != null)
      {
        paramView = new Intent();
        localObject = as.GSQ;
        as.a.a((Context)paramat.getActivity(), paramView, 0L, 0, false, 124);
        paramView.putExtra("Contact_User", parampu.ADE);
        paramView.putExtra("Contact_Scene", 213);
        paramView.putExtra("force_get_contact", true);
        paramView.putExtra("key_use_new_contact_profile", true);
        paramView.putExtra("biz_profile_tab_type", 1);
        com.tencent.mm.br.c.b((Context)paramat.getActivity(), "profile", ".ui.ContactInfoUI", paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338528);
      return;
    }
  }
  
  private static final void a(at paramat, com.tencent.mm.ui.base.s params)
  {
    Object localObject = null;
    AppMethodBeat.i(338647);
    kotlin.g.b.s.u(paramat, "this$0");
    if (params.jmw())
    {
      params.oh(1001, e.h.app_field_mmsight);
      params.oh(1002, e.h.app_field_select_new_pic);
      if (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxg()) {
        params.oh(1031, e.h.finder_video_template_post);
      }
      am localam = am.GhD;
      am.a(paramat.Bsq, params, paramat.getContext());
    }
    params = com.tencent.mm.plugin.finder.report.z.FrZ;
    params = as.GSQ;
    params = as.a.hu((Context)paramat.getContext());
    if (params == null)
    {
      params = null;
      com.tencent.mm.plugin.finder.report.z.b(0, "post_acionsheet_camera", "", params);
      params = com.tencent.mm.plugin.finder.report.z.FrZ;
      params = as.GSQ;
      paramat = as.a.hu((Context)paramat.getContext());
      if (paramat != null) {
        break label180;
      }
    }
    label180:
    for (paramat = localObject;; paramat = paramat.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(0, "post_actionsheet_album", "", paramat);
      AppMethodBeat.o(338647);
      return;
      params = params.fou();
      break;
    }
  }
  
  private static final void a(at paramat, String paramString, View paramView)
  {
    AppMethodBeat.i(338465);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    kotlin.g.b.s.u(paramString, "$url");
    localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("CreatorCenter");
    localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("CreatorCenter");
    long l;
    boolean bool2;
    if ((localObject2 != null) && (localObject1 != null))
    {
      w localw = w.FrV;
      paramView = as.GSQ;
      paramView = as.a.hu((Context)paramat.getActivity());
      if (paramView == null)
      {
        paramView = null;
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, (bxq)localObject1, 2, paramView, 0, null, 0, 480);
      }
    }
    else
    {
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView = (Context)paramat.getContext();
      l = paramat.zVt;
      bool2 = paramat.GTM;
      if (localObject1 == null) {
        break label327;
      }
    }
    label327:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, l, bool2, 2L, 8L, bool1);
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("FinderPosterEntrance");
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL("CreatorCenter");
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramString);
      com.tencent.mm.br.c.b((Context)paramat.getActivity(), "webview", ".ui.tools.WebViewUI", paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338465);
      return;
      paramView = paramView.fou();
      break;
    }
  }
  
  private static final void a(at paramat, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(338541);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).fv(paramBoolean);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = com.tencent.mm.plugin.finder.report.v.FrN;
    int i;
    if (paramat.GTV)
    {
      i = 4;
      com.tencent.mm.plugin.finder.report.v.T(false, i);
      paramView = com.tencent.mm.plugin.finder.report.v.FrN;
      if (!paramat.GTV) {
        break label433;
      }
      i = 4;
      label102:
      com.tencent.mm.plugin.finder.report.v.aP(i, false);
      paramView = com.tencent.mm.plugin.finder.report.v.FrN;
      paramView = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.finder.report.v.azR(com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLCamera");
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLCamera");
      paramView = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
          break label438;
        }
        i = 0;
        label227:
        paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramView = as.GSQ;
        paramView = as.a.hu((Context)paramat.getActivity());
        if (paramView != null) {
          break label443;
        }
        paramView = null;
        label252:
        com.tencent.mm.plugin.finder.report.z.a("4", 2, 2, 1, i, 0, null, null, 0L, paramView, 0, 0, 3520);
        w localw = w.FrV;
        paramView = as.GSQ;
        paramView = as.a.hu((Context)paramat.getActivity());
        if (paramView != null) {
          break label451;
        }
        paramView = null;
        label298:
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, (bxq)localObject1, 2, paramView, 0, null, 0, 480);
      }
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("TLCamera");
      paramView = new Intent();
      if (!paramBoolean) {
        break label459;
      }
      paramView.putExtra("key_create_scene", 4);
    }
    for (;;)
    {
      localObject1 = paramat.AwM;
      if (localObject1 != null) {
        paramView.putExtra("key_prepare_resp", ((bys)localObject1).toByteArray());
      }
      com.tencent.mm.plugin.finder.utils.a.GfO.x((Context)paramat.getActivity(), paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338541);
      return;
      i = 3;
      break;
      label433:
      i = 3;
      break label102;
      label438:
      i = 1;
      break label227;
      label443:
      paramView = paramView.fou();
      break label252;
      label451:
      paramView = paramView.fou();
      break label298;
      label459:
      paramView.putExtra("key_create_scene", 2);
    }
  }
  
  private static final void b(at paramat)
  {
    AppMethodBeat.i(338548);
    kotlin.g.b.s.u(paramat, "this$0");
    View localView = paramat.GTF;
    paramat = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("finderPosBtn");
      paramat = null;
    }
    paramat.performClick();
    AppMethodBeat.o(338548);
  }
  
  private static final void b(at paramat, View paramView)
  {
    long l1 = 0L;
    AppMethodBeat.i(338340);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = new Intent();
    localObject = as.GSQ;
    as.a.a((Context)paramat.getActivity(), paramView, 0L, 0, false, 124);
    paramView.setClass((Context)paramat.getActivity(), FinderLikeFeedGridUI.class);
    paramView.putExtra("finder_username", com.tencent.mm.model.z.bAW());
    paramat.getActivity().startActivityForResult(paramView, 2);
    paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramView = (Context)paramat.getActivity();
    long l2 = paramat.zVt;
    boolean bool = paramat.GTM;
    paramat = paramat.AwM;
    if (paramat == null) {}
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, l2, bool, 2L, 2L, false, l1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338340);
      return;
      l1 = paramat.aahx;
    }
  }
  
  private static final void b(at paramat, l.a parama)
  {
    int j = 0;
    AppMethodBeat.i(338418);
    kotlin.g.b.s.u(paramat, "this$0");
    Object localObject1 = new StringBuilder("[finderMessage] red=");
    boolean bool;
    Object localObject2;
    if ((parama != null) && (parama.hBY == true))
    {
      bool = true;
      localObject2 = ((StringBuilder)localObject1).append(bool).append(" ctrlType=");
      if (parama != null) {
        break label216;
      }
      localObject1 = null;
      label65:
      Log.i("SimpleUIComponent", localObject1);
      if (parama == null) {
        break label249;
      }
      localObject1 = parama.ASh;
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo.type != 1007)) {
        break label249;
      }
      i = 1;
    }
    Object localObject3;
    Object localObject4;
    label216:
    label249:
    int k;
    for (;;)
    {
      if ((i != 0) && (parama.hBY))
      {
        paramat.findViewById(e.e.finder_send_msg_redot).setVisibility(8);
        paramat.findViewById(e.e.finder_hello_msg_redot).setVisibility(0);
        localObject3 = parama.ASh;
        localObject4 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject3).avK("finder_private_msg_entrance");
        if (localObject4 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject3).field_ctrInfo.ZYN;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (kotlin.g.b.s.p(localObject1, paramat.GTQ))
          {
            AppMethodBeat.o(338418);
            return;
            bool = false;
            break;
            localObject1 = parama.ASh;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label65;
            }
            localObject1 = Integer.valueOf(((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo.type);
            break label65;
            i = 0;
            continue;
          }
          kotlin.g.b.s.u(localObject1, "<set-?>");
          paramat.GTQ = ((String)localObject1);
          localObject2 = w.FrV;
          localObject1 = as.GSQ;
          localObject1 = as.a.hu((Context)paramat.getActivity());
          if (localObject1 != null) {
            break label391;
          }
          localObject1 = null;
          w.a((w)localObject2, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject3, (bxq)localObject4, 1, (bui)localObject1, 0, null, 0, 480);
        }
        label319:
        if ((paramat.findViewById(e.e.finder_send_msg_redot).getVisibility() != 0) && (paramat.findViewById(e.e.finder_hello_msg_redot).getVisibility() != 0)) {
          break label864;
        }
        paramat = paramat.findViewById(e.e.sendMsgLayout);
        if (paramat == null) {
          break label887;
        }
        k = e.e.finder_accessibility_msg_count_tag;
        parama = parama.ASg;
        if (parama != null) {
          break label856;
        }
      }
    }
    label391:
    label432:
    label468:
    label856:
    for (int i = j;; i = parama.count)
    {
      paramat.setTag(k, Integer.valueOf(i));
      AppMethodBeat.o(338418);
      return;
      localObject1 = ((as)localObject1).fou();
      break;
      if (parama != null)
      {
        localObject1 = parama.ASh;
        if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).field_ctrInfo.type == 1006))
        {
          i = 1;
          if ((i == 0) || (!parama.hBY)) {
            break label829;
          }
          paramat.findViewById(e.e.finder_hello_msg_redot).setVisibility(8);
          localObject1 = parama.ASg;
          if (localObject1 != null) {
            break label684;
          }
          i = 0;
          if (i <= 0) {
            break label783;
          }
          paramat.findViewById(e.e.finder_send_msg_redot).setVisibility(0);
          localObject2 = (TextView)paramat.findViewById(e.e.finder_send_msg_redot);
          if (i <= 999) {
            break label693;
          }
        }
      }
      for (localObject1 = (CharSequence)"· · ·";; localObject1 = (CharSequence)String.valueOf(i))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)paramat.findViewById(e.e.finder_send_msg_redot)).setBackgroundResource(com.tencent.mm.ui.tools.v.bC((Context)paramat.getContext(), i));
        localObject1 = (TextView)paramat.findViewById(e.e.finder_send_msg_redot);
        float f = com.tencent.mm.cd.a.bs((Context)paramat.getContext(), e.c.unReadCountTextSize);
        ((TextView)localObject1).setTextSize(0, com.tencent.mm.cd.a.jO((Context)paramat.getContext()) * f);
        localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("finder_private_msg_entrance");
        localObject4 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_private_msg_entrance");
        if ((localObject3 == null) || (localObject4 == null)) {
          break;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject4).field_ctrInfo.ZYN;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (!kotlin.g.b.s.p(localObject1, paramat.GTP)) {
          break label705;
        }
        AppMethodBeat.o(338418);
        return;
        i = 0;
        break label432;
        i = ((bxq)localObject1).count;
        break label468;
      }
      kotlin.g.b.s.u(localObject1, "<set-?>");
      paramat.GTP = ((String)localObject1);
      localObject2 = w.FrV;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)paramat.getActivity());
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
      {
        w.a((w)localObject2, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject4, (bxq)localObject3, 1, (bui)localObject1, 0, null, 0, 480);
        break;
      }
      paramat.findViewById(e.e.finder_send_msg_redot).setVisibility(8);
      Log.e("SimpleUIComponent", "LOCAL_FINDER_MESSAGE is show,but count is zero.");
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("finder_private_msg_entrance");
      break label319;
      paramat.findViewById(e.e.finder_send_msg_redot).setVisibility(8);
      paramat.findViewById(e.e.finder_hello_msg_redot).setVisibility(8);
      break label319;
    }
    label684:
    label693:
    label705:
    label864:
    paramat = paramat.findViewById(e.e.sendMsgLayout);
    label783:
    label829:
    if (paramat != null) {
      paramat.setTag(e.e.finder_accessibility_msg_count_tag, Integer.valueOf(0));
    }
    label887:
    AppMethodBeat.o(338418);
  }
  
  private static final void c(at paramat)
  {
    AppMethodBeat.i(338585);
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.findViewById(e.e.finder_account_area).performClick();
    AppMethodBeat.o(338585);
  }
  
  private static final void c(at paramat, View paramView)
  {
    AppMethodBeat.i(338354);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("Personal_Center_FavList_Entrance");
    localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("Personal_Center_FavList_Entrance");
    paramView = com.tencent.mm.plugin.finder.utils.av.GiL;
    paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    label195:
    long l2;
    boolean bool;
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView = as.GSQ;
      paramView = as.a.hu((Context)paramat.getActivity());
      if (paramView == null)
      {
        paramView = null;
        com.tencent.mm.plugin.finder.report.z.a("4", 6, 2, 0, 0, 0, null, null, 0L, paramView, 0, 0, 3520);
        w localw = w.FrV;
        paramView = as.GSQ;
        paramView = as.a.hu((Context)paramat.getActivity());
        if (paramView != null) {
          break label370;
        }
        paramView = null;
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, (bxq)localObject1, 2, paramView, 0, null, 0, 480);
      }
    }
    else
    {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("Personal_Center_FavList_Entrance");
      paramView = new Intent();
      localObject1 = as.GSQ;
      as.a.a((Context)paramat.getActivity(), paramView, 0L, 0, false, 124);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.b((MMActivity)paramat.getActivity(), paramView);
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramView = (Context)paramat.getActivity();
      l2 = paramat.zVt;
      bool = paramat.GTM;
      paramat = paramat.AwM;
      if (paramat != null) {
        break label378;
      }
    }
    label370:
    label378:
    for (long l1 = 0L;; l1 = paramat.aahy)
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, l2, bool, 2L, 3L, false, l1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338354);
      return;
      paramView = paramView.fou();
      break;
      paramView = paramView.fou();
      break label195;
    }
  }
  
  private static final void c(at paramat, l.a parama)
  {
    AppMethodBeat.i(338428);
    kotlin.g.b.s.u(paramat, "this$0");
    boolean bool;
    int i;
    if ((parama != null) && (parama.hBY == true))
    {
      bool = true;
      Log.i("SimpleUIComponent", kotlin.g.b.s.X("[finderWxMessage] red=", Boolean.valueOf(bool)));
      if ((parama == null) || (parama.hBY != true)) {
        break label266;
      }
      i = 1;
      label59:
      if (i == 0) {
        break label381;
      }
      parama = parama.ASg;
      if (parama != null) {
        break label271;
      }
      i = 0;
      label74:
      if (i <= 0) {
        break label362;
      }
      localObject = (TextView)paramat.findViewById(e.e.finder_wx_private_msg_tv);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        if (i <= 999) {
          break label279;
        }
      }
    }
    bxq localbxq;
    com.tencent.mm.plugin.finder.extension.reddot.p localp;
    label266:
    label271:
    label279:
    for (parama = (CharSequence)"· · ·";; parama = (CharSequence)String.valueOf(i))
    {
      ((TextView)localObject).setText(parama);
      ((TextView)localObject).setBackgroundResource(com.tencent.mm.ui.tools.v.bC((Context)paramat.getActivity(), i));
      float f = com.tencent.mm.cd.a.bs((Context)paramat.getActivity(), e.c.unReadCountTextSize);
      ((TextView)localObject).setTextSize(0, com.tencent.mm.cd.a.jO((Context)paramat.getActivity()) * f);
      localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("finder_wx_private_msg_entrance");
      localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_wx_private_msg_entrance");
      if ((localbxq == null) || (localp == null)) {
        break label393;
      }
      localObject = localp.field_ctrInfo.ZYN;
      parama = (l.a)localObject;
      if (localObject == null) {
        parama = "";
      }
      if (!kotlin.g.b.s.p(parama, paramat.GTR)) {
        break label290;
      }
      AppMethodBeat.o(338428);
      return;
      bool = false;
      break;
      i = 0;
      break label59;
      i = parama.count;
      break label74;
    }
    label290:
    kotlin.g.b.s.u(parama, "<set-?>");
    paramat.GTR = parama;
    parama = w.FrV;
    Object localObject = as.GSQ;
    paramat = as.a.hu((Context)paramat.getActivity());
    if (paramat == null) {}
    for (paramat = null;; paramat = paramat.fou())
    {
      w.a(parama, "4", localp, localbxq, 1, paramat, 0, null, 0, 480);
      AppMethodBeat.o(338428);
      return;
    }
    label362:
    paramat.findViewById(e.e.finder_wx_private_msg_tv).setVisibility(8);
    AppMethodBeat.o(338428);
    return;
    label381:
    paramat.findViewById(e.e.finder_wx_private_msg_tv).setVisibility(8);
    label393:
    AppMethodBeat.o(338428);
  }
  
  private static final void d(at paramat)
  {
    AppMethodBeat.i(338624);
    kotlin.g.b.s.u(paramat, "this$0");
    View localView = paramat.GTF;
    paramat = localView;
    if (localView == null)
    {
      kotlin.g.b.s.bIx("finderPosBtn");
      paramat = null;
    }
    paramat.performClick();
    AppMethodBeat.o(338624);
  }
  
  private static final void d(at paramat, View paramView)
  {
    AppMethodBeat.i(338367);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hh((Context)paramat.getActivity());
    long l1 = foO();
    paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramView = (Context)paramat.getActivity();
    long l2 = paramat.zVt;
    boolean bool2 = paramat.GTM;
    boolean bool1;
    if (l1 > 0L)
    {
      bool1 = true;
      com.tencent.mm.plugin.finder.report.z.a(paramView, l2, bool2, 2L, 7L, bool1, l1);
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      com.tencent.mm.plugin.finder.report.f.eMi().at(2L, 0L);
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      com.tencent.mm.plugin.finder.report.f.eMm().Foh = foO();
      paramView = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("finder_wx_private_msg_entrance");
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_wx_private_msg_entrance");
      if ((paramView != null) && (localObject1 != null))
      {
        localObject2 = w.FrV;
        as.a locala = as.GSQ;
        paramat = as.a.hu((Context)paramat.getActivity());
        if (paramat != null) {
          break label289;
        }
      }
    }
    label289:
    for (paramat = null;; paramat = paramat.fou())
    {
      w.a((w)localObject2, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject1, paramView, 3, paramat, 0, null, 0, 480);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338367);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static final void d(at paramat, l.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(338452);
    kotlin.g.b.s.u(paramat, "this$0");
    Object localObject3 = paramat.findViewById(e.e.creator_reddot_layout);
    View localView = paramat.findViewById(e.e.creator_entrance_redot);
    TextView localTextView = (TextView)paramat.findViewById(e.e.creator_entrance_title_redot);
    Object localObject1;
    int i;
    label79:
    com.tencent.mm.plugin.finder.extension.reddot.p localp;
    if (parama == null)
    {
      localObject1 = null;
      Log.i("SimpleUIComponent", kotlin.g.b.s.X("finderCreatorEntrance, reddot show:", localObject1));
      if ((parama == null) || (parama.hBY != true)) {
        break label304;
      }
      i = 1;
      if (i == 0) {
        break label531;
      }
      ((View)localObject3).setVisibility(0);
      localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("CreatorCenter");
      localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("CreatorCenter");
      if (localp != null) {
        break label309;
      }
      parama = "";
      label138:
      if (!kotlin.g.b.s.p(parama, paramat.GTU))
      {
        kotlin.g.b.s.u(parama, "<set-?>");
        paramat.GTU = parama;
        if ((localp != null) && (localObject3 != null))
        {
          parama = w.FrV;
          localObject1 = as.GSQ;
          paramat = as.a.hu((Context)paramat.getActivity());
          if (paramat != null) {
            break label344;
          }
          paramat = null;
          label196:
          w.a(parama, "4", localp, (bxq)localObject3, 1, paramat, 0, null, 0, 480);
        }
      }
      parama = new StringBuilder("finderCreatorEntrance, showtype:");
      if (localObject3 != null) {
        break label352;
      }
      paramat = null;
      label233:
      parama = parama.append(paramat).append(",title:");
      if (localObject3 != null) {
        break label364;
      }
      paramat = null;
      label252:
      Log.i("SimpleUIComponent", paramat);
      if (localObject3 != null) {
        break label373;
      }
      paramat = localObject2;
      label274:
      if (paramat != null) {
        break label385;
      }
      label278:
      if (paramat != null) {
        break label413;
      }
    }
    for (;;)
    {
      if (paramat == null)
      {
        AppMethodBeat.o(338452);
        return;
        localObject1 = Boolean.valueOf(parama.hBY);
        break;
        label304:
        i = 0;
        break label79;
        label309:
        parama = localp.field_ctrInfo;
        if (parama == null)
        {
          parama = "";
          break label138;
        }
        localObject1 = parama.ZYN;
        parama = (l.a)localObject1;
        if (localObject1 != null) {
          break label138;
        }
        parama = "";
        break label138;
        label344:
        paramat = paramat.fou();
        break label196;
        label352:
        paramat = Integer.valueOf(((bxq)localObject3).show_type);
        break label233;
        label364:
        paramat = ((bxq)localObject3).title;
        break label252;
        label373:
        paramat = Integer.valueOf(((bxq)localObject3).show_type);
        break label274;
        label385:
        if (paramat.intValue() != 1) {
          break label278;
        }
        localTextView.setVisibility(8);
        localView.setVisibility(0);
        AppMethodBeat.o(338452);
        return;
        label413:
        if (paramat.intValue() == 17)
        {
          localTextView.setVisibility(0);
          localView.setVisibility(8);
          paramat = ((bxq)localObject3).title;
          if (paramat == null) {}
          for (paramat = (CharSequence)"";; paramat = (CharSequence)paramat)
          {
            localTextView.setText(paramat);
            AppMethodBeat.o(338452);
            return;
          }
        }
      }
    }
    if (paramat.intValue() == 3)
    {
      localTextView.setVisibility(0);
      localView.setVisibility(0);
      paramat = ((bxq)localObject3).title;
      if (paramat == null) {}
      for (paramat = (CharSequence)"";; paramat = (CharSequence)paramat)
      {
        localTextView.setText(paramat);
        AppMethodBeat.o(338452);
        return;
      }
      label531:
      ((View)localObject3).setVisibility(4);
    }
    AppMethodBeat.o(338452);
  }
  
  private static void doPrepareUser()
  {
    AppMethodBeat.i(338270);
    di localdi = new di(8);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
    AppMethodBeat.o(338270);
  }
  
  private static final void e(at paramat)
  {
    AppMethodBeat.i(338641);
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.findViewById(e.e.finder_account_area).performClick();
    AppMethodBeat.o(338641);
  }
  
  private static final void e(at paramat, View paramView)
  {
    AppMethodBeat.i(338375);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ha((Context)paramat.getActivity());
    paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a((Context)paramat.getActivity(), paramat.zVt, paramat.GTM, 2L, 4L, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338375);
  }
  
  private static final void e(at paramat, l.a parama)
  {
    AppMethodBeat.i(338484);
    kotlin.g.b.s.u(paramat, "this$0");
    Object localObject = paramat.findViewById(e.e.live_income_reddot_tv);
    int i;
    if ((parama != null) && (parama.hBY == true)) {
      i = 1;
    }
    while (i != 0)
    {
      ((View)localObject).setVisibility(0);
      bxq localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderLiveIncomeEntrance");
      com.tencent.mm.plugin.finder.extension.reddot.p localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveIncomeEntrance");
      if ((localbxq == null) || (localp == null)) {
        break label213;
      }
      localObject = localp.field_ctrInfo.ZYN;
      parama = (l.a)localObject;
      if (localObject == null) {
        parama = "";
      }
      if (kotlin.g.b.s.p(parama, paramat.Gms))
      {
        AppMethodBeat.o(338484);
        return;
        i = 0;
      }
      else
      {
        kotlin.g.b.s.u(parama, "<set-?>");
        paramat.Gms = parama;
        parama = w.FrV;
        localObject = as.GSQ;
        paramat = as.a.hu((Context)paramat.getActivity());
        if (paramat == null) {}
        for (paramat = null;; paramat = paramat.fou())
        {
          w.a(parama, "4", localp, localbxq, 1, paramat, 0, null, 0, 480);
          AppMethodBeat.o(338484);
          return;
        }
      }
    }
    ((View)localObject).setVisibility(8);
    label213:
    AppMethodBeat.o(338484);
  }
  
  private final void efU()
  {
    AppMethodBeat.i(338294);
    Object localObject1 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("post"))
    {
      AppMethodBeat.o(338294);
      return;
    }
    localObject1 = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    int i = foM();
    Object localObject2 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.T(false, i);
    localObject2 = com.tencent.mm.ui.component.k.aeZF;
    if (!((com.tencent.mm.plugin.finder.post.g)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.finder.post.g.class)).a((kotlin.g.a.a)new c(this), (kotlin.g.a.a)new d(this)))
    {
      AppMethodBeat.o(338294);
      return;
    }
    localObject2 = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 1, true);
    View localView = af.mU((Context)getActivity()).inflate(e.f.finder_sheet_header, null);
    Object localObject5 = (TextView)localView.findViewById(e.e.nickname);
    Object localObject3 = (ImageView)localView.findViewById(e.e.avatar);
    Object localObject4 = com.tencent.mm.plugin.finder.api.d.AwY;
    localObject4 = d.a.auT(com.tencent.mm.model.z.bAW());
    if (localObject4 != null)
    {
      ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject4).getNickname()));
      localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject4).field_avatarUrl);
      kotlin.g.b.s.s(localObject3, "avatarIv");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject5).a(localb, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject3 = com.tencent.mm.plugin.finder.utils.av.GiL;
      kotlin.g.b.s.s(localView, "headerView");
      com.tencent.mm.plugin.finder.utils.av.a((com.tencent.mm.plugin.finder.api.m)localObject4, localView);
    }
    localObject3 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.azP((String)localObject1);
    ((com.tencent.mm.ui.widget.a.f)localObject2).af(localView, true);
    ((com.tencent.mm.ui.widget.a.f)localObject2).Vtg = new at..ExternalSyntheticLambda29(this);
    ((com.tencent.mm.ui.widget.a.f)localObject2).GAC = new at..ExternalSyntheticLambda30(i, (String)localObject1, this, (String)localObject1);
    ((com.tencent.mm.ui.widget.a.f)localObject2).aeLi = at..ExternalSyntheticLambda31.INSTANCE;
    ((com.tencent.mm.ui.widget.a.f)localObject2).dDn();
    if (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxg()) {
      ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).preload(0L);
    }
    AppMethodBeat.o(338294);
  }
  
  private static final void f(at paramat, View paramView)
  {
    AppMethodBeat.i(338401);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_private_msg_entrance");
    int i;
    label111:
    w localw;
    if (localObject2 == null)
    {
      paramView = null;
      if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).field_ctrInfo.type != 1007)) {
        break label290;
      }
      i = 1;
      if (i == 0) {
        break label303;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a((Context)paramat.getActivity(), paramat.zVt, paramat.GTM, 2L, 6L, true, 0L);
      if (paramView != null)
      {
        localw = w.FrV;
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)paramat.getActivity());
        if (localObject1 != null) {
          break label295;
        }
        localObject1 = null;
        label175:
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, paramView, 2, (bui)localObject1, 0, null, 0, 480);
      }
    }
    for (;;)
    {
      paramView = com.tencent.mm.plugin.finder.report.f.FnM;
      com.tencent.mm.plugin.finder.report.f.eMi().at(1L, 0L);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("finder_private_msg_entrance");
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderConversationUI((Context)paramat.getActivity());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338401);
      return;
      paramView = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).avK("finder_private_msg_entrance");
      break;
      label290:
      i = 0;
      break label111;
      label295:
      localObject1 = ((as)localObject1).fou();
      break label175;
      label303:
      if ((localObject2 != null) && (((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2).field_ctrInfo.type == 1006))
      {
        i = 1;
        label324:
        if (i == 0) {
          break label438;
        }
        if (paramView != null) {
          break label422;
        }
        i = 0;
        label334:
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.a((Context)paramat.getActivity(), paramat.zVt, paramat.GTM, 2L, 6L, true, i);
        if (paramView == null) {
          continue;
        }
        localw = w.FrV;
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)paramat.getActivity());
        if (localObject1 != null) {
          break label430;
        }
      }
      label422:
      label430:
      for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
      {
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, paramView, 3, (bui)localObject1, 0, null, 0, 480);
        break;
        i = 0;
        break label324;
        i = paramView.count;
        break label334;
      }
      label438:
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a((Context)paramat.getActivity(), paramat.zVt, paramat.GTM, 2L, 6L, false, 0L);
    }
  }
  
  private static final void f(at paramat, l.a parama)
  {
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(338555);
    kotlin.g.b.s.u(paramat, "this$0");
    boolean bool;
    if ((parama != null) && (parama.hBY == true))
    {
      bool = true;
      Log.i("SimpleUIComponent", kotlin.g.b.s.X("[SHOW NEW] red=", Boolean.valueOf(bool)));
      if ((parama == null) || (parama.hBY != true)) {
        break label100;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label105;
      }
      parama = paramat.GTH;
      paramat = parama;
      if (parama == null)
      {
        kotlin.g.b.s.bIx("finderCanPostNoContact");
        paramat = null;
      }
      paramat.setVisibility(0);
      AppMethodBeat.o(338555);
      return;
      bool = false;
      break;
      label100:
      i = 0;
    }
    label105:
    paramat = paramat.GTH;
    if (paramat == null)
    {
      kotlin.g.b.s.bIx("finderCanPostNoContact");
      paramat = localObject;
    }
    for (;;)
    {
      paramat.setVisibility(8);
      AppMethodBeat.o(338555);
      return;
    }
  }
  
  private final com.tencent.mm.plugin.findersdk.a.av foG()
  {
    AppMethodBeat.i(338123);
    com.tencent.mm.plugin.findersdk.a.av localav = (com.tencent.mm.plugin.findersdk.a.av)this.FcH.getValue();
    AppMethodBeat.o(338123);
    return localav;
  }
  
  private final void foH()
  {
    AppMethodBeat.i(338139);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVA().bmg()).intValue() == 2)
    {
      localObject1 = "https://channels.weixin.qq.com/mobile/creator_center.html";
      if (((CharSequence)localObject1).length() <= 0) {
        break label169;
      }
    }
    label169:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label174;
      }
      GTZ = (String)localObject1;
      findViewById(e.e.finder_poster_service_entrance).setVisibility(0);
      findViewById(e.e.finder_poster_entrance).setVisibility(8);
      findViewById(e.e.finder_poster_service_entrance).setOnClickListener(new at..ExternalSyntheticLambda19(this, (String)localObject1));
      AppMethodBeat.o(338139);
      return;
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eVA().bmg()).intValue() == 1)
      {
        localObject1 = "https://channels.weixin.qq.com/mobile-support/pages/creator/center";
        break;
      }
      localObject1 = this.AwM;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((bys)localObject1).aahD)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = GTZ;
        }
        kotlin.g.b.s.s(localObject2, "{\n            prepareRes…rUrl ?: lastUrl\n        }");
        localObject1 = localObject2;
        break;
      }
    }
    label174:
    ((FrameLayout)findViewById(e.e.finder_poster_service_entrance)).setVisibility(8);
    AppMethodBeat.o(338139);
  }
  
  private final void foI()
  {
    AppMethodBeat.i(338152);
    Object localObject1 = this.AwM;
    int i;
    boolean bool1;
    boolean bool2;
    Object localObject2;
    long l;
    label72:
    boolean bool3;
    boolean bool4;
    Object localObject3;
    if (localObject1 == null)
    {
      i = 0;
      bool1 = com.tencent.mm.ae.d.ee(i, 1);
      bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      localObject1 = (com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class);
      localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject2 = d.a.auT(com.tencent.mm.model.z.bAW());
      if (localObject2 != null) {
        break label301;
      }
      l = 0L;
      bool3 = ((com.tencent.mm.plugin.g)localObject1).jq(l);
      localObject2 = findViewById(e.e.live_income_ll);
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      bool4 = com.tencent.mm.plugin.finder.utils.av.ffR();
      localObject1 = new StringBuilder("initLiveIncomeCell FinderLive.entrance,xLab enable live:");
      localObject3 = com.tencent.d.a.a.a.a.a.ahiX;
      localObject3 = ((StringBuilder)localObject1).append(com.tencent.d.a.a.a.a.a.jTq()).append(", hasAccount:").append(bool4).append(", server flag:");
      localObject1 = this.AwM;
      if (localObject1 != null) {
        break label311;
      }
    }
    label301:
    label311:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((bys)localObject1).aahC))
    {
      Log.i("SimpleUIComponent", localObject1 + ", server enable live:" + bool1 + " rewardGainEnable:" + bool3);
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (!com.tencent.mm.plugin.finder.utils.av.bgV())
      {
        localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
        if ((!com.tencent.d.a.a.a.a.a.jTq()) && (!bool1)) {
          break label324;
        }
      }
      if ((!bool3) || (bool2) || (bool4)) {
        break label324;
      }
      ((View)localObject2).setVisibility(0);
      ((View)localObject2).setOnClickListener(new at..ExternalSyntheticLambda6(this));
      localObject1 = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZZ(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda27(this));
      AppMethodBeat.o(338152);
      return;
      i = ((bys)localObject1).aahC;
      break;
      l = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_liveSwitchFlag;
      break label72;
    }
    label324:
    ((View)localObject2).setVisibility(8);
    AppMethodBeat.o(338152);
  }
  
  private final void foJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(338172);
    Object localObject1 = this.AwM;
    int i;
    if (localObject1 == null)
    {
      i = 0;
      boolean bool = com.tencent.mm.ae.d.ee(i, 1);
      localObject1 = new StringBuilder("FinderLive.entrance,xLab enable live:");
      Object localObject3 = com.tencent.d.a.a.a.a.a.ahiX;
      localObject3 = ((StringBuilder)localObject1).append(com.tencent.d.a.a.a.a.a.jTq()).append(", server flag:");
      localObject1 = this.AwM;
      if (localObject1 != null) {
        break label414;
      }
      localObject1 = null;
      label68:
      Log.i("SimpleUIComponent", localObject1 + ", server enable live:" + bool);
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (!com.tencent.mm.plugin.finder.utils.av.bgV())
      {
        localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
        if ((!com.tencent.d.a.a.a.a.a.jTq()) && (!bool)) {
          break label425;
        }
      }
      localObject1 = findViewById(e.e.postBtn_new);
      kotlin.g.b.s.s(localObject1, "findViewById<View>(R.id.postBtn_new)");
      this.GTF = ((View)localObject1);
      localObject1 = findViewById(e.e.finder_post_new_feed_new);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_post_new_feed_new)");
      this.GTG = ((TextView)localObject1);
      localObject1 = findViewById(e.e.finder_can_post_no_contact_new);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_can_post_no_contact_new)");
      this.GTH = ((TextView)localObject1);
      this.GTI = findViewById(e.e.livePostBtn);
      this.GTJ = ((TextView)findViewById(e.e.finder_live_post_new_feed));
      this.GTK = ((TextView)findViewById(e.e.finder_can_post_live_no_contact));
      findViewById(e.e.postBtn).setVisibility(8);
      findViewById(e.e.post_container_new).setVisibility(0);
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderSelfLiveEntrance");
      localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderSelfLiveEntrance");
      Object localObject4 = this.GTI;
      if (localObject4 != null) {
        ((View)localObject4).setOnClickListener(new at..ExternalSyntheticLambda17(this, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject3, (bxq)localObject1));
      }
      localObject4 = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZQ(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda28(this, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject3, (bxq)localObject1));
      label343:
      localObject1 = this.GTF;
      if (localObject1 != null) {
        break label517;
      }
      kotlin.g.b.s.bIx("finderPosBtn");
      localObject1 = localObject2;
    }
    label517:
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new at..ExternalSyntheticLambda13(this));
      this.GTL = findViewById(e.e.red_pack);
      localObject1 = this.GTL;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      AppMethodBeat.o(338172);
      return;
      i = ((bys)localObject1).aahC;
      break;
      label414:
      localObject1 = Integer.valueOf(((bys)localObject1).aahC);
      break label68;
      label425:
      localObject1 = findViewById(e.e.postBtn);
      kotlin.g.b.s.s(localObject1, "findViewById<View>(R.id.postBtn)");
      this.GTF = ((View)localObject1);
      localObject1 = findViewById(e.e.finder_post_new_feed);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_post_new_feed)");
      this.GTG = ((TextView)localObject1);
      localObject1 = findViewById(e.e.finder_can_post_no_contact);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_can_post_no_contact)");
      this.GTH = ((TextView)localObject1);
      findViewById(e.e.postBtn).setVisibility(0);
      findViewById(e.e.post_container_new).setVisibility(8);
      break label343;
    }
  }
  
  private final void foK()
  {
    AppMethodBeat.i(338184);
    if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      AppMethodBeat.o(338184);
      return;
    }
    View localView = findViewById(e.e.finder_self_account_state);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(e.e.loading_progress_bar);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(e.e.jump_finder_management);
    if (localView != null) {
      localView.setVisibility(8);
    }
    findViewById(e.e.jump_finder_live_purchase).setVisibility(8);
    AppMethodBeat.o(338184);
  }
  
  private final void foL()
  {
    AppMethodBeat.i(338262);
    this.GTC = com.tencent.mm.model.z.bAW();
    Log.i("SimpleUIComponent", kotlin.g.b.s.X("myFinderUser ", this.GTC));
    foI();
    foJ();
    foH();
    Object localObject3 = findViewById(e.e.has_contact_container);
    Object localObject1 = findViewById(e.e.no_contact_container);
    Object localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
    int i;
    label173:
    label220:
    label370:
    int j;
    label263:
    label540:
    label565:
    boolean bool1;
    label519:
    Object localObject6;
    Object localObject7;
    Object localObject4;
    Object localObject5;
    label1300:
    label1441:
    int k;
    switch (com.tencent.mm.plugin.finder.utils.av.fgg())
    {
    default: 
      Log.d("SimpleUIComponent", "not one of six state");
      i = 0;
    case 1: 
    case 2: 
      for (;;)
      {
        localObject1 = this.AwM;
        if (localObject1 != null)
        {
          if (((bys)localObject1).aahx <= 0) {
            break;
          }
          localObject2 = (TextView)findViewById(e.e.like_feed_count);
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText((CharSequence)r.TQ(((bys)localObject1).aahx));
            ((TextView)localObject2).setVisibility(0);
          }
          if (((bys)localObject1).aahy <= 0) {
            break label3443;
          }
          localObject2 = (TextView)findViewById(e.e.fav_feed_count);
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText((CharSequence)r.TQ(((bys)localObject1).aahy));
            ((TextView)localObject2).setVisibility(0);
          }
          if (((bys)localObject1).aahL <= 0) {
            break label3461;
          }
          ((TextView)findViewById(e.e.finder_live_purchase_count)).setText((CharSequence)String.valueOf(((bys)localObject1).aahL));
          findViewById(e.e.jump_finder_live_purchase).setVisibility(0);
          Log.i("SimpleUIComponent", "likeCount = " + ((bys)localObject1).aahx + ",favCount = " + ((bys)localObject1).aahy + "，purchased_total_count=" + ((bys)localObject1).aahL);
        }
        localObject2 = this.GTG;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("finderPostNewFeed");
          localObject1 = null;
        }
        com.tencent.mm.ui.aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
        localObject1 = this.GTJ;
        if (localObject1 != null) {
          break label3495;
        }
        localObject1 = null;
        com.tencent.mm.ui.aw.a((Paint)localObject1, 0.8F);
        findViewById(e.e.finder_self_account_state).setVisibility(0);
        if (getIntent().getBooleanExtra("key_from_sns_post", false))
        {
          localObject2 = this.GTF;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("finderPosBtn");
            localObject1 = null;
          }
          ((View)localObject1).post(new at..ExternalSyntheticLambda32((View)localObject1));
          getIntent().removeExtra("key_from_sns_post");
        }
        Log.i("SimpleUIComponent", kotlin.g.b.s.X("[checkAutoShowPost] autoShow", Boolean.valueOf(this.GTX)));
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        j = com.tencent.mm.plugin.finder.utils.av.fgg();
        if ((!this.GTX) || ((j != 3) && (j != 6))) {
          break label3505;
        }
        efU();
        Log.i("SimpleUIComponent", "[checkAutoShowPost] has autoShow post bottom sheet ,set false");
        this.GTX = false;
        localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
        localObject1 = d.a.auT(com.tencent.mm.model.z.bAW());
        if (localObject1 != null) {
          break label3517;
        }
        localObject1 = null;
        localObject2 = findViewById(e.e.biz_identity_tips);
        if (localObject2 != null)
        {
          if ((localObject1 == null) || (i == 0)) {
            break label3528;
          }
          i = 0;
          ((View)localObject2).setVisibility(i);
          com.tencent.mm.view.f.a((View)localObject2, (e.b)new f(this));
          ((View)localObject2).setOnClickListener(new at..ExternalSyntheticLambda18(this, (pu)localObject1));
        }
        foK();
        AppMethodBeat.o(338262);
        return;
        kotlin.g.b.s.s(localObject3, "hasContactContainer");
        kotlin.g.b.s.s(localObject1, "noContactContainer");
        kotlin.g.b.s.u(localObject3, "hasContactContainer");
        kotlin.g.b.s.u(localObject1, "noContactContainer");
        localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
        bool1 = com.tencent.mm.plugin.finder.utils.av.fgk();
        Log.d("SimpleUIComponent", kotlin.g.b.s.X("账户无发表权限,isForeign:", Boolean.valueOf(bool1)));
        ((View)localObject1).setVisibility(0);
        ((View)localObject3).setVisibility(8);
        if (bool1)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eWG().bmg()).intValue() == 0) {
            ((TextView)localObject1).setText((CharSequence)getActivity().getString(e.h.finder_oversea_no_quality_tips));
          }
        }
        i = 0;
        continue;
        kotlin.g.b.s.s(localObject3, "hasContactContainer");
        kotlin.g.b.s.s(localObject1, "noContactContainer");
        kotlin.g.b.s.u(localObject3, "hasContactContainer");
        kotlin.g.b.s.u(localObject1, "noContactContainer");
        localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
        bool1 = com.tencent.mm.plugin.finder.utils.av.fgk();
        Log.d("SimpleUIComponent", kotlin.g.b.s.X("有发表权限但未创建账号,isForign = ", Boolean.valueOf(bool1)));
        if (bool1)
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eWG().bmg()).intValue() == 0)
          {
            ((View)localObject1).setVisibility(0);
            ((View)localObject3).setVisibility(8);
            ((TextView)localObject1).setText((CharSequence)getActivity().getString(e.h.finder_oversea_no_quality_tips));
            i = 0;
            continue;
          }
        }
        ((View)localObject1).setVisibility(8);
        ((View)localObject3).setVisibility(0);
        findViewById(e.e.msg_ll).setVisibility(8);
        findViewById(e.e.finder_account_area).setVisibility(8);
        findViewById(e.e.sendMsgLayout).setVisibility(8);
        findViewById(e.e.finder_poster_entrance).setVisibility(8);
        findViewById(e.e.finder_poster_service_entrance).setVisibility(8);
        bool1 = getIntent().getBooleanExtra("key_from_sns_post", false);
        localObject2 = this.GTF;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("finderPosBtn");
          localObject1 = null;
        }
        ((View)localObject1).setOnClickListener(new at..ExternalSyntheticLambda20(this, bool1));
        if ((bool1) && (this.AwM != null))
        {
          localObject2 = this.GTF;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("finderPosBtn");
            localObject1 = null;
          }
          ((View)localObject1).post(new at..ExternalSyntheticLambda34(this));
          getIntent().removeExtra("key_from_sns_post");
        }
        localObject1 = l.ARA;
        com.tencent.mm.ae.d.a((LiveData)l.dZD(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda25(this));
        localObject1 = this.GTI;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = l.ARA;
        com.tencent.mm.ae.d.a((LiveData)l.dZS(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda23(this));
        i = 0;
      }
    case 3: 
    case 6: 
      kotlin.g.b.s.s(localObject3, "hasContactContainer");
      kotlin.g.b.s.s(localObject1, "noContactContainer");
      Log.d("SimpleUIComponent", "账户正常");
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("TLCamera");
      ((View)localObject1).setVisibility(8);
      ((View)localObject3).setVisibility(0);
      localObject1 = findViewById(e.e.finder_account_area);
      localObject2 = findViewById(e.e.msg_ll);
      localObject6 = findViewById(e.e.finder_poster_entrance);
      localObject7 = (ImageView)findViewById(e.e.finder_avatar_iv);
      localObject4 = (TextView)findViewById(e.e.finder_nick_tv);
      localObject5 = (TextView)findViewById(e.e.finder_msg_tv);
      Object localObject8 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject8 = this.GTC;
      kotlin.g.b.s.checkNotNull(localObject8);
      localObject8 = d.a.auT((String)localObject8);
      ImageView localImageView = (ImageView)findViewById(e.e.auth_icon);
      if (this.GTW)
      {
        findViewById(e.e.sendMsgLayout).setVisibility(0);
        if (localObject8 == null) {
          break label3541;
        }
        Object localObject9 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject9 = com.tencent.mm.plugin.finder.loader.p.eCp();
        com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((com.tencent.mm.plugin.finder.api.m)localObject8).dUs(), com.tencent.mm.plugin.finder.storage.v.FLE);
        kotlin.g.b.s.s(localObject7, "finderAvatar");
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject9).a(localb, (ImageView)localObject7, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.m)localObject8).dUr()));
        com.tencent.mm.ui.aw.a((Paint)((TextView)localObject4).getPaint(), 0.8F);
        localObject7 = com.tencent.mm.plugin.finder.utils.av.GiL;
        kotlin.g.b.s.s(localImageView, "authIcon");
        com.tencent.mm.plugin.finder.utils.av.a(localImageView, ((com.tencent.mm.plugin.finder.api.m)localObject8).field_authInfo, 0, null, 12);
        localObject7 = ((com.tencent.mm.plugin.finder.api.m)localObject8).field_authInfo;
        if (localObject7 != null) {
          break label1604;
        }
        i = 0;
        j = com.tencent.mm.kernel.h.baE().ban().getInt(com.tencent.mm.storage.at.a.adcP, 0);
        if (j <= 0) {
          break label1613;
        }
        localObject7 = (TextView)findViewById(e.e.finder_follow_count);
        if (localObject7 == null) {
          break label1630;
        }
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setText((CharSequence)getActivity().getResources().getString(e.h.finder_fans, new Object[] { String.valueOf(j) }));
        localObject7 = ah.aiuX;
        k = j;
        j = i;
        i = k;
      }
      break;
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      label1604:
      label1613:
      label1630:
      label1656:
      int n;
      int m;
      if (findViewById(e.e.finder_poster_service_entrance).getVisibility() != 0)
      {
        ((View)localObject6).setVisibility(0);
        localObject7 = ae.Ghi;
        if (localObject6 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(338262);
          throw ((Throwable)localObject1);
          findViewById(e.e.sendMsgLayout).setVisibility(8);
          break label1300;
          i = ((FinderAuthInfo)localObject7).authIconType;
          break label1441;
          findViewById(e.e.finder_follow_count).setVisibility(8);
          localObject7 = ah.aiuX;
          k = i;
          i = j;
          j = k;
          continue;
        }
        ae.a((ViewGroup)localObject6, (androidx.lifecycle.q)getActivity());
        localObject6 = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
        localObject6 = m.a.eam();
        k = localObject6[0];
        n = localObject6[1];
        int i1 = localObject6[2];
        m = localObject6[3];
        Log.i("SimpleUIComponent", "redDot check likeCount :" + k + " commentCount " + n + " followCount " + i1 + ' ');
        ((View)localObject1).setOnClickListener(new at..ExternalSyntheticLambda9(this));
        localObject6 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("AuthorProfileNotify");
        localObject7 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("AuthorProfileNotify");
        ((View)localObject2).setOnClickListener(new at..ExternalSyntheticLambda0(m, this, (com.tencent.mm.plugin.finder.extension.reddot.p)localObject6, (bxq)localObject7));
        if (m <= 0) {
          break label2574;
        }
        ((TextView)localObject5).setVisibility(0);
        if (m <= 999) {
          break label2535;
        }
        localObject1 = (CharSequence)"· · ·";
        label1840:
        ((TextView)localObject5).setText((CharSequence)localObject1);
        ((TextView)localObject5).setBackgroundResource(com.tencent.mm.ui.tools.v.bC((Context)getContext(), m));
        float f = com.tencent.mm.cd.a.bs((Context)getActivity(), e.c.unReadCountTextSize);
        ((TextView)localObject5).setTextSize(0, com.tencent.mm.cd.a.jO((Context)getActivity()) * f);
        if (!this.GTD)
        {
          this.GTD = true;
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
            break label2548;
          }
          k = 0;
          label1933:
          if (m > 0)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
            localObject1 = as.GSQ;
            localObject1 = as.a.hu((Context)getActivity());
            if (localObject1 != null) {
              break label2554;
            }
            localObject1 = null;
            label1968:
            com.tencent.mm.plugin.finder.report.z.a("4", 1, 1, 5, k, m, null, null, 0L, (bui)localObject1, 0, 0, 3520);
          }
          if ((localObject6 != null) && (localObject7 != null))
          {
            localObject5 = w.FrV;
            localObject1 = as.GSQ;
            localObject1 = as.a.hu((Context)getActivity());
            if (localObject1 != null) {
              break label2564;
            }
            localObject1 = null;
            label2031:
            w.a((w)localObject5, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject6, (bxq)localObject7, 1, (bui)localObject1, 0, null, 0, 480);
            localObject1 = ah.aiuX;
          }
        }
        ((View)localObject2).setTag(e.e.finder_accessibility_msg_count_tag, Integer.valueOf(m));
        label2070:
        localObject2 = this.GTF;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("finderPosBtn");
          localObject1 = null;
        }
        ((View)localObject1).setOnClickListener(new at..ExternalSyntheticLambda10(this));
        localObject2 = this.GTF;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("finderPosBtn");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = this.GTI;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        if (getIntent().getBooleanExtra("key_from_sns_post", false))
        {
          localObject2 = this.GTF;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("finderPosBtn");
            localObject1 = null;
          }
          ((View)localObject1).post(new at..ExternalSyntheticLambda33(this));
          getIntent().removeExtra("key_from_sns_post");
        }
        if (!this.GTO)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          localObject1 = (Context)getActivity();
          long l = this.zVt;
          boolean bool2 = this.GTM;
          if (m <= 0) {
            break label2596;
          }
          bool1 = true;
          label2257:
          com.tencent.mm.plugin.finder.report.z.a((Context)localObject1, l, bool2, 1L, 5L, bool1, m);
          this.GTO = true;
        }
        Log.i("SimpleUIComponent", kotlin.g.b.s.X("show finder msg red, totalCount:", Integer.valueOf(m)));
        localObject2 = this.GTC;
        if (localObject2 != null)
        {
          localObject1 = (TextView)findViewById(e.e.finder_self_state_txt);
          localObject5 = com.tencent.mm.plugin.finder.api.d.AwY;
          localObject2 = d.a.auW((String)localObject2);
          if (localObject2 != null)
          {
            if (((d.a.a)localObject2).Axb != 1) {
              break label2636;
            }
            k = 0;
            n = ((LinearLayout)localObject3).getChildCount();
            if (n <= 0) {}
          }
        }
      }
      for (;;)
      {
        m = k + 1;
        localObject2 = ((LinearLayout)localObject3).getChildAt(k);
        if (localObject2 != null)
        {
          k = ((View)localObject2).getId();
          if (k == e.e.finder_account_area)
          {
            ((View)localObject2).setVisibility(0);
            label2408:
            localObject2 = ah.aiuX;
            localObject2 = ah.aiuX;
          }
        }
        else
        {
          if (m < n) {
            break label3534;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText((CharSequence)getActivity().getString(e.h.finder_account_in_logout_status_in_selfui));
        }
        for (;;)
        {
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
          localObject1 = findViewById(e.e.finder_account_area);
          if (localObject1 != null)
          {
            ((View)localObject1).setTag(e.e.finder_accessibility_nickname_tag, ((TextView)localObject4).getText());
            ((View)localObject1).setTag(e.e.finder_accessibility_follow_count_tag, Integer.valueOf(i));
            ((View)localObject1).setTag(e.e.finder_accessibility_auth_icon_type_tag, Integer.valueOf(j));
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
          i = 1;
          break;
          ((View)localObject6).setVisibility(8);
          break label1656;
          label2535:
          localObject1 = (CharSequence)String.valueOf(m);
          break label1840;
          label2548:
          k = 2;
          break label1933;
          label2554:
          localObject1 = ((as)localObject1).fou();
          break label1968;
          label2564:
          localObject1 = ((as)localObject1).fou();
          break label2031;
          label2574:
          ((TextView)localObject5).setVisibility(8);
          ((View)localObject2).setTag(e.e.finder_accessibility_msg_count_tag, Integer.valueOf(0));
          break label2070;
          label2596:
          bool1 = false;
          break label2257;
          if (k == e.e.post_container_new)
          {
            ((View)localObject2).setVisibility(8);
            break label2408;
          }
          ((View)localObject2).setOnClickListener(new at..ExternalSyntheticLambda3(this));
          break label2408;
          label2636:
          ((TextView)localObject1).setText((CharSequence)"");
          ((TextView)localObject1).setVisibility(8);
        }
        kotlin.g.b.s.s(localObject3, "hasContactContainer");
        kotlin.g.b.s.s(localObject1, "noContactContainer");
        Log.d("SimpleUIComponent", "账户封禁");
        ((View)localObject1).setVisibility(8);
        ((View)localObject3).setVisibility(0);
        findViewById(e.e.msg_ll).setVisibility(8);
        findViewById(e.e.finder_poster_entrance).setVisibility(8);
        findViewById(e.e.finder_poster_service_entrance).setVisibility(8);
        localObject2 = this.GTF;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("finderPosBtn");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(8);
        localObject1 = this.GTI;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject2 = new com.tencent.mm.plugin.finder.loader.b("");
        localObject3 = findViewById(e.e.finder_avatar_iv);
        kotlin.g.b.s.s(localObject3, "findViewById<ImageView>(R.id.finder_avatar_iv)");
        localObject3 = (ImageView)localObject3;
        localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        ((TextView)findViewById(e.e.finder_nick_tv)).setText((CharSequence)getResources().getString(e.h.finder_account_forbid));
        findViewById(e.e.finder_account_area).setOnClickListener(new at..ExternalSyntheticLambda12(this));
        if (getIntent().getBooleanExtra("key_from_sns_post", false))
        {
          findViewById(e.e.finder_account_area).post(new at..ExternalSyntheticLambda37(this));
          getIntent().removeExtra("key_from_sns_post");
        }
        findViewById(e.e.sendMsgLayout).setVisibility(8);
        i = 0;
        break;
        kotlin.g.b.s.s(localObject3, "hasContactContainer");
        kotlin.g.b.s.s(localObject1, "noContactContainer");
        Log.d("SimpleUIComponent", "账户审核中");
        ((View)localObject1).setVisibility(8);
        ((View)localObject3).setVisibility(0);
        localObject5 = (ImageView)findViewById(e.e.finder_avatar_iv);
        localObject3 = (TextView)findViewById(e.e.finder_nick_tv);
        localObject4 = (TextView)findViewById(e.e.finder_state_tv);
        findViewById(e.e.msg_ll).setVisibility(8);
        localObject2 = this.GTF;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("finderPosBtn");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(8);
        localObject1 = this.GTI;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        findViewById(e.e.finder_poster_entrance).setVisibility(8);
        findViewById(e.e.finder_poster_service_entrance).setVisibility(8);
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject6 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject1 = this.AwM;
        if (localObject1 == null)
        {
          localObject1 = "";
          label3135:
          localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1, com.tencent.mm.plugin.finder.storage.v.FLE);
          kotlin.g.b.s.s(localObject5, "finderAvatar");
          localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject6).a(localObject1, (ImageView)localObject5, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
          localObject2 = (Context)getActivity();
          localObject1 = this.AwM;
          if (localObject1 != null) {
            break label3397;
          }
          localObject1 = null;
        }
        for (;;)
        {
          ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject2, (CharSequence)localObject1));
          com.tencent.mm.ui.aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText((CharSequence)getResources().getString(e.h.finder_self_contact_reviewing));
          findViewById(e.e.msg_ll).setVisibility(8);
          findViewById(e.e.finder_account_area).setOnClickListener(new at..ExternalSyntheticLambda15(this));
          if ((getIntent().getBooleanExtra("key_from_sns_post", false)) && (this.AwM != null))
          {
            findViewById(e.e.finder_account_area).post(new at..ExternalSyntheticLambda36(this));
            getIntent().removeExtra("key_from_sns_post");
          }
          findViewById(e.e.sendMsgLayout).setVisibility(8);
          i = 0;
          break;
          localObject1 = ((bys)localObject1).verifyInfo;
          if (localObject1 == null)
          {
            localObject1 = "";
            break label3135;
          }
          localObject2 = ((bqt)localObject1).nVM;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label3135;
          }
          localObject1 = "";
          break label3135;
          label3397:
          localObject1 = ((bys)localObject1).verifyInfo;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((bqt)localObject1).ZYH;
          }
        }
        ((TextView)findViewById(e.e.like_feed_count)).setVisibility(8);
        break label173;
        label3443:
        ((TextView)findViewById(e.e.fav_feed_count)).setVisibility(8);
        break label220;
        label3461:
        ((TextView)findViewById(e.e.finder_live_purchase_count)).setText((CharSequence)"");
        findViewById(e.e.jump_finder_live_purchase).setVisibility(8);
        break label263;
        label3495:
        localObject1 = ((TextView)localObject1).getPaint();
        break label370;
        label3505:
        Log.i("SimpleUIComponent", "[checkAutoShowPost] not autoShow");
        break label519;
        label3517:
        localObject1 = com.tencent.mm.plugin.finder.api.c.a((com.tencent.mm.plugin.finder.api.m)localObject1, true);
        break label540;
        label3528:
        i = 8;
        break label565;
        label3534:
        k = m;
      }
      label3541:
      i = 0;
      j = 0;
    }
  }
  
  private final int foM()
  {
    AppMethodBeat.i(338279);
    com.tencent.mm.plugin.finder.activity.b localb = com.tencent.mm.plugin.finder.activity.b.Aty;
    if (!com.tencent.mm.plugin.finder.activity.b.c(null, 5))
    {
      if (this.GTV)
      {
        AppMethodBeat.o(338279);
        return 4;
      }
      AppMethodBeat.o(338279);
      return 3;
    }
    AppMethodBeat.o(338279);
    return 9;
  }
  
  private final void foN()
  {
    AppMethodBeat.i(338307);
    Object localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a((Context)getActivity(), this.zVt, this.GTM, 1L, 1L, false);
    localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject1 = (Context)getActivity();
    long l2 = this.zVt;
    boolean bool1 = this.GTM;
    Object localObject2 = this.AwM;
    long l1;
    label125:
    int i;
    if (localObject2 == null)
    {
      l1 = 0L;
      com.tencent.mm.plugin.finder.report.z.a((Context)localObject1, l2, bool1, 1L, 2L, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject1 = (Context)getActivity();
      l2 = this.zVt;
      bool1 = this.GTM;
      localObject2 = this.AwM;
      if (localObject2 != null) {
        break label445;
      }
      l1 = 0L;
      com.tencent.mm.plugin.finder.report.z.a((Context)localObject1, l2, bool1, 1L, 3L, false, l1);
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a((Context)getActivity(), this.zVt, this.GTM, 1L, 4L, false);
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("finder_private_msg_entrance");
      if (localObject1 != null) {
        break label455;
      }
      localObject1 = null;
      label196:
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = (Context)getActivity();
      l1 = this.zVt;
      boolean bool2 = this.GTM;
      if (localObject1 == null) {
        break label468;
      }
      bool1 = true;
      label229:
      if (localObject1 != null) {
        break label474;
      }
      i = 0;
      label236:
      com.tencent.mm.plugin.finder.report.z.a((Context)localObject2, l1, bool2, 1L, 6L, bool1, i);
      l1 = foO();
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject1 = (Context)getActivity();
      l2 = this.zVt;
      bool2 = this.GTM;
      if (l1 <= 0L) {
        break label483;
      }
      bool1 = true;
      label291:
      com.tencent.mm.plugin.finder.report.z.a((Context)localObject1, l2, bool2, 1L, 7L, bool1, l1);
      localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("CreatorCenter");
      localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = (Context)getActivity();
      l1 = this.zVt;
      bool2 = this.GTM;
      if (localObject1 == null) {
        break label489;
      }
      bool1 = true;
      label360:
      com.tencent.mm.plugin.finder.report.z.a((Context)localObject2, l1, bool2, 1L, 8L, bool1);
      localObject1 = findViewById(e.e.live_income_ll);
      if (((View)localObject1).getVisibility() != 0) {
        break label495;
      }
      i = 1;
      label393:
      if (i == 0) {
        break label500;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.a((Context)getActivity(), this.zVt, false, 1L, 9L, false, 0L);
      }
      AppMethodBeat.o(338307);
      return;
      l1 = ((bys)localObject2).aahx;
      break;
      label445:
      l1 = ((bys)localObject2).aahy;
      break label125;
      label455:
      localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.p)localObject1).avK("finder_private_msg_entrance");
      break label196;
      label468:
      bool1 = false;
      break label229;
      label474:
      i = ((bxq)localObject1).count;
      break label236;
      label483:
      bool1 = false;
      break label291;
      label489:
      bool1 = false;
      break label360;
      label495:
      i = 0;
      break label393;
      label500:
      localObject1 = null;
    }
  }
  
  private static long foO()
  {
    AppMethodBeat.i(338314);
    bxq localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("finder_wx_private_msg_entrance");
    if (localbxq == null)
    {
      AppMethodBeat.o(338314);
      return 0L;
    }
    long l = localbxq.count;
    AppMethodBeat.o(338314);
    return l;
  }
  
  private static final void foP()
  {
    AppMethodBeat.i(338662);
    com.tencent.mm.plugin.finder.report.v localv = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.SA(6);
    ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).destroyEngine();
    AppMethodBeat.o(338662);
  }
  
  private static final void g(at paramat, View paramView)
  {
    AppMethodBeat.i(338437);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hk((Context)paramat.getActivity());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338437);
  }
  
  private static final void g(at paramat, l.a parama)
  {
    AppMethodBeat.i(338568);
    kotlin.g.b.s.u(paramat, "this$0");
    int i;
    Object localObject;
    label53:
    TextView localTextView;
    if ((parama != null) && (parama.hBY == true))
    {
      i = 1;
      if (i == 0) {
        break label195;
      }
      localObject = (CharSequence)com.tencent.mm.model.z.bAW();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label163;
      }
      i = 1;
      if (i == 0) {
        break label195;
      }
      localObject = paramat.findViewById(e.e.red_pack);
      kotlin.g.b.s.s(localObject, "findViewById<View>(R.id.red_pack)");
      com.tencent.mm.view.f.a((View)localObject, (e.b)new b(paramat));
      paramat.findViewById(e.e.red_pack).setVisibility(0);
      localTextView = (TextView)paramat.findViewById(e.e.red_pack_text);
      localObject = parama.ASg;
      if (localObject != null) {
        break label168;
      }
      localObject = (CharSequence)"";
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      paramat.findViewById(e.e.red_pack).setOnClickListener(new at..ExternalSyntheticLambda1(parama, paramat));
      AppMethodBeat.o(338568);
      return;
      i = 0;
      break;
      label163:
      i = 0;
      break label53;
      label168:
      localObject = ((bxq)localObject).title;
      if (localObject == null) {
        localObject = (CharSequence)"";
      } else {
        localObject = (CharSequence)localObject;
      }
    }
    label195:
    paramat.findViewById(e.e.red_pack).setVisibility(8);
    AppMethodBeat.o(338568);
  }
  
  private static final void h(at paramat, View paramView)
  {
    AppMethodBeat.i(338442);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hl((Context)paramat.getActivity());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338442);
  }
  
  private static final void hl(View paramView)
  {
    AppMethodBeat.i(338522);
    kotlin.g.b.s.u(paramView, "$it");
    paramView.performClick();
    AppMethodBeat.o(338522);
  }
  
  private static final void i(at paramat, View paramView)
  {
    AppMethodBeat.i(338478);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("FinderLiveIncomeEntrance");
    localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveIncomeEntrance");
    int i;
    if ((localObject1 != null) && (localObject2 != null))
    {
      w localw = w.FrV;
      paramView = as.GSQ;
      paramView = as.a.hu((Context)paramat.getActivity());
      if (paramView == null)
      {
        paramView = null;
        w.a(localw, "4", (com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, (bxq)localObject1, 2, paramView, 0, null, 0, 480);
      }
    }
    else
    {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("FinderLiveIncomeEntrance");
      paramView = (CharSequence)paramat.GTC;
      if ((paramView != null) && (paramView.length() != 0)) {
        break label305;
      }
      i = 1;
      label201:
      if (i == 0) {
        break label322;
      }
      paramView = new Intent();
      if (!paramView.getBooleanExtra("key_from_sns_post", false)) {
        break label310;
      }
      paramView.putExtra("key_create_scene", 4);
      label233:
      localObject1 = paramat.AwM;
      if (localObject1 != null) {
        paramView.putExtra("key_prepare_resp", ((bys)localObject1).toByteArray());
      }
      com.tencent.mm.plugin.finder.utils.a.GfO.x((Context)paramat.getActivity(), paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338478);
      return;
      paramView = paramView.fou();
      break;
      label305:
      i = 0;
      break label201;
      label310:
      paramView.putExtra("key_create_scene", 2);
      break label233;
      label322:
      ((com.tencent.mm.plugin.wallet.wecoin.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class)).cj((Context)paramat.getActivity(), "");
      paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.a((Context)paramat.getActivity(), paramat.zVt, false, 2L, 9L, false, 0L);
    }
  }
  
  private static final void j(at paramat, View paramView)
  {
    AppMethodBeat.i(338514);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.efU();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338514);
  }
  
  private static final void k(at paramat, View paramView)
  {
    AppMethodBeat.i(338582);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramView = paramat.AwM;
    if (paramView != null)
    {
      localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.aO((Activity)paramat.getActivity()))
      {
        int i = paramView.actionType;
        Log.i("SimpleUIComponent", kotlin.g.b.s.X("actionType ", Integer.valueOf(i)));
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338582);
      return;
      paramView = paramView.verifyInfo;
      if (paramView != null)
      {
        ((t)com.tencent.mm.kernel.h.ax(t.class)).a((Context)paramat.getActivity(), paramView.appName, "", 0, 0, paramView.ZYG, new AppBrandStatObject());
        continue;
        paramView = new Intent();
        paramView.putExtra("finder_username", paramat.GTC);
        paramView.putExtra("KEY_FINDER_SELF_FLAG", true);
        localObject = as.GSQ;
        as.a.a((Context)paramat.getActivity(), paramView, 0L, 0, false, 124);
        com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)paramat.getActivity(), paramView);
      }
    }
  }
  
  private static final void l(at paramat, View paramView)
  {
    AppMethodBeat.i(338603);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramat);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    localObject2 = new Intent();
    paramView = com.tencent.mm.plugin.finder.api.d.AwY;
    paramView = d.a.auT(com.tencent.mm.model.z.bAW());
    kotlin.g.b.s.checkNotNull(paramView);
    if (paramView.isBlock())
    {
      ((Intent)localObject2).setClass((Context)paramat.getActivity(), FinderExposeUI.class);
      paramat = paramat.getActivity();
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(paramat, paramView.aYi(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "normalOrAbNomalUi$lambda-54", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramat.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramat, "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "normalOrAbNomalUi$lambda-54", "(Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    label311:
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(338603);
      return;
      paramView = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject1 = paramat.GTC;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      paramView = d.a.auW(paramView);
      if (paramView == null) {
        paramView = null;
      }
      for (;;)
      {
        if (paramView != null) {
          break label311;
        }
        a((Intent)localObject2, paramat);
        break;
        if (paramView.Axb == 1)
        {
          paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
          Context localContext = (Context)paramat.getActivity();
          localObject1 = paramat.GTC;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          paramView = Boolean.valueOf(com.tencent.mm.plugin.finder.utils.a.aG(localContext, paramView));
        }
        else
        {
          a((Intent)localObject2, paramat);
          paramView = ah.aiuX;
        }
      }
    }
  }
  
  private static final void m(at paramat, View paramView)
  {
    AppMethodBeat.i(338618);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.efU();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338618);
  }
  
  private static final void n(at paramat, View paramView)
  {
    AppMethodBeat.i(338629);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    new g.a((Context)paramat.getActivity()).bf((CharSequence)"").bDE(paramat.getActivity().getString(e.h.finder_account_in_logout_status_dialog_tips)).aEX(e.h.finder_account_in_logout_confirm).NF(true).b(null).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338629);
  }
  
  private static final void o(at paramat, View paramView)
  {
    AppMethodBeat.i(338636);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramat, "this$0");
    paramat.getIntent().putExtra("finder_username", paramat.GTC);
    paramat.getIntent().putExtra("KEY_FINDER_SELF_FLAG", true);
    paramView = as.GSQ;
    as.a.a((Context)paramat.getActivity(), paramat.getIntent(), 0L, 0, false, 124);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)paramat.getActivity(), paramat.getIntent());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(338636);
  }
  
  public final void a(auw paramauw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(338968);
    kotlin.g.b.s.u(paramauw, "cmdItem");
    Log.i("SimpleUIComponent", kotlin.g.b.s.X("cmdId ", Integer.valueOf(paramauw.cmdId)));
    if (paramauw.cmdId == 101) {
      foL();
    }
    AppMethodBeat.o(338968);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_self_pref;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(338940);
    boolean bool1;
    if (paramIntent == null)
    {
      paramInt2 = 0;
      switch (paramInt1)
      {
      default: 
        bool1 = true;
        bool2 = true;
      }
    }
    for (;;)
    {
      if ((!bool2) || (!bool1))
      {
        Log.i("SimpleUIComponent", "ifFavCountEquals = " + bool2 + ",ifLikeCountEquals = " + bool1);
        doPrepareUser();
      }
      AppMethodBeat.o(338940);
      return;
      paramInt2 = paramIntent.getIntExtra("INNER_ITEM_COUNT", 0);
      break;
      paramIntent = this.AwM;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.aahy == paramInt2) {
          bool1 = true;
        }
      }
      bool3 = true;
      bool2 = bool1;
      bool1 = bool3;
      continue;
      paramIntent = this.AwM;
      bool1 = bool3;
      if (paramIntent != null)
      {
        bool1 = bool3;
        if (paramIntent.aahx == paramInt2) {
          bool1 = true;
        }
      }
      bool2 = true;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338934);
    super.onCreate(paramBundle);
    this.GTM = getIntent().getBooleanExtra("RED_DOT_EXIST_ON_ENTER", false);
    this.zVt = System.currentTimeMillis();
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("TLPersonalCenter");
    this.GTN = getIntent().getBooleanExtra("key_need_done_post_action", false);
    paramBundle = findViewById(e.e.jump_finder_follow);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new at..ExternalSyntheticLambda2(this));
    }
    paramBundle = findViewById(e.e.jump_finder_liked);
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new at..ExternalSyntheticLambda4(this));
    }
    paramBundle = findViewById(e.e.jump_finder_fav);
    paramBundle.setVisibility(0);
    paramBundle.setOnClickListener(new at..ExternalSyntheticLambda11(this));
    Object localObject;
    label306:
    label449:
    com.tencent.mm.plugin.finder.extension.reddot.p localp;
    int i;
    label643:
    label668:
    w localw;
    if ((this.GTW) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()))
    {
      paramBundle = findViewById(e.e.jump_finder_private_msg);
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = findViewById(e.e.jump_finder_private_msg);
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new at..ExternalSyntheticLambda14(this));
      }
      paramBundle = findViewById(e.e.loading_progress_bar);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.loading_progress_bar)");
      this.progressBar = ((ProgressBar)paramBundle);
      findViewById(e.e.jump_finder_wxmsg).setOnClickListener(new at..ExternalSyntheticLambda8(this));
      localObject = (TextView)findViewById(e.e.finder_fav_feed_title_tv);
      if (localObject != null)
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
          break label870;
        }
        paramBundle = (CharSequence)getContext().getString(e.h.finder_fav_feed);
        ((TextView)localObject).setText(paramBundle);
      }
      paramBundle = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZK(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda26(this));
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv.dZd();
      if (!this.GTW) {
        break label887;
      }
      findViewById(e.e.sendMsgLayout).setOnClickListener(new at..ExternalSyntheticLambda5(this));
      findViewById(e.e.sendMsgLayout).setVisibility(0);
      paramBundle = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZN(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda24(this));
      paramBundle = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZO(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda21(this));
      findViewById(e.e.jump_finder_management).setOnClickListener(new at..ExternalSyntheticLambda16(this));
      findViewById(e.e.jump_finder_live_purchase).setOnClickListener(new at..ExternalSyntheticLambda7(this));
      paramBundle = l.ARA;
      com.tencent.mm.ae.d.a((LiveData)l.dZR(), (androidx.lifecycle.q)getActivity(), new at..ExternalSyntheticLambda22(this));
      foH();
      foJ();
      foI();
      foK();
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().a(101, (com.tencent.mm.plugin.finder.api.k)this);
      com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
      localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("TLCamera");
      localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramBundle = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      if ((localObject != null) && (localp != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSi().bmg()).intValue() != 1) {
          break label902;
        }
        i = 0;
        paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)getActivity());
        if (paramBundle != null) {
          break label907;
        }
        paramBundle = null;
        com.tencent.mm.plugin.finder.report.z.a("4", 2, 1, 1, i, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        localw = w.FrV;
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)getActivity());
        if (paramBundle != null) {
          break label915;
        }
      }
    }
    label902:
    label907:
    label915:
    for (paramBundle = null;; paramBundle = paramBundle.fou())
    {
      w.a(localw, "4", localp, (bxq)localObject, 1, paramBundle, 0, null, 0, 480);
      this.GTV = getIntent().getBooleanExtra("key_from_sns_post", false);
      this.GTE = foG().exM();
      this.GTX = getIntent().getBooleanExtra("key_auto_show_post_bottom_sheet", false);
      Log.i("SimpleUIComponent", kotlin.g.b.s.X("needDonePostAction = ", Boolean.valueOf(this.GTN)));
      if (this.GTN)
      {
        this.GTN = false;
        localObject = this.GTF;
        paramBundle = (Bundle)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("finderPosBtn");
          paramBundle = null;
        }
        paramBundle.postDelayed(new at..ExternalSyntheticLambda35(this), 150L);
      }
      AppMethodBeat.o(338934);
      return;
      paramBundle = findViewById(e.e.jump_finder_private_msg);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
      label870:
      paramBundle = (CharSequence)getContext().getString(e.h.finder_fav_feed2);
      break label306;
      label887:
      findViewById(e.e.sendMsgLayout).setVisibility(8);
      break label449;
      i = 1;
      break label643;
      paramBundle = paramBundle.fou();
      break label668;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338987);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension().b(101, (com.tencent.mm.plugin.finder.api.k)this);
    Object localObject = com.tencent.mm.plugin.finder.extension.reddot.m.ASi;
    int i = m.a.eam()[3] + com.tencent.mm.kernel.h.baE().ban().getInt(com.tencent.mm.storage.at.a.adcQ, 0);
    Log.i("SimpleUIComponent", kotlin.g.b.s.X("onDestroy : ", Integer.valueOf(i)));
    if (i <= 0) {
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Nv(2);
    }
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv.dZa();
    ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv.dYZ();
    localObject = this.GTE;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.a.aw)localObject).destroy();
    }
    localObject = com.tencent.mm.media.camera.e.a.nvP;
    com.tencent.mm.media.camera.e.a.bop();
    AppMethodBeat.o(338987);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(338946);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    com.tencent.mm.plugin.findersdk.a.aw localaw = this.GTE;
    if (localaw != null) {
      localaw.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(338946);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338958);
    super.onResume();
    ((com.tencent.mm.plugin.finder.extension.c)((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderSyncExtension()).a(110633, 1, null);
    this.GTC = com.tencent.mm.model.z.bAW();
    Object localObject;
    if (this.AwM != null)
    {
      foL();
      foN();
      localObject = this.GTE;
      if (localObject != null) {
        ((com.tencent.mm.plugin.findersdk.a.aw)localObject).a(this.AwM);
      }
      localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQv;
      ((com.tencent.mm.plugin.finder.extension.reddot.b)localObject).handler.removeMessages(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.b)localObject).handler.sendEmptyMessage(4);
      ((com.tencent.mm.plugin.finder.extension.reddot.b)localObject).handler.removeMessages(6);
      ((com.tencent.mm.plugin.finder.extension.reddot.b)localObject).handler.sendEmptyMessage(6);
      localObject = com.tencent.mm.plugin.finder.report.v.FrN;
      if (!this.GTV) {
        break label315;
      }
      i = 4;
      label139:
      com.tencent.mm.plugin.finder.report.v.T(true, i);
      localObject = this.GTI;
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label320;
      }
    }
    label315:
    label320:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().Dqr)) {
        ((ce)com.tencent.mm.kernel.h.ax(ce.class)).C(q.a.DqD.mwI, "");
      }
      localObject = l.ARA;
      l.avu("CreateFinderEntrance");
      if (((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishPostApi().eKZ())
      {
        localObject = com.tencent.mm.media.camera.e.a.nvP;
        com.tencent.mm.media.camera.f.c.a(com.tencent.mm.media.camera.e.a.bon(), (com.tencent.mm.media.j.a)new com.tencent.mm.plugin.recordvideo.e.a());
      }
      AppMethodBeat.o(338958);
      return;
      if (Util.isNullOrNil(this.GTC))
      {
        ProgressBar localProgressBar = this.progressBar;
        localObject = localProgressBar;
        if (localProgressBar == null)
        {
          kotlin.g.b.s.bIx("progressBar");
          localObject = null;
        }
        ((ProgressBar)localObject).setVisibility(0);
      }
      for (;;)
      {
        doPrepareUser();
        break;
        foL();
      }
      i = 3;
      break label139;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(338979);
    Log.i("SimpleUIComponent", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramp instanceof di))
    {
      ProgressBar localProgressBar = this.progressBar;
      Object localObject = localProgressBar;
      if (localProgressBar == null)
      {
        kotlin.g.b.s.bIx("progressBar");
        localObject = null;
      }
      ((ProgressBar)localObject).setVisibility(8);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.post.g)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.finder.post.g.class)).onSceneEnd(paramInt1, paramInt2, paramString, paramp);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.AwM == null)
        {
          if (paramp == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
            AppMethodBeat.o(338979);
            throw paramString;
          }
          this.AwM = ((di)paramp).dVy();
          foN();
        }
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
          AppMethodBeat.o(338979);
          throw paramString;
        }
        this.AwM = ((di)paramp).dVy();
        paramString = this.GTE;
        if (paramString != null) {
          paramString.a(this.AwM);
        }
        foL();
        AppMethodBeat.o(338979);
        return;
      }
      foN();
      aa.makeText((Context)getActivity(), e.h.finder_prepare_user_failed, 1).show();
    }
    AppMethodBeat.o(338979);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(338950);
    super.onStop();
    this.GTO = false;
    this.GTP = "";
    this.GTQ = "";
    this.GTR = "";
    this.GTS = "";
    this.GTT = "";
    this.GTU = "";
    AppMethodBeat.o(338950);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$Companion;", "", "()V", "BANNER_TYPE_CREATOR_ENTRANCE", "", "BANNER_TYPE_FAV", "BANNER_TYPE_FINDER_MSG", "BANNER_TYPE_FINDER_PRIVATE_MESSAGE", "getBANNER_TYPE_FINDER_PRIVATE_MESSAGE$annotations", "BANNER_TYPE_FOLLOW", "BANNER_TYPE_LIKE", "BANNER_TYPE_LIVE_INCOME", "BANNER_TYPE_WX_MSG", "BANNER_TYPE_WX_PRIVATE_MESSAGE", "lastUrl", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$canPostButNoAccountUi$4$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.b
  {
    b(at paramat) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(337667);
      kotlin.g.b.s.u(paramView, "view");
      bxq localbxq;
      com.tencent.mm.plugin.finder.extension.reddot.p localp;
      w localw;
      if (paramBoolean)
      {
        paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.bB(1, "");
        localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("CreateFinderEntrance");
        localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("CreateFinderEntrance");
        paramView = this.GUa;
        if ((localp != null) && (localbxq != null))
        {
          localw = w.FrV;
          as.a locala = as.GSQ;
          paramView = as.a.hu((Context)paramView.getActivity());
          if (paramView != null) {
            break label129;
          }
        }
      }
      label129:
      for (paramView = null;; paramView = paramView.fou())
      {
        w.a(localw, "4", localp, localbxq, 1, paramView, 0, null, 0, 480);
        AppMethodBeat.o(337667);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(at paramat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(at paramat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostBtnUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.a.av>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderSelfUIC$refreshSelf$3$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends e.b
  {
    f(at paramat) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(337531);
      kotlin.g.b.s.u(paramView, "view");
      if (paramBoolean)
      {
        paramView = as.GSQ;
        paramView = as.a.hu((Context)this.GUa.getActivity());
        if (paramView != null) {
          break label58;
        }
      }
      label58:
      for (paramView = null;; paramView = paramView.fou())
      {
        bb localbb = bb.FuK;
        bb.a(paramView, "biz_identity_tips", 0);
        AppMethodBeat.o(337531);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.at
 * JD-Core Version:    0.7.0.1
 */