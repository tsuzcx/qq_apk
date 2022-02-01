package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.iw;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveBaseUI;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveTaskBannerView;
import com.tencent.mm.plugin.finder.live.widget.af;
import com.tencent.mm.plugin.finder.live.widget.ag;
import com.tencent.mm.plugin.finder.utils.FinderGameEventListener;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.ba;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.finder.utils.bc;
import com.tencent.mm.plugin.finder.utils.bh;
import com.tencent.mm.plugin.finder.utils.bh.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.protocal.protobuf.gfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "appid", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "coverWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;", "getCoverWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;", "setCoverWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;)V", "developerCustomParam", "getDeveloperCustomParam", "setDeveloperCustomParam", "gameAppInfo", "Lcom/tencent/mm/protocal/protobuf/GameAppInfo;", "getGameAppInfo", "()Lcom/tencent/mm/protocal/protobuf/GameAppInfo;", "setGameAppInfo", "(Lcom/tencent/mm/protocal/protobuf/GameAppInfo;)V", "gameTeamWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;", "getGameTeamWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;", "setGameTeamWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;)V", "gameUserInfo", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "getGameUserInfo", "()Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "setGameUserInfo", "(Lcom/tencent/mm/protocal/protobuf/GameUserInfo;)V", "isFromWeApp", "", "()Z", "setFromWeApp", "(Z)V", "licensePanelWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameLicensePanelWidget;", "getLicensePanelWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameLicensePanelWidget;", "setLicensePanelWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameLicensePanelWidget;)V", "licenseWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;", "getLicenseWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;", "setLicenseWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;)V", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "miniGameScene", "", "getMiniGameScene", "()I", "setMiniGameScene", "(I)V", "postBtn", "Landroid/view/View;", "getPostBtn", "()Landroid/view/View;", "setPostBtn", "(Landroid/view/View;)V", "postEventWhenResume", "getPostEventWhenResume", "setPostEventWhenResume", "replaceCoverIv", "getReplaceCoverIv", "setReplaceCoverIv", "reportInfo", "getReportInfo", "setReportInfo", "root", "getRoot", "setRoot", "scene", "getScene", "setScene", "stickerWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostStickerWidget;", "getStickerWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostStickerWidget;", "setStickerWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostStickerWidget;)V", "taskBannerView", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "getTaskBannerView", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;", "setTaskBannerView", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTaskBannerView;)V", "taskWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostTaskWidget;", "getTaskWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostTaskWidget;", "setTaskWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostTaskWidget;)V", "ticket", "getTicket", "setTicket", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "versionType", "getVersionType", "setVersionType", "checkGameTeamUI", "", "checkProtocol", "configCoverUrlAndAppInfo", "continuePost", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getLayoutId", "gotoFaceVerify", "verifyUrl", "handleError", "errCode", "handleStartMiniGameLiveFail", "errType", "errMsg", "extInfo", "Landroid/os/Bundle;", "initData", "initView", "isMiniGameLive", "jumpFinish", "succ", "title", "desc", "jumpGame", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "onCreateAfter", "onGetUserGameConfigFail", "onPause", "onResume", "refreshGameInfo", "refreshSticker", "refreshView", "startMiniGameLive", "startPost", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  public static final e.a DXB;
  private static final int DXR;
  private bh Bpq;
  public FinderLiveTaskBannerView DXC;
  public View DXD;
  public View DXE;
  public com.tencent.mm.plugin.finder.live.widget.b DXF;
  public com.tencent.mm.plugin.finder.live.widget.d DXG;
  public ag DXH;
  public af DXI;
  com.tencent.mm.plugin.finder.live.widget.ah DXJ;
  private com.tencent.mm.plugin.finder.live.widget.c DXK;
  private ccb DXL;
  cbb DXM;
  boolean DXN;
  private int DXO;
  private String DXP;
  boolean DXQ;
  private final String TAG;
  String appid;
  public ImageView coverIv;
  private String coverUrl;
  int euz;
  private String hFb;
  public View lBX;
  private String mxQ;
  private int scene;
  public TextView titleTv;
  
  static
  {
    AppMethodBeat.i(356504);
    DXB = new e.a((byte)0);
    DXR = 10000;
    AppMethodBeat.o(356504);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356223);
    this.TAG = "Finder.FinderGameLivePostUIC";
    this.coverUrl = "";
    this.hFb = "";
    this.appid = "";
    this.DXP = "";
    this.mxQ = "";
    AppMethodBeat.o(356223);
  }
  
  private static final kotlin.ah a(e parame, b.a parama)
  {
    Object localObject1 = null;
    AppMethodBeat.i(356370);
    kotlin.g.b.s.u(parame, "this$0");
    Object localObject3;
    Object localObject2;
    label97:
    label116:
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = ((bil)parama.ott).ZRA;
      kotlin.g.b.s.s(parama, "it.resp.game_user_info_list");
      localObject3 = ((Iterable)parama).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label224;
      }
      localObject2 = ((Iterator)localObject3).next();
      ccb localccb = (ccb)localObject2;
      parama = localccb.aals;
      if (parama == null)
      {
        parama = null;
        if (Util.isNullOrNil(parama)) {
          break label219;
        }
        parama = localccb.aals;
        if (parama != null) {
          break label211;
        }
        parama = null;
        if (!kotlin.g.b.s.p(parama, parame.appid)) {
          break label219;
        }
        i = 1;
        label129:
        if (i == 0) {
          break label222;
        }
        parama = (b.a)localObject2;
        label136:
        localObject3 = (ccb)parama;
        if (localObject3 != null) {
          break label229;
        }
        Log.i(parame.TAG, "no game match");
      }
    }
    else
    {
      Log.i(parame.TAG, "CgiFinderLiveGetUserGameConfig error");
      aa.makeText((Context)parame.getContext(), (CharSequence)parame.getString(p.h.finder_live_game_prepare_error), 0).show();
    }
    label211:
    label219:
    label222:
    label224:
    label229:
    label252:
    do
    {
      parame = kotlin.ah.aiuX;
      AppMethodBeat.o(356370);
      return parame;
      parama = parama.app_id;
      break label97;
      parama = parama.app_id;
      break label116;
      i = 0;
      break label129;
      break;
      parama = null;
      break label136;
      parame.DXM = ((ccb)localObject3).aals;
      parama = ((ccb)localObject3).aalt;
      if (parama != null) {
        break label398;
      }
      parama = "";
      parame.coverUrl = parama;
      parame.ewV().b((ccb)localObject3);
      parame.ewY();
      parame.ewU().setCover(parame.coverUrl);
      localObject3 = parame.getTitleTv();
      parama = parame.DXM;
      if (parama != null) {
        break label419;
      }
      parama = "";
      ((TextView)localObject3).setText((CharSequence)parama);
      parame.ewW().bF(parame.appid, parame.exb());
      parame.ewW().eAQ();
      parame.ewX().sC(parame.exb());
      parame.ewZ();
      localObject2 = parame.DXK;
    } while (localObject2 == null);
    label300:
    parama = parame.DXM;
    if (parama == null)
    {
      parama = localObject1;
      label369:
      parame = parame.DXM;
      if ((parame == null) || (parame.ZXv != true)) {
        break label448;
      }
    }
    label398:
    label419:
    label448:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.finder.live.widget.c)localObject2).bD(parama, bool);
      break;
      localObject2 = parama.aabN;
      parama = (b.a)localObject2;
      if (localObject2 != null) {
        break label252;
      }
      parama = "";
      break label252;
      localObject2 = parama.xlJ;
      parama = (b.a)localObject2;
      if (localObject2 != null) {
        break label300;
      }
      parama = "";
      break label300;
      parama = parama.aakm;
      break label369;
    }
  }
  
  private static final void a(e parame, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356415);
    kotlin.g.b.s.u(parame, "this$0");
    Log.i(parame.TAG, "dialog cancel");
    paramDialogInterface.dismiss();
    AppMethodBeat.o(356415);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(356385);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    parame.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(356385);
  }
  
  private static final void a(e parame, ah.a parama, cbb paramcbb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356406);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(parama, "$isInstalled");
    paramDialogInterface.dismiss();
    Log.i(parame.TAG, kotlin.g.b.s.X("dialog ok isInstall:", Boolean.valueOf(parama.aiwY)));
    parama = com.tencent.mm.plugin.finder.utils.t.GgN;
    paramDialogInterface = (Context)parame.getContext();
    parama = paramcbb.lwO;
    parame = parama;
    if (parama == null) {
      parame = "";
    }
    com.tencent.mm.plugin.finder.utils.t.aL(paramDialogInterface, parame);
    parame = com.tencent.mm.plugin.finder.utils.s.GgL;
    if (com.tencent.mm.plugin.finder.utils.s.feR() == 18L)
    {
      parame = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.TU(8);
    }
    AppMethodBeat.o(356406);
  }
  
  private final void a(FinderMedia paramFinderMedia)
  {
    Object localObject3 = null;
    int i = -1;
    int k = 0;
    AppMethodBeat.i(356316);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.s.GgL;
    if (com.tencent.mm.plugin.finder.utils.s.feR() == 18L)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.s.GgL;
      localObject1 = new com.tencent.mm.ad.i();
      ((com.tencent.mm.ad.i)localObject1).au("type", 4);
      localObject2 = this.DXJ;
      if (localObject2 != null) {
        break label168;
      }
      localObject2 = this.DXJ;
      if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.widget.ah)localObject2).EqN != 7)) {
        break label189;
      }
    }
    label168:
    label189:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (i > 0)) {
        ((com.tencent.mm.ad.i)localObject1).au("money", i);
      }
      localObject2 = kotlin.ah.aiuX;
      localObject1 = ((com.tencent.mm.ad.i)localObject1).toString();
      kotlin.g.b.s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
      com.tencent.mm.plugin.finder.utils.s.aBx((String)localObject1);
      if (paramFinderMedia != null) {
        break label194;
      }
      aa.makeText((Context)getContext(), p.h.Ckz, 0).show();
      Log.i(this.TAG, "continuePost: media is null!");
      AppMethodBeat.o(356316);
      return;
      localObject2 = ((com.tencent.mm.plugin.finder.live.widget.ah)localObject2).eAV();
      if (localObject2 == null) {
        break;
      }
      i = ((cca)localObject2).aalq;
      break;
    }
    label194:
    ewW().eAR();
    if (exb())
    {
      b(paramFinderMedia);
      AppMethodBeat.o(356316);
      return;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    String str1 = ((d)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(d.class)).ewQ().getText().toString();
    String str2 = this.hFb;
    String str3 = this.appid;
    j = this.scene;
    localObject1 = this.DXJ;
    if (localObject1 == null)
    {
      i = k;
      localObject1 = this.DXJ;
      if (localObject1 != null) {
        break label440;
      }
      localObject1 = null;
      label300:
      localObject2 = aj.CGT;
      com.tencent.mm.plugin.finder.live.model.context.a locala = aj.elr();
      localObject2 = locala;
      if (locala == null) {
        localObject2 = new com.tencent.mm.plugin.finder.live.model.context.a();
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdT;
      if (localObject2 != null) {
        break label450;
      }
    }
    label440:
    label450:
    for (Object localObject2 = localObject3;; localObject2 = (bmw)kotlin.a.p.oL((List)localObject2))
    {
      new com.tencent.mm.plugin.finder.cgi.i(paramFinderMedia, str1, str2, str3, j, i, (cca)localObject1, (bmw)localObject2).e((Context)getActivity(), getResources().getString(p.h.finder_waiting), 500L).bFJ().a((com.tencent.mm.vending.e.b)getActivity()).g(new e..ExternalSyntheticLambda6(this));
      AppMethodBeat.o(356316);
      return;
      i = ((com.tencent.mm.plugin.finder.live.widget.ah)localObject1).EqN;
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.widget.ah)localObject1).eAV();
      break label300;
    }
  }
  
  private static final kotlin.ah b(e parame, final b.a parama)
  {
    int j = 0;
    AppMethodBeat.i(356428);
    kotlin.g.b.s.u(parame, "this$0");
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      if (parame.scene != 1)
      {
        avw localavw = (avw)parama.ott;
        i = j;
        if (localavw != null)
        {
          i = j;
          if (localavw.ZGg == 1) {
            i = 1;
          }
        }
        if (i == 0) {}
      }
      else
      {
        i = p.h.Cus;
        parama = parame.getResources().getString(p.h.Cur);
        kotlin.g.b.s.s(parama, "resources.getString(R.st…livesuccess_pagesubtitle)");
        parame.b(true, i, parama);
        parame = kotlin.ah.aiuX;
        AppMethodBeat.o(356428);
        return parame;
      }
      parama = (avw)parama.ott;
      if (parama == null) {
        parama = "";
      }
      for (;;)
      {
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new c(parame, parama));
        break;
        parama = parama.ZGf;
        if (parama == null) {
          parama = "";
        }
      }
    }
    switch (parama.errCode)
    {
    default: 
    case -200057: 
      for (i = 0; i == 0; i = 1)
      {
        aa.makeText((Context)parame.getContext(), p.h.finder_live_game_prepare_error, 0).show();
        break;
        com.tencent.mm.ui.base.k.b((Context)parame.getContext(), parame.getContext().getString(p.h.Cuq), "", parame.getContext().getString(p.h.app_ok), "", e..ExternalSyntheticLambda3.INSTANCE, e..ExternalSyntheticLambda2.INSTANCE);
      }
    }
    if (parame.exb()) {}
    for (parama = parame.getResources().getString(p.h.Cuu, new Object[] { Integer.valueOf(p.h.Cuv) });; parama = parame.getResources().getString(p.h.Cuu, new Object[] { Integer.valueOf(p.h.Cut) }))
    {
      kotlin.g.b.s.s(parama, "if (isMiniGameLive()) {\n…icense)\n                }");
      parame.b(false, p.h.Cuh, parama);
      i = 1;
      break;
    }
  }
  
  private static final void b(e parame, View paramView)
  {
    AppMethodBeat.i(356397);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    if (parame.exb())
    {
      paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
      com.tencent.mm.plugin.finder.utils.s.bG(9, parame.appid);
    }
    for (;;)
    {
      parame.exa();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(356397);
      return;
      paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
      if (com.tencent.mm.plugin.finder.utils.s.feR() == 18L)
      {
        paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
        com.tencent.mm.plugin.finder.utils.s.TU(5);
      }
      paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
      if (com.tencent.mm.plugin.finder.utils.s.feR() == 19L)
      {
        paramView = com.tencent.mm.plugin.finder.utils.s.GgL;
        com.tencent.mm.plugin.finder.utils.s.TU(2);
      }
    }
  }
  
  private final void b(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(356348);
    Log.i(this.TAG, "startMiniGameLive: appid = " + this.appid + ", version_type = " + this.euz);
    if (this.Bpq == null)
    {
      localObject1 = bh.GlM;
      this.Bpq = bh.a.a((Context)getActivity(), getActivity().getResources().getString(p.h.finder_waiting), 0L, 12);
    }
    Object localObject1 = this.Bpq;
    if (localObject1 != null) {
      ((bh)localObject1).begin();
    }
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localFinderObjectDesc.description = ((d)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(d.class)).ewQ().getText().toString();
    localFinderObjectDesc.mediaType = 9;
    localFinderObjectDesc.extReading = new axa();
    localObject1 = new bgk();
    ((bgk)localObject1).EcY = paramFinderMedia.coverUrl;
    Object localObject2 = kotlin.ah.aiuX;
    localFinderObjectDesc.liveDesc = ((bgk)localObject1);
    localFinderObjectDesc.media.add(paramFinderMedia);
    paramFinderMedia = ba.Gjt;
    localObject1 = bb.GjM;
    ba.a(paramFinderMedia, bb.fhs().name, null, true, false, 10);
    paramFinderMedia = ba.Gjt;
    localObject1 = bb.GjM;
    ba.a(paramFinderMedia, bb.fht().name, null, false, false, 14);
    paramFinderMedia = bc.GkH;
    bc.qP(cn.bDu());
    localObject2 = aj.CGT;
    localObject1 = aj.elr();
    paramFinderMedia = (FinderMedia)localObject1;
    if (localObject1 == null) {
      paramFinderMedia = new com.tencent.mm.plugin.finder.live.model.context.a();
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet = true;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeu = this.appid;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eev = this.euz;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DXO = this.DXO;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ayn(this.DXP);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ayo(this.mxQ);
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).desc = localFinderObjectDesc.description;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).EeY = localFinderObjectDesc;
    localObject1 = kotlin.ah.aiuX;
    aj.a((aj)localObject2, paramFinderMedia, null, 1, null, 10);
    paramFinderMedia = getActivity();
    if ((paramFinderMedia instanceof FinderGameLiveBaseUI))
    {
      paramFinderMedia = (FinderGameLiveBaseUI)paramFinderMedia;
      if (paramFinderMedia != null)
      {
        paramFinderMedia = paramFinderMedia.eeY();
        if (paramFinderMedia != null) {
          paramFinderMedia.dead();
        }
      }
      paramFinderMedia = new iw();
      paramFinderMedia.hKx.hKy = true;
      paramFinderMedia.hKx.hKz = true;
      paramFinderMedia.publish();
      paramFinderMedia = getActivity();
      if (!(paramFinderMedia instanceof FinderGameLiveBaseUI)) {
        break label592;
      }
    }
    label592:
    for (paramFinderMedia = (FinderGameLiveBaseUI)paramFinderMedia;; paramFinderMedia = null)
    {
      if (paramFinderMedia != null)
      {
        paramFinderMedia = paramFinderMedia.eeY();
        if (paramFinderMedia != null) {
          paramFinderMedia.alive();
        }
      }
      paramFinderMedia = aj.CGT;
      paramFinderMedia = aj.elr();
      if (paramFinderMedia != null)
      {
        localObject1 = aj.CGT;
        aj.a(paramFinderMedia, true, b.c.ndi, null, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      }
      paramFinderMedia = aj.CGT;
      aj.b(this.DXN, (kotlin.g.a.s)new i(this));
      AppMethodBeat.o(356348);
      return;
      paramFinderMedia = null;
      break;
    }
  }
  
  private final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(356322);
    Intent localIntent = new Intent();
    localIntent.putExtra("SUCC", paramBoolean);
    localIntent.putExtra("TITLE", getResources().getString(paramInt));
    localIntent.putExtra("DESC", paramString);
    localIntent.putExtra("IS_MINI_GAME", exb());
    ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).y((Context)getContext(), localIntent);
    AppMethodBeat.o(356322);
  }
  
  private com.tencent.mm.plugin.finder.live.widget.d ewV()
  {
    AppMethodBeat.i(356242);
    com.tencent.mm.plugin.finder.live.widget.d locald = this.DXG;
    if (locald != null)
    {
      AppMethodBeat.o(356242);
      return locald;
    }
    kotlin.g.b.s.bIx("taskWidget");
    AppMethodBeat.o(356242);
    return null;
  }
  
  private af ewX()
  {
    AppMethodBeat.i(356251);
    af localaf = this.DXI;
    if (localaf != null)
    {
      AppMethodBeat.o(356251);
      return localaf;
    }
    kotlin.g.b.s.bIx("licensePanelWidget");
    AppMethodBeat.o(356251);
    return null;
  }
  
  private final void ewY()
  {
    Object localObject2 = null;
    AppMethodBeat.i(356264);
    String str;
    label69:
    StringBuilder localStringBuilder;
    if (Util.isNullOrNil(this.coverUrl))
    {
      localObject1 = this.DXM;
      if (localObject1 == null)
      {
        localObject1 = "";
        this.coverUrl = ((String)localObject1);
        Log.i(this.TAG, kotlin.g.b.s.X("configCoverUrlAndAppInfo, coverUrl is empty, default:", this.coverUrl));
      }
    }
    else
    {
      str = this.appid;
      localObject1 = this.DXM;
      if (localObject1 != null) {
        break label180;
      }
      localObject1 = null;
      com.tencent.mm.pluginsdk.model.app.h.a(str, (String)localObject1, null);
      str = this.TAG;
      localStringBuilder = new StringBuilder("configCoverUrlAndAppInfo game:").append(this.appid).append(", ");
      localObject1 = this.DXM;
      if (localObject1 != null) {
        break label188;
      }
    }
    label180:
    label188:
    for (Object localObject1 = localObject2;; localObject1 = ((cbb)localObject1).xlJ)
    {
      Log.i(str, localObject1 + ", " + this.scene + ", " + this.hFb);
      AppMethodBeat.o(356264);
      return;
      str = ((cbb)localObject1).aakg;
      localObject1 = str;
      if (str != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = ((cbb)localObject1).xlr;
      break label69;
    }
  }
  
  private final void ewZ()
  {
    Object localObject2 = null;
    boolean bool = false;
    AppMethodBeat.i(356282);
    Object localObject1 = this.DXM;
    int j;
    label90:
    Object localObject5;
    label117:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((cbr)localObject1).aakZ.size() <= 0)) {
        break label274;
      }
      localObject3 = (MMActivity)getActivity();
      localObject2 = getActivity().findViewById(p.e.BVq);
      kotlin.g.b.s.s(localObject2, "activity.findViewById(R.…me_team_condition_layout)");
      localObject4 = (ViewGroup)localObject2;
      localObject2 = this.DXM;
      if (localObject2 != null) {
        break label228;
      }
      j = 0;
      localObject2 = ((cbr)localObject1).aakZ;
      kotlin.g.b.s.s(localObject2, "gameTeamInfo.qualifications_infos");
      localObject5 = ((Iterable)localObject2).iterator();
      if (!((Iterator)localObject5).hasNext()) {
        break label242;
      }
      localObject2 = ((Iterator)localObject5).next();
      if (((des)localObject2).value != 7) {
        break label237;
      }
      i = 1;
      label151:
      if (i == 0) {
        break label240;
      }
      label155:
      localObject2 = (des)localObject2;
      if (localObject2 != null) {
        break label248;
      }
      i = 0;
    }
    for (;;)
    {
      this.DXJ = new com.tencent.mm.plugin.finder.live.widget.ah((MMActivity)localObject3, (ViewGroup)localObject4, (cbr)localObject1, j, i);
      localObject1 = getActivity().findViewById(p.e.BVq);
      if (localObject1 == null) {
        break label361;
      }
      ((View)localObject1).setVisibility(0);
      AppMethodBeat.o(356282);
      return;
      localObject1 = ((cbb)localObject1).aaki;
      break;
      label228:
      j = ((cbb)localObject2).ZQz;
      break label90;
      label237:
      i = 0;
      break label151;
      label240:
      break label117;
      label242:
      localObject2 = null;
      break label155;
      label248:
      localObject2 = ((des)localObject2).ZGd;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = ((cca)localObject2).aalq;
      }
    }
    label274:
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("gameTeamInfo empty:");
    if (localObject1 != null) {
      bool = true;
    }
    localObject4 = ((StringBuilder)localObject4).append(bool).append(", ");
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      Log.i((String)localObject3, localObject1);
      localObject1 = getActivity().findViewById(p.e.BVq);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      label361:
      AppMethodBeat.o(356282);
      return;
      localObject5 = ((cbr)localObject1).aakZ;
      localObject1 = localObject2;
      if (localObject5 != null) {
        localObject1 = Integer.valueOf(((LinkedList)localObject5).size());
      }
    }
  }
  
  private final void exa()
  {
    AppMethodBeat.i(356299);
    Log.i(this.TAG, "startPost");
    Object localObject1 = aw.Gjk;
    if (aw.isFastClick())
    {
      Log.i(this.TAG, "startPost: click too fast!");
      AppMethodBeat.o(356299);
      return;
    }
    if (!ewW().isReady())
    {
      Log.i(this.TAG, "startPost: license not ready!");
      localObject1 = ewX();
      ((af)localObject1).EqD.setVisibility(0);
      ((af)localObject1).niX.show();
      AppMethodBeat.o(356299);
      return;
    }
    Object localObject2;
    String str;
    if (!exb())
    {
      localObject2 = this.DXM;
      if (localObject2 != null)
      {
        localObject1 = (CharSequence)((cbb)localObject2).xlr;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (i = 1; (i == 0) && (this.scene == 0); i = 0)
        {
          ah.a locala = new ah.a();
          localObject1 = com.tencent.mm.plugin.finder.utils.t.GgN;
          Context localContext = (Context)getContext();
          str = ((cbb)localObject2).xlr;
          localObject1 = str;
          if (str == null) {
            localObject1 = "";
          }
          locala.aiwY = com.tencent.mm.plugin.finder.utils.t.aN(localContext, (String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eSc().bmg()).intValue() == 3) {
            locala.aiwY = false;
          }
          Log.i(this.TAG, "game installed: " + locala.aiwY + ", packagename:" + ((cbb)localObject2).xlr);
          if (locala.aiwY) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.s.GgL;
          if (com.tencent.mm.plugin.finder.utils.s.feR() == 18L)
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.s.GgL;
            com.tencent.mm.plugin.finder.utils.s.TU(7);
          }
          com.tencent.mm.ui.base.k.b((Context)getContext(), getContext().getString(p.h.finder_secondcut_install_tip, new Object[] { ((cbb)localObject2).xlJ }), "", getContext().getString(p.h.app_ok), getContext().getString(p.h.app_cancel), new e..ExternalSyntheticLambda1(this, locala, (cbb)localObject2), new e..ExternalSyntheticLambda0(this));
          AppMethodBeat.o(356299);
          return;
        }
      }
    }
    localObject1 = ewU();
    if ((!Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.b)localObject1).Ebq)) && (y.ZC(((com.tencent.mm.plugin.finder.live.widget.b)localObject1).Ebq))) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("choose live cover:", ewU().Ebq));
      localObject1 = ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager();
      str = ewU().Ebq;
      localObject2 = z.bAW();
      kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.publish.b)localObject1).h(str, (String)localObject2, new j(this));
      AppMethodBeat.o(356299);
      return;
    }
    Log.i(this.TAG, kotlin.g.b.s.X("choose default cover:", ewU().EcY));
    a(ewU().Ely);
    AppMethodBeat.o(356299);
  }
  
  private final boolean exb()
  {
    cbb localcbb = this.DXM;
    return (localcbb != null) && (localcbb.aakj == 1);
  }
  
  private TextView getTitleTv()
  {
    AppMethodBeat.i(356231);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(356231);
      return localTextView;
    }
    kotlin.g.b.s.bIx("titleTv");
    AppMethodBeat.o(356231);
    return null;
  }
  
  private static final void gl(View paramView)
  {
    AppMethodBeat.i(356379);
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(localRect.width() * -2, -localRect.width());
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(356379);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(356379);
  }
  
  private static final void r(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356436);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(356436);
  }
  
  private static final void s(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356440);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(356440);
  }
  
  public final View ewT()
  {
    AppMethodBeat.i(356554);
    View localView = this.DXE;
    if (localView != null)
    {
      AppMethodBeat.o(356554);
      return localView;
    }
    kotlin.g.b.s.bIx("postBtn");
    AppMethodBeat.o(356554);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.live.widget.b ewU()
  {
    AppMethodBeat.i(356559);
    com.tencent.mm.plugin.finder.live.widget.b localb = this.DXF;
    if (localb != null)
    {
      AppMethodBeat.o(356559);
      return localb;
    }
    kotlin.g.b.s.bIx("coverWidget");
    AppMethodBeat.o(356559);
    return null;
  }
  
  public final ag ewW()
  {
    AppMethodBeat.i(356565);
    ag localag = this.DXH;
    if (localag != null)
    {
      AppMethodBeat.o(356565);
      return localag;
    }
    kotlin.g.b.s.bIx("licenseWidget");
    AppMethodBeat.o(356565);
    return null;
  }
  
  public final int getLayoutId()
  {
    return p.f.CcB;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(356625);
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    Object localObject1;
    if (paramIntent == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, localObject1);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt1 != DXR) {
        break label142;
      }
      if (paramInt2 != -1) {
        break label525;
      }
      if ((paramIntent == null) || (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) != 1)) {
        break label137;
      }
    }
    label137:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label525;
      }
      exa();
      AppMethodBeat.o(356625);
      return;
      localObject1 = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));
      break;
    }
    label142:
    localObject3 = ewU();
    if (paramInt1 == ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).Elz)
    {
      if (paramIntent == null) {
        break label525;
      }
      localObject1 = paramIntent.getData();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject4 = paramIntent.getData();
        if (localObject4 != null) {
          break label330;
        }
        label186:
        if (!Util.isNullOrNil((String)localObject2)) {
          break label576;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.tools.t.g((Context)((com.tencent.mm.plugin.finder.live.widget.b)localObject3).activity, paramIntent, ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUh());
      }
    }
    label525:
    label532:
    label546:
    label555:
    label576:
    for (;;)
    {
      Log.i(((com.tencent.mm.plugin.finder.live.widget.b)localObject3).TAG, "filePath[" + localObject1 + "] " + paramIntent);
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).a(((com.tencent.mm.plugin.finder.live.widget.b)localObject3).activity, (String)localObject1, "", ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).ElA, ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).activity.getResources().getColor(p.b.room_live_logo_color));
        if (paramIntent.getData() == null)
        {
          AppMethodBeat.o(356625);
          return;
          localObject1 = ((Uri)localObject1).getPath();
          break;
          label330:
          localObject2 = ((Uri)localObject4).getPath();
          break label186;
          if (paramInt1 == ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).ElA)
          {
            if (paramIntent != null) {
              break label532;
            }
            paramIntent = null;
            localObject2 = ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).TAG;
            if (paramIntent != null) {
              break label546;
            }
            localObject1 = null;
            label369:
            Log.i((String)localObject2, kotlin.g.b.s.X("REQUEST_CODE_CROP_FIX_IMAGE model: ", localObject1));
            if (paramIntent != null)
            {
              localObject1 = paramIntent.thumbPath;
              localObject2 = paramIntent.NHK;
              kotlin.g.b.s.s(localObject2, "photo");
              if ((!((Boolean)localObject2).booleanValue()) || (Util.isNullOrNil(paramIntent.thumbPath))) {
                break label555;
              }
              paramIntent = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              paramIntent = ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).coverIv;
              kotlin.g.b.s.s(localObject1, "filePath");
              com.tencent.mm.plugin.finder.live.utils.a.b(paramIntent, (String)localObject1, Math.min(((com.tencent.mm.plugin.finder.live.widget.b)localObject3).coverIv.getWidth(), 500), Math.min(((com.tencent.mm.plugin.finder.live.widget.b)localObject3).coverIv.getHeight(), 500));
              kotlin.g.b.s.u(localObject1, "<set-?>");
              ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).Ebq = ((String)localObject1);
              kotlin.g.b.s.u("", "<set-?>");
              ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).EcY = "";
              ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).Ely = null;
            }
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.live.widget.b)localObject3).Elx.onChange();
        AppMethodBeat.o(356625);
        return;
        paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
        break;
        localObject1 = paramIntent.thumbPath;
        break label369;
        aa.makeText((Context)((com.tencent.mm.plugin.finder.live.widget.b)localObject3).activity, p.h.finder_activity_crop_cover_fail, 0).show();
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(356632);
    af localaf = ewX();
    if (localaf.EqD.getVisibility() == 0) {
      localaf.niX.hide();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(356632);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(356632);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    TextView localTextView = null;
    boolean bool2 = false;
    AppMethodBeat.i(356589);
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getStringExtra("COVER_URL");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.coverUrl = paramBundle;
    localObject1 = getIntent().getStringExtra("TICKET");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.hFb = paramBundle;
    localObject1 = getIntent().getStringExtra("APPID");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.appid = paramBundle;
    this.scene = getIntent().getIntExtra("POST_FROM_SCENE", 0);
    this.DXN = getIntent().getBooleanExtra("IS_FROM_WEAPP", false);
    paramBundle = (com.tencent.mm.bx.a)new ccb();
    localObject1 = getIntent().getByteArrayExtra("GameUserInfo");
    try
    {
      paramBundle.parseFrom((byte[])localObject1);
      this.DXL = ((ccb)paramBundle);
      paramBundle = this.DXL;
      if (paramBundle == null)
      {
        paramBundle = null;
        this.DXM = paramBundle;
        if (!getIntent().hasExtra("VERSION_TYPE")) {
          break label1167;
        }
        i = getIntent().getIntExtra("VERSION_TYPE", 0);
        this.euz = i;
        this.DXO = getIntent().getIntExtra("MINI_GAME_SCENE", 0);
        localObject1 = getIntent().getStringExtra("WXA_DEVELOPER_CUSTOM_PARAM");
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        this.DXP = paramBundle;
        localObject1 = getIntent().getStringExtra("REPORT_INFO");
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        this.mxQ = paramBundle;
        if (this.DXM != null) {
          break label1203;
        }
        new com.tencent.mm.plugin.finder.live.cgi.p(this.appid, this.scene).e((Context)getContext(), getResources().getString(p.h.finder_waiting), 500L).bFJ().a((com.tencent.mm.vending.e.b)getActivity()).g(new e..ExternalSyntheticLambda7(this));
        paramBundle = getActivity().findViewById(p.e.BVb);
        kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.game_post_root)");
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.lBX = paramBundle;
        paramBundle = getActivity().findViewById(p.e.BVd);
        kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.game_post_title_tv)");
        paramBundle = (TextView)paramBundle;
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.titleTv = paramBundle;
        paramBundle = getActivity().findViewById(p.e.BQU);
        kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.…nder_live_post_task_view)");
        paramBundle = (FinderLiveTaskBannerView)paramBundle;
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXC = paramBundle;
        paramBundle = getActivity().findViewById(p.e.BUY);
        kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.game_post_iv)");
        paramBundle = (ImageView)paramBundle;
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.coverIv = paramBundle;
        paramBundle = getActivity().findViewById(p.e.BVf);
        kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.game_replace_cover_iv)");
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXD = paramBundle;
        paramBundle = getActivity().findViewById(p.e.BZm);
        kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.id.post_btn)");
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXE = paramBundle;
        ewT().setEnabled(false);
        Object localObject2 = (Activity)getActivity();
        paramBundle = this.coverIv;
        if (paramBundle == null) {
          break label1210;
        }
        localObject1 = this.DXD;
        if (localObject1 == null) {
          break label1221;
        }
        paramBundle = new com.tencent.mm.plugin.finder.live.widget.b((Activity)localObject2, paramBundle, (View)localObject1, (k.f)new d(this));
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXF = paramBundle;
        ewU().setCover(this.coverUrl);
        localObject1 = (Activity)getActivity();
        paramBundle = this.DXC;
        if (paramBundle == null) {
          break label1233;
        }
        paramBundle = new com.tencent.mm.plugin.finder.live.widget.d((Activity)localObject1, paramBundle);
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXG = paramBundle;
        paramBundle = this.DXL;
        if (paramBundle != null) {
          ewV().b(paramBundle);
        }
        paramBundle = (MMActivity)getActivity();
        localObject1 = getActivity().findViewById(p.e.BUZ);
        kotlin.g.b.s.s(localObject1, "activity.findViewById(R.…e_post_license_container)");
        localObject1 = (ViewGroup)localObject1;
        if (this.scene != 1) {
          break label1244;
        }
        bool1 = true;
        paramBundle = new ag(paramBundle, (ViewGroup)localObject1, bool1, (k.f)new e());
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXH = paramBundle;
        ewW().bF(this.appid, exb());
        paramBundle = (MMActivity)getActivity();
        localObject1 = getActivity().findViewById(p.e.BKF);
        kotlin.g.b.s.s(localObject1, "activity.findViewById(R.…st_license_panel_ui_root)");
        paramBundle = new af(paramBundle, (ViewGroup)localObject1, (kotlin.g.a.a)new f(this));
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        this.DXI = paramBundle;
        ewX().sC(exb());
        ewW().eAQ();
        ewZ();
        paramBundle = (MMActivity)getActivity();
        localObject1 = getActivity().findViewById(p.e.BVk);
        kotlin.g.b.s.s(localObject1, "activity.findViewById(R.id.game_sticker_layout)");
        this.DXK = new com.tencent.mm.plugin.finder.live.widget.c(paramBundle, (ViewGroup)localObject1, this.appid, this.scene, (kotlin.g.a.m)new g(this));
        localObject1 = this.DXK;
        if (localObject1 != null)
        {
          paramBundle = this.DXM;
          if (paramBundle != null) {
            break label1249;
          }
          paramBundle = null;
          localObject2 = this.DXM;
          bool1 = bool2;
          if (localObject2 != null)
          {
            bool1 = bool2;
            if (((cbb)localObject2).ZXv == true) {
              bool1 = true;
            }
          }
          ((com.tencent.mm.plugin.finder.live.widget.c)localObject1).bD(paramBundle, bool1);
        }
        paramBundle = g.DIp;
        localObject1 = z.bAW();
        paramBundle = this.lBX;
        if (paramBundle == null) {
          break label1257;
        }
        g.a((String)localObject1, "", paramBundle);
        paramBundle = findViewById(p.e.BVe);
        paramBundle.post(new e..ExternalSyntheticLambda8(paramBundle));
        paramBundle.setOnClickListener(new e..ExternalSyntheticLambda5(this));
        localTextView = getTitleTv();
        paramBundle = this.DXM;
        if (paramBundle != null) {
          break label1269;
        }
        paramBundle = "";
        localTextView.setText((CharSequence)paramBundle);
        ewT().setOnClickListener(new e..ExternalSyntheticLambda4(this));
        paramBundle = com.tencent.mm.plugin.finder.utils.s.GgL;
        if (com.tencent.mm.plugin.finder.utils.s.feR() == 19L)
        {
          paramBundle = com.tencent.mm.plugin.finder.utils.s.GgL;
          com.tencent.mm.plugin.finder.utils.s.TU(1);
        }
        AppMethodBeat.o(356589);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        int i;
        boolean bool1;
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        paramBundle = paramBundle.aals;
        continue;
        label1167:
        paramBundle = this.DXM;
        if (paramBundle == null)
        {
          i = 0;
        }
        else
        {
          paramBundle = paramBundle.aakk;
          if (paramBundle == null)
          {
            i = 0;
          }
          else
          {
            i = paramBundle.Tqb;
            continue;
            label1203:
            ewY();
            continue;
            label1210:
            kotlin.g.b.s.bIx("coverIv");
            paramBundle = null;
            continue;
            label1221:
            kotlin.g.b.s.bIx("replaceCoverIv");
            localObject1 = null;
            continue;
            label1233:
            kotlin.g.b.s.bIx("taskBannerView");
            paramBundle = null;
            continue;
            label1244:
            bool1 = false;
            continue;
            label1249:
            paramBundle = paramBundle.aakm;
            continue;
            label1257:
            kotlin.g.b.s.bIx("root");
            paramBundle = localTextView;
            continue;
            label1269:
            localObject1 = paramBundle.xlJ;
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null) {
              paramBundle = "";
            }
          }
        }
      }
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(356596);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.adbA, Boolean.FALSE);
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(356596);
      throw paramBundle;
    }
    if (!((Boolean)paramBundle).booleanValue())
    {
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((h)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(h.class)).show();
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((h)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(h.class)).DYl = ((kotlin.g.a.a)new b(this));
    }
    AppMethodBeat.o(356596);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(356603);
    super.onPause();
    ewV().ElI.stop();
    AppMethodBeat.o(356603);
  }
  
  public final void onResume()
  {
    int i = 1;
    AppMethodBeat.i(356613);
    super.onResume();
    ewV().ElI.resume();
    if (this.DXQ)
    {
      localObject = new iw();
      ((iw)localObject).hKx.hKy = true;
      ((iw)localObject).publish();
    }
    Object localObject = this.DXK;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.widget.c)localObject).onResume();
    }
    localObject = getActivity().findViewById(p.e.BVk);
    StringBuilder localStringBuilder;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      if (i != 0)
      {
        localObject = com.tencent.mm.plugin.finder.utils.s.GgL;
        localStringBuilder = new StringBuilder("{\"gameappid\":\"");
        localObject = this.DXK;
        if (localObject != null) {
          break label150;
        }
        localObject = "";
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.utils.s.bF(9, (String)localObject + "\"}");
      AppMethodBeat.o(356613);
      return;
      i = 0;
      break;
      label150:
      String str = ((com.tencent.mm.plugin.finder.live.widget.c)localObject).appid;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(e parame, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements k.f
  {
    d(e parame) {}
    
    public final void onChange()
    {
      AppMethodBeat.i(356429);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.DXS));
      AppMethodBeat.o(356429);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      a(e parame)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$3", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements k.f
  {
    public final void onChange() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "url", "", "hasSet", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.m<String, Boolean, kotlin.ah>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$jumpGame$ok$1", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "onLaunchApp", "", "launchSuccess", "", "launchCancel", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ap
  {
    h(e parame) {}
    
    public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(356459);
      if (paramBoolean1)
      {
        this.DXS.DXQ = true;
        com.tencent.mm.plugin.finder.utils.s locals = com.tencent.mm.plugin.finder.utils.s.GgL;
        if (com.tencent.mm.plugin.finder.utils.s.feR() == 18L)
        {
          locals = com.tencent.mm.plugin.finder.utils.s.GgL;
          com.tencent.mm.plugin.finder.utils.s.TU(6);
        }
      }
      AppMethodBeat.o(356459);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "extInfo", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, Bundle, kotlin.ah>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$startPost$3", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.loader.f.e<com.tencent.mm.loader.f.c>
  {
    j(e parame) {}
    
    public final void a(com.tencent.mm.loader.f.c paramc, com.tencent.mm.loader.f.i parami)
    {
      AppMethodBeat.i(356476);
      kotlin.g.b.s.u(paramc, "task");
      kotlin.g.b.s.u(parami, "status");
      FinderMedia localFinderMedia;
      if ((parami == com.tencent.mm.loader.f.i.nrG) && (!Util.isNullOrNil(((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl)))
      {
        localFinderMedia = new FinderMedia();
        localFinderMedia.url = ((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl;
        localFinderMedia.mediaType = 9;
        localFinderMedia.thumbUrl = ((com.tencent.mm.plugin.finder.upload.m)paramc).Gcj;
        localFinderMedia.videoDuration = 0;
        if (Util.isNullOrNil(this.DXS.ewU().Ebq)) {
          break label185;
        }
        parami = aw.Gjk;
        parami = aw.aBX(this.DXS.ewU().Ebq);
        localFinderMedia.width = parami.x;
        localFinderMedia.height = parami.y;
        parami = ((com.tencent.mm.plugin.finder.upload.m)paramc).mxU;
        if (parami != null) {
          break label200;
        }
        parami = "";
      }
      for (;;)
      {
        localFinderMedia.md5sum = parami;
        localFinderMedia.coverUrl = ((com.tencent.mm.plugin.finder.upload.m)paramc).resultUrl;
        e.a(this.DXS, localFinderMedia);
        AppMethodBeat.o(356476);
        return;
        label185:
        this.DXS.ewU();
        parami = com.tencent.mm.plugin.finder.live.widget.b.ezT();
        break;
        label200:
        String str = parami.field_filemd5;
        parami = str;
        if (str == null) {
          parami = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.e
 * JD-Core Version:    0.7.0.1
 */