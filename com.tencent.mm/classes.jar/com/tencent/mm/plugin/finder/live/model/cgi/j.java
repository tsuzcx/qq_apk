package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.d.a.a.a.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.glp;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGameLivePlaygameSetTeamupConfig;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameSetTeamupConfigResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "jo", "Lorg/json/JSONObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callback", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "(JJLcom/tencent/mm/protobuf/ByteString;Lorg/json/JSONObject;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;)V", "TAG", "", "getCallback", "()Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "getFeedId", "()J", "getJo", "()Lorg/json/JSONObject;", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGameSetTeamupConfigRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportGameLiveSetting", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c<bhe>
{
  private final b Ayh;
  private final JSONObject CJe;
  private final b.e CJf;
  private final bhd CJg;
  private final String TAG;
  private final long feedId;
  private final long liveId;
  
  public j(long paramLong1, long paramLong2, b paramb, JSONObject paramJSONObject, b.e parame)
  {
    super(null);
    AppMethodBeat.i(360333);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.Ayh = paramb;
    this.CJe = paramJSONObject;
    this.CJf = parame;
    this.TAG = "Finder.GameLive.CgiFinderGameLivePlaygameSetTeamupConfig";
    this.CJg = new bhd();
    paramb = this.CJg;
    paramJSONObject = bi.ABn;
    paramb.YIY = bi.dVu();
    this.CJg.object_id = this.feedId;
    this.CJg.mMJ = this.liveId;
    this.CJg.YJa = this.Ayh;
    this.CJg.YIZ = z.bAW();
    paramb = this.CJg;
    paramJSONObject = l.k.mYO;
    paramb.scene = l.k.bhG();
    paramb = this.CJg;
    paramJSONObject = new cbu();
    paramJSONObject.ZTO = 1;
    paramJSONObject.Jfv = this.CJe.optInt("join_team_mode");
    parame = new glp();
    parame.title = this.CJe.optString("title");
    parame.Jfw = this.CJe.optString("teamup_desc");
    parame.Jfx = this.CJe.optString("member_desc");
    parame.Jfy = this.CJe.optString("teamup_extra_data");
    Object localObject = new aya();
    ((aya)localObject).appid = this.CJe.optString("appid");
    ((aya)localObject).version = this.CJe.optInt("versionType");
    ((aya)localObject).path = this.CJe.optString("path");
    ah localah = ah.aiuX;
    parame.achj = ((aya)localObject);
    localObject = ah.aiuX;
    paramJSONObject.aald = parame;
    parame = ah.aiuX;
    paramb.ZQC = paramJSONObject;
    paramb = new bhe();
    paramJSONObject = new c.a();
    paramJSONObject.otE = ((a)this.CJg);
    paramJSONObject.otF = ((a)paramb);
    paramJSONObject.uri = "/cgi-bin/micromsg-bin/finderlivegamesetteamupconfig";
    paramJSONObject.funcId = 6917;
    c(paramJSONObject.bEF());
    paramb = new JSONObject();
    paramb.put("appid", this.CJe.optString("appid"));
    paramb.put("type", 2);
    paramb.put("gametype", 1);
    paramb.put("sourceid", this.CJe.optString("sourceid"));
    paramb.put("teamupsetting", this.CJe.optString("join_team_mode"));
    com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.DrV, paramb.toString());
    AppMethodBeat.o(360333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */