package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine;", "", "()V", "TAG", "", "doSetTimelineData", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "sessionId", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_ShareToTimeLine", "plugin-brandservice_release"})
public final class f
{
  private static final String TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
  public static final f pKH;
  
  static
  {
    AppMethodBeat.i(7295);
    pKH = new f();
    TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
    AppMethodBeat.o(7295);
  }
  
  public static void a(x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, String paramString, d<Bundle> paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(7293);
    p.h(paramx, "msgInfo");
    p.h(paramb, "controller");
    p.h(paramString, "sessionId");
    p.h(paramd, "callback");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.sessionId = paramString;
    localAppMsgDataParcelable.pHv = paramx;
    int i;
    if (paramb.cpW())
    {
      i = 1;
      localAppMsgDataParcelable.pKf = i;
      paramx = paramb.pHB;
      if (paramx == null) {
        break label171;
      }
      paramx = paramx.title;
      label94:
      localAppMsgDataParcelable.pKg = paramx;
      paramx = paramb.pHB;
      if (paramx == null) {
        break label176;
      }
    }
    label171:
    label176:
    for (paramx = paramx.iAq;; paramx = null)
    {
      localAppMsgDataParcelable.pKh = paramx;
      paramb = paramb.pHB;
      paramx = localObject;
      if (paramb != null) {
        paramx = paramb.iAo;
      }
      localAppMsgDataParcelable.pKi = paramx;
      h.a(MainProcessIPCService.dkO, (Parcelable)localAppMsgDataParcelable, a.class, paramd);
      AppMethodBeat.o(7293);
      return;
      i = 0;
      break;
      paramx = null;
      break label94;
    }
  }
  
  public static void b(AppMsgDataParcelable paramAppMsgDataParcelable)
  {
    AppMethodBeat.i(7294);
    p.h(paramAppMsgDataParcelable, "data");
    x localx = paramAppMsgDataParcelable.pHv;
    if (localx == null)
    {
      Log.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7294);
      return;
    }
    int i;
    ad.b localb;
    if (paramAppMsgDataParcelable.pKf == 1)
    {
      i = 1;
      localb = ad.aVe().G(paramAppMsgDataParcelable.sessionId, true);
      localb.l("sendAppMsgScene", Integer.valueOf(2));
      localb.l("preChatName", localx.ajO());
      localb.l("preMsgIndex", Integer.valueOf(localx.iAf));
      localb.l("prePublishId", localx.iAh);
      localb.l("preUsername", localx.ajO());
      localb.l("url", paramAppMsgDataParcelable.url);
      localb.l("referUrl", paramAppMsgDataParcelable.url);
      int j = localx.iAi.type;
      if (j != -1)
      {
        localb.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
        if (localx.iAi.type == 5)
        {
          localb.l("_DATA_CENTER_VID", localx.iAi.vid);
          localb.l("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)localx.iAi.time));
          localb.l("_DATA_CENTER__DULATION", Integer.valueOf(localx.iAi.iAs));
          if (i == 0) {
            break label350;
          }
          localb.l("_DATA_CENTER_DESC", paramAppMsgDataParcelable.pKh);
          localb.l("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.pKi);
        }
      }
    }
    for (;;)
    {
      localb.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(localx.iAi.videoWidth));
      localb.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(localx.iAi.videoHeight));
      localb.l("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
      localb.l("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(localx.iwg));
      localb.l("_tmpl_webview_transfer_scene", Integer.valueOf(10));
      AppMethodBeat.o(7294);
      return;
      i = 0;
      break;
      label350:
      localb.l("_DATA_CENTER_DESC", localx.iAi.iAq);
      localb.l("_DATA_CENTER_COVER_URL", localx.iAi.iAo);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine$IPCInvoke_ShareToTimeLine;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f
 * JD-Core Version:    0.7.0.1
 */