package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUser", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class n
  extends ap
{
  private static final String TAG = "Finder.NetSceneFinderFollow";
  private static final int qpe = 1;
  private static final int qpf = 2;
  public static final a qpg;
  private g callback;
  private final long feedId;
  public final int opType;
  public final String qpd;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(165213);
    qpg = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollow";
    qpe = 1;
    qpf = 2;
    AppMethodBeat.o(165213);
  }
  
  public n(String paramString, int paramInt, dzp paramdzp, long paramLong)
  {
    super(paramdzp);
    AppMethodBeat.i(197287);
    this.qpd = paramString;
    this.opType = paramInt;
    this.feedId = paramLong;
    paramString = new com.tencent.mm.al.b.a();
    paramString.nB(getType());
    Object localObject1 = new aip();
    ((aip)localObject1).DkK = this.qpd;
    ((aip)localObject1).opType = this.opType;
    ((aip)localObject1).refObjectId = this.feedId;
    Object localObject2 = am.KJy;
    ((aip)localObject1).Dkw = am.a(paramdzp);
    ((aip)localObject1).Dkw.scene = paramdzp.LiL;
    localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
    ((aip)localObject1).sessionBuffer = com.tencent.mm.plugin.finder.report.b.am(this.feedId, ((aip)localObject1).Dkw.scene);
    ((aip)localObject1).tjk = paramdzp.LiM;
    paramString.c((a)localObject1);
    localObject1 = new aiq();
    ((aiq)localObject1).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject1);
    paramString.wg("/cgi-bin/micromsg-bin/finderfollow");
    paramString = paramString.atI();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(TAG, "NetSceneFinderFollow init " + this.qpd + " opType " + this.opType + " scene " + paramdzp.LiL + " feedId " + this.feedId);
    AppMethodBeat.o(197287);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165210);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165210);
    return i;
  }
  
  public final int getType()
  {
    return 3867;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(165211);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED)) {
        t.makeText(aj.getContext(), (CharSequence)("is debug info finderfollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fvU();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      }
      AppMethodBeat.o(165211);
      return;
    }
    paramq = com.tencent.mm.plugin.finder.api.b.qnX;
    paramq = this.qpd;
    if (this.opType == qpe) {}
    for (;;)
    {
      com.tencent.mm.plugin.finder.api.b.a.a(paramq, bool, (d.g.a.b)n.b.qph);
      break;
      bool = false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */