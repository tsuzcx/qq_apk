package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "liveId", "", "objectId", "audienceUsername", "", "productId", "promoteType", "", "adId", "scene", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "(JJLjava/lang/String;JIJILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class af
  extends n<bbn>
{
  private final String TAG;
  private a yjT;
  private bbm yjU;
  
  public af(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt1, long paramLong4, int paramInt2, a parama)
  {
    AppMethodBeat.i(288335);
    this.TAG = "Finder.CgiFinderLivePromoteProduct";
    this.yjT = parama;
    this.yjU = new bbm();
    this.yjU.liveId = paramLong1;
    this.yjU.xbk = paramLong2;
    this.yjU.finderUsername = paramString;
    this.yjU.yiz = paramLong3;
    this.yjU.scene = paramInt2;
    this.yjU.SNi = paramInt1;
    this.yjU.zaI = paramLong4;
    paramString = this.yjU;
    parama = ao.xcj;
    paramString.SDi = ao.dnO();
    paramString = new d.a();
    paramString.c((a)this.yjU);
    parama = new bbn();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivepromoteproduct");
    paramString.vD(5800);
    c(paramString.bgN());
    Log.i(this.TAG, "CgiFinderLivePromoteProduct init " + this.yjU.liveId + ',' + this.yjU.finderUsername + ",productId:" + this.yjU.yiz + ",ad_id:" + this.yjU.zaI + ",promoteType:" + this.yjU.SNi + ",scene:" + this.yjU.scene);
    AppMethodBeat.o(288335);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bbn parambbn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.af
 * JD-Core Version:    0.7.0.1
 */