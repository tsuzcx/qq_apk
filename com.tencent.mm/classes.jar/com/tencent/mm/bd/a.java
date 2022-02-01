package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public String hpO;
  public String hpP;
  public byte[] hpQ;
  private final b rr;
  
  public a()
  {
    this(u.aqG(), bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(66561, null)), 0);
    AppMethodBeat.i(150870);
    AppMethodBeat.o(150870);
  }
  
  public a(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150871);
    this.callback = null;
    this.hpO = null;
    this.hpP = null;
    this.hpQ = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ayy();
    ((b.a)localObject).gUV = new ayz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).funcId = 168;
    ((b.a)localObject).reqCmdId = 67;
    ((b.a)localObject).respCmdId = 1000000067;
    this.rr = ((b.a)localObject).atI();
    localObject = (ayy)this.rr.gUS.gUX;
    ((ayy)localObject).Dby = z.BE(paramString);
    ((ayy)localObject).Dxp = paramInt1;
    ((ayy)localObject).OpCode = paramInt2;
    ad.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150871);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150872);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150872);
    return i;
  }
  
  public final int getType()
  {
    return 168;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150873);
    ad.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (ayy)this.rr.gUS.gUX;
      paramq = (ayz)this.rr.gUT.gUX;
      paramArrayOfByte = z.a(paramArrayOfByte.Dby);
      this.hpQ = z.a(paramq.Dxq, new byte[0]);
      this.hpO = paramq.Dxr;
      ad.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.hpO, paramq.Dxs, paramq.Dxt });
      if (u.aqG().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramq.Dxs;
        String str = (String)com.tencent.mm.kernel.g.afB().afk().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          com.tencent.mm.kernel.g.afB().afk().set(66563, paramArrayOfByte);
          this.hpP = paramq.Dxt;
        }
        com.tencent.mm.kernel.g.afB().afk().set(66561, Integer.valueOf(paramq.Dxp));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.a
 * JD-Core Version:    0.7.0.1
 */