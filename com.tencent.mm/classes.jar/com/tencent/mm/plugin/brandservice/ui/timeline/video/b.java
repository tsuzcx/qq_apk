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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "channelSessionId", "getChannelSessionId", "()Ljava/lang/String;", "setChannelSessionId", "(Ljava/lang/String;)V", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "setCopyUrl", "enterId", "getEnterId", "setEnterId", "filesize", "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "hasShowWifiTips", "", "getHasShowWifiTips", "()Z", "setHasShowWifiTips", "(Z)V", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "landingPageType", "getLandingPageType", "setLandingPageType", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "wifiTipsFlag", "getWifiTipsFlag", "setWifiTipsFlag", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getFileSizeKB", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "onShowWifiTips", "mode", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b
{
  final String TAG;
  String doK;
  private com.tencent.mm.ui.base.p fQJ;
  public long hDP;
  public int hzh;
  public int hzl;
  public String hzm;
  public int idx;
  IPCRunCgi.a kfc;
  public WeakReference<TmplShareWebViewToolUI> lVh;
  public com.tencent.mm.ai.v ocq;
  String ooa;
  public String oob;
  public n ooc;
  long ood;
  int ooe;
  boolean oof;
  public int oog;
  public x ooh;
  public int ooi;
  public int ooj;
  int ook;
  public String ool;
  public int oom;
  public bxp oon;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m ooo;
  public int scene;
  public String url;
  
  public b()
  {
    AppMethodBeat.i(7081);
    this.TAG = "MicroMsg.BizNativePageController";
    this.hzl = -1;
    this.doK = "";
    this.ooa = "";
    this.hzm = "";
    this.oob = "";
    this.ooc = new n();
    this.oog = ((int)(System.currentTimeMillis() / 1000L));
    this.url = "";
    this.ool = "";
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m localm = new com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m();
    m.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.orL;
    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m.b(new WeakReference(localm));
    this.ooo = localm;
    AppMethodBeat.o(7081);
  }
  
  private TmplShareWebViewToolUI bRk()
  {
    AppMethodBeat.i(7080);
    Object localObject = this.lVh;
    if (localObject == null) {
      d.g.b.p.bcb("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7080);
      return null;
    }
    localObject = this.lVh;
    if (localObject == null) {
      d.g.b.p.bcb("ui");
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
  
  public final String VS()
  {
    AppMethodBeat.i(7079);
    Object localObject = this.ooh;
    if (localObject == null) {
      d.g.b.p.bcb("msgInfo");
    }
    localObject = ((x)localObject).VS();
    AppMethodBeat.o(7079);
    return localObject;
  }
  
  public final void XT(String paramString)
  {
    if (paramString != null) {
      this.url = paramString;
    }
  }
  
  public final void a(et paramet)
  {
    AppMethodBeat.i(7076);
    d.g.b.p.h(paramet, "req");
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.c((com.tencent.mm.bx.a)paramet);
    locala.d((com.tencent.mm.bx.a)new eu());
    locala.Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.oP(1870);
    locala.oR(0);
    locala.oS(0);
    IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)new b.b(this));
    AppMethodBeat.o(7076);
  }
  
  public final void aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(7074);
    Object localObject = new fj();
    ((fj)localObject).url = this.url;
    ((fj)localObject).hXi = System.currentTimeMillis();
    ((fj)localObject).FxH = paramString;
    ((fj)localObject).scene = this.scene;
    ((fj)localObject).FwF = this.ooi;
    ((fj)localObject).ozA = paramInt;
    ((fj)localObject).FwD = this.hzh;
    ((fj)localObject).session_id = this.ooj;
    ((fj)localObject).FwE = this.oog;
    paramString = new com.tencent.mm.al.b.a();
    paramString.c((com.tencent.mm.bx.a)localObject);
    paramString.d((com.tencent.mm.bx.a)new fk());
    paramString.Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
    paramString.oP(2691);
    paramString.oR(0);
    paramString.oS(0);
    IPCRunCgi.a(paramString.aDC(), (IPCRunCgi.a)new b.c(this));
    paramString = bRk();
    if (paramString != null) {}
    for (paramString = paramString.getString(2131761348);; paramString = null)
    {
      localObject = this.lVh;
      if (localObject == null) {
        d.g.b.p.bcb("ui");
      }
      if (((WeakReference)localObject).get() == null) {
        break label275;
      }
      localObject = this.lVh;
      if (localObject == null) {
        d.g.b.p.bcb("ui");
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
      bRj();
      if (this.fQJ != null)
      {
        localObject = this.fQJ;
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        if (!((com.tencent.mm.ui.base.p)localObject).isShowing())
        {
          paramString = this.fQJ;
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
      localObject = this.lVh;
      if (localObject == null) {
        d.g.b.p.bcb("ui");
      }
      this.fQJ = h.b((Context)((WeakReference)localObject).get(), paramString, true, (DialogInterface.OnCancelListener)new b.e(this));
    }
    AppMethodBeat.o(7074);
  }
  
  public final com.tencent.mm.ai.v bRh()
  {
    AppMethodBeat.i(7070);
    com.tencent.mm.ai.v localv = this.ocq;
    if (localv == null) {
      d.g.b.p.bcb("readerItem");
    }
    AppMethodBeat.o(7070);
    return localv;
  }
  
  public final void bRi()
  {
    AppMethodBeat.i(7073);
    ff localff = new ff();
    localff.url = this.url;
    localff.hzm = this.hzm;
    localff.scene = this.scene;
    localff.FwF = this.ooi;
    localff.nettype = com.tencent.mm.ai.m.aaW();
    if (localff.nettype == 100) {
      localff.nettype = 0;
    }
    localff.session_id = this.ooj;
    localff.FwE = this.oog;
    Object localObject = this.ooh;
    if (localObject == null) {
      d.g.b.p.bcb("msgInfo");
    }
    int j;
    if (x.oj(((x)localObject).hzl))
    {
      localff.Fxf = 1;
      j = this.ook;
      if (j != 0) {
        break label466;
      }
      i = 0;
      label140:
      localff.Fxg = i;
      localObject = ax.aQz(this.TAG);
      if (localObject != null)
      {
        localff.Fxh = ((ax)localObject).decodeLong("BizVideoLastPlayTimestamp", 0L);
        localff.Fxi = ((ax)localObject).decodeLong("BizVideoLastPlayFileSize", 0L);
        localff.Fxl = ((ax)localObject).decodeInt("BizVideoLastShowWifiTipsMode", 0);
      }
      if (bRk() != null)
      {
        localff.Fxj = new pj();
        localff.Fxj.FKz = com.tencent.mm.cc.a.ip((Context)bRk());
        localff.Fxj.FKA = com.tencent.mm.cc.a.iq((Context)bRk());
        localff.Fxj.FKB = al.fxO().densityDpi;
      }
      localff.Fxn = this.ool;
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.oqk;
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.bRY()) {
        break label481;
      }
    }
    label466:
    label481:
    for (int i = 1;; i = 0)
    {
      localff.Fxm = i;
      ad.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d, width %d, height %d, dpi %d", new Object[] { Integer.valueOf(j), Long.valueOf(localff.Fxh), Long.valueOf(localff.Fxi), Integer.valueOf(localff.Fxj.FKz), Integer.valueOf(localff.Fxj.FKA), Integer.valueOf(localff.Fxj.FKB) });
      localObject = new com.tencent.mm.al.b.a();
      ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)localff);
      ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new fg());
      ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
      ((com.tencent.mm.al.b.a)localObject).oP(1179);
      ((com.tencent.mm.al.b.a)localObject).oR(0);
      ((com.tencent.mm.al.b.a)localObject).oS(0);
      IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject).aDC(), (IPCRunCgi.a)new b.a(this));
      AppMethodBeat.o(7073);
      return;
      localff.Fxf = 0;
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
  
  public final void bRj()
  {
    AppMethodBeat.i(7078);
    if (this.fQJ != null)
    {
      Object localObject = this.fQJ;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((com.tencent.mm.ui.base.p)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.fQJ;
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
  
  public final boolean bRl()
  {
    return (this.hzl & 0x4) != 0;
  }
  
  public final int bRm()
  {
    return (int)(this.ood / 1024L);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7077);
    bRj();
    n localn = this.ooc;
    if (localn.orM.size() > 0)
    {
      localObject1 = new LinkedList();
      localObject2 = localn.orM.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        d.g.b.p.g(localObject3, "it.next()");
        localObject3 = ((Map.Entry)localObject3).getValue();
        d.g.b.p.g(localObject3, "entry.value");
        ((LinkedList)localObject1).add((aai)localObject3);
      }
      localObject2 = new ew();
      ((ew)localObject2).FwC = ((LinkedList)localObject1);
      localObject1 = localn.opy;
      if (localObject1 == null) {
        d.g.b.p.bcb("controller");
      }
      d.g.b.p.h(localObject2, "req");
      ((ew)localObject2).FwE = ((b)localObject1).oog;
      ((ew)localObject2).session_id = ((b)localObject1).ooj;
      ((ew)localObject2).FwD = ((b)localObject1).hzh;
      ((ew)localObject2).url = ((b)localObject1).url;
      localObject3 = new com.tencent.mm.al.b.a();
      ((com.tencent.mm.al.b.a)localObject3).c((com.tencent.mm.bx.a)localObject2);
      ((com.tencent.mm.al.b.a)localObject3).d((com.tencent.mm.bx.a)new ex());
      ((com.tencent.mm.al.b.a)localObject3).Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
      ((com.tencent.mm.al.b.a)localObject3).oP(2827);
      ((com.tencent.mm.al.b.a)localObject3).oR(0);
      ((com.tencent.mm.al.b.a)localObject3).oS(0);
      IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject3).aDC(), (IPCRunCgi.a)new b.d((b)localObject1));
      localn.orM.clear();
    }
    Object localObject1 = new et();
    Object localObject2 = new es();
    ((es)localObject2).type = 1;
    Object localObject3 = localn.opy;
    if (localObject3 == null) {
      d.g.b.p.bcb("controller");
    }
    int i = ((b)localObject3).scene;
    localObject3 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("scene", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ay.iR(aj.getContext());
    Object localObject4 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject4, "reportData.item");
    n.a("netType", (String)localObject3, (LinkedList)localObject4);
    long l = localn.orN;
    localObject3 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("StartTimeMs", String.valueOf(l), (LinkedList)localObject3);
    l = System.currentTimeMillis();
    localObject3 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("EndTimeMs", String.valueOf(l), (LinkedList)localObject3);
    localObject3 = localn.opy;
    if (localObject3 == null) {
      d.g.b.p.bcb("controller");
    }
    i = ((b)localObject3).hzh;
    localObject3 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("ItemShowType", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = new StringBuilder();
    localObject4 = localn.opy;
    if (localObject4 == null) {
      d.g.b.p.bcb("controller");
    }
    localObject3 = ((b)localObject4).ooj;
    localObject4 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject4, "reportData.item");
    n.a("SessionId", (String)localObject3, (LinkedList)localObject4);
    localObject3 = localn.opy;
    if (localObject3 == null) {
      d.g.b.p.bcb("controller");
    }
    i = ((b)localObject3).oog;
    localObject3 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("EnterId", String.valueOf(i), (LinkedList)localObject3);
    localObject3 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject3, "reportData.item");
    n.a("NativePage", "1", (LinkedList)localObject3);
    localObject3 = localn.opy;
    if (localObject3 == null) {
      d.g.b.p.bcb("controller");
    }
    localObject3 = ((b)localObject3).url;
    localObject4 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject4, "reportData.item");
    n.a("#AppMsgUrl#", (String)localObject3, (LinkedList)localObject4);
    ((et)localObject1).FwA.add(localObject2);
    localObject3 = localn.opy;
    if (localObject3 == null) {
      d.g.b.p.bcb("controller");
    }
    ((b)localObject3).a((et)localObject1);
    localObject1 = ((es)localObject2).FsS;
    d.g.b.p.g(localObject1, "reportData.item");
    localn.b(10945, (LinkedList)localObject1);
    this.kfc = null;
    AppMethodBeat.o(7077);
  }
  
  public final void zU(int paramInt)
  {
    AppMethodBeat.i(175498);
    ax localax = ax.aQz(this.TAG);
    if (localax != null)
    {
      localax.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000L);
      localax.encode("BizVideoLastPlayFileSize", this.ood);
      localax.encode("BizVideoLastShowWifiTipsMode", paramInt);
    }
    AppMethodBeat.o(175498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b
 * JD-Core Version:    0.7.0.1
 */