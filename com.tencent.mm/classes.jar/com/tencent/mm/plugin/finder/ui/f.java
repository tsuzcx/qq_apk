package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.live.s.af;
import com.tencent.mm.plugin.finder.report.live.s.ah;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.utils.ai;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.g.b.z.e;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "checkAccountValid", "finderUsername", "", "checkLivePermission", "context", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "globalEnable", "globalFlag", "", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "Companion", "plugin-finder_release"})
public final class f
  implements i
{
  public static final a vKQ;
  private final Activity activity;
  public awt uiv;
  public bed vKL;
  public aqb vKM;
  public axq vKN;
  private ak vKO;
  private boolean vKP;
  
  static
  {
    AppMethodBeat.i(252471);
    vKQ = new a((byte)0);
    AppMethodBeat.o(252471);
  }
  
  public f(Activity paramActivity)
  {
    AppMethodBeat.i(252470);
    this.activity = paramActivity;
    paramActivity = ak.wan;
    paramActivity = (Context)this.activity;
    String str = this.activity.getResources().getString(2131760677);
    p.h(paramActivity, "context");
    ak localak = new ak();
    localak.gY = 1000L;
    localak.lAM = new WeakReference(paramActivity);
    ag localag = new ag();
    if (str != null) {
      localag.awz(str);
    }
    localag.kke = null;
    localag.lAM = new WeakReference(paramActivity);
    localak.vUZ = ((ai)localag);
    this.vKO = localak;
    AppMethodBeat.o(252470);
  }
  
  private static boolean Lp(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(252463);
    if (!d.cW(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostForNearby", "globalEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(252463);
      return bool;
      bool = false;
    }
  }
  
  private static boolean Lq(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(252464);
    if (!d.cW(paramInt, 1)) {}
    for (;;)
    {
      Log.i("Finder.FinderLivePostForNearby", "privateEnable enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(252464);
      return bool;
      bool = false;
    }
  }
  
  private final void Lr(int paramInt)
  {
    AppMethodBeat.i(252469);
    Log.i("Finder.FinderLivePostForNearby", "showErrPage type:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    localIntent.setClass((Context)this.activity, FinderLivePostHelperUI.class);
    this.activity.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(252469);
  }
  
  private static boolean al(Activity paramActivity)
  {
    AppMethodBeat.i(252466);
    Log.i("Finder.FinderLivePostForNearby", "checkLivePermission()");
    boolean bool = b.a(paramActivity, "android.permission.CAMERA", 16, "", "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostForNearby", "checkLivePermission() invalid checkCamera:".concat(String.valueOf(bool)));
      AppMethodBeat.o(252466);
      return false;
    }
    bool = b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "", "");
    if (!bool)
    {
      Log.i("Finder.FinderLivePostForNearby", "checkLivePermission() invalid checkMicroPhone:".concat(String.valueOf(bool)));
      AppMethodBeat.o(252466);
      return false;
    }
    AppMethodBeat.o(252466);
    return true;
  }
  
  private final boolean avQ(String paramString)
  {
    AppMethodBeat.i(252461);
    Log.i("Finder.FinderLivePostForNearby", "checkAccountValid()");
    if (Util.isNullOrNil(paramString))
    {
      Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() need create finder contact.");
      paramString = k.vkd;
      k.dpl().a(s.ah.vqv);
      FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialog((Context)this.activity, 3);
      AppMethodBeat.o(252461);
      return false;
    }
    paramString = g.aAh();
    p.g(paramString, "MMKernel.storage()");
    int i = paramString.azQ().getInt(ar.a.Okh, 0);
    if ((i & 0x1) != 0)
    {
      Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() check has real name userFlag %d", new Object[] { Integer.valueOf(i) });
      paramString = k.vkd;
      k.dpl().a(s.ah.vqw);
      FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialog(this.activity);
      AppMethodBeat.o(252461);
      return false;
    }
    AppMethodBeat.o(252461);
    return true;
  }
  
  private final void avR(String paramString)
  {
    AppMethodBeat.i(252467);
    Log.i("Finder.FinderLivePostForNearby", "gotoFaceVerify ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 1);
    localIntent.putExtra("FACE_VERIFY_URL", paramString);
    localIntent.setClass((Context)this.activity, FinderLivePostHelperUI.class);
    this.activity.startActivityForResult(localIntent, 10000);
    AppMethodBeat.o(252467);
  }
  
  private final boolean dzA()
  {
    AppMethodBeat.i(252460);
    if (!NetStatusUtil.isConnected((Context)this.activity))
    {
      new com.tencent.mm.ui.widget.a.f.a((Context)this.activity).hbu().bow(this.activity.getResources().getString(2131759962)).boA(this.activity.getResources().getString(2131755873)).b((com.tencent.mm.ui.widget.a.f.c)c.vKT).show();
      Log.e("Finder.FinderLivePostForNearby", "checkNetworkAvailable() network problem");
      AppMethodBeat.o(252460);
      return false;
    }
    AppMethodBeat.o(252460);
    return true;
  }
  
  private static boolean dzB()
  {
    AppMethodBeat.i(252462);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Oki, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(252462);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("Finder.FinderLivePostForNearby", "isVerify:".concat(String.valueOf(bool)));
    if (BuildInfo.DEBUG) {
      bool = true;
    }
    AppMethodBeat.o(252462);
    return bool;
  }
  
  private final void dzC()
  {
    AppMethodBeat.i(252465);
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    p.g(localObject2, "Looper.getMainLooper()");
    if ((p.j(localObject1, ((Looper)localObject2).getThread()) ^ true))
    {
      d.h((kotlin.g.a.a)new d(this));
      AppMethodBeat.o(252465);
      return;
    }
    Log.i("Finder.FinderLivePostForNearby", "gotoLive");
    if (this.vKP)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive 已经进入直播间.");
      AppMethodBeat.o(252465);
      return;
    }
    if (this.vKL == null)
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive finderUserPrepareResponse is null.");
      AppMethodBeat.o(252465);
      return;
    }
    Object localObject4 = this.vKM;
    label246:
    int i;
    if (localObject4 != null)
    {
      localObject1 = o.ujN;
      if ((o.dfZ() == null) && (((aqb)localObject4).LBU != null))
      {
        localObject1 = ((aqb)localObject4).LBU;
        Context localContext;
        long l;
        awe localawe;
        label389:
        label419:
        label449:
        boolean bool;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label562;
          }
          localObject1 = ((aqb)localObject4).LBU;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObject)localObject1).liveInfo;
            if ((localObject1 != null) && (((awe)localObject1).liveId == 0L)) {
              break label562;
            }
          }
          localObject2 = new StringBuilder("gotoLive continue live:");
          localObject1 = ((aqb)localObject4).LBU;
          if (localObject1 == null) {
            break label533;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label533;
          }
          localObject1 = Long.valueOf(((awe)localObject1).liveId);
          Log.i("Finder.FinderLivePostForNearby", localObject1);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
          localContext = (Context)this.activity;
          localObject1 = ((aqb)localObject4).LBU;
          if (localObject1 == null) {
            p.hyc();
          }
          l = ((FinderObject)localObject1).id;
          localObject1 = ((aqb)localObject4).LBU;
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
          localObject2 = ((aqb)localObject4).LBU;
          if (localObject2 == null) {
            p.hyc();
          }
          localawe = ((FinderObject)localObject2).liveInfo;
          if (localawe == null) {
            p.hyc();
          }
          p.g(localawe, "it.recover_live_object!!.liveInfo!!");
          localObject2 = m.vVH;
          localObject2 = this.vKL;
          if (localObject2 == null) {
            break label539;
          }
          i = ((bed)localObject2).LNW;
          localObject2 = this.vKL;
          if (localObject2 == null) {
            break label544;
          }
          localObject2 = ((bed)localObject2).wxaShopInfo;
          if (localObject2 == null) {
            break label544;
          }
          localObject2 = ((bel)localObject2).appId;
          localObject3 = this.vKL;
          if (localObject3 == null) {
            break label550;
          }
          localObject3 = ((bed)localObject3).wxaShopInfo;
          if (localObject3 == null) {
            break label550;
          }
          localObject3 = ((bel)localObject3).LOg;
          bool = m.z(i, (String)localObject2, (String)localObject3);
          localObject3 = this.uiv;
          localObject2 = ((aqb)localObject4).LBU;
          if (localObject2 == null) {
            break label556;
          }
        }
        label533:
        label539:
        label544:
        label550:
        label556:
        for (localObject2 = ((FinderObject)localObject2).sessionBuffer;; localObject2 = null)
        {
          com.tencent.mm.plugin.finder.utils.a.a(localContext, l, (String)localObject1, localawe, bool, (awt)localObject3, null, ((aqb)localObject4).LBV, ((aqb)localObject4).LBW, null, (String)localObject2, ((aqb)localObject4).LBX, 1168);
          AppMethodBeat.o(252465);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label246;
          i = 0;
          break label389;
          localObject2 = null;
          break label419;
          localObject3 = null;
          break label449;
        }
      }
      label562:
      if (!Lp(((aqb)localObject4).LBS))
      {
        Lr(2);
        Log.w("Finder.FinderLivePostForNearby", "gotoLive type:" + ((aqb)localObject4).LBS);
        AppMethodBeat.o(252465);
        return;
      }
      if (!Lq(((aqb)localObject4).KTQ))
      {
        Lr(2);
        Log.w("Finder.FinderLivePostForNearby", "gotoLive type:" + ((aqb)localObject4).KTQ);
        AppMethodBeat.o(252465);
      }
    }
    else
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive finderCreateLivePrepareResponse is null.");
      AppMethodBeat.o(252465);
      return;
    }
    if (dzB()) {
      if (this.vKN != null)
      {
        localObject1 = this.vKN;
        if (localObject1 == null) {
          p.hyc();
        }
        if (!((axq)localObject1).sPX)
        {
          localObject1 = this.vKN;
          if (localObject1 == null) {
            p.hyc();
          }
          if (!Util.isNullOrNil(((axq)localObject1).HIt))
          {
            localObject1 = this.vKN;
            if (localObject1 == null) {
              p.hyc();
            }
            localObject2 = ((axq)localObject1).HIt;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            avR((String)localObject1);
            localObject1 = new StringBuilder("gotoLive, is verify:");
            localObject2 = this.vKN;
            if (localObject2 == null) {
              p.hyc();
            }
            Log.i("Finder.FinderLivePostForNearby", ((axq)localObject2).sPX);
            AppMethodBeat.o(252465);
            return;
          }
          u.makeText((Context)this.activity, (CharSequence)this.activity.getResources().getString(2131760130), 0).show();
          localObject2 = new StringBuilder("handleNetSceneFinderLiveVerify() real name Url is empty:");
          localObject1 = this.vKN;
          if (localObject1 != null) {}
          for (localObject1 = ((axq)localObject1).HIt;; localObject1 = null)
          {
            Log.e("Finder.FinderLivePostForNearby", (String)localObject1);
            break;
          }
        }
      }
      else
      {
        Log.e("Finder.FinderLivePostForNearby", "gotoLive finderLiveVerifyResp is null.");
        AppMethodBeat.o(252465);
        return;
      }
    }
    if (!al(this.activity))
    {
      Log.e("Finder.FinderLivePostForNearby", "gotoLive permission is invalid.");
      AppMethodBeat.o(252465);
      return;
    }
    Object localObject3 = this.vKM;
    if (localObject3 != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject4 = (Context)this.activity;
      localObject1 = m.vVH;
      localObject1 = this.vKL;
      if (localObject1 == null) {
        break label1121;
      }
      i = ((bed)localObject1).LNW;
      localObject1 = this.vKL;
      if (localObject1 == null) {
        break label1126;
      }
      localObject1 = ((bed)localObject1).wxaShopInfo;
      if (localObject1 == null) {
        break label1126;
      }
      localObject1 = ((bel)localObject1).appId;
      label1028:
      localObject2 = this.vKL;
      if (localObject2 == null) {
        break label1132;
      }
      localObject2 = ((bed)localObject2).wxaShopInfo;
      if (localObject2 == null) {
        break label1132;
      }
    }
    label1121:
    label1126:
    label1132:
    for (localObject2 = ((bel)localObject2).LOg;; localObject2 = null)
    {
      com.tencent.mm.plugin.finder.utils.a.a((Context)localObject4, 0L, "", null, m.z(i, (String)localObject1, (String)localObject2), this.uiv, null, ((aqb)localObject3).LBV, ((aqb)localObject3).LBW, null, null, ((aqb)localObject3).LBX, 3224);
      this.vKP = true;
      Log.w("Finder.FinderLivePostForNearby", "gotoLive 进入直播间.");
      AppMethodBeat.o(252465);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label1028;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252456);
    StringBuilder localStringBuilder = new StringBuilder("onActivityResult,requestCode:").append(paramInt1).append(",resultCode:").append(paramInt2).append(",face verify result:");
    if (paramIntent != null) {}
    for (Integer localInteger = Integer.valueOf(paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0));; localInteger = null)
    {
      Log.i("Finder.FinderLivePostForNearby", localInteger);
      if ((paramInt1 == 10000) && (paramInt2 == -1))
      {
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1) {
          dzC();
        }
      }
      AppMethodBeat.o(252456);
      return;
    }
    AppMethodBeat.o(252456);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(252457);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
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
        dzC();
        AppMethodBeat.o(252457);
        return;
        i = 0;
        break;
      }
      label86:
      Log.i("Finder.FinderLivePostForNearby", "FinderLive request permission " + paramInt + " failed");
    }
    AppMethodBeat.o(252457);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(252468);
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd scene:");
    Integer localInteger;
    if (paramq != null)
    {
      localInteger = Integer.valueOf(paramq.getType());
      Log.i("Finder.FinderLivePostForNearby", localInteger + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramq instanceof bu)) {
        break label367;
      }
      paramString = (Context)this.activity;
      paramq = (bu)paramq;
      Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderLiveVerify()");
      g.azz().b(5231, (i)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label218;
      }
      this.vKN = paramq.cYK();
      dzC();
      paramString = new StringBuilder("handleNetSceneFinderLiveVerify() is verify:");
      paramq = this.vKN;
      if (paramq == null) {
        p.hyc();
      }
      Log.i("Finder.FinderLivePostForNearby", paramq.sPX);
    }
    for (;;)
    {
      paramString = this.vKO;
      if (paramString == null) {
        break label360;
      }
      paramString.end();
      AppMethodBeat.o(252468);
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
        u.makeText(paramString, (CharSequence)paramString.getResources().getString(2131759916), 0).show();
        break;
      case -200009: 
        u.makeText(paramString, (CharSequence)paramString.getResources().getString(2131759875), 0).show();
        break;
      case -200010: 
        u.makeText(paramString, (CharSequence)paramString.getResources().getString(2131759871), 0).show();
        break;
      case -200011: 
        Lr(3);
        break;
      case -200018: 
      case -200012: 
        label218:
        Lr(2);
      }
    }
    label360:
    AppMethodBeat.o(252468);
    return;
    label367:
    if ((paramq instanceof cd))
    {
      paramString = (Context)this.activity;
      paramq = (cd)paramq;
      Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderPrepareUser()");
      g.azz().b(3761, (i)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.vKL = paramq.cZc();
        dzC();
      }
      for (;;)
      {
        paramString = this.vKO;
        if (paramString == null) {
          break;
        }
        paramString.end();
        AppMethodBeat.o(252468);
        return;
        u.makeText(paramString, 2131760430, 1).show();
      }
    }
    AppMethodBeat.o(252468);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(252458);
    Log.i("Finder.FinderLivePostForNearby", "prepare()");
    String str = z.aUg();
    if (!dzA())
    {
      Log.e("Finder.FinderLivePostForNearby", "prepare() checkNetworkAvailable failed");
      AppMethodBeat.o(252458);
      return;
    }
    if (!avQ(str))
    {
      Log.e("Finder.FinderLivePostForNearby", "prepare() checkAccountValid failed");
      AppMethodBeat.o(252458);
      return;
    }
    Object localObject = k.vkd;
    k.dpl().a(s.ah.vqu);
    localObject = FinderBottomCustomDialogHelper.Companion;
    Context localContext = (Context)this.activity;
    p.g(str, "finderUsername");
    ((FinderBottomCustomDialogHelper.Companion)localObject).showUserInfoConfirmDialog(localContext, str, (DialogInterface.OnClickListener)new e(this), (DialogInterface.OnClickListener)f.vKU);
    AppMethodBeat.o(252458);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(252459);
    Log.i("Finder.FinderLivePostForNearby", "reset()");
    this.vKP = false;
    ak localak = this.vKO;
    if (localak != null)
    {
      localak.wam = 0;
      AppMethodBeat.o(252459);
      return;
    }
    AppMethodBeat.o(252459);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "", "ENTER_LIVE_FORBIDDEN_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderLivePostForNearby$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static final class b
    implements s.a
  {
    b(z.e parame, f paramf) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, aqb paramaqb)
    {
      AppMethodBeat.i(252451);
      p.h(paramaqb, "resp");
      if (this.vKR.SYF == paramLong) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          f.a(this.vKS, paramaqb);
        }
      }
      for (;;)
      {
        paramString = f.c(this.vKS);
        if (paramString == null) {
          break;
        }
        paramString.end();
        AppMethodBeat.o(252451);
        return;
        u.makeText((Context)f.b(this.vKS), 2131760430, 1).show();
        continue;
        Log.i("Finder.FinderLivePostForNearby", "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + this.vKR.SYF + ",scene.requestId:" + paramLong);
      }
      AppMethodBeat.o(252451);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class c
    implements com.tencent.mm.ui.widget.a.f.c
  {
    public static final c vKT;
    
    static
    {
      AppMethodBeat.i(252452);
      vKT = new c();
      AppMethodBeat.o(252452);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(f paramf) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(252454);
      f.a(this.vKS);
      paramDialogInterface = k.vkd;
      k.a(s.af.vqp);
      AppMethodBeat.o(252454);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    public static final f vKU;
    
    static
    {
      AppMethodBeat.i(252455);
      vKU = new f();
      AppMethodBeat.o(252455);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f
 * JD-Core Version:    0.7.0.1
 */