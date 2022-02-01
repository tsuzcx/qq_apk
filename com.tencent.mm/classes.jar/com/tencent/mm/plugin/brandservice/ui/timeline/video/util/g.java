package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.sh.a;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "transmitBizVideoMsg", "context", "Landroid/content/Context;", "msg", "IPCInvoke_SendAppMsg", "plugin-brandservice_release"})
public final class g
{
  private static final String TAG = "MicroMsg.BizVideoMsgTransmit";
  public static final g nOc;
  
  static
  {
    AppMethodBeat.i(7300);
    nOc = new g();
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
    if (paramb.bML())
    {
      localObject2 = (Map)localHashMap;
      paramx = paramb.nLH;
      if (paramx != null)
      {
        paramx = paramx.hld;
        paramx = bs.nullAsNil(paramx);
        k.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
        ((Map)localObject2).put("img_url", paramx);
        localObject2 = (Map)localHashMap;
        paramx = paramb.nLH;
        if (paramx == null) {
          break label339;
        }
        paramx = paramx.hlf;
        label106:
        paramx = bs.nullAsNil(paramx);
        k.g(paramx, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
        ((Map)localObject2).put("desc", paramx);
        localObject2 = (Map)localHashMap;
        btb localbtb = paramb.nLH;
        paramx = (x)localObject1;
        if (localbtb != null) {
          paramx = localbtb.title;
        }
        paramx = bs.nullAsNil(paramx);
        k.g(paramx, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
        ((Map)localObject2).put("title", paramx);
      }
    }
    for (;;)
    {
      paramx = (Map)localHashMap;
      localObject1 = paramb.url;
      if (localObject1 == null) {
        k.fOy();
      }
      paramx.put("url", localObject1);
      ac.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", new Object[] { localHashMap.get("img_url"), localHashMap.get("desc"), localHashMap.get("title"), paramb.url });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(157L, 5L, 1L, false);
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
      localObject2 = bs.nullAsNil(paramx.hkX.hld);
      k.g(localObject2, "Util.nullAsNil(msg.item.cover)");
      ((Map)localObject1).put("img_url", localObject2);
      localObject1 = (Map)localHashMap;
      localObject2 = bs.nullAsNil(paramx.hkX.hlf);
      k.g(localObject2, "Util.nullAsNil(msg.item.digest)");
      ((Map)localObject1).put("desc", localObject2);
      localObject1 = (Map)localHashMap;
      paramx = bs.nullAsNil(paramx.hkX.title);
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
    localAppMsgDataParcelable.kLS = paramString2;
    localAppMsgDataParcelable.nLB = paramx;
    int i;
    if (paramb.bML())
    {
      i = 1;
      localAppMsgDataParcelable.nNz = i;
      paramString1 = paramb.nLH;
      if (paramString1 == null) {
        break label178;
      }
      paramString1 = paramString1.title;
      label101:
      localAppMsgDataParcelable.nNA = paramString1;
      paramString1 = paramb.nLH;
      if (paramString1 == null) {
        break label183;
      }
    }
    label178:
    label183:
    for (paramString1 = paramString1.hlf;; paramString1 = null)
    {
      localAppMsgDataParcelable.nNB = paramString1;
      paramx = paramb.nLH;
      paramString1 = localObject;
      if (paramx != null) {
        paramString1 = paramx.hld;
      }
      localAppMsgDataParcelable.nNC = paramString1;
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
    Object localObject1 = paramAppMsgDataParcelable.nLB;
    if (localObject1 == null)
    {
      ac.w(TAG, "doSendAppMsg msgInfo is null");
      AppMethodBeat.o(7299);
      return false;
    }
    int i;
    Object localObject2;
    Object localObject3;
    if (paramAppMsgDataParcelable.nNz == 1)
    {
      i = 1;
      localObject2 = new WXWebpageObject();
      ((WXWebpageObject)localObject2).webpageUrl = paramAppMsgDataParcelable.url;
      localObject3 = new WXMediaMessage();
      ((WXMediaMessage)localObject3).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
      if (i == 0) {
        break label644;
      }
      ((WXMediaMessage)localObject3).title = paramAppMsgDataParcelable.nNA;
      ((WXMediaMessage)localObject3).description = paramAppMsgDataParcelable.nNB;
      label108:
      localObject2 = new sh();
      ((sh)localObject2).dvk.dis = ((WXMediaMessage)localObject3);
      ((sh)localObject2).dvk.toUser = paramAppMsgDataParcelable.toUser;
      ((sh)localObject2).dvk.dit = 2;
      if (!bs.isNullOrNil(((x)localObject1).ddo)) {
        break label673;
      }
      ((sh)localObject2).dvk.dvl = ((x)localObject1).TC();
      ((sh)localObject2).dvk.dvm = com.tencent.mm.model.v.wk(((x)localObject1).TC());
    }
    for (;;)
    {
      try
      {
        ((sh)localObject2).dvk.dvo = paramAppMsgDataParcelable.url;
        ((sh)localObject2).dvk.dvr = bs.nullAsNil(((x)localObject1).hkW);
        localObject3 = y.xJ(((sh)localObject2).dvk.dvr);
        localb = y.ayq().F((String)localObject3, true);
        if (localb == null) {
          k.fOy();
        }
        localb.l("sendAppMsgScene", Integer.valueOf(2));
        localb.l("preChatName", ((x)localObject1).TC());
        localb.l("preMsgIndex", Integer.valueOf(((x)localObject1).hkU));
        localb.l("prePublishId", ((x)localObject1).hkW);
        localb.l("preUsername", ((x)localObject1).TC());
        int j = ((x)localObject1).hkX.type;
        if (j != -1)
        {
          localb.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
          localb.l("_tmpl_webview_transfer_scene", Integer.valueOf(11));
        }
        if (((x)localObject1).hkX.type == 5)
        {
          localb.l("_DATA_CENTER_VID", ((x)localObject1).hkX.hhd);
          localb.l("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(((x)localObject1).hhc));
          localb.l("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)((x)localObject1).hkX.time));
          localb.l("_DATA_CENTER__DULATION", Integer.valueOf(((x)localObject1).hkX.hlh));
          localb.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(((x)localObject1).hkX.videoWidth));
          localb.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(((x)localObject1).hkX.videoHeight));
          if (i == 0) {
            continue;
          }
          localb.l("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.nNC);
          localb.l("_DATA_CENTER_DESC", paramAppMsgDataParcelable.nNB);
        }
        ((sh)localObject2).dvk.sessionId = ((String)localObject3);
        ((sh)localObject2).dvk.dvp = paramAppMsgDataParcelable.url;
      }
      catch (Exception localException)
      {
        y.b localb;
        boolean bool;
        label644:
        label673:
        ac.e(TAG, "init bunddata failed : %s", new Object[] { localException.getMessage() });
        continue;
      }
      bool = a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      if (!bs.isNullOrNil(paramAppMsgDataParcelable.kLS))
      {
        localObject1 = new sk();
        ((sk)localObject1).dvv.dvw = paramAppMsgDataParcelable.toUser;
        ((sk)localObject1).dvv.content = paramAppMsgDataParcelable.kLS;
        ((sk)localObject1).dvv.type = w.xt(paramAppMsgDataParcelable.toUser);
        ((sk)localObject1).dvv.flags = 0;
        a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(7299);
      return bool;
      i = 0;
      break;
      ((WXMediaMessage)localObject3).title = ((x)localObject1).hkX.title;
      ((WXMediaMessage)localObject3).description = ((x)localObject1).hkX.hlf;
      break label108;
      ((sh)localObject2).dvk.dvl = ((x)localObject1).ddo;
      ((sh)localObject2).dvk.dvm = ((x)localObject1).hkV;
      continue;
      localb.l("_DATA_CENTER_COVER_URL", ((x)localObject1).hkX.hld);
      localb.l("_DATA_CENTER_DESC", ((x)localObject1).hkX.hlf);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit$IPCInvoke_SendAppMsg;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g
 * JD-Core Version:    0.7.0.1
 */