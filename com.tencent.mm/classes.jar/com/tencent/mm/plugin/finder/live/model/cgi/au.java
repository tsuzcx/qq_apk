package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyResponse;", "liveId", "", "objectId", "scene", "", "verificationId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "(JJILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends o<bng>
{
  public static final b CKD;
  private final a CKE;
  private final bnf CKF;
  
  static
  {
    AppMethodBeat.i(360189);
    CKD = new b((byte)0);
    AppMethodBeat.o(360189);
  }
  
  public au(long paramLong1, long paramLong2, int paramInt, String paramString, a parama)
  {
    AppMethodBeat.i(360181);
    this.CKE = parama;
    this.CKF = new bnf();
    this.CKF.mMJ = paramLong1;
    this.CKF.object_id = paramLong2;
    this.CKF.scene = paramInt;
    this.CKF.ZSt = paramString;
    parama = this.CKF;
    Object localObject = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKF.YIZ = z.bAW();
    parama = new c.a();
    parama.otE = ((a)this.CKF);
    localObject = new bng();
    ((bng)localObject).setBaseResponse(new kd());
    ((bng)localObject).getBaseResponse().akjO = new etl();
    parama.otF = ((a)localObject);
    parama.uri = "/cgi-bin/micromsg-bin/finderlivesuspiciousverify";
    parama.funcId = 5281;
    c(parama.bEF());
    Log.i("Finder.CgiFinderLiveSuspiciousVerify", "init: liveId:" + paramLong1 + ", objectId:" + paramLong2 + ", scene:" + paramInt + ", verification_id:" + paramString);
    AppMethodBeat.o(360181);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSuspiciousVerifyResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bng parambng);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSuspiciousVerify$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.au
 * JD-Core Version:    0.7.0.1
 */