package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "username", "", "apply", "", "getWording", "(Ljava/lang/String;ZZ)V", "getApply", "()Z", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getGetWording", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class av
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneFinderOriginal";
  public static final a rSb;
  private f callback;
  private final boolean rRZ;
  private final boolean rSa;
  private b rr;
  private final String username;
  
  static
  {
    AppMethodBeat.i(201580);
    rSb = new a((byte)0);
    TAG = "Finder.NetSceneFinderOriginal";
    AppMethodBeat.o(201580);
  }
  
  private av(String paramString)
  {
    AppMethodBeat.i(201579);
    this.username = paramString;
    this.rRZ = true;
    this.rSa = false;
    paramString = new b.a();
    paramString.oS(getType());
    Object localObject = new alu();
    ((alu)localObject).sbR = this.username;
    v localv = v.rRb;
    ((alu)localObject).GEg = v.czz();
    if (this.rSa) {
      i = 3;
    }
    for (;;)
    {
      ((alu)localObject).dGO = i;
      paramString.c((a)localObject);
      localObject = new alv();
      ((alv)localObject).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject);
      paramString.DN("/cgi-bin/micromsg-bin/finderapplyoriginal");
      paramString = paramString.aDS();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      ae.i(TAG, "NetSceneFinderOriginal init " + this.rRZ);
      AppMethodBeat.o(201579);
      return;
      if (!this.rRZ) {
        i = 2;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201577);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201577);
    return i;
  }
  
  public final int getType()
  {
    return 3785;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(201578);
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject;
    aj localaj;
    am.a locala;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderApplyOriginalResponse");
        AppMethodBeat.o(201578);
        throw paramString;
      }
      paramq = (alv)paramq;
      if (!this.rSa)
      {
        localObject = paramq.GEh;
        if ((localObject != null) && (bu.lX(((FinderContact)localObject).username, com.tencent.mm.model.v.aAK())))
        {
          paramq = g.ajR();
          p.g(paramq, "MMKernel.storage()");
          paramq.ajA().set(am.a.Jbe, Integer.valueOf(((FinderContact)localObject).originalFlag));
          paramq = g.ajR();
          p.g(paramq, "MMKernel.storage()");
          paramq.ajA().set(am.a.Jbj, Integer.valueOf(((FinderContact)localObject).originalEntranceFlag));
          if (((FinderContact)localObject).originalInfo != null)
          {
            paramq = g.ajR();
            p.g(paramq, "MMKernel.storage()");
            localaj = paramq.ajA();
            locala = am.a.Jbf;
            paramq = ((FinderContact)localObject).originalInfo;
            if (paramq == null) {
              break label521;
            }
            paramq = Integer.valueOf(paramq.GHB);
            localaj.set(locala, paramq);
            paramq = g.ajR();
            p.g(paramq, "MMKernel.storage()");
            localaj = paramq.ajA();
            locala = am.a.Jbg;
            paramq = ((FinderContact)localObject).originalInfo;
            if (paramq == null) {
              break label527;
            }
            paramq = Integer.valueOf(paramq.GHC);
            label301:
            localaj.set(locala, paramq);
            paramq = g.ajR();
            p.g(paramq, "MMKernel.storage()");
            localaj = paramq.ajA();
            locala = am.a.Jbh;
            paramq = ((FinderContact)localObject).originalInfo;
            if (paramq == null) {
              break label533;
            }
            paramq = Integer.valueOf(paramq.GHD);
            label356:
            localaj.set(locala, paramq);
            paramq = g.ajR();
            p.g(paramq, "MMKernel.storage()");
            localaj = paramq.ajA();
            locala = am.a.Jbi;
            paramq = ((FinderContact)localObject).originalInfo;
            if (paramq == null) {
              break label539;
            }
          }
        }
      }
    }
    label521:
    label527:
    label533:
    label539:
    for (paramq = Integer.valueOf(paramq.GHE);; paramq = null)
    {
      localaj.set(locala, paramq);
      paramq = g.ajR();
      p.g(paramq, "MMKernel.storage()");
      localaj = paramq.ajA();
      locala = am.a.Jbl;
      localObject = ((FinderContact)localObject).originalInfo;
      paramq = paramArrayOfByte;
      if (localObject != null) {
        paramq = Integer.valueOf(((aqt)localObject).GHF);
      }
      localaj.set(locala, paramq);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(201578);
      return;
      paramq = null;
      break;
      paramq = null;
      break label301;
      paramq = null;
      break label356;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderOriginal$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */