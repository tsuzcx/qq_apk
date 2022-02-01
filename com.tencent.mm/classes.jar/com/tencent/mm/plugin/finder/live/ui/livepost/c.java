package com.tencent.mm.plugin.finder.live.ui.livepost;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.model.cgi.am;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.findersdk.a.aw;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.fgq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePostHelper;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "livePrepareResp", "Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper$LivePrepareInfo;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "onLivePrepareEnd", "Lkotlin/Function0;", "", "getOnLivePrepareEnd", "()Lkotlin/jvm/functions/Function0;", "setOnLivePrepareEnd", "(Lkotlin/jvm/functions/Function0;)V", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "requestId", "", "selectedItemId", "", "getSelectedItemId", "()I", "setSelectedItemId", "(I)V", "checkLivePermission", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "isFromScan", "", "continueLive", "finderObjectInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "destroy", "getPrepareResp", "globalEnable", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "gotoLiveInternal", "liveVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "precheckEnable", "userFlag", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "prepareLive", "privateEnable", "privateFlag", "resetPrepateFlag", "setPrepareResp", "showErrPage", "type", "showPermissionWarningDialog", "title", "content", "posBtnString", "showPrecheckPage", "Companion", "LivePrepareInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h, aw
{
  public static final a DIc;
  public bys AwM;
  private long Bjl;
  private bkk BvE;
  public b DId;
  public kotlin.g.a.a<ah> DIe;
  public final String TAG;
  public int dqc;
  private final Activity hHU;
  
  static
  {
    AppMethodBeat.i(352565);
    DIc = new a((byte)0);
    AppMethodBeat.o(352565);
  }
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(352425);
    this.hHU = paramActivity;
    this.TAG = "Finder.LivePostHelper";
    this.dqc = -1;
    AppMethodBeat.o(352425);
  }
  
  private final boolean Oj(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(352432);
    if (!d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i(this.TAG, "live global enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(352432);
      return bool;
      bool = false;
    }
  }
  
  private final boolean Ok(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(352439);
    if (!d.ee(paramInt, 1)) {}
    for (;;)
    {
      Log.i(this.TAG, "live private enable:" + bool + ",flag:" + paramInt);
      AppMethodBeat.o(352439);
      return bool;
      bool = false;
    }
  }
  
  private final void Ol(int paramInt)
  {
    AppMethodBeat.i(352510);
    Log.i(this.TAG, kotlin.g.b.s.X("showErrPage type:", Integer.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    Context localContext = (Context)this.hHU;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.fsy());
    com.tencent.mm.hellhoundlib.a.a.a(this.hHU, com.tencent.mm.hellhoundlib.b.c.a(10001, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper", "showErrPage", "(I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(352510);
  }
  
  private static final ah a(c paramc, long paramLong, b.a parama)
  {
    AppMethodBeat.i(371300);
    kotlin.g.b.s.u(paramc, "this$0");
    Log.i(paramc.TAG, "result errCode:" + parama.errCode + ",errMsg:" + parama.errMsg + ",errType:" + parama.errType + ",requestId:" + paramc.Bjl + ",scene.requestId:" + paramLong);
    if (paramc.Bjl == paramLong)
    {
      paramc.DId = new b(parama.errCode, parama.errMsg, (awa)parama.ott);
      if ((parama.errType != 0) || (parama.errCode != 0)) {
        break label198;
      }
      paramc.BvE = ((awa)parama.ott).live_notice_info;
      ((g)com.tencent.mm.kernel.h.ax(g.class)).a(paramc.BvE);
      paramc = paramc.DIe;
      if (paramc != null) {
        paramc.invoke();
      }
    }
    for (;;)
    {
      paramc = ah.aiuX;
      AppMethodBeat.o(371300);
      return paramc;
      label198:
      paramc.BvE = null;
      paramc = paramc.DIe;
      if (paramc != null) {
        paramc.invoke();
      }
    }
  }
  
  private static final void a(c paramc, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(371302);
    kotlin.g.b.s.u(paramc, "this$0");
    Log.i(paramc.TAG, "showAlertDialog click bOk:" + paramBoolean + ",text:" + paramString);
    AppMethodBeat.o(371302);
  }
  
  private final void b(int paramInt, fgq paramfgq)
  {
    AppMethodBeat.i(352523);
    Log.i(this.TAG, "showPrecheckPage userFlag:" + paramInt + " spamRisk:" + paramfgq + ",stack:" + Util.getStack());
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", 11);
    localIntent.putExtra("PRECHECK_USERFLAG", paramInt);
    localIntent.putExtra("PRECHECK_SPAMRISK", paramfgq.toByteArray());
    paramfgq = (Context)this.hHU;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.HdV;
    localIntent.setClass(paramfgq, com.tencent.mm.plugin.findersdk.e.a.fsy());
    com.tencent.mm.hellhoundlib.a.a.a(this.hHU, com.tencent.mm.hellhoundlib.b.c.a(10001, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper", "showPrecheckPage", "(ILcom/tencent/mm/protocal/protobuf/SpamRisk;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(352523);
  }
  
  private void b(awa paramawa, boolean paramBoolean)
  {
    AppMethodBeat.i(352469);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaC, Boolean.FALSE);
    if (localObject == null)
    {
      paramawa = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(352469);
      throw paramawa;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i(this.TAG, kotlin.g.b.s.X("gotoLive isVerify:", Boolean.valueOf(bool)));
    if (bool)
    {
      c(paramawa, paramBoolean);
      AppMethodBeat.o(352469);
      return;
    }
    eun();
    AppMethodBeat.o(352469);
  }
  
  private final void c(awa paramawa, boolean paramBoolean)
  {
    AppMethodBeat.i(352500);
    String str = this.TAG;
    if (paramawa == null) {}
    for (Object localObject = "";; localObject = paramawa)
    {
      Log.i(str, kotlin.g.b.s.X("checkLivePermission resp", com.tencent.mm.ae.f.dg(localObject)));
      bool = com.tencent.mm.pluginsdk.permission.b.a(this.hHU, "android.permission.CAMERA", 16, "");
      Log.i(this.TAG, kotlin.g.b.s.X("check camera:", Boolean.valueOf(bool)));
      if (bool) {
        break;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("check camera stack:", Util.getStack()));
      AppMethodBeat.o(352500);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.hHU, "android.permission.RECORD_AUDIO", 80, "");
    Log.i(this.TAG, kotlin.g.b.s.X("check micro:", Boolean.valueOf(bool)));
    if (!bool)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("check micro:", Util.getStack()));
      AppMethodBeat.o(352500);
      return;
    }
    str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("full_tag_info:");
    if (paramawa == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(",visibility_file_list size:");
      if (paramawa != null) {
        break label286;
      }
      localObject = null;
    }
    for (;;)
    {
      Log.i(str, localObject);
      ((com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class)).a((Context)this.hHU, paramawa, null, paramBoolean);
      AppMethodBeat.o(352500);
      return;
      localObject = paramawa.ZGp;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = Integer.valueOf(((LinkedList)localObject).size());
      break;
      label286:
      localObject = paramawa.ZGr;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((LinkedList)localObject).size());
      }
    }
  }
  
  private final boolean c(int paramInt, fgq paramfgq)
  {
    boolean bool4 = true;
    AppMethodBeat.i(352451);
    if (paramfgq == null)
    {
      Log.i(this.TAG, "precheckEnable spamRisk is empty!");
      AppMethodBeat.o(352451);
      return true;
    }
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.euE())
    {
      Log.i(this.TAG, "precheckEnable canShowPrecheckEntrance:false");
      AppMethodBeat.o(352451);
      return true;
    }
    if (paramfgq.abGu == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i(this.TAG, "precheckEnable showPage:" + bool1 + " promt:" + paramfgq.abGu + " flag:" + paramInt);
      if (bool1) {
        break;
      }
      AppMethodBeat.o(352451);
      return true;
    }
    paramfgq = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaU, Boolean.FALSE);
    if (paramfgq == null)
    {
      paramfgq = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(352451);
      throw paramfgq;
    }
    boolean bool5 = ((Boolean)paramfgq).booleanValue();
    boolean bool2;
    label203:
    boolean bool3;
    if (!d.ee(paramInt, 4))
    {
      bool1 = true;
      if (d.ee(paramInt, 8)) {
        break label305;
      }
      bool2 = true;
      if (d.ee(paramInt, 16)) {
        break label311;
      }
      bool3 = true;
      label215:
      if ((!bool1) || (!bool2) || (!bool5) || (!bool3)) {
        break label317;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "precheckEnable haveShowPrecheckPage:" + bool5 + ",realnamePrecheckResult:" + bool1 + ",agePrecheckResult:" + bool2 + ", otherPrecheckResult:" + bool3);
      AppMethodBeat.o(352451);
      return bool4;
      bool1 = false;
      break;
      label305:
      bool2 = false;
      break label203;
      label311:
      bool3 = false;
      break label215;
      label317:
      bool4 = false;
    }
  }
  
  private final void eun()
  {
    AppMethodBeat.i(352488);
    Log.i(this.TAG, "liveVerify");
    com.tencent.mm.kernel.h.aZW().a(5231, (com.tencent.mm.am.h)this);
    com.tencent.mm.plugin.findersdk.b.h localh = new com.tencent.mm.plugin.finder.live.cgi.aa().f((Context)this.hHU, this.hHU.getResources().getString(p.h.finder_waiting), 1000L);
    com.tencent.mm.kernel.h.aZW().a((p)localh, 0);
    AppMethodBeat.o(352488);
  }
  
  public final void a(awa paramawa, boolean paramBoolean)
  {
    AppMethodBeat.i(352605);
    kotlin.g.b.s.u(paramawa, "resp");
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Boolean)com.tencent.d.a.a.a.a.a.jUB().bmg()).booleanValue())
    {
      c(paramawa, false);
      AppMethodBeat.o(352605);
      return;
    }
    if (!Oj(paramawa.ZGm))
    {
      Ol(2);
      AppMethodBeat.o(352605);
      return;
    }
    if (!Ok(paramawa.user_flag))
    {
      Ol(2);
      AppMethodBeat.o(352605);
      return;
    }
    if (!c(paramawa.user_flag, paramawa.ZGw))
    {
      localObject = paramawa.ZGw;
      if (localObject != null) {
        b(paramawa.user_flag, (fgq)localObject);
      }
      AppMethodBeat.o(352605);
      return;
    }
    b(paramawa, paramBoolean);
    AppMethodBeat.o(352605);
  }
  
  public final void a(bys parambys)
  {
    Object localObject = null;
    AppMethodBeat.i(352580);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setPrepareResp wxaShopInfo appId:");
    if (parambys == null) {}
    for (;;)
    {
      Log.i(str, localObject + ',');
      this.AwM = parambys;
      AppMethodBeat.o(352580);
      return;
      bzd localbzd = parambys.wxaShopInfo;
      if (localbzd != null) {
        localObject = localbzd.appId;
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(352646);
    Log.i(this.TAG, "destroy");
    com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(352646);
  }
  
  public final bys euk()
  {
    return this.AwM;
  }
  
  public final void eul()
  {
    AppMethodBeat.i(352589);
    Log.i(this.TAG, "prepareLive");
    this.Bjl = System.currentTimeMillis();
    this.dqc = -1;
    this.DId = null;
    long l = this.Bjl;
    bi localbi = bi.ABn;
    new am(bi.dVu(), z.bAW(), this.Bjl, null, (byte)0).bFJ().a((com.tencent.mm.vending.e.b)this.hHU).g(new c..ExternalSyntheticLambda1(this, l));
    AppMethodBeat.o(352589);
  }
  
  public final void eum()
  {
    this.Bjl = 0L;
    this.dqc = -1;
  }
  
  public final void f(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(352614);
    bip localbip;
    if (paramFinderObject != null)
    {
      localbip = paramFinderObject.liveInfo;
      if ((localbip != null) && (localbip.liveId != 0L))
      {
        localObject1 = localbip.ZRZ;
        if (localObject1 != null) {
          break label140;
        }
      }
    }
    label140:
    for (Object localObject1 = null;; localObject1 = new Intent().putExtra("KEY_PARAMS_LAYER_SHOW_INFO", ((bix)localObject1).toByteArray()))
    {
      Object localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject2, "service(IActivityRouter::class.java)");
      com.tencent.mm.plugin.f localf = (com.tencent.mm.plugin.f)localObject2;
      Context localContext = (Context)this.hHU;
      long l = paramFinderObject.id;
      String str = paramFinderObject.objectNonceId;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      f.a.a(localf, localContext, l, (String)localObject2, localbip, this.BvE, null, null, null, null, paramFinderObject.sessionBuffer, null, (Intent)localObject1, 3024);
      AppMethodBeat.o(352614);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(352641);
    kotlin.g.b.s.u(paramArrayOfString, "permissions");
    kotlin.g.b.s.u(paramArrayOfInt, "grantResults");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(352641);
      return;
      int i;
      if (paramArrayOfInt.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label112;
        }
        i = 1;
        label71:
        if ((i == 0) || (paramArrayOfInt[0] != 0)) {
          break label126;
        }
        paramArrayOfString = this.DId;
        if (paramArrayOfString != null) {
          break label118;
        }
      }
      label112:
      label118:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString.DIf)
      {
        c(paramArrayOfString, false);
        AppMethodBeat.o(352641);
        return;
        i = 0;
        break;
        i = 0;
        break label71;
      }
      label126:
      Log.i(this.TAG, "FinderLive request permission " + paramInt + " failed");
      paramArrayOfString = this.hHU.getResources().getString(p.h.Cqy);
      kotlin.g.b.s.s(paramArrayOfString, "context.resources.getStr…permission_warning_title)");
      paramArrayOfInt = this.hHU.getResources().getString(p.h.Cqx);
      kotlin.g.b.s.s(paramArrayOfInt, "context.resources.getStr…rmission_warning_content)");
      String str = this.hHU.getResources().getString(p.h.Cqw);
      kotlin.g.b.s.s(str, "context.resources.getStr…ermission_warning_action)");
      paramArrayOfString = new g.a((Context)this.hHU).bf((CharSequence)paramArrayOfString).bDE(paramArrayOfInt).bDI(str);
      paramArrayOfString.Xdm = true;
      paramArrayOfString.b(new c..ExternalSyntheticLambda0(this)).show();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject2 = null;
    AppMethodBeat.i(352627);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("scene:");
    if (paramp == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramp.getType()))
    {
      Log.i(str, localObject1 + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramp instanceof com.tencent.mm.plugin.finder.live.cgi.aa)) {
        break label486;
      }
      com.tencent.mm.kernel.h.aZW().b(5231, (com.tencent.mm.am.h)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label399;
      }
      paramString = ((com.tencent.mm.plugin.finder.live.cgi.aa)paramp).ehq();
      Log.i(this.TAG, kotlin.g.b.s.X("prepareLive,is verify:", Boolean.valueOf(paramString.zSb)));
      if (paramString.zSb) {
        break label366;
      }
      if (Util.isNullOrNil(paramString.Vpy)) {
        break;
      }
      paramp = paramString.Vpy;
      paramString = paramp;
      if (paramp == null) {
        paramString = "";
      }
      Log.i(this.TAG, kotlin.g.b.s.X("gotoFaceVerify ", paramString));
      paramp = new Intent();
      paramp.putExtra("LIVE_HELP_TYPE", 1);
      paramp.putExtra("FACE_VERIFY_URL", paramString);
      paramString = (Context)this.hHU;
      localObject1 = com.tencent.mm.plugin.findersdk.e.a.HdV;
      paramp.setClass(paramString, com.tencent.mm.plugin.findersdk.e.a.fsy());
      com.tencent.mm.hellhoundlib.a.a.a(this.hHU, com.tencent.mm.hellhoundlib.b.c.a(10000, new com.tencent.mm.hellhoundlib.b.a()).cG(paramp).aYi(), "com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper", "gotoFaceVerify", "(Ljava/lang/String;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(352627);
      return;
    }
    com.tencent.mm.ui.base.aa.makeText((Context)this.hHU, (CharSequence)this.hHU.getResources().getString(p.h.CoR), 0).show();
    Log.e(this.TAG, kotlin.g.b.s.X("prepareLive,realnameUrl is empty:", paramString.Vpy));
    AppMethodBeat.o(352627);
    return;
    label366:
    paramString = this.DId;
    if (paramString == null) {}
    for (paramString = localObject2;; paramString = paramString.DIf)
    {
      c(paramString, false);
      AppMethodBeat.o(352627);
      return;
    }
    switch (paramInt2)
    {
    case -200017: 
    case -200016: 
    case -200015: 
    case -200014: 
    case -200013: 
    default: 
      com.tencent.mm.ui.base.aa.makeText((Context)this.hHU, (CharSequence)this.hHU.getResources().getString(p.h.CjO), 0).show();
      AppMethodBeat.o(352627);
      return;
    case -200009: 
      com.tencent.mm.ui.base.aa.makeText((Context)this.hHU, (CharSequence)this.hHU.getResources().getString(p.h.Cip), 0).show();
      AppMethodBeat.o(352627);
      return;
    case -200010: 
      com.tencent.mm.ui.base.aa.makeText((Context)this.hHU, (CharSequence)this.hHU.getResources().getString(p.h.Cic), 0).show();
      AppMethodBeat.o(352627);
      return;
    case -200011: 
      label399:
      label486:
      Ol(3);
      AppMethodBeat.o(352627);
      return;
    }
    Ol(2);
    AppMethodBeat.o(352627);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY", "", "ENTER_LIVE_POST_HELPER", "PREPARE_TIME_OUT", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper$LivePrepareInfo;", "", "errCode", "", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getResp", "()Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public final awa DIf;
    public final int errCode;
    public final String errMsg;
    
    public b(int paramInt, String paramString, awa paramawa)
    {
      this.errCode = paramInt;
      this.errMsg = paramString;
      this.DIf = paramawa;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(352395);
      if (this == paramObject)
      {
        AppMethodBeat.o(352395);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(352395);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.errCode != paramObject.errCode)
      {
        AppMethodBeat.o(352395);
        return false;
      }
      if (!kotlin.g.b.s.p(this.errMsg, paramObject.errMsg))
      {
        AppMethodBeat.o(352395);
        return false;
      }
      if (!kotlin.g.b.s.p(this.DIf, paramObject.DIf))
      {
        AppMethodBeat.o(352395);
        return false;
      }
      AppMethodBeat.o(352395);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(352387);
      int k = this.errCode;
      int i;
      if (this.errMsg == null)
      {
        i = 0;
        if (this.DIf != null) {
          break label56;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(352387);
        return (i + k * 31) * 31 + j;
        i = this.errMsg.hashCode();
        break;
        label56:
        j = this.DIf.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(352382);
      String str = "LivePrepareInfo(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", resp=" + this.DIf + ')';
      AppMethodBeat.o(352382);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.livepost.c
 * JD-Core Version:    0.7.0.1
 */