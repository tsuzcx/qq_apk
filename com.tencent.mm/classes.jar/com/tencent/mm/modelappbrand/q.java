package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ih.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class q
  extends com.tencent.mm.plugin.websearch.api.a
  implements k
{
  private f eGj;
  private final com.tencent.mm.ai.b fpW;
  private cvy fpX;
  private s fpY;
  
  public q(s params)
  {
    AppMethodBeat.i(93736);
    this.fpY = params;
    this.uIB = params.cCT;
    this.uIC = params.cnv;
    this.Fb = params.offset;
    this.mScene = params.scene;
    this.uID = params.uIV;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cvx();
    ((b.a)localObject).fsY = new cvy();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fpW = ((b.a)localObject).ado();
    localObject = (cvx)this.fpW.fsV.fta;
    azu localazu = acv();
    ((cvx)localObject).jKs = params.businessType;
    ((cvx)localObject).xba = params.cnv;
    ((cvx)localObject).wzS = params.offset;
    ((cvx)localObject).wBZ = params.low;
    ((cvx)localObject).xpG = params.uIK;
    ih localih = new ih();
    com.tencent.mm.sdk.b.a.ymk.l(localih);
    ((cvx)localObject).xpF = localih.cxG.cxH;
    if (localazu != null)
    {
      ((cvx)localObject).xpH = localazu.wDh;
      ((cvx)localObject).xpI = localazu.wDi;
    }
    ((cvx)localObject).xpJ = b.fpQ;
    ((cvx)localObject).yeo = params.uIG;
    ((cvx)localObject).yep = params.uIL;
    ((cvx)localObject).yeq = params.uIM;
    ((cvx)localObject).yem = b.fpR;
    ((cvx)localObject).xCa = params.mRU;
    ab.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", new Object[] { ((cvx)localObject).xpJ, ((cvx)localObject).yem, Double.valueOf(((cvx)localObject).xpH), Double.valueOf(((cvx)localObject).xpI) });
    AppMethodBeat.o(93736);
  }
  
  private static azu acv()
  {
    AppMethodBeat.i(93739);
    try
    {
      Object localObject = (String)g.RL().Ru().get(67591, null);
      if (localObject != null)
      {
        azu localazu = new azu();
        localObject = ((String)localObject).split(",");
        localazu.wSk = Integer.valueOf(localObject[0]).intValue();
        localazu.wSn = Integer.valueOf(localObject[1]).intValue();
        localazu.wDi = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localazu.wDh = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ab.i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localazu.wDi), Float.valueOf(localazu.wDh) });
        AppMethodBeat.o(93739);
        return localazu;
      }
      ab.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(93739);
      return null;
    }
    catch (Exception localException)
    {
      ab.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93739);
    }
    return null;
  }
  
  public final String act()
  {
    if (this.fpX != null) {
      return this.fpX.wAa;
    }
    return "";
  }
  
  public final int acu()
  {
    if (this.fpX != null) {
      return this.fpX.xpM;
    }
    return 0;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(93738);
    ab.i("MicroMsg.NetSceneWeAppSearch", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.fpW, this);
    AppMethodBeat.o(93738);
    return i;
  }
  
  public final int getType()
  {
    return 1162;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93737);
    ab.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fpX = ((cvy)this.fpW.fsW.fta);
    if (this.fpX != null) {
      ab.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", new Object[] { this.fpX.wAa });
    }
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(93737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */