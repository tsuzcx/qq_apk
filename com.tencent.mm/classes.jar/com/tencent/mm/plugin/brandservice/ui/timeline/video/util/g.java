package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class g
{
  private static final String TAG = "MicroMsg.BizVideoMsgTransmit";
  public static final g pKI;
  
  static
  {
    AppMethodBeat.i(7300);
    pKI = new g();
    TAG = "MicroMsg.BizVideoMsgTransmit";
    AppMethodBeat.o(7300);
  }
  
  public static void a(Context paramContext, x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(7297);
    p.h(paramContext, "context");
    p.h(paramx, "msg");
    p.h(paramb, "controller");
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (paramb.cpW())
    {
      localObject2 = (Map)localHashMap;
      paramx = paramb.pHB;
      if (paramx != null)
      {
        paramx = paramx.iAo;
        paramx = Util.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
        ((Map)localObject2).put("img_url", paramx);
        localObject2 = (Map)localHashMap;
        paramx = paramb.pHB;
        if (paramx == null) {
          break label339;
        }
        paramx = paramx.iAq;
        label106:
        paramx = Util.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
        ((Map)localObject2).put("desc", paramx);
        localObject2 = (Map)localHashMap;
        cmb localcmb = paramb.pHB;
        paramx = (x)localObject1;
        if (localcmb != null) {
          paramx = localcmb.title;
        }
        paramx = Util.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
        ((Map)localObject2).put("title", paramx);
      }
    }
    for (;;)
    {
      paramx = (Map)localHashMap;
      localObject1 = paramb.url;
      if (localObject1 == null) {
        p.hyc();
      }
      paramx.put("url", localObject1);
      Log.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramb.url });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(157L, 5L, 1L, false);
      paramx = new Intent();
      paramx.putExtra("Select_Conv_Type", 3);
      paramx.putExtra("scene_from", 2);
      paramx.putExtra("mutil_select_is_ret", true);
      paramx.putExtra("webview_params", (Serializable)localHashMap);
      paramx.putExtra("Retr_Msg_Type", 2);
      c.c(paramContext, ".ui.transmit.SelectConversationUI", paramx, 2);
      AppMethodBeat.o(7297);
      return;
      paramx = null;
      break;
      label339:
      paramx = null;
      break label106;
      localObject1 = (Map)localHashMap;
      localObject2 = Util.nullAsNil(paramx.iAi.iAo);
      p.g(localObject2, "Util.nullAsNil(msg.item.cover)");
      ((Map)localObject1).put("img_url", localObject2);
      localObject1 = (Map)localHashMap;
      localObject2 = Util.nullAsNil(paramx.iAi.iAq);
      p.g(localObject2, "Util.nullAsNil(msg.item.digest)");
      ((Map)localObject1).put("desc", localObject2);
      localObject1 = (Map)localHashMap;
      paramx = Util.nullAsNil(paramx.iAi.title);
      p.g(paramx, "Util.nullAsNil(msg.item.title)");
      ((Map)localObject1).put("title", paramx);
    }
  }
  
  public static void a(String paramString1, x paramx, String paramString2, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, d<Bundle> paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(7298);
    p.h(paramString1, "toUser");
    p.h(paramx, "msgInfo");
    p.h(paramb, "controller");
    p.h(paramd, "callback");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.toUser = paramString1;
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.msd = paramString2;
    localAppMsgDataParcelable.pHv = paramx;
    int i;
    if (paramb.cpW())
    {
      i = 1;
      localAppMsgDataParcelable.pKf = i;
      paramString1 = paramb.pHB;
      if (paramString1 == null) {
        break label179;
      }
      paramString1 = paramString1.title;
      label101:
      localAppMsgDataParcelable.pKg = paramString1;
      paramString1 = paramb.pHB;
      if (paramString1 == null) {
        break label184;
      }
    }
    label179:
    label184:
    for (paramString1 = paramString1.iAq;; paramString1 = null)
    {
      localAppMsgDataParcelable.pKh = paramString1;
      paramx = paramb.pHB;
      paramString1 = localObject;
      if (paramx != null) {
        paramString1 = paramx.iAo;
      }
      localAppMsgDataParcelable.pKi = paramString1;
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localAppMsgDataParcelable, a.class, paramd);
      AppMethodBeat.o(7298);
      return;
      i = 0;
      break;
      paramString1 = null;
      break label101;
    }
  }
  
  public static boolean c(AppMsgDataParcelable paramAppMsgDataParcelable)
  {
    AppMethodBeat.i(7299);
    p.h(paramAppMsgDataParcelable, "data");
    Object localObject1 = paramAppMsgDataParcelable.pHv;
    if (localObject1 == null)
    {
      Log.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(7299);
      return false;
    }
    int i;
    Object localObject2;
    Object localObject3;
    if (paramAppMsgDataParcelable.pKf == 1)
    {
      i = 1;
      localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).webpageUrl = paramAppMsgDataParcelable.url;
      localObject3 = new WXMediaMessage();
      ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (i == 0) {
        break label644;
      }
      ((WXMediaMessage)localObject3).title = paramAppMsgDataParcelable.pKg;
      ((WXMediaMessage)localObject3).description = paramAppMsgDataParcelable.pKh;
      label108:
      localObject2 = new tt();
      ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject3);
      ((tt)localObject2).eaf.toUser = paramAppMsgDataParcelable.toUser;
      ((tt)localObject2).eaf.dMG = 2;
      if (!Util.isNullOrNil(((x)localObject1).dHc)) {
        break label673;
      }
      ((tt)localObject2).eaf.eag = ((x)localObject1).ajO();
      ((tt)localObject2).eaf.eah = aa.getDisplayName(((x)localObject1).ajO());
    }
    for (;;)
    {
      try
      {
        ((tt)localObject2).eaf.eaj = paramAppMsgDataParcelable.url;
        ((tt)localObject2).eaf.eam = Util.nullAsNil(((x)localObject1).iAh);
        localObject3 = ad.JX(((tt)localObject2).eaf.eam);
        localb = ad.aVe().G((String)localObject3, true);
        if (localb == null) {
          p.hyc();
        }
        localb.l("sendAppMsgScene", Integer.valueOf(2));
        localb.l("preChatName", ((x)localObject1).ajO());
        localb.l("preMsgIndex", Integer.valueOf(((x)localObject1).iAf));
        localb.l("prePublishId", ((x)localObject1).iAh);
        localb.l("preUsername", ((x)localObject1).ajO());
        int j = ((x)localObject1).iAi.type;
        if (j != -1)
        {
          localb.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
          localb.l("_tmpl_webview_transfer_scene", Integer.valueOf(11));
        }
        if (((x)localObject1).iAi.type == 5)
        {
          localb.l("_DATA_CENTER_VID", ((x)localObject1).iAi.vid);
          localb.l("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(((x)localObject1).iwg));
          localb.l("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)((x)localObject1).iAi.time));
          localb.l("_DATA_CENTER__DULATION", Integer.valueOf(((x)localObject1).iAi.iAs));
          localb.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((x)localObject1).iAi.videoWidth));
          localb.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((x)localObject1).iAi.videoHeight));
          if (i == 0) {
            continue;
          }
          localb.l("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.pKi);
          localb.l("_DATA_CENTER_DESC", paramAppMsgDataParcelable.pKh);
        }
        ((tt)localObject2).eaf.sessionId = ((String)localObject3);
        ((tt)localObject2).eaf.eak = paramAppMsgDataParcelable.url;
      }
      catch (Exception localException)
      {
        ad.b localb;
        boolean bool;
        label644:
        label673:
        Log.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
        continue;
      }
      bool = EventCenter.instance.publish((IEvent)localObject2);
      if (!Util.isNullOrNil(paramAppMsgDataParcelable.msd))
      {
        localObject1 = new tw();
        ((tw)localObject1).eaq.dkV = paramAppMsgDataParcelable.toUser;
        ((tw)localObject1).eaq.content = paramAppMsgDataParcelable.msd;
        ((tw)localObject1).eaq.type = ab.JG(paramAppMsgDataParcelable.toUser);
        ((tw)localObject1).eaq.flags = 0;
        EventCenter.instance.publish((IEvent)localObject1);
      }
      AppMethodBeat.o(7299);
      return bool;
      i = 0;
      break;
      ((WXMediaMessage)localObject3).title = ((x)localObject1).iAi.title;
      ((WXMediaMessage)localObject3).description = ((x)localObject1).iAi.iAq;
      break label108;
      ((tt)localObject2).eaf.eag = ((x)localObject1).dHc;
      ((tt)localObject2).eaf.eah = ((x)localObject1).iAg;
      continue;
      localb.l("_DATA_CENTER_COVER_URL", ((x)localObject1).iAi.iAo);
      localb.l("_DATA_CENTER_DESC", ((x)localObject1).iAi.iAq);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g
 * JD-Core Version:    0.7.0.1
 */