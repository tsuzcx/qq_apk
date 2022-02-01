package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.asu;

public final class e
  extends n
  implements k
{
  private g callback;
  private final String id;
  public byte[] nbG;
  private final com.tencent.mm.ak.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21948);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ast();
    ((b.a)localObject).hvu = new asu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).funcId = 596;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ast)this.rr.hvr.hvw;
    ((ast)localObject).ID = paramString;
    ((ast)localObject).EMc = com.tencent.mm.protocal.ac.eRv().ver;
    this.id = paramString;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((ast)localObject).ID, Integer.valueOf(((ast)localObject).EMc) });
    AppMethodBeat.o(21948);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21949);
    super.cancel();
    AppMethodBeat.o(21949);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(21950);
    this.callback = paramg;
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.nbG = ((asu)this.rr.hvs.hvw).DUt.getBuffer().xy;
      paramq = this.id;
      if (this.nbG == null) {}
      for (paramInt1 = 0;; paramInt1 = this.nbG.length)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { paramq, Integer.valueOf(paramInt1) });
        if (this.nbG == null) {
          break label197;
        }
        paramArrayOfByte = this.nbG;
        paramq = "";
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.length)
        {
          paramq = paramq + Integer.toHexString(paramArrayOfByte[paramInt1] & 0xFF) + " ";
          paramInt1 += 1;
        }
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[] { paramq });
    }
    label197:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.e
 * JD-Core Version:    0.7.0.1
 */