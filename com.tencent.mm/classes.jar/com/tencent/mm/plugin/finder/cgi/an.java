package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class an
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneFinderOriginal";
  public static final an.a qYx;
  private com.tencent.mm.ak.g callback;
  private final boolean qYv;
  private final boolean qYw;
  private b rr;
  private final String username;
  
  static
  {
    AppMethodBeat.i(201210);
    qYx = new an.a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(201210);
  }
  
  private an(String paramString)
  {
    AppMethodBeat.i(201209);
    this.username = paramString;
    this.qYv = true;
    this.qYw = false;
    paramString = new b.a();
    paramString.op(getType());
    Object localObject = new ais();
    ((ais)localObject).rfC = this.username;
    if (this.qYw) {
      i = 3;
    }
    for (;;)
    {
      ((ais)localObject).dtJ = i;
      paramString.c((a)localObject);
      localObject = new ait();
      ((ait)localObject).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject);
      paramString.Am("/cgi-bin/micromsg-bin/finderapplyoriginal");
      paramString = paramString.aAz();
      d.g.b.k.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ac.i(TAG, "NetSceneFinderOriginal init " + this.qYv);
      AppMethodBeat.o(201209);
      return;
      if (!this.qYv) {
        i = 2;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(201207);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201207);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201208);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(201208);
        throw paramString;
      }
      paramq = (ait)paramq;
      if (!this.qYw)
      {
        paramq = paramq.EDv;
        if ((paramq != null) && (bs.lr(paramq.username, u.axE())))
        {
          paramArrayOfByte = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.agA().set(ah.a.GTY, Integer.valueOf(paramq.originalFlag));
          if (paramq.originalInfo != null)
          {
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GTZ, Integer.valueOf(paramq.originalInfo.EFP));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUa, Integer.valueOf(paramq.originalInfo.EFQ));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUb, Integer.valueOf(paramq.originalInfo.EFR));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUc, Integer.valueOf(paramq.originalInfo.EFS));
            paramArrayOfByte = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.agA().set(ah.a.GUf, Integer.valueOf(paramq.originalInfo.EFT));
          }
        }
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.an
 * JD-Core Version:    0.7.0.1
 */