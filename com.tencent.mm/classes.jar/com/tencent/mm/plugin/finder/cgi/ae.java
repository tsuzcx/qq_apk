package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUser", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ae
  extends ac
{
  private static final String TAG = "Finder.NetSceneFinderFollow";
  private static final int rJe = 1;
  private static final int rJf = 2;
  private static final int rJg = 3;
  public static final a rJh;
  private f callback;
  private final long dtq;
  public final int opType;
  public final String rJd;
  private b rr;
  
  static
  {
    AppMethodBeat.i(165213);
    rJh = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollow";
    rJe = 1;
    rJf = 2;
    rJg = 3;
    AppMethodBeat.o(165213);
  }
  
  public ae(String paramString, int paramInt, aqy paramaqy, long paramLong)
  {
    super(paramaqy);
    AppMethodBeat.i(201107);
    this.rJd = paramString;
    this.opType = paramInt;
    this.dtq = paramLong;
    paramString = new b.a();
    paramString.oP(getType());
    Object localObject1 = new amz();
    ((amz)localObject1).GlV = this.rJd;
    ((amz)localObject1).opType = this.opType;
    ((amz)localObject1).refObjectId = this.dtq;
    Object localObject2 = v.rIR;
    ((amz)localObject1).Glv = v.a(paramaqy);
    ((amz)localObject1).Glv.scene = paramaqy.tcl;
    localObject2 = h.soM;
    ((amz)localObject1).sessionBuffer = h.I(this.dtq, ((amz)localObject1).Glv.scene);
    ((amz)localObject1).vug = paramaqy.tcm;
    paramString.c((a)localObject1);
    localObject1 = new ana();
    ((ana)localObject1).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject1);
    paramString.Dl("/cgi-bin/micromsg-bin/finderfollow");
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ad.i(TAG, "NetSceneFinderFollow init " + this.rJd + " opType " + this.opType + " scene " + paramaqy.tcl + " feedId " + this.dtq);
    AppMethodBeat.o(201107);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(165210);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165210);
    return i;
  }
  
  public final int getType()
  {
    return 3867;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165211);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED)) {
        t.makeText(aj.getContext(), (CharSequence)("is debug info finderfollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165211);
      return;
    }
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderFollowResponse");
      AppMethodBeat.o(165211);
      throw paramString;
    }
    paramArrayOfByte = ((ana)paramq).contact;
    if (paramArrayOfByte != null)
    {
      ad.i(TAG, "newContact.followFlag: " + paramArrayOfByte.followFlag);
      paramq = c.rHn;
      paramq = this.rJd;
      paramInt1 = paramArrayOfByte.followFlag;
    }
    for (;;)
    {
      c.a.dj(paramq, paramInt1);
      break;
      paramq = c.rHn;
      paramq = this.rJd;
      if (this.opType == rJe)
      {
        paramArrayOfByte = g.rHB;
        paramInt1 = g.cxS();
      }
      else
      {
        paramArrayOfByte = g.rHB;
        paramInt1 = g.cxT();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ae
 * JD-Core Version:    0.7.0.1
 */