package com.tencent.mm.plugin.finder.live.ui.livepost;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.cgi.ae.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.protocal.protobuf.arr;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.LinkedList;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "livePrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "onLivePrepareEnd", "Lkotlin/Function0;", "", "getOnLivePrepareEnd", "()Lkotlin/jvm/functions/Function0;", "setOnLivePrepareEnd", "(Lkotlin/jvm/functions/Function0;)V", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "requestId", "", "selectedItemId", "", "getSelectedItemId", "()I", "setSelectedItemId", "(I)V", "checkLivePermission", "resp", "continueLive", "finderObjectInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "destroy", "getPrepareResp", "globalEnable", "", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "gotoLiveInternal", "liveVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "precheckEnable", "userFlag", "spamRisk", "Lcom/tencent/mm/protocal/protobuf/SpamRisk;", "prepareLive", "privateEnable", "privateFlag", "resetPrepateFlag", "setPrepareResp", "showErrPage", "type", "showPermissionWarningDialog", "title", "content", "posBtnString", "showPrecheckPage", "Companion", "plugin-finder_release"})
public final class c
  implements i
{
  public static final a yOx;
  public final String TAG;
  public int bwZ;
  public final Activity fDf;
  public ble wZz;
  public bbh xUD;
  public arr yOv;
  public kotlin.g.a.a<x> yOw;
  public long yjR;
  
  static
  {
    AppMethodBeat.i(270956);
    yOx = new a((byte)0);
    AppMethodBeat.o(270956);
  }
  
  public c(Activity paramActivity)
  {
    AppMethodBeat.i(270955);
    this.fDf = paramActivity;
    this.TAG = "Finder.LivePostHelper";
    this.bwZ = -1;
    AppMethodBeat.o(270955);
  }
  
  private final void MN(int paramInt)
  {
    AppMethodBeat.i(270953);
    Log.i(this.TAG, "showErrPage type:".concat(String.valueOf(paramInt)));
    Intent localIntent = new Intent();
    localIntent.putExtra("LIVE_HELP_TYPE", paramInt);
    Context localContext = (Context)this.fDf;
    com.tencent.mm.plugin.findersdk.e.a locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
    localIntent.setClass(localContext, com.tencent.mm.plugin.findersdk.e.a.enJ());
    this.fDf.startActivityForResult(localIntent, 10001);
    AppMethodBeat.o(270953);
  }
  
  public final void a(ble paramble)
  {
    AppMethodBeat.i(270949);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setPrepareResp wxaShopInfo appId:");
    if (paramble != null)
    {
      localObject = paramble.wxaShopInfo;
      if (localObject == null) {}
    }
    for (Object localObject = ((bln)localObject).appId;; localObject = null)
    {
      Log.i(str, (String)localObject + ',');
      this.wZz = paramble;
      AppMethodBeat.o(270949);
      return;
    }
  }
  
  public final void b(arr paramarr)
  {
    AppMethodBeat.i(270950);
    Object localObject = h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).aHp().get(ar.a.VyG, Boolean.FALSE);
    if (localObject == null)
    {
      paramarr = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(270950);
      throw paramarr;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i(this.TAG, "gotoLive isVerify:".concat(String.valueOf(bool)));
    if (bool)
    {
      c(paramarr);
      AppMethodBeat.o(270950);
      return;
    }
    Log.i(this.TAG, "liveVerify");
    h.aGY().a(5231, (i)this);
    paramarr = new com.tencent.mm.plugin.finder.live.cgi.p().f((Context)this.fDf, this.fDf.getResources().getString(b.j.finder_waiting), 1000L);
    h.aGY().b((q)paramarr);
    AppMethodBeat.o(270950);
  }
  
  public final void c(arr paramarr)
  {
    Object localObject2 = null;
    AppMethodBeat.i(270952);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checkLivePermission resp");
    if (paramarr == null) {}
    for (Object localObject1 = "";; localObject1 = paramarr)
    {
      Log.i(str, g.bN(localObject1));
      boolean bool = b.a(this.fDf, "android.permission.CAMERA", 16, "", "");
      Log.i(this.TAG, "check camera:".concat(String.valueOf(bool)));
      if (!bool)
      {
        Log.i(this.TAG, "check camera stack:" + Util.getStack());
        AppMethodBeat.o(270952);
        return;
      }
      bool = b.a(this.fDf, "android.permission.RECORD_AUDIO", 80, "", "");
      Log.i(this.TAG, "check micro:".concat(String.valueOf(bool)));
      if (!bool)
      {
        Log.i(this.TAG, "check micro:" + Util.getStack());
        AppMethodBeat.o(270952);
        return;
      }
      str = this.TAG;
      localStringBuilder = new StringBuilder("full_tag_info:");
      if (paramarr != null)
      {
        localObject1 = paramarr.SEN;
        if (localObject1 == null) {}
      }
      for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append(",visibility_file_list size:");
        localObject1 = localObject2;
        if (paramarr != null)
        {
          LinkedList localLinkedList = paramarr.SEP;
          localObject1 = localObject2;
          if (localLinkedList != null) {
            localObject1 = Integer.valueOf(localLinkedList.size());
          }
        }
        Log.i(str, localObject1);
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.a((Context)this.fDf, paramarr);
        AppMethodBeat.o(270952);
        return;
      }
    }
  }
  
  public final void dDU()
  {
    this.yjR = 0L;
    this.bwZ = -1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(270951);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("scene:");
    if (paramq != null) {}
    for (Object localObject = Integer.valueOf(paramq.getType());; localObject = null)
    {
      Log.i(str, localObject + " result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1);
      if (!(paramq instanceof com.tencent.mm.plugin.finder.live.cgi.p)) {
        break label450;
      }
      h.aGY().b(5231, (i)this);
      if (((paramInt1 != 0) || (paramInt2 != 0)) && (paramInt2 != -200008)) {
        break label363;
      }
      paramString = ((com.tencent.mm.plugin.finder.live.cgi.p)paramq).dwU();
      Log.i(this.TAG, "prepareLive,is verify:" + paramString.wvU);
      if (paramString.wvU) {
        break label348;
      }
      if (Util.isNullOrNil(paramString.OAl)) {
        break;
      }
      paramq = paramString.OAl;
      paramString = paramq;
      if (paramq == null) {
        paramString = "";
      }
      Log.i(this.TAG, "gotoFaceVerify ".concat(String.valueOf(paramString)));
      paramq = new Intent();
      paramq.putExtra("LIVE_HELP_TYPE", 1);
      paramq.putExtra("FACE_VERIFY_URL", paramString);
      paramString = (Context)this.fDf;
      localObject = com.tencent.mm.plugin.findersdk.e.a.Bxf;
      paramq.setClass(paramString, com.tencent.mm.plugin.findersdk.e.a.enJ());
      this.fDf.startActivityForResult(paramq, 10000);
      AppMethodBeat.o(270951);
      return;
    }
    w.makeText((Context)this.fDf, (CharSequence)this.fDf.getResources().getString(b.j.finder_live_not_realname), 0).show();
    Log.e(this.TAG, "prepareLive,realnameUrl is empty:" + paramString.OAl);
    AppMethodBeat.o(270951);
    return;
    label348:
    c(this.yOv);
    AppMethodBeat.o(270951);
    return;
    switch (paramInt2)
    {
    case -200017: 
    case -200016: 
    case -200015: 
    case -200014: 
    case -200013: 
    default: 
      w.makeText((Context)this.fDf, (CharSequence)this.fDf.getResources().getString(b.j.finder_live_disable), 0).show();
      AppMethodBeat.o(270951);
      return;
    case -200009: 
      w.makeText((Context)this.fDf, (CharSequence)this.fDf.getResources().getString(b.j.finder_live_anchor_not_adult), 0).show();
      AppMethodBeat.o(270951);
      return;
    case -200010: 
      w.makeText((Context)this.fDf, (CharSequence)this.fDf.getResources().getString(b.j.finder_live_anchor_foreigner_error_text), 0).show();
      AppMethodBeat.o(270951);
      return;
    case -200011: 
      label363:
      MN(3);
      label450:
      AppMethodBeat.o(270951);
      return;
    }
    MN(2);
    AppMethodBeat.o(270951);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY", "", "ENTER_LIVE_POST_HELPER", "PREPARE_TIME_OUT", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/ui/livepost/FinderLivePostHelper$prepareLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
  public static final class b
    implements ae.a
  {
    public final void a(int paramInt1, int paramInt2, String paramString, long paramLong, arr paramarr)
    {
      AppMethodBeat.i(270596);
      kotlin.g.b.p.k(paramarr, "resp");
      if (c.b(this.yOy) == paramLong)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          c.a(this.yOy, paramarr);
          this.yOy.xUD = paramarr.live_notice_info;
          paramString = this.yOy.yOw;
          if (paramString != null)
          {
            paramString.invoke();
            AppMethodBeat.o(270596);
            return;
          }
          AppMethodBeat.o(270596);
          return;
        }
        this.yOy.xUD = null;
        paramString = this.yOy.yOw;
        if (paramString != null)
        {
          paramString.invoke();
          AppMethodBeat.o(270596);
          return;
        }
        AppMethodBeat.o(270596);
        return;
      }
      Log.i(c.c(this.yOy), "result errCode:" + paramInt2 + ",errMsg:" + paramString + ",errType:" + paramInt1 + ",requestId:" + c.b(this.yOy) + ",scene.requestId:" + paramLong);
      AppMethodBeat.o(270596);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  public static final class c
    implements f.c
  {
    public c(c paramc) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(283574);
      Log.i(c.c(this.yOy), "showAlertDialog click bOk:" + paramBoolean + ",text:" + paramString);
      AppMethodBeat.o(283574);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.livepost.c
 * JD-Core Version:    0.7.0.1
 */