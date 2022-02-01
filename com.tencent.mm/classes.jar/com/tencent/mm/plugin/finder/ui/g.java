package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.live.model.cgi.s;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.u;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "livePrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "onLivePrepareEnd", "Lkotlin/Function0;", "", "getOnLivePrepareEnd", "()Lkotlin/jvm/functions/Function0;", "setOnLivePrepareEnd", "(Lkotlin/jvm/functions/Function0;)V", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "requestId", "", "selectedItemId", "", "getSelectedItemId", "()I", "setSelectedItemId", "(I)V", "checkLivePermission", "resp", "continueLive", "finderObjectInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "destroy", "globalEnable", "", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "gotoLiveInternal", "liveVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareLive", "privateEnable", "privateFlag", "resetPrepateFlag", "setPrepareResp", "showErrPage", "type", "Companion", "plugin-finder_release"})
public final class g
  implements i
{
  public static final a vKX;
  public final String TAG;
  public final Activity dKq;
  public int ks;
  public bed udb;
  public awt ufj;
  private long ulj;
  public aqb vKV;
  public kotlin.g.a.a<x> vKW;
  
  static
  {
    AppMethodBeat.i(252484);
    vKX = new a((byte)0);
    AppMethodBeat.o(252484);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(252483);
    this.dKq = paramActivity;
    this.TAG = "Finder.LivePostHelper";
    this.ks = -1;
    AppMethodBeat.o(252483);
  }
  
  private final void Lr(int paramInt)
  {
    AppMethodBeat.i(252481);
    Log.i(this.TAG, "showErrPage type:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    localIntent.setClass((Context)this.dKq, FinderLivePostHelperUI.class);
    this.dKq.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(252481);
  }
  
  public final void a(bed parambed)
  {
    AppMethodBeat.i(252476);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setPrepareResp wxaShopInfo appId:");
    if (parambed != null)
    {
      localObject = parambed.wxaShopInfo;
      if (localObject == null) {}
    }
    for (Object localObject = ((bel)localObject).appId;; localObject = null)
    {
      Log.i(str, (String)localObject + ',');
      this.udb = parambed;
      AppMethodBeat.o(252476);
      return;
    }
  }
  
  public final void b(aqb paramaqb)
  {
    AppMethodBeat.i(252478);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Oki, Boolean.FALSE);
    if (localObject == null)
    {
      paramaqb = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(252478);
      throw paramaqb;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i(this.TAG, "gotoLive isVerify:".concat(String.valueOf(bool)));
    if (bool)
    {
      c(paramaqb);
      AppMethodBeat.o(252478);
      return;
    }
    Log.i(this.TAG, "liveVerify");
    com.tencent.mm.kernel.g.azz().a(5231, (i)this);
    paramaqb = new bu().d((Context)this.dKq, this.dKq.getResources().getString(2131760677), 1000L);
    com.tencent.mm.kernel.g.azz().b((q)paramaqb);
    AppMethodBeat.o(252478);
  }
  
  public final void c(aqb paramaqb)
  {
    AppMethodBeat.i(252480);
    Log.i(this.TAG, "checkLivePermission resp".concat(String.valueOf(paramaqb)));
    boolean bool = b.a(this.dKq, "android.permission.CAMERA", 16, "", "");
    Log.i(this.TAG, "check camera:".concat(String.valueOf(bool)));
    if (!bool)
    {
      Log.i(this.TAG, "check camera stack:" + Util.getStack());
      AppMethodBeat.o(252480);
      return;
    }
    bool = b.a(this.dKq, "android.permission.RECORD_AUDIO", 80, "", "");
    Log.i(this.TAG, "check micro:".concat(String.valueOf(bool)));
    if (!bool)
    {
      Log.i(this.TAG, "check micro:" + Util.getStack());
      AppMethodBeat.o(252480);
      return;
    }
    Object localObject1 = m.vVH;
    localObject1 = this.udb;
    int i;
    label221:
    Object localObject2;
    label251:
    Object localObject3;
    label313:
    label353:
    Context localContext;
    label422:
    awt localawt;
    if (localObject1 != null)
    {
      i = ((bed)localObject1).LNW;
      localObject1 = this.udb;
      if (localObject1 == null) {
        break label494;
      }
      localObject1 = ((bed)localObject1).wxaShopInfo;
      if (localObject1 == null) {
        break label494;
      }
      localObject1 = ((bel)localObject1).appId;
      localObject2 = this.udb;
      if (localObject2 == null) {
        break label500;
      }
      localObject2 = ((bed)localObject2).wxaShopInfo;
      if (localObject2 == null) {
        break label500;
      }
      localObject2 = ((bel)localObject2).LOg;
      bool = m.z(i, (String)localObject1, (String)localObject2);
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("bindShop:").append(bool).append(", full_tag_info:");
      if (paramaqb == null) {
        break label506;
      }
      localObject1 = paramaqb.LBV;
      if (localObject1 == null) {
        break label506;
      }
      localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",visibility_file_list size:");
      if (paramaqb == null) {
        break label512;
      }
      localObject1 = paramaqb.LBX;
      if (localObject1 == null) {
        break label512;
      }
      localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
      Log.i((String)localObject2, localObject1);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
      localContext = (Context)this.dKq;
      if (paramaqb != null)
      {
        localObject1 = paramaqb.LBU;
        if (localObject1 != null)
        {
          localObject2 = ((FinderObject)localObject1).liveInfo;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label422;
          }
        }
      }
      localObject1 = new awe();
      localawt = this.ufj;
      if (paramaqb == null) {
        break label518;
      }
      localObject2 = paramaqb.LBV;
      label438:
      if (paramaqb == null) {
        break label524;
      }
      localObject3 = paramaqb.LBW;
      label448:
      if (paramaqb == null) {
        break label530;
      }
    }
    label512:
    label518:
    label524:
    label530:
    for (paramaqb = paramaqb.LBX;; paramaqb = null)
    {
      com.tencent.mm.plugin.finder.utils.a.a(localContext, 0L, "", (awe)localObject1, bool, localawt, null, (LinkedList)localObject2, (axk)localObject3, null, null, paramaqb, 3216);
      AppMethodBeat.o(252480);
      return;
      i = 0;
      break;
      label494:
      localObject1 = null;
      break label221;
      label500:
      localObject2 = null;
      break label251;
      label506:
      localObject1 = null;
      break label313;
      localObject1 = null;
      break label353;
      localObject2 = null;
      break label438;
      localObject3 = null;
      break label448;
    }
  }
  
  public final void dzD()
  {
    AppMethodBeat.i(252477);
    Log.i(this.TAG, "prepareLive");
    this.ulj = System.currentTimeMillis();
    this.ks = -1;
    am localam = am.tuw;
    new s(am.cXY(), z.aUg(), this.ulj, (s.a)new b(this), (byte)0).aYI();
    AppMethodBeat.o(252477);
  }
  
  public final void dzE()
  {
    this.ulj = 0L;
    this.ks = -1;
    this.vKV = null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(252479);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("scene:");
    if (paramq != null) {}
    for (Integer localInteger = Integer.valueOf(paramq.getType());; localInteger = null)
    {
      Log.i(str, localInteger + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramq instanceof bu)) {
        break label442;
      }
      com.tencent.mm.kernel.g.azz().b(5231, (i)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label355;
      }
      paramString = ((bu)paramq).cYK();
      Log.i(this.TAG, "prepareLive,is verify:" + paramString.sPX);
      if (paramString.sPX) {
        break label340;
      }
      if (Util.isNullOrNil(paramString.HIt)) {
        break;
      }
      paramq = paramString.HIt;
      paramString = paramq;
      if (paramq == null) {
        paramString = "";
      }
      Log.i(this.TAG, "gotoFaceVerify ".concat(String.valueOf(paramString)));
      paramq = new Intent();
      paramq.putExtra("LIVE_HELP_TYPE", 1);
      paramq.putExtra("FACE_VERIFY_URL", paramString);
      paramq.setClass((Context)this.dKq, FinderLivePostHelperUI.class);
      this.dKq.startActivityForResult(paramq, 10000);
      AppMethodBeat.o(252479);
      return;
    }
    u.makeText((Context)this.dKq, (CharSequence)this.dKq.getResources().getString(2131760130), 0).show();
    Log.e(this.TAG, "prepareLive,realnameUrl is empty:" + paramString.HIt);
    AppMethodBeat.o(252479);
    return;
    label340:
    c(this.vKV);
    AppMethodBeat.o(252479);
    return;
    switch (paramInt2)
    {
    case -200017: 
    case -200016: 
    case -200015: 
    case -200014: 
    case -200013: 
    default: 
      u.makeText((Context)this.dKq, (CharSequence)this.dKq.getResources().getString(2131759916), 0).show();
      AppMethodBeat.o(252479);
      return;
    case -200009: 
      u.makeText((Context)this.dKq, (CharSequence)this.dKq.getResources().getString(2131759875), 0).show();
      AppMethodBeat.o(252479);
      return;
    case -200010: 
      u.makeText((Context)this.dKq, (CharSequence)this.dKq.getResources().getString(2131759871), 0).show();
      AppMethodBeat.o(252479);
      return;
    case -200011: 
      label355:
      Lr(3);
      label442:
      AppMethodBeat.o(252479);
      return;
    }
    Lr(2);
    AppMethodBeat.o(252479);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelper$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY", "", "ENTER_LIVE_FORBIDEEN", "PREPARE_TIME_OUT", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderLivePostHelper$prepareLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static final class b
    implements s.a
  {
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, aqb paramaqb)
    {
      AppMethodBeat.i(252475);
      p.h(paramaqb, "resp");
      if (g.b(this.vKY) == paramLong)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          g.a(this.vKY, paramaqb);
          this.vKY.ufj = paramaqb.live_notice_info;
          paramString = this.vKY.vKW;
          if (paramString != null)
          {
            paramString.invoke();
            AppMethodBeat.o(252475);
            return;
          }
          AppMethodBeat.o(252475);
          return;
        }
        this.vKY.ufj = null;
        paramString = this.vKY.vKW;
        if (paramString != null)
        {
          paramString.invoke();
          AppMethodBeat.o(252475);
          return;
        }
        AppMethodBeat.o(252475);
        return;
      }
      Log.i(g.c(this.vKY), "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + g.b(this.vKY) + ",scene.requestId:" + paramLong);
      AppMethodBeat.o(252475);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */