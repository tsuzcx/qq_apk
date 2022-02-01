package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.ry.a;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class g
{
  private static final String TAG = "MicroMsg.BizVideoMsgTransmit";
  public static final g nlc;
  
  static
  {
    AppMethodBeat.i(7300);
    nlc = new g();
    TAG = "MicroMsg.BizVideoMsgTransmit";
    AppMethodBeat.o(7300);
  }
  
  public static void a(Context paramContext, x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(7297);
    k.h(paramContext, "context");
    k.h(paramx, "msg");
    k.h(paramb, "controller");
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (paramb.bFy())
    {
      localObject2 = (Map)localHashMap;
      paramx = paramb.niO;
      if (paramx != null)
      {
        paramx = paramx.gKD;
        paramx = bt.nullAsNil(paramx);
        k.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
        ((Map)localObject2).put("img_url", paramx);
        localObject2 = (Map)localHashMap;
        paramx = paramb.niO;
        if (paramx == null) {
          break label339;
        }
        paramx = paramx.gKF;
        label106:
        paramx = bt.nullAsNil(paramx);
        k.g(paramx, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
        ((Map)localObject2).put("desc", paramx);
        localObject2 = (Map)localHashMap;
        bol localbol = paramb.niO;
        paramx = (x)localObject1;
        if (localbol != null) {
          paramx = localbol.title;
        }
        paramx = bt.nullAsNil(paramx);
        k.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
        ((Map)localObject2).put("title", paramx);
      }
    }
    for (;;)
    {
      paramx = (Map)localHashMap;
      localObject1 = paramb.url;
      if (localObject1 == null) {
        k.fvU();
      }
      paramx.put("url", localObject1);
      ad.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramb.url });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(157L, 5L, 1L, false);
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
      localObject2 = bt.nullAsNil(paramx.gKx.gKD);
      k.g(localObject2, "Util.nullAsNil(msg.item.cover)");
      ((Map)localObject1).put("img_url", localObject2);
      localObject1 = (Map)localHashMap;
      localObject2 = bt.nullAsNil(paramx.gKx.gKF);
      k.g(localObject2, "Util.nullAsNil(msg.item.digest)");
      ((Map)localObject1).put("desc", localObject2);
      localObject1 = (Map)localHashMap;
      paramx = bt.nullAsNil(paramx.gKx.title);
      k.g(paramx, "Util.nullAsNil(msg.item.title)");
      ((Map)localObject1).put("title", paramx);
    }
  }
  
  public static void a(String paramString1, x paramx, String paramString2, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, com.tencent.mm.ipcinvoker.d<Bundle> paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(7298);
    k.h(paramString1, "toUser");
    k.h(paramx, "msgInfo");
    k.h(paramb, "controller");
    k.h(paramd, "callback");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.toUser = paramString1;
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.kkB = paramString2;
    localAppMsgDataParcelable.niI = paramx;
    int i;
    if (paramb.bFy())
    {
      i = 1;
      localAppMsgDataParcelable.nkz = i;
      paramString1 = paramb.niO;
      if (paramString1 == null) {
        break label178;
      }
      paramString1 = paramString1.title;
      label101:
      localAppMsgDataParcelable.nkA = paramString1;
      paramString1 = paramb.niO;
      if (paramString1 == null) {
        break label183;
      }
    }
    label178:
    label183:
    for (paramString1 = paramString1.gKF;; paramString1 = null)
    {
      localAppMsgDataParcelable.nkB = paramString1;
      paramx = paramb.niO;
      paramString1 = localObject;
      if (paramx != null) {
        paramString1 = paramx.gKD;
      }
      localAppMsgDataParcelable.nkC = paramString1;
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, a.class, paramd);
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
    k.h(paramAppMsgDataParcelable, "data");
    Object localObject1 = paramAppMsgDataParcelable.niI;
    if (localObject1 == null)
    {
      ad.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(7299);
      return false;
    }
    int i;
    Object localObject2;
    Object localObject3;
    if (paramAppMsgDataParcelable.nkz == 1)
    {
      i = 1;
      localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).webpageUrl = paramAppMsgDataParcelable.url;
      localObject3 = new WXMediaMessage();
      ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (i == 0) {
        break label644;
      }
      ((WXMediaMessage)localObject3).title = paramAppMsgDataParcelable.nkA;
      ((WXMediaMessage)localObject3).description = paramAppMsgDataParcelable.nkB;
      label108:
      localObject2 = new ry();
      ((ry)localObject2).dxx.doG = ((WXMediaMessage)localObject3);
      ((ry)localObject2).dxx.toUser = paramAppMsgDataParcelable.toUser;
      ((ry)localObject2).dxx.dxy = 2;
      if (!bt.isNullOrNil(((x)localObject1).dfT)) {
        break label673;
      }
      ((ry)localObject2).dxx.dxz = ((x)localObject1).SI();
      ((ry)localObject2).dxx.dxA = com.tencent.mm.model.v.sh(((x)localObject1).SI());
    }
    for (;;)
    {
      try
      {
        ((ry)localObject2).dxx.dxC = paramAppMsgDataParcelable.url;
        ((ry)localObject2).dxx.dxF = bt.nullAsNil(((x)localObject1).gKw);
        localObject3 = y.tD(((ry)localObject2).dxx.dxF);
        localb = y.arz().E((String)localObject3, true);
        if (localb == null) {
          k.fvU();
        }
        localb.m("sendAppMsgScene", Integer.valueOf(2));
        localb.m("preChatName", ((x)localObject1).SI());
        localb.m("preMsgIndex", Integer.valueOf(((x)localObject1).gKu));
        localb.m("prePublishId", ((x)localObject1).gKw);
        localb.m("preUsername", ((x)localObject1).SI());
        int j = ((x)localObject1).gKx.type;
        if (j != -1)
        {
          localb.m("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
          localb.m("_tmpl_webview_transfer_scene", Integer.valueOf(11));
        }
        if (((x)localObject1).gKx.type == 5)
        {
          localb.m("_DATA_CENTER_VID", ((x)localObject1).gKx.gGC);
          localb.m("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(((x)localObject1).gGB));
          localb.m("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)((x)localObject1).gKx.time));
          localb.m("_DATA_CENTER__DULATION", Integer.valueOf(((x)localObject1).gKx.gKH));
          localb.m("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((x)localObject1).gKx.videoWidth));
          localb.m("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((x)localObject1).gKx.videoHeight));
          if (i == 0) {
            continue;
          }
          localb.m("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.nkC);
          localb.m("_DATA_CENTER_DESC", paramAppMsgDataParcelable.nkB);
        }
        ((ry)localObject2).dxx.sessionId = ((String)localObject3);
        ((ry)localObject2).dxx.dxD = paramAppMsgDataParcelable.url;
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
      bool = a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (!bt.isNullOrNil(paramAppMsgDataParcelable.kkB))
      {
        localObject1 = new sb();
        ((sb)localObject1).dxJ.dxK = paramAppMsgDataParcelable.toUser;
        ((sb)localObject1).dxJ.content = paramAppMsgDataParcelable.kkB;
        ((sb)localObject1).dxJ.type = w.tq(paramAppMsgDataParcelable.toUser);
        ((sb)localObject1).dxJ.flags = 0;
        a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(7299);
      return bool;
      i = 0;
      break;
      ((WXMediaMessage)localObject3).title = ((x)localObject1).gKx.title;
      ((WXMediaMessage)localObject3).description = ((x)localObject1).gKx.gKF;
      break label108;
      ((ry)localObject2).dxx.dxz = ((x)localObject1).dfT;
      ((ry)localObject2).dxx.dxA = ((x)localObject1).gKv;
      continue;
      localb.m("_DATA_CENTER_COVER_URL", ((x)localObject1).gKx.gKD);
      localb.m("_DATA_CENTER_DESC", ((x)localObject1).gKx.gKF);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g
 * JD-Core Version:    0.7.0.1
 */