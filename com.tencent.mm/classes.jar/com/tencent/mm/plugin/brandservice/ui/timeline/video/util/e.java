package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class e
{
  private static final String TAG = "MicroMsg.BizVideoMsgFav";
  public static final e pKG;
  
  static
  {
    AppMethodBeat.i(7291);
    pKG = new e();
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
    localAppMsgDataParcelable.pHv = paramx;
    int i;
    if (paramb.cpW())
    {
      i = 1;
      localAppMsgDataParcelable.pKf = i;
      paramx = paramb.pHB;
      if (paramx == null) {
        break label136;
      }
      paramx = paramx.title;
      label67:
      localAppMsgDataParcelable.pKg = paramx;
      paramx = paramb.pHB;
      if (paramx == null) {
        break label141;
      }
      paramx = paramx.iAq;
      label86:
      localAppMsgDataParcelable.pKh = paramx;
      paramx = paramb.pHB;
      if (paramx == null) {
        break label146;
      }
    }
    label136:
    label141:
    label146:
    for (paramx = paramx.iAo;; paramx = null)
    {
      localAppMsgDataParcelable.pKi = paramx;
      h.a(MainProcessIPCService.dkO, (Parcelable)localAppMsgDataParcelable, a.class, null);
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
    x localx = paramAppMsgDataParcelable.pHv;
    if (localx == null)
    {
      Log.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7290);
      return;
    }
    int i;
    cz localcz;
    c.a locala;
    if (paramAppMsgDataParcelable.pKf == 1)
    {
      i = 1;
      localcz = new cz();
      locala = new c.a();
      locala.url = paramAppMsgDataParcelable.url;
      locala.IXu = new amt();
      locala.IXu.iwe = 1;
      locala.IXu.iwc = localx.iAi.type;
      locala.IXu.vid = localx.iAi.vid;
      locala.IXu.videoWidth = localx.iAi.videoWidth;
      locala.IXu.videoHeight = localx.iAi.videoHeight;
      locala.IXu.duration = localx.iAi.iAs;
      locala.IXu.iwd = ((int)localx.iAi.time);
      locala.IXu.iwg = localx.iwg;
      if (!Util.isNullOrNil(localx.dHc)) {
        break label427;
      }
      locala.IXu.dHc = localx.ajO();
      locala.IXu.iAg = aa.getDisplayName(localx.ajO());
      label233:
      if (i == 0) {
        break label454;
      }
      locala.thumbUrl = paramAppMsgDataParcelable.pKi;
      locala.title = paramAppMsgDataParcelable.pKg;
    }
    for (locala.desc = paramAppMsgDataParcelable.pKh;; locala.desc = localx.iAi.iAq)
    {
      locala.IXu.iAo = locala.thumbUrl;
      Object localObject = ad.JX(Util.nullAsNil(localx.iAh));
      localObject = ad.aVe().G((String)localObject, true);
      if (localObject == null) {
        p.hyc();
      }
      ((ad.b)localObject).l("sendAppMsgScene", Integer.valueOf(2));
      ((ad.b)localObject).l("preChatName", localx.ajO());
      ((ad.b)localObject).l("preMsgIndex", Integer.valueOf(localx.iAf));
      ((ad.b)localObject).l("prePublishId", localx.iAh);
      ((ad.b)localObject).l("preUsername", localx.ajO());
      ((ad.b)localObject).l("referUrl", paramAppMsgDataParcelable.url);
      localcz.dFZ.dGf = 36;
      c.a(localcz, locala);
      EventCenter.instance.publish((IEvent)localcz);
      AppMethodBeat.o(7290);
      return;
      i = 0;
      break;
      label427:
      locala.IXu.dHc = localx.dHc;
      locala.IXu.iAg = localx.iAg;
      break label233;
      label454:
      locala.thumbUrl = localx.iAi.iAo;
      locala.title = localx.iAi.title;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e
 * JD-Core Version:    0.7.0.1
 */