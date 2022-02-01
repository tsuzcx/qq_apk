package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPostBoxMsg;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class eg
  extends c<bsq>
{
  private bsp CvP;
  private final String TAG;
  
  public eg(bdm parambdm, com.tencent.mm.plugin.finder.live.model.context.a parama, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(370696);
    this.TAG = "Finder.CgiFinderPostBoxMsg";
    this.CvP = new bsp();
    this.CvP.YJa = b.cX(((f)((e)parama.business(e.class)).business(f.class)).mZp);
    this.CvP.CER = parambdm;
    this.CvP.mMJ = ((f)parama.business(f.class)).liveInfo.liveId;
    this.CvP.object_id = ((f)parama.business(f.class)).hKN;
    this.CvP.object_nonce_id = ((f)parama.business(f.class)).nonceId;
    parambdm = this.CvP;
    Object localObject2 = l.k.mYO;
    parambdm.scene = l.k.bhH();
    this.CvP.YIZ = z.bAW();
    parambdm = this.CvP;
    localObject2 = bi.ABn;
    parambdm.ZEc = bi.dVu();
    parambdm = bi.ABn;
    parambdm = this.CvP.ZEc;
    int i;
    if (parambui == null)
    {
      i = 0;
      bi.a(parambdm, p.listOf(new r(Integer.valueOf(i), Long.valueOf(((f)parama.business(f.class)).hKN))));
      parambdm = this.CvP.ZEc;
      if (parambdm != null) {
        parambdm.ZEt = 1;
      }
      parambdm = new c.a();
      parambdm.otE = ((com.tencent.mm.bx.a)this.CvP);
      parama = new bsq();
      parama.setBaseResponse(new kd());
      parama.getBaseResponse().akjO = new etl();
      parambdm.otF = ((com.tencent.mm.bx.a)parama);
      parambdm.uri = "/cgi-bin/micromsg-bin/finderpostliveappmsg";
      parambdm.funcId = 6888;
      c(parambdm.bEF());
      parama = this.TAG;
      parambui = new StringBuilder("CgiFinderPostBoxMsg init ").append(this.CvP.mMJ).append(",msgType ");
      parambdm = this.CvP.CER;
      if (parambdm != null) {
        break label434;
      }
      parambdm = null;
      label380:
      parambui = parambui.append(parambdm).append(", client_msg_id:");
      parambdm = this.CvP.CER;
      if (parambdm != null) {
        break label445;
      }
    }
    label434:
    label445:
    for (parambdm = localObject1;; parambdm = parambdm.Tro)
    {
      Log.i(parama, parambdm);
      AppMethodBeat.o(370696);
      return;
      i = parambui.hLK;
      break;
      parambdm = Integer.valueOf(parambdm.msg_type);
      break label380;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.eg
 * JD-Core Version:    0.7.0.1
 */