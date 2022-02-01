package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public String hQq;
  public String hQr;
  public byte[] hQs;
  private final b rr;
  
  public a()
  {
    this(u.axw(), bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(66561, null)), 0);
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
    this.hQq = null;
    this.hQr = null;
    this.hQs = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bcq();
    ((b.a)localObject).hvu = new bcr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).funcId = 168;
    ((b.a)localObject).reqCmdId = 67;
    ((b.a)localObject).respCmdId = 1000000067;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bcq)this.rr.hvr.hvw;
    ((bcq)localObject).EuE = z.FI(paramString);
    ((bcq)localObject).ESL = paramInt1;
    ((bcq)localObject).OpCode = paramInt2;
    ac.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150871);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bcq)this.rr.hvr.hvw;
      paramq = (bcr)this.rr.hvs.hvw;
      paramArrayOfByte = z.a(paramArrayOfByte.EuE);
      this.hQs = z.a(paramq.ESM, new byte[0]);
      this.hQq = paramq.ESN;
      ac.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.hQq, paramq.ESO, paramq.ESP });
      if (u.axw().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramq.ESO;
        String str = (String)com.tencent.mm.kernel.g.agR().agA().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          com.tencent.mm.kernel.g.agR().agA().set(66563, paramArrayOfByte);
          this.hQr = paramq.ESP;
        }
        com.tencent.mm.kernel.g.agR().agA().set(66561, Integer.valueOf(paramq.ESL));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */