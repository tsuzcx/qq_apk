package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.w;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class g
{
  private static final String TAG = "MicroMsg.BizVideoMsgTransmit";
  public static final g oxe;
  
  static
  {
    AppMethodBeat.i(7300);
    oxe = new g();
    TAG = "MicroMsg.BizVideoMsgTransmit";
    AppMethodBeat.o(7300);
  }
  
  public static void a(Context paramContext, com.tencent.mm.ah.x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(7297);
    p.h(paramContext, "context");
    p.h(paramx, "msg");
    p.h(paramb, "controller");
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (paramb.bSm())
    {
      localObject2 = (Map)localHashMap;
      paramx = paramb.oue;
      if (paramx != null)
      {
        paramx = paramx.hGe;
        paramx = bu.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
        ((Map)localObject2).put("img_url", paramx);
        localObject2 = (Map)localHashMap;
        paramx = paramb.oue;
        if (paramx == null) {
          break label339;
        }
        paramx = paramx.hGg;
        label106:
        paramx = bu.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
        ((Map)localObject2).put("desc", paramx);
        localObject2 = (Map)localHashMap;
        byj localbyj = paramb.oue;
        paramx = (com.tencent.mm.ah.x)localObject1;
        if (localbyj != null) {
          paramx = localbyj.title;
        }
        paramx = bu.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
        ((Map)localObject2).put("title", paramx);
      }
    }
    for (;;)
    {
      paramx = (Map)localHashMap;
      localObject1 = paramb.url;
      if (localObject1 == null) {
        p.gkB();
      }
      paramx.put("url", localObject1);
      ae.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramb.url });
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(157L, 5L, 1L, false);
      paramx = new Intent();
      paramx.putExtra("Select_Conv_Type", 3);
      paramx.putExtra("scene_from", 2);
      paramx.putExtra("mutil_select_is_ret", true);
      paramx.putExtra("webview_params", (Serializable)localHashMap);
      paramx.putExtra("Retr_Msg_Type", 2);
      com.tencent.mm.br.d.c(paramContext, ".ui.transmit.SelectConversationUI", paramx, 2);
      AppMethodBeat.o(7297);
      return;
      paramx = null;
      break;
      label339:
      paramx = null;
      break label106;
      localObject1 = (Map)localHashMap;
      localObject2 = bu.nullAsNil(paramx.hFY.hGe);
      p.g(localObject2, "Util.nullAsNil(msg.item.cover)");
      ((Map)localObject1).put("img_url", localObject2);
      localObject1 = (Map)localHashMap;
      localObject2 = bu.nullAsNil(paramx.hFY.hGg);
      p.g(localObject2, "Util.nullAsNil(msg.item.digest)");
      ((Map)localObject1).put("desc", localObject2);
      localObject1 = (Map)localHashMap;
      paramx = bu.nullAsNil(paramx.hFY.title);
      p.g(paramx, "Util.nullAsNil(msg.item.title)");
      ((Map)localObject1).put("title", paramx);
    }
  }
  
  public static void a(String paramString1, com.tencent.mm.ah.x paramx, String paramString2, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
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
    localAppMsgDataParcelable.lmh = paramString2;
    localAppMsgDataParcelable.otY = paramx;
    int i;
    if (paramb.bSm())
    {
      i = 1;
      localAppMsgDataParcelable.owB = i;
      paramString1 = paramb.oue;
      if (paramString1 == null) {
        break label178;
      }
      paramString1 = paramString1.title;
      label101:
      localAppMsgDataParcelable.owC = paramString1;
      paramString1 = paramb.oue;
      if (paramString1 == null) {
        break label183;
      }
    }
    label178:
    label183:
    for (paramString1 = paramString1.hGg;; paramString1 = null)
    {
      localAppMsgDataParcelable.owD = paramString1;
      paramx = paramb.oue;
      paramString1 = localObject;
      if (paramx != null) {
        paramString1 = paramx.hGe;
      }
      localAppMsgDataParcelable.owE = paramString1;
      h.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, a.class, paramd);
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
    Object localObject1 = paramAppMsgDataParcelable.otY;
    if (localObject1 == null)
    {
      ae.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(7299);
      return false;
    }
    int i;
    Object localObject2;
    Object localObject3;
    if (paramAppMsgDataParcelable.owB == 1)
    {
      i = 1;
      localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).webpageUrl = paramAppMsgDataParcelable.url;
      localObject3 = new WXMediaMessage();
      ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (i == 0) {
        break label644;
      }
      ((WXMediaMessage)localObject3).title = paramAppMsgDataParcelable.owC;
      ((WXMediaMessage)localObject3).description = paramAppMsgDataParcelable.owD;
      label108:
      localObject2 = new sv();
      ((sv)localObject2).dIs.dve = ((WXMediaMessage)localObject3);
      ((sv)localObject2).dIs.toUser = paramAppMsgDataParcelable.toUser;
      ((sv)localObject2).dIs.dvf = 2;
      if (!bu.isNullOrNil(((com.tencent.mm.ah.x)localObject1).dpP)) {
        break label673;
      }
      ((sv)localObject2).dIs.dIt = ((com.tencent.mm.ah.x)localObject1).Wa();
      ((sv)localObject2).dIs.dIu = w.zP(((com.tencent.mm.ah.x)localObject1).Wa());
    }
    for (;;)
    {
      try
      {
        ((sv)localObject2).dIs.dIw = paramAppMsgDataParcelable.url;
        ((sv)localObject2).dIs.dIz = bu.nullAsNil(((com.tencent.mm.ah.x)localObject1).hFX);
        localObject3 = z.Br(((sv)localObject2).dIs.dIz);
        localb = z.aBG().F((String)localObject3, true);
        if (localb == null) {
          p.gkB();
        }
        localb.k("sendAppMsgScene", Integer.valueOf(2));
        localb.k("preChatName", ((com.tencent.mm.ah.x)localObject1).Wa());
        localb.k("preMsgIndex", Integer.valueOf(((com.tencent.mm.ah.x)localObject1).hFV));
        localb.k("prePublishId", ((com.tencent.mm.ah.x)localObject1).hFX);
        localb.k("preUsername", ((com.tencent.mm.ah.x)localObject1).Wa());
        int j = ((com.tencent.mm.ah.x)localObject1).hFY.type;
        if (j != -1)
        {
          localb.k("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
          localb.k("_tmpl_webview_transfer_scene", Integer.valueOf(11));
        }
        if (((com.tencent.mm.ah.x)localObject1).hFY.type == 5)
        {
          localb.k("_DATA_CENTER_VID", ((com.tencent.mm.ah.x)localObject1).hFY.hCa);
          localb.k("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(((com.tencent.mm.ah.x)localObject1).hBZ));
          localb.k("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)((com.tencent.mm.ah.x)localObject1).hFY.time));
          localb.k("_DATA_CENTER__DULATION", Integer.valueOf(((com.tencent.mm.ah.x)localObject1).hFY.hGi));
          localb.k("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((com.tencent.mm.ah.x)localObject1).hFY.videoWidth));
          localb.k("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((com.tencent.mm.ah.x)localObject1).hFY.videoHeight));
          if (i == 0) {
            continue;
          }
          localb.k("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.owE);
          localb.k("_DATA_CENTER_DESC", paramAppMsgDataParcelable.owD);
        }
        ((sv)localObject2).dIs.sessionId = ((String)localObject3);
        ((sv)localObject2).dIs.dIx = paramAppMsgDataParcelable.url;
      }
      catch (Exception localException)
      {
        z.b localb;
        boolean bool;
        label644:
        label673:
        ae.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
        continue;
      }
      bool = a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      if (!bu.isNullOrNil(paramAppMsgDataParcelable.lmh))
      {
        localObject1 = new sy();
        ((sy)localObject1).dID.cUB = paramAppMsgDataParcelable.toUser;
        ((sy)localObject1).dID.content = paramAppMsgDataParcelable.lmh;
        ((sy)localObject1).dID.type = com.tencent.mm.model.x.Bb(paramAppMsgDataParcelable.toUser);
        ((sy)localObject1).dID.flags = 0;
        a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(7299);
      return bool;
      i = 0;
      break;
      ((WXMediaMessage)localObject3).title = ((com.tencent.mm.ah.x)localObject1).hFY.title;
      ((WXMediaMessage)localObject3).description = ((com.tencent.mm.ah.x)localObject1).hFY.hGg;
      break label108;
      ((sv)localObject2).dIs.dIt = ((com.tencent.mm.ah.x)localObject1).dpP;
      ((sv)localObject2).dIs.dIu = ((com.tencent.mm.ah.x)localObject1).hFW;
      continue;
      localb.k("_DATA_CENTER_COVER_URL", ((com.tencent.mm.ah.x)localObject1).hFY.hGe);
      localb.k("_DATA_CENTER_DESC", ((com.tencent.mm.ah.x)localObject1).hFY.hGg);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g
 * JD-Core Version:    0.7.0.1
 */