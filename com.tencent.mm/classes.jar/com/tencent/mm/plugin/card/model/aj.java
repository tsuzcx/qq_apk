package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.sdk.platformtools.ae;

public final class aj
  extends n
  implements k
{
  private f callback;
  public boolean hkx;
  public com.tencent.mm.bw.b oGT;
  public String oGs;
  private final com.tencent.mm.ak.b rr;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axb();
    ((b.a)localObject).hQG = new axc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((b.a)localObject).funcId = 1059;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (axb)this.rr.hQD.hQJ;
    ((axb)localObject).app_id = paramString1;
    ((axb)localObject).oOV = paramInt1;
    ((axb)localObject).oOW = paramString2;
    ((axb)localObject).oOX = paramString3;
    ((axb)localObject).time_stamp = paramInt2;
    ((axb)localObject).oOY = paramString4;
    ((axb)localObject).oEo = paramString5;
    ((axb)localObject).oOZ = paramString6;
    ((axb)localObject).oGT = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((axb)localObject).GOy = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((axb)localObject).GOy = 0;
    AppMethodBeat.o(112864);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112865);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112865);
    return i;
  }
  
  public final int getType()
  {
    return 1059;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112866);
    ae.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (axc)this.rr.hQE.hQJ;
      this.oGs = paramq.oGs;
      this.oGT = paramq.oGT;
      if (paramq.GOz == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.hkx = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */