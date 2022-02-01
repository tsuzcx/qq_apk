package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusResponse;", "liveId", "", "objectId", "status", "", "finderUserName", "", "liveStatus", "micFlag", "gameTeamMode", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "(JJILjava/lang/String;IJILcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;)V", "TAG", "anchorStatus", "micSettingFlag", "request", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class d
  extends c<biz>
{
  private final String TAG;
  private int anchorStatus;
  private a xXR;
  private biy xXS;
  private long xXT;
  
  public d(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, long paramLong3, int paramInt3, a parama)
  {
    AppMethodBeat.i(282261);
    this.TAG = "Finder.CgiFinderLiveAnchorStatus";
    this.xXR = parama;
    this.xXS = new biy();
    this.anchorStatus = paramInt1;
    this.xXT = paramLong3;
    this.xXS.liveId = paramLong1;
    this.xXS.xbk = paramLong2;
    this.xXS.finderUsername = paramString;
    paramString = this.xXS;
    parama = ao.xcj;
    paramString.SDi = ao.dnO();
    this.xXS.liveStatus = paramInt2;
    paramString = new crm();
    paramString.Tyz = paramInt1;
    paramString.Tyy = cm.bfD();
    parama = new cxh();
    parama.TFP = this.xXT;
    paramString.SEm = parama;
    parama = new bnp();
    parama.SYJ = paramInt3;
    paramString.TyA = parama;
    this.xXS.SLc = b.cU(paramString.toByteArray());
    paramString = new com.tencent.mm.an.d.a();
    paramString.c((a)this.xXS);
    parama = new biz();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/findersetanchorstatus");
    paramString.vD(6443);
    c(paramString.bgN());
    Log.i(this.TAG, "init " + this.xXS.liveId + ',' + this.xXS.finderUsername + ',' + this.anchorStatus + ',' + this.xXT);
    AppMethodBeat.o(282261);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void ai(int paramInt, long paramLong);
    
    public abstract void b(int paramInt1, int paramInt2, String paramString, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.d
 * JD-Core Version:    0.7.0.1
 */