package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ii;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.i;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveBaseUI;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.widget.r;
import com.tencent.mm.plugin.finder.upload.m;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.ap.c;
import com.tencent.mm.plugin.finder.utils.aq;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.au.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;
import kotlin.g.b.aa.a;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "appid", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "coverWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;", "getCoverWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;", "setCoverWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderGameLivePostCoverWidget;)V", "gameAppInfo", "Lcom/tencent/mm/protocal/protobuf/GameAppInfo;", "getGameAppInfo", "()Lcom/tencent/mm/protocal/protobuf/GameAppInfo;", "setGameAppInfo", "(Lcom/tencent/mm/protocal/protobuf/GameAppInfo;)V", "gameTeamWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;", "getGameTeamWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;", "setGameTeamWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostTeamWidget;)V", "isFromWeApp", "", "()Z", "setFromWeApp", "(Z)V", "licensePanelWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameLicensePanelWidget;", "getLicensePanelWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameLicensePanelWidget;", "setLicensePanelWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGameLicensePanelWidget;)V", "licenseWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;", "getLicenseWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;", "setLicenseWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveGamePostLicenseWidget;)V", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "postBtn", "Landroid/view/View;", "getPostBtn", "()Landroid/view/View;", "setPostBtn", "(Landroid/view/View;)V", "postEventWhenResume", "getPostEventWhenResume", "setPostEventWhenResume", "replaceCoverIv", "getReplaceCoverIv", "setReplaceCoverIv", "root", "getRoot", "setRoot", "scene", "", "getScene", "()I", "setScene", "(I)V", "ticket", "getTicket", "setTicket", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "versionType", "getVersionType", "setVersionType", "configCoverUrlAndAppInfo", "", "continuePost", "media", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getLayoutId", "gotoFaceVerify", "verifyUrl", "handleError", "errCode", "handleStartMiniGameLiveFail", "errType", "errMsg", "extInfo", "Landroid/os/Bundle;", "initData", "initView", "isMiniGameLive", "jumpFinish", "succ", "title", "desc", "jumpGame", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "onGetUserGameConfigFail", "onResume", "refreshGameInfo", "gameUserInfo", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "refreshView", "startMiniGameLive", "startPost", "Companion", "plugin-finder_release"})
public final class e
  extends UIComponent
{
  private static final int zbD = 10000;
  public static final a zbE;
  private final String TAG;
  String appid;
  int cBU;
  private String coverUrl;
  private String fAo;
  public View jac;
  public ImageView sDJ;
  int scene;
  public TextView titleTv;
  private au xPA;
  bne zbA;
  boolean zbB;
  boolean zbC;
  public View zbu;
  public View zbv;
  public com.tencent.mm.plugin.finder.live.widget.a zbw;
  public r zbx;
  public com.tencent.mm.plugin.finder.live.widget.q zby;
  private com.tencent.mm.plugin.finder.live.widget.s zbz;
  
  static
  {
    AppMethodBeat.i(276320);
    zbE = new a((byte)0);
    zbD = 10000;
    AppMethodBeat.o(276320);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(276318);
    this.TAG = "Finder.FinderGameLivePostUIC";
    this.coverUrl = "";
    this.fAo = "";
    this.appid = "";
    AppMethodBeat.o(276318);
  }
  
  private final void a(FinderMedia paramFinderMedia)
  {
    int i = 0;
    AppMethodBeat.i(276309);
    if (paramFinderMedia == null)
    {
      w.makeText((Context)getContext(), b.j.finder_live_game_post_failed_reason, 0).show();
      Log.i(this.TAG, "continuePost: media is null!");
      AppMethodBeat.o(276309);
      return;
    }
    Object localObject = this.zbx;
    if (localObject == null) {
      kotlin.g.b.p.bGy("licenseWidget");
    }
    ((r)localObject).dIm();
    if (dFT())
    {
      b(paramFinderMedia);
      AppMethodBeat.o(276309);
      return;
    }
    localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = ((d)com.tencent.mm.ui.component.g.lm((Context)getContext()).i(d.class)).dFM().getText().toString();
    String str1 = this.fAo;
    String str2 = this.appid;
    int j = this.scene;
    com.tencent.mm.plugin.finder.live.widget.s locals = this.zbz;
    if (locals != null) {
      i = locals.zoj;
    }
    paramFinderMedia = new i(paramFinderMedia, (String)localObject, str1, str2, j, i).e((Context)getActivity(), getResources().getString(b.j.finder_waiting), 500L).bhW();
    localObject = getActivity();
    if (localObject == null)
    {
      paramFinderMedia = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostUI");
      AppMethodBeat.o(276309);
      throw paramFinderMedia;
    }
    paramFinderMedia.a((com.tencent.mm.vending.e.b)localObject).g((com.tencent.mm.vending.c.a)new b(this));
    AppMethodBeat.o(276309);
  }
  
  private final void b(FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(276312);
    Log.i(this.TAG, "startMiniGameLive: appid = " + this.appid + ", version_type = " + this.cBU);
    if (this.xPA == null)
    {
      localObject = au.AJj;
      this.xPA = au.a.a((Context)getActivity(), getActivity().getResources().getString(b.j.finder_waiting), 0L, 12);
    }
    Object localObject = this.xPA;
    if (localObject != null) {
      ((au)localObject).begin();
    }
    FinderObjectDesc localFinderObjectDesc = new FinderObjectDesc();
    localObject = com.tencent.mm.ui.component.g.Xox;
    localFinderObjectDesc.description = ((d)com.tencent.mm.ui.component.g.lm((Context)getContext()).i(d.class)).dFM().getText().toString();
    localFinderObjectDesc.mediaType = 9;
    localFinderObjectDesc.extReading = new asl();
    localObject = new azd();
    ((azd)localObject).zfA = paramFinderMedia.coverUrl;
    localFinderObjectDesc.liveDesc = ((azd)localObject);
    localFinderObjectDesc.media.add(paramFinderMedia);
    paramFinderMedia = ao.AGX;
    localObject = ap.AIh;
    ao.a(paramFinderMedia, ap.efv().name, null, true, false, 10);
    paramFinderMedia = ao.AGX;
    localObject = ap.AIh;
    ao.a(paramFinderMedia, ap.efw().name, null, false, false, 14);
    paramFinderMedia = aq.AIJ;
    aq.Nl(cm.bfC());
    ah localah = ah.yhC;
    localObject = ah.dzj();
    paramFinderMedia = (FinderMedia)localObject;
    if (localObject == null) {
      paramFinderMedia = new com.tencent.mm.plugin.finder.live.model.context.a();
    }
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy = true;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgz = this.appid;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgA = this.cBU;
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).zgW = localFinderObjectDesc;
    ah.a(localah, paramFinderMedia, null, 0, 1, null, 22);
    localObject = getActivity();
    paramFinderMedia = (FinderMedia)localObject;
    if (!(localObject instanceof FinderGameLiveBaseUI)) {
      paramFinderMedia = null;
    }
    paramFinderMedia = (FinderGameLiveBaseUI)paramFinderMedia;
    if (paramFinderMedia != null)
    {
      paramFinderMedia = paramFinderMedia.dvi();
      if (paramFinderMedia != null) {
        paramFinderMedia.dead();
      }
    }
    paramFinderMedia = EventCenter.instance;
    localObject = new ii();
    ((ii)localObject).fFz.fFA = true;
    ((ii)localObject).fFz.fFB = true;
    paramFinderMedia.publish((IEvent)localObject);
    localObject = getActivity();
    paramFinderMedia = (FinderMedia)localObject;
    if (!(localObject instanceof FinderGameLiveBaseUI)) {
      paramFinderMedia = null;
    }
    paramFinderMedia = (FinderGameLiveBaseUI)paramFinderMedia;
    if (paramFinderMedia != null)
    {
      paramFinderMedia = paramFinderMedia.dvi();
      if (paramFinderMedia != null) {
        paramFinderMedia.alive();
      }
    }
    paramFinderMedia = ah.yhC;
    paramFinderMedia = ah.dzj();
    if (paramFinderMedia != null)
    {
      localObject = ah.yhC;
      ah.a(paramFinderMedia, true, com.tencent.mm.live.c.b.c.kzS, null, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramFinderMedia.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId);
    }
    paramFinderMedia = ah.yhC;
    ah.a((kotlin.g.a.s)new m(this));
    AppMethodBeat.o(276312);
  }
  
  private final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(276310);
    Intent localIntent = new Intent();
    localIntent.putExtra("SUCC", paramBoolean);
    localIntent.putExtra("TITLE", getResources().getString(paramInt));
    localIntent.putExtra("DESC", paramString);
    localIntent.putExtra("IS_MINI_GAME", dFT());
    paramString = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.ah((Context)getContext(), localIntent);
    AppMethodBeat.o(276310);
  }
  
  private final void dFR()
  {
    Object localObject2 = null;
    AppMethodBeat.i(276307);
    if (Util.isNullOrNil(this.coverUrl))
    {
      localObject1 = this.zbA;
      if (localObject1 != null)
      {
        str = ((bne)localObject1).SYf;
        localObject1 = str;
        if (str != null) {}
      }
      else
      {
        localObject1 = "";
      }
      this.coverUrl = ((String)localObject1);
      Log.i(this.TAG, "configCoverUrlAndAppInfo, coverUrl is empty, default:" + this.coverUrl);
    }
    String str = this.appid;
    Object localObject1 = this.zbA;
    if (localObject1 != null) {}
    for (localObject1 = ((bne)localObject1).ufq;; localObject1 = null)
    {
      com.tencent.mm.pluginsdk.model.app.h.a(str, (String)localObject1, null);
      str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("configCoverUrlAndAppInfo game:").append(this.appid).append(", ");
      bne localbne = this.zbA;
      localObject1 = localObject2;
      if (localbne != null) {
        localObject1 = localbne.ufB;
      }
      Log.i(str, (String)localObject1 + ", " + this.scene + ", " + this.fAo);
      AppMethodBeat.o(276307);
      return;
    }
  }
  
  private final void dFS()
  {
    AppMethodBeat.i(276308);
    Log.i(this.TAG, "startPost");
    Object localObject1 = aj.AGc;
    if (aj.isFastClick())
    {
      Log.i(this.TAG, "startPost: click too fast!");
      AppMethodBeat.o(276308);
      return;
    }
    localObject1 = this.zbx;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("licenseWidget");
    }
    if (!((r)localObject1).isReady())
    {
      Log.i(this.TAG, "startPost: license not ready!");
      localObject1 = this.zby;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("licensePanelWidget");
      }
      ((com.tencent.mm.plugin.finder.live.widget.q)localObject1).znZ.setVisibility(0);
      ((com.tencent.mm.plugin.finder.live.widget.q)localObject1).kFV.show();
      AppMethodBeat.o(276308);
      return;
    }
    if (!dFT())
    {
      localObject3 = this.zbA;
      if (localObject3 != null)
      {
        localObject1 = (CharSequence)((bne)localObject3).ufq;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (i = 1; (i == 0) && (this.scene == 0); i = 0)
        {
          final aa.a locala = new aa.a();
          localObject1 = com.tencent.mm.plugin.finder.utils.p.ADF;
          Context localContext = (Context)getContext();
          localObject2 = ((bne)localObject3).ufq;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          locala.aaBx = com.tencent.mm.plugin.finder.utils.p.aJ(localContext, (String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dTL().aSr()).intValue() == 3) {
            locala.aaBx = false;
          }
          Log.i(this.TAG, "game installed: " + locala.aaBx + ", packagename:" + ((bne)localObject3).ufq);
          if (locala.aaBx) {
            break;
          }
          localObject1 = o.ADA;
          if (o.ecW() == 18L)
          {
            localObject1 = o.ADA;
            o.QJ(7);
          }
          com.tencent.mm.ui.base.h.c((Context)getContext(), getContext().getString(b.j.finder_secondcut_install_tip, new Object[] { ((bne)localObject3).ufB }), "", getContext().getString(b.j.app_ok), getContext().getString(b.j.app_cancel), (DialogInterface.OnClickListener)new n(this, locala, (bne)localObject3), (DialogInterface.OnClickListener)new o(this));
          AppMethodBeat.o(276308);
          return;
        }
      }
    }
    localObject1 = this.zbw;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("coverWidget");
    }
    if ((!Util.isNullOrNil(((com.tencent.mm.plugin.finder.live.widget.a)localObject1).zex)) && (com.tencent.mm.vfs.u.agG(((com.tencent.mm.plugin.finder.live.widget.a)localObject1).zex))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("choose live cover:");
      localObject3 = this.zbw;
      if (localObject3 == null) {
        kotlin.g.b.p.bGy("coverWidget");
      }
      Log.i((String)localObject1, ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zex);
      localObject1 = com.tencent.mm.plugin.finder.upload.g.AAk;
      localObject1 = com.tencent.mm.plugin.finder.upload.g.ecj();
      localObject2 = this.zbw;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("coverWidget");
      }
      localObject2 = ((com.tencent.mm.plugin.finder.live.widget.a)localObject2).zex;
      localObject3 = z.bdh();
      kotlin.g.b.p.j(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.upload.g)localObject1).a((String)localObject2, (String)localObject3, (com.tencent.mm.loader.g.f)new p(this));
      AppMethodBeat.o(276308);
      return;
    }
    localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("choose default cover:");
    Object localObject3 = this.zbw;
    if (localObject3 == null) {
      kotlin.g.b.p.bGy("coverWidget");
    }
    Log.i((String)localObject1, ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zfA);
    localObject1 = this.zbw;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("coverWidget");
    }
    a(((com.tencent.mm.plugin.finder.live.widget.a)localObject1).zlj);
    AppMethodBeat.o(276308);
  }
  
  private final boolean dFT()
  {
    bne localbne = this.zbA;
    return (localbne != null) && (localbne.SYi == 1);
  }
  
  public final View dFP()
  {
    AppMethodBeat.i(276304);
    View localView = this.zbv;
    if (localView == null) {
      kotlin.g.b.p.bGy("postBtn");
    }
    AppMethodBeat.o(276304);
    return localView;
  }
  
  public final com.tencent.mm.plugin.finder.live.widget.a dFQ()
  {
    AppMethodBeat.i(276305);
    com.tencent.mm.plugin.finder.live.widget.a locala = this.zbw;
    if (locala == null) {
      kotlin.g.b.p.bGy("coverWidget");
    }
    AppMethodBeat.o(276305);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_game_live_post_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(276314);
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    if (paramIntent != null) {}
    for (Object localObject1 = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt1 != zbD) {
        break label138;
      }
      if (paramInt2 != -1) {
        break label528;
      }
      if (paramIntent == null) {
        break;
      }
      if (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) != 1) {
        break label528;
      }
      dFS();
      AppMethodBeat.o(276314);
      return;
    }
    AppMethodBeat.o(276314);
    return;
    label138:
    localObject3 = this.zbw;
    if (localObject3 == null) {
      kotlin.g.b.p.bGy("coverWidget");
    }
    if (paramInt1 == ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zlk)
    {
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getData();
        if (localObject1 != null) {}
        for (localObject1 = ((Uri)localObject1).getPath();; localObject1 = null)
        {
          localObject4 = paramIntent.getData();
          if (localObject4 != null) {
            localObject2 = ((Uri)localObject4).getPath();
          }
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = (Context)((com.tencent.mm.plugin.finder.live.widget.a)localObject3).activity;
            localObject2 = av.AJz;
            localObject1 = com.tencent.mm.pluginsdk.ui.tools.u.g((Context)localObject1, paramIntent, av.egn());
          }
          Log.i(((com.tencent.mm.plugin.finder.live.widget.a)localObject3).TAG, "filePath[" + (String)localObject1 + "] " + paramIntent);
          if (localObject1 == null) {
            break;
          }
          localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.a(((com.tencent.mm.plugin.finder.live.widget.a)localObject3).activity, (String)localObject1, "", ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zll, ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).activity.getResources().getColor(com.tencent.mm.plugin.finder.b.c.room_live_logo_color));
          if (paramIntent.getData() != null) {
            break;
          }
          AppMethodBeat.o(276314);
          return;
        }
      }
    }
    else if (paramInt1 == ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zll)
    {
      if (paramIntent == null) {
        break label535;
      }
      paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
      localObject2 = ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).TAG;
      localObject4 = new StringBuilder("REQUEST_CODE_CROP_FIX_IMAGE model: ");
      if (paramIntent == null) {
        break label540;
      }
      localObject1 = paramIntent.aZe();
      label388:
      Log.i((String)localObject2, (String)localObject1);
      if (paramIntent != null)
      {
        localObject1 = paramIntent.aZe();
        localObject2 = paramIntent.fvT();
        kotlin.g.b.p.j(localObject2, "photo");
        if ((!((Boolean)localObject2).booleanValue()) || (Util.isNullOrNil(paramIntent.aZe()))) {
          break label546;
        }
        paramIntent = aj.AGc;
        paramIntent = ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).sDJ;
        kotlin.g.b.p.j(localObject1, "filePath");
        aj.b(paramIntent, (String)localObject1, Math.min(((com.tencent.mm.plugin.finder.live.widget.a)localObject3).sDJ.getWidth(), 500), Math.min(((com.tencent.mm.plugin.finder.live.widget.a)localObject3).sDJ.getHeight(), 500));
        ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zex = ((String)localObject1);
        ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zfA = "";
        ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zlj = null;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.widget.a)localObject3).zlm.onChange();
      label528:
      AppMethodBeat.o(276314);
      return;
      label535:
      paramIntent = null;
      break;
      label540:
      localObject1 = null;
      break label388;
      label546:
      w.makeText((Context)((com.tencent.mm.plugin.finder.live.widget.a)localObject3).activity, b.j.finder_activity_crop_cover_fail, 0).show();
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(276316);
    com.tencent.mm.plugin.finder.live.widget.q localq = this.zby;
    if (localq == null) {
      kotlin.g.b.p.bGy("licensePanelWidget");
    }
    if (localq.znZ.getVisibility() == 0) {
      localq.kFV.hide();
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(276316);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(276316);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    int j = 0;
    AppMethodBeat.i(276306);
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
    this.fAo = paramBundle;
    localObject1 = getIntent().getStringExtra("APPID");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.appid = paramBundle;
    this.scene = getIntent().getIntExtra("POST_FROM_SCENE", 0);
    this.zbB = getIntent().getBooleanExtra("IS_FROM_WEAPP", false);
    paramBundle = (com.tencent.mm.cd.a)new bne();
    localObject1 = getIntent().getByteArrayExtra("GameAppInfo");
    label333:
    Object localObject3;
    label621:
    boolean bool1;
    try
    {
      paramBundle.parseFrom((byte[])localObject1);
      this.zbA = ((bne)paramBundle);
      if (getIntent().hasExtra("VERSION_TYPE"))
      {
        i = getIntent().getIntExtra("VERSION_TYPE", 0);
        this.cBU = i;
        if (this.zbA != null) {
          break label621;
        }
        paramBundle = new com.tencent.mm.plugin.finder.live.cgi.j(this.appid, this.scene).e((Context)getContext(), getResources().getString(b.j.finder_waiting), 500L).bhW();
        localObject1 = getActivity();
        if (localObject1 != null) {
          break label333;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(276306);
        throw paramBundle;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        paramBundle = this.zbA;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.SYj;
          if (paramBundle != null)
          {
            i = paramBundle.RYL;
            continue;
          }
        }
        i = 0;
      }
      paramBundle.a((com.tencent.mm.vending.e.b)localObject1).g((com.tencent.mm.vending.c.a)new e(this));
      for (;;)
      {
        paramBundle = getActivity().findViewById(b.f.game_post_root);
        kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.game_post_root)");
        this.jac = paramBundle;
        paramBundle = getActivity().findViewById(b.f.game_post_title_tv);
        kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.game_post_title_tv)");
        this.titleTv = ((TextView)paramBundle);
        paramBundle = getActivity().findViewById(b.f.game_post_iv);
        kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.game_post_iv)");
        this.sDJ = ((ImageView)paramBundle);
        paramBundle = getActivity().findViewById(b.f.game_replace_cover_iv);
        kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.game_replace_cover_iv)");
        this.zbu = paramBundle;
        paramBundle = getActivity().findViewById(b.f.post_btn);
        kotlin.g.b.p.j(paramBundle, "activity.findViewById(R.id.post_btn)");
        this.zbv = paramBundle;
        paramBundle = this.zbv;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("postBtn");
        }
        paramBundle.setEnabled(false);
        paramBundle = (Activity)getActivity();
        localObject1 = this.sDJ;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("coverIv");
        }
        localObject3 = this.zbu;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("replaceCoverIv");
        }
        this.zbw = new com.tencent.mm.plugin.finder.live.widget.a(paramBundle, (ImageView)localObject1, (View)localObject3, (i.e)new f(this));
        paramBundle = this.zbw;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("coverWidget");
        }
        paramBundle.setCover(this.coverUrl);
        paramBundle = getActivity();
        if (paramBundle != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(276306);
        throw paramBundle;
        dFR();
      }
      paramBundle = (MMActivity)paramBundle;
      localObject1 = getActivity().findViewById(b.f.game_post_license_container);
      kotlin.g.b.p.j(localObject1, "activity.findViewById(R.…e_post_license_container)");
      localObject1 = (ViewGroup)localObject1;
      if (this.scene == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.zbx = new r(paramBundle, (ViewGroup)localObject1, bool1, (i.e)new g());
        paramBundle = this.zbx;
        if (paramBundle == null) {
          kotlin.g.b.p.bGy("licenseWidget");
        }
        paramBundle.bp(this.appid, dFT());
        paramBundle = getActivity();
        if (paramBundle != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(276306);
        throw paramBundle;
      }
      paramBundle = (MMActivity)paramBundle;
      localObject1 = getActivity().findViewById(b.f.finder_live_game_post_license_panel_ui_root);
      kotlin.g.b.p.j(localObject1, "activity.findViewById(R.…st_license_panel_ui_root)");
      this.zby = new com.tencent.mm.plugin.finder.live.widget.q(paramBundle, (ViewGroup)localObject1, (kotlin.g.a.a)new h(this));
      paramBundle = this.zby;
      if (paramBundle == null) {
        kotlin.g.b.p.bGy("licensePanelWidget");
      }
      paramBundle.pI(dFT());
      paramBundle = this.zbx;
      if (paramBundle == null) {
        kotlin.g.b.p.bGy("licenseWidget");
      }
      paramBundle.dIl();
      paramBundle = this.zbA;
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.SYh;; paramBundle = null)
      {
        if ((paramBundle == null) || (paramBundle.SYM.size() <= 0)) {
          break label1164;
        }
        localObject1 = getActivity();
        if (localObject1 != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(276306);
        throw paramBundle;
      }
      localObject1 = (MMActivity)localObject1;
      localObject2 = getActivity().findViewById(b.f.game_team_condition_layout);
      kotlin.g.b.p.j(localObject2, "activity.findViewById(R.…me_team_condition_layout)");
      localObject2 = (ViewGroup)localObject2;
      localObject3 = this.zbA;
      int i = j;
      if (localObject3 != null) {
        i = ((bne)localObject3).SLe;
      }
      this.zbz = new com.tencent.mm.plugin.finder.live.widget.s((MMActivity)localObject1, (ViewGroup)localObject2, paramBundle, i);
    }
    paramBundle = com.tencent.mm.plugin.finder.live.util.g.yPJ;
    paramBundle = z.bdh();
    localObject1 = this.jac;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("root");
    }
    com.tencent.mm.plugin.finder.live.util.g.a(paramBundle, "", (View)localObject1);
    paramBundle = findViewById(b.f.game_post_top_close);
    paramBundle.post((Runnable)new i(paramBundle));
    paramBundle.setOnClickListener((View.OnClickListener)new j(this));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("titleTv");
    }
    paramBundle = this.zbA;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.ufB;
      if (paramBundle == null) {}
    }
    for (paramBundle = (CharSequence)paramBundle;; paramBundle = (CharSequence)"")
    {
      ((TextView)localObject1).setText(paramBundle);
      paramBundle = this.zbv;
      if (paramBundle == null) {
        kotlin.g.b.p.bGy("postBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new k(this));
      paramBundle = o.ADA;
      if (o.ecW() == 19L)
      {
        paramBundle = o.ADA;
        o.QJ(1);
      }
      AppMethodBeat.o(276306);
      return;
      label1164:
      localObject3 = this.TAG;
      localObject1 = new StringBuilder("gameTeamInfo empty:");
      bool1 = bool2;
      if (paramBundle != null) {
        bool1 = true;
      }
      StringBuilder localStringBuilder = ((StringBuilder)localObject1).append(bool1).append(", ");
      localObject1 = localObject2;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.SYM;
        localObject1 = localObject2;
        if (paramBundle != null) {
          localObject1 = Integer.valueOf(paramBundle.size());
        }
      }
      Log.i((String)localObject3, localObject1);
      paramBundle = getActivity().findViewById(b.f.game_team_condition_layout);
      if (paramBundle == null) {
        break;
      }
      paramBundle.setVisibility(8);
      break;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(276313);
    super.onResume();
    if (this.zbC)
    {
      EventCenter localEventCenter = EventCenter.instance;
      ii localii = new ii();
      localii.fFz.fFA = true;
      localEventCenter.publish((IEvent)localii);
    }
    AppMethodBeat.o(276313);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "", "getENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateGameLivePrepareResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    public static final c zbJ;
    
    static
    {
      AppMethodBeat.i(276709);
      zbJ = new c();
      AppMethodBeat.o(276709);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(276707);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(276707);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    public static final d zbK;
    
    static
    {
      AppMethodBeat.i(285265);
      zbK = new d();
      AppMethodBeat.o(285265);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(285264);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(285264);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder_release"})
  public static final class f
    implements i.e
  {
    public final void onChange()
    {
      AppMethodBeat.i(290107);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(290107);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(e.f paramf)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$2", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLivePostUIC$WidgetStatusCallback;", "onChange", "", "plugin-finder_release"})
  public static final class g
    implements i.e
  {
    public final void onChange() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(267177);
      Object localObject1 = new Rect();
      this.xOk.getHitRect((Rect)localObject1);
      ((Rect)localObject1).inset(((Rect)localObject1).width() * -2, -((Rect)localObject1).width());
      Object localObject2 = this.xOk;
      kotlin.g.b.p.j(localObject2, "topBack");
      localObject2 = ((View)localObject2).getParent();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(267177);
        throw ((Throwable)localObject1);
      }
      ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, this.xOk));
      AppMethodBeat.o(267177);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291274);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zbF.getActivity().finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291274);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(284846);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (e.d(this.zbF))
      {
        paramView = o.ADA;
        o.bd(9, this.zbF.appid);
      }
      for (;;)
      {
        e.e(this.zbF);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$initView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284846);
        return;
        paramView = o.ADA;
        if (o.ecW() == 18L)
        {
          paramView = o.ADA;
          o.QJ(5);
        }
        paramView = o.ADA;
        if (o.ecW() == 19L)
        {
          paramView = o.ADA;
          o.QJ(2);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$jumpGame$ok$1", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "onLaunchApp", "", "launchSuccess", "", "launchCancel", "plugin-finder_release"})
  public static final class l
    implements al
  {
    public final void y(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(248556);
      if (paramBoolean1)
      {
        this.zbF.zbC = true;
        o localo = o.ADA;
        if (o.ecW() == 18L)
        {
          localo = o.ADA;
          o.QJ(6);
        }
      }
      AppMethodBeat.o(248556);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "extInfo", "Landroid/os/Bundle;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.s<Boolean, Integer, Integer, String, Bundle, x>
  {
    m(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class n
    implements DialogInterface.OnClickListener
  {
    n(e parame, aa.a parama, bne parambne) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(277404);
      paramDialogInterface.dismiss();
      Log.i(e.a(this.zbF), "dialog ok isInstall:" + locala.aaBx);
      paramDialogInterface = com.tencent.mm.plugin.finder.utils.p.ADF;
      Context localContext = (Context)this.zbF.getContext();
      String str = this.zbN.iUJ;
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
      com.tencent.mm.plugin.finder.utils.p.aK(localContext, paramDialogInterface);
      paramDialogInterface = o.ADA;
      if (o.ecW() == 18L)
      {
        paramDialogInterface = o.ADA;
        o.QJ(8);
      }
      AppMethodBeat.o(277404);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class o
    implements DialogInterface.OnClickListener
  {
    o(e parame) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(286208);
      Log.i(e.a(this.zbF), "dialog cancel");
      paramDialogInterface.dismiss();
      AppMethodBeat.o(286208);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLivePostUIC$startPost$3", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(289613);
      kotlin.g.b.p.k(paramc, "task");
      kotlin.g.b.p.k(paramj, "status");
      FinderMedia localFinderMedia;
      if ((paramj == com.tencent.mm.loader.g.j.kQd) && (!Util.isNullOrNil(((m)paramc).resultUrl)))
      {
        localFinderMedia = new FinderMedia();
        localFinderMedia.url = ((m)paramc).resultUrl;
        localFinderMedia.mediaType = 9;
        localFinderMedia.thumbUrl = ((m)paramc).AAI;
        localFinderMedia.videoDuration = 0;
        if (Util.isNullOrNil(this.zbF.dFQ().zex)) {
          break label196;
        }
        paramj = aj.AGc;
      }
      for (paramj = aj.aFH(this.zbF.dFQ().zex);; paramj = com.tencent.mm.plugin.finder.live.widget.a.dHG())
      {
        localFinderMedia.width = paramj.x;
        localFinderMedia.height = paramj.y;
        paramj = ((m)paramc).jYa;
        if (paramj != null)
        {
          String str = paramj.field_filemd5;
          paramj = str;
          if (str != null) {}
        }
        else
        {
          paramj = "";
        }
        localFinderMedia.md5sum = paramj;
        localFinderMedia.coverUrl = ((m)paramc).resultUrl;
        e.a(this.zbF, localFinderMedia);
        AppMethodBeat.o(289613);
        return;
        label196:
        this.zbF.dFQ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.e
 * JD-Core Version:    0.7.0.1
 */