package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends p
  implements m
{
  private h callback;
  private final String id;
  private final c rr;
  public byte[] vfJ;
  
  public e(String paramString)
  {
    AppMethodBeat.i(21948);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cer();
    ((c.a)localObject).otF = new ces();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getbakchatkey";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    ((c.a)localObject).funcId = 596;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cer)c.b.b(this.rr.otB);
    ((cer)localObject).vgy = paramString;
    ((cer)localObject).aaoG = ac.iQe().ver;
    this.id = paramString;
    Log.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", new Object[] { ((cer)localObject).vgy, Integer.valueOf(((cer)localObject).aaoG) });
    AppMethodBeat.o(21948);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21949);
    super.cancel();
    AppMethodBeat.o(21949);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(21950);
    this.callback = paramh;
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
      this.vfJ = ((ces)c.c.b(this.rr.otC)).YKf.aaxD.Op;
      params = this.id;
      if (this.vfJ == null) {}
      for (paramInt1 = 0;; paramInt1 = this.vfJ.length)
      {
        Log.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", new Object[] { params, Integer.valueOf(paramInt1) });
        if (this.vfJ == null) {
          break label197;
        }
        paramArrayOfByte = this.vfJ;
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