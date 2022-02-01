package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b rr;
  
  public c(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20771);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cqm();
    ((b.a)localObject).hNN = new cqn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((b.a)localObject).funcId = 415;
    ((b.a)localObject).hNO = 200;
    ((b.a)localObject).respCmdId = 1000000200;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cqm)this.rr.hNK.hNQ;
    ((cqm)localObject).Hjd = new cqr();
    ((cqm)localObject).Hjd.Hjk = new cwt().aPy(bt.bI(paramb.jsb, ""));
    ((cqm)localObject).Hjd.Hji = new cwt().aPy(bt.bI(paramb.jrZ, ""));
    ((cqm)localObject).Hjd.Hjn = new cwt().aPy(bt.bI(paramb.jse, ""));
    ((cqm)localObject).Hjd.Hjl = new cwt().aPy(bt.bI(paramb.jsc, ""));
    ((cqm)localObject).Hjd.Hjo = new cwt().aPy(bt.bI(paramb.jsf, ""));
    ((cqm)localObject).Hjd.Hjp = new cwt().aPy(bt.bI(paramb.jsg, ""));
    ((cqm)localObject).Hjd.Hjj = new cwt().aPy(bt.bI(paramb.jsa, ""));
    ((cqm)localObject).Hjd.Hjm = new cwt().aPy(bt.bI(paramb.jsd, ""));
    ((cqm)localObject).Hjd.Hjq = new cwt().aPy(bt.bI(paramb.jsh, ""));
    AppMethodBeat.o(20771);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20773);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20773);
    return i;
  }
  
  public final int getType()
  {
    return 415;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20772);
    ad.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cqn)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      if (paramq.Hje.Hjh != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Hje.Hjh.size());
        a.aUR();
        a.aUT().t(paramq.Hje.Hjh);
        a.aUR();
        a.aUT().aUV();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */