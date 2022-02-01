package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ax
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  private b rJA;
  public boolean rJR;
  
  public ax(int paramInt)
  {
    AppMethodBeat.i(165263);
    this.TAG = "Finder.NetSceneFinderPrepareUser";
    b.a locala = new b.a();
    aso localaso = new aso();
    localaso.scene = paramInt;
    v localv = v.rIR;
    localaso.Glv = v.cxY();
    locala.c((a)localaso);
    locala.d((a)new asp());
    locala.oP(getType());
    locala.Dl("/cgi-bin/micromsg-bin/finderuserprepare");
    this.rJA = locala.aDC();
    AppMethodBeat.o(165263);
  }
  
  public final asp cyJ()
  {
    AppMethodBeat.i(165261);
    Object localObject = this.rJA;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((b)localObject).aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
      AppMethodBeat.o(165261);
      throw ((Throwable)localObject);
    }
    localObject = (asp)localObject;
    AppMethodBeat.o(165261);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165260);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rJA, (k)this);
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
      ad.i(this.TAG, "userFlag %d", new Object[] { Integer.valueOf(cyJ().GqC) });
      paramq = g.ajC();
      p.g(paramq, "MMKernel.storage()");
      paramq.ajl().set(al.a.IGO, Integer.valueOf(cyJ().GqC));
      paramq = cyJ().Glf;
      if (paramq != null)
      {
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGw, paramq.username);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGx, paramq.nickname);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGy, paramq.signature);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGz, paramq.headUrl);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGB, paramq.coverImgUrl);
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGW, Integer.valueOf(paramq.extFlag));
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGE, Integer.valueOf(paramq.originalFlag));
        paramArrayOfByte = paramq.originalInfo;
        if (paramArrayOfByte != null)
        {
          com.tencent.mm.kernel.e locale = g.ajC();
          p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IGF, Integer.valueOf(paramArrayOfByte.Gok));
          locale = g.ajC();
          p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IGG, Integer.valueOf(paramArrayOfByte.Gol));
          locale = g.ajC();
          p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IGH, Integer.valueOf(paramArrayOfByte.Gom));
          locale = g.ajC();
          p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IGI, Integer.valueOf(paramArrayOfByte.Gon));
          locale = g.ajC();
          p.g(locale, "MMKernel.storage()");
          locale.ajl().set(al.a.IGL, Integer.valueOf(paramArrayOfByte.Goo));
        }
        paramArrayOfByte = c.rHn;
        c.a.a(paramq);
        if (paramq.authInfo != null) {
          break label610;
        }
        paramq = g.ajC();
        p.g(paramq, "MMKernel.storage()");
        paramq.ajl().set(al.a.IGA, "");
      }
    }
    for (;;)
    {
      paramq = cyJ().GqE;
      if (paramq != null)
      {
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGM, paramq);
      }
      paramq = cyJ().GqF;
      if (paramq != null)
      {
        paramArrayOfByte = g.ajC();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajl().set(al.a.IGN, paramq);
      }
      paramq = this.callback;
      if (paramq == null) {
        break;
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(165262);
      return;
      label610:
      paramArrayOfByte = g.ajC();
      p.g(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte.ajl().set(al.a.IGA, bt.cE(paramq.authInfo.toByteArray()));
    }
    AppMethodBeat.o(165262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */