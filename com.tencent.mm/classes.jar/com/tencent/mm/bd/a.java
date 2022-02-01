package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class a
  extends n
  implements k
{
  private f callback;
  public String ijE;
  public String ijF;
  public byte[] ijG;
  private final b rr;
  
  public a()
  {
    this(u.aAm(), bt.n((Integer)g.ajC().ajl().get(66561, null)), 0);
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
    this.ijE = null;
    this.ijF = null;
    this.ijG = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bgu();
    ((b.a)localObject).hNN = new bgv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).funcId = 168;
    ((b.a)localObject).hNO = 67;
    ((b.a)localObject).respCmdId = 1000000067;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bgu)this.rr.hNK.hNQ;
    ((bgu)localObject).GbY = z.IX(paramString);
    ((bgu)localObject).FHR = paramInt1;
    ((bgu)localObject).OpCode = paramInt2;
    ad.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    ad.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bgu)this.rr.hNK.hNQ;
      paramq = (bgv)this.rr.hNL.hNQ;
      paramArrayOfByte = z.a(paramArrayOfByte.GbY);
      this.ijG = z.a(paramq.GCe, new byte[0]);
      this.ijE = paramq.GCf;
      ad.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.ijE, paramq.GCg, paramq.GCh });
      if (u.aAm().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramq.GCg;
        String str = (String)g.ajC().ajl().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          g.ajC().ajl().set(66563, paramArrayOfByte);
          this.ijF = paramq.GCh;
        }
        g.ajC().ajl().set(66561, Integer.valueOf(paramq.FHR));
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