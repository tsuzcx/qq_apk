package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.ah.x;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine;", "", "()V", "TAG", "", "doSetTimelineData", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "sessionId", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_ShareToTimeLine", "plugin-brandservice_release"})
public final class f
{
  private static final String TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
  public static final f nOb;
  
  static
  {
    AppMethodBeat.i(7295);
    nOb = new f();
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
    localAppMsgDataParcelable.nLB = paramx;
    int i;
    if (paramb.bML())
    {
      i = 1;
      localAppMsgDataParcelable.nNz = i;
      paramx = paramb.nLH;
      if (paramx == null) {
        break label170;
      }
      paramx = paramx.title;
      label94:
      localAppMsgDataParcelable.nNA = paramx;
      paramx = paramb.nLH;
      if (paramx == null) {
        break label175;
      }
    }
    label170:
    label175:
    for (paramx = paramx.hlf;; paramx = null)
    {
      localAppMsgDataParcelable.nNB = paramx;
      paramb = paramb.nLH;
      paramx = localObject;
      if (paramb != null) {
        paramx = paramb.hld;
      }
      localAppMsgDataParcelable.nNC = paramx;
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
    x localx = paramAppMsgDataParcelable.nLB;
    if (localx == null)
    {
      ac.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7294);
      return;
    }
    int i;
    y.b localb;
    if (paramAppMsgDataParcelable.nNz == 1)
    {
      i = 1;
      localb = y.ayq().F(paramAppMsgDataParcelable.sessionId, true);
      localb.l("sendAppMsgScene", Integer.valueOf(2));
      localb.l("preChatName", localx.TC());
      localb.l("preMsgIndex", Integer.valueOf(localx.hkU));
      localb.l("prePublishId", localx.hkW);
      localb.l("preUsername", localx.TC());
      localb.l("url", paramAppMsgDataParcelable.url);
      localb.l("referUrl", paramAppMsgDataParcelable.url);
      int j = localx.hkX.type;
      if (j != -1)
      {
        localb.l("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
        if (localx.hkX.type == 5)
        {
          localb.l("_DATA_CENTER_VID", localx.hkX.hhd);
          localb.l("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)localx.hkX.time));
          localb.l("_DATA_CENTER__DULATION", Integer.valueOf(localx.hkX.hlh));
          if (i == 0) {
            break label350;
          }
          localb.l("_DATA_CENTER_DESC", paramAppMsgDataParcelable.nNB);
          localb.l("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.nNC);
        }
      }
    }
    for (;;)
    {
      localb.l("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(localx.hkX.videoWidth));
      localb.l("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(localx.hkX.videoHeight));
      localb.l("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
      localb.l("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(localx.hhc));
      localb.l("_tmpl_webview_transfer_scene", Integer.valueOf(10));
      AppMethodBeat.o(7294);
      return;
      i = 0;
      break;
      label350:
      localb.l("_DATA_CENTER_DESC", localx.hkX.hlf);
      localb.l("_DATA_CENTER_COVER_URL", localx.hkX.hld);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine$IPCInvoke_ShareToTimeLine;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f
 * JD-Core Version:    0.7.0.1
 */