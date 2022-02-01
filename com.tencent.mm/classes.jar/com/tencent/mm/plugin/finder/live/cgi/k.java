package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "nickname", "", "url", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class k
  extends c<bcn>
{
  private final String TAG;
  private a xYd;
  private bcm xYe;
  
  public k(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(273625);
    this.TAG = "Finder.CgiFinderLiveSetSockPuppetAttr";
    this.xYd = parama;
    this.xYe = new bcm();
    this.xYe.nickname = paramString1;
    this.xYe.ueX = paramString2;
    paramString1 = this.xYe;
    paramString2 = ao.xcj;
    paramString1.RLM = ao.dnO();
    paramString1 = new d.a();
    paramString1.c((a)this.xYe);
    paramString2 = new bcn();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderlivesetsockpuppetattr");
    paramString1.vD(6816);
    c(paramString1.bgN());
    paramString2 = this.TAG;
    parama = new StringBuilder("init nickname:").append(this.xYe.nickname).append(",url:").append(this.xYe.ueX).append(",live_identity:");
    paramString1 = this.xYe.RLM;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.SDv);; paramString1 = null)
    {
      Log.i(paramString2, paramString1);
      AppMethodBeat.o(273625);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(bcn parambcn);
    
    public abstract void aY(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.k
 * JD-Core Version:    0.7.0.1
 */