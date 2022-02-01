package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentResponse;", "liveId", "", "objectId", "audienceUsername", "", "scene", "", "enable", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;", "(JJLjava/lang/String;IZLcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class t
  extends an<aou>
{
  private final String TAG;
  private a ttv;
  private aot ttw;
  
  public t(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(242243);
    this.TAG = "Finder.CgiFinderLiveBanComment";
    this.ttv = parama;
    this.ttw = new aot();
    this.ttw.liveId = paramLong1;
    this.ttw.hFK = paramLong2;
    this.ttw.LAP = paramString;
    this.ttw.scene = 2;
    this.ttw.enable = paramBoolean;
    paramString = this.ttw;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    paramString = new d.a();
    paramString.c((a)this.ttw);
    parama = new aou();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/finderbanlivecomment");
    paramString.sG(6656);
    c(paramString.aXF());
    Log.i(this.TAG, "CgiFinderLiveBanComment init " + this.ttw.liveId + ',' + this.ttw.LAP);
    AppMethodBeat.o(242243);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveBanComment$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void mO(boolean paramBoolean);
    
    public abstract void t(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */