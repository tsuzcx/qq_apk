package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReceiveCoupon;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;", "liveId", "", "objectId", "anchorUsername", "", "finderUsername", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "stockIds", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReceiveCoupon$CallBack;", "(JJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReceiveCoupon$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends o<blp>
{
  private a CKn;
  private blo CKo;
  private final String TAG;
  
  public ao(long paramLong1, long paramLong2, String paramString1, String paramString2, b paramb, LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(360184);
    this.TAG = "Finder.CgiFinderLiveReceiveCoupon";
    this.CKn = parama;
    this.CKo = new blo();
    parama = this.CKo;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKo.mMJ = paramLong1;
    this.CKo.object_id = paramLong2;
    this.CKo.ZKq = paramString1;
    this.CKo.YIZ = paramString2;
    this.CKo.YJa = paramb;
    this.CKo.ZUF = paramLinkedList;
    this.CKo.request_id = UUID.randomUUID().toString();
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CKo);
    paramString2 = new blp();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivereceivecoupon";
    paramString1.funcId = 6219;
    c(paramString1.bEF());
    Log.i(this.TAG, s.X("init ", Long.valueOf(this.CKo.mMJ)));
    AppMethodBeat.o(360184);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReceiveCoupon$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, blp paramblp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ao
 * JD-Core Version:    0.7.0.1
 */