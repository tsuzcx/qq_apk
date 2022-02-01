package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private final String id;
  public byte[] oSv;
  private final d rr;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21948);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bir();
    ((d.a)localObject).iLO = new bis();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).funcId = 596;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bir)this.rr.iLK.iLR;
    ((bir)localObject).ID = paramString;
    ((bir)localObject).LSJ = ac.gtT().ver;
    this.id = paramString;
    Log.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((bir)localObject).ID, Integer.valueOf(((bir)localObject).LSJ) });
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
      this.oSv = ((bis)this.rr.iLL.iLR).KLU.getBuffer().zy;
      params = this.id;
      if (this.oSv == null) {}
      for (paramInt1 = 0;; paramInt1 = this.oSv.length)
      {
        Log.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { params, Integer.valueOf(paramInt1) });
        if (this.oSv == null) {
          break label197;
        }
        paramArrayOfByte = this.oSv;
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