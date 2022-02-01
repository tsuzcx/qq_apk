package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveDislikeBanner;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveDislikeBannerResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "finderUsername", "", "nonce_id", "dislikeId", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getDislikeId", "()Ljava/lang/String;", "getFeedId", "()J", "getFinderUsername", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveDislikeBannerRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends c<bgn>
{
  private final b Ayh;
  private final String AzL;
  private bgm AzM;
  private final String TAG;
  private final long feedId;
  private final String finderUsername;
  private final long liveId;
  
  public af(long paramLong1, long paramLong2, b paramb, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(336264);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.Ayh = paramb;
    this.finderUsername = paramString1;
    this.AzL = paramString3;
    this.TAG = "Finder.CgiFinderLiveDislikeBanner";
    this.AzM = new bgm();
    paramb = this.AzM;
    paramString1 = bi.ABn;
    paramb.YIY = bi.dVu();
    this.AzM.object_id = this.feedId;
    this.AzM.mMJ = this.liveId;
    this.AzM.YJa = this.Ayh;
    this.AzM.YIZ = this.finderUsername;
    this.AzM.ZQc = this.AzL;
    this.AzM.object_nonce_id = paramString2;
    paramb = new c.a();
    paramb.otE = ((a)this.AzM);
    paramString1 = new bgn();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramb.otF = ((a)paramString1);
    paramb.uri = "/cgi-bin/micromsg-bin/finderlivedislikebanner";
    paramb.funcId = 4268;
    c(paramb.bEF());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", finderUsername:" + this.finderUsername + ", liveCookies size:" + this.Ayh.Op.length + ", dislikeId:" + this.AzL);
    AppMethodBeat.o(336264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */