package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  public int dlw;
  private com.tencent.mm.al.b gPp;
  public String paA;
  private ail vlm;
  private aim vln;
  
  public b(String paramString)
  {
    AppMethodBeat.i(65038);
    Object localObject = new b.a();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).hNM = new ail();
    ((b.a)localObject).hNN = new aim();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
    this.gPp = ((b.a)localObject).aDC();
    this.vlm = ((ail)this.gPp.hNK.hNQ);
    localObject = com.tencent.mm.plugin.wallet_core.model.k.eFo();
    if (localObject != null)
    {
      this.vlm.latitude = ((bb)localObject).latitude;
      this.vlm.longitude = ((bb)localObject).longitude;
    }
    this.vlm.GfQ = paramString;
    AppMethodBeat.o(65038);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65039);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(65039);
    return i;
  }
  
  public final int getType()
  {
    return 1971;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65040);
    ad.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.vln = ((aim)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    this.dlw = this.vln.dlw;
    this.paA = this.vln.paA;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.vln.dlw, this.vln.paA, this);
    }
    AppMethodBeat.o(65040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.b
 * JD-Core Version:    0.7.0.1
 */