package com.tencent.mm.plugin.finder.live.viewmodel;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.edit.FinderCoverEditPluginLayout;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI14;
import com.tencent.mm.plugin.finder.live.widget.d.d;
import com.tencent.mm.plugin.finder.live.widget.e.c;
import com.tencent.mm.plugin.finder.report.live.s.a;
import com.tencent.mm.plugin.finder.report.live.s.ap;
import com.tencent.mm.plugin.finder.report.live.s.l;
import com.tencent.mm.plugin.finder.report.live.s.m;
import com.tencent.mm.plugin.finder.report.live.s.o;
import com.tencent.mm.plugin.finder.report.live.s.t;
import com.tencent.mm.plugin.finder.report.live.s.y;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.r;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "SHEET_MORE_ACTION_COMMENT", "", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_SENSITIVE_WORD", "SHEET_MORE_ACTION_VISIBILITY_MODE", "STATE_BEAUTY", "STATE_DEFAULT", "STATE_FILTER", "beautyRootView", "Landroid/widget/RelativeLayout;", "getBeautyRootView", "()Landroid/widget/RelativeLayout;", "setBeautyRootView", "(Landroid/widget/RelativeLayout;)V", "beautyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "getBeautyWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;", "setBeautyWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptBeautyWidget;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "cameraOptPanel", "Landroid/support/v7/widget/RecyclerView;", "getCameraOptPanel", "()Landroid/support/v7/widget/RecyclerView;", "setCameraOptPanel", "(Landroid/support/v7/widget/RecyclerView;)V", "contentRoot", "Landroid/view/View;", "getContentRoot", "()Landroid/view/View;", "setContentRoot", "(Landroid/view/View;)V", "coverWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "getCoverWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;", "setCoverWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostCoverWidget;)V", "descWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "getDescWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;", "setDescWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostDescWidget;)V", "filterRootView", "getFilterRootView", "setFilterRootView", "filterWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "getFilterWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;", "setFilterWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget;)V", "licensePanelWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "getLicensePanelWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;", "setLicensePanelWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLicensePanelWidget;)V", "licenseWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "getLicenseWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;", "setLicenseWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLicenseWidget;)V", "liveCore", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "liveTagView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "getLiveTagView", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "setLiveTagView", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;)V", "locationWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "getLocationWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;", "setLocationWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePostLocationWidget;)V", "maskView", "getMaskView", "setMaskView", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "noticeLayout", "getNoticeLayout", "setNoticeLayout", "noticeTimeTxt", "Landroid/widget/TextView;", "getNoticeTimeTxt", "()Landroid/widget/TextView;", "setNoticeTimeTxt", "(Landroid/widget/TextView;)V", "onOptionClick", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "Lkotlin/ParameterName;", "name", "option", "", "onStartLive", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "getOnStartLive", "()Lkotlin/jvm/functions/Function1;", "setOnStartLive", "(Lkotlin/jvm/functions/Function1;)V", "optList", "Ljava/util/ArrayList;", "postBtn", "getPostBtn", "setPostBtn", "postBtnGroup", "getPostBtnGroup", "setPostBtnGroup", "postLayout", "getPostLayout", "setPostLayout", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "state", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "topBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTopBack", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTopBack", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "topContainer", "getTopContainer", "setTopContainer", "topMoreActionBtn", "getTopMoreActionBtn", "setTopMoreActionBtn", "visibilityTv", "getVisibilityTv", "setVisibilityTv", "widgetListener", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "getWidgetListener", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "setWidgetListener", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;)V", "adjustMargin", "beforeLive", "buildConfirmDialog", "checkIsReadyToPost", "", "checkNetwork", "checkState", "clickBeauty", "clickFilter", "clickMirror", "clickShop", "clickSwitch", "continuePost", "coverUrl", "", "thumbUrl", "path", "md5", "disableComment", "disableGift", "disableLinkMic", "enableComment", "enableGift", "enableLinkMic", "initPostLayout", "rootView", "isCommentEnable", "isGiftEnable", "isLinkMicEnable", "loadOptions", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyboardHeightChanged", "height", "show", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "refreshPostState", "setLiveNoticeInfo", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setupConfig", "showLinkConfirmDialog", "startPost", "needPrepare", "tryStartPost", "BeforeOptAdapter", "BeforeOptViewHolder", "Companion", "OptionInfo", "WidgetStatusCallback", "plugin-finder_release"})
public final class FinderLivePostUIC
  extends UIComponent
  implements View.OnClickListener, com.tencent.mm.ak.i
{
  public static final String TAG = "Finder.FinderLivePostUIC";
  public static final c uDb;
  private final int STATE_DEFAULT;
  public com.tencent.mm.live.core.core.a.b hOO;
  public com.tencent.mm.live.c.b hOp;
  private com.tencent.mm.ui.widget.a.e hOv;
  public g liveData;
  public View maskView;
  private int state;
  private final int uCA;
  private final int uCB;
  private final int uCC;
  public View uCD;
  public TextView uCE;
  public com.tencent.mm.plugin.finder.live.widget.k uCF;
  public com.tencent.mm.plugin.finder.live.widget.h uCG;
  public com.tencent.mm.plugin.finder.live.widget.j uCH;
  public com.tencent.mm.plugin.finder.live.widget.g uCI;
  public com.tencent.mm.plugin.finder.live.widget.i uCJ;
  public RelativeLayout uCK;
  public WeImageView uCL;
  public View uCM;
  public TextView uCN;
  public TextView uCO;
  public RecyclerView uCP;
  public View uCQ;
  public View uCR;
  public RelativeLayout uCS;
  public RelativeLayout uCT;
  public View uCU;
  public com.tencent.mm.plugin.finder.live.widget.n uCV;
  private ArrayList<FinderLivePostUIC.d> uCW;
  public kotlin.g.a.b<? super FinderLivePostUIC.d, x> uCX;
  public com.tencent.mm.plugin.finder.api.g uCY;
  public kotlin.g.a.b<? super FinderObjectDesc, x> uCZ;
  private final int uCy;
  private final int uCz;
  public e uDa;
  private final o.g uhx;
  public com.tencent.mm.plugin.finder.live.widget.e umJ;
  public com.tencent.mm.plugin.finder.live.widget.d umK;
  private final int usT;
  private final int usU;
  
  static
  {
    AppMethodBeat.i(247928);
    uDb = new c((byte)0);
    TAG = "Finder.FinderLivePostUIC";
    AppMethodBeat.o(247928);
  }
  
  public FinderLivePostUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(247927);
    this.uCy = 1;
    this.uCz = 2;
    this.usT = 1;
    this.usU = 3;
    this.uCB = 4;
    this.uCC = 5;
    this.uCW = new ArrayList();
    this.state = this.STATE_DEFAULT;
    this.uhx = ((o.g)new n(this));
    this.uDa = ((e)new t(this));
    AppMethodBeat.o(247927);
  }
  
  private final void diQ()
  {
    Object localObject2 = null;
    int j = 1;
    AppMethodBeat.i(247915);
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      new f.a((Context)getActivity()).hbu().bow(getActivity().getResources().getString(2131759962)).boA(getActivity().getResources().getString(2131755873)).b((f.c)s.uDk).show();
      AppMethodBeat.o(247915);
      return;
    }
    Object localObject1 = this.uCH;
    if (localObject1 == null) {
      p.btv("licenseWidget");
    }
    if (localObject1 != null) {}
    for (localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.widget.j)localObject1).isReady()); !((Boolean)localObject1).booleanValue(); localObject1 = null)
    {
      localObject1 = this.uCI;
      if (localObject1 == null) {
        p.btv("licensePanelWidget");
      }
      ((com.tencent.mm.plugin.finder.live.widget.g)localObject1).uGC.setVisibility(0);
      ((com.tencent.mm.plugin.finder.live.widget.g)localObject1).hRy.show();
      AppMethodBeat.o(247915);
      return;
    }
    localObject1 = this.uCV;
    if (localObject1 == null) {
      p.btv("liveTagView");
    }
    if (!((com.tencent.mm.plugin.finder.live.widget.n)localObject1).isReady())
    {
      localObject1 = this.uCV;
      if (localObject1 == null) {
        p.btv("liveTagView");
      }
      ((com.tencent.mm.plugin.finder.live.widget.n)localObject1).nF(true);
      AppMethodBeat.o(247915);
      return;
    }
    localObject1 = this.uCG;
    if (localObject1 == null) {
      p.btv("coverWidget");
    }
    boolean bool;
    label304:
    label344:
    label379:
    Object localObject3;
    if (localObject1 != null) {
      if ((!Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uEu)) || (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).kog)) || ((!Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uGF)) && (com.tencent.mm.vfs.s.YS(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uGF))))
      {
        bool = true;
        localObject1 = Boolean.valueOf(bool);
        if (!((Boolean)localObject1).booleanValue()) {
          break label714;
        }
        localObject1 = this.uCH;
        if (localObject1 == null) {
          p.btv("licenseWidget");
        }
        if (localObject1 == null) {
          break label708;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.finder.live.widget.j)localObject1).isReady());
        if (!((Boolean)localObject1).booleanValue()) {
          break label714;
        }
        localObject1 = this.uCV;
        if (localObject1 == null) {
          p.btv("liveTagView");
        }
        if (!((com.tencent.mm.plugin.finder.live.widget.n)localObject1).isReady()) {
          break label714;
        }
        i = 1;
        if (i == 0) {
          break label791;
        }
        localObject1 = this.uCQ;
        if (localObject1 == null) {
          p.btv("postBtnGroup");
        }
        ((View)localObject1).setEnabled(false);
        localObject3 = this.liveData;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((g)localObject3).uDO;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((h)localObject3).hwh;
          }
        }
        Util.isNullOrNil((String)localObject1);
        localObject1 = this.uCG;
        if (localObject1 == null) {
          p.btv("coverWidget");
        }
        if ((Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uGF)) || (!com.tencent.mm.vfs.s.YS(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uGF))) {
          break label719;
        }
      }
    }
    label708:
    label714:
    label719:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label724;
      }
      localObject1 = TAG;
      localObject2 = new StringBuilder("choose live cover:");
      localObject3 = this.uCG;
      if (localObject3 == null) {
        p.btv("coverWidget");
      }
      localObject2 = ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uGF).append(", ");
      localObject3 = this.uCG;
      if (localObject3 == null) {
        p.btv("coverWidget");
      }
      Log.i((String)localObject1, ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).kog);
      localObject1 = com.tencent.mm.plugin.finder.upload.g.vSJ;
      localObject1 = com.tencent.mm.plugin.finder.upload.g.dBa();
      localObject2 = this.uCG;
      if (localObject2 == null) {
        p.btv("coverWidget");
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.widget.h)localObject2).uGF;
      localObject3 = z.aUg();
      p.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
      com.tencent.mm.loader.g.f localf = (com.tencent.mm.loader.g.f)new r(this);
      p.h(localObject2, "path");
      p.h(localObject3, "userName");
      p.h(localf, "callback");
      ((com.tencent.mm.plugin.finder.upload.g)localObject1).vSB.a((com.tencent.mm.loader.g.c)new com.tencent.mm.plugin.finder.upload.m((String)localObject2, (String)localObject3), localf);
      AppMethodBeat.o(247915);
      return;
      bool = false;
      break;
      localObject1 = null;
      break label304;
      localObject1 = null;
      break label344;
      i = 0;
      break label379;
    }
    label724:
    localObject1 = this.uCG;
    if (localObject1 == null) {
      p.btv("coverWidget");
    }
    if (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uEu)) {}
    for (localObject1 = ((com.tencent.mm.plugin.finder.live.widget.h)localObject1).uEu;; localObject1 = ((com.tencent.mm.plugin.finder.live.widget.h)localObject1).kog)
    {
      n("", (String)localObject1, "", "");
      Log.i(TAG, "choose default cover:".concat(String.valueOf(localObject1)));
      label791:
      AppMethodBeat.o(247915);
      return;
    }
  }
  
  private final boolean diS()
  {
    AppMethodBeat.i(247918);
    com.tencent.mm.plugin.finder.api.g localg = this.uCY;
    if (localg != null) {}
    for (long l = localg.field_liveAnchorStatusFlag;; l = 0L)
    {
      boolean bool = com.tencent.mm.ac.d.cW((int)l, 64);
      AppMethodBeat.o(247918);
      return bool;
    }
  }
  
  private final boolean diT()
  {
    AppMethodBeat.i(247919);
    com.tencent.mm.plugin.finder.api.g localg = this.uCY;
    if (localg != null) {}
    for (long l = localg.field_liveAnchorStatusFlag; !com.tencent.mm.ac.d.cW((int)l, 8); l = 0L)
    {
      AppMethodBeat.o(247919);
      return true;
    }
    AppMethodBeat.o(247919);
    return false;
  }
  
  private final boolean diV()
  {
    AppMethodBeat.i(247920);
    com.tencent.mm.plugin.finder.api.g localg = this.uCY;
    if (localg != null) {}
    for (long l = localg.field_liveAnchorStatusFlag;; l = 0L)
    {
      boolean bool = com.tencent.mm.ac.d.cW((int)l, 128);
      AppMethodBeat.o(247920);
      return bool;
    }
  }
  
  private final void diX()
  {
    AppMethodBeat.i(247922);
    Log.i(TAG, "checkState state:" + this.state);
    if (this.state == this.STATE_DEFAULT)
    {
      localObject = this.uCR;
      if (localObject == null) {
        p.btv("contentRoot");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.uCK;
      if (localObject == null) {
        p.btv("topContainer");
      }
      ((RelativeLayout)localObject).setVisibility(0);
      AppMethodBeat.o(247922);
      return;
    }
    Object localObject = this.uCR;
    if (localObject == null) {
      p.btv("contentRoot");
    }
    ((View)localObject).setVisibility(4);
    localObject = this.uCK;
    if (localObject == null) {
      p.btv("topContainer");
    }
    ((RelativeLayout)localObject).setVisibility(4);
    AppMethodBeat.o(247922);
  }
  
  public final com.tencent.mm.live.c.b diO()
  {
    AppMethodBeat.i(247912);
    com.tencent.mm.live.c.b localb = this.hOp;
    if (localb == null) {
      p.btv("statusMonitor");
    }
    AppMethodBeat.o(247912);
    return localb;
  }
  
  public final WeImageView diP()
  {
    AppMethodBeat.i(247913);
    WeImageView localWeImageView = this.uCL;
    if (localWeImageView == null) {
      p.btv("topBack");
    }
    AppMethodBeat.o(247913);
    return localWeImageView;
  }
  
  public final void diR()
  {
    com.tencent.mm.plugin.finder.api.g localg = this.uCY;
    if (localg != null) {
      localg.field_liveAnchorStatusFlag = ((int)localg.field_liveAnchorStatusFlag & 0xFFFFFFBF);
    }
  }
  
  public final void diU()
  {
    com.tencent.mm.plugin.finder.api.g localg = this.uCY;
    if (localg != null) {
      localg.field_liveAnchorStatusFlag = ((int)localg.field_liveAnchorStatusFlag & 0xFFFFFF7F);
    }
  }
  
  public final void diW()
  {
    AppMethodBeat.i(247921);
    View localView = this.uCQ;
    if (localView == null) {
      p.btv("postBtnGroup");
    }
    localView.setEnabled(true);
    AppMethodBeat.o(247921);
  }
  
  public final void diY()
  {
    Object localObject2 = null;
    AppMethodBeat.i(247923);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("loadOptions bindShop:");
    Object localObject1 = this.liveData;
    label73:
    int i;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((g)localObject1).uit);
      localStringBuilder = localStringBuilder.append(localObject1).append(", exptFilterEnable:");
      localObject1 = this.liveData;
      if (localObject1 == null) {
        break label180;
      }
      localObject1 = Boolean.valueOf(((g)localObject1).uEW);
      localStringBuilder = localStringBuilder.append(localObject1).append(", exptBeautyEnable:");
      g localg = this.liveData;
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = Boolean.valueOf(localg.uEV);
      }
      Log.i(str, localObject1);
      i = 0;
      label125:
      if (i > 5) {
        break label286;
      }
      if (i != 4) {
        break label185;
      }
      localObject1 = this.liveData;
      if ((localObject1 != null) && (((g)localObject1).uit == true)) {
        this.uCW.add(new FinderLivePostUIC.d(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label125;
      localObject1 = null;
      break;
      label180:
      localObject1 = null;
      break label73;
      label185:
      if (i == 3)
      {
        localObject1 = this.liveData;
        if ((localObject1 != null) && (((g)localObject1).uEW == true)) {
          this.uCW.add(new FinderLivePostUIC.d(i));
        }
      }
      else if (i == 2)
      {
        localObject1 = this.liveData;
        if ((localObject1 != null) && (((g)localObject1).uEV == true)) {
          this.uCW.add(new FinderLivePostUIC.d(i));
        }
      }
      else
      {
        this.uCW.add(new FinderLivePostUIC.d(i));
      }
    }
    label286:
    AppMethodBeat.o(247923);
  }
  
  public final void n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l2 = 0L;
    Object localObject1 = null;
    AppMethodBeat.i(247924);
    p.h(paramString1, "coverUrl");
    p.h(paramString2, "thumbUrl");
    p.h(paramString3, "path");
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    Object localObject2 = this.uCJ;
    if (localObject2 == null) {
      p.btv("descWidget");
    }
    localFinderObjectDesc.description = ((com.tencent.mm.plugin.finder.live.widget.i)localObject2).uGP.getText().toString();
    localFinderObjectDesc.mediaType = 9;
    localObject2 = this.uCF;
    if (localObject2 == null) {
      p.btv("locationWidget");
    }
    localFinderObjectDesc.location = ((com.tencent.mm.plugin.finder.live.widget.k)localObject2).uHb.vUM;
    localFinderObjectDesc.extReading = new aqp();
    localObject2 = new FinderMedia();
    ((FinderMedia)localObject2).url = paramString1;
    ((FinderMedia)localObject2).mediaType = 9;
    ((FinderMedia)localObject2).thumbUrl = paramString2;
    ((FinderMedia)localObject2).videoDuration = 0;
    if (!Util.isNullOrNil(paramString3))
    {
      paramString1 = y.vXH;
      paramString1 = y.awm(paramString3);
      ((FinderMedia)localObject2).width = paramString1.x;
      ((FinderMedia)localObject2).height = paramString1.y;
      if (paramString4 != null) {
        break label646;
      }
    }
    label646:
    for (paramString1 = "";; paramString1 = paramString4)
    {
      ((FinderMedia)localObject2).md5sum = paramString1;
      ((FinderMedia)localObject2).coverUrl = "";
      localFinderObjectDesc.media.add(localObject2);
      paramString3 = TAG;
      paramString2 = new StringBuilder("desc coverUrl:");
      paramString1 = localFinderObjectDesc.media;
      p.g(paramString1, "objectDesc.media");
      paramString1 = (FinderMedia)paramString1.getFirst();
      if (paramString1 != null)
      {
        paramString1 = paramString1.coverUrl;
        label273:
        paramString2 = paramString2.append(paramString1).append(",thumbUrl:");
        paramString1 = localFinderObjectDesc.media;
        p.g(paramString1, "objectDesc.media");
        paramString1 = (FinderMedia)paramString1.getFirst();
        if (paramString1 == null) {
          break label623;
        }
        paramString1 = paramString1.thumbUrl;
        label315:
        paramString2 = paramString2.append(paramString1).append(",md5:").append(paramString4).append(", selfContact.anchorFlag:");
        paramString1 = this.uCY;
        if (paramString1 == null) {
          break label628;
        }
        paramString1 = Long.valueOf(paramString1.field_liveAnchorStatusFlag);
        label355:
        paramString2 = paramString2.append(paramString1).append(", selfContact.switchFlag:");
        paramString4 = this.uCY;
        paramString1 = localObject1;
        if (paramString4 != null) {
          paramString1 = Long.valueOf(paramString4.field_liveSwitchFlag);
        }
        paramString4 = paramString2.append(paramString1).append(", linkMic:").append(diS()).append(", gift:").append(diV()).append(", comment:").append(diT()).append(",location:");
        paramString2 = localFinderObjectDesc.location;
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        Log.i(paramString3, com.tencent.mm.ac.g.bN(paramString1));
        paramString1 = this.uCY;
        if (paramString1 != null)
        {
          paramString2 = com.tencent.mm.plugin.finder.api.c.tsp;
          c.a.c(paramString1);
          if (this.liveData != null)
          {
            paramString1 = this.uCY;
            if (paramString1 == null) {
              break label633;
            }
          }
        }
      }
      label623:
      label628:
      label633:
      for (long l1 = paramString1.field_liveAnchorStatusFlag;; l1 = 0L)
      {
        g.EP(l1);
        if (this.liveData != null)
        {
          paramString1 = this.uCY;
          l1 = l2;
          if (paramString1 != null) {
            l1 = paramString1.field_liveSwitchFlag;
          }
          g.EQ(l1);
        }
        paramString1 = this.uCH;
        if (paramString1 == null) {
          p.btv("licenseWidget");
        }
        if (paramString1 != null) {
          paramString1.djL();
        }
        paramString1 = this.uCZ;
        if (paramString1 == null) {
          break label639;
        }
        paramString1.invoke(localFinderObjectDesc);
        AppMethodBeat.o(247924);
        return;
        if (this.uCG == null) {
          p.btv("coverWidget");
        }
        paramString1 = com.tencent.mm.plugin.finder.live.widget.h.djK();
        break;
        paramString1 = null;
        break label273;
        paramString1 = null;
        break label315;
        paramString1 = null;
        break label355;
      }
      label639:
      AppMethodBeat.o(247924);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(247917);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(TAG, "onActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    Object localObject3 = this.uCG;
    if (localObject3 == null) {
      p.btv("coverWidget");
    }
    Object localObject1;
    Object localObject2;
    label370:
    int i;
    if (paramInt1 == ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uGG)
    {
      if (paramIntent == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.m.vol);
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmA.hlf, String.valueOf(s.l.vog.action));
        localObject1 = this.uCF;
        if (localObject1 == null) {
          p.btv("locationWidget");
        }
        if ((paramInt1 == ((com.tencent.mm.plugin.finder.live.widget.k)localObject1).uHa) && (paramIntent != null))
        {
          ((com.tencent.mm.plugin.finder.live.widget.k)localObject1).uHb.ar(paramIntent);
          ((com.tencent.mm.plugin.finder.live.widget.k)localObject1).uHb.dBu();
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("poiClassifyId", Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), ""));
          ((JSONObject)localObject1).put("longitude", Float.valueOf(paramIntent.getFloatExtra("get_lng", -1000.0F)));
          ((JSONObject)localObject1).put("latitude", Float.valueOf(paramIntent.getFloatExtra("get_lat", -85.0F)));
          ((JSONObject)localObject1).put("city", Util.nullAs(paramIntent.getStringExtra("get_city"), ""));
          ((JSONObject)localObject1).put("poiname", Util.nullAs(paramIntent.getStringExtra("get_poi_name"), ""));
          localObject2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
          com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmC.hlf, ((JSONObject)localObject1).toString());
        }
        localObject1 = this.uCV;
        if (localObject1 == null) {
          p.btv("liveTagView");
        }
        if ((paramInt2 == -1) && (paramInt1 == com.tencent.mm.plugin.finder.live.widget.n.uHx)) {
          ((com.tencent.mm.plugin.finder.live.widget.n)localObject1).djO();
        }
        if (paramInt2 != -1) {
          break label1838;
        }
        if (paramInt1 != 1001) {
          break label1797;
        }
        localObject3 = this.liveData;
        if (localObject3 != null)
        {
          if (paramIntent == null) {
            break label1743;
          }
          localObject1 = OccupyFinderUI14.ueB;
          localObject1 = paramIntent.getSerializableExtra(OccupyFinderUI14.deI());
          localObject2 = localObject1;
          if (!(localObject1 instanceof List)) {
            localObject2 = null;
          }
          ((g)localObject3).uEZ = ((List)localObject2);
        }
        if (paramIntent == null) {
          break label1749;
        }
        localObject1 = OccupyFinderUI14.ueB;
        paramInt1 = paramIntent.getIntExtra(OccupyFinderUI14.deG(), 0);
        label413:
        localObject1 = TAG;
        localObject2 = new StringBuilder("visibilityChooseByteArray size:");
        paramIntent = this.liveData;
        if (paramIntent == null) {
          break label1754;
        }
        paramIntent = paramIntent.uEZ;
        if (paramIntent == null) {
          break label1754;
        }
        paramIntent = Integer.valueOf(paramIntent.size());
        label458:
        Log.i((String)localObject1, paramIntent + ",anchorChooseMode:" + paramInt1);
        i = paramInt1;
        if (paramInt1 == 1)
        {
          paramIntent = this.liveData;
          if (paramIntent == null) {
            break label1759;
          }
          paramIntent = paramIntent.uEZ;
          if (paramIntent == null) {
            break label1759;
          }
          paramInt2 = paramIntent.size();
          label515:
          i = paramInt1;
          if (paramInt2 <= 0) {
            i = 0;
          }
        }
        paramIntent = this.liveData;
        if (paramIntent != null) {
          paramIntent.uFa = i;
        }
        paramIntent = com.tencent.mm.plugin.finder.utils.m.vVH;
        paramIntent = this.liveData;
        if (paramIntent == null) {
          break label1764;
        }
        paramInt1 = paramIntent.uFa;
        label558:
        paramIntent = com.tencent.mm.plugin.finder.utils.m.au(paramInt1, true);
        u.a((Context)getContext(), paramIntent, (u.b)o.uDj);
        paramIntent = this.liveData;
        if ((paramIntent == null) || (paramIntent.uFa != 1)) {
          break label1769;
        }
        paramIntent = MMApplicationContext.getContext();
        p.g(paramIntent, "MMApplicationContext.getContext()");
        paramIntent = paramIntent.getResources().getString(2131760117);
        p.g(paramIntent, "MMApplicationContext.get…e_more_action_visibility)");
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getResources().getString(2131760216);
        p.g(localObject1, "MMApplicationContext.get…ve_visibility_white_list)");
        localObject2 = this.uCN;
        if (localObject2 == null) {
          p.btv("visibilityTv");
        }
        localObject3 = MMApplicationContext.getContext();
        p.g(localObject3, "MMApplicationContext.getContext()");
        ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getResources().getString(2131760211, new Object[] { paramIntent, localObject1 }));
        paramIntent = this.uCN;
        if (paramIntent == null) {
          p.btv("visibilityTv");
        }
        paramIntent.setVisibility(0);
        AppMethodBeat.o(247917);
        return;
      }
      localObject1 = paramIntent.getData();
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject1).getPath();
        label768:
        localObject2 = paramIntent.getData();
        if (localObject2 == null) {
          break label904;
        }
        localObject2 = ((Uri)localObject2).getPath();
        label786:
        if (!Util.isNullOrNil((String)localObject2)) {
          break label1852;
        }
        localObject1 = (Context)((com.tencent.mm.plugin.finder.live.widget.h)localObject3).activity;
        localObject2 = al.waC;
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.s.h((Context)localObject1, paramIntent, al.dEA());
      }
    }
    label904:
    label1441:
    label1579:
    label1715:
    label1845:
    label1852:
    for (;;)
    {
      Log.i(((com.tencent.mm.plugin.finder.live.widget.h)localObject3).TAG, "filePath[" + (String)localObject1 + "] " + paramIntent);
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.m.vol);
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmA.hlf, String.valueOf(s.l.vog.action));
        break;
        localObject1 = null;
        break label768;
        localObject2 = null;
        break label786;
      }
      localObject2 = RecordConfigProvider.jA((String)localObject1, "");
      ((RecordConfigProvider)localObject2).scene = 11;
      Object localObject4 = new UICustomParam.a();
      ((UICustomParam.a)localObject4).apE();
      ((UICustomParam.a)localObject4).apD();
      ((UICustomParam.a)localObject4).dz(true);
      ((UICustomParam.a)localObject4).dy(true);
      ((UICustomParam.a)localObject4).apC();
      ((UICustomParam.a)localObject4).a(2131232578, 0, "", 0);
      ((RecordConfigProvider)localObject2).BOn = ((UICustomParam.a)localObject4).apG();
      CaptureDataManager.BOb.a((CaptureDataManager.b)localObject3);
      localObject4 = new Bundle();
      Object localObject5 = new ArrayList();
      ((ArrayList)localObject5).add(new GalleryItem.ImageMediaItem(0L, (String)localObject1, "", "image/fav"));
      ((Bundle)localObject4).putParcelableArrayList("media_list", (ArrayList)localObject5);
      localObject1 = ao.az((Context)((com.tencent.mm.plugin.finder.live.widget.h)localObject3).activity);
      localObject5 = y.vXH;
      localObject5 = ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).activity.getBaseContext();
      p.g(localObject5, "activity.baseContext");
      localObject1 = y.g((Context)localObject5, ((Point)localObject1).x, ((Point)localObject1).y);
      localObject1 = new Point(((Number)((r)localObject1).second).intValue(), ((Number)((r)localObject1).SWY).intValue());
      ((Bundle)localObject4).putInt("KEY_PREVIEW_WIDTH", ((Point)localObject1).x);
      ((Bundle)localObject4).putInt("KEY_PREVIEW_HEIGHT", ((Point)localObject1).y);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject4).putLong("video_max_duration", com.tencent.mm.plugin.finder.storage.c.drG() * 1000L);
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject4).putInt("image_max_height", com.tencent.mm.plugin.finder.storage.c.dqP());
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject4).putInt("image_max_width", com.tencent.mm.plugin.finder.storage.c.dqO());
      localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      ((Bundle)localObject4).putInt("image_compress_quality", com.tencent.mm.plugin.finder.storage.c.dqQ());
      localObject1 = al.waC;
      ((Bundle)localObject4).putString("output_dir", al.dEA());
      ((Bundle)localObject4).putBoolean("KEY_DISABLE_IMAGE_ADD_MUSIC", true);
      ((Bundle)localObject4).putBoolean("KEY_DISABLE_VIDEO_ENHANCEMENT", true);
      ((RecordConfigProvider)localObject2).jkf = ((Bundle)localObject4);
      ((RecordConfigProvider)localObject2).F(1, FinderCoverEditPluginLayout.class.getName());
      localObject1 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)((com.tencent.mm.plugin.finder.live.widget.h)localObject3).activity, ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uGH, 2130772161, -1, (RecordConfigProvider)localObject2, 1, 1);
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.m.vol);
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmA.hlf, String.valueOf(s.l.vog.action));
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject1 = ((Uri)localObject1).toString();
      p.g(localObject1, "dataFilePath.toString()");
      if (kotlin.n.n.J((String)localObject1, "file://", false)) {}
      for (localObject1 = s.m.vom;; localObject1 = s.m.von)
      {
        com.tencent.mm.plugin.finder.report.live.k.a((s.m)localObject1);
        break;
      }
      if (paramInt1 != ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uGH) {
        break;
      }
      if (paramIntent != null)
      {
        localObject1 = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        if (localObject1 == null) {
          break label1546;
        }
        localObject1 = ((CaptureDataManager.CaptureVideoNormalModel)localObject1).eJK();
        if (localObject1 == null) {
          break label1546;
        }
      }
      for (localObject2 = (String)((List)localObject1).get(0);; localObject2 = null)
      {
        if ((localObject2 != null) && (com.tencent.mm.vfs.s.YS((String)localObject2))) {
          break label1552;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(s.m.vol);
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmA.hlf, String.valueOf(s.l.vog.action));
        Log.e(((com.tencent.mm.plugin.finder.live.widget.h)localObject3).TAG, "ERROR! filePath=".concat(String.valueOf(localObject2)));
        break;
        localObject1 = null;
        break label1441;
      }
      localObject1 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(localObject1, "ConfigHelper.getInstance()");
      if (((com.tencent.mm.live.core.core.trtc.a.a)localObject1).aDG().hBp == 0)
      {
        i = 2;
        localObject1 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        if (com.tencent.mm.plugin.finder.report.live.k.dpk() != s.m.vom.type) {
          break label1729;
        }
        if (i != 1) {
          break label1715;
        }
        localObject1 = String.valueOf(s.l.voh.action);
      }
      for (;;)
      {
        localObject4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmA.hlf, (String)localObject1);
        localObject1 = y.vXH;
        y.b(((com.tencent.mm.plugin.finder.live.widget.h)localObject3).puw, (String)localObject2, Math.min(((com.tencent.mm.plugin.finder.live.widget.h)localObject3).puw.getWidth(), 500), Math.min(((com.tencent.mm.plugin.finder.live.widget.h)localObject3).puw.getHeight(), 500));
        ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uGF = ((String)localObject2);
        ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).kog = "";
        ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uEu = "";
        ((com.tencent.mm.plugin.finder.live.widget.h)localObject3).uGJ.onChange();
        break;
        i = 1;
        break label1579;
        localObject1 = String.valueOf(s.l.voi.action);
        continue;
        label1729:
        localObject1 = String.valueOf(s.l.voj.action);
      }
      label1743:
      localObject1 = null;
      break label370;
      label1749:
      paramInt1 = 0;
      break label413;
      label1754:
      paramIntent = null;
      break label458;
      label1759:
      paramInt2 = 0;
      break label515;
      label1764:
      paramInt1 = 0;
      break label558;
      label1769:
      paramIntent = this.uCN;
      if (paramIntent == null) {
        p.btv("visibilityTv");
      }
      paramIntent.setVisibility(8);
      AppMethodBeat.o(247917);
      return;
      localObject1 = com.tencent.mm.plugin.finder.live.widget.n.uHy;
      if (paramInt1 == com.tencent.mm.plugin.finder.live.widget.n.djP())
      {
        if (paramIntent == null) {
          break label1845;
        }
        if (paramIntent.getBooleanExtra("KEY_START_LIVE", false) == true)
        {
          Log.i(TAG, "onActivityResult startLive by selected tag result");
          diQ();
        }
      }
      AppMethodBeat.o(247917);
      return;
      AppMethodBeat.o(247917);
      return;
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(247926);
    Object localObject = this.uCI;
    if (localObject == null) {
      p.btv("licensePanelWidget");
    }
    if (((com.tencent.mm.plugin.finder.live.widget.g)localObject).uGC.getVisibility() == 0) {
      ((com.tencent.mm.plugin.finder.live.widget.g)localObject).hRy.hide();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(247926);
      return true;
    }
    i = this.state;
    if (i == this.uCy)
    {
      this.state = this.STATE_DEFAULT;
      localObject = this.umJ;
      if (localObject == null) {
        p.btv("filterWidget");
      }
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new e.c((com.tencent.mm.plugin.finder.live.widget.e)localObject, (kotlin.g.a.a)new p(this)));
      AppMethodBeat.o(247926);
      return true;
    }
    if (i == this.uCz)
    {
      this.state = this.STATE_DEFAULT;
      localObject = this.umK;
      if (localObject == null) {
        p.btv("beautyWidget");
      }
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new d.d((com.tencent.mm.plugin.finder.live.widget.d)localObject, (kotlin.g.a.a)new q(this)));
      AppMethodBeat.o(247926);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(247926);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(247925);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label91;
      }
      label55:
      if (paramView != null) {
        break label181;
      }
      label59:
      if (paramView != null) {
        break label210;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247925);
      return;
      paramView = null;
      break;
      label91:
      if (paramView.intValue() != 2131301243) {
        break label55;
      }
      paramView = this.hOp;
      if (paramView == null) {
        p.btv("statusMonitor");
      }
      if (paramView != null) {
        b.b.a(paramView, b.c.hLD);
      }
      paramView = this.hOp;
      if (paramView == null) {
        p.btv("statusMonitor");
      }
      if (paramView.getLiveRole() == 1)
      {
        paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmG.hlf, "");
        paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.a(com.tencent.mm.plugin.finder.report.live.k.dpj());
        continue;
        label181:
        if (paramView.intValue() != 2131301240) {
          break label59;
        }
        if (this.state != this.STATE_DEFAULT)
        {
          onBackPressed();
          continue;
          label210:
          if (paramView.intValue() == 2131301248)
          {
            if (this.hOv == null)
            {
              this.hOv = new com.tencent.mm.ui.widget.a.e((Context)getContext(), 0, true);
              paramView = this.hOv;
              if (paramView != null) {
                paramView.hbs();
              }
            }
            paramView = this.hOv;
            if (paramView != null) {
              paramView.hbr();
            }
            paramView = this.hOv;
            if (paramView != null) {
              paramView.Dp(false);
            }
            paramView = this.hOv;
            if (paramView != null) {
              paramView.a((o.f)new f(this));
            }
            paramView = this.hOv;
            if (paramView != null) {
              paramView.a(this.uhx);
            }
            paramView = this.hOv;
            if (paramView != null) {
              paramView.b((e.b)new g(this));
            }
            paramView = this.hOv;
            if (paramView != null) {
              paramView.dGm();
            }
          }
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(247914);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(5874, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(247914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(247916);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(5874, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(247916);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<FinderLivePostUIC.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(247892);
      int i = FinderLivePostUIC.a(this.uDc).size();
      AppMethodBeat.o(247892);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderLivePostUIC.a parama, int paramInt, FinderLivePostUIC.b paramb) {}
      
      public final void onClick(final View paramView)
      {
        AppMethodBeat.i(247890);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = (FinderLivePostUIC.d)kotlin.a.j.L((List)FinderLivePostUIC.a(this.uDd.uDc), this.gUj);
        float f;
        if (paramView != null)
        {
          if (paramView.key == 1)
          {
            localObject = FinderLivePostUIC.b(this.uDd.uDc);
            if (localObject == null) {
              break label239;
            }
            localObject = ((g)localObject).hIy;
            if (localObject == null) {
              break label239;
            }
            localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
            if ((localObject == null) || (((com.tencent.mm.live.core.core.b.d)localObject).hzh != true)) {
              break label239;
            }
            localObject = FinderLivePostUIC.b(this.uDd.uDc);
            if (localObject == null) {
              break label234;
            }
            localObject = ((g)localObject).hIy;
            if (localObject == null) {
              break label234;
            }
            localObject = ((com.tencent.mm.live.core.core.b.f)localObject).hzt;
            if ((localObject == null) || (((com.tencent.mm.live.core.core.b.d)localObject).hzk != true)) {
              break label234;
            }
            f = 180.0F;
            this.uDe.uDh.animate().rotationY(f).setListener((Animator.AnimatorListener)new a(this, paramView)).setDuration(200L).start();
          }
          localObject = FinderLivePostUIC.c(this.uDd.uDc);
          if (localObject != null) {
            ((kotlin.g.a.b)localObject).invoke(paramView);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247890);
          return;
          label234:
          f = 0.0F;
          break;
          label239:
          paramView = FinderLivePostUIC.uDb;
          Log.i(FinderLivePostUIC.access$getTAG$cp(), "clickMirror while using front camera, skip!");
          paramView = this.uDe.aus;
          p.g(paramView, "holder.itemView");
          paramView = paramView.getContext();
          localObject = this.uDe.aus;
          p.g(localObject, "holder.itemView");
          localObject = ((View)localObject).getContext();
          p.g(localObject, "holder.itemView.context");
          u.makeText(paramView, (CharSequence)((Context)localObject).getResources().getString(2131760090), 0).show();
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptAdapter$onBindViewHolder$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
      public static final class a
        extends AnimatorListenerAdapter
      {
        a(FinderLivePostUIC.a.a parama, FinderLivePostUIC.d paramd) {}
        
        public final void onAnimationEnd(Animator paramAnimator)
        {
          AppMethodBeat.i(247889);
          this.uDf.uDe.aus.invalidate();
          AppMethodBeat.o(247889);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$BeforeOptViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC;Landroid/view/View;)V", "optIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getOptIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "optTv", "Landroid/widget/TextView;", "getOptTv", "()Landroid/widget/TextView;", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    final WeImageView uDh;
    final TextView uDi;
    
    public b()
    {
      super();
      AppMethodBeat.i(247894);
      this.uDh = ((WeImageView)localObject.findViewById(2131300933));
      this.uDi = ((TextView)localObject.findViewById(2131300934));
      AppMethodBeat.o(247894);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "", "onChange", "", "plugin-finder_release"})
  public static abstract interface e
  {
    public abstract void onChange();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    f(FinderLivePostUIC paramFinderLivePostUIC) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(247896);
      Object localObject = FinderLivePostUIC.j(this.uDc);
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramm.clear();
      localObject = this.uDc;
      p.g(paramm, "menu");
      FinderLivePostUIC.a((FinderLivePostUIC)localObject, paramm);
      AppMethodBeat.o(247896);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    g(FinderLivePostUIC paramFinderLivePostUIC) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(247897);
      b.b.a(this.uDc.diO(), b.c.hNo);
      FinderLivePostUIC.k(this.uDc);
      AppMethodBeat.o(247897);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public h(FinderLivePostUIC paramFinderLivePostUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class i
    implements Runnable
  {
    public i(FinderLivePostUIC paramFinderLivePostUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(247899);
      Object localObject = new Rect();
      this.uDc.diP().getHitRect((Rect)localObject);
      ((Rect)localObject).inset(((Rect)localObject).width() * -2, -((Rect)localObject).width());
      ViewParent localViewParent = this.uDc.diP().getParent();
      if (localViewParent == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(247899);
        throw ((Throwable)localObject);
      }
      ((View)localViewParent).setTouchDelegate(new TouchDelegate((Rect)localObject, (View)this.uDc.diP()));
      AppMethodBeat.o(247899);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public j(FinderLivePostUIC paramFinderLivePostUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public k(FinderLivePostUIC paramFinderLivePostUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class l
    implements View.OnClickListener
  {
    public l(FinderLivePostUIC paramFinderLivePostUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247902);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initPostLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderLivePostUIC.d(this.uDc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$initPostLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247902);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$OptionInfo;", "invoke"})
  public static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<FinderLivePostUIC.d, x>
  {
    public m(FinderLivePostUIC paramFinderLivePostUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class n
    implements o.g
  {
    n(FinderLivePostUIC paramFinderLivePostUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(247904);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderLivePostUIC.m(this.uDc))
      {
        if (FinderLivePostUIC.n(this.uDc))
        {
          u.cG((Context)this.uDc.getContext(), this.uDc.getContext().getResources().getString(2131760094));
          FinderLivePostUIC.o(this.uDc);
        }
        for (;;)
        {
          paramMenuItem = FinderLivePostUIC.j(this.uDc);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bMo();
          AppMethodBeat.o(247904);
          return;
          u.cG((Context)this.uDc.getContext(), this.uDc.getContext().getResources().getString(2131760092));
          FinderLivePostUIC.p(this.uDc);
        }
        AppMethodBeat.o(247904);
        return;
      }
      if (paramInt == FinderLivePostUIC.q(this.uDc))
      {
        if (FinderLivePostUIC.r(this.uDc))
        {
          u.cG((Context)this.uDc.getContext(), this.uDc.getContext().getResources().getString(2131759984));
          FinderLivePostUIC.s(this.uDc);
          if (this.uDc.diO().getLiveRole() == 1)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmI.hlf, String.valueOf(s.y.vpD.action));
          }
        }
        for (;;)
        {
          paramMenuItem = FinderLivePostUIC.j(this.uDc);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bMo();
          AppMethodBeat.o(247904);
          return;
          u.cG((Context)this.uDc.getContext(), this.uDc.getContext().getResources().getString(2131759986));
          FinderLivePostUIC.t(this.uDc);
          if (this.uDc.diO().getLiveRole() == 1)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmI.hlf, String.valueOf(s.y.vpC.action));
          }
        }
        AppMethodBeat.o(247904);
        return;
      }
      if (paramInt == FinderLivePostUIC.u(this.uDc))
      {
        if (FinderLivePostUIC.v(this.uDc))
        {
          u.cG((Context)this.uDc.getContext(), this.uDc.getContext().getResources().getString(2131759941));
          FinderLivePostUIC.w(this.uDc);
          if (this.uDc.diO().getLiveRole() == 1)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmJ.hlf, String.valueOf(s.t.vph.action));
          }
        }
        for (;;)
        {
          paramMenuItem = FinderLivePostUIC.j(this.uDc);
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.bMo();
          AppMethodBeat.o(247904);
          return;
          u.cG((Context)this.uDc.getContext(), this.uDc.getContext().getResources().getString(2131759943));
          FinderLivePostUIC.x(this.uDc);
          if (this.uDc.diO().getLiveRole() == 1)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmJ.hlf, String.valueOf(s.t.vpi.action));
          }
        }
        AppMethodBeat.o(247904);
        return;
      }
      Activity localActivity;
      Intent localIntent;
      Object localObject;
      if ((paramInt != FinderLivePostUIC.y(this.uDc)) && (paramInt == FinderLivePostUIC.z(this.uDc)))
      {
        paramMenuItem = FinderLivePostUIC.j(this.uDc);
        if (paramMenuItem != null) {
          paramMenuItem.bMo();
        }
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
        localActivity = this.uDc.getContext();
        localIntent = new Intent();
        paramMenuItem = OccupyFinderUI14.ueB;
        String str = OccupyFinderUI14.deH();
        paramMenuItem = FinderLivePostUIC.b(this.uDc);
        if (paramMenuItem == null) {
          break label746;
        }
        paramMenuItem = paramMenuItem.uEY;
        localObject = paramMenuItem;
        if (!(paramMenuItem instanceof Serializable)) {
          localObject = null;
        }
        localIntent.putExtra(str, (Serializable)localObject);
        paramMenuItem = OccupyFinderUI14.ueB;
        str = OccupyFinderUI14.deI();
        paramMenuItem = FinderLivePostUIC.b(this.uDc);
        if (paramMenuItem == null) {
          break label751;
        }
        paramMenuItem = paramMenuItem.uEZ;
        label671:
        localObject = paramMenuItem;
        if (!(paramMenuItem instanceof Serializable)) {
          localObject = null;
        }
        localIntent.putExtra(str, (Serializable)localObject);
        paramMenuItem = OccupyFinderUI14.ueB;
        localObject = OccupyFinderUI14.deG();
        paramMenuItem = FinderLivePostUIC.b(this.uDc);
        if (paramMenuItem == null) {
          break label756;
        }
      }
      label746:
      label751:
      label756:
      for (paramMenuItem = Integer.valueOf(paramMenuItem.uFa);; paramMenuItem = null)
      {
        localIntent.putExtra((String)localObject, (Serializable)paramMenuItem);
        com.tencent.mm.plugin.finder.utils.a.e(localActivity, localIntent);
        AppMethodBeat.o(247904);
        return;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label671;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class o
    implements u.b
  {
    public static final o uDj;
    
    static
    {
      AppMethodBeat.i(247906);
      uDj = new o();
      AppMethodBeat.o(247906);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(247905);
      if (paramView != null) {
        paramView.findViewById(2131309260);
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(2131309259);
        if (paramView != null)
        {
          paramView.setImageResource(2131690537);
          AppMethodBeat.o(247905);
          return;
        }
      }
      AppMethodBeat.o(247905);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    p(FinderLivePostUIC paramFinderLivePostUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    q(FinderLivePostUIC paramFinderLivePostUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$startPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class r
    implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(247909);
      p.h(paramc, "task");
      p.h(paramj, "status");
      if ((paramj == com.tencent.mm.loader.g.j.ibw) && (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl)))
      {
        paramj = this.uDc;
        localObject1 = ((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl;
        String str = ((com.tencent.mm.plugin.finder.upload.m)paramc).vTf;
        Object localObject2 = this.uDc.uCG;
        if (localObject2 == null) {
          p.btv("coverWidget");
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.widget.h)localObject2).uGF;
        paramc = ((com.tencent.mm.plugin.finder.upload.m)paramc).hmq;
        if (paramc != null) {}
        for (paramc = paramc.field_filemd5;; paramc = null)
        {
          paramj.n((String)localObject1, str, (String)localObject2, paramc);
          AppMethodBeat.o(247909);
          return;
        }
      }
      if (this.uDc.diO().getLiveRole() == 1)
      {
        paramc = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.q(s.a.vmx.hlf, String.valueOf(s.ap.vrb.type));
        paramc = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.setErrorCode(com.tencent.mm.loader.g.j.ibx.ordinal());
        paramc = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(s.o.vov);
      }
      paramc = ae.vZW;
      paramc = ae.dEa();
      Object localObject1 = ae.vZW;
      ae.a(paramc, ae.dDZ(), 0, paramj.toString(), FinderLivePostUIC.b(this.uDc));
      AppMethodBeat.o(247909);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class s
    implements f.c
  {
    public static final s uDk;
    
    static
    {
      AppMethodBeat.i(247910);
      uDk = new s();
      AppMethodBeat.o(247910);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$widgetListener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder_release"})
  public static final class t
    implements FinderLivePostUIC.e
  {
    public final void onChange()
    {
      AppMethodBeat.i(247911);
      this.uDc.diW();
      AppMethodBeat.o(247911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC
 * JD-Core Version:    0.7.0.1
 */