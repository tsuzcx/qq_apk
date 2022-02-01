package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.u.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.bb;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.ac;
import com.tencent.mm.plugin.finder.live.report.q.ao;
import com.tencent.mm.plugin.finder.live.report.q.aq;
import com.tencent.mm.plugin.finder.live.report.q.bc;
import com.tencent.mm.plugin.finder.live.report.q.bk;
import com.tencent.mm.plugin.finder.live.report.q.bs;
import com.tencent.mm.plugin.finder.live.report.q.p;
import com.tencent.mm.plugin.finder.live.report.q.q;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.report.q.v;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.r;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveDescEditView;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView.a;
import com.tencent.mm.plugin.finder.live.widget.ad;
import com.tencent.mm.plugin.finder.live.widget.ai;
import com.tencent.mm.plugin.finder.live.widget.al;
import com.tencent.mm.plugin.finder.live.widget.au;
import com.tencent.mm.plugin.finder.live.widget.av;
import com.tencent.mm.plugin.finder.live.widget.x;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.FinderGameEventListener;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.fgt;
import com.tencent.mm.protocal.protobuf.fgv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.an;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "NET_SPEED_TEST_RESULT_DEFAULT", "", "NET_SPEED_TEST_RESULT_FAIL", "NET_SPEED_TEST_RESULT_OK", "SHEET_MORE_ACTION_CAMERA_STATUS", "SHEET_MORE_ACTION_COMMENT", "SHEET_MORE_ACTION_FANS_CLUB", "SHEET_MORE_ACTION_FAST_COMMENT", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_LIKE", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_MUTE", "SHEET_MORE_ACTION_SENSITIVE_WORD", "SHEET_MORE_ACTION_VISIBILITY_MODE", "SHEET_MORE_ACTION_VISITOR_ANONYMOUS", "STATE_DEFAULT", "STATE_LENS", "baseLivePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "cameraOptPanel", "Landroidx/recyclerview/widget/RecyclerView;", "contentRoot", "Landroid/view/View;", "coverWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "descEditView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView;", "getDescEditView", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView;", "setDescEditView", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveDescEditView;)V", "fansClubWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorFansClubWidget;", "fastCommentWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFastCommentWidget;", "gameEventListener", "Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "getGameEventListener", "()Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "setGameEventListener", "(Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;)V", "lastCheckSpeedTime", "", "licensePanelWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "licenseWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "livePostContainer", "liveTagView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "liveTaskBanner", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "locationWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "luckyMoneyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "maskView", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "netSpeedTestResult", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$NetSpeedTestResult;", "noticeLayout", "noticeTimeTxt", "Landroid/widget/TextView;", "onOptionClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "Lkotlin/ParameterName;", "name", "option", "", "onStartLive", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "getOnStartLive", "()Lkotlin/jvm/functions/Function1;", "setOnStartLive", "(Lkotlin/jvm/functions/Function1;)V", "optList", "Ljava/util/ArrayList;", "outerDescEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "postBtn", "postBtnGroup", "postLayout", "redDot", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getSelfContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "state", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "topBackArea", "topContainer", "Landroid/widget/RelativeLayout;", "topGameBtn", "topMoreActionBtn", "visibilityGroup", "visibilityTv", "widgetListener", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "getWidgetListener", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "setWidgetListener", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "GDPRLocationConfirm", "adjustMargin", "afterSelectTagOperation", "beforeLive", "buildConfirmDialog", "checkIsReadyToPost", "", "checkLocationPermission", "checkNetworkAvailable", "checkNetworkSpeed", "checkRedDot", "checkState", "checkVisibilityMode", "anchorChooseMode", "clickLens", "clickMusic", "clickPromotion", "clickShop", "continuePost", "coverUrl", "", "thumbUrl", "path", "md5", "disableComment", "disableGift", "disableLike", "disableLinkMic", "disableScreenShare", "dpToPx", "dp", "enableComment", "enableGift", "enableLike", "enableLinkMic", "enableScreenShare", "initOuterDescEt", "initPostLayout", "rootView", "basePlugin", "initView", "isCommentEnable", "isGiftEnable", "isLikeEnable", "isLinkMicEnable", "isMuteMic", "isScreenShareEnable", "isTagLiveNeedPoi", "isVisitorAnonymousSwitchOn", "loadOptions", "muteMic", "mute", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyboardHeightChanged", "height", "show", "onNewIntent", "intent", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareSecondMenuItems", "prepareSpeedTest", "refreshGroupVisibility", "refreshLuckyMoneyChatroom", "chatroomList", "refreshPostState", "releaseResource", "reportElementExpose", "restorePostUI", "setLiveNoticeInfo", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setLiveTaskInfo", "liveTaskInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "setVisible", "visible", "setupConfig", "showNetworkSpeedTipPanel", "startPost", "switchVisitorAnonymous", "isEnable", "tryStartPost", "tryToPreloadMiniprogram", "updateCoverInfo", "BeforeOptAdapter", "BeforeOptViewHolder", "Companion", "NetSpeedTestResult", "OptionInfo", "WidgetStatusCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends UIComponent
  implements View.OnClickListener, com.tencent.mm.am.h
{
  public static final k.c DYB;
  public static final String TAG;
  private FinderGameEventListener BnV;
  public FinderLiveDescEditView CUD;
  public com.tencent.mm.plugin.finder.live.widget.g CUK;
  private ad CUN;
  private com.tencent.mm.plugin.finder.live.model.context.a CvU;
  public final int DYC;
  private final int DYD;
  private final int DYE;
  private final int DYF;
  private final int DYG;
  private final int DYH;
  private final int DYI;
  private com.tencent.mm.plugin.finder.live.plugin.b DYJ;
  private View DYK;
  private TextView DYL;
  private com.tencent.mm.plugin.finder.live.widget.aw DYM;
  private au DYN;
  private av DYO;
  private ai DYP;
  private RelativeLayout DYQ;
  private View DYR;
  public View DYS;
  private View DYT;
  private TextView DYU;
  public TextView DYV;
  private RecyclerView DYW;
  private View DYX;
  private View DYY;
  private View DYZ;
  private View DZa;
  private com.tencent.mm.plugin.finder.live.widget.bc DZb;
  private al DZc;
  public FinderLiveTaskBannerView DZd;
  private View DZe;
  public MMEditText DZf;
  private ArrayList<k.e> DZg;
  private kotlin.g.a.b<? super k.e, ah> DZh;
  private kotlin.g.a.b<? super FinderObjectDesc, ah> DZi;
  private k.d DZj;
  private long DZk;
  private f DZl;
  private final int DZm;
  private final int DZn;
  private final int DZo;
  private final int DfC;
  private final int DfD;
  private final int DfF;
  private final int DfH;
  private final int DfS;
  private final int DfV;
  private final u.i Dgv;
  private View maskView;
  private View mlS;
  private com.tencent.mm.live.b.b nfT;
  private com.tencent.mm.live.core.core.a.b ngB;
  private com.tencent.mm.ui.widget.a.f ngn;
  public int state;
  
  static
  {
    AppMethodBeat.i(356795);
    DYB = new k.c((byte)0);
    TAG = "Finder.FinderLivePostUIC";
    AppMethodBeat.o(356795);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356297);
    this.DYD = 1;
    this.DfC = 1;
    this.DfD = 3;
    this.DYF = 4;
    this.DYG = 5;
    this.DfF = 6;
    this.DfH = 7;
    this.DYH = 8;
    this.DYI = 10;
    this.DfS = 9;
    this.DfV = 11;
    this.DZg = new ArrayList();
    this.state = this.DYC;
    this.DZj = new k.d((byte)0);
    this.Dgv = new k..ExternalSyntheticLambda7(this, paramAppCompatActivity);
    this.DZl = ((f)new m(this));
    this.DZm = -1;
    this.DZo = 1;
    AppMethodBeat.o(356297);
  }
  
  private static final void W(boolean paramBoolean, String paramString) {}
  
  private static final ah a(k paramk, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(356581);
    kotlin.g.b.s.u(paramk, "this$0");
    Object localObject;
    label137:
    int i;
    label195:
    label197:
    label238:
    boolean bool;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localObject = com.tencent.mm.plugin.finder.utils.t.GgN;
      localObject = ((bil)parama.ott).ZRA;
      kotlin.g.b.s.s(localObject, "it.resp.game_user_info_list");
      localObject = (List)localObject;
      kotlin.g.b.s.u(localObject, "gameList");
      long l = com.tencent.mm.plugin.finder.utils.t.feT();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        ccb localccb = (ccb)localIterator.next();
        if (localccb.aals != null)
        {
          localObject = localccb.aals;
          if (localObject == null)
          {
            localObject = null;
            if (Util.isNullOrNil((String)localObject)) {
              break label195;
            }
            localObject = localccb.aals;
            if (localObject != null) {
              break label197;
            }
            i = 0;
          }
          for (;;)
          {
            if ((l > 0L) && (i > 0))
            {
              if (l > i)
              {
                localLinkedList.add(localccb);
                break;
                localObject = ((cbb)localObject).app_id;
                break label137;
                break;
                i = ((cbb)localObject).aakh;
                continue;
              }
              String str = com.tencent.mm.plugin.finder.utils.t.TAG;
              StringBuilder localStringBuilder = new StringBuilder("filter game by mem: ");
              localObject = localccb.aals;
              if (localObject == null)
              {
                localObject = null;
                localStringBuilder = localStringBuilder.append(localObject).append(", ");
                localObject = localccb.aals;
                if (localObject != null) {
                  break label306;
                }
              }
              label306:
              for (localObject = null;; localObject = Integer.valueOf(((cbb)localObject).aakh))
              {
                Log.i(str, localObject + ", totalMem:" + l);
                break;
                localObject = ((cbb)localObject).xlJ;
                break label238;
              }
            }
          }
          localLinkedList.add(localccb);
        }
      }
      localObject = (List)localLinkedList;
      if (((bil)parama.ott).ZRB != 1) {
        break label462;
      }
      bool = true;
      Log.i(TAG, "CgiFinderLiveGetUserGameConfig game list size: " + ((bil)parama.ott).ZRA + ", after filter:" + Integer.valueOf(((List)localObject).size()) + ", showSearchLayout:" + bool);
      if (!((Collection)localObject).isEmpty()) {
        break label468;
      }
      i = 1;
      label431:
      if (i == 0) {
        break label473;
      }
      paramk = paramk.DZa;
      if (paramk != null) {
        paramk.setVisibility(8);
      }
    }
    for (;;)
    {
      paramk = ah.aiuX;
      AppMethodBeat.o(356581);
      return paramk;
      label462:
      bool = false;
      break;
      label468:
      i = 0;
      break label431;
      label473:
      parama = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.qF(18L);
      parama = paramk.DZa;
      if (parama != null) {
        parama.setVisibility(0);
      }
      parama = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.TU(1);
      parama = paramk.DZa;
      if (parama != null) {
        parama.setOnClickListener(new k..ExternalSyntheticLambda3(bool, paramk, (List)localObject));
      }
    }
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(356543);
    kotlin.g.b.s.u(paramk, "this$0");
    paramk = paramk.DZb;
    if (paramk != null) {
      paramk.eBC();
    }
    AppMethodBeat.o(356543);
  }
  
  private static final void a(k paramk, View paramView)
  {
    AppMethodBeat.i(356551);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramk);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramk, "this$0");
    Log.i(TAG, kotlin.g.b.s.X("netSpeedTestResult:", paramk.DZj));
    paramk.exi();
    paramk = paramk.CUK;
    if (paramk != null) {
      paramk.unMount();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356551);
  }
  
  private static final void a(k paramk, AppCompatActivity paramAppCompatActivity, MenuItem paramMenuItem, int paramInt)
  {
    int j = 0;
    int k = 1;
    int m = 1;
    int n = 1;
    int i1 = 1;
    int i = 1;
    paramInt = 1;
    AppMethodBeat.i(356535);
    kotlin.g.b.s.u(paramk, "this$0");
    kotlin.g.b.s.u(paramAppCompatActivity, "$activity");
    int i2 = paramMenuItem.getItemId();
    Object localObject1;
    if (i2 == paramk.DYE)
    {
      if (paramk.exp())
      {
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuF;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.CnV));
        paramAppCompatActivity = paramk.CvU;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramAppCompatActivity != null) {
            paramAppCompatActivity.Ecp |= 0x8;
          }
        }
      }
      for (;;)
      {
        paramk = paramk.ngn;
        if (paramk != null)
        {
          paramk.cyW();
          paramk = ah.aiuX;
        }
        AppMethodBeat.o(356535);
        return;
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuE;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.CnN));
        paramAppCompatActivity = paramk.CvU;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramAppCompatActivity != null) {
            paramAppCompatActivity.Ecp &= 0xFFFFFFF7;
          }
        }
      }
    }
    if (i2 == paramk.DYI)
    {
      if (paramk.erg()) {
        paramk.ru(false);
      }
      for (;;)
      {
        paramk = paramk.ngn;
        if (paramk != null)
        {
          paramk.cyW();
          paramk = ah.aiuX;
        }
        AppMethodBeat.o(356535);
        return;
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.euI())
        {
          paramAppCompatActivity = new com.tencent.mm.ui.widget.a.j((Context)paramk.getContext(), 2, 2, true, (byte)0);
          paramAppCompatActivity.au((CharSequence)paramk.getContext().getResources().getString(p.h.app_i_know));
          paramAppCompatActivity.aFe(6);
          paramMenuItem = new TextView((Context)paramk.getContext());
          paramMenuItem.setPaddingRelative(paramk.eri(), 0, 0, 0);
          paramMenuItem.setText(p.h.CnR);
          paramMenuItem.setTextColor(paramMenuItem.getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
          paramMenuItem.setTextSize(15.0F);
          localObject1 = ah.aiuX;
          paramAppCompatActivity.setHeaderView((View)paramMenuItem);
          paramMenuItem = new TextView((Context)paramk.getContext());
          paramMenuItem.setText(p.h.CnS);
          paramMenuItem.setTextColor(paramMenuItem.getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
          paramMenuItem.setTextSize(15.0F);
          localObject1 = ah.aiuX;
          paramAppCompatActivity.setCustomView((View)paramMenuItem);
          paramAppCompatActivity.agfR = new k..ExternalSyntheticLambda12(paramAppCompatActivity, paramk);
          paramAppCompatActivity.dDn();
        }
        else
        {
          paramk.ru(true);
        }
      }
    }
    if (i2 == paramk.DYH)
    {
      if (paramk.exq())
      {
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuN;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.CnX));
        paramAppCompatActivity = paramk.CvU;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramAppCompatActivity != null) {
            paramAppCompatActivity.Ecp |= 0x200;
          }
        }
        paramAppCompatActivity = paramk.nfT;
        if ((paramAppCompatActivity != null) && (paramAppCompatActivity.getLiveRole() == 1)) {
          if (paramInt != 0) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqX.mwI, String.valueOf(q.ao.DyK.type));
          }
        }
      }
      label820:
      for (;;)
      {
        paramk = paramk.ngn;
        if (paramk != null)
        {
          paramk.cyW();
          paramk = ah.aiuX;
        }
        AppMethodBeat.o(356535);
        return;
        paramInt = 0;
        break;
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuM;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.CnP));
        paramAppCompatActivity = paramk.CvU;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramAppCompatActivity != null) {
            paramAppCompatActivity.Ecp &= 0xFFFFFDFF;
          }
        }
        paramAppCompatActivity = paramk.nfT;
        if ((paramAppCompatActivity != null) && (paramAppCompatActivity.getLiveRole() == 1)) {}
        for (paramInt = k;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label820;
          }
          com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqX.mwI, String.valueOf(q.ao.DyJ.type));
          break;
        }
      }
    }
    if (i2 == paramk.DfC)
    {
      if (paramk.exo())
      {
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuJ;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.ClG));
        paramk.exn();
        paramAppCompatActivity = paramk.nfT;
        if ((paramAppCompatActivity != null) && (paramAppCompatActivity.getLiveRole() == 1))
        {
          paramInt = m;
          if (paramInt != 0) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqR.mwI, String.valueOf(q.aq.Dzc.action));
          }
        }
      }
      label1100:
      for (;;)
      {
        paramk = paramk.ngn;
        if (paramk != null)
        {
          paramk.cyW();
          paramk = ah.aiuX;
        }
        AppMethodBeat.o(356535);
        return;
        paramInt = 0;
        break;
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuI;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.ClH));
        paramAppCompatActivity = paramk.CvU;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
          if (paramAppCompatActivity != null) {
            paramAppCompatActivity.Ecp |= 0x40;
          }
        }
        paramAppCompatActivity = paramk.nfT;
        if ((paramAppCompatActivity != null) && (paramAppCompatActivity.getLiveRole() == 1)) {}
        for (paramInt = n;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1100;
          }
          com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqR.mwI, String.valueOf(q.aq.Dzb.action));
          break;
        }
      }
    }
    Object localObject2;
    if (i2 == paramk.DfD)
    {
      if (paramk.exs())
      {
        paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramMenuItem = q.s.DuL;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.CkL));
        paramk.exr();
        paramAppCompatActivity = paramk.nfT;
        if ((paramAppCompatActivity != null) && (paramAppCompatActivity.getLiveRole() == 1)) {}
        for (paramInt = i1;; paramInt = 0)
        {
          if (paramInt != 0) {
            com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqS.mwI, String.valueOf(q.ac.DxM.action));
          }
          paramk = paramk.ngn;
          if (paramk != null)
          {
            paramk.cyW();
            paramk = ah.aiuX;
          }
          AppMethodBeat.o(356535);
          return;
        }
      }
      paramAppCompatActivity = paramk.CvU;
      if (paramAppCompatActivity == null) {
        break label2130;
      }
      paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramAppCompatActivity == null) {
        break label2130;
      }
      paramAppCompatActivity = paramAppCompatActivity.EcQ;
      if (paramAppCompatActivity == null) {
        break label2130;
      }
      if (paramAppCompatActivity.ZFp) {
        break label2125;
      }
      paramMenuItem = new com.tencent.mm.ui.widget.a.j((Context)paramk.getContext(), 2, 2, true, (byte)0);
      paramMenuItem.au((CharSequence)paramk.getContext().getResources().getString(p.h.app_i_know));
      paramMenuItem.aFe(6);
      localObject1 = new TextView((Context)paramk.getContext());
      ((TextView)localObject1).setPaddingRelative(paramk.eri(), 0, 0, 0);
      ((TextView)localObject1).setText(p.h.Cog);
      ((TextView)localObject1).setTextColor(((TextView)localObject1).getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
      ((TextView)localObject1).setTextSize(17.0F);
      localObject2 = ah.aiuX;
      paramMenuItem.setHeaderView((View)localObject1);
      localObject1 = new TextView((Context)paramk.getContext());
      paramAppCompatActivity = paramAppCompatActivity.error_msg;
      if (paramAppCompatActivity == null)
      {
        paramAppCompatActivity = (CharSequence)"";
        label1439:
        ((TextView)localObject1).setText(paramAppCompatActivity);
        ((TextView)localObject1).setTextColor(((TextView)localObject1).getContext().getResources().getColor(p.b.hot_tab_BW_100_Alpha_0_8));
        ((TextView)localObject1).setTextSize(15.0F);
        paramAppCompatActivity = ah.aiuX;
        paramMenuItem.setCustomView((View)localObject1);
        paramMenuItem.agfR = new k..ExternalSyntheticLambda11(paramMenuItem);
        paramMenuItem.dDn();
        paramAppCompatActivity = paramk.ngn;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity.cyW();
          paramAppCompatActivity = ah.aiuX;
        }
        paramInt = 1;
        label1520:
        paramAppCompatActivity = ah.aiuX;
        paramAppCompatActivity = ah.aiuX;
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        AppMethodBeat.o(356535);
        return;
        paramAppCompatActivity = (CharSequence)paramAppCompatActivity;
        break label1439;
      }
      paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramMenuItem = q.s.DuK;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      aa.db((Context)paramk.getContext(), paramk.getContext().getResources().getString(p.h.CkQ));
      paramAppCompatActivity = paramk.CvU;
      if (paramAppCompatActivity != null)
      {
        paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramAppCompatActivity.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (paramAppCompatActivity != null) {
          paramAppCompatActivity.Ecp |= 0x80;
        }
      }
      paramAppCompatActivity = paramk.nfT;
      if ((paramAppCompatActivity != null) && (paramAppCompatActivity.getLiveRole() == 1)) {}
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label1683;
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqS.mwI, String.valueOf(q.ac.DxN.action));
        break;
      }
      label1683:
      break;
      if (i2 == paramk.DfH)
      {
        if (paramk.ext())
        {
          paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem = q.s.DuB;
          localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
          paramk.sg(false);
        }
        for (;;)
        {
          paramk = paramk.ngn;
          if (paramk != null)
          {
            paramk.cyW();
            paramk = ah.aiuX;
          }
          AppMethodBeat.o(356535);
          return;
          paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem = q.s.DuA;
          localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
          paramk.sg(true);
        }
      }
      if (i2 != paramk.DYF)
      {
        if (i2 == paramk.DfS)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject1 = q.s.DuP;
          localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem.a((q.s)localObject1, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
          if (paramk.CUK == null)
          {
            paramMenuItem = (Activity)paramAppCompatActivity;
            paramAppCompatActivity = paramAppCompatActivity.findViewById(16908290);
            kotlin.g.b.s.s(paramAppCompatActivity, "activity.findViewById(android.R.id.content)");
            paramk.CUK = new com.tencent.mm.plugin.finder.live.widget.g(paramMenuItem, (ViewGroup)paramAppCompatActivity);
          }
          paramAppCompatActivity = aj.CGT;
          paramAppCompatActivity = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
          paramInt = j;
          if (paramAppCompatActivity != null)
          {
            paramAppCompatActivity = paramAppCompatActivity.Efg;
            paramInt = j;
            if (paramAppCompatActivity != null)
            {
              paramInt = j;
              if (paramAppCompatActivity.ZQo == true) {
                paramInt = 1;
              }
            }
          }
          if (paramInt != 0)
          {
            paramAppCompatActivity = paramk.CUK;
            if (paramAppCompatActivity != null)
            {
              paramAppCompatActivity.sw(true);
              paramAppCompatActivity = ah.aiuX;
            }
          }
          for (;;)
          {
            paramAppCompatActivity = paramk.ngn;
            if (paramAppCompatActivity != null)
            {
              paramAppCompatActivity.cyW();
              paramAppCompatActivity = ah.aiuX;
            }
            paramk = paramk.mlS;
            if (paramk == null) {
              break;
            }
            paramk.setVisibility(8);
            AppMethodBeat.o(356535);
            return;
            paramAppCompatActivity = paramk.CUK;
            if (paramAppCompatActivity != null)
            {
              paramAppCompatActivity = paramAppCompatActivity.ElO;
              if (paramAppCompatActivity != null)
              {
                paramAppCompatActivity.show();
                paramAppCompatActivity = ah.aiuX;
              }
            }
          }
        }
        if (i2 == paramk.DfV)
        {
          paramAppCompatActivity = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramMenuItem = q.s.DuG;
          localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramAppCompatActivity.a(paramMenuItem, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
          if (paramk.CUN == null)
          {
            paramAppCompatActivity = paramk.CvU;
            if (paramAppCompatActivity != null) {
              break label2106;
            }
          }
        }
      }
      label2106:
      for (paramAppCompatActivity = null;; paramAppCompatActivity = new ad((Context)paramk.getContext(), paramAppCompatActivity))
      {
        paramk.CUN = paramAppCompatActivity;
        paramAppCompatActivity = paramk.CUN;
        if (paramAppCompatActivity != null)
        {
          paramAppCompatActivity.show();
          paramAppCompatActivity = ah.aiuX;
        }
        paramk = paramk.ngn;
        if (paramk != null)
        {
          paramk.cyW();
          paramk = ah.aiuX;
        }
        AppMethodBeat.o(356535);
        return;
      }
      label2125:
      paramInt = 0;
      break label1520;
      label2130:
      paramInt = 0;
    }
  }
  
  private static final void a(k paramk, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(356631);
    kotlin.g.b.s.u(paramk, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    com.tencent.mm.plugin.finder.live.report.j localj;
    if (paramk.ext())
    {
      localObject1 = paramk.getContext().getResources().getString(p.h.CnY);
      kotlin.g.b.s.s(localObject1, "context.resources.getStr…_more_action_cancel_mute)");
      i = p.g.icons_outlined_mic_on;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.DvN;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      params.a(paramk.DfH, (CharSequence)localObject1, i, Color.parseColor("#CCFFFFFF"));
      localObject1 = paramk.CvU;
      if (localObject1 == null) {
        break label385;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (localObject1 == null) {
        break label385;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)localObject1).Efg;
      if ((localObject1 == null) || (((bgw)localObject1).ZQq != true)) {
        break label385;
      }
    }
    label385:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = paramk.getContext().getResources().getString(p.h.Cof);
        kotlin.g.b.s.s(localObject1, "context.resources.getStr…er_live_more_action_fans)");
        params.a(paramk.DfS, (CharSequence)localObject1, p.g.icons_outlined_fans, Color.parseColor("#CCFFFFFF"));
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.Dra.mwI, "1");
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject2 = q.t.Dwb;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      }
      localObject1 = paramk.getContext().getResources().getString(p.h.Cko);
      kotlin.g.b.s.s(localObject1, "context.resources.getStr…finder_live_fast_comment)");
      localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jRP().bmg()).intValue() == 1)
      {
        params.a(paramk.DfV, (CharSequence)localObject1, p.g.icons_outlined_fast_comment, Color.parseColor("#CCFFFFFF"));
        paramk = com.tencent.mm.plugin.finder.live.report.j.Dob;
        params = q.t.DvZ;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramk.a(params, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      }
      AppMethodBeat.o(356631);
      return;
      localObject1 = paramk.getContext().getResources().getString(p.h.Cop);
      kotlin.g.b.s.s(localObject1, "context.resources.getStr…er_live_more_action_mute)");
      i = p.g.icons_outlined_mic_off;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.DvM;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      break;
    }
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.j paramj, k paramk)
  {
    AppMethodBeat.i(356505);
    kotlin.g.b.s.u(paramj, "$dialog");
    kotlin.g.b.s.u(paramk, "this$0");
    paramj.cyW();
    paramj = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.euJ();
    paramk.ru(true);
    AppMethodBeat.o(356505);
  }
  
  private static final void a(boolean paramBoolean, k paramk, List paramList, View paramView)
  {
    AppMethodBeat.i(356566);
    kotlin.g.b.s.u(paramk, "this$0");
    kotlin.g.b.s.u(paramList, "$gameList");
    paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
    com.tencent.mm.plugin.finder.utils.s.TU(2);
    paramView = new Intent();
    bil localbil = new bil();
    localbil.ZRA.addAll((Collection)paramList);
    paramView.putExtra("APP_LIST", localbil.toByteArray());
    paramView.putExtra("SHOW_SEARCH_LAYOUT", paramBoolean);
    ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).u((Context)paramk.getContext(), paramView);
    paramk.BnV = new FinderGameEventListener(new WeakReference(paramk.getContext()));
    paramk = paramk.BnV;
    if (paramk != null) {
      paramk.alive();
    }
    AppMethodBeat.o(356566);
  }
  
  private final void aB(LinkedList<blk> paramLinkedList)
  {
    AppMethodBeat.i(356354);
    if (paramLinkedList == null) {
      paramLinkedList = null;
    }
    for (;;)
    {
      if (paramLinkedList == null)
      {
        paramLinkedList = ((k)this).DZd;
        if (paramLinkedList != null) {
          paramLinkedList.setVisibility(8);
        }
      }
      AppMethodBeat.o(356354);
      return;
      int i;
      if (!((Collection)paramLinkedList).isEmpty())
      {
        i = 1;
        label55:
        if (i == 0) {
          break label73;
        }
      }
      for (;;)
      {
        if (paramLinkedList != null) {
          break label78;
        }
        paramLinkedList = null;
        break;
        i = 0;
        break label55;
        label73:
        paramLinkedList = null;
      }
      label78:
      Object localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label163:
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        blk localblk = (blk)localObject2;
        if ((localblk.ZUB == -1) || (localblk.ZUB > 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label163;
          }
          paramLinkedList.add(localObject2);
          break;
        }
      }
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramLinkedList.add(new FinderLiveTaskBannerView.a((blk)((Iterator)localObject1).next()));
      }
      paramLinkedList = (List)paramLinkedList;
      localObject1 = this.DZd;
      if (localObject1 != null) {
        ((FinderLiveTaskBannerView)localObject1).setVisibility(0);
      }
      localObject1 = this.DZd;
      if (localObject1 == null)
      {
        paramLinkedList = null;
      }
      else
      {
        ((FinderLiveTaskBannerView)localObject1).setTaskInfoList(paramLinkedList);
        paramLinkedList = ah.aiuX;
      }
    }
  }
  
  private final void am(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(356395);
    Object localObject = this.CvU;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EdQ;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.n)localObject).EbY;
          if (localObject != null) {
            ((LinkedList)localObject).clear();
          }
        }
      }
    }
    if (paramArrayList != null)
    {
      localObject = this.CvU;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).EdQ;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.n)localObject).EbY;
            if (localObject != null) {
              ((LinkedList)localObject).addAll((Collection)paramArrayList);
            }
          }
        }
      }
    }
    paramArrayList = this.DZc;
    if (paramArrayList != null) {
      paramArrayList.eBb();
    }
    AppMethodBeat.o(356395);
  }
  
  private static final Object b(k paramk, com.tencent.mm.am.b.a parama)
  {
    int m = 0;
    AppMethodBeat.i(356590);
    kotlin.g.b.s.u(paramk, "this$0");
    Log.i(TAG, "CgiTestClientSpeed errType:" + parama.errType + " errCode:" + parama.errCode);
    if (parama == null)
    {
      AppMethodBeat.o(356590);
      return null;
    }
    Object localObject2 = (add)parama.ott;
    if (localObject2 == null)
    {
      AppMethodBeat.o(356590);
      return null;
    }
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = com.tencent.mm.kernel.h.baD();
      if (parama == null)
      {
        AppMethodBeat.o(356590);
        return null;
      }
      parama = parama.mCm;
      if (parama == null)
      {
        AppMethodBeat.o(356590);
        return null;
      }
      com.tencent.mm.network.g localg = parama.oun;
      if (localg == null)
      {
        AppMethodBeat.o(356590);
        return null;
      }
      parama = ((add)localObject2).ZlH;
      Object localObject1;
      int i;
      label183:
      int j;
      label197:
      int k;
      if (parama == null)
      {
        parama = "";
        localObject1 = ((add)localObject2).ZlH;
        if (localObject1 != null) {
          break label355;
        }
        i = 0;
        localObject1 = ((add)localObject2).ZlI;
        if (localObject1 != null) {
          break label364;
        }
        j = 0;
        localObject1 = ((add)localObject2).ZlH;
        if (localObject1 != null) {
          break label373;
        }
        k = 0;
        label212:
        localObject1 = ((add)localObject2).ZlI;
        if (localObject1 != null) {
          break label383;
        }
        label224:
        localObject1 = ((add)localObject2).ZlH;
        if (localObject1 != null) {
          break label393;
        }
        localObject1 = null;
        label239:
        localObject2 = ((add)localObject2).ZlH;
        if (localObject2 != null) {
          break label421;
        }
        localObject2 = null;
      }
      for (;;)
      {
        i = localg.doLiveSpeedTest(parama, i, j, k, m, (byte[])localObject1, (byte[])localObject2, (com.tencent.mm.network.u)new j(paramk));
        AppMethodBeat.o(356590);
        return Integer.valueOf(i);
        parama = parama.abHa;
        if (parama == null)
        {
          parama = "";
          break;
        }
        parama = (fgt)kotlin.a.p.ae((List)parama, 0);
        if (parama == null)
        {
          parama = "";
          break;
        }
        localObject1 = parama.ip;
        parama = (com.tencent.mm.am.b.a)localObject1;
        if (localObject1 != null) {
          break;
        }
        parama = "";
        break;
        label355:
        i = ((fgv)localObject1).abHb;
        break label183;
        label364:
        j = ((fgv)localObject1).abHb;
        break label197;
        label373:
        k = ((fgv)localObject1).ZlG;
        break label212;
        label383:
        m = ((fgv)localObject1).ZlG;
        break label224;
        label393:
        localObject1 = ((fgv)localObject1).aaPP;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label239;
        }
        localObject1 = ((com.tencent.mm.bx.b)localObject1).toByteArray();
        break label239;
        label421:
        localObject2 = ((fgv)localObject2).aaPP;
        if (localObject2 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((com.tencent.mm.bx.b)localObject2).toByteArray();
        }
      }
    }
    paramk.DZj.DZt = 0;
    paramk.DZj.DZs = paramk.DZo;
    paramk = ah.aiuX;
    AppMethodBeat.o(356590);
    return paramk;
  }
  
  private static final void b(k paramk)
  {
    AppMethodBeat.i(356655);
    kotlin.g.b.s.u(paramk, "this$0");
    com.tencent.mm.live.b.b localb = paramk.nfT;
    if (localb != null) {
      b.b.a(localb, b.c.nec);
    }
    paramk.ngn = null;
    AppMethodBeat.o(356655);
  }
  
  private static final void b(k paramk, View paramView)
  {
    AppMethodBeat.i(356600);
    kotlin.g.b.s.u(paramk, "this$0");
    kotlin.g.b.s.u(paramView, "$it");
    Object localObject = paramk.DYQ;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((RelativeLayout)localObject).getLayoutParams())
    {
      paramk = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(356600);
      throw paramk;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    int i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (bf.getStatusBarHeight((Context)paramk.getActivity()) + i);
    i = paramView.getPaddingLeft();
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    paramView.setPadding(i, j, k, bf.bk((Context)paramk.getActivity()) + m);
    AppMethodBeat.o(356600);
  }
  
  private static final void b(k paramk, com.tencent.mm.ui.base.s params)
  {
    long l2 = 0L;
    AppMethodBeat.i(356647);
    kotlin.g.b.s.u(paramk, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = paramk.exh();
    long l1;
    int i;
    com.tencent.mm.plugin.finder.live.report.j localj1;
    q.t localt;
    com.tencent.mm.plugin.finder.live.report.j localj2;
    if (localObject == null)
    {
      l1 = 0L;
      if (com.tencent.mm.plugin.finder.live.utils.a.oM(l1))
      {
        if (!paramk.exo()) {
          break label559;
        }
        localObject = paramk.getContext().getResources().getString(p.h.Coc);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…_action_disable_link_mic)");
        i = p.g.finder_live_unmic;
        localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localt = q.t.DvT;
        localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        label114:
        params.a(paramk.DfC, (CharSequence)localObject, i, Color.parseColor("#CCFFFFFF"));
      }
      localObject = com.tencent.mm.plugin.finder.live.util.u.DJC;
      localObject = paramk.exh();
      if (localObject != null) {
        break label617;
      }
      l1 = 0L;
      label153:
      if (com.tencent.mm.plugin.finder.live.util.u.oE(l1))
      {
        if (!paramk.exs()) {
          break label626;
        }
        localObject = paramk.getContext().getResources().getString(p.h.Cob);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…more_action_disable_gift)");
        i = p.g.finder_live_ungift;
        localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localt = q.t.DvV;
        localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        label222:
        params.a(paramk.DfD, (CharSequence)localObject, i, Color.parseColor("#CCFFFFFF"));
      }
      if (!paramk.exp()) {
        break label684;
      }
      localObject = paramk.getContext().getResources().getString(p.h.CnU);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…_more_action_ban_comment)");
      i = p.g.icon_outlined_close_comment;
      localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localt = q.t.DvR;
      localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      label305:
      params.a(paramk.DYE, (CharSequence)localObject, i, Color.parseColor("#CCFFFFFF"));
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = paramk.exh();
      if (localObject != null) {
        break label742;
      }
      l1 = 0L;
      label344:
      if (com.tencent.mm.plugin.finder.live.utils.a.oN(l1))
      {
        if (!paramk.exq()) {
          break label751;
        }
        localObject = paramk.getContext().getResources().getString(p.h.CnW);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…ive_more_action_ban_like)");
        i = p.g.icons_outlined_favour_off;
        localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localt = q.t.DvX;
        localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        params.a(paramk.DYH, (CharSequence)localObject, i, Color.parseColor("#CCFFFFFF"));
      }
      label413:
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject = paramk.exh();
      if (localObject != null) {
        break label809;
      }
      l1 = l2;
      label453:
      if (com.tencent.mm.plugin.finder.live.utils.a.oP(l1))
      {
        if (!paramk.erg()) {
          break label818;
        }
        localObject = paramk.getContext().getResources().getString(p.h.CnQ);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…action_anonymous_disable)");
        i = p.g.finder_live_anonymous_1;
        localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localt = q.t.Dwo;
        localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      }
    }
    for (;;)
    {
      params.a(paramk.DYI, (CharSequence)localObject, i, Color.parseColor("#CCFFFFFF"));
      AppMethodBeat.o(356647);
      return;
      l1 = ((com.tencent.mm.plugin.finder.api.m)localObject).field_liveSwitchFlag;
      break;
      label559:
      localObject = paramk.getContext().getResources().getString(p.h.Coe);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…e_action_enable_link_mic)");
      i = p.g.finder_icons_request_link_mic;
      localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localt = q.t.DvS;
      localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      break label114;
      label617:
      l1 = ((com.tencent.mm.plugin.finder.api.m)localObject).field_liveSwitchFlag;
      break label153;
      label626:
      localObject = paramk.getContext().getResources().getString(p.h.Cod);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…_more_action_enable_gift)");
      i = p.g.finder_live_gift;
      localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localt = q.t.DvU;
      localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      break label222;
      label684:
      localObject = paramk.getContext().getResources().getString(p.h.CnM);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…ore_action_allow_comment)");
      i = p.g.icons_outlined_comment;
      localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localt = q.t.DvQ;
      localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      break label305;
      label742:
      l1 = ((com.tencent.mm.plugin.finder.api.m)localObject).field_liveSwitchFlag;
      break label344;
      label751:
      localObject = paramk.getContext().getResources().getString(p.h.CnO);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…e_more_action_allow_like)");
      i = p.g.icons_outlined_favour_on;
      localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localt = q.t.DvW;
      localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      break label413;
      label809:
      l1 = ((com.tencent.mm.plugin.finder.api.m)localObject).field_liveSwitchFlag;
      break label453;
      label818:
      localObject = paramk.getContext().getResources().getString(p.h.CnR);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…_action_anonymous_enable)");
      i = p.g.finder_live_anonymous_0;
      localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localt = q.t.Dwn;
      localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
    }
  }
  
  private static final void c(k paramk, View paramView)
  {
    AppMethodBeat.i(356619);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramk);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramk, "this$0");
    Log.i(TAG, "visibilityGroup click");
    localObject1 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    localObject2 = paramk.getContext();
    Intent localIntent = new Intent();
    paramView = a.d.HbG;
    String str = a.d.frh();
    paramView = paramk.CvU;
    if (paramView == null)
    {
      paramView = null;
      if (!(paramView instanceof Serializable)) {
        break label454;
      }
      paramView = (Serializable)paramView;
      label124:
      localIntent.putExtra(str, paramView);
      paramView = a.d.HbG;
      str = a.d.fri();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label459;
      }
      paramView = null;
      label153:
      if (!(paramView instanceof Serializable)) {
        break label487;
      }
      paramView = (Serializable)paramView;
      label165:
      localIntent.putExtra(str, paramView);
      paramView = a.d.HbG;
      str = a.d.frl();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label492;
      }
      paramView = null;
      label194:
      localIntent.putExtra(str, (Serializable)paramView);
      paramView = a.d.HbG;
      str = a.d.frj();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label523;
      }
      paramView = null;
      label226:
      localIntent.putStringArrayListExtra(str, paramView);
      paramView = a.d.HbG;
      str = a.d.frk();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label551;
      }
      paramView = null;
      label255:
      localIntent.putStringArrayListExtra(str, paramView);
      paramView = a.d.HbG;
      str = a.d.frm();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label579;
      }
      paramView = null;
      label284:
      localIntent.putExtra(str, paramView);
      paramView = a.d.HbG;
      str = a.d.frn();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label621;
      }
      paramView = null;
      label313:
      localIntent.putExtra(str, paramView);
      paramView = a.d.HbG;
      str = a.d.frg();
      paramView = paramk.CvU;
      if (paramView != null) {
        break label663;
      }
      paramView = null;
      label342:
      localIntent.putExtra(str, (Serializable)paramView);
      paramView = a.d.HbG;
      paramView = a.d.frf();
      paramk = paramk.CvU;
      if (paramk != null) {
        break label694;
      }
      paramk = null;
    }
    for (;;)
    {
      localIntent.putExtra(paramView, (Serializable)paramk);
      paramk = ah.aiuX;
      ((com.tencent.mm.plugin.f)localObject1).g((Activity)localObject2, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356619);
      return;
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break;
      }
      paramView = paramView.Eiq;
      break;
      label454:
      paramView = null;
      break label124;
      label459:
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break label153;
      }
      paramView = paramView.Eir;
      break label153;
      label487:
      paramView = null;
      break label165;
      label492:
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramView == null)
      {
        paramView = null;
        break label194;
      }
      paramView = Integer.valueOf(paramView.CFh);
      break label194;
      label523:
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break label226;
      }
      paramView = paramView.Eit;
      break label226;
      label551:
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break label255;
      }
      paramView = paramView.Eiu;
      break label255;
      label579:
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break label284;
      }
      paramView = paramView.CJb;
      if (paramView == null)
      {
        paramView = null;
        break label284;
      }
      paramView = paramView.toByteArray();
      break label284;
      label621:
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break label313;
      }
      paramView = paramView.Eiw;
      if (paramView == null)
      {
        paramView = null;
        break label313;
      }
      paramView = paramView.toByteArray();
      break label313;
      label663:
      paramView = (r)paramView.business(r.class);
      if (paramView == null)
      {
        paramView = null;
        break label342;
      }
      paramView = Integer.valueOf(paramView.Eis);
      break label342;
      label694:
      paramk = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramk.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramk == null) {
        paramk = null;
      } else {
        paramk = Integer.valueOf(paramk.CFg);
      }
    }
  }
  
  private final boolean erg()
  {
    AppMethodBeat.i(356430);
    Object localObject = this.CvU;
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.ae.d.ee(i, 8192);
      AppMethodBeat.o(356430);
      return bool;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp;
      }
    }
  }
  
  private final int eri()
  {
    AppMethodBeat.i(356313);
    int i = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 24);
    AppMethodBeat.o(356313);
    return i;
  }
  
  private final void exa()
  {
    String str = null;
    int i = 1;
    AppMethodBeat.i(356483);
    Object localObject1 = this.DYN;
    Object localObject2;
    if ((localObject1 != null) && (((au)localObject1).eBl() == true))
    {
      if (i == 0) {
        break label201;
      }
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("choose live cover:");
      localObject1 = this.DYN;
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = null;
      label59:
      localStringBuilder = localStringBuilder.append(localObject1).append(", ");
      localObject1 = this.DYN;
      if (localObject1 != null) {
        break label175;
      }
      localObject1 = str;
      label84:
      Log.i((String)localObject2, localObject1);
      localObject2 = ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager();
      localObject1 = this.DYN;
      if (localObject1 != null) {
        break label183;
      }
      localObject1 = "";
    }
    for (;;)
    {
      str = z.bAW();
      kotlin.g.b.s.s(str, "getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.publish.b)localObject2).h((String)localObject1, str, new k(this));
      AppMethodBeat.o(356483);
      return;
      i = 0;
      break;
      label167:
      localObject1 = ((au)localObject1).Ebq;
      break label59;
      label175:
      localObject1 = ((au)localObject1).nVM;
      break label84;
      label183:
      str = ((au)localObject1).Ebq;
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
    }
    label201:
    localObject1 = this.DYN;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      t((String)localObject1, (String)localObject1, "", "");
      Log.i(TAG, kotlin.g.b.s.X("choose default cover:", localObject1));
      AppMethodBeat.o(356483);
      return;
      str = ((au)localObject1).eBm();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
    }
  }
  
  private final com.tencent.mm.plugin.finder.api.m exh()
  {
    AppMethodBeat.i(356309);
    Object localObject = this.CvU;
    if (localObject == null)
    {
      AppMethodBeat.o(356309);
      return null;
    }
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    if (localObject == null)
    {
      AppMethodBeat.o(356309);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eej;
    AppMethodBeat.o(356309);
    return localObject;
  }
  
  private final void exi()
  {
    View localView = null;
    Object localObject3 = null;
    int j = 1;
    AppMethodBeat.i(356341);
    Object localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Boolean)com.tencent.d.a.a.a.a.a.jUB().bmg()).booleanValue())
    {
      localObject1 = this.DYX;
      if (localObject1 != null) {
        ((View)localObject1).setEnabled(false);
      }
      exa();
      AppMethodBeat.o(356341);
      return;
    }
    Object localObject2;
    if (exx())
    {
      localObject1 = this;
      localObject1 = (k)localObject1;
      if (localObject1 == null) {
        break label328;
      }
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      if (!((com.tencent.mm.plugin.finder.api.g)com.tencent.mm.ui.component.k.cn(cn.class).cq(com.tencent.mm.plugin.finder.api.g.class)).dUi()) {
        break label244;
      }
      label112:
      if (localObject1 == null) {
        break label328;
      }
      localObject2 = this.DYM;
      if (localObject2 != null) {
        break label250;
      }
      localObject2 = null;
      label131:
      localObject2 = (CharSequence)localObject2;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label278;
      }
      i = 1;
      label155:
      if (i == 0) {
        break label283;
      }
      label159:
      if (localObject1 == null) {
        break label328;
      }
      localObject2 = this.DYM;
      if (localObject2 != null) {
        break label289;
      }
      localObject2 = null;
      label178:
      localObject2 = (CharSequence)localObject2;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label317;
      }
      i = 1;
      label202:
      if (i == 0) {
        break label322;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label328;
      }
      aa.showTextToast((Context)getContext(), getContext().getString(p.h.Cnh));
      AppMethodBeat.o(356341);
      return;
      localObject1 = null;
      break;
      label244:
      localObject1 = null;
      break label112;
      label250:
      localObject2 = ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).getLocation();
      if (localObject2 == null)
      {
        localObject2 = null;
        break label131;
      }
      localObject2 = ((boi)localObject2).city;
      break label131;
      label278:
      i = 0;
      break label155;
      label283:
      localObject1 = null;
      break label159;
      label289:
      localObject2 = ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).getLocation();
      if (localObject2 == null)
      {
        localObject2 = null;
        break label178;
      }
      localObject2 = ((boi)localObject2).poiName;
      break label178;
      label317:
      i = 0;
      break label202;
      label322:
      localObject1 = null;
    }
    label328:
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      localObject1 = new g.a((Context)getActivity());
      ((g.a)localObject1).Xdm = true;
      ((g.a)localObject1).bDE(getActivity().getResources().getString(p.h.Cld)).bDI(getActivity().getResources().getString(p.h.app_i_know)).b(k..ExternalSyntheticLambda9.INSTANCE).show();
      AppMethodBeat.o(356341);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.DZk;
    localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    if (l1 - l2 > ((Number)com.tencent.d.a.a.a.a.a.jUP().bmg()).intValue()) {
      if (this.DZj.DZs == this.DZn)
      {
        i = this.DZj.DZt;
        localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
        if (i >= ((Number)com.tencent.d.a.a.a.a.a.jUO().bmg()).intValue()) {}
      }
      else
      {
        if ((this.DZj.DZs != this.DZo) && (this.DZj.DZs != this.DZm)) {
          break label710;
        }
      }
    }
    int i = 1;
    if (i == 0)
    {
      com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqZ.mwI, String.valueOf(q.bc.DAz.action));
      this.DZk = System.currentTimeMillis();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adbD, Long.valueOf(this.DZk));
      localObject2 = new com.tencent.mm.ui.widget.a.j((Context)getContext(), 2, 0, true, (byte)0);
      ((com.tencent.mm.ui.widget.a.j)localObject2).au((CharSequence)getContext().getResources().getString(p.h.app_i_know));
      ((com.tencent.mm.ui.widget.a.j)localObject2).aFe(6);
      ((com.tencent.mm.ui.widget.a.j)localObject2).agfR = new k..ExternalSyntheticLambda10((com.tencent.mm.ui.widget.a.j)localObject2);
      localView = af.mU((Context)getContext()).inflate(p.f.CcS, null);
      if (localView == null)
      {
        localObject1 = null;
        label658:
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (localView != null) {
          break label728;
        }
      }
      label710:
      label728:
      for (localObject1 = localObject3;; localObject1 = localView.findViewById(p.e.BZz))
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        ((com.tencent.mm.ui.widget.a.j)localObject2).setCustomView(localView);
        ((com.tencent.mm.ui.widget.a.j)localObject2).dDn();
        AppMethodBeat.o(356341);
        return;
        i = 0;
        break;
        localObject1 = localView.findViewById(p.e.BZA);
        break label658;
      }
    }
    localObject1 = this.DYO;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((av)localObject1).isReady()))
    {
      kotlin.g.b.s.checkNotNull(localObject1);
      if (((Boolean)localObject1).booleanValue()) {
        break;
      }
      localObject1 = this.DYP;
      if (localObject1 == null) {
        break label1028;
      }
      ((ai)localObject1).EqD.setVisibility(0);
      ((ai)localObject1).niX.show();
      AppMethodBeat.o(356341);
      return;
    }
    localObject1 = this.DZb;
    if (localObject1 == null) {}
    for (localObject1 = localView;; localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.widget.bc)localObject1).isReady()))
    {
      kotlin.g.b.s.checkNotNull(localObject1);
      if (((Boolean)localObject1).booleanValue()) {
        break;
      }
      localObject1 = this.DZb;
      if (localObject1 == null) {
        break label1028;
      }
      ((com.tencent.mm.plugin.finder.live.widget.bc)localObject1).sG(true);
      AppMethodBeat.o(356341);
      return;
    }
    localObject1 = this.DYN;
    if (localObject1 != null) {
      if ((!Util.isNullOrNil(((au)localObject1).EcY)) || (!Util.isNullOrNil(((au)localObject1).nVM)) || ((!Util.isNullOrNil(((au)localObject1).Ebq)) && (y.ZC(((au)localObject1).Ebq))))
      {
        i = 1;
        if (i != 1) {
          break label1040;
        }
        i = 1;
        label945:
        if (i == 0) {
          break label1055;
        }
        localObject1 = this.DYO;
        if ((localObject1 == null) || (((av)localObject1).isReady() != true)) {
          break label1045;
        }
        i = 1;
        label971:
        if (i == 0) {
          break label1055;
        }
        localObject1 = this.DZb;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.widget.bc)localObject1).isReady() != true)) {
          break label1050;
        }
        i = 1;
        label997:
        if (i == 0) {
          break label1055;
        }
      }
    }
    label1028:
    label1040:
    label1045:
    label1050:
    label1055:
    for (i = j;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.DYX;
        if (localObject1 != null) {
          ((View)localObject1).setEnabled(false);
        }
        exa();
      }
      AppMethodBeat.o(356341);
      return;
      i = 0;
      break;
      i = 0;
      break label945;
      i = 0;
      break label971;
      i = 0;
      break label997;
    }
  }
  
  public static void exk()
  {
    AppMethodBeat.i(356362);
    com.tencent.mm.plugin.finder.live.report.j localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    q.t localt = q.t.Dwi;
    com.tencent.mm.plugin.finder.live.report.j localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
    localj1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    localt = q.t.Dvq;
    localj2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    localj1.a(localt, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
    AppMethodBeat.o(356362);
  }
  
  private final void exl()
  {
    AppMethodBeat.i(356373);
    Log.i(TAG, "afterSelectTagOperation");
    Object localObject = this.CvU;
    if ((localObject != null) && ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class) != null))
    {
      if (exx())
      {
        localObject = this.DYM;
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.widget.aw)localObject).eBo();
        }
      }
      localObject = this.DYM;
      if (localObject != null) {
        if (exx()) {
          break label87;
        }
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.finder.live.widget.aw)localObject).sE(bool);
      AppMethodBeat.o(356373);
      return;
    }
  }
  
  private final void exm()
  {
    AppMethodBeat.i(356384);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool;
    label82:
    String str;
    int i;
    if (((Number)com.tencent.d.a.a.a.a.a.jSH().bmg()).intValue() == 0)
    {
      bool = true;
      Log.i(TAG, kotlin.g.b.s.X("prepareMenuItems,showVisibilityEntrance:", Boolean.valueOf(bool)));
      if (!bool) {
        break label220;
      }
      localObject = this.DYT;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.DYT;
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new k..ExternalSyntheticLambda0(this));
      }
      str = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_more_action_visibility);
      kotlin.g.b.s.s(str, "getContext().resources.g…e_more_action_visibility)");
      localObject = this.CvU;
      if (localObject == null) {
        break label238;
      }
      localObject = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(r.class);
      if ((localObject == null) || (((r)localObject).Eis != 524288)) {
        break label238;
      }
      i = 1;
      label140:
      if (i == 0) {
        break label243;
      }
      localObject = MMApplicationContext.getContext().getResources().getString(p.h.ChL);
    }
    for (;;)
    {
      kotlin.g.b.s.s(localObject, "when {\n            liveD…)\n            }\n        }");
      TextView localTextView = this.DYU;
      if (localTextView != null) {
        localTextView.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Ctt, new Object[] { str, localObject }));
      }
      AppMethodBeat.o(356384);
      return;
      bool = false;
      break;
      label220:
      localObject = this.DYT;
      if (localObject == null) {
        break label82;
      }
      ((View)localObject).setVisibility(8);
      break label82;
      label238:
      i = 0;
      break label140;
      label243:
      localObject = this.CvU;
      if (localObject == null) {
        i = 0;
      }
      for (;;)
      {
        if (!com.tencent.mm.ae.d.ee(i, 7)) {
          break label307;
        }
        localObject = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_visibility_white_list);
        break;
        localObject = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(r.class);
        if (localObject == null) {
          i = 0;
        } else {
          i = ((r)localObject).Eis;
        }
      }
      label307:
      localObject = MMApplicationContext.getContext().getResources().getString(p.h.finder_live_visibility_public);
    }
  }
  
  private final void exn()
  {
    AppMethodBeat.i(356403);
    Object localObject = this.CvU;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp &= 0xFFFFFFBF;
      }
    }
    AppMethodBeat.o(356403);
  }
  
  private final boolean exo()
  {
    AppMethodBeat.i(356409);
    Object localObject = this.CvU;
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.ae.d.ee(i, 64);
      AppMethodBeat.o(356409);
      return bool;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp;
      }
    }
  }
  
  private final boolean exp()
  {
    AppMethodBeat.i(356416);
    Object localObject = this.CvU;
    int i;
    if (localObject == null) {
      i = 0;
    }
    while (!com.tencent.mm.ae.d.ee(i, 8))
    {
      AppMethodBeat.o(356416);
      return true;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp;
      }
    }
    AppMethodBeat.o(356416);
    return false;
  }
  
  private final boolean exq()
  {
    AppMethodBeat.i(356424);
    Object localObject = this.CvU;
    int i;
    if (localObject == null) {
      i = 0;
    }
    while (!com.tencent.mm.ae.d.ee(i, 512))
    {
      AppMethodBeat.o(356424);
      return true;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp;
      }
    }
    AppMethodBeat.o(356424);
    return false;
  }
  
  private final void exr()
  {
    AppMethodBeat.i(356448);
    Object localObject = this.CvU;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp &= 0xFFFFFF7F;
      }
    }
    AppMethodBeat.o(356448);
  }
  
  private final boolean exs()
  {
    AppMethodBeat.i(356455);
    Object localObject = this.CvU;
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      boolean bool = com.tencent.mm.ae.d.ee(i, 128);
      AppMethodBeat.o(356455);
      return bool;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject == null) {
        i = 0;
      } else {
        i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Ecp;
      }
    }
  }
  
  private final boolean ext()
  {
    AppMethodBeat.i(356465);
    Object localObject = this.CvU;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eem == true))
      {
        AppMethodBeat.o(356465);
        return true;
      }
    }
    AppMethodBeat.o(356465);
    return false;
  }
  
  private final void exw()
  {
    AppMethodBeat.i(356493);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("loadOptions exptFilterEnable:");
    Object localObject1 = this.CvU;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", exptBeautyEnable:");
      localObject1 = this.CvU;
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = null;
      label59:
      Log.i((String)localObject2, localObject1);
      this.DZg.clear();
    }
    int j;
    label394:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      switch (i)
      {
      default: 
        this.DZg.add(new k.e(i));
      }
      for (;;)
      {
        if (j < 4) {
          break label394;
        }
        AppMethodBeat.o(356493);
        return;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EdG);
        break;
        label167:
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label59;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EdF);
        break label59;
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.euF())
        {
          this.DZg.add(new k.e(i));
          localObject1 = this.CvU;
          if (localObject1 == null)
          {
            localObject1 = null;
            label235:
            localObject2 = (Collection)localObject1;
            if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
              break label360;
            }
          }
          label360:
          for (i = 1; i == 0; i = 0)
          {
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localObject2 = (MMActivity)getActivity();
            localObject3 = this.CvU;
            kotlin.g.b.s.checkNotNull(localObject3);
            bfk localbfk = new bfk();
            localbfk.ZPo = ((LinkedList)localObject1);
            localObject1 = ah.aiuX;
            com.tencent.mm.plugin.finder.live.utils.a.a((MMActivity)localObject2, (com.tencent.mm.plugin.finder.live.model.context.a)localObject3, localbfk);
            break;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
            if (localObject1 == null)
            {
              localObject1 = null;
              break label235;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Eee;
            if (localObject1 == null)
            {
              localObject1 = null;
              break label235;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.live.model.c)localObject1).CDF;
            break label235;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          if (com.tencent.mm.plugin.finder.utils.aw.fgy()) {
            this.DZg.add(new k.e(i));
          }
        }
      }
    }
  }
  
  private final boolean exx()
  {
    AppMethodBeat.i(356498);
    Object localObject = this.CvU;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).CFe;
        if ((localObject != null) && (((bno)localObject).ZWm == 1))
        {
          AppMethodBeat.o(356498);
          return true;
        }
      }
    }
    AppMethodBeat.o(356498);
    return false;
  }
  
  private static final void g(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(356514);
    kotlin.g.b.s.u(paramj, "$dialog");
    paramj.cyW();
    AppMethodBeat.o(356514);
  }
  
  private static final void gm(View paramView)
  {
    AppMethodBeat.i(356606);
    if (paramView != null) {
      paramView.findViewById(p.e.toast_text);
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(p.e.toast_img);
      if (paramView != null) {
        paramView.setImageResource(p.g.icons_filled_done);
      }
    }
    AppMethodBeat.o(356606);
  }
  
  private static final void h(com.tencent.mm.ui.widget.a.j paramj)
  {
    AppMethodBeat.i(356662);
    kotlin.g.b.s.u(paramj, "$dialog");
    com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqZ.mwI, String.valueOf(q.bc.DAA.action));
    paramj.cyW();
    AppMethodBeat.o(356662);
  }
  
  private static final void i(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(356557);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$showEdit");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356557);
  }
  
  private final void ru(boolean paramBoolean)
  {
    AppMethodBeat.i(356439);
    Object localObject1;
    Object localObject2;
    com.tencent.mm.plugin.finder.live.report.j localj;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.s.Dvb;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.s)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      localObject1 = (Context)getContext();
      localObject2 = getContext().getResources();
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = p.h.CnT;; i = p.h.CnL)
    {
      aa.db((Context)localObject1, ((Resources)localObject2).getString(i));
      Log.i(TAG, kotlin.g.b.s.X("switchVisitorAnonymous isEnable=", Boolean.valueOf(paramBoolean)));
      localObject1 = this.CvU;
      if (localObject1 == null) {
        break label182;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 == null) {
        break label182;
      }
      if (!paramBoolean) {
        break label170;
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Ecp |= 0x2000;
      AppMethodBeat.o(356439);
      return;
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.s.Dvc;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.s)localObject2, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
      break;
    }
    label170:
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).Ecp &= 0xFFFFDFFF;
    label182:
    AppMethodBeat.o(356439);
  }
  
  private final void sg(boolean paramBoolean)
  {
    AppMethodBeat.i(356474);
    Object localObject = this.CvU;
    if (localObject == null) {}
    for (localObject = null;; localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).Eem = paramBoolean;
      }
      if (!paramBoolean) {
        break;
      }
      localObject = this.ngB;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.a.b)localObject).fI(true);
      }
      aa.db((Context)getContext(), getContext().getResources().getString(p.h.Cio));
      AppMethodBeat.o(356474);
      return;
    }
    localObject = this.ngB;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.a.b)localObject).fI(false);
    }
    aa.db((Context)getContext(), getContext().getResources().getString(p.h.ChZ));
    AppMethodBeat.o(356474);
  }
  
  public final void a(View paramView, com.tencent.mm.live.b.b paramb, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.plugin.b paramb1, kotlin.g.a.b<? super FinderObjectDesc, ah> paramb2)
  {
    long l2 = 0L;
    com.tencent.mm.plugin.finder.loader.p localp = null;
    AppMethodBeat.i(356957);
    kotlin.g.b.s.u(paramView, "rootView");
    kotlin.g.b.s.u(paramb, "statusMonitor");
    kotlin.g.b.s.u(parama, "liveData");
    kotlin.g.b.s.u(paramb1, "basePlugin");
    kotlin.g.b.s.u(paramb2, "onStartLive");
    this.nfT = paramb;
    this.CvU = parama;
    this.DYK = paramView;
    paramView = com.tencent.mm.live.core.core.a.b.mMo;
    this.ngB = com.tencent.mm.live.core.core.a.b.a.bej();
    this.DYJ = paramb1;
    this.DZi = paramb2;
    paramView = this.DYK;
    label114:
    label248:
    label376:
    label637:
    long l1;
    label130:
    label168:
    label184:
    label200:
    label216:
    label232:
    label495:
    int i;
    if (paramView == null)
    {
      paramView = null;
      this.DYL = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1278;
      }
      paramView = null;
      this.DYN = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1321;
      }
      paramView = null;
      this.DYO = paramView;
      this.DYM = new com.tencent.mm.plugin.finder.live.widget.aw((MMActivity)getActivity(), getRootView());
      paramView = this.DYK;
      if (paramView != null) {
        break label1364;
      }
      paramView = null;
      this.CUD = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1378;
      }
      paramView = null;
      this.DYS = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1389;
      }
      paramView = null;
      this.DYU = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1403;
      }
      paramView = null;
      this.DYT = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1414;
      }
      paramView = null;
      this.DYV = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1428;
      }
      paramView = null;
      this.DYW = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1442;
      }
      paramView = null;
      label264:
      this.DYX = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1453;
      }
      paramView = null;
      label280:
      this.DYY = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1464;
      }
      paramView = null;
      label296:
      this.maskView = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1475;
      }
      paramView = null;
      label312:
      this.DYZ = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1486;
      }
      paramView = null;
      label328:
      this.mlS = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1497;
      }
      paramView = null;
      label344:
      this.DZa = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1508;
      }
      paramView = null;
      label360:
      this.DZe = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1519;
      }
      paramView = null;
      this.DZb = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1566;
      }
      paramView = null;
      label392:
      this.DYP = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1616;
      }
      paramView = null;
      label408:
      paramb = this.CvU;
      if ((paramb == null) || (paramView == null)) {
        break label1630;
      }
      paramView = new al(paramView, paramb);
      label431:
      this.DZc = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1635;
      }
      paramView = null;
      label447:
      this.DZd = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1649;
      }
      paramView = null;
      label463:
      this.DYQ = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1663;
      }
      paramView = null;
      label479:
      this.DYR = paramView;
      paramView = this.DYK;
      if (paramView != null) {
        break label1674;
      }
      paramView = null;
      this.DZf = paramView;
      paramView = this.CUD;
      if (paramView != null) {
        paramView.setFromScene(1);
      }
      paramView = this.DYR;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)this);
      }
      paramView = this.DYZ;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)this);
      }
      paramView = this.maskView;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)this);
      }
      paramView = this.DYX;
      if (paramView != null) {
        paramView.setEnabled(true);
      }
      paramView = this.DYX;
      if (paramView != null) {
        paramView.setOnClickListener(new k..ExternalSyntheticLambda1(this));
      }
      paramView = this.DYL;
      if (paramView != null) {
        paramView.setTextColor(getActivity().getResources().getColor(p.b.White));
      }
      paramView = this.DYL;
      if (paramView != null) {
        break label1688;
      }
      paramView = null;
      com.tencent.mm.ui.aw.a((Paint)paramView, 0.8F);
      this.DZh = ((kotlin.g.a.b)new i(this));
      paramView = this.DYW;
      if (paramView != null) {
        paramView.setAdapter((RecyclerView.a)new a());
      }
      paramView = this.DYW;
      if (paramView != null)
      {
        paramb = this.DYK;
        if (paramb != null) {
          paramb.getContext();
        }
        paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
      }
      paramView = this.DZf;
      if (paramView != null) {
        paramView.setShowSoftInputOnFocus(false);
      }
      paramView = this.DZf;
      if (paramView != null) {
        paramView.setMovementMethod((MovementMethod)new ScrollingMovementMethod());
      }
      paramView = (kotlin.g.a.a)new g(this);
      paramb = this.DZf;
      if (paramb != null) {
        paramb.setOnClickListener(new k..ExternalSyntheticLambda2(paramView));
      }
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramView = exh();
      if (paramView != null) {
        break label1696;
      }
      l1 = 0L;
      label811:
      if (!com.tencent.mm.plugin.finder.live.utils.a.oM(l1)) {
        exn();
      }
      paramView = com.tencent.mm.plugin.finder.live.util.u.DJC;
      paramView = exh();
      if (paramView != null) {
        break label1705;
      }
      l1 = 0L;
      label839:
      if (!com.tencent.mm.plugin.finder.live.util.u.oE(l1)) {
        exr();
      }
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramView = exh();
      if (paramView != null) {
        break label1714;
      }
      l1 = 0L;
      label867:
      if (!com.tencent.mm.plugin.finder.live.utils.a.oO(l1)) {
        break label1723;
      }
      paramView = this.CvU;
      if (paramView != null)
      {
        paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (paramView != null) {
          paramView.Ecp |= 0x400;
        }
      }
      label911:
      paramView = this.CvU;
      if (paramView == null) {
        break label1762;
      }
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if ((paramView == null) || (paramView.isLiveStarted() != true)) {
        break label1762;
      }
      i = 1;
      label946:
      if (i == 0)
      {
        paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramView = exh();
        if (paramView != null) {
          break label1768;
        }
        l1 = l2;
        label968:
        if (com.tencent.mm.plugin.finder.live.utils.a.oQ(l1))
        {
          paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (com.tencent.mm.plugin.finder.live.utils.a.euH()) {}
        }
        else
        {
          paramView = new Bundle();
          paramView.putBoolean("PARAM_FINDER_LIVE_AUDIO_MODE", false);
          paramb = this.nfT;
          if (paramb != null) {
            paramb.statusChange(b.c.neR, paramView);
          }
        }
      }
      paramb = TAG;
      paramb1 = new StringBuilder("setupConfig selfContact.anchorStatus:");
      paramView = exh();
      if (paramView != null) {
        break label1777;
      }
      paramView = null;
      label1048:
      paramb1 = paramb1.append(paramView).append(" switchFlag:");
      paramView = exh();
      if (paramView != null) {
        break label1788;
      }
      paramView = null;
      label1073:
      Log.i(paramb, paramView);
      paramb1 = this.DYN;
      if (paramb1 != null)
      {
        paramView = com.tencent.mm.plugin.finder.api.d.AwY;
        paramb = d.a.auT(z.bAW());
        paramb2 = paramb1.TAG;
        if (paramb != null) {
          break label1799;
        }
        paramView = null;
        label1121:
        Log.i(paramb2, kotlin.g.b.s.X("setCover liveCover:", paramView));
        if (paramb != null) {
          break label1807;
        }
        paramView = null;
        label1139:
        if (Util.isNullOrNil(paramView)) {
          break label1833;
        }
        if (paramb != null) {
          break label1815;
        }
        paramView = "";
      }
    }
    for (;;)
    {
      paramb1.EcY = paramView;
      paramView = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramView = com.tencent.mm.plugin.finder.loader.p.eCr();
      paramb = new com.tencent.mm.plugin.finder.loader.b(paramb1.EcY);
      paramb2 = paramb1.coverIv;
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramView.a(paramb, paramb2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      paramb1.Elx.onChange();
      paramView = this.DYO;
      if (paramView == null) {
        break label2003;
      }
      paramb = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaU, Boolean.FALSE);
      if (paramb != null) {
        break label1936;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(356957);
      throw paramView;
      paramView = (TextView)paramView.findViewById(p.e.BQA);
      break;
      label1278:
      paramView = (ViewGroup)paramView.findViewById(p.e.BQD);
      if (paramView == null)
      {
        paramView = null;
        break label114;
      }
      paramView = new au((MMActivity)getActivity(), paramView, this.DZl);
      break label114;
      label1321:
      paramView = (ViewGroup)paramView.findViewById(p.e.BZo);
      if (paramView == null)
      {
        paramView = null;
        break label130;
      }
      paramView = new av((MMActivity)getActivity(), paramView, this.DZl);
      break label130;
      label1364:
      paramView = (FinderLiveDescEditView)paramView.findViewById(p.e.BQE);
      break label168;
      label1378:
      paramView = paramView.findViewById(p.e.BPH);
      break label184;
      label1389:
      paramView = (TextView)paramView.findViewById(p.e.BTD);
      break label200;
      label1403:
      paramView = paramView.findViewById(p.e.BTC);
      break label216;
      label1414:
      paramView = (TextView)paramView.findViewById(p.e.finder_live_notice_time_txt);
      break label232;
      label1428:
      paramView = (RecyclerView)paramView.findViewById(p.e.BHS);
      break label248;
      label1442:
      paramView = paramView.findViewById(p.e.BQH);
      break label264;
      label1453:
      paramView = paramView.findViewById(p.e.BQC);
      break label280;
      label1464:
      paramView = paramView.findViewById(p.e.BQR);
      break label296;
      label1475:
      paramView = paramView.findViewById(p.e.BQX);
      break label312;
      label1486:
      paramView = paramView.findViewById(p.e.BQT);
      break label328;
      label1497:
      paramView = paramView.findViewById(p.e.BQG);
      break label344;
      label1508:
      paramView = paramView.findViewById(p.e.BQB);
      break label360;
      label1519:
      paramView = (LinearLayout)paramView.findViewById(p.e.BSX);
      if (paramView == null)
      {
        paramView = null;
        break label376;
      }
      paramb = this.CvU;
      if (paramb == null) {}
      for (paramView = null;; paramView = new com.tencent.mm.plugin.finder.live.widget.bc(paramView, paramb)) {
        break;
      }
      label1566:
      paramView = (ViewGroup)paramView.findViewById(p.e.BQK);
      if (paramView == null)
      {
        paramView = null;
        break label392;
      }
      paramView = new ai((MMActivity)getActivity(), paramView, (kotlin.g.a.a)new h(this));
      break label392;
      label1616:
      paramView = (LinearLayout)paramView.findViewById(p.e.BNC);
      break label408;
      label1630:
      paramView = null;
      break label431;
      label1635:
      paramView = (FinderLiveTaskBannerView)paramView.findViewById(p.e.BQU);
      break label447;
      label1649:
      paramView = (RelativeLayout)paramView.findViewById(p.e.BQW);
      break label463;
      label1663:
      paramView = paramView.findViewById(p.e.BQV);
      break label479;
      label1674:
      paramView = (MMEditText)paramView.findViewById(p.e.BWW);
      break label495;
      label1688:
      paramView = paramView.getPaint();
      break label637;
      label1696:
      l1 = paramView.field_liveSwitchFlag;
      break label811;
      label1705:
      l1 = paramView.field_liveSwitchFlag;
      break label839;
      label1714:
      l1 = paramView.field_liveSwitchFlag;
      break label867;
      label1723:
      paramView = this.CvU;
      if (paramView == null) {
        break label911;
      }
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (paramView == null) {
        break label911;
      }
      paramView.Ecp &= 0xFFFFFBFF;
      break label911;
      label1762:
      i = 0;
      break label946;
      label1768:
      l1 = paramView.field_liveSwitchFlag;
      break label968;
      label1777:
      paramView = Long.valueOf(paramView.field_liveAnchorStatusFlag);
      break label1048;
      label1788:
      paramView = Long.valueOf(paramView.field_liveSwitchFlag);
      break label1073;
      label1799:
      paramView = paramb.field_liveCoverImg;
      break label1121;
      label1807:
      paramView = paramb.field_liveCoverImg;
      break label1139;
      label1815:
      paramb = paramb.field_liveCoverImg;
      paramView = paramb;
      if (paramb == null) {
        paramView = "";
      }
    }
    label1833:
    if (paramb == null)
    {
      paramView = localp;
      label1840:
      if (Util.isNullOrNil(paramView)) {
        break label1916;
      }
      if (paramb != null) {
        break label1918;
      }
      paramView = "";
    }
    for (;;)
    {
      paramb1.nVM = paramView;
      paramView = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramView = com.tencent.mm.plugin.finder.loader.p.eCr();
      paramb = new com.tencent.mm.plugin.finder.loader.b(paramb1.nVM);
      paramb2 = paramb1.coverIv;
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramView.a(paramb, paramb2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
      break;
      paramView = paramb.field_avatarUrl;
      break label1840;
      label1916:
      break;
      label1918:
      paramb = paramb.field_avatarUrl;
      paramView = paramb;
      if (paramb == null) {
        paramView = "";
      }
    }
    label1936:
    boolean bool = ((Boolean)paramb).booleanValue();
    Log.i("FinderLivePostLicenseWidget", "checkLicenseState hasShowLicense:" + bool + ", licenseState:" + paramView.Dma);
    paramView.hDw.setVisibility(0);
    if (bool)
    {
      paramView.hDw.performClick();
      label2003:
      paramView = this.DYY;
      if (paramView != null) {
        paramView.post(new k..ExternalSyntheticLambda16(this, paramView));
      }
      exw();
      paramView = getActivity().getIntent().getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
      Log.i(TAG, kotlin.g.b.s.X("onCreate REQUEST_CODE_SELECT_LUCKY_MONEY_ROOM chatroomList:", paramView));
      if (paramView != null)
      {
        if (((Collection)paramView).isEmpty()) {
          break label2391;
        }
        i = 1;
        label2076:
        if (i != 0)
        {
          am(paramView);
          paramb = ((r)parama.business(r.class)).Eiu;
          if (paramb != null) {
            paramb.clear();
          }
          paramb = ((r)parama.business(r.class)).Eit;
          if (paramb != null) {
            paramb.addAll((Collection)paramView);
          }
          ((r)parama.business(r.class)).Eis = 2;
        }
      }
      exm();
      new com.tencent.mm.plugin.finder.live.cgi.p("", 0).bFJ().a((com.tencent.mm.vending.e.b)getContext()).g(new k..ExternalSyntheticLambda14(this));
      aB(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eel);
      exl();
      paramView = this.CvU;
      if (paramView == null) {
        break label2397;
      }
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (paramView == null) {
        break label2397;
      }
      paramView = paramView.Efg;
      if ((paramView == null) || (paramView.ZQq != true)) {
        break label2397;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramView = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaY, Boolean.FALSE);
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(356957);
          throw paramView;
          paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
          if (com.tencent.mm.plugin.finder.live.report.j.Doc.Dqr) {
            break;
          }
          paramb = com.tencent.mm.plugin.finder.live.report.j.Dob;
          if (com.tencent.mm.plugin.finder.live.report.j.Doc.Dqs) {
            break;
          }
          if (paramView.Dma == 1) {
            paramView.hDw.performClick();
          }
          for (i = q.bk.DBl.action;; i = q.bk.DBm.action)
          {
            com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqM.mwI, String.valueOf(i));
            paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
            com.tencent.mm.plugin.finder.live.report.j.Pj(i);
            break;
          }
          label2391:
          i = 0;
          break label2076;
          label2397:
          i = 0;
          continue;
        }
        if (((Boolean)paramView).booleanValue())
        {
          paramView = this.mlS;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
        }
        for (;;)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adaY, Boolean.TRUE);
          AppMethodBeat.o(356957);
          return;
          paramView = this.mlS;
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
      }
    }
    paramView = this.mlS;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(356957);
  }
  
  public final void exj()
  {
    AppMethodBeat.i(356966);
    Object localObject = getActivity();
    if ((localObject instanceof MMFinderUI)) {}
    for (localObject = (MMFinderUI)localObject;; localObject = null)
    {
      if (localObject != null) {
        new bb().bFJ().g(new k..ExternalSyntheticLambda13(this)).a((com.tencent.mm.vending.e.b)localObject);
      }
      AppMethodBeat.o(356966);
      return;
    }
  }
  
  public final void exu()
  {
    AppMethodBeat.i(357033);
    View localView = this.DYX;
    if (localView != null) {
      localView.setEnabled(true);
    }
    AppMethodBeat.o(357033);
  }
  
  public final void exv()
  {
    AppMethodBeat.i(357042);
    Log.i(TAG, kotlin.g.b.s.X("checkState state:", Integer.valueOf(this.state)));
    Object localObject;
    if (this.state == this.DYC)
    {
      localObject = this.DYY;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.DYQ;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).setVisibility(0);
        AppMethodBeat.o(357042);
      }
    }
    else
    {
      localObject = this.DYY;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      localObject = this.DYQ;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
    }
    AppMethodBeat.o(357042);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(357029);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(TAG, "onActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    Object localObject3 = this.DYN;
    Object localObject1;
    Object localObject2;
    if (localObject3 != null)
    {
      if (paramInt1 != ((au)localObject3).Elz) {
        break label724;
      }
      if (paramIntent == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.a(q.q.Dua);
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqJ.mwI, String.valueOf(q.p.DtV.action));
      }
    }
    else
    {
      localObject2 = this.DYM;
      if ((localObject2 != null) && (paramInt1 == 20000) && (paramIntent != null))
      {
        ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).EsQ.ar(paramIntent);
        ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).EsQ.dUo();
        localObject1 = ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).EsQ.getLocation();
        if (localObject1 != null) {
          break label1052;
        }
        localObject1 = null;
        label165:
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).EsQ.getLocation();
          if (localObject1 != null) {
            break label1062;
          }
          localObject1 = null;
          label193:
          if (Util.isNullOrNil((String)localObject1)) {
            ((com.tencent.mm.plugin.finder.live.widget.aw)localObject2).EsQ.dUl();
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("poiClassifyId", Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), ""));
        ((JSONObject)localObject1).put("longitude", Float.valueOf(paramIntent.getFloatExtra("get_lng", -1000.0F)));
        ((JSONObject)localObject1).put("latitude", Float.valueOf(paramIntent.getFloatExtra("get_lat", -85.0F)));
        ((JSONObject)localObject1).put("city", Util.nullAs(paramIntent.getStringExtra("get_city"), ""));
        ((JSONObject)localObject1).put("poiname", Util.nullAs(paramIntent.getStringExtra("get_poi_name"), ""));
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqL.mwI, ((JSONObject)localObject1).toString());
      }
      localObject1 = this.DZb;
      if ((localObject1 != null) && (paramInt2 == -1) && (paramInt1 == 1003)) {
        ((com.tencent.mm.plugin.finder.live.widget.bc)localObject1).eBC();
      }
      if (paramInt2 != -1) {}
    }
    switch (paramInt1)
    {
    case 1002: 
    default: 
      AppMethodBeat.o(357029);
      return;
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        localObject1 = null;
        label433:
        localObject2 = paramIntent.getData();
        if (localObject2 != null) {
          break label569;
        }
        localObject2 = null;
        label447:
        if (!Util.isNullOrNil((String)localObject2)) {
          break label2615;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.t.g((Context)((au)localObject3).activity, paramIntent, ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUh());
      }
      break;
    }
    label1024:
    label1038:
    label1052:
    label1062:
    label1448:
    label1837:
    label1967:
    label2101:
    label2485:
    label2615:
    for (;;)
    {
      Log.i(((au)localObject3).TAG, "filePath[" + localObject1 + "] " + paramIntent);
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.a(q.q.Dua);
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqJ.mwI, String.valueOf(q.p.DtV.action));
        break;
        localObject1 = ((Uri)localObject1).getPath();
        break label433;
        label569:
        localObject2 = ((Uri)localObject2).getPath();
        break label447;
      }
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).a((Activity)((au)localObject3).activity, (String)localObject1, "", ((au)localObject3).ElA, ((au)localObject3).activity.getResources().getColor(p.b.room_live_logo_color));
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.a(q.q.Dua);
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqJ.mwI, String.valueOf(q.p.DtV.action));
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject1 = ((Uri)localObject1).toString();
      kotlin.g.b.s.s(localObject1, "dataFilePath.toString()");
      if (kotlin.n.n.U((String)localObject1, "file://", false)) {}
      for (localObject1 = q.q.Dub;; localObject1 = q.q.Duc)
      {
        com.tencent.mm.plugin.finder.live.report.j.a((q.q)localObject1);
        break;
      }
      label724:
      if (paramInt1 != ((au)localObject3).ElA) {
        break;
      }
      if (paramIntent == null)
      {
        localObject1 = null;
        label740:
        String str = ((au)localObject3).TAG;
        if (localObject1 != null) {
          break label855;
        }
        localObject2 = null;
        label755:
        Log.i(str, kotlin.g.b.s.X("REQUEST_CODE_CROP_FIX_IMAGE model: ", localObject2));
        if (localObject1 != null) {
          break label865;
        }
      }
      label855:
      label865:
      for (localObject2 = null;; localObject2 = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath)
      {
        if ((localObject2 != null) && (y.ZC((String)localObject2))) {
          break label875;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.a(q.q.Dua);
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqJ.mwI, String.valueOf(q.p.DtV.action));
        Log.e(((au)localObject3).TAG, kotlin.g.b.s.X("ERROR! filePath=", localObject2));
        break;
        localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        break label740;
        localObject2 = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).thumbPath;
        break label755;
      }
      label875:
      int i;
      if (a.a.bfr().bfq().cameraId == 0)
      {
        i = 2;
        label890:
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        if (com.tencent.mm.plugin.finder.live.report.j.etl() != q.q.Dub.type) {
          break label1038;
        }
        if (i != 1) {
          break label1024;
        }
        localObject1 = String.valueOf(q.p.DtW.action);
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqJ.mwI, (String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.b(((au)localObject3).coverIv, (String)localObject2, Math.min(((au)localObject3).coverIv.getWidth(), 500), Math.min(((au)localObject3).coverIv.getHeight(), 500));
        ((au)localObject3).Ebq = ((String)localObject2);
        ((au)localObject3).nVM = "";
        ((au)localObject3).EcY = "";
        ((au)localObject3).Elx.onChange();
        break;
        i = 1;
        break label890;
        localObject1 = String.valueOf(q.p.DtX.action);
        continue;
        localObject1 = String.valueOf(q.p.DtY.action);
      }
      localObject1 = ((boi)localObject1).poiName;
      break label165;
      localObject1 = ((boi)localObject1).city;
      break label193;
      localObject1 = this.CvU;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null)
        {
          if (paramIntent != null) {
            break label1967;
          }
          localObject2 = null;
          label1098:
          if (!an.hC(localObject2)) {
            break label1984;
          }
          localObject2 = (List)localObject2;
          label1113:
          ((r)localObject1).Eir = ((List)localObject2);
        }
        if (paramIntent != null) {
          break label1990;
        }
        localObject1 = null;
        label1127:
        if (localObject1 != null)
        {
          localObject2 = this.CvU;
          if (localObject2 != null)
          {
            localObject2 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(r.class);
            if (localObject2 != null)
            {
              localObject2 = ((r)localObject2).Eit;
              if (localObject2 != null) {
                ((ArrayList)localObject2).clear();
              }
            }
          }
          localObject2 = this.CvU;
          if (localObject2 != null)
          {
            localObject2 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(r.class);
            if (localObject2 != null)
            {
              localObject2 = ((r)localObject2).Eit;
              if (localObject2 != null) {
                ((ArrayList)localObject2).addAll((Collection)localObject1);
              }
            }
          }
        }
        if (paramIntent != null) {
          break label2007;
        }
        localObject1 = null;
        label1237:
        if (localObject1 != null)
        {
          localObject2 = this.CvU;
          if (localObject2 != null)
          {
            localObject2 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(r.class);
            if (localObject2 != null)
            {
              localObject2 = ((r)localObject2).Eiu;
              if (localObject2 != null) {
                ((ArrayList)localObject2).clear();
              }
            }
          }
          localObject2 = this.CvU;
          if (localObject2 != null)
          {
            localObject2 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(r.class);
            if (localObject2 != null)
            {
              localObject2 = ((r)localObject2).Eiu;
              if (localObject2 != null) {
                ((ArrayList)localObject2).addAll((Collection)localObject1);
              }
            }
          }
        }
        localObject1 = this.CvU;
        if (localObject1 != null) {
          break label2024;
        }
        localObject2 = null;
        label1354:
        if (localObject2 != null)
        {
          if (paramIntent != null) {
            break label2040;
          }
          localObject1 = null;
          label1366:
          ((r)localObject2).b((bfy)localObject1);
        }
        localObject1 = this.CvU;
        if (localObject1 != null) {
          break label2085;
        }
        localObject2 = null;
        label1387:
        if (localObject2 != null)
        {
          if (paramIntent != null) {
            break label2101;
          }
          localObject1 = null;
          label1399:
          ((r)localObject2).b((boe)localObject1);
        }
        if (paramIntent != null) {
          break label2146;
        }
        paramInt2 = 0;
        paramIntent = this.CvU;
        if (paramIntent != null) {
          break label2163;
        }
        paramIntent = null;
        if (paramIntent != null)
        {
          if (!com.tencent.mm.ae.d.ee(paramInt2, 1)) {
            break label2609;
          }
          localObject1 = this.CvU;
          if (localObject1 != null) {
            break label2177;
          }
          paramInt1 = 0;
          if (paramInt1 > 0) {
            break label2609;
          }
        }
      }
      for (int j = paramInt2 & 0xFFFFFFFE;; j = paramInt2)
      {
        i = j;
        if (com.tencent.mm.ae.d.ee(paramInt2, 2))
        {
          localObject1 = this.CvU;
          if (localObject1 != null) {
            break label2228;
          }
          paramInt1 = 0;
          label1483:
          i = j;
          if (paramInt1 <= 0) {
            i = paramInt2 & 0xFFFFFFFD;
          }
        }
        j = i;
        if (com.tencent.mm.ae.d.ee(paramInt2, 4))
        {
          localObject1 = this.CvU;
          if (localObject1 != null) {
            break label2277;
          }
          paramInt1 = 0;
          label1522:
          j = i;
          if (paramInt1 <= 0) {
            j = paramInt2 & 0xFFFFFFFB;
          }
        }
        if (!com.tencent.mm.ae.d.ee(paramInt2, 1))
        {
          localObject1 = this.CvU;
          if (localObject1 != null)
          {
            localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
            if (localObject1 != null)
            {
              localObject1 = ((r)localObject1).Eir;
              if (localObject1 != null) {
                ((List)localObject1).clear();
              }
            }
          }
        }
        if (!com.tencent.mm.ae.d.ee(paramInt2, 2))
        {
          localObject1 = this.CvU;
          if (localObject1 != null)
          {
            localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
            if (localObject1 != null)
            {
              localObject1 = ((r)localObject1).Eit;
              if (localObject1 != null) {
                ((ArrayList)localObject1).clear();
              }
            }
          }
        }
        if (!com.tencent.mm.ae.d.ee(paramInt2, 4))
        {
          localObject1 = this.CvU;
          if (localObject1 != null)
          {
            localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
            if (localObject1 != null)
            {
              localObject1 = ((r)localObject1).Eiu;
              if (localObject1 != null) {
                ((ArrayList)localObject1).clear();
              }
            }
          }
        }
        Log.i(TAG, "checkVisibilityMode oriMode:" + paramInt2 + " finalMode:" + j);
        paramIntent.Eis = j;
        paramIntent = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramIntent = this.CvU;
        if (paramIntent == null)
        {
          paramInt1 = 0;
          label1755:
          paramIntent = com.tencent.mm.plugin.finder.live.utils.a.Pp(paramInt1);
          aa.a((Context)getContext(), paramIntent, k..ExternalSyntheticLambda4.INSTANCE);
          localObject1 = TAG;
          localObject2 = new StringBuilder("onActivityResult anchorChooseMode:").append(paramInt2).append(", visibilityChooseByteArray size:");
          paramIntent = this.CvU;
          if (paramIntent != null) {
            break label2354;
          }
          paramIntent = null;
          localObject2 = ((StringBuilder)localObject2).append(paramIntent).append(",chooseRoomList:");
          paramIntent = this.CvU;
          if (paramIntent != null) {
            break label2401;
          }
          paramIntent = null;
          localObject2 = ((StringBuilder)localObject2).append(paramIntent).append(",chooseUserList:");
          paramIntent = this.CvU;
          if (paramIntent != null) {
            break label2429;
          }
          paramIntent = null;
          label1862:
          localObject2 = ((StringBuilder)localObject2).append(paramIntent).append(",partWhiteList:");
          paramIntent = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          paramIntent = this.CvU;
          if (paramIntent != null) {
            break label2457;
          }
          paramIntent = null;
          label1891:
          localObject2 = ((StringBuilder)localObject2).append(com.tencent.mm.plugin.finder.live.view.convert.a.a(paramIntent)).append(",liveChargePost:");
          paramIntent = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          paramIntent = this.CvU;
          if (paramIntent != null) {
            break label2485;
          }
          paramIntent = null;
        }
        for (;;)
        {
          Log.i((String)localObject1, com.tencent.mm.plugin.finder.live.view.convert.a.a(paramIntent));
          exm();
          AppMethodBeat.o(357029);
          return;
          localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
          break;
          localObject2 = a.d.HbG;
          localObject2 = paramIntent.getSerializableExtra(a.d.fri());
          break label1098;
          label1984:
          localObject2 = null;
          break label1113;
          label1990:
          localObject1 = a.d.HbG;
          localObject1 = paramIntent.getStringArrayListExtra(a.d.frj());
          break label1127;
          label2007:
          localObject1 = a.d.HbG;
          localObject1 = paramIntent.getStringArrayListExtra(a.d.frk());
          break label1237;
          label2024:
          localObject2 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
          break label1354;
          label2040:
          localObject1 = a.d.HbG;
          localObject3 = paramIntent.getByteArrayExtra(a.d.frm());
          if (localObject3 == null)
          {
            localObject1 = null;
            break label1366;
          }
          localObject1 = new bfy();
          ((bfy)localObject1).parseFrom((byte[])localObject3);
          break label1366;
          localObject2 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
          break label1387;
          localObject1 = a.d.HbG;
          localObject3 = paramIntent.getByteArrayExtra(a.d.frn());
          if (localObject3 == null)
          {
            localObject1 = null;
            break label1399;
          }
          localObject1 = new boe();
          ((boe)localObject1).parseFrom((byte[])localObject3);
          break label1399;
          label2146:
          localObject1 = a.d.HbG;
          paramInt2 = paramIntent.getIntExtra(a.d.frg(), 0);
          break label1412;
          label2163:
          paramIntent = (r)paramIntent.business(r.class);
          break label1423;
          localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label1448;
          }
          localObject1 = ((r)localObject1).Eir;
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label1448;
          }
          paramInt1 = ((List)localObject1).size();
          break label1448;
          localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label1483;
          }
          localObject1 = ((r)localObject1).Eit;
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label1483;
          }
          paramInt1 = ((ArrayList)localObject1).size();
          break label1483;
          label2277:
          localObject1 = (r)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(r.class);
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label1522;
          }
          localObject1 = ((r)localObject1).Eiu;
          if (localObject1 == null)
          {
            paramInt1 = 0;
            break label1522;
          }
          paramInt1 = ((ArrayList)localObject1).size();
          break label1522;
          paramIntent = (r)paramIntent.business(r.class);
          if (paramIntent == null)
          {
            paramInt1 = 0;
            break label1755;
          }
          paramInt1 = paramIntent.Eis;
          break label1755;
          paramIntent = (r)paramIntent.business(r.class);
          if (paramIntent == null)
          {
            paramIntent = null;
            break label1812;
          }
          paramIntent = paramIntent.Eir;
          if (paramIntent == null)
          {
            paramIntent = null;
            break label1812;
          }
          paramIntent = Integer.valueOf(paramIntent.size());
          break label1812;
          label2401:
          paramIntent = (r)paramIntent.business(r.class);
          if (paramIntent == null)
          {
            paramIntent = null;
            break label1837;
          }
          paramIntent = paramIntent.Eit;
          break label1837;
          label2429:
          paramIntent = (r)paramIntent.business(r.class);
          if (paramIntent == null)
          {
            paramIntent = null;
            break label1862;
          }
          paramIntent = paramIntent.Eiu;
          break label1862;
          paramIntent = (r)paramIntent.business(r.class);
          if (paramIntent == null)
          {
            paramIntent = null;
            break label1891;
          }
          paramIntent = paramIntent.Eiw;
          break label1891;
          paramIntent = (r)paramIntent.business(r.class);
          if (paramIntent == null) {
            paramIntent = null;
          } else {
            paramIntent = paramIntent.CJb;
          }
        }
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_START_LIVE", false) == true)) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          Log.i(TAG, "onActivityResult REQUEST_CODE_SELECT_TAG startLive by selected tag result");
          exi();
          AppMethodBeat.o(357029);
          return;
        }
        exl();
        AppMethodBeat.o(357029);
        return;
        if (paramIntent == null) {}
        for (paramIntent = null;; paramIntent = paramIntent.getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME"))
        {
          Log.i(TAG, kotlin.g.b.s.X("onActivityResult REQUEST_CODE_SELECT_LUCKY_MONEY_ROOM chatroomList:", paramIntent));
          am(paramIntent);
          break;
        }
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    int k = 0;
    AppMethodBeat.i(357080);
    Object localObject = this.CUD;
    if ((localObject != null) && (((FinderLiveDescEditView)localObject).onBackPressed() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(357080);
      return true;
    }
    localObject = this.DYP;
    int j = k;
    if (localObject != null)
    {
      if (((ai)localObject).EqD.getVisibility() != 0) {
        break label102;
      }
      ((ai)localObject).niX.hide();
    }
    label102:
    for (i = 1;; i = 0)
    {
      j = k;
      if (i == 1) {
        j = 1;
      }
      if (j == 0) {
        break;
      }
      AppMethodBeat.o(357080);
      return true;
    }
    if (this.state == this.DYD)
    {
      this.state = this.DYC;
      localObject = this.nfT;
      if (localObject != null) {
        b.b.a((com.tencent.mm.live.b.b)localObject, b.c.neg);
      }
      exv();
      AppMethodBeat.o(357080);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(357080);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(357066);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BQV;
      if (paramView != null) {
        break label103;
      }
      label53:
      i = p.e.BQR;
      if (paramView != null) {
        break label185;
      }
      label61:
      i = p.e.BQX;
      if (paramView != null) {
        break label212;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357066);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label103:
      if (paramView.intValue() != i) {
        break label53;
      }
      paramView = this.nfT;
      if (paramView != null) {
        b.b.a(paramView, b.c.ncl);
      }
      paramView = this.nfT;
      if ((paramView != null) && (paramView.getLiveRole() == 1)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label183;
        }
        com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqP.mwI, "");
        paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
        com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.etj());
        break;
      }
      label183:
      continue;
      label185:
      if (paramView.intValue() != i) {
        break label61;
      }
      if (this.state != this.DYC)
      {
        onBackPressed();
        continue;
        label212:
        if (paramView.intValue() == i)
        {
          if (this.ngn == null)
          {
            this.ngn = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 0, true);
            paramView = this.ngn;
            if (paramView != null) {
              paramView.NyV = true;
            }
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.NE(true);
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.agfb = false;
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.setFooterView(null);
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.Vtg = new k..ExternalSyntheticLambda5(this);
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.GAz = new k..ExternalSyntheticLambda6(this);
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.GAC = this.Dgv;
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.agem = this.Dgv;
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.aeLi = new k..ExternalSyntheticLambda8(this);
          }
          paramView = this.ngn;
          if (paramView != null) {
            paramView.dDn();
          }
          paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localObject = q.s.Dui;
          com.tencent.mm.plugin.finder.live.report.j localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramView.a((q.s)localObject, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Due));
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356895);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(5874, (com.tencent.mm.am.h)this);
    paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.adbD, Long.valueOf(0L));
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(356895);
      throw paramBundle;
    }
    this.DZk = ((Long)paramBundle).longValue();
    AppMethodBeat.o(356895);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(356974);
    super.onDestroy();
    Object localObject = this.DYM;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.widget.aw)localObject).EsR = true;
    }
    com.tencent.mm.kernel.h.aZW().b(5874, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    localObject = this.BnV;
    if (localObject != null) {
      ((FinderGameEventListener)localObject).dead();
    }
    AppMethodBeat.o(356974);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(356905);
    super.onNewIntent(paramIntent);
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getByteArrayExtra("KEY_PARAMS_CHOSEN_TAG");
      if (localObject != null)
      {
        paramIntent = this.CvU;
        if (paramIntent != null) {
          break label94;
        }
      }
    }
    label94:
    for (paramIntent = null;; paramIntent = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramIntent.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
    {
      if (paramIntent != null)
      {
        bno localbno = new bno();
        localbno.parseFrom((byte[])localObject);
        localObject = ah.aiuX;
        paramIntent.CFe = localbno;
      }
      paramIntent = this.DYK;
      if (paramIntent != null) {
        paramIntent.post(new k..ExternalSyntheticLambda15(this));
      }
      AppMethodBeat.o(356905);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(356983);
    super.onPause();
    FinderLiveTaskBannerView localFinderLiveTaskBannerView = this.DZd;
    if (localFinderLiveTaskBannerView != null) {
      localFinderLiveTaskBannerView.stop();
    }
    AppMethodBeat.o(356983);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(356989);
    super.onResume();
    FinderLiveTaskBannerView localFinderLiveTaskBannerView = this.DZd;
    if (localFinderLiveTaskBannerView != null) {
      localFinderLiveTaskBannerView.resume();
    }
    AppMethodBeat.o(356989);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp) {}
  
  public final void t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    float f2 = 0.0F;
    Object localObject2 = null;
    AppMethodBeat.i(357054);
    kotlin.g.b.s.u(paramString1, "coverUrl");
    kotlin.g.b.s.u(paramString2, "thumbUrl");
    kotlin.g.b.s.u(paramString3, "path");
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    Object localObject1 = this.DZf;
    label87:
    float f1;
    if (localObject1 == null)
    {
      localObject1 = null;
      localFinderObjectDesc.description = String.valueOf(localObject1);
      localFinderObjectDesc.mediaType = 9;
      localObject1 = this.DYM;
      if (localObject1 != null) {
        break label554;
      }
      localObject1 = null;
      localFinderObjectDesc.location = ((boi)localObject1);
      localFinderObjectDesc.extReading = new axa();
      localObject1 = new bgk();
      ((bgk)localObject1).EcY = paramString1;
      ah localah = ah.aiuX;
      localFinderObjectDesc.liveDesc = ((bgk)localObject1);
      localObject1 = new FinderMedia();
      ((FinderMedia)localObject1).url = paramString1;
      ((FinderMedia)localObject1).mediaType = 9;
      ((FinderMedia)localObject1).thumbUrl = paramString2;
      ((FinderMedia)localObject1).videoDuration = 0;
      if (Util.isNullOrNil(paramString3)) {
        break label564;
      }
      paramString2 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      paramString2 = com.tencent.mm.plugin.finder.utils.aw.aBX(paramString3);
      label183:
      if (paramString2 != null) {
        break label583;
      }
      f1 = 0.0F;
      label190:
      ((FinderMedia)localObject1).width = f1;
      if (paramString2 != null) {
        break label593;
      }
      f1 = f2;
      label205:
      ((FinderMedia)localObject1).height = f1;
      if (paramString4 != null) {
        break label603;
      }
      paramString2 = "";
      label221:
      ((FinderMedia)localObject1).md5sum = paramString2;
      ((FinderMedia)localObject1).coverUrl = paramString1;
      localFinderObjectDesc.media.add(localObject1);
      paramString3 = TAG;
      paramString2 = new StringBuilder("desc coverUrl:");
      paramString1 = (FinderMedia)localFinderObjectDesc.media.getFirst();
      if (paramString1 != null) {
        break label609;
      }
      paramString1 = null;
      label277:
      paramString2 = paramString2.append(paramString1).append(",thumbUrl:");
      paramString1 = (FinderMedia)localFinderObjectDesc.media.getFirst();
      if (paramString1 != null) {
        break label617;
      }
      paramString1 = null;
      label307:
      paramString2 = paramString2.append(paramString1).append(",md5:").append(paramString4).append(", selfContact.anchorFlag:");
      paramString1 = exh();
      if (paramString1 != null) {
        break label625;
      }
      paramString1 = null;
      label341:
      paramString2 = paramString2.append(paramString1).append(", selfContact.switchFlag:");
      paramString1 = exh();
      if (paramString1 != null) {
        break label636;
      }
      paramString1 = null;
      label364:
      paramString4 = paramString2.append(paramString1).append(", linkMic:").append(exo()).append(", gift:").append(exs()).append(", comment:").append(exp()).append(",location:");
      paramString2 = localFinderObjectDesc.location;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      Log.i(paramString3, com.tencent.mm.ae.f.dg(paramString1));
      paramString1 = this.CvU;
      if (paramString1 != null) {
        break label647;
      }
    }
    label647:
    for (paramString1 = localObject2;; paramString1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramString1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class))
    {
      paramString2 = exh();
      if ((paramString1 != null) && (paramString2 != null))
      {
        paramString2.field_liveAnchorStatusFlag = paramString1.Ecp;
        paramString3 = com.tencent.mm.plugin.finder.api.d.AwY;
        d.a.d(paramString2);
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.pa(paramString1.Ecp);
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.pb(paramString2.field_liveSwitchFlag);
      }
      paramString1 = this.DYO;
      if (paramString1 != null) {
        paramString1.eAR();
      }
      paramString1 = this.DZi;
      if (paramString1 != null) {
        paramString1.invoke(localFinderObjectDesc);
      }
      AppMethodBeat.o(357054);
      return;
      localObject1 = ((MMEditText)localObject1).getText();
      break;
      label554:
      localObject1 = ((com.tencent.mm.plugin.finder.live.widget.aw)localObject1).getLocation();
      break label87;
      label564:
      if (this.DYN == null)
      {
        paramString2 = null;
        break label183;
      }
      paramString2 = au.ezT();
      break label183;
      label583:
      f1 = paramString2.x;
      break label190;
      label593:
      f1 = paramString2.y;
      break label205;
      label603:
      paramString2 = paramString4;
      break label221;
      label609:
      paramString1 = paramString1.coverUrl;
      break label277;
      label617:
      paramString1 = paramString1.thumbUrl;
      break label307;
      label625:
      paramString1 = Long.valueOf(paramString1.field_liveAnchorStatusFlag);
      break label341;
      label636:
      paramString1 = Long.valueOf(paramString1.field_liveSwitchFlag);
      break label364;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<k.b>
  {
    public a()
    {
      AppMethodBeat.i(356239);
      AppMethodBeat.o(356239);
    }
    
    private static final void a(k paramk, int paramInt, View paramView)
    {
      AppMethodBeat.i(356252);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramk);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramk, "this$0");
      paramView = (k.e)kotlin.a.p.ae((List)k.l(paramk), paramInt);
      if (paramView != null)
      {
        paramk = k.n(paramk);
        if (paramk != null) {
          paramk.invoke(paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356252);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(356272);
      int i = k.l(this.DZp).size();
      AppMethodBeat.o(356272);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;Landroid/view/View;)V", "optIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getOptIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "optTv", "Landroid/widget/TextView;", "getOptTv", "()Landroid/widget/TextView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    final WeImageView DZq;
    final TextView DZr;
    
    public b()
    {
      super();
      AppMethodBeat.i(356236);
      this.DZq = ((WeImageView)localObject.findViewById(p.e.BHQ));
      this.DZr = ((TextView)localObject.findViewById(p.e.BHR));
      AppMethodBeat.o(356236);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "", "onChange", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface f
  {
    public abstract void onChange();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.b<k.e, ah>
  {
    i(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$prepareSpeedTest$1$1$1$1", "Lcom/tencent/mm/network/ISpeedTestCallback_AIDL$Stub;", "onSpeedTestDone", "", "rttSuccessful", "", "rtt", "", "jitter", "uploadSuccessful", "aveUpSpeed", "", "minUpSpeed", "maxUpSpeed", "downloadSuccessful", "aveDownSpeed", "minDownSpeed", "maxDownSpeed", "onUploadAndRttDone", "aveSpeed", "minSpeed", "maxSpeed", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends u.a
  {
    j(k paramk) {}
    
    public final void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(356342);
      k.c localc = k.DYB;
      Log.i(k.access$getTAG$cp(), "onUploadAndRttDone rttSuccessful:" + paramBoolean1 + " rtt:" + paramFloat1 + " jitter:" + paramFloat2 + " uploadSuccessful:" + paramBoolean2 + " aveSpeed:" + paramInt1 + " minSpeed:" + paramInt2 + " maxSpeed:" + paramInt3);
      AppMethodBeat.o(356342);
    }
    
    public final void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, final int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean3, int paramInt4, int paramInt5, int paramInt6)
    {
      AppMethodBeat.i(356333);
      k.c localc = k.DYB;
      Log.i(k.access$getTAG$cp(), "onSpeedTestDone rttSuccessful:" + paramBoolean1 + " rtt:" + paramFloat1 + " jitter:" + paramFloat2 + " uploadSuccessful:" + paramBoolean2 + " aveUpSpeed:" + paramInt1 + " minUpSpeed:" + paramInt2 + " maxUpSpeed:" + paramInt3 + " downloadSuccessful:" + paramBoolean3 + " aveDownSpeed:" + paramInt4 + " minDownSpeed:" + paramInt5 + " maxDownSpeed:" + paramInt6);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramBoolean2, this.DZp, paramInt1));
      AppMethodBeat.o(356333);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(boolean paramBoolean, k paramk, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$startPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.loader.f.e<com.tencent.mm.loader.f.c>
  {
    k(k paramk) {}
    
    public final void a(com.tencent.mm.loader.f.c paramc, i parami)
    {
      AppMethodBeat.i(356387);
      kotlin.g.b.s.u(paramc, "task");
      kotlin.g.b.s.u(parami, "status");
      Object localObject;
      if ((parami == i.nrG) && (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl)))
      {
        k localk = this.DZp;
        String str1 = ((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl;
        String str2 = ((com.tencent.mm.plugin.finder.upload.m)paramc).Gcj;
        parami = k.i(this.DZp);
        if (parami == null)
        {
          parami = "";
          paramc = ((com.tencent.mm.plugin.finder.upload.m)paramc).mxU;
          if (paramc != null) {
            break label127;
          }
        }
        label127:
        for (paramc = null;; paramc = paramc.field_filemd5)
        {
          localk.t(str1, str2, parami, paramc);
          AppMethodBeat.o(356387);
          return;
          localObject = parami.Ebq;
          parami = (i)localObject;
          if (localObject != null) {
            break;
          }
          parami = "";
          break;
        }
      }
      paramc = k.j(this.DZp);
      if ((paramc != null) && (paramc.getLiveRole() == 1)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqG.mwI, String.valueOf(q.bs.DCa.type));
          paramc = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.setErrorCode(i.nrH.ordinal());
          paramc = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.b(q.v.DwK);
        }
        paramc = com.tencent.mm.plugin.finder.utils.bc.GkH;
        paramc = com.tencent.mm.plugin.finder.utils.bc.fhG();
        localObject = com.tencent.mm.plugin.finder.utils.bc.GkH;
        com.tencent.mm.plugin.finder.utils.bc.fhF();
        parami = parami.toString();
        k.k(this.DZp);
        com.tencent.mm.plugin.finder.utils.bc.it(paramc, parami);
        AppMethodBeat.o(356387);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    l(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$widgetListener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements k.f
  {
    m(k paramk) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(356388);
      this.DZp.exu();
      k.t(this.DZp);
      AppMethodBeat.o(356388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.k
 * JD-Core Version:    0.7.0.1
 */