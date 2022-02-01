package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.am;
import com.tencent.mm.plugin.finder.live.model.cgi.am.a;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.utils.bh;
import com.tencent.mm.plugin.finder.utils.bh.a;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "callback", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isVerifyFin", "listener", "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$listener$1", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$listener$1;", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "scene", "", "getScene", "()I", "setScene", "(I)V", "checkAccountValid", "finderUsername", "", "checkLivePermission", "context", "Landroid/app/Activity;", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "getLayoutId", "globalEnable", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "precheckEnable", "userFlag", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "prepare", "privateEnable", "privateFlag", "release", "showErrPage", "type", "showPrecheckPage", "Companion", "LivePostVerifyCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final l.a DZw;
  private bys Bpm;
  private awa Bpn;
  private bkk Bpo;
  private boa Bpp;
  private bh Bpq;
  private boolean Bpt;
  private boolean Bpu;
  private FinderLiveVerifyUIC.listener.1 DZx;
  public b DZy;
  public int scene;
  
  static
  {
    AppMethodBeat.i(356427);
    DZw = new l.a((byte)0);
    AppMethodBeat.o(356427);
  }
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356171);
    this.DZx = new FinderLiveVerifyUIC.listener.1(this, com.tencent.mm.app.f.hfK);
    this.scene = 8;
    AppMethodBeat.o(356171);
  }
  
  private static boolean Oj(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(356317);
    if (!d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "globalEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(356317);
      return bool;
      bool = false;
    }
  }
  
  private static boolean Ok(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(356321);
    if (!d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "privateEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(356321);
      return bool;
      bool = false;
    }
  }
  
  private final void Ol(int paramInt)
  {
    AppMethodBeat.i(356262);
    Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("showErrPage type:", Integer.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    Context localContext = (Context)getActivity();
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsy());
    getActivity().startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(356262);
  }
  
  private static final void a(l paraml, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356381);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml = paraml.DZy;
    if (paraml != null) {
      l.b.a.a(paraml, false, null, 14);
    }
    AppMethodBeat.o(356381);
  }
  
  private static final void a(l paraml, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(356367);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml = paraml.DZy;
    if (paraml != null) {
      l.b.a.a(paraml, false, null, 14);
    }
    AppMethodBeat.o(356367);
  }
  
  private static final void a(ah.a parama, l paraml, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(356357);
    kotlin.g.b.s.u(parama, "$isOkClick");
    kotlin.g.b.s.u(paraml, "this$0");
    if (!parama.aiwY)
    {
      parama = paraml.DZy;
      if (parama != null) {
        l.b.a.a(parama, false, null, 14);
      }
    }
    AppMethodBeat.o(356357);
  }
  
  private static final void a(ah.a parama, l paraml, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356343);
    kotlin.g.b.s.u(parama, "$isOkClick");
    kotlin.g.b.s.u(paraml, "this$0");
    parama.aiwY = true;
    paraml.efm();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(6), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(356343);
  }
  
  private static boolean aw(Activity paramActivity)
  {
    AppMethodBeat.i(356310);
    Log.i("Finder.FinderLiveVerifyUIC", "checkLivePermission()");
    boolean bool = b.a(paramActivity, "android.permission.CAMERA", 16, "");
    if (!bool)
    {
      Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("checkLivePermission() invalid checkCamera:", Boolean.valueOf(bool)));
      AppMethodBeat.o(356310);
      return false;
    }
    bool = b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "");
    if (!bool)
    {
      Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("checkLivePermission() invalid checkMicroPhone:", Boolean.valueOf(bool)));
      AppMethodBeat.o(356310);
      return false;
    }
    AppMethodBeat.o(356310);
    return true;
  }
  
  private final boolean awd(String paramString)
  {
    AppMethodBeat.i(356205);
    Log.i("Finder.FinderLiveVerifyUIC", "checkAccountValid()");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("Finder.FinderLiveVerifyUIC", "checkAccountValid() need create finder contact.");
      paramString = new Intent();
      paramString.putExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 1);
      paramString.putExtra("key_router_to_profile", false);
      ah.a locala = new ah.a();
      com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
      ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a((Activity)getActivity(), 3, paramString, new l..ExternalSyntheticLambda1(locala), new l..ExternalSyntheticLambda0(this), new l..ExternalSyntheticLambda5(locala, this));
      AppMethodBeat.o(356205);
      return false;
    }
    AppMethodBeat.o(356205);
    return true;
  }
  
  private final void awe(String paramString)
  {
    AppMethodBeat.i(356302);
    Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("gotoFaceVerify ", paramString));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 1);
    localIntent.putExtra("FACE_VERIFY_URL", paramString);
    paramString = (Context)getActivity();
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramString, com.tencent.mm.plugin.findersdk.e.a.fsy());
    getActivity().startActivityForResult(localIntent, 10000);
    AppMethodBeat.o(356302);
  }
  
  private final void b(int paramInt, fgq paramfgq)
  {
    AppMethodBeat.i(356276);
    Log.i("Finder.FinderLiveVerifyUIC", "showPrecheckPage userFlag:" + paramInt + " spamRisk:" + paramfgq + ",stack:" + Util.getStack());
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 11);
    localIntent.putExtra("PRECHECK_USERFLAG", paramInt);
    localIntent.putExtra("PRECHECK_SPAMRISK", paramfgq.toByteArray());
    paramfgq = (Context)getContext();
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramfgq, com.tencent.mm.plugin.findersdk.e.a.fsy());
    com.tencent.mm.hellhoundlib.a.a.a(getContext(), c.a(10003, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC", "showPrecheckPage", "(ILcom/tencent/mm/protocal/protobuf/SpamRisk;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(356276);
  }
  
  private static final void b(ah.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356375);
    kotlin.g.b.s.u(parama, "$isOkClick");
    parama.aiwY = true;
    com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(356375);
  }
  
  private static final void b(ah.a parama, l paraml, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(356389);
    kotlin.g.b.s.u(parama, "$isOkClick");
    kotlin.g.b.s.u(paraml, "this$0");
    if (!parama.aiwY)
    {
      parama = paraml.DZy;
      if (parama != null) {
        l.b.a.a(parama, false, null, 14);
      }
    }
    AppMethodBeat.o(356389);
  }
  
  private static boolean c(int paramInt, fgq paramfgq)
  {
    boolean bool4 = true;
    AppMethodBeat.i(356335);
    if (paramfgq == null)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable spamRisk is empty!");
      AppMethodBeat.o(356335);
      return true;
    }
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.euE())
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable canShowPrecheckEntrance:false");
      AppMethodBeat.o(356335);
      return true;
    }
    if (paramfgq.abGu == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable showPage:" + bool1 + " promt:" + paramfgq.abGu + " flag:" + paramInt);
      if (bool1) {
        break;
      }
      AppMethodBeat.o(356335);
      return true;
    }
    paramfgq = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaU, Boolean.FALSE);
    if (paramfgq == null)
    {
      paramfgq = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(356335);
      throw paramfgq;
    }
    boolean bool5 = ((Boolean)paramfgq).booleanValue();
    boolean bool2;
    label196:
    boolean bool3;
    if (!d.ee(paramInt, 4))
    {
      bool1 = true;
      if (d.ee(paramInt, 8)) {
        break label294;
      }
      bool2 = true;
      if (d.ee(paramInt, 16)) {
        break label299;
      }
      bool3 = true;
      label208:
      if ((!bool1) || (!bool2) || (!bool5) || (!bool3)) {
        break label305;
      }
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveVerifyUIC", "precheckEnable haveShowPrecheckPage:" + bool5 + ",realnamePrecheckResult:" + bool1 + ",agePrecheckResult:" + bool2 + ", otherPrecheckResult:" + bool3);
      AppMethodBeat.o(356335);
      return bool4;
      bool1 = false;
      break;
      label294:
      bool2 = false;
      break label196;
      label299:
      bool3 = false;
      break label208;
      label305:
      bool4 = false;
    }
  }
  
  private final boolean efl()
  {
    AppMethodBeat.i(356195);
    if (!NetStatusUtil.isConnected((Context)getActivity()))
    {
      g.a locala = new g.a((Context)getActivity());
      locala.Xdm = true;
      locala.bDE(getActivity().getResources().getString(p.h.Cld)).bDI(getActivity().getResources().getString(p.h.app_i_know)).b(new l..ExternalSyntheticLambda6(this)).show();
      Log.e("Finder.FinderLiveVerifyUIC", "checkNetworkAvailable() network problem");
      AppMethodBeat.o(356195);
      return false;
    }
    AppMethodBeat.o(356195);
    return true;
  }
  
  private final void efm()
  {
    AppMethodBeat.i(356213);
    Log.i("Finder.FinderLiveVerifyUIC", "handleConfirmPostLive");
    bh localbh = this.Bpq;
    if (localbh != null) {
      localbh.end();
    }
    efn();
    efo();
    efp();
    efr();
    AppMethodBeat.o(356213);
  }
  
  private final void efn()
  {
    AppMethodBeat.i(356221);
    if (this.Bpm == null)
    {
      Object localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)localObject, this.scene);
      localObject = this.Bpq;
      if (localObject != null) {
        ((bh)localObject).begin();
      }
    }
    AppMethodBeat.o(356221);
  }
  
  private final void efo()
  {
    AppMethodBeat.i(356229);
    if ((efq()) && (this.Bpp == null))
    {
      com.tencent.mm.kernel.h.aZW().a(5231, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.finder.live.cgi.aa(), 0);
      bh localbh = this.Bpq;
      if (localbh != null) {
        localbh.begin();
      }
    }
    AppMethodBeat.o(356229);
  }
  
  private final void efp()
  {
    AppMethodBeat.i(356250);
    if (this.Bpn == null)
    {
      long l = System.currentTimeMillis();
      Object localObject = bi.ABn;
      new am(bi.dVu(), z.bAW(), l, (am.a)new c(l, this), (byte)0).bFJ();
      localObject = this.Bpq;
      if (localObject != null) {
        ((bh)localObject).begin();
      }
    }
    AppMethodBeat.o(356250);
  }
  
  private static boolean efq()
  {
    AppMethodBeat.i(356241);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaC, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(356241);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("isVerify:", Boolean.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(356241);
    return bool;
  }
  
  private final void efr()
  {
    Object localObject2 = null;
    bip localbip = null;
    AppMethodBeat.i(356293);
    if (!kotlin.g.b.s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      d.uiThread((kotlin.g.a.a)new l.d(this));
      AppMethodBeat.o(356293);
      return;
    }
    Log.i("Finder.FinderLiveVerifyUIC", "gotoLive");
    if (this.Bpu)
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(356293);
      return;
    }
    if (this.Bpm == null)
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(356293);
      return;
    }
    Object localObject1;
    if (efq())
    {
      if (this.Bpp == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
      {
        Log.e("Finder.FinderLiveVerifyUIC", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(356293);
        return;
        localObject1 = this.Bpp;
        kotlin.g.b.s.checkNotNull(localObject1);
        if (!((boa)localObject1).zSb)
        {
          localObject1 = this.Bpp;
          kotlin.g.b.s.checkNotNull(localObject1);
          if (!Util.isNullOrNil(((boa)localObject1).Vpy))
          {
            localObject1 = this.Bpp;
            kotlin.g.b.s.checkNotNull(localObject1);
            localObject2 = ((boa)localObject1).Vpy;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            awe((String)localObject1);
            localObject1 = this.Bpp;
            kotlin.g.b.s.checkNotNull(localObject1);
            Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("gotoLive, is verify:", Boolean.valueOf(((boa)localObject1).zSb)));
            AppMethodBeat.o(356293);
            return;
          }
          com.tencent.mm.ui.base.aa.makeText((Context)getActivity(), (CharSequence)getActivity().getResources().getString(p.h.CoR), 0).show();
          localObject1 = this.Bpp;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((boa)localObject1).Vpy)
          {
            Log.e("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("handleNetSceneFinderLiveVerify() real name Url is empty:", localObject1));
            break;
          }
        }
      }
    }
    if (!aw((Activity)getActivity()))
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive permission is invalid.");
      AppMethodBeat.o(356293);
      return;
    }
    awa localawa = this.Bpn;
    if (localawa == null) {
      localObject1 = localbip;
    }
    while (localObject1 == null)
    {
      Log.e("Finder.FinderLiveVerifyUIC", "gotoLive finderCreateLivePrepareResponse is null.");
      AppMethodBeat.o(356293);
      return;
      localObject1 = aj.CGT;
      if ((aj.elr() == null) && (localawa.ZGo != null))
      {
        localObject1 = localawa.ZGo;
        int i;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label519;
          }
          localObject1 = localawa.ZGo;
          if (localObject1 == null) {
            break label489;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if ((localObject1 == null) || (((bip)localObject1).liveId != 0L)) {
            break label489;
          }
          i = 1;
          label427:
          if (i != 0) {
            break label519;
          }
          localObject1 = localawa.ZGo;
          if (localObject1 != null) {
            break label494;
          }
          localObject1 = localObject2;
        }
        for (;;)
        {
          Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("gotoLive continue live:", localObject1));
          localObject1 = this.DZy;
          if (localObject1 != null) {
            ((b)localObject1).a(true, localawa, true);
          }
          AppMethodBeat.o(356293);
          return;
          localObject1 = ((FinderObject)localObject1).liveInfo;
          break;
          label489:
          i = 0;
          break label427;
          label494:
          localbip = ((FinderObject)localObject1).liveInfo;
          localObject1 = localObject2;
          if (localbip != null) {
            localObject1 = Long.valueOf(localbip.liveId);
          }
        }
      }
      label519:
      if (!Oj(localawa.ZGm))
      {
        Ol(2);
        Log.w("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(localawa.ZGm)));
        AppMethodBeat.o(356293);
        return;
      }
      if (!Ok(localawa.user_flag))
      {
        Ol(2);
        Log.w("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(localawa.user_flag)));
        AppMethodBeat.o(356293);
        return;
      }
      if (!c(localawa.user_flag, localawa.ZGw))
      {
        localObject1 = localawa.ZGw;
        if (localObject1 != null) {
          b(localawa.user_flag, (fgq)localObject1);
        }
        Log.w("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(localawa.user_flag)));
        AppMethodBeat.o(356293);
        return;
      }
      localObject2 = this.DZy;
      localObject1 = localbip;
      if (localObject2 != null)
      {
        l.b.a.a((b)localObject2, true, localawa, 8);
        localObject1 = ah.aiuX;
      }
    }
    this.Bpu = true;
    Log.w("Finder.FinderLiveVerifyUIC", "gotoLive enter live room");
    AppMethodBeat.o(356293);
  }
  
  private final void prepare()
  {
    AppMethodBeat.i(356183);
    Log.i("Finder.FinderLiveVerifyUIC", "prepare()");
    Object localObject1 = z.bAW();
    if (!efl())
    {
      Log.e("Finder.FinderLiveVerifyUIC", "prepare() checkNetworkAvailable failed");
      localObject1 = this.Bpq;
      if (localObject1 != null) {
        ((bh)localObject1).end();
      }
      AppMethodBeat.o(356183);
      return;
    }
    if (!awd((String)localObject1))
    {
      Log.e("Finder.FinderLiveVerifyUIC", "prepare() checkAccountValid failed");
      localObject1 = this.Bpq;
      if (localObject1 != null) {
        ((bh)localObject1).end();
      }
      AppMethodBeat.o(356183);
      return;
    }
    Object localObject2 = this.Bpq;
    if (localObject2 != null) {
      ((bh)localObject2).end();
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(5), Long.valueOf(System.currentTimeMillis()) });
    localObject2 = new ah.a();
    Object localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject3, "service(IFinderCommonService::class.java)");
    localObject3 = (com.tencent.mm.plugin.h)localObject3;
    Context localContext = (Context)getActivity();
    kotlin.g.b.s.s(localObject1, "finderUsername");
    h.a.a((com.tencent.mm.plugin.h)localObject3, localContext, (String)localObject1, new l..ExternalSyntheticLambda2((ah.a)localObject2, this), l..ExternalSyntheticLambda3.INSTANCE, new l..ExternalSyntheticLambda4((ah.a)localObject2, this), false, 32);
    AppMethodBeat.o(356183);
  }
  
  private static final void t(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(356347);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    AppMethodBeat.o(356347);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfU;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(356500);
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    Object localObject;
    if (paramIntent == null)
    {
      localObject = null;
      Log.i("Finder.FinderLiveVerifyUIC", localObject);
    }
    switch (paramInt1)
    {
    default: 
    case 10000: 
    case 10001: 
    case 10002: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(356500);
            return;
            localObject = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));
            break;
            if (paramInt2 == -1)
            {
              if ((paramIntent != null) && (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1)) {}
              for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
              {
                efr();
                AppMethodBeat.o(356500);
                return;
              }
            }
            paramIntent = this.DZy;
          } while (paramIntent == null);
          l.b.a.a(paramIntent, false, null, 14);
          AppMethodBeat.o(356500);
          return;
          paramIntent = this.DZy;
        } while (paramIntent == null);
        l.b.a.a(paramIntent, false, null, 14);
        AppMethodBeat.o(356500);
        return;
        paramIntent = com.tencent.mm.plugin.findersdk.a.l.Hcd;
        if (paramInt2 == com.tencent.mm.plugin.findersdk.a.l.frx())
        {
          efm();
          AppMethodBeat.o(356500);
          return;
        }
        paramIntent = this.DZy;
      } while (paramIntent == null);
      l.b.a.a(paramIntent, false, null, 14);
      AppMethodBeat.o(356500);
      return;
    }
    if (paramIntent == null)
    {
      paramIntent = null;
      label258:
      Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("precheck result:", paramIntent));
      if ((paramInt2 == -1) && (paramIntent != null)) {
        break label314;
      }
    }
    label314:
    while (paramIntent.intValue() != 1)
    {
      paramIntent = this.DZy;
      if (paramIntent == null) {
        break;
      }
      l.b.a.a(paramIntent, false, null, 14);
      break;
      paramIntent = Integer.valueOf(paramIntent.getIntExtra("PRECHECK_RESULT", 0));
      break label258;
    }
    efr();
    AppMethodBeat.o(356500);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356485);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    paramBundle = bh.GlM;
    this.Bpq = bh.a.a((Context)getActivity(), getActivity().getResources().getString(p.h.finder_waiting), 1000L, 8);
    paramBundle = this.Bpq;
    if (paramBundle != null) {
      paramBundle.begin();
    }
    this.DZx.alive();
    prepare();
    AppMethodBeat.o(356485);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(356525);
    super.onDestroy();
    this.DZx.dead();
    com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    this.Bpm = null;
    this.Bpn = null;
    this.Bpo = null;
    this.Bpp = null;
    AppMethodBeat.o(356525);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(356508);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(356508);
      return;
      if (paramArrayOfInt.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label104;
        }
      }
      label104:
      for (int i = j;; i = 0)
      {
        if ((i == 0) || (paramArrayOfInt[0] != 0)) {
          break label110;
        }
        efr();
        AppMethodBeat.o(356508);
        return;
        i = 0;
        break;
      }
      label110:
      Log.i("Finder.FinderLiveVerifyUIC", "FinderLive request permission " + paramInt + " failed");
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(356520);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Object localObject;
    if (paramp == null)
    {
      localObject = null;
      Log.i("Finder.FinderLiveVerifyUIC", localObject + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramp instanceof com.tencent.mm.plugin.finder.live.cgi.aa)) {
        break label348;
      }
      paramString = (Context)getActivity();
      paramp = (com.tencent.mm.plugin.finder.live.cgi.aa)paramp;
      Log.i("Finder.FinderLiveVerifyUIC", "handleNetSceneFinderLiveVerify()");
      com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label203;
      }
      this.Bpp = paramp.ehq();
      efr();
      paramString = this.Bpp;
      kotlin.g.b.s.checkNotNull(paramString);
      Log.i("Finder.FinderLiveVerifyUIC", kotlin.g.b.s.X("handleNetSceneFinderLiveVerify() is verify:", Boolean.valueOf(paramString.zSb)));
    }
    for (;;)
    {
      paramString = this.Bpq;
      if (paramString != null) {
        paramString.end();
      }
      AppMethodBeat.o(356520);
      return;
      localObject = Integer.valueOf(paramp.getType());
      break;
      switch (paramInt2)
      {
      case -200017: 
      case -200016: 
      case -200015: 
      case -200014: 
      case -200013: 
      default: 
        com.tencent.mm.ui.base.aa.makeText(paramString, (CharSequence)paramString.getResources().getString(p.h.CjO), 0).show();
        break;
      case -200009: 
        com.tencent.mm.ui.base.aa.makeText(paramString, (CharSequence)paramString.getResources().getString(p.h.Cip), 0).show();
        break;
      case -200010: 
        com.tencent.mm.ui.base.aa.makeText(paramString, (CharSequence)paramString.getResources().getString(p.h.Cic), 0).show();
        break;
      case -200011: 
        Ol(3);
        break;
      case -200018: 
      case -200012: 
        label203:
        Ol(2);
      }
    }
    label348:
    if ((paramp instanceof bl))
    {
      if (this.Bpt)
      {
        paramString = this.Bpq;
        if (paramString != null) {
          paramString.end();
        }
        this.Bpt = false;
        prepare();
        AppMethodBeat.o(356520);
        return;
      }
      paramString = (Context)getActivity();
      paramp = (bl)paramp;
      Log.i("Finder.FinderLiveVerifyUIC", "handleNetSceneFinderPrepareUser()");
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label458;
      }
      this.Bpm = paramp.dVy();
      efr();
    }
    for (;;)
    {
      paramString = this.Bpq;
      if (paramString != null) {
        paramString.end();
      }
      AppMethodBeat.o(356520);
      return;
      label458:
      com.tencent.mm.ui.base.aa.makeText(paramString, p.h.finder_prepare_user_failed, 1).show();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$LivePostVerifyCallback;", "", "onVerified", "", "result", "", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "needContinueLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean1, awa paramawa, boolean paramBoolean2);
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVerifyUIC$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements am.a
  {
    c(long paramLong, l paraml) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, awa paramawa)
    {
      AppMethodBeat.i(356122);
      kotlin.g.b.s.u(paramawa, "resp");
      if (this.CEB == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          l.a(this.DZz, paramawa);
        }
      }
      for (;;)
      {
        paramString = l.b(this.DZz);
        if (paramString != null) {
          paramString.end();
        }
        AppMethodBeat.o(356122);
        return;
        com.tencent.mm.ui.base.aa.makeText((Context)this.DZz.getActivity(), p.h.finder_prepare_user_failed, 1).show();
        continue;
        Log.i("Finder.FinderLiveVerifyUIC", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.CEB + ",scene.requestId:" + paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.l
 * JD-Core Version:    0.7.0.1
 */