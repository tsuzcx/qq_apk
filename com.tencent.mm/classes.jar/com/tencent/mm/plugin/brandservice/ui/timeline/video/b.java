package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "channelSessionId", "getChannelSessionId", "()Ljava/lang/String;", "setChannelSessionId", "(Ljava/lang/String;)V", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "setCopyUrl", "enterId", "getEnterId", "setEnterId", "filesize", "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "hasShowWifiTips", "", "getHasShowWifiTips", "()Z", "setHasShowWifiTips", "(Z)V", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "landingPageType", "getLandingPageType", "setLandingPageType", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "wifiTipsFlag", "getWifiTipsFlag", "setWifiTipsFlag", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getFileSizeKB", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "onShowWifiTips", "mode", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b
{
  final String TAG;
  String dpP;
  private com.tencent.mm.ui.base.p fSP;
  public int hBV;
  public int hBZ;
  public String hCa;
  public long hGH;
  public int idx;
  IPCRunCgi.a kis;
  public WeakReference<TmplShareWebViewToolUI> lZK;
  public com.tencent.mm.ah.v oif;
  String otR;
  public String otS;
  public n otT;
  long otU;
  int otV;
  boolean otW;
  public int otX;
  public x otY;
  public int otZ;
  public int oua;
  int oub;
  public String ouc;
  public int oud;
  public byj oue;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m ouf;
  public int scene;
  public String url;
  
  public b()
  {
    AppMethodBeat.i(7081);
    this.TAG = "MicroMsg.BizNativePageController";
    this.hBZ = -1;
    this.dpP = "";
    this.otR = "";
    this.hCa = "";
    this.otS = "";
    this.otT = new n();
    this.otX = ((int)(System.currentTimeMillis() / 1000L));
    this.url = "";
    this.ouc = "";
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m localm = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m();
    m.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.oyh;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.f(new WeakReference(localm));
    this.ouf = localm;
    AppMethodBeat.o(7081);
  }
  
  private TmplShareWebViewToolUI bSl()
  {
    AppMethodBeat.i(7080);
    Object localObject = this.lZK;
    if (localObject == null) {
      d.g.b.p.bdF("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7080);
      return null;
    }
    localObject = this.lZK;
    if (localObject == null) {
      d.g.b.p.bdF("ui");
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
  
  public final void Ad(int paramInt)
  {
    AppMethodBeat.i(175498);
    ay localay = ay.aRW(this.TAG);
    if (localay != null)
    {
      localay.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000L);
      localay.encode("BizVideoLastPlayFileSize", this.otU);
      localay.encode("BizVideoLastShowWifiTipsMode", paramInt);
    }
    AppMethodBeat.o(175498);
  }
  
  public final String Wa()
  {
    AppMethodBeat.i(7079);
    Object localObject = this.otY;
    if (localObject == null) {
      d.g.b.p.bdF("msgInfo");
    }
    localObject = ((x)localObject).Wa();
    AppMethodBeat.o(7079);
    return localObject;
  }
  
  public final void YG(String paramString)
  {
    if (paramString != null) {
      this.url = paramString;
    }
  }
  
  public final void a(et paramet)
  {
    AppMethodBeat.i(7076);
    d.g.b.p.h(paramet, "req");
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.c((com.tencent.mm.bw.a)paramet);
    locala.d((com.tencent.mm.bw.a)new eu());
    locala.DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.oS(1870);
    locala.oU(0);
    locala.oV(0);
    IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new b.b(this));
    AppMethodBeat.o(7076);
  }
  
  public final void aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(7074);
    Object localObject = new fj();
    ((fj)localObject).url = this.url;
    ((fj)localObject).iaa = System.currentTimeMillis();
    ((fj)localObject).FQf = paramString;
    ((fj)localObject).scene = this.scene;
    ((fj)localObject).FPd = this.otZ;
    ((fj)localObject).oGc = paramInt;
    ((fj)localObject).FPb = this.hBV;
    ((fj)localObject).session_id = this.oua;
    ((fj)localObject).FPc = this.otX;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.c((com.tencent.mm.bw.a)localObject);
    paramString.d((com.tencent.mm.bw.a)new fk());
    paramString.DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
    paramString.oS(2691);
    paramString.oU(0);
    paramString.oV(0);
    IPCRunCgi.a(paramString.aDS(), (IPCRunCgi.a)new c(this));
    paramString = bSl();
    if (paramString != null) {}
    for (paramString = paramString.getString(2131761348);; paramString = null)
    {
      localObject = this.lZK;
      if (localObject == null) {
        d.g.b.p.bdF("ui");
      }
      if (((WeakReference)localObject).get() == null) {
        break label275;
      }
      localObject = this.lZK;
      if (localObject == null) {
        d.g.b.p.bdF("ui");
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
      bSk();
      if (this.fSP != null)
      {
        localObject = this.fSP;
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (!((com.tencent.mm.ui.base.p)localObject).isShowing())
        {
          paramString = this.fSP;
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
      localObject = this.lZK;
      if (localObject == null) {
        d.g.b.p.bdF("ui");
      }
      this.fSP = h.b((Context)((WeakReference)localObject).get(), paramString, true, (DialogInterface.OnCancelListener)new b.e(this));
    }
    AppMethodBeat.o(7074);
  }
  
  public final com.tencent.mm.ah.v bSi()
  {
    AppMethodBeat.i(7070);
    com.tencent.mm.ah.v localv = this.oif;
    if (localv == null) {
      d.g.b.p.bdF("readerItem");
    }
    AppMethodBeat.o(7070);
    return localv;
  }
  
  public final void bSj()
  {
    AppMethodBeat.i(7073);
    ff localff = new ff();
    localff.url = this.url;
    localff.hCa = this.hCa;
    localff.scene = this.scene;
    localff.FPd = this.otZ;
    localff.nettype = com.tencent.mm.ah.m.abf();
    if (localff.nettype == 100) {
      localff.nettype = 0;
    }
    localff.session_id = this.oua;
    localff.FPc = this.otX;
    Object localObject = this.otY;
    if (localObject == null) {
      d.g.b.p.bdF("msgInfo");
    }
    int j;
    if (x.om(((x)localObject).hBZ))
    {
      localff.FPD = 1;
      j = this.oub;
      if (j != 0) {
        break label466;
      }
      i = 0;
      label140:
      localff.FPE = i;
      localObject = ay.aRW(this.TAG);
      if (localObject != null)
      {
        localff.FPF = ((ay)localObject).decodeLong("BizVideoLastPlayTimestamp", 0L);
        localff.FPG = ((ay)localObject).decodeLong("BizVideoLastPlayFileSize", 0L);
        localff.FPJ = ((ay)localObject).decodeInt("BizVideoLastShowWifiTipsMode", 0);
      }
      if (bSl() != null)
      {
        localff.FPH = new pl();
        localff.FPH.GcY = com.tencent.mm.cb.a.iu((Context)bSl());
        localff.FPH.GcZ = com.tencent.mm.cb.a.iv((Context)bSl());
        localff.FPH.Gda = al.fBQ().densityDpi;
      }
      localff.FPL = this.ouc;
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.owG;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.bTk()) {
        break label481;
      }
    }
    label466:
    label481:
    for (int i = 1;; i = 0)
    {
      localff.FPK = i;
      ae.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d, width %d, height %d, dpi %d", new Object[] { Integer.valueOf(j), Long.valueOf(localff.FPF), Long.valueOf(localff.FPG), Integer.valueOf(localff.FPH.GcY), Integer.valueOf(localff.FPH.GcZ), Integer.valueOf(localff.FPH.Gda) });
      localObject = new com.tencent.mm.ak.b.a();
      ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)localff);
      ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new fg());
      ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
      ((com.tencent.mm.ak.b.a)localObject).oS(1179);
      ((com.tencent.mm.ak.b.a)localObject).oU(0);
      ((com.tencent.mm.ak.b.a)localObject).oV(0);
      IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject).aDS(), (IPCRunCgi.a)new a(this));
      AppMethodBeat.o(7073);
      return;
      localff.FPD = 0;
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
  
  public final void bSk()
  {
    AppMethodBeat.i(7078);
    if (this.fSP != null)
    {
      Object localObject = this.fSP;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((com.tencent.mm.ui.base.p)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.fSP;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
        AppMethodBeat.o(7078);
        return;
      }
    }
    AppMethodBeat.o(7078);
  }
  
  public final boolean bSm()
  {
    return (this.hBZ & 0x4) != 0;
  }
  
  public final int bSn()
  {
    return (int)(this.otU / 1024L);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7077);
    bSk();
    n localn = this.otT;
    if (localn.oyi.size() > 0)
    {
      localObject1 = new LinkedList();
      localObject2 = localn.oyi.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        d.g.b.p.g(localObject3, "it.next()");
        localObject3 = ((Map.Entry)localObject3).getValue();
        d.g.b.p.g(localObject3, "entry.value");
        ((LinkedList)localObject1).add((aal)localObject3);
      }
      localObject2 = new ew();
      ((ew)localObject2).FPa = ((LinkedList)localObject1);
      localObject1 = localn.ovq;
      if (localObject1 == null) {
        d.g.b.p.bdF("controller");
      }
      d.g.b.p.h(localObject2, "req");
      ((ew)localObject2).FPc = ((b)localObject1).otX;
      ((ew)localObject2).session_id = ((b)localObject1).oua;
      ((ew)localObject2).FPb = ((b)localObject1).hBV;
      ((ew)localObject2).url = ((b)localObject1).url;
      localObject3 = new com.tencent.mm.ak.b.a();
      ((com.tencent.mm.ak.b.a)localObject3).c((com.tencent.mm.bw.a)localObject2);
      ((com.tencent.mm.ak.b.a)localObject3).d((com.tencent.mm.bw.a)new ex());
      ((com.tencent.mm.ak.b.a)localObject3).DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
      ((com.tencent.mm.ak.b.a)localObject3).oS(2827);
      ((com.tencent.mm.ak.b.a)localObject3).oU(0);
      ((com.tencent.mm.ak.b.a)localObject3).oV(0);
      IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject3).aDS(), (IPCRunCgi.a)new b.d((b)localObject1));
      localn.oyi.clear();
    }
    Object localObject1 = new et();
    Object localObject2 = new es();
    ((es)localObject2).type = 1;
    Object localObject3 = localn.ovq;
    if (localObject3 == null) {
      d.g.b.p.bdF("controller");
    }
    int i = ((b)localObject3).scene;
    localObject3 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("scene", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = az.iW(ak.getContext());
    Object localObject4 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject4, "reportData.item");
    n.a("netType", (String)localObject3, (LinkedList)localObject4);
    long l = localn.oyj;
    localObject3 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("StartTimeMs", String.valueOf(l), (LinkedList)localObject3);
    l = System.currentTimeMillis();
    localObject3 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("EndTimeMs", String.valueOf(l), (LinkedList)localObject3);
    localObject3 = localn.ovq;
    if (localObject3 == null) {
      d.g.b.p.bdF("controller");
    }
    i = ((b)localObject3).hBV;
    localObject3 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("ItemShowType", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = new StringBuilder();
    localObject4 = localn.ovq;
    if (localObject4 == null) {
      d.g.b.p.bdF("controller");
    }
    localObject3 = ((b)localObject4).oua;
    localObject4 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject4, "reportData.item");
    n.a("SessionId", (String)localObject3, (LinkedList)localObject4);
    localObject3 = localn.ovq;
    if (localObject3 == null) {
      d.g.b.p.bdF("controller");
    }
    i = ((b)localObject3).otX;
    localObject3 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("EnterId", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("NativePage", "1", (LinkedList)localObject3);
    localObject3 = localn.ovq;
    if (localObject3 == null) {
      d.g.b.p.bdF("controller");
    }
    localObject3 = ((b)localObject3).url;
    localObject4 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject4, "reportData.item");
    n.a("#AppMsgUrl#", (String)localObject3, (LinkedList)localObject4);
    ((et)localObject1).FOY.add(localObject2);
    localObject3 = localn.ovq;
    if (localObject3 == null) {
      d.g.b.p.bdF("controller");
    }
    ((b)localObject3).a((et)localObject1);
    localObject1 = ((es)localObject2).FLq;
    d.g.b.p.g(localObject1, "reportData.item");
    localn.b(10945, (LinkedList)localObject1);
    this.kis = null;
    AppMethodBeat.o(7077);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7064);
      ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7063);
          IPCRunCgi.a locala = this.ouh.oug.kis;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(b paramb) {}
    
    public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(7067);
      ar.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(7066);
          IPCRunCgi.a locala = this.ouj.oug.kis;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b
 * JD-Core Version:    0.7.0.1
 */