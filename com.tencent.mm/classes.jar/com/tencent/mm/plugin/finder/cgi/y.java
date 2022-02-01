package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class y
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b qpm;
  public boolean qpv;
  
  public y(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    alu localalu = new alu();
    localalu.scene = paramInt;
    am localam = am.KJy;
    localalu.Dkw = am.fRS();
    locala.c((a)localalu);
    locala.d((a)new alv());
    locala.nB(getType());
    locala.wg("/cgi-bin/micromsg-bin/finderuserprepare");
    this.qpm = locala.atI();
    AppMethodBeat.o(165263);
  }
  
  public final alv ckV()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.qpm;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    localObject = ((com.tencent.mm.al.b)localObject).auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (alv)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165260);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.qpm, (com.tencent.mm.network.k)this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ad.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(ckV().DmR) });
      paramq = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq.afk().set(ae.a.Fwn, Integer.valueOf(ckV().DmR));
      paramq = ckV().DmQ;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvW, paramq.username);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvX, paramq.nickname);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvY, paramq.signature);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.FvZ, paramq.headUrl);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.Fwb, paramq.coverImgUrl);
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.Fwo, Integer.valueOf(paramq.extFlag));
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.Fwe, Integer.valueOf(paramq.originalFlag));
        paramArrayOfByte = paramq.originalInfo;
        if (paramArrayOfByte != null)
        {
          com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.afk().set(ae.a.Fwf, Integer.valueOf(paramArrayOfByte.LxV));
          locale = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.afk().set(ae.a.Fwg, Integer.valueOf(paramArrayOfByte.LxW));
          locale = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.afk().set(ae.a.Fwh, Integer.valueOf(paramArrayOfByte.LxX));
          locale = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.afk().set(ae.a.Fwi, Integer.valueOf(paramArrayOfByte.LxY));
          locale = com.tencent.mm.kernel.g.afB();
          d.g.b.k.g(locale, "MMKernel.storage()");
          locale.afk().set(ae.a.LAK, Integer.valueOf(paramArrayOfByte.LxZ));
        }
        paramArrayOfByte = com.tencent.mm.plugin.finder.api.b.qnX;
        com.tencent.mm.plugin.finder.api.b.a.a(paramq);
        if (paramq.authInfo != null) {
          break label610;
        }
        paramq = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramq, "MMKernel.storage()");
        paramq.afk().set(ae.a.Fwa, "");
      }
    }
    for (;;)
    {
      paramq = ckV().DmT;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.Fwl, paramq);
      }
      paramq = ckV().DmU;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.Fwm, paramq);
      }
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165262);
      return;
      label610:
      paramArrayOfByte = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte.afk().set(ae.a.Fwa, bt.cy(paramq.authInfo.toByteArray()));
    }
    AppMethodBeat.o(165262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */