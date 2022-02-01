package com.tencent.mm.plugin.aa.model.cgi;

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
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private f callback;
  private b gPp;
  private v iTy;
  public w iTz;
  
  public j(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(63391);
    b.a locala = new b.a();
    locala.hNM = new v();
    locala.hNN = new w();
    locala.funcId = 1695;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.iTy = ((v)this.gPp.hNK.hNQ);
    this.iTy.FpG = paramString1;
    this.iTy.scene = paramInt1;
    this.iTy.FpH = paramString2;
    if (paramInt1 == 5)
    {
      ad.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
      this.iTy.sign = paramString3;
      this.iTy.ver = paramInt2;
    }
    ad.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2 });
    AppMethodBeat.o(63391);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63393);
    ad.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iTz = ((w)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iTz.dlw), this.iTz.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */