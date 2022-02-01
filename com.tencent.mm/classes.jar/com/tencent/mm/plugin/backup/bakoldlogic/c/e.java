package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private final String id;
  public byte[] rUu;
  private final d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21948);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bqa();
    ((d.a)localObject).lBV = new bqb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).funcId = 596;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bqa)d.b.b(this.rr.lBR);
    ((bqa)localObject).ID = paramString;
    ((bqa)localObject).Tbu = ac.hpj().ver;
    this.id = paramString;
    Log.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((bqa)localObject).ID, Integer.valueOf(((bqa)localObject).Tbu) });
    AppMethodBeat.o(21948);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21949);
    super.cancel();
    AppMethodBeat.o(21949);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(21950);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(21950);
    return i;
  }
  
  public final int getType()
  {
    return 596;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21951);
    Log.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.rUu = ((bqb)d.c.b(this.rr.lBS)).RMR.Tkb.UH;
      params = this.id;
      if (this.rUu == null) {}
      for (paramInt1 = 0;; paramInt1 = this.rUu.length)
      {
        Log.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { params, Integer.valueOf(paramInt1) });
        if (this.rUu == null) {
          break label197;
        }
        paramArrayOfByte = this.rUu;
        params = "";
        paramInt1 = 0;
        while (paramInt1 < paramArrayOfByte.length)
        {
          params = params + Integer.toHexString(paramArrayOfByte[paramInt1] & 0xFF) + " ";
          paramInt1 += 1;
        }
      }
      Log.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", new Object[] { params });
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