package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.io;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.au.a;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.aa.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isVerifyFin", "listener", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$listener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$listener$1;", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "scene", "", "getScene", "()I", "setScene", "(I)V", "checkAccountValid", "finderUsername", "", "checkLivePermission", "context", "Landroid/app/Activity;", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "getLayoutId", "globalEnable", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "precheckEnable", "userFlag", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "prepare", "privateEnable", "privateFlag", "release", "showErrPage", "type", "showPrecheckPage", "Companion", "LivePostVerifyCallback", "plugin-finder_release"})
public final class j
  extends UIComponent
  implements i
{
  public static final a zdb;
  public int scene;
  private au xPA;
  private boolean xPD;
  private boolean xPE;
  private ble xPw;
  private arr xPx;
  private bbh xPy;
  private bdh xPz;
  private l zcZ;
  public b zda;
  
  static
  {
    AppMethodBeat.i(264700);
    zdb = new a((byte)0);
    AppMethodBeat.o(264700);
  }
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(264699);
    this.zcZ = new l(this);
    this.scene = 8;
    AppMethodBeat.o(264699);
  }
  
  private static boolean ML(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(264693);
    if (!d.dr(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "globalEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(264693);
      return bool;
      bool = false;
    }
  }
  
  private static boolean MM(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(264695);
    if (!d.dr(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "privateEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(264695);
      return bool;
      bool = false;
    }
  }
  
  private final void MN(int paramInt)
  {
    AppMethodBeat.i(264682);
    Log.i("Finder.FinderLiveVerifyUIC", "showErrPage type:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    Context localContext = (Context)getActivity();
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enJ());
    getActivity().startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(264682);
  }
  
  private final void a(int paramInt, elx paramelx)
  {
    AppMethodBeat.i(264684);
    Log.i("Finder.FinderLiveVerifyUIC", "showPrecheckPage userFlag:" + paramInt + " spamRisk:" + paramelx + ",stack:" + Util.getStack());
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 11);
    localIntent.putExtra("PRECHECK_USERFLAG", paramInt);
    localIntent.putExtra("PRECHECK_SPAMRISK", paramelx.toByteArray());
    paramelx = (Context)getContext();
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(paramelx, com.tencent.mm.plugin.findersdk.e.a.enJ());
    getContext().startActivityForResult(localIntent, 10003);
    AppMethodBeat.o(264684);
  }
  
  private final boolean aBM(final String paramString)
  {
    AppMethodBeat.i(264664);
    Log.i("Finder.FinderLiveVerifyUIC", "checkAccountValid()");
    Object localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    int i = ((f)localObject).aHp().getInt(ar.a.VyF, 0);
    if ((i & 0x1) != 0)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "checkAccountValid() check has real name userFlag %d", new Object[] { Integer.valueOf(i) });
      paramString = new aa.a();
      paramString.aaBx = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(9), Long.valueOf(System.currentTimeMillis()) });
      FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialogWithCallback((Activity)getActivity(), (DialogInterface.OnClickListener)new c(paramString), (DialogInterface.OnClickListener)new d(this), (DialogInterface.OnDismissListener)new e(this, paramString));
      AppMethodBeat.o(264664);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.i("Finder.FinderLiveVerifyUIC", "checkAccountValid() need create finder contact.");
      paramString = new Intent();
      paramString.putExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 1);
      paramString.putExtra("key_router_to_profile", false);
      localObject = new aa.a();
      ((aa.a)localObject).aaBx = false;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
      FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialogOnLiveWithCallback((Activity)getActivity(), 3, paramString, 10002, (DialogInterface.OnClickListener)new f((aa.a)localObject), (DialogInterface.OnClickListener)new g(this), (DialogInterface.OnDismissListener)new h(this, (aa.a)localObject));
      AppMethodBeat.o(264664);
      return false;
    }
    AppMethodBeat.o(264664);
    return true;
  }
  
  private final void aBN(String paramString)
  {
    AppMethodBeat.i(264690);
    Log.i("Finder.FinderLiveVerifyUIC", "gotoFaceVerify ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 1);
    localIntent.putExtra("FACE_VERIFY_URL", paramString);
    paramString = (Context)getActivity();
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(paramString, com.tencent.mm.plugin.findersdk.e.a.enJ());
    getActivity().startActivityForResult(localIntent, 10000);
    AppMethodBeat.o(264690);
  }
  
  private static boolean am(Activity paramActivity)
  {
    AppMethodBeat.i(264692);
    Log.i("Finder.FinderLiveVerifyUIC", "checkLivePermission()");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.CAMERA", 16, "", "");
    if (!bool)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "checkLivePermission() invalid checkCamera:".concat(String.valueOf(bool)));
      AppMethodBeat.o(264692);
      return false;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "", "");
    if (!bool)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "checkLivePermission() invalid checkMicroPhone:".concat(String.valueOf(bool)));
      AppMethodBeat.o(264692);
      return false;
    }
    AppMethodBeat.o(264692);
    return true;
  }
  
  private static boolean b(int paramInt, elx paramelx)
  {
    boolean bool4 = true;
    AppMethodBeat.i(264696);
    if (paramelx == null)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable spamRisk is empty!");
      AppMethodBeat.o(264696);
      return true;
    }
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (!com.tencent.mm.plugin.finder.live.utils.a.dEF())
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable canShowPrecheckEntrance:false");
      AppMethodBeat.o(264696);
      return true;
    }
    if (paramelx.UnS == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable showPage:" + bool1 + " promt:" + paramelx.UnS + " flag:" + paramInt);
      if (bool1) {
        break;
      }
      AppMethodBeat.o(264696);
      return true;
    }
    paramelx = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(paramelx, "MMKernel.storage()");
    paramelx = paramelx.aHp().get(ar.a.VyY, Boolean.FALSE);
    if (paramelx == null)
    {
      paramelx = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(264696);
      throw paramelx;
    }
    boolean bool5 = ((Boolean)paramelx).booleanValue();
    boolean bool2;
    label205:
    boolean bool3;
    if (!d.dr(paramInt, 4))
    {
      bool1 = true;
      if (d.dr(paramInt, 8)) {
        break label303;
      }
      bool2 = true;
      if (d.dr(paramInt, 16)) {
        break label308;
      }
      bool3 = true;
      label217:
      if ((!bool1) || (!bool2) || (!bool5) || (!bool3)) {
        break label314;
      }
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable haveShowPrecheckPage:" + bool5 + ",realnamePrecheckResult:" + bool1 + ",agePrecheckResult:" + bool2 + ", otherPrecheckResult:" + bool3);
      AppMethodBeat.o(264696);
      return bool4;
      bool1 = false;
      break;
      label303:
      bool2 = false;
      break label205;
      label308:
      bool3 = false;
      break label217;
      label314:
      bool4 = false;
    }
  }
  
  private final boolean dvr()
  {
    AppMethodBeat.i(264662);
    if (!NetStatusUtil.isConnected((Context)getActivity()))
    {
      new f.a((Context)getActivity()).icD().bBl(getActivity().getResources().getString(b.j.finder_live_jump_tip_network_unavailable)).bBp(getActivity().getResources().getString(b.j.app_i_know)).b((f.c)new j(this)).show();
      Log.e("Finder.FinderLiveVerifyUIC", "checkNetworkAvailable() network problem");
      AppMethodBeat.o(264662);
      return false;
    }
    AppMethodBeat.o(264662);
    return true;
  }
  
  private final void dvs()
  {
    AppMethodBeat.i(264670);
    Log.i("Finder.FinderLiveVerifyUIC", "handleConfirmPostLive");
    au localau = this.xPA;
    if (localau != null) {
      localau.end();
    }
    dvt();
    dvu();
    dvv();
    dvx();
    AppMethodBeat.o(264670);
  }
  
  private final void dvt()
  {
    AppMethodBeat.i(264672);
    if (this.xPw == null)
    {
      b.a.a((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class), this.scene);
      Object localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(264672);
        return;
      }
    }
    AppMethodBeat.o(264672);
  }
  
  private final void dvu()
  {
    AppMethodBeat.i(264673);
    if ((dvw()) && (this.xPz == null))
    {
      com.tencent.mm.kernel.h.aGY().a(5231, (i)this);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.finder.live.cgi.p());
      Object localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(264673);
        return;
      }
    }
    AppMethodBeat.o(264673);
  }
  
  private final void dvv()
  {
    AppMethodBeat.i(264676);
    if (this.xPx == null)
    {
      long l = System.currentTimeMillis();
      Object localObject = com.tencent.mm.plugin.finder.cgi.ao.xcj;
      new ae(com.tencent.mm.plugin.finder.cgi.ao.dnO(), z.bdh(), l, (ae.a)new i(l, this), (byte)0).bhW();
      localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(264676);
        return;
      }
    }
    AppMethodBeat.o(264676);
  }
  
  private static boolean dvw()
  {
    AppMethodBeat.i(264675);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VyG, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(264675);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLiveVerifyUIC", "isVerify:".concat(String.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(264675);
    return bool;
  }
  
  private final void dvx()
  {
    StringBuilder localStringBuilder = null;
    Object localObject2 = null;
    AppMethodBeat.i(264688);
    Object localObject1 = Thread.currentThread();
    Object localObject3 = Looper.getMainLooper();
    kotlin.g.b.p.j(localObject3, "Looper.getMainLooper()");
    if ((kotlin.g.b.p.h(localObject1, ((Looper)localObject3).getThread()) ^ true))
    {
      d.uiThread((kotlin.g.a.a)new k(this));
      AppMethodBeat.o(264688);
      return;
    }
    Log.i("Finder.FinderLiveVerifyUIC", "gotoLive");
    if (this.xPE)
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(264688);
      return;
    }
    if (this.xPw == null)
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(264688);
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
            Log.i("Finder.FinderLiveVerifyUIC", ((bdh)localObject2).wvU);
            AppMethodBeat.o(264688);
            return;
          }
          w.makeText((Context)getActivity(), (CharSequence)getActivity().getResources().getString(b.j.finder_live_not_realname), 0).show();
          localObject2 = new StringBuilder("handleNetSceneFinderLiveVerify() real name Url is empty:");
          localObject1 = this.xPz;
          if (localObject1 != null) {}
          for (localObject1 = ((bdh)localObject1).OAl;; localObject1 = null)
          {
            Log.e("Finder.FinderLiveVerifyUIC", (String)localObject1);
            break;
          }
        }
      }
      else
      {
        Log.e("Finder.FinderLiveVerifyUIC", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(264688);
        return;
      }
    }
    if (!am((Activity)getActivity()))
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive permission is invalid.");
      AppMethodBeat.o(264688);
      return;
    }
    localObject3 = this.xPx;
    if (localObject3 != null)
    {
      localObject1 = ah.yhC;
      if ((ah.dzj() == null) && (((arr)localObject3).SEM != null))
      {
        localObject1 = ((arr)localObject3).SEM;
        if (localObject1 != null) {
          localObject1 = ((FinderObject)localObject1).liveInfo;
        }
        while (localObject1 != null)
        {
          localObject1 = ((arr)localObject3).SEM;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).liveInfo;
            if ((localObject1 != null) && (((bac)localObject1).liveId == 0L)) {
              break;
            }
          }
          else
          {
            localStringBuilder = new StringBuilder("gotoLive continue live:");
            Object localObject4 = ((arr)localObject3).SEM;
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              localObject4 = ((FinderObject)localObject4).liveInfo;
              localObject1 = localObject2;
              if (localObject4 != null) {
                localObject1 = Long.valueOf(((bac)localObject4).liveId);
              }
            }
            Log.i("Finder.FinderLiveVerifyUIC", localObject1);
            localObject1 = this.zda;
            if (localObject1 != null)
            {
              ((b)localObject1).a(true, (arr)localObject3, true);
              AppMethodBeat.o(264688);
              return;
              localObject1 = null;
            }
            else
            {
              AppMethodBeat.o(264688);
              return;
            }
          }
        }
      }
      if (!ML(((arr)localObject3).SEK))
      {
        MN(2);
        Log.w("Finder.FinderLiveVerifyUIC", "gotoLive type:" + ((arr)localObject3).SEK);
        AppMethodBeat.o(264688);
        return;
      }
      if (!MM(((arr)localObject3).RUO))
      {
        MN(2);
        Log.w("Finder.FinderLiveVerifyUIC", "gotoLive type:" + ((arr)localObject3).RUO);
        AppMethodBeat.o(264688);
        return;
      }
      if (!b(((arr)localObject3).RUO, ((arr)localObject3).SEU))
      {
        localObject1 = ((arr)localObject3).SEU;
        if (localObject1 != null) {
          a(((arr)localObject3).RUO, (elx)localObject1);
        }
        Log.w("Finder.FinderLiveVerifyUIC", "gotoLive type:" + ((arr)localObject3).RUO);
        AppMethodBeat.o(264688);
        return;
      }
      localObject2 = this.zda;
      localObject1 = localStringBuilder;
      if (localObject2 != null)
      {
        j.b.a.a((b)localObject2, true, (arr)localObject3, 8);
        localObject1 = x.aazN;
      }
      if (localObject1 != null) {}
    }
    else
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive finderCreateLivePrepareResponse is null.");
      AppMethodBeat.o(264688);
      return;
    }
    this.xPE = true;
    Log.w("Finder.FinderLiveVerifyUIC", "gotoLive enter live room");
    AppMethodBeat.o(264688);
  }
  
  private final void prepare()
  {
    AppMethodBeat.i(264661);
    Log.i("Finder.FinderLiveVerifyUIC", "prepare()");
    Object localObject1 = z.bdh();
    if (!dvr())
    {
      Log.e("Finder.FinderLiveVerifyUIC", "prepare() checkNetworkAvailable failed");
      localObject1 = this.xPA;
      if (localObject1 != null)
      {
        ((au)localObject1).end();
        AppMethodBeat.o(264661);
        return;
      }
      AppMethodBeat.o(264661);
      return;
    }
    if (!aBM((String)localObject1))
    {
      Log.e("Finder.FinderLiveVerifyUIC", "prepare() checkAccountValid failed");
      localObject1 = this.xPA;
      if (localObject1 != null)
      {
        ((au)localObject1).end();
        AppMethodBeat.o(264661);
        return;
      }
      AppMethodBeat.o(264661);
      return;
    }
    Object localObject2 = this.xPA;
    if (localObject2 != null) {
      ((au)localObject2).end();
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(5), Long.valueOf(System.currentTimeMillis()) });
    localObject2 = new aa.a();
    ((aa.a)localObject2).aaBx = false;
    FinderBottomCustomDialogHelper.Companion localCompanion = FinderBottomCustomDialogHelper.Companion;
    Context localContext = (Context)getActivity();
    kotlin.g.b.p.j(localObject1, "finderUsername");
    localCompanion.showUserInfoConfirmDialog(localContext, (String)localObject1, (DialogInterface.OnClickListener)new m(this, (aa.a)localObject2), (DialogInterface.OnClickListener)n.zde, (DialogInterface.OnDismissListener)new o(this, (aa.a)localObject2));
    AppMethodBeat.o(264661);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_verify_uic;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(264667);
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    if (paramIntent != null) {}
    for (Integer localInteger = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));; localInteger = null)
    {
      Log.i("Finder.FinderLiveVerifyUIC", localInteger);
      if (paramInt1 != 10000) {
        break label146;
      }
      if ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) != 1)) {
        break;
      }
      dvx();
      AppMethodBeat.o(264667);
      return;
    }
    paramIntent = this.zda;
    if (paramIntent != null)
    {
      j.b.a.a(paramIntent, false, null, 14);
      AppMethodBeat.o(264667);
      return;
    }
    AppMethodBeat.o(264667);
    return;
    label146:
    if (paramInt1 == 10001)
    {
      paramIntent = this.zda;
      if (paramIntent != null)
      {
        j.b.a.a(paramIntent, false, null, 14);
        AppMethodBeat.o(264667);
        return;
      }
      AppMethodBeat.o(264667);
      return;
    }
    if (paramInt1 == 10002)
    {
      paramIntent = FinderCreateContactUI.ApX;
      if (paramInt2 == FinderCreateContactUI.eaj())
      {
        dvs();
        AppMethodBeat.o(264667);
        return;
      }
      paramIntent = this.zda;
      if (paramIntent != null)
      {
        j.b.a.a(paramIntent, false, null, 14);
        AppMethodBeat.o(264667);
        return;
      }
      AppMethodBeat.o(264667);
      return;
    }
    if (paramInt1 == 10003)
    {
      if (paramIntent != null)
      {
        paramIntent = Integer.valueOf(paramIntent.getIntExtra("PRECHECK_RESULT", 0));
        Log.i("Finder.FinderLiveVerifyUIC", "precheck result:".concat(String.valueOf(paramIntent)));
        if ((paramInt2 == -1) && (paramIntent != null)) {
          break label320;
        }
      }
      label320:
      while (paramIntent.intValue() != 1)
      {
        paramIntent = this.zda;
        if (paramIntent == null) {
          break label339;
        }
        j.b.a.a(paramIntent, false, null, 14);
        AppMethodBeat.o(264667);
        return;
        paramIntent = null;
        break;
      }
      dvx();
      AppMethodBeat.o(264667);
      return;
    }
    label339:
    AppMethodBeat.o(264667);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264660);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(3761, (i)this);
    paramBundle = au.AJj;
    this.xPA = au.a.a((Context)getActivity(), getActivity().getResources().getString(b.j.finder_waiting), 1000L, 8);
    paramBundle = this.xPA;
    if (paramBundle != null) {
      paramBundle.begin();
    }
    this.zcZ.alive();
    prepare();
    AppMethodBeat.o(264660);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(264698);
    super.onDestroy();
    this.zcZ.dead();
    com.tencent.mm.kernel.h.aGY().b(5231, (i)this);
    com.tencent.mm.kernel.h.aGY().b(3761, (i)this);
    this.xPw = null;
    this.xPx = null;
    this.xPy = null;
    this.xPz = null;
    AppMethodBeat.o(264698);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(264669);
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
        AppMethodBeat.o(264669);
        return;
        i = 0;
        break;
      }
      label86:
      Log.i("Finder.FinderLiveVerifyUIC", "FinderLive request permission " + paramInt + " failed");
    }
    AppMethodBeat.o(264669);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(264680);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Integer localInteger;
    if (paramq != null)
    {
      localInteger = Integer.valueOf(paramq.getType());
      Log.i("Finder.FinderLiveVerifyUIC", localInteger + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramq instanceof com.tencent.mm.plugin.finder.live.cgi.p)) {
        break label367;
      }
      paramString = (Context)getActivity();
      paramq = (com.tencent.mm.plugin.finder.live.cgi.p)paramq;
      Log.i("Finder.FinderLiveVerifyUIC", "handleNetSceneFinderLiveVerify()");
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
      Log.i("Finder.FinderLiveVerifyUIC", paramq.wvU);
    }
    for (;;)
    {
      paramString = this.xPA;
      if (paramString == null) {
        break label360;
      }
      paramString.end();
      AppMethodBeat.o(264680);
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
    AppMethodBeat.o(264680);
    return;
    label367:
    if ((paramq instanceof aq))
    {
      if (this.xPD)
      {
        paramString = this.xPA;
        if (paramString != null) {
          paramString.end();
        }
        this.xPD = false;
        prepare();
        AppMethodBeat.o(264680);
        return;
      }
      paramString = (Context)getActivity();
      paramq = (aq)paramq;
      Log.i("Finder.FinderLiveVerifyUIC", "handleNetSceneFinderPrepareUser()");
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
        AppMethodBeat.o(264680);
        return;
        w.makeText(paramString, b.j.finder_prepare_user_failed, 1).show();
      }
    }
    AppMethodBeat.o(264680);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$Companion;", "", "()V", "ENTER_LIVE_CREATE_CONTACT_REQUEST_CODE", "", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "ENTER_LIVE_FORBIDDEN_REQUEST_CODE", "ENTER_LIVE_PRECHECK_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "", "onVerified", "", "result", "", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "needContinueLive", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean1, arr paramarr, boolean paramBoolean2);
    
    @l(iBK={1, 1, 16})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(aa.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(274218);
      this.xPG.aaBx = true;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(10), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(274218);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(j paramj) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(289317);
      paramDialogInterface = this.zdc.zda;
      if (paramDialogInterface != null)
      {
        j.b.a.a(paramDialogInterface, false, null, 14);
        AppMethodBeat.o(289317);
        return;
      }
      AppMethodBeat.o(289317);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class e
    implements DialogInterface.OnDismissListener
  {
    e(j paramj, aa.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(289037);
      if (!paramString.aaBx)
      {
        paramDialogInterface = this.zdc.zda;
        if (paramDialogInterface != null)
        {
          j.b.a.a(paramDialogInterface, false, null, 14);
          AppMethodBeat.o(289037);
          return;
        }
      }
      AppMethodBeat.o(289037);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(aa.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(281318);
      this.xPG.aaBx = true;
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(281318);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(j paramj) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(282201);
      paramDialogInterface = this.zdc.zda;
      if (paramDialogInterface != null)
      {
        j.b.a.a(paramDialogInterface, false, null, 14);
        AppMethodBeat.o(282201);
        return;
      }
      AppMethodBeat.o(282201);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class h
    implements DialogInterface.OnDismissListener
  {
    h(j paramj, aa.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(283323);
      if (!this.xPG.aaBx)
      {
        paramDialogInterface = this.zdc.zda;
        if (paramDialogInterface != null)
        {
          j.b.a.a(paramDialogInterface, false, null, 14);
          AppMethodBeat.o(283323);
          return;
        }
      }
      AppMethodBeat.o(283323);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static final class i
    implements ae.a
  {
    i(long paramLong, j paramj) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, arr paramarr)
    {
      AppMethodBeat.i(274990);
      kotlin.g.b.p.k(paramarr, "resp");
      if (this.zdd == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          j.a(this.zdc, paramarr);
        }
      }
      for (;;)
      {
        paramString = j.b(this.zdc);
        if (paramString == null) {
          break;
        }
        paramString.end();
        AppMethodBeat.o(274990);
        return;
        w.makeText((Context)this.zdc.getActivity(), b.j.finder_prepare_user_failed, 1).show();
        continue;
        Log.i("Finder.FinderLiveVerifyUIC", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.zdd + ",scene.requestId:" + paramLong);
      }
      AppMethodBeat.o(274990);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class j
    implements f.c
  {
    j(j paramj) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(285474);
      paramString = this.zdc.zda;
      if (paramString != null)
      {
        j.b.a.a(paramString, false, null, 14);
        AppMethodBeat.o(285474);
        return;
      }
      AppMethodBeat.o(285474);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderRealNameVertifyFinishEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class l
    extends IListener<io>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(j paramj, aa.a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(270681);
      this.xPG.aaBx = true;
      j.a(this.zdc);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(22385, new Object[] { Integer.valueOf(6), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(270681);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class n
    implements DialogInterface.OnClickListener
  {
    public static final n zde;
    
    static
    {
      AppMethodBeat.i(264979);
      zde = new n();
      AppMethodBeat.o(264979);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(264978);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.dismiss();
        AppMethodBeat.o(264978);
        return;
      }
      AppMethodBeat.o(264978);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class o
    implements DialogInterface.OnDismissListener
  {
    o(j paramj, aa.a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(232408);
      if (!this.xPG.aaBx)
      {
        paramDialogInterface = this.zdc.zda;
        if (paramDialogInterface != null)
        {
          j.b.a.a(paramDialogInterface, false, null, 14);
          AppMethodBeat.o(232408);
          return;
        }
      }
      AppMethodBeat.o(232408);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.j
 * JD-Core Version:    0.7.0.1
 */