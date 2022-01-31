package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.af.s;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgShareToTimeLine;", "", "()V", "TAG", "", "doSetTimelineData", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "sessionId", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Landroid/os/Bundle;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_ShareToTimeLine", "plugin-brandservice_release"})
public final class b
{
  private static final String TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
  public static final b khW;
  
  static
  {
    AppMethodBeat.i(152954);
    khW = new b();
    TAG = "MicroMsg.BizVideoMsgShareToTimeLine";
    AppMethodBeat.o(152954);
  }
  
  public static void a(s params, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb, String paramString, c<Bundle> paramc)
  {
    Object localObject = null;
    AppMethodBeat.i(152952);
    j.q(params, "msgInfo");
    j.q(paramb, "controller");
    j.q(paramString, "sessionId");
    j.q(paramc, "callback");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.cpW = paramString;
    localAppMsgDataParcelable.jXm = params;
    int i;
    if (paramb.aZg())
    {
      i = 1;
      localAppMsgDataParcelable.khR = i;
      params = paramb.kfA;
      if (params == null) {
        break label168;
      }
      params = params.title;
      label93:
      localAppMsgDataParcelable.khS = params;
      params = paramb.kfA;
      if (params == null) {
        break label173;
      }
    }
    label168:
    label173:
    for (params = params.fjL;; params = null)
    {
      localAppMsgDataParcelable.khT = params;
      paramb = paramb.kfA;
      params = localObject;
      if (paramb != null) {
        params = paramb.fjJ;
      }
      localAppMsgDataParcelable.khU = params;
      f.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, b.a.class, paramc);
      AppMethodBeat.o(152952);
      return;
      i = 0;
      break;
      params = null;
      break label93;
    }
  }
  
  public static void b(AppMsgDataParcelable paramAppMsgDataParcelable)
  {
    AppMethodBeat.i(152953);
    j.q(paramAppMsgDataParcelable, "data");
    s locals = paramAppMsgDataParcelable.jXm;
    if (locals == null)
    {
      ab.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(152953);
      return;
    }
    int i;
    v.b localb;
    if (paramAppMsgDataParcelable.khR == 1)
    {
      i = 1;
      localb = v.aae().z(paramAppMsgDataParcelable.cpW, true);
      localb.i("sendAppMsgScene", Integer.valueOf(2));
      localb.i("preChatName", locals.HD());
      localb.i("preMsgIndex", Integer.valueOf(locals.fjA));
      localb.i("prePublishId", locals.fjC);
      localb.i("preUsername", locals.HD());
      localb.i("url", paramAppMsgDataParcelable.url);
      localb.i("referUrl", paramAppMsgDataParcelable.url);
      int j = locals.fjD.type;
      if (j != -1)
      {
        localb.i("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(j));
        if (locals.fjD.type == 5)
        {
          localb.i("_DATA_CENTER_VID", locals.fjD.fgl);
          localb.i("_DATA_CENTER_PUB_TIME", Integer.valueOf((int)locals.fjD.time));
          localb.i("_DATA_CENTER__DULATION", Integer.valueOf(locals.fjD.fjN));
          if (i == 0) {
            break label347;
          }
          localb.i("_DATA_CENTER_DESC", paramAppMsgDataParcelable.khT);
          localb.i("_DATA_CENTER_COVER_URL", paramAppMsgDataParcelable.khU);
        }
      }
    }
    for (;;)
    {
      localb.i("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(locals.fjD.videoWidth));
      localb.i("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(locals.fjD.videoHeight));
      localb.i("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
      localb.i("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(locals.fgk));
      localb.i("_tmpl_webview_transfer_scene", Integer.valueOf(10));
      AppMethodBeat.o(152953);
      return;
      i = 0;
      break;
      label347:
      localb.i("_DATA_CENTER_DESC", locals.fjD.fjL);
      localb.i("_DATA_CENTER_COVER_URL", locals.fjD.fjJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.b
 * JD-Core Version:    0.7.0.1
 */