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
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ay
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private b rRO;
  public boolean rSf;
  
  public ay(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    b.a locala = new b.a();
    ate localate = new ate();
    localate.scene = paramInt;
    v localv = v.rRb;
    localate.GDR = v.czz();
    locala.c((a)localate);
    locala.d((a)new atf());
    locala.oS(getType());
    locala.DN("/cgi-bin/micromsg-bin/finderuserprepare");
    this.rRO = locala.aDS();
    AppMethodBeat.o(165263);
  }
  
  public final atf cAk()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.rRO;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((b)localObject).aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (atf)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165260);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rRO, (k)this);
    AppMethodBeat.o(165260);
    return i;
  }
  
  public final int getType()
  {
    return 3761;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165262);
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(cAk().GKa) });
      paramq = g.ajR();
      p.g(paramq, "MMKernel.storage()");
      paramq.ajA().set(am.a.Jbp, Integer.valueOf(cAk().GKa));
      paramq = cAk().GEh;
      if (paramq != null)
      {
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaW, paramq.username);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaX, paramq.nickname);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaY, paramq.signature);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JaZ, paramq.headUrl);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jbb, paramq.coverImgUrl);
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jbx, Integer.valueOf(paramq.extFlag));
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jbe, Integer.valueOf(paramq.originalFlag));
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jbj, Integer.valueOf(paramq.originalEntranceFlag));
        paramArrayOfByte = paramq.originalInfo;
        if (paramArrayOfByte != null)
        {
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbf, Integer.valueOf(paramArrayOfByte.GHB));
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbg, Integer.valueOf(paramArrayOfByte.GHC));
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbh, Integer.valueOf(paramArrayOfByte.GHD));
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbi, Integer.valueOf(paramArrayOfByte.GHE));
          localObject = g.ajR();
          p.g(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jbl, Integer.valueOf(paramArrayOfByte.GHF));
        }
        paramArrayOfByte = c.rPy;
        p.g(paramq, "it");
        c.a.a(paramq);
        if (paramq.authInfo != null) {
          break label649;
        }
        paramq = g.ajR();
        p.g(paramq, "MMKernel.storage()");
        paramq.ajA().set(am.a.Jba, "");
      }
      paramq = cAk().GKc;
      if (paramq != null)
      {
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jbm, paramq);
      }
      paramq = cAk().GKd;
      if (paramq != null)
      {
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jbn, paramq);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165262);
      return;
      label649:
      paramArrayOfByte = g.ajR();
      p.g(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte = paramArrayOfByte.ajA();
      localObject = am.a.Jba;
      paramq = paramq.authInfo;
      if (paramq != null) {}
      for (paramq = paramq.toByteArray();; paramq = null)
      {
        paramArrayOfByte.set((am.a)localObject, bu.cH(paramq));
        break;
      }
    }
    AppMethodBeat.o(165262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ay
 * JD-Core Version:    0.7.0.1
 */