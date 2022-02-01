package com.tencent.mm.plugin.finder.live.ui.livepost;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.cgi.am;
import com.tencent.mm.plugin.finder.live.model.cgi.am.a;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.av;
import com.tencent.mm.plugin.finder.live.report.q.bd;
import com.tencent.mm.plugin.finder.live.report.q.bf;
import com.tencent.mm.plugin.finder.utils.bh;
import com.tencent.mm.plugin.finder.utils.bh.a;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.e;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostForNearby;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveCreateNoticeHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLiveCreateNoticeHelper;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isRequestCreateNotice", "isRequestGotoLive", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "checkAccountValid", "finderUsername", "", "checkLivePermission", "context", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "globalEnable", "globalFlag", "", "gotoCreateNotice", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmCreateNotice", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preCheckEnable", "userFlag", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "showPrecheckPage", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.am.h
{
  public static final a DHX;
  private bys Bpm;
  private awa Bpn;
  private bkk Bpo;
  private boa Bpp;
  private bh Bpq;
  private boolean Bpu;
  private a DHY;
  private boolean DHZ;
  private boolean DIa;
  private final Activity activity;
  
  static
  {
    AppMethodBeat.i(352635);
    DHX = new a((byte)0);
    AppMethodBeat.o(352635);
  }
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(352424);
    this.activity = paramActivity;
    paramActivity = bh.GlM;
    this.Bpq = bh.a.a((Context)this.activity, this.activity.getResources().getString(p.h.finder_waiting), 500L, 8);
    AppMethodBeat.o(352424);
  }
  
  private static boolean Oj(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(352473);
    if (!d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostForNearby", "globalEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(352473);
      return bool;
      bool = false;
    }
  }
  
  private static boolean Ok(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(352481);
    if (!d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostForNearby", "privateEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(352481);
      return bool;
      bool = false;
    }
  }
  
  private final void Ol(int paramInt)
  {
    AppMethodBeat.i(352554);
    Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("showErrPage type:", Integer.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    Context localContext = (Context)this.activity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsy());
    com.tencent.mm.hellhoundlib.a.a.a(this.activity, c.a(10001, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby", "showErrPage", "(I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(352554);
  }
  
  private static final void T(boolean paramBoolean, String paramString) {}
  
  private static final void a(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(371295);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.efm();
    j.Dob.a(q.bd.DAE);
    AppMethodBeat.o(371295);
  }
  
  private static boolean a(int paramInt, fgq paramfgq)
  {
    boolean bool4 = true;
    AppMethodBeat.i(352493);
    if (paramfgq == null)
    {
      Log.i("Finder.FinderLivePostForNearby", "preCheckEnable spamRisk is empty!");
      AppMethodBeat.o(352493);
      return true;
    }
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.euE())
    {
      Log.i("Finder.FinderLivePostForNearby", "preCheckEnable canShowPrecheckEntrance:false");
      AppMethodBeat.o(352493);
      return true;
    }
    if (paramfgq.abGu == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.FinderLivePostForNearby", "preCheckEnable showPage:" + bool1 + " promt:" + paramfgq.abGu + " flag:" + paramInt);
      if (bool1) {
        break;
      }
      AppMethodBeat.o(352493);
      return true;
    }
    paramfgq = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaU, Boolean.FALSE);
    if (paramfgq == null)
    {
      paramfgq = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(352493);
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
      Log.i("Finder.FinderLivePostForNearby", "preCheckEnable haveShowPrecheckPage:" + bool5 + ",realnamePrecheckResult:" + bool1 + ",agePrecheckResult:" + bool2 + ", otherPrecheckResult:" + bool3);
      AppMethodBeat.o(352493);
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
  
  private static boolean aw(Activity paramActivity)
  {
    AppMethodBeat.i(352531);
    Log.i("Finder.FinderLivePostForNearby", "checkLivePermission()");
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.CAMERA", 16, "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("checkLivePermission() invalid checkCamera:", Boolean.valueOf(bool)));
      AppMethodBeat.o(352531);
      return false;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("checkLivePermission() invalid checkMicroPhone:", Boolean.valueOf(bool)));
      AppMethodBeat.o(352531);
      return false;
    }
    AppMethodBeat.o(352531);
    return true;
  }
  
  private final void awe(String paramString)
  {
    AppMethodBeat.i(352541);
    Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("gotoFaceVerify ", paramString));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 1);
    localIntent.putExtra("FACE_VERIFY_URL", paramString);
    paramString = (Context)this.activity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramString, com.tencent.mm.plugin.findersdk.e.a.fsy());
    com.tencent.mm.hellhoundlib.a.a.a(this.activity, c.a(10000, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby", "gotoFaceVerify", "(Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(352541);
  }
  
  private final void b(int paramInt, fgq paramfgq)
  {
    AppMethodBeat.i(352566);
    Log.i("Finder.FinderLivePostForNearby", "showPrecheckPage userFlag:" + paramInt + " spamRisk:" + paramfgq);
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 11);
    localIntent.putExtra("PRECHECK_USERFLAG", paramInt);
    localIntent.putExtra("PRECHECK_SPAMRISK", paramfgq.toByteArray());
    paramfgq = (Context)this.activity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramfgq, com.tencent.mm.plugin.findersdk.e.a.fsy());
    com.tencent.mm.hellhoundlib.a.a.a(this.activity, c.a(10001, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby", "showPrecheckPage", "(ILcom/tencent/mm/protocal/protobuf/SpamRisk;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(352566);
  }
  
  private static final void b(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(371297);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.efm();
    j.Dob.a(q.bd.DAE);
    AppMethodBeat.o(371297);
  }
  
  private final void efm()
  {
    AppMethodBeat.i(352455);
    Log.i("Finder.FinderLivePostForNearby", "handleConfirmPostLive");
    Object localObject;
    if (this.Bpm == null)
    {
      com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)localObject, 8);
      localObject = this.Bpq;
      if (localObject != null) {
        ((bh)localObject).begin();
      }
    }
    if ((efq()) && (this.Bpp == null))
    {
      com.tencent.mm.kernel.h.aZW().a(5231, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a((p)new com.tencent.mm.plugin.finder.live.cgi.aa(), 0);
      localObject = this.Bpq;
      if (localObject != null) {
        ((bh)localObject).begin();
      }
    }
    if (this.Bpn == null)
    {
      localObject = new ah.e();
      ((ah.e)localObject).aixc = System.currentTimeMillis();
      bi localbi = bi.ABn;
      new am(bi.dVu(), z.bAW(), ((ah.e)localObject).aixc, (am.a)new b((ah.e)localObject, this), (byte)0).bFJ();
      localObject = this.Bpq;
      if (localObject != null) {
        ((bh)localObject).begin();
      }
    }
    efr();
    AppMethodBeat.o(352455);
  }
  
  private static boolean efq()
  {
    AppMethodBeat.i(352462);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaC, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(352462);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("isVerify:", Boolean.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(352462);
    return bool;
  }
  
  private final void efr()
  {
    AppMethodBeat.i(352521);
    if (!kotlin.g.b.s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      d.uiThread((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(352521);
      return;
    }
    Log.i("Finder.FinderLivePostForNearby", "gotoLive");
    if (this.Bpu)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(352521);
      return;
    }
    if (this.Bpm == null)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(352521);
      return;
    }
    Object localObject3 = this.Bpn;
    if (localObject3 == null) {}
    label213:
    label232:
    Object localObject2;
    for (Object localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive finderCreateLivePrepareResponse is null.");
      this.DIa = true;
      AppMethodBeat.o(352521);
      return;
      this.DIa = false;
      localObject1 = aj.CGT;
      if ((aj.elr() == null) && (((awa)localObject3).ZGo != null))
      {
        localObject1 = ((awa)localObject3).ZGo;
        int i;
        com.tencent.mm.plugin.f localf;
        Object localObject4;
        long l;
        label297:
        bip localbip;
        bkk localbkk;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label501;
          }
          localObject1 = ((awa)localObject3).ZGo;
          if (localObject1 == null) {
            break label431;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if ((localObject1 == null) || (((bip)localObject1).liveId != 0L)) {
            break label431;
          }
          i = 1;
          if (i != 0) {
            break label501;
          }
          localObject1 = ((awa)localObject3).ZGo;
          if (localObject1 != null) {
            break label436;
          }
          localObject1 = null;
          Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("gotoLive continue live:", localObject1));
          localf = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
          localObject4 = this.activity;
          localObject1 = ((awa)localObject3).ZGo;
          kotlin.g.b.s.checkNotNull(localObject1);
          l = ((FinderObject)localObject1).id;
          localObject1 = ((awa)localObject3).ZGo;
          if (localObject1 != null) {
            break label467;
          }
          localObject1 = "";
          localObject2 = ((awa)localObject3).ZGo;
          kotlin.g.b.s.checkNotNull(localObject2);
          localbip = ((FinderObject)localObject2).liveInfo;
          kotlin.g.b.s.checkNotNull(localbip);
          localbkk = this.Bpo;
          localObject2 = ((awa)localObject3).ZGo;
          if (localObject2 != null) {
            break label491;
          }
        }
        label431:
        label436:
        label467:
        label491:
        for (localObject2 = null;; localObject2 = ((FinderObject)localObject2).sessionBuffer)
        {
          LinkedList localLinkedList = ((awa)localObject3).ZGp;
          bno localbno = ((awa)localObject3).ZGq;
          localObject3 = ((awa)localObject3).ZGr;
          kotlin.g.b.s.s(localf, "service(IActivityRouter::class.java)");
          localObject4 = (Context)localObject4;
          kotlin.g.b.s.s(localbip, "!!");
          f.a.a(localf, (Context)localObject4, l, (String)localObject1, localbip, localbkk, null, localLinkedList, localbno, null, (String)localObject2, (LinkedList)localObject3, null, 4688);
          AppMethodBeat.o(352521);
          return;
          localObject1 = ((FinderObject)localObject1).liveInfo;
          break;
          i = 0;
          break label213;
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label232;
          }
          localObject1 = Long.valueOf(((bip)localObject1).liveId);
          break label232;
          localObject2 = ((FinderObject)localObject1).objectNonceId;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label297;
          }
          localObject1 = "";
          break label297;
        }
      }
      label501:
      if (!Oj(((awa)localObject3).ZGm))
      {
        Ol(2);
        Log.w("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(((awa)localObject3).ZGm)));
        AppMethodBeat.o(352521);
        return;
      }
      if (!Ok(((awa)localObject3).user_flag))
      {
        Ol(2);
        Log.w("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("gotoLive type:", Integer.valueOf(((awa)localObject3).user_flag)));
        AppMethodBeat.o(352521);
        return;
      }
      if (!a(((awa)localObject3).user_flag, ((awa)localObject3).ZGw))
      {
        localObject1 = ((awa)localObject3).ZGw;
        if (localObject1 != null) {
          b(((awa)localObject3).user_flag, (fgq)localObject1);
        }
        AppMethodBeat.o(352521);
        return;
      }
    }
    if (efq())
    {
      if (this.Bpp == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ah.aiuX)
      {
        Log.e("Finder.FinderLivePostForNearby", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(352521);
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
            Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("gotoLive, is verify:", Boolean.valueOf(((boa)localObject1).zSb)));
            AppMethodBeat.o(352521);
            return;
          }
          com.tencent.mm.ui.base.aa.makeText((Context)this.activity, (CharSequence)this.activity.getResources().getString(p.h.CoR), 0).show();
          localObject1 = this.Bpp;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((boa)localObject1).Vpy)
          {
            Log.e("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("handleNetSceneFinderLiveVerify() real name Url is empty:", localObject1));
            break;
          }
        }
      }
    }
    if (!aw(this.activity))
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive permission is invalid.");
      AppMethodBeat.o(352521);
      return;
    }
    if (this.Bpn != null)
    {
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
      f.a.a((com.tencent.mm.plugin.f)localObject1, (Context)this.activity, this.Bpn, null, 12);
    }
    this.Bpu = true;
    Log.w("Finder.FinderLivePostForNearby", "gotoLive 进入直播间.");
    AppMethodBeat.o(352521);
  }
  
  private final void euj()
  {
    Object localObject1 = null;
    AppMethodBeat.i(352447);
    if (!kotlin.g.b.s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      d.uiThread((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(352447);
      return;
    }
    Log.i("Finder.FinderLivePostForNearby", "gotoCreateNotice");
    Object localObject2 = this.Bpn;
    if (localObject2 == null)
    {
      if (localObject1 == null)
      {
        this.DHZ = true;
        Log.e("Finder.FinderLivePostForNearby", "gotoCreateNotice finderCreateLivePrepareResponse is null.");
      }
      AppMethodBeat.o(352447);
      return;
    }
    label103:
    int i;
    if (((awa)localObject2).live_notice_info != null)
    {
      localObject1 = ((awa)localObject2).live_notice_info;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label229;
        }
        i = 1;
        label123:
        if (i == 0) {
          break label252;
        }
      }
    }
    else
    {
      localObject1 = this.Bpm;
      if (localObject1 != null)
      {
        localObject1 = ((bys)localObject1).ZEd;
        if (localObject1 != null)
        {
          localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
          kotlin.g.b.s.s(localObject3, "service(IActivityRouter::class.java)");
          f.a.a((com.tencent.mm.plugin.f)localObject3, this.activity, null, (FinderContact)localObject1);
        }
      }
      Object localObject3 = j.Dob;
      q.av localav = q.av.DzR;
      localObject1 = ((awa)localObject2).live_notice_info;
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = "";
      label198:
      ((j)localObject3).a(localav, "", (String)localObject1);
    }
    for (;;)
    {
      this.DHZ = false;
      localObject1 = ah.aiuX;
      break;
      localObject1 = ((bkk)localObject1).hAR;
      break label103;
      label229:
      i = 0;
      break label123;
      label234:
      localObject2 = ((bkk)localObject1).YSR;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label198;
      }
      localObject1 = "";
      break label198;
      label252:
      Log.i("Finder.FinderLivePostForNearby", "gotoCreateNotice goto live notice");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("finder_username", z.bAW());
      ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", true);
      localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject2, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)localObject2, (Context)this.activity, (Intent)localObject1, 0, 124);
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).enterFinderProfileUI((Context)this.activity, (Intent)localObject1);
    }
  }
  
  private static final void n(DialogInterface paramDialogInterface, int paramInt) {}
  
  private static final void t(DialogInterface paramDialogInterface, int paramInt) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(352665);
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    Object localObject1;
    if (paramIntent == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", precheckResult:");
      if (paramIntent != null) {
        break label135;
      }
      localObject1 = localObject2;
      label74:
      Log.i("Finder.FinderLivePostForNearby", localObject1);
      switch (paramInt1)
      {
      }
    }
    label135:
    label232:
    for (;;)
    {
      AppMethodBeat.o(352665);
      return;
      localObject1 = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));
      break;
      localObject1 = Integer.valueOf(paramIntent.getIntExtra("PRECHECK_RESULT", 0));
      break label74;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1)) {}
        for (paramInt1 = i; paramInt1 != 0; paramInt1 = 0)
        {
          efr();
          AppMethodBeat.o(352665);
          return;
        }
        if (paramInt2 == -1)
        {
          if ((paramIntent != null) && (paramIntent.getIntExtra("PRECHECK_RESULT", 0) == 1)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 == 0) {
              break label232;
            }
            efr();
            break;
          }
        }
      }
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(352675);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(352675);
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
        AppMethodBeat.o(352675);
        return;
        i = 0;
        break;
      }
      label110:
      Log.i("Finder.FinderLivePostForNearby", "FinderLive request permission " + paramInt + " failed");
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(352699);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Object localObject;
    if (paramp == null)
    {
      localObject = null;
      Log.i("Finder.FinderLivePostForNearby", localObject + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramp instanceof com.tencent.mm.plugin.finder.live.cgi.aa)) {
        break label348;
      }
      paramString = (Context)this.activity;
      paramp = (com.tencent.mm.plugin.finder.live.cgi.aa)paramp;
      Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderLiveVerify()");
      com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label203;
      }
      this.Bpp = paramp.ehq();
      efr();
      paramString = this.Bpp;
      kotlin.g.b.s.checkNotNull(paramString);
      Log.i("Finder.FinderLivePostForNearby", kotlin.g.b.s.X("handleNetSceneFinderLiveVerify() is verify:", Boolean.valueOf(paramString.zSb)));
    }
    for (;;)
    {
      paramString = this.Bpq;
      if (paramString != null) {
        paramString.end();
      }
      AppMethodBeat.o(352699);
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
      paramString = (Context)this.activity;
      paramp = (bl)paramp;
      Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderPrepareUser()");
      com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label435;
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
      AppMethodBeat.o(352699);
      return;
      label435:
      com.tencent.mm.ui.base.aa.makeText(paramString, p.h.finder_prepare_user_failed, 1).show();
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(352685);
    Log.i("Finder.FinderLivePostForNearby", "prepare()");
    String str = z.bAW();
    if (!NetStatusUtil.isConnected((Context)this.activity))
    {
      localObject = new g.a((Context)this.activity);
      ((g.a)localObject).Xdm = true;
      ((g.a)localObject).bDE(this.activity.getResources().getString(p.h.Cld)).bDI(this.activity.getResources().getString(p.h.app_i_know)).b(b..ExternalSyntheticLambda4.INSTANCE).show();
      Log.e("Finder.FinderLivePostForNearby", "checkNetworkAvailable() network problem");
    }
    for (int i = 0; i == 0; i = 1)
    {
      Log.e("Finder.FinderLivePostForNearby", "prepare() checkNetworkAvailable failed");
      AppMethodBeat.o(352685);
      return;
    }
    Log.i("Finder.FinderLivePostForNearby", "checkAccountValid()");
    if (Util.isNullOrNil(str))
    {
      Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() need create finder contact.");
      localObject = j.Dob;
      j.Doc.a(q.bf.DAK);
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
      ((com.tencent.mm.plugin.h)localObject).em((Context)this.activity);
      i = 0;
    }
    while (i == 0)
    {
      Log.e("Finder.FinderLivePostForNearby", "prepare() checkAccountValid failed");
      AppMethodBeat.o(352685);
      return;
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0);
      if ((i & 0x1) != 0)
      {
        Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() check has real name userFlag %d", new Object[] { Integer.valueOf(i) });
        localObject = j.Dob;
        j.Doc.a(q.bf.DAL);
        ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).showRealNameCertificationDialog(this.activity);
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    Object localObject = j.Dob;
    j.Doc.a(q.bf.DAJ);
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
      localObject = (com.tencent.mm.plugin.h)localObject;
      localContext = (Context)this.activity;
      kotlin.g.b.s.s(str, "finderUsername");
      h.a.a((com.tencent.mm.plugin.h)localObject, localContext, str, new b..ExternalSyntheticLambda0(this), b..ExternalSyntheticLambda2.INSTANCE, null, true, 16);
      AppMethodBeat.o(352685);
      return;
    }
    localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(localObject, "service(IFinderCommonService::class.java)");
    localObject = (com.tencent.mm.plugin.h)localObject;
    Context localContext = (Context)this.activity;
    kotlin.g.b.s.s(str, "finderUsername");
    h.a.a((com.tencent.mm.plugin.h)localObject, localContext, str, new b..ExternalSyntheticLambda1(this), b..ExternalSyntheticLambda3.INSTANCE, null, false, 48);
    AppMethodBeat.o(352685);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(352690);
    Log.i("Finder.FinderLivePostForNearby", "reset()");
    this.Bpu = false;
    bh localbh = this.Bpq;
    if (localbh != null) {
      localbh.GlN = 0;
    }
    if (this.DHY != null)
    {
      Log.i("CreateFinderNoticeHelper", "reset()");
      AppMethodBeat.o(352690);
      throw null;
    }
    AppMethodBeat.o(352690);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "", "ENTER_LIVE_HELPER_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements am.a
  {
    b(ah.e parame, b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, awa paramawa)
    {
      AppMethodBeat.i(352396);
      kotlin.g.b.s.u(paramawa, "resp");
      if (this.Bpv.aixc == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          b.a(jdField_this, paramawa);
        }
      }
      for (;;)
      {
        paramString = b.d(jdField_this);
        if (paramString != null) {
          paramString.end();
        }
        AppMethodBeat.o(352396);
        return;
        com.tencent.mm.ui.base.aa.makeText((Context)b.c(jdField_this), p.h.finder_prepare_user_failed, 1).show();
        continue;
        Log.i("Finder.FinderLivePostForNearby", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.Bpv.aixc + ",scene.requestId:" + paramLong);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.livepost.b
 * JD-Core Version:    0.7.0.1
 */