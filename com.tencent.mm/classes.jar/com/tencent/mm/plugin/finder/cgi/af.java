package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUser", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class af
  extends ad
{
  private static final String TAG = "Finder.NetSceneFinderFollow";
  private static final int rRs = 1;
  private static final int rRt = 2;
  private static final int rRu = 3;
  public static final a rRv;
  private f callback;
  private final long duw;
  public final int opType;
  public final String rRr;
  private b rr;
  
  static
  {
    AppMethodBeat.i(165213);
    rRv = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollow";
    rRs = 1;
    rRt = 2;
    rRu = 3;
    AppMethodBeat.o(165213);
  }
  
  public af(String paramString, int paramInt, arn paramarn, long paramLong)
  {
    super(paramarn);
    AppMethodBeat.i(201529);
    this.rRr = paramString;
    this.opType = paramInt;
    this.duw = paramLong;
    paramString = new b.a();
    paramString.oS(getType());
    Object localObject1 = new anm();
    ((anm)localObject1).GEX = this.rRr;
    ((anm)localObject1).opType = this.opType;
    ((anm)localObject1).refObjectId = this.duw;
    Object localObject2 = v.rRb;
    ((anm)localObject1).GDR = v.a(paramarn);
    localObject2 = ((anm)localObject1).GDR;
    if (localObject2 != null) {
      ((alw)localObject2).scene = paramarn.tnf;
    }
    localObject2 = i.syT;
    paramLong = this.duw;
    localObject2 = ((anm)localObject1).GDR;
    if (localObject2 != null) {}
    for (paramInt = ((alw)localObject2).scene;; paramInt = 0)
    {
      ((anm)localObject1).sessionBuffer = i.I(paramLong, paramInt);
      ((anm)localObject1).vGk = paramarn.tng;
      paramString.c((a)localObject1);
      localObject1 = new ann();
      ((ann)localObject1).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject1);
      paramString.DN("/cgi-bin/micromsg-bin/finderfollow");
      paramString = paramString.aDS();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ae.i(TAG, "NetSceneFinderFollow init " + this.rRr + " opType " + this.opType + " scene " + paramarn.tnf + " feedId " + this.duw + " enterType" + paramarn.tng);
      AppMethodBeat.o(201529);
      return;
    }
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
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED)) {
        t.makeText(ak.getContext(), (CharSequence)("is debug info finderfollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165211);
      return;
    }
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderFollowResponse");
      AppMethodBeat.o(165211);
      throw paramString;
    }
    paramArrayOfByte = ((ann)paramq).contact;
    if (paramArrayOfByte != null)
    {
      ae.i(TAG, "newContact.followFlag: " + paramArrayOfByte.followFlag);
      paramq = c.rPy;
      paramq = this.rRr;
      paramInt1 = paramArrayOfByte.followFlag;
    }
    for (;;)
    {
      c.a.dn(paramq, paramInt1);
      break;
      paramq = c.rPy;
      paramq = this.rRr;
      if (this.opType == rRs)
      {
        paramArrayOfByte = g.rPM;
        paramInt1 = g.czt();
      }
      else
      {
        paramArrayOfByte = g.rPM;
        paramInt1 = g.czu();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */