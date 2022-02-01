package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.t;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUser", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class y
  extends w
{
  private static final String TAG = "Finder.NetSceneFinderFollow";
  private static final int qXU = 1;
  private static final int qXV = 2;
  public static final y.a qXW;
  private g callback;
  private final long dig;
  public final int opType;
  public final String qXT;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(165213);
    qXW = new y.a((byte)0);
    TAG = "Finder.NetSceneFinderFollow";
    qXU = 1;
    qXV = 2;
    AppMethodBeat.o(165213);
  }
  
  public y(String paramString, int paramInt, anm paramanm, long paramLong)
  {
    super(paramanm);
    AppMethodBeat.i(201164);
    this.qXT = paramString;
    this.opType = paramInt;
    this.dig = paramLong;
    paramString = new com.tencent.mm.ak.b.a();
    paramString.op(getType());
    Object localObject1 = new akb();
    ((akb)localObject1).EEg = this.qXT;
    ((akb)localObject1).opType = this.opType;
    ((akb)localObject1).refObjectId = this.dig;
    Object localObject2 = q.qXH;
    ((akb)localObject1).EDL = q.a(paramanm);
    ((akb)localObject1).EDL.scene = paramanm.seo;
    localObject2 = d.rxr;
    ((akb)localObject1).sessionBuffer = d.G(this.dig, ((akb)localObject1).EDL.scene);
    ((akb)localObject1).urD = paramanm.sep;
    paramString.c((a)localObject1);
    localObject1 = new akc();
    ((akc)localObject1).setBaseResponse(new BaseResponse());
    paramString.d((a)localObject1);
    paramString.Am("/cgi-bin/micromsg-bin/finderfollow");
    paramString = paramString.aAz();
    d.g.b.k.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    ac.i(TAG, "NetSceneFinderFollow init " + this.qXT + " opType " + this.opType + " scene " + paramanm.seo + " feedId " + this.dig);
    AppMethodBeat.o(201164);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(165210);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165210);
    return i;
  }
  
  public final int getType()
  {
    return 3867;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(165211);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED)) {
        t.makeText(ai.getContext(), (CharSequence)("is debug info finderfollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165211);
      return;
    }
    paramq = com.tencent.mm.plugin.finder.api.b.qWt;
    paramq = this.qXT;
    if (this.opType == qXU) {}
    for (;;)
    {
      com.tencent.mm.plugin.finder.api.b.a.a(paramq, bool, (d.g.a.b)b.qXX);
      break;
      bool = false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, d.y>
  {
    public static final b qXX;
    
    static
    {
      AppMethodBeat.i(165209);
      qXX = new b();
      AppMethodBeat.o(165209);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */