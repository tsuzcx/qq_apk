package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentResponse;", "liveId", "", "objectId", "audienceUsername", "", "scene", "", "enable", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;", "(JJLjava/lang/String;IZLcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderBanLiveCommentRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends c<atv>
{
  private a Cvm;
  private atu Cvn;
  private final String TAG;
  
  public g(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(351117);
    this.TAG = "Finder.CgiFinderLiveBanComment";
    this.Cvm = parama;
    this.Cvn = new atu();
    this.Cvn.liveId = paramLong1;
    this.Cvn.hKN = paramLong2;
    this.Cvn.ZEm = paramString;
    this.Cvn.scene = 2;
    this.Cvn.enable = paramBoolean;
    paramString = this.Cvn;
    parama = bi.ABn;
    paramString.ZEc = bi.dVu();
    paramString = new c.a();
    paramString.otE = ((a)this.Cvn);
    parama = new atv();
    parama.setBaseResponse(new kd());
    parama.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)parama);
    paramString.uri = "/cgi-bin/micromsg-bin/finderbanlivecomment";
    paramString.funcId = 6656;
    c(paramString.bEF());
    Log.i(this.TAG, "CgiFinderLiveBanComment init " + this.Cvn.liveId + ',' + this.Cvn.ZEm);
    AppMethodBeat.o(351117);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void qo(boolean paramBoolean);
    
    public abstract void w(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.g
 * JD-Core Version:    0.7.0.1
 */