package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.ac;

public final class j
  extends n
  implements k
{
  private g callback;
  private b gvE;
  private v iAo;
  public w iAp;
  
  public j(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(63391);
    b.a locala = new b.a();
    locala.hvt = new v();
    locala.hvu = new w();
    locala.funcId = 1695;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.iAo = ((v)this.gvE.hvr.hvw);
    this.iAo.DKA = paramString1;
    this.iAo.scene = paramInt1;
    this.iAo.DKB = paramString2;
    if (paramInt1 == 5)
    {
      ac.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
      this.iAo.sign = paramString3;
      this.iAo.ver = paramInt2;
    }
    ac.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
    AppMethodBeat.o(63391);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63393);
    ac.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(63393);
    return i;
  }
  
  public final int getType()
  {
    return 1695;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63392);
    ac.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iAp = ((w)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iAp.dae), this.iAp.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */