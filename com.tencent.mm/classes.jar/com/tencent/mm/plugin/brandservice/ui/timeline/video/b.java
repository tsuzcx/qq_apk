package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "channelSessionId", "getChannelSessionId", "()Ljava/lang/String;", "setChannelSessionId", "(Ljava/lang/String;)V", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "setCopyUrl", "enterId", "getEnterId", "setEnterId", "filesize", "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "hasShowWifiTips", "", "getHasShowWifiTips", "()Z", "setHasShowWifiTips", "(Z)V", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "landingPageType", "getLandingPageType", "setLandingPageType", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "wifiTipsFlag", "getWifiTipsFlag", "setWifiTipsFlag", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getFileSizeKB", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "onShowWifiTips", "mode", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b
{
  final String TAG;
  String dHc;
  private q gxX;
  public long iAQ;
  public int idx;
  public int iwc;
  public int iwg;
  IPCRunCgi.a lma;
  public WeakReference<TmplShareWebViewToolUI> nhy;
  public int pHA;
  public cmb pHB;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m pHC;
  String pHo;
  public String pHp;
  public n pHq;
  long pHr;
  int pHs;
  boolean pHt;
  public int pHu;
  public x pHv;
  public int pHw;
  public int pHx;
  int pHy;
  public String pHz;
  public v ptH;
  public int scene;
  public String url;
  public String vid;
  
  public b()
  {
    AppMethodBeat.i(7081);
    this.TAG = "MicroMsg.BizNativePageController";
    this.iwg = -1;
    this.dHc = "";
    this.pHo = "";
    this.vid = "";
    this.pHp = "";
    this.pHq = new n();
    this.pHu = ((int)(System.currentTimeMillis() / 1000L));
    this.url = "";
    this.pHz = "";
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m localm = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m();
    m.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.pLL;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.g(new WeakReference(localm));
    this.pHC = localm;
    AppMethodBeat.o(7081);
  }
  
  private TmplShareWebViewToolUI cpV()
  {
    AppMethodBeat.i(7080);
    Object localObject = this.nhy;
    if (localObject == null) {
      p.btv("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7080);
      return null;
    }
    localObject = this.nhy;
    if (localObject == null) {
      p.btv("ui");
    }
    localObject = ((WeakReference)localObject).get();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(7080);
      throw ((Throwable)localObject);
    }
    localObject = (TmplShareWebViewToolUI)localObject;
    AppMethodBeat.o(7080);
    return localObject;
  }
  
  public final void DJ(int paramInt)
  {
    AppMethodBeat.i(175498);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(this.TAG);
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000L);
      localMultiProcessMMKV.encode("BizVideoLastPlayFileSize", this.pHr);
      localMultiProcessMMKV.encode("BizVideoLastShowWifiTipsMode", paramInt);
    }
    AppMethodBeat.o(175498);
  }
  
  public final void a(fg paramfg)
  {
    AppMethodBeat.i(7076);
    p.h(paramfg, "req");
    d.a locala = new d.a();
    locala.c((com.tencent.mm.bw.a)paramfg);
    locala.d((com.tencent.mm.bw.a)new fh());
    locala.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.sG(1870);
    locala.sI(0);
    locala.sJ(0);
    IPCRunCgi.a(locala.aXF(), (IPCRunCgi.a)new b.b(this));
    AppMethodBeat.o(7076);
  }
  
  public final void aJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(7074);
    Object localObject = new fw();
    ((fw)localObject).url = this.url;
    ((fw)localObject).request_id = System.currentTimeMillis();
    ((fw)localObject).KJM = paramString;
    ((fw)localObject).scene = this.scene;
    ((fw)localObject).KIL = this.pHw;
    ((fw)localObject).pTI = paramInt;
    ((fw)localObject).KIJ = this.iwc;
    ((fw)localObject).session_id = this.pHx;
    ((fw)localObject).KIK = this.pHu;
    paramString = new d.a();
    paramString.c((com.tencent.mm.bw.a)localObject);
    paramString.d((com.tencent.mm.bw.a)new fx());
    paramString.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
    paramString.sG(2691);
    paramString.sI(0);
    paramString.sJ(0);
    IPCRunCgi.a(paramString.aXF(), (IPCRunCgi.a)new c(this));
    paramString = cpV();
    if (paramString != null) {}
    for (paramString = paramString.getString(2131763175);; paramString = null)
    {
      localObject = this.nhy;
      if (localObject == null) {
        p.btv("ui");
      }
      if (((WeakReference)localObject).get() == null) {
        break label275;
      }
      localObject = this.nhy;
      if (localObject == null) {
        p.btv("ui");
      }
      localObject = ((WeakReference)localObject).get();
      if (localObject != null) {
        break;
      }
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(7074);
      throw paramString;
    }
    if (((TmplShareWebViewToolUI)localObject).isFinishing()) {
      label275:
      paramInt = 1;
    }
    while (paramInt == 0)
    {
      cpU();
      if (this.gxX != null)
      {
        localObject = this.gxX;
        if (localObject == null) {
          p.hyc();
        }
        if (!((q)localObject).isShowing())
        {
          paramString = this.gxX;
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
      localObject = this.nhy;
      if (localObject == null) {
        p.btv("ui");
      }
      this.gxX = h.a((Context)((WeakReference)localObject).get(), paramString, true, (DialogInterface.OnCancelListener)new b.e(this));
    }
    AppMethodBeat.o(7074);
  }
  
  public final void aiF(String paramString)
  {
    if (paramString != null) {
      this.url = paramString;
    }
  }
  
  public final String ajO()
  {
    AppMethodBeat.i(7079);
    Object localObject = this.pHv;
    if (localObject == null) {
      p.btv("msgInfo");
    }
    localObject = ((x)localObject).ajO();
    AppMethodBeat.o(7079);
    return localObject;
  }
  
  public final v cpS()
  {
    AppMethodBeat.i(7070);
    v localv = this.ptH;
    if (localv == null) {
      p.btv("readerItem");
    }
    AppMethodBeat.o(7070);
    return localv;
  }
  
  public final void cpT()
  {
    AppMethodBeat.i(7073);
    fs localfs = new fs();
    localfs.url = this.url;
    localfs.vid = this.vid;
    localfs.scene = this.scene;
    localfs.KIL = this.pHw;
    localfs.nettype = com.tencent.mm.ag.m.ape();
    if (localfs.nettype == 100) {
      localfs.nettype = 0;
    }
    localfs.session_id = this.pHx;
    localfs.KIK = this.pHu;
    Object localObject = this.pHv;
    if (localObject == null) {
      p.btv("msgInfo");
    }
    int j;
    if (x.rK(((x)localObject).iwg))
    {
      localfs.KJl = 1;
      j = this.pHy;
      if (j != 0) {
        break label466;
      }
      i = 0;
      label140:
      localfs.KJm = i;
      localObject = MultiProcessMMKV.getMMKV(this.TAG);
      if (localObject != null)
      {
        localfs.KJn = ((MultiProcessMMKV)localObject).decodeLong("BizVideoLastPlayTimestamp", 0L);
        localfs.KJo = ((MultiProcessMMKV)localObject).decodeLong("BizVideoLastPlayFileSize", 0L);
        localfs.KJr = ((MultiProcessMMKV)localObject).decodeInt("BizVideoLastShowWifiTipsMode", 0);
      }
      if (cpV() != null)
      {
        localfs.KJp = new ql();
        localfs.KJp.KXn = com.tencent.mm.cb.a.jn((Context)cpV());
        localfs.KJp.KXo = com.tencent.mm.cb.a.jo((Context)cpV());
        localfs.KJp.KXp = ao.gJO().densityDpi;
      }
      localfs.KJt = this.pHz;
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.pKk;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.cqV()) {
        break label481;
      }
    }
    label466:
    label481:
    for (int i = 1;; i = 0)
    {
      localfs.KJs = i;
      Log.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d, width %d, height %d, dpi %d", new Object[] { Integer.valueOf(j), Long.valueOf(localfs.KJn), Long.valueOf(localfs.KJo), Integer.valueOf(localfs.KJp.KXn), Integer.valueOf(localfs.KJp.KXo), Integer.valueOf(localfs.KJp.KXp) });
      localObject = new d.a();
      ((d.a)localObject).c((com.tencent.mm.bw.a)localfs);
      ((d.a)localObject).d((com.tencent.mm.bw.a)new ft());
      ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
      ((d.a)localObject).sG(1179);
      ((d.a)localObject).sI(0);
      ((d.a)localObject).sJ(0);
      IPCRunCgi.a(((d.a)localObject).aXF(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(7073);
      return;
      localfs.KJl = 0;
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
  
  public final void cpU()
  {
    AppMethodBeat.i(7078);
    if (this.gxX != null)
    {
      Object localObject = this.gxX;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((q)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          p.hyc();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.gxX;
        if (localObject == null) {
          break;
        }
        ((q)localObject).dismiss();
        AppMethodBeat.o(7078);
        return;
      }
    }
    AppMethodBeat.o(7078);
  }
  
  public final boolean cpW()
  {
    return (this.iwg & 0x4) != 0;
  }
  
  public final int cpX()
  {
    return (int)(this.pHr / 1024L);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7077);
    cpU();
    n localn = this.pHq;
    if (localn.pLM.size() > 0)
    {
      localObject1 = new LinkedList();
      localObject2 = localn.pLM.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        p.g(localObject3, "it.next()");
        localObject3 = ((Map.Entry)localObject3).getValue();
        p.g(localObject3, "entry.value");
        ((LinkedList)localObject1).add((acd)localObject3);
      }
      localObject2 = new fj();
      ((fj)localObject2).KII = ((LinkedList)localObject1);
      localObject1 = localn.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      p.h(localObject2, "req");
      ((fj)localObject2).KIK = ((b)localObject1).pHu;
      ((fj)localObject2).session_id = ((b)localObject1).pHx;
      ((fj)localObject2).KIJ = ((b)localObject1).iwc;
      ((fj)localObject2).url = ((b)localObject1).url;
      localObject3 = new d.a();
      ((d.a)localObject3).c((com.tencent.mm.bw.a)localObject2);
      ((d.a)localObject3).d((com.tencent.mm.bw.a)new fk());
      ((d.a)localObject3).MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
      ((d.a)localObject3).sG(2827);
      ((d.a)localObject3).sI(0);
      ((d.a)localObject3).sJ(0);
      IPCRunCgi.a(((d.a)localObject3).aXF(), (IPCRunCgi.a)new b.d((b)localObject1));
      localn.pLM.clear();
    }
    Object localObject1 = new fg();
    Object localObject2 = new ff();
    ((ff)localObject2).type = 1;
    Object localObject3 = localn.pIL;
    if (localObject3 == null) {
      p.btv("controller");
    }
    int i = ((b)localObject3).scene;
    localObject3 = ((ff)localObject2).KEQ;
    p.g(localObject3, "reportData.item");
    n.a("scene", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    Object localObject4 = ((ff)localObject2).KEQ;
    p.g(localObject4, "reportData.item");
    n.a("netType", (String)localObject3, (LinkedList)localObject4);
    long l = localn.pLN;
    localObject3 = ((ff)localObject2).KEQ;
    p.g(localObject3, "reportData.item");
    n.a("StartTimeMs", String.valueOf(l), (LinkedList)localObject3);
    l = System.currentTimeMillis();
    localObject3 = ((ff)localObject2).KEQ;
    p.g(localObject3, "reportData.item");
    n.a("EndTimeMs", String.valueOf(l), (LinkedList)localObject3);
    localObject3 = localn.pIL;
    if (localObject3 == null) {
      p.btv("controller");
    }
    i = ((b)localObject3).iwc;
    localObject3 = ((ff)localObject2).KEQ;
    p.g(localObject3, "reportData.item");
    n.a("ItemShowType", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = new StringBuilder();
    localObject4 = localn.pIL;
    if (localObject4 == null) {
      p.btv("controller");
    }
    localObject3 = ((b)localObject4).pHx;
    localObject4 = ((ff)localObject2).KEQ;
    p.g(localObject4, "reportData.item");
    n.a("SessionId", (String)localObject3, (LinkedList)localObject4);
    localObject3 = localn.pIL;
    if (localObject3 == null) {
      p.btv("controller");
    }
    i = ((b)localObject3).pHu;
    localObject3 = ((ff)localObject2).KEQ;
    p.g(localObject3, "reportData.item");
    n.a("EnterId", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ((ff)localObject2).KEQ;
    p.g(localObject3, "reportData.item");
    n.a("NativePage", "1", (LinkedList)localObject3);
    localObject3 = localn.pIL;
    if (localObject3 == null) {
      p.btv("controller");
    }
    localObject3 = ((b)localObject3).url;
    localObject4 = ((ff)localObject2).KEQ;
    p.g(localObject4, "reportData.item");
    n.a("#AppMsgUrl#", (String)localObject3, (LinkedList)localObject4);
    ((fg)localObject1).KIG.add(localObject2);
    localObject3 = localn.pIL;
    if (localObject3 == null) {
      p.btv("controller");
    }
    ((b)localObject3).a((fg)localObject1);
    localObject1 = ((ff)localObject2).KEQ;
    p.g(localObject1, "reportData.item");
    localn.b(10945, (LinkedList)localObject1);
    this.lma = null;
    AppMethodBeat.o(7077);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
    {
      AppMethodBeat.i(7064);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7063);
          IPCRunCgi.a locala = this.pHE.pHD.lma;
          if (locala != null)
          {
            locala.a(paramInt1, paramInt2, paramString, paramd);
            AppMethodBeat.o(7063);
            return;
          }
          AppMethodBeat.o(7063);
        }
      });
      AppMethodBeat.o(7064);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
    {
      AppMethodBeat.i(7067);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7066);
          IPCRunCgi.a locala = this.pHF.pHD.lma;
          if (locala != null)
          {
            locala.a(paramInt1, paramInt2, paramString, paramd);
            AppMethodBeat.o(7066);
            return;
          }
          AppMethodBeat.o(7066);
        }
      });
      AppMethodBeat.o(7067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b
 * JD-Core Version:    0.7.0.1
 */