package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "role", "", "nonceId", "sessionBuffer", "shareUserName", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "joinType", "joinLiveTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "seiData", "ecSource", "live_identity", "uniqueId", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "(J[BLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "getUniqueId", "()Ljava/lang/String;", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "saveFuncSwitchFlag", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends o<bca>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private bbz CJk;
  private final String TAG;
  public final String hTs;
  
  private m(long paramLong1, byte[] paramArrayOfByte, String paramString1, long paramLong2, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, bui parambui, int paramInt3, bcb parambcb, String paramString5, String paramString6, int paramInt4, String paramString7, bma parambma)
  {
    super(parambui);
    AppMethodBeat.i(360330);
    this.hTs = paramString7;
    this.TAG = "Finder.CgiFinderJoinLive";
    this.CJk = new bbz();
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    paramString7 = this.CJk;
    bi localbi = bi.ABn;
    paramString7.ZEc = bi.a(parambui);
    if (paramInt4 > 0)
    {
      paramString7 = this.CJk.ZEc;
      if (paramString7 != null) {
        paramString7.ZEt = paramInt4;
      }
    }
    this.CJk.liveId = paramLong1;
    this.CJk.Ayh = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJk.finderUsername = paramString1;
    this.CJk.hKN = paramLong2;
    this.CJk.ZEj = paramLong2;
    this.CJk.scene = paramInt1;
    this.CJk.object_nonce_id = paramString2;
    this.CJk.ZJK = paramString3;
    this.CJk.ZMJ = paramInt3;
    this.CJk.ZMK = paramString4;
    this.CJk.iaK = paramInt2;
    this.CJk.ZML = parambcb;
    this.CJk.ZIR = parambma;
    label259:
    label296:
    label461:
    boolean bool;
    if (paramString5 != null)
    {
      this.CJk.ZJJ = com.tencent.mm.bx.b.bsj(paramString5);
      paramString2 = this.CJk;
      if (paramString6 != null) {
        break label870;
      }
      paramArrayOfByte = "";
      paramString2.Edn = paramArrayOfByte;
      paramArrayOfByte = this.CJk;
      paramString2 = aw.Gjk;
      paramArrayOfByte.ZKH = aw.fgv();
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramArrayOfByte != null) {
        break label876;
      }
      paramArrayOfByte = null;
      if (paramArrayOfByte != null)
      {
        paramString2 = paramString6;
        if (paramString6 == null) {
          paramString2 = "";
        }
        paramArrayOfByte.Edo = paramString2;
      }
      this.ABH.put("liveId", paramLong1);
      this.ABH.put("finderUsername", paramString1);
      this.ABH.put("objectId", paramLong2);
      this.ABH.put("scene", paramInt1);
      this.ABH.put("joinType", paramInt3);
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = (f)paramArrayOfByte.business(f.class);
        if (paramArrayOfByte != null)
        {
          paramString1 = this.ABH;
          s.u(paramString1, "json");
          paramString1.put("_cLiveId", paramArrayOfByte.hKN);
          paramString1.put("_liveInfo", paramArrayOfByte.mIU);
        }
      }
      paramArrayOfByte = bi.ABn;
      paramArrayOfByte = this.CJk.ZEc;
      if (parambui != null) {
        break label889;
      }
      paramInt2 = 0;
      bi.a(paramArrayOfByte, p.listOf(new r(Integer.valueOf(paramInt2), Long.valueOf(paramLong2))));
      if (paramInt1 == 2)
      {
        paramArrayOfByte = d.Pmb;
        d.asyncReportFinderSecurityInfoThroughCgi(540999693);
      }
      paramString1 = this.TAG;
      paramString2 = new StringBuilder("living context: ");
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (paramArrayOfByte != null) {
        break label899;
      }
      paramArrayOfByte = null;
      label533:
      paramString2 = paramString2.append(paramArrayOfByte).append(", uniqueId:").append(this.hTs).append(",speed=");
      paramArrayOfByte = this.CJk;
      if (paramArrayOfByte != null) {
        break label926;
      }
      paramArrayOfByte = null;
      label571:
      Log.i(paramString1, paramArrayOfByte);
      paramArrayOfByte = new c.a();
      paramArrayOfByte.otE = ((com.tencent.mm.bx.a)this.CJk);
      paramString1 = new bca();
      paramString1.setBaseResponse(new kd());
      paramString1.getBaseResponse().akjO = new etl();
      paramArrayOfByte.otF = ((com.tencent.mm.bx.a)paramString1);
      paramArrayOfByte.uri = "/cgi-bin/micromsg-bin/finderjoinlive";
      paramArrayOfByte.funcId = 3539;
      c(paramArrayOfByte.bEF());
      paramString1 = this.TAG;
      paramArrayOfByte = new StringBuilder("CgiFinderJoinLive init ").append(this.CJk.liveId).append(',').append(this.CJk.finderUsername).append(',').append(this.CJk.scene).append(",liveCookies is null:");
      if (this.CJk.Ayh != null) {
        break label965;
      }
      bool = true;
      label748:
      paramString2 = paramArrayOfByte.append(bool).append(", sessionBuffer:").append(this.CJk.ZJK).append(", joinType:").append(this.CJk.ZMJ).append(" contextId:");
      paramArrayOfByte = this.CJk.ZEc;
      if (paramArrayOfByte != null) {
        break label971;
      }
      paramArrayOfByte = null;
    }
    for (;;)
    {
      Log.i(paramString1, paramArrayOfByte + " ecSource:" + this.CJk.Edn + " uniqueId:" + this.hTs);
      AppMethodBeat.o(360330);
      return;
      Log.e(this.TAG, "ljd live sei is empty");
      break;
      label870:
      paramArrayOfByte = paramString6;
      break label259;
      label876:
      paramArrayOfByte = (e)paramArrayOfByte.business(e.class);
      break label296;
      label889:
      paramInt2 = parambui.AJo;
      break label461;
      label899:
      paramArrayOfByte = (f)paramArrayOfByte.business(f.class);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = null;
        break label533;
      }
      paramArrayOfByte = paramArrayOfByte.info();
      break label533;
      label926:
      paramArrayOfByte = paramArrayOfByte.ZKH;
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = null;
        break label571;
      }
      paramArrayOfByte = paramArrayOfByte.ZPF;
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = null;
        break label571;
      }
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.ZPE);
      break label571;
      label965:
      bool = false;
      break label748;
      label971:
      paramArrayOfByte = paramArrayOfByte.ZEs;
      if (paramArrayOfByte == null) {
        paramArrayOfByte = null;
      } else {
        paramArrayOfByte = paramArrayOfByte.zIO;
      }
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.m
 * JD-Core Version:    0.7.0.1
 */