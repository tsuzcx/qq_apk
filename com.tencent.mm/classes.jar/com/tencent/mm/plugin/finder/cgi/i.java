package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderCreateGameLivePrepare;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateGameLivePrepareResponse;", "cover_img", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "desc", "", "ticket", "appid", "scene", "", "join_team_up_setting", "team_up_payment_setting", "Lcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;", "fast_comment_list", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShortcutWordingInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderMedia;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;Lcom/tencent/mm/protocal/protobuf/FinderLiveShortcutWordingInfo;)V", "TAG", "getAppid", "()Ljava/lang/String;", "getCover_img", "()Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "getDesc", "getFast_comment_list", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShortcutWordingInfo;", "getJoin_team_up_setting", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateGameLivePrepareRequest;", "getScene", "getTeam_up_payment_setting", "()Lcom/tencent/mm/protocal/protobuf/GameTeamUpPaymentSetting;", "getTicket", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c<avw>
{
  private final FinderMedia AyC;
  private final int AyD;
  private final cca AyE;
  private final bmw AyF;
  private avv AyG;
  private final String TAG;
  private final String appid;
  private final String desc;
  private final String hFb;
  private final int scene;
  
  public i(FinderMedia paramFinderMedia, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, cca paramcca, bmw parambmw)
  {
    super(null);
    AppMethodBeat.i(336343);
    this.AyC = paramFinderMedia;
    this.desc = paramString1;
    this.hFb = paramString2;
    this.appid = paramString3;
    this.scene = paramInt1;
    this.AyD = paramInt2;
    this.AyE = paramcca;
    this.AyF = parambmw;
    this.TAG = "Finder.CgiFinderCreateGameLivePrepare";
    this.AyG = new avv();
    paramFinderMedia = this.AyG;
    paramString1 = bi.ABn;
    paramFinderMedia.YIY = bi.dVu();
    this.AyG.YIZ = z.bAW();
    this.AyG.AyC = this.AyC;
    this.AyG.description = this.desc;
    this.AyG.ZFX = this.hFb;
    this.AyG.app_id = this.appid;
    this.AyG.scene = this.scene;
    this.AyG.AyD = this.AyD;
    this.AyG.ZGd = this.AyE;
    paramFinderMedia = this.AyG;
    paramString1 = new bqc();
    paramString1.ZYd = this.AyF;
    paramString2 = ah.aiuX;
    paramFinderMedia.ZGe = paramString1;
    paramFinderMedia = new c.a();
    paramFinderMedia.otE = ((a)this.AyG);
    paramString1 = new avw();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramFinderMedia.otF = ((a)paramString1);
    paramFinderMedia.uri = "/cgi-bin/micromsg-bin/findercreategameliveprepare";
    paramFinderMedia.funcId = 6434;
    c(paramFinderMedia.bEF());
    paramString1 = this.TAG;
    paramString2 = new StringBuilder("init join_team_up_setting:").append(this.AyD).append(' ');
    paramFinderMedia = this.AyE;
    if (paramFinderMedia == null)
    {
      paramFinderMedia = null;
      paramString2 = paramString2.append(paramFinderMedia).append(' ');
      paramFinderMedia = this.AyE;
      if (paramFinderMedia != null) {
        break label405;
      }
    }
    label405:
    for (paramFinderMedia = localObject;; paramFinderMedia = Integer.valueOf(paramFinderMedia.aalp))
    {
      Log.i(paramString1, paramFinderMedia);
      AppMethodBeat.o(336343);
      return;
      paramFinderMedia = Integer.valueOf(paramFinderMedia.aalq);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.i
 * JD-Core Version:    0.7.0.1
 */