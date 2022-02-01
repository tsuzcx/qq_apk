package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.ad;
import com.tencent.mm.plugin.finder.live.report.s.af;
import com.tencent.mm.plugin.finder.live.report.s.bd;
import com.tencent.mm.plugin.finder.live.report.s.n;
import com.tencent.mm.plugin.finder.live.report.s.o;
import com.tencent.mm.plugin.finder.live.report.s.s;
import com.tencent.mm.plugin.finder.live.report.s.y;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView;
import com.tencent.mm.plugin.finder.live.widget.ae;
import com.tencent.mm.plugin.finder.live.widget.af;
import com.tencent.mm.plugin.finder.live.widget.ah;
import com.tencent.mm.plugin.finder.live.widget.an;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.aq;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "SHEET_MORE_ACTION_CAMERA_STATUS", "", "SHEET_MORE_ACTION_COMMENT", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_LIKE", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_MUTE", "SHEET_MORE_ACTION_SCREEN_SHARE", "SHEET_MORE_ACTION_SENSITIVE_WORD", "SHEET_MORE_ACTION_VISIBILITY_MODE", "STATE_DEFAULT", "STATE_LENS", "baseLivePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "cameraOptPanel", "Landroidx/recyclerview/widget/RecyclerView;", "contentRoot", "Landroid/view/View;", "coverWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "descWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "getDescWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "setDescWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;)V", "gameEventListener", "Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "getGameEventListener", "()Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;", "setGameEventListener", "(Lcom/tencent/mm/plugin/finder/utils/FinderGameEventListener;)V", "licensePanelWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "licenseWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveTagView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "liveTaskBanner", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "locationWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "luckyMoneyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLuckyMoneyWidget;", "maskView", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "noticeLayout", "noticeTimeTxt", "Landroid/widget/TextView;", "onOptionClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "Lkotlin/ParameterName;", "name", "option", "", "onStartLive", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "getOnStartLive", "()Lkotlin/jvm/functions/Function1;", "setOnStartLive", "(Lkotlin/jvm/functions/Function1;)V", "optList", "Ljava/util/ArrayList;", "postBtn", "postBtnGroup", "postLayout", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "getSelfContact", "()Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shopBindInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "state", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "topBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "topBackArea", "topContainer", "Landroid/widget/RelativeLayout;", "topGameBtn", "topMoreActionBtn", "visibilityGroup", "visibilityTv", "widgetListener", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "getWidgetListener", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "setWidgetListener", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "adjustMargin", "afterSelectTagOperation", "beforeLive", "buildConfirmDialog", "checkIsReadyToPost", "", "checkNetwork", "checkState", "checkVisibilityMode", "anchorChooseMode", "clickLens", "clickMusic", "clickShop", "continuePost", "coverUrl", "", "thumbUrl", "path", "md5", "disableComment", "disableGift", "disableLike", "disableLinkMic", "disableScreenShare", "enableComment", "enableGift", "enableLike", "enableLinkMic", "enableScreenShare", "initPostLayout", "rootView", "basePlugin", "initView", "isCommentEnable", "isGiftEnable", "isLikeEnable", "isLinkMicEnable", "isMuteMic", "isScreenShareEnable", "isTagLiveNeedPoi", "loadOptions", "muteMic", "mute", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyboardHeightChanged", "height", "show", "onNewIntent", "intent", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "refreshGroupVisibility", "refreshLuckyMoneyChatroom", "chatroomList", "refreshPostState", "restorePostUI", "setLiveNoticeInfo", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setLiveTaskInfo", "liveTaskInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQuestActivity;", "setVisible", "visible", "setupConfig", "showLinkConfirmDialog", "startPost", "tryStartPost", "tryToPreloadMiniprogram", "updateCoverInfo", "BeforeOptAdapter", "BeforeOptViewHolder", "Companion", "OptionInfo", "WidgetStatusCallback", "plugin-finder_release"})
public final class i
  extends UIComponent
  implements View.OnClickListener, com.tencent.mm.an.i
{
  public static final String TAG = "Finder.FinderLivePostUIC";
  public static final c zcP;
  public com.tencent.mm.live.c.b kCL;
  private e kCR;
  public com.tencent.mm.live.core.core.a.b kDk;
  public View maskView;
  public int state;
  com.tencent.mm.plugin.finder.utils.n xNU;
  public com.tencent.mm.plugin.finder.live.model.context.a xYp;
  private final q.g ybB;
  private final int yvh;
  private final int yvi;
  private final int yvk;
  private final int yvm;
  private final int yvr;
  public View zcA;
  public TextView zcB;
  public TextView zcC;
  public RecyclerView zcD;
  public View zcE;
  public View zcF;
  public View zcG;
  public View zcH;
  public an zcI;
  public com.tencent.mm.plugin.finder.live.widget.w zcJ;
  public FinderLiveTaskBannerView zcK;
  private ArrayList<d> zcL;
  public kotlin.g.a.b<? super d, x> zcM;
  public kotlin.g.a.b<? super FinderObjectDesc, x> zcN;
  public e zcO;
  public final int zci;
  private final int zcj;
  private final int zck;
  private final int zcl;
  private final int zcm;
  private final int zcn;
  public com.tencent.mm.plugin.finder.live.plugin.d zco;
  public View zcp;
  public TextView zcq;
  public ah zcr;
  public ae zcs;
  public com.tencent.mm.plugin.finder.live.widget.ag zct;
  public com.tencent.mm.plugin.finder.live.widget.t zcu;
  public af zcv;
  public RelativeLayout zcw;
  public WeImageView zcx;
  public View zcy;
  public View zcz;
  
  static
  {
    AppMethodBeat.i(286799);
    zcP = new c((byte)0);
    TAG = "Finder.FinderLivePostUIC";
    AppMethodBeat.o(286799);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(286798);
    this.zcj = 1;
    this.yvh = 1;
    this.yvi = 3;
    this.zcl = 4;
    this.zcm = 5;
    this.yvk = 6;
    this.yvm = 7;
    this.zcn = 8;
    this.yvr = 9;
    this.zcL = new ArrayList();
    this.state = this.zci;
    this.ybB = ((q.g)new n(this));
    this.zcO = ((e)new u(this));
    AppMethodBeat.o(286798);
  }
  
  private final void dFX()
  {
    String str = null;
    AppMethodBeat.i(286774);
    Object localObject2;
    label50:
    label77:
    int i;
    if (dGl())
    {
      localObject1 = this;
      localObject1 = (i)localObject1;
      if (localObject1 == null) {
        break label223;
      }
      localObject2 = com.tencent.mm.ui.component.g.Xox;
      com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class);
      if (!com.tencent.mm.plugin.finder.viewmodel.a.ejZ()) {
        break label188;
      }
      if (localObject1 == null) {
        break label223;
      }
      localObject2 = this.zcr;
      if (localObject2 == null) {
        break label193;
      }
      localObject2 = ((ah)localObject2).getLocation();
      if (localObject2 == null) {
        break label193;
      }
      localObject2 = ((bdm)localObject2).city;
      localObject2 = (CharSequence)localObject2;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label198;
      }
      i = 1;
      label97:
      if (i == 0) {
        break label203;
      }
      label101:
      if (localObject1 == null) {
        break label223;
      }
      localObject2 = this.zcr;
      if (localObject2 == null) {
        break label208;
      }
      localObject2 = ((ah)localObject2).getLocation();
      if (localObject2 == null) {
        break label208;
      }
      localObject2 = ((bdm)localObject2).poiName;
      label128:
      localObject2 = (CharSequence)localObject2;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label213;
      }
      i = 1;
      label148:
      if (i == 0) {
        break label218;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label223;
      }
      com.tencent.mm.ui.base.w.cP((Context)getContext(), getContext().getString(b.j.finder_live_mall_live_premise));
      AppMethodBeat.o(286774);
      return;
      localObject1 = null;
      break;
      label188:
      localObject1 = null;
      break label50;
      label193:
      localObject2 = null;
      break label77;
      label198:
      i = 0;
      break label97;
      label203:
      localObject1 = null;
      break label101;
      label208:
      localObject2 = null;
      break label128;
      label213:
      i = 0;
      break label148;
      label218:
      localObject1 = null;
    }
    label223:
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      new f.a((Context)getActivity()).icD().bBl(getActivity().getResources().getString(b.j.finder_live_jump_tip_network_unavailable)).bBp(getActivity().getResources().getString(b.j.app_i_know)).b((f.c)s.zcY).show();
      AppMethodBeat.o(286774);
      return;
    }
    Object localObject1 = this.zct;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.widget.ag)localObject1).isReady());; localObject1 = null)
    {
      if (localObject1 == null) {
        p.iCn();
      }
      if (((Boolean)localObject1).booleanValue()) {
        break label374;
      }
      localObject1 = this.zcu;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.live.widget.t)localObject1).znZ.setVisibility(0);
      ((com.tencent.mm.plugin.finder.live.widget.t)localObject1).kFV.show();
      AppMethodBeat.o(286774);
      return;
    }
    AppMethodBeat.o(286774);
    return;
    label374:
    localObject1 = this.zcI;
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((an)localObject1).isReady());; localObject1 = null)
    {
      if (localObject1 == null) {
        p.iCn();
      }
      if (((Boolean)localObject1).booleanValue()) {
        break label438;
      }
      localObject1 = this.zcI;
      if (localObject1 == null) {
        break;
      }
      ((an)localObject1).pM(true);
      AppMethodBeat.o(286774);
      return;
    }
    AppMethodBeat.o(286774);
    return;
    label438:
    localObject1 = this.zcs;
    if (localObject1 != null) {
      if ((!Util.isNullOrNil(((ae)localObject1).zfA)) || (!Util.isNullOrNil(((ae)localObject1).nfY)) || ((!Util.isNullOrNil(((ae)localObject1).zex)) && (com.tencent.mm.vfs.u.agG(((ae)localObject1).zex))))
      {
        i = 1;
        if (i != 1) {
          break label734;
        }
        localObject1 = this.zct;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.widget.ag)localObject1).isReady() != true)) {
          break label734;
        }
        localObject1 = this.zcI;
        if ((localObject1 == null) || (((an)localObject1).isReady() != true)) {
          break label734;
        }
        i = 1;
        label530:
        if (i == 0) {
          break label811;
        }
        localObject1 = this.zcE;
        if (localObject1 != null) {
          ((View)localObject1).setEnabled(false);
        }
        localObject1 = this.zcs;
        if (localObject1 == null) {
          break label749;
        }
        if ((Util.isNullOrNil(((ae)localObject1).zex)) || (!com.tencent.mm.vfs.u.agG(((ae)localObject1).zex))) {
          break label739;
        }
        i = 1;
        label579:
        if (i != 1) {
          break label749;
        }
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder("choose live cover:");
        localObject1 = this.zcs;
        if (localObject1 == null) {
          break label744;
        }
        localObject1 = ((ae)localObject1).zex;
        label614:
        localStringBuilder = localStringBuilder.append((String)localObject1).append(", ");
        ae localae = this.zcs;
        localObject1 = str;
        if (localae != null) {
          localObject1 = localae.nfY;
        }
        Log.i((String)localObject2, (String)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.upload.g.AAk;
        localObject2 = com.tencent.mm.plugin.finder.upload.g.ecj();
        localObject1 = this.zcs;
        if (localObject1 != null)
        {
          localObject1 = ((ae)localObject1).zex;
          if (localObject1 != null) {
            break label826;
          }
        }
        localObject1 = "";
      }
    }
    label811:
    label818:
    label826:
    for (;;)
    {
      str = z.bdh();
      p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.upload.g)localObject2).a((String)localObject1, str, (f)new r(this));
      AppMethodBeat.o(286774);
      return;
      i = 0;
      break;
      label734:
      i = 0;
      break label530;
      label739:
      i = 0;
      break label579;
      label744:
      localObject1 = null;
      break label614;
      label749:
      localObject1 = this.zcs;
      if (localObject1 != null) {
        if (Util.isNullOrNil(((ae)localObject1).zfA)) {
          break label818;
        }
      }
      for (localObject1 = ((ae)localObject1).zfA;; localObject1 = ((ae)localObject1).nfY)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        r((String)localObject2, (String)localObject2, "", "");
        Log.i(TAG, "choose default cover:".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(286774);
        return;
      }
    }
  }
  
  private final boolean dGb()
  {
    AppMethodBeat.i(286784);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa;; i = 0)
    {
      boolean bool = com.tencent.mm.ae.d.dr(i, 64);
      AppMethodBeat.o(286784);
      return bool;
    }
  }
  
  private final boolean dGc()
  {
    AppMethodBeat.i(286785);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa; !com.tencent.mm.ae.d.dr(i, 8); i = 0)
    {
      AppMethodBeat.o(286785);
      return true;
    }
    AppMethodBeat.o(286785);
    return false;
  }
  
  private final boolean dGd()
  {
    AppMethodBeat.i(286786);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa; !com.tencent.mm.ae.d.dr(i, 512); i = 0)
    {
      AppMethodBeat.o(286786);
      return true;
    }
    AppMethodBeat.o(286786);
    return false;
  }
  
  private final boolean dGf()
  {
    AppMethodBeat.i(286788);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa;; i = 0)
    {
      boolean bool = com.tencent.mm.ae.d.dr(i, 128);
      AppMethodBeat.o(286788);
      return bool;
    }
  }
  
  private final boolean dGg()
  {
    AppMethodBeat.i(286789);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa;; i = 0)
    {
      boolean bool = com.tencent.mm.ae.d.dr(i, 1024);
      AppMethodBeat.o(286789);
      return bool;
    }
  }
  
  private final boolean dGh()
  {
    AppMethodBeat.i(286790);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgs == true))
      {
        AppMethodBeat.o(286790);
        return true;
      }
    }
    AppMethodBeat.o(286790);
    return false;
  }
  
  private final boolean dGl()
  {
    AppMethodBeat.i(286797);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).yeG;
        if ((localObject != null) && (((bda)localObject).SOm == 1))
        {
          AppMethodBeat.o(286797);
          return true;
        }
      }
    }
    AppMethodBeat.o(286797);
    return false;
  }
  
  public final void ai(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(286782);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zga;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.m)localObject).zeT;
          if (localObject != null) {
            ((LinkedList)localObject).clear();
          }
        }
      }
    }
    if (paramArrayList != null)
    {
      localObject = this.xYp;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zga;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.m)localObject).zeT;
            if (localObject != null) {
              ((LinkedList)localObject).addAll((Collection)paramArrayList);
            }
          }
        }
      }
    }
    paramArrayList = this.zcJ;
    if (paramArrayList != null)
    {
      paramArrayList.dIt();
      AppMethodBeat.o(286782);
      return;
    }
    AppMethodBeat.o(286782);
  }
  
  public final void aw(LinkedList<bbt> paramLinkedList)
  {
    AppMethodBeat.i(286775);
    if (paramLinkedList != null)
    {
      int i;
      if (!((Collection)paramLinkedList).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label119;
        }
        label28:
        if (paramLinkedList == null) {
          break label170;
        }
        localObject1 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
      }
      label55:
      label119:
      label127:
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label129;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        bbt localbbt = (bbt)localObject2;
        if ((localbbt.SNz == -1) || (localbbt.SNz > 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label127;
          }
          paramLinkedList.add(localObject2);
          break label55;
          i = 0;
          break;
          paramLinkedList = null;
          break label28;
        }
      }
      label129:
      paramLinkedList = (List)paramLinkedList;
      Object localObject1 = this.zcK;
      if (localObject1 != null) {
        ((FinderLiveTaskBannerView)localObject1).setVisibility(0);
      }
      localObject1 = this.zcK;
      if (localObject1 == null) {
        break label199;
      }
      ((FinderLiveTaskBannerView)localObject1).setTaskInfoList(paramLinkedList);
    }
    label170:
    label199:
    for (paramLinkedList = x.aazN;; paramLinkedList = null)
    {
      if (paramLinkedList == null)
      {
        paramLinkedList = ((i)this).zcK;
        if (paramLinkedList != null) {
          paramLinkedList.setVisibility(8);
        }
        paramLinkedList = x.aazN;
      }
      AppMethodBeat.o(286775);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.finder.api.i dFW()
  {
    AppMethodBeat.i(286771);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgp;
        AppMethodBeat.o(286771);
        return localObject;
      }
    }
    AppMethodBeat.o(286771);
    return null;
  }
  
  public final void dFY()
  {
    AppMethodBeat.i(286780);
    Log.i(TAG, "afterSelectTagOperation");
    Object localObject = this.xYp;
    if ((localObject != null) && ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class) != null))
    {
      if (dGl())
      {
        localObject = this.zcr;
        if (localObject != null) {
          ((ah)localObject).dIA();
        }
      }
      localObject = this.zcr;
      if (localObject != null)
      {
        if (!dGl()) {}
        for (boolean bool = true;; bool = false)
        {
          ((ah)localObject).pK(bool);
          AppMethodBeat.o(286780);
          return;
        }
      }
      AppMethodBeat.o(286780);
      return;
    }
    AppMethodBeat.o(286780);
  }
  
  public final void dFZ()
  {
    AppMethodBeat.i(286781);
    Object localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool;
    label85:
    int i;
    if (((Number)com.tencent.c.a.a.a.a.a.ime().aSr()).intValue() == 0)
    {
      bool = true;
      Log.i(TAG, "prepareMenuItems,showVisibilityEntrance:".concat(String.valueOf(bool)));
      if (!bool) {
        break label254;
      }
      localObject1 = this.zcA;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.zcA;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new q(this));
      }
      localObject1 = this.xYp;
      if (localObject1 == null) {
        break label272;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
      if (localObject1 == null) {
        break label272;
      }
      i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziS;
    }
    Context localContext;
    for (;;)
    {
      if (com.tencent.mm.ae.d.dr(i, 7))
      {
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_more_action_visibility);
        p.j(localObject1, "MMApplicationContext.get…e_more_action_visibility)");
        localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_visibility_white_list);
        p.j(localObject2, "MMApplicationContext.get…ve_visibility_white_list)");
        localTextView = this.zcB;
        if (localTextView != null)
        {
          localContext = MMApplicationContext.getContext();
          p.j(localContext, "MMApplicationContext.getContext()");
          localTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_visibility_desc, new Object[] { localObject1, localObject2 }));
          AppMethodBeat.o(286781);
          return;
          bool = false;
          break;
          label254:
          localObject1 = this.zcA;
          if (localObject1 == null) {
            break label85;
          }
          ((View)localObject1).setVisibility(8);
          break label85;
          label272:
          i = 0;
          continue;
        }
        AppMethodBeat.o(286781);
        return;
      }
    }
    localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_more_action_visibility);
    p.j(localObject1, "MMApplicationContext.get…e_more_action_visibility)");
    Object localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_visibility_public);
    p.j(localObject2, "MMApplicationContext.get…r_live_visibility_public)");
    TextView localTextView = this.zcB;
    if (localTextView != null)
    {
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      localTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_visibility_desc, new Object[] { localObject1, localObject2 }));
      AppMethodBeat.o(286781);
      return;
    }
    AppMethodBeat.o(286781);
  }
  
  public final void dGa()
  {
    AppMethodBeat.i(286783);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa &= 0xFFFFFFBF;
        AppMethodBeat.o(286783);
        return;
      }
    }
    AppMethodBeat.o(286783);
  }
  
  public final void dGe()
  {
    AppMethodBeat.i(286787);
    Object localObject = this.xYp;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfa &= 0xFFFFFF7F;
        AppMethodBeat.o(286787);
        return;
      }
    }
    AppMethodBeat.o(286787);
  }
  
  public final void dGi()
  {
    AppMethodBeat.i(286791);
    View localView = this.zcE;
    if (localView != null)
    {
      localView.setEnabled(true);
      AppMethodBeat.o(286791);
      return;
    }
    AppMethodBeat.o(286791);
  }
  
  public final void dGj()
  {
    AppMethodBeat.i(286792);
    Log.i(TAG, "checkState state:" + this.state);
    if (this.state == this.zci)
    {
      localObject = this.zcF;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.zcw;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).setVisibility(0);
        AppMethodBeat.o(286792);
        return;
      }
      AppMethodBeat.o(286792);
      return;
    }
    Object localObject = this.zcF;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    localObject = this.zcw;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setVisibility(4);
      AppMethodBeat.o(286792);
      return;
    }
    AppMethodBeat.o(286792);
  }
  
  public final void dGk()
  {
    AppMethodBeat.i(286793);
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder("loadOptions exptFilterEnable:");
    Object localObject1 = this.xYp;
    label101:
    int i;
    label198:
    int j;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zfQ);
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(", exptBeautyEnable:");
        localObject1 = this.xYp;
        if (localObject1 == null) {
          break label265;
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (localObject1 == null) {
          break label265;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zfP);
        Log.i((String)localObject2, localObject1);
        this.zcL.clear();
        i = 0;
        if (i >= 3) {
          break label351;
        }
        if (i != 1) {
          break label332;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (!com.tencent.mm.plugin.finder.live.utils.a.dEG()) {
          break label325;
        }
        this.zcL.add(new d(i));
        localObject1 = this.xYp;
        if (localObject1 == null) {
          break label270;
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if (localObject1 == null) {
          break label270;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).zgj;
        if (localObject1 == null) {
          break label270;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).ydg;
        localObject2 = (Collection)localObject1;
        if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
          break label275;
        }
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        localObject2 = getActivity();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(286793);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
          label265:
          localObject1 = null;
          break label101;
          label270:
          localObject1 = null;
          break label198;
          label275:
          j = 0;
          continue;
        }
        localObject2 = (MMActivity)localObject2;
        localObject3 = this.xYp;
        if (localObject3 == null) {
          p.iCn();
        }
        ayk localayk = new ayk();
        localayk.SKz = ((LinkedList)localObject1);
        com.tencent.mm.plugin.finder.live.utils.a.a((MMActivity)localObject2, (com.tencent.mm.plugin.finder.live.model.context.a)localObject3, localayk);
      }
    }
    for (;;)
    {
      label325:
      i += 1;
      break;
      label332:
      this.zcL.add(new d(i));
    }
    label351:
    AppMethodBeat.o(286793);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 0;
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(286779);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(TAG, "onActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    ae localae = this.zcs;
    Object localObject1;
    Object localObject2;
    if (localae != null)
    {
      if (paramInt1 != localae.zlk) {
        break label516;
      }
      if (paramIntent == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.a(s.o.yGp);
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDP.jWO, String.valueOf(s.n.yGk.action));
      }
    }
    else
    {
      localObject2 = this.zcr;
      if (localObject2 == null) {}
    }
    switch (paramInt1)
    {
    default: 
      label144:
      localObject1 = this.zcI;
      if ((localObject1 != null) && (paramInt2 == -1) && (paramInt1 == 1003)) {
        ((an)localObject1).dII();
      }
      if (paramInt2 == -1) {}
      switch (paramInt1)
      {
      case 1002: 
      default: 
        AppMethodBeat.o(286779);
        return;
        localObject1 = paramIntent.getData();
        if (localObject1 != null)
        {
          localObject1 = ((Uri)localObject1).getPath();
          label233:
          localObject2 = paramIntent.getData();
          if (localObject2 == null) {
            break label369;
          }
          localObject2 = ((Uri)localObject2).getPath();
          label251:
          if (!Util.isNullOrNil((String)localObject2)) {
            break label2244;
          }
          localObject1 = (Context)localae.activity;
          localObject2 = av.AJz;
          localObject1 = com.tencent.mm.pluginsdk.ui.tools.u.g((Context)localObject1, paramIntent, av.egn());
        }
        break;
      }
      break;
    }
    label516:
    label541:
    label572:
    label2115:
    label2244:
    for (;;)
    {
      Log.i(localae.TAG, "filePath[" + (String)localObject1 + "] " + paramIntent);
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.a(s.o.yGp);
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDP.jWO, String.valueOf(s.n.yGk.action));
        break;
        localObject1 = null;
        break label233;
        label369:
        localObject2 = null;
        break label251;
      }
      localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.a((Activity)localae.activity, (String)localObject1, "", localae.zll, localae.activity.getResources().getColor(com.tencent.mm.plugin.finder.b.c.room_live_logo_color));
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.a(s.o.yGp);
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDP.jWO, String.valueOf(s.n.yGk.action));
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.live.report.k.yBj;
      localObject1 = ((Uri)localObject1).toString();
      p.j(localObject1, "dataFilePath.toString()");
      if (kotlin.n.n.M((String)localObject1, "file://", false)) {}
      for (localObject1 = s.o.yGq;; localObject1 = s.o.yGr)
      {
        com.tencent.mm.plugin.finder.live.report.k.a((s.o)localObject1);
        break;
      }
      if (paramInt1 != localae.zll) {
        break;
      }
      Object localObject5;
      if (paramIntent != null)
      {
        localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        localObject5 = localae.TAG;
        StringBuilder localStringBuilder = new StringBuilder("REQUEST_CODE_CROP_FIX_IMAGE model: ");
        if (localObject1 == null) {
          break label674;
        }
        localObject2 = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).aZe();
        Log.i((String)localObject5, (String)localObject2);
        if (localObject1 == null) {
          break label680;
        }
      }
      for (localObject2 = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).aZe();; localObject2 = null)
      {
        if ((localObject2 != null) && (com.tencent.mm.vfs.u.agG((String)localObject2))) {
          break label686;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.a(s.o.yGp);
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDP.jWO, String.valueOf(s.n.yGk.action));
        Log.e(localae.TAG, "ERROR! filePath=".concat(String.valueOf(localObject2)));
        break;
        localObject1 = null;
        break label541;
        localObject2 = null;
        break label572;
      }
      localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
      p.j(localObject1, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject1).aLM().kpc == 0)
      {
        i = 2;
        label713:
        localObject1 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        if (com.tencent.mm.plugin.finder.live.report.k.dDl() != s.o.yGq.type) {
          break label863;
        }
        if (i != 1) {
          break label849;
        }
        localObject1 = String.valueOf(s.n.yGl.action);
      }
      for (;;)
      {
        localObject5 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDP.jWO, (String)localObject1);
        localObject1 = aj.AGc;
        aj.b(localae.sDJ, (String)localObject2, Math.min(localae.sDJ.getWidth(), 500), Math.min(localae.sDJ.getHeight(), 500));
        localae.zex = ((String)localObject2);
        localae.nfY = "";
        localae.zfA = "";
        localae.zlm.onChange();
        break;
        i = 1;
        break label713;
        label849:
        localObject1 = String.valueOf(s.n.yGm.action);
        continue;
        label863:
        localObject1 = String.valueOf(s.n.yGn.action);
      }
      if (paramIntent == null) {
        break label144;
      }
      ((ah)localObject2).yOK.ax(paramIntent);
      ((ah)localObject2).yOK.ecH();
      localObject1 = ((ah)localObject2).yOK.ACz;
      if (localObject1 != null)
      {
        localObject1 = ((bdm)localObject1).poiName;
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = ((ah)localObject2).yOK.ACz;
          if (localObject1 == null) {
            break label1114;
          }
        }
      }
      label1114:
      for (localObject1 = ((bdm)localObject1).city;; localObject1 = null)
      {
        if (Util.isNullOrNil((String)localObject1)) {
          ((ah)localObject2).yOK.ACz = null;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("poiClassifyId", Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), ""));
        ((JSONObject)localObject1).put("longitude", Float.valueOf(paramIntent.getFloatExtra("get_lng", -1000.0F)));
        ((JSONObject)localObject1).put("latitude", Float.valueOf(paramIntent.getFloatExtra("get_lat", -85.0F)));
        ((JSONObject)localObject1).put("city", Util.nullAs(paramIntent.getStringExtra("get_city"), ""));
        ((JSONObject)localObject1).put("poiname", Util.nullAs(paramIntent.getStringExtra("get_poi_name"), ""));
        localObject2 = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDR.jWO, ((JSONObject)localObject1).toString());
        break;
        localObject1 = null;
        break label920;
      }
      localObject1 = this.xYp;
      if (localObject1 != null)
      {
        localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        if (localObject4 != null)
        {
          if (paramIntent == null) {
            break label2103;
          }
          localObject1 = a.d.BuY;
          localObject1 = paramIntent.getSerializableExtra(a.d.emZ());
          localObject2 = localObject1;
          if (!kotlin.g.b.ag.fe(localObject1)) {
            localObject2 = null;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject4).ziR = ((List)localObject2);
        }
      }
      if (paramIntent != null)
      {
        localObject1 = a.d.BuY;
        localObject1 = paramIntent.getStringArrayListExtra(a.d.ena());
        if (localObject1 != null)
        {
          localObject2 = this.xYp;
          if (localObject2 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
            if (localObject2 != null)
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).ziT;
              if (localObject2 != null) {
                ((ArrayList)localObject2).clear();
              }
            }
          }
          localObject2 = this.xYp;
          if (localObject2 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
            if (localObject2 != null)
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).ziT;
              if (localObject2 != null) {
                ((ArrayList)localObject2).addAll((Collection)localObject1);
              }
            }
          }
        }
        if (paramIntent == null) {
          break label2115;
        }
        localObject1 = a.d.BuY;
        localObject1 = paramIntent.getStringArrayListExtra(a.d.enb());
        if (localObject1 != null)
        {
          localObject2 = this.xYp;
          if (localObject2 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
            if (localObject2 != null)
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).ziU;
              if (localObject2 != null) {
                ((ArrayList)localObject2).clear();
              }
            }
          }
          localObject2 = this.xYp;
          if (localObject2 != null)
          {
            localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
            if (localObject2 != null)
            {
              localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).ziU;
              if (localObject2 != null) {
                ((ArrayList)localObject2).addAll((Collection)localObject1);
              }
            }
          }
        }
        if (paramIntent == null) {
          break label2121;
        }
        localObject1 = a.d.BuY;
        paramInt1 = paramIntent.getIntExtra(a.d.emX(), 0);
        localObject1 = TAG;
        localObject2 = new StringBuilder("onActivityResult REQUEST_CODE_VISITOR_WHITE_LIST visibilityChooseByteArray size:");
        paramIntent = this.xYp;
        if (paramIntent == null) {
          break label2126;
        }
        paramIntent = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramIntent.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        if (paramIntent == null) {
          break label2126;
        }
        paramIntent = paramIntent.ziR;
        if (paramIntent == null) {
          break label2126;
        }
        paramIntent = Integer.valueOf(paramIntent.size());
        label1512:
        localObject2 = ((StringBuilder)localObject2).append(paramIntent).append(",anchorChooseMode:").append(paramInt1).append(", chooseRoomList:");
        localObject4 = this.xYp;
        paramIntent = localObject3;
        if (localObject4 != null)
        {
          localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          paramIntent = localObject3;
          if (localObject4 != null) {
            paramIntent = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject4).ziT;
          }
        }
        Log.i((String)localObject1, paramIntent);
        paramIntent = this.xYp;
        if (paramIntent != null)
        {
          paramIntent = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramIntent.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (paramIntent != null)
          {
            if (!com.tencent.mm.ae.d.dr(paramInt1, 1)) {
              break label2238;
            }
            localObject1 = this.xYp;
            if (localObject1 == null) {
              break label2131;
            }
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
            if (localObject1 == null) {
              break label2131;
            }
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziR;
            if (localObject1 == null) {
              break label2131;
            }
            paramInt2 = ((List)localObject1).size();
            if (paramInt2 > 0) {
              break label2238;
            }
          }
        }
      }
      for (int i = paramInt1 & 0xFFFFFFFE;; i = paramInt1)
      {
        paramInt2 = i;
        if (com.tencent.mm.ae.d.dr(paramInt1, 2))
        {
          localObject1 = this.xYp;
          if (localObject1 == null) {
            break label2136;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (localObject1 == null) {
            break label2136;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziT;
          if (localObject1 == null) {
            break label2136;
          }
          j = ((ArrayList)localObject1).size();
          label1741:
          paramInt2 = i;
          if (j <= 0) {
            paramInt2 = paramInt1 & 0xFFFFFFFD;
          }
        }
        int j = paramInt2;
        if (com.tencent.mm.ae.d.dr(paramInt1, 4))
        {
          localObject1 = this.xYp;
          if (localObject1 == null) {
            break label2142;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (localObject1 == null) {
            break label2142;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziU;
          if (localObject1 == null) {
            break label2142;
          }
        }
        label2121:
        label2126:
        label2131:
        label2136:
        label2142:
        for (i = ((ArrayList)localObject1).size();; i = 0)
        {
          j = paramInt2;
          if (i <= 0) {
            j = paramInt1 & 0xFFFFFFFB;
          }
          if (!com.tencent.mm.ae.d.dr(paramInt1, 1))
          {
            localObject1 = this.xYp;
            if (localObject1 != null)
            {
              localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziR;
                if (localObject1 != null) {
                  ((List)localObject1).clear();
                }
              }
            }
          }
          if (!com.tencent.mm.ae.d.dr(paramInt1, 2))
          {
            localObject1 = this.xYp;
            if (localObject1 != null)
            {
              localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziT;
                if (localObject1 != null) {
                  ((ArrayList)localObject1).clear();
                }
              }
            }
          }
          if (!com.tencent.mm.ae.d.dr(paramInt1, 4))
          {
            localObject1 = this.xYp;
            if (localObject1 != null)
            {
              localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
              if (localObject1 != null)
              {
                localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).ziU;
                if (localObject1 != null) {
                  ((ArrayList)localObject1).clear();
                }
              }
            }
          }
          Log.i(TAG, "checkVisibilityMode oriMode:" + paramInt1 + " finalMode:" + j);
          paramIntent.ziS = j;
          paramIntent = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          paramIntent = this.xYp;
          paramInt1 = k;
          if (paramIntent != null)
          {
            paramIntent = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramIntent.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
            paramInt1 = k;
            if (paramIntent != null) {
              paramInt1 = paramIntent.ziS;
            }
          }
          paramIntent = com.tencent.mm.plugin.finder.live.utils.a.NH(paramInt1);
          com.tencent.mm.ui.base.w.a((Context)getContext(), paramIntent, (w.b)o.zcX);
          dFZ();
          AppMethodBeat.o(286779);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label1210;
          localObject1 = null;
          break label1331;
          paramInt1 = 0;
          break label1452;
          paramIntent = null;
          break label1512;
          paramInt2 = 0;
          break label1672;
          j = 0;
          break label1741;
        }
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_START_LIVE", false) == true))
        {
          Log.i(TAG, "onActivityResult REQUEST_CODE_SELECT_TAG startLive by selected tag result");
          dFX();
          AppMethodBeat.o(286779);
          return;
        }
        dFY();
        AppMethodBeat.o(286779);
        return;
        localObject1 = localObject4;
        if (paramIntent != null) {
          localObject1 = paramIntent.getStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
        }
        Log.i(TAG, "onActivityResult REQUEST_CODE_SELECT_LUCKY_MONEY_ROOM chatroomList:".concat(String.valueOf(localObject1)));
        ai((ArrayList)localObject1);
        break;
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(286796);
    Object localObject = this.zcu;
    if (localObject != null)
    {
      if (((com.tencent.mm.plugin.finder.live.widget.t)localObject).znZ.getVisibility() == 0) {
        ((com.tencent.mm.plugin.finder.live.widget.t)localObject).kFV.hide();
      }
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(286796);
        return true;
      }
    }
    if (this.state == this.zcj)
    {
      this.state = this.zci;
      localObject = this.kCL;
      if (localObject != null) {
        b.b.a((com.tencent.mm.live.c.b)localObject, com.tencent.mm.live.c.b.c.kAJ);
      }
      dGj();
      AppMethodBeat.o(286796);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(286796);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(286795);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_post_top_close_area;
      if (paramView != null) {
        break label111;
      }
      label59:
      i = b.f.finder_live_post_top_close;
      if (paramView != null) {
        break label183;
      }
      i = b.f.finder_live_post_mask;
      if (paramView != null) {
        break label194;
      }
      label75:
      i = b.f.finder_live_post_top_more;
      if (paramView != null) {
        break label221;
      }
    }
    for (;;)
    {
      label83:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286795);
      return;
      paramView = null;
      break;
      label111:
      if (paramView.intValue() != i) {
        break label59;
      }
      for (;;)
      {
        paramView = this.kCL;
        if (paramView != null) {
          b.b.a(paramView, com.tencent.mm.live.c.b.c.kyW);
        }
        paramView = this.kCL;
        if ((paramView == null) || (paramView.getLiveRole() != 1)) {
          break label83;
        }
        paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDV.jWO, "");
        paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.dDk());
        break label83;
        label183:
        if (paramView.intValue() != i) {
          break;
        }
      }
      label194:
      if (paramView.intValue() != i) {
        break label75;
      }
      if (this.state != this.zci)
      {
        onBackPressed();
        continue;
        label221:
        if (paramView.intValue() == i)
        {
          if (this.kCR == null)
          {
            this.kCR = new e((Context)getContext(), 0, true);
            paramView = this.kCR;
            if (paramView != null) {
              paramView.icA();
            }
          }
          paramView = this.kCR;
          if (paramView != null) {
            paramView.icy();
          }
          paramView = this.kCR;
          if (paramView != null) {
            paramView.HK(false);
          }
          paramView = this.kCR;
          if (paramView != null) {
            paramView.a((q.f)new g(this));
          }
          paramView = this.kCR;
          if (paramView != null) {
            paramView.a(this.ybB);
          }
          paramView = this.kCR;
          if (paramView != null) {
            paramView.b((e.b)new h(this));
          }
          paramView = this.kCR;
          if (paramView != null) {
            paramView.eik();
          }
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286772);
    super.onCreate(paramBundle);
    h.aGY().a(5874, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(286772);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286776);
    super.onDestroy();
    Object localObject = this.zcr;
    if (localObject != null) {
      ((ah)localObject).zqo = true;
    }
    h.aGY().b(5874, (com.tencent.mm.an.i)this);
    h.aGY().b(3761, (com.tencent.mm.an.i)this);
    localObject = this.xNU;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.utils.n)localObject).dead();
      AppMethodBeat.o(286776);
      return;
    }
    AppMethodBeat.o(286776);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(286773);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("KEY_PARAMS_CHOSEN_TAG");
      if (paramIntent != null)
      {
        Object localObject = this.xYp;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (localObject != null)
          {
            bda localbda = new bda();
            localbda.parseFrom(paramIntent);
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).yeG = localbda;
          }
        }
        paramIntent = this.zcp;
        if (paramIntent != null)
        {
          paramIntent.post((Runnable)new p(this));
          AppMethodBeat.o(286773);
          return;
        }
        AppMethodBeat.o(286773);
        return;
      }
    }
    AppMethodBeat.o(286773);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286777);
    super.onPause();
    FinderLiveTaskBannerView localFinderLiveTaskBannerView = this.zcK;
    if (localFinderLiveTaskBannerView != null)
    {
      localFinderLiveTaskBannerView.stop();
      AppMethodBeat.o(286777);
      return;
    }
    AppMethodBeat.o(286777);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286778);
    super.onResume();
    FinderLiveTaskBannerView localFinderLiveTaskBannerView = this.zcK;
    if (localFinderLiveTaskBannerView != null)
    {
      localFinderLiveTaskBannerView.zrA = true;
      localFinderLiveTaskBannerView.startLoop();
      AppMethodBeat.o(286778);
      return;
    }
    AppMethodBeat.o(286778);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq) {}
  
  public final void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(286794);
    p.k(paramString1, "coverUrl");
    p.k(paramString2, "thumbUrl");
    p.k(paramString3, "path");
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    Object localObject = this.zcv;
    label104:
    float f1;
    if (localObject != null)
    {
      localObject = ((af)localObject).zbm;
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getText();
        localFinderObjectDesc.description = String.valueOf(localObject);
        localFinderObjectDesc.mediaType = 9;
        localObject = this.zcr;
        if (localObject == null) {
          break label617;
        }
        localObject = ((ah)localObject).getLocation();
        localFinderObjectDesc.location = ((bdm)localObject);
        localFinderObjectDesc.extReading = new asl();
        localObject = new azd();
        ((azd)localObject).zfA = paramString1;
        localFinderObjectDesc.liveDesc = ((azd)localObject);
        localObject = new FinderMedia();
        ((FinderMedia)localObject).url = paramString1;
        ((FinderMedia)localObject).mediaType = 9;
        ((FinderMedia)localObject).thumbUrl = paramString2;
        ((FinderMedia)localObject).videoDuration = 0;
        if (Util.isNullOrNil(paramString3)) {
          break label623;
        }
        paramString2 = aj.AGc;
        paramString2 = aj.aFH(paramString3);
        label195:
        if (paramString2 == null) {
          break label642;
        }
        f1 = paramString2.x;
        label206:
        ((FinderMedia)localObject).width = f1;
        f1 = f2;
        if (paramString2 != null) {
          f1 = paramString2.y;
        }
        ((FinderMedia)localObject).height = f1;
        if (paramString4 != null) {
          break label680;
        }
      }
    }
    label394:
    label423:
    label680:
    for (paramString2 = "";; paramString2 = paramString4)
    {
      ((FinderMedia)localObject).md5sum = paramString2;
      ((FinderMedia)localObject).coverUrl = paramString1;
      localFinderObjectDesc.media.add(localObject);
      paramString3 = TAG;
      paramString2 = new StringBuilder("desc coverUrl:");
      paramString1 = localFinderObjectDesc.media;
      p.j(paramString1, "objectDesc.media");
      paramString1 = (FinderMedia)paramString1.getFirst();
      if (paramString1 != null)
      {
        paramString1 = paramString1.coverUrl;
        label312:
        paramString2 = paramString2.append(paramString1).append(",thumbUrl:");
        paramString1 = localFinderObjectDesc.media;
        p.j(paramString1, "objectDesc.media");
        paramString1 = (FinderMedia)paramString1.getFirst();
        if (paramString1 == null) {
          break label653;
        }
        paramString1 = paramString1.thumbUrl;
        label354:
        paramString2 = paramString2.append(paramString1).append(",md5:").append(paramString4).append(", selfContact.anchorFlag:");
        paramString1 = dFW();
        if (paramString1 == null) {
          break label658;
        }
        paramString1 = Long.valueOf(paramString1.field_liveAnchorStatusFlag);
        paramString2 = paramString2.append(paramString1).append(", selfContact.switchFlag:");
        paramString1 = dFW();
        if (paramString1 == null) {
          break label663;
        }
        paramString1 = Long.valueOf(paramString1.field_liveSwitchFlag);
        paramString4 = paramString2.append(paramString1).append(", linkMic:").append(dGb()).append(", gift:").append(dGf()).append(", comment:").append(dGc()).append(",location:");
        paramString2 = localFinderObjectDesc.location;
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        Log.i(paramString3, com.tencent.mm.ae.g.bN(paramString1));
        paramString1 = this.xYp;
        if (paramString1 == null) {
          break label668;
        }
      }
      for (paramString1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramString1.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);; paramString1 = null)
      {
        paramString2 = dFW();
        if ((paramString1 != null) && (paramString2 != null))
        {
          paramString2.field_liveAnchorStatusFlag = paramString1.zfa;
          paramString3 = com.tencent.mm.plugin.finder.api.d.wZQ;
          d.a.c(paramString2);
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.LS(paramString1.zfa);
          com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.LT(paramString2.field_liveSwitchFlag);
        }
        paramString1 = this.zct;
        if (paramString1 != null) {
          paramString1.dIm();
        }
        paramString1 = this.zcN;
        if (paramString1 == null) {
          break label673;
        }
        paramString1.invoke(localFinderObjectDesc);
        AppMethodBeat.o(286794);
        return;
        localObject = null;
        break;
        label617:
        localObject = null;
        break label104;
        label623:
        if (this.zcs != null)
        {
          paramString2 = ae.dHG();
          break label195;
        }
        paramString2 = null;
        break label195;
        f1 = 0.0F;
        break label206;
        paramString1 = null;
        break label312;
        paramString1 = null;
        break label354;
        paramString1 = null;
        break label394;
        paramString1 = null;
        break label423;
      }
      AppMethodBeat.o(286794);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<i.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(240774);
      int i = i.a(this.zcQ).size();
      AppMethodBeat.o(240774);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(i.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(222607);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = (i.d)kotlin.a.j.M((List)i.a(this.zcR.zcQ), this.jEN);
        if (paramView != null)
        {
          localObject = i.c(this.zcR.zcQ);
          if (localObject != null) {
            ((kotlin.g.a.b)localObject).invoke(paramView);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(222607);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;Landroid/view/View;)V", "optIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getOptIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "optTv", "Landroid/widget/TextView;", "getOptTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    final WeImageView zcS;
    final TextView zcT;
    
    public b()
    {
      super();
      AppMethodBeat.i(230559);
      this.zcS = ((WeImageView)localObject.findViewById(b.f.finder_live_before_camera_opt_item_icon));
      this.zcT = ((TextView)localObject.findViewById(b.f.finder_live_before_camera_opt_item_tv));
      AppMethodBeat.o(230559);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "", "key", "", "(I)V", "getKey", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class d
  {
    final int key;
    
    public d(int paramInt)
    {
      this.key = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if (this.key != paramObject.key) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.key;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(241655);
      String str = "OptionInfo(key=" + this.key + ")";
      AppMethodBeat.o(241655);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "", "onChange", "", "plugin-finder_release"})
  public static abstract interface e
  {
    public abstract void onChange();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$adjustMargin$1$1"})
  public static final class f
    implements Runnable
  {
    public f(View paramView, i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(278765);
      Object localObject = i.l(this.zcQ);
      if (localObject != null) {}
      for (localObject = ((RelativeLayout)localObject).getLayoutParams(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(278765);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      int i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (ax.getStatusBarHeight((Context)this.zcQ.getActivity()) + i);
      localObject = this.kJS;
      if (localObject != null)
      {
        i = this.kJS.getPaddingLeft();
        int j = this.kJS.getPaddingTop();
        int k = this.kJS.getPaddingRight();
        int m = this.kJS.getPaddingBottom();
        ((View)localObject).setPadding(i, j, k, ax.aB((Context)this.zcQ.getActivity()) + m);
        AppMethodBeat.o(278765);
        return;
      }
      AppMethodBeat.o(278765);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements q.f
  {
    g(i parami) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(265108);
      Object localObject = i.n(this.zcQ);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramo.clear();
      localObject = this.zcQ;
      p.j(paramo, "menu");
      i.a((i)localObject, paramo);
      AppMethodBeat.o(265108);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class h
    implements e.b
  {
    h(i parami) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(286938);
      com.tencent.mm.live.c.b localb = i.p(this.zcQ);
      if (localb != null) {
        b.b.a(localb, com.tencent.mm.live.c.b.c.kAF);
      }
      i.o(this.zcQ);
      AppMethodBeat.o(286938);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigResponse;", "kotlin.jvm.PlatformType", "call"})
  public static final class i<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public i(i parami) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initView$5$1"})
  public static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public j(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class k
    implements Runnable
  {
    public k(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(223074);
      Rect localRect = new Rect();
      Object localObject = i.g(this.zcQ);
      if (localObject != null) {
        ((WeImageView)localObject).getHitRect(localRect);
      }
      localRect.inset(localRect.width() * -2, -localRect.width());
      localObject = i.g(this.zcQ);
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(223074);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, (View)i.g(this.zcQ)));
      AppMethodBeat.o(223074);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class l
    implements View.OnClickListener
  {
    public l(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291417);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      i.f(this.zcQ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291417);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "invoke"})
  public static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<i.d, x>
  {
    public m(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class n
    implements q.g
  {
    n(i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(224308);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == i.r(this.zcQ))
      {
        if (i.s(this.zcQ))
        {
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_more_action_ban_comment_done));
          i.t(this.zcQ);
        }
        for (;;)
        {
          paramMenuItem = i.n(this.zcQ);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bYF();
          AppMethodBeat.o(224308);
          return;
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_more_action_allow_comment_done));
          i.u(this.zcQ);
        }
        AppMethodBeat.o(224308);
        return;
      }
      if (paramInt == i.v(this.zcQ))
      {
        if (i.w(this.zcQ))
        {
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_more_action_ban_like_done));
          i.x(this.zcQ);
          paramMenuItem = i.p(this.zcQ);
          if ((paramMenuItem != null) && (paramMenuItem.getLiveRole() == 1))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.t(s.a.yEc.jWO, String.valueOf(s.ad.yHU.type));
          }
        }
        for (;;)
        {
          paramMenuItem = i.n(this.zcQ);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bYF();
          AppMethodBeat.o(224308);
          return;
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_more_action_allow_like_done));
          i.y(this.zcQ);
          paramMenuItem = i.p(this.zcQ);
          if ((paramMenuItem != null) && (paramMenuItem.getLiveRole() == 1))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.t(s.a.yEc.jWO, String.valueOf(s.ad.yHT.type));
          }
        }
        AppMethodBeat.o(224308);
        return;
      }
      if (paramInt == i.z(this.zcQ))
      {
        if (i.A(this.zcQ))
        {
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_link_mic_disable_tip));
          i.B(this.zcQ);
          paramMenuItem = i.p(this.zcQ);
          if ((paramMenuItem != null) && (paramMenuItem.getLiveRole() == 1))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDX.jWO, String.valueOf(s.af.yIm.action));
          }
        }
        for (;;)
        {
          paramMenuItem = i.n(this.zcQ);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bYF();
          AppMethodBeat.o(224308);
          return;
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_link_mic_enable_tip));
          i.C(this.zcQ);
          paramMenuItem = i.p(this.zcQ);
          if ((paramMenuItem != null) && (paramMenuItem.getLiveRole() == 1))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDX.jWO, String.valueOf(s.af.yIl.action));
          }
        }
        AppMethodBeat.o(224308);
        return;
      }
      if (paramInt == i.D(this.zcQ))
      {
        if (i.E(this.zcQ))
        {
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_gift_disable_tip));
          i.F(this.zcQ);
          paramMenuItem = i.p(this.zcQ);
          if ((paramMenuItem != null) && (paramMenuItem.getLiveRole() == 1))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDY.jWO, String.valueOf(s.y.yHB.action));
          }
        }
        for (;;)
        {
          paramMenuItem = i.n(this.zcQ);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bYF();
          AppMethodBeat.o(224308);
          return;
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_gift_enable_tip));
          i.G(this.zcQ);
          paramMenuItem = i.p(this.zcQ);
          if ((paramMenuItem != null) && (paramMenuItem.getLiveRole() == 1))
          {
            paramMenuItem = com.tencent.mm.plugin.finder.live.report.k.yBj;
            com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDY.jWO, String.valueOf(s.y.yHC.action));
          }
        }
        AppMethodBeat.o(224308);
        return;
      }
      if (paramInt == i.H(this.zcQ))
      {
        if (i.I(this.zcQ)) {
          i.a(this.zcQ, false);
        }
        for (;;)
        {
          paramMenuItem = i.n(this.zcQ);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bYF();
          AppMethodBeat.o(224308);
          return;
          i.a(this.zcQ, true);
        }
        AppMethodBeat.o(224308);
        return;
      }
      if (paramInt == i.J(this.zcQ))
      {
        if (i.K(this.zcQ))
        {
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_doc_cast_disable_tip));
          i.L(this.zcQ);
        }
        for (;;)
        {
          paramMenuItem = i.n(this.zcQ);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bYF();
          AppMethodBeat.o(224308);
          return;
          com.tencent.mm.ui.base.w.cR((Context)this.zcQ.getContext(), this.zcQ.getContext().getResources().getString(b.j.finder_live_doc_cast_enable_tip));
          i.M(this.zcQ);
        }
        AppMethodBeat.o(224308);
        return;
      }
      i.N(this.zcQ);
      AppMethodBeat.o(224308);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class o
    implements w.b
  {
    public static final o zcX;
    
    static
    {
      AppMethodBeat.i(284990);
      zcX = new o();
      AppMethodBeat.o(284990);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(284988);
      if (paramView != null) {
        paramView.findViewById(b.f.toast_text);
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(b.f.toast_img);
        if (paramView != null)
        {
          paramView.setImageResource(b.i.icons_filled_done);
          AppMethodBeat.o(284988);
          return;
        }
      }
      AppMethodBeat.o(284988);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$onNewIntent$1$2"})
  static final class p
    implements Runnable
  {
    p(i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(285328);
      an localan = i.d(this.zcQ);
      if (localan != null)
      {
        localan.dII();
        AppMethodBeat.o(285328);
        return;
      }
      AppMethodBeat.o(285328);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class q
    implements View.OnClickListener
  {
    q(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290982);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$refreshGroupVisibility$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = i.zcP;
      Log.i(i.access$getTAG$cp(), "visibilityGroup click");
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      Activity localActivity = this.zcQ.getContext();
      Intent localIntent = new Intent();
      paramView = a.d.BuY;
      String str = a.d.emY();
      paramView = i.m(this.zcQ);
      if (paramView != null)
      {
        paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        if (paramView != null)
        {
          paramView = paramView.ziQ;
          localObject = paramView;
          if (!(paramView instanceof Serializable)) {
            localObject = null;
          }
          localIntent.putExtra(str, (Serializable)localObject);
          paramView = a.d.BuY;
          str = a.d.emZ();
          paramView = i.m(this.zcQ);
          if (paramView == null) {
            break label475;
          }
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (paramView == null) {
            break label475;
          }
          paramView = paramView.ziR;
          label170:
          localObject = paramView;
          if (!(paramView instanceof Serializable)) {
            localObject = null;
          }
          localIntent.putExtra(str, (Serializable)localObject);
          paramView = a.d.BuY;
          localObject = a.d.enc();
          paramView = i.m(this.zcQ);
          if (paramView == null) {
            break label480;
          }
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramView == null) {
            break label480;
          }
          paramView = Integer.valueOf(paramView.yeJ);
          label235:
          localIntent.putExtra((String)localObject, (Serializable)paramView);
          paramView = a.d.BuY;
          localObject = a.d.ena();
          paramView = i.m(this.zcQ);
          if (paramView == null) {
            break label485;
          }
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (paramView == null) {
            break label485;
          }
          paramView = paramView.ziT;
          label285:
          localIntent.putStringArrayListExtra((String)localObject, paramView);
          paramView = a.d.BuY;
          localObject = a.d.enb();
          paramView = i.m(this.zcQ);
          if (paramView == null) {
            break label490;
          }
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (paramView == null) {
            break label490;
          }
          paramView = paramView.ziU;
          label332:
          localIntent.putStringArrayListExtra((String)localObject, paramView);
          paramView = a.d.BuY;
          localObject = a.d.emX();
          paramView = i.m(this.zcQ);
          if (paramView == null) {
            break label495;
          }
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (paramView == null) {
            break label495;
          }
          paramView = Integer.valueOf(paramView.ziS);
          label382:
          localIntent.putExtra((String)localObject, (Serializable)paramView);
          paramView = a.d.BuY;
          localObject = a.d.emW();
          paramView = i.m(this.zcQ);
          if (paramView == null) {
            break label500;
          }
          paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramView.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramView == null) {
            break label500;
          }
        }
      }
      label475:
      label480:
      label485:
      label490:
      label495:
      label500:
      for (paramView = Integer.valueOf(paramView.yeI);; paramView = null)
      {
        localIntent.putExtra((String)localObject, (Serializable)paramView);
        com.tencent.mm.plugin.finder.utils.a.e(localActivity, localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$refreshGroupVisibility$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(290982);
        return;
        paramView = null;
        break;
        paramView = null;
        break label170;
        paramView = null;
        break label235;
        paramView = null;
        break label285;
        paramView = null;
        break label332;
        paramView = null;
        break label382;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$startPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class r
    implements f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(279889);
      p.k(paramc, "task");
      p.k(paramj, "status");
      if ((paramj == com.tencent.mm.loader.g.j.kQd) && (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl)))
      {
        i locali = this.zcQ;
        String str1 = ((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl;
        String str2 = ((com.tencent.mm.plugin.finder.upload.m)paramc).AAI;
        paramj = i.q(this.zcQ);
        if (paramj != null)
        {
          localObject = paramj.zex;
          paramj = (com.tencent.mm.loader.g.j)localObject;
          if (localObject != null) {}
        }
        else
        {
          paramj = "";
        }
        paramc = ((com.tencent.mm.plugin.finder.upload.m)paramc).jYa;
        if (paramc != null) {}
        for (paramc = paramc.field_filemd5;; paramc = null)
        {
          locali.r(str1, str2, paramj, paramc);
          AppMethodBeat.o(279889);
          return;
        }
      }
      paramc = i.p(this.zcQ);
      if ((paramc != null) && (paramc.getLiveRole() == 1))
      {
        paramc = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.t(s.a.yDM.jWO, String.valueOf(s.bd.yKR.type));
        paramc = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.setErrorCode(com.tencent.mm.loader.g.j.kQe.ordinal());
        paramc = com.tencent.mm.plugin.finder.live.report.k.yBj;
        com.tencent.mm.plugin.finder.live.report.k.b(s.s.yGI);
      }
      paramc = aq.AIJ;
      paramc = aq.efJ();
      Object localObject = aq.AIJ;
      aq.efI();
      paramj = paramj.toString();
      i.m(this.zcQ);
      aq.hw(paramc, paramj);
      AppMethodBeat.o(279889);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class s
    implements f.c
  {
    public static final s zcY;
    
    static
    {
      AppMethodBeat.i(288694);
      zcY = new s();
      AppMethodBeat.o(288694);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$tryToPreloadMiniprogram$1$1"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    t(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$widgetListener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder_release"})
  public static final class u
    implements i.e
  {
    public final void onChange()
    {
      AppMethodBeat.i(283810);
      this.zcQ.dGi();
      i.O(this.zcQ);
      AppMethodBeat.o(283810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.i
 * JD-Core Version:    0.7.0.1
 */