package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.qg.a;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class c
{
  private static final String TAG = "MicroMsg.BizVideoMsgTransmit";
  public static final c khX;
  
  static
  {
    AppMethodBeat.i(15311);
    khX = new c();
    TAG = "MicroMsg.BizVideoMsgTransmit";
    AppMethodBeat.o(15311);
  }
  
  public static void a(Context paramContext, com.tencent.mm.af.s params, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(152956);
    j.q(paramContext, "context");
    j.q(params, "msg");
    j.q(paramb, "controller");
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (paramb.aZg())
    {
      localObject2 = (Map)localHashMap;
      params = paramb.kfA;
      if (params != null)
      {
        params = params.fjJ;
        params = bo.nullAsNil(params);
        j.p(params, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
        ((Map)localObject2).put("img_url", params);
        localObject2 = (Map)localHashMap;
        params = paramb.kfA;
        if (params == null) {
          break label337;
        }
        params = params.fjL;
        label105:
        params = bo.nullAsNil(params);
        j.p(params, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
        ((Map)localObject2).put("desc", params);
        localObject2 = (Map)localHashMap;
        bca localbca = paramb.kfA;
        params = (com.tencent.mm.af.s)localObject1;
        if (localbca != null) {
          params = localbca.title;
        }
        params = bo.nullAsNil(params);
        j.p(params, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
        ((Map)localObject2).put("title", params);
      }
    }
    for (;;)
    {
      params = (Map)localHashMap;
      localObject1 = paramb.url;
      if (localObject1 == null) {
        j.ebi();
      }
      params.put("url", localObject1);
      ab.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramb.url });
      h.qsU.idkeyStat(157L, 5L, 1L, false);
      params = new Intent();
      params.putExtra("Select_Conv_Type", 3);
      params.putExtra("scene_from", 2);
      params.putExtra("mutil_select_is_ret", true);
      params.putExtra("webview_params", (Serializable)localHashMap);
      params.putExtra("Retr_Msg_Type", 2);
      d.b(paramContext, ".ui.transmit.SelectConversationUI", params, 2);
      AppMethodBeat.o(152956);
      return;
      params = null;
      break;
      label337:
      params = null;
      break label105;
      localObject1 = (Map)localHashMap;
      localObject2 = bo.nullAsNil(params.fjD.fjJ);
      j.p(localObject2, "Util.nullAsNil(msg.item.cover)");
      ((Map)localObject1).put("img_url", localObject2);
      localObject1 = (Map)localHashMap;
      localObject2 = bo.nullAsNil(params.fjD.fjL);
      j.p(localObject2, "Util.nullAsNil(msg.item.digest)");
      ((Map)localObject1).put("desc", localObject2);
      localObject1 = (Map)localHashMap;
      params = bo.nullAsNil(params.fjD.title);
      j.p(params, "Util.nullAsNil(msg.item.title)");
      ((Map)localObject1).put("title", params);
    }
  }
  
  public static void a(String paramString1, com.tencent.mm.af.s params, String paramString2, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, com.tencent.mm.ipcinvoker.c<Bundle> paramc)
  {
    Object localObject = null;
    AppMethodBeat.i(152957);
    j.q(paramString1, "toUser");
    j.q(params, "msgInfo");
    j.q(paramb, "controller");
    j.q(paramc, "callback");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.toUser = paramString1;
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.hZN = paramString2;
    localAppMsgDataParcelable.jXm = params;
    int i;
    if (paramb.aZg())
    {
      i = 1;
      localAppMsgDataParcelable.khR = i;
      paramString1 = paramb.kfA;
      if (paramString1 == null) {
        break label176;
      }
      paramString1 = paramString1.title;
      label100:
      localAppMsgDataParcelable.khS = paramString1;
      paramString1 = paramb.kfA;
      if (paramString1 == null) {
        break label181;
      }
    }
    label176:
    label181:
    for (paramString1 = paramString1.fjL;; paramString1 = null)
    {
      localAppMsgDataParcelable.khT = paramString1;
      params = paramb.kfA;
      paramString1 = localObject;
      if (params != null) {
        paramString1 = params.fjJ;
      }
      localAppMsgDataParcelable.khU = paramString1;
      f.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, c.a.class, paramc);
      AppMethodBeat.o(152957);
      return;
      i = 0;
      break;
      paramString1 = null;
      break label100;
    }
  }
  
  public static boolean c(AppMsgDataParcelable paramAppMsgDataParcelable)
  {
    AppMethodBeat.i(152958);
    j.q(paramAppMsgDataParcelable, "data");
    Object localObject1 = paramAppMsgDataParcelable.jXm;
    if (localObject1 == null)
    {
      ab.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(152958);
      return false;
    }
    int i;
    Object localObject2;
    Object localObject3;
    if (paramAppMsgDataParcelable.khR == 1)
    {
      i = 1;
      localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).webpageUrl = paramAppMsgDataParcelable.url;
      localObject3 = new WXMediaMessage();
      ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (i == 0) {
        break label641;
      }
      ((WXMediaMessage)localObject3).title = paramAppMsgDataParcelable.khS;
      ((WXMediaMessage)localObject3).description = paramAppMsgDataParcelable.khT;
      label106:
      localObject2 = new qg();
      ((qg)localObject2).cGL.cyF = ((WXMediaMessage)localObject3);
      ((qg)localObject2).cGL.toUser = paramAppMsgDataParcelable.toUser;
      ((qg)localObject2).cGL.cGM = 2;
      if (!bo.isNullOrNil(((com.tencent.mm.af.s)localObject1).cqX)) {
        break label670;
      }
      ((qg)localObject2).cGL.cGN = ((com.tencent.mm.af.s)localObject1).HD();
      ((qg)localObject2).cGL.cGO = com.tencent.mm.model.s.nE(((com.tencent.mm.af.s)localObject1).HD());
    }
    for (;;)
    {
      try
      {
        ((qg)localObject2).cGL.cGQ = paramAppMsgDataParcelable.url;
        ((qg)localObject2).cGL.cGT = bo.nullAsNil(((com.tencent.mm.af.s)localObject1).fjC);
        localObject3 = v.oQ(((qg)localObject2).cGL.cGT);
        localb = v.aae().z((String)localObject3, true);
        if (localb == null) {
          j.ebi();
        }
        localb.i("sendAppMsgScene", Integer.valueOf(2));
        localb.i("preChatName", ((com.tencent.mm.af.s)localObject1).HD());
        localb.i("preMsgIndex", Integer.valueOf(((com.tencent.mm.af.s)localObject1).fjA));
        localb.i("prePublishId", ((com.tencent.mm.af.s)localObject1).fjC);
        localb.i("preUsername", ((com.tencent.mm.af.s)localObject1).HD());
        int j = ((com.tencent.mm.af.s)localObject1).fjD.type;
        if (j != -1)
        {
          localb.i("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
          localb.i("_tmpl_webview_transfer_scene", Integer.valueOf(11));
        }
        if (((com.tencent.mm.af.s)localObject1).fjD.type == 5)
        {
          localb.i("_DATA_CENTER_VID", ((com.tencent.mm.af.s)localObject1).fjD.fgl);
          localb.i("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(((com.tencent.mm.af.s)localObject1).fgk));
          localb.i("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)((com.tencent.mm.af.s)localObject1).fjD.time));
          localb.i("_DATA_CENTER__DULATION", Integer.valueOf(((com.tencent.mm.af.s)localObject1).fjD.fjN));
          localb.i("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((com.tencent.mm.af.s)localObject1).fjD.videoWidth));
          localb.i("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((com.tencent.mm.af.s)localObject1).fjD.videoHeight));
          if (i == 0) {
            continue;
          }
          localb.i("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.khU);
          localb.i("_DATA_CENTER_DESC", paramAppMsgDataParcelable.khT);
        }
        ((qg)localObject2).cGL.cpW = ((String)localObject3);
        ((qg)localObject2).cGL.cGR = paramAppMsgDataParcelable.url;
      }
      catch (Exception localException)
      {
        v.b localb;
        boolean bool;
        label641:
        label670:
        ab.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
        continue;
      }
      bool = a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      if (!bo.isNullOrNil(paramAppMsgDataParcelable.hZN))
      {
        localObject1 = new qj();
        ((qj)localObject1).cGX.cGY = paramAppMsgDataParcelable.toUser;
        ((qj)localObject1).cGX.content = paramAppMsgDataParcelable.hZN;
        ((qj)localObject1).cGX.type = t.oF(paramAppMsgDataParcelable.toUser);
        ((qj)localObject1).cGX.flags = 0;
        a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(152958);
      return bool;
      i = 0;
      break;
      ((WXMediaMessage)localObject3).title = ((com.tencent.mm.af.s)localObject1).fjD.title;
      ((WXMediaMessage)localObject3).description = ((com.tencent.mm.af.s)localObject1).fjD.fjL;
      break label106;
      ((qg)localObject2).cGL.cGN = ((com.tencent.mm.af.s)localObject1).cqX;
      ((qg)localObject2).cGL.cGO = ((com.tencent.mm.af.s)localObject1).fjB;
      continue;
      localb.i("_DATA_CENTER_COVER_URL", ((com.tencent.mm.af.s)localObject1).fjD.fjJ);
      localb.i("_DATA_CENTER_DESC", ((com.tencent.mm.af.s)localObject1).fjD.fjL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.c
 * JD-Core Version:    0.7.0.1
 */