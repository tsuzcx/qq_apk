package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.ai;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "channelSessionId", "getChannelSessionId", "()Ljava/lang/String;", "setChannelSessionId", "(Ljava/lang/String;)V", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "setCopyUrl", "enterId", "getEnterId", "setEnterId", "filesize", "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "hasShowWifiTips", "", "getHasShowWifiTips", "()Z", "setHasShowWifiTips", "(Z)V", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "landingPageType", "getLandingPageType", "setLandingPageType", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "wifiTipsFlag", "getWifiTipsFlag", "setWifiTipsFlag", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getFileSizeKB", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "onShowWifiTips", "mode", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b
{
  final String TAG;
  String dfT;
  private p ftP;
  public int gGB;
  public String gGC;
  public int gGx;
  public long gLf;
  public int idx;
  IPCRunCgi.a jkE;
  public WeakReference<TmplShareWebViewToolUI> kUk;
  public com.tencent.mm.ai.v mYN;
  String niB;
  public String niC;
  public n niD;
  long niE;
  int niF;
  boolean niG;
  public int niH;
  public x niI;
  public int niJ;
  public int niK;
  int niL;
  public String niM;
  public int niN;
  public bol niO;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m niP;
  public int scene;
  public String url;
  
  public b()
  {
    AppMethodBeat.i(7081);
    this.TAG = "MicroMsg.BizNativePageController";
    this.gGB = -1;
    this.dfT = "";
    this.niB = "";
    this.gGC = "";
    this.niC = "";
    this.niD = new n();
    this.niH = ((int)(System.currentTimeMillis() / 1000L));
    this.url = "";
    this.niM = "";
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m localm = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m();
    m.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.nmf;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.b(new WeakReference(localm));
    this.niP = localm;
    AppMethodBeat.o(7081);
  }
  
  private TmplShareWebViewToolUI bFx()
  {
    AppMethodBeat.i(7080);
    Object localObject = this.kUk;
    if (localObject == null) {
      k.aPZ("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7080);
      return null;
    }
    localObject = this.kUk;
    if (localObject == null) {
      k.aPZ("ui");
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
  
  public final void PY(String paramString)
  {
    if (paramString != null) {
      this.url = paramString;
    }
  }
  
  public final String SI()
  {
    AppMethodBeat.i(7079);
    Object localObject = this.niI;
    if (localObject == null) {
      k.aPZ("msgInfo");
    }
    localObject = ((x)localObject).SI();
    AppMethodBeat.o(7079);
    return localObject;
  }
  
  public final void a(en paramen)
  {
    AppMethodBeat.i(7076);
    k.h(paramen, "req");
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.c((com.tencent.mm.bx.a)paramen);
    locala.d((com.tencent.mm.bx.a)new eo());
    locala.wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.nB(1870);
    locala.nD(0);
    locala.nE(0);
    IPCRunCgi.a(locala.atI(), (IPCRunCgi.a)new b.b(this));
    AppMethodBeat.o(7076);
  }
  
  public final void aB(int paramInt, String paramString)
  {
    AppMethodBeat.i(7074);
    Object localObject = new fc();
    ((fc)localObject).url = this.url;
    ((fc)localObject).hea = System.currentTimeMillis();
    ((fc)localObject).CzS = paramString;
    ((fc)localObject).scene = this.scene;
    ((fc)localObject).CyR = this.niJ;
    ((fc)localObject).ntg = paramInt;
    ((fc)localObject).CyP = this.gGx;
    ((fc)localObject).session_id = this.niK;
    ((fc)localObject).CyQ = this.niH;
    paramString = new com.tencent.mm.al.b.a();
    paramString.c((com.tencent.mm.bx.a)localObject);
    paramString.d((com.tencent.mm.bx.a)new fd());
    paramString.wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
    paramString.nB(2691);
    paramString.nD(0);
    paramString.nE(0);
    IPCRunCgi.a(paramString.atI(), (IPCRunCgi.a)new c(this));
    paramString = bFx();
    if (paramString != null) {}
    for (paramString = paramString.getString(2131761348);; paramString = null)
    {
      localObject = this.kUk;
      if (localObject == null) {
        k.aPZ("ui");
      }
      if (((WeakReference)localObject).get() == null) {
        break label275;
      }
      localObject = this.kUk;
      if (localObject == null) {
        k.aPZ("ui");
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
      bFw();
      if (this.ftP != null)
      {
        localObject = this.ftP;
        if (localObject == null) {
          k.fvU();
        }
        if (!((p)localObject).isShowing())
        {
          paramString = this.ftP;
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
      localObject = this.kUk;
      if (localObject == null) {
        k.aPZ("ui");
      }
      this.ftP = h.b((Context)((WeakReference)localObject).get(), paramString, true, (DialogInterface.OnCancelListener)new b.e(this));
    }
    AppMethodBeat.o(7074);
  }
  
  public final com.tencent.mm.ai.v bFu()
  {
    AppMethodBeat.i(7070);
    com.tencent.mm.ai.v localv = this.mYN;
    if (localv == null) {
      k.aPZ("readerItem");
    }
    AppMethodBeat.o(7070);
    return localv;
  }
  
  public final void bFv()
  {
    AppMethodBeat.i(7073);
    ey localey = new ey();
    localey.url = this.url;
    localey.gGC = this.gGC;
    localey.scene = this.scene;
    localey.CyR = this.niJ;
    localey.nettype = com.tencent.mm.ai.m.Xx();
    if (localey.nettype == 100) {
      localey.nettype = 0;
    }
    localey.session_id = this.niK;
    localey.CyQ = this.niH;
    Object localObject = this.niI;
    if (localObject == null) {
      k.aPZ("msgInfo");
    }
    int j;
    if (x.mW(((x)localObject).gGB))
    {
      localey.Czq = 1;
      j = this.niL;
      if (j != 0) {
        break label466;
      }
      i = 0;
      label140:
      localey.Czr = i;
      localObject = ax.aFC(this.TAG);
      if (localObject != null)
      {
        localey.Czs = ((ax)localObject).decodeLong("BizVideoLastPlayTimestamp", 0L);
        localey.Czt = ((ax)localObject).decodeLong("BizVideoLastPlayFileSize", 0L);
        localey.Czw = ((ax)localObject).decodeInt("BizVideoLastShowWifiTipsMode", 0);
      }
      if (bFx() != null)
      {
        localey.Czu = new nx();
        localey.Czu.CLx = com.tencent.mm.cd.a.hV((Context)bFx());
        localey.Czu.CLy = com.tencent.mm.cd.a.hW((Context)bFx());
        localey.Czu.CLz = ai.eRR().densityDpi;
      }
      localey.Czy = this.niM;
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.nkE;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.bGl()) {
        break label481;
      }
    }
    label466:
    label481:
    for (int i = 1;; i = 0)
    {
      localey.Czx = i;
      ad.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d, width %d, height %d, dpi %d", new Object[] { Integer.valueOf(j), Long.valueOf(localey.Czs), Long.valueOf(localey.Czt), Integer.valueOf(localey.Czu.CLx), Integer.valueOf(localey.Czu.CLy), Integer.valueOf(localey.Czu.CLz) });
      localObject = new com.tencent.mm.al.b.a();
      ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)localey);
      ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new ez());
      ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
      ((com.tencent.mm.al.b.a)localObject).nB(1179);
      ((com.tencent.mm.al.b.a)localObject).nD(0);
      ((com.tencent.mm.al.b.a)localObject).nE(0);
      IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject).atI(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(7073);
      return;
      localey.Czq = 0;
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
  
  public final void bFw()
  {
    AppMethodBeat.i(7078);
    if (this.ftP != null)
    {
      Object localObject = this.ftP;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((p)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          k.fvU();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.ftP;
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
  
  public final boolean bFy()
  {
    return (this.gGB & 0x4) != 0;
  }
  
  public final int bFz()
  {
    return (int)(this.niE / 1024L);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7077);
    bFw();
    n localn = this.niD;
    if (localn.nmg.size() > 0)
    {
      localObject1 = new LinkedList();
      localObject2 = localn.nmg.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        k.g(localObject3, "it.next()");
        localObject3 = ((Map.Entry)localObject3).getValue();
        k.g(localObject3, "entry.value");
        ((LinkedList)localObject1).add((xr)localObject3);
      }
      localObject2 = new eq();
      ((eq)localObject2).CyO = ((LinkedList)localObject1);
      localObject1 = localn.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      k.h(localObject2, "req");
      ((eq)localObject2).CyQ = ((b)localObject1).niH;
      ((eq)localObject2).session_id = ((b)localObject1).niK;
      ((eq)localObject2).CyP = ((b)localObject1).gGx;
      ((eq)localObject2).url = ((b)localObject1).url;
      localObject3 = new com.tencent.mm.al.b.a();
      ((com.tencent.mm.al.b.a)localObject3).c((com.tencent.mm.bx.a)localObject2);
      ((com.tencent.mm.al.b.a)localObject3).d((com.tencent.mm.bx.a)new er());
      ((com.tencent.mm.al.b.a)localObject3).wg("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
      ((com.tencent.mm.al.b.a)localObject3).nB(2827);
      ((com.tencent.mm.al.b.a)localObject3).nD(0);
      ((com.tencent.mm.al.b.a)localObject3).nE(0);
      IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject3).atI(), (IPCRunCgi.a)new b.d((b)localObject1));
      localn.nmg.clear();
    }
    Object localObject1 = new en();
    Object localObject2 = new em();
    ((em)localObject2).type = 1;
    Object localObject3 = localn.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    int i = ((b)localObject3).scene;
    localObject3 = ((em)localObject2).Cvr;
    k.g(localObject3, "reportData.item");
    n.a("scene", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ay.iw(aj.getContext());
    Object localObject4 = ((em)localObject2).Cvr;
    k.g(localObject4, "reportData.item");
    n.a("netType", (String)localObject3, (LinkedList)localObject4);
    long l = localn.nmh;
    localObject3 = ((em)localObject2).Cvr;
    k.g(localObject3, "reportData.item");
    n.a("StartTimeMs", String.valueOf(l), (LinkedList)localObject3);
    l = System.currentTimeMillis();
    localObject3 = ((em)localObject2).Cvr;
    k.g(localObject3, "reportData.item");
    n.a("EndTimeMs", String.valueOf(l), (LinkedList)localObject3);
    localObject3 = localn.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    i = ((b)localObject3).gGx;
    localObject3 = ((em)localObject2).Cvr;
    k.g(localObject3, "reportData.item");
    n.a("ItemShowType", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = new StringBuilder();
    localObject4 = localn.njZ;
    if (localObject4 == null) {
      k.aPZ("controller");
    }
    localObject3 = ((b)localObject4).niK;
    localObject4 = ((em)localObject2).Cvr;
    k.g(localObject4, "reportData.item");
    n.a("SessionId", (String)localObject3, (LinkedList)localObject4);
    localObject3 = localn.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    i = ((b)localObject3).niH;
    localObject3 = ((em)localObject2).Cvr;
    k.g(localObject3, "reportData.item");
    n.a("EnterId", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ((em)localObject2).Cvr;
    k.g(localObject3, "reportData.item");
    n.a("NativePage", "1", (LinkedList)localObject3);
    localObject3 = localn.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    localObject3 = ((b)localObject3).url;
    localObject4 = ((em)localObject2).Cvr;
    k.g(localObject4, "reportData.item");
    n.a("#AppMsgUrl#", (String)localObject3, (LinkedList)localObject4);
    ((en)localObject1).CyM.add(localObject2);
    localObject3 = localn.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    ((b)localObject3).a((en)localObject1);
    localObject1 = ((em)localObject2).Cvr;
    k.g(localObject1, "reportData.item");
    localn.b(10945, (LinkedList)localObject1);
    this.jkE = null;
    AppMethodBeat.o(7077);
  }
  
  public final void yu(int paramInt)
  {
    AppMethodBeat.i(175498);
    ax localax = ax.aFC(this.TAG);
    if (localax != null)
    {
      localax.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000L);
      localax.encode("BizVideoLastPlayFileSize", this.niE);
      localax.encode("BizVideoLastShowWifiTipsMode", paramInt);
    }
    AppMethodBeat.o(175498);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(7064);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7063);
          IPCRunCgi.a locala = this.niR.niQ.jkE;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(7067);
      aq.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7066);
          IPCRunCgi.a locala = this.niT.niQ.jkE;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b
 * JD-Core Version:    0.7.0.1
 */