package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class a
  extends n
  implements k
{
  private f callback;
  public String imx;
  public String imy;
  public byte[] imz;
  private final b rr;
  
  public a()
  {
    this(v.aAC(), bu.o((Integer)g.ajR().ajA().get(66561, null)), 0);
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
    this.imx = null;
    this.imy = null;
    this.imz = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bhk();
    ((b.a)localObject).hQG = new bhl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).funcId = 168;
    ((b.a)localObject).hQH = 67;
    ((b.a)localObject).respCmdId = 1000000067;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bhk)this.rr.hQD.hQJ;
    ((bhk)localObject).GuF = z.Jw(paramString);
    ((bhk)localObject).Gan = paramInt1;
    ((bhk)localObject).OpCode = paramInt2;
    ae.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150871);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150872);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bhk)this.rr.hQD.hQJ;
      paramq = (bhl)this.rr.hQE.hQJ;
      paramArrayOfByte = z.a(paramArrayOfByte.GuF);
      this.imz = z.a(paramq.GVE, new byte[0]);
      this.imx = paramq.GVF;
      ae.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.imx, paramq.GVG, paramq.GVH });
      if (v.aAC().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramq.GVG;
        String str = (String)g.ajR().ajA().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          g.ajR().ajA().set(66563, paramArrayOfByte);
          this.imy = paramq.GVH;
        }
        g.ajR().ajA().set(66561, Integer.valueOf(paramq.Gan));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */