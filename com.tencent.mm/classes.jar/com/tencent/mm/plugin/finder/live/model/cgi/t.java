package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "liveId", "", "objectId", "audienceUsername", "", "productId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "(JJLjava/lang/String;JILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class t
  extends k<aww>
{
  private final String TAG;
  private a ull;
  private awv ulm;
  
  public t(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246338);
    this.TAG = "Finder.CgiFinderLivePromoteProduct";
    this.ull = parama;
    this.ulm = new awv();
    this.ulm.liveId = paramLong1;
    this.ulm.hFK = paramLong2;
    this.ulm.finderUsername = paramString;
    this.ulm.uko = paramLong3;
    this.ulm.scene = paramInt;
    paramString = this.ulm;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    paramString = new d.a();
    paramString.c((a)this.ulm);
    parama = new aww();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/finderlivepromoteproduct");
    paramString.sG(5800);
    c(paramString.aXF());
    Log.i(this.TAG, "CgiFinderLivePromoteProduct init " + this.ulm.liveId + ',' + this.ulm.finderUsername);
    AppMethodBeat.o(246338);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePromoteProduct$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteProductResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aww paramaww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.t
 * JD-Core Version:    0.7.0.1
 */