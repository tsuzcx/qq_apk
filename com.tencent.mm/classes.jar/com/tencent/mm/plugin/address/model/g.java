package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(20783);
    b.a locala = new b.a();
    locala.hNM = new cqw();
    locala.hNN = new cqx();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
    locala.funcId = 419;
    locala.hNO = 204;
    locala.respCmdId = 1000000204;
    this.rr = locala.aDC();
    ((cqw)this.rr.hNK.hNQ).id = paramInt;
    AppMethodBeat.o(20783);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20785);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20785);
    return i;
  }
  
  public final int getType()
  {
    return 419;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20784);
    ad.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cqx)((b)paramq).hNL.hNQ;
      if (paramq.Hje.Hjh != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Hje.Hjh.size());
        a.aUR();
        a.aUT().t(paramq.Hje.Hjh);
        a.aUR();
        a.aUT().aUV();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.g
 * JD-Core Version:    0.7.0.1
 */