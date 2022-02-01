package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.ah.x;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.w;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class e
{
  private static final String TAG = "MicroMsg.BizVideoMsgFav";
  public static final e oxc;
  
  static
  {
    AppMethodBeat.i(7291);
    oxc = new e();
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
    localAppMsgDataParcelable.otY = paramx;
    int i;
    if (paramb.bSm())
    {
      i = 1;
      localAppMsgDataParcelable.owB = i;
      paramx = paramb.oue;
      if (paramx == null) {
        break label135;
      }
      paramx = paramx.title;
      label67:
      localAppMsgDataParcelable.owC = paramx;
      paramx = paramb.oue;
      if (paramx == null) {
        break label140;
      }
      paramx = paramx.hGg;
      label86:
      localAppMsgDataParcelable.owD = paramx;
      paramx = paramb.oue;
      if (paramx == null) {
        break label145;
      }
    }
    label135:
    label140:
    label145:
    for (paramx = paramx.hGe;; paramx = null)
    {
      localAppMsgDataParcelable.owE = paramx;
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
    x localx = paramAppMsgDataParcelable.otY;
    if (localx == null)
    {
      ae.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7290);
      return;
    }
    int i;
    cw localcw;
    c.a locala;
    if (paramAppMsgDataParcelable.owB == 1)
    {
      i = 1;
      localcw = new cw();
      locala = new c.a();
      locala.url = paramAppMsgDataParcelable.url;
      locala.Ekw = new akf();
      locala.Ekw.hBX = 1;
      locala.Ekw.hBV = localx.hFY.type;
      locala.Ekw.hCa = localx.hFY.hCa;
      locala.Ekw.videoWidth = localx.hFY.videoWidth;
      locala.Ekw.videoHeight = localx.hFY.videoHeight;
      locala.Ekw.duration = localx.hFY.hGi;
      locala.Ekw.hBW = ((int)localx.hFY.time);
      locala.Ekw.hBZ = localx.hBZ;
      if (!bu.isNullOrNil(localx.dpP)) {
        break label425;
      }
      locala.Ekw.dpP = localx.Wa();
      locala.Ekw.hFW = w.zP(localx.Wa());
      label233:
      if (i == 0) {
        break label452;
      }
      locala.thumbUrl = paramAppMsgDataParcelable.owE;
      locala.title = paramAppMsgDataParcelable.owC;
    }
    for (locala.desc = paramAppMsgDataParcelable.owD;; locala.desc = localx.hFY.hGg)
    {
      locala.Ekw.hGe = locala.thumbUrl;
      Object localObject = z.Br(bu.nullAsNil(localx.hFX));
      localObject = z.aBG().F((String)localObject, true);
      if (localObject == null) {
        p.gkB();
      }
      ((z.b)localObject).k("sendAppMsgScene", Integer.valueOf(2));
      ((z.b)localObject).k("preChatName", localx.Wa());
      ((z.b)localObject).k("preMsgIndex", Integer.valueOf(localx.hFV));
      ((z.b)localObject).k("prePublishId", localx.hFX);
      ((z.b)localObject).k("preUsername", localx.Wa());
      ((z.b)localObject).k("referUrl", paramAppMsgDataParcelable.url);
      localcw.doL.doR = 36;
      c.a(localcw, locala);
      a.IvT.l((com.tencent.mm.sdk.b.b)localcw);
      AppMethodBeat.o(7290);
      return;
      i = 0;
      break;
      label425:
      locala.Ekw.dpP = localx.dpP;
      locala.Ekw.hFW = localx.hFW;
      break label233;
      label452:
      locala.thumbUrl = localx.hFY.hGe;
      locala.title = localx.hFY.title;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e
 * JD-Core Version:    0.7.0.1
 */