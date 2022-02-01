package com.tencent.mm.plugin.finder.live.ui.livepost;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s;
import com.tencent.mm.plugin.finder.live.report.s.ak;
import com.tencent.mm.plugin.finder.live.report.s.aq;
import com.tencent.mm.plugin.finder.live.report.s.as;
import com.tencent.mm.plugin.finder.live.viewmodel.component.c;
import com.tencent.mm.plugin.finder.live.viewmodel.component.c.a;
import com.tencent.mm.plugin.finder.utils.au;
import com.tencent.mm.plugin.finder.utils.au.a;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.aa.e;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveCreateNoticeHelper", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLiveCreateNoticeHelper;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isRequestCreateNotice", "isRequestGotoLive", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "checkAccountValid", "finderUsername", "", "checkLivePermission", "context", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "globalEnable", "globalFlag", "", "gotoCreateNotice", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmCreateNotice", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/INetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preCheckEnable", "userFlag", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "showPrecheckPage", "Companion", "plugin-finder_release"})
public final class b
  implements i
{
  public static final a yOr;
  private final Activity activity;
  public au xPA;
  public boolean xPE;
  private ble xPw;
  private arr xPx;
  private bbh xPy;
  private bdh xPz;
  public a yOo;
  private boolean yOp;
  private boolean yOq;
  
  static
  {
    AppMethodBeat.i(290500);
    yOr = new a((byte)0);
    AppMethodBeat.o(290500);
  }
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(290499);
    this.activity = paramActivity;
    paramActivity = au.AJj;
    this.xPA = au.a.a((Context)this.activity, this.activity.getResources().getString(b.j.finder_waiting), 500L, 8);
    AppMethodBeat.o(290499);
  }
  
  private final void MN(int paramInt)
  {
    AppMethodBeat.i(290498);
    Log.i("Finder.FinderLivePostForNearby", "showErrPage type:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    Context localContext = (Context)this.activity;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enJ());
    this.activity.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(290498);
  }
  
  private final boolean aBM(String paramString)
  {
    AppMethodBeat.i(290491);
    Log.i("Finder.FinderLivePostForNearby", "checkAccountValid()");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() need create finder contact.");
      paramString = k.yBj;
      k.dDm().a(s.as.yJK);
      FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialog$default(FinderBottomCustomDialogHelper.Companion, (Context)this.activity, 3, null, 4, null);
      AppMethodBeat.o(290491);
      return false;
    }
    paramString = h.aHG();
    kotlin.g.b.p.j(paramString, "MMKernel.storage()");
    int i = paramString.aHp().getInt(ar.a.VyF, 0);
    if ((i & 0x1) != 0)
    {
      Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() check has real name userFlag %d", new Object[] { Integer.valueOf(i) });
      paramString = k.yBj;
      k.dDm().a(s.as.yJL);
      FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialog(this.activity);
      AppMethodBeat.o(290491);
      return false;
    }
    AppMethodBeat.o(290491);
    return true;
  }
  
  private final void dDT()
  {
    AppMethodBeat.i(290492);
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    kotlin.g.b.p.j(localObject2, "Looper.getMainLooper()");
    if ((kotlin.g.b.p.h(localObject1, ((Looper)localObject2).getThread()) ^ true))
    {
      d.uiThread((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(290492);
      return;
    }
    Log.i("Finder.FinderLivePostForNearby", "gotoCreateNotice");
    localObject2 = this.xPx;
    if (localObject2 != null)
    {
      int i;
      if (((arr)localObject2).live_notice_info != null)
      {
        localObject1 = ((arr)localObject2).live_notice_info;
        if (localObject1 != null)
        {
          localObject1 = ((bbh)localObject1).fwt;
          localObject1 = (CharSequence)localObject1;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label227;
          }
          i = 1;
          label113:
          if (i == 0) {
            break label232;
          }
        }
      }
      else
      {
        localObject1 = this.xPw;
        if (localObject1 != null)
        {
          localObject1 = ((ble)localObject1).SDj;
          if (localObject1 != null)
          {
            localObject3 = com.tencent.mm.plugin.finder.utils.a.ACH;
            localObject3 = this.activity;
            kotlin.g.b.p.j(localObject1, "it");
            c.a locala = c.zdR;
            com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject3, null, (FinderContact)localObject1, c.dGv());
          }
        }
        localObject1 = k.yBj;
        Object localObject3 = s.ak.yIZ;
        localObject1 = ((arr)localObject2).live_notice_info;
        if (localObject1 != null)
        {
          localObject2 = ((bbh)localObject1).SNb;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        k.a((s.ak)localObject3, "", (String)localObject1);
      }
      for (;;)
      {
        this.yOp = false;
        AppMethodBeat.o(290492);
        return;
        localObject1 = null;
        break;
        label227:
        i = 0;
        break label113;
        label232:
        Log.i("Finder.FinderLivePostForNearby", "gotoCreateNotice goto live notice");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("finder_username", z.bdh());
        ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", true);
        localObject2 = aj.Bnu;
        aj.a.a((Context)this.activity, (Intent)localObject1, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.activity, (Intent)localObject1);
      }
    }
    this.yOp = true;
    Log.e("Finder.FinderLivePostForNearby", "gotoCreateNotice finderCreateLivePrepareResponse is null.");
    AppMethodBeat.o(290492);
  }
  
  private final boolean dvr()
  {
    AppMethodBeat.i(290490);
    if (!NetStatusUtil.isConnected((Context)this.activity))
    {
      new f.a((Context)this.activity).icD().bBl(this.activity.getResources().getString(b.j.finder_live_jump_tip_network_unavailable)).bBp(this.activity.getResources().getString(b.j.app_i_know)).b((f.c)c.yOt).show();
      Log.e("Finder.FinderLivePostForNearby", "checkNetworkAvailable() network problem");
      AppMethodBeat.o(290490);
      return false;
    }
    AppMethodBeat.o(290490);
    return true;
  }
  
  private final void dvv()
  {
    AppMethodBeat.i(290493);
    if (this.xPx == null)
    {
      Object localObject = new aa.e();
      ((aa.e)localObject).aaBB = System.currentTimeMillis();
      com.tencent.mm.plugin.finder.cgi.ao localao = com.tencent.mm.plugin.finder.cgi.ao.xcj;
      new ae(com.tencent.mm.plugin.finder.cgi.ao.dnO(), z.bdh(), ((aa.e)localObject).aaBB, (ae.a)new b((aa.e)localObject, this), (byte)0).bhW();
      localObject = this.xPA;
      if (localObject != null)
      {
        ((au)localObject).begin();
        localObject = x.aazN;
        AppMethodBeat.o(290493);
        return;
      }
    }
    AppMethodBeat.o(290493);
  }
  
  private static boolean dvw()
  {
    AppMethodBeat.i(290494);
    Object localObject = h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VyG, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(290494);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLivePostForNearby", "isVerify:".concat(String.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(290494);
    return bool;
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(290495);
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    kotlin.g.b.p.j(localObject2, "Looper.getMainLooper()");
    if ((kotlin.g.b.p.h(localObject1, ((Looper)localObject2).getThread()) ^ true))
    {
      d.uiThread((kotlin.g.a.a)new e(this));
      AppMethodBeat.o(290495);
      return;
    }
    Log.i("Finder.FinderLivePostForNearby", "gotoLive");
    if (this.xPE)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(290495);
      return;
    }
    if (this.xPw == null)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(290495);
      return;
    }
    Object localObject3 = this.xPx;
    label251:
    int i;
    if (localObject3 != null)
    {
      this.yOq = false;
      localObject1 = ah.yhC;
      if ((ah.dzj() == null) && (((arr)localObject3).SEM != null))
      {
        localObject1 = ((arr)localObject3).SEM;
        Context localContext;
        long l;
        bac localbac;
        bbh localbbh;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label457;
          }
          localObject1 = ((arr)localObject3).SEM;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).liveInfo;
            if ((localObject1 != null) && (((bac)localObject1).liveId == 0L)) {
              break label457;
            }
          }
          localObject2 = new StringBuilder("gotoLive continue live:");
          localObject1 = ((arr)localObject3).SEM;
          if (localObject1 == null) {
            break label445;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label445;
          }
          localObject1 = Long.valueOf(((bac)localObject1).liveId);
          Log.i("Finder.FinderLivePostForNearby", localObject1);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
          localContext = (Context)this.activity;
          localObject1 = ((arr)localObject3).SEM;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          l = ((FinderObject)localObject1).id;
          localObject1 = ((arr)localObject3).SEM;
          if (localObject1 != null)
          {
            localObject2 = ((FinderObject)localObject1).objectNonceId;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          localObject2 = ((arr)localObject3).SEM;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          localbac = ((FinderObject)localObject2).liveInfo;
          if (localbac == null) {
            kotlin.g.b.p.iCn();
          }
          kotlin.g.b.p.j(localbac, "it.recover_live_object!!.liveInfo!!");
          localbbh = this.xPy;
          localObject2 = ((arr)localObject3).SEM;
          if (localObject2 == null) {
            break label451;
          }
        }
        label445:
        label451:
        for (localObject2 = ((FinderObject)localObject2).sessionBuffer;; localObject2 = null)
        {
          com.tencent.mm.plugin.finder.utils.a.a(localContext, l, (String)localObject1, localbac, localbbh, null, ((arr)localObject3).SEN, ((arr)localObject3).SEO, null, (String)localObject2, ((arr)localObject3).SEP, null, 4688);
          AppMethodBeat.o(290495);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label251;
        }
      }
      label457:
      i = ((arr)localObject3).SEK;
      if (!d.dr(i, 1)) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("Finder.FinderLivePostForNearby", "globalEnable enable:" + bool1 + ",flag:" + i);
        if (bool1) {
          break;
        }
        MN(2);
        Log.w("Finder.FinderLivePostForNearby", "gotoLive type:" + ((arr)localObject3).SEK);
        AppMethodBeat.o(290495);
        return;
      }
      i = ((arr)localObject3).RUO;
      if (!d.dr(i, 1)) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("Finder.FinderLivePostForNearby", "privateEnable enable:" + bool1 + ",flag:" + i);
        if (bool1) {
          break;
        }
        MN(2);
        Log.w("Finder.FinderLivePostForNearby", "gotoLive type:" + ((arr)localObject3).RUO);
        AppMethodBeat.o(290495);
        return;
      }
      i = ((arr)localObject3).RUO;
      localObject1 = ((arr)localObject3).SEU;
      if (localObject1 == null) {
        Log.i("Finder.FinderLivePostForNearby", "preCheckEnable spamRisk is empty!");
      }
      for (i = 1;; i = 1)
      {
        if (i != 0) {
          break label1154;
        }
        localObject2 = ((arr)localObject3).SEU;
        if (localObject2 == null) {
          break label1127;
        }
        i = ((arr)localObject3).RUO;
        Log.i("Finder.FinderLivePostForNearby", "showPrecheckPage userFlag:" + i + " spamRisk:" + localObject2);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("LIVE_HELP_TYPE", 11);
        ((Intent)localObject1).putExtra("PRECHECK_USERFLAG", i);
        ((Intent)localObject1).putExtra("PRECHECK_SPAMRISK", ((elx)localObject2).toByteArray());
        localObject2 = (Context)this.activity;
        localObject3 = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        ((Intent)localObject1).setClass((Context)localObject2, com.tencent.mm.plugin.findersdk.e.a.enJ());
        this.activity.startActivityForResult((Intent)localObject1, 10001);
        AppMethodBeat.o(290495);
        return;
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEF()) {
          break;
        }
        Log.i("Finder.FinderLivePostForNearby", "preCheckEnable canShowPrecheckEntrance:false");
      }
      if (((elx)localObject1).UnS == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("Finder.FinderLivePostForNearby", "preCheckEnable showPage:" + bool1 + " promt:" + ((elx)localObject1).UnS + " flag:" + i);
        if (bool1) {
          break label923;
        }
        i = 1;
        break;
      }
      label923:
      localObject1 = h.aHG();
      kotlin.g.b.p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((f)localObject1).aHp().get(ar.a.VyY, Boolean.FALSE);
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(290495);
        throw ((Throwable)localObject1);
      }
      boolean bool4 = ((Boolean)localObject1).booleanValue();
      label999:
      boolean bool2;
      label1011:
      boolean bool3;
      if (!d.dr(i, 4))
      {
        bool1 = true;
        if (d.dr(i, 8)) {
          break label1110;
        }
        bool2 = true;
        if (d.dr(i, 16)) {
          break label1116;
        }
        bool3 = true;
        label1023:
        if ((!bool1) || (!bool2) || (!bool4) || (!bool3)) {
          break label1122;
        }
      }
      label1110:
      label1116:
      label1122:
      for (i = 1;; i = 0)
      {
        Log.i("Finder.FinderLivePostForNearby", "preCheckEnable haveShowPrecheckPage:" + bool4 + ",realnamePrecheckResult:" + bool1 + ",agePrecheckResult:" + bool2 + ", otherPrecheckResult:" + bool3);
        break;
        bool1 = false;
        break label999;
        bool2 = false;
        break label1011;
        bool3 = false;
        break label1023;
      }
      label1127:
      AppMethodBeat.o(290495);
      return;
    }
    Log.e("Finder.FinderLivePostForNearby", "gotoLive finderCreateLivePrepareResponse is null.");
    this.yOq = true;
    AppMethodBeat.o(290495);
    return;
    label1154:
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
            Log.i("Finder.FinderLivePostForNearby", "gotoFaceVerify ".concat(String.valueOf(localObject1)));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("LIVE_HELP_TYPE", 1);
            ((Intent)localObject2).putExtra("FACE_VERIFY_URL", (String)localObject1);
            localObject1 = (Context)this.activity;
            localObject3 = com.tencent.mm.plugin.findersdk.e.a.Bxf;
            ((Intent)localObject2).setClass((Context)localObject1, com.tencent.mm.plugin.findersdk.e.a.enJ());
            this.activity.startActivityForResult((Intent)localObject2, 10000);
            localObject1 = new StringBuilder("gotoLive, is verify:");
            localObject2 = this.xPz;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            Log.i("Finder.FinderLivePostForNearby", ((bdh)localObject2).wvU);
            AppMethodBeat.o(290495);
            return;
          }
          w.makeText((Context)this.activity, (CharSequence)this.activity.getResources().getString(b.j.finder_live_not_realname), 0).show();
          localObject2 = new StringBuilder("handleNetSceneFinderLiveVerify() real name Url is empty:");
          localObject1 = this.xPz;
          if (localObject1 != null) {}
          for (localObject1 = ((bdh)localObject1).OAl;; localObject1 = null)
          {
            Log.e("Finder.FinderLivePostForNearby", (String)localObject1);
            break;
          }
        }
      }
      else
      {
        Log.e("Finder.FinderLivePostForNearby", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(290495);
        return;
      }
    }
    localObject1 = this.activity;
    Log.i("Finder.FinderLivePostForNearby", "checkLivePermission()");
    boolean bool1 = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject1, "android.permission.CAMERA", 16, "", "");
    if (!bool1)
    {
      Log.i("Finder.FinderLivePostForNearby", "checkLivePermission() invalid checkCamera:".concat(String.valueOf(bool1)));
      i = 0;
    }
    while (i == 0)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive permission is invalid.");
      AppMethodBeat.o(290495);
      return;
      bool1 = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject1, "android.permission.RECORD_AUDIO", 80, "", "");
      if (!bool1)
      {
        Log.i("Finder.FinderLivePostForNearby", "checkLivePermission() invalid checkMicroPhone:".concat(String.valueOf(bool1)));
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    if (this.xPx != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.a((Context)this.activity, this.xPx);
    }
    this.xPE = true;
    Log.w("Finder.FinderLivePostForNearby", "gotoLive 进入直播间.");
    AppMethodBeat.o(290495);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(290496);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Integer localInteger;
    if (paramq != null)
    {
      localInteger = Integer.valueOf(paramq.getType());
      Log.i("Finder.FinderLivePostForNearby", localInteger + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramq instanceof com.tencent.mm.plugin.finder.live.cgi.p)) {
        break label367;
      }
      paramString = (Context)this.activity;
      paramq = (com.tencent.mm.plugin.finder.live.cgi.p)paramq;
      Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderLiveVerify()");
      h.aGY().b(5231, (i)this);
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
      Log.i("Finder.FinderLivePostForNearby", paramq.wvU);
    }
    for (;;)
    {
      paramString = this.xPA;
      if (paramString == null) {
        break label360;
      }
      paramString.end();
      AppMethodBeat.o(290496);
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
    AppMethodBeat.o(290496);
    return;
    label367:
    if ((paramq instanceof aq))
    {
      paramString = (Context)this.activity;
      paramq = (aq)paramq;
      Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderPrepareUser()");
      h.aGY().b(3761, (i)this);
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
        AppMethodBeat.o(290496);
        return;
        w.makeText(paramString, b.j.finder_prepare_user_failed, 1).show();
      }
    }
    AppMethodBeat.o(290496);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(290489);
    Log.i("Finder.FinderLivePostForNearby", "prepare()");
    Object localObject1 = z.bdh();
    if (!dvr())
    {
      Log.e("Finder.FinderLivePostForNearby", "prepare() checkNetworkAvailable failed");
      AppMethodBeat.o(290489);
      return;
    }
    if (!aBM((String)localObject1))
    {
      Log.e("Finder.FinderLivePostForNearby", "prepare() checkAccountValid failed");
      AppMethodBeat.o(290489);
      return;
    }
    Object localObject2 = k.yBj;
    k.dDm().a(s.as.yJJ);
    localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      localObject1 = com.tencent.mm.plugin.finder.view.dialog.a.Bey;
      com.tencent.mm.plugin.finder.view.dialog.a.a((Context)this.activity, (q.g)new f(this));
      AppMethodBeat.o(290489);
      return;
    }
    localObject2 = FinderBottomCustomDialogHelper.Companion;
    Context localContext = (Context)this.activity;
    kotlin.g.b.p.j(localObject1, "finderUsername");
    FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog$default((FinderBottomCustomDialogHelper.Companion)localObject2, localContext, (String)localObject1, (DialogInterface.OnClickListener)new g(this), (DialogInterface.OnClickListener)h.yOu, null, 16, null);
    AppMethodBeat.o(290489);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "", "ENTER_LIVE_HELPER_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostForNearby$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static final class b
    implements ae.a
  {
    b(aa.e parame, b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, arr paramarr)
    {
      AppMethodBeat.i(279281);
      kotlin.g.b.p.k(paramarr, "resp");
      if (this.xPI.aaBB == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          b.a(jdField_this, paramarr);
        }
      }
      for (;;)
      {
        paramString = b.e(jdField_this);
        if (paramString == null) {
          break;
        }
        paramString.end();
        AppMethodBeat.o(279281);
        return;
        w.makeText((Context)b.d(jdField_this), b.j.finder_prepare_user_failed, 1).show();
        continue;
        Log.i("Finder.FinderLivePostForNearby", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.xPI.aaBB + ",scene.requestId:" + paramLong);
      }
      AppMethodBeat.o(279281);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements f.c
  {
    public static final c yOt;
    
    static
    {
      AppMethodBeat.i(227934);
      yOt = new c();
      AppMethodBeat.o(227934);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements q.g
  {
    f(b paramb) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(272052);
      kotlin.g.b.p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(272052);
        return;
        b.a(this.yOs);
        paramMenuItem = k.yBj;
        k.a(s.aq.yJE);
        AppMethodBeat.o(272052);
        return;
        b.b(this.yOs);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(b paramb) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(273023);
      b.a(this.yOs);
      paramDialogInterface = k.yBj;
      k.a(s.aq.yJE);
      AppMethodBeat.o(273023);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    public static final h yOu;
    
    static
    {
      AppMethodBeat.i(290151);
      yOu = new h();
      AppMethodBeat.o(290151);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.livepost.b
 * JD-Core Version:    0.7.0.1
 */