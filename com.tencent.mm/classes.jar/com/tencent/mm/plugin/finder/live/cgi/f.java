package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;", "(Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class f
  extends c<ayu>
{
  private final String TAG;
  private a xXW;
  private ayt xXX;
  
  public f(a parama)
  {
    AppMethodBeat.i(285961);
    this.TAG = "Finder.CgiFinderLiveClearAliasRole";
    this.xXW = parama;
    this.xXX = new ayt();
    parama = this.xXX;
    Object localObject = ao.xcj;
    parama.RLM = ao.dnO();
    parama = new d.a();
    parama.c((a)this.xXX);
    localObject = new ayu();
    ((ayu)localObject).setBaseResponse(new jh());
    ((ayu)localObject).getBaseResponse().Tef = new eaf();
    parama.d((a)localObject);
    parama.TW("/cgi-bin/micromsg-bin/finderliveclearaliasrole");
    parama.vD(4020);
    c(parama.bgN());
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init live_identity:");
    parama = this.xXX.RLM;
    if (parama != null) {}
    for (parama = Integer.valueOf(parama.SDv);; parama = null)
    {
      Log.i((String)localObject, parama);
      AppMethodBeat.o(285961);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void MZ(int paramInt);
    
    public abstract void a(ayu paramayu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.f
 * JD-Core Version:    0.7.0.1
 */