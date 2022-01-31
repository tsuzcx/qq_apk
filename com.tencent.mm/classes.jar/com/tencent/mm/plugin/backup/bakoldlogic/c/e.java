package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends m
  implements k
{
  private f callback;
  private final String id;
  public byte[] jIn;
  private final com.tencent.mm.ai.b rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(17891);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new agi();
    ((b.a)localObject).fsY = new agj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    ((b.a)localObject).funcId = 596;
    this.rr = ((b.a)localObject).ado();
    localObject = (agi)this.rr.fsV.fta;
    ((agi)localObject).ID = paramString;
    ((agi)localObject).wZl = aa.dqG().ver;
    this.id = paramString;
    ab.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((agi)localObject).ID, Integer.valueOf(((agi)localObject).wZl) });
    AppMethodBeat.o(17891);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17892);
    super.cancel();
    AppMethodBeat.o(17892);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(17893);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(17893);
    return i;
  }
  
  public final int getType()
  {
    return 596;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17894);
    ab.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.jIn = ((agj)this.rr.fsW.fta).wsu.getBuffer().pW;
      paramq = this.id;
      if (this.jIn == null) {}
      for (paramInt1 = 0;; paramInt1 = this.jIn.length)
      {
        ab.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { paramq, Integer.valueOf(paramInt1) });
        if (this.jIn == null) {
          break label197;
        }
        paramArrayOfByte = this.jIn;
        paramq = "";
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.length)
        {
          paramq = paramq + Integer.toHexString(paramArrayOfByte[paramInt1] & 0xFF) + " ";
          paramInt1 += 1;
        }
      }
      ab.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[] { paramq });
    }
    label197:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(17894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.e
 * JD-Core Version:    0.7.0.1
 */