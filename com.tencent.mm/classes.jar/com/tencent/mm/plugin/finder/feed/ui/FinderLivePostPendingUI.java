package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ji;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.am;
import com.tencent.mm.plugin.finder.live.model.cgi.am.a;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.bh;
import com.tencent.mm.plugin.finder.utils.bh.a;
import com.tencent.mm.plugin.findersdk.a.c;
import com.tencent.mm.plugin.findersdk.a.l;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.e;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "activity", "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI;", "setActivity", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isVerifyFin", "()Z", "setVerifyFin", "(Z)V", "listener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderRealNameVertifyFinishEvent;", "getListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "outSizeTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "roomId", "", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "checkAccountValid", "finderUsername", "checkLivePermission", "context", "Landroid/app/Activity;", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "getLayoutId", "", "getReportTag", "globalEnable", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePostPendingUI
  extends MMFinderUI
  implements com.tencent.mm.am.h
{
  public static final FinderLivePostPendingUI.a Bpl;
  private bys Bpm;
  private awa Bpn;
  private bkk Bpo;
  private boa Bpp;
  private bh Bpq;
  private bno Bpr;
  FinderLivePostPendingUI Bps;
  boolean Bpt;
  private boolean Bpu;
  private IListener<ji> lsH;
  private String roomId;
  
  static
  {
    AppMethodBeat.i(364682);
    Bpl = new FinderLivePostPendingUI.a((byte)0);
    AppMethodBeat.o(364682);
  }
  
  public FinderLivePostPendingUI()
  {
    AppMethodBeat.i(364450);
    this.Bps = this;
    this.roomId = "";
    this.lsH = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    AppMethodBeat.o(364450);
  }
  
  private static boolean Oj(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(364545);
    if (!com.tencent.mm.ae.d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostPendingUI", "globalEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(364545);
      return bool;
      bool = false;
    }
  }
  
  private static boolean Ok(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(364554);
    if (!com.tencent.mm.ae.d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostPendingUI", "privateEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(364554);
      return bool;
      bool = false;
    }
  }
  
  private final void Ol(int paramInt)
  {
    AppMethodBeat.i(364600);
    Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("showErrPage type:", Integer.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    localIntent.setClass((Context)this.Bps, a.c.class);
    this.Bps.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(364600);
  }
  
  private static final void a(FinderLivePostPendingUI paramFinderLivePostPendingUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(364652);
    kotlin.g.b.s.u(paramFinderLivePostPendingUI, "this$0");
    paramFinderLivePostPendingUI.Bps.finish();
    AppMethodBeat.o(364652);
  }
  
  private static final void a(FinderLivePostPendingUI paramFinderLivePostPendingUI, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(364637);
    kotlin.g.b.s.u(paramFinderLivePostPendingUI, "this$0");
    paramFinderLivePostPendingUI.Bps.finish();
    AppMethodBeat.o(364637);
  }
  
  private static final void a(ah.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(364644);
    kotlin.g.b.s.u(parama, "$isOkClick");
    parama.aiwY = true;
    com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(364644);
  }
  
  private static final void a(ah.a parama, FinderLivePostPendingUI paramFinderLivePostPendingUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(364626);
    kotlin.g.b.s.u(parama, "$isOkClick");
    kotlin.g.b.s.u(paramFinderLivePostPendingUI, "this$0");
    if (!parama.aiwY) {
      paramFinderLivePostPendingUI.Bps.finish();
    }
    AppMethodBeat.o(364626);
  }
  
  private static final void a(ah.a parama, FinderLivePostPendingUI paramFinderLivePostPendingUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(364614);
    kotlin.g.b.s.u(parama, "$isOkClick");
    kotlin.g.b.s.u(paramFinderLivePostPendingUI, "this$0");
    parama.aiwY = true;
    paramFinderLivePostPendingUI.efm();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(6), Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(364614);
  }
  
  private static final boolean a(FinderLivePostPendingUI paramFinderLivePostPendingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364606);
    kotlin.g.b.s.u(paramFinderLivePostPendingUI, "this$0");
    paramFinderLivePostPendingUI.finish();
    AppMethodBeat.o(364606);
    return true;
  }
  
  private static boolean aw(Activity paramActivity)
  {
    AppMethodBeat.i(364582);
    Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission()");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.CAMERA", 16, "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("checkLivePermission() invalid checkCamera:", Boolean.valueOf(bool)));
      AppMethodBeat.o(364582);
      return false;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("checkLivePermission() invalid checkMicroPhone:", Boolean.valueOf(bool)));
      AppMethodBeat.o(364582);
      return false;
    }
    AppMethodBeat.o(364582);
    return true;
  }
  
  private final boolean awd(String paramString)
  {
    AppMethodBeat.i(364485);
    Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid()");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid() need create finder contact.");
      paramString = new Intent();
      paramString.putExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 1);
      paramString.putExtra("key_router_to_profile", false);
      ah.a locala = new ah.a();
      com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
      ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a((Activity)this.Bps, 9, paramString, new FinderLivePostPendingUI..ExternalSyntheticLambda1(locala), new FinderLivePostPendingUI..ExternalSyntheticLambda0(this), new FinderLivePostPendingUI..ExternalSyntheticLambda4(locala, this));
      AppMethodBeat.o(364485);
      return false;
    }
    AppMethodBeat.o(364485);
    return true;
  }
  
  private final void awe(String paramString)
  {
    AppMethodBeat.i(364593);
    Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("gotoFaceVerify ", paramString));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 1);
    localIntent.putExtra("FACE_VERIFY_URL", paramString);
    localIntent.setClass((Context)this.Bps, a.c.class);
    this.Bps.startActivityForResult(localIntent, 10000);
    AppMethodBeat.o(364593);
  }
  
  private static final void b(ah.a parama, FinderLivePostPendingUI paramFinderLivePostPendingUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(364658);
    kotlin.g.b.s.u(parama, "$isOkClick");
    kotlin.g.b.s.u(paramFinderLivePostPendingUI, "this$0");
    if (!parama.aiwY) {
      paramFinderLivePostPendingUI.Bps.finish();
    }
    AppMethodBeat.o(364658);
  }
  
  private final boolean efl()
  {
    AppMethodBeat.i(364474);
    if (!NetStatusUtil.isConnected((Context)this.Bps))
    {
      g.a locala = new g.a((Context)this.Bps);
      locala.Xdm = true;
      locala.bDE(this.Bps.getResources().getString(p.h.Cld)).bDI(this.Bps.getResources().getString(p.h.app_i_know)).b(new FinderLivePostPendingUI..ExternalSyntheticLambda7(this)).show();
      Log.e("Finder.FinderLivePostPendingUI", "checkNetworkAvailable() network problem");
      AppMethodBeat.o(364474);
      return false;
    }
    AppMethodBeat.o(364474);
    return true;
  }
  
  private final void efm()
  {
    AppMethodBeat.i(364493);
    Log.i("Finder.FinderLivePostPendingUI", "handleConfirmPostLive");
    bh localbh = this.Bpq;
    if (localbh != null) {
      localbh.end();
    }
    efn();
    efo();
    efp();
    efr();
    AppMethodBeat.o(364493);
  }
  
  private final void efn()
  {
    AppMethodBeat.i(364502);
    if (this.Bpm == null)
    {
      com.tencent.mm.kernel.h.aZW().a((p)((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUn(), 0);
      bh localbh = this.Bpq;
      if (localbh != null) {
        localbh.begin();
      }
    }
    AppMethodBeat.o(364502);
  }
  
  private final void efo()
  {
    AppMethodBeat.i(364512);
    if ((efq()) && (this.Bpp == null))
    {
      com.tencent.mm.kernel.h.aZW().a(5231, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.finder.live.cgi.aa(), 0);
      bh localbh = this.Bpq;
      if (localbh != null) {
        localbh.begin();
      }
    }
    AppMethodBeat.o(364512);
  }
  
  private final void efp()
  {
    AppMethodBeat.i(364524);
    if (this.Bpn == null)
    {
      Object localObject = new ah.e();
      ((ah.e)localObject).aixc = System.currentTimeMillis();
      bi localbi = bi.ABn;
      new am(bi.dVu(), z.bAW(), ((ah.e)localObject).aixc, (am.a)new b((ah.e)localObject, this), (byte)0).bFJ().a((com.tencent.mm.vending.e.b)this.Bps);
      localObject = this.Bpq;
      if (localObject != null) {
        ((bh)localObject).begin();
      }
    }
    AppMethodBeat.o(364524);
  }
  
  private static boolean efq()
  {
    AppMethodBeat.i(364536);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaC, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(364536);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("isVerify:", Boolean.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(364536);
    return bool;
  }
  
  private final void efr()
  {
    AppMethodBeat.i(364573);
    if (!kotlin.g.b.s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new FinderLivePostPendingUI.c(this));
      AppMethodBeat.o(364573);
      return;
    }
    Log.i("Finder.FinderLivePostPendingUI", "gotoLive");
    if (this.Bpu)
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(364573);
      return;
    }
    if (this.Bpm == null)
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(364573);
      return;
    }
    Object localObject4 = this.Bpn;
    if (localObject4 == null) {}
    label203:
    label222:
    Object localObject2;
    label364:
    Object localObject3;
    for (Object localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderCreateLivePrepareResponse is null.");
      AppMethodBeat.o(364573);
      return;
      localObject1 = aj.CGT;
      if ((aj.elr() == null) && (((awa)localObject4).ZGo != null))
      {
        localObject1 = ((awa)localObject4).ZGo;
        int i;
        Intent localIntent;
        com.tencent.mm.plugin.f localf;
        Object localObject5;
        long l;
        bip localbip;
        bkk localbkk;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label561;
          }
          localObject1 = ((awa)localObject4).ZGo;
          if (localObject1 == null) {
            break label492;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if ((localObject1 == null) || (((bip)localObject1).liveId != 0L)) {
            break label492;
          }
          i = 1;
          if (i != 0) {
            break label561;
          }
          localObject1 = ((awa)localObject4).ZGo;
          if (localObject1 != null) {
            break label497;
          }
          localObject1 = null;
          Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("gotoLive continue live:", localObject1));
          localIntent = new Intent();
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(this.roomId);
          localObject2 = ah.aiuX;
          localIntent.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", (ArrayList)localObject1);
          localObject2 = this.Bpr;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = null;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = ((awa)localObject4).ZGq;
          }
          localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
          localObject5 = this.Bps;
          localObject1 = ((awa)localObject4).ZGo;
          kotlin.g.b.s.checkNotNull(localObject1);
          l = ((FinderObject)localObject1).id;
          localObject1 = ((awa)localObject4).ZGo;
          if (localObject1 != null) {
            break label528;
          }
          localObject1 = "";
          localObject3 = ((awa)localObject4).ZGo;
          kotlin.g.b.s.checkNotNull(localObject3);
          localbip = ((FinderObject)localObject3).liveInfo;
          kotlin.g.b.s.checkNotNull(localbip);
          localbkk = this.Bpo;
          localObject3 = ((awa)localObject4).ZGo;
          if (localObject3 != null) {
            break label551;
          }
        }
        label528:
        label551:
        for (localObject3 = null;; localObject3 = ((FinderObject)localObject3).sessionBuffer)
        {
          LinkedList localLinkedList = ((awa)localObject4).ZGp;
          localObject4 = ((awa)localObject4).ZGr;
          kotlin.g.b.s.s(localf, "service(IActivityRouter::class.java)");
          localObject5 = (Context)localObject5;
          kotlin.g.b.s.s(localbip, "!!");
          f.a.a(localf, (Context)localObject5, l, (String)localObject1, localbip, localbkk, null, localLinkedList, (bno)localObject2, null, (String)localObject3, (LinkedList)localObject4, localIntent, 592);
          AppMethodBeat.o(364573);
          return;
          localObject1 = ((FinderObject)localObject1).liveInfo;
          break;
          label492:
          i = 0;
          break label203;
          label497:
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label222;
          }
          localObject1 = Long.valueOf(((bip)localObject1).liveId);
          break label222;
          localObject3 = ((FinderObject)localObject1).objectNonceId;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label364;
          }
          localObject1 = "";
          break label364;
        }
      }
      label561:
      if (!Oj(((awa)localObject4).ZGm))
      {
        Ol(2);
        Log.w("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(((awa)localObject4).ZGm)));
        AppMethodBeat.o(364573);
        return;
      }
      if (!Ok(((awa)localObject4).user_flag))
      {
        Ol(2);
        Log.w("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(((awa)localObject4).user_flag)));
        AppMethodBeat.o(364573);
        return;
      }
    }
    if (efq())
    {
      if (this.Bpp == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
      {
        Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(364573);
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
            Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("gotoLive, is verify:", Boolean.valueOf(((boa)localObject1).zSb)));
            AppMethodBeat.o(364573);
            return;
          }
          com.tencent.mm.ui.base.aa.makeText((Context)this.Bps, (CharSequence)this.Bps.getResources().getString(p.h.CoR), 0).show();
          localObject1 = this.Bpp;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((boa)localObject1).Vpy)
          {
            Log.e("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("handleNetSceneFinderLiveVerify() real name Url is empty:", localObject1));
            break;
          }
        }
      }
    }
    if (!aw((Activity)this.Bps))
    {
      Log.e("Finder.FinderLivePostPendingUI", "gotoLive permission is invalid.");
      AppMethodBeat.o(364573);
      return;
    }
    localObject4 = this.Bpn;
    if (localObject4 != null)
    {
      localObject3 = new Intent();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(this.roomId);
      localObject2 = ah.aiuX;
      ((Intent)localObject3).putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", (ArrayList)localObject1);
      localObject2 = this.Bpr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((awa)localObject4).ZGq;
      }
      localObject1 = this.Bpn;
      if (localObject1 != null) {
        ((awa)localObject1).ZGq = ((bno)localObject2);
      }
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
      f.a.a((com.tencent.mm.plugin.f)localObject1, (Context)this.Bps, this.Bpn, (Intent)localObject3, 8);
    }
    this.Bpu = true;
    Log.w("Finder.FinderLivePostPendingUI", "gotoLive 进入直播间.");
    finish();
    AppMethodBeat.o(364573);
  }
  
  private static final void n(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(364619);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    AppMethodBeat.o(364619);
  }
  
  private void prepare()
  {
    AppMethodBeat.i(364465);
    Log.i("Finder.FinderLivePostPendingUI", "prepare()");
    Object localObject1 = z.bAW();
    if (!efl())
    {
      Log.e("Finder.FinderLivePostPendingUI", "prepare() checkNetworkAvailable failed");
      localObject1 = this.Bpq;
      if (localObject1 != null) {
        ((bh)localObject1).end();
      }
      AppMethodBeat.o(364465);
      return;
    }
    if (!awd((String)localObject1))
    {
      Log.e("Finder.FinderLivePostPendingUI", "prepare() checkAccountValid failed");
      localObject1 = this.Bpq;
      if (localObject1 != null) {
        ((bh)localObject1).end();
      }
      AppMethodBeat.o(364465);
      return;
    }
    if (kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.adgk, Integer.valueOf(0)), Integer.valueOf(0)))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgk, Integer.valueOf(1));
      Object localObject2 = this.Bpq;
      if (localObject2 != null) {
        ((bh)localObject2).end();
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(22385, new Object[] { Integer.valueOf(5), Long.valueOf(System.currentTimeMillis()) });
      localObject2 = new ah.a();
      Object localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject3, "service(IFinderCommonService::class.java)");
      localObject3 = (com.tencent.mm.plugin.h)localObject3;
      Context localContext = (Context)this.Bps;
      kotlin.g.b.s.s(localObject1, "finderUsername");
      h.a.a((com.tencent.mm.plugin.h)localObject3, localContext, (String)localObject1, new FinderLivePostPendingUI..ExternalSyntheticLambda2((ah.a)localObject2, this), FinderLivePostPendingUI..ExternalSyntheticLambda3.INSTANCE, new FinderLivePostPendingUI..ExternalSyntheticLambda5((ah.a)localObject2, this), false, 32);
      AppMethodBeat.o(364465);
      return;
    }
    efm();
    AppMethodBeat.o(364465);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "Finder.FinderLivePostPendingUI";
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(364755);
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    Object localObject;
    if (paramIntent == null)
    {
      localObject = null;
      Log.i("Finder.FinderLivePostPendingUI", localObject);
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(364755);
      return;
      localObject = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));
      break;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1)) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          efr();
          AppMethodBeat.o(364755);
          return;
        }
        AppMethodBeat.o(364755);
        return;
        paramIntent = l.Hcd;
        if (paramInt2 == l.frx())
        {
          efm();
          AppMethodBeat.o(364755);
          return;
        }
        this.Bps.finish();
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364746);
    setTheme(p.i.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    paramBundle = bh.GlM;
    this.Bpq = bh.a.a((Context)this.Bps, this.Bps.getResources().getString(p.h.finder_waiting), 1000L, 8);
    paramBundle = this.Bpq;
    if (paramBundle != null) {
      paramBundle.begin();
    }
    setBackBtn(new FinderLivePostPendingUI..ExternalSyntheticLambda6(this));
    this.lsH.alive();
    Object localObject = getIntent().getStringExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.roomId = paramBundle;
    paramBundle = getIntent().getByteArrayExtra("KEY_TAG_INFO");
    if (paramBundle != null)
    {
      this.Bpr = new bno();
      localObject = this.Bpr;
      kotlin.g.b.s.checkNotNull(localObject);
      ((bno)localObject).parseFrom(paramBundle);
    }
    Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("roomId ", this.roomId));
    prepare();
    AppMethodBeat.o(364746);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364772);
    super.onDestroy();
    this.lsH.dead();
    Log.i("Finder.FinderLivePostPendingUI", "release()");
    Log.i("Finder.FinderLivePostPendingUI", "reset()");
    this.Bpu = false;
    bh localbh = this.Bpq;
    if (localbh != null) {
      localbh.GlN = 0;
    }
    com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    this.Bpm = null;
    this.Bpn = null;
    this.Bpo = null;
    this.Bpp = null;
    AppMethodBeat.o(364772);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(364763);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(364763);
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
        AppMethodBeat.o(364763);
        return;
        i = 0;
        break;
      }
      label110:
      Log.i("Finder.FinderLivePostPendingUI", "FinderLive request permission " + paramInt + " failed");
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(364785);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Object localObject;
    if (paramp == null)
    {
      localObject = null;
      Log.i("Finder.FinderLivePostPendingUI", localObject + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramp instanceof com.tencent.mm.plugin.finder.live.cgi.aa)) {
        break label348;
      }
      paramString = (Context)this.Bps;
      paramp = (com.tencent.mm.plugin.finder.live.cgi.aa)paramp;
      Log.i("Finder.FinderLivePostPendingUI", "handleNetSceneFinderLiveVerify()");
      com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label203;
      }
      this.Bpp = paramp.ehq();
      efr();
      paramString = this.Bpp;
      kotlin.g.b.s.checkNotNull(paramString);
      Log.i("Finder.FinderLivePostPendingUI", kotlin.g.b.s.X("handleNetSceneFinderLiveVerify() is verify:", Boolean.valueOf(paramString.zSb)));
    }
    for (;;)
    {
      paramString = this.Bpq;
      if (paramString != null) {
        paramString.end();
      }
      AppMethodBeat.o(364785);
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
        AppMethodBeat.o(364785);
        return;
      }
      paramString = (Context)this.Bps;
      paramp = (bl)paramp;
      Log.i("Finder.FinderLivePostPendingUI", "handleNetSceneFinderPrepareUser()");
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
      AppMethodBeat.o(364785);
      return;
      label458:
      com.tencent.mm.ui.base.aa.makeText(paramString, p.h.finder_prepare_user_failed, 1).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLivePostPendingUI$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements am.a
  {
    b(ah.e parame, FinderLivePostPendingUI paramFinderLivePostPendingUI) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, awa paramawa)
    {
      AppMethodBeat.i(365172);
      kotlin.g.b.s.u(paramawa, "resp");
      if (this.Bpv.aixc == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          FinderLivePostPendingUI.a(jdField_this, paramawa);
        }
      }
      for (;;)
      {
        paramString = FinderLivePostPendingUI.b(jdField_this);
        if (paramString != null) {
          paramString.end();
        }
        AppMethodBeat.o(365172);
        return;
        com.tencent.mm.ui.base.aa.makeText((Context)jdField_this.Bps, p.h.finder_prepare_user_failed, 1).show();
        continue;
        Log.i("Finder.FinderLivePostPendingUI", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.Bpv.aixc + ",scene.requestId:" + paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLivePostPendingUI
 * JD-Core Version:    0.7.0.1
 */