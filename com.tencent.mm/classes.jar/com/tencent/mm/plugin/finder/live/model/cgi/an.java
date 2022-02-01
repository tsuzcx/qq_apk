package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "liveId", "", "objectId", "audienceUsername", "", "productId", "promoteType", "", "adId", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "(JJLjava/lang/String;JIJILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends o<blc>
{
  private a CKl;
  private blb CKm;
  private final String TAG;
  
  public an(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt1, long paramLong4, int paramInt2, bui parambui, a parama)
  {
    AppMethodBeat.i(360277);
    this.TAG = "Finder.CgiFinderLivePromoteProduct";
    this.CKl = parama;
    this.CKm = new blb();
    this.CKm.liveId = paramLong1;
    this.CKm.hKN = paramLong2;
    this.CKm.finderUsername = paramString;
    this.CKm.Azu = paramLong3;
    this.CKm.scene = paramInt2;
    this.CKm.ZNM = paramInt1;
    this.CKm.DUP = paramLong4;
    paramString = this.CKm;
    parama = bi.ABn;
    paramString.ZEc = bi.dVu();
    paramString = bi.ABn;
    paramString = this.CKm.ZEc;
    if (parambui == null) {}
    for (paramInt1 = 0;; paramInt1 = parambui.AJo)
    {
      bi.a(paramString, p.listOf(new r(Integer.valueOf(paramInt1), Long.valueOf(paramLong2))));
      paramString = new c.a();
      paramString.otE = ((a)this.CKm);
      parambui = new blc();
      parambui.setBaseResponse(new kd());
      parambui.getBaseResponse().akjO = new etl();
      paramString.otF = ((a)parambui);
      paramString.uri = "/cgi-bin/micromsg-bin/finderlivepromoteproduct";
      paramString.funcId = 5800;
      c(paramString.bEF());
      Log.i(this.TAG, "CgiFinderLivePromoteProduct init " + this.CKm.liveId + ',' + this.CKm.finderUsername + ",productId:" + this.CKm.Azu + ",ad_id:" + this.CKm.DUP + ",promoteType:" + this.CKm.ZNM + ",scene:" + this.CKm.scene);
      AppMethodBeat.o(360277);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, blc paramblc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.an
 * JD-Core Version:    0.7.0.1
 */