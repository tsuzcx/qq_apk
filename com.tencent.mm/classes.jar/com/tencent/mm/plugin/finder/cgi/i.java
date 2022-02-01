package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderCreateGameLivePrepare;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateGameLivePrepareResponse;", "cover_img", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "desc", "", "ticket", "appid", "scene", "", "join_team_up_setting", "(Lcom/tencent/mm/protocal/protobuf/FinderMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "TAG", "getAppid", "()Ljava/lang/String;", "getCover_img", "()Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getDesc", "getJoin_team_up_setting", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateGameLivePrepareRequest;", "getScene", "getTicket", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class i
  extends c<arn>
{
  private final String TAG;
  private final String appid;
  private final String desc;
  private final String fAo;
  private final int scene;
  private final int xaA;
  private arm xay;
  private final FinderMedia xaz;
  
  public i(FinderMedia paramFinderMedia, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(290313);
    this.xaz = paramFinderMedia;
    this.desc = paramString1;
    this.fAo = paramString2;
    this.appid = paramString3;
    this.scene = paramInt1;
    this.xaA = paramInt2;
    this.TAG = "Finder.CgiFinderCreateGameLivePrepare";
    this.xay = new arm();
    paramFinderMedia = this.xay;
    paramString1 = ao.xcj;
    paramFinderMedia.RLM = ao.dnO();
    this.xay.RLN = z.bdh();
    this.xay.xaz = this.xaz;
    this.xay.description = this.desc;
    this.xay.SEx = this.fAo;
    this.xay.app_id = this.appid;
    this.xay.scene = this.scene;
    this.xay.xaA = this.xaA;
    paramFinderMedia = new d.a();
    paramFinderMedia.c((a)this.xay);
    paramString1 = new arn();
    paramString1.setBaseResponse(new jh());
    paramString1.getBaseResponse().Tef = new eaf();
    paramFinderMedia.d((a)paramString1);
    paramFinderMedia.TW("/cgi-bin/micromsg-bin/findercreategameliveprepare");
    paramFinderMedia.vD(6434);
    c(paramFinderMedia.bgN());
    Log.i(this.TAG, "init join_team_up_setting:" + this.xaA);
    AppMethodBeat.o(290313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.i
 * JD-Core Version:    0.7.0.1
 */