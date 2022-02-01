package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "finderUserName", "", "targetAliasRole", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityRequest;", "getTargetAliasRole", "()I", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends c<bni>
{
  private final int CvK;
  private w.a CvL;
  private bnh CvM;
  private final String TAG;
  
  public w(String paramString, int paramInt, w.a parama)
  {
    AppMethodBeat.i(351161);
    this.CvK = paramInt;
    this.TAG = "Finder.CgiFinderLiveSwitchIdentity";
    this.CvL = parama;
    this.CvM = new bnh();
    this.CvM.YIZ = paramString;
    this.CvM.ZVR = this.CvK;
    paramString = this.CvM;
    parama = bi.ABn;
    paramString.YIY = bi.dVu();
    paramString = new c.a();
    paramString.otE = ((a)this.CvM);
    parama = new bni();
    parama.setBaseResponse(new kd());
    parama.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)parama);
    paramString.uri = "/cgi-bin/micromsg-bin/finderliveswitchidentity";
    paramString.funcId = 4163;
    c(paramString.bEF());
    parama = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("init finder_username:").append(this.CvM.YIZ).append(",target_alias_role:").append(this.CvM.ZVR).append(",live_identity:");
    paramString = this.CvM.YIY;
    if (paramString == null) {}
    for (paramString = null;; paramString = Integer.valueOf(paramString.ZEt))
    {
      Log.i(parama, paramString);
      AppMethodBeat.o(351161);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.w
 * JD-Core Version:    0.7.0.1
 */