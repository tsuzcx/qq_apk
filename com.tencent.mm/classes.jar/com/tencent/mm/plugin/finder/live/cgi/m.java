package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "finderUserName", "", "targetAliasRole", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityRequest;", "getTargetAliasRole", "()I", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class m
  extends c<bcy>
{
  private final String TAG;
  private a xYh;
  private bcx xYi;
  private final int xYj;
  
  public m(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(284918);
    this.xYj = paramInt;
    this.TAG = "Finder.CgiFinderLiveSwitchIdentity";
    this.xYh = parama;
    this.xYi = new bcx();
    this.xYi.RLN = paramString;
    this.xYi.SNZ = this.xYj;
    paramString = this.xYi;
    parama = ao.xcj;
    paramString.RLM = ao.dnO();
    paramString = new d.a();
    paramString.c((a)this.xYi);
    parama = new bcy();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/finderliveswitchidentity");
    paramString.vD(4163);
    c(paramString.bgN());
    parama = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init finder_username:").append(this.xYi.RLN).append(",target_alias_role:").append(this.xYi.SNZ).append(",live_identity:");
    paramString = this.xYi.RLM;
    if (paramString != null) {}
    for (paramString = Integer.valueOf(paramString.SDv);; paramString = null)
    {
      Log.i(parama, paramString);
      AppMethodBeat.o(284918);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(bcy parambcy);
    
    public abstract void aBO(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.m
 * JD-Core Version:    0.7.0.1
 */