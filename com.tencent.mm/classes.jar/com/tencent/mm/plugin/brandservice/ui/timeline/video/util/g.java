package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class g
{
  private static final String TAG = "MicroMsg.BizVideoMsgTransmit";
  public static final g oqI;
  
  static
  {
    AppMethodBeat.i(7300);
    oqI = new g();
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
    if (paramb.bRl())
    {
      localObject2 = (Map)localHashMap;
      paramx = paramb.oon;
      if (paramx != null)
      {
        paramx = paramx.hDm;
        paramx = bt.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
        ((Map)localObject2).put("img_url", paramx);
        localObject2 = (Map)localHashMap;
        paramx = paramb.oon;
        if (paramx == null) {
          break label339;
        }
        paramx = paramx.hDo;
        label106:
        paramx = bt.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
        ((Map)localObject2).put("desc", paramx);
        localObject2 = (Map)localHashMap;
        bxp localbxp = paramb.oon;
        paramx = (x)localObject1;
        if (localbxp != null) {
          paramx = localbxp.title;
        }
        paramx = bt.nullAsNil(paramx);
        p.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
        ((Map)localObject2).put("title", paramx);
      }
    }
    for (;;)
    {
      paramx = (Map)localHashMap;
      localObject1 = paramb.url;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramx.put("url", localObject1);
      ad.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramb.url });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(157L, 5L, 1L, false);
      paramx = new Intent();
      paramx.putExtra("Select_Conv_Type", 3);
      paramx.putExtra("scene_from", 2);
      paramx.putExtra("mutil_select_is_ret", true);
      paramx.putExtra("webview_params", (Serializable)localHashMap);
      paramx.putExtra("Retr_Msg_Type", 2);
      com.tencent.mm.bs.d.c(paramContext, ".ui.transmit.SelectConversationUI", paramx, 2);
      AppMethodBeat.o(7297);
      return;
      paramx = null;
      break;
      label339:
      paramx = null;
      break label106;
      localObject1 = (Map)localHashMap;
      localObject2 = bt.nullAsNil(paramx.hDg.hDm);
      p.g(localObject2, "Util.nullAsNil(msg.item.cover)");
      ((Map)localObject1).put("img_url", localObject2);
      localObject1 = (Map)localHashMap;
      localObject2 = bt.nullAsNil(paramx.hDg.hDo);
      p.g(localObject2, "Util.nullAsNil(msg.item.digest)");
      ((Map)localObject1).put("desc", localObject2);
      localObject1 = (Map)localHashMap;
      paramx = bt.nullAsNil(paramx.hDg.title);
      p.g(paramx, "Util.nullAsNil(msg.item.title)");
      ((Map)localObject1).put("title", paramx);
    }
  }
  
  public static void a(String paramString1, x paramx, String paramString2, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
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
    localAppMsgDataParcelable.liv = paramString2;
    localAppMsgDataParcelable.ooh = paramx;
    int i;
    if (paramb.bRl())
    {
      i = 1;
      localAppMsgDataParcelable.oqf = i;
      paramString1 = paramb.oon;
      if (paramString1 == null) {
        break label178;
      }
      paramString1 = paramString1.title;
      label101:
      localAppMsgDataParcelable.oqg = paramString1;
      paramString1 = paramb.oon;
      if (paramString1 == null) {
        break label183;
      }
    }
    label178:
    label183:
    for (paramString1 = paramString1.hDo;; paramString1 = null)
    {
      localAppMsgDataParcelable.oqh = paramString1;
      paramx = paramb.oon;
      paramString1 = localObject;
      if (paramx != null) {
        paramString1 = paramx.hDm;
      }
      localAppMsgDataParcelable.oqi = paramString1;
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
    Object localObject1 = paramAppMsgDataParcelable.ooh;
    if (localObject1 == null)
    {
      ad.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(7299);
      return false;
    }
    int i;
    Object localObject2;
    Object localObject3;
    if (paramAppMsgDataParcelable.oqf == 1)
    {
      i = 1;
      localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).webpageUrl = paramAppMsgDataParcelable.url;
      localObject3 = new WXMediaMessage();
      ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (i == 0) {
        break label644;
      }
      ((WXMediaMessage)localObject3).title = paramAppMsgDataParcelable.oqg;
      ((WXMediaMessage)localObject3).description = paramAppMsgDataParcelable.oqh;
      label108:
      localObject2 = new su();
      ((su)localObject2).dHn.dtZ = ((WXMediaMessage)localObject3);
      ((su)localObject2).dHn.toUser = paramAppMsgDataParcelable.toUser;
      ((su)localObject2).dHn.dua = 2;
      if (!bt.isNullOrNil(((x)localObject1).doK)) {
        break label673;
      }
      ((su)localObject2).dHn.dHo = ((x)localObject1).VS();
      ((su)localObject2).dHn.dHp = com.tencent.mm.model.v.zf(((x)localObject1).VS());
    }
    for (;;)
    {
      try
      {
        ((su)localObject2).dHn.dHr = paramAppMsgDataParcelable.url;
        ((su)localObject2).dHn.dHu = bt.nullAsNil(((x)localObject1).hDf);
        localObject3 = y.AH(((su)localObject2).dHn.dHu);
        localb = y.aBq().F((String)localObject3, true);
        if (localb == null) {
          p.gfZ();
        }
        localb.k("sendAppMsgScene", Integer.valueOf(2));
        localb.k("preChatName", ((x)localObject1).VS());
        localb.k("preMsgIndex", Integer.valueOf(((x)localObject1).hDd));
        localb.k("prePublishId", ((x)localObject1).hDf);
        localb.k("preUsername", ((x)localObject1).VS());
        int j = ((x)localObject1).hDg.type;
        if (j != -1)
        {
          localb.k("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
          localb.k("_tmpl_webview_transfer_scene", Integer.valueOf(11));
        }
        if (((x)localObject1).hDg.type == 5)
        {
          localb.k("_DATA_CENTER_VID", ((x)localObject1).hDg.hzm);
          localb.k("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(((x)localObject1).hzl));
          localb.k("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)((x)localObject1).hDg.time));
          localb.k("_DATA_CENTER__DULATION", Integer.valueOf(((x)localObject1).hDg.hDq));
          localb.k("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((x)localObject1).hDg.videoWidth));
          localb.k("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((x)localObject1).hDg.videoHeight));
          if (i == 0) {
            continue;
          }
          localb.k("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.oqi);
          localb.k("_DATA_CENTER_DESC", paramAppMsgDataParcelable.oqh);
        }
        ((su)localObject2).dHn.sessionId = ((String)localObject3);
        ((su)localObject2).dHn.dHs = paramAppMsgDataParcelable.url;
      }
      catch (Exception localException)
      {
        y.b localb;
        boolean bool;
        label644:
        label673:
        ad.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
        continue;
      }
      bool = a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (!bt.isNullOrNil(paramAppMsgDataParcelable.liv))
      {
        localObject1 = new sx();
        ((sx)localObject1).dHy.dHz = paramAppMsgDataParcelable.toUser;
        ((sx)localObject1).dHy.content = paramAppMsgDataParcelable.liv;
        ((sx)localObject1).dHy.type = w.Ar(paramAppMsgDataParcelable.toUser);
        ((sx)localObject1).dHy.flags = 0;
        a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(7299);
      return bool;
      i = 0;
      break;
      ((WXMediaMessage)localObject3).title = ((x)localObject1).hDg.title;
      ((WXMediaMessage)localObject3).description = ((x)localObject1).hDg.hDo;
      break label108;
      ((su)localObject2).dHn.dHo = ((x)localObject1).doK;
      ((su)localObject2).dHn.dHp = ((x)localObject1).hDe;
      continue;
      localb.k("_DATA_CENTER_COVER_URL", ((x)localObject1).hDg.hDm);
      localb.k("_DATA_CENTER_DESC", ((x)localObject1).hDg.hDo);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g
 * JD-Core Version:    0.7.0.1
 */