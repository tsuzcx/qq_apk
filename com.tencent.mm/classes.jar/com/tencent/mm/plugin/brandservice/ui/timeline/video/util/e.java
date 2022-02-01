package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class e
{
  private static final String TAG = "MicroMsg.BizVideoMsgFav";
  public static final e nla;
  
  static
  {
    AppMethodBeat.i(7291);
    nla = new e();
    TAG = "MicroMsg.BizVideoMsgFav";
    AppMethodBeat.o(7291);
  }
  
  public static void a(x paramx, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    AppMethodBeat.i(7289);
    k.h(paramx, "msgInfo");
    k.h(paramb, "controller");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.niI = paramx;
    int i;
    if (paramb.bFy())
    {
      i = 1;
      localAppMsgDataParcelable.nkz = i;
      paramx = paramb.niO;
      if (paramx == null) {
        break label135;
      }
      paramx = paramx.title;
      label67:
      localAppMsgDataParcelable.nkA = paramx;
      paramx = paramb.niO;
      if (paramx == null) {
        break label140;
      }
      paramx = paramx.gKF;
      label86:
      localAppMsgDataParcelable.nkB = paramx;
      paramx = paramb.niO;
      if (paramx == null) {
        break label145;
      }
    }
    label135:
    label140:
    label145:
    for (paramx = paramx.gKD;; paramx = null)
    {
      localAppMsgDataParcelable.nkC = paramx;
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
    k.h(paramAppMsgDataParcelable, "data");
    x localx = paramAppMsgDataParcelable.niI;
    if (localx == null)
    {
      ad.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7290);
      return;
    }
    int i;
    cs localcs;
    c.a locala;
    if (paramAppMsgDataParcelable.nkz == 1)
    {
      i = 1;
      localcs = new cs();
      locala = new c.a();
      locala.url = paramAppMsgDataParcelable.url;
      locala.AWL = new agg();
      locala.AWL.gGz = 1;
      locala.AWL.gGx = localx.gKx.type;
      locala.AWL.gGC = localx.gKx.gGC;
      locala.AWL.videoWidth = localx.gKx.videoWidth;
      locala.AWL.videoHeight = localx.gKx.videoHeight;
      locala.AWL.duration = localx.gKx.gKH;
      locala.AWL.gGy = ((int)localx.gKx.time);
      locala.AWL.gGB = localx.gGB;
      if (!bt.isNullOrNil(localx.dfT)) {
        break label425;
      }
      locala.AWL.dfT = localx.SI();
      locala.AWL.gKv = com.tencent.mm.model.v.sh(localx.SI());
      label233:
      if (i == 0) {
        break label452;
      }
      locala.thumbUrl = paramAppMsgDataParcelable.nkC;
      locala.title = paramAppMsgDataParcelable.nkA;
    }
    for (locala.desc = paramAppMsgDataParcelable.nkB;; locala.desc = localx.gKx.gKF)
    {
      locala.AWL.gKD = locala.thumbUrl;
      Object localObject = y.tD(bt.nullAsNil(localx.gKw));
      localObject = y.arz().E((String)localObject, true);
      if (localObject == null) {
        k.fvU();
      }
      ((y.b)localObject).m("sendAppMsgScene", Integer.valueOf(2));
      ((y.b)localObject).m("preChatName", localx.SI());
      ((y.b)localObject).m("preMsgIndex", Integer.valueOf(localx.gKu));
      ((y.b)localObject).m("prePublishId", localx.gKw);
      ((y.b)localObject).m("preUsername", localx.SI());
      ((y.b)localObject).m("referUrl", paramAppMsgDataParcelable.url);
      localcs.deQ.deW = 36;
      c.a(localcs, locala);
      a.ESL.l((com.tencent.mm.sdk.b.b)localcs);
      AppMethodBeat.o(7290);
      return;
      i = 0;
      break;
      label425:
      locala.AWL.dfT = localx.dfT;
      locala.AWL.gKv = localx.gKv;
      break label233;
      label452:
      locala.thumbUrl = localx.gKx.gKD;
      locala.title = localx.gKx.title;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e
 * JD-Core Version:    0.7.0.1
 */