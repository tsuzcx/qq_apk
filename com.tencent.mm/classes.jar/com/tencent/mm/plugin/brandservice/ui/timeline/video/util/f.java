package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.ai.x;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine;", "", "()V", "TAG", "", "doSetTimelineData", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "sessionId", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_ShareToTimeLine", "plugin-brandservice_release"})
public final class f
{
  private static final String TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
  public static final f nlb;
  
  static
  {
    AppMethodBeat.i(7295);
    nlb = new f();
    TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
    AppMethodBeat.o(7295);
  }
  
  public static void a(x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, String paramString, d<Bundle> paramd)
  {
    Object localObject = null;
    AppMethodBeat.i(7293);
    k.h(paramx, "msgInfo");
    k.h(paramb, "controller");
    k.h(paramString, "sessionId");
    k.h(paramd, "callback");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.sessionId = paramString;
    localAppMsgDataParcelable.niI = paramx;
    int i;
    if (paramb.bFy())
    {
      i = 1;
      localAppMsgDataParcelable.nkz = i;
      paramx = paramb.niO;
      if (paramx == null) {
        break label170;
      }
      paramx = paramx.title;
      label94:
      localAppMsgDataParcelable.nkA = paramx;
      paramx = paramb.niO;
      if (paramx == null) {
        break label175;
      }
    }
    label170:
    label175:
    for (paramx = paramx.gKF;; paramx = null)
    {
      localAppMsgDataParcelable.nkB = paramx;
      paramb = paramb.niO;
      paramx = localObject;
      if (paramb != null) {
        paramx = paramb.gKD;
      }
      localAppMsgDataParcelable.nkC = paramx;
      h.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, a.class, paramd);
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
    k.h(paramAppMsgDataParcelable, "data");
    x localx = paramAppMsgDataParcelable.niI;
    if (localx == null)
    {
      ad.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7294);
      return;
    }
    int i;
    y.b localb;
    if (paramAppMsgDataParcelable.nkz == 1)
    {
      i = 1;
      localb = y.arz().E(paramAppMsgDataParcelable.sessionId, true);
      localb.m("sendAppMsgScene", Integer.valueOf(2));
      localb.m("preChatName", localx.SI());
      localb.m("preMsgIndex", Integer.valueOf(localx.gKu));
      localb.m("prePublishId", localx.gKw);
      localb.m("preUsername", localx.SI());
      localb.m("url", paramAppMsgDataParcelable.url);
      localb.m("referUrl", paramAppMsgDataParcelable.url);
      int j = localx.gKx.type;
      if (j != -1)
      {
        localb.m("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
        if (localx.gKx.type == 5)
        {
          localb.m("_DATA_CENTER_VID", localx.gKx.gGC);
          localb.m("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)localx.gKx.time));
          localb.m("_DATA_CENTER__DULATION", Integer.valueOf(localx.gKx.gKH));
          if (i == 0) {
            break label350;
          }
          localb.m("_DATA_CENTER_DESC", paramAppMsgDataParcelable.nkB);
          localb.m("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.nkC);
        }
      }
    }
    for (;;)
    {
      localb.m("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(localx.gKx.videoWidth));
      localb.m("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(localx.gKx.videoHeight));
      localb.m("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
      localb.m("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(localx.gGB));
      localb.m("_tmpl_webview_transfer_scene", Integer.valueOf(10));
      AppMethodBeat.o(7294);
      return;
      i = 0;
      break;
      label350:
      localb.m("_DATA_CENTER_DESC", localx.gKx.gKF);
      localb.m("_DATA_CENTER_COVER_URL", localx.gKx.gKD);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine$IPCInvoke_ShareToTimeLine;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f
 * JD-Core Version:    0.7.0.1
 */