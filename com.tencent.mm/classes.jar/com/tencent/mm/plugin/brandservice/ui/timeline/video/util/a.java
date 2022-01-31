package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.model.c.a;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgFav;", "", "()V", "TAG", "", "doFav", "", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "IPCInvoke_Fav", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.BizVideoMsgFav";
  public static final a khV;
  
  static
  {
    AppMethodBeat.i(152950);
    khV = new a();
    TAG = "MicroMsg.BizVideoMsgFav";
    AppMethodBeat.o(152950);
  }
  
  public static void a(com.tencent.mm.af.s params, com.tencent.mm.plugin.brandservice.ui.timeline.video.b paramb)
  {
    AppMethodBeat.i(152948);
    j.q(params, "msgInfo");
    j.q(paramb, "controller");
    AppMsgDataParcelable localAppMsgDataParcelable = new AppMsgDataParcelable();
    localAppMsgDataParcelable.url = paramb.url;
    localAppMsgDataParcelable.jXm = params;
    int i;
    if (paramb.aZg())
    {
      i = 1;
      localAppMsgDataParcelable.khR = i;
      params = paramb.kfA;
      if (params == null) {
        break label133;
      }
      params = params.title;
      label66:
      localAppMsgDataParcelable.khS = params;
      params = paramb.kfA;
      if (params == null) {
        break label138;
      }
      params = params.fjL;
      label85:
      localAppMsgDataParcelable.khT = params;
      params = paramb.kfA;
      if (params == null) {
        break label143;
      }
    }
    label133:
    label138:
    label143:
    for (params = params.fjJ;; params = null)
    {
      localAppMsgDataParcelable.khU = params;
      f.a("com.tencent.mm", (Parcelable)localAppMsgDataParcelable, a.a.class, null);
      AppMethodBeat.o(152948);
      return;
      i = 0;
      break;
      params = null;
      break label66;
      params = null;
      break label85;
    }
  }
  
  public static void a(AppMsgDataParcelable paramAppMsgDataParcelable)
  {
    AppMethodBeat.i(152949);
    j.q(paramAppMsgDataParcelable, "data");
    com.tencent.mm.af.s locals = paramAppMsgDataParcelable.jXm;
    if (locals == null)
    {
      ab.w(TAG, "doFav msgInfo is null");
      AppMethodBeat.o(152949);
      return;
    }
    int i;
    cm localcm;
    c.a locala;
    if (paramAppMsgDataParcelable.khR == 1)
    {
      i = 1;
      localcm = new cm();
      locala = new c.a();
      locala.url = paramAppMsgDataParcelable.url;
      locala.uVl = new aci();
      locala.uVl.fgj = 1;
      locala.uVl.fgh = locals.fjD.type;
      locala.uVl.fgl = locals.fjD.fgl;
      locala.uVl.videoWidth = locals.fjD.videoWidth;
      locala.uVl.videoHeight = locals.fjD.videoHeight;
      locala.uVl.duration = locals.fjD.fjN;
      locala.uVl.fgi = ((int)locals.fjD.time);
      locala.uVl.fgk = locals.fgk;
      if (!bo.isNullOrNil(locals.cqX)) {
        break label423;
      }
      locala.uVl.cqX = locals.HD();
      locala.uVl.fjB = com.tencent.mm.model.s.nE(locals.HD());
      label231:
      if (i == 0) {
        break label450;
      }
      locala.thumbUrl = paramAppMsgDataParcelable.khU;
      locala.title = paramAppMsgDataParcelable.khS;
    }
    for (locala.desc = paramAppMsgDataParcelable.khT;; locala.desc = locals.fjD.fjL)
    {
      locala.uVl.fjJ = locala.thumbUrl;
      Object localObject = v.oQ(bo.nullAsNil(locals.fjC));
      localObject = v.aae().z((String)localObject, true);
      if (localObject == null) {
        j.ebi();
      }
      ((v.b)localObject).i("sendAppMsgScene", Integer.valueOf(2));
      ((v.b)localObject).i("preChatName", locals.HD());
      ((v.b)localObject).i("preMsgIndex", Integer.valueOf(locals.fjA));
      ((v.b)localObject).i("prePublishId", locals.fjC);
      ((v.b)localObject).i("preUsername", locals.HD());
      ((v.b)localObject).i("referUrl", paramAppMsgDataParcelable.url);
      localcm.cpR.cpY = 36;
      c.a(localcm, locala);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localcm);
      AppMethodBeat.o(152949);
      return;
      i = 0;
      break;
      label423:
      locala.uVl.cqX = locals.cqX;
      locala.uVl.fjB = locals.fjB;
      break label231;
      label450:
      locala.thumbUrl = locals.fjD.fjJ;
      locala.title = locals.fjD.title;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a
 * JD-Core Version:    0.7.0.1
 */