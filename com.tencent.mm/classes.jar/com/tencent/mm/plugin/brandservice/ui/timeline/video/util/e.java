package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class e
{
  private static final String TAG = "MicroMsg.BizVideoMsgFav";
  public static final e oqG;
  
  static
  {
    AppMethodBeat.i(7291);
    oqG = new e();
    TAG = "MicroMsg.BizVideoMsgFav";
    AppMethodBeat.o(7291);
  }
  
  public static void a(x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    AppMethodBeat.i(7289);
    p.h(paramx, "msgInfo");
    p.h(paramb, "controller");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.ooh = paramx;
    int i;
    if (paramb.bRl())
    {
      i = 1;
      localAppMsgDataParcelable.oqf = i;
      paramx = paramb.oon;
      if (paramx == null) {
        break label135;
      }
      paramx = paramx.title;
      label67:
      localAppMsgDataParcelable.oqg = paramx;
      paramx = paramb.oon;
      if (paramx == null) {
        break label140;
      }
      paramx = paramx.hDo;
      label86:
      localAppMsgDataParcelable.oqh = paramx;
      paramx = paramb.oon;
      if (paramx == null) {
        break label145;
      }
    }
    label135:
    label140:
    label145:
    for (paramx = paramx.hDm;; paramx = null)
    {
      localAppMsgDataParcelable.oqi = paramx;
      h.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, a.class, null);
      AppMethodBeat.o(7289);
      return;
      i = 0;
      break;
      paramx = null;
      break label67;
      paramx = null;
      break label86;
    }
  }
  
  public static void a(AppMsgDataParcelable paramAppMsgDataParcelable)
  {
    AppMethodBeat.i(7290);
    p.h(paramAppMsgDataParcelable, "data");
    x localx = paramAppMsgDataParcelable.ooh;
    if (localx == null)
    {
      ad.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7290);
      return;
    }
    int i;
    cv localcv;
    c.a locala;
    if (paramAppMsgDataParcelable.oqf == 1)
    {
      i = 1;
      localcv = new cv();
      locala = new c.a();
      locala.url = paramAppMsgDataParcelable.url;
      locala.DSw = new ajv();
      locala.DSw.hzj = 1;
      locala.DSw.hzh = localx.hDg.type;
      locala.DSw.hzm = localx.hDg.hzm;
      locala.DSw.videoWidth = localx.hDg.videoWidth;
      locala.DSw.videoHeight = localx.hDg.videoHeight;
      locala.DSw.duration = localx.hDg.hDq;
      locala.DSw.hzi = ((int)localx.hDg.time);
      locala.DSw.hzl = localx.hzl;
      if (!bt.isNullOrNil(localx.doK)) {
        break label425;
      }
      locala.DSw.doK = localx.VS();
      locala.DSw.hDe = com.tencent.mm.model.v.zf(localx.VS());
      label233:
      if (i == 0) {
        break label452;
      }
      locala.thumbUrl = paramAppMsgDataParcelable.oqi;
      locala.title = paramAppMsgDataParcelable.oqg;
    }
    for (locala.desc = paramAppMsgDataParcelable.oqh;; locala.desc = localx.hDg.hDo)
    {
      locala.DSw.hDm = locala.thumbUrl;
      Object localObject = y.AH(bt.nullAsNil(localx.hDf));
      localObject = y.aBq().F((String)localObject, true);
      if (localObject == null) {
        p.gfZ();
      }
      ((y.b)localObject).k("sendAppMsgScene", Integer.valueOf(2));
      ((y.b)localObject).k("preChatName", localx.VS());
      ((y.b)localObject).k("preMsgIndex", Integer.valueOf(localx.hDd));
      ((y.b)localObject).k("prePublishId", localx.hDf);
      ((y.b)localObject).k("preUsername", localx.VS());
      ((y.b)localObject).k("referUrl", paramAppMsgDataParcelable.url);
      localcv.dnG.dnM = 36;
      c.a(localcv, locala);
      a.IbL.l((com.tencent.mm.sdk.b.b)localcv);
      AppMethodBeat.o(7290);
      return;
      i = 0;
      break;
      label425:
      locala.DSw.doK = localx.doK;
      locala.DSw.hDe = localx.hDe;
      break label233;
      label452:
      locala.thumbUrl = localx.hDg.hDm;
      locala.title = localx.hDg.title;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e
 * JD-Core Version:    0.7.0.1
 */