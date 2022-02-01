package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.f;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSetProductRecommendWord;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTransferResponse;", "objectId", "", "liveId", "sceneValue", "", "anchorUserName", "", "recomendWord", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetProductRecommendWord;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveSetProductRecommendWord;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getAnchorUserName", "getLiveId", "()J", "getObjectId", "getRecomendWord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveSetProductRecommendWord;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTransferRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTransferRequest;", "setRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTransferRequest;)V", "getSceneValue", "()I", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends o<bnu>
{
  private final int CKA;
  private final bmn CKB;
  private bnt CKC;
  private final String TAG;
  private final long hKN;
  private final long liveId;
  private final String mZs;
  
  public at(long paramLong1, long paramLong2, int paramInt, String paramString, bmn parambmn, bui parambui)
  {
    AppMethodBeat.i(360186);
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.CKA = paramInt;
    this.mZs = paramString;
    this.CKB = parambmn;
    this.TAG = "CgiFinderLiveSetProductRecommendWord";
    this.CKC = new bnt();
    paramString = this.CKC;
    parambmn = bi.ABn;
    paramString.YIY = bi.a(parambui);
    bnt localbnt = this.CKC;
    bns localbns = new bns();
    localbns.object_id = this.hKN;
    localbns.mMJ = this.liveId;
    localbns.scene = this.CKA;
    parambmn = this.mZs;
    paramString = parambmn;
    if (parambmn == null) {
      paramString = "";
    }
    localbns.ZWp = paramString;
    paramString = ah.aiuX;
    localbnt.ZWq = localbns;
    paramString = this.CKC;
    parambmn = aw.Gjk;
    paramString.ZWr = aw.j((a)this.CKB);
    paramString = bi.ABn;
    paramString = this.CKC.YIY;
    if (parambui == null)
    {
      paramInt = 0;
      bi.a(paramString, p.listOf(new r(Integer.valueOf(paramInt), Long.valueOf(this.hKN))));
      paramString = new c.a();
      paramString.otE = ((a)this.CKC);
      parambmn = new bnu();
      parambmn.setBaseResponse(new kd());
      parambmn.getBaseResponse().akjO = new etl();
      paramString.otF = ((a)parambmn);
      paramString.uri = "/cgi-bin/mmbiz-bin/finderlive_set_product_recommend_word";
      paramString.funcId = 10767;
      c(paramString.bEF());
      parambmn = this.TAG;
      paramString = new StringBuilder("init object_id:");
      parambui = this.CKC.ZWq;
      if (parambui != null) {
        break label507;
      }
      paramLong1 = 0L;
      label365:
      parambui = paramString.append(d.hF(paramLong1)).append(",liveId:");
      paramString = this.CKC.ZWq;
      if (paramString != null) {
        break label516;
      }
      paramString = null;
      label398:
      parambui = parambui.append(paramString).append(",scene:");
      paramString = this.CKC.ZWq;
      if (paramString != null) {
        break label529;
      }
      paramString = null;
      label429:
      parambui = parambui.append(paramString).append(",username:");
      paramString = this.CKC.ZWq;
      if (paramString != null) {
        break label542;
      }
    }
    label516:
    label529:
    label542:
    for (paramString = localObject;; paramString = paramString.ZWp)
    {
      Log.i(parambmn, paramString + ',' + f.dg(this.CKB));
      AppMethodBeat.o(360186);
      return;
      paramInt = parambui.hLK;
      break;
      label507:
      paramLong1 = parambui.object_id;
      break label365;
      paramString = Long.valueOf(paramString.mMJ);
      break label398;
      paramString = Integer.valueOf(paramString.scene);
      break label429;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.at
 * JD-Core Version:    0.7.0.1
 */