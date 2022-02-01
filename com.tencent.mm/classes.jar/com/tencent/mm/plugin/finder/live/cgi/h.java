package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;", "(Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends c<bgb>
{
  private a Cvo;
  private bga Cvp;
  private final String TAG;
  
  public h(a parama)
  {
    AppMethodBeat.i(351110);
    this.TAG = "Finder.CgiFinderLiveClearAliasRole";
    this.Cvo = parama;
    this.Cvp = new bga();
    parama = this.Cvp;
    Object localObject = bi.ABn;
    parama.YIY = bi.dVu();
    parama = new c.a();
    parama.otE = ((a)this.Cvp);
    localObject = new bgb();
    ((bgb)localObject).setBaseResponse(new kd());
    ((bgb)localObject).getBaseResponse().akjO = new etl();
    parama.otF = ((a)localObject);
    parama.uri = "/cgi-bin/micromsg-bin/finderliveclearaliasrole";
    parama.funcId = 4020;
    c(parama.bEF());
    localObject = this.TAG;
    parama = this.Cvp.YIY;
    if (parama == null) {}
    for (parama = null;; parama = Integer.valueOf(parama.ZEt))
    {
      Log.i((String)localObject, s.X("init live_identity:", parama));
      AppMethodBeat.o(351110);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Oz(int paramInt);
    
    public abstract void a(bgb parambgb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.h
 * JD-Core Version:    0.7.0.1
 */