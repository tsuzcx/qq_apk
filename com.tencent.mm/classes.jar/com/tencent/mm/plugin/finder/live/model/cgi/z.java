package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "productId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;JLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class z
  extends n<azw>
{
  private final String TAG;
  private a yjG;
  private azv yjH;
  
  public z(com.tencent.mm.plugin.finder.live.model.context.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(291706);
    this.TAG = "Finder.CgiFinderLiveGetProductDetail";
    this.yjG = parama1;
    this.yjH = new azv();
    this.yjH.klE = ((c)parama.business(c.class)).liveInfo.liveId;
    this.yjH.object_id = ((c)parama.business(c.class)).xbk;
    this.yjH.object_nonce_id = ((c)parama.business(c.class)).nonceId;
    this.yjH.zaO = paramLong;
    this.yjH.SLt = ((b)parama.business(b.class)).fIY;
    parama = this.yjH;
    parama1 = ao.xcj;
    parama.SDi = ao.dnO();
    parama = new d.a();
    parama.c((com.tencent.mm.cd.a)this.yjH);
    parama1 = new azw();
    parama1.setBaseResponse(new jh());
    parama1.getBaseResponse().Tef = new eaf();
    parama.d((com.tencent.mm.cd.a)parama1);
    parama.TW("/cgi-bin/micromsg-bin/finderlivegetshopproductdetail");
    parama.vD(6211);
    c(parama.bgN());
    Log.i(this.TAG, "CgiFinderLiveGetProductDetail init " + this.yjH.klE + ',' + this.yjH.zaO + ',' + this.yjH.SLt);
    AppMethodBeat.o(291706);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, azw paramazw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.z
 * JD-Core Version:    0.7.0.1
 */