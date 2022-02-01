package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentResponse;", "liveId", "", "objectId", "audienceUsername", "", "scene", "", "enable", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;", "(JJLjava/lang/String;IZLcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class e
  extends c<aqb>
{
  private final String TAG;
  private a xXU;
  private aqa xXV;
  
  public e(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(274911);
    this.TAG = "Finder.CgiFinderLiveBanComment";
    this.xXU = parama;
    this.xXV = new aqa();
    this.xXV.liveId = paramLong1;
    this.xXV.xbk = paramLong2;
    this.xXV.SDo = paramString;
    this.xXV.scene = 2;
    this.xXV.enable = paramBoolean;
    paramString = this.xXV;
    parama = ao.xcj;
    paramString.SDi = ao.dnO();
    paramString = new d.a();
    paramString.c((a)this.xXV);
    parama = new aqb();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/finderbanlivecomment");
    paramString.vD(6656);
    c(paramString.bgN());
    Log.i(this.TAG, "CgiFinderLiveBanComment init " + this.xXV.liveId + ',' + this.xXV.SDo);
    AppMethodBeat.o(274911);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void oE(boolean paramBoolean);
    
    public abstract void w(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.e
 * JD-Core Version:    0.7.0.1
 */