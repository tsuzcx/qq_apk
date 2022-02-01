package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class p
  extends k<awa>
{
  private final String TAG;
  private a ulb;
  private avz ulc;
  
  public p(g paramg, axg paramaxg, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246328);
    this.TAG = "Finder.CgiFinderLiveGetProductDetail";
    this.ulb = parama;
    this.ulc = new avz();
    this.ulc.hyH = paramg.liveInfo.liveId;
    this.ulc.object_id = paramg.hFK;
    this.ulc.object_nonce_id = paramg.hwg;
    this.ulc.LGv = paramaxg.uko;
    this.ulc.LGw = paramg.dPI;
    paramg = this.ulc;
    paramaxg = am.tuw;
    paramg.LAI = am.cXY();
    paramg = new d.a();
    paramg.c((a)this.ulc);
    paramaxg = new awa();
    paramaxg.setBaseResponse(new BaseResponse());
    paramaxg.getBaseResponse().ErrMsg = new dqi();
    paramg.d((a)paramaxg);
    paramg.MB("/cgi-bin/micromsg-bin/finderlivegetshopproductdetail");
    paramg.sG(6211);
    c(paramg.aXF());
    Log.i(this.TAG, "CgiFinderLiveGetProductDetail init " + this.ulc.hyH + ',' + this.ulc.LGv);
    AppMethodBeat.o(246328);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetProductDetail$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopProductDetailResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, awa paramawa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.p
 * JD-Core Version:    0.7.0.1
 */