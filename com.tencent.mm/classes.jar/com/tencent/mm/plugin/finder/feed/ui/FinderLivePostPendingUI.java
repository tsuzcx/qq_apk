package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.io;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.au.a;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.findersdk.a.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.e;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "activity", "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI;", "setActivity", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isVerifyFin", "()Z", "setVerifyFin", "(Z)V", "listener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderRealNameVertifyFinishEvent;", "getListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "outSizeTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "roomId", "", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "checkAccountValid", "finderUsername", "checkLivePermission", "context", "Landroid/app/Activity;", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "getLayoutId", "", "getReportTag", "globalEnable", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "Companion", "plugin-finder-live_release"})
public final class FinderLivePostPendingUI
  extends MMFinderUI
  implements i
{
  public static final a xPF;
  private HashMap _$_findViewCache;
  private IListener<io> iQL;
  private String roomId;
  private au xPA;
  private bda xPB;
  FinderLivePostPendingUI xPC;
  boolean xPD;
  private boolean xPE;
  private ble xPw;
  private arr xPx;
  private bbh xPy;
  private bdh xPz;
  
  static
  {
    AppMethodBeat.i(232411);
    xPF = new a((byte)0);
    AppMethodBeat.o(232411);
  }
  
  public FinderLivePostPendingUI()
  {
    AppMethodBeat.i(232410);
    this.xPC = ((FinderLivePostPendingUI)this);
    this.roomId = "";
    this.iQL = ((IListener)new k(this));
    AppMethodBeat.o(232410);
  }
  
  private static boolean ML(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(232395);
    if (!com.tencent.mm.ae.d.dr(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostPendingUI", "globalEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(232395);
      return bool;
      bool = false;
    }
  }
  
  private static boolean MM(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(232396);
    if (!com.tencent.mm.ae.d.dr(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostPendingUI", "privateEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(232396);
      return bool;
      bool = false;
    }
  }
  
  private final void MN(int paramInt)
  {
    AppMethodBeat.i(232406);
    Log.i("Finder.FinderLivePostPendingUI", "showErrPage type:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    localIntent.setClass((Context)this.xPC, a.c.class);
    this.xPC.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(232406);
  }
  
  private final boolean aBM(final String paramString)
  {
    AppMethodBeat.i(232385);
    Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid()");
    Object localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VyF, 0);
    if ((i & 0x1) != 0)
    {
      Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid() check has real name userFlag %d", new Object[] { Integer.valueOf(i) });
      paramString = new aa.a();
      paramString.aaBx = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(9), Long.valueOf(System.currentTimeMillis()) });
      FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialogWithCallback((Activity)this.xPC, (DialogInterface.OnClickListener)new b(paramString), (DialogInterface.OnClickListener)new c(this), (DialogInterface.OnDismissListener)new d(this, paramString));
      AppMethodBeat.o(232385);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid() need create finder contact.");
      paramString = new Intent();
      paramString.putExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 1);
      paramString.putExtra("key_router_to_profile", false);
      localObject = new aa.a();
      ((aa.a)localObject).aaBx = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
      FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialogOnLiveWithCallback((Activity)this.xPC, 9, paramString, 10002, (DialogInterface.OnClickListener)new e((aa.a)localObject), (DialogInterface.OnClickListener)new f(this), (DialogInterface.OnDismissListener)new g(this, (aa.a)localObject));
      AppMethodBeat.o(232385);
      return false;
    }
    AppMethodBeat.o(232385);
    return true;
  }
  
  private final void aBN(String paramString)
  {
    AppMethodBeat.i(232404);
    Log.i("Finder.FinderLivePostPendingUI", "gotoFaceVerify ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 1);
    localIntent.putExtra("FACE_VERIFY_URL", paramString);
    localIntent.setClass((Context)this.xPC, a.c.class);
    this.xPC.startActivityForResult(localIntent, 10000);
    AppMethodBeat.o(232404);
  }
  
  private static boolean am(Activity paramActivity)
  {
    AppMethodBeat.i(232402);
    Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission()");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.CAMERA", 16, "", "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission() invalid checkCamera:".concat(String.valueOf(bool)));
      AppMethodBeat.o(232402);
      return false;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "", "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission() invalid checkMicroPhone:".concat(String.valueOf(bool)));
      AppMethodBeat.o(232402);
      return false;
    }
    AppMethodBeat.o(232402);
    return true;
  }
  
  private final boolean dvr()
  {
    AppMethodBeat.i(232384);
    if (!NetStatusUtil.isConnected((Context)this.xPC))
    {
      new f.a((Context)this.xPC).icD().bBl(this.xPC.getResources().getString(b.j.finder_live_jump_tip_network_unavailable)).bBp(this.xPC.getResources().getString(b.j.app_i_know)).b((f.c)new i(this)).show();
      Log.e("Finder.FinderLivePostPendingUI", "checkNetworkAvailable() network problem");
      AppMethodBeat.o(232384);
      return false;
    }
    AppMethodBeat.o(232384);
    return true;
  }
  
  private final void dvs()
  {
    AppMethodBeat.i(232387);
    Log.i("Finder.FinderLivePostPendingUI", "handleConfirmPostLive");
    au localau = this.xPA;
    if (localau != null) {
      localau.end();
    }
    dvt();
    dvu();
    dvv();
    dvx();
    AppMethodBeat.o(232387);
  }
  
  private final void dvt()
  {
    AppMethodBeat.i(232389);
    if (this.xPw == null)
    {
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new ch(8));
      Object localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(232389);
        return;
      }
    }
    AppMethodBeat.o(232389);
  }
  
  private final void dvu()
  {
    AppMethodBeat.i(232391);
    if ((dvw()) && (this.xPz == null))
    {
      com.tencent.mm.kernel.h.aGY().a(5231, (i)this);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.finder.live.cgi.p());
      Object localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(232391);
        return;
      }
    }
    AppMethodBeat.o(232391);
  }
  
  private final void dvv()
  {
    AppMethodBeat.i(232393);
    if (this.xPx == null)
    {
      Object localObject = new aa.e();
      ((aa.e)localObject).aaBB = System.currentTimeMillis();
      com.tencent.mm.plugin.finder.cgi.ao localao = com.tencent.mm.plugin.finder.cgi.ao.xcj;
      new ae(com.tencent.mm.plugin.finder.cgi.ao.dnO(), z.bdh(), ((aa.e)localObject).aaBB, (ae.a)new h((aa.e)localObject, this), (byte)0).bhW().a((com.tencent.mm.vending.e.b)this.xPC);
      localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(232393);
        return;
      }
    }
    AppMethodBeat.o(232393);
  }
  
  private static boolean dvw()
  {
    AppMethodBeat.i(232394);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VyG, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(232394);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLivePostPendingUI", "isVerify:".concat(String.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(232394);
    return bool;
  }
  
  private final void dvx()
  {
    AppMethodBeat.i(232400);
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    kotlin.g.b.p.j(localObject2, "Looper.getMainLooper()");
    if ((kotlin.g.b.p.h(localObject1, ((Looper)localObject2).getThread()) ^ true))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(this));
      AppMethodBeat.o(232400);
      return;
    }
    Log.i("Finder.FinderLivePostPendingUI", "gotoLive");
    if (this.xPE)
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(232400);
      return;
    }
    if (this.xPw == null)
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(232400);
      return;
    }
    arr localarr = this.xPx;
    label225:
    Object localObject3;
    if (localarr != null)
    {
      localObject1 = ah.yhC;
      if ((ah.dzj() == null) && (localarr.SEM != null))
      {
        localObject1 = localarr.SEM;
        Intent localIntent;
        Context localContext;
        long l;
        bac localbac;
        bbh localbbh;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label485;
          }
          localObject1 = localarr.SEM;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).liveInfo;
            if ((localObject1 != null) && (((bac)localObject1).liveId == 0L)) {
              break label485;
            }
          }
          localObject2 = new StringBuilder("gotoLive continue live:");
          localObject1 = localarr.SEM;
          if (localObject1 == null) {
            break label474;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label474;
          }
          localObject1 = Long.valueOf(((bac)localObject1).liveId);
          Log.i("Finder.FinderLivePostPendingUI", localObject1);
          localIntent = new Intent();
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(this.roomId);
          localIntent.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", (ArrayList)localObject1);
          localObject2 = this.xPB;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = localarr.SEO;
          }
          localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localContext = (Context)this.xPC;
          localObject2 = localarr.SEM;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          l = ((FinderObject)localObject2).id;
          localObject2 = localarr.SEM;
          if (localObject2 != null)
          {
            localObject3 = ((FinderObject)localObject2).objectNonceId;
            localObject2 = localObject3;
            if (localObject3 != null) {}
          }
          else
          {
            localObject2 = "";
          }
          localObject3 = localarr.SEM;
          if (localObject3 == null) {
            kotlin.g.b.p.iCn();
          }
          localbac = ((FinderObject)localObject3).liveInfo;
          if (localbac == null) {
            kotlin.g.b.p.iCn();
          }
          kotlin.g.b.p.j(localbac, "it.recover_live_object!!.liveInfo!!");
          localbbh = this.xPy;
          localObject3 = localarr.SEM;
          if (localObject3 == null) {
            break label479;
          }
        }
        label474:
        label479:
        for (localObject3 = ((FinderObject)localObject3).sessionBuffer;; localObject3 = null)
        {
          com.tencent.mm.plugin.finder.utils.a.a(localContext, l, (String)localObject2, localbac, localbbh, null, localarr.SEN, (bda)localObject1, null, (String)localObject3, localarr.SEP, localIntent, 592);
          AppMethodBeat.o(232400);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label225;
        }
      }
      label485:
      if (!ML(localarr.SEK))
      {
        MN(2);
        Log.w("Finder.FinderLivePostPendingUI", "gotoLive type:" + localarr.SEK);
        AppMethodBeat.o(232400);
        return;
      }
      if (!MM(localarr.RUO))
      {
        MN(2);
        Log.w("Finder.FinderLivePostPendingUI", "gotoLive type:" + localarr.RUO);
        AppMethodBeat.o(232400);
      }
    }
    else
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderCreateLivePrepareResponse is null.");
      AppMethodBeat.o(232400);
      return;
    }
    if (dvw()) {
      if (this.xPz != null)
      {
        localObject1 = this.xPz;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        if (!((bdh)localObject1).wvU)
        {
          localObject1 = this.xPz;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          if (!Util.isNullOrNil(((bdh)localObject1).OAl))
          {
            localObject1 = this.xPz;
            if (localObject1 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject2 = ((bdh)localObject1).OAl;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            aBN((String)localObject1);
            localObject1 = new StringBuilder("gotoLive, is verify:");
            localObject2 = this.xPz;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            Log.i("Finder.FinderLivePostPendingUI", ((bdh)localObject2).wvU);
            AppMethodBeat.o(232400);
            return;
          }
          w.makeText((Context)this.xPC, (CharSequence)this.xPC.getResources().getString(b.j.finder_live_not_realname), 0).show();
          localObject2 = new StringBuilder("handleNetSceneFinderLiveVerify() real name Url is empty:");
          localObject1 = this.xPz;
          if (localObject1 != null) {}
          for (localObject1 = ((bdh)localObject1).OAl;; localObject1 = null)
          {
            Log.e("Finder.FinderLivePostPendingUI", (String)localObject1);
            break;
          }
        }
      }
      else
      {
        Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(232400);
        return;
      }
    }
    if (!am((Activity)this.xPC))
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive permission is invalid.");
      AppMethodBeat.o(232400);
      return;
    }
    localarr = this.xPx;
    if (localarr != null)
    {
      localObject3 = new Intent();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(this.roomId);
      ((Intent)localObject3).putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", (ArrayList)localObject1);
      localObject2 = this.xPB;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = localarr.SEO;
      }
      localObject2 = this.xPx;
      if (localObject2 != null) {
        ((arr)localObject2).SEO = ((bda)localObject1);
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.a((Context)this.xPC, this.xPx, (Intent)localObject3);
    }
    this.xPE = true;
    Log.w("Finder.FinderLivePostPendingUI", "gotoLive 进入直播间.");
    finish();
    AppMethodBeat.o(232400);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(232382);
    Log.i("Finder.FinderLivePostPendingUI", "prepare()");
    Object localObject1 = z.bdh();
    if (!dvr())
    {
      Log.e("Finder.FinderLivePostPendingUI", "prepare() checkNetworkAvailable failed");
      localObject1 = this.xPA;
      if (localObject1 != null)
      {
        ((au)localObject1).end();
        AppMethodBeat.o(232382);
        return;
      }
      AppMethodBeat.o(232382);
      return;
    }
    if (!aBM((String)localObject1))
    {
      Log.e("Finder.FinderLivePostPendingUI", "prepare() checkAccountValid failed");
      localObject1 = this.xPA;
      if (localObject1 != null)
      {
        ((au)localObject1).end();
        AppMethodBeat.o(232382);
        return;
      }
      AppMethodBeat.o(232382);
      return;
    }
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
    if (kotlin.g.b.p.h(((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VDp, Integer.valueOf(0)), Integer.valueOf(0)))
    {
      localObject2 = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.VDp, Integer.valueOf(1));
      localObject2 = this.xPA;
      if (localObject2 != null) {
        ((au)localObject2).end();
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(5), Long.valueOf(System.currentTimeMillis()) });
      localObject2 = new aa.a();
      ((aa.a)localObject2).aaBx = false;
      FinderBottomCustomDialogHelper.Companion localCompanion = FinderBottomCustomDialogHelper.Companion;
      Context localContext = (Context)this.xPC;
      kotlin.g.b.p.j(localObject1, "finderUsername");
      localCompanion.showUserInfoConfirmDialog(localContext, (String)localObject1, (DialogInterface.OnClickListener)new m(this, (aa.a)localObject2), (DialogInterface.OnClickListener)n.xPJ, (DialogInterface.OnDismissListener)new o(this, (aa.a)localObject2));
      AppMethodBeat.o(232382);
      return;
    }
    dvs();
    AppMethodBeat.o(232382);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(232418);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(232418);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232417);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(232417);
    return localView1;
  }
  
  public final String dvl()
  {
    return "Finder.FinderLivePostPendingUI";
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(232379);
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    if (paramIntent != null) {}
    for (Integer localInteger = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));; localInteger = null)
    {
      Log.i("Finder.FinderLivePostPendingUI", localInteger);
      if (paramInt1 != 10000) {
        break label122;
      }
      if (paramInt2 != -1) {
        break label165;
      }
      if (paramIntent == null) {
        break;
      }
      if (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) != 1) {
        break label165;
      }
      dvx();
      AppMethodBeat.o(232379);
      return;
    }
    AppMethodBeat.o(232379);
    return;
    label122:
    if ((paramInt1 != 10001) && (paramInt1 == 10002))
    {
      paramIntent = FinderCreateContactUI.ApX;
      if (paramInt2 == FinderCreateContactUI.eaj())
      {
        dvs();
        AppMethodBeat.o(232379);
        return;
      }
      this.xPC.finish();
    }
    label165:
    AppMethodBeat.o(232379);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232377);
    setTheme(b.k.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(3761, (i)this);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    paramBundle = au.AJj;
    this.xPA = au.a.a((Context)this.xPC, this.xPC.getResources().getString(b.j.finder_waiting), 1000L, 8);
    paramBundle = this.xPA;
    if (paramBundle != null) {
      paramBundle.begin();
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new l(this));
    this.iQL.alive();
    Object localObject = getIntent().getStringExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.roomId = paramBundle;
    paramBundle = getIntent().getByteArrayExtra("KEY_TAG_INFO");
    if (paramBundle != null)
    {
      this.xPB = new bda();
      localObject = this.xPB;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      ((bda)localObject).parseFrom(paramBundle);
    }
    Log.i("Finder.FinderLivePostPendingUI", "roomId " + this.roomId);
    prepare();
    AppMethodBeat.o(232377);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232383);
    super.onDestroy();
    this.iQL.dead();
    Log.i("Finder.FinderLivePostPendingUI", "release()");
    Log.i("Finder.FinderLivePostPendingUI", "reset()");
    this.xPE = false;
    au localau = this.xPA;
    if (localau != null) {
      localau.AJi = 0;
    }
    com.tencent.mm.kernel.h.aGY().b(5231, (i)this);
    com.tencent.mm.kernel.h.aGY().b(3761, (i)this);
    this.xPw = null;
    this.xPx = null;
    this.xPy = null;
    this.xPz = null;
    AppMethodBeat.o(232383);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(232380);
    kotlin.g.b.p.k(paramArrayOfString, "permissions");
    kotlin.g.b.p.k(paramArrayOfInt, "grantResults");
    if ((paramInt == 16) || (paramInt == 80))
    {
      if (paramArrayOfInt.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label80;
        }
      }
      label80:
      for (int i = j;; i = 0)
      {
        if ((i == 0) || (paramArrayOfInt[0] != 0)) {
          break label86;
        }
        dvx();
        AppMethodBeat.o(232380);
        return;
        i = 0;
        break;
      }
      label86:
      Log.i("Finder.FinderLivePostPendingUI", "FinderLive request permission " + paramInt + " failed");
    }
    AppMethodBeat.o(232380);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(232405);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Integer localInteger;
    if (paramq != null)
    {
      localInteger = Integer.valueOf(paramq.getType());
      Log.i("Finder.FinderLivePostPendingUI", localInteger + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramq instanceof com.tencent.mm.plugin.finder.live.cgi.p)) {
        break label367;
      }
      paramString = (Context)this.xPC;
      paramq = (com.tencent.mm.plugin.finder.live.cgi.p)paramq;
      Log.i("Finder.FinderLivePostPendingUI", "handleNetSceneFinderLiveVerify()");
      com.tencent.mm.kernel.h.aGY().b(5231, (i)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label218;
      }
      this.xPz = paramq.dwU();
      dvx();
      paramString = new StringBuilder("handleNetSceneFinderLiveVerify() is verify:");
      paramq = this.xPz;
      if (paramq == null) {
        kotlin.g.b.p.iCn();
      }
      Log.i("Finder.FinderLivePostPendingUI", paramq.wvU);
    }
    for (;;)
    {
      paramString = this.xPA;
      if (paramString == null) {
        break label360;
      }
      paramString.end();
      AppMethodBeat.o(232405);
      return;
      localInteger = null;
      break;
      switch (paramInt2)
      {
      case -200017: 
      case -200016: 
      case -200015: 
      case -200014: 
      case -200013: 
      default: 
        w.makeText(paramString, (CharSequence)paramString.getResources().getString(b.j.finder_live_disable), 0).show();
        break;
      case -200009: 
        w.makeText(paramString, (CharSequence)paramString.getResources().getString(b.j.finder_live_anchor_not_adult), 0).show();
        break;
      case -200010: 
        w.makeText(paramString, (CharSequence)paramString.getResources().getString(b.j.finder_live_anchor_foreigner_error_text), 0).show();
        break;
      case -200011: 
        MN(3);
        break;
      case -200018: 
      case -200012: 
        label218:
        MN(2);
      }
    }
    label360:
    AppMethodBeat.o(232405);
    return;
    label367:
    if ((paramq instanceof ch))
    {
      if (this.xPD)
      {
        paramString = this.xPA;
        if (paramString != null) {
          paramString.end();
        }
        this.xPD = false;
        prepare();
        AppMethodBeat.o(232405);
        return;
      }
      paramString = (Context)this.xPC;
      paramq = (ch)paramq;
      Log.i("Finder.FinderLivePostPendingUI", "handleNetSceneFinderPrepareUser()");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.xPw = paramq.dnR();
        dvx();
      }
      for (;;)
      {
        paramString = this.xPA;
        if (paramString == null) {
          break;
        }
        paramString.end();
        AppMethodBeat.o(232405);
        return;
        w.makeText(paramString, b.j.finder_prepare_user_failed, 1).show();
      }
    }
    AppMethodBeat.o(232405);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI$Companion;", "", "()V", "ENTER_LIVE_CREATE_CONTACT_REQUEST_CODE", "", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "ENTER_LIVE_FORBIDDEN_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder-live_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(aa.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(232906);
      this.xPG.aaBx = true;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(10), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(232906);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(FinderLivePostPendingUI paramFinderLivePostPendingUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(232955);
      this.xPH.xPC.finish();
      AppMethodBeat.o(232955);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class d
    implements DialogInterface.OnDismissListener
  {
    d(FinderLivePostPendingUI paramFinderLivePostPendingUI, aa.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(233078);
      if (!paramString.aaBx) {
        this.xPH.xPC.finish();
      }
      AppMethodBeat.o(233078);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(aa.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(232356);
      this.xPG.aaBx = true;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(232356);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(FinderLivePostPendingUI paramFinderLivePostPendingUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(233743);
      this.xPH.xPC.finish();
      AppMethodBeat.o(233743);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class g
    implements DialogInterface.OnDismissListener
  {
    g(FinderLivePostPendingUI paramFinderLivePostPendingUI, aa.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(233991);
      if (!this.xPG.aaBx) {
        this.xPH.xPC.finish();
      }
      AppMethodBeat.o(233991);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder-live_release"})
  public static final class h
    implements ae.a
  {
    h(aa.e parame, FinderLivePostPendingUI paramFinderLivePostPendingUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, arr paramarr)
    {
      AppMethodBeat.i(233507);
      kotlin.g.b.p.k(paramarr, "resp");
      if (this.xPI.aaBB == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          FinderLivePostPendingUI.a(jdField_this, paramarr);
        }
      }
      for (;;)
      {
        paramString = FinderLivePostPendingUI.b(jdField_this);
        if (paramString == null) {
          break;
        }
        paramString.end();
        AppMethodBeat.o(233507);
        return;
        w.makeText((Context)jdField_this.xPC, b.j.finder_prepare_user_failed, 1).show();
        continue;
        Log.i("Finder.FinderLivePostPendingUI", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.xPI.aaBB + ",scene.requestId:" + paramLong);
      }
      AppMethodBeat.o(233507);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class i
    implements f.c
  {
    i(FinderLivePostPendingUI paramFinderLivePostPendingUI) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(233576);
      this.xPH.xPC.finish();
      AppMethodBeat.o(233576);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(FinderLivePostPendingUI paramFinderLivePostPendingUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderRealNameVertifyFinishEvent;", "callback", "", "event", "plugin-finder-live_release"})
  public static final class k
    extends IListener<io>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(FinderLivePostPendingUI paramFinderLivePostPendingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(232467);
      this.xPH.finish();
      AppMethodBeat.o(232467);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(FinderLivePostPendingUI paramFinderLivePostPendingUI, aa.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(233674);
      this.xPG.aaBx = true;
      FinderLivePostPendingUI.a(this.xPH);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(6), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(233674);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class n
    implements DialogInterface.OnClickListener
  {
    public static final n xPJ;
    
    static
    {
      AppMethodBeat.i(232823);
      xPJ = new n();
      AppMethodBeat.o(232823);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(232822);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dismiss();
        AppMethodBeat.o(232822);
        return;
      }
      AppMethodBeat.o(232822);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class o
    implements DialogInterface.OnDismissListener
  {
    o(FinderLivePostPendingUI paramFinderLivePostPendingUI, aa.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(233301);
      if (!this.xPG.aaBx) {
        this.xPH.xPC.finish();
      }
      AppMethodBeat.o(233301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLivePostPendingUI
 * JD-Core Version:    0.7.0.1
 */