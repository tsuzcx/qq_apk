package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aq
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  public boolean qYB;
  private com.tencent.mm.ak.b qYo;
  
  public aq(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    aox localaox = new aox();
    localaox.scene = paramInt;
    q localq = q.qXH;
    localaox.EDL = q.csi();
    locala.c((a)localaox);
    locala.d((a)new aoy());
    locala.op(getType());
    locala.Am("/cgi-bin/micromsg-bin/finderuserprepare");
    this.qYo = locala.aAz();
    AppMethodBeat.o(165263);
  }
  
  public final aoy csO()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.qYo;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    localObject = ((com.tencent.mm.ak.b)localObject).aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (aoy)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165260);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.qYo, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165260);
    return i;
  }
  
  public final int getType()
  {
    return 3761;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165262);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(csO().EHN) });
      paramq = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq.agA().set(ah.a.GUi, Integer.valueOf(csO().EHN));
      paramq = csO().EDv;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTQ, paramq.username);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTR, paramq.nickname);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTS, paramq.signature);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTT, paramq.headUrl);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTV, paramq.coverImgUrl);
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GUq, Integer.valueOf(paramq.extFlag));
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GTY, Integer.valueOf(paramq.originalFlag));
        paramArrayOfByte = paramq.originalInfo;
        if (paramArrayOfByte != null)
        {
          com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.agA().set(ah.a.GTZ, Integer.valueOf(paramArrayOfByte.EFP));
          locale = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.agA().set(ah.a.GUa, Integer.valueOf(paramArrayOfByte.EFQ));
          locale = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.agA().set(ah.a.GUb, Integer.valueOf(paramArrayOfByte.EFR));
          locale = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.agA().set(ah.a.GUc, Integer.valueOf(paramArrayOfByte.EFS));
          locale = com.tencent.mm.kernel.g.agR();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.agA().set(ah.a.GUf, Integer.valueOf(paramArrayOfByte.EFT));
        }
        paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qWt;
        com.tencent.mm.plugin.finder.api.b.a.a(paramq);
        if (paramq.authInfo != null) {
          break label610;
        }
        paramq = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramq, "MMKernel.storage()");
        paramq.agA().set(ah.a.GTU, "");
      }
    }
    for (;;)
    {
      paramq = csO().EHP;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GUg, paramq);
      }
      paramq = csO().EHQ;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(ah.a.GUh, paramq);
      }
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165262);
      return;
      label610:
      paramArrayOfByte = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte.agA().set(ah.a.GTU, bs.cx(paramq.authInfo.toByteArray()));
    }
    AppMethodBeat.o(165262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aq
 * JD-Core Version:    0.7.0.1
 */