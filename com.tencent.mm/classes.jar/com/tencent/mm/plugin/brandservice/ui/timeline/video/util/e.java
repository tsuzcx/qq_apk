package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class e
{
  private static final String TAG = "MicroMsg.BizVideoMsgFav";
  public static final e nOa;
  
  static
  {
    AppMethodBeat.i(7291);
    nOa = new e();
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
    localAppMsgDataParcelable.nLB = paramx;
    int i;
    if (paramb.bML())
    {
      i = 1;
      localAppMsgDataParcelable.nNz = i;
      paramx = paramb.nLH;
      if (paramx == null) {
        break label135;
      }
      paramx = paramx.title;
      label67:
      localAppMsgDataParcelable.nNA = paramx;
      paramx = paramb.nLH;
      if (paramx == null) {
        break label140;
      }
      paramx = paramx.hlf;
      label86:
      localAppMsgDataParcelable.nNB = paramx;
      paramx = paramb.nLH;
      if (paramx == null) {
        break label145;
      }
    }
    label135:
    label140:
    label145:
    for (paramx = paramx.hld;; paramx = null)
    {
      localAppMsgDataParcelable.nNC = paramx;
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
    x localx = paramAppMsgDataParcelable.nLB;
    if (localx == null)
    {
      ac.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(7290);
      return;
    }
    int i;
    cs localcs;
    c.a locala;
    if (paramAppMsgDataParcelable.nNz == 1)
    {
      i = 1;
      localcs = new cs();
      locala = new c.a();
      locala.url = paramAppMsgDataParcelable.url;
      locala.CoY = new ahf();
      locala.CoY.hha = 1;
      locala.CoY.hgY = localx.hkX.type;
      locala.CoY.hhd = localx.hkX.hhd;
      locala.CoY.videoWidth = localx.hkX.videoWidth;
      locala.CoY.videoHeight = localx.hkX.videoHeight;
      locala.CoY.duration = localx.hkX.hlh;
      locala.CoY.hgZ = ((int)localx.hkX.time);
      locala.CoY.hhc = localx.hhc;
      if (!bs.isNullOrNil(localx.ddo)) {
        break label425;
      }
      locala.CoY.ddo = localx.TC();
      locala.CoY.hkV = com.tencent.mm.model.v.wk(localx.TC());
      label233:
      if (i == 0) {
        break label452;
      }
      locala.thumbUrl = paramAppMsgDataParcelable.nNC;
      locala.title = paramAppMsgDataParcelable.nNA;
    }
    for (locala.desc = paramAppMsgDataParcelable.nNB;; locala.desc = localx.hkX.hlf)
    {
      locala.CoY.hld = locala.thumbUrl;
      Object localObject = y.xJ(bs.nullAsNil(localx.hkW));
      localObject = y.ayq().F((String)localObject, true);
      if (localObject == null) {
        k.fOy();
      }
      ((y.b)localObject).l("sendAppMsgScene", Integer.valueOf(2));
      ((y.b)localObject).l("preChatName", localx.TC());
      ((y.b)localObject).l("preMsgIndex", Integer.valueOf(localx.hkU));
      ((y.b)localObject).l("prePublishId", localx.hkW);
      ((y.b)localObject).l("preUsername", localx.TC());
      ((y.b)localObject).l("referUrl", paramAppMsgDataParcelable.url);
      localcs.dck.dcq = 36;
      c.a(localcs, locala);
      a.GpY.l((com.tencent.mm.sdk.b.b)localcs);
      AppMethodBeat.o(7290);
      return;
      i = 0;
      break;
      label425:
      locala.CoY.ddo = localx.ddo;
      locala.CoY.hkV = localx.hkV;
      break label233;
      label452:
      locala.thumbUrl = localx.hkX.hld;
      locala.title = localx.hkX.title;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav$IPCInvoke_Fav;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.b<AppMsgDataParcelable, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e
 * JD-Core Version:    0.7.0.1
 */