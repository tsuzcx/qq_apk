package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductResponse;", "liveId", "", "objectId", "audienceUsername", "", "productId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;", "(JJLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class r
  extends k<awp>
{
  private final String TAG;
  private a ulf;
  private awo ulg;
  
  public r(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246332);
    this.TAG = "Finder.CgiFinderLiveModifyProduct";
    this.ulf = parama;
    this.ulg = new awo();
    this.ulg.liveId = paramLong1;
    this.ulg.hFK = paramLong2;
    this.ulg.finderUsername = paramString;
    this.ulg.uko = paramLong3;
    this.ulg.scene = paramInt;
    paramString = this.ulg;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    paramString = new d.a();
    paramString.c((a)this.ulg);
    parama = new awp();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/finderlivemodshopwindowproduct");
    paramString.sG(6699);
    c(paramString.aXF());
    Log.i(this.TAG, "CgiFinderLiveModifyProduct init " + this.ulg.liveId + ',' + this.ulg.finderUsername);
    AppMethodBeat.o(246332);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyProduct$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopWindowProductResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, awp paramawp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.r
 * JD-Core Version:    0.7.0.1
 */