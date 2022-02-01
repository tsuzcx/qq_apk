package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "channelSessionId", "getChannelSessionId", "()Ljava/lang/String;", "setChannelSessionId", "(Ljava/lang/String;)V", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "setCopyUrl", "enterId", "getEnterId", "setEnterId", "filesize", "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "hasShowWifiTips", "", "getHasShowWifiTips", "()Z", "setHasShowWifiTips", "(Z)V", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "landingPageType", "getLandingPageType", "setLandingPageType", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "wifiTipsFlag", "getWifiTipsFlag", "setWifiTipsFlag", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getFileSizeKB", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "onShowWifiTips", "mode", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b
{
  final String TAG;
  String ddo;
  private p fxw;
  public int hgY;
  public int hhc;
  public String hhd;
  public long hlF;
  public int idx;
  IPCRunCgi.a jKR;
  public WeakReference<TmplShareWebViewToolUI> lvU;
  public com.tencent.mm.ah.v nBm;
  public int nLA;
  public x nLB;
  public int nLC;
  public int nLD;
  int nLE;
  public String nLF;
  public int nLG;
  public btb nLH;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m nLI;
  String nLu;
  public String nLv;
  public n nLw;
  long nLx;
  int nLy;
  boolean nLz;
  public int scene;
  public String url;
  
  public b()
  {
    AppMethodBeat.i(7081);
    this.TAG = "MicroMsg.BizNativePageController";
    this.hhc = -1;
    this.ddo = "";
    this.nLu = "";
    this.hhd = "";
    this.nLv = "";
    this.nLw = new n();
    this.nLA = ((int)(System.currentTimeMillis() / 1000L));
    this.url = "";
    this.nLF = "";
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m localm = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m();
    m.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.nPf;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.b(new WeakReference(localm));
    this.nLI = localm;
    AppMethodBeat.o(7081);
  }
  
  private TmplShareWebViewToolUI bMK()
  {
    AppMethodBeat.i(7080);
    Object localObject = this.lvU;
    if (localObject == null) {
      k.aVY("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7080);
      return null;
    }
    localObject = this.lvU;
    if (localObject == null) {
      k.aVY("ui");
    }
    localObject = ((WeakReference)localObject).get();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(7080);
      throw ((Throwable)localObject);
    }
    localObject = (TmplShareWebViewToolUI)localObject;
    AppMethodBeat.o(7080);
    return localObject;
  }
  
  public final String TC()
  {
    AppMethodBeat.i(7079);
    Object localObject = this.nLB;
    if (localObject == null) {
      k.aVY("msgInfo");
    }
    localObject = ((x)localObject).TC();
    AppMethodBeat.o(7079);
    return localObject;
  }
  
  public final void Uk(String paramString)
  {
    if (paramString != null) {
      this.url = paramString;
    }
  }
  
  public final void a(ep paramep)
  {
    AppMethodBeat.i(7076);
    k.h(paramep, "req");
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.c((com.tencent.mm.bw.a)paramep);
    locala.d((com.tencent.mm.bw.a)new eq());
    locala.Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.op(1870);
    locala.or(0);
    locala.os(0);
    IPCRunCgi.a(locala.aAz(), (IPCRunCgi.a)new b(this));
    AppMethodBeat.o(7076);
  }
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(7074);
    Object localObject = new fe();
    ((fe)localObject).url = this.url;
    ((fe)localObject).hED = System.currentTimeMillis();
    ((fe)localObject).DSo = paramString;
    ((fe)localObject).scene = this.scene;
    ((fe)localObject).DRn = this.nLC;
    ((fe)localObject).nWg = paramInt;
    ((fe)localObject).DRl = this.hgY;
    ((fe)localObject).session_id = this.nLD;
    ((fe)localObject).DRm = this.nLA;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.c((com.tencent.mm.bw.a)localObject);
    paramString.d((com.tencent.mm.bw.a)new ff());
    paramString.Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
    paramString.op(2691);
    paramString.or(0);
    paramString.os(0);
    IPCRunCgi.a(paramString.aAz(), (IPCRunCgi.a)new c(this));
    paramString = bMK();
    if (paramString != null) {}
    for (paramString = paramString.getString(2131761348);; paramString = null)
    {
      localObject = this.lvU;
      if (localObject == null) {
        k.aVY("ui");
      }
      if (((WeakReference)localObject).get() == null) {
        break label275;
      }
      localObject = this.lvU;
      if (localObject == null) {
        k.aVY("ui");
      }
      localObject = ((WeakReference)localObject).get();
      if (localObject != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(7074);
      throw paramString;
    }
    if (((TmplShareWebViewToolUI)localObject).isFinishing()) {
      label275:
      paramInt = 1;
    }
    while (paramInt == 0)
    {
      bMJ();
      if (this.fxw != null)
      {
        localObject = this.fxw;
        if (localObject == null) {
          k.fOy();
        }
        if (!((p)localObject).isShowing())
        {
          paramString = this.fxw;
          if (paramString != null)
          {
            paramString.show();
            AppMethodBeat.o(7074);
            return;
            paramInt = 0;
            continue;
          }
          AppMethodBeat.o(7074);
          return;
        }
      }
      localObject = this.lvU;
      if (localObject == null) {
        k.aVY("ui");
      }
      this.fxw = h.b((Context)((WeakReference)localObject).get(), paramString, true, (DialogInterface.OnCancelListener)new e(this));
    }
    AppMethodBeat.o(7074);
  }
  
  public final com.tencent.mm.ah.v bMH()
  {
    AppMethodBeat.i(7070);
    com.tencent.mm.ah.v localv = this.nBm;
    if (localv == null) {
      k.aVY("readerItem");
    }
    AppMethodBeat.o(7070);
    return localv;
  }
  
  public final void bMI()
  {
    AppMethodBeat.i(7073);
    fa localfa = new fa();
    localfa.url = this.url;
    localfa.hhd = this.hhd;
    localfa.scene = this.scene;
    localfa.DRn = this.nLC;
    localfa.nettype = com.tencent.mm.ah.m.Yu();
    if (localfa.nettype == 100) {
      localfa.nettype = 0;
    }
    localfa.session_id = this.nLD;
    localfa.DRm = this.nLA;
    Object localObject = this.nLB;
    if (localObject == null) {
      k.aVY("msgInfo");
    }
    int j;
    if (x.nK(((x)localObject).hhc))
    {
      localfa.DRM = 1;
      j = this.nLE;
      if (j != 0) {
        break label466;
      }
      i = 0;
      label140:
      localfa.DRN = i;
      localObject = aw.aKT(this.TAG);
      if (localObject != null)
      {
        localfa.DRO = ((aw)localObject).decodeLong("BizVideoLastPlayTimestamp", 0L);
        localfa.DRP = ((aw)localObject).decodeLong("BizVideoLastPlayFileSize", 0L);
        localfa.DRS = ((aw)localObject).decodeInt("BizVideoLastShowWifiTipsMode", 0);
      }
      if (bMK() != null)
      {
        localfa.DRQ = new oe();
        localfa.DRQ.Eea = com.tencent.mm.cc.a.ig((Context)bMK());
        localfa.DRQ.Eeb = com.tencent.mm.cc.a.ih((Context)bMK());
        localfa.DRQ.Eec = aj.fhB().densityDpi;
      }
      localfa.DRU = this.nLF;
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.nNE;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.bNy()) {
        break label481;
      }
    }
    label466:
    label481:
    for (int i = 1;; i = 0)
    {
      localfa.DRT = i;
      ac.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d, width %d, height %d, dpi %d", new Object[] { Integer.valueOf(j), Long.valueOf(localfa.DRO), Long.valueOf(localfa.DRP), Integer.valueOf(localfa.DRQ.Eea), Integer.valueOf(localfa.DRQ.Eeb), Integer.valueOf(localfa.DRQ.Eec) });
      localObject = new com.tencent.mm.ak.b.a();
      ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)localfa);
      ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new fb());
      ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
      ((com.tencent.mm.ak.b.a)localObject).op(1179);
      ((com.tencent.mm.ak.b.a)localObject).or(0);
      ((com.tencent.mm.ak.b.a)localObject).os(0);
      IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject).aAz(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(7073);
      return;
      localfa.DRM = 0;
      break;
      if (j == 1)
      {
        i = 1;
        break label140;
      }
      i = 2;
      break label140;
    }
  }
  
  public final void bMJ()
  {
    AppMethodBeat.i(7078);
    if (this.fxw != null)
    {
      Object localObject = this.fxw;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((p)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          k.fOy();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.fxw;
        if (localObject == null) {
          break;
        }
        ((p)localObject).dismiss();
        AppMethodBeat.o(7078);
        return;
      }
    }
    AppMethodBeat.o(7078);
  }
  
  public final boolean bML()
  {
    return (this.hhc & 0x4) != 0;
  }
  
  public final int bMM()
  {
    return (int)(this.nLx / 1024L);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7077);
    bMJ();
    n localn = this.nLw;
    if (localn.nPg.size() > 0)
    {
      localObject1 = new LinkedList();
      localObject2 = localn.nPg.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        k.g(localObject3, "it.next()");
        localObject3 = ((Map.Entry)localObject3).getValue();
        k.g(localObject3, "entry.value");
        ((LinkedList)localObject1).add((yj)localObject3);
      }
      localObject2 = new es();
      ((es)localObject2).DRk = ((LinkedList)localObject1);
      localObject1 = localn.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      k.h(localObject2, "req");
      ((es)localObject2).DRm = ((b)localObject1).nLA;
      ((es)localObject2).session_id = ((b)localObject1).nLD;
      ((es)localObject2).DRl = ((b)localObject1).hgY;
      ((es)localObject2).url = ((b)localObject1).url;
      localObject3 = new com.tencent.mm.ak.b.a();
      ((com.tencent.mm.ak.b.a)localObject3).c((com.tencent.mm.bw.a)localObject2);
      ((com.tencent.mm.ak.b.a)localObject3).d((com.tencent.mm.bw.a)new et());
      ((com.tencent.mm.ak.b.a)localObject3).Am("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
      ((com.tencent.mm.ak.b.a)localObject3).op(2827);
      ((com.tencent.mm.ak.b.a)localObject3).or(0);
      ((com.tencent.mm.ak.b.a)localObject3).os(0);
      IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject3).aAz(), (IPCRunCgi.a)new d((b)localObject1));
      localn.nPg.clear();
    }
    Object localObject1 = new ep();
    Object localObject2 = new eo();
    ((eo)localObject2).type = 1;
    Object localObject3 = localn.nMS;
    if (localObject3 == null) {
      k.aVY("controller");
    }
    int i = ((b)localObject3).scene;
    localObject3 = ((eo)localObject2).DNM;
    k.g(localObject3, "reportData.item");
    n.a("scene", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ax.iH(ai.getContext());
    Object localObject4 = ((eo)localObject2).DNM;
    k.g(localObject4, "reportData.item");
    n.a("netType", (String)localObject3, (LinkedList)localObject4);
    long l = localn.nPh;
    localObject3 = ((eo)localObject2).DNM;
    k.g(localObject3, "reportData.item");
    n.a("StartTimeMs", String.valueOf(l), (LinkedList)localObject3);
    l = System.currentTimeMillis();
    localObject3 = ((eo)localObject2).DNM;
    k.g(localObject3, "reportData.item");
    n.a("EndTimeMs", String.valueOf(l), (LinkedList)localObject3);
    localObject3 = localn.nMS;
    if (localObject3 == null) {
      k.aVY("controller");
    }
    i = ((b)localObject3).hgY;
    localObject3 = ((eo)localObject2).DNM;
    k.g(localObject3, "reportData.item");
    n.a("ItemShowType", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = new StringBuilder();
    localObject4 = localn.nMS;
    if (localObject4 == null) {
      k.aVY("controller");
    }
    localObject3 = ((b)localObject4).nLD;
    localObject4 = ((eo)localObject2).DNM;
    k.g(localObject4, "reportData.item");
    n.a("SessionId", (String)localObject3, (LinkedList)localObject4);
    localObject3 = localn.nMS;
    if (localObject3 == null) {
      k.aVY("controller");
    }
    i = ((b)localObject3).nLA;
    localObject3 = ((eo)localObject2).DNM;
    k.g(localObject3, "reportData.item");
    n.a("EnterId", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ((eo)localObject2).DNM;
    k.g(localObject3, "reportData.item");
    n.a("NativePage", "1", (LinkedList)localObject3);
    localObject3 = localn.nMS;
    if (localObject3 == null) {
      k.aVY("controller");
    }
    localObject3 = ((b)localObject3).url;
    localObject4 = ((eo)localObject2).DNM;
    k.g(localObject4, "reportData.item");
    n.a("#AppMsgUrl#", (String)localObject3, (LinkedList)localObject4);
    ((ep)localObject1).DRi.add(localObject2);
    localObject3 = localn.nMS;
    if (localObject3 == null) {
      k.aVY("controller");
    }
    ((b)localObject3).a((ep)localObject1);
    localObject1 = ((eo)localObject2).DNM;
    k.g(localObject1, "reportData.item");
    localn.b(10945, (LinkedList)localObject1);
    this.jKR = null;
    AppMethodBeat.o(7077);
  }
  
  public final void zl(int paramInt)
  {
    AppMethodBeat.i(175498);
    aw localaw = aw.aKT(this.TAG);
    if (localaw != null)
    {
      localaw.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000L);
      localaw.encode("BizVideoLastPlayFileSize", this.nLx);
      localaw.encode("BizVideoLastShowWifiTipsMode", paramInt);
    }
    AppMethodBeat.o(175498);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7064);
      ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7063);
          IPCRunCgi.a locala = this.nLK.nLJ.jKR;
          if (locala != null)
          {
            locala.a(paramInt1, paramInt2, paramString, paramb);
            AppMethodBeat.o(7063);
            return;
          }
          AppMethodBeat.o(7063);
        }
      });
      AppMethodBeat.o(7064);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class b
    implements IPCRunCgi.a
  {
    b(b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7065);
      ac.i(this.nLJ.TAG, "appmsg_report errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      AppMethodBeat.o(7065);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7067);
      ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7066);
          IPCRunCgi.a locala = this.nLM.nLJ.jKR;
          if (locala != null)
          {
            locala.a(paramInt1, paramInt2, paramString, paramb);
            AppMethodBeat.o(7066);
            return;
          }
          AppMethodBeat.o(7066);
        }
      });
      AppMethodBeat.o(7067);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(b paramb) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7068);
      ac.i(this.nLJ.TAG, "appmsg_comment_exposure errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      AppMethodBeat.o(7068);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    e(b paramb) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(7069);
      try
      {
        paramDialogInterface.dismiss();
        AppMethodBeat.o(7069);
        return;
      }
      catch (Exception paramDialogInterface)
      {
        ac.e(this.nLJ.TAG, "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
        AppMethodBeat.o(7069);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b
 * JD-Core Version:    0.7.0.1
 */