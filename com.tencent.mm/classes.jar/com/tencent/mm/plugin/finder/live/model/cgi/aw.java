package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveTopComment;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "opType", "", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;I)V", "TAG", "", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getMsg", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "setMsg", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;)V", "getOpType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTopCommentRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends o<bnr>
{
  private bke CIc;
  private bnq CKI;
  private com.tencent.mm.plugin.finder.live.model.context.a CvU;
  private final String TAG;
  private final int opType;
  
  public aw(com.tencent.mm.plugin.finder.live.model.context.a parama, bke parambke, int paramInt)
  {
    AppMethodBeat.i(360218);
    this.CvU = parama;
    this.CIc = parambke;
    this.opType = paramInt;
    this.TAG = "Finder.CgiFinderLiveTopComment";
    this.CKI = new bnq();
    parama = this.CKI;
    parambke = bi.ABn;
    parama.ZEc = bi.dVu();
    this.CKI.liveId = ((f)this.CvU.business(f.class)).liveInfo.liveId;
    this.CKI.hKN = ((f)this.CvU.business(f.class)).hKN;
    this.CKI.kLn = (this.CIc.kLn + '_' + cn.getSyncServerTimeSecond() + '_' + ((e)this.CvU.business(e.class)).CFc);
    this.CKI.Ayh = com.tencent.mm.bx.b.cX(((f)this.CvU.business(f.class)).mZp);
    this.CKI.seq = this.CIc.seq;
    this.CKI.hYl = this.opType;
    this.CKI.ZPX = d.FK(((f)this.CvU.business(f.class)).nonceId);
    this.CKI.finderUsername = z.bAW();
    this.CKI.mdD = ((f)this.CvU.business(f.class)).nonceId;
    ((e)this.CvU.business(e.class)).EdZ.add(this.CKI.kLn);
    parama = new c.a();
    parama.otE = ((com.tencent.mm.bx.a)this.CKI);
    parambke = new bnr();
    parambke.setBaseResponse(new kd());
    parama.otF = ((com.tencent.mm.bx.a)parambke);
    parama.uri = "/cgi-bin/micromsg-bin/finderlivetopcomment";
    parama.funcId = 6295;
    c(parama.bEF());
    Log.i(this.TAG, "CgiFinderLiveTopComment init " + this.CKI.liveId + ',' + z.bAW() + ',' + this.CIc.content + " opType:" + this.CKI.hYl);
    AppMethodBeat.o(360218);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aw
 * JD-Core Version:    0.7.0.1
 */