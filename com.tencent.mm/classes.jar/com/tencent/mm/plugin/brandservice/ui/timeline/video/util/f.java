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
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine;", "", "()V", "TAG", "", "doSetTimelineData", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "sessionId", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_ShareToTimeLine", "plugin-brandservice_release"})
public final class f
{
  private static final String TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
  public static final f oqH;
  
  static
  {
    AppMethodBeat.i(7295);
    oqH = new f();
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
    localAppMsgDataParcelable.ooh = paramx;
    int i;
    if (paramb.bRl())
    {
      i = 1;
      localAppMsgDataParcelable.oqf = i;
      paramx = paramb.oon;
      if (paramx == null) {
        break label170;
      }
      paramx = paramx.title;
      label94:
      localAppMsgDataParcelable.oqg = paramx;
      paramx = paramb.oon;
      if (paramx == null) {
        break label175;
      }
    }
    label170:
    label175:
    for (paramx = paramx.hDo;; paramx = null)
    {
      localAppMsgDataParcelable.oqh = paramx;
      paramb = paramb.oon;
      paramx = localObject;
      if (paramb != null) {
        paramx = paramb.hDm;
      }
      localAppMsgDataParcelable.oqi = paramx;
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
    p.h(paramAppMsgDataParcelable, "data");
    x localx = paramAppMsgDataParcelable.ooh;
    if (localx == null)
    {
      ad.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7294);
      return;
    }
    int i;
    y.b localb;
    if (paramAppMsgDataParcelable.oqf == 1)
    {
      i = 1;
      localb = y.aBq().F(paramAppMsgDataParcelable.sessionId, true);
      localb.k("sendAppMsgScene", Integer.valueOf(2));
      localb.k("preChatName", localx.VS());
      localb.k("preMsgIndex", Integer.valueOf(localx.hDd));
      localb.k("prePublishId", localx.hDf);
      localb.k("preUsername", localx.VS());
      localb.k("url", paramAppMsgDataParcelable.url);
      localb.k("referUrl", paramAppMsgDataParcelable.url);
      int j = localx.hDg.type;
      if (j != -1)
      {
        localb.k("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
        if (localx.hDg.type == 5)
        {
          localb.k("_DATA_CENTER_VID", localx.hDg.hzm);
          localb.k("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)localx.hDg.time));
          localb.k("_DATA_CENTER__DULATION", Integer.valueOf(localx.hDg.hDq));
          if (i == 0) {
            break label350;
          }
          localb.k("_DATA_CENTER_DESC", paramAppMsgDataParcelable.oqh);
          localb.k("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.oqi);
        }
      }
    }
    for (;;)
    {
      localb.k("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(localx.hDg.videoWidth));
      localb.k("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(localx.hDg.videoHeight));
      localb.k("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
      localb.k("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(localx.hzl));
      localb.k("_tmpl_webview_transfer_scene", Integer.valueOf(10));
      AppMethodBeat.o(7294);
      return;
      i = 0;
      break;
      label350:
      localb.k("_DATA_CENTER_DESC", localx.hDg.hDo);
      localb.k("_DATA_CENTER_COVER_URL", localx.hDg.hDm);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine$IPCInvoke_ShareToTimeLine;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f
 * JD-Core Version:    0.7.0.1
 */