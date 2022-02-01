package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  private f callback;
  private final String id;
  public byte[] nHy;
  private final com.tencent.mm.ak.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21948);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axh();
    ((b.a)localObject).hQG = new axi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).funcId = 596;
    this.rr = ((b.a)localObject).aDS();
    localObject = (axh)this.rr.hQD.hQJ;
    ((axh)localObject).ID = paramString;
    ((axh)localObject).GOF = ac.fkp().ver;
    this.id = paramString;
    ae.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((axh)localObject).ID, Integer.valueOf(((axh)localObject).GOF) });
    AppMethodBeat.o(21948);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21949);
    super.cancel();
    AppMethodBeat.o(21949);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(21950);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21950);
    return i;
  }
  
  public final int getType()
  {
    return 596;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21951);
    ae.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.nHy = ((axi)this.rr.hQE.hQJ).FSl.getBuffer().zr;
      paramq = this.id;
      if (this.nHy == null) {}
      for (paramInt1 = 0;; paramInt1 = this.nHy.length)
      {
        ae.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { paramq, Integer.valueOf(paramInt1) });
        if (this.nHy == null) {
          break label197;
        }
        paramArrayOfByte = this.nHy;
        paramq = "";
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.length)
        {
          paramq = paramq + Integer.toHexString(paramArrayOfByte[paramInt1] & 0xFF) + " ";
          paramInt1 += 1;
        }
      }
      ae.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[] { paramq });
    }
    label197:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.e
 * JD-Core Version:    0.7.0.1
 */