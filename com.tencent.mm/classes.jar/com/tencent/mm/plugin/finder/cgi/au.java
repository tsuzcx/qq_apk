package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class au
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderOriginal";
  public static final a rJN;
  private f callback;
  private final boolean rJL;
  private final boolean rJM;
  private b rr;
  private final String username;
  
  static
  {
    AppMethodBeat.i(201158);
    rJN = new a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(201158);
  }
  
  private au(String paramString)
  {
    AppMethodBeat.i(201157);
    this.username = paramString;
    this.rJL = true;
    this.rJM = false;
    paramString = new b.a();
    paramString.oP(getType());
    Object localObject = new ali();
    ((ali)localObject).rTn = this.username;
    v localv = v.rIR;
    ((ali)localObject).Gle = v.cxY();
    if (this.rJM) {
      i = 3;
    }
    for (;;)
    {
      ((ali)localObject).dFJ = i;
      paramString.c((a)localObject);
      localObject = new alj();
      ((alj)localObject).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject);
      paramString.Dl("/cgi-bin/micromsg-bin/finderapplyoriginal");
      paramString = paramString.aDC();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ad.i(TAG, "NetSceneFinderOriginal init " + this.rJL);
      AppMethodBeat.o(201157);
      return;
      if (!this.rJL) {
        i = 2;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201155);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201155);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201156);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(201156);
        throw paramString;
      }
      paramq = (alj)paramq;
      if (!this.rJM)
      {
        paramq = paramq.Glf;
        if ((paramq != null) && (bt.lQ(paramq.username, u.aAu())))
        {
          paramArrayOfByte = g.ajC();
          p.g(paramArrayOfByte, "MMKernel.storage()");
          paramArrayOfByte.ajl().set(al.a.IGE, Integer.valueOf(paramq.originalFlag));
          if (paramq.originalInfo != null)
          {
            paramArrayOfByte = g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGF, Integer.valueOf(paramq.originalInfo.Gok));
            paramArrayOfByte = g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGG, Integer.valueOf(paramq.originalInfo.Gol));
            paramArrayOfByte = g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGH, Integer.valueOf(paramq.originalInfo.Gom));
            paramArrayOfByte = g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGI, Integer.valueOf(paramq.originalInfo.Gon));
            paramArrayOfByte = g.ajC();
            p.g(paramArrayOfByte, "MMKernel.storage()");
            paramArrayOfByte.ajl().set(al.a.IGL, Integer.valueOf(paramq.originalInfo.Goo));
          }
        }
      }
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201156);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */