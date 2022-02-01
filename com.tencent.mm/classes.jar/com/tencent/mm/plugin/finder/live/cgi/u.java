package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "nickname", "", "url", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends c<bmp>
{
  private a CvG;
  private bmo CvH;
  private final String TAG;
  
  public u(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(351145);
    this.TAG = "Finder.CgiFinderLiveSetSockPuppetAttr";
    this.CvG = parama;
    this.CvH = new bmo();
    this.CvH.nickname = paramString1;
    this.CvH.xkY = paramString2;
    paramString1 = this.CvH;
    paramString2 = bi.ABn;
    paramString1.YIY = bi.dVu();
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CvH);
    paramString2 = new bmp();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivesetsockpuppetattr";
    paramString1.funcId = 6816;
    c(paramString1.bEF());
    paramString2 = this.TAG;
    parama = new StringBuilder("init nickname:").append(this.CvH.nickname).append(",url:").append(this.CvH.xkY).append(",live_identity:");
    paramString1 = this.CvH.YIY;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.ZEt))
    {
      Log.i(paramString2, paramString1);
      AppMethodBeat.o(351145);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(bmp parambmp);
    
    public abstract void bu(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.u
 * JD-Core Version:    0.7.0.1
 */