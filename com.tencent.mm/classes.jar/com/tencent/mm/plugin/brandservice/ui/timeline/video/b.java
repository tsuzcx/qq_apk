package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.v;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.af.s;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "()Ljava/lang/String;", "setCopyUrl", "(Ljava/lang/String;)V", "enterId", "getEnterId", "setEnterId", "filesize", "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "overSize", "getOverSize", "setOverSize", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "appMsgGet", "", "appMsgIgnoreWarning", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getKv17149", "getTalker", "ignoreWarning", "init", "isFinished", "isMaliciousTitle", "onDestroy", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b
{
  final String TAG;
  private String cqX;
  private p ehb;
  public int fgh;
  public int fgk;
  public String fgl;
  public WeakReference<TmplShareWebViewToolUI> hkv;
  com.tencent.mm.ipcinvoker.wx_extension.b.a hnw;
  public s jXm;
  public int kbN;
  public bca kfA;
  f kfB;
  private String kfp;
  public String kfq;
  public g kfr;
  public long kfs;
  public int kft;
  long kfu;
  public int kfv;
  public q kfw;
  public int kfx;
  int kfy;
  int kfz;
  public int scene;
  public String url;
  
  public b()
  {
    AppMethodBeat.i(152813);
    this.TAG = "MicroMsg.BizNativePageController";
    this.fgk = -1;
    this.cqX = "";
    this.kfp = "";
    this.fgl = "";
    this.kfq = "";
    this.kfr = new g();
    this.kfv = ((int)(System.currentTimeMillis() / 1000L));
    this.url = "";
    this.kfB = new f();
    AppMethodBeat.o(152813);
  }
  
  public final String HD()
  {
    AppMethodBeat.i(152812);
    Object localObject = this.jXm;
    if (localObject == null) {
      j.ays("msgInfo");
    }
    localObject = ((s)localObject).HD();
    AppMethodBeat.o(152812);
    return localObject;
  }
  
  public final void Hq(String paramString)
  {
    if (paramString != null) {
      this.url = paramString;
    }
  }
  
  public final void a(com.tencent.mm.ipcinvoker.wx_extension.b.a parama)
  {
    AppMethodBeat.i(152805);
    j.q(parama, "callback");
    this.hnw = parama;
    AppMethodBeat.o(152805);
  }
  
  public final void a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI, int paramInt1, int paramInt2, q paramq, s params, int paramInt3)
  {
    AppMethodBeat.i(152804);
    j.q(paramTmplShareWebViewToolUI, "ui");
    j.q(paramq, "readerItem");
    j.q(params, "msgInfo");
    this.hkv = new WeakReference(paramTmplShareWebViewToolUI);
    this.scene = paramInt1;
    this.kbN = paramInt2;
    Hq(paramq.url);
    this.kfw = paramq;
    this.jXm = params;
    this.fgh = paramq.type;
    this.kfv = paramInt3;
    this.cqX = params.cqX;
    this.kfp = params.fjB;
    this.fgl = params.fjD.fgl;
    this.kfr.a(this);
    this.kfB.a(this);
    try
    {
      paramTmplShareWebViewToolUI = Uri.parse(params.fjD.url);
      this.kfs = bo.getLong(paramTmplShareWebViewToolUI.getQueryParameter("mid"), 0L);
      this.kft = bo.getInt(paramTmplShareWebViewToolUI.getQueryParameter("idx"), 0);
      ab.i(this.TAG, "init vid=" + this.fgl);
      AppMethodBeat.o(152804);
      return;
    }
    catch (UnsupportedOperationException paramTmplShareWebViewToolUI)
    {
      for (;;)
      {
        ab.w(this.TAG, "init parse url exp %s", new Object[] { paramTmplShareWebViewToolUI.getMessage() });
      }
    }
    catch (Exception paramTmplShareWebViewToolUI)
    {
      for (;;)
      {
        ab.w(this.TAG, "init parse url exp %s", new Object[] { paramTmplShareWebViewToolUI.getMessage() });
      }
    }
  }
  
  public final void a(ea paramea)
  {
    AppMethodBeat.i(152809);
    j.q(paramea, "req");
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    locala.a((a)paramea);
    locala.b((a)new eb());
    locala.rl("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.kT(1870);
    locala.kU(0);
    locala.kV(0);
    com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new b.b(this));
    AppMethodBeat.o(152809);
  }
  
  public final void a(ed paramed)
  {
    AppMethodBeat.i(152808);
    j.q(paramed, "req");
    paramed.wqb = this.kfv;
    paramed.session_id = this.kfx;
    paramed.wqa = this.fgh;
    paramed.url = this.url;
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    locala.a((a)paramed);
    locala.b((a)new ee());
    locala.rl("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
    locala.kT(2827);
    locala.kU(0);
    locala.kV(0);
    com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new b.d(this));
    AppMethodBeat.o(152808);
  }
  
  public final q aZd()
  {
    AppMethodBeat.i(152803);
    q localq = this.kfw;
    if (localq == null) {
      j.ays("readerItem");
    }
    AppMethodBeat.o(152803);
    return localq;
  }
  
  public final void aZe()
  {
    AppMethodBeat.i(152806);
    ek localek = new ek();
    localek.url = this.url;
    localek.fgl = this.fgl;
    localek.scene = this.scene;
    localek.wqc = this.kbN;
    localek.nettype = com.tencent.mm.af.l.LZ();
    if (localek.nettype == 100) {
      localek.nettype = 0;
    }
    localek.session_id = this.kfx;
    localek.wqb = this.kfv;
    Object localObject = this.jXm;
    if (localObject == null) {
      j.ays("msgInfo");
    }
    int j;
    int i;
    if (s.kr(((s)localObject).fgk))
    {
      localek.wqs = 1;
      j = this.kfy;
      if (j != 0) {
        break label318;
      }
      i = 0;
    }
    for (;;)
    {
      localek.wqt = i;
      localObject = as.eu("brandService", 2);
      if (localObject != null)
      {
        localek.wqu = ((as)localObject).aps("BizVideoLastPlayTimestamp");
        localek.wqv = ((as)localObject).aps("BizVideoLastPlayFileSize");
      }
      ab.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d", new Object[] { Integer.valueOf(j), Long.valueOf(localek.wqu), Long.valueOf(localek.wqv) });
      localObject = new com.tencent.mm.ai.b.a();
      ((com.tencent.mm.ai.b.a)localObject).a((a)localek);
      ((com.tencent.mm.ai.b.a)localObject).b((a)new el());
      ((com.tencent.mm.ai.b.a)localObject).rl("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
      ((com.tencent.mm.ai.b.a)localObject).kT(1179);
      ((com.tencent.mm.ai.b.a)localObject).kU(0);
      ((com.tencent.mm.ai.b.a)localObject).kV(0);
      com.tencent.mm.ipcinvoker.wx_extension.b.a(((com.tencent.mm.ai.b.a)localObject).ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new b.a(this));
      AppMethodBeat.o(152806);
      return;
      localek.wqs = 0;
      break;
      label318:
      if (j == 1) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public final void aZf()
  {
    AppMethodBeat.i(152811);
    if (this.ehb != null)
    {
      Object localObject = this.ehb;
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((p)localObject).isShowing());; localObject = null)
      {
        if (localObject == null) {
          j.ebi();
        }
        if (!((Boolean)localObject).booleanValue()) {
          break;
        }
        localObject = this.ehb;
        if (localObject == null) {
          break;
        }
        ((p)localObject).dismiss();
        AppMethodBeat.o(152811);
        return;
      }
    }
    AppMethodBeat.o(152811);
  }
  
  public final boolean aZg()
  {
    return (this.fgk & 0x4) != 0;
  }
  
  public final void ao(int paramInt, String paramString)
  {
    AppMethodBeat.i(152807);
    Object localObject = new em();
    ((em)localObject).url = this.url;
    ((em)localObject).fBA = System.currentTimeMillis();
    ((em)localObject).wqH = paramString;
    ((em)localObject).scene = this.scene;
    ((em)localObject).wqc = this.kbN;
    ((em)localObject).knS = paramInt;
    ((em)localObject).wqa = this.fgh;
    ((em)localObject).session_id = this.kfx;
    ((em)localObject).wqb = this.kfv;
    paramString = new com.tencent.mm.ai.b.a();
    paramString.a((a)localObject);
    paramString.b((a)new en());
    paramString.rl("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
    paramString.kT(2691);
    paramString.kU(0);
    paramString.kV(0);
    com.tencent.mm.ipcinvoker.wx_extension.b.a(paramString.ado(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new b.c(this));
    paramString = this.hkv;
    if (paramString == null) {
      j.ays("ui");
    }
    if (paramString.get() == null)
    {
      paramString = null;
      if (paramString == null) {
        break label329;
      }
    }
    label329:
    for (paramString = paramString.getString(2131301638);; paramString = null)
    {
      localObject = this.hkv;
      if (localObject == null) {
        j.ays("ui");
      }
      if (((WeakReference)localObject).get() == null) {
        break label344;
      }
      localObject = this.hkv;
      if (localObject == null) {
        j.ays("ui");
      }
      localObject = ((WeakReference)localObject).get();
      if (localObject != null) {
        break label334;
      }
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(152807);
      throw paramString;
      paramString = this.hkv;
      if (paramString == null) {
        j.ays("ui");
      }
      paramString = paramString.get();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
        AppMethodBeat.o(152807);
        throw paramString;
      }
      paramString = (TmplShareWebViewToolUI)paramString;
      break;
    }
    label334:
    if (((TmplShareWebViewToolUI)localObject).isFinishing()) {
      label344:
      paramInt = 1;
    }
    while (paramInt == 0)
    {
      aZf();
      if (this.ehb != null)
      {
        localObject = this.ehb;
        if (localObject == null) {
          j.ebi();
        }
        if (!((p)localObject).isShowing())
        {
          paramString = this.ehb;
          if (paramString != null)
          {
            paramString.show();
            AppMethodBeat.o(152807);
            return;
            paramInt = 0;
            continue;
          }
          AppMethodBeat.o(152807);
          return;
        }
      }
      localObject = this.hkv;
      if (localObject == null) {
        j.ays("ui");
      }
      this.ehb = h.b((Context)((WeakReference)localObject).get(), paramString, true, (DialogInterface.OnCancelListener)new b.e(this));
    }
    AppMethodBeat.o(152807);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(152810);
    aZf();
    this.kfr.onDestroy();
    this.hnw = null;
    AppMethodBeat.o(152810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b
 * JD-Core Version:    0.7.0.1
 */