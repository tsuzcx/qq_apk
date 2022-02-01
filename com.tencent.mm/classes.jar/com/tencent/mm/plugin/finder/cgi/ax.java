package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ax
  extends n
  implements com.tencent.mm.network.k
{
  public static final a KJR;
  private static final String TAG = "Finder.NetSceneFinderOriginal";
  private final boolean KJP;
  private final boolean KJQ;
  private com.tencent.mm.al.g callback;
  private b rr;
  private final String username;
  
  static
  {
    AppMethodBeat.i(197332);
    KJR = new a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(197332);
  }
  
  private ax(String paramString)
  {
    AppMethodBeat.i(197331);
    this.username = paramString;
    this.KJP = true;
    this.KJQ = false;
    paramString = new b.a();
    paramString.nB(getType());
    Object localObject = new dyc();
    ((dyc)localObject).finderUsername = this.username;
    if (this.KJQ) {
      i = 3;
    }
    for (;;)
    {
      ((dyc)localObject).dvW = i;
      paramString.c((a)localObject);
      localObject = new dyd();
      ((dyd)localObject).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject);
      paramString.wg("/cgi-bin/micromsg-bin/finderapplyoriginal");
      paramString = paramString.atI();
      d.g.b.k.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ad.i(TAG, "NetSceneFinderOriginal init " + this.KJP);
      AppMethodBeat.o(197331);
      return;
      if (!this.KJP) {
        i = 2;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(197329);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197329);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197330);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(197330);
        throw paramString;
      }
      paramq = (dyd)paramq;
      if (!this.KJQ)
      {
        paramq = paramq.DmQ;
        if ((paramq != null) && (bt.kU(paramq.username, u.aqO())))
        {
          paramArrayOfByte = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.afk().set(ae.a.Fwe, Integer.valueOf(paramq.originalFlag));
          if (paramq.originalInfo != null)
          {
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwf, Integer.valueOf(paramq.originalInfo.LxV));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwg, Integer.valueOf(paramq.originalInfo.LxW));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwh, Integer.valueOf(paramq.originalInfo.LxX));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.Fwi, Integer.valueOf(paramq.originalInfo.LxY));
            paramArrayOfByte = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.afk().set(ae.a.LAK, Integer.valueOf(paramq.originalInfo.LxZ));
          }
        }
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197330);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */